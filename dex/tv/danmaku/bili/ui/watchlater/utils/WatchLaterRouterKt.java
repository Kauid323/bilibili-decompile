package tv.danmaku.bili.ui.watchlater.utils;

import android.content.Context;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterRouter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¨\u0006\b"}, d2 = {"routerTo", "", "url", "", "context", "Landroid/content/Context;", "withExtra", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterRouterKt {
    public static /* synthetic */ void routerTo$default(String str, Context context, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        routerTo(str, context, map);
    }

    public static final void routerTo(String url, Context context, final Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "withExtra");
        String str = url;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        RouteRequest request = new RouteRequest.Builder(url).extras(new Function1() { // from class: tv.danmaku.bili.ui.watchlater.utils.WatchLaterRouterKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit routerTo$lambda$0;
                routerTo$lambda$0 = WatchLaterRouterKt.routerTo$lambda$0(map, (MutableBundleLike) obj);
                return routerTo$lambda$0;
            }
        }).build();
        BLRouter.routeTo(request, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit routerTo$lambda$0(Map $withExtra, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.putAll($withExtra);
        return Unit.INSTANCE;
    }
}