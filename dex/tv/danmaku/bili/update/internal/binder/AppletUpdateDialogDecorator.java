package tv.danmaku.bili.update.internal.binder;

import android.app.Dialog;
import android.os.Looper;
import android.view.View;
import androidx.browser.browseractions.BrowserActionsFallbackMenuDialog$;
import com.bilibili.app.updateapi.ButtonClickListener;
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
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.bili.update.internal.report.NeuronReporterKt;
import tv.danmaku.bili.update.internal.report.UpdateReporter;
import tv.danmaku.bili.update.internal.report.UpdateReporterV2;

public class AppletUpdateDialogDecorator extends DialogViewBinder.Decorator<BinderParams.AppletUpdate> {
    public AppletUpdateDialogDecorator(DialogViewBinder<BinderParams.AppletUpdate> dialogViewBinder) {
        super(dialogViewBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder.Decorator
    public void setBusinessEvent(final Dialog dialog) throws ViewNotFoundException {
        View positiveBtn = requireViewById(dialog, R.id.update_btn_confirm, "update_btn_confirm");
        View negativeBtn = requireViewById(dialog, R.id.update_btn_cancel, "update_btn_cancel");
        negativeBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.update.internal.binder.AppletUpdateDialogDecorator.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateReporterV2.reportDialogClick("1", "3", "1");
                NeuronReporterKt.reportDialogClick("1", "3", "1", AppletUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                NeuronReporterKt.reportUpdateDialog(AppletUpdateDialogDecorator.this.getUpgradeInfo().versionCode(), false, ConstsKt.ARG_STATE_DIALOG_CLICK_CANCEL, "3", AppletUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                UpdateReporterV2.reportDialogResult("1", "3", "2");
                NeuronReporterKt.reportDialogResult("1", "3", "2", AppletUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                ButtonClickListener buttonClickListener = ((BinderParams.AppletUpdate) AppletUpdateDialogDecorator.this.mBindParams).getButtonClickListener();
                if (buttonClickListener != null) {
                    buttonClickListener.onNegativeClick();
                }
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
        positiveBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.update.internal.binder.AppletUpdateDialogDecorator.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                UpdateReporter.reportUpdate("2");
                UpdateReporterV2.reportDialogClick("1", "3", "2");
                NeuronReporterKt.reportDialogClick("1", "3", "2", AppletUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                NeuronReporterKt.reportUpdateDialog(AppletUpdateDialogDecorator.this.getUpgradeInfo().versionCode(), false, ConstsKt.ARG_STATE_DIALOG_CLICK_UPDATE, "3", AppletUpdateDialogDecorator.this.getUpgradeInfo().getMd5());
                UpdaterKt.doUpgrade(AppletUpdateDialogDecorator.this.getContext(), AppletUpdateDialogDecorator.this.getUpgradeInfo(), true);
                ButtonClickListener buttonClickListener = ((BinderParams.AppletUpdate) AppletUpdateDialogDecorator.this.mBindParams).getButtonClickListener();
                if (buttonClickListener != null) {
                    buttonClickListener.onPositiveClick();
                }
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
    }
}