package tv.danmaku.videoplayer.coreV2;

import kotlin.Metadata;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface;
import tv.danmaku.videoplayer.coreV2.IMediaPlayContext;

/* compiled from: IMediaPlayControlContext.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0014\u0010\b\u001a\u00020\u00032\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0014H&J\b\u0010\u0018\u001a\u00020\u0014H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001dH&J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u0012\u0010!\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\"H&J\u0012\u0010#\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010$H&J\u0012\u0010%\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010&H&J\u0012\u0010'\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010(H&J\u0012\u0010)\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010*H&J\u0012\u0010+\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010,H&J\u0012\u0010-\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010.H&J\b\u0010/\u001a\u00020\u000eH&J\b\u00100\u001a\u00020\u0014H&J\n\u00101\u001a\u0004\u0018\u000102H&J$\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u0002052\b\b\u0002\u00107\u001a\u000205H&J$\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00162\b\b\u0002\u0010:\u001a\u0002052\b\b\u0002\u0010;\u001a\u000205H&J\b\u0010<\u001a\u00020\u0016H&J\u0010\u0010=\u001a\u00020\u00032\u0006\u00104\u001a\u000205H&J\b\u0010>\u001a\u000205H&J\b\u0010?\u001a\u000205H&J\u0012\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u0016H&J\b\u0010C\u001a\u00020\u000eH&J\b\u0010D\u001a\u000205H&J\u0010\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u000205H&J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u0016H&J\u0012\u0010I\u001a\u00020\u00032\b\u0010J\u001a\u0004\u0018\u00010KH&J\n\u0010L\u001a\u0004\u0018\u00010MH&J\n\u0010N\u001a\u0004\u0018\u00010AH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006OÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/IMediaPlayControlContext;", "", "init", "", "params", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayParams;", "updatePlayParams", "release", "setMediaItem", "mediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "removeMediaItem", "setVolume", "left", "", "right", "resume", "pause", "seekTo", "position", "", "accurate", "", "getDuration", "getCurrentPosition", "setOnPreparedListener", "l", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "setOnCompletionListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "setOnInfoListener", "listener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "setOnErrorListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "setOnSeekComplete", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "setPlayerClockChangedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPlayerClockChangedListener;", "setFirstFrameListener", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$OnFirstFrameListener;", "setOnBufferingUpdateListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;", "setOnMediaStreamChangedListener", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext$OnMediaStreamChangedListener;", "setOnRawDataWriteListener", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer$OnRawDataWriteListener;", "getSpeed", "getBufferedPosition", "getSupportQualities", "", "setVideoStream", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "", "min", "max", "setDashAuto", "flag", "minQuality", "maxQuality", "getDashAuto", "setAudioStream", "getCurrentVideoStream", "getCurrentAudioStream", "getCurrentPlayUrl", "", "isAudio", "getVideoFps", "getBufferControl", "setBufferControl", "type", "setLooping", "looping", "setOnVideoDisplayCallback", "callback", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer$OnVideoDisplayCallback;", "getMediaInfo", "Ltv/danmaku/ijk/media/player/MediaInfo;", "getPlayFailReason", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMediaPlayControlContext {
    int getBufferControl();

    long getBufferedPosition();

    int getCurrentAudioStream();

    String getCurrentPlayUrl(boolean z);

    long getCurrentPosition();

    int getCurrentVideoStream();

    boolean getDashAuto();

    long getDuration();

    MediaInfo getMediaInfo();

    String getPlayFailReason();

    float getSpeed();

    int[] getSupportQualities();

    float getVideoFps();

    void init(IMediaPlayParams iMediaPlayParams);

    void pause();

    void release();

    void removeMediaItem(MediaItem<?> mediaItem);

    void resume();

    void seekTo(long j);

    void seekTo(long j, boolean z);

    void setAudioStream(int i);

    void setBufferControl(int i);

    void setDashAuto(boolean z, int i, int i2);

    void setFirstFrameListener(IJKEXTRendererInterface.OnFirstFrameListener onFirstFrameListener);

    void setLooping(boolean z);

    void setMediaItem(MediaItem<?> mediaItem);

    void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener);

    void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener);

    void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener);

    void setOnMediaStreamChangedListener(IMediaPlayContext.OnMediaStreamChangedListener onMediaStreamChangedListener);

    void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener);

    void setOnRawDataWriteListener(IjkMediaPlayer.OnRawDataWriteListener onRawDataWriteListener);

    void setOnSeekComplete(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoDisplayCallback(IjkMediaPlayer.OnVideoDisplayCallback onVideoDisplayCallback);

    void setPlayerClockChangedListener(IMediaPlayer.OnPlayerClockChangedListener onPlayerClockChangedListener);

    void setVideoStream(int i, int i2, int i3);

    void setVolume(float f, float f2);

    void updatePlayParams(IMediaPlayParams iMediaPlayParams);

    /* compiled from: IMediaPlayControlContext.kt */
    /* renamed from: tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext$-CC */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void seekTo$default(IMediaPlayControlContext iMediaPlayControlContext, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: seekTo");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iMediaPlayControlContext.seekTo(j, z);
        }

        public static /* synthetic */ void setVideoStream$default(IMediaPlayControlContext iMediaPlayControlContext, int i, int i2, int i3, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setVideoStream");
            }
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = 0;
            }
            iMediaPlayControlContext.setVideoStream(i, i2, i3);
        }

        public static /* synthetic */ void setDashAuto$default(IMediaPlayControlContext iMediaPlayControlContext, boolean z, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDashAuto");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            iMediaPlayControlContext.setDashAuto(z, i, i2);
        }

        public static /* synthetic */ String getCurrentPlayUrl$default(IMediaPlayControlContext iMediaPlayControlContext, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return iMediaPlayControlContext.getCurrentPlayUrl(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCurrentPlayUrl");
        }
    }
}