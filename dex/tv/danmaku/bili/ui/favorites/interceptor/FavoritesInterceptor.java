package tv.danmaku.bili.ui.favorites.interceptor;

import android.net.Uri;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.blrouter.RouteInterceptor;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.blrouter.RouteResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: FavoritesInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/favorites/interceptor/FavoritesInterceptor;", "Lcom/bilibili/lib/blrouter/RouteInterceptor;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lcom/bilibili/lib/blrouter/RouteResponse;", "chain", "Lcom/bilibili/lib/blrouter/RouteInterceptor$Chain;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesInterceptor implements RouteInterceptor {
    public static final int $stable = 0;

    public RouteResponse intercept(RouteInterceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RouteRequest originReq = chain.getRequest();
        Uri uri = originReq.getTargetUri();
        if (Intrinsics.areEqual(ListExtentionsKt.toStringMap(originReq.getExtras().toBundle()).get("version"), "2")) {
            Uri newUri = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath() + "2").query(uri.getQuery()).build();
            RouteRequest.Builder newBuilder = originReq.newBuilder();
            Intrinsics.checkNotNull(newUri);
            newBuilder.setTargetUri(newUri);
            return RouteRequestKt.redirectTo(originReq, newBuilder.build());
        }
        return chain.next(originReq);
    }
}