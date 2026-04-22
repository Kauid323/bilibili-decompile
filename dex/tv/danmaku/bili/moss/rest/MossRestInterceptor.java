package tv.danmaku.bili.moss.rest;

import android.text.TextUtils;
import com.bilibili.api.BiliConfig;
import com.bilibili.api.DisplayID;
import com.bilibili.api.PhoneDeviceId;
import com.bilibili.nativelibrary.LibBili;
import com.bilibili.nativelibrary.SignedQuery;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.bilow.UserAgents;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: MossRestInterceptor.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\f\u001a\u00020\t2\u0016\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J2\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0016\u0010\u001b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\"\u0010\u001c\u001a\u00020\u001d2\u0018\u0010\r\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002¨\u0006 "}, d2 = {"Ltv/danmaku/bili/moss/rest/MossRestInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "addHeader", "", "builder", "Lokhttp3/Request$Builder;", "addCommonParam", "params", "", "", "getAppKey", "addCommonParamToBody", "oUrl", "Lokhttp3/HttpUrl;", "body", "Lokhttp3/RequestBody;", "requestBuilder", "addCommonParamToUrl", "put", ChannelRoutes.CHANNEL_NAME, "value", "toMap", "signQuery", "Lcom/bilibili/nativelibrary/SignedQuery;", "", "ua", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MossRestInterceptor implements Interceptor {
    public static final int $stable = 0;

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request origin = chain.request();
        Request.Builder builder = origin.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "newBuilder(...)");
        try {
            addHeader(builder);
            if (Intrinsics.areEqual("GET", origin.method())) {
                HttpUrl url = origin.url();
                Intrinsics.checkNotNullExpressionValue(url, "url(...)");
                addCommonParamToUrl(url, builder);
            } else if (origin.body() != null) {
                HttpUrl url2 = origin.url();
                Intrinsics.checkNotNullExpressionValue(url2, "url(...)");
                RequestBody body = origin.body();
                Intrinsics.checkNotNull(body);
                addCommonParamToBody(url2, body, builder);
            }
        } catch (Exception e) {
            BLog.e("moss.rest.interceptor", e);
        }
        Response proceed = chain.proceed(builder.build());
        Intrinsics.checkNotNullExpressionValue(proceed, "proceed(...)");
        return proceed;
    }

    private final void addHeader(Request.Builder builder) {
        String displayId = DisplayID.get();
        if (!TextUtils.isEmpty(displayId)) {
            builder.header("Display-ID", displayId);
        }
        String buvid = BiliConfig.getBuvid();
        if (!TextUtils.isEmpty(buvid)) {
            builder.header("Buvid", buvid);
        }
        String userAgent = ua();
        if (!TextUtils.isEmpty(userAgent)) {
            builder.header("User-Agent", userAgent);
        }
        String deviceId = PhoneDeviceId.get();
        if (!TextUtils.isEmpty(deviceId)) {
            builder.header("Device-ID", deviceId);
        }
        String fpLocal = BiliConfig.getFpLocal();
        Intrinsics.checkNotNullExpressionValue(fpLocal, "getFpLocal(...)");
        if (!TextUtils.isEmpty(fpLocal)) {
            builder.header("fp_local", fpLocal);
        }
        String fpRemote = BiliConfig.getFpRemote();
        Intrinsics.checkNotNullExpressionValue(fpRemote, "getFpRemote(...)");
        if (!TextUtils.isEmpty(fpRemote)) {
            builder.header("fp_remote", fpRemote);
        }
        String sessionId = BiliConfig.getSessionId();
        Intrinsics.checkNotNullExpressionValue(sessionId, "getSessionId(...)");
        if (!TextUtils.isEmpty(sessionId)) {
            builder.header("session_id", sessionId);
        }
        builder.header("bili-rest-engine", "moss");
    }

    private final void addCommonParam(Map<String, String> map) {
        map.put("platform", "android");
        map.put("mobi_app", BiliConfig.getMobiApp());
        map.put("appkey", getAppKey());
        map.put("build", String.valueOf(BiliConfig.getBiliVersionCode()));
        map.put("channel", BiliConfig.getChannel());
        String accessKey = BiliConfig.getAccessKey();
        if (!TextUtils.isEmpty(accessKey)) {
            map.put("access_key", accessKey);
        }
        Map customParams = BiliConfig.getCustomParams();
        if (customParams != null) {
            map.putAll(customParams);
        }
        map.put("c_locale", BiliConfig.getCurrentLocale());
        map.put("s_locale", BiliConfig.getSystemLocale());
    }

    private final String getAppKey() {
        return BiliConfig.getAppKey();
    }

    private final void addCommonParamToBody(HttpUrl oUrl, RequestBody body, Request.Builder requestBuilder) {
        if (body instanceof MultipartBody) {
            return;
        }
        try {
            if (!(body instanceof FormBody)) {
                if (body.contentLength() > 0) {
                    return;
                }
            }
            Map params = new LinkedHashMap();
            if (body instanceof FormBody) {
                int formSize = ((FormBody) body).size();
                for (int i = 0; i < formSize; i++) {
                    String name = ((FormBody) body).name(i);
                    Intrinsics.checkNotNullExpressionValue(name, "name(...)");
                    put(name, ((FormBody) body).value(i), params);
                }
            }
            int querySize = oUrl.querySize();
            for (int i2 = 0; i2 < querySize; i2++) {
                String name2 = oUrl.queryParameterName(i2);
                String value = oUrl.queryParameterValue(i2);
                Intrinsics.checkNotNull(name2);
                put(name2, value, params);
            }
            addCommonParam(params);
            SignedQuery query = signQuery(params);
            MediaType type = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody signedBody = RequestBody.create(type, query.toString());
            HttpUrl pureUrl = oUrl.newBuilder().query((String) null).build();
            requestBuilder.url(pureUrl).post(signedBody);
        } catch (IOException e) {
        }
    }

    private final void addCommonParamToUrl(HttpUrl oUrl, Request.Builder requestBuilder) {
        Map params = new LinkedHashMap();
        int querySize = oUrl.querySize();
        for (int i = 0; i < querySize; i++) {
            String name = oUrl.queryParameterName(i);
            String value = oUrl.queryParameterValue(i);
            Intrinsics.checkNotNull(name);
            put(name, value, params);
        }
        addCommonParam(params);
        SignedQuery query = signQuery(params);
        HttpUrl newUrl = oUrl.newBuilder().encodedQuery(query.toString()).build();
        requestBuilder.url(newUrl);
    }

    private final void put(String name, String value, Map<String, String> map) {
        if (map.containsKey(name)) {
            String old = map.get(name);
            if (value != null) {
                map.put(name, old + "," + value);
                return;
            }
            return;
        }
        map.put(name, value);
    }

    private final SignedQuery signQuery(Map<String, String> map) {
        SignedQuery signQuery = LibBili.signQuery(map);
        Intrinsics.checkNotNullExpressionValue(signQuery, "signQuery(...)");
        return signQuery;
    }

    private final String ua() {
        String defaultFullUa = UserAgents.defaultFullUa();
        Intrinsics.checkNotNullExpressionValue(defaultFullUa, "defaultFullUa(...)");
        return defaultFullUa;
    }
}