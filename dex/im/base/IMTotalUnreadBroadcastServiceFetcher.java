package im.base;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* compiled from: IMTotalUnreadBroadcastService.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lim/base/IMTotalUnreadBroadcastServiceFetcher;", "", "<init>", "()V", "service", "Lim/base/IMTotalUnreadBroadcastService;", "getService$annotations", "getService", "()Lim/base/IMTotalUnreadBroadcastService;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMTotalUnreadBroadcastServiceFetcher {
    public static final IMTotalUnreadBroadcastServiceFetcher INSTANCE = new IMTotalUnreadBroadcastServiceFetcher();

    public static /* synthetic */ void getService$annotations() {
    }

    private IMTotalUnreadBroadcastServiceFetcher() {
    }

    public final IMTotalUnreadBroadcastService getService() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((IMTotalUnreadBroadcastPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(IMTotalUnreadBroadcastPoint.class))).getService();
    }
}