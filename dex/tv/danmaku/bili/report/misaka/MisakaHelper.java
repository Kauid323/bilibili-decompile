package tv.danmaku.bili.report.misaka;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.bilibili.base.Applications;
import com.bilibili.base.SharedPreferencesHelper;
import com.bilibili.base.connectivity.Connectivity;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.commons.ArrayUtils;
import com.bilibili.commons.StringUtils;
import com.bilibili.droid.SystemProperties;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.biliid.utils.device.HwIdHelper;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.utils.ExBilowUtil;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.CRC32;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.report.biz.api.consume.filter.HostFilters;
import tv.danmaku.bili.report.biz.api.produce.model.RequestEvent;
import tv.danmaku.bili.report.misaka.api.MisakaRule;
import tv.danmaku.bili.report.misaka.api.MisakaService;
import tv.danmaku.bili.report.misaka.model.MediaEvent;

public class MisakaHelper {
    public static final int MAX_REPORT_SIZE = 1024;
    private static final String PREF_MISAKA_RULES_FEED = "pref_misaka_rules_feed";
    private static final String PREF_MISAKA_RULE_FETCH_TIME = "pref_misaka_rules_fetch_time";
    private static final String PREF_NAME = "pref_misaka_rules";
    private static final String SK = "QklMSUZFNzFDQjBCOEVGQTQzNDI5NzQ3RDEyNUZENUE5MUZDTUlTQUtB";
    private static final String SPLIT = " misaka ";
    private static final String VERSION = "2";
    private static MisakaHelper instance;
    private AtomicBoolean mNewFeedRetrived;
    List<MisakaRule> mRuleList;
    private final long FETCH_INTERVAL = 111600000;
    private ReadWriteLock mLock = null;
    private String plainSk = "";
    SharedPreferencesHelper prefHelper = null;
    private long mLastFetchTime = 0;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum ReportType {
        ERROR_NO_NEED,
        ERROR_HTTP,
        ERROR_PARSE,
        ERROR_SERVER
    }

    public static MisakaHelper getInstance() {
        if (instance == null) {
            synchronized (MisakaHelper.class) {
                if (instance == null) {
                    instance = new MisakaHelper();
                }
            }
        }
        return instance;
    }

    private MisakaHelper() {
        init();
        initRules();
    }

    void init() {
        this.prefHelper = new SharedPreferencesHelper(Applications.getCurrent(), PREF_NAME);
        this.mRuleList = new ArrayList();
        this.mLock = new ReentrantReadWriteLock();
        this.mNewFeedRetrived = new AtomicBoolean(false);
    }

    void initRules() {
        this.mRuleList.addAll(MisakaRule.getDefaultRuleList());
        loadFeedCache();
    }

