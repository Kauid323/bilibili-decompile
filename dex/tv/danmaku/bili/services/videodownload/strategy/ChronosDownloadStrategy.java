package tv.danmaku.bili.services.videodownload.strategy;

import android.content.Context;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.utils.strategy.IChronosDownloadStrategy;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.download.ChronosOfflineDownloader;
import tv.danmaku.videoplayer.coreV2.VideoBizType;

public class ChronosDownloadStrategy implements IChronosDownloadStrategy {
    private final ChronosOfflineDownloader mChronosOfflineDownloader = new ChronosOfflineDownloader();
    private final Context mContext;

    public ChronosDownloadStrategy(Context context) {
        this.mContext = context;
    }

    public String getChronosDownloadUrl(String avid, String cid, VideoDownloadEntry entryData) {
        VideoBizType type = entryData != null ? entryData.getType() : VideoBizType.UNKNOWN;
        return this.mChronosOfflineDownloader.getChronosPackageUrlFromAvid(avid, cid, type);
    }

    public String getChronosMd5(String avid, String cid, VideoDownloadEntry entryData) {
        VideoBizType type = entryData != null ? entryData.getType() : VideoBizType.UNKNOWN;
        return this.mChronosOfflineDownloader.getChronosMd5FromAvid(avid, cid, type);
    }

    public void clear() {
        this.mChronosOfflineDownloader.clear();
    }
}