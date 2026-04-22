package tv.danmaku.bili.services.videodownload.monitor;

import android.content.Context;
import com.bilibili.videodownloader.utils.log.LogHelper;
import com.bilibili.videodownloader.utils.monitor.VideoDownloadQuantityMonitor;
import tv.danmaku.bili.services.videodownload.utils.VideoDownloadProvider;

public class VideoDownloadQuantityMonitorImpl implements VideoDownloadQuantityMonitor {
    private static final String TAG = "VideoDownloadQualityListenerImpl";

    public void notifyChanged(Context context, int completedCount, int totalCount) {
        LogHelper.i(TAG, "manager update provider, total:%d, completed:%d", new Object[]{Integer.valueOf(totalCount), Integer.valueOf(completedCount)});
        VideoDownloadProvider.Notifier.update(context, totalCount, totalCount - completedCount, completedCount);
    }

    public void notifyDestroy(Context context) {
        VideoDownloadProvider.Notifier.onServiceDestroy(context);
    }
}