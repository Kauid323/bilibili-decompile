package tv.danmaku.bili.update.api.updater;

import android.app.Activity;
import android.app.Dialog;
import java.lang.ref.WeakReference;
import tv.danmaku.bili.update.api.UpdaterOptions;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.binder.DialogBinderFactory;
import tv.danmaku.bili.update.internal.binder.DialogViewBinder;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.bili.update.internal.report.NeuronReporterKt;
import tv.danmaku.bili.update.internal.report.UpdateReporter;
import tv.danmaku.bili.update.internal.report.UpdateReporterV2;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.utils.RuntimeHelper;

public class StartupUpdater implements IUpdater {
    private static final String TAG = "fawkes.update.manual";
    WeakReference<Activity> mActivityRef;

    public StartupUpdater(Activity activity) {
        this.mActivityRef = new WeakReference<>(activity);
    }

    @Override // tv.danmaku.bili.update.api.updater.IUpdater
    public void onUpdate(BiliUpgradeInfo info, boolean isManual) {
        if (info == null || this.mActivityRef.get() == null || this.mActivityRef.get().isFinishing()) {
            return;
        }
        showUpdateDialog(info, isManual);
    }

    public void showUpdateDialog(BiliUpgradeInfo info, boolean isManual) {
        if (info == null || this.mActivityRef.get() == null || this.mActivityRef.get().isFinishing()) {
            return;
        }
        UpdateReporter.reportUpdate("1");
        UpdateReporterV2.reportDialogShow("1", NeuronReporterKt.manualToValue(isManual));
        NeuronReporterKt.reportDialogShow("1", NeuronReporterKt.manualToValue(isManual), info.getMd5());
        NeuronReporterKt.reportUpdateDialog(info.versionCode(), false, ConstsKt.ARG_STATE_DIALOG_SHOW, NeuronReporterKt.manualToValue(isManual), info.getMd5());
        UpdaterOptions updaterOptions = RuntimeHelper.getUpdaterOptions();
        Dialog dialog = updaterOptions.getDialogFactory().create(this.mActivityRef.get(), 2);
        DialogViewBinder.Decorator dialogViewBinder = new DialogBinderFactory().create(new BinderParams.StartupUpdate(this.mActivityRef, info, isManual));
        dialogViewBinder.bindView(dialog);
        dialog.show();
    }

    @Override // tv.danmaku.bili.update.api.updater.IUpdater
    public void onError(String msg) {
    }
}