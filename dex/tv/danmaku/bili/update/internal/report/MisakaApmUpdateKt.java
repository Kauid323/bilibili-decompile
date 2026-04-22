package tv.danmaku.bili.update.internal.report;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.update.api.ReportTracker;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MisakaApmUpdate.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"MISAKA_APM_LOGID_UPDATE", "", "report", "", "data", "", "", "updater_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MisakaApmUpdateKt {
    private static final long MISAKA_APM_LOGID_UPDATE = 100009;

    public static final void report(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        ReportTracker reportTracker = RuntimeHelper.getReportTracker();
        if (reportTracker != null) {
            reportTracker.trackT(false, "ops.misaka.app-update", map, new Function0() { // from class: tv.danmaku.bili.update.internal.report.MisakaApmUpdateKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    boolean report$lambda$0;
                    report$lambda$0 = MisakaApmUpdateKt.report$lambda$0();
                    return Boolean.valueOf(report$lambda$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$0() {
        return true;
    }
}