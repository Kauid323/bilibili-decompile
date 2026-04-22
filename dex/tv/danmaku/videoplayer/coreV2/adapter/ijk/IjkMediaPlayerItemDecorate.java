package tv.danmaku.videoplayer.coreV2.adapter.ijk;

import android.content.Context;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkLibLoader;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;

/* compiled from: IjkMediaPlayerItemDecorate.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/adapter/ijk/IjkMediaPlayerItemDecorate;", "Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem;", "libLoader", "Ltv/danmaku/ijk/media/player/IjkLibLoader;", "context", "Landroid/content/Context;", "looper", "Landroid/os/Looper;", "scheme", "", "defaultAudioStream", "defaultVideoStream", "<init>", "(Ltv/danmaku/ijk/media/player/IjkLibLoader;Landroid/content/Context;Landroid/os/Looper;III)V", "getDefaultAudioStream", "()I", "getDefaultVideoStream", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkMediaPlayerItemDecorate extends IjkMediaPlayerItem {
    private final int defaultAudioStream;
    private final int defaultVideoStream;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IjkMediaPlayerItemDecorate(IjkLibLoader libLoader, Context context, Looper looper, int scheme, int defaultAudioStream, int defaultVideoStream) {
        super(libLoader, context, looper, scheme);
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultAudioStream = defaultAudioStream;
        this.defaultVideoStream = defaultVideoStream;
    }

    public final int getDefaultAudioStream() {
        return this.defaultAudioStream;
    }

    public final int getDefaultVideoStream() {
        return this.defaultVideoStream;
    }
}