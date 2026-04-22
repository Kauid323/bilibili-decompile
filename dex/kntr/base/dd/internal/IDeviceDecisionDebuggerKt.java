package kntr.base.dd.internal;

import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.KDeviceDecision;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: IDeviceDecisionDebugger.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"debugger", "Lkntr/base/dd/internal/IDeviceDecisionDebugger;", "Lkntr/base/dd/KDeviceDecision;", "getDebugger$annotations", "(Lkntr/base/dd/KDeviceDecision;)V", "getDebugger", "(Lkntr/base/dd/KDeviceDecision;)Lkntr/base/dd/internal/IDeviceDecisionDebugger;", "api_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IDeviceDecisionDebuggerKt {
    public static /* synthetic */ void getDebugger$annotations(KDeviceDecision kDeviceDecision) {
    }

    public static final IDeviceDecisionDebugger getDebugger(KDeviceDecision $this$debugger) {
        Intrinsics.checkNotNullParameter($this$debugger, "<this>");
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(IDeviceDecisionDebugger.class), (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer);
        return (IDeviceDecisionDebugger) suspendProducer.get();
    }
}