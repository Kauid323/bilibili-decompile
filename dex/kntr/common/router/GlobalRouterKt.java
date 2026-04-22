package kntr.common.router;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.router.Router;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* compiled from: GlobalRouter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"GlobalRouter", "Lkntr/base/router/Router;", "getGlobalRouter", "()Lkntr/base/router/Router;", "GlobalRouter$delegate", "Lkotlin/Lazy;", "router_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GlobalRouterKt {
    private static final Lazy GlobalRouter$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.router.GlobalRouterKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            Router GlobalRouter_delegate$lambda$0;
            GlobalRouter_delegate$lambda$0 = GlobalRouterKt.GlobalRouter_delegate$lambda$0();
            return GlobalRouter_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Router GlobalRouter_delegate$lambda$0() {
        return ((GlobalRouterEntryPoint) Component_jvmKt.entryPoint(Gripper_component_holder_androidKt.getRootGripperComponent(), Reflection.getOrCreateKotlinClass(GlobalRouterEntryPoint.class))).getGlobalRouter();
    }

    public static final Router getGlobalRouter() {
        return (Router) GlobalRouter$delegate.getValue();
    }
}