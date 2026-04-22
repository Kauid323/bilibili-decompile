package tv.danmaku.bili.update.internal.binder;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.browser.browseractions.BrowserActionsFallbackMenuDialog$;
import com.bilibili.app.updater.R;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.binder.DialogViewBinder;
import tv.danmaku.bili.update.internal.exception.ViewNotFoundException;
import tv.danmaku.bili.update.internal.persist.files.UpdateApk;
import tv.danmaku.bili.update.internal.persist.prefs.PrefsHelperKt;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.bili.update.internal.report.NeuronReporterKt;
import tv.danmaku.bili.update.internal.report.UpdateReporterV2;
import tv.danmaku.bili.update.utils.RuntimeHelper;

/* JADX INFO: Access modifiers changed from: package-private */
public class InstallUpdateDialogDecorator extends DialogViewBinder.Decorator<BinderParams.WifeAutoUpdate> {
    public InstallUpdateDialogDecorator(DialogViewBinder<BinderParams.WifeAutoUpdate> dialogViewBinder) {
        super(dialogViewBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder.Decorator
    public void setBusinessEvent(final Dialog dialog) throws ViewNotFoundException {
        CheckBox cbxCloseWifiAutoDownload = (CheckBox) requireViewById(dialog, R.id.update_cbx_close_wifi_download, "update_cbx_close_wifi_download");
        View positiveBtn = requireViewById(dialog, R.id.update_btn_confirm, "update_btn_confirm");
        View negativeBtn = requireViewById(dialog, R.id.update_btn_cancel, "update_btn_cancel");
        cbxCloseWifiAutoDownload.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.update.internal.binder.InstallUpdateDialogDecorator.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                PrefsHelperKt.setWifiAutoUpdateEnabled(buttonView.getContext(), !isChecked);
            }
        });
        negativeBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.update.internal.binder.InstallUpdateDialogDecorator.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateReporterV2.reportDialogClick("2", "1", "1");
                NeuronReporterKt.reportDialogClick("2", NeuronReporterKt.manualToValue(false), "1", InstallUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                NeuronReporterKt.reportUpdateDialog(InstallUpdateDialogDecorator.this.getUpgradeInfo().versionCode(), true, ConstsKt.ARG_STATE_DIALOG_CLICK_CANCEL, "1", InstallUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                UpdateReporterV2.reportDialogResult("2", "1", "2");
                NeuronReporterKt.reportDialogResult("2", NeuronReporterKt.manualToValue(false), "2", InstallUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookDialogDismiss(dialog);
            }

            private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookDialogDismiss(Object popup) {
                Intrinsics.checkNotNullParameter(popup, "popup");
                if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
                    Thread thread = Thread.currentThread();
                    if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                        IllegalStateException exp = new IllegalStateException("Dialog.dismiss() called from non-UI thread: " + thread + ", 请联系 Jackin");
                        BLog.e("BgThreadUIAccess", "Dialog.dismiss() called from non-UI thread: " + thread, exp);
                        Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new BrowserActionsFallbackMenuDialog$.ExternalSyntheticLambda0());
                        if (BuildConfig.DEBUG) {
                            throw exp;
                        }
                    }
                }
                ((Dialog) popup).dismiss();
            }
        });
        positiveBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.update.internal.binder.InstallUpdateDialogDecorator.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateReporterV2.reportDialogClick("2", "1", "2");
                NeuronReporterKt.reportDialogClick("2", NeuronReporterKt.manualToValue(false), "2", InstallUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                NeuronReporterKt.reportUpdateDialog(InstallUpdateDialogDecorator.this.getUpgradeInfo().versionCode(), true, ConstsKt.ARG_STATE_DIALOG_CLICK_UPDATE, "1", InstallUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                PrefsHelperKt.saveUpdateState(InstallUpdateDialogDecorator.this.getContext(), true, false, InstallUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                UpdateApk.installApk(InstallUpdateDialogDecorator.this.getContext(), InstallUpdateDialogDecorator.this.getUpgradeInfo().getApkPath());
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookDialogDismiss(dialog);
            }

            private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookDialogDismiss(Object popup) {
                Intrinsics.checkNotNullParameter(popup, "popup");
                if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
                    Thread thread = Thread.currentThread();
                    if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                        IllegalStateException exp = new IllegalStateException("Dialog.dismiss() called from non-UI thread: " + thread + ", 请联系 Jackin");
                        BLog.e("BgThreadUIAccess", "Dialog.dismiss() called from non-UI thread: " + thread, exp);
                        Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new BrowserActionsFallbackMenuDialog$.ExternalSyntheticLambda0());
                        if (BuildConfig.DEBUG) {
                            throw exp;
                        }
                    }
                }
                ((Dialog) popup).dismiss();
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.update.internal.binder.InstallUpdateDialogDecorator$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                InstallUpdateDialogDecorator.this.m1882lambda$setBusinessEvent$0$tvdanmakubiliupdateinternalbinderInstallUpdateDialogDecorator(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setBusinessEvent$0$tv-danmaku-bili-update-internal-binder-InstallUpdateDialogDecorator  reason: not valid java name */
    public /* synthetic */ void m1882lambda$setBusinessEvent$0$tvdanmakubiliupdateinternalbinderInstallUpdateDialogDecorator(DialogInterface dialog1) {
        RuntimeHelper.showUpdateNextDialog(false, getContext());
    }
}