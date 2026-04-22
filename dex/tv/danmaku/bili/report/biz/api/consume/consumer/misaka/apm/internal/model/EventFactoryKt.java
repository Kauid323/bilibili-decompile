package tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.internal.model;

import android.net.Uri;
import android.util.Base64;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.RequestEvent;

/* compiled from: EventFactory.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00020\u0004H\u0007\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0004H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0004H\u0002\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0004H\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\u0004H\u0002\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u0004H\u0002\u001a\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0004H\u0002\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0004H\u0002\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"TAG", "", "asExtension", "", "Ltv/danmaku/bili/report/biz/api/produce/model/RequestEvent;", "isError", "", "httpError", "buildUrl", "encodeReqArgs", "encodeRespBody", "SUCCESS", "ERROR", "TYPE_ANDROID_OKHTTP", "TYPE_IOS_BFCAPIREQUEST", "DOMAIN_DEFAULT", "DOMAIN_HTTP_ERROR", "DOMAIN_SERIALIZATION_ERROR", "DOMAIN_FIELD_ERROR", "ERRNO_NA", "errorCode", "", "getDomain", "getCode", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EventFactoryKt {
    private static final String DOMAIN_DEFAULT = "00000000";
    private static final String DOMAIN_FIELD_ERROR = "00000011";
    private static final String DOMAIN_HTTP_ERROR = "00000001";
    private static final String DOMAIN_SERIALIZATION_ERROR = "00000010";
    private static final String ERRNO_NA = "0000000000000000";
    private static final String ERROR = "01";
    private static final String SUCCESS = "00";
    private static final String TAG = "misaka.apm.api";
    private static final String TYPE_ANDROID_OKHTTP = "000001";
    private static final String TYPE_IOS_BFCAPIREQUEST = "001000";

    @Deprecated(message = "using EventListener based model")
    public static final Map<String, String> asExtension(RequestEvent $this$asExtension) {
        Intrinsics.checkNotNullParameter($this$asExtension, "<this>");
        HashMap $this$asExtension_u24lambda_u240 = new HashMap();
        boolean error = isError($this$asExtension);
        $this$asExtension_u24lambda_u240.put("request_uri", buildUrl($this$asExtension));
        String str = $this$asExtension.traceId;
        if (str == null) {
            str = "";
        }
        $this$asExtension_u24lambda_u240.put("traceid", str);
        String str2 = $this$asExtension.idc;
        if (str2 == null) {
            str2 = "";
        }
        $this$asExtension_u24lambda_u240.put("idc", str2);
        $this$asExtension_u24lambda_u240.put("start_request_ts", String.valueOf($this$asExtension.requestTime / 1000));
        $this$asExtension_u24lambda_u240.put("request_package_size", String.valueOf($this$asExtension.reqBodySize));
        $this$asExtension_u24lambda_u240.put("response_package_size", String.valueOf($this$asExtension.respBodySize));
        $this$asExtension_u24lambda_u240.put("http_code", String.valueOf($this$asExtension.httpcode));
        $this$asExtension_u24lambda_u240.put("consumer_time", String.valueOf($this$asExtension.timeused));
        $this$asExtension_u24lambda_u240.put("response_code", String.valueOf($this$asExtension.respcode));
        $this$asExtension_u24lambda_u240.put("request_args", error ? encodeReqArgs($this$asExtension) : "");
        $this$asExtension_u24lambda_u240.put("response_body", error ? encodeRespBody($this$asExtension) : "");
        $this$asExtension_u24lambda_u240.put("biz_errcode", String.valueOf(errorCode($this$asExtension)));
        String str3 = $this$asExtension.hostIp;
        if (str3 == null) {
            str3 = "";
        }
        $this$asExtension_u24lambda_u240.put("cdn_addr", str3);
        Throwable it = $this$asExtension.exception;
        if (it != null) {
            $this$asExtension_u24lambda_u240.put("exception_name", it.getClass().getName());
            String message = it.getMessage();
            $this$asExtension_u24lambda_u240.put("exception_message", message != null ? message : "");
        }
        return $this$asExtension_u24lambda_u240;
    }

    private static final boolean isError(RequestEvent $this$isError) {
        return httpError($this$isError) || $this$isError.parsestate != 1;
    }

    private static final boolean httpError(RequestEvent $this$httpError) {
        int i = $this$httpError.httpcode;
        boolean z = false;
        if (200 <= i && i < 400) {
            z = true;
        }
        return !z;
    }

    private static final String buildUrl(RequestEvent $this$buildUrl) {
        Uri.Builder $this$buildUrl_u24lambda_u240 = new Uri.Builder();
        $this$buildUrl_u24lambda_u240.scheme($this$buildUrl.scheme);
        $this$buildUrl_u24lambda_u240.authority($this$buildUrl.host);
        $this$buildUrl_u24lambda_u240.path($this$buildUrl.api);
        String uri = $this$buildUrl_u24lambda_u240.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }

    private static final String encodeReqArgs(RequestEvent $this$encodeReqArgs) {
        String str = $this$encodeReqArgs.url;
        if (str == null) {
            str = "";
        }
        Uri uri = Uri.parse(str);
        String encodedQuery = uri.getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private static final String encodeRespBody(RequestEvent $this$encodeRespBody) {
        if ($this$encodeRespBody.responseBody != null) {
            String encodeToString = Base64.encodeToString($this$encodeRespBody.responseBody, 0);
            Intrinsics.checkNotNull(encodeToString);
            return encodeToString;
        }
        return "";
    }

    private static final int errorCode(RequestEvent $this$errorCode) {
        StringBuilder builder = new StringBuilder();
        builder.append(isError($this$errorCode) ? "01" : "00");
        builder.append(TYPE_ANDROID_OKHTTP);
        builder.append(getDomain($this$errorCode));
        builder.append(getCode($this$errorCode));
        String code = builder.toString();
        Intrinsics.checkNotNullExpressionValue(code, "toString(...)");
        BLog.vfmt(TAG, "Final error code = %s.", code);
        Integer intOrNull = StringsKt.toIntOrNull(code, 2);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 0;
    }

    private static final String getDomain(RequestEvent $this$getDomain) {
        if (httpError($this$getDomain)) {
            return DOMAIN_HTTP_ERROR;
        }
        if ($this$getDomain.parsestate == 3) {
            return DOMAIN_SERIALIZATION_ERROR;
        }
        if ($this$getDomain.parsestate == 4) {
            return DOMAIN_FIELD_ERROR;
        }
        return DOMAIN_DEFAULT;
    }

    private static final String getCode(RequestEvent $this$getCode) {
        return ERRNO_NA;
    }
}