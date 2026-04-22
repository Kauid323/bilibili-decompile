package tv.danmaku.bili.utils;

import android.content.Context;
import android.net.Uri;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UriRoute.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"openRoute", "", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "onlyBili", "", "widgets_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UriRouteKt {
    public static final void openRoute(Uri uri, Context context) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        openRoute$default(uri, context, false, 2, null);
    }

    public static /* synthetic */ void openRoute$default(Uri uri, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        openRoute(uri, context, z);
    }

    public static final void openRoute(Uri $this$openRoute, Context context, boolean onlyBili) {
        Intrinsics.checkNotNullParameter($this$openRoute, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        BLRouter.routeTo(RouteRequestKt.toRouteRequest($this$openRoute), context);
    }
}