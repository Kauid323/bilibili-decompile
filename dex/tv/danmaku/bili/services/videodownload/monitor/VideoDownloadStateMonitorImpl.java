package tv.danmaku.bili.services.videodownload.monitor;

import android.app.Service;
import android.content.Context;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.utils.monitor.VideoDownloadStateMonitor;
import tv.danmaku.bili.services.videodownload.utils.VideoDownloadNotificationHelper;

public class VideoDownloadStateMonitorImpl implements VideoDownloadStateMonitor {
    private VideoDownloadNotificationHelper mNotificationHelper;

    public void notifyDownloadState(Context context, VideoDownloadEntry entry) {
        if (this.mNotificationHelper == null) {
            this.mNotificationHelper = VideoDownloadNotificationHelper.initHelper(context);
        }
        this.mNotificationHelper.notifyDownloadState(entry);
    }

    public void notifyDownloadStateForForeground(Service service, VideoDownloadEntry entry) {
        VideoDownloadNotificationHelper.notifyEntryForForeground(service, entry);
    }

    public void notifyDownloadErrorPrompter(Context context, int errorCode) {
        VideoDownloadNotificationHelper.notifyDownloadErrorPrompter(context, errorCode);
    }
}