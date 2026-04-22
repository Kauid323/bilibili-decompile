package tv.danmaku.bili.okhttp;

import com.bilibili.nativelibrary.LibBili;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: CustomParamsAndHeaderInterceptor.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/okhttp/CustomParamsAndHeaderInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "params", "", "", "url", "Lokhttp3/HttpUrl;", "addParams", "addHeaders", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class CustomParamsAndHeaderInterceptor implements Interceptor {
    public static final int $stable = 0;

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            Map addParams = addParams();
            Map addHeaders = addHeaders();
            Request req = chain.request();
            Request.Builder newReqBuilder = req.newBuilder();
            HttpUrl url = req.url();
            Intrinsics.checkNotNull(url);
            try {
                Map params = params(url);
                HttpUrl newUrl = url.newBuilder().encodedQuery(LibBili.signQuery(MapsKt.plus(params, addParams)).toString()).build();
                newReqBuilder.url(newUrl);
                for (Map.Entry element$iv : addHeaders.entrySet()) {
                    newReqBuilder.header(element$iv.getKey(), element$iv.getValue());
                    addParams = addParams;
                }
                Response proceed = chain.proceed(newReqBuilder.build());
                Intrinsics.checkNotNullExpressionValue(proceed, "proceed(...)");
                return proceed;
            } catch (Throwable th) {
                t = th;
                BLog.e("CustomParamsAndHeaderInterceptor intercept exception " + t);
                if (t instanceof IOException) {
                    throw t;
                }
                throw new IOException(t);
            }
        } catch (Throwable th2) {
            t = th2;
        }
    }

    public final Map<String, String> params(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        int n = url.querySize();
        Map map = new LinkedHashMap();
        for (int i = 0; i < n; i++) {
            try {
                map.put(url.queryParameterName(i), url.queryParameterValue(i));
            } catch (Throwable t) {
                BLog.e("CustomParamsAndHeaderInterceptor params exception " + t);
            }
        }
        return map;
    }

    public Map<String, String> addParams() {
        return MapsKt.emptyMap();
    }

    public Map<String, String> addHeaders() {
        return MapsKt.emptyMap();
    }
}