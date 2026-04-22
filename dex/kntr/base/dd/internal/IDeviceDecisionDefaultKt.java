package kntr.base.dd.internal;

import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.KDeviceDecision;
import kntr.base.dd.internal.IDeviceDecisionDefault;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: IDeviceDecisionDefault.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"defaultDD", "Lkntr/base/dd/internal/IDeviceDecisionDefault;", "Lkntr/base/dd/KDeviceDecision;", "getDefaultDD$annotations", "(Lkntr/base/dd/KDeviceDecision;)V", "getDefaultDD", "(Lkntr/base/dd/KDeviceDecision;)Lkntr/base/dd/internal/IDeviceDecisionDefault;", "isDDAppDisabled", "", "getBool", "key", "Lkntr/base/dd/internal/IDeviceDecisionDefault$Key;", "api_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IDeviceDecisionDefaultKt {
    public static /* synthetic */ void getDefaultDD$annotations(KDeviceDecision kDeviceDecision) {
    }

    public static final IDeviceDecisionDefault getDefaultDD(KDeviceDecision $this$defaultDD) {
        Intrinsics.checkNotNullParameter($this$defaultDD, "<this>");
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(IDeviceDecisionDefault.class), (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer);
        return (IDeviceDecisionDefault) suspendProducer.get();
    }

    public static final boolean isDDAppDisabled(IDeviceDecisionDefault $this$isDDAppDisabled) {
        Intrinsics.checkNotNullParameter($this$isDDAppDisabled, "<this>");
        return getBool($this$isDDAppDisabled, IDeviceDecisionDefault.Key.KDDAppDisabled);
    }

    public static final boolean getBool(IDeviceDecisionDefault $this$getBool, IDeviceDecisionDefault.Key key) {
        Intrinsics.checkNotNullParameter($this$getBool, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String it = $this$getBool.get(key);
        if (it != null) {
            return Intrinsics.areEqual(it, "true") || Intrinsics.areEqual(it, "__true__");
        }
        return false;
    }
}