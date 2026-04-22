package tv.danmaku.videoplayer.core.media.mediacenter.factory;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.videoplayer.core.media.mediacenter.config.MediaPlayerConfig;

/* compiled from: IjkPlayerFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ltv/danmaku/videoplayer/core/media/mediacenter/factory/IjkPlayerFactory;", "Ltv/danmaku/videoplayer/core/media/mediacenter/factory/IPlayerFactory;", "<init>", "()V", "create", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "context", "Landroid/content/Context;", "config", "Ltv/danmaku/videoplayer/core/media/mediacenter/config/MediaPlayerConfig;", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkPlayerFactory implements IPlayerFactory {
    @Override // tv.danmaku.videoplayer.core.media.mediacenter.factory.IPlayerFactory
    public IjkMediaPlayer create(Context context, MediaPlayerConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.getUseExternalRender()) {
            BiliRenderContext.init(context);
        }
        return new IjkMediaPlayer(config.getIjkLibLoader(), context, config.getUseExternalRender(), config.getStartPlayerService());
    }
}