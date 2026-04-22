package tv.danmaku.bili.ui.freedata.ui;

import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteInterceptor;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: UnicomRouteActiveFragment.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/freedata/ui/UnicomActivateInterceptor;", "Lcom/bilibili/lib/blrouter/RouteInterceptor;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lcom/bilibili/lib/blrouter/RouteResponse;", "chain", "Lcom/bilibili/lib/blrouter/RouteInterceptor$Chain;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UnicomActivateInterceptor implements RouteInterceptor {
    public static final int $stable = 0;

    public RouteResponse intercept(RouteInterceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RouteRequest request = chain.getRequest();
        final Ref.ObjectRef activeType = new Ref.ObjectRef();
        activeType.element = "51";
        RouteRequest.Builder newRequest = request.newBuilder();
        newRequest.extras(new Function1() { // from class: tv.danmaku.bili.ui.freedata.ui.UnicomActivateInterceptor$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit intercept$lambda$0;
                intercept$lambda$0 = UnicomActivateInterceptor.intercept$lambda$0(activeType, (MutableBundleLike) obj);
                return intercept$lambda$0;
            }
        });
        newRequest.requestCode(1001).build();
        return chain.next(newRequest.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit intercept$lambda$0(Ref.ObjectRef $activeType, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("activate_type", (String) $activeType.element);
        return Unit.INSTANCE;
    }
}