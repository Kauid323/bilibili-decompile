package tv.danmaku.bili.report.biz.api.consume;

import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.okretro.tracker.ApiTracker;
import tv.danmaku.bili.report.biz.api.consume.consumer.infoeyes.ApiInfoEyesFilter;
import tv.danmaku.bili.report.biz.api.produce.APIQualityTrackerImpl;
import tv.danmaku.bili.report.biz.api.produce.model.RequestEvent;
import tv.danmaku.bili.report.platform.infoeyes.TaskIdConst;

@Deprecated
public class APIQualityReporter implements ApiTracker.Factory {
    static final APIQualityReporter instance = new APIQualityReporter();

    public static APIQualityReporter getInstance() {
        return instance;
    }

    public static void reportToAll(RequestEvent event, Long misakaLogId) {
        if (!ApiInfoEyesFilter.filter(event)) {
            InfoEyesManager.getInstance().report2(false, TaskIdConst.TABLE_APP_API_LOG, event.asArgs());
        }
        if (ConnectivityMonitor.getInstance().getNetwork() == 3) {
            event.recycle();
        }
    }

    public ApiTracker getTracker() {
        return new APIQualityTrackerImpl();
    }
}