package tv.danmaku.bili.ui.watchlater;

import com.bilibili.lib.blrouter.RouteInterceptor;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterFragmentV4.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/WatchLaterInterceptor;", "Lcom/bilibili/lib/blrouter/RouteInterceptor;", "<init>", "()V", "watchLaterUseKntr", "", "intercept", "Lcom/bilibili/lib/blrouter/RouteResponse;", "chain", "Lcom/bilibili/lib/blrouter/RouteInterceptor$Chain;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterInterceptor implements RouteInterceptor {
    public static final int $stable = 0;
    private final boolean watchLaterUseKntr = Intrinsics.areEqual(DeviceDecision.INSTANCE.dd("watch_later_use_kntr", "1"), "1");

    public RouteResponse intercept(RouteInterceptor.Chain chain) {
        RouteResponse next;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RouteRequest originReq = chain.getRequest();
        try {
            if (this.watchLaterUseKntr) {
                next = RouteRequestKt.redirectTo(originReq, RouteRequestKt.toRouteRequest("bilibili://user_center/watch_later_kntr"));
            } else {
                next = chain.next(originReq);
            }
            return next;
        } catch (Exception e) {
            return chain.next(originReq);
        }
    }
}