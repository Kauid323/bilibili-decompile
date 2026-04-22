package tv.danmaku.bili.update.api.updater;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import java.lang.ref.WeakReference;
import tv.danmaku.bili.update.api.UpdaterOptions;
import tv.danmaku.bili.update.internal.UpdaterKt;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.binder.DialogBinderFactory;
import tv.danmaku.bili.update.internal.binder.DialogViewBinder;
import tv.danmaku.bili.update.internal.json.JsonParserKt;
import tv.danmaku.bili.update.internal.persist.prefs.PrefsHelperKt;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.bili.update.internal.report.NeuronReporterKt;
import tv.danmaku.bili.update.internal.report.UpdateReporter;
import tv.danmaku.bili.update.internal.report.UpdateReporterV2;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.utils.CommonUtilsKt;
import tv.danmaku.bili.update.utils.RandomHelper;
import tv.danmaku.bili.update.utils.RuntimeHelper;

public class WifiAutoUpdater implements IUpdater {
    private static final long AGE_1DAY = 86400000;
    private static final String TAG = "fawkes.update.wifi";
    private WeakReference<Activity> mActivityRef;

    public WifiAutoUpdater(Activity activity) {
        this.mActivityRef = new WeakReference<>(activity);
    }

    public static boolean enable(Context context, BiliUpgradeInfo info) {
        return PrefsHelperKt.isWifiAutoUpdateEnabled(context) && CommonUtilsKt.isInWifi(context) && hitAutoDownloadPolicy(info);
    }

    private static boolean hitAutoDownloadPolicy(BiliUpgradeInfo info) {
        return info.silentDownload() && System.currentTimeMillis() > info.getPtime() * 1000;
    }

    @Override // tv.danmaku.bili.update.api.updater.IUpdater
    public void onUpdate(BiliUpgradeInfo info, boolean isManual) {
        if (info == null || this.mActivityRef == null || this.mActivityRef.get() == null) {
            return;
        }
        UpdateReporter.reportUpdateSilent("1");
        UpdaterKt.downloadUpdateApk(this.mActivityRef.get(), info, true, isManual);
    }

    @Override // tv.danmaku.bili.update.api.updater.IUpdater
    public void onError(String message) {
    }

    public void showInstallDialogAfterDownload(BiliUpgradeInfo info) {
        if (info == null || this.mActivityRef == null || this.mActivityRef.get() == null || this.mActivityRef.get().isFinishing()) {
            return;
        }
        UpdateReporterV2.reportDialogShow("2", "1");
        NeuronReporterKt.reportDialogShow("2", NeuronReporterKt.manualToValue(false), info.getMd5());
        NeuronReporterKt.reportUpdateDialog(info.versionCode(), true, ConstsKt.ARG_STATE_DIALOG_SHOW, "1", info.getMd5());
        UpdaterOptions updaterOptions = RuntimeHelper.getUpdaterOptions();
        Dialog dialog = updaterOptions.getDialogFactory().create(this.mActivityRef.get(), 1);
        DialogViewBinder.Decorator dialogViewBinder = new DialogBinderFactory().create(new BinderParams.WifeAutoUpdate(this.mActivityRef, info));
        dialogViewBinder.bindView(dialog);
        dialog.show();
    }

    @Deprecated
    static boolean hitAutoDownloadPolicy(String json, long versionTimeMillis) {
        if (json != null && json.length() > 0 && versionTimeMillis > 0) {
            try {
                int[] array = (int[]) JsonParserKt.parseObject(json, int[].class);
                if (array == null || array.length == 0) {
                    return false;
                }
                long now = System.currentTimeMillis();
                int percent = RandomHelper.getRandomInt(100);
                int size = array.length;
                if (size % 2 == 0 && versionTimeMillis < now) {
                    float dayDelta = ((float) (now - versionTimeMillis)) / 8.64E7f;
                    for (int i = 0; i < size - 1; i += 2) {
                        float day = array[i];
                        if (dayDelta <= day) {
                            int rnd = array[i + 1];
                            return percent < rnd;
                        }
                    }
                    int i2 = size - 1;
                    return percent < array[i2];
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}