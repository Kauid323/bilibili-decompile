package tv.danmaku.videoplayer.coreV2.adapter.ijk;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkAssetUpdateReason;
import tv.danmaku.ijk.media.player.IjkMediaAsset;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.coreV2.MediaItem;
import tv.danmaku.videoplayer.coreV2.OnItemUpdateListener;

/* compiled from: IjkMediaItem.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\rH\u0016J\b\u0010'\u001a\u00020#H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\rH\u0016J \u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/adapter/ijk/IjkMediaItem;", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem;", "mediaPlayerItem", "listener", "Ltv/danmaku/videoplayer/coreV2/MediaItem$IStatusListener;", "<init>", "(Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem;Ltv/danmaku/videoplayer/coreV2/MediaItem$IStatusListener;)V", "mReleased", "", "mPriority", "Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem$PlayerItemPriority;", "mQualityMode", "", "realMediaItem", "onDestroy", "", "valid", "start", "stop", "reset", "setIdleBufferInfo", "priority", "attachedToPlayer", "getPriority", "setAutoQualityMode", "mode", "getAutoQualityMode", "setItemUpdateListener", "l", "Ltv/danmaku/videoplayer/coreV2/OnItemUpdateListener;", "setItemTrackerListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnTrackerListener;", "setStartPosition", "millisecond", "", "getStartPosition", "setItemMaxQn", "maxQn", "getRecommendMaxQn", "setScreenState", "state", "setExpectLatency", "latency", "enableSkipFrame", "enableJitterBuffer", "Companion", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkMediaItem extends MediaItem<IjkMediaPlayerItem> {
    public static final int BLIJKPlayMode_CM_FREE = 101;
    public static final int BLIJKPlayMode_LIVE = 2;
    public static final int BLIJKPlayMode_OFFLINE = 3;
    public static final int BLIJKPlayMode_PODCAST = 9;
    public static final int BLIJKPlayMode_TELCOM_FREE = 103;
    public static final int BLIJKPlayMode_UNICOM_FREE = 102;
    public static final int BLIJKPlayMode_VOD = 1;
    public static final int BLIJKPlayMode_VOD_LIVE_STORY = 8;
    public static final int BLIJKPlayMode_VOD_LIVE_STORY_CM_FREE = 801;
    public static final int BLIJKPlayMode_VOD_LIVE_STORY_TELCOM_FREE = 803;
    public static final int BLIJKPlayMode_VOD_LIVE_STORY_UNICOM_FREE = 802;
    public static final int BLIJKPlayMode_VOD_STORY = 5;
    public static final int BLIJKPlayMode_VOD_STORY_CM_FREE = 501;
    public static final int BLIJKPlayMode_VOD_STORY_TELCOM_FREE = 503;
    public static final int BLIJKPlayMode_VOD_STORY_UNICOM_FREE = 502;
    public static final Companion Companion = new Companion(null);
    private IjkMediaPlayerItem.PlayerItemPriority mPriority;
    private int mQualityMode;
    private boolean mReleased;
    private final IjkMediaPlayerItem mediaPlayerItem;

    /* compiled from: IjkMediaItem.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/adapter/ijk/IjkMediaItem$Companion;", "", "<init>", "()V", "BLIJKPlayMode_VOD", "", "BLIJKPlayMode_LIVE", "BLIJKPlayMode_CM_FREE", "BLIJKPlayMode_UNICOM_FREE", "BLIJKPlayMode_TELCOM_FREE", "BLIJKPlayMode_OFFLINE", "BLIJKPlayMode_PODCAST", "BLIJKPlayMode_VOD_STORY", "BLIJKPlayMode_VOD_STORY_CM_FREE", "BLIJKPlayMode_VOD_STORY_UNICOM_FREE", "BLIJKPlayMode_VOD_STORY_TELCOM_FREE", "BLIJKPlayMode_VOD_LIVE_STORY", "BLIJKPlayMode_VOD_LIVE_STORY_CM_FREE", "BLIJKPlayMode_VOD_LIVE_STORY_UNICOM_FREE", "BLIJKPlayMode_VOD_LIVE_STORY_TELCOM_FREE", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public IjkMediaItem(IjkMediaPlayerItem mediaPlayerItem, MediaItem.IStatusListener listener) {
        Intrinsics.checkNotNullParameter(mediaPlayerItem, "mediaPlayerItem");
        this.mediaPlayerItem = mediaPlayerItem;
        setStatusListener(listener);
        onCreated();
        this.mPriority = IjkMediaPlayerItem.PlayerItemPriority.PRIORITY_7;
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public IjkMediaPlayerItem realMediaItem() {
        return this.mediaPlayerItem;
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void onDestroy() {
        super.onDestroy();
        this.mReleased = true;
        PlayerLog.i(MediaItem.TAG, "media_player_item#release");
        this.mediaPlayerItem.release();
        this.mediaPlayerItem.setAssetUpdateListener(null);
        this.mediaPlayerItem.setOnTrackerListener(null);
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public boolean valid() {
        return !this.mReleased;
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void start() {
        this.mediaPlayerItem.start();
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void stop() {
        this.mediaPlayerItem.stop();
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void reset() {
        this.mediaPlayerItem.reset();
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void setIdleBufferInfo(IjkMediaPlayerItem.PlayerItemPriority priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (isActive()) {
            BLog.i("++++ current play item, cannot change priority");
        } else if (priority != this.mPriority) {
            this.mPriority = priority;
            if (valid()) {
                this.mediaPlayerItem.setPlayerItemPriority(priority);
            }
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void attachedToPlayer() {
        this.mPriority = IjkMediaPlayerItem.PlayerItemPriority.PRIORITY_7;
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public IjkMediaPlayerItem.PlayerItemPriority getPriority() {
        return this.mPriority;
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void setAutoQualityMode(int mode) {
        this.mQualityMode = mode;
        this.mediaPlayerItem.setStoryMode(mode);
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public int getAutoQualityMode() {
        return this.mQualityMode;
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void setItemUpdateListener(final OnItemUpdateListener l) {
        if (l == null) {
            this.mediaPlayerItem.setAssetUpdateListener(null);
        } else {
            this.mediaPlayerItem.setAssetUpdateListener(new IjkMediaPlayerItem.IjkMediaPlayerItemAssetUpdateListener() { // from class: tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaItem$setItemUpdateListener$1
                @Override // tv.danmaku.ijk.media.player.IjkMediaPlayerItem.IjkMediaPlayerItemAssetUpdateListener
                public IjkMediaAsset onAssetUpdate(IjkAssetUpdateReason reason) {
                    Intrinsics.checkNotNullParameter(reason, "reason");
                    Object onItemUpdate = OnItemUpdateListener.this.onItemUpdate(reason.getReason(), reason.getCurrentNetWork(), reason.getVideoCodecType(), reason.getFormat());
                    if (onItemUpdate instanceof IjkMediaAsset) {
                        return (IjkMediaAsset) onItemUpdate;
                    }
                    return null;
                }

                @Override // tv.danmaku.ijk.media.player.IjkMediaPlayerItem.IjkMediaPlayerItemAssetUpdateListener
                public String onMeteredNetworkUrlHook(String url, IjkNetworkUtils.NetWorkType type, int reasonType) {
                    Intrinsics.checkNotNullParameter(url, "url");
                    return OnItemUpdateListener.this.onMeteredNetworkUrlHook(url, type);
                }
            });
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void setItemTrackerListener(IMediaPlayer.OnTrackerListener l) {
        if (l == null) {
            this.mediaPlayerItem.setOnTrackerListener(null);
        } else {
            this.mediaPlayerItem.setOnTrackerListener(l);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void setStartPosition(long millisecond) {
        this.mediaPlayerItem.setPlayPosition(millisecond);
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public long getStartPosition() {
        return this.mediaPlayerItem.getPlayPosition();
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void setItemMaxQn(int maxQn) {
        this.mediaPlayerItem.setItemMaxQn(maxQn);
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public long getRecommendMaxQn() {
        return this.mediaPlayerItem.getRecommendedQn();
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void setScreenState(int state) {
        this.mediaPlayerItem.setScreenState(state);
    }

    @Override // tv.danmaku.videoplayer.coreV2.MediaItem
    public void setExpectLatency(int latency, boolean enableSkipFrame, boolean enableJitterBuffer) {
        this.mediaPlayerItem.setExpectLatency(latency, enableSkipFrame ? 1 : 0, enableJitterBuffer ? 1 : 0);
    }
}