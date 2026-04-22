package tv.danmaku.bili.report.biz.api.produce;

import android.net.Uri;
import com.bilibili.lib.okhttp.track.tag.RpcTag;
import com.bilibili.lib.okhttp.track.utils.TagUtilsKt;
import com.bilibili.lib.rpc.report.BizReporter;
import com.bilibili.lib.rpc.track.model.BizEvent;
import com.bilibili.lib.rpc.track.model.Header;
import com.bilibili.lib.rpc.track.model.RpcExtra;
import com.bilibili.lib.rpc.track.model.RpcSample;
import com.bilibili.lib.rpc.track.model.Tunnel;
import com.bilibili.lib.rpc.track.util.HttpUtilsKt;
import com.bilibili.okretro.tracker.ApiTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.RequestBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: BilowBizTrackers.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J@\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\u001c\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010!\u001a\u00020\fH\u0016J$\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010&\u001a\u00020\fH\u0016J\u0012\u0010'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Ltv/danmaku/bili/report/biz/api/produce/BilowBizTracker;", "Lcom/bilibili/okretro/tracker/ApiTracker;", "consumer", "Lcom/bilibili/lib/rpc/report/BizReporter;", "<init>", "(Lcom/bilibili/lib/rpc/report/BizReporter;)V", "getConsumer", "()Lcom/bilibili/lib/rpc/report/BizReporter;", "builder", "Lcom/bilibili/lib/rpc/track/model/BizEvent$Builder;", "kotlin.jvm.PlatformType", "beginConnect", "", "method", "", "url", "requestBodySize", "", "endConnect", "timeCostMill", "httpCode", "", "xcache", "traceId", "idc", "connectError", "", "updateUrl", "beginReadBody", "endReadBody", "data", "", "readError", "beginParse", "endParse", "apiCode", "apiMsg", "parseError", "finish", "setCall", "call", "Lokhttp3/Call;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BilowBizTracker implements ApiTracker {
    private final BizEvent.Builder builder;
    private final BizReporter consumer;

    public /* synthetic */ void beginConnect(String str, String str2) {
        ApiTracker.-CC.$default$beginConnect(this, str, str2);
    }

    public /* synthetic */ void beginConnect(String str, String str2, RequestBody requestBody, long j) {
        ApiTracker.-CC.$default$beginConnect(this, str, str2, requestBody, j);
    }

    public /* synthetic */ void endConnect(long j, int i, String str, Throwable th) {
        ApiTracker.-CC.$default$endConnect(this, j, i, str, th);
    }

    public /* synthetic */ void endConnect(long j, int i, Throwable th) {
        ApiTracker.-CC.$default$endConnect(this, j, i, th);
    }

    public BilowBizTracker(BizReporter consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.consumer = consumer;
        this.builder = BizEvent.newBuilder();
    }

    public final BizReporter getConsumer() {
        return this.consumer;
    }

    public void beginConnect(String method, String url, long requestBodySize) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        BizEvent.Builder $this$beginConnect_u24lambda_u240 = this.builder;
        $this$beginConnect_u24lambda_u240.setUrl(url);
        Uri parsed = Uri.parse(url);
        $this$beginConnect_u24lambda_u240.setScheme(parsed.getScheme());
        $this$beginConnect_u24lambda_u240.setHost(parsed.getHost());
        $this$beginConnect_u24lambda_u240.setPath(parsed.getPath());
    }

    public void endConnect(long timeCostMill, int httpCode, String xcache, String traceId, String idc, Throwable connectError) {
        Header.Builder $this$endConnect_u24lambda_u240 = Header.newBuilder();
        $this$endConnect_u24lambda_u240.setXcache(xcache == null ? "" : xcache);
        $this$endConnect_u24lambda_u240.setTraceId(traceId == null ? "" : traceId);
        $this$endConnect_u24lambda_u240.setIdc(idc != null ? idc : "");
        Header header = $this$endConnect_u24lambda_u240.build();
        this.builder.setHeader(header);
    }

    public void updateUrl(String url) {
    }

    public void beginReadBody() {
    }

    public void endReadBody(byte[] data, Throwable readError) {
    }

    public void beginParse() {
    }

    public void endParse(int apiCode, String apiMsg, Throwable parseError) {
        if (parseError != null) {
            this.builder.setBizExceptionName(parseError.getClass().getName());
            this.builder.setBizExceptionMessage(HttpUtilsKt.errorMsg("parse error=", parseError));
            BizEvent event = this.builder.build();
            BizReporter bizReporter = this.consumer;
            Intrinsics.checkNotNull(event);
            bizReporter.report(event);
        } else if (apiCode != 0) {
            this.builder.setBizCode(apiCode);
            this.builder.setBizMessage(apiMsg == null ? "" : apiMsg);
            BizEvent event2 = this.builder.build();
            BizReporter bizReporter2 = this.consumer;
            Intrinsics.checkNotNull(event2);
            bizReporter2.report(event2);
        }
    }

    public void finish() {
    }

    public void setCall(Call call) {
        Request request;
        RpcTag rpcTag = TagUtilsKt.getRpcTag((call == null || (request = call.request()) == null) ? null : request.tag());
        RpcExtra extra = rpcTag != null ? rpcTag.getExtra() : null;
        if (extra == null) {
            BLog.e("okhttp.bilow.biz.tracker", "Miss RpcExtra in bilow biz tracker, new one.");
            extra = new RpcExtra(Tunnel.OKHTTP, (String) null, false, false, (RpcSample) null, (String) null, (String) null, (String) null, (String) null, (int) BR.roleName, (DefaultConstructorMarker) null);
        }
        this.builder.setTunnel(extra.getTunnel());
        this.builder.setLocalRpcTraceId(extra.getTraceId());
    }
}