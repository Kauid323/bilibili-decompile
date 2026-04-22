package tv.danmaku.videoplayer.coreV2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: MediaItem.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000 A*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002ABB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018J\b\u0010\u001c\u001a\u00020\u001aH\u0017J\u0012\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0007J\b\u0010\u001f\u001a\u00020\u001aH\u0017J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001aH\u0016J\b\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020'H\u0016J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020'H\u0016J\b\u0010.\u001a\u00020'H\u0016J\u0012\u0010/\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u000103H\u0016J\u0010\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020)H\u0016J\b\u00106\u001a\u00020)H\u0016J \u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0016J\u000f\u0010;\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020\u0006H&J\b\u0010>\u001a\u00020\u001aH&J\b\u0010?\u001a\u00020\u001aH&J\b\u0010@\u001a\u00020\u001aH&R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/MediaItem;", "REAL", "", "<init>", "()V", "value", "", "isActive", "()Z", "setActive$playercore_debug", "(Z)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "keepAliveRemoveFromPlayer", "getKeepAliveRemoveFromPlayer", "setKeepAliveRemoveFromPlayer", "autoPlayWhenPrepare", "getAutoPlayWhenPrepare", "setAutoPlayWhenPrepare", "mStatusListener", "Ltv/danmaku/videoplayer/coreV2/MediaItem$IStatusListener;", "setStatusListener", "", "listener", "onCreated", "release", "force", "onDestroy", "setIdleBufferInfo", "priority", "Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem$PlayerItemPriority;", "attachedToPlayer", "getPriority", "setItemMaxQn", "maxQn", "", "getRecommendMaxQn", "", "setScreenState", "state", "setAutoQualityMode", "mode", "getAutoQualityMode", "setItemUpdateListener", "l", "Ltv/danmaku/videoplayer/coreV2/OnItemUpdateListener;", "setItemTrackerListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnTrackerListener;", "setStartPosition", "millisecond", "getStartPosition", "setExpectLatency", "latency", "enableSkipFrame", "enableJitterBuffer", "realMediaItem", "()Ljava/lang/Object;", "valid", "start", "stop", "reset", "Companion", "IStatusListener", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class MediaItem<REAL> {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "PlaybackV2::MediaItem";
    private boolean autoPlayWhenPrepare;
    private String id;
    private boolean isActive;
    private boolean keepAliveRemoveFromPlayer;
    private IStatusListener mStatusListener;

    public abstract REAL realMediaItem();

    public abstract void reset();

    public abstract void start();

    public abstract void stop();

    public abstract boolean valid();

    /* compiled from: MediaItem.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/MediaItem$Companion;", "", "<init>", "()V", "TAG", "", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive$playercore_debug(boolean value) {
        this.isActive = value;
        if (value) {
            attachedToPlayer();
            IStatusListener iStatusListener = this.mStatusListener;
            if (iStatusListener != null) {
                iStatusListener.onWillActive(this);
                return;
            }
            return;
        }
        IStatusListener iStatusListener2 = this.mStatusListener;
        if (iStatusListener2 != null) {
            iStatusListener2.onWillInactive(this);
        }
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final boolean getKeepAliveRemoveFromPlayer() {
        return this.keepAliveRemoveFromPlayer;
    }

    public final void setKeepAliveRemoveFromPlayer(boolean z) {
        this.keepAliveRemoveFromPlayer = z;
    }

    public final boolean getAutoPlayWhenPrepare() {
        return this.autoPlayWhenPrepare;
    }

    public final void setAutoPlayWhenPrepare(boolean z) {
        this.autoPlayWhenPrepare = z;
    }

    public final void setStatusListener(IStatusListener listener) {
        this.mStatusListener = listener;
    }

    public void onCreated() {
        IStatusListener iStatusListener = this.mStatusListener;
        if (iStatusListener != null) {
            iStatusListener.onCreated(this);
        }
    }

    public static /* synthetic */ void release$default(MediaItem mediaItem, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: release");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        mediaItem.release(z);
    }

    public final void release(boolean force) {
        if (this.keepAliveRemoveFromPlayer && !force) {
            PlayerLog.i(TAG, "item is hold, should not release");
        } else {
            onDestroy();
        }
    }

    public void onDestroy() {
        this.mStatusListener = null;
    }

    public void setIdleBufferInfo(IjkMediaPlayerItem.PlayerItemPriority priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
    }

    public void attachedToPlayer() {
    }

    public IjkMediaPlayerItem.PlayerItemPriority getPriority() {
        return IjkMediaPlayerItem.PlayerItemPriority.PRIORITY_7;
    }

    public void setItemMaxQn(int maxQn) {
    }

    public long getRecommendMaxQn() {
        return 0L;
    }

    public void setScreenState(int state) {
    }

    public void setAutoQualityMode(int mode) {
    }

    public int getAutoQualityMode() {
        return 0;
    }

    public void setItemUpdateListener(OnItemUpdateListener l) {
    }

    public void setItemTrackerListener(IMediaPlayer.OnTrackerListener l) {
    }

    public void setStartPosition(long millisecond) {
    }

    public long getStartPosition() {
        return 0L;
    }

    public void setExpectLatency(int latency, boolean enableSkipFrame, boolean enableJitterBuffer) {
    }

    /* compiled from: MediaItem.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\u0006\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\u0014\u0010\u0007\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/MediaItem$IStatusListener;", "", "onCreated", "", "item", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "onWillActive", "onWillInactive", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface IStatusListener {
        void onCreated(MediaItem<?> mediaItem);

        void onWillActive(MediaItem<?> mediaItem);

        void onWillInactive(MediaItem<?> mediaItem);

        /* compiled from: MediaItem.kt */
        /* renamed from: tv.danmaku.videoplayer.coreV2.MediaItem$IStatusListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
        }
    }
}