package tv.danmaku.bili.bilow.gaia;

import com.bilibili.lib.rpc.gaia.Gaia;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: GaiaInterceptor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/bilow/gaia/GaiaInterceptor;", "Lokhttp3/Interceptor;", "gaia", "Lcom/bilibili/lib/rpc/gaia/Gaia;", "<init>", "(Lcom/bilibili/lib/rpc/gaia/Gaia;)V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GaiaInterceptor implements Interceptor {
    private final Gaia gaia;

    public GaiaInterceptor(Gaia gaia) {
        Intrinsics.checkNotNullParameter(gaia, "gaia");
        this.gaia = gaia;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String host = request.url().host();
        String path = request.url().encodedPath();
        Request.Builder newBuilder = request.newBuilder();
        Gaia gaia = this.gaia;
        Intrinsics.checkNotNull(host);
        Intrinsics.checkNotNull(path);
        Response proceed = chain.proceed(newBuilder.header("x-bili-gaia-vtoken", gaia.onGaiaReq(host, path)).build());
        Intrinsics.checkNotNullExpressionValue(proceed, "proceed(...)");
        return proceed;
    }
}