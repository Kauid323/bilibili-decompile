package tv.danmaku.bili.report.startup.v2;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.danmaku.bili.report.startup.v2.Reporter;

/* compiled from: ReportArgsFilterHolder.java */
class SplashTimeFilter implements Reporter.IReportArgsFilter {
    @Override // tv.danmaku.bili.report.startup.v2.Reporter.IReportArgsFilter
    public void filteReportList(CopyOnWriteArrayList<Reporter.ReportArgs> reportArgs) {
        Reporter.ReportArgs startArgs = null;
        Reporter.ReportArgs splashArgs = null;
        Reporter.ReportArgs extraArgs = null;
        Reporter.ReportArgs startShowArgs = null;
        Reporter.ReportArgs appInitArgs = null;
        Reporter.ReportArgs realStartShowArgs = null;
        Iterator<Reporter.ReportArgs> it = reportArgs.iterator();
        while (it.hasNext()) {
            Reporter.ReportArgs item = it.next();
            if ("StartUp".equalsIgnoreCase(item.mModuleName)) {
                startArgs = item;
            } else if (BootTagHolder.TAG_APP_INIT.equalsIgnoreCase(item.mModuleName)) {
                appInitArgs = item;
            } else if (BootTagHolder.TAG_SP_SHOW.equalsIgnoreCase(item.mModuleName)) {
                splashArgs = item;
            } else if (BootTagHolder.TAG_SP_DURATION.equalsIgnoreCase(item.mModuleName)) {
                extraArgs = item;
                reportArgs.remove(item);
            } else if (BootTagHolder.TAG_SP_REAL_DURATION.equalsIgnoreCase(item.mModuleName)) {
                reportArgs.remove(item);
            } else if (BootTagHolder.TAG_START_SHOW.equalsIgnoreCase(item.mModuleName)) {
                startShowArgs = item;
            } else if (BootTagHolder.TAG_REAL_START_SHOW.equalsIgnoreCase(item.mModuleName)) {
                realStartShowArgs = item;
            }
        }
        if (extraArgs != null) {
            if (startArgs != null) {
                startArgs.mExtraTime = extraArgs.mDuration;
            }
            if (splashArgs != null) {
                splashArgs.mExtraTime = extraArgs.mDuration;
            }
        }
        if (startShowArgs != null) {
            startShowArgs.mExtraField = String.valueOf(startShowArgs.mDuration);
            startShowArgs.mSelfStart = StartShowRecorder.isSelfStart() ? 1 : 0;
        }
        if (realStartShowArgs != null) {
            realStartShowArgs.mExtraField = String.valueOf(StartShowRecorder.getBrandSplashDuration());
            realStartShowArgs.mSelfStart = StartShowRecorder.isSelfStart() ? 1 : 0;
        }
        if (appInitArgs != null) {
            appInitArgs.mSelfStart = StartShowRecorder.isSelfStart() ? 1 : 0;
        }
        if (startArgs != null) {
            startArgs.mSelfStart = StartShowRecorder.isSelfStart() ? 1 : 0;
        }
    }
}