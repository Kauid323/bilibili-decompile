package tv.danmaku.bili.player.router;

import com.bilibili.playerbizcommon.IVideoLikeRouteService;
import com.bilibili.playerbizcommon.action.VideoLikeActionHelper;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: VideoLikeRouteService.kt */
@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/player/router/VideoLikeRouteService;", "Lcom/bilibili/playerbizcommon/IVideoLikeRouteService;", "<init>", "()V", "reportActionLike", "", "polymer", "Lcom/bilibili/playerbizcommon/IVideoLikeRouteService$ActionLikePolymer;", AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bilibili/playerbizcommon/IVideoLikeRouteService$ActionLikeCallback;", "reportActionDislike", "Lcom/bilibili/playerbizcommon/IVideoLikeRouteService$ActionDislikePolymer;", "reportActionLikeTriple", "Lcom/bilibili/playerbizcommon/IVideoLikeRouteService$ActionLikeTriplePolymer;", "Lcom/bilibili/playerbizcommon/IVideoLikeRouteService$ActionLikeTripleCallback;", "reportActionLikeNologin", "Lcom/bilibili/playerbizcommon/IVideoLikeRouteService$ActionLikeNologinPolymer;", "Lcom/bilibili/playerbizcommon/IVideoLikeRouteService$ActionLikeNologinCallback;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Named("video_like")
public final class VideoLikeRouteService implements IVideoLikeRouteService {
    public static final int $stable = 0;

    public void reportActionLike(IVideoLikeRouteService.ActionLikePolymer polymer, IVideoLikeRouteService.ActionLikeCallback callback) {
        Intrinsics.checkNotNullParameter(polymer, "polymer");
        Intrinsics.checkNotNullParameter(callback, AuthResultCbHelper.ARGS_CALLBACK);
        VideoLikeActionHelper.INSTANCE.requestActionLike(polymer, callback);
    }

    public void reportActionDislike(IVideoLikeRouteService.ActionDislikePolymer polymer, IVideoLikeRouteService.ActionLikeCallback callback) {
        Intrinsics.checkNotNullParameter(polymer, "polymer");
        Intrinsics.checkNotNullParameter(callback, AuthResultCbHelper.ARGS_CALLBACK);
        VideoLikeActionHelper.INSTANCE.requestActionDislike(polymer, callback);
    }

    public void reportActionLikeTriple(IVideoLikeRouteService.ActionLikeTriplePolymer polymer, IVideoLikeRouteService.ActionLikeTripleCallback callback) {
        Intrinsics.checkNotNullParameter(polymer, "polymer");
        Intrinsics.checkNotNullParameter(callback, AuthResultCbHelper.ARGS_CALLBACK);
        VideoLikeActionHelper.INSTANCE.requestActionLikeTriple(polymer, callback);
    }

    public void reportActionLikeNologin(IVideoLikeRouteService.ActionLikeNologinPolymer polymer, IVideoLikeRouteService.ActionLikeNologinCallback callback) {
        Intrinsics.checkNotNullParameter(polymer, "polymer");
        Intrinsics.checkNotNullParameter(callback, AuthResultCbHelper.ARGS_CALLBACK);
        VideoLikeActionHelper.INSTANCE.requestActionLikeUnLogin(polymer, callback);
    }
}