    private void loadFeedCache() {
        Task.callInBackground(new Callable<Void>() { // from class: tv.danmaku.bili.report.misaka.MisakaHelper.1
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                String feedCache = MisakaHelper.this.prefHelper.optString(MisakaHelper.PREF_MISAKA_RULES_FEED, "");
                if (TextUtils.isEmpty(feedCache)) {
                    return null;
                }
                List<MisakaRule> cached = (List) JSON.parseObject(feedCache, new ParameterizedTypeImpl((Type[]) ArrayUtils.toArray(new Type[]{MisakaRule.class}), (Type) null, ArrayList.class), new Feature[0]);
                List<MisakaRule> cached2 = MisakaRule.checkListValid(cached);
                if (!MisakaHelper.this.mNewFeedRetrived.get()) {
                    MisakaHelper.this.updateHelperRules(cached2);
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHelperRules(List<MisakaRule> update) {
        this.mLock.writeLock().lock();
        this.mRuleList.clear();
        if (update != null) {
            this.mRuleList.addAll(update);
        }
        this.mLock.writeLock().unlock();
    }

    public void fetchRules() {
        if (!ConnectivityMonitor.getInstance().isNetworkActive()) {
            return;
        }
        this.mLastFetchTime = this.prefHelper.optLong(PREF_MISAKA_RULE_FETCH_TIME, 0L);
        long interval = BuildConfig.DEBUG ? 5000L : 111600000L;
        if (System.currentTimeMillis() - this.mLastFetchTime < interval) {
            if (BuildConfig.DEBUG) {
                BLog.d("fetch dynamic rules too frequently! ");
                return;
            }
            return;
        }
        try {
            List<MisakaRule> data = (List) ExBilowUtil.extractResponseData(((MisakaService) ServiceGenerator.createService(MisakaService.class)).fetchMisakaRules().execute());
            List<MisakaRule> feed = MisakaRule.checkListValid(data);
            this.mNewFeedRetrived.set(true);
            updateHelperRules(feed);
            String feedStr = JSON.toJSONString(feed != null ? feed : new ArrayList<>());
            this.prefHelper.setString(PREF_MISAKA_RULES_FEED, feedStr);
            this.prefHelper.setLong(PREF_MISAKA_RULE_FETCH_TIME, System.currentTimeMillis());
        } catch (Exception t) {
            if (BuildConfig.DEBUG) {
                BLog.e("misaka fetch rule fail : " + t.getMessage());
            }
        }
    }

    public void report(final RequestEvent event, final ReportType type) {
        HandlerThreads.getHandler(1).post(new Runnable() { // from class: tv.danmaku.bili.report.misaka.MisakaHelper.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (type != ReportType.ERROR_HTTP && type != ReportType.ERROR_PARSE) {
                        if (type == ReportType.ERROR_SERVER) {
                            if (!MisakaHelper.this.matchDynamicRules(event)) {
                                return;
                            }
                            MisakaHelper.this.postReport(event);
                        }
                        return;
                    }
                    if (!MisakaHelper.this.isHostMatched(event.host)) {
                        return;
                    }
                    MisakaHelper.this.postReport(event);
                } finally {
                    event.recycle();
                }
            }
        });
    }

    public void reportPlayUrl(final JSONObject info, final String playUrl) {
        HandlerThreads.getHandler(1).post(new Runnable() { // from class: tv.danmaku.bili.report.misaka.MisakaHelper.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    info.put("f_url", playUrl);
                    MediaEvent mediaEvent = MediaEvent.obtain(info);
                    RequestEvent event = MediaEvent.transformToRequestEvent(mediaEvent, MediaEvent.FormatType.TYPE_PARSE);
                    MisakaHelper.this.postReport(event);
                } catch (Exception e) {
                }
            }
        });
    }

    public void reportPlayResult(String... args) {
        final MediaEvent mediaEvent = MediaEvent.obtain(args);
        HandlerThreads.getHandler(1).post(new Runnable() { // from class: tv.danmaku.bili.report.misaka.MisakaHelper.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    RequestEvent event = MediaEvent.transformToRequestEvent(mediaEvent, MediaEvent.FormatType.TYPE_PLAY);
                    MisakaHelper.this.postReport(event);
                } catch (Exception e) {
                }
            }
        });
    }

    public void reportDanmakuLoadError(int httpCode, String bulletUrl) {
        if (!TextUtils.isEmpty(bulletUrl)) {
            final RequestEvent requestEvent = RequestEvent.obtain(bulletUrl);
            requestEvent.httpcode = httpCode;
            HandlerThreads.getHandler(1).post(new Runnable() { // from class: tv.danmaku.bili.report.misaka.MisakaHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    MisakaHelper.this.postReport(requestEvent);
                }
            });
        }
    }

    public void reportDanmakuParseError(int errorType, String errorMsg, String url) {
        if (!TextUtils.isEmpty(url)) {
            final RequestEvent requestEvent = RequestEvent.obtain(url);
            requestEvent.respmsg = "danmaku parse error : errorType = " + errorType + " msg = " + errorMsg;
            requestEvent.parsestate = errorType;
            HandlerThreads.getHandler(1).post(new Runnable() { // from class: tv.danmaku.bili.report.misaka.MisakaHelper.6
                @Override // java.lang.Runnable
                public void run() {
                    MisakaHelper.this.postReport(requestEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postReport(RequestEvent event) {
        if (event == null || event.host == null || event.api == null || !allowReportBySwitcher()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        long crashTime = System.currentTimeMillis();
        String did = getDeviceId();
        String ver = String.valueOf(Foundation.instance().getApps().getVersionCode());
        String vid = generateVid(did, ver, crashTime);
        String body = generateBodyParams(did, ver, crashTime, event, stringBuilder);
        try {
            ((MisakaService) ServiceGenerator.createService(MisakaService.class)).reportBadRequest(vid, body).execute();
        } catch (Exception e) {
        }
    }

    private String generateBodyParams(String did, String ver, long crashTime, RequestEvent event, StringBuilder exceptionMsg) {
        String[] params = new String[17];
        params[0] = "2";
        params[1] = String.valueOf(event.errorCode);
        params[2] = String.valueOf(event.httpcode);
        params[3] = String.valueOf(event.timeused);
        params[4] = String.valueOf(crashTime);
        params[5] = parseNetWorkType();
        AccountInfo myInfo = BiliAccountInfo.get().getAccountInfoFromCache();
        if (myInfo != null) {
            params[6] = String.valueOf(myInfo.getMid());
        } else {
            params[6] = String.valueOf(0);
        }
        params[7] = did;
        params[8] = ver;
        params[9] = "Android";
        params[10] = getHexDNSAddress(exceptionMsg);
        params[11] = getHexIPAddress(event.host, exceptionMsg);
        params[12] = generateErrorMsg(event, exceptionMsg);
        try {
            params[13] = Uri.encode(removeCommonParam(event.url));
        } catch (Exception e) {
            params[13] = "encode event url " + e.getMessage();
        }
        params[14] = String.valueOf(event.parsestate);
        params[15] = String.valueOf(event.respcode);
        String device = Build.BRAND + "|" + Build.MODEL;
        try {
            params[16] = Uri.encode(device.length() > 1 ? device : String.valueOf(0));
        } catch (Exception e2) {
            params[16] = String.valueOf(0);
        }
        return StringUtils.join(params, "||");
    }

    private String parseNetWorkType() {
        int type = ConnectivityMonitor.getInstance().getNetwork();
        switch (type) {
            case 1:
                return "WIFI";
            case 2:
                String result = "MOBILE:" + Connectivity.getMobileNetworkInfo(Applications.getCurrent()).getExtraInfo();
                return result;
            case 3:
                return "NO_CONNECTION";
            case 4:
                return "OTHER";
            case 5:
                return "ETHERNET";
            default:
                return "UNKNOWN";
        }
    }

    private String generateVid(String did, String ver, long crashTime) {
        if (TextUtils.isEmpty(this.plainSk)) {
            this.plainSk = getSignKey();
        }
        StringBuilder vidBuilder = new StringBuilder((int) BR.cover).append("2").append(did).append(ver).append(crashTime).append(this.plainSk);
        byte[] checkData = vidBuilder.toString().getBytes();
        CRC32 crc32 = new CRC32();
        crc32.update(checkData);
        return String.valueOf(crc32.getValue());
    }

    private String getSignKey() {
        try {
            byte[] input = SK.getBytes();
            byte[] enCode = Base64.decode(input, 0);
            String key = new String(enCode, Charset.forName("UTF-8"));
            return StringUtils.substring(key, String.valueOf("BILI").length(), key.length() - String.valueOf("MISAKA").length());
        } catch (Exception e) {
            return "";
        }
    }

    private String generateErrorMsg(RequestEvent event, StringBuilder exceptionMsg) {
        String result;
        int limited = OnlineParamsHelper.getMisakaReportLimite();
        try {
            if (!TextUtils.isEmpty(event.respmsg)) {
                String excpetionKeyInfo = getJsonExceptionKeyInfo(event.respmsg);
                if (!TextUtils.isEmpty(excpetionKeyInfo)) {
                    if (exceptionMsg.length() != 0) {
                        exceptionMsg.insert(0, SPLIT);
                        String result2 = Uri.encode(StringUtils.substring(excpetionKeyInfo, 0, limited - exceptionMsg.length()) + exceptionMsg.toString());
                        return result2;
                    }
                    String result3 = Uri.encode(StringUtils.substring(excpetionKeyInfo, 0, limited));
                    return result3;
                }
                if (exceptionMsg.length() > 0) {
                    exceptionMsg.insert(0, SPLIT);
                    result = Uri.encode(StringUtils.substring(event.respmsg, 0, limited - exceptionMsg.length()) + exceptionMsg.toString());
                } else {
                    result = Uri.encode(StringUtils.substring(event.respmsg, 0, limited));
                }
                return result;
            } else if (!TextUtils.isEmpty(exceptionMsg.toString())) {
                exceptionMsg.insert(0, SPLIT);
                if (event.respdata != null && event.respdata.length > limited - exceptionMsg.length()) {
                    String result4 = Uri.encode(new String(event.respdata, 0, limited - exceptionMsg.length(), Charset.forName("UTF-8")) + exceptionMsg.toString());
                    return result4;
                }
                String result5 = Uri.encode(new String(event.respdata, Charset.forName("UTF-8") + exceptionMsg.toString()));
                return result5;
            } else if (event.respdata == null) {
                return "";
            } else {
                if (event.respdata.length > limited - exceptionMsg.length()) {
                    String result6 = Uri.encode(new String(event.respdata, 0, limited - exceptionMsg.length(), Charset.forName("UTF-8")));
                    return result6;
                } else if (event.respdata.length > 0) {
                    String result7 = Uri.encode(new String(event.respdata, Charset.forName("UTF-8") + exceptionMsg.toString()));
                    return result7;
                } else {
                    return "response data is empty";
                }
            }
        } catch (Exception e) {
            String result8 = "deal with respmsg " + e.getMessage();
            return result8;
        }
    }

    private String removeCommonParam(String url) {
        try {
            int index = StringUtils.indexOf(url, "?");
            if (index > 0) {
                return StringUtils.substring(url, 0, index);
            }
            return url;
        } catch (Exception e) {
            return url;
        }
    }

    private String getJsonExceptionKeyInfo(String jsonString) {
        int posStart;
        int posEnd;
        try {
            if (!jsonString.startsWith("com.alibaba.fastjson.JSONException") || (posStart = jsonString.indexOf("pos ") + 4) <= 3 || (posEnd = jsonString.indexOf(" json") - 1) == -2 || posStart >= posEnd) {
                return "";
            }
            String posNum = jsonString.substring(posStart, posEnd);
            int pos = Integer.parseInt(posNum);
            if (pos <= 1) {
                return "";
            }
            int contentPos = posEnd + 9;
            String exceptionHead = jsonString.substring(0, contentPos);
            return exceptionHead + StringUtils.substring(jsonString, (pos + contentPos) - 150, pos + contentPos + BR.danmukuTvText);
        } catch (Exception e) {
            return "";
        }
    }

    private String parseAddressToHex(String address) throws Exception {
        if (TextUtils.isEmpty(address) || address.indexOf(58) != -1) {
            return "0";
        }
        int result = 0;
        String[] str = address.split("\\.");
        for (String addre : str) {
            int j = Integer.parseInt(addre);
            result = (result << 8) | (j & BR.hallCover);
        }
        return Integer.toHexString(result);
    }

    private String getDNSAddress() throws Exception {
        String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
        for (int i = 0; i < 4; i++) {
            String name = strArr[i];
            String value = SystemProperties.get(name);
            if (!TextUtils.isEmpty(value)) {
                return value;
            }
        }
        return "";
    }

    private String getIpAddress(String host) throws Exception {
        InetAddress[] address = InetAddress.getAllByName(host);
        for (InetAddress adre : address) {
            if (!TextUtils.isEmpty(adre.getHostAddress())) {
                return adre.getHostAddress();
            }
        }
        return "";
    }

    private String getHexDNSAddress(StringBuilder exceptionMsg) {
        String ip = "";
        try {
            ip = getDNSAddress();
        } catch (Exception e) {
            if (exceptionMsg != null) {
                exceptionMsg.append(" dns ");
                exceptionMsg.append(e.getMessage());
            }
        }
        String hex = String.valueOf(0);
        try {
            return parseAddressToHex(ip);
        } catch (Exception e2) {
            if (exceptionMsg != null) {
                exceptionMsg.append(" parse dns ");
                exceptionMsg.append(e2.getMessage());
                return hex;
            }
            return hex;
        }
    }

    private String getHexIPAddress(String host, StringBuilder exceptionMsg) {
        String ip = "";
        try {
            ip = getIpAddress(host);
        } catch (Exception e) {
            if (exceptionMsg != null) {
                exceptionMsg.append(" ip ");
                exceptionMsg.append(e.getMessage());
            }
        }
        String hex = String.valueOf(0);
        try {
            return parseAddressToHex(ip);
        } catch (Exception e2) {
            if (exceptionMsg != null) {
                exceptionMsg.append(" parse ip ");
                exceptionMsg.append(e2.getMessage());
                return hex;
            }
            return hex;
        }
    }

    private String getDeviceId() {
        return HwIdHelper.getDid(Applications.getCurrent());
    }

    boolean isHostMatched(String host) {
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        boolean result = false;
        this.mLock.readLock().lock();
        Iterator<MisakaRule> it = this.mRuleList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MisakaRule rule = it.next();
            if (rule.isHostMatched(host)) {
                result = true;
                break;
            }
        }
        this.mLock.readLock().unlock();
        return result;
    }

    public ReportType isNeedReport(RequestEvent event) {
        if (HostFilters.isReportSelf(event)) {
            return ReportType.ERROR_NO_NEED;
        }
        if (!ConnectivityMonitor.getInstance().isNetworkActive()) {
            return ReportType.ERROR_NO_NEED;
        }
        if (event.httpcode != 200 && event.httpcode != 304 && event.httpcode != 302) {
            return ReportType.ERROR_HTTP;
        }
        if (event.httpcode == 200 && event.parsestate != 1) {
            return ReportType.ERROR_PARSE;
        }
        if (event.httpcode == 200 && event.respcode != 0) {
            return ReportType.ERROR_SERVER;
        }
        return ReportType.ERROR_NO_NEED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean matchDynamicRules(RequestEvent event) {
        return checkRuleMatch(event);
    }

    boolean checkRuleMatch(RequestEvent event) {
        if (event == null || TextUtils.isEmpty(event.host)) {
            return false;
        }
        boolean result = false;
        this.mLock.readLock().lock();
        Iterator<MisakaRule> it = this.mRuleList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MisakaRule rule = it.next();
            if (rule.isRuleMatched(event.host, event.respcode)) {
                result = true;
                break;
            }
        }
        this.mLock.readLock().unlock();
        return result;
    }

    private boolean allowReportBySwitcher() {
        return OnlineParamsHelper.isMisakaReportEnable();
    }
}