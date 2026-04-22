package tv.danmaku.bili.services.videodownload.interceptor;

import android.content.Context;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.media.resolver2.MediaResolveClientV2;
import com.bilibili.videodownloader.manager.Cancelable;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.resolver.playurl.IDashFreeDataResolver;
import com.bilibili.videodownloader.resolver.playurl.IMediaResolveClientCreator;

public class VideoDownloadResolveClientCreator implements IMediaResolveClientCreator {
    private Context mContext;

    public VideoDownloadResolveClientCreator(Context context) {
        this.mContext = context;
    }

    public MediaResolveClientV2 createV2(VideoDownloadEntry entry, Cancelable cancelCheck) {
        MediaResolveClientV2.Builder builder = new MediaResolveClientV2.Builder();
        return builder.build();
    }

    public IDashFreeDataResolver getDashFreeDataResolver(VideoDownloadEntry entry) {
        boolean supportFreeData = !FreeDataManager.getInstance().isFreeDataForbade(this.mContext, FreeDataManager.ForbadeType.VIDEO_DOWNLOAD);
        if (supportFreeData) {
            supportFreeData = entry.mSupportFd;
        }
        return new FreeDataDashResolver(supportFreeData);
    }
}