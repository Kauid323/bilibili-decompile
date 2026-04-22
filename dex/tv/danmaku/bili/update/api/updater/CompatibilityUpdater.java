package tv.danmaku.bili.update.api.updater;

import android.app.Activity;
import java.lang.ref.WeakReference;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.internal.UpdaterKt;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.bili.update.internal.report.NeuronReporterKt;
import tv.danmaku.bili.update.internal.report.UpdateReporter;
import tv.danmaku.bili.update.internal.report.UpdateReporterV2;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.utils.RuntimeHelper;

public class CompatibilityUpdater implements IUpdater {
    private static final String TAG = "fawkes.update.compatibility";
    WeakReference<Activity> mActivityRef;

    public CompatibilityUpdater(Activity activity) {
        this.mActivityRef = new WeakReference<>(activity);
    }

    @Override // tv.danmaku.bili.update.api.updater.IUpdater
    public void onUpdate(BiliUpgradeInfo info, boolean isManual) {
        BLog.i(TAG, "onUpdate info = " + info);
        if (info == null || this.mActivityRef.get() == null || this.mActivityRef.get().isFinishing()) {
            return;
        }
        UpdateReporter.reportUpdate("1");
        UpdateReporterV2.reportDialogShow("1", "4");
        NeuronReporterKt.reportDialogShow("1", "4", info.getMd5());
        startUpdate(info);
    }

    private void startUpdate(BiliUpgradeInfo info) {
        BLog.i(TAG, "startUpdate info = " + info);
        Activity context = this.mActivityRef.get();
        if (context == null) {
            return;
        }
        UpdateReporter.reportUpdate("2");
        UpdateReporterV2.reportDialogClick("1", "4", "2");
        NeuronReporterKt.reportDialogClick("1", "4", "2", info.getMd5());
        NeuronReporterKt.reportUpdateDialog(info.versionCode(), false, ConstsKt.ARG_STATE_DIALOG_CLICK_UPDATE, "4", info.getMd5());
        UpdaterKt.doUpgrade(context, info, true);
    }

    @Override // tv.danmaku.bili.update.api.updater.IUpdater
    public void onError(String msg) {
        BLog.i(TAG, "onError msg = " + msg);
        Activity activity = this.mActivityRef.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        RuntimeHelper.showToastShort(activity, msg);
    }
}