package tv.danmaku.bili.update.api.updater;

import android.app.Activity;
import android.app.Dialog;
import com.bilibili.app.updateapi.ButtonClickListener;
import com.bilibili.app.updateapi.applet.DialogOptions;
import java.lang.ref.WeakReference;
import tv.danmaku.bili.update.api.UpdaterOptions;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.binder.DialogBinderFactory;
import tv.danmaku.bili.update.internal.binder.DialogViewBinder;
import tv.danmaku.bili.update.internal.report.NeuronReporterKt;
import tv.danmaku.bili.update.internal.report.UpdateReporter;
import tv.danmaku.bili.update.internal.report.UpdateReporterV2;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.utils.RuntimeHelper;

public class AppletUpdater implements IUpdater {
    private static final String TAG = "fawkes.update.applet";
    private WeakReference<Activity> mActivityRef;
    private ButtonClickListener mButtonClickListener;
    private DialogOptions mDialogOptions;

    public AppletUpdater(Activity activity, DialogOptions dialogOptions, ButtonClickListener buttonClickListener) {
        this.mActivityRef = new WeakReference<>(activity);
        this.mDialogOptions = dialogOptions;
        this.mButtonClickListener = buttonClickListener;
    }

    @Override // tv.danmaku.bili.update.api.updater.IUpdater
    public void onUpdate(BiliUpgradeInfo info, boolean isManual) {
        if (info == null || this.mActivityRef.get() == null || this.mActivityRef.get().isFinishing()) {
            return;
        }
        showUpdateDialog(info, isManual);
    }

    private void showUpdateDialog(BiliUpgradeInfo info, boolean isManual) {
        if (info == null || this.mActivityRef == null || this.mActivityRef.get() == null || this.mActivityRef.get().isFinishing()) {
            return;
        }
        UpdateReporter.reportUpdate("1");
        UpdateReporterV2.reportDialogShow("1", "3");
        NeuronReporterKt.reportDialogShow("1", "3", info.getMd5());
        UpdaterOptions updaterOptions = RuntimeHelper.getUpdaterOptions();
        Dialog dialog = updaterOptions.getDialogFactory().create(this.mActivityRef.get(), 3);
        DialogViewBinder.Decorator dialogViewBinder = new DialogBinderFactory().create(new BinderParams.AppletUpdate(this.mActivityRef, info, this.mDialogOptions, this.mButtonClickListener));
        dialogViewBinder.bindView(dialog);
        dialog.show();
    }

    @Override // tv.danmaku.bili.update.api.updater.IUpdater
    public void onError(String msg) {
        if (this.mActivityRef.get() == null || this.mActivityRef.get().isFinishing()) {
            return;
        }
        RuntimeHelper.showToastShort(this.mActivityRef.get(), msg);
    }
}