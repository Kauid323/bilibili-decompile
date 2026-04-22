package kntr.base.router.di;

import com.bilibili.lib.brouter.api.BRouter;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* compiled from: EntryPoint.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"KRouter", "Lcom/bilibili/lib/brouter/api/BRouter;", "getKRouter", "()Lcom/bilibili/lib/brouter/api/BRouter;", "KRouter$delegate", "Lkotlin/Lazy;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class EntryPointKt {
    private static final Lazy KRouter$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.router.di.EntryPointKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            BRouter KRouter_delegate$lambda$0;
            KRouter_delegate$lambda$0 = EntryPointKt.KRouter_delegate$lambda$0();
            return KRouter_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final BRouter KRouter_delegate$lambda$0() {
        return ((RouterEntryPoint) Component_jvmKt.entryPoint(Gripper_component_holder_androidKt.getRootGripperComponent(), Reflection.getOrCreateKotlinClass(RouterEntryPoint.class))).getRouter();
    }

    public static final BRouter getKRouter() {
        return (BRouter) KRouter$delegate.getValue();
    }
}