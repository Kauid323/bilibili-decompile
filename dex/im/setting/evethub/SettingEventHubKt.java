package im.setting.evethub;

import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSettingRedirect;
import im.setting.model.SettingItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingEventHub.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002¨\u0006\u0004"}, d2 = {"update", "Lim/setting/model/SettingItem$Setting;", "changeDisplaySummary", "", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SettingEventHubKt {
    public static final /* synthetic */ SettingItem.Setting access$update(SettingItem.Setting $receiver, String changeDisplaySummary) {
        return update($receiver, changeDisplaySummary);
    }

    public static final SettingItem.Setting update(SettingItem.Setting $this$update, String changeDisplaySummary) {
        KSetting.IContent content;
        String str;
        KSetting setting = $this$update.getSetting();
        if ($this$update.getSetting().getContent() instanceof KSetting.KRedirect) {
            KSetting.KRedirect content2 = $this$update.getSetting().getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KRedirect");
            KSetting.KRedirect kRedirect = content2;
            KSetting.KRedirect content3 = $this$update.getSetting().getContent();
            Intrinsics.checkNotNull(content3, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KRedirect");
            KSettingRedirect value = content3.getValue();
            if (changeDisplaySummary != null) {
                str = changeDisplaySummary;
            } else {
                KSetting.KRedirect content4 = $this$update.getSetting().getContent();
                Intrinsics.checkNotNull(content4, "null cannot be cast to non-null type com.bapis.bilibili.app.im.v1.KSetting.KRedirect");
                str = content4.getValue().getTitle();
            }
            content = (KSetting.IContent) kRedirect.copy(KSettingRedirect.copy$default(value, (KSettingRedirect.IContent) null, (String) null, (String) null, str, 7, (Object) null));
        } else {
            content = $this$update.getSetting().getContent();
        }
        return SettingItem.Setting.copy$default($this$update, null, setting.copy(content), false, false, 13, null);
    }
}