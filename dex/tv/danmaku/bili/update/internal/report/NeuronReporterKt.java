package tv.danmaku.bili.update.internal.report;

import androidx.collection.ArrayMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.api.ReportTracker;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: NeuronReporter.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u001ak\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\u0010\u0014\u001a\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a0\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0019\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u000e\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000b\u001a\"\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0000\u001a*\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0000\u001a*\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0000\u001a2\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\"\u001a\u00020\u000fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"TAG", "", "EVENT_UPDATE_DOWNLOAD", "EVENT_DIALOG_SHOW", "EVENT_DIALOG_CLICK", "EVENT_UPDATE_RESULT", "reportUpdateDownload", "", "version", "", "silent", "", "state", "md5", "patchType", "", "isPatchDegrade", "patchDownloadFailed", "patchError", "downloadErrorCode", "(JZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "reportUpdateDialog", "trackParams", "Ltv/danmaku/bili/update/internal/report/TrackParams;", "trigger", "silentToValue", "manualToValue", "manual", "reportDialogShow", "packageReady", "reportDialogClick", "button", "reportDialogResult", "result", "is32To64Int", "updater_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NeuronReporterKt {
    private static final String EVENT_DIALOG_CLICK = "app.update.prompt.0.click";
    private static final String EVENT_DIALOG_SHOW = "app.update.prompt.0.show";
    private static final String EVENT_UPDATE_DOWNLOAD = "app.update.download.sys";
    private static final String EVENT_UPDATE_RESULT = "app.update.result.sys";
    private static final String TAG = "fawkes.update.reporter";

    public static final void reportUpdateDownload(long j, boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "state");
        reportUpdateDownload$default(j, z, str, str2, null, null, null, null, null, 496, null);
    }

    public static final void reportUpdateDownload(long j, boolean z, String str, String str2, Integer num) {
        Intrinsics.checkNotNullParameter(str, "state");
        reportUpdateDownload$default(j, z, str, str2, num, null, null, null, null, 480, null);
    }

    public static final void reportUpdateDownload(long j, boolean z, String str, String str2, Integer num, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "state");
        reportUpdateDownload$default(j, z, str, str2, num, bool, null, null, null, 448, null);
    }

    public static final void reportUpdateDownload(long j, boolean z, String str, String str2, Integer num, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, "state");
        reportUpdateDownload$default(j, z, str, str2, num, bool, bool2, null, null, 384, null);
    }

    public static final void reportUpdateDownload(long j, boolean z, String str, String str2, Integer num, Boolean bool, Boolean bool2, String str3) {
        Intrinsics.checkNotNullParameter(str, "state");
        reportUpdateDownload$default(j, z, str, str2, num, bool, bool2, str3, null, IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN, null);
    }

    public static /* synthetic */ void reportUpdateDownload$default(long j, boolean z, String str, String str2, Integer num, Boolean bool, Boolean bool2, String str3, Integer num2, int i, Object obj) {
        reportUpdateDownload(j, z, str, str2, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : bool2, (i & 128) != 0 ? null : str3, (i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? null : num2);
    }

    public static final void reportUpdateDownload(long version, boolean silent, String state, String md5, Integer patchType, Boolean isPatchDegrade, Boolean patchDownloadFailed, String patchError, Integer downloadErrorCode) {
        Intrinsics.checkNotNullParameter(state, "state");
        BLog.vfmt(TAG, "Report EVENT_UPDATE_DOWNLOAD silent=%b, state=%s.", new Object[]{Boolean.valueOf(silent), state});
        HashMap extra = new HashMap();
        extra.put("silent", silentToValue(silent));
        extra.put("state", state);
        extra.put("target_version", String.valueOf(version));
        extra.put("info_md5", md5 == null ? "" : md5);
        extra.put("is32_to_64", String.valueOf(RuntimeHelper.INSTANCE.is32To64Int$updater_debug()));
        if (patchType != null) {
            int it = patchType.intValue();
            extra.put("patch_type", String.valueOf(it));
        }
        if (isPatchDegrade != null) {
            boolean it2 = isPatchDegrade.booleanValue();
            extra.put("patch_degrade", it2 ? "1" : "0");
        }
        if (patchDownloadFailed != null) {
            boolean it3 = patchDownloadFailed.booleanValue();
            extra.put("patch_download_failed", it3 ? "1" : "0");
        }
        if (patchError != null) {
            extra.put("patch_error", patchError);
        }
        if (downloadErrorCode != null) {
            int it4 = downloadErrorCode.intValue();
            extra.put("download_error_code", String.valueOf(it4));
        }
        ReportTracker reportTracker = RuntimeHelper.getReportTracker();
        if (reportTracker != null) {
            reportTracker.report(false, 4, EVENT_UPDATE_DOWNLOAD, extra);
        }
        MisakaApmUpdateKt.report(extra);
    }

    public static final void reportUpdateDialog(TrackParams trackParams) {
        Intrinsics.checkNotNullParameter(trackParams, "trackParams");
        BLog.vfmt(TAG, "reportUpdateDialog： trackParams=" + trackParams, new Object[0]);
        MisakaApmUpdateKt.report(trackParams.toMap());
    }

    public static final void reportUpdateDialog(long version, boolean silent, String state, String trigger, String md5) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(md5, "md5");
        BLog.vfmt(TAG, "reportUpdateDialog： version=%s,silent=%b, state=%s.", new Object[]{Long.valueOf(version), Boolean.valueOf(silent), state});
        HashMap extra = new HashMap();
        extra.put("silent", silentToValue(silent));
        extra.put("state", state);
        extra.put("target_version", String.valueOf(version));
        extra.put("trigger", trigger);
        extra.put("info_md5", md5);
        extra.put("is32_to_64", String.valueOf(RuntimeHelper.INSTANCE.is32To64Int$updater_debug()));
        MisakaApmUpdateKt.report(extra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String silentToValue(boolean silent) {
        return silent ? "1" : "2";
    }

    public static final String manualToValue(boolean manual) {
        return manual ? "2" : "1";
    }

    public static final void reportDialogShow(String packageReady, String trigger, String md5) {
        Intrinsics.checkNotNullParameter(packageReady, "packageReady");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        BLog.vfmt(TAG, "Report EVENT_DIALOG_SHOW package=%s, trigger=%s.", new Object[]{packageReady, trigger});
        HashMap extra = new HashMap();
        extra.put("package", packageReady);
        extra.put("trigger", trigger);
        extra.put("info_md5", md5 == null ? "" : md5);
        extra.put("is32_to_64", String.valueOf(RuntimeHelper.INSTANCE.is32To64Int$updater_debug()));
        ReportTracker reportTracker = RuntimeHelper.getReportTracker();
        if (reportTracker != null) {
            reportTracker.reportExposure(false, EVENT_DIALOG_SHOW, extra);
        }
    }

    public static final void reportDialogClick(String packageReady, String trigger, String button, String md5) {
        Intrinsics.checkNotNullParameter(packageReady, "packageReady");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(button, "button");
        BLog.vfmt(TAG, "Report EVENT_DIALOG_CLICK package=%s, trigger=%s, button=%s.", new Object[]{packageReady, trigger, button});
        HashMap extra = new HashMap();
        extra.put("package", packageReady);
        extra.put("trigger", trigger);
        extra.put("button", button);
        extra.put("info_md5", md5 == null ? "" : md5);
        extra.put("is32_to_64", String.valueOf(RuntimeHelper.INSTANCE.is32To64Int$updater_debug()));
        ReportTracker reportTracker = RuntimeHelper.getReportTracker();
        if (reportTracker != null) {
            reportTracker.reportClick(false, EVENT_DIALOG_CLICK, extra);
        }
    }

    public static final void reportDialogResult(String packageReady, String trigger, String result, String md5) {
        Intrinsics.checkNotNullParameter(packageReady, "packageReady");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(result, "result");
        reportDialogResult(packageReady, trigger, result, md5, RuntimeHelper.INSTANCE.is32To64Int$updater_debug());
    }

    public static final void reportDialogResult(String packageReady, String trigger, String result, String md5, int is32To64Int) {
        Intrinsics.checkNotNullParameter(packageReady, "packageReady");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(result, "result");
        BLog.vfmt(TAG, "Report EVENT_UPDATE_RESULT package=%s, trigger=%s, result=%s.", new Object[]{packageReady, trigger, result});
        Map<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put("package", packageReady);
        arrayMap.put("trigger", trigger);
        arrayMap.put("result", result);
        arrayMap.put("info_md5", md5 == null ? "" : md5);
        arrayMap.put("is32_to_64", String.valueOf(is32To64Int));
        ReportTracker reportTracker = RuntimeHelper.getReportTracker();
        if (reportTracker != null) {
            reportTracker.report(false, 4, EVENT_UPDATE_RESULT, arrayMap);
        }
        Map arrayMap2 = new ArrayMap();
        arrayMap2.put("package", packageReady);
        arrayMap2.put("trigger", trigger);
        arrayMap2.put("result", result);
        arrayMap2.put("info_md5", md5 != null ? md5 : "");
        arrayMap2.put("state", ConstsKt.ARG_UPDATE_RESULT);
        arrayMap2.put("is32_to_64", String.valueOf(is32To64Int));
        MisakaApmUpdateKt.report(arrayMap2);
    }
}