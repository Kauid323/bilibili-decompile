package im.setting.stateMachine;

import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSwitchConfirmDialog;
import im.setting.IMSettingDialog;
import im.setting.IMSettingDialogCancelAction;
import im.setting.IMSettingDialogConfirmAction;
import im.setting.model.SettingItem;
import im.setting.stateMachine.IMSettingItemChangeTask;
import kotlin.Metadata;

/* compiled from: SettingItemChangeStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"dialog", "Lim/setting/IMSettingDialog;", "Lim/setting/model/SettingItem$Setting;", "task", "Lim/setting/stateMachine/IMSettingItemChangeTask;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SettingItemChangeStateMachineKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingDialog dialog(SettingItem.Setting $this$dialog, IMSettingItemChangeTask task) {
        KSetting.KSwitch content = $this$dialog.getSetting().getContent();
        if (content instanceof KSetting.KSwitch) {
            IMSettingItemChangeTask.Switch switchAction = task instanceof IMSettingItemChangeTask.Switch ? (IMSettingItemChangeTask.Switch) task : null;
            if (switchAction != null) {
                KSwitchConfirmDialog onDialog = content.getValue().getOnDialog();
                KSwitchConfirmDialog offDialog = content.getValue().getOffDialog();
                if (switchAction.getOn() && onDialog != null) {
                    return new IMSettingDialog(onDialog.getTitle(), onDialog.getSubtitle(), $this$dialog.getType(), new IMSettingDialogConfirmAction($this$dialog, switchAction.getOn()), new IMSettingDialogCancelAction($this$dialog));
                } else if (!switchAction.getOn() && offDialog != null) {
                    return new IMSettingDialog(offDialog.getTitle(), offDialog.getSubtitle(), $this$dialog.getType(), new IMSettingDialogConfirmAction($this$dialog, switchAction.getOn()), new IMSettingDialogCancelAction($this$dialog));
                }
            }
            return null;
        }
        return null;
    }
}