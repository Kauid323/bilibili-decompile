package kntr.common.restricted;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* compiled from: KRestrictedMode.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"KRestrictedMode", "Lkntr/common/restricted/IRestrictedMode;", "getKRestrictedMode", "()Lkntr/common/restricted/IRestrictedMode;", "restricted-mode_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KRestrictedModeKt {
    private static final IRestrictedMode KRestrictedMode;

    public static final IRestrictedMode getKRestrictedMode() {
        return KRestrictedMode;
    }

    static {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        KRestrictedMode = ((RestrictedModeEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(RestrictedModeEntryPoint.class))).getRestrictedModeManager();
    }
}