package tv.danmaku.bili.update.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import com.bilibili.app.updater.R;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.SharedPrefX;
import java.io.File;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.internal.network.download.UpdateService2;
import tv.danmaku.bili.update.internal.persist.files.UpdateApk;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.bili.update.internal.report.NeuronReporterKt;

public class InstallCheckHelper {
    private static boolean mJumpToInstallPage = false;
    private static String UP_TAG = "check_updater_install";

    public static void checkUpdaterInstall(final Context mContext) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                SharedPrefX bLSharedPreferences = BLKV.getBLSharedPreferences(mContext, UpdateService2.SP_APK_STORE_INFO, true, 0);
                if (bLSharedPreferences.contains(UpdateService2.SP_APK_PATH)) {
                    String apkPath = bLSharedPreferences.getString(UpdateService2.SP_APK_PATH, "");
                    final boolean isSilent = bLSharedPreferences.getBoolean(UpdateService2.SP_KEY_APK_IS_SILENT, false);
                    final boolean isManual = bLSharedPreferences.getBoolean(UpdateService2.SP_KEY_APK_IS_MANUAL, false);
                    final long versionCode = bLSharedPreferences.getLong(UpdateService2.SP_KEY_APK_VERSION_CODE, 0L);
                    final String infoMd5 = bLSharedPreferences.getString(UpdateService2.SP_KEY_APK_INFO_MD5, "");
                    Log.i(UP_TAG, "apk_path:" + apkPath);
                    if (!TextUtils.isEmpty(apkPath)) {
                        bLSharedPreferences.edit().clear().apply();
                        final File apkFile = new File(apkPath);
                        if (apkFile.exists()) {
                            String fname = apkFile.getName();
                            String version = fname.split("\\.")[0];
                            Log.i(UP_TAG, "apk_version:" + version + ",runtime_verison:" + RuntimeHelper.versionCode());
                            if (Integer.parseInt(version) <= RuntimeHelper.versionCode()) {
                                Log.i(UP_TAG, "delete apk file");
                                FileUtils.deleteQuietly(apkFile);
                            } else {
                                Log.i(UP_TAG, "show update dialog");
                                final AlertDialog installDialog = new AlertDialog.Builder(mContext).setMessage(R.string.update_check_install).setPositiveButton(R.string.update_install, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.update.utils.InstallCheckHelper.2
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialog, int which) {
                                        InstallCheckHelper.mJumpToInstallPage = true;
                                        UpdateApk.installApk(mContext, apkFile);
                                        NeuronReporterKt.reportUpdateDialog(versionCode, isSilent, ConstsKt.ARG_STATE_DIALOG_CLICK_UPDATE, NeuronReporterKt.manualToValue(isManual), infoMd5);
                                    }
                                }).setNegativeButton(R.string.update_cancel, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.update.utils.InstallCheckHelper.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialog, int which) {
                                        InstallCheckHelper.mJumpToInstallPage = false;
                                        NeuronReporterKt.reportUpdateDialog(versionCode, isSilent, ConstsKt.ARG_STATE_DIALOG_CLICK_CANCEL, NeuronReporterKt.manualToValue(isManual), infoMd5);
                                    }
                                }).create();
                                installDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.update.utils.InstallCheckHelper$$ExternalSyntheticLambda0
                                    @Override // android.content.DialogInterface.OnDismissListener
                                    public final void onDismiss(DialogInterface dialogInterface) {
                                        InstallCheckHelper.lambda$checkUpdaterInstall$0(mContext, dialogInterface);
                                    }
                                });
                                RuntimeHelper.addInstallCheckDialog(mContext, new Runnable() { // from class: tv.danmaku.bili.update.utils.InstallCheckHelper$$ExternalSyntheticLambda1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        installDialog.show();
                                    }
                                });
                                NeuronReporterKt.reportUpdateDialog(versionCode, isSilent, ConstsKt.ARG_STATE_DIALOG_SHOW, NeuronReporterKt.manualToValue(isManual), infoMd5);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.e(UP_TAG, "Exception:" + e.toString());
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$checkUpdaterInstall$0(Context mContext, DialogInterface dialog) {
        BLog.i(UP_TAG, String.format("checkUpdaterInstall: show next dialog: %b", Boolean.valueOf(mJumpToInstallPage)));
        RuntimeHelper.showInstallCheckNextDialog(mJumpToInstallPage, mContext);
    }
}