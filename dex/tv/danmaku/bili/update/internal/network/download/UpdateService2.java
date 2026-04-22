package tv.danmaku.bili.update.internal.network.download;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.PendingIntentCompat;
import androidx.core.app.ServiceCompat;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.app.updater.BuildConfig;
import com.bilibili.app.updater.R;
import com.bilibili.lib.bilipatch.PatchInfo;
import com.bilibili.lib.bilipatch.PatchItem;
import com.bilibili.lib.bilipatch.PatchResult;
import com.bilibili.lib.bilipatch.TransformCallback;
import com.bilibili.lib.bilipatch.UrlTransformer;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.neuron.util.HandlerThreads;
import com.bilibili.lib.okdownloader.BiliDownloader;
import com.bilibili.lib.spy.generated.android_app_Service;
import com.bilibili.lib.tribe.core.internal.Hooks;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.internal.exception.Errors;
import tv.danmaku.bili.update.internal.exception.ErrorsCompat;
import tv.danmaku.bili.update.internal.exception.UpdateError;
import tv.danmaku.bili.update.internal.network.connectivity.Connectivity;
import tv.danmaku.bili.update.internal.network.connectivity.ConnectivityMonitor;
import tv.danmaku.bili.update.internal.persist.files.UpdateApk;
import tv.danmaku.bili.update.internal.persist.prefs.PrefsHelperKt;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.bili.update.internal.report.NeuronReporterKt;
import tv.danmaku.bili.update.internal.report.UpdateReporter;
import tv.danmaku.bili.update.internal.report.UpdateReporterV2;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.model.Patch;
import tv.danmaku.bili.update.utils.Constants;
import tv.danmaku.bili.update.utils.FileUtils;
import tv.danmaku.bili.update.utils.PackageUtilsKt;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import video.biz.offline.base.infra.utils.EntryScannerKt;

