package kntr.base.device;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* compiled from: KDevice.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"platformDevice", "Lkntr/base/device/IDevice;", "getPlatformDevice", "()Lkntr/base/device/IDevice;", "device_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KDeviceKt {
    private static final IDevice platformDevice;

    static {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        platformDevice = ((DeviceEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(DeviceEntryPoint.class))).getDevice();
    }

    public static final IDevice getPlatformDevice() {
        return platformDevice;
    }
}