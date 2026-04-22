package tv.danmaku.videoplayer.core.media.mediacenter.record;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.videoplayer.core.media.mediacenter.listener.IMediaPlayerLifeCycleListener;

/* compiled from: MediaPlayerRecord.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J)\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Ltv/danmaku/videoplayer/core/media/mediacenter/record/MediaPlayerRecord;", "", X86IjkRequest.POOL, "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "listener", "Ltv/danmaku/videoplayer/core/media/mediacenter/listener/IMediaPlayerLifeCycleListener;", "playerType", "Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;", "<init>", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;Ltv/danmaku/videoplayer/core/media/mediacenter/listener/IMediaPlayerLifeCycleListener;Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;)V", "getPlayer", "()Ltv/danmaku/ijk/media/player/IMediaPlayer;", "getListener", "()Ltv/danmaku/videoplayer/core/media/mediacenter/listener/IMediaPlayerLifeCycleListener;", "setListener", "(Ltv/danmaku/videoplayer/core/media/mediacenter/listener/IMediaPlayerLifeCycleListener;)V", "getPlayerType", "()Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;", "setPlayerType", "(Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;)V", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "copy", "toString", "", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaPlayerRecord {
    private IMediaPlayerLifeCycleListener listener;
    private final IMediaPlayer player;
    private PlayerType playerType;

    public static /* synthetic */ MediaPlayerRecord copy$default(MediaPlayerRecord mediaPlayerRecord, IMediaPlayer iMediaPlayer, IMediaPlayerLifeCycleListener iMediaPlayerLifeCycleListener, PlayerType playerType, int i, Object obj) {
        if ((i & 1) != 0) {
            iMediaPlayer = mediaPlayerRecord.player;
        }
        if ((i & 2) != 0) {
            iMediaPlayerLifeCycleListener = mediaPlayerRecord.listener;
        }
        if ((i & 4) != 0) {
            playerType = mediaPlayerRecord.playerType;
        }
        return mediaPlayerRecord.copy(iMediaPlayer, iMediaPlayerLifeCycleListener, playerType);
    }

    public final IMediaPlayer component1() {
        return this.player;
    }

    public final IMediaPlayerLifeCycleListener component2() {
        return this.listener;
    }

    public final PlayerType component3() {
        return this.playerType;
    }

    public final MediaPlayerRecord copy(IMediaPlayer iMediaPlayer, IMediaPlayerLifeCycleListener iMediaPlayerLifeCycleListener, PlayerType playerType) {
        Intrinsics.checkNotNullParameter(iMediaPlayer, X86IjkRequest.POOL);
        Intrinsics.checkNotNullParameter(playerType, "playerType");
        return new MediaPlayerRecord(iMediaPlayer, iMediaPlayerLifeCycleListener, playerType);
    }

    public String toString() {
        IMediaPlayer iMediaPlayer = this.player;
        IMediaPlayerLifeCycleListener iMediaPlayerLifeCycleListener = this.listener;
        return "MediaPlayerRecord(player=" + iMediaPlayer + ", listener=" + iMediaPlayerLifeCycleListener + ", playerType=" + this.playerType + ")";
    }

    public MediaPlayerRecord(IMediaPlayer player, IMediaPlayerLifeCycleListener listener, PlayerType playerType) {
        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
        Intrinsics.checkNotNullParameter(playerType, "playerType");
        this.player = player;
        this.listener = listener;
        this.playerType = playerType;
    }

    public /* synthetic */ MediaPlayerRecord(IMediaPlayer iMediaPlayer, IMediaPlayerLifeCycleListener iMediaPlayerLifeCycleListener, PlayerType playerType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iMediaPlayer, (i & 2) != 0 ? null : iMediaPlayerLifeCycleListener, (i & 4) != 0 ? PlayerType.Single : playerType);
    }

    public final IMediaPlayer getPlayer() {
        return this.player;
    }

    public final IMediaPlayerLifeCycleListener getListener() {
        return this.listener;
    }

    public final void setListener(IMediaPlayerLifeCycleListener iMediaPlayerLifeCycleListener) {
        this.listener = iMediaPlayerLifeCycleListener;
    }

    public final PlayerType getPlayerType() {
        return this.playerType;
    }

    public final void setPlayerType(PlayerType playerType) {
        Intrinsics.checkNotNullParameter(playerType, "<set-?>");
        this.playerType = playerType;
    }

    public boolean equals(Object other) {
        return (other instanceof MediaPlayerRecord) && Intrinsics.areEqual(this.player, ((MediaPlayerRecord) other).player) && Intrinsics.areEqual(this.listener, ((MediaPlayerRecord) other).listener) && this.playerType == ((MediaPlayerRecord) other).playerType;
    }

    public int hashCode() {
        int hashCode = this.player.hashCode();
        IMediaPlayerLifeCycleListener iMediaPlayerLifeCycleListener = this.listener;
        return hashCode + (iMediaPlayerLifeCycleListener != null ? iMediaPlayerLifeCycleListener.hashCode() : 0);
    }
}