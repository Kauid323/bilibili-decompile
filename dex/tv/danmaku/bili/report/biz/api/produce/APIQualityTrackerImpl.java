package tv.danmaku.bili.report.biz.api.produce;

import android.text.TextUtils;
import android.util.Log;
import com.bilibili.app.comm.billow.biz.BuildConfig;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.commons.StringUtils;
import com.bilibili.lib.rpc.track.util.HttpUtilsKt;
import com.bilibili.okretro.tracker.ApiTracker;
import java.net.MalformedURLException;
import java.net.URL;
import okhttp3.Call;
import okhttp3.RequestBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.bilow.cdn.CallInfoManager;
import tv.danmaku.bili.report.biz.api.consume.APIQualityReporter;
import tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.MisakaApmApiKt;
import tv.danmaku.bili.report.biz.api.produce.model.RequestEvent2;

@Deprecated
public class APIQualityTrackerImpl implements ApiTracker {
    private Long misakaApmLogid;
    final String TAG = "CallInfoManager";
    private Call call = null;
    private RequestEvent2.Builder mInfoBuidler = new RequestEvent2.Builder();
    private boolean isFinish = false;

    public /* synthetic */ void beginConnect(String str, String str2, RequestBody requestBody, long j) {
        ApiTracker.-CC.$default$beginConnect(this, str, str2, requestBody, j);
    }

    public /* synthetic */ void endConnect(long j, int i, String str, Throwable th) {
        ApiTracker.-CC.$default$endConnect(this, j, i, str, th);
    }

    public /* synthetic */ void endConnect(long j, int i, Throwable th) {
        ApiTracker.-CC.$default$endConnect(this, j, i, th);
    }

    public void beginConnect(String method, String url) {
        throwIfFinish();
        this.mInfoBuidler.setUrl(url);
        this.mInfoBuidler.setRequestTime(System.currentTimeMillis());
    }

    public void beginConnect(String method, String url, long requestBodySize) {
        throwIfFinish();
        this.mInfoBuidler.setUrl(url);
        this.mInfoBuidler.setReqBodySize(requestBodySize);
        this.mInfoBuidler.setRequestTime(System.currentTimeMillis());
        checkMisakaReport();
    }

    private void checkMisakaReport() {
        URL url = null;
        try {
            url = new URL(this.mInfoBuidler.getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (url != null) {
            this.misakaApmLogid = MisakaApmApiKt.misakaHit(url.getHost(), url.getPath());
        }
    }

    public void endConnect(long timeCostMill, int httpCode, String xcache, String traceId, String idc, Throwable connectError) {
        throwIfFinish();
        this.mInfoBuidler.setTimeused(timeCostMill);
        this.mInfoBuidler.setHttpcode(httpCode);
        this.mInfoBuidler.setXcache(xcache);
        this.mInfoBuidler.setTraceId(traceId);
        this.mInfoBuidler.setIdc(idc);
        if (connectError != null) {
            this.mInfoBuidler.setHttpmsg(HttpUtilsKt.errorMsg("connect error = ", connectError));
            this.mInfoBuidler.setException(connectError);
        }
    }

    public void updateUrl(String url) {
        throwIfFinish();
        if (AppConfig.BILI_HOST_PATTERN.matcher(url).find()) {
            this.mInfoBuidler.setUrl(url);
        }
    }

    public void beginReadBody() {
        throwIfFinish();
    }

    public void endReadBody(byte[] data, Throwable readError) {
        throwIfFinish();
        this.mInfoBuidler.setResponseBody(data);
        this.mInfoBuidler.setRespBodySize(data != null ? data.length : 0L);
        if (readError != null) {
            this.mInfoBuidler.setParseState(2);
            this.mInfoBuidler.setRespmsg(HttpUtilsKt.errorMsg("read error = ", readError));
            this.mInfoBuidler.setException(readError);
        }
    }

    public void beginParse() {
        throwIfFinish();
    }

    public void endParse(int apiCode, String apiMsg, Throwable parseError) {
        throwIfFinish();
        this.mInfoBuidler.setRespcode(apiCode);
        String respMsg = null;
        if (!TextUtils.isEmpty(apiMsg)) {
            respMsg = StringUtils.abbreviate(apiMsg, (int) RingBuffer.CONSUME_SIZE);
        } else if (parseError != null) {
            this.mInfoBuidler.setParseState(3);
            respMsg = HttpUtilsKt.errorMsg("parse error = ", parseError);
            this.mInfoBuidler.setException(parseError);
        }
        this.mInfoBuidler.setRespmsg(respMsg);
    }

    private int getCallKey() {
        if (this.call != null) {
            return this.call.hashCode();
        }
        return -1;
    }

    public void finish() {
        throwIfFinish();
        this.isFinish = true;
        if (this.misakaApmLogid != null) {
            String ip = CallInfoManager.getInstance().pickupIp(getCallKey());
            this.mInfoBuidler.setHostIp(ip);
            if (BuildConfig.DEBUG) {
                Log.d("CallInfoManager", "onFinish cacheSize=" + CallInfoManager.getInstance().size() + ", " + getCallKey() + ", ip=" + ip + this.mInfoBuidler.getUrl());
            }
        }
        if (this.mInfoBuidler.getHttpmsg() != null && !ConnectivityMonitor.getInstance().isNetworkActive()) {
            BLog.w("Request " + this.mInfoBuidler.getUrl() + " but no network!");
        } else {
            APIQualityReporter.reportToAll(this.mInfoBuidler.build(), this.misakaApmLogid);
        }
    }

    public void setCall(Call call) {
        if (this.misakaApmLogid != null) {
            this.call = call;
            CallInfoManager.getInstance().needCache(call.hashCode());
        }
        if (BuildConfig.DEBUG) {
            BLog.d("CallInfoManager", "misakaHit + " + call.hashCode() + ": " + (this.misakaApmLogid != null ? "yes" : "no"));
        }
    }

    private void throwIfFinish() {
        if (this.isFinish) {
            throw new IllegalStateException("This track cycle had finished");
        }
    }
}