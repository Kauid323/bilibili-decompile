package im.base.model;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* compiled from: VipNameColorHolder.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"parseVipNameColor", "Lim/base/model/VipNameColorHolder;", "vipColorInfo", "", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VipNameColorHolder_androidKt {
    public static final VipNameColorHolder parseVipNameColor(String vipColorInfo) {
        if (vipColorInfo == null) {
            return null;
        }
        try {
            Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
            return ((VipNameColorEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(VipNameColorEntryPoint.class))).vipNameColorParser().parseVipNameColor(vipColorInfo);
        } catch (Exception e2) {
            KLog_androidKt.getKLog().e("VipNameColor", "parse vip name color error", e2);
            return null;
        }
    }
}