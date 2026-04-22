package tv.danmaku.videoplayer.core.media.mediacenter.creator;

import android.content.Context;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.mediacenter.MediaType;
import tv.danmaku.videoplayer.core.media.mediacenter.config.MediaPlayerConfig;
import tv.danmaku.videoplayer.core.media.mediacenter.factory.IPlayerFactory;
import tv.danmaku.videoplayer.core.media.mediacenter.factory.IjkPlayerFactory;

/* compiled from: MediaPlayerCreator.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/videoplayer/core/media/mediacenter/creator/MediaPlayerCreator;", "", "<init>", "()V", "mPlayerFactoryMap", "Ljava/util/HashMap;", "Ltv/danmaku/videoplayer/core/media/mediacenter/MediaType;", "Ltv/danmaku/videoplayer/core/media/mediacenter/factory/IPlayerFactory;", "Lkotlin/collections/HashMap;", "createMediaPlayer", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "context", "Landroid/content/Context;", "config", "Ltv/danmaku/videoplayer/core/media/mediacenter/config/MediaPlayerConfig;", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaPlayerCreator {
    public static final MediaPlayerCreator INSTANCE = new MediaPlayerCreator();
    private static final HashMap<MediaType, IPlayerFactory> mPlayerFactoryMap = new HashMap<>();

    private MediaPlayerCreator() {
    }

    static {
        mPlayerFactoryMap.put(MediaType.IJK, new IjkPlayerFactory());
    }

    public final IjkMediaPlayer createMediaPlayer(Context context, MediaPlayerConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        IjkPlayerFactory factory = mPlayerFactoryMap.get(config.getMediaType());
        if (factory == null) {
            factory = new IjkPlayerFactory();
        }
        return factory.create(context, config);
    }
}