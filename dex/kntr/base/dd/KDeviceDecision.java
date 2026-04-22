package kntr.base.dd;

import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: KDeviceDecision.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkntr/base/dd/KDeviceDecision;", "", "<init>", "()V", "dd", "Lkntr/base/dd/IDeviceDecision;", "getDd", "()Lkntr/base/dd/IDeviceDecision;", "updater", "Lkntr/base/dd/IDeviceDecisionUpdater;", "getUpdater", "()Lkntr/base/dd/IDeviceDecisionUpdater;", "property", "Lkntr/base/dd/IDeviceDecisionProperty;", "getProperty", "()Lkntr/base/dd/IDeviceDecisionProperty;", "utils", "Lkntr/base/dd/IDeviceDecisionUtils;", "getUtils", "()Lkntr/base/dd/IDeviceDecisionUtils;", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KDeviceDecision {
    public static final KDeviceDecision INSTANCE = new KDeviceDecision();
    private static final IDeviceDecision dd;
    private static final IDeviceDecisionProperty property;
    private static final IDeviceDecisionUpdater updater;
    private static final IDeviceDecisionUtils utils;

    private KDeviceDecision() {
    }

    static {
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(IDeviceDecision.class), (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer);
        dd = (IDeviceDecision) suspendProducer.get();
        SuspendProducer suspendProducer2 = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(IDeviceDecisionUpdater.class), (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer2);
        updater = (IDeviceDecisionUpdater) suspendProducer2.get();
        SuspendProducer suspendProducer3 = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(IDeviceDecisionProperty.class), (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer3);
        property = (IDeviceDecisionProperty) suspendProducer3.get();
        SuspendProducer suspendProducer4 = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(IDeviceDecisionUtils.class), (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer4);
        utils = (IDeviceDecisionUtils) suspendProducer4.get();
    }

    public final IDeviceDecision getDd() {
        return dd;
    }

    public final IDeviceDecisionUpdater getUpdater() {
        return updater;
    }

    public final IDeviceDecisionProperty getProperty() {
        return property;
    }

    public final IDeviceDecisionUtils getUtils() {
        return utils;
    }
}