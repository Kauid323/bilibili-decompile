package tv.danmaku.bili.update.internal.binder;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.browser.browseractions.BrowserActionsFallbackMenuDialog$;
import androidx.core.app.ActivityCompat$;
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
import tv.danmaku.bili.update.internal.UpdaterKt;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.binder.DialogViewBinder;
import tv.danmaku.bili.update.internal.exception.ViewNotFoundException;
import tv.danmaku.bili.update.internal.persist.prefs.PrefsHelperKt;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.bili.update.internal.report.NeuronReporterKt;
import tv.danmaku.bili.update.internal.report.UpdateReporter;
import tv.danmaku.bili.update.internal.report.UpdateReporterV2;
import tv.danmaku.bili.update.utils.RuntimeHelper;

/* JADX INFO: Access modifiers changed from: package-private */
public class DownloadUpdateDialogDecorator extends DialogViewBinder.Decorator<BinderParams.ManualUpdate> {
    private boolean mJumpToOtherPage;

    public DownloadUpdateDialogDecorator(DialogViewBinder<BinderParams.ManualUpdate> dialogViewBinder) {
        super(dialogViewBinder);
    }

    public boolean isManual() {
        return ((BinderParams.ManualUpdate) this.mBindParams).isManual();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder.Decorator
    public void setBusinessEvent(final Dialog dialog) throws ViewNotFoundException {
        CheckBox cbxIgnoreVersion = (CheckBox) requireViewById(dialog, R.id.update_cbx_ignore_version, "update_cbx_ignore_version");
        View positiveBtn = requireViewById(dialog, R.id.update_btn_confirm, "update_btn_confirm");
        View negativeBtn = requireViewById(dialog, R.id.update_btn_cancel, "update_btn_cancel");
        cbxIgnoreVersion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.update.internal.binder.DownloadUpdateDialogDecorator.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    PrefsHelperKt.setIgnoreVersion(DownloadUpdateDialogDecorator.this.getContext(), DownloadUpdateDialogDecorator.this.getUpgradeInfo().versionCode());
                } else {
                    PrefsHelperKt.setIgnoreVersion(DownloadUpdateDialogDecorator.this.getContext(), 0);
                }
            }
        });
        if (getUpgradeInfo().forceUpgrade()) {
            negativeBtn.setVisibility(8);
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: tv.danmaku.bili.update.internal.binder.DownloadUpdateDialogDecorator.2
                private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
                        Thread thread = Thread.currentThread();
                        if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                            IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                            BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                            Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                            if (BuildConfig.DEBUG) {
                                throw exp;
                            }
                        }
                    }
                    ((Activity) activity).finish();
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialog2, int keyCode, KeyEvent event) {
                    if (DownloadUpdateDialogDecorator.this.getContext() != null || !DownloadUpdateDialogDecorator.this.getContext().isFinishing()) {
                        dialog2.dismiss();
                        __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(DownloadUpdateDialogDecorator.this.getContext());
                    }
                    return keyCode == 4;
                }
            });
        } else {
            negativeBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.update.internal.binder.DownloadUpdateDialogDecorator.3
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

                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    UpdateReporterV2.reportDialogClick("1", NeuronReporterKt.manualToValue(DownloadUpdateDialogDecorator.this.isManual()), "1");
                    NeuronReporterKt.reportDialogClick("1", NeuronReporterKt.manualToValue(DownloadUpdateDialogDecorator.this.isManual()), "1", DownloadUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                    NeuronReporterKt.reportUpdateDialog(DownloadUpdateDialogDecorator.this.getUpgradeInfo().versionCode(), false, ConstsKt.ARG_STATE_DIALOG_CLICK_CANCEL, NeuronReporterKt.manualToValue(DownloadUpdateDialogDecorator.this.isManual()), DownloadUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                    UpdateReporterV2.reportDialogResult("1", NeuronReporterKt.manualToValue(DownloadUpdateDialogDecorator.this.isManual()), "2");
                    NeuronReporterKt.reportDialogResult("1", NeuronReporterKt.manualToValue(DownloadUpdateDialogDecorator.this.isManual()), "2", DownloadUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                    __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookDialogDismiss(dialog);
                }
            });
        }
        positiveBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.update.internal.binder.DownloadUpdateDialogDecorator.4
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

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateReporter.reportUpdate("2");
                UpdateReporterV2.reportDialogClick("1", NeuronReporterKt.manualToValue(DownloadUpdateDialogDecorator.this.isManual()), "2");
                NeuronReporterKt.reportDialogClick("1", NeuronReporterKt.manualToValue(DownloadUpdateDialogDecorator.this.isManual()), "2", DownloadUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                NeuronReporterKt.reportUpdateDialog(DownloadUpdateDialogDecorator.this.getUpgradeInfo().versionCode(), false, ConstsKt.ARG_STATE_DIALOG_CLICK_UPDATE, NeuronReporterKt.manualToValue(DownloadUpdateDialogDecorator.this.isManual()), DownloadUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                DownloadUpdateDialogDecorator.this.mJumpToOtherPage = UpdaterKt.doUpgrade(DownloadUpdateDialogDecorator.this.getContext(), DownloadUpdateDialogDecorator.this.getUpgradeInfo(), DownloadUpdateDialogDecorator.this.isManual());
                if (!DownloadUpdateDialogDecorator.this.getUpgradeInfo().forceUpgrade()) {
                    __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookDialogDismiss(dialog);
                }
            }
        });
        if (!isManual()) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.update.internal.binder.DownloadUpdateDialogDecorator$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DownloadUpdateDialogDecorator.this.m1881lambda$setBusinessEvent$0$tvdanmakubiliupdateinternalbinderDownloadUpdateDialogDecorator(dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setBusinessEvent$0$tv-danmaku-bili-update-internal-binder-DownloadUpdateDialogDecorator  reason: not valid java name */
    public /* synthetic */ void m1881lambda$setBusinessEvent$0$tvdanmakubiliupdateinternalbinderDownloadUpdateDialogDecorator(DialogInterface dialog1) {
        RuntimeHelper.showUpdateNextDialog(this.mJumpToOtherPage, getContext());
    }
}