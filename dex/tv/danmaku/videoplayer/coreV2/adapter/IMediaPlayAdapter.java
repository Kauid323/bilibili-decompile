package tv.danmaku.videoplayer.coreV2.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext;
import tv.danmaku.videoplayer.coreV2.IMediaPlayParams;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;
import tv.danmaku.videoplayer.coreV2.MediaItem;

/* compiled from: IMediaPlayAdapter.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H&J'\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001a\u001a\u00020\u0018H&J\b\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter;", "", "init", "", "params", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayParams;", "release", "getMediaPlayControlContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayControlContext;", "getMediaPlayRenderContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "supported", "", "mediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "getMediaPlayer", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "supportOperator", "op", "Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter$Ops;", "invokeOp", "T", "(Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter$Ops;Ljava/lang/Object;)Ljava/lang/Object;", "type", "", "getDefaultAudioIndex", "getCurrentAudioIndex", "getAudioStreamsIndex", "", "setAudioIndex", "index", "Ops", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMediaPlayAdapter {

    /* compiled from: IMediaPlayAdapter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b)\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)¨\u0006*"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter$Ops;", "", "<init>", "(Ljava/lang/String;I)V", "OpSwitchSpeed", "GetTcpSpeed", "SetAudioOnly", "EnterWholeScene", "ExitWholeScene", "NotifyWholeSceneOffset", "SupportWholeScene", "NotifyScreenOrientation", "CloseSensorGyroscope", "OpenSensorGyroscope", "ResetGyroscope", "OpenExternalRender", "CloseExternalRender", "PerformVisibilityChanged", "SwitchDaltonismMode", "SetBlurRectList", "ClearBlurRect", "SetOnNativeInvokeListener", "GetAudioCachedDuration", "GetVideoCachedDuration", "GetCacheCurTcpSpeed", "GetCacheCurBitrate", "GetDropFrame", "GetAvDiff", "GetItemError", "GetPlayerError", "UpdateDns", "LiveLowLatencyPlay", "SetIjkSeiCallBack", "SetIjkDownloadSeiCallBack", "IjkFlushCache", "GetIjkPlayerItemStopExtera", "GetIjkPlayerFisrtPkgTracker", "SetIsAbleLowLatency", "SetExpectLatency", "SetIjkGuid", "NotifyStreamLessQnChange", "NotifyLiveP2PPlayUrlChange", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum Ops {
        OpSwitchSpeed,
        GetTcpSpeed,
        SetAudioOnly,
        EnterWholeScene,
        ExitWholeScene,
        NotifyWholeSceneOffset,
        SupportWholeScene,
        NotifyScreenOrientation,
        CloseSensorGyroscope,
        OpenSensorGyroscope,
        ResetGyroscope,
        OpenExternalRender,
        CloseExternalRender,
        PerformVisibilityChanged,
        SwitchDaltonismMode,
        SetBlurRectList,
        ClearBlurRect,
        SetOnNativeInvokeListener,
        GetAudioCachedDuration,
        GetVideoCachedDuration,
        GetCacheCurTcpSpeed,
        GetCacheCurBitrate,
        GetDropFrame,
        GetAvDiff,
        GetItemError,
        GetPlayerError,
        UpdateDns,
        LiveLowLatencyPlay,
        SetIjkSeiCallBack,
        SetIjkDownloadSeiCallBack,
        IjkFlushCache,
        GetIjkPlayerItemStopExtera,
        GetIjkPlayerFisrtPkgTracker,
        SetIsAbleLowLatency,
        SetExpectLatency,
        SetIjkGuid,
        NotifyStreamLessQnChange,
        NotifyLiveP2PPlayUrlChange;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Ops> getEntries() {
            return $ENTRIES;
        }
    }

    int[] getAudioStreamsIndex();

    int getCurrentAudioIndex();

    int getDefaultAudioIndex();

    IMediaPlayControlContext getMediaPlayControlContext();

    IMediaPlayRenderContext getMediaPlayRenderContext();

    IMediaPlayer getMediaPlayer();

    void init(IMediaPlayParams iMediaPlayParams);

    <T> T invokeOp(Ops ops, Object obj);

    void release();

    int setAudioIndex(int i);

    boolean supportOperator(Ops ops);

    boolean supported(MediaItem<?> mediaItem);

    int type();
}