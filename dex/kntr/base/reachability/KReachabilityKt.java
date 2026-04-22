package kntr.base.reachability;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.reachability.IReachability;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: KReachability.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"KReachability", "Lkntr/base/reachability/IReachability;", "getKReachability", "()Lkntr/base/reachability/IReachability;", "service", "Lkntr/base/reachability/ReachabilityService;", "getService", "()Lkntr/base/reachability/ReachabilityService;", "service$delegate", "Lkotlin/Lazy;", "reachability_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KReachabilityKt {
    private static final IReachability KReachability = new IReachability() { // from class: kntr.base.reachability.KReachabilityKt$KReachability$1
        @Override // kntr.base.reachability.IReachability
        public /* bridge */ boolean isReachable() {
            return IReachability.CC.$default$isReachable(this);
        }

        @Override // kntr.base.reachability.IReachability
        public /* bridge */ boolean isReachableViaWWAN() {
            return IReachability.CC.$default$isReachableViaWWAN(this);
        }

        @Override // kntr.base.reachability.IReachability
        public /* bridge */ boolean isReachableViaWiFi() {
            return IReachability.CC.$default$isReachableViaWiFi(this);
        }

        @Override // kntr.base.reachability.IReachability
        public Flow<NetWorkState> currentStateFlow() {
            return KReachabilityKt.getService().observe();
        }

        @Override // kntr.base.reachability.IReachability
        public NetWorkState getCurrentState() {
            return KReachabilityKt.getService().currentState();
        }
    };
    private static final Lazy service$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.reachability.KReachabilityKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            ReachabilityService service_delegate$lambda$0;
            service_delegate$lambda$0 = KReachabilityKt.service_delegate$lambda$0();
            return service_delegate$lambda$0;
        }
    });

    public static final IReachability getKReachability() {
        return KReachability;
    }

    public static final ReachabilityService getService() {
        return (ReachabilityService) service$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReachabilityService service_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((ReachabilityEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(ReachabilityEntryPoint.class))).getReachability();
    }
}