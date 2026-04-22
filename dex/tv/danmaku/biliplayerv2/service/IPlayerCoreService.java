package tv.danmaku.biliplayerv2.service;

import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.resource.PlayerCodecConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.clock.PlayerProgressRangeObserver;
import tv.danmaku.biliplayerv2.service.lock.DisablePlayLock;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaAsset;
import tv.danmaku.videoplayer.coreV2.IMediaPlayContext;
import tv.danmaku.videoplayer.coreV2.IMediaPlayParams;
import tv.danmaku.videoplayer.coreV2.MediaItem;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;
import tv.danmaku.videoplayer.coreV2.transformer.P2PParams;

/* compiled from: IPlayerCoreService.kt */
@Metadata(d1 = {"\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u0000 ¿\u00012\u00020\u0001:\u0002¿\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00020\t\"\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u001a\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH&J\"\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H&J.\u0010!\u001a\u00020\u00052\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(2\u0006\u0010)\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H&J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0003H&J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0003H&J$\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u0003H&J\b\u00101\u001a\u00020\u001bH&J\u001a\u00102\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H&J\b\u00103\u001a\u00020\u001bH&J\b\u00104\u001a\u00020\u0003H&J\u0012\u00105\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u000106H&J\b\u00107\u001a\u00020\u0003H&J\b\u00108\u001a\u00020\u0003H&J\u0012\u00109\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010:H&J\b\u0010;\u001a\u00020\u0003H&J\b\u0010<\u001a\u00020=H&J\b\u0010>\u001a\u00020\u0003H&J\b\u0010?\u001a\u00020\u001bH&J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001bH&J\b\u0010B\u001a\u00020\u001bH&J\b\u0010C\u001a\u00020\u001bH&J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001bH&J\b\u0010E\u001a\u00020\u001bH&J\u0012\u0010F\u001a\u00020=2\b\b\u0002\u0010G\u001a\u00020\u001bH&J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020=H&J\u000f\u0010J\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0002\u0010KJ\n\u0010L\u001a\u0004\u0018\u00010MH&J\b\u0010N\u001a\u00020\u0005H&J\u0010\u0010O\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020PH&J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020PH&J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020SH&J\u0010\u0010T\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020SH&J\u0010\u0010U\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020VH&J\u0010\u0010W\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020VH&J\u0010\u0010X\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020YH&J\u0010\u0010Z\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020YH&J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\\H&J\u0010\u0010]\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\\H&J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020_H&J\u0010\u0010`\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020_H&J\u0010\u0010a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020bH&J\u0010\u0010c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020bH&J\u0010\u0010d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020eH&J\u0010\u0010f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020eH&J\n\u0010g\u001a\u0004\u0018\u00010#H&J\u0010\u0010h\u001a\u00020\u00052\u0006\u0010)\u001a\u00020#H&J\u0010\u0010i\u001a\u00020\u00052\u0006\u0010j\u001a\u00020kH&J\u0010\u0010l\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020mH&J\u0010\u0010n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020mH&J\b\u0010o\u001a\u00020\u001bH&J\n\u0010p\u001a\u0004\u0018\u00010qH&J\u0010\u0010r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020sH&J\u0010\u0010t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020sH&J\u0010\u0010u\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020vH&J\u0010\u0010w\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020vH&J\u0012\u0010x\u001a\u00020\u00052\b\u0010y\u001a\u0004\u0018\u00010zH&J\u0012\u0010{\u001a\u00020\u00052\b\u0010y\u001a\u0004\u0018\u00010|H&J\n\u0010}\u001a\u0004\u0018\u00010|H&J\u0010\u0010~\u001a\u00020\u00052\u0006\u0010\u007f\u001a\u00020\u001bH&J\u001b\u0010\u0080\u0001\u001a\u00020\u00052\u0007\u0010\u0081\u0001\u001a\u00020=2\u0007\u0010\u0082\u0001\u001a\u00020=H&J\u0016\u0010\u0083\u0001\u001a\u000f\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=0\u0084\u0001H&J\u0012\u0010\u0085\u0001\u001a\u00020\u00052\u0007\u0010\u0006\u001a\u00030\u0086\u0001H&J\u0012\u0010\u0087\u0001\u001a\u00020\u00052\u0007\u0010\u0006\u001a\u00030\u0086\u0001H&J\n\u0010\u0088\u0001\u001a\u00030\u0089\u0001H&J\u001f\u0010\u008a\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010(2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020#H&J\u0013\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020MH&J\u0013\u0010\u008e\u0001\u001a\u00020\u00052\b\u0010\u008f\u0001\u001a\u00030\u008c\u0001H&J\u0014\u0010\u0090\u0001\u001a\u00020\u00052\t\u0010y\u001a\u0005\u0018\u00010\u0091\u0001H&J)\u0010\u0092\u0001\u001a\u00020\u001b2\u000e\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0094\u00012\u000e\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0094\u0001H&J\u000f\u0010\u0096\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010(H&J\u0012\u0010\u0097\u0001\u001a\u00020\u00052\u0007\u0010\u0098\u0001\u001a\u00020\u0003H&J\u0014\u0010\u0099\u0001\u001a\u00030\u0089\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H&J\u0015\u0010\u009c\u0001\u001a\u00020\u00052\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H&J\f\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u0001H&J\u0014\u0010 \u0001\u001a\u00020M2\t\b\u0002\u0010¡\u0001\u001a\u00020\u001bH&J\t\u0010¢\u0001\u001a\u00020=H&J\u0012\u0010£\u0001\u001a\u00020\u00052\u0007\u0010¤\u0001\u001a\u00020\u001bH&J\u0012\u0010¥\u0001\u001a\u00020\u00052\u0007\u0010\u0006\u001a\u00030¦\u0001H&J\u0012\u0010§\u0001\u001a\u00020\u00052\u0007\u0010\u0006\u001a\u00030¦\u0001H&J&\u0010¨\u0001\u001a\u00020\u00052\u0007\u0010\u0006\u001a\u00030©\u00012\b\u0010ª\u0001\u001a\u00030\u0089\u00012\b\u0010«\u0001\u001a\u00030\u0089\u0001H&J\u0012\u0010¬\u0001\u001a\u00020\u00052\u0007\u0010\u0006\u001a\u00030©\u0001H&J\t\u0010\u00ad\u0001\u001a\u00020\u001bH&J\u0016\u0010®\u0001\u001a\u0005\u0018\u00010¯\u00012\b\u0010°\u0001\u001a\u00030±\u0001H&J\u0013\u0010²\u0001\u001a\u00020\u00052\b\u0010³\u0001\u001a\u00030¯\u0001H&J\u0012\u0010´\u0001\u001a\u00020\u00052\u0007\u0010µ\u0001\u001a\u00020\u001bH&J\t\u0010¶\u0001\u001a\u00020\u001bH&J\t\u0010·\u0001\u001a\u00020\u0003H&J\t\u0010¸\u0001\u001a\u00020\u0003H&J\t\u0010¹\u0001\u001a\u00020\tH&J\t\u0010º\u0001\u001a\u00020\u0003H&J\u001a\u0010»\u0001\u001a\u00020\u00032\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0003\u0010½\u0001J\t\u0010¾\u0001\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006À\u0001À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "", "getState", "", "registerState", "", "observer", "Ltv/danmaku/biliplayerv2/service/PlayerStateObserver;", "states", "", "unregisterState", "registerSeekObserver", "Ltv/danmaku/biliplayerv2/service/PlayerSeekObserver;", "unregisterSeekObserver", "registerBufferingState", "Ltv/danmaku/biliplayerv2/service/BufferingObserver;", "unregisterBufferingState", "registerPlayerErrorObserver", "Ltv/danmaku/biliplayerv2/service/PlayerErrorObserver;", "unregisterPlayerErrorObserver", "play", "pause", "resume", "stop", "seekTo", "position", "accurate", "", "interceptSeekTarget", "addSeekInterceptor", "interceptor", "Ltv/danmaku/biliplayerv2/service/ISeekInterceptor;", "removeSeekInterceptor", "setMediaResource", "resource", "Lcom/bilibili/lib/media/resource/MediaResource;", "autoStart", "itemParams", "Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams;", "mediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "mediaResource", "supportQuality", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "switchQuality", "setDashAuto", "flag", "minQuality", "maxQuality", "getDashAuto", "switchAutoQuality", "isThirdPlayer", "getDuration", "setDurationInterceptor", "Ltv/danmaku/biliplayerv2/service/IDurationInterceptor;", "getRealDuration", "getCurrentPosition", "setCurrentPositionInterceptor", "Ltv/danmaku/biliplayerv2/service/ICurrentPositionInterceptor;", "getRealCurrentPosition", "getBufferedPercentage", "", "getCurrentQuality", "supportMiniPlayer", "setMiniPlayerAvailable", "available", "isMiniPlayerAvailable", "supportProjectionScreen", "setProjectionScreenAvailable", "isProjectionScreenAvailable", "getPlaySpeed", "forceFromNative", "setPlaySpeed", "speed", "isVariableResolutionRatio", "()Ljava/lang/Boolean;", "getPlayFailReason", "", "removeCurrentSource", "addPlayerLoopObserver", "Ltv/danmaku/biliplayerv2/service/IPlayerLoopObserver;", "removePlayerLoopObserver", "addPlayerSpeedChangedObserver", "Ltv/danmaku/biliplayerv2/service/IPlayerSpeedChangedObserver;", "removePlayerSpeedChangedObserver", "addPlayerClockChangedObserver", "Ltv/danmaku/biliplayerv2/service/IPlayerClockChangedObserver;", "removePlayerClockChangedObserver", "addPlayerOnRawDataWriteObserver", "Ltv/danmaku/biliplayerv2/service/OnRawDataWriteObserver;", "removePlayerOnRawDataWriteObserver", "addPlayerOnTrackInfoObserver", "Ltv/danmaku/biliplayerv2/service/OnTrackInfoObserver;", "removePlayerOnTrackInfoObserver", "addPlayerReleaseObserver", "Ltv/danmaku/biliplayerv2/service/IPlayerReleaseObserver;", "removePlayerReleaseObserver", "addMediaCenterObserver", "Ltv/danmaku/biliplayerv2/service/IMediaCenterObserver;", "removeMediaCenterObserver", "addAssetUpdateObserver", "Ltv/danmaku/biliplayerv2/service/IAssetUpdateObserver;", "removeAssetUpdateObserver", "getMediaResource", "updateMediaResource", "updateP2PParams", "params", "Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;", "addPlayerSourceObserver", "Ltv/danmaku/biliplayerv2/service/IPlayerSourceObserver;", "removePlayerSourceObserver", "tryToRestoreFromShutDownByOthers", "getPlayerCodecConfig", "Lcom/bilibili/lib/media/resource/PlayerCodecConfig;", "addRenderStartObserver", "Ltv/danmaku/biliplayerv2/service/IRenderStartObserver;", "removeRenderStartObserver", "addMediaResourceObserver", "Ltv/danmaku/biliplayerv2/service/IMediaResourceObserver;", "removeMediaResourceObserver", "setAssetUpdateListener", "listener", "Ltv/danmaku/biliplayerv2/service/OnAssetUpdateListener;", "setMeteredNetworkUrlHookListener", "Ltv/danmaku/biliplayerv2/service/OnMeteredNetworkUrlHookListener;", "getMeteredNetworkUrlHookListener", "setAudioOnly", "audioOnly", "setVolume", "left", "right", "getVolume", "Lkotlin/Pair;", "registerVolumeChangeObserver", "Ltv/danmaku/biliplayerv2/service/PlayerVolumeChangeObserver;", "unregisterVolumeChangeObserver", "getTcpSpeed", "", "createMediaItem", "acquireDisablePlayLock", "Ltv/danmaku/biliplayerv2/service/lock/DisablePlayLock;", "name", "releaseDisablePlayLock", "lock", "setPlayerPerformanceListener", "Ltv/danmaku/biliplayerv2/service/IPlayerPerformanceListener;", "playFromShared", "prepare", "Lkotlin/Function0;", "success", "getCurrentMediaItem", "setAudioStreamId", "id", "getMediaSize", "codec", "Ltv/danmaku/ijk/media/player/IjkMediaAsset$VideoCodecType;", "setStartStreamIdSelector", "selector", "Ltv/danmaku/biliplayerv2/service/IStartStreamIdSelector;", "getStartStreamIdSelector", "getCurrentPlayUrl", "isAudio", "getVideoFps", "setLooping", "looping", "registerPlayerProgressObserver", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "unregisterPlayerProgressObserver", "registerPlayerProgressRangeObserver", "Ltv/danmaku/biliplayerv2/clock/PlayerProgressRangeObserver;", "startPosition", "endPosition", "unregisterPlayerProgressRangeObserver", "isCorePlayerActive", "createMultiMediaContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext;", "mediaParam", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayParams;", "releaseMultiMediaContext", "mediaContext", "setBufferLimit", "limit", "isBufferLimit", "getDefaultAudioIndex", "getCurrentAudioIndex", "getAudioStreamsIndex", "getCurrentAudioStream", "setAudioIndex", "index", "(Ljava/lang/Integer;)I", "resetAudioIndex", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPlayerCoreService {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String KEY_SHARE_MEDIA_CONTEXT = "key_share_media_context";
    public static final String KEY_SHARE_PLAYER_CORE = "key_share_player_core";

    DisablePlayLock acquireDisablePlayLock(String str);

    void addAssetUpdateObserver(IAssetUpdateObserver iAssetUpdateObserver);

    void addMediaCenterObserver(IMediaCenterObserver iMediaCenterObserver);

    void addMediaResourceObserver(IMediaResourceObserver iMediaResourceObserver);

    void addPlayerClockChangedObserver(IPlayerClockChangedObserver iPlayerClockChangedObserver);

    void addPlayerLoopObserver(IPlayerLoopObserver iPlayerLoopObserver);

    void addPlayerOnRawDataWriteObserver(OnRawDataWriteObserver onRawDataWriteObserver);

    void addPlayerOnTrackInfoObserver(OnTrackInfoObserver onTrackInfoObserver);

    void addPlayerReleaseObserver(IPlayerReleaseObserver iPlayerReleaseObserver);

    void addPlayerSourceObserver(IPlayerSourceObserver iPlayerSourceObserver);

    void addPlayerSpeedChangedObserver(IPlayerSpeedChangedObserver iPlayerSpeedChangedObserver);

    void addRenderStartObserver(IRenderStartObserver iRenderStartObserver);

    void addSeekInterceptor(ISeekInterceptor iSeekInterceptor);

    MediaItem<?> createMediaItem(MediaItemParams mediaItemParams, MediaResource mediaResource);

    IMediaPlayContext createMultiMediaContext(IMediaPlayParams iMediaPlayParams);

    int[] getAudioStreamsIndex();

    float getBufferedPercentage();

    int getCurrentAudioIndex();

    int getCurrentAudioStream();

    MediaItem<?> getCurrentMediaItem();

    String getCurrentPlayUrl(boolean z);

    int getCurrentPosition();

    int getCurrentQuality();

    boolean getDashAuto();

    int getDefaultAudioIndex();

    int getDuration();

    MediaResource getMediaResource();

    long getMediaSize(IjkMediaAsset.VideoCodecType videoCodecType);

    OnMeteredNetworkUrlHookListener getMeteredNetworkUrlHookListener();

    String getPlayFailReason();

    float getPlaySpeed(boolean z);

    PlayerCodecConfig getPlayerCodecConfig();

    int getRealCurrentPosition();

    int getRealDuration();

    IStartStreamIdSelector getStartStreamIdSelector();

    int getState();

    long getTcpSpeed();

    float getVideoFps();

    Pair<Float, Float> getVolume();

    int interceptSeekTarget(int i);

    boolean isBufferLimit();

    boolean isCorePlayerActive();

    boolean isMiniPlayerAvailable();

    boolean isProjectionScreenAvailable();

    boolean isThirdPlayer();

    Boolean isVariableResolutionRatio();

    void pause();

    void play();

    boolean playFromShared(Function0<Unit> function0, Function0<Unit> function02);

    void registerBufferingState(BufferingObserver bufferingObserver);

    void registerPlayerErrorObserver(PlayerErrorObserver playerErrorObserver);

    void registerPlayerProgressObserver(PlayerProgressObserver playerProgressObserver);

    void registerPlayerProgressRangeObserver(PlayerProgressRangeObserver playerProgressRangeObserver, long j, long j2);

    void registerSeekObserver(PlayerSeekObserver playerSeekObserver);

    void registerState(PlayerStateObserver playerStateObserver, int... iArr);

    void registerVolumeChangeObserver(PlayerVolumeChangeObserver playerVolumeChangeObserver);

    void releaseDisablePlayLock(DisablePlayLock disablePlayLock);

    void releaseMultiMediaContext(IMediaPlayContext iMediaPlayContext);

    void removeAssetUpdateObserver(IAssetUpdateObserver iAssetUpdateObserver);

    void removeCurrentSource();

    void removeMediaCenterObserver(IMediaCenterObserver iMediaCenterObserver);

    void removeMediaResourceObserver(IMediaResourceObserver iMediaResourceObserver);

    void removePlayerClockChangedObserver(IPlayerClockChangedObserver iPlayerClockChangedObserver);

    void removePlayerLoopObserver(IPlayerLoopObserver iPlayerLoopObserver);

    void removePlayerOnRawDataWriteObserver(OnRawDataWriteObserver onRawDataWriteObserver);

    void removePlayerOnTrackInfoObserver(OnTrackInfoObserver onTrackInfoObserver);

    void removePlayerReleaseObserver(IPlayerReleaseObserver iPlayerReleaseObserver);

    void removePlayerSourceObserver(IPlayerSourceObserver iPlayerSourceObserver);

    void removePlayerSpeedChangedObserver(IPlayerSpeedChangedObserver iPlayerSpeedChangedObserver);

    void removeRenderStartObserver(IRenderStartObserver iRenderStartObserver);

    void removeSeekInterceptor(ISeekInterceptor iSeekInterceptor);

    void resetAudioIndex();

    void resume();

    void seekTo(int i);

    void seekTo(int i, boolean z);

    void setAssetUpdateListener(OnAssetUpdateListener onAssetUpdateListener);

    int setAudioIndex(Integer num);

    void setAudioOnly(boolean z);

    void setAudioStreamId(int i);

    void setBufferLimit(boolean z);

    void setCurrentPositionInterceptor(ICurrentPositionInterceptor iCurrentPositionInterceptor);

    void setDashAuto(boolean z, int i, int i2);

    void setDurationInterceptor(IDurationInterceptor iDurationInterceptor);

    void setLooping(boolean z);

    void setMediaResource(MediaResource mediaResource, boolean z, MediaItemParams mediaItemParams);

    void setMediaResource(MediaItem<?> mediaItem, MediaResource mediaResource, boolean z, MediaItemParams mediaItemParams);

    void setMeteredNetworkUrlHookListener(OnMeteredNetworkUrlHookListener onMeteredNetworkUrlHookListener);

    void setMiniPlayerAvailable(boolean z);

    void setPlaySpeed(float f);

    void setPlayerPerformanceListener(IPlayerPerformanceListener iPlayerPerformanceListener);

    void setProjectionScreenAvailable(boolean z);

    void setStartStreamIdSelector(IStartStreamIdSelector iStartStreamIdSelector);

    void setVolume(float f, float f2);

    void stop();

    boolean supportMiniPlayer();

    boolean supportProjectionScreen();

    boolean supportQuality(int i);

    void switchAutoQuality(int i, int i2);

    void switchQuality(int i);

    boolean tryToRestoreFromShutDownByOthers();

    void unregisterBufferingState(BufferingObserver bufferingObserver);

    void unregisterPlayerErrorObserver(PlayerErrorObserver playerErrorObserver);

    void unregisterPlayerProgressObserver(PlayerProgressObserver playerProgressObserver);

    void unregisterPlayerProgressRangeObserver(PlayerProgressRangeObserver playerProgressRangeObserver);

    void unregisterSeekObserver(PlayerSeekObserver playerSeekObserver);

    void unregisterState(PlayerStateObserver playerStateObserver);

    void unregisterVolumeChangeObserver(PlayerVolumeChangeObserver playerVolumeChangeObserver);

    void updateMediaResource(MediaResource mediaResource);

    void updateP2PParams(P2PParams p2PParams);

    /* compiled from: IPlayerCoreService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayerCoreService$Companion;", "", "<init>", "()V", "KEY_SHARE_MEDIA_CONTEXT", "", "KEY_SHARE_PLAYER_CORE", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String KEY_SHARE_MEDIA_CONTEXT = "key_share_media_context";
        public static final String KEY_SHARE_PLAYER_CORE = "key_share_player_core";

        private Companion() {
        }
    }

    /* compiled from: IPlayerCoreService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IPlayerCoreService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = IPlayerCoreService.Companion;
        }

        public static /* synthetic */ void seekTo$default(IPlayerCoreService iPlayerCoreService, int i, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: seekTo");
            }
            if ((i2 & 2) != 0) {
                z = false;
            }
            iPlayerCoreService.seekTo(i, z);
        }

        public static /* synthetic */ void setMediaResource$default(IPlayerCoreService iPlayerCoreService, MediaResource mediaResource, boolean z, MediaItemParams mediaItemParams, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMediaResource");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            iPlayerCoreService.setMediaResource(mediaResource, z, mediaItemParams);
        }

        public static /* synthetic */ void setMediaResource$default(IPlayerCoreService iPlayerCoreService, MediaItem mediaItem, MediaResource mediaResource, boolean z, MediaItemParams mediaItemParams, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMediaResource");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            iPlayerCoreService.setMediaResource(mediaItem, mediaResource, z, mediaItemParams);
        }

        public static /* synthetic */ void setDashAuto$default(IPlayerCoreService iPlayerCoreService, boolean z, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDashAuto");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            iPlayerCoreService.setDashAuto(z, i, i2);
        }

        public static /* synthetic */ void switchAutoQuality$default(IPlayerCoreService iPlayerCoreService, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchAutoQuality");
            }
            if ((i3 & 1) != 0) {
                i = 15;
            }
            iPlayerCoreService.switchAutoQuality(i, i2);
        }

        public static /* synthetic */ float getPlaySpeed$default(IPlayerCoreService iPlayerCoreService, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return iPlayerCoreService.getPlaySpeed(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPlaySpeed");
        }

        public static /* synthetic */ String getCurrentPlayUrl$default(IPlayerCoreService iPlayerCoreService, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return iPlayerCoreService.getCurrentPlayUrl(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCurrentPlayUrl");
        }
    }
}