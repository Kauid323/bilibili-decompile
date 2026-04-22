package tv.danmaku.bili.ui.freedata.tracer;

import com.bilibili.fd_service.FreeDataConfig;
import com.bilibili.fd_service.monitor.FdError;
import com.bilibili.fd_service.monitor.FdMonitor;
import java.util.concurrent.atomic.AtomicInteger;

public class FdMonitorImpl implements FdMonitor {
    private static final int MAX_REPORT_COUNT = 20;
    private AtomicInteger currentReportCount = new AtomicInteger(0);

    public void onError(FdError error) {
        if (error == null || this.currentReportCount.addAndGet(1) > 20) {
            return;
        }
        FreeDataConfig.getTechnologyReporter().errorReport(error.toMap());
    }
}