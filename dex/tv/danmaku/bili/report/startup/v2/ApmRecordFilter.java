package tv.danmaku.bili.report.startup.v2;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.danmaku.bili.report.startup.StartupApm;
import tv.danmaku.bili.report.startup.v2.Reporter;

/* compiled from: ReportArgsFilterHolder.java */
class ApmRecordFilter implements Reporter.IReportArgsFilter {
    @Override // tv.danmaku.bili.report.startup.v2.Reporter.IReportArgsFilter
    public void filteReportList(CopyOnWriteArrayList<Reporter.ReportArgs> reportArgs) {
        Iterator<Reporter.ReportArgs> it = reportArgs.iterator();
        while (it.hasNext()) {
            Reporter.ReportArgs arg = it.next();
            StartUpUtilsKt.startUpTrace("filterReportList ReportArgs = " + arg.toLogString());
            if ("StartUp".equalsIgnoreCase(arg.mModuleName)) {
                StartupApm.setStartupTime(arg.mDuration);
            } else if (BootTagHolder.TAG_APP_INIT.equalsIgnoreCase(arg.mModuleName)) {
                StartupApm.setAppTime(arg.mDuration);
            } else if (BootTagHolder.TAG_SP_SHOW.equalsIgnoreCase(arg.mModuleName)) {
                StartupApm.setSplashTime(arg.mDuration);
            } else if (BootTagHolder.TAG_START_SHOW.equalsIgnoreCase(arg.mModuleName)) {
                StartupApm.setStartShowTime(arg.mDuration);
            }
        }
    }
}