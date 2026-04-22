package kntr.app.game.base.bridge;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* compiled from: GameTeenagerModeBridge.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"gameTeenagerModeService", "Lkntr/app/game/base/bridge/IKntrGameTeenagerModeService;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameTeenagerModeBridgeKt {
    private static final IKntrGameTeenagerModeService gameTeenagerModeService;

    static {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        gameTeenagerModeService = (IKntrGameTeenagerModeService) ((KntrGameTeenagerModeEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(KntrGameTeenagerModeEntryPoint.class))).getKntrGameTeenagerModeService().orNull();
    }
}