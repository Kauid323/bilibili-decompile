package tv.danmaku.bili.update.api;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.util.Pair;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import java.util.concurrent.Callable;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.update.api.updater.IUpdater;
import tv.danmaku.bili.update.api.updater.ManualUpdater;
import tv.danmaku.bili.update.api.updater.StartupUpdater;
import tv.danmaku.bili.update.api.updater.WifiAutoUpdater;
import tv.danmaku.bili.update.internal.config.OnlineParams;
import tv.danmaku.bili.update.internal.network.connectivity.ConnectivityMonitor;
import tv.danmaku.bili.update.internal.persist.files.UpdateApk;
import tv.danmaku.bili.update.internal.persist.prefs.PrefsHelperKt;
import tv.danmaku.bili.update.internal.persist.prefs.SharedPreferencesHelper;
import tv.danmaku.bili.update.internal.report.NeuronReporterKt;
import tv.danmaku.bili.update.internal.report.UpdateReporter;
import tv.danmaku.bili.update.internal.report.UpdateReporterV2;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.utils.CommonUtilsKt;
import tv.danmaku.bili.update.utils.RuntimeHelper;

public class UpdateHelper {
    private static final String TAG = "fawkes.update.helper";

    public static void checkUpdateInStartup(final Activity activity, final IUpdater updater2) {
        Log.d(TAG, "checkUpdateInStartup from child repo!");
        final CancellationTokenSource cts = new CancellationTokenSource();
        getExistingForceUpdate(activity).onSuccess(new Continuation() { // from class: tv.danmaku.bili.update.api.UpdateHelper$$ExternalSyntheticLambda3
            public final Object then(Task task) {
                return UpdateHelper.lambda$checkUpdateInStartup$1(activity, cts, task);
            }
        }, Task.UI_THREAD_EXECUTOR).continueWith(new Continuation() { // from class: tv.danmaku.bili.update.api.UpdateHelper$$ExternalSyntheticLambda4
            public final Object then(Task task) {
                return UpdateHelper.lambda$checkUpdateInStartup$2(activity, cts, updater2, task);
            }
        }, Task.BACKGROUND_EXECUTOR, cts.getToken()).continueWith(new Continuation() { // from class: tv.danmaku.bili.update.api.UpdateHelper$$ExternalSyntheticLambda5
            public final Object then(Task task) {
                return UpdateHelper.lambda$checkUpdateInStartup$4(activity, cts, updater2, task);
            }
        }, Task.UI_THREAD_EXECUTOR, cts.getToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$checkUpdateInStartup$1(final Activity activity, CancellationTokenSource cts, final Task task) throws Exception {
        if (CommonUtilsKt.invalid(activity)) {
            cts.cancel();
            return null;
        }
        BLog.i(TAG, "Prompt with cached force update.");
        RuntimeHelper.addUpdateDialog(activity, new Runnable() { // from class: tv.danmaku.bili.update.api.UpdateHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                new ManualUpdater(activity).showUpdateDialog((BiliUpgradeInfo) task.getResult(), false);
            }
        });
        cts.cancel();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Pair lambda$checkUpdateInStartup$2(Activity activity, CancellationTokenSource cts, IUpdater updater2, Task task) throws Exception {
        if (CommonUtilsKt.invalid(activity)) {
            cts.cancel();
            if (updater2 != null) {
                updater2.onError(SplashCustomReporterKt.STATE_CANCEL);
            }
            return null;
        }
        BLog.v(TAG, "Check the startup online param and interval time.");
        if (!OnlineParams.getEnableStartupUpdate() || !PrefsHelperKt.shouldPerformUpdate(activity)) {
            BLog.ifmt(TAG, "Skip update for switch or interval.", new Object[0]);
            cts.cancel();
            if (updater2 != null) {
                updater2.onError("Skip update for switch or interval.");
            }
            return null;
        }
        BLog.v(TAG, "Fetch update info from fawkes service.");
        BiliUpgradeInfo result = null;
        try {
            result = RuntimeHelper.getUpdaterOptions().getRemoteUpgradeInfoSupplier().get(activity);
        } catch (Exception e) {
            BLog.d(TAG, e.getMessage());
        }
        boolean nullResponse = result == null;
        boolean oldVersion = !nullResponse && RuntimeHelper.versionCode() >= result.versionCode();
        boolean ignoredVersion = nullResponse ? false : PrefsHelperKt.ignore(activity, result);
        boolean triedBefore = (nullResponse || PrefsHelperKt.canPrompt(activity, result)) ? false : true;
        if (nullResponse || oldVersion || ignoredVersion || triedBefore) {
            BLog.efmt(TAG, "Skip update for fetched info %s, %s.", new Object[]{nullResponse ? "na" : result.getVersion(), skipReason(nullResponse, oldVersion, ignoredVersion, triedBefore)});
            cts.cancel();
            if (updater2 != null) {
                updater2.onError(String.format("Skip update for fetched info %s, %s.", nullResponse ? "na" : result.getVersion(), skipReason(nullResponse, oldVersion, ignoredVersion, triedBefore)));
            }
            return null;
        }
        BLog.v(TAG, "Find downloaded apk if exist.");
        BiliUpgradeInfo downloadInfo = null;
        try {
            downloadInfo = UpdateApk.getDownloadedUpdate(activity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        BLog.vfmt(TAG, "Found downloaded apk %b, version=%s.", new Object[]{Boolean.valueOf(downloadInfo != null), downloadInfo != null ? downloadInfo.getVersion() : "na"});
        return new Pair(result, downloadInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$checkUpdateInStartup$4(final Activity activity, CancellationTokenSource cts, IUpdater updater2, Task task) throws Exception {
        if (CommonUtilsKt.invalid(activity)) {
            cts.cancel();
            if (updater2 != null) {
                updater2.onError(SplashCustomReporterKt.STATE_CANCEL);
            }
            return null;
        }
        boolean success = (!task.isCompleted() || task.isCancelled() || task.getResult() == null) ? false : true;
        if (!success) {
            BLog.e(TAG, "Skip update, find downloaded file task failed.");
            cts.cancel();
            if (updater2 != null) {
                updater2.onError("Skip update, find downloaded file task failed.");
            }
            return null;
        }
        Pair<BiliUpgradeInfo, BiliUpgradeInfo> result = (Pair) task.getResult();
        BiliUpgradeInfo fetchInfo = (BiliUpgradeInfo) result.first;
        final BiliUpgradeInfo downloadInfo = (BiliUpgradeInfo) result.second;
        if (fetchInfo == null) {
            cts.cancel();
            if (updater2 != null) {
                updater2.onError(SplashCustomReporterKt.STATE_CANCEL);
            }
            return null;
        } else if (downloadInfo != null && downloadInfo.versionCode() >= fetchInfo.versionCode()) {
            BLog.d(TAG, "The downloaded apk is available and start install.");
            RuntimeHelper.addUpdateDialog(activity, new Runnable() { // from class: tv.danmaku.bili.update.api.UpdateHelper$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateHelper.lambda$checkUpdateInStartup$3(activity, downloadInfo);
                }
            });
            if (updater2 != null) {
                updater2.onError("The downloaded apk is available and start install.");
            }
            cts.cancel();
            return null;
        } else {
            if (updater2 != null) {
                updater2.onUpdate(fetchInfo, false);
            }
            onUpdateResult(activity, fetchInfo);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$checkUpdateInStartup$3(Activity activity, BiliUpgradeInfo downloadInfo) {
        PrefsHelperKt.onShowPrompt(activity, downloadInfo);
        new WifiAutoUpdater(activity).showInstallDialogAfterDownload(downloadInfo);
    }

    private static Object skipReason(boolean nullResponse, boolean oldVersion, boolean ignoredVersion, boolean triedBefore) {
        return nullResponse ? "null response" : oldVersion ? "old version" : ignoredVersion ? "ignored version" : triedBefore ? "prompt policy" : "INTERNAL LOGIC ERROR";
    }

    private static void onUpdateResult(final Activity activity, final BiliUpgradeInfo info) {
        if (info == null || RuntimeHelper.versionCode() >= info.versionCode()) {
            return;
        }
        if (info.getPolicy() == 0) {
            long timeMills = info.getPtime() * 1000;
            if (!info.forceUpgrade() && WifiAutoUpdater.enable(activity, info)) {
                BLog.v(TAG, "Silent download start.");
                new WifiAutoUpdater(activity).onUpdate(info, false);
                PrefsHelperKt.setUpdatePerformed(activity);
                return;
            } else if (ConnectivityMonitor.getInstance().isMobileActive() && System.currentTimeMillis() < OnlineParams.getShowDialogOnMobileNetwork() + timeMills) {
                BLog.i(TAG, "Skip update on mobile network cause the time is not suitable.");
                return;
            }
        }
        BLog.d(TAG, "Show dialog and start update on the common way.");
        RuntimeHelper.addUpdateDialog(activity, new Runnable() { // from class: tv.danmaku.bili.update.api.UpdateHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UpdateHelper.lambda$onUpdateResult$5(activity, info);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onUpdateResult$5(Activity activity, BiliUpgradeInfo info) {
        PrefsHelperKt.onShowPrompt(activity, info);
        new StartupUpdater(activity).onUpdate(info, false);
    }

    public static void checkInternalUpdateFlag(final Context context) {
        Task.callInBackground(new Callable<Void>() { // from class: tv.danmaku.bili.update.api.UpdateHelper.1
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                if (PrefsHelperKt.isInternalUpdate(context)) {
                    UpdateReporter.reportUpdate("4");
                    String preparedFlag = PrefsHelperKt.getPackagePreparedState(context) ? "2" : "1";
                    String manualFlag = PrefsHelperKt.getUpdateManualClickState(context) ? "2" : "1";
                    UpdateReporterV2.reportDialogResult(preparedFlag, manualFlag, "1");
                    NeuronReporterKt.reportDialogResult(preparedFlag, NeuronReporterKt.manualToValue(PrefsHelperKt.getUpdateManualClickState(context)), "1", PrefsHelperKt.getUpdateInfoMd5(context), PrefsHelperKt.getUpdateInfo32To64(context));
                    return null;
                }
                return null;
            }
        });
    }

    public static int getLastRunVersion(Context context) {
        return SharedPreferencesHelper.getInstance(context).optInteger(PrefsHelperKt.PREFS_KEY_LAST_RUN_VERSION, 0);
    }

    public static Task<BiliUpgradeInfo> getExistingForceUpdate(final Activity activity) {
        return Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.update.api.UpdateHelper$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UpdateHelper.lambda$getExistingForceUpdate$6(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ BiliUpgradeInfo lambda$getExistingForceUpdate$6(Activity activity) throws Exception {
        BLog.v(TAG, "Check cached force update.");
        return UpdateApk.getExistingForceUpdate(activity);
    }

    public static void checkUpdateAndShowDialog(Context context, final IUpdater updater2) {
        Log.d(TAG, "checkUpdateAndShowDialog from child repo!");
        checkUpdate(context).continueWith(new Continuation() { // from class: tv.danmaku.bili.update.api.UpdateHelper$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                return UpdateHelper.lambda$checkUpdateAndShowDialog$7(IUpdater.this, task);
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$checkUpdateAndShowDialog$7(IUpdater updater2, Task task) throws Exception {
        BiliUpgradeInfo result;
        if (task.isFaulted()) {
            Exception e = task.getError();
            if (e != null) {
                updater2.onError(e.getMessage());
                return null;
            }
            return null;
        } else if (task.isCompleted() && !task.isCancelled() && (result = (BiliUpgradeInfo) task.getResult()) != null && RuntimeHelper.versionCode() <= result.versionCode()) {
            updater2.onUpdate(result, true);
            return null;
        } else {
            return null;
        }
    }

    private static Task<BiliUpgradeInfo> checkUpdate(final Context context) {
        return Task.callInBackground(new Callable<BiliUpgradeInfo>() { // from class: tv.danmaku.bili.update.api.UpdateHelper.2
            @Override // java.util.concurrent.Callable
            public BiliUpgradeInfo call() throws Exception {
                return RuntimeHelper.getUpdaterOptions().getRemoteUpgradeInfoSupplier().get(context);
            }
        });
    }
}