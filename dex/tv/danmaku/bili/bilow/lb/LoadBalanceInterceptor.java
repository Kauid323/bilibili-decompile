package tv.danmaku.bili.bilow.lb;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: LoadBalanceInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/bilow/lb/LoadBalanceInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoadBalanceInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request req = chain.request();
        HttpUrl url = req.url();
        String host = url.host();
        Lbs lbs = Lbs.INSTANCE;
        Intrinsics.checkNotNull(host);
        String newHost = lbs.maybeChangeHost(host);
        if (Intrinsics.areEqual(newHost, host)) {
            Response proceed = chain.proceed(req);
            Intrinsics.checkNotNull(proceed);
            return proceed;
        }
        BLog.i("http.lb", "Replace " + host + " with " + newHost + " for load balance");
        HttpUrl newUrl = url.newBuilder().host(newHost).build();
        Request newReq = req.newBuilder().url(newUrl).build();
        Response proceed2 = chain.proceed(newReq);
        Intrinsics.checkNotNull(proceed2);
        return proceed2;
    }
}