public class UpdateService2 extends android_app_Service {
    public static final String EXTRA_MANUAL = "extra_manual";
    public static final String EXTRA_SILENT = "EXTRA_SILENT";
    public static final String EXTRA_UPDATE_INFO = "EXTRA_UPDATE_INFO";
    private static final int ID_UPDATE_APK = 8264;
    private static final long NOTIFY_INTERVAL_MILLIS = 1000;
    public static final String SP_APK_PATH = "apk_path";
    public static final String SP_APK_STORE_INFO = "apk_store_info";
    public static final String SP_KEY_APK_INFO_MD5 = "sp_key_apk_info_md5";
    public static final String SP_KEY_APK_IS_MANUAL = "sp_key_apk_is_manual";
    public static final String SP_KEY_APK_IS_SILENT = "sp_key_apk_is_silent";
    public static final String SP_KEY_APK_VERSION_CODE = "sp_key_apk_version_code";
    private static final String TAG = "fawkes.update.service";
    private NotificationCompat.Builder mBuilder;
    private BiliUpgradeInfo mInfo;
    private boolean mIsDownloading;
    private boolean mIsManual;
    private boolean mIsSilent;
    private int mLastStartId = -1;
    private String mIncrementDownloadTaskId = "";
    private int finalPatchType = -1;
    private boolean isDegrade = false;
    private boolean patchDownloadFailed = false;
    private UrlTransformer patchUrlTransformer = new UrlTransformer() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2$$ExternalSyntheticLambda0
        public final void onTransform(String str, TransformCallback transformCallback) {
            UpdateService2.this.m1906lambda$new$2$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2(str, transformCallback);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnTransformUrl {
        void onGetUrl(String str);
    }

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onTimeout(int startId, int fgsType) {
        super.onTimeout(startId, fgsType);
        BLog.d(TAG, "onTimeout");
        if (this.mInfo != null && this.mInfo.getUrl() != null) {
            BiliDownloader.getInstance(this).pauseByUrl(this.mInfo.getUrl());
        }
        stopSelf(startId);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (this.mIsDownloading) {
            toastIfNonSilent(R.string.update_is_downloading);
            return 2;
        }
        this.mLastStartId = startId;
        onHandleIntent(intent);
        return 2;
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            this.mIsSilent = intent.getBooleanExtra(EXTRA_SILENT, false);
            this.mInfo = (BiliUpgradeInfo) intent.getParcelableExtra(EXTRA_UPDATE_INFO);
            this.mIsManual = intent.getBooleanExtra(EXTRA_MANUAL, false);
            if (this.mInfo != null && RuntimeHelper.checkInit()) {
                Boolean isAsync = RuntimeHelper.abtest("update_service_async");
                if (isAsync == null || isAsync.booleanValue()) {
                    HandlerThreads.post(2, new Runnable() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            UpdateService2.this.m1907lambda$onHandleIntent$0$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2();
                        }
                    });
                } else {
                    startNewUpdateTask(this.mInfo, this.mIsSilent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onHandleIntent$0$tv-danmaku-bili-update-internal-network-download-UpdateService2  reason: not valid java name */
    public /* synthetic */ void m1907lambda$onHandleIntent$0$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2() {
        startNewUpdateTask(this.mInfo, this.mIsSilent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void startNewUpdateTask(BiliUpgradeInfo info, boolean silent) {
        boolean incrementalUpgradeEffect = false;
        if (BuildConfig.DEBUG) {
            BLog.dfmt(TAG, "New task coming %s.", new Object[]{info.toString()});
        }
        File file = UpdateApk.getDestFile(this, info);
        if (file == null) {
            toastIfNonSilent(R.string.update_no_capacity);
            UpdateReporterV2.reportDialogResult("1", getIsManualReportParam(), "2");
            NeuronReporterKt.reportDialogResult("1", NeuronReporterKt.manualToValue(this.mIsManual), "2", info.getMd5());
        } else if (!UpdateApk.DEBUG && isDownloadedDestFileInstallable(file)) {
            if (!silent) {
                BLog.d(TAG, "find available apk, now install.");
                UpdateReporter.reportUpdate("3");
                tryInstall(file, true);
                removeApkInfo();
            }
        } else if (!Connectivity.isConnectedOrConnecting(Connectivity.getActiveNetworkInfo(this))) {
            toastIfNonSilent(R.string.update_no_network);
            UpdateReporterV2.reportDialogResult("1", getIsManualReportParam(), "2");
            NeuronReporterKt.reportDialogResult("1", NeuronReporterKt.manualToValue(this.mIsManual), "2", info.getMd5());
        } else {
            beforeUpdateDownload(info, file);
            if (UpdateApk.enableIncremental(this) && UpdatePatchHelper.getPreferPatch(info) != null) {
                incrementalUpgradeEffect = true;
            }
            if (incrementalUpgradeEffect) {
                doIncrementalUpgrade(info, file);
            } else {
                doFullUpgrade(info, file);
            }
        }
    }

    private boolean isDownloadedDestFileInstallable(File file) {
        PackageInfo archiveInfo;
        if (file == null || !file.exists() || (archiveInfo = PackageUtilsKt.getPackageArchiveInfo(getApplicationContext(), file.getAbsolutePath(), 0)) == null || (archiveInfo.versionCode <= RuntimeHelper.versionCode() && !isSameBuild(archiveInfo))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void beforeUpdateDownload(BiliUpgradeInfo info, File file) {
        if (!UpdateApk.DEBUG && file.exists()) {
            file.delete();
        }
        UpdateApk.cleanApkDir(this, false);
        startForegroundIfNonSilent();
        toastIfNonSilent(R.string.update_start_download);
        this.mIsDownloading = true;
        UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), "1");
        NeuronReporterKt.reportUpdateDownload(info.versionCode(), this.mIsSilent, "1", info.getMd5());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$tv-danmaku-bili-update-internal-network-download-UpdateService2  reason: not valid java name */
    public /* synthetic */ void m1906lambda$new$2$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2(String originUrl, final TransformCallback transformCallback) {
        if (isUnicomServiceEnable()) {
            transformDownloadUrl(originUrl, new OnTransformUrl() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2$$ExternalSyntheticLambda6
                @Override // tv.danmaku.bili.update.internal.network.download.UpdateService2.OnTransformUrl
                public final void onGetUrl(String str) {
                    transformCallback.onResult(str);
                }
            }, true);
        } else {
            transformCallback.onResult(originUrl);
        }
    }

    private void doIncrementalUpgrade(final BiliUpgradeInfo info, final File file) {
        boolean newVersion = UpdatePatchHelper.patchNewVersion();
        if (!newVersion) {
            if (isUnicomServiceEnable()) {
                transformDownloadUrl(info.getPatch().getUrl(), new OnTransformUrl() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2.1
                    @Override // tv.danmaku.bili.update.internal.network.download.UpdateService2.OnTransformUrl
                    public void onGetUrl(String url) {
                        info.getPatch().setUrl(url);
                        UpdateService2.this.tryIncrementalUpgradeOld(info, file);
                    }
                }, false);
                return;
            } else {
                tryIncrementalUpgradeOld(info, file);
                return;
            }
        }
        tryIncrementalUpgrade(info, file);
    }

    private void doFullUpgrade(final BiliUpgradeInfo info, final File file) {
        UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), "7");
        NeuronReporterKt.reportUpdateDownload(info.versionCode(), this.mIsSilent, "7", info.getMd5());
        if (isUnicomServiceEnable()) {
            transformDownloadUrl(info.getUrl(), new OnTransformUrl() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2.2
                @Override // tv.danmaku.bili.update.internal.network.download.UpdateService2.OnTransformUrl
                public void onGetUrl(String url) {
                    if (!TextUtils.isEmpty(url)) {
                        info.setUrl(url);
                        UpdateService2.this.fullUpgrade(info, file);
                    }
                }
            }, false);
        } else {
            fullUpgrade(info, file);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isUnicomServiceEnable() {
        return ConnectivityMonitor.getInstance().isMobileActive() && RuntimeHelper.checkApkUpdateFreeDataAvailable(this);
    }

    private boolean isSameBuild(PackageInfo archiveInfo) {
        PackageInfo info = PackageUtilsKt.getPackageInfo(getApplicationContext(), null, 0);
        return (info == null || archiveInfo.versionCode != info.versionCode || TextUtils.equals(archiveInfo.versionName, info.versionName)) ? false : true;
    }

    private void transformDownloadUrl(final String url, final OnTransformUrl onTransformUrl, final boolean callback) {
        Task.callInBackground(new Callable<String>() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2.4
            @Override // java.util.concurrent.Callable
            public String call() throws Exception {
                return RuntimeHelper.processApkDownloadUrl(UpdateService2.this, url);
            }
        }).continueWith(new Continuation<String, Void>() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2.3
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1911then((Task<String>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1911then(Task<String> task) throws Exception {
                if (task != null && task.isCompleted()) {
                    String transUrl = (String) task.getResult();
                    if (!TextUtils.isEmpty(transUrl)) {
                        RuntimeHelper.showToastShort(UpdateService2.this, UpdateService2.this.getString(R.string.update_unicom_toast_update_apk_downloading));
                        onTransformUrl.onGetUrl(transUrl);
                        return null;
                    } else if (!callback) {
                        RuntimeHelper.showToastShort(UpdateService2.this, UpdateService2.this.getString(R.string.update_unicom_toast_update_apk_failed));
                        UpdateService2.this.dismissNotification();
                        UpdateService2.this.reset();
                        UpdateService2.this.stopSelf(UpdateService2.this.mLastStartId);
                        return null;
                    } else {
                        onTransformUrl.onGetUrl("");
                        return null;
                    }
                }
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    private int getDownloadNetwork() {
        if (this.mIsSilent) {
            return 2;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void fullUpgrade(BiliUpgradeInfo info, final File file) {
        BLog.i(TAG, String.format("fullUpgrade: currentThread(%s)", Thread.currentThread().getName()));
        if (TextUtils.isEmpty(info.getUrl())) {
            onFullUpgradeDownloadFailed(file, 101, "url is invalid");
        } else {
            BiliDownloader.get(this).create(info.getUrl(), Constants.DOWNLOAD_TAG).fileName(file.getName()).priority(10).networkOn(getDownloadNetwork()).totalSize(info.getSize()).md5(info.getMd5()).into(file.getParent()).addListener(new DownloadListenerAdapter() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2.5
                @Override // tv.danmaku.bili.update.internal.network.download.DownloadListenerAdapter
                public void onStart(String taskId) {
                    BLog.i(UpdateService2.TAG, "BiliDownloader start download：" + taskId);
                }

                @Override // tv.danmaku.bili.update.internal.network.download.DownloadListenerAdapter
                public void onFinish(String taskId, String dir, String name) {
                    BLog.i(UpdateService2.TAG, "onFinish dir = " + dir + ", name = " + name);
                    File destFile = new File(dir, name);
                    if (!BuildConfig.DEBUG && !UpdateApk.checkValidity(UpdateService2.this, UpdateService2.this.mInfo, destFile)) {
                        UpdateService2.this.onFullUpgradeDownloadFailed(file, 305, "apk is invalid.");
                        return;
                    }
                    UpdateReporterV2.reportUpdateDownload(UpdateService2.this.getDownloadModeReportParam(), ConstsKt.ARG_FULL_PKG_START_INSTALL);
                    NeuronReporterKt.reportUpdateDownload(UpdateService2.this.mInfo.versionCode(), UpdateService2.this.mIsSilent, ConstsKt.ARG_FULL_PKG_START_INSTALL, UpdateService2.this.mInfo.getMd5());
                    UpdateService2.this.onUpdateSuccess(destFile, UpdateService2.this.mInfo);
                }

                @Override // tv.danmaku.bili.update.internal.network.download.DownloadListenerAdapter
                public void onError(String taskId, List<Integer> errorCodes, long size, long length) {
                    BLog.e(UpdateService2.TAG, "onError errorCodes = " + errorCodes + ",size = " + size);
                    int errorCode = 0;
                    if (errorCodes != null && errorCodes.size() > 0) {
                        errorCode = errorCodes.get(0).intValue();
                    }
                    UpdateService2.this.onFullUpgradeDownloadFailed(file, errorCode, "");
                }

                @Override // tv.danmaku.bili.update.internal.network.download.DownloadListenerAdapter
                public void onCheck(String taskId) {
                    BLog.i(UpdateService2.TAG, "onCheck taskId = " + taskId);
                    UpdateService2.this.notifyNotificationIfNonSilent(UpdateService2.this.getString(R.string.update_apk_checking));
                }

                @Override // tv.danmaku.bili.update.internal.network.download.DownloadListenerAdapter
                public void onLoading(String taskId, long speed, long totalBytes, long downloadedBytes, int progress) {
                    UpdateService2.this.onDownloading(progress, totalBytes, downloadedBytes);
                }
            }).build().enqueue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryIncrementalUpgradeOld(BiliUpgradeInfo info, File file) {
        BLog.i(TAG, String.format("tryIncrementalUpgradeOld: currentThread(%s)", Thread.currentThread().getName()));
        File patchFile = UpdateApk.getPatchFile(getApplicationContext(), info);
        if (patchFile == null) {
            fullUpgrade(info, file);
            return;
        }
        FileUtils.deleteQuietly(patchFile);
        BLog.i(TAG, "use incrementUpgrade old");
        incrementUpgradeOld(info, file, patchFile);
    }

    private void tryIncrementalUpgrade(BiliUpgradeInfo info, File file) {
        BLog.i(TAG, String.format("tryIncrementalUpgrade: currentThread(%s)", Thread.currentThread().getName()));
        File patchFile = UpdateApk.getPreferPatchFile(getApplicationContext(), info);
        if (patchFile == null) {
            fullUpgrade(info, file);
            return;
        }
        List<File> files = UpdateApk.getPatchFileList(getApplicationContext(), info);
        if (files != null) {
            for (File f : files) {
                FileUtils.deleteQuietly(f);
            }
        }
        BLog.i(TAG, "use incrementUpgrade new");
        incrementUpgrade(info, file, patchFile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkPatch(File destFile, Patch patch) {
        if (BuildConfig.DEBUG) {
            return true;
        }
        return destFile != null && destFile.exists() && destFile.length() == patch.getSize();
    }

    private void incrementUpgrade(final BiliUpgradeInfo info, final File file, File patchFile) {
        Patch patch = UpdatePatchHelper.getPreferPatch(info);
        UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), "2");
        NeuronReporterKt.reportUpdateDownload(info.versionCode(), this.mIsSilent, "2", info.getMd5());
        if (TextUtils.isEmpty(patch.getUrl())) {
            onIncrementUpgradeDownloadFailed(101, "url is invalid", info, file);
            return;
        }
        String dir = patchFile.getParent();
        final File oldFile = getOldApk(getApplicationContext());
        List<PatchItem> items = UpdatePatchHelper.getPatchItems(getApplicationContext(), info);
        final PatchInfo patchInfo = new PatchInfo(patch.getUrl(), patchFile.getName(), dir, patch.getMd5(), (Map) null, Constants.DOWNLOAD_TAG);
        patchInfo.setItems(items);
        final String fileMd5 = info.getMd5();
        if (fileMd5 != null && !TextUtils.isEmpty(fileMd5)) {
            this.finalPatchType = -1;
            this.isDegrade = false;
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return UpdateService2.this.m1904lambda$incrementUpgrade$3$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2(oldFile, patchInfo, file, fileMd5, info);
                }
            }).continueWith(new Continuation() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2$$ExternalSyntheticLambda2
                public final Object then(Task task) {
                    return UpdateService2.this.m1905lambda$incrementUpgrade$4$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2(file, task);
                }
            }, Task.UI_THREAD_EXECUTOR);
            return;
        }
        UpdateReporter.reportError(this.mIsSilent, Errors.ERROR_PATCH_INVALID, "file md5 is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$incrementUpgrade$3$tv-danmaku-bili-update-internal-network-download-UpdateService2  reason: not valid java name */
    public /* synthetic */ PatchResult m1904lambda$incrementUpgrade$3$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2(File oldFile, PatchInfo patchInfo, File file, String fileMd5, final BiliUpgradeInfo info) throws Exception {
        PatchResult result = UpdatePatchHelper.downloadAndPatch(this, oldFile.getAbsolutePath(), patchInfo, file.getAbsolutePath(), fileMd5, new UpdatePatchEventListener() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2.6
            @Override // tv.danmaku.bili.update.internal.network.download.UpdatePatchEventListener
            public void onPatchStart(int patchType) {
                BLog.i(UpdateService2.TAG, "onPatchEnd onPatchStart = " + patchType);
                UpdateService2.this.finalPatchType = patchType;
                UpdateService2.this.notifyNotificationIfNonSilent(UpdateService2.this.getString(R.string.update_incremental_patch));
            }

            @Override // tv.danmaku.bili.update.internal.network.download.UpdatePatchEventListener
            public void onPatchDegrade(int patchType) {
                BLog.i(UpdateService2.TAG, "onPatchEnd onPatchDegrade = " + patchType);
                UpdateService2.this.finalPatchType = patchType;
                UpdateService2.this.isDegrade = true;
            }

            @Override // tv.danmaku.bili.update.internal.network.download.UpdatePatchEventListener
            public void onPatchEvent(String s) {
                BLog.i(UpdateService2.TAG, "onPatchEnd onPatchEvent = " + s);
            }

            @Override // tv.danmaku.bili.update.internal.network.download.UpdatePatchEventListener
            public void onPatchEnd(int patchType, int code, Integer rawErrorCode, String patchMd5, Throwable throwable) {
                BLog.i(UpdateService2.TAG, "onPatchEnd patchType = " + patchType + ",code = " + code + ",patchMd5 = " + patchMd5);
            }

            @Override // tv.danmaku.bili.update.internal.network.download.UpdatePatchEventListener
            public void onDownloadStart(String taskId) {
                BLog.i(UpdateService2.TAG, "BiliDownloader start download：" + taskId);
            }

            @Override // tv.danmaku.bili.update.internal.network.download.UpdatePatchEventListener
            public void onDownloadLoading(String taskId, long speed, long totalBytes, long downloadedBytes, int progress) {
                UpdateService2.this.onDownloading(progress, totalBytes, downloadedBytes);
            }

            @Override // tv.danmaku.bili.update.internal.network.download.UpdatePatchEventListener
            public void onDownloadCheck(String s) {
                UpdateService2.this.notifyNotificationIfNonSilent(UpdateService2.this.getString(R.string.update_apk_checking));
            }

            @Override // tv.danmaku.bili.update.internal.network.download.UpdatePatchEventListener
            public void onDownloadFinish(String taskId, String dir, String name) {
                UpdateService2.this.patchDownloadFailed = false;
                UpdateReporterV2.reportUpdateDownload(UpdateService2.this.getDownloadModeReportParam(), "3");
                NeuronReporterKt.reportUpdateDownload(info.versionCode(), UpdateService2.this.mIsSilent, "3", info.getMd5());
            }

            @Override // tv.danmaku.bili.update.internal.network.download.UpdatePatchEventListener
            public void onDownloadError(String s, List<Integer> errorCodes, long size, long length) {
                UpdateService2.this.patchDownloadFailed = true;
                BLog.e(UpdateService2.TAG, "onError errorCodes = " + errorCodes + ",size = " + size);
                int errorCode = 0;
                if (errorCodes != null && errorCodes.size() > 0) {
                    errorCode = errorCodes.get(0).intValue();
                }
                UpdateReporter.reportError(UpdateService2.this.mIsSilent, errorCode, "");
                UpdateReporterV2.reportUpdateDownload(UpdateService2.this.getDownloadModeReportParam(), ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE);
                NeuronReporterKt.reportUpdateDownload(info.versionCode(), UpdateService2.this.mIsSilent, ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE, info.getMd5(), Integer.valueOf(UpdateService2.this.finalPatchType), Boolean.valueOf(UpdateService2.this.isDegrade), Boolean.valueOf(UpdateService2.this.patchDownloadFailed), null, Integer.valueOf(errorCode));
            }
        }, this.patchUrlTransformer);
        List<File> patchFiles = UpdateApk.getPatchFileList(getApplicationContext(), info);
        if (patchFiles != null) {
            for (File p : patchFiles) {
                FileUtils.deleteQuietly(p);
            }
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$incrementUpgrade$4$tv-danmaku-bili-update-internal-network-download-UpdateService2  reason: not valid java name */
    public /* synthetic */ Void m1905lambda$incrementUpgrade$4$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2(File file, Task task) throws Exception {
        PatchResult result = (PatchResult) task.getResult();
        BLog.i(TAG, "OnGetPatchResult code = " + result.getCode() + ", msg = " + result.getMessage());
        switch (result.getCode()) {
            case 100:
                UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), "4");
                NeuronReporterKt.reportUpdateDownload(this.mInfo.versionCode(), this.mIsSilent, "4", this.mInfo.getMd5(), Integer.valueOf(this.finalPatchType), Boolean.valueOf(this.isDegrade));
                onPatchSuccess(file, this.mInfo);
                return null;
            case 101:
                UpdateReporter.reportError(this.mIsSilent, Errors.ERROR_PATCH_FAIL, result.getMessage());
                notifyNotificationIfNonSilent(getString(R.string.update_incremental_fail));
                UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), ConstsKt.ARG_MERGE_INCREMENT_FAILURE);
                NeuronReporterKt.reportUpdateDownload(this.mInfo.versionCode(), this.mIsSilent, ConstsKt.ARG_MERGE_INCREMENT_FAILURE, this.mInfo.getMd5(), Integer.valueOf(this.finalPatchType), Boolean.valueOf(this.isDegrade), Boolean.valueOf(this.patchDownloadFailed), result.getRawErrorCode() + "");
                fullUpgrade(this.mInfo, file);
                return null;
            case 102:
                UpdateReporter.reportError(this.mIsSilent, Errors.ERROR_PATCH_FAIL, result.getMessage());
                notifyNotificationIfNonSilent(getString(R.string.update_incremental_fail));
                UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), ConstsKt.ARG_MERGE_INCREMENT_FAILURE);
                NeuronReporterKt.reportUpdateDownload(this.mInfo.versionCode(), this.mIsSilent, ConstsKt.ARG_MERGE_INCREMENT_FAILURE, this.mInfo.getMd5(), Integer.valueOf(this.finalPatchType), Boolean.valueOf(this.isDegrade), Boolean.valueOf(this.patchDownloadFailed), "102");
                fullUpgrade(this.mInfo, file);
                return null;
            case 103:
                RuntimeHelper.showToastShort(this, getString(R.string.update_unicom_toast_update_apk_failed));
                NeuronReporterKt.reportUpdateDownload(this.mInfo.versionCode(), this.mIsSilent, ConstsKt.ARG_MERGE_INCREMENT_FAILURE, this.mInfo.getMd5(), Integer.valueOf(this.finalPatchType), Boolean.valueOf(this.isDegrade), Boolean.valueOf(this.patchDownloadFailed), "103");
                dismissNotification();
                reset();
                stopSelf(this.mLastStartId);
                return null;
            default:
                UpdateReporter.reportError(this.mIsSilent, Errors.ERROR_PATCH_FAIL, result.getMessage());
                notifyNotificationIfNonSilent(getString(R.string.update_incremental_fail));
                UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), ConstsKt.ARG_MERGE_INCREMENT_FAILURE);
                NeuronReporterKt.reportUpdateDownload(this.mInfo.versionCode(), this.mIsSilent, ConstsKt.ARG_MERGE_INCREMENT_FAILURE, this.mInfo.getMd5(), Integer.valueOf(this.finalPatchType), Boolean.valueOf(this.isDegrade), Boolean.valueOf(this.patchDownloadFailed));
                fullUpgrade(this.mInfo, file);
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void incrementUpgradeOld(final BiliUpgradeInfo info, final File file, final File patchFile) {
        final Patch patch = info.getPatch();
        UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), "2");
        NeuronReporterKt.reportUpdateDownload(info.versionCode(), this.mIsSilent, "2", info.getMd5());
        if (TextUtils.isEmpty(patch.getUrl())) {
            onIncrementUpgradeDownloadFailed(101, "url is invalid", info, file);
            return;
        }
        com.bilibili.lib.okdownloader.Task task = BiliDownloader.get(this).create(patch.getUrl(), Constants.DOWNLOAD_TAG).fileName(patchFile.getName()).priority(10).networkOn(getDownloadNetwork()).totalSize(patch.getSize()).md5(patch.getMd5()).into(patchFile.getParent()).addListener(new DownloadListenerAdapter() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2.7
            @Override // tv.danmaku.bili.update.internal.network.download.DownloadListenerAdapter
            public void onStart(String taskId) {
                BLog.i(UpdateService2.TAG, "BiliDownloader start download：" + taskId);
            }

            @Override // tv.danmaku.bili.update.internal.network.download.DownloadListenerAdapter
            public void onFinish(String taskId, String dir, String name) {
                BLog.i(UpdateService2.TAG, "onFinish dir = " + dir + ", name = " + name);
                File destFile = new File(dir, name);
                if (!UpdateService2.this.checkPatch(destFile, patch)) {
                    UpdateService2.this.onIncrementUpgradeDownloadFailed(Errors.ERROR_PATCH_INVALID, "Patch is invalid.", info, file);
                    return;
                }
                UpdateService2.this.notifyNotificationIfNonSilent(UpdateService2.this.getString(R.string.update_incremental_patch));
                UpdateReporterV2.reportUpdateDownload(UpdateService2.this.getDownloadModeReportParam(), "3");
                NeuronReporterKt.reportUpdateDownload(info.versionCode(), UpdateService2.this.mIsSilent, "3", info.getMd5(), 102);
                UpdateService2.this.onPatchDownloaded(file, patchFile);
            }

            @Override // tv.danmaku.bili.update.internal.network.download.DownloadListenerAdapter
            public void onError(String taskId, List<Integer> errorCodes, long size, long length) {
                BLog.e(UpdateService2.TAG, "onError errorCodes = " + errorCodes + ",size = " + size);
                int errorCode = 0;
                if (errorCodes != null && errorCodes.size() > 0) {
                    errorCode = errorCodes.get(0).intValue();
                }
                UpdateService2.this.onIncrementUpgradeDownloadFailed(errorCode, "", info, file);
            }

            @Override // tv.danmaku.bili.update.internal.network.download.DownloadListenerAdapter
            public void onCheck(String taskId) {
                BLog.i(UpdateService2.TAG, "onCheck taskId = " + taskId);
                UpdateService2.this.notifyNotificationIfNonSilent(UpdateService2.this.getString(R.string.update_apk_checking));
            }

            @Override // tv.danmaku.bili.update.internal.network.download.DownloadListenerAdapter
            public void onLoading(String taskId, long speed, long totalBytes, long downloadedBytes, int progress) {
                UpdateService2.this.onDownloading(progress, totalBytes, downloadedBytes);
            }
        }).build();
        this.mIncrementDownloadTaskId = task.getTaskId();
        task.enqueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onIncrementUpgradeDownloadFailed(int errorCode, String errorMessage, BiliUpgradeInfo info, File file) {
        if (this.mIncrementDownloadTaskId != null && this.mIncrementDownloadTaskId.length() > 0) {
            BiliDownloader.getInstance(this).cancel(this.mIncrementDownloadTaskId);
        }
        notifyNotificationIfNonSilent(getString(R.string.update_incremental_fail));
        UpdateReporter.reportError(this.mIsSilent, errorCode, errorMessage);
        UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE);
        NeuronReporterKt.reportUpdateDownload(info.versionCode(), this.mIsSilent, ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE, info.getMd5());
        fullUpgrade(info, file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onFullUpgradeDownloadFailed(File destFile, int errorCode, String errorMessage) {
        UpdateReporter.reportError(this.mIsSilent, errorCode, errorMessage);
        UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), ConstsKt.ARG_FULL_PKG_DOWNLOAD_FAILURE);
        NeuronReporterKt.reportUpdateDownload(this.mInfo.versionCode(), this.mIsSilent, ConstsKt.ARG_FULL_PKG_DOWNLOAD_FAILURE, this.mInfo.getMd5());
        UpdateReporterV2.reportDialogResult("1", getIsManualReportParam(), "2");
        NeuronReporterKt.reportDialogResult("1", NeuronReporterKt.manualToValue(this.mIsManual), "2", this.mInfo != null ? this.mInfo.getMd5() : "");
        try {
            if (!ErrorsCompat.isNetworkError(errorCode)) {
                FileUtils.deleteQuietly(destFile);
            }
            notifyNotificationIfNonSilent(ErrorsCompat.getErrorMsg(this, errorCode));
        } finally {
            stopForeground(false);
            reset();
        }
    }

    private File getOldApk(Context context) {
        File oldApk = UpdateApk.getOldApkFile(context);
        try {
            if (!TextUtils.equals(UpdateApk.getApkManifestId(oldApk), UpdateApk.getOldApkManifestId(getApplicationContext()))) {
                BLog.i(TAG, "Apply path manifest id mismatch, reprepare old apk file.");
                return UpdateApk.prepareOldApkFile(context);
            }
            return oldApk;
        } catch (Exception e) {
            return oldApk;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPatchDownloaded(final File newFile, final File patchFile) {
        BLog.d(TAG, "Handle after patch downloaded.");
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UpdateService2.this.m1908lambda$onPatchDownloaded$5$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2();
            }
        }).onSuccess(new Continuation() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2$$ExternalSyntheticLambda4
            public final Object then(Task task) {
                return UpdateService2.this.m1909lambda$onPatchDownloaded$6$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2(newFile, patchFile, task);
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2$$ExternalSyntheticLambda5
            public final Object then(Task task) {
                return UpdateService2.this.m1910lambda$onPatchDownloaded$7$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2(newFile, task);
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onPatchDownloaded$5$tv-danmaku-bili-update-internal-network-download-UpdateService2  reason: not valid java name */
    public /* synthetic */ File m1908lambda$onPatchDownloaded$5$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2() throws Exception {
        Context context = getApplicationContext();
        File oldApk = UpdateApk.getOldApkFile(context);
        if (!TextUtils.equals(UpdateApk.getApkManifestId(oldApk), UpdateApk.getOldApkManifestId(getApplicationContext()))) {
            BLog.i(TAG, "Apply path manifest id mismatch, reprepare old apk file.");
            return UpdateApk.prepareOldApkFile(context);
        }
        return oldApk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onPatchDownloaded$6$tv-danmaku-bili-update-internal-network-download-UpdateService2  reason: not valid java name */
    public /* synthetic */ Void m1909lambda$onPatchDownloaded$6$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2(File newFile, File patchFile, Task task) throws Exception {
        File apkWithoutChannel = (File) task.getResult();
        try {
            UpdateApk.archivePatch(apkWithoutChannel, newFile, patchFile);
            FileUtils.deleteQuietly(patchFile);
            if (!BuildConfig.DEBUG && !UpdateApk.checkValidity(this, this.mInfo, newFile)) {
                throw new UpdateError("New apk verify fail.", Errors.ERROR_MERGE_INVALID);
            }
            return null;
        } catch (Throwable th) {
            FileUtils.deleteQuietly(patchFile);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onPatchDownloaded$7$tv-danmaku-bili-update-internal-network-download-UpdateService2  reason: not valid java name */
    public /* synthetic */ Void m1910lambda$onPatchDownloaded$7$tvdanmakubiliupdateinternalnetworkdownloadUpdateService2(File newFile, Task task) throws Exception {
        if (task.isFaulted()) {
            BLog.e(TAG, "Patch failed, try full download.");
            Exception error = task.getError();
            if (error instanceof UpdateError) {
                UpdateError updateError = (UpdateError) error;
                UpdateReporter.reportError(this.mIsSilent, updateError.code, updateError.getLocalizedMessage());
            }
            notifyNotificationIfNonSilent(getString(R.string.update_incremental_fail));
            UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), ConstsKt.ARG_MERGE_INCREMENT_FAILURE);
            NeuronReporterKt.reportUpdateDownload(this.mInfo.versionCode(), this.mIsSilent, ConstsKt.ARG_MERGE_INCREMENT_FAILURE, this.mInfo.getMd5());
            fullUpgrade(this.mInfo, newFile);
            return null;
        }
        UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), "4");
        NeuronReporterKt.reportUpdateDownload(this.mInfo.versionCode(), this.mIsSilent, "4", this.mInfo.getMd5());
        onUpdateSuccess(newFile, this.mInfo);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onPatchSuccess(File destFile, BiliUpgradeInfo upgradeInfo) {
        BLog.i(TAG, "onPatchSuccess");
        boolean error = !UpdateApk.checkValidity(this, this.mInfo, destFile);
        if (error) {
            BLog.e(TAG, "onPatchSuccess checkValidity error");
            notifyNotificationIfNonSilent(getString(R.string.update_incremental_fail));
            UpdateReporterV2.reportUpdateDownload(getDownloadModeReportParam(), ConstsKt.ARG_MERGE_INCREMENT_FAILURE);
            NeuronReporterKt.reportUpdateDownload(this.mInfo.versionCode(), this.mIsSilent, ConstsKt.ARG_MERGE_INCREMENT_FAILURE, this.mInfo.getMd5());
            fullUpgrade(this.mInfo, destFile);
            return;
        }
        onUpdateSuccess(destFile, upgradeInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateSuccess(final File destFile, final BiliUpgradeInfo upgradeInfo) {
        BLog.i(TAG, "On apk downloaded or patched.");
        Task.callInBackground(new Callable<File>() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public File call() throws Exception {
                if (destFile != null && destFile.exists()) {
                    UpdateApk.attachChannelInfo(destFile, upgradeInfo.grayTest());
                }
                return destFile;
            }
        }).continueWith(new Continuation<File, Object>() { // from class: tv.danmaku.bili.update.internal.network.download.UpdateService2.8
            public Object then(Task<File> task) throws Exception {
                try {
                    UpdateService2.this.dismissNotification();
                    UpdateService2.this.tryInstall((File) task.getResult(), false);
                    UpdateService2.this.dismissNotification();
                    UpdateService2.this.reset();
                    UpdateService2.this.stopSelf(UpdateService2.this.mLastStartId);
                    return null;
                } catch (Throwable th) {
                    UpdateService2.this.dismissNotification();
                    UpdateService2.this.reset();
                    UpdateService2.this.stopSelf(UpdateService2.this.mLastStartId);
                    throw th;
                }
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    private void recordApkInfo(File destFile) {
        BLKV.getBLSharedPreferences(getApplicationContext(), SP_APK_STORE_INFO, true, 0).edit().putString(SP_APK_PATH, destFile.getPath()).putBoolean(SP_KEY_APK_IS_SILENT, this.mIsSilent).putBoolean(SP_KEY_APK_IS_MANUAL, this.mIsManual).putString(SP_KEY_APK_INFO_MD5, this.mInfo.getMd5()).putLong(SP_KEY_APK_VERSION_CODE, this.mInfo == null ? 0L : this.mInfo.versionCode()).apply();
    }

    private void removeApkInfo() {
        BLKV.getBLSharedPreferences(getApplicationContext(), SP_APK_STORE_INFO, true, 0).edit().clear().apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void tryInstall(File destFile, boolean isPrepared) {
        recordApkInfo(destFile);
        if (!this.mIsSilent) {
            UpdateReporter.reportUpdate("3");
            UpdateApk.installApk(this, destFile);
            PrefsHelperKt.saveUpdateState(this, isPrepared, this.mIsManual, this.mInfo.getMd5());
            return;
        }
        UpdateReporter.reportUpdateSilent("2");
    }

    protected void reset() {
        this.mIsDownloading = false;
        this.mIsSilent = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onDownloading(int progress, long totalBytes, long downloadedBytes) {
        if (this.mIsSilent) {
            return;
        }
        ensureNotificationBuilder();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        this.mBuilder.setProgress(100, progress, false).setContentInfo(Formatter.formatFileSize(this, downloadedBytes) + EntryScannerKt.PATH_SEPARATOR + Formatter.formatFileSize(this, totalBytes));
        try {
            Notification notification = this.mBuilder.build();
            notification.flags |= 32;
            managerCompat.notify((int) ID_UPDATE_APK, notification);
        } catch (Exception e) {
            BLog.w("Build notification error!", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void ensureNotificationBuilder() {
        if (this.mBuilder == null) {
            this.mBuilder = new NotificationCompat.Builder(this, createNotificationChannelId()).setContentTitle(PackageUtilsKt.getAppName(this)).setContentText(getResources().getString(R.string.update_app_update_downloading)).setContentIntent((PendingIntent) null).setSmallIcon(R.drawable.update_ic_notify_msg);
        }
    }

    private String createNotificationChannelId() {
        if (Build.VERSION.SDK_INT < 26) {
            return "";
        }
        NotificationChannel chan = new NotificationChannel("bili_channel_update", "Apk Update Service", 3);
        chan.setLockscreenVisibility(0);
        chan.setSound(null, null);
        chan.setVibrationPattern(new long[]{0});
        NotificationManager service = (NotificationManager) getSystemService("notification");
        if (service != null) {
            service.createNotificationChannel(chan);
        }
        return "bili_channel_update";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void toastIfNonSilent(int stringId) {
        if (this.mIsSilent) {
            return;
        }
        RuntimeHelper.showToastShort(this, getString(stringId));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void startForegroundIfNonSilent() {
        if (this.mIsSilent) {
            return;
        }
        ensureNotificationBuilder();
        Notification notification = null;
        try {
            notification = this.mBuilder.build();
        } catch (NullPointerException e) {
            BLog.w("Build notification error!", e);
        }
        if (notification != null) {
            ServiceCompat.startForeground(this, (int) ID_UPDATE_APK, notification, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void notifyNotificationIfNonSilent(String msg) {
        if (this.mIsSilent) {
            return;
        }
        PendingIntent notifyPIntent = PendingIntentCompat.getActivity(getApplicationContext(), 0, new Intent(), 0, false);
        try {
            Notification notification = new NotificationCompat.Builder(this, createNotificationChannelId()).setContentTitle(PackageUtilsKt.getAppName(this)).setContentText(msg).setAutoCancel(true).setOngoing(false).setContentIntent(notifyPIntent).setTicker(msg).setSmallIcon(R.drawable.update_ic_notify_msg).build();
            notification.flags &= -33;
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
            managerCompat.notify((int) ID_UPDATE_APK, notification);
        } catch (NullPointerException e) {
            BLog.w("Build notification error!", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void dismissNotification() {
        NotificationManagerCompat.from(this).cancel((int) ID_UPDATE_APK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDownloadModeReportParam() {
        return this.mIsSilent ? "1" : "2";
    }

    private String getIsManualReportParam() {
        return this.mIsManual ? "2" : "1";
    }

    public void onDestroy() {
        stopForeground(true);
        super.onDestroy();
    }
}