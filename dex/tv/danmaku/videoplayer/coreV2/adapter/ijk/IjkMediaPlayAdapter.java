package tv.danmaku.videoplayer.coreV2.adapter.ijk;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Surface;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.render.core.BiliImageOrientation;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.output.IImageCapture;
import tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface;
import tv.danmaku.ijk.media.player.render.output.IJKPlayerExternalRender;
import tv.danmaku.ijk.media.player.render.tools.BiliDaltonizer;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.media.ijk.IjkPluginLibLoader;
import tv.danmaku.videoplayer.core.media.mediacenter.MediaCenter;
import tv.danmaku.videoplayer.core.media.mediacenter.config.MediaPlayerConfig;
import tv.danmaku.videoplayer.coreV2.ABRManagerKt;
import tv.danmaku.videoplayer.coreV2.IMediaPlayContext;
import tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext;
import tv.danmaku.videoplayer.coreV2.IMediaPlayParams;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderAdapter;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;
import tv.danmaku.videoplayer.coreV2.MediaItem;
import tv.danmaku.videoplayer.coreV2.VideoDisplay;
import tv.danmaku.videoplayer.coreV2.adapter.CoordinateAxis;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;
import tv.danmaku.videoplayer.coreV2.adapter.IjkItemExpectLatency;
import tv.danmaku.videoplayer.coreV2.adapter.IjkItemNotifyLiveP2PUrlChange;
import tv.danmaku.videoplayer.coreV2.adapter.IjkItemNotifyLiveQnChange;
import tv.danmaku.videoplayer.coreV2.adapter.ScreenOrientation;

/* compiled from: IjkMediaPlayAdapter.kt */
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0015\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 ¾\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002¾\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J'\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J,\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016J(\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u000bH\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0016H\u0016J\u0010\u00103\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u000201H\u0016J\b\u00104\u001a\u00020\u0016H\u0016J\b\u00105\u001a\u00020$H\u0016J\u0012\u00106\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u00109\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010;\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010=\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010?\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010A\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010C\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010E\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010G\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010H\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010IH\u0016J\b\u0010J\u001a\u00020\u0002H\u0016J\b\u0010K\u001a\u00020\u0003H\u0016J\u0014\u0010L\u001a\u00020\u00162\n\u0010M\u001a\u0006\u0012\u0002\b\u00030NH\u0016J\u0016\u0010O\u001a\u00020\u00162\f\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010NH\u0016J\b\u0010P\u001a\u00020\u0016H\u0016J\b\u0010Q\u001a\u00020\u0016H\u0016J\b\u0010R\u001a\u00020SH\u0016J\b\u0010T\u001a\u00020SH\u0016J\u0010\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020ZH\u0016J\n\u0010[\u001a\u0004\u0018\u00010ZH\u0016J\u0010\u0010\\\u001a\u00020\u00162\u0006\u0010]\u001a\u00020\rH\u0016J\u0010\u0010^\u001a\u00020\u00162\u0006\u0010^\u001a\u00020\u0018H\u0016J\u0018\u0010^\u001a\u00020\u00162\u0006\u0010_\u001a\u00020\u00182\u0006\u0010`\u001a\u00020\u0018H\u0016J\u0018\u0010a\u001a\u00020\u00162\u0006\u0010b\u001a\u00020\r2\u0006\u0010c\u001a\u00020\rH\u0016J\u0010\u0010d\u001a\u00020\u00162\u0006\u0010e\u001a\u00020\u0018H\u0016J(\u0010f\u001a\u00020\u00162\u0006\u0010^\u001a\u00020\u00182\u0006\u0010b\u001a\u00020\r2\u0006\u0010c\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u0018H\u0016J\u0010\u0010g\u001a\u00020\u00162\u0006\u0010h\u001a\u00020\u000bH\u0016J\u0012\u0010i\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010j\u001a\u00020\u000b2\n\u0010M\u001a\u0006\u0012\u0002\b\u00030NH\u0016J\b\u0010k\u001a\u00020\rH\u0016J\b\u0010l\u001a\u00020\rH\u0016J\b\u0010m\u001a\u00020\rH\u0016J\b\u0010n\u001a\u00020oH\u0016J\u0010\u0010p\u001a\u00020\r2\u0006\u0010q\u001a\u00020\rH\u0016J\u0010\u0010r\u001a\u00020\u00162\u0006\u0010s\u001a\u00020SH\u0016J\u0018\u0010r\u001a\u00020\u00162\u0006\u0010s\u001a\u00020S2\u0006\u0010t\u001a\u00020\u000bH\u0016J\b\u0010u\u001a\u00020SH\u0016J\n\u0010v\u001a\u0004\u0018\u00010oH\u0016J \u0010w\u001a\u00020\u00162\u0006\u0010x\u001a\u00020\r2\u0006\u0010y\u001a\u00020\r2\u0006\u0010z\u001a\u00020\rH\u0016J \u0010{\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\rH\u0016J\b\u0010\u007f\u001a\u00020\u000bH\u0016J\u0011\u0010\u0080\u0001\u001a\u00020\u00162\u0006\u0010x\u001a\u00020\rH\u0016J\t\u0010\u0081\u0001\u001a\u00020\rH\u0016J\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u000bH\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0018H\u0016J\t\u0010\u0086\u0001\u001a\u00020\rH\u0016J\u0011\u0010\u0087\u0001\u001a\u00020\u00162\u0006\u0010k\u001a\u00020\rH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020\u00162\u0007\u0010\u0089\u0001\u001a\u00020\u000bH\u0016J\t\u0010\u008a\u0001\u001a\u00020\rH\u0016J\u0014\u0010\u008b\u0001\u001a\u00020\u00162\t\u0010+\u001a\u0005\u0018\u00010\u008c\u0001H\u0016J\f\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J\f\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\t\u0010\u0090\u0001\u001a\u00020\u0016H\u0016J\t\u0010\u0091\u0001\u001a\u00020\rH\u0016J\t\u0010\u0092\u0001\u001a\u00020\rH\u0016J-\u0010\u0093\u0001\u001a\u00020\u00162\u0007\u0010\u0094\u0001\u001a\u00020\u00182\u0007\u0010\u0095\u0001\u001a\u00020\u00182\u0007\u0010\u0096\u0001\u001a\u00020\u00182\u0007\u0010\u0097\u0001\u001a\u00020\u0018H\u0016J)\u0010\u0098\u0001\u001a\u00020\u00162\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u000b2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010ZH\u0016J\t\u0010\u009d\u0001\u001a\u00020\rH\u0016J\t\u0010\u009e\u0001\u001a\u00020\rH\u0016J\u001b\u0010\u009f\u0001\u001a\u00020\u00162\u0007\u0010 \u0001\u001a\u00020\u000b2\u0007\u0010k\u001a\u00030¡\u0001H\u0016J\u001a\u0010¢\u0001\u001a\u00020\u00162\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030¥\u00010¤\u0001H\u0016J\t\u0010¦\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010§\u0001\u001a\u00020\u00162\u0007\u0010¨\u0001\u001a\u00020\u000bH\u0016J\u0013\u0010©\u0001\u001a\u00020\u00162\b\u0010\u009c\u0001\u001a\u00030¥\u0001H\u0016J\u0015\u0010ª\u0001\u001a\u00020\u00162\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0016J\u0013\u0010\u00ad\u0001\u001a\u00020\u00162\b\u0010\u009c\u0001\u001a\u00030¥\u0001H\u0016J\u0014\u0010®\u0001\u001a\u00020\u00162\t\u0010<\u001a\u0005\u0018\u00010¯\u0001H\u0016J'\u0010°\u0001\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u0007\u0010±\u0001\u001a\u00020 2\u0007\u0010²\u0001\u001a\u0002H\u001eH\u0002¢\u0006\u0003\u0010³\u0001J\u001c\u0010´\u0001\u001a\u00020S2\b\u0010'\u001a\u0004\u0018\u00010(2\u0007\u0010µ\u0001\u001a\u00020\rH\u0002J\t\u0010¶\u0001\u001a\u00020SH\u0002J\t\u0010·\u0001\u001a\u00020SH\u0002J\t\u0010¸\u0001\u001a\u00020\u0018H\u0002J\t\u0010¹\u0001\u001a\u00020\u0018H\u0002J\t\u0010º\u0001\u001a\u00020SH\u0002J\t\u0010»\u0001\u001a\u00020SH\u0002J\t\u0010¼\u0001\u001a\u00020SH\u0002J\t\u0010½\u0001\u001a\u00020SH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¿\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/adapter/ijk/IjkMediaPlayAdapter;", "Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter;", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayControlContext;", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderAdapter;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "<init>", "()V", "mMediaPlayer", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "mInitialed", "", "mCurrentDisplayType", "", "mCurrentAudioStream", "mForbidReusePlayCore", "mCustomInfoListener", "mMediaStreamChangedListener", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext$OnMediaStreamChangedListener;", "mCustomFirstFrameListener", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$OnFirstFrameListener;", "setVolume", "", "left", "", "right", "supportOperator", "op", "Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter$Ops;", "invokeOp", "T", "params", "", "(Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter$Ops;Ljava/lang/Object;)Ljava/lang/Object;", "onInfo", X86IjkRequest.POOL, "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "what", "extra", "bundle", "Landroid/os/Bundle;", "getSpeed", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "width", "height", "ignoreModelChange", "init", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayParams;", "unbindContext", "updatePlayParams", "release", "getMediaPlayer", "setOnPreparedListener", "l", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "setOnCompletionListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "setOnInfoListener", "listener", "setOnErrorListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "setOnSeekComplete", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "setPlayerClockChangedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPlayerClockChangedListener;", "setOnVideoSizeChangedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "setOnBufferingUpdateListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;", "setOnMediaStreamChangedListener", "setOnRawDataWriteListener", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer$OnRawDataWriteListener;", "getMediaPlayControlContext", "getMediaPlayRenderContext", "setMediaItem", "mediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "removeMediaItem", "resume", "pause", "getDuration", "", "getCurrentPosition", "setVideoDisPlay", "display", "Ltv/danmaku/videoplayer/coreV2/VideoDisplay;", "setDisplayViewPort", "viewPort", "Landroid/graphics/Rect;", "getDisplayViewPort", "setVerticesModel", "mode", "scale", "scaleX", "scaleY", "translate", "tX", "tY", "rotate", "degree", "transform", "flipVideo", "flip", "setFirstFrameListener", "supported", "type", "getDefaultAudioIndex", "getCurrentAudioIndex", "getAudioStreamsIndex", "", "setAudioIndex", "index", "seekTo", "position", "accurate", "getBufferedPosition", "getSupportQualities", "setVideoStream", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "min", "max", "setDashAuto", "flag", "minQuality", "maxQuality", "getDashAuto", "setAudioStream", "getCurrentAudioStream", "getCurrentPlayUrl", "", "isAudio", "getVideoFps", "getBufferControl", "setBufferControl", "setLooping", "looping", "getCurrentVideoStream", "setOnVideoDisplayCallback", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer$OnVideoDisplayCallback;", "getMediaInfo", "Ltv/danmaku/ijk/media/player/MediaInfo;", "getPlayFailReason", "notifyRefreshFrame", "getVideoHeight", "getVideoWidth", "setBackgroundColor", "red", "green", "blue", "alpha", "setBackgroundImage", "bitmap", "Landroid/graphics/Bitmap;", "recycle", "rect", "getVideoSarDen", "getVideoSarNum", "setEnhance", "enable", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$IjkEnhanceType;", "setBlurRectList", "rectList", "", "Landroid/graphics/RectF;", "clearBlurRect", "setEnableMultiRender", "isEnable", "setMultiMainCaptureRect", "setMultiSubWindowSurface", "surface", "Landroid/view/Surface;", "setMultiSubWindowCaptureRect", "setOnFrameRendererListener", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$OnFrameRenderedListener;", "cast", "src", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getPropetyLong", "key", "getPlayerError", "getItemError", "getAvDiff", "getDropFrame", "getCacheCurBitrate", "getCacheCurTcpSpeed", "getVideoCacheDuration", "getAudioCachedDuration", "Companion", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkMediaPlayAdapter implements IMediaPlayAdapter, IMediaPlayControlContext, IMediaPlayRenderContext, IMediaPlayRenderAdapter, IMediaPlayer.OnInfoListener {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "PlaybackV2::IjkMediaPlayAdapter";
    private int mCurrentAudioStream;
    private int mCurrentDisplayType = 3;
    private IJKEXTRendererInterface.OnFirstFrameListener mCustomFirstFrameListener;
    private IMediaPlayer.OnInfoListener mCustomInfoListener;
    private boolean mForbidReusePlayCore;
    private boolean mInitialed;
    private IjkMediaPlayer mMediaPlayer;
    private IMediaPlayContext.OnMediaStreamChangedListener mMediaStreamChangedListener;

    /* compiled from: IjkMediaPlayAdapter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ScreenOrientation.values().length];
            try {
                iArr[ScreenOrientation.Up.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ScreenOrientation.Down.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ScreenOrientation.Left.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ScreenOrientation.Right.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CoordinateAxis.values().length];
            try {
                iArr2[CoordinateAxis.AxisAll.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[CoordinateAxis.AxisX.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[CoordinateAxis.AxisY.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[CoordinateAxis.AxisZ.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[IMediaPlayAdapter.Ops.values().length];
            try {
                iArr3[IMediaPlayAdapter.Ops.OpSwitchSpeed.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.GetTcpSpeed.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.SetAudioOnly.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.EnterWholeScene.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.ExitWholeScene.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.SupportWholeScene.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.NotifyWholeSceneOffset.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.NotifyScreenOrientation.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.CloseSensorGyroscope.ordinal()] = 9;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.OpenSensorGyroscope.ordinal()] = 10;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.ResetGyroscope.ordinal()] = 11;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.OpenExternalRender.ordinal()] = 12;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.CloseExternalRender.ordinal()] = 13;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.PerformVisibilityChanged.ordinal()] = 14;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.SwitchDaltonismMode.ordinal()] = 15;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.SetBlurRectList.ordinal()] = 16;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.ClearBlurRect.ordinal()] = 17;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.SetOnNativeInvokeListener.ordinal()] = 18;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.GetAudioCachedDuration.ordinal()] = 19;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.GetVideoCachedDuration.ordinal()] = 20;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.GetCacheCurTcpSpeed.ordinal()] = 21;
            } catch (NoSuchFieldError e29) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.GetCacheCurBitrate.ordinal()] = 22;
            } catch (NoSuchFieldError e30) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.GetDropFrame.ordinal()] = 23;
            } catch (NoSuchFieldError e31) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.GetAvDiff.ordinal()] = 24;
            } catch (NoSuchFieldError e32) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.GetItemError.ordinal()] = 25;
            } catch (NoSuchFieldError e33) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.GetPlayerError.ordinal()] = 26;
            } catch (NoSuchFieldError e34) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.UpdateDns.ordinal()] = 27;
            } catch (NoSuchFieldError e35) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.LiveLowLatencyPlay.ordinal()] = 28;
            } catch (NoSuchFieldError e36) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.SetIjkSeiCallBack.ordinal()] = 29;
            } catch (NoSuchFieldError e37) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.SetIjkDownloadSeiCallBack.ordinal()] = 30;
            } catch (NoSuchFieldError e38) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.IjkFlushCache.ordinal()] = 31;
            } catch (NoSuchFieldError e39) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.GetIjkPlayerItemStopExtera.ordinal()] = 32;
            } catch (NoSuchFieldError e40) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.GetIjkPlayerFisrtPkgTracker.ordinal()] = 33;
            } catch (NoSuchFieldError e41) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.SetIsAbleLowLatency.ordinal()] = 34;
            } catch (NoSuchFieldError e42) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.SetExpectLatency.ordinal()] = 35;
            } catch (NoSuchFieldError e43) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.SetIjkGuid.ordinal()] = 36;
            } catch (NoSuchFieldError e44) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.NotifyStreamLessQnChange.ordinal()] = 37;
            } catch (NoSuchFieldError e45) {
            }
            try {
                iArr3[IMediaPlayAdapter.Ops.NotifyLiveP2PPlayUrlChange.ordinal()] = 38;
            } catch (NoSuchFieldError e46) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public /* synthetic */ VideoDisplay getVideoDisplay() {
        return IMediaPlayRenderContext.CC.$default$getVideoDisplay(this);
    }

    /* compiled from: IjkMediaPlayAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/adapter/ijk/IjkMediaPlayAdapter$Companion;", "", "<init>", "()V", "TAG", "", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setVolume(float left, float right) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setVolume(left, right);
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter
    public boolean supportOperator(IMediaPlayAdapter.Ops op) {
        Intrinsics.checkNotNullParameter(op, "op");
        if (op == IMediaPlayAdapter.Ops.OpSwitchSpeed || op == IMediaPlayAdapter.Ops.GetTcpSpeed || op == IMediaPlayAdapter.Ops.SetAudioOnly || op == IMediaPlayAdapter.Ops.EnterWholeScene || op == IMediaPlayAdapter.Ops.ExitWholeScene || op == IMediaPlayAdapter.Ops.SupportWholeScene || op == IMediaPlayAdapter.Ops.NotifyWholeSceneOffset || op == IMediaPlayAdapter.Ops.NotifyScreenOrientation || op == IMediaPlayAdapter.Ops.CloseSensorGyroscope || op == IMediaPlayAdapter.Ops.OpenSensorGyroscope || op == IMediaPlayAdapter.Ops.ResetGyroscope || op == IMediaPlayAdapter.Ops.OpenExternalRender || op == IMediaPlayAdapter.Ops.CloseExternalRender || op == IMediaPlayAdapter.Ops.PerformVisibilityChanged || op == IMediaPlayAdapter.Ops.SwitchDaltonismMode || op == IMediaPlayAdapter.Ops.SetOnNativeInvokeListener || op == IMediaPlayAdapter.Ops.GetAudioCachedDuration || op == IMediaPlayAdapter.Ops.GetVideoCachedDuration || op == IMediaPlayAdapter.Ops.GetCacheCurTcpSpeed || op == IMediaPlayAdapter.Ops.GetCacheCurBitrate || op == IMediaPlayAdapter.Ops.GetDropFrame || op == IMediaPlayAdapter.Ops.GetAvDiff || op == IMediaPlayAdapter.Ops.GetItemError || op == IMediaPlayAdapter.Ops.GetPlayerError || op == IMediaPlayAdapter.Ops.UpdateDns || op == IMediaPlayAdapter.Ops.LiveLowLatencyPlay || op == IMediaPlayAdapter.Ops.SetIjkSeiCallBack || op == IMediaPlayAdapter.Ops.SetIjkDownloadSeiCallBack || op == IMediaPlayAdapter.Ops.IjkFlushCache || op == IMediaPlayAdapter.Ops.GetIjkPlayerItemStopExtera || op == IMediaPlayAdapter.Ops.GetIjkPlayerFisrtPkgTracker || op == IMediaPlayAdapter.Ops.SetIsAbleLowLatency || op == IMediaPlayAdapter.Ops.SetExpectLatency || op == IMediaPlayAdapter.Ops.SetIjkGuid || op == IMediaPlayAdapter.Ops.NotifyStreamLessQnChange || op == IMediaPlayAdapter.Ops.NotifyLiveP2PPlayUrlChange) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter, tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public <T> T invokeOp(IMediaPlayAdapter.Ops op, Object params) {
        Intrinsics.checkNotNullParameter(op, "op");
        IjkMediaPlayer ijkMediaPlayer = null;
        switch (WhenMappings.$EnumSwitchMapping$2[op.ordinal()]) {
            case 1:
                if (!(params instanceof Float)) {
                    throw new IllegalArgumentException("op:" + op + " params must is Float");
                }
                IjkMediaPlayer ijkMediaPlayer2 = this.mMediaPlayer;
                if (ijkMediaPlayer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer2 = null;
                }
                ijkMediaPlayer2.setSpeed(((Number) params).floatValue());
                return null;
            case 2:
                IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
                if (ijkMediaPlayer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                } else {
                    ijkMediaPlayer = ijkMediaPlayer3;
                }
                return (T) Long.valueOf(ijkMediaPlayer.getTcpSpeed());
            case 3:
                if (!(params instanceof Boolean)) {
                    throw new IllegalArgumentException("op:" + op + " params must is Boolean");
                }
                IjkMediaPlayer ijkMediaPlayer4 = this.mMediaPlayer;
                if (ijkMediaPlayer4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer4 = null;
                }
                ijkMediaPlayer4.setAudioOnly(((Boolean) params).booleanValue());
                return null;
            case 4:
                IjkMediaPlayer ijkMediaPlayer5 = this.mMediaPlayer;
                if (ijkMediaPlayer5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer5 = null;
                }
                IJKPlayerExternalRender externalRender = ijkMediaPlayer5.getExternalRender();
                if (externalRender != null) {
                    externalRender.setSensorContext(BiliContext.application());
                    Unit unit = Unit.INSTANCE;
                }
                IjkMediaPlayer ijkMediaPlayer6 = this.mMediaPlayer;
                if (ijkMediaPlayer6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer6 = null;
                }
                IJKPlayerExternalRender externalRender2 = ijkMediaPlayer6.getExternalRender();
                if (externalRender2 != null) {
                    externalRender2.switchRenderer(2);
                    Unit unit2 = Unit.INSTANCE;
                    return null;
                }
                return null;
            case 5:
                IjkMediaPlayer ijkMediaPlayer7 = this.mMediaPlayer;
                if (ijkMediaPlayer7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer7 = null;
                }
                IJKPlayerExternalRender externalRender3 = ijkMediaPlayer7.getExternalRender();
                if (externalRender3 != null) {
                    externalRender3.switchRenderer(1);
                    Unit unit3 = Unit.INSTANCE;
                    return null;
                }
                return null;
            case 6:
                IjkMediaPlayer ijkMediaPlayer8 = this.mMediaPlayer;
                if (ijkMediaPlayer8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                } else {
                    ijkMediaPlayer = ijkMediaPlayer8;
                }
                return (T) Boolean.valueOf(ijkMediaPlayer.getExternalRender() != null);
            case 7:
                if (!(params instanceof float[])) {
                    throw new IllegalArgumentException("op:" + op + " params must is FloatArray");
                }
                IjkMediaPlayer ijkMediaPlayer9 = this.mMediaPlayer;
                if (ijkMediaPlayer9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer9 = null;
                }
                IJKPlayerExternalRender externalRender4 = ijkMediaPlayer9.getExternalRender();
                if (externalRender4 != null) {
                    externalRender4.setPanoramaRotation(((float[]) params)[0], ((float[]) params)[1]);
                    Unit unit4 = Unit.INSTANCE;
                    return null;
                }
                return null;
            case 8:
                if (!(params instanceof ScreenOrientation)) {
                    throw new IllegalArgumentException("op:" + op + " params must is ScreenOrientation");
                }
                switch (WhenMappings.$EnumSwitchMapping$0[((ScreenOrientation) params).ordinal()]) {
                    case 1:
                        IjkMediaPlayer ijkMediaPlayer10 = this.mMediaPlayer;
                        if (ijkMediaPlayer10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                            ijkMediaPlayer10 = null;
                        }
                        IJKPlayerExternalRender externalRender5 = ijkMediaPlayer10.getExternalRender();
                        if (externalRender5 != null) {
                            externalRender5.setWindowOrientation(BiliImageOrientation.Up);
                            Unit unit5 = Unit.INSTANCE;
                            return null;
                        }
                        return null;
                    case 2:
                        IjkMediaPlayer ijkMediaPlayer11 = this.mMediaPlayer;
                        if (ijkMediaPlayer11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                            ijkMediaPlayer11 = null;
                        }
                        IJKPlayerExternalRender externalRender6 = ijkMediaPlayer11.getExternalRender();
                        if (externalRender6 != null) {
                            externalRender6.setWindowOrientation(BiliImageOrientation.Down);
                            Unit unit6 = Unit.INSTANCE;
                            return null;
                        }
                        return null;
                    case 3:
                        IjkMediaPlayer ijkMediaPlayer12 = this.mMediaPlayer;
                        if (ijkMediaPlayer12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                            ijkMediaPlayer12 = null;
                        }
                        IJKPlayerExternalRender externalRender7 = ijkMediaPlayer12.getExternalRender();
                        if (externalRender7 != null) {
                            externalRender7.setWindowOrientation(BiliImageOrientation.Left);
                            Unit unit7 = Unit.INSTANCE;
                            return null;
                        }
                        return null;
                    case 4:
                        IjkMediaPlayer ijkMediaPlayer13 = this.mMediaPlayer;
                        if (ijkMediaPlayer13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                            ijkMediaPlayer13 = null;
                        }
                        IJKPlayerExternalRender externalRender8 = ijkMediaPlayer13.getExternalRender();
                        if (externalRender8 != null) {
                            externalRender8.setWindowOrientation(BiliImageOrientation.Right);
                            Unit unit8 = Unit.INSTANCE;
                            return null;
                        }
                        return null;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 9:
                IjkMediaPlayer ijkMediaPlayer14 = this.mMediaPlayer;
                if (ijkMediaPlayer14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer14 = null;
                }
                IJKPlayerExternalRender externalRender9 = ijkMediaPlayer14.getExternalRender();
                if (externalRender9 != null) {
                    externalRender9.closeGyroSensor();
                    Unit unit9 = Unit.INSTANCE;
                    return null;
                }
                return null;
            case 10:
                IjkMediaPlayer ijkMediaPlayer15 = this.mMediaPlayer;
                if (ijkMediaPlayer15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer15 = null;
                }
                IJKPlayerExternalRender externalRender10 = ijkMediaPlayer15.getExternalRender();
                if (externalRender10 != null) {
                    externalRender10.openGyroSensor();
                    Unit unit10 = Unit.INSTANCE;
                    return null;
                }
                return null;
            case 11:
                if (!(params instanceof CoordinateAxis)) {
                    throw new IllegalArgumentException("op:" + op + " params must is CoordinateAxis");
                }
                switch (WhenMappings.$EnumSwitchMapping$1[((CoordinateAxis) params).ordinal()]) {
                    case 1:
                        IjkMediaPlayer ijkMediaPlayer16 = this.mMediaPlayer;
                        if (ijkMediaPlayer16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                            ijkMediaPlayer16 = null;
                        }
                        IJKPlayerExternalRender externalRender11 = ijkMediaPlayer16.getExternalRender();
                        if (externalRender11 != null) {
                            externalRender11.resetAxis(0);
                            Unit unit11 = Unit.INSTANCE;
                        }
                        IjkMediaPlayer ijkMediaPlayer17 = this.mMediaPlayer;
                        if (ijkMediaPlayer17 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                            ijkMediaPlayer17 = null;
                        }
                        IJKPlayerExternalRender externalRender12 = ijkMediaPlayer17.getExternalRender();
                        if (externalRender12 != null) {
                            externalRender12.resetAxis(1);
                            Unit unit12 = Unit.INSTANCE;
                        }
                        IjkMediaPlayer ijkMediaPlayer18 = this.mMediaPlayer;
                        if (ijkMediaPlayer18 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                            ijkMediaPlayer18 = null;
                        }
                        IJKPlayerExternalRender externalRender13 = ijkMediaPlayer18.getExternalRender();
                        if (externalRender13 != null) {
                            externalRender13.resetAxis(2);
                            Unit unit13 = Unit.INSTANCE;
                            return null;
                        }
                        return null;
                    case 2:
                        IjkMediaPlayer ijkMediaPlayer19 = this.mMediaPlayer;
                        if (ijkMediaPlayer19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                            ijkMediaPlayer19 = null;
                        }
                        IJKPlayerExternalRender externalRender14 = ijkMediaPlayer19.getExternalRender();
                        if (externalRender14 != null) {
                            externalRender14.resetAxis(0);
                            Unit unit14 = Unit.INSTANCE;
                            return null;
                        }
                        return null;
                    case 3:
                        IjkMediaPlayer ijkMediaPlayer20 = this.mMediaPlayer;
                        if (ijkMediaPlayer20 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                            ijkMediaPlayer20 = null;
                        }
                        IJKPlayerExternalRender externalRender15 = ijkMediaPlayer20.getExternalRender();
                        if (externalRender15 != null) {
                            externalRender15.resetAxis(1);
                            Unit unit15 = Unit.INSTANCE;
                            return null;
                        }
                        return null;
                    case 4:
                        IjkMediaPlayer ijkMediaPlayer21 = this.mMediaPlayer;
                        if (ijkMediaPlayer21 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                            ijkMediaPlayer21 = null;
                        }
                        IJKPlayerExternalRender externalRender16 = ijkMediaPlayer21.getExternalRender();
                        if (externalRender16 != null) {
                            externalRender16.resetAxis(2);
                            Unit unit16 = Unit.INSTANCE;
                            return null;
                        }
                        return null;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 12:
                BiliRenderContext.init(BiliContext.application());
                IjkMediaPlayer ijkMediaPlayer22 = this.mMediaPlayer;
                if (ijkMediaPlayer22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer22 = null;
                }
                ijkMediaPlayer22.enableExternalRender();
                IjkMediaPlayer ijkMediaPlayer23 = this.mMediaPlayer;
                if (ijkMediaPlayer23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer23 = null;
                }
                IJKPlayerExternalRender externalRender17 = ijkMediaPlayer23.getExternalRender();
                if (externalRender17 != null) {
                    externalRender17.setOnFirstFrameListener(this.mCustomFirstFrameListener);
                    Unit unit17 = Unit.INSTANCE;
                    return null;
                }
                return null;
            case 13:
                IjkMediaPlayer ijkMediaPlayer24 = this.mMediaPlayer;
                if (ijkMediaPlayer24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer24 = null;
                }
                ijkMediaPlayer24.disableExternalRender();
                IjkMediaPlayer ijkMediaPlayer25 = this.mMediaPlayer;
                if (ijkMediaPlayer25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer25 = null;
                }
                IJKPlayerExternalRender externalRender18 = ijkMediaPlayer25.getExternalRender();
                if (externalRender18 != null) {
                    externalRender18.setOnFirstFrameListener(null);
                    Unit unit18 = Unit.INSTANCE;
                    return null;
                }
                return null;
            case 14:
                if (!(params instanceof Boolean)) {
                    throw new IllegalArgumentException("op:" + op + " params must is Boolean");
                }
                IjkMediaPlayer ijkMediaPlayer26 = this.mMediaPlayer;
                if (ijkMediaPlayer26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer26 = null;
                }
                IJKPlayerExternalRender externalRender19 = ijkMediaPlayer26.getExternalRender();
                if (externalRender19 != null) {
                    externalRender19.notifyUpdateNow();
                    Unit unit19 = Unit.INSTANCE;
                    return null;
                }
                return null;
            case 15:
                if (!(params instanceof BiliDaltonizer.ColorBlindnessType)) {
                    throw new IllegalArgumentException("op:" + op + " params must be ColorBlindnessType");
                }
                IjkMediaPlayer ijkMediaPlayer27 = this.mMediaPlayer;
                if (ijkMediaPlayer27 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer27 = null;
                }
                IJKPlayerExternalRender externalRender20 = ijkMediaPlayer27.getExternalRender();
                if (externalRender20 != null) {
                    externalRender20.setDaltonismType((BiliDaltonizer.ColorBlindnessType) params);
                    Unit unit20 = Unit.INSTANCE;
                    return null;
                }
                return null;
            case 16:
                if (!(params instanceof List)) {
                    throw new IllegalArgumentException("op:" + op + " params must be List<RectF>");
                }
                IjkMediaPlayer ijkMediaPlayer28 = this.mMediaPlayer;
                if (ijkMediaPlayer28 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer28 = null;
                }
                IJKPlayerExternalRender externalRender21 = ijkMediaPlayer28.getExternalRender();
                if (externalRender21 != null) {
                    Iterable $this$map$iv = (Iterable) params;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Intrinsics.checkNotNull(item$iv$iv, "null cannot be cast to non-null type android.graphics.RectF");
                        destination$iv$iv.add((RectF) item$iv$iv);
                    }
                    externalRender21.setBlurRectList((List) destination$iv$iv);
                    Unit unit21 = Unit.INSTANCE;
                    return null;
                }
                return null;
            case 17:
                IjkMediaPlayer ijkMediaPlayer29 = this.mMediaPlayer;
                if (ijkMediaPlayer29 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer29 = null;
                }
                IJKPlayerExternalRender externalRender22 = ijkMediaPlayer29.getExternalRender();
                if (externalRender22 != null) {
                    externalRender22.clearBlurRect();
                    Unit unit22 = Unit.INSTANCE;
                    return null;
                }
                return null;
            case 18:
                if (!(params instanceof IjkMediaPlayer.OnNativeInvokeListener)) {
                    throw new IllegalArgumentException("op:" + op + " params must be OnNativeInvokeListener");
                }
                IjkMediaPlayer ijkMediaPlayer30 = this.mMediaPlayer;
                if (ijkMediaPlayer30 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer30 = null;
                }
                ijkMediaPlayer30.setOnNativeInvokeListener((IjkMediaPlayer.OnNativeInvokeListener) params);
                return null;
            case 19:
                return (T) cast(Long.valueOf(getAudioCachedDuration()), params);
            case 20:
                return (T) cast(Long.valueOf(getVideoCacheDuration()), params);
            case 21:
                return (T) cast(Long.valueOf(getCacheCurTcpSpeed()), params);
            case 22:
                return (T) cast(Long.valueOf(getCacheCurBitrate()), params);
            case module_topic_VALUE:
                return (T) cast(Float.valueOf(getDropFrame()), params);
            case 24:
                return (T) cast(Float.valueOf(getAvDiff()), params);
            case 25:
                return (T) cast(Long.valueOf(getItemError()), params);
            case module_topic_brief_VALUE:
                return (T) cast(Long.valueOf(getPlayerError()), params);
            case module_title_VALUE:
                if (!(params instanceof Boolean)) {
                    throw new IllegalArgumentException("op:" + op + " params must be Boolean");
                }
                IjkMediaPlayer ijkMediaPlayer31 = this.mMediaPlayer;
                if (ijkMediaPlayer31 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer31 = null;
                }
                ijkMediaPlayer31.updateDns(((Boolean) params).booleanValue());
                return null;
            case module_button_VALUE:
                if (!(params instanceof Integer)) {
                    throw new IllegalArgumentException("op:" + op + " params must be Int");
                }
                IjkMediaPlayer ijkMediaPlayer32 = this.mMediaPlayer;
                if (ijkMediaPlayer32 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer32 = null;
                }
                ijkMediaPlayer32.setLiveDelayTime(((Number) params).intValue());
                return null;
            case module_notice_VALUE:
                if (!(params instanceof IjkMediaPlayer.OnSeiDataWriteListener)) {
                    throw new IllegalArgumentException("op:" + op + " params must be IjkMediaPlayer.OnSeiDataWriteListener");
                }
                IjkMediaPlayer ijkMediaPlayer33 = this.mMediaPlayer;
                if (ijkMediaPlayer33 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer33 = null;
                }
                ijkMediaPlayer33.setOnSeiDataWriteListener((IjkMediaPlayer.OnSeiDataWriteListener) params);
                return null;
            case 30:
                if (!(params instanceof IjkMediaPlayer.OnDownloadSeiDataWriteListener)) {
                    throw new IllegalArgumentException("op:" + op + " params must be IjkMediaPlayer.OnSeiDataWriteListener");
                }
                IjkMediaPlayer ijkMediaPlayer34 = this.mMediaPlayer;
                if (ijkMediaPlayer34 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer34 = null;
                }
                ijkMediaPlayer34.setOnDownloadSeiDataWriteListener((IjkMediaPlayer.OnDownloadSeiDataWriteListener) params);
                return null;
            case module_copyright_VALUE:
                IjkMediaPlayer ijkMediaPlayer35 = this.mMediaPlayer;
                if (ijkMediaPlayer35 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer35 = null;
                }
                ijkMediaPlayer35.flushCache();
                return null;
            case 32:
                IjkMediaPlayer ijkMediaPlayer36 = this.mMediaPlayer;
                if (ijkMediaPlayer36 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer36 = null;
                }
                if (ijkMediaPlayer36.getIjkMediaPlayerItem() != null) {
                    IjkMediaPlayer ijkMediaPlayer37 = this.mMediaPlayer;
                    if (ijkMediaPlayer37 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    } else {
                        ijkMediaPlayer = ijkMediaPlayer37;
                    }
                    Bundle extra = ijkMediaPlayer.getIjkMediaPlayerItem().getPropertiesBundle(IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_AUDIO_BYTE_COUNT, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_DASH_VIDEO_BYTE_COUNT, IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT, IjkMediaPlayer.FFP_PROP_INT64_ITEM_ERROR_CODE);
                    Intrinsics.checkNotNullExpressionValue(extra, "getPropertiesBundle(...)");
                    return (T) cast(extra, params);
                }
                return params;
            case 33:
                IjkMediaPlayer ijkMediaPlayer38 = this.mMediaPlayer;
                if (ijkMediaPlayer38 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                } else {
                    ijkMediaPlayer = ijkMediaPlayer38;
                }
                Bundle extra2 = ijkMediaPlayer.getPropertiesBundle(IjkMediaPlayer.FFP_PROP_INT64_FIRST_PKG_GET_TRACKER);
                Intrinsics.checkNotNullExpressionValue(extra2, "getPropertiesBundle(...)");
                boolean playerFirstPkg = getPropetyLong(extra2, IjkMediaPlayer.FFP_PROP_INT64_FIRST_PKG_GET_TRACKER) != 0;
                return (T) cast(Boolean.valueOf(playerFirstPkg), params);
            case 34:
                if (!(params instanceof Integer)) {
                    throw new IllegalArgumentException("op:" + op + " params must be Int");
                }
                IjkMediaPlayer ijkMediaPlayer39 = this.mMediaPlayer;
                if (ijkMediaPlayer39 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer39 = null;
                }
                ijkMediaPlayer39.getIjkMediaPlayerItem().setIsAbleLowLatency(((Number) params).intValue());
                return null;
            case module_opus_collection_VALUE:
                if (!(params instanceof IjkItemExpectLatency)) {
                    throw new IllegalArgumentException("op:" + op + " params must be Int");
                }
                IjkMediaPlayer ijkMediaPlayer40 = this.mMediaPlayer;
                if (ijkMediaPlayer40 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer40 = null;
                }
                ijkMediaPlayer40.getIjkMediaPlayerItem().setExpectLatency(((IjkItemExpectLatency) params).getLatency(), ((IjkItemExpectLatency) params).getEnableSkipFrame(), ((IjkItemExpectLatency) params).getEnableJitterBuffer());
                return null;
            case module_onetime_notice_VALUE:
                if (!(params instanceof String)) {
                    throw new IllegalArgumentException("op:" + op + " params must be String");
                }
                IjkMediaPlayer ijkMediaPlayer41 = this.mMediaPlayer;
                if (ijkMediaPlayer41 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer41 = null;
                }
                if (ijkMediaPlayer41.getIjkMediaPlayerItem() != null) {
                    IjkMediaPlayer ijkMediaPlayer42 = this.mMediaPlayer;
                    if (ijkMediaPlayer42 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                        ijkMediaPlayer42 = null;
                    }
                    ijkMediaPlayer42.getIjkMediaPlayerItem().setGuid((String) params);
                    return null;
                }
                return null;
            case module_sneaking_ad_VALUE:
                if (!(params instanceof IjkItemNotifyLiveQnChange)) {
                    throw new IllegalArgumentException("op:" + op + " params must be IjkItemNotifyLiveQnChange");
                }
                IjkMediaPlayer ijkMediaPlayer43 = this.mMediaPlayer;
                if (ijkMediaPlayer43 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer43 = null;
                }
                ijkMediaPlayer43.notifyLiveQnChange(((IjkItemNotifyLiveQnChange) params).getCurQn(), ((IjkItemNotifyLiveQnChange) params).getTargetQn(), ((IjkItemNotifyLiveQnChange) params).getNewUrl(), ((IjkItemNotifyLiveQnChange) params).getSwitchQnMode());
                return null;
            case module_manga_horizontal_page_pic_content_VALUE:
                if (!(params instanceof IjkItemNotifyLiveP2PUrlChange)) {
                    throw new IllegalArgumentException("op:" + op + " params must be IjkItemNotifyLiveP2PUrlChange");
                }
                IjkMediaPlayer ijkMediaPlayer44 = this.mMediaPlayer;
                if (ijkMediaPlayer44 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer44 = null;
                }
                ijkMediaPlayer44.notifyP2pUrlChange(((IjkItemNotifyLiveP2PUrlChange) params).getNewUrl(), ((IjkItemNotifyLiveP2PUrlChange) params).getExtraInfo());
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer player, int what, int extra, Bundle bundle) {
        IMediaPlayContext.OnMediaStreamChangedListener onMediaStreamChangedListener;
        if (10107 == what && bundle != null) {
            boolean fromAuto = bundle.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_DASH_AUTO_SIWTCH) == 1;
            int errorCode = bundle.getInt("error");
            int type = bundle.getInt("type");
            int newStream = bundle.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_DASH_NEXT_ID);
            int oldStream = bundle.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_DASH_CUR_ID);
            switch (type) {
                case 0:
                    if (errorCode == 0) {
                        IMediaPlayContext.OnMediaStreamChangedListener onMediaStreamChangedListener2 = this.mMediaStreamChangedListener;
                        if (onMediaStreamChangedListener2 != null) {
                            onMediaStreamChangedListener2.onVideoStreamChanged(true, oldStream, newStream, fromAuto);
                            break;
                        }
                    } else {
                        IMediaPlayContext.OnMediaStreamChangedListener onMediaStreamChangedListener3 = this.mMediaStreamChangedListener;
                        if (onMediaStreamChangedListener3 != null) {
                            onMediaStreamChangedListener3.onVideoStreamChanged(false, oldStream, newStream, fromAuto);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (errorCode == 0) {
                        this.mCurrentAudioStream = newStream;
                        IMediaPlayContext.OnMediaStreamChangedListener onMediaStreamChangedListener4 = this.mMediaStreamChangedListener;
                        if (onMediaStreamChangedListener4 != null) {
                            onMediaStreamChangedListener4.onAudioStreamChanged(true, oldStream, newStream, fromAuto);
                            break;
                        }
                    } else {
                        IMediaPlayContext.OnMediaStreamChangedListener onMediaStreamChangedListener5 = this.mMediaStreamChangedListener;
                        if (onMediaStreamChangedListener5 != null) {
                            onMediaStreamChangedListener5.onAudioStreamChanged(false, oldStream, newStream, fromAuto);
                            break;
                        }
                    }
                    break;
            }
        } else if (10111 == what && (onMediaStreamChangedListener = this.mMediaStreamChangedListener) != null) {
            onMediaStreamChangedListener.onRecommendVideoStreamStarted(extra);
        }
        IMediaPlayer.OnInfoListener onInfoListener = this.mCustomInfoListener;
        if (onInfoListener != null) {
            return onInfoListener.onInfo(player, what, extra, bundle);
        }
        return false;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public float getSpeed() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getSpeed(1.0f);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void takeVideoCapture(final IMediaPlayRenderContext.OnTakeVideoCapture callback, int width, int height, boolean ignoreModelChange) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setCaptureFrameAvailableListener(new IImageCapture.OnCaptureFrameAvailableListener() { // from class: tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaPlayAdapter$$ExternalSyntheticLambda0
                @Override // tv.danmaku.ijk.media.player.render.output.IImageCapture.OnCaptureFrameAvailableListener
                public final void onCaptureFrameAvailable(Bitmap bitmap) {
                    IMediaPlayRenderContext.OnTakeVideoCapture.this.onResult(bitmap);
                }
            });
        }
        try {
            BiliSize size = BiliSize.create(width, height);
            if (size.isSize()) {
                if (ignoreModelChange) {
                    float[] matrix = {1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f};
                    IjkMediaPlayer ijkMediaPlayer2 = this.mMediaPlayer;
                    if (ijkMediaPlayer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                        ijkMediaPlayer2 = null;
                    }
                    IJKPlayerExternalRender externalRender2 = ijkMediaPlayer2.getExternalRender();
                    if (externalRender2 != null) {
                        externalRender2.captureOneImage(BiliSize.create(width, height), matrix);
                        return;
                    }
                    return;
                }
                IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
                if (ijkMediaPlayer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer3 = null;
                }
                IJKPlayerExternalRender externalRender3 = ijkMediaPlayer3.getExternalRender();
                if (externalRender3 != null) {
                    externalRender3.captureOneImage(BiliSize.create(width, height));
                    return;
                }
                return;
            }
            IjkMediaPlayer ijkMediaPlayer4 = this.mMediaPlayer;
            if (ijkMediaPlayer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                ijkMediaPlayer4 = null;
            }
            IJKPlayerExternalRender externalRender4 = ijkMediaPlayer4.getExternalRender();
            if (externalRender4 != null) {
                externalRender4.captureOneImage();
            }
        } catch (Exception e) {
            PlayerLog.e(TAG, "take video capture failed!!!", e);
            callback.onResult(null);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter, tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext, tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void init(IMediaPlayParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.mInitialed) {
            PlayerLog.e(TAG, "adapter already initialed");
            return;
        }
        this.mInitialed = true;
        Application context = BiliContext.application();
        MediaPlayerConfig config = new MediaPlayerConfig.Builder().ijkLibLoader(IjkPluginLibLoader.getInstance(context)).useExternalRender(params.externalRender()).build();
        if (params.forbidReusePlayerCore()) {
            config.setForceCreate(true);
            this.mForbidReusePlayCore = true;
        }
        this.mMediaPlayer = MediaCenter.INSTANCE.obtainMediaPlayer(context, config);
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setOnInfoListener(this);
        setVolume(1.0f, 1.0f);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderAdapter
    public void unbindContext() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setCaptureFrameAvailableListener(null);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void updatePlayParams(IMediaPlayParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.mForbidReusePlayCore = params.forbidReusePlayerCore();
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter, tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext, tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void release() {
        if (!this.mInitialed) {
            PlayerLog.e(TAG, "adapter do not initialed");
            return;
        }
        IjkMediaPlayer ijkMediaPlayer = null;
        setOnPreparedListener(null);
        setFirstFrameListener(null);
        setOnVideoSizeChangedListener(null);
        setOnCompletionListener(null);
        setOnErrorListener(null);
        setOnBufferingUpdateListener(null);
        setOnInfoListener(null);
        setOnSeekComplete(null);
        setPlayerClockChangedListener(null);
        setOnMediaStreamChangedListener(null);
        setOnRawDataWriteListener(null);
        setOnVideoDisplayCallback(null);
        unbindContext();
        if (this.mForbidReusePlayCore || !MediaCenter.INSTANCE.reuseMediaPlayer()) {
            IjkMediaPlayer ijkMediaPlayer2 = this.mMediaPlayer;
            if (ijkMediaPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                ijkMediaPlayer2 = null;
            }
            ijkMediaPlayer2.setOnNativeInvokeListener(null);
            if (this.mCurrentDisplayType == 1) {
                IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
                if (ijkMediaPlayer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer3 = null;
                }
                ijkMediaPlayer3.setDisplay(null);
            } else {
                IjkMediaPlayer ijkMediaPlayer4 = this.mMediaPlayer;
                if (ijkMediaPlayer4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer4 = null;
                }
                ijkMediaPlayer4.setSurface(null);
            }
            IjkMediaPlayer ijkMediaPlayer5 = this.mMediaPlayer;
            if (ijkMediaPlayer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            } else {
                ijkMediaPlayer = ijkMediaPlayer5;
            }
            ijkMediaPlayer.release();
        } else {
            IjkMediaPlayer ijkMediaPlayer6 = this.mMediaPlayer;
            if (ijkMediaPlayer6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                ijkMediaPlayer6 = null;
            }
            IjkMediaPlayer ijkMediaPlayer7 = this.mMediaPlayer;
            if (ijkMediaPlayer7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            } else {
                ijkMediaPlayer = ijkMediaPlayer7;
            }
            ijkMediaPlayer6.removeIjkMediaPlayerItem(ijkMediaPlayer.getIjkMediaPlayerItem());
        }
        this.mForbidReusePlayCore = false;
        PlayerLog.i(TAG, "release ijk player");
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter
    public IMediaPlayer getMediaPlayer() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener l) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setOnPreparedListener(l);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener l) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setOnCompletionListener(l);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnInfoListener(IMediaPlayer.OnInfoListener listener) {
        this.mCustomInfoListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnErrorListener(IMediaPlayer.OnErrorListener listener) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setOnErrorListener(listener);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnSeekComplete(IMediaPlayer.OnSeekCompleteListener listener) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setOnSeekCompleteListener(listener);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setPlayerClockChangedListener(IMediaPlayer.OnPlayerClockChangedListener listener) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setOnPlayerClockChangedListener(MediaCenter.INSTANCE.getIjkEventThreadLooper(), listener);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener listener) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setOnVideoSizeChangedListener(listener);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener listener) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setOnBufferingUpdateListener(listener);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnMediaStreamChangedListener(IMediaPlayContext.OnMediaStreamChangedListener listener) {
        this.mMediaStreamChangedListener = listener;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnRawDataWriteListener(IjkMediaPlayer.OnRawDataWriteListener listener) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setOnRawDataWriteListener(listener);
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter
    public IMediaPlayControlContext getMediaPlayControlContext() {
        return this;
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter
    public IMediaPlayRenderContext getMediaPlayRenderContext() {
        return this;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setMediaItem(MediaItem<?> mediaItem) {
        IjkMediaPlayerItem $this$setMediaItem_u24lambda_u240;
        Intrinsics.checkNotNullParameter(mediaItem, "mediaItem");
        PlayerLog.i(TAG, "setMediaItem");
        if ((mediaItem instanceof IjkMediaItem) && ($this$setMediaItem_u24lambda_u240 = ((IjkMediaItem) mediaItem).realMediaItem()) != null) {
            if ($this$setMediaItem_u24lambda_u240 instanceof IjkMediaPlayerItemDecorate) {
                this.mCurrentAudioStream = ((IjkMediaPlayerItemDecorate) $this$setMediaItem_u24lambda_u240).getDefaultAudioStream();
            }
            IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
            IjkMediaPlayer ijkMediaPlayer2 = null;
            if (ijkMediaPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                ijkMediaPlayer = null;
            }
            if (!ijkMediaPlayer.isRunning()) {
                IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
                if (ijkMediaPlayer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                    ijkMediaPlayer3 = null;
                }
                ijkMediaPlayer3.setIjkMediaPlayerItem($this$setMediaItem_u24lambda_u240);
                IjkMediaPlayer ijkMediaPlayer4 = this.mMediaPlayer;
                if (ijkMediaPlayer4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                } else {
                    ijkMediaPlayer2 = ijkMediaPlayer4;
                }
                ijkMediaPlayer2.prepareAsync();
                return;
            }
            $this$setMediaItem_u24lambda_u240.start();
            IjkMediaPlayer ijkMediaPlayer5 = this.mMediaPlayer;
            if (ijkMediaPlayer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            } else {
                ijkMediaPlayer2 = ijkMediaPlayer5;
            }
            ijkMediaPlayer2.replaceCurrentItem($this$setMediaItem_u24lambda_u240);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void removeMediaItem(MediaItem<?> mediaItem) {
        if (mediaItem instanceof IjkMediaItem) {
            IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
            if (ijkMediaPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                ijkMediaPlayer = null;
            }
            ijkMediaPlayer.removeIjkMediaPlayerItem(((IjkMediaItem) mediaItem).realMediaItem());
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void resume() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.start();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void pause() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.pause();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public long getDuration() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getDuration();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public long getCurrentPosition() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getCurrentPosition();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setVideoDisPlay(VideoDisplay display) {
        Intrinsics.checkNotNullParameter(display, "display");
        IjkMediaPlayer ijkMediaPlayer = null;
        if (display.getType() == 1) {
            this.mCurrentDisplayType = 1;
            IjkMediaPlayer ijkMediaPlayer2 = this.mMediaPlayer;
            if (ijkMediaPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                ijkMediaPlayer2 = null;
            }
            ijkMediaPlayer2.setDisplay(display.getSurfaceHolder());
        } else {
            this.mCurrentDisplayType = 2;
            IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
            if (ijkMediaPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                ijkMediaPlayer3 = null;
            }
            ijkMediaPlayer3.setSurface(display.getSurface());
        }
        if (IjkMediaPlayAdapterKt.getHitExternalRenderFirstFrameDD()) {
            IjkMediaPlayer ijkMediaPlayer4 = this.mMediaPlayer;
            if (ijkMediaPlayer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                ijkMediaPlayer4 = null;
            }
            if (ijkMediaPlayer4.isExternalRenderEnable()) {
                IjkMediaPlayer ijkMediaPlayer5 = this.mMediaPlayer;
                if (ijkMediaPlayer5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
                } else {
                    ijkMediaPlayer = ijkMediaPlayer5;
                }
                ijkMediaPlayer.resetHasCallFirstFrame();
            }
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setDisplayViewPort(Rect viewPort) {
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setDisplayRect(viewPort);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public Rect getDisplayViewPort() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            return externalRender.getDisplayRect();
        }
        return null;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setVerticesModel(int mode) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setVerticesModel(mode);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void scale(float scale) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.scale(scale);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void scale(float scaleX, float scaleY) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.scale(scaleX, scaleY);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void translate(int tX, int tY) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.translate(tX, tY);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void rotate(float degree) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.rotate(degree);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void transform(float scale, int tX, int tY, float degree) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.transform(scale, tX, tY, degree);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void flipVideo(boolean flip) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.mirror(0, flip);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext, tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setFirstFrameListener(IJKEXTRendererInterface.OnFirstFrameListener listener) {
        this.mCustomFirstFrameListener = listener;
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        IjkMediaPlayer ijkMediaPlayer2 = null;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        if (ijkMediaPlayer.getExternalRender() != null) {
            IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
            if (ijkMediaPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            } else {
                ijkMediaPlayer2 = ijkMediaPlayer3;
            }
            IJKPlayerExternalRender externalRender = ijkMediaPlayer2.getExternalRender();
            if (externalRender != null) {
                externalRender.setOnFirstFrameListener(listener);
                return;
            }
            return;
        }
        PlayerLog.i(TAG, "set first frame listener, but external not start");
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter
    public boolean supported(MediaItem<?> mediaItem) {
        Intrinsics.checkNotNullParameter(mediaItem, "mediaItem");
        return mediaItem instanceof IjkMediaItem;
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter
    public int type() {
        return 1;
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter
    public int getDefaultAudioIndex() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getDefaultAudioIndex();
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter
    public int getCurrentAudioIndex() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getCurrentAudioIndex();
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter
    public int[] getAudioStreamsIndex() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        int[] audioStreamsIndex = ijkMediaPlayer.getAudioStreamsIndex();
        Intrinsics.checkNotNullExpressionValue(audioStreamsIndex, "getAudioStreamsIndex(...)");
        return audioStreamsIndex;
    }

    @Override // tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter
    public int setAudioIndex(int index) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.switchAudioStream(index);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void seekTo(long position) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.seekTo(position, false);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void seekTo(long position, boolean accurate) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.seekTo(position, accurate);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public long getBufferedPosition() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        IjkMediaPlayer ijkMediaPlayer2 = null;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        long videoCache = ijkMediaPlayer.getVideoCachedDuration();
        IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
        if (ijkMediaPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer3 = null;
        }
        long audioCache = ijkMediaPlayer3.getAudioCachedDuration();
        IjkMediaPlayer ijkMediaPlayer4 = this.mMediaPlayer;
        if (ijkMediaPlayer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
        } else {
            ijkMediaPlayer2 = ijkMediaPlayer4;
        }
        boolean audioOnly = ijkMediaPlayer2.isAudioOnly();
        return audioOnly ? audioCache : Math.min(videoCache, audioCache);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public int[] getSupportQualities() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        Bundle dashInfo = ijkMediaPlayer.getDashStreamInfo();
        if (dashInfo == null) {
            return null;
        }
        return dashInfo.getIntArray(IjkMediaMeta.IJKM_DASH_KEY_VIDEO_ID_ARRAY);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setVideoStream(int quality, int min, int max) {
        if (quality == 0) {
            setDashAuto(true, min, max);
            return;
        }
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        IjkMediaPlayer ijkMediaPlayer2 = null;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setSwitchNonAutoTargetQn(quality);
        setDashAuto(false, min, max);
        IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
        if (ijkMediaPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
        } else {
            ijkMediaPlayer2 = ijkMediaPlayer3;
        }
        ijkMediaPlayer2.switchDashVideoStream(quality);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setDashAuto(boolean flag, int minQuality, int maxQuality) {
        if (flag) {
            ABRManagerKt.setMinQn(minQuality);
            ABRManagerKt.setMaxQn(maxQuality);
        }
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setDashAuto(flag);
        PlayerLog.i(TAG, "setDashAuto:" + flag + "-minQuality:" + minQuality + "-maxQuality:" + maxQuality);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public boolean getDashAuto() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getDashAuto();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setAudioStream(final int quality) {
        if (quality == this.mCurrentAudioStream) {
            HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaPlayAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    IjkMediaPlayAdapter.setAudioStream$lambda$0(IjkMediaPlayAdapter.this, quality);
                }
            });
            return;
        }
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.switchDashAudioStream(quality);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setAudioStream$lambda$0(IjkMediaPlayAdapter this$0, int $quality) {
        IMediaPlayContext.OnMediaStreamChangedListener onMediaStreamChangedListener = this$0.mMediaStreamChangedListener;
        if (onMediaStreamChangedListener != null) {
            onMediaStreamChangedListener.onAudioStreamChanged(true, this$0.mCurrentAudioStream, $quality, false);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public int getCurrentAudioStream() {
        return this.mCurrentAudioStream;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public String getCurrentPlayUrl(boolean isAudio) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        String trackerUrl = ijkMediaPlayer.getTrackerUrl(isAudio);
        return trackerUrl == null ? "" : trackerUrl;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public float getVideoFps() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getVideoFps();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public int getBufferControl() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getBufferControl();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setBufferControl(int type) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setBufferControl(type);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setLooping(boolean looping) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setLooping(looping);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public int getCurrentVideoStream() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getCurrentVideoId();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public void setOnVideoDisplayCallback(IjkMediaPlayer.OnVideoDisplayCallback callback) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        ijkMediaPlayer.setOnVideoDisplayCallback(callback);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public MediaInfo getMediaInfo() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getMediaInfo();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayControlContext
    public String getPlayFailReason() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getIjkLoadFailReason();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void notifyRefreshFrame() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.notifyUpdate();
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public int getVideoHeight() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getVideoHeight();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public int getVideoWidth() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getVideoWidth();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setBackgroundColor(float red, float green, float blue, float alpha) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setBackgroundColor(red, green, blue, alpha);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setBackgroundImage(Bitmap bitmap, boolean recycle, Rect rect) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setBackgroundImage(bitmap, recycle, rect);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public int getVideoSarDen() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getVideoSarDen();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public int getVideoSarNum() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getVideoSarNum();
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setEnhance(boolean enable, IJKEXTRendererInterface.IjkEnhanceType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        IjkMediaPlayer ijkMediaPlayer2 = null;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setEnhance(enable, type);
        }
        IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
        if (ijkMediaPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
        } else {
            ijkMediaPlayer2 = ijkMediaPlayer3;
        }
        ijkMediaPlayer2.updateEnhanceInfoForTracker(enable, type);
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setBlurRectList(List<? extends RectF> list) {
        List rectList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(rectList, "rectList");
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setBlurRectList(rectList);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void clearBlurRect() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.clearBlurRect();
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setEnableMultiRender(boolean isEnable) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setEnableMultiRender(isEnable);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setMultiMainCaptureRect(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setMultiMainCaptureRect(rect);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setMultiSubWindowSurface(Surface surface) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setMultiSubWindowSurface(surface);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setMultiSubWindowCaptureRect(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setMultiSubWindowCaptureRect(rect);
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext
    public void setOnFrameRendererListener(IJKEXTRendererInterface.OnFrameRenderedListener listener) {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IJKPlayerExternalRender externalRender = ijkMediaPlayer.getExternalRender();
        if (externalRender != null) {
            externalRender.setOnFrameRenderedListener(listener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T cast(Object src, T t) {
        if (t == null) {
            return src;
        }
        Class targetClazz = t.getClass();
        if (targetClazz.isInstance(src)) {
            return (T) targetClazz.cast(src);
        }
        return t;
    }

    private final long getPropetyLong(Bundle bundle, int key) {
        if (bundle == null) {
            return 0L;
        }
        try {
            String string = bundle.getString(String.valueOf(key));
            long ret = string != null ? Long.parseLong(string) : 0L;
            return ret;
        } catch (Exception err) {
            err.printStackTrace();
            return 0L;
        }
    }

    private final long getPlayerError() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getPlayerErrorCode();
    }

    private final long getItemError() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        IjkMediaPlayerItem item = ijkMediaPlayer.getIjkMediaPlayerItem();
        if (item == null) {
            BLog.i(TAG, "getItemError: null 'IjkMediaPlayerItem'");
            return 0L;
        }
        return item.getItemError();
    }

    private final float getAvDiff() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getAvdiff();
    }

    private final float getDropFrame() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getDropFrameRate();
    }

    private final long getCacheCurBitrate() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getCacheCurBitrate();
    }

    private final long getCacheCurTcpSpeed() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getTcpSpeed();
    }

    private final long getVideoCacheDuration() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getVideoCachedDuration();
    }

    private final long getAudioCachedDuration() {
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayer");
            ijkMediaPlayer = null;
        }
        return ijkMediaPlayer.getAudioCachedDuration();
    }
}