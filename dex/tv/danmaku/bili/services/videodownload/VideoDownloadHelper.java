package tv.danmaku.bili.services.videodownload;

import android.content.Context;
import com.bilibili.videodownloader.VideoDownload;
import com.bilibili.videodownloader.VideoDownloadConfig;
import tv.danmaku.bili.services.videodownload.interceptor.VideoDownloadResolveClientCreator;
import tv.danmaku.bili.services.videodownload.monitor.VideoDownloadLoginStateMonitorImpl;
import tv.danmaku.bili.services.videodownload.monitor.VideoDownloadNetworkMonitorImpl;
import tv.danmaku.bili.services.videodownload.monitor.VideoDownloadQuantityMonitorImpl;
import tv.danmaku.bili.services.videodownload.monitor.VideoDownloadReportMonitorImpl;
import tv.danmaku.bili.services.videodownload.monitor.VideoDownloadStateMonitorImpl;
import tv.danmaku.bili.services.videodownload.strategy.ChronosDownloadStrategy;
import tv.danmaku.bili.services.videodownload.strategy.DanmakuDownloadStrategy;
import tv.danmaku.bili.services.videodownload.strategy.DownloadStartSortStrategy;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;

public class VideoDownloadHelper {
    public static void init(Context context) {
        VideoDownloadConfig config = new VideoDownloadConfig.Builder(new VideoDownloadResolveClientCreator(context)).addDownloadStorageStrategy(new VideoDownloadStorageStrategy()).addDownloadStartSortStrategy(new DownloadStartSortStrategy()).addDanmakuDownloadStrategy(new DanmakuDownloadStrategy(context)).addChronosDownloadStrategy(new ChronosDownloadStrategy(context)).addDownloadQualityMonitor(new VideoDownloadQuantityMonitorImpl()).addDownloadStateMonitor(new VideoDownloadStateMonitorImpl()).addDownloadNetworkMonitor(new VideoDownloadNetworkMonitorImpl()).addDownloadReportMonitor(new VideoDownloadReportMonitorImpl()).addDownloadLoginStateMonitor(new VideoDownloadLoginStateMonitorImpl()).build();
        VideoDownload.init(config);
    }
}