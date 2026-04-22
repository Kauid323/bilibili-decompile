package tv.danmaku.bili.report;

import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.oaid.MsaHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DelayReportForOaid.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/report/DelayReportForOaid;", "", "<init>", "()V", "delayIfNeed", "", "report", "Lkotlin/Function0;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DelayReportForOaid {
    public static final int $stable = 0;
    public static final DelayReportForOaid INSTANCE = new DelayReportForOaid();

    private DelayReportForOaid() {
    }

    public final void delayIfNeed(final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "report");
        if (EnvironmentManager.getInstance().isFirstStart()) {
            if ((MsaHelper.getOaid().length() == 0) && Intrinsics.areEqual(ConfigManager.Companion.ab().get("delay_startup_report_for_oaid", false), true)) {
                String str = (String) ConfigManager.Companion.config().get("oaid.oppo_delay_time", "10000");
                long delayTime = str != null ? Long.parseLong(str) : 10000L;
                HandlerThreads.getHandler(2).postDelayed(new Runnable() { // from class: tv.danmaku.bili.report.DelayReportForOaid$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        function0.invoke();
                    }
                }, delayTime);
                return;
            }
        }
        function0.invoke();
    }
}