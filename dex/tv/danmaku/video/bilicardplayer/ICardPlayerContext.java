package tv.danmaku.video.bilicardplayer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.v4.media.session.MediaSessionCompat;
import com.bilibili.playerbizcommon.features.headset.IPlayerHeadsetEventCallback;
import com.bilibili.playerbizcommon.features.headset.MediaSessionControllerCallback;
import com.bilibili.playerbizcommon.features.network.VideoEnvironment;
import com.bilibili.playerbizcommon.gesture.OnDoubleTapListener;
import com.bilibili.playerbizcommon.gesture.OnLongPressListener;
import com.bilibili.playerbizcommon.gesture.OnSingleTapListener;
import com.bilibili.playerbizcommon.mediasession.IMediaSessionPlayback;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.clock.PlayerProgressRangeObserver;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuConfigChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.service.setting.ICloudConfigObserver;
import tv.danmaku.biliplayerv2.utils.PlayerCloudConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;

/* compiled from: CardPlayerContext.kt */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0010H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0012H&J\b\u0010\u0017\u001a\u00020\u000bH&J\b\u0010\u0018\u001a\u00020\u000bH&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0005H&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\n\u0010 \u001a\u0004\u0018\u00010!H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010#\u001a\u00020'H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010#\u001a\u00020'H&J\n\u0010)\u001a\u0004\u0018\u00010*H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0005H&J\b\u0010-\u001a\u00020\u0005H&J\n\u0010.\u001a\u0004\u0018\u00010/H&J\u0010\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0005H&J\b\u00102\u001a\u00020\u0003H&J\b\u00103\u001a\u00020\u000bH&J\u0010\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u000bH&J\u0010\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u000208H&J\b\u00109\u001a\u000208H&J\b\u0010:\u001a\u00020\u0003H&J\b\u0010;\u001a\u00020\u0003H&J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H&J\b\u0010?\u001a\u00020\tH&J$\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020\u00102\b\b\u0002\u0010D\u001a\u00020\u0010H&J\u0010\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020GH&J\b\u0010H\u001a\u00020\u0003H&J@\u0010I\u001a\u00020\u00032\b\u0010J\u001a\u0004\u0018\u00010K2\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010M2\u0010\b\u0002\u0010O\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010M2\b\b\u0002\u0010P\u001a\u00020\u0005H&J\b\u0010Q\u001a\u00020\u0010H&J\b\u0010R\u001a\u00020\u0010H&J\u0010\u0010S\u001a\u00020\u00032\u0006\u0010T\u001a\u00020UH'J\u0010\u0010V\u001a\u00020\u00032\u0006\u0010T\u001a\u00020UH'J\u0010\u0010W\u001a\u00020\u00032\u0006\u0010T\u001a\u00020XH'J\u0010\u0010Y\u001a\u00020\u00032\u0006\u0010T\u001a\u00020XH'J\u0010\u0010Z\u001a\u00020\u00032\u0006\u0010T\u001a\u00020[H&J\u0010\u0010\\\u001a\u00020\u00032\u0006\u0010T\u001a\u00020[H&J \u0010]\u001a\u00020\u00032\u0006\u0010#\u001a\u00020^2\u0006\u0010_\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020\u000bH&J\u0010\u0010a\u001a\u00020\u00032\u0006\u0010#\u001a\u00020^H&J\u0010\u0010b\u001a\u00020\u00032\u0006\u0010#\u001a\u00020cH&J\u0010\u0010d\u001a\u00020\u00032\u0006\u0010#\u001a\u00020cH&J\u0018\u0010e\u001a\u00020\u00032\u000e\u0010f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030gH&J\u0018\u0010h\u001a\u00020\u00032\u000e\u0010f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030gH&J\n\u0010i\u001a\u0004\u0018\u00010jH&J\u0010\u0010k\u001a\u00020\u00032\u0006\u0010l\u001a\u00020mH&J\u0012\u0010n\u001a\u0004\u0018\u00010o2\u0006\u0010p\u001a\u00020\u0005H&J\n\u0010q\u001a\u0004\u0018\u00010rH&J\u0010\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020rH&J\u0012\u0010u\u001a\u00020\u00032\b\u0010A\u001a\u0004\u0018\u00010vH&J\b\u0010w\u001a\u00020\u0003H&J\u0010\u0010x\u001a\u00020\u00032\u0006\u0010y\u001a\u00020\u0010H&J\u0010\u0010z\u001a\u00020\u00032\u0006\u0010{\u001a\u00020\u0005H&J\u0010\u0010|\u001a\u00020\u00032\u0006\u0010}\u001a\u00020\u0005H&J\u001b\u0010~\u001a\u00020\u00032\u0007\u0010\u007f\u001a\u00030\u0080\u00012\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H&J)\u0010\u0083\u0001\u001a\u00020\u00032\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u00052\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010KH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0088\u0001À\u0006\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/ICardPlayerContext;", "", "showDanmaku", "", "fromUser", "", "hideDanmaku", "getDanmakuReportParams", "", "", "getCurrentPosition", "", "getRealCurrentPosition", "replay", "reload", "getPlayerState", "", "getCurrentControlContainerType", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "switchOrientation", "orientation", "setControlContainerType", "type", "getDuration", "getRealDuration", "hideControl", "showControl", "pause", "setAudioOnly", "audioOnly", "resume", "stop", "getVideoEnvironment", "Lcom/bilibili/playerbizcommon/features/network/VideoEnvironment;", "addCloudConfigObserver", "observer", "Ltv/danmaku/biliplayerv2/service/setting/ICloudConfigObserver;", "removeCloudConfigObserver", "addHeadsetEventObserver", "Lcom/bilibili/playerbizcommon/features/headset/IPlayerHeadsetEventCallback;", "removeHeadsetEventObserver", "getPlayerSettingCloudConfig", "Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig;", "setNetworkAlertEnable", "enable", "isNetworkPanelShowed", "getCurrentPlayableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "setMute", "isMute", "allowToContinuePlay", "getBufferedPosition", "seekTo", "targetPosition", "setPlaySpeed", "speed", "", "getPlaySpeed", "hideBufferingView", "showBufferingView", "report", "event", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "getCurrentPlayUrl", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "width", "height", "setAspectRatio", "ratio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "resetVideoFlip", "updateViewPort", "viewPort", "Landroid/graphics/Rect;", "builtInLayers", "", "Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;", "customerLayers", "immediately", "getVideoWidth", "getVideoHeight", "addDoubleTapListener", "listener", "Lcom/bilibili/playerbizcommon/gesture/OnDoubleTapListener;", "removerDoubleTapListener", "addSingleTapListener", "Lcom/bilibili/playerbizcommon/gesture/OnSingleTapListener;", "removerSingleTapListener", "addLongPressListener", "Lcom/bilibili/playerbizcommon/gesture/OnLongPressListener;", "removeLongPressListener", "registerPlayerProgressRangeObserver", "Ltv/danmaku/biliplayerv2/clock/PlayerProgressRangeObserver;", "startPosition", "endPosition", "unregisterPlayerProgressRangeObserver", "registerPlayerProgressObserver", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "unregisterPlayerProgressObserver", "registerChronosMessageHandler", "handler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRequestHandler;", "unregisterChronosMessageHandler", "getChronosRemoteHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;", "setVisibleRect", "visibleRect", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;", "getMediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "autoCreate", "getMediaSessionPlayback", "Lcom/bilibili/playerbizcommon/mediasession/IMediaSessionPlayback;", "setMediaSessionPlayback", "playback", "setMediaSessionControllerCallback", "Lcom/bilibili/playerbizcommon/features/headset/MediaSessionControllerCallback;", "updateMediaSessionPlaybackState", "setRenderViewOffset", "offsetY", "blockBottomChronos", "block", "setDanmakuAvoidScript", "avoidScript", "setSceneAndBizParams", LoginSceneProcessor.SCENE_KEY, "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "biz", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;", "setBackgroundImage", "bitmap", "Landroid/graphics/Bitmap;", "recycle", "rect", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ICardPlayerContext {
    void addCloudConfigObserver(ICloudConfigObserver iCloudConfigObserver);

    @Deprecated(message = "临时的一个解决方案，提供双击事件，后续移除")
    void addDoubleTapListener(OnDoubleTapListener onDoubleTapListener);

    void addHeadsetEventObserver(IPlayerHeadsetEventCallback iPlayerHeadsetEventCallback);

    void addLongPressListener(OnLongPressListener onLongPressListener);

    @Deprecated(message = "临时的一个解决方案，提供点击事件，后续移除")
    void addSingleTapListener(OnSingleTapListener onSingleTapListener);

    void allowToContinuePlay();

    void blockBottomChronos(boolean z);

    long getBufferedPosition();

    IRemoteHandler getChronosRemoteHandler();

    ControlContainerType getCurrentControlContainerType();

    String getCurrentPlayUrl();

    Video.PlayableParams getCurrentPlayableParams();

    long getCurrentPosition();

    Map<String, String> getDanmakuReportParams();

    long getDuration();

    MediaSessionCompat getMediaSession(boolean z);

    IMediaSessionPlayback getMediaSessionPlayback();

    float getPlaySpeed();

    PlayerCloudConfig getPlayerSettingCloudConfig();

    int getPlayerState();

    long getRealCurrentPosition();

    long getRealDuration();

    VideoEnvironment getVideoEnvironment();

    int getVideoHeight();

    int getVideoWidth();

    void hideBufferingView();

    void hideControl();

    void hideDanmaku(boolean z);

    boolean isNetworkPanelShowed();

    void pause();

    void registerChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler);

    void registerPlayerProgressObserver(PlayerProgressObserver playerProgressObserver);

    void registerPlayerProgressRangeObserver(PlayerProgressRangeObserver playerProgressRangeObserver, long j, long j2);

    void reload();

    void removeCloudConfigObserver(ICloudConfigObserver iCloudConfigObserver);

    void removeHeadsetEventObserver(IPlayerHeadsetEventCallback iPlayerHeadsetEventCallback);

    void removeLongPressListener(OnLongPressListener onLongPressListener);

    @Deprecated(message = "临时的一个解决方案，提供双击事件，后续移除")
    void removerDoubleTapListener(OnDoubleTapListener onDoubleTapListener);

    @Deprecated(message = "临时的一个解决方案，提供点击事件，后续移除")
    void removerSingleTapListener(OnSingleTapListener onSingleTapListener);

    void replay();

    void report(NeuronsEvents.Event event);

    void resetVideoFlip();

    void resume();

    void seekTo(long j);

    void setAspectRatio(AspectRatio aspectRatio);

    void setAudioOnly(boolean z);

    void setBackgroundImage(Bitmap bitmap, boolean z, Rect rect);

    void setControlContainerType(ControlContainerType controlContainerType);

    void setDanmakuAvoidScript(boolean z);

    void setMediaSessionControllerCallback(MediaSessionControllerCallback mediaSessionControllerCallback);

    void setMediaSessionPlayback(IMediaSessionPlayback iMediaSessionPlayback);

    void setMute(boolean z);

    void setNetworkAlertEnable(boolean z);

    void setPlaySpeed(float f);

    void setRenderViewOffset(int i);

    void setSceneAndBizParams(ChronosScene chronosScene, ChronosBiz chronosBiz);

    void setVisibleRect(DanmakuConfigChange.VisibleRect visibleRect);

    void showBufferingView();

    void showControl();

    void showDanmaku(boolean z);

    void stop();

    void switchOrientation(int i);

    void takeVideoCapture(IMediaPlayRenderContext.OnTakeVideoCapture onTakeVideoCapture, int i, int i2);

    void unregisterChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler);

    void unregisterPlayerProgressObserver(PlayerProgressObserver playerProgressObserver);

    void unregisterPlayerProgressRangeObserver(PlayerProgressRangeObserver playerProgressRangeObserver);

    void updateMediaSessionPlaybackState();

    void updateViewPort(Rect rect, List<? extends BuiltInLayer> list, List<String> list2, boolean z);

    /* compiled from: CardPlayerContext.kt */
    /* renamed from: tv.danmaku.video.bilicardplayer.ICardPlayerContext$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void showDanmaku$default(ICardPlayerContext iCardPlayerContext, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDanmaku");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            iCardPlayerContext.showDanmaku(z);
        }

        public static /* synthetic */ void hideDanmaku$default(ICardPlayerContext iCardPlayerContext, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideDanmaku");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            iCardPlayerContext.hideDanmaku(z);
        }

        public static /* synthetic */ void takeVideoCapture$default(ICardPlayerContext iCardPlayerContext, IMediaPlayRenderContext.OnTakeVideoCapture onTakeVideoCapture, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeVideoCapture");
            }
            if ((i3 & 2) != 0) {
                i = -1;
            }
            if ((i3 & 4) != 0) {
                i2 = -1;
            }
            iCardPlayerContext.takeVideoCapture(onTakeVideoCapture, i, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void updateViewPort$default(ICardPlayerContext iCardPlayerContext, Rect rect, List list, List list2, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateViewPort");
            }
            if ((i & 2) != 0) {
                list = null;
            }
            if ((i & 4) != 0) {
                list2 = null;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            iCardPlayerContext.updateViewPort(rect, list, list2, z);
        }
    }
}