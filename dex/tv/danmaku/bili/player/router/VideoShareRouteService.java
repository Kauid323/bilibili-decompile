package tv.danmaku.bili.player.router;

import com.bilibili.playerbizcommon.IVideoShareRouteService;
import com.bilibili.playerbizcommon.share.VideoShareCounter;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: VideoShareRouteService.kt */
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/player/router/VideoShareRouteService;", "Lcom/bilibili/playerbizcommon/IVideoShareRouteService;", "<init>", "()V", "generateShareSession", "", "reportShareClick", "", "params", "Lcom/bilibili/playerbizcommon/IVideoShareRouteService$ShareCountParams;", AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bilibili/playerbizcommon/IVideoShareRouteService$IShareReportCallback;", "reportShareComplete", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Named("video_share")
public final class VideoShareRouteService implements IVideoShareRouteService {
    public static final int $stable = 0;

    public String generateShareSession() {
        return VideoShareCounter.INSTANCE.generateShareSession();
    }

    public void reportShareClick(IVideoShareRouteService.ShareCountParams params, IVideoShareRouteService.IShareReportCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        VideoShareCounter.INSTANCE.requestShareStart(params, callback);
    }

    public void reportShareComplete(IVideoShareRouteService.ShareCountParams params, IVideoShareRouteService.IShareReportCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        VideoShareCounter.INSTANCE.requestShareSuccess(params, callback);
    }
}