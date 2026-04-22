package tv.danmaku.bili.update.internal.binder;

import android.app.Dialog;
import android.widget.CheckBox;
import com.bilibili.app.updater.R;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.binder.DialogViewBinder;
import tv.danmaku.bili.update.internal.exception.ViewNotFoundException;
import tv.danmaku.bili.update.internal.persist.prefs.PrefsHelperKt;

/* JADX INFO: Access modifiers changed from: package-private */
public class StartupUpdateDialogDecorator extends DialogViewBinder.Decorator<BinderParams.ManualUpdate> {
    public StartupUpdateDialogDecorator(DialogViewBinder<BinderParams.ManualUpdate> dialogViewBinder) {
        super(new DownloadUpdateDialogDecorator(dialogViewBinder));
    }

    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder.Decorator, tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpOtherView(Dialog dialog) {
        PrefsHelperKt.setUpdatePerformed(getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder.Decorator
    public void setBusinessEvent(Dialog dialog) throws ViewNotFoundException {
        if (this.dialogViewBinder != null && (this.dialogViewBinder instanceof DialogViewBinder.Decorator)) {
            ((DialogViewBinder.Decorator) this.dialogViewBinder).setBusinessEvent(dialog);
        }
    }

    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder.Decorator, tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpIgnoreView(Dialog dialog) throws ViewNotFoundException {
        if (dialog != null && !getUpgradeInfo().forceUpgrade()) {
            CheckBox cbxIgnoreVersion = (CheckBox) requireViewById(dialog, R.id.update_cbx_ignore_version, "update_cbx_ignore_version");
            cbxIgnoreVersion.setVisibility(0);
            return;
        }
        super.setUpIgnoreView(dialog);
    }
}