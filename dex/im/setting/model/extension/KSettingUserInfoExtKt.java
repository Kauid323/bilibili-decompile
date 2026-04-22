package im.setting.model.extension;

import com.bapis.bilibili.app.im.v1.KSettingUserInfo;
import im.base.model.VipNameColorHolder;
import im.base.model.VipNameColorHolder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KSettingUserInfoExt.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"vipColor", "Lim/base/model/VipNameColorHolder;", "Lcom/bapis/bilibili/app/im/v1/KSettingUserInfo;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KSettingUserInfoExtKt {
    public static final VipNameColorHolder vipColor(KSettingUserInfo $this$vipColor) {
        Intrinsics.checkNotNullParameter($this$vipColor, "<this>");
        return VipNameColorHolder_androidKt.parseVipNameColor($this$vipColor.getVipInfo());
    }
}