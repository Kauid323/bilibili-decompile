package tv.danmaku.video.bilicardplayer.player;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.os.TraceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bilibili.app.gemini.base.resolver.ArchiveInfo;
import com.bilibili.app.gemini.base.resolver.PlayerResolveExtraInfosUtilKt;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.media.resource.ExtraInfo;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.resource.PlayIndex;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.player.history.IMediaHistoryKeyParams;
import com.bilibili.player.history.IMediaHistoryStorage;
import com.bilibili.player.history.MediaHistoryEntry;
import com.bilibili.player.history.MediaHistoryHelper;
import com.bilibili.playerbizcommon.features.daltonism.PlayerRenderFilterService;
import com.bilibili.playerbizcommon.features.hardware.HardwareService;
import com.bilibili.playerbizcommon.features.hardware.IHardwareDelegate;
import com.bilibili.playerbizcommon.features.headset.IPlayerHeadsetEventCallback;
import com.bilibili.playerbizcommon.features.headset.MediaSessionControllerCallback;
import com.bilibili.playerbizcommon.features.headset.PlayerHeadsetService;
import com.bilibili.playerbizcommon.features.network.INetworkAlertHandler;
import com.bilibili.playerbizcommon.features.network.INetworkToastHandler;
import com.bilibili.playerbizcommon.features.network.PlayerNetworkService;
import com.bilibili.playerbizcommon.features.network.ShowAlertMode;
import com.bilibili.playerbizcommon.features.network.VideoEnvironment;
import com.bilibili.playerbizcommon.features.network.VideoEnvironmentObserver;
import com.bilibili.playerbizcommon.gesture.GestureService;
import com.bilibili.playerbizcommon.gesture.IGestureService;
import com.bilibili.playerbizcommon.gesture.OnDoubleTapListener;
import com.bilibili.playerbizcommon.gesture.OnLongPressListener;
import com.bilibili.playerbizcommon.gesture.OnSingleTapListener;
import com.bilibili.playerbizcommon.mediasession.IMediaSessionPlayback;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.bili.wauth.WAuthErrorMsg;
import tv.danmaku.biliplayer.preload.strategy.PlayerPreloadConfigKt;
import tv.danmaku.biliplayerv2.BuildConfig;
import tv.danmaku.biliplayerv2.BusinessServiceLauncher;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.PlayerConfiguration;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.clock.PlayerProgressRangeObserver;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.panel.IPanelContainer;
import tv.danmaku.biliplayerv2.profiler.PlayerProfiler;
import tv.danmaku.biliplayerv2.profiler.ProfilerHandler;
import tv.danmaku.biliplayerv2.profiler.ProfilerTags;
import tv.danmaku.biliplayerv2.service.BufferingObserver;
import tv.danmaku.biliplayerv2.service.ControlContainerObserver;
import tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver;
import tv.danmaku.biliplayerv2.service.CurrentVideoPointer;
import tv.danmaku.biliplayerv2.service.ICurrentPositionInterceptor;
import tv.danmaku.biliplayerv2.service.IDurationInterceptor;
import tv.danmaku.biliplayerv2.service.IMediaItemParamsInterceptor;
import tv.danmaku.biliplayerv2.service.IMediaResourceObserver;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerPerformanceListener;
import tv.danmaku.biliplayerv2.service.IPlayerReleaseObserver;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.service.ISeekInterceptor;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.PlayerErrorObserver;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.service.PlayerSeekObserver;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.service.audio.AudioFocusService;
import tv.danmaku.biliplayerv2.service.interact.biz.IDanmakuParamsChangeObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.OnChronosReadyCallback;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuConfigChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.ShipChainChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.service.interact.core.DanmakuVisibleObserver;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.service.lock.DisablePlayLock;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.service.report.PlayScene;
import tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatService;
import tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask;
import tv.danmaku.biliplayerv2.service.resolve.CommonResolveTaskProvider;
import tv.danmaku.biliplayerv2.service.resolve.DefaultCommonResolveTaskProvider;
import tv.danmaku.biliplayerv2.service.setting.ICloudConfigObserver;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.utils.PlayerCloudConfig;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BlockListStorageUtils;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BlockedKeywords;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.UserKeywordItem;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.video.bilicardplayer.CardDanmakuManager;
import tv.danmaku.video.bilicardplayer.CardPlayerLog;
import tv.danmaku.video.bilicardplayer.CardTaskRepository;
import tv.danmaku.video.bilicardplayer.DataRelationShipChain;
import tv.danmaku.video.bilicardplayer.ICardPlayBufferingCallback;
import tv.danmaku.video.bilicardplayer.ICardPlaySateChangedCallback;
import tv.danmaku.video.bilicardplayer.ICardPlayerContext;
import tv.danmaku.video.bilicardplayer.ICardPlayerInfoListener;
import tv.danmaku.video.bilicardplayer.IControlContainerChangedCallback;
import tv.danmaku.video.bilicardplayer.IControlContainerVisibleCallback;
import tv.danmaku.video.bilicardplayer.IDanmakuParamsChangedCallback;
import tv.danmaku.video.bilicardplayer.IDanmakuStateChangedCallback;
import tv.danmaku.video.bilicardplayer.INetworkAlertCallback;
import tv.danmaku.video.bilicardplayer.IPlayerRenderCallback;
import tv.danmaku.video.bilicardplayer.IPlayerSeekCallback;
import tv.danmaku.video.bilicardplayer.IVideoEnvironmentChangedCallback;
import tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo;
import tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer;
import tv.danmaku.video.bilicardplayer.player.ICardPlayTask;
import tv.danmaku.video.bilicardplayer.utils.ConfigUtils;
import tv.danmaku.videoplayer.core.media.mediacenter.record.PlayerType;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;
import tv.danmaku.videoplayer.coreV2.MediaItem;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: DefaultCardPlayer.kt */
@Metadata(d1 = {"\u0000Ê\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0016GLORUX[^cfinqtwz\u0080\u0001\u0083\u0001\u008d\u0001\u0018\u0000 ã\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0002ã\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010k\u001a\u00020lH\u0002J\u000b\u0010\u0085\u0001\u001a\u0004\u0018\u00010*H\u0002J1\u0010\u0086\u0001\u001a\u00020l2\b\u0010B\u001a\u0004\u0018\u00010C2\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\u0088\u0001\u001a\u00020:2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0016J'\u0010\u008b\u0001\u001a\u00020l2\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\u0088\u0001\u001a\u00020:2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0002J\t\u0010\u008f\u0001\u001a\u00020lH\u0002J\t\u0010\u0090\u0001\u001a\u00020\u0002H\u0016J\t\u0010\u0091\u0001\u001a\u00020lH\u0016J\u0012\u0010\u0092\u0001\u001a\u00020l2\u0007\u0010\u0093\u0001\u001a\u00020CH\u0016J\t\u0010\u0094\u0001\u001a\u00020lH\u0002J\u0013\u0010\u0097\u0001\u001a\u00020l2\b\u0010\u0087\u0001\u001a\u00030\u0098\u0001H\u0002J\t\u0010\u0099\u0001\u001a\u00020lH\u0002J\u001c\u0010\u009a\u0001\u001a\u00020l2\u0011\u0010\u009b\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u009d\u00010\u009c\u0001H\u0002J\u001c\u0010\u009e\u0001\u001a\u00020l2\u0011\u0010\u009b\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u009d\u00010\u009c\u0001H\u0002J\u0012\u0010\u009f\u0001\u001a\u00020l2\u0007\u0010 \u0001\u001a\u000204H\u0002J\u0012\u0010¡\u0001\u001a\u00020l2\u0007\u0010¢\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010£\u0001\u001a\u00020l2\u0007\u0010¤\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010¥\u0001\u001a\u00020l2\u0007\u0010¤\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010¦\u0001\u001a\u00020l2\u0007\u0010¤\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010§\u0001\u001a\u00020l2\u0007\u0010¨\u0001\u001a\u000204H\u0002J\t\u0010©\u0001\u001a\u00020lH\u0002J\u0012\u0010ª\u0001\u001a\u00020l2\u0007\u0010¤\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010«\u0001\u001a\u00020l2\u0007\u0010¤\u0001\u001a\u00020\u000fH\u0002J\u0013\u0010¬\u0001\u001a\u00030\u00ad\u00012\u0007\u0010®\u0001\u001a\u00020~H\u0002J\u0012\u0010¯\u0001\u001a\u00020l2\u0007\u0010°\u0001\u001a\u00020:H\u0016J\u0012\u0010±\u0001\u001a\u00020l2\u0007\u0010°\u0001\u001a\u00020:H\u0002J\u0012\u0010²\u0001\u001a\u00020l2\u0007\u0010°\u0001\u001a\u00020:H\u0002J\t\u0010³\u0001\u001a\u00020lH\u0016J\u0012\u0010´\u0001\u001a\u00020l2\u0007\u0010µ\u0001\u001a\u000204H\u0016J\u0012\u0010¶\u0001\u001a\u00020l2\u0007\u0010·\u0001\u001a\u000204H\u0016J\u0012\u0010¸\u0001\u001a\u00020l2\u0007\u0010·\u0001\u001a\u000204H\u0016J\u0019\u0010¹\u0001\u001a\u0012\u0012\u0005\u0012\u00030º\u0001\u0012\u0005\u0012\u00030º\u0001\u0018\u00010.H\u0016J\t\u0010»\u0001\u001a\u000206H\u0016J\t\u0010¼\u0001\u001a\u000206H\u0016J\t\u0010½\u0001\u001a\u00020lH\u0016J\t\u0010¾\u0001\u001a\u00020lH\u0016J\t\u0010¿\u0001\u001a\u00020:H\u0016J\t\u0010À\u0001\u001a\u000206H\u0016J\t\u0010Á\u0001\u001a\u000206H\u0016J\t\u0010Â\u0001\u001a\u00020lH\u0016J\t\u0010Ã\u0001\u001a\u00020lH\u0016J\t\u0010Ä\u0001\u001a\u00020,H\u0016J\u0012\u0010Å\u0001\u001a\u00020l2\u0007\u0010Æ\u0001\u001a\u00020:H\u0016J\u0012\u0010Ç\u0001\u001a\u00020l2\u0007\u0010È\u0001\u001a\u00020,H\u0016J:\u0010É\u0001\u001a\u00020l\"\n\b\u0000\u0010Ê\u0001*\u00030\u009d\u00012\u0011\u0010\u009b\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u0003HÊ\u00010\u009c\u00012\u0010\u0010Ë\u0001\u001a\u000b\u0012\u0005\u0012\u0003HÊ\u0001\u0018\u00010\u0015H\u0016JA\u0010Ì\u0001\u001a\u00020l\"\n\b\u0000\u0010Ê\u0001*\u00030\u009d\u00012\u0011\u0010\u009b\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u0003HÊ\u00010\u009c\u00012\u000e\u0010Ë\u0001\u001a\t\u0012\u0005\u0012\u0003HÊ\u00010\u00152\u0007\u0010Í\u0001\u001a\u000204H\u0016J%\u0010Î\u0001\u001a\u00020l\"\n\b\u0000\u0010Ê\u0001*\u00030\u009d\u00012\u000e\u0010Ë\u0001\u001a\t\u0012\u0005\u0012\u0003HÊ\u00010\u0015H\u0016J\u001c\u0010Ï\u0001\u001a\u00020l2\u0011\u0010\u009b\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u009d\u00010\u009c\u0001H\u0016J\u0012\u0010Ð\u0001\u001a\u00020l2\u0007\u0010Ñ\u0001\u001a\u000202H\u0016J\t\u0010Ò\u0001\u001a\u000204H\u0016J\u001b\u0010Ó\u0001\u001a\u00020:2\u0007\u0010Ô\u0001\u001a\u0002042\u0007\u0010Õ\u0001\u001a\u000204H\u0016JD\u0010Ö\u0001\u001a\u00020l2\n\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u00012\u0011\u0010Ù\u0001\u001a\f\u0012\u0005\u0012\u00030Û\u0001\u0018\u00010Ú\u00012\u0011\u0010Ü\u0001\u001a\f\u0012\u0005\u0012\u00030º\u0001\u0018\u00010Ú\u00012\u0007\u0010Ý\u0001\u001a\u000204H\u0016J\t\u0010Þ\u0001\u001a\u00020lH\u0016J\t\u0010ß\u0001\u001a\u00020lH\u0016J\f\u0010à\u0001\u001a\u0005\u0018\u00010á\u0001H\u0016J\u0013\u0010â\u0001\u001a\u00020l2\b\u0010Ñ\u0001\u001a\u00030ã\u0001H\u0016J\u0013\u0010ä\u0001\u001a\u00020l2\b\u0010Ñ\u0001\u001a\u00030ã\u0001H\u0016J\u0013\u0010å\u0001\u001a\u00020l2\b\u0010Ñ\u0001\u001a\u00030æ\u0001H\u0016J\u0013\u0010ç\u0001\u001a\u00020l2\b\u0010Ñ\u0001\u001a\u00030æ\u0001H\u0016J\n\u0010è\u0001\u001a\u00030é\u0001H\u0016J\u0012\u0010ê\u0001\u001a\u00020l2\u0007\u0010 \u0001\u001a\u000204H\u0016J\t\u0010ë\u0001\u001a\u000204H\u0016J\f\u0010ì\u0001\u001a\u0005\u0018\u00010í\u0001H\u0016J\t\u0010î\u0001\u001a\u00020lH\u0016J\u0012\u0010ï\u0001\u001a\u00020l2\u0007\u0010¨\u0001\u001a\u000204H\u0016J\t\u0010ð\u0001\u001a\u00020lH\u0016J\t\u0010ñ\u0001\u001a\u000206H\u0016J\u0012\u0010ò\u0001\u001a\u00020l2\u0007\u0010ó\u0001\u001a\u000206H\u0016J\u0013\u0010ô\u0001\u001a\u00020l2\b\u0010õ\u0001\u001a\u00030ö\u0001H\u0016J\n\u0010÷\u0001\u001a\u00030ö\u0001H\u0016J\t\u0010ø\u0001\u001a\u00020lH\u0016J\t\u0010ù\u0001\u001a\u00020lH\u0016J\u0013\u0010ú\u0001\u001a\u00020l2\b\u0010û\u0001\u001a\u00030ü\u0001H\u0016J\n\u0010ý\u0001\u001a\u00030º\u0001H\u0016J%\u0010þ\u0001\u001a\u00020l2\b\u0010ÿ\u0001\u001a\u00030\u0080\u00022\u0007\u0010\u0081\u0002\u001a\u00020:2\u0007\u0010\u0082\u0002\u001a\u00020:H\u0016J\u0013\u0010\u0083\u0002\u001a\u00020l2\b\u0010\u0084\u0002\u001a\u00030\u0085\u0002H\u0016J\t\u0010\u0086\u0002\u001a\u00020:H\u0016J\t\u0010\u0087\u0002\u001a\u00020:H\u0016J'\u0010\u0088\u0002\u001a\u00020l2\u0013\u0010\u0089\u0002\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020/0.2\u0007\u0010\u008a\u0002\u001a\u00020,H\u0016J\t\u0010\u008b\u0002\u001a\u00020lH\u0016J'\u0010\u008c\u0002\u001a\u00020l2\u0013\u0010\u0089\u0002\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020/0.2\u0007\u0010\u008a\u0002\u001a\u00020,H\u0002J\u0014\u0010\u008d\u0002\u001a\u00020l2\t\u0010\u008e\u0002\u001a\u0004\u0018\u00010*H\u0016J\t\u0010\u008f\u0002\u001a\u000204H\u0016J\u0013\u0010\u0090\u0002\u001a\u00020l2\b\u0010\u0091\u0002\u001a\u00030\u0092\u0002H\u0016J\u0012\u0010\u0093\u0002\u001a\u00020l2\u0007\u0010\u0094\u0002\u001a\u000204H\u0016J\u0013\u0010\u0095\u0002\u001a\u00020l2\b\u0010\u0096\u0002\u001a\u00030\u0097\u0002H\u0016J\u0013\u0010\u0098\u0002\u001a\u00020l2\b\u0010\u0096\u0002\u001a\u00030\u0097\u0002H\u0016J\u0013\u0010\u0099\u0002\u001a\u00020l2\b\u0010\u0096\u0002\u001a\u00030\u009a\u0002H\u0016J\u0013\u0010\u009b\u0002\u001a\u00020l2\b\u0010\u0096\u0002\u001a\u00030\u009a\u0002H\u0016J\u0013\u0010\u009c\u0002\u001a\u00020l2\b\u0010\u0096\u0002\u001a\u00030\u009d\u0002H\u0016J\u0013\u0010\u009e\u0002\u001a\u00020l2\b\u0010\u0096\u0002\u001a\u00030\u009d\u0002H\u0016J%\u0010\u009f\u0002\u001a\u00020l2\b\u0010Ñ\u0001\u001a\u00030 \u00022\u0007\u0010¡\u0002\u001a\u0002062\u0007\u0010¢\u0002\u001a\u000206H\u0016J\u0013\u0010£\u0002\u001a\u00020l2\b\u0010Ñ\u0001\u001a\u00030 \u0002H\u0016J\u0013\u0010¤\u0002\u001a\u00020l2\b\u0010Ñ\u0001\u001a\u00030¥\u0002H\u0016J\u0013\u0010¦\u0002\u001a\u00020l2\b\u0010Ñ\u0001\u001a\u00030¥\u0002H\u0016J\u001b\u0010§\u0002\u001a\u00020l2\u0010\u0010¨\u0002\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030©\u0002H\u0016J\u001b\u0010ª\u0002\u001a\u00020l2\u0010\u0010¨\u0002\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030©\u0002H\u0016J\f\u0010«\u0002\u001a\u0005\u0018\u00010¬\u0002H\u0016J\u0013\u0010\u00ad\u0002\u001a\u00020l2\b\u0010®\u0002\u001a\u00030¯\u0002H\u0016J\u0015\u0010°\u0002\u001a\u0005\u0018\u00010±\u00022\u0007\u0010Í\u0001\u001a\u000204H\u0016J\f\u0010²\u0002\u001a\u0005\u0018\u00010³\u0002H\u0016J\u0013\u0010´\u0002\u001a\u00020l2\b\u0010µ\u0002\u001a\u00030³\u0002H\u0016J\u0015\u0010¶\u0002\u001a\u00020l2\n\u0010ÿ\u0001\u001a\u0005\u0018\u00010·\u0002H\u0016J\t\u0010¸\u0002\u001a\u00020lH\u0016J\u0012\u0010¹\u0002\u001a\u00020l2\u0007\u0010º\u0002\u001a\u00020:H\u0016J\u0012\u0010»\u0002\u001a\u00020l2\u0007\u0010¼\u0002\u001a\u000204H\u0016J\u0012\u0010½\u0002\u001a\u00020l2\u0007\u0010¾\u0002\u001a\u000204H\u0016J\u001d\u0010¿\u0002\u001a\u00020l2\b\u0010À\u0002\u001a\u00030Á\u00022\b\u0010Â\u0002\u001a\u00030Ã\u0002H\u0016J*\u0010Ä\u0002\u001a\u00020l2\n\u0010Å\u0002\u001a\u0005\u0018\u00010Æ\u00022\u0007\u0010Ç\u0002\u001a\u0002042\n\u0010È\u0002\u001a\u0005\u0018\u00010Ø\u0001H\u0016J#\u0010É\u0002\u001a\u00020l2\u0018\u0010Ê\u0002\u001a\u0013\u0012\u000e\u0012\f\u0012\u0007\b\u0001\u0012\u00030\u009d\u00010\u009c\u00010Ú\u0001H\u0002J#\u0010Ë\u0002\u001a\u00020l2\u0018\u0010Ê\u0002\u001a\u0013\u0012\u000e\u0012\f\u0012\u0007\b\u0001\u0012\u00030\u009d\u00010\u009c\u00010Ú\u0001H\u0002J\u001a\u0010Ì\u0002\u001a\u00020l2\u000f\u0010Í\u0002\u001a\n\u0012\u0005\u0012\u00030Î\u00020Ú\u0001H\u0002J\u001a\u0010Ï\u0002\u001a\u00020l2\u000f\u0010Í\u0002\u001a\n\u0012\u0005\u0012\u00030Î\u00020Ú\u0001H\u0002J\u001f\u0010Ñ\u0002\u001a\u0004\u0018\u00010\u000f2\t\u0010Ò\u0002\u001a\u0004\u0018\u00010\u000f2\u0007\u0010Ó\u0002\u001a\u000204H\u0017J\u001b\u0010Ô\u0002\u001a\u00020l2\u0007\u0010Ó\u0002\u001a\u0002042\u0007\u0010Õ\u0002\u001a\u00020\u000fH\u0002J\t\u0010Ö\u0002\u001a\u00020lH\u0002J\u0012\u0010×\u0002\u001a\u0002042\u0007\u0010¤\u0001\u001a\u00020\u000fH\u0002J\t\u0010Ø\u0002\u001a\u00020lH\u0002J\u0012\u0010Ù\u0002\u001a\u00020l2\u0007\u0010\u0093\u0001\u001a\u00020CH\u0016J\t\u0010Ú\u0002\u001a\u00020lH\u0002J\u0012\u0010Û\u0002\u001a\u00020l2\u0007\u0010\u0093\u0001\u001a\u00020CH\u0016J\t\u0010Ü\u0002\u001a\u00020lH\u0002J\u0012\u0010Ý\u0002\u001a\u00020l2\u0007\u0010\u0093\u0001\u001a\u00020CH\u0016J\t\u0010Þ\u0002\u001a\u00020lH\u0002J\u0012\u0010ß\u0002\u001a\u00020l2\u0007\u0010\u0093\u0001\u001a\u00020CH\u0016J\t\u0010à\u0002\u001a\u00020lH\u0002J\u0012\u0010á\u0002\u001a\u00020l2\u0007\u0010\u0093\u0001\u001a\u00020CH\u0016J\t\u0010â\u0002\u001a\u00020lH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020/0.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020/0.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0004\n\u0002\u0010HR\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0004\n\u0002\u0010MR\u0010\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0004\n\u0002\u0010PR\u0010\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0004\n\u0002\u0010SR\u0010\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0004\n\u0002\u0010VR\u0010\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0004\n\u0002\u0010YR\u0010\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\\R\u0010\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0004\n\u0002\u0010_R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u00020cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010dR\u0010\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010gR\u0010\u0010h\u001a\u00020iX\u0082\u0004¢\u0006\u0004\n\u0002\u0010jR\u0010\u0010m\u001a\u00020nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010oR\u0010\u0010p\u001a\u00020qX\u0082\u0004¢\u0006\u0004\n\u0002\u0010rR\u0010\u0010s\u001a\u00020tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010uR\u0010\u0010v\u001a\u00020wX\u0082\u0004¢\u0006\u0004\n\u0002\u0010xR\u0010\u0010y\u001a\u00020zX\u0082\u0004¢\u0006\u0004\n\u0002\u0010{R\u001a\u0010|\u001a\u000e\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u00020l0}X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u007f\u001a\u00030\u0080\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u0081\u0001R\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0084\u0001R\u0013\u0010\u008c\u0001\u001a\u00030\u008d\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008e\u0001R\u0012\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ð\u0002\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ä\u0002"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer;", "Ltv/danmaku/video/bilicardplayer/player/IBiliCardPlayer;", "Ltv/danmaku/video/bilicardplayer/ICardPlayerContext;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "mContext", "Landroid/content/Context;", "mPlayerRootView", "Landroid/view/View;", "mRootViewLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "mCardPlayTask", "Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask;", "mBiliCardPlayerDataSource", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerDataSource;", "mBusinessServiceLauncher", "Ltv/danmaku/biliplayerv2/BusinessServiceLauncher;", "mCardQualityServiceClient", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "Ltv/danmaku/video/bilicardplayer/player/CardPlayerQualityService;", "mHardwareServiceClient", "Lcom/bilibili/playerbizcommon/features/hardware/HardwareService;", "mNetworkServiceClient", "Lcom/bilibili/playerbizcommon/features/network/PlayerNetworkService;", "mPlayerRenderFilterClient", "Lcom/bilibili/playerbizcommon/features/daltonism/PlayerRenderFilterService;", "mPlayerHeadsetServiceClient", "Lcom/bilibili/playerbizcommon/features/headset/PlayerHeadsetService;", "mGestureClient", "Lcom/bilibili/playerbizcommon/gesture/GestureService;", "mAudioFocusClient", "Ltv/danmaku/biliplayerv2/service/audio/AudioFocusService;", "resolveProvider", "Ltv/danmaku/biliplayerv2/service/resolve/DefaultCommonResolveTaskProvider;", "getResolveProvider", "()Ltv/danmaku/biliplayerv2/service/resolve/DefaultCommonResolveTaskProvider;", "resolveProvider$delegate", "Lkotlin/Lazy;", "mDefaultCustomHardwareDelegate", "Lcom/bilibili/playerbizcommon/features/hardware/IHardwareDelegate;", "mCurrentContainerType", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "mDefaultControlContainerConfig", "", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "mCurrentControlContainerConfig", "mPlayerReadyObserver", "Ltv/danmaku/video/bilicardplayer/player/CardPlayerReadyObserver;", "mIsReady", "", "mPendingSeekPosition", "", "mDisablePlayLock", "Ltv/danmaku/biliplayerv2/service/lock/DisablePlayLock;", "mPendingPlaySharedId", "", "alreadyLoadedHardwareService", "mCardVideoPlayHandler", "Ltv/danmaku/video/bilicardplayer/player/CardVideoPlayHandler;", "mCardDanmakuManager", "Ltv/danmaku/video/bilicardplayer/CardDanmakuManager;", "mWaitRenderStart", "isApplicationPlayer", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "mFirstFrameListener", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$OnFirstFrameListener;", "mHardwareDelegate", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mHardwareDelegate$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mHardwareDelegate$1;", "mPerformanceListener", "Ltv/danmaku/biliplayerv2/service/IPlayerPerformanceListener;", "mRenderStartObserver", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mRenderStartObserver$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mRenderStartObserver$1;", "mVideoSizeChangeObserver", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mVideoSizeChangeObserver$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mVideoSizeChangeObserver$1;", "mPlayerErrorObserver", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mPlayerErrorObserver$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mPlayerErrorObserver$1;", "mPlayerStateObserver", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mPlayerStateObserver$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mPlayerStateObserver$1;", "mPlayerBufferingObserver", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mPlayerBufferingObserver$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mPlayerBufferingObserver$1;", "mMediaResourceObserver", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mMediaResourceObserver$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mMediaResourceObserver$1;", "mVideoPlayEventListener", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mVideoPlayEventListener$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mVideoPlayEventListener$1;", "mTaskMediaItemParamsInterceptor", "Ltv/danmaku/biliplayerv2/service/IMediaItemParamsInterceptor;", "mMediaItemParamsInterceptor", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mMediaItemParamsInterceptor$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mMediaItemParamsInterceptor$1;", "mControlContainerObserver", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mControlContainerObserver$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mControlContainerObserver$1;", "mControlContainerVisibleObserver", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mControlContainerVisibleObserver$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mControlContainerVisibleObserver$1;", "preloadDamankuFilter", "", "mDanmakuVisibleCallback", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mDanmakuVisibleCallback$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mDanmakuVisibleCallback$1;", "mDanmakuParamsCallback", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mDanmakuParamsCallback$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mDanmakuParamsCallback$1;", "mNetworkAlertHandler", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mNetworkAlertHandler$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mNetworkAlertHandler$1;", "mVideoEnvironmentObserver", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mVideoEnvironmentObserver$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mVideoEnvironmentObserver$1;", "mIgnoreNetworkToastHandler", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mIgnoreNetworkToastHandler$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mIgnoreNetworkToastHandler$1;", "mRelationShipChangedObserver", "Lkotlin/Function1;", "Ltv/danmaku/video/bilicardplayer/DataRelationShipChain;", "mPlayerReleaseObserver", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mPlayerReleaseObserver$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mPlayerReleaseObserver$1;", "mPlayerSeekObserver", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mPlayerSeekObserver$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mPlayerSeekObserver$1;", "hardwareDelegate", "initialize", "context", "sharedId", "extraConfiguration", "Ltv/danmaku/video/bilicardplayer/player/PlayerExtraConfiguration;", "initializeInternal", "preloadHandler", "tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$preloadHandler$1", "Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$preloadHandler$1;", "initPreloadReport", "getCardPlayerContext", "release", "onCreate", "owner", "onCreateInternal", "mWindowFocusChangeListener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "initHardwareService", "Landroidx/fragment/app/FragmentActivity;", "showPlayerIfNeed", "startServiceInternal", "clazz", "Ljava/lang/Class;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "stopServiceInternal", "setPlayEnable", "enable", "checkRequestWillAttach", "task", "attachToTask", "cardPlayTask", "attachTaskInMainThread", "attachTaskInternal", "setAudioMute", "isMute", "handleResetAudioIndex", "checkLiveInline", "reqLiveInlineChronos", "translateRelationShipChain", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ShipChainChange$Request;", "data", "play", "index", "playInMainThread", "playInternal", "pause", "setAudioOnly", "audioOnly", "showDanmaku", "fromUser", "hideDanmaku", "getDanmakuReportParams", "", "getCurrentPosition", "getRealCurrentPosition", "replay", "reload", "getPlayerState", "getDuration", "getRealDuration", "hideControl", "showControl", "getCurrentControlContainerType", "switchOrientation", "orientation", "setControlContainerType", "type", "startService", "T", "client", "bindService", "autoCreate", "unbindService", "stopService", "listenPlayerReady", "observer", "isReady", "prepareForShare", "keepRender", "needMute", "updateViewPort", "viewPort", "Landroid/graphics/Rect;", "builtInLayers", "", "Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;", "customerLayers", "immediately", "resume", "stop", "getVideoEnvironment", "Lcom/bilibili/playerbizcommon/features/network/VideoEnvironment;", "addCloudConfigObserver", "Ltv/danmaku/biliplayerv2/service/setting/ICloudConfigObserver;", "removeCloudConfigObserver", "addHeadsetEventObserver", "Lcom/bilibili/playerbizcommon/features/headset/IPlayerHeadsetEventCallback;", "removeHeadsetEventObserver", "getPlayerSettingCloudConfig", "Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig;", "setNetworkAlertEnable", "isNetworkPanelShowed", "getCurrentPlayableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "show", "setMute", "allowToContinuePlay", "getBufferedPosition", "seekTo", "targetPosition", "setPlaySpeed", "speed", "", "getPlaySpeed", "hideBufferingView", "showBufferingView", "report", "event", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "getCurrentPlayUrl", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "width", "height", "setAspectRatio", "ratio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "getVideoWidth", "getVideoHeight", "setControlContainerConfig", "config", "initializeType", "resetVideoFlip", "applyControlContainerConfig", "setHardwareDelegate", "delegate", "performBackPressed", "performConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "performMultiWindowModeChanged", "isInMultiWindowMode", "addDoubleTapListener", "listener", "Lcom/bilibili/playerbizcommon/gesture/OnDoubleTapListener;", "removerDoubleTapListener", "addSingleTapListener", "Lcom/bilibili/playerbizcommon/gesture/OnSingleTapListener;", "removerSingleTapListener", "addLongPressListener", "Lcom/bilibili/playerbizcommon/gesture/OnLongPressListener;", "removeLongPressListener", "registerPlayerProgressRangeObserver", "Ltv/danmaku/biliplayerv2/clock/PlayerProgressRangeObserver;", "startPosition", "endPosition", "unregisterPlayerProgressRangeObserver", "registerPlayerProgressObserver", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "unregisterPlayerProgressObserver", "registerChronosMessageHandler", "handler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRequestHandler;", "unregisterChronosMessageHandler", "getChronosRemoteHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;", "setVisibleRect", "visibleRect", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;", "getMediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "getMediaSessionPlayback", "Lcom/bilibili/playerbizcommon/mediasession/IMediaSessionPlayback;", "setMediaSessionPlayback", "playback", "setMediaSessionControllerCallback", "Lcom/bilibili/playerbizcommon/features/headset/MediaSessionControllerCallback;", "updateMediaSessionPlaybackState", "setRenderViewOffset", "offsetY", "blockBottomChronos", "block", "setDanmakuAvoidScript", "avoidScript", "setSceneAndBizParams", LoginSceneProcessor.SCENE_KEY, "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "biz", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;", "setBackgroundImage", "bitmap", "Landroid/graphics/Bitmap;", "recycle", "rect", "installRequestServices", "services", "uninstallRequestServices", "installRequestLayer", "layerDescriptors", "Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask$PlayerLayerDescriptor;", "uninstallRequestLayer", "detachingTask", "detachFromTask", "detachTask", "changeContainer", "detachFromTaskInMainThread", WAuthErrorMsg.ERROR_MESSAGE_REQUEST, "resetChronosPackageForLiveInline", "isLiveInlineTask", "releaseCardDanmaku", "onStart", "onStartInternal", "onResume", "onResumeInternal", "onPause", "onPauseInternal", "onStop", "onStopInternal", "onDestroy", "onDestroyInternal", "Companion", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DefaultCardPlayer implements IBiliCardPlayer, ICardPlayerContext, DefaultLifecycleObserver {
    private static final String CARD_PLAYER_PLAY_NORMAL = "player.card.start.play-normal.track";
    private static final String CARD_PLAYER_PLAY_PRELOAD = "player.card.start.play-preload.track";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "DefaultCardPlayer";
    private boolean alreadyLoadedHardwareService;
    private volatile ICardPlayTask detachingTask;
    private boolean isApplicationPlayer;
    private LifecycleOwner lifecycleOwner;
    private BusinessServiceLauncher mBusinessServiceLauncher;
    private CardDanmakuManager mCardDanmakuManager;
    private ICardPlayTask mCardPlayTask;
    private CardVideoPlayHandler mCardVideoPlayHandler;
    private Context mContext;
    private IHardwareDelegate mDefaultCustomHardwareDelegate;
    private DisablePlayLock mDisablePlayLock;
    private boolean mIsReady;
    private IPlayerContainer mPlayerContainer;
    private CardPlayerReadyObserver mPlayerReadyObserver;
    private View mPlayerRootView;
    private IMediaItemParamsInterceptor mTaskMediaItemParamsInterceptor;
    private ViewTreeObserver.OnWindowFocusChangeListener mWindowFocusChangeListener;
    private final ViewGroup.LayoutParams mRootViewLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    private final BiliCardPlayerDataSource mBiliCardPlayerDataSource = new BiliCardPlayerDataSource();
    private final PlayerServiceManager.Client<CardPlayerQualityService> mCardQualityServiceClient = new PlayerServiceManager.Client<>();
    private final PlayerServiceManager.Client<HardwareService> mHardwareServiceClient = new PlayerServiceManager.Client<>();
    private final PlayerServiceManager.Client<PlayerNetworkService> mNetworkServiceClient = new PlayerServiceManager.Client<>();
    private final PlayerServiceManager.Client<PlayerRenderFilterService> mPlayerRenderFilterClient = new PlayerServiceManager.Client<>();
    private final PlayerServiceManager.Client<PlayerHeadsetService> mPlayerHeadsetServiceClient = new PlayerServiceManager.Client<>();
    private final PlayerServiceManager.Client<GestureService> mGestureClient = new PlayerServiceManager.Client<>();
    private final PlayerServiceManager.Client<AudioFocusService> mAudioFocusClient = new PlayerServiceManager.Client<>();
    private final Lazy resolveProvider$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$$ExternalSyntheticLambda2
        public final Object invoke() {
            DefaultCommonResolveTaskProvider resolveProvider_delegate$lambda$0;
            resolveProvider_delegate$lambda$0 = DefaultCardPlayer.resolveProvider_delegate$lambda$0();
            return resolveProvider_delegate$lambda$0;
        }
    });
    private ControlContainerType mCurrentContainerType = ControlContainerType.INITIAL;
    private Map<ControlContainerType, ControlContainerConfig> mDefaultControlContainerConfig = new EnumMap(ControlContainerType.class);
    private Map<ControlContainerType, ControlContainerConfig> mCurrentControlContainerConfig = this.mDefaultControlContainerConfig;
    private long mPendingSeekPosition = -1;
    private int mPendingPlaySharedId = -1;
    private boolean mWaitRenderStart = true;
    private final IJKEXTRendererInterface.OnFirstFrameListener mFirstFrameListener = new IJKEXTRendererInterface.OnFirstFrameListener() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$$ExternalSyntheticLambda3
        @Override // tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface.OnFirstFrameListener
        public final void onFirstFrame() {
            DefaultCardPlayer.mFirstFrameListener$lambda$0(DefaultCardPlayer.this);
        }
    };
    private final DefaultCardPlayer$mHardwareDelegate$1 mHardwareDelegate = new IHardwareDelegate() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mHardwareDelegate$1
        public /* synthetic */ boolean changeOrientationEnable() {
            return IHardwareDelegate.-CC.$default$changeOrientationEnable(this);
        }

        public /* synthetic */ boolean onAdjustWindowInset(WindowInset windowInset) {
            return IHardwareDelegate.-CC.$default$onAdjustWindowInset(this, windowInset);
        }

        public /* synthetic */ ControlContainerType onGetControlContainerType(ScreenModeType screenModeType) {
            return IHardwareDelegate.-CC.$default$onGetControlContainerType(this, screenModeType);
        }

        public /* synthetic */ ControlContainerType onGetControlContainerTypeForOrientation(int i) {
            return IHardwareDelegate.-CC.$default$onGetControlContainerTypeForOrientation(this, i);
        }

        public void onHandleSwitchControlContainerType(ControlContainerType type) {
            ControlContainerType controlContainerType;
            IHardwareDelegate hardwareDelegate;
            Intrinsics.checkNotNullParameter(type, "type");
            controlContainerType = DefaultCardPlayer.this.mCurrentContainerType;
            if (controlContainerType != type) {
                DefaultCardPlayer.this.mCurrentContainerType = type;
                hardwareDelegate = DefaultCardPlayer.this.hardwareDelegate();
                if (hardwareDelegate != null) {
                    hardwareDelegate.onHandleSwitchControlContainerType(type);
                }
            }
        }

        public boolean onAdjustControlContainerType(ScreenModeType curScreenModeType, Video.PlayableParams playableParams) {
            IHardwareDelegate hardwareDelegate;
            Intrinsics.checkNotNullParameter(curScreenModeType, "curScreenModeType");
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
            hardwareDelegate = DefaultCardPlayer.this.hardwareDelegate();
            if (hardwareDelegate != null) {
                return hardwareDelegate.onAdjustControlContainerType(curScreenModeType, playableParams);
            }
            return false;
        }
    };
    private final IPlayerPerformanceListener mPerformanceListener = new IPlayerPerformanceListener() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPerformanceListener$1
        @Override // tv.danmaku.biliplayerv2.service.IPlayerPerformanceListener
        public void onPlayerPrepared(long timestamp) {
        }

        @Override // tv.danmaku.biliplayerv2.service.IPlayerPerformanceListener
        public void onVideoFirstRender(final long timestamp) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo<ICardPlayerInfoListener> cardPlayInfoListeners;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (cardPlayInfoListeners = iCardPlayTask.getCardPlayInfoListeners()) == null) {
                return;
            }
            cardPlayInfoListeners.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlayerInfoListener>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPerformanceListener$1$onVideoFirstRender$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(ICardPlayerInfoListener callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    Long firstRenderTime = timestamp > 0 ? Long.valueOf(timestamp) : null;
                    callback.onInfo(2, firstRenderTime);
                }
            });
        }
    };
    private final DefaultCardPlayer$mRenderStartObserver$1 mRenderStartObserver = new DefaultCardPlayer$mRenderStartObserver$1(this);
    private final DefaultCardPlayer$mVideoSizeChangeObserver$1 mVideoSizeChangeObserver = new IVideoRenderLayer.OnVideoSizeChangedListener() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mVideoSizeChangeObserver$1
        @Override // tv.danmaku.render.core.IVideoRenderLayer.OnVideoSizeChangedListener
        public void onChanged(final int width, final int height) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getPlayerRenderCallbacks()) == null) {
                return;
            }
            callbacks.visit(new CardPlayerCallbacksInfo.Visitor<IPlayerRenderCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mVideoSizeChangeObserver$1$onChanged$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(IPlayerRenderCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    callback.onVideoSizeChanged(width, height);
                }
            });
        }
    };
    private final DefaultCardPlayer$mPlayerErrorObserver$1 mPlayerErrorObserver = new PlayerErrorObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerErrorObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerErrorObserver
        public void onPlayerError(IMediaPlayer player, int what, int extra) {
            ICardPlayTask iCardPlayTask;
            IPlayerContainer iPlayerContainer;
            Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask != null && DefaultCardPlayer.this.getPlayerState() != 6 && DefaultCardPlayer.this.getPlayerState() != 7 && DefaultCardPlayer.this.getPlayerState() != 5) {
                iPlayerContainer = DefaultCardPlayer.this.mPlayerContainer;
                if (iPlayerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer = null;
                }
                iPlayerContainer.getVideoPlayDirectorService().replayCurrentVideoItem();
            }
        }
    };
    private final DefaultCardPlayer$mPlayerStateObserver$1 mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerStateObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        public void onPlayerStateChanged(int state) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            IPlayerContainer iPlayerContainer;
            IPlayerContainer iPlayerContainer2;
            PlayIndex playIndex;
            String str;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getPlayerStateChangedCallbacks()) == null) {
                return;
            }
            switch (state) {
                case 2:
                    final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
                    callbacks.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlaySateChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerStateObserver$1$onPlayerStateChanged$1
                        @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                        public void onVisit(ICardPlaySateChangedCallback callback) {
                            Intrinsics.checkNotNullParameter(callback, "callback");
                            callback.onPreparing(DefaultCardPlayer.this);
                        }
                    });
                    return;
                case 3:
                    final DefaultCardPlayer defaultCardPlayer2 = DefaultCardPlayer.this;
                    callbacks.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlaySateChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerStateObserver$1$onPlayerStateChanged$2
                        @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                        public void onVisit(ICardPlaySateChangedCallback callback) {
                            Intrinsics.checkNotNullParameter(callback, "callback");
                            callback.onPrepared(DefaultCardPlayer.this);
                        }
                    });
                    if (ConfigUtils.INSTANCE.getLiveExpectLatency() > 0) {
                        iPlayerContainer = DefaultCardPlayer.this.mPlayerContainer;
                        IPlayerContainer iPlayerContainer3 = null;
                        if (iPlayerContainer == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                            iPlayerContainer = null;
                        }
                        MediaResource mediaResource = iPlayerContainer.getPlayerCoreService().getMediaResource();
                        boolean z = false;
                        if (mediaResource != null && (playIndex = mediaResource.getPlayIndex()) != null && (str = playIndex.mFrom) != null && str.equals("live")) {
                            z = true;
                        }
                        if (z) {
                            iPlayerContainer2 = DefaultCardPlayer.this.mPlayerContainer;
                            if (iPlayerContainer2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                            } else {
                                iPlayerContainer3 = iPlayerContainer2;
                            }
                            MediaItem<?> currentMediaItem = iPlayerContainer3.getPlayerCoreService().getCurrentMediaItem();
                            if (currentMediaItem != null) {
                                currentMediaItem.setExpectLatency(ConfigUtils.INSTANCE.getLiveExpectLatency(), true, true);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    final DefaultCardPlayer defaultCardPlayer3 = DefaultCardPlayer.this;
                    callbacks.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlaySateChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerStateObserver$1$onPlayerStateChanged$4
                        @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                        public void onVisit(ICardPlaySateChangedCallback callback) {
                            Intrinsics.checkNotNullParameter(callback, "callback");
                            callback.onResume(DefaultCardPlayer.this);
                        }
                    });
                    return;
                case 5:
                    final DefaultCardPlayer defaultCardPlayer4 = DefaultCardPlayer.this;
                    callbacks.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlaySateChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerStateObserver$1$onPlayerStateChanged$3
                        @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                        public void onVisit(ICardPlaySateChangedCallback callback) {
                            Intrinsics.checkNotNullParameter(callback, "callback");
                            callback.onPause(DefaultCardPlayer.this);
                        }
                    });
                    return;
                case 6:
                    final DefaultCardPlayer defaultCardPlayer5 = DefaultCardPlayer.this;
                    callbacks.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlaySateChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerStateObserver$1$onPlayerStateChanged$5
                        @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                        public void onVisit(ICardPlaySateChangedCallback callback) {
                            Intrinsics.checkNotNullParameter(callback, "callback");
                            callback.onCompleted(DefaultCardPlayer.this);
                        }
                    });
                    return;
                case 7:
                    final DefaultCardPlayer defaultCardPlayer6 = DefaultCardPlayer.this;
                    callbacks.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlaySateChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerStateObserver$1$onPlayerStateChanged$6
                        @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                        public void onVisit(ICardPlaySateChangedCallback callback) {
                            Intrinsics.checkNotNullParameter(callback, "callback");
                            callback.onStop(DefaultCardPlayer.this);
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    };
    private final DefaultCardPlayer$mPlayerBufferingObserver$1 mPlayerBufferingObserver = new BufferingObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerBufferingObserver$1
        @Override // tv.danmaku.biliplayerv2.service.BufferingObserver
        public void onBufferingStart(final int extra) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getPlayerBufferingCallback()) == null) {
                return;
            }
            callbacks.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlayBufferingCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerBufferingObserver$1$onBufferingStart$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(ICardPlayBufferingCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    callback.onBufferingStart(extra);
                }
            });
        }

        @Override // tv.danmaku.biliplayerv2.service.BufferingObserver
        public void onBufferingEnd() {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getPlayerBufferingCallback()) == null) {
                return;
            }
            callbacks.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlayBufferingCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerBufferingObserver$1$onBufferingEnd$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(ICardPlayBufferingCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    callback.onBufferingEnd();
                }
            });
        }
    };
    private final DefaultCardPlayer$mMediaResourceObserver$1 mMediaResourceObserver = new IMediaResourceObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mMediaResourceObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public /* synthetic */ void onUpdated(MediaResource mediaResource) {
            IMediaResourceObserver.CC.$default$onUpdated(this, mediaResource);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaResourceObserver
        public boolean onPrepared(final MediaResource resource) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getPlayerStateChangedCallbacks()) == null) {
                return true;
            }
            final Ref.BooleanRef playable = new Ref.BooleanRef();
            playable.element = true;
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callbacks.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlaySateChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mMediaResourceObserver$1$onPrepared$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(ICardPlaySateChangedCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    playable.element = playable.element && callback.onSourcePlayable(defaultCardPlayer, resource);
                }
            });
            return playable.element;
        }
    };
    private final DefaultCardPlayer$mVideoPlayEventListener$1 mVideoPlayEventListener = new IVideosPlayDirectorService.VideoPlayEventListener() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mVideoPlayEventListener$1
        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onAllVideoCompleted() {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onAllVideoCompleted(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onResolveFailed(Video video2, Video.PlayableParams playableParams, List list) {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveFailed(this, video2, playableParams, list);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onResolveSucceed() {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveSucceed(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoCompleted(Video video2) {
            Intrinsics.checkNotNullParameter(video2, "video");
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoItemCompleted(CurrentVideoPointer currentVideoPointer, Video video2) {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemCompleted(this, currentVideoPointer, video2);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoItemWillChange(CurrentVideoPointer currentVideoPointer, CurrentVideoPointer currentVideoPointer2, Video video2) {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemWillChange(this, currentVideoPointer, currentVideoPointer2, video2);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoSetChanged() {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoSetChanged(int i) {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this, i);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoSetWillChange() {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetWillChange(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoStart(Video video2) {
            Intrinsics.checkNotNullParameter(video2, "video");
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public /* synthetic */ void onVideoWillChange(Video video2, Video video3) {
            IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoWillChange(this, video2, video3);
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public void onVideoItemStart(CurrentVideoPointer item, Video video2) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            ICardPlayTask it;
            IPlayerContainer iPlayerContainer;
            IPlayerContainer iPlayerContainer2;
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(video2, "video");
            DefaultCardPlayer.this.mWaitRenderStart = true;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getPlayerStateChangedCallbacks()) == null) {
                return;
            }
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callbacks.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlaySateChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mVideoPlayEventListener$1$onVideoItemStart$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(ICardPlaySateChangedCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    callback.onStart(DefaultCardPlayer.this);
                }
            });
            it = DefaultCardPlayer.this.mCardPlayTask;
            if (it != null) {
                DefaultCardPlayer defaultCardPlayer2 = DefaultCardPlayer.this;
                final int customDuration = (int) it.getCustomFakeDuration();
                IPlayerContainer iPlayerContainer3 = null;
                if (customDuration > 0) {
                    iPlayerContainer2 = defaultCardPlayer2.mPlayerContainer;
                    if (iPlayerContainer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        iPlayerContainer3 = iPlayerContainer2;
                    }
                    iPlayerContainer3.getPlayerCoreService().setDurationInterceptor(new IDurationInterceptor() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mVideoPlayEventListener$1$onVideoItemStart$2$1
                        @Override // tv.danmaku.biliplayerv2.service.IDurationInterceptor
                        public int intercept(int duration) {
                            return customDuration;
                        }
                    });
                    return;
                }
                iPlayerContainer = defaultCardPlayer2.mPlayerContainer;
                if (iPlayerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer = null;
                }
                iPlayerContainer.getPlayerCoreService().setDurationInterceptor(null);
            }
        }

        @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
        public void onResolveFailed(Video video2, Video.PlayableParams playableParams, String errorMsg) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            Intrinsics.checkNotNullParameter(video2, "video");
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getPlayerStateChangedCallbacks()) == null) {
                return;
            }
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callbacks.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlaySateChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mVideoPlayEventListener$1$onResolveFailed$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(ICardPlaySateChangedCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    callback.onError(DefaultCardPlayer.this);
                }
            });
        }
    };
    private final DefaultCardPlayer$mMediaItemParamsInterceptor$1 mMediaItemParamsInterceptor = new IMediaItemParamsInterceptor() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mMediaItemParamsInterceptor$1
        @Override // tv.danmaku.biliplayerv2.service.IMediaItemParamsInterceptor
        public boolean interceptMediaItemParams(Video.PlayableParams playableParams, MediaItemParams.Builder itemParamsBuilder, boolean isUpdate) {
            boolean changed;
            IMediaItemParamsInterceptor iMediaItemParamsInterceptor;
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
            Intrinsics.checkNotNullParameter(itemParamsBuilder, "itemParamsBuilder");
            if (Intrinsics.areEqual(playableParams.getFrom(), "live") && ConfigUtils.INSTANCE.getLiveStartExpectLatency() > 0) {
                itemParamsBuilder.setLiveStartLatency(ConfigUtils.INSTANCE.getLiveStartExpectLatency());
                changed = true;
            } else {
                changed = false;
            }
            if (changed) {
                return true;
            }
            iMediaItemParamsInterceptor = DefaultCardPlayer.this.mTaskMediaItemParamsInterceptor;
            return iMediaItemParamsInterceptor != null && iMediaItemParamsInterceptor.interceptMediaItemParams(playableParams, itemParamsBuilder, isUpdate);
        }
    };
    private final DefaultCardPlayer$mControlContainerObserver$1 mControlContainerObserver = new ControlContainerObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mControlContainerObserver$1
        @Override // tv.danmaku.biliplayerv2.service.ControlContainerObserver
        public void onControlContainerChanged(final ControlContainerType state, final ScreenModeType screenType) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callback;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(screenType, "screenType");
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callback = iCardPlayTask.getControlContainerChangedCallbacks()) == null) {
                return;
            }
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callback.visit(new CardPlayerCallbacksInfo.Visitor<IControlContainerChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mControlContainerObserver$1$onControlContainerChanged$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(IControlContainerChangedCallback callback2) {
                    Intrinsics.checkNotNullParameter(callback2, "callback");
                    callback2.onChanged(DefaultCardPlayer.this, state, screenType);
                }
            });
        }
    };
    private final DefaultCardPlayer$mControlContainerVisibleObserver$1 mControlContainerVisibleObserver = new ControlContainerVisibleObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mControlContainerVisibleObserver$1
        @Override // tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver
        public /* synthetic */ void onControlContainerImmersiveChanged(int i, boolean z) {
            ControlContainerVisibleObserver.CC.$default$onControlContainerImmersiveChanged(this, i, z);
        }

        @Override // tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver
        public void onControlContainerVisibleChanged(final boolean visible) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getControlContainerVisibleCallbacks()) == null) {
                return;
            }
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callbacks.visit(new CardPlayerCallbacksInfo.Visitor<IControlContainerVisibleCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mControlContainerVisibleObserver$1$onControlContainerVisibleChanged$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(IControlContainerVisibleCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    if (visible) {
                        callback.onShow(defaultCardPlayer);
                    } else {
                        callback.onHide(defaultCardPlayer);
                    }
                }
            });
        }
    };
    private final DefaultCardPlayer$mDanmakuVisibleCallback$1 mDanmakuVisibleCallback = new DanmakuVisibleObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mDanmakuVisibleCallback$1
        @Override // tv.danmaku.biliplayerv2.service.interact.core.DanmakuVisibleObserver
        public void onDanmakuVisibleChanged(final boolean visible, boolean fromUser) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getDanmakuStateChangedCallbacks()) == null) {
                return;
            }
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callbacks.visit(new CardPlayerCallbacksInfo.Visitor<IDanmakuStateChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mDanmakuVisibleCallback$1$onDanmakuVisibleChanged$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(IDanmakuStateChangedCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    if (visible) {
                        callback.onShow(defaultCardPlayer);
                    } else {
                        callback.onHide(defaultCardPlayer);
                    }
                }
            });
        }
    };
    private final DefaultCardPlayer$mDanmakuParamsCallback$1 mDanmakuParamsCallback = new IDanmakuParamsChangeObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mDanmakuParamsCallback$1
        @Override // tv.danmaku.biliplayerv2.service.interact.biz.IDanmakuParamsChangeObserver
        public void onChanged(final DanmakuParams params) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            Intrinsics.checkNotNullParameter(params, "params");
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getDanmakuParamsChangedCallbacks()) == null) {
                return;
            }
            callbacks.visit(new CardPlayerCallbacksInfo.Visitor<IDanmakuParamsChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mDanmakuParamsCallback$1$onChanged$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(IDanmakuParamsChangedCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    DmViewReply dmViewReply = DanmakuParams.this.getDmViewReply();
                    callback.onChanged(new IDanmakuParamsChangedCallback.Params(dmViewReply != null ? dmViewReply.getClosed() : false));
                }
            });
        }
    };
    private final DefaultCardPlayer$mNetworkAlertHandler$1 mNetworkAlertHandler = new INetworkAlertHandler() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mNetworkAlertHandler$1
        public /* synthetic */ boolean onBackPressed() {
            return INetworkAlertHandler.-CC.$default$onBackPressed(this);
        }

        public /* synthetic */ void onContinueToPlay() {
            INetworkAlertHandler.-CC.$default$onContinueToPlay(this);
        }

        public void onAlertWidgetDismiss() {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callback;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callback = iCardPlayTask.getNetworkAlertCallbacks()) == null) {
                return;
            }
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callback.visit(new CardPlayerCallbacksInfo.Visitor<INetworkAlertCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mNetworkAlertHandler$1$onAlertWidgetDismiss$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(INetworkAlertCallback callback2) {
                    Intrinsics.checkNotNullParameter(callback2, "callback");
                    callback2.onDismiss(DefaultCardPlayer.this);
                }
            });
        }

        public void onAlertWidgetShow() {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callback;
            DefaultCardPlayer.this.showPlayerIfNeed();
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callback = iCardPlayTask.getNetworkAlertCallbacks()) == null) {
                return;
            }
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callback.visit(new CardPlayerCallbacksInfo.Visitor<INetworkAlertCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mNetworkAlertHandler$1$onAlertWidgetShow$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(INetworkAlertCallback callback2) {
                    Intrinsics.checkNotNullParameter(callback2, "callback");
                    callback2.onShow(DefaultCardPlayer.this);
                }
            });
        }

        public void onPanelClick() {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callback;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callback = iCardPlayTask.getNetworkAlertCallbacks()) == null) {
                return;
            }
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callback.visit(new CardPlayerCallbacksInfo.Visitor<INetworkAlertCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mNetworkAlertHandler$1$onPanelClick$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(INetworkAlertCallback callback2) {
                    Intrinsics.checkNotNullParameter(callback2, "callback");
                    callback2.onClick(DefaultCardPlayer.this);
                }
            });
        }

        public void onAllowPlayWithMobileData() {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callback;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callback = iCardPlayTask.getNetworkAlertCallbacks()) == null) {
                return;
            }
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callback.visit(new CardPlayerCallbacksInfo.Visitor<INetworkAlertCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mNetworkAlertHandler$1$onAllowPlayWithMobileData$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(INetworkAlertCallback callback2) {
                    Intrinsics.checkNotNullParameter(callback2, "callback");
                    callback2.onPlayWithMobileData(DefaultCardPlayer.this);
                }
            });
        }

        public void onGotoUnicom() {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callback;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callback = iCardPlayTask.getNetworkAlertCallbacks()) == null) {
                return;
            }
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callback.visit(new CardPlayerCallbacksInfo.Visitor<INetworkAlertCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mNetworkAlertHandler$1$onGotoUnicom$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(INetworkAlertCallback callback2) {
                    Intrinsics.checkNotNullParameter(callback2, "callback");
                    callback2.onGotoUnicom(DefaultCardPlayer.this);
                }
            });
        }
    };
    private final DefaultCardPlayer$mVideoEnvironmentObserver$1 mVideoEnvironmentObserver = new VideoEnvironmentObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mVideoEnvironmentObserver$1
        public void onVideoEnvironmentChanged(VideoEnvironment environment) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callback;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callback = iCardPlayTask.getVideoEnvironmentChangedCallbacks()) == null) {
                return;
            }
            final DefaultCardPlayer defaultCardPlayer = DefaultCardPlayer.this;
            callback.visit(new CardPlayerCallbacksInfo.Visitor<IVideoEnvironmentChangedCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mVideoEnvironmentObserver$1$onVideoEnvironmentChanged$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(IVideoEnvironmentChangedCallback callback2) {
                    Intrinsics.checkNotNullParameter(callback2, "callback");
                    callback2.onChanged(DefaultCardPlayer.this);
                }
            });
        }
    };
    private final DefaultCardPlayer$mIgnoreNetworkToastHandler$1 mIgnoreNetworkToastHandler = new INetworkToastHandler() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mIgnoreNetworkToastHandler$1
        public /* synthetic */ boolean showCustomToast(VideoEnvironment videoEnvironment, long j, boolean z, boolean z2, boolean z3) {
            return INetworkToastHandler.-CC.$default$showCustomToast(this, videoEnvironment, j, z, z2, z3);
        }

        public void showToast(String toastMsg, boolean report, boolean force) {
            Intrinsics.checkNotNullParameter(toastMsg, "toastMsg");
        }
    };
    private final Function1<DataRelationShipChain, Unit> mRelationShipChangedObserver = new Function1() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$$ExternalSyntheticLambda4
        public final Object invoke(Object obj) {
            Unit mRelationShipChangedObserver$lambda$0;
            mRelationShipChangedObserver$lambda$0 = DefaultCardPlayer.mRelationShipChangedObserver$lambda$0(DefaultCardPlayer.this, (DataRelationShipChain) obj);
            return mRelationShipChangedObserver$lambda$0;
        }
    };
    private DefaultCardPlayer$mPlayerReleaseObserver$1 mPlayerReleaseObserver = new IPlayerReleaseObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerReleaseObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IPlayerReleaseObserver
        public /* synthetic */ void onPlayerItemWillChanged() {
            IPlayerReleaseObserver.CC.$default$onPlayerItemWillChanged(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IPlayerReleaseObserver
        public void onPlayerItemRelease() {
        }

        @Override // tv.danmaku.biliplayerv2.service.IPlayerReleaseObserver
        public void onPlayerWillRelease() {
        }
    };
    private final DefaultCardPlayer$mPlayerSeekObserver$1 mPlayerSeekObserver = new PlayerSeekObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerSeekObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerSeekObserver
        public void onSeekStart(final long position) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getPlayerSeekCallbacks()) == null) {
                return;
            }
            callbacks.visit(new CardPlayerCallbacksInfo.Visitor<IPlayerSeekCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerSeekObserver$1$onSeekStart$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(IPlayerSeekCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    callback.onSeekStart(position);
                }
            });
        }

        @Override // tv.danmaku.biliplayerv2.service.PlayerSeekObserver
        public void onSeekComplete(final long position) {
            ICardPlayTask iCardPlayTask;
            CardPlayerCallbacksInfo callbacks;
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (callbacks = iCardPlayTask.getPlayerSeekCallbacks()) == null) {
                return;
            }
            callbacks.visit(new CardPlayerCallbacksInfo.Visitor<IPlayerSeekCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mPlayerSeekObserver$1$onSeekComplete$1
                @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                public void onVisit(IPlayerSeekCallback callback) {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    callback.onSeekComplete(position);
                }
            });
        }
    };
    private final DefaultCardPlayer$preloadHandler$1 preloadHandler = new ProfilerHandler() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$preloadHandler$1
        @Override // tv.danmaku.biliplayerv2.profiler.ProfilerHandler
        public void handleMessage(PlayerProfiler.Message message) {
            ICardPlayTask iCardPlayTask;
            List<Video.PlayableParams> playableParamsList;
            Video.PlayableParams params;
            Intrinsics.checkNotNullParameter(message, "message");
            iCardPlayTask = DefaultCardPlayer.this.mCardPlayTask;
            if (iCardPlayTask == null || (playableParamsList = iCardPlayTask.getPlayableParamsList()) == null || (params = playableParamsList.get(0)) == null) {
                return;
            }
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to("spmid", params.getSpmid());
            pairArr[1] = TuplesKt.to("fromSpmid", params.getFromSpmid());
            Video.ReportCommonParams reportCommonParams = params.getReportCommonParams();
            pairArr[2] = TuplesKt.to("cid", reportCommonParams != null ? String.valueOf(reportCommonParams.getCid()) : null);
            Video.ReportCommonParams reportCommonParams2 = params.getReportCommonParams();
            pairArr[3] = TuplesKt.to("aid", reportCommonParams2 != null ? String.valueOf(reportCommonParams2.getAvid()) : null);
            Map reportMap = MapsKt.mapOf(pairArr);
            String tag = message.getTag();
            if (Intrinsics.areEqual(tag, ProfilerTags.START_PLAY_PRELOAD)) {
                Neurons.trackT(false, "player.card.start.play-preload.track", reportMap, 1, PlayerPreloadConfigKt.getReportSampler());
            } else if (Intrinsics.areEqual(tag, ProfilerTags.START_PLAY_PRELOAD_NORMAL)) {
                Neurons.trackT(false, "player.card.start.play-normal.track", reportMap, 1, PlayerPreloadConfigKt.getReportSampler());
            }
        }
    };

    /* compiled from: DefaultCardPlayer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ICardPlayTask.CardPlayerReportScene.values().length];
            try {
                iArr2[ICardPlayTask.CardPlayerReportScene.Inline.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[ICardPlayTask.CardPlayerReportScene.MiniScreen.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* compiled from: DefaultCardPlayer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$Companion;", "", "<init>", "()V", "TAG", "", "CARD_PLAYER_PLAY_PRELOAD", "CARD_PLAYER_PLAY_NORMAL", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final DefaultCommonResolveTaskProvider getResolveProvider() {
        return (DefaultCommonResolveTaskProvider) this.resolveProvider$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DefaultCommonResolveTaskProvider resolveProvider_delegate$lambda$0() {
        return new DefaultCommonResolveTaskProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFirstFrameListener$lambda$0(final DefaultCardPlayer this$0) {
        HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DefaultCardPlayer.mFirstFrameListener$lambda$0$0(DefaultCardPlayer.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFirstFrameListener$lambda$0$0(DefaultCardPlayer this$0) {
        this$0.mRenderStartObserver.onVideoRenderStart();
    }

    private final void preloadDamankuFilter() {
        if (BlockListStorageUtils.isUserKeywordsExpired(this.mContext)) {
            KeywordsSyncTask keywordsSyncTask = new KeywordsSyncTask();
            keywordsSyncTask.readUserBlockedKeywordsFromRemote(this.mContext, new KeywordsSyncTask.KeywordsSyncCallback() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$preloadDamankuFilter$syncCallback$1
                @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.KeywordsSyncCallback
                public void onSyncKeywords(boolean success, BlockedKeywords<UserKeywordItem> blockedKeywords) {
                }

                @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.KeywordsSyncCallback
                public void onSyncAfterWriteDataSuccess() {
                    IPlayerContainer iPlayerContainer;
                    iPlayerContainer = DefaultCardPlayer.this.mPlayerContainer;
                    if (iPlayerContainer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        iPlayerContainer = null;
                    }
                    IRemoteHandler remoteHandler = iPlayerContainer.getInteractLayerService().getRemoteHandler();
                    if (remoteHandler != null) {
                        remoteHandler.filtersChanged();
                    }
                }
            }, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mRelationShipChangedObserver$lambda$0(DefaultCardPlayer this$0, DataRelationShipChain newValue) {
        IPlayerContainer iPlayerContainer = this$0.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        IRemoteHandler remoteHandler = iPlayerContainer.getInteractLayerService().getRemoteHandler();
        if (remoteHandler != null) {
            remoteHandler.updateRelationshipChainChanged(this$0.translateRelationShipChain(newValue));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IHardwareDelegate hardwareDelegate() {
        ICardPlayTask iCardPlayTask = this.mCardPlayTask;
        IHardwareDelegate delegate = iCardPlayTask != null ? iCardPlayTask.getHardwareDelegate() : null;
        if (delegate == null) {
            return this.mDefaultCustomHardwareDelegate;
        }
        return delegate;
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public void initialize(LifecycleOwner lifecycleOwner, Context context, int sharedId, PlayerExtraConfiguration extraConfiguration) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(context, "context");
        this.isApplicationPlayer = lifecycleOwner == null;
        if (this.isApplicationPlayer) {
            CardPlayerLog.i(TAG, "initialize application card player");
        } else {
            CardPlayerLog.i(TAG, "initialize lifecycle card player");
        }
        this.lifecycleOwner = lifecycleOwner;
        initializeInternal(context, sharedId, extraConfiguration);
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        if (lifecycleOwner2 != null && (lifecycle = lifecycleOwner2.getLifecycle()) != null) {
            lifecycle.addObserver((LifecycleObserver) this);
        }
        if (this.isApplicationPlayer) {
            onCreateInternal();
            CardPlayerLog.i(TAG, "on create application card player ");
        }
        initPreloadReport();
        preloadDamankuFilter();
    }

    private final void initializeInternal(Context context, int sharedId, PlayerExtraConfiguration extraConfiguration) {
        PlayerType playerType;
        IVideoRenderLayer.Type type;
        boolean z;
        this.mContext = context;
        PlayerParamsV2 playerParams = new PlayerParamsV2();
        PlayerConfiguration config = new PlayerConfiguration();
        config.setUpdateVideoRenderViewPortEnable(true);
        if (extraConfiguration == null || (playerType = extraConfiguration.getPlayerType()) == null) {
            playerType = PlayerType.Single;
        }
        config.setPlayerType(playerType);
        config.setAllowReusePlayerCore(extraConfiguration != null ? extraConfiguration.getAllowReusePlayerCore() : false);
        if (IVideoRenderLayer.Companion.enableExternalRender()) {
            if (extraConfiguration != null && extraConfiguration.getKeepRender()) {
                z = true;
            } else {
                z = false;
            }
            type = z ? IVideoRenderLayer.Type.TypeSurfaceViewWithExternalRender : IVideoRenderLayer.Type.TypeTextureViewWithExternalRender;
        } else {
            type = IVideoRenderLayer.Type.TypeTextureView;
        }
        config.setVideoRenderLayerType(type);
        config.setWholeSceneEnable(false);
        config.setDisallowParentIntercept(false);
        config.setMLoadingDelayTime(800L);
        playerParams.setConfig(config);
        boolean useShared = false;
        if (sharedId > 0) {
            IPlayerContainer.SharedRecord retrieveSharedRecord = IPlayerContainer.Companion.retrieveSharedRecord(sharedId);
            PlayerSharingBundle sharedBundle = retrieveSharedRecord != null ? retrieveSharedRecord.getSharingBundle() : null;
            Video.PlayableParams playableParams = sharedBundle != null ? (Video.PlayableParams) sharedBundle.getSharableObject("key_share_player_playable_params", true) : null;
            if (playableParams != null) {
                BiliCardPlayerDataSource.setPlayableParamsList$default(this.mBiliCardPlayerDataSource, CollectionsKt.listOf(playableParams), false, false, 4, null);
                sharedBundle.putSharableObject("key_share_player_data_source", this.mBiliCardPlayerDataSource);
                sharedBundle.getBundle().putInt("key_share_current_video_index", 0);
                CurrentVideoPointer newVideoItem = new CurrentVideoPointer();
                newVideoItem.setIndex(0);
                newVideoItem.setType(104);
                sharedBundle.putSharableObject("key_share_current_video_item", newVideoItem);
                playerParams.setSharingBundle(sharedBundle);
                this.mPendingPlaySharedId = sharedId;
                useShared = true;
            }
        }
        if (!useShared) {
            playerParams.setPlayerDataSource(this.mBiliCardPlayerDataSource);
        }
        this.mPlayerContainer = new IPlayerContainer.Builder().setContext(context).setPlayerParams(playerParams).setControlContainerConfig(this.mDefaultControlContainerConfig).build();
    }

    private final void initPreloadReport() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.setProfilerHandler(this.preloadHandler, ProfilerTags.START_PLAY_PRELOAD, ProfilerTags.START_PLAY_PRELOAD_NORMAL);
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public ICardPlayerContext getCardPlayerContext() {
        return this;
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public void release() {
        Lifecycle.State state;
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null || (state = lifecycle.getCurrentState()) == null) {
            state = Lifecycle.State.RESUMED;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                onPauseInternal();
                onStopInternal();
                onDestroyInternal();
                return;
            case 2:
                onStopInternal();
                onDestroyInternal();
                return;
            case 3:
                onDestroyInternal();
                return;
            default:
                return;
        }
    }

    public void onCreate(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        CardPlayerLog.i(TAG, "on lifecycle create");
        onCreateInternal();
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onCreateInternal() {
        IPlayerContainer iPlayerContainer;
        GestureService service;
        IPlayerContainer iPlayerContainer2;
        IPlayerContainer iPlayerContainer3;
        CardPlayerReadyObserver cardPlayerReadyObserver;
        IPlayerContainer iPlayerContainer4 = this.mPlayerContainer;
        IPlayerContainer iPlayerContainer5 = null;
        if (iPlayerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer4 = null;
        }
        iPlayerContainer4.onCreate(null);
        IPlayerContainer iPlayerContainer6 = this.mPlayerContainer;
        if (iPlayerContainer6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer6 = null;
        }
        this.mBusinessServiceLauncher = new BusinessServiceLauncher(iPlayerContainer6.getPlayerServiceManager());
        IPlayerContainer iPlayerContainer7 = this.mPlayerContainer;
        if (iPlayerContainer7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer7 = null;
        }
        LayoutInflater from = LayoutInflater.from(this.mContext);
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        this.mPlayerRootView = iPlayerContainer7.onCreateView(from, null, null);
        View view2 = this.mPlayerRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
            view2 = null;
        }
        view2.setLayoutParams(this.mRootViewLayoutParams);
        IPlayerContainer iPlayerContainer8 = this.mPlayerContainer;
        if (iPlayerContainer8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer8 = null;
        }
        View view3 = this.mPlayerRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
            view3 = null;
        }
        iPlayerContainer8.onViewCreated(view3, null);
        CardPlayerLog.i(TAG, "launch builtin services");
        BusinessServiceLauncher businessServiceLauncher = this.mBusinessServiceLauncher;
        if (businessServiceLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBusinessServiceLauncher");
            businessServiceLauncher = null;
        }
        businessServiceLauncher.launch(CardPlayerBuiltServicesKt.getCardPlayerBuiltInServices());
        IPlayerContainer iPlayerContainer9 = this.mPlayerContainer;
        if (iPlayerContainer9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer9 = null;
        }
        iPlayerContainer9.getPlayerCoreService().setPlayerPerformanceListener(this.mPerformanceListener);
        if (IVideoRenderLayer.Companion.enableExternalRender()) {
            IPlayerContainer iPlayerContainer10 = this.mPlayerContainer;
            if (iPlayerContainer10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer10 = null;
            }
            iPlayerContainer10.getRenderContainerService().setFirstFrameListener(this.mFirstFrameListener);
        } else {
            IPlayerContainer iPlayerContainer11 = this.mPlayerContainer;
            if (iPlayerContainer11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer11 = null;
            }
            iPlayerContainer11.getPlayerCoreService().addRenderStartObserver(this.mRenderStartObserver);
        }
        IPlayerContainer iPlayerContainer12 = this.mPlayerContainer;
        if (iPlayerContainer12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer12 = null;
        }
        iPlayerContainer12.getPlayerCoreService().registerPlayerErrorObserver(this.mPlayerErrorObserver);
        IPlayerContainer iPlayerContainer13 = this.mPlayerContainer;
        if (iPlayerContainer13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer13 = null;
        }
        iPlayerContainer13.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(CardPlayerQualityService.class), this.mCardQualityServiceClient);
        IPlayerContainer iPlayerContainer14 = this.mPlayerContainer;
        if (iPlayerContainer14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer14 = null;
        }
        iPlayerContainer14.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(PlayerHeadsetService.class), this.mPlayerHeadsetServiceClient);
        IPlayerContainer iPlayerContainer15 = this.mPlayerContainer;
        if (iPlayerContainer15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer15 = null;
        }
        iPlayerContainer15.getVideoPlayDirectorService().addVideoPlayEventListener(new IVideosPlayDirectorService.VideoPlayEventListener() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$onCreateInternal$1
            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onAllVideoCompleted() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onAllVideoCompleted(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onResolveFailed(Video video2, Video.PlayableParams playableParams, List list) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveFailed(this, video2, playableParams, list);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onResolveSucceed() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onResolveSucceed(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoCompleted(Video video2) {
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoItemCompleted(CurrentVideoPointer currentVideoPointer, Video video2) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemCompleted(this, currentVideoPointer, video2);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoItemStart(CurrentVideoPointer currentVideoPointer, Video video2) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemStart(this, currentVideoPointer, video2);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoItemWillChange(CurrentVideoPointer currentVideoPointer, CurrentVideoPointer currentVideoPointer2, Video video2) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoItemWillChange(this, currentVideoPointer, currentVideoPointer2, video2);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoSetChanged() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoSetChanged(int i) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetChanged(this, i);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoSetWillChange() {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoSetWillChange(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoStart(Video video2) {
                Intrinsics.checkNotNullParameter(video2, "video");
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public /* synthetic */ void onVideoWillChange(Video video2, Video video3) {
                IVideosPlayDirectorService.VideoPlayEventListener.CC.$default$onVideoWillChange(this, video2, video3);
            }

            @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService.VideoPlayEventListener
            public void onResolveFailed(Video video2, Video.PlayableParams playableParams, String errorMsg) {
                Intrinsics.checkNotNullParameter(video2, "video");
                Intrinsics.checkNotNullParameter(playableParams, "playableParams");
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                DefaultCardPlayer.this.showPlayerIfNeed();
            }
        });
        IPlayerContainer iPlayerContainer16 = this.mPlayerContainer;
        if (iPlayerContainer16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer16 = null;
        }
        iPlayerContainer16.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(PlayerNetworkService.class), this.mNetworkServiceClient);
        PlayerNetworkService service2 = this.mNetworkServiceClient.getService();
        if (service2 != null) {
            service2.registerVideoEnvironmentObserver(this.mVideoEnvironmentObserver);
        }
        PlayerNetworkService service3 = this.mNetworkServiceClient.getService();
        if (service3 != null) {
            service3.setNetworkAlertHandler(this.mNetworkAlertHandler);
        }
        this.mCardVideoPlayHandler = new CardVideoPlayHandler();
        CardVideoPlayHandler cardVideoPlayHandler = this.mCardVideoPlayHandler;
        if (cardVideoPlayHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardVideoPlayHandler");
            cardVideoPlayHandler = null;
        }
        cardVideoPlayHandler.setHistoryProgressReader(new AbsMediaResourceResolveTask.IHistoryProgressReader() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$onCreateInternal$2
            /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
                r2 = r4.this$0.mCardPlayTask;
             */
            @Override // tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask.IHistoryProgressReader
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public int read() {
                IPlayerContainer iPlayerContainer17;
                IMediaHistoryKeyParams it;
                ICardPlayTask iCardPlayTask;
                IMediaHistoryReader mediaHistoryReader;
                MediaHistoryEntry read;
                iPlayerContainer17 = DefaultCardPlayer.this.mPlayerContainer;
                if (iPlayerContainer17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer17 = null;
                }
                Video.PlayableParams currentPlayableParams = iPlayerContainer17.getVideoPlayDirectorService().getCurrentPlayableParams();
                if (currentPlayableParams == null || (it = currentPlayableParams.getMediaHistoryKayParams()) == null || iCardPlayTask == null || (mediaHistoryReader = iCardPlayTask.getMediaHistoryReader()) == null || (read = mediaHistoryReader.read(it)) == null) {
                    return 0;
                }
                return read.getProgress();
            }

            @Override // tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask.IHistoryProgressReader
            public int read(MediaResource mediaResource) {
                return read();
            }

            @Override // tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask.IHistoryProgressReader
            public boolean isForceAccurateSeek() {
                IPlayerContainer iPlayerContainer17;
                IMediaHistoryKeyParams historyKeyParams;
                MediaHistoryEntry read;
                iPlayerContainer17 = DefaultCardPlayer.this.mPlayerContainer;
                if (iPlayerContainer17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer17 = null;
                }
                Video.PlayableParams playableParams = iPlayerContainer17.getVideoPlayDirectorService().getCurrentPlayableParams();
                if (playableParams == null || (historyKeyParams = playableParams.getMediaHistoryKayParams()) == null || (read = MediaHistoryHelper.Companion.getInstance().read(historyKeyParams)) == null) {
                    return false;
                }
                return read.isForceStartAccurateSeek();
            }

            private final IMediaHistoryStorage<MediaHistoryEntry> getMediaHistoryStorage(IMediaHistoryKeyParams mediaHistoryKeyParams) {
                if (mediaHistoryKeyParams == null) {
                    return null;
                }
                Object obj = BLRouter.INSTANCE.get(IMediaHistoryStorage.class, mediaHistoryKeyParams.getType());
                if (obj instanceof IMediaHistoryStorage) {
                    return (IMediaHistoryStorage) obj;
                }
                return null;
            }
        });
        IPlayerContainer iPlayerContainer17 = this.mPlayerContainer;
        if (iPlayerContainer17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer17 = null;
        }
        IVideosPlayDirectorService videoPlayDirectorService = iPlayerContainer17.getVideoPlayDirectorService();
        CardVideoPlayHandler cardVideoPlayHandler2 = this.mCardVideoPlayHandler;
        if (cardVideoPlayHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardVideoPlayHandler");
            cardVideoPlayHandler2 = null;
        }
        videoPlayDirectorService.registerVideoPlayHandler(104, cardVideoPlayHandler2);
        IPlayerContainer iPlayerContainer18 = this.mPlayerContainer;
        if (iPlayerContainer18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer18 = null;
        }
        iPlayerContainer18.getPlayerCoreService().registerState(new PlayerStateObserver() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$onCreateInternal$3
            @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
            public void onPlayerStateChanged(int state) {
                long j;
                long j2;
                ICardPlayTask request;
                IPlayerContainer iPlayerContainer19;
                long j3;
                long j4;
                IPlayerContainer iPlayerContainer20;
                long j5;
                IPlayerContainer iPlayerContainer21;
                MediaHistoryEntry read;
                IPlayerContainer iPlayerContainer22;
                long j6;
                switch (state) {
                    case 3:
                        j = DefaultCardPlayer.this.mPendingSeekPosition;
                        if (j == 0) {
                            DefaultCardPlayer.this.mPendingSeekPosition = -1L;
                            return;
                        }
                        j2 = DefaultCardPlayer.this.mPendingSeekPosition;
                        IPlayerContainer iPlayerContainer23 = null;
                        if (j2 > 0) {
                            iPlayerContainer22 = DefaultCardPlayer.this.mPlayerContainer;
                            if (iPlayerContainer22 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                            } else {
                                iPlayerContainer23 = iPlayerContainer22;
                            }
                            IPlayerCoreService playerCoreService = iPlayerContainer23.getPlayerCoreService();
                            j6 = DefaultCardPlayer.this.mPendingSeekPosition;
                            playerCoreService.seekTo((int) j6);
                            DefaultCardPlayer.this.mPendingSeekPosition = -1L;
                            return;
                        }
                        request = DefaultCardPlayer.this.mCardPlayTask;
                        iPlayerContainer19 = DefaultCardPlayer.this.mPlayerContainer;
                        if (iPlayerContainer19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                            iPlayerContainer19 = null;
                        }
                        Video.PlayableParams playableParams = iPlayerContainer19.getVideoPlayDirectorService().getCurrentPlayableParams();
                        IMediaHistoryKeyParams historyKeyParams = playableParams != null ? playableParams.getMediaHistoryKayParams() : null;
                        j3 = DefaultCardPlayer.this.mPendingSeekPosition;
                        if (j3 < 0 && request != null && playableParams != null && historyKeyParams != null) {
                            IMediaHistoryReader mediaHistoryReader = request.getMediaHistoryReader();
                            int progress = (mediaHistoryReader == null || (read = mediaHistoryReader.read(historyKeyParams)) == null) ? -1 : read.getProgress();
                            if (progress >= 0) {
                                iPlayerContainer21 = DefaultCardPlayer.this.mPlayerContainer;
                                if (iPlayerContainer21 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                                    iPlayerContainer21 = null;
                                }
                                if (iPlayerContainer21.getPlayerCoreService().getCurrentPosition() != progress) {
                                    DefaultCardPlayer.this.mPendingSeekPosition = progress;
                                }
                            }
                            j4 = DefaultCardPlayer.this.mPendingSeekPosition;
                            if (j4 >= 0) {
                                iPlayerContainer20 = DefaultCardPlayer.this.mPlayerContainer;
                                if (iPlayerContainer20 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                                } else {
                                    iPlayerContainer23 = iPlayerContainer20;
                                }
                                IPlayerCoreService playerCoreService2 = iPlayerContainer23.getPlayerCoreService();
                                j5 = DefaultCardPlayer.this.mPendingSeekPosition;
                                playerCoreService2.seekTo((int) j5);
                                DefaultCardPlayer.this.mPendingSeekPosition = -1L;
                                return;
                            }
                            return;
                        }
                        return;
                    case 6:
                        DefaultCardPlayer.this.showPlayerIfNeed();
                        return;
                    default:
                        return;
                }
            }
        }, 6, 3);
        IPlayerContainer iPlayerContainer19 = this.mPlayerContainer;
        if (iPlayerContainer19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer19 = null;
        }
        iPlayerContainer19.getRenderContainerService().addVideoSizeChangedListener(this.mVideoSizeChangeObserver);
        IPlayerContainer iPlayerContainer20 = this.mPlayerContainer;
        if (iPlayerContainer20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer20 = null;
        }
        iPlayerContainer20.getPlayerCoreService().registerState(this.mPlayerStateObserver, 2, 3, 4, 5, 6, 7);
        IPlayerContainer iPlayerContainer21 = this.mPlayerContainer;
        if (iPlayerContainer21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer21 = null;
        }
        iPlayerContainer21.getPlayerCoreService().registerBufferingState(this.mPlayerBufferingObserver);
        IPlayerContainer iPlayerContainer22 = this.mPlayerContainer;
        if (iPlayerContainer22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer22 = null;
        }
        iPlayerContainer22.getPlayerCoreService().addMediaResourceObserver(this.mMediaResourceObserver);
        IPlayerContainer iPlayerContainer23 = this.mPlayerContainer;
        if (iPlayerContainer23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer23 = null;
        }
        iPlayerContainer23.getPlayerCoreService().registerSeekObserver(this.mPlayerSeekObserver);
        IPlayerContainer iPlayerContainer24 = this.mPlayerContainer;
        if (iPlayerContainer24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer24 = null;
        }
        iPlayerContainer24.getVideoPlayDirectorService().addVideoPlayEventListener(this.mVideoPlayEventListener);
        IPlayerContainer iPlayerContainer25 = this.mPlayerContainer;
        if (iPlayerContainer25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer25 = null;
        }
        iPlayerContainer25.getVideoPlayDirectorService().setMediaItemSettingInterceptor(this.mMediaItemParamsInterceptor);
        IPlayerContainer iPlayerContainer26 = this.mPlayerContainer;
        if (iPlayerContainer26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer26 = null;
        }
        iPlayerContainer26.getVideoPlayDirectorService().setProcessCompleteActionEnable(false);
        IPlayerContainer iPlayerContainer27 = this.mPlayerContainer;
        if (iPlayerContainer27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer27 = null;
        }
        iPlayerContainer27.getVideoPlayDirectorService().setProcessCompleteActionAvailable(false);
        IPlayerContainer iPlayerContainer28 = this.mPlayerContainer;
        if (iPlayerContainer28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer28 = null;
        }
        iPlayerContainer28.getInteractLayerService().registerDanmakuVisibleObserver(this.mDanmakuVisibleCallback);
        IPlayerContainer iPlayerContainer29 = this.mPlayerContainer;
        if (iPlayerContainer29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer29 = null;
        }
        iPlayerContainer29.getInteractLayerService().addDanmakuParamsChangedObserver(this.mDanmakuParamsCallback);
        IPlayerContainer iPlayerContainer30 = this.mPlayerContainer;
        if (iPlayerContainer30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer30 = null;
        }
        iPlayerContainer30.getControlContainerService().registerState(this.mControlContainerObserver);
        IPlayerContainer iPlayerContainer31 = this.mPlayerContainer;
        if (iPlayerContainer31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer31 = null;
        }
        iPlayerContainer31.getControlContainerService().registerControlContainerVisible(this.mControlContainerVisibleObserver);
        FragmentActivity context = ContextUtilKt.findFragmentActivityOrNull(this.mContext);
        if (context != null) {
            ICardPlayTask iCardPlayTask = this.mCardPlayTask;
            if (iCardPlayTask != null && iCardPlayTask.enableGravitySensor()) {
                initHardwareService(context);
                iPlayerContainer = this.mPlayerContainer;
                if (iPlayerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer = null;
                }
                iPlayerContainer.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(GestureService.class), this.mGestureClient);
                service = this.mGestureClient.getService();
                if (service != null) {
                    service.setVerticalScrollEnable(false);
                }
                iPlayerContainer2 = this.mPlayerContainer;
                if (iPlayerContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer2 = null;
                }
                iPlayerContainer2.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(AudioFocusService.class), this.mAudioFocusClient);
                iPlayerContainer3 = this.mPlayerContainer;
                if (iPlayerContainer3 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    iPlayerContainer5 = iPlayerContainer3;
                }
                iPlayerContainer5.getPlayerCoreService().addPlayerReleaseObserver(this.mPlayerReleaseObserver);
                this.mIsReady = true;
                cardPlayerReadyObserver = this.mPlayerReadyObserver;
                if (cardPlayerReadyObserver == null) {
                    cardPlayerReadyObserver.onReady();
                    return;
                }
                return;
            }
        }
        CardPlayerLog.i(TAG, "do not enable gravity");
        iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
        }
        iPlayerContainer.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(GestureService.class), this.mGestureClient);
        service = this.mGestureClient.getService();
        if (service != null) {
        }
        iPlayerContainer2 = this.mPlayerContainer;
        if (iPlayerContainer2 == null) {
        }
        iPlayerContainer2.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(AudioFocusService.class), this.mAudioFocusClient);
        iPlayerContainer3 = this.mPlayerContainer;
        if (iPlayerContainer3 != null) {
        }
        iPlayerContainer5.getPlayerCoreService().addPlayerReleaseObserver(this.mPlayerReleaseObserver);
        this.mIsReady = true;
        cardPlayerReadyObserver = this.mPlayerReadyObserver;
        if (cardPlayerReadyObserver == null) {
        }
    }

    private final void initHardwareService(FragmentActivity context) {
        CardPlayerLog.i(TAG, "init hardware service");
        this.alreadyLoadedHardwareService = true;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        View view2 = null;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(HardwareService.class), this.mHardwareServiceClient);
        HardwareService service = this.mHardwareServiceClient.getService();
        if (service != null) {
            service.init(context, this.mHardwareDelegate);
        }
        HardwareService service2 = this.mHardwareServiceClient.getService();
        if (service2 != null) {
            service2.setGravityEnable(true);
        }
        this.mWindowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                DefaultCardPlayer.initHardwareService$lambda$0(DefaultCardPlayer.this, z);
            }
        };
        View view3 = this.mPlayerRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
        } else {
            view2 = view3;
        }
        view2.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHardwareService$lambda$0(DefaultCardPlayer this$0, boolean hasFocus) {
        if (hasFocus) {
            ICardPlayTask iCardPlayTask = this$0.mCardPlayTask;
            boolean z = false;
            if (iCardPlayTask != null && iCardPlayTask.enableGravitySensor()) {
                z = true;
            }
            if (z) {
                HardwareService service = this$0.mHardwareServiceClient.getService();
                if (service != null) {
                    service.startGravitySensor();
                    return;
                }
                return;
            }
        }
        HardwareService service2 = this$0.mHardwareServiceClient.getService();
        if (service2 != null) {
            service2.stopGravitySensor();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPlayerIfNeed() {
        View view2 = this.mPlayerRootView;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
            view2 = null;
        }
        if (view2.getAlpha() == 1.0f) {
            return;
        }
        View view4 = this.mPlayerRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
        } else {
            view3 = view4;
        }
        view3.setAlpha(1.0f);
    }

    private final void startServiceInternal(Class<? extends IPlayerService> cls) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerServiceManager().startService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(cls));
    }

    private final void stopServiceInternal(Class<? extends IPlayerService> cls) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerServiceManager().stopService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(cls));
    }

    private final void setPlayEnable(boolean enable) {
        IPlayerContainer iPlayerContainer = null;
        if (enable) {
            DisablePlayLock it = this.mDisablePlayLock;
            if (it != null) {
                IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
                if (iPlayerContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer2 = null;
                }
                iPlayerContainer2.getPlayerCoreService().releaseDisablePlayLock(it);
            }
            this.mDisablePlayLock = null;
        } else if (this.mDisablePlayLock == null) {
            IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
            if (iPlayerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                iPlayerContainer = iPlayerContainer3;
            }
            this.mDisablePlayLock = iPlayerContainer.getPlayerCoreService().acquireDisablePlayLock(TAG);
        }
    }

    private final void checkRequestWillAttach(ICardPlayTask task) {
        List layers = task.getPlayerLayerDescriptors();
        for (ICardPlayTask.PlayerLayerDescriptor layer : layers) {
            ViewParent parent = layer.getLayer().getView().getParent();
            if (parent instanceof ViewGroup) {
                if (BuildConfig.DEBUG) {
                    throw new IllegalStateException("something error, layer@" + layer + " already attach a parent");
                }
                CardPlayerLog.e(TAG, "something error, layer@" + layer + " already attach a parent, will remove it from old parent anyway");
                ((ViewGroup) parent).removeView(layer.getLayer().getView());
            }
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public void attachToTask(ICardPlayTask cardPlayTask) {
        Intrinsics.checkNotNullParameter(cardPlayTask, "cardPlayTask");
        attachTaskInMainThread(cardPlayTask);
    }

    private final void attachTaskInMainThread(ICardPlayTask cardPlayTask) {
        CardPlayerLog.i(TAG, "attach to request in main thread: " + cardPlayTask);
        attachTaskInternal(cardPlayTask);
    }

    private final void attachTaskInternal(ICardPlayTask cardPlayTask) {
        IPanelContainer panelContainer;
        View view2;
        IPlayerContainer iPlayerContainer;
        IHeartbeatService heartbeatService;
        CardTaskRepository cardTaskRepository;
        CardTaskRepository it;
        IPanelContainer panelContainer2;
        View view3;
        IDurationInterceptor it2;
        ICurrentPositionInterceptor it3;
        Iterable seekInterceptor;
        if (this.mCardPlayTask != null) {
            if (BuildConfig.DEBUG) {
                throw new IllegalStateException("must detach from old request first!!!");
            }
            CardPlayerLog.e(TAG, "must detach from old request first!!!");
            IBiliCardPlayer.CC.detachFromTask$default(this, this.mCardPlayTask, false, 2, null);
        }
        checkRequestWillAttach(cardPlayTask);
        this.mCardPlayTask = cardPlayTask;
        this.mWaitRenderStart = true;
        setPlayEnable(true);
        PlayerHeadsetService service = this.mPlayerHeadsetServiceClient.getService();
        if (service != null) {
            service.setEnable(true);
            Unit unit = Unit.INSTANCE;
        }
        IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
        if (iPlayerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer2 = null;
        }
        iPlayerContainer2.getFunctionWidgetService().hideAllWidget();
        View view4 = this.mPlayerRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
            view4 = null;
        }
        ViewParent parent = view4.getParent();
        if (parent == null) {
            ViewGroup container = cardPlayTask.getContainer();
            View view5 = this.mPlayerRootView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
                view5 = null;
            }
            container.addView(view5);
        } else if (!Intrinsics.areEqual(parent, cardPlayTask.getContainer())) {
            ViewGroup viewGroup = (ViewGroup) parent;
            View view6 = this.mPlayerRootView;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
                view6 = null;
            }
            viewGroup.removeView(view6);
            ViewGroup container2 = cardPlayTask.getContainer();
            View view7 = this.mPlayerRootView;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
                view7 = null;
            }
            container2.addView(view7);
        }
        if (cardPlayTask.shouldShowWhenFirstRender()) {
            CardPlayerLog.i(TAG, "player show when first render, dismiss it this moment");
            View view8 = this.mPlayerRootView;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
                view8 = null;
            }
            view8.setAlpha(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        } else {
            showPlayerIfNeed();
        }
        List playableParams = cardPlayTask.getPlayableParamsList();
        if (playableParams.isEmpty() && (this.mPendingPlaySharedId <= 0 || this.mPendingPlaySharedId == cardPlayTask.getSharedRecordId())) {
            CardPlayerLog.w(TAG, "playableParamsList is empty");
        }
        if (!playableParams.isEmpty()) {
            if (this.mPendingPlaySharedId > 0 && this.mPendingPlaySharedId == cardPlayTask.getSharedRecordId()) {
                this.mBiliCardPlayerDataSource.setPlayableParamsList(playableParams, false, cardPlayTask.enablePreLoad());
            } else {
                BiliCardPlayerDataSource.setPlayableParamsList$default(this.mBiliCardPlayerDataSource, playableParams, false, cardPlayTask.enablePreLoad(), 2, null);
            }
        }
        if (!cardPlayTask.enableNetworkToast()) {
            PlayerNetworkService service2 = this.mNetworkServiceClient.getService();
            if (service2 != null) {
                service2.setNetworkToastHandler(this.mIgnoreNetworkToastHandler);
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            PlayerNetworkService service3 = this.mNetworkServiceClient.getService();
            if (service3 != null) {
                service3.setNetworkToastHandler((INetworkToastHandler) null);
                Unit unit3 = Unit.INSTANCE;
            }
        }
        if (cardPlayTask.enableNetworkAlert()) {
            PlayerNetworkService service4 = this.mNetworkServiceClient.getService();
            if (service4 != null) {
                service4.setShowAlertMode(ShowAlertMode.AppOnce);
                Unit unit4 = Unit.INSTANCE;
            }
        } else {
            PlayerNetworkService service5 = this.mNetworkServiceClient.getService();
            if (service5 != null) {
                service5.setShowAlertMode(ShowAlertMode.None);
                Unit unit5 = Unit.INSTANCE;
            }
        }
        installRequestServices(CollectionsKt.emptyList());
        installRequestLayer(cardPlayTask.getPlayerLayerDescriptors());
        CommonResolveTaskProvider it4 = cardPlayTask.getCommonTaskProvider();
        if (it4 != null) {
            CardPlayerLog.i(TAG, "set common resolve task provider: " + it4.getClass().getCanonicalName());
            IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
            if (iPlayerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer3 = null;
            }
            iPlayerContainer3.getVideoPlayDirectorService().setCommonResolveTaskProvider(it4);
            Unit unit6 = Unit.INSTANCE;
            Unit unit7 = Unit.INSTANCE;
        }
        CommonResolveTaskProvider taskProvider = cardPlayTask.getCommonTaskProvider();
        if (taskProvider != null) {
            CardPlayerLog.i(TAG, "set common resolve task provider: " + taskProvider.getClass().getCanonicalName());
            IPlayerContainer iPlayerContainer4 = this.mPlayerContainer;
            if (iPlayerContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer4 = null;
            }
            iPlayerContainer4.getVideoPlayDirectorService().setCommonResolveTaskProvider(taskProvider);
        } else {
            IPlayerContainer iPlayerContainer5 = this.mPlayerContainer;
            if (iPlayerContainer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer5 = null;
            }
            if (!(iPlayerContainer5.getVideoPlayDirectorService().getCommonResolveTaskProvider() instanceof DefaultCommonResolveTaskProvider)) {
                IPlayerContainer iPlayerContainer6 = this.mPlayerContainer;
                if (iPlayerContainer6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer6 = null;
                }
                iPlayerContainer6.getVideoPlayDirectorService().setCommonResolveTaskProvider(getResolveProvider());
            }
        }
        IPlayerContainer iPlayerContainer7 = this.mPlayerContainer;
        if (iPlayerContainer7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer7 = null;
        }
        iPlayerContainer7.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(PlayerRenderFilterService.class), this.mPlayerRenderFilterClient);
        PlayerRenderFilterService service6 = this.mPlayerRenderFilterClient.getService();
        if (service6 != null) {
            service6.setDaltonismEnable(cardPlayTask.enableDaltonismFilter());
            Unit unit8 = Unit.INSTANCE;
        }
        if (cardPlayTask.enableResetAudioIndex()) {
            handleResetAudioIndex();
        }
        CardPlayerLog.i(TAG, "desired quality: " + cardPlayTask.getDesiredQuality());
        CardPlayerQualityService service7 = this.mCardQualityServiceClient.getService();
        if (service7 != null) {
            service7.setDesireQuality(cardPlayTask.getDesiredQuality());
            Unit unit9 = Unit.INSTANCE;
        }
        CardPlayerLog.i(TAG, "max quality: " + cardPlayTask.getMaxQuality());
        CardPlayerQualityService service8 = this.mCardQualityServiceClient.getService();
        if (service8 != null) {
            service8.setMaxQuality(cardPlayTask.getMaxQuality());
            Unit unit10 = Unit.INSTANCE;
        }
        setAudioMute(cardPlayTask.isMute());
        if (cardPlayTask.isMute()) {
            CardPlayerLog.i(TAG, "is mute play: true");
            IPlayerContainer iPlayerContainer8 = this.mPlayerContainer;
            if (iPlayerContainer8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer8 = null;
            }
            iPlayerContainer8.getPlayerCoreService().setVolume(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        } else {
            CardPlayerLog.i(TAG, "is mute play: false");
            IPlayerContainer iPlayerContainer9 = this.mPlayerContainer;
            if (iPlayerContainer9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer9 = null;
            }
            iPlayerContainer9.getPlayerCoreService().setVolume(1.0f, 1.0f);
        }
        Map controlConfig = cardPlayTask.getControlContainerConfig();
        if (controlConfig != null) {
            CardPlayerLog.i(TAG, "use requester control config");
            applyControlContainerConfig(controlConfig, cardPlayTask.getInitializedControlContainerType());
        } else {
            CardPlayerLog.i(TAG, "use default control config");
            applyControlContainerConfig(this.mDefaultControlContainerConfig, cardPlayTask.getInitializedControlContainerType());
        }
        ICardPlayTask iCardPlayTask = this.mCardPlayTask;
        if (iCardPlayTask != null && (seekInterceptor = iCardPlayTask.getSeekInterceptor()) != null) {
            Iterable $this$forEach$iv = seekInterceptor;
            for (Object element$iv : $this$forEach$iv) {
                ISeekInterceptor it5 = (ISeekInterceptor) element$iv;
                IPlayerContainer iPlayerContainer10 = this.mPlayerContainer;
                if (iPlayerContainer10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer10 = null;
                }
                iPlayerContainer10.getPlayerCoreService().addSeekInterceptor(it5);
            }
            Unit unit11 = Unit.INSTANCE;
        }
        ICardPlayTask iCardPlayTask2 = this.mCardPlayTask;
        if (iCardPlayTask2 != null && (it3 = iCardPlayTask2.getCurrentPositionInterceptor()) != null) {
            IPlayerContainer iPlayerContainer11 = this.mPlayerContainer;
            if (iPlayerContainer11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer11 = null;
            }
            iPlayerContainer11.getPlayerCoreService().setCurrentPositionInterceptor(it3);
            Unit unit12 = Unit.INSTANCE;
            Unit unit13 = Unit.INSTANCE;
        }
        ICardPlayTask iCardPlayTask3 = this.mCardPlayTask;
        if (iCardPlayTask3 != null && (it2 = iCardPlayTask3.getDurationInterceptor()) != null) {
            IPlayerContainer iPlayerContainer12 = this.mPlayerContainer;
            if (iPlayerContainer12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer12 = null;
            }
            iPlayerContainer12.getPlayerCoreService().setDurationInterceptor(it2);
            Unit unit14 = Unit.INSTANCE;
            Unit unit15 = Unit.INSTANCE;
        }
        this.mTaskMediaItemParamsInterceptor = cardPlayTask.getMediaItemSettingInterceptor();
        IPlayerContainer iPlayerContainer13 = this.mPlayerContainer;
        if (iPlayerContainer13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer13 = null;
        }
        PlayerContainer playerContainer = iPlayerContainer13 instanceof PlayerContainer ? (PlayerContainer) iPlayerContainer13 : null;
        if (cardPlayTask.useTransparentLayer()) {
            IPlayerContainer iPlayerContainer14 = this.mPlayerContainer;
            if (iPlayerContainer14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer14 = null;
            }
            iPlayerContainer14.getRenderContainerService().setLayerAlpha(true);
            if (playerContainer != null && (panelContainer2 = playerContainer.getPanelContainer()) != null && (view3 = panelContainer2.getView()) != null) {
                view3.setBackground(new ColorDrawable(0));
                Unit unit16 = Unit.INSTANCE;
            }
        } else {
            IPlayerContainer iPlayerContainer15 = this.mPlayerContainer;
            if (iPlayerContainer15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer15 = null;
            }
            iPlayerContainer15.getRenderContainerService().setLayerAlpha(false);
            if (playerContainer != null && (panelContainer = playerContainer.getPanelContainer()) != null && (view2 = panelContainer.getView()) != null) {
                view2.setBackground(new ColorDrawable(-16777216));
                Unit unit17 = Unit.INSTANCE;
            }
        }
        GestureService service9 = this.mGestureClient.getService();
        if (service9 != null) {
            service9.forbiddenInnerTouchEvent(cardPlayTask.isInnerTouchEventForbidden());
            Unit unit18 = Unit.INSTANCE;
        }
        if (cardPlayTask.enableGravitySensor()) {
            if (this.alreadyLoadedHardwareService) {
                CardPlayerLog.i(TAG, "hardware service has already load and enable gravity sensor");
                HardwareService service10 = this.mHardwareServiceClient.getService();
                if (service10 != null) {
                    service10.setGravityEnable(true);
                    Unit unit19 = Unit.INSTANCE;
                }
            } else {
                FragmentActivity context = ContextUtilKt.findFragmentActivityOrNull(this.mContext);
                if (context != null) {
                    CardPlayerLog.i(TAG, "hardware service need to init and enable gravity sensor");
                    initHardwareService(context);
                }
                Unit unit20 = Unit.INSTANCE;
            }
        } else {
            CardPlayerLog.i(TAG, "disable gravity sensor");
            HardwareService service11 = this.mHardwareServiceClient.getService();
            if (service11 != null) {
                service11.setGravityEnable(false);
                Unit unit21 = Unit.INSTANCE;
            }
        }
        IPlayerContainer iPlayerContainer16 = this.mPlayerContainer;
        if (iPlayerContainer16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer16 = null;
        }
        iPlayerContainer16.getInteractLayerService().setDanmakuMonopolizeTap(true);
        IPlayerContainer iPlayerContainer17 = this.mPlayerContainer;
        if (iPlayerContainer17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer17 = null;
        }
        iPlayerContainer17.getInteractLayerService().setInlineMode(cardPlayTask.isDanmakuInlineMode());
        IPlayerContainer iPlayerContainer18 = this.mPlayerContainer;
        if (iPlayerContainer18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer18 = null;
        }
        iPlayerContainer18.getInteractLayerService().setDanmakuSwitchShareEnable(cardPlayTask.isDanmakuSwitchShareEnable());
        IPlayerContainer iPlayerContainer19 = this.mPlayerContainer;
        if (iPlayerContainer19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer19 = null;
        }
        iPlayerContainer19.getInteractLayerService().setAutomaticViewProgressRequestDisabled(true);
        String it6 = cardPlayTask.getPlayableParamsList().get(0).getSpmid();
        if (it6 != null) {
            IPlayerContainer iPlayerContainer20 = this.mPlayerContainer;
            if (iPlayerContainer20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer20 = null;
            }
            iPlayerContainer20.getInteractLayerService().setDanmakuExposureSpmid(it6);
            Unit unit22 = Unit.INSTANCE;
            Unit unit23 = Unit.INSTANCE;
        }
        this.mPendingSeekPosition = cardPlayTask.getStartPosition();
        ICardPlayTask iCardPlayTask4 = this.mCardPlayTask;
        if (iCardPlayTask4 != null && iCardPlayTask4.enableChronos()) {
            CardPlayerLog.i(TAG, "init and bind chronos service");
            ICardPlayTask iCardPlayTask5 = this.mCardPlayTask;
            if (iCardPlayTask5 != null && (it = iCardPlayTask5.getCardTaskRepository()) != null) {
                IPlayerContainer iPlayerContainer21 = this.mPlayerContainer;
                if (iPlayerContainer21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer21 = null;
                }
                IRemoteHandler remoteHandler = iPlayerContainer21.getInteractLayerService().getRemoteHandler();
                if (remoteHandler != null) {
                    remoteHandler.updateRelationshipChainChanged(translateRelationShipChain(it.getChronosRelationShipChain()));
                    Unit unit24 = Unit.INSTANCE;
                }
                IPlayerContainer iPlayerContainer22 = this.mPlayerContainer;
                if (iPlayerContainer22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer22 = null;
                }
                iPlayerContainer22.getInteractLayerService().setSceneAndBizParams((ChronosScene) it.getChronosSceneAndBiz().getFirst(), (ChronosBiz) it.getChronosSceneAndBiz().getSecond());
                Unit unit25 = Unit.INSTANCE;
                Unit unit26 = Unit.INSTANCE;
            }
            ICardPlayTask iCardPlayTask6 = this.mCardPlayTask;
            if (iCardPlayTask6 != null && (cardTaskRepository = iCardPlayTask6.getCardTaskRepository()) != null) {
                cardTaskRepository.setRelationShipChangeObserver(this.mRelationShipChangedObserver);
                Unit unit27 = Unit.INSTANCE;
            }
            IPlayerContainer iPlayerContainer23 = this.mPlayerContainer;
            if (iPlayerContainer23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer23 = null;
            }
            ILocalHandler localHandler = iPlayerContainer23.getInteractLayerService().getLocalHandler();
            if (localHandler != null) {
                ICardPlayTask iCardPlayTask7 = this.mCardPlayTask;
                localHandler.registerRpcInvokeObserver(new CardChronosInvokeObserver(iCardPlayTask7 != null ? iCardPlayTask7.getCardTaskRepository() : null));
                Unit unit28 = Unit.INSTANCE;
            }
            resetChronosPackageForLiveInline();
            checkLiveInline(cardPlayTask);
        } else {
            CardPlayerLog.i(TAG, "do not need bind chronos");
        }
        IPlayerContainer iPlayerContainer24 = this.mPlayerContainer;
        if (iPlayerContainer24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer24 = null;
        }
        IInteractLayerService interactLayerService = iPlayerContainer24.getInteractLayerService();
        ICardPlayTask iCardPlayTask8 = this.mCardPlayTask;
        interactLayerService.setChronosEnable(iCardPlayTask8 != null ? iCardPlayTask8.enableChronos() : false);
        ICardPlayTask iCardPlayTask9 = this.mCardPlayTask;
        ICardPlayTask.CardPlayerReportScene cardPlayerReportScene = iCardPlayTask9 != null ? iCardPlayTask9.getCardPlayerReportScene() : null;
        switch (cardPlayerReportScene == null ? -1 : WhenMappings.$EnumSwitchMapping$1[cardPlayerReportScene.ordinal()]) {
            case 1:
                IPlayerContainer iPlayerContainer25 = this.mPlayerContainer;
                if (iPlayerContainer25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer = null;
                } else {
                    iPlayerContainer = iPlayerContainer25;
                }
                iPlayerContainer.getReporterService().notifySceneChange(PlayScene.INLINEV3);
                Unit unit29 = Unit.INSTANCE;
                return;
            case 2:
                IPlayerContainer iPlayerContainer26 = this.mPlayerContainer;
                if (iPlayerContainer26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer26 = null;
                }
                iPlayerContainer26.getReporterService().notifySceneChange(PlayScene.MINI_SCREEN);
                IPlayerContainer iPlayerContainer27 = this.mPlayerContainer;
                if (iPlayerContainer27 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer27 = null;
                }
                PlayerContainer playerContainer2 = iPlayerContainer27 instanceof PlayerContainer ? (PlayerContainer) iPlayerContainer27 : null;
                if (playerContainer2 != null && (heartbeatService = playerContainer2.getHeartbeatService()) != null) {
                    heartbeatService.notifyMiniPlayerSwitch(true);
                    break;
                } else {
                    return;
                }
                break;
        }
        Unit unit30 = Unit.INSTANCE;
    }

    private final void setAudioMute(boolean isMute) {
        AudioFocusService service = this.mAudioFocusClient.getService();
        if (service != null) {
            service.disableRequestAudioFocus(isMute);
        }
    }

    private final void handleResetAudioIndex() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerCoreService().resetAudioIndex();
    }

    private final void checkLiveInline(final ICardPlayTask cardPlayTask) {
        IPlayerContainer iPlayerContainer = null;
        if (!isLiveInlineTask(cardPlayTask)) {
            IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
            if (iPlayerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                iPlayerContainer = iPlayerContainer2;
            }
            iPlayerContainer.getInteractLayerService().unregisterChronosReadyCallback();
        } else if (!DeviceDecision.INSTANCE.getBoolean("inline.live.damaku.useable", true)) {
            CardDanmakuManager cardDanmakuManager = this.mCardDanmakuManager;
            if (cardDanmakuManager != null) {
                cardDanmakuManager.release();
            }
            this.mCardDanmakuManager = null;
            BLog.d(TAG, "not hit [inline.live.damaku.useable], do not connect socket for live inline");
            IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
            if (iPlayerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                iPlayerContainer = iPlayerContainer3;
            }
            iPlayerContainer.getInteractLayerService().unregisterChronosReadyCallback();
        } else {
            IPlayerContainer iPlayerContainer4 = this.mPlayerContainer;
            if (iPlayerContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer4 = null;
            }
            if (iPlayerContainer4.getInteractLayerService().isChronosValid()) {
                reqLiveInlineChronos(cardPlayTask);
                IPlayerContainer iPlayerContainer5 = this.mPlayerContainer;
                if (iPlayerContainer5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    iPlayerContainer = iPlayerContainer5;
                }
                iPlayerContainer.getInteractLayerService().unregisterChronosReadyCallback();
                return;
            }
            IPlayerContainer iPlayerContainer6 = this.mPlayerContainer;
            if (iPlayerContainer6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                iPlayerContainer = iPlayerContainer6;
            }
            iPlayerContainer.getInteractLayerService().registerChronosReadyCallback(new OnChronosReadyCallback() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$checkLiveInline$1
                @Override // tv.danmaku.biliplayerv2.service.interact.biz.OnChronosReadyCallback
                public void onChronosReady() {
                    DefaultCardPlayer.this.reqLiveInlineChronos(cardPlayTask);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reqLiveInlineChronos(ICardPlayTask cardPlayTask) {
        Video.PlayableParams params = cardPlayTask.getPlayableParamsList().get(0);
        this.mCardDanmakuManager = new CardDanmakuManager();
        Video.DanmakuResolveParams danmakuResolveParams = params.getDanmakuResolveParams();
        if (danmakuResolveParams != null) {
            long it = danmakuResolveParams.getAvid();
            CardDanmakuManager cardDanmakuManager = this.mCardDanmakuManager;
            if (cardDanmakuManager != null) {
                cardDanmakuManager.initLiveDanmaku(it);
            }
            CardDanmakuManager cardDanmakuManager2 = this.mCardDanmakuManager;
            if (cardDanmakuManager2 != null) {
                cardDanmakuManager2.setSocketScene(cardPlayTask.getLiveScene());
            }
            CardDanmakuManager cardDanmakuManager3 = this.mCardDanmakuManager;
            if (cardDanmakuManager3 != null) {
                cardDanmakuManager3.registerCardDanmakuCallback(new DefaultCardPlayer$reqLiveInlineChronos$1$1(this));
            }
        }
    }

    private final ShipChainChange.Request translateRelationShipChain(DataRelationShipChain data) {
        ShipChainChange.Request shipChain = new ShipChainChange.Request();
        shipChain.setCoinState(data.getRelationCoinState());
        shipChain.setLikeState(data.getRelationLikeState());
        shipChain.setLikeNum(data.getRelationLikeNum());
        shipChain.setFavoriteState(data.getRelationFavoriteState());
        shipChain.setFollowState(data.getRelationFollowState());
        return shipChain;
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public void play(int index) {
        TraceCompat.beginSection("DefaultCardPlayer_PLAY");
        playInMainThread(index);
        TraceCompat.endSection();
    }

    private final void playInMainThread(int index) {
        playInternal(index);
    }

    private final void playInternal(int index) {
        if (this.mCardPlayTask == null) {
            throw new IllegalStateException("must call attachToTask(host: IHost) first");
        }
        IPlayerContainer iPlayerContainer = null;
        if (this.mPendingPlaySharedId > 0) {
            ICardPlayTask iCardPlayTask = this.mCardPlayTask;
            if (iCardPlayTask != null && this.mPendingPlaySharedId == iCardPlayTask.getSharedRecordId()) {
                IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
                if (iPlayerContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    iPlayerContainer = iPlayerContainer2;
                }
                iPlayerContainer.getVideoPlayDirectorService().playFromShared();
                this.mPendingPlaySharedId = -1;
            }
        }
        IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
        if (iPlayerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer3 = null;
        }
        iPlayerContainer3.getFunctionWidgetService().showBufferingWidget();
        IPlayerContainer iPlayerContainer4 = this.mPlayerContainer;
        if (iPlayerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            iPlayerContainer = iPlayerContainer4;
        }
        iPlayerContainer.getVideoPlayDirectorService().play(0, index);
        this.mPendingPlaySharedId = -1;
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void pause() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerCoreService().pause();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setAudioOnly(boolean audioOnly) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerCoreService().setAudioOnly(audioOnly);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void showDanmaku(boolean fromUser) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getInteractLayerService().showDanmaku(fromUser);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void hideDanmaku(boolean fromUser) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getInteractLayerService().hideDanmaku(fromUser);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public Map<String, String> getDanmakuReportParams() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        return iPlayerContainer.getInteractLayerService().getDanmakuReportCommonParameters();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public long getCurrentPosition() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        IPlayerContainer iPlayerContainer2 = null;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        int state = iPlayerContainer.getPlayerCoreService().getState();
        if (state < 3) {
            CardPlayerLog.i(TAG, "get card player current position = 0, player state: " + getPlayerState());
            return 0L;
        }
        IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
        if (iPlayerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            iPlayerContainer2 = iPlayerContainer3;
        }
        return iPlayerContainer2.getPlayerCoreService().getCurrentPosition();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public long getRealCurrentPosition() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        return iPlayerContainer.getPlayerCoreService().getRealCurrentPosition();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void replay() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getVideoPlayDirectorService().replayCurrentVideoItem();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void reload() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        IPlayerContainer iPlayerContainer2 = null;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getFunctionWidgetService().showBufferingWidget();
        IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
        if (iPlayerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            iPlayerContainer2 = iPlayerContainer3;
        }
        iPlayerContainer2.getVideoPlayDirectorService().reloadCurrentVideoItem();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public int getPlayerState() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        return iPlayerContainer.getPlayerCoreService().getState();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public long getDuration() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        IPlayerContainer iPlayerContainer2 = null;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        int state = iPlayerContainer.getPlayerCoreService().getState();
        if (state < 3) {
            CardPlayerLog.i(TAG, "get card player duration = 0, player state: " + getPlayerState());
            return 0L;
        }
        IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
        if (iPlayerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            iPlayerContainer2 = iPlayerContainer3;
        }
        return iPlayerContainer2.getPlayerCoreService().getDuration();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public long getRealDuration() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        return iPlayerContainer.getPlayerCoreService().getRealDuration();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void hideControl() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getControlContainerService().hide();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void showControl() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getControlContainerService().show();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public ControlContainerType getCurrentControlContainerType() {
        return this.mCurrentContainerType;
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void switchOrientation(int orientation) {
        HardwareService service;
        ICardPlayTask iCardPlayTask = this.mCardPlayTask;
        boolean z = false;
        if (iCardPlayTask != null && iCardPlayTask.enableGravitySensor()) {
            z = true;
        }
        if (!z || !this.alreadyLoadedHardwareService || (service = this.mHardwareServiceClient.getService()) == null) {
            return;
        }
        service.switchScreenOrientation(orientation);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setControlContainerType(ControlContainerType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!this.mCurrentControlContainerConfig.containsKey(type)) {
            CardPlayerLog.e(TAG, "currentControlContainerConfig could not contain type@" + type);
            return;
        }
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getControlContainerService().switchTo(type);
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public <T extends IPlayerService> void startService(Class<? extends T> cls, PlayerServiceManager.Client<T> client) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        if (client != null) {
            IPlayerContainer iPlayerContainer = this.mPlayerContainer;
            if (iPlayerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer = null;
            }
            iPlayerContainer.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(cls), client);
            return;
        }
        startServiceInternal(cls);
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public <T extends IPlayerService> void bindService(Class<? extends T> cls, PlayerServiceManager.Client<T> client, boolean autoCreate) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(client, "client");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(cls), client, autoCreate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public <T extends IPlayerService> void unbindService(PlayerServiceManager.Client<T> client) {
        Class clazz;
        Intrinsics.checkNotNullParameter(client, "client");
        T service = client.getService();
        if (service == null || (clazz = service.getClass()) == null) {
            return;
        }
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerServiceManager().unbindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(clazz), client);
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public void stopService(Class<? extends IPlayerService> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        stopServiceInternal(cls);
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public void listenPlayerReady(CardPlayerReadyObserver observer) {
        CardPlayerReadyObserver cardPlayerReadyObserver;
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerReadyObserver = observer;
        if (!isReady() || (cardPlayerReadyObserver = this.mPlayerReadyObserver) == null) {
            return;
        }
        cardPlayerReadyObserver.onReady();
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public boolean isReady() {
        return this.mIsReady;
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public int prepareForShare(boolean keepRender, boolean needMute) {
        PlayerSharingBundle $this$prepareForShare_u24lambda_u240;
        Lifecycle lifecycle;
        ExtraInfo extraInfo;
        ArchiveInfo archiveInfo;
        if (isReady()) {
            IPlayerContainer iPlayerContainer = this.mPlayerContainer;
            if (iPlayerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer = null;
            }
            MediaResource mediaResource = iPlayerContainer.getPlayerCoreService().getMediaResource();
            boolean z = false;
            if (mediaResource != null && (extraInfo = mediaResource.getExtraInfo()) != null && (archiveInfo = PlayerResolveExtraInfosUtilKt.getArchiveInfo(extraInfo)) != null && archiveInfo.isInteract()) {
                z = true;
            }
            if (z) {
                CardPlayerLog.i(TAG, "video is interact, cannot share");
                return -1;
            }
            releaseCardDanmaku();
            setAudioMute(true);
            if (!needMute) {
                IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
                if (iPlayerContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    iPlayerContainer2 = null;
                }
                iPlayerContainer2.getPlayerCoreService().setVolume(1.0f, 1.0f);
            }
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver((LifecycleObserver) this);
            }
            if (keepRender) {
                $this$prepareForShare_u24lambda_u240 = new PlayerSharingBundle();
                $this$prepareForShare_u24lambda_u240.getBundle().putBoolean(PlayerSharingBundle.KEY_SHARE_KEEP_RENDER, true);
                $this$prepareForShare_u24lambda_u240.getBundle().putBoolean("key_share_player_viewport_until_surface_created", true);
            } else {
                $this$prepareForShare_u24lambda_u240 = new PlayerSharingBundle();
            }
            IPlayerContainer.Companion companion = IPlayerContainer.Companion;
            PlayerSharingType playerSharingType = PlayerSharingType.NORMAL;
            IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
            if (iPlayerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer3 = null;
            }
            return companion.prepareForShare(playerSharingType, iPlayerContainer3, $this$prepareForShare_u24lambda_u240, null);
        }
        return -1;
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void updateViewPort(Rect viewPort, List<? extends BuiltInLayer> list, List<String> list2, boolean immediately) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.updateViewPort(viewPort, list, list2, immediately);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void resume() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerCoreService().resume();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void stop() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerCoreService().stop();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public VideoEnvironment getVideoEnvironment() {
        PlayerNetworkService service = this.mNetworkServiceClient.getService();
        if (service != null) {
            return service.getVideoEnvironment();
        }
        return null;
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void addCloudConfigObserver(ICloudConfigObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerSettingService().addCloudConfigObserver(observer);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void removeCloudConfigObserver(ICloudConfigObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerSettingService().removeCloudConfigObserver(observer);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void addHeadsetEventObserver(IPlayerHeadsetEventCallback observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        PlayerHeadsetService service = this.mPlayerHeadsetServiceClient.getService();
        if (service != null) {
            service.addHeadsetEventObserver(observer);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void removeHeadsetEventObserver(IPlayerHeadsetEventCallback observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        PlayerHeadsetService service = this.mPlayerHeadsetServiceClient.getService();
        if (service != null) {
            service.removeHeadsetEventObserver(observer);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public PlayerCloudConfig getPlayerSettingCloudConfig() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        return iPlayerContainer.getPlayerSettingService().getCloudConfig();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setNetworkAlertEnable(boolean enable) {
        if (enable) {
            PlayerNetworkService service = this.mNetworkServiceClient.getService();
            if (service != null) {
                service.setShowAlertMode(ShowAlertMode.AppOnce);
                return;
            }
            return;
        }
        PlayerNetworkService service2 = this.mNetworkServiceClient.getService();
        if (service2 != null) {
            service2.setShowAlertMode(ShowAlertMode.None);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public boolean isNetworkPanelShowed() {
        PlayerNetworkService service = this.mNetworkServiceClient.getService();
        if (service != null) {
            return service.isNetworkPanelShowed();
        }
        return false;
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public Video.PlayableParams getCurrentPlayableParams() {
        IPlayerContainer iPlayerContainer = null;
        if (this.mCardPlayTask == null) {
            return null;
        }
        IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
        if (iPlayerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            iPlayerContainer = iPlayerContainer2;
        }
        return iPlayerContainer.getVideoPlayDirectorService().getCurrentPlayableParams();
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public void show() {
        if (this.mCardPlayTask == null) {
            CardPlayerLog.w(TAG, "do not attach a request this moment, do nothing");
        } else {
            showPlayerIfNeed();
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer, tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setMute(boolean isMute) {
        setAudioMute(isMute);
        IPlayerContainer iPlayerContainer = null;
        if (isMute) {
            IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
            if (iPlayerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                iPlayerContainer = iPlayerContainer2;
            }
            iPlayerContainer.getPlayerCoreService().setVolume(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            return;
        }
        IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
        if (iPlayerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            iPlayerContainer = iPlayerContainer3;
        }
        iPlayerContainer.getPlayerCoreService().setVolume(1.0f, 1.0f);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void allowToContinuePlay() {
        PlayerNetworkService service = this.mNetworkServiceClient.getService();
        if (service != null) {
            service.allowToContinuePlay();
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public long getBufferedPosition() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        IPlayerContainer iPlayerContainer2 = null;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        float percent = iPlayerContainer.getPlayerCoreService().getBufferedPercentage();
        IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
        if (iPlayerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            iPlayerContainer2 = iPlayerContainer3;
        }
        int duration = iPlayerContainer2.getPlayerCoreService().getDuration();
        return duration * percent;
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void seekTo(long targetPosition) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerCoreService().seekTo((int) targetPosition);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setPlaySpeed(float speed) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerCoreService().setPlaySpeed(speed);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public float getPlaySpeed() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        return IPlayerCoreService.CC.getPlaySpeed$default(iPlayerContainer.getPlayerCoreService(), false, 1, null);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void hideBufferingView() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getFunctionWidgetService().hideBufferingWidget();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void showBufferingView() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getFunctionWidgetService().showBufferingWidget();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void report(NeuronsEvents.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getReporterService().report(event);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public String getCurrentPlayUrl() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        return IPlayerCoreService.CC.getCurrentPlayUrl$default(iPlayerContainer.getPlayerCoreService(), false, 1, null);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void takeVideoCapture(IMediaPlayRenderContext.OnTakeVideoCapture callback, int width, int height) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getRenderContainerService().takeVideoCapture(callback, width, height);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setAspectRatio(AspectRatio ratio) {
        Intrinsics.checkNotNullParameter(ratio, "ratio");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getRenderContainerService().setAspectRatio(ratio);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public int getVideoWidth() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        return iPlayerContainer.getRenderContainerService().getVideoWidth();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public int getVideoHeight() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        return iPlayerContainer.getRenderContainerService().getVideoHeight();
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public void setControlContainerConfig(Map<ControlContainerType, ControlContainerConfig> map, ControlContainerType initializeType) {
        Intrinsics.checkNotNullParameter(map, "config");
        Intrinsics.checkNotNullParameter(initializeType, "initializeType");
        this.mDefaultControlContainerConfig = map;
        applyControlContainerConfig(map, initializeType);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void resetVideoFlip() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        IPlayerContainer iPlayerContainer2 = null;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        boolean isFlip = iPlayerContainer.getPlayerSettingService().getBoolean(Player.KEY_FLIP_VIDEO_SELECTED, false);
        if (isFlip) {
            IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
            if (iPlayerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                iPlayerContainer2 = iPlayerContainer3;
            }
            iPlayerContainer2.getRenderContainerService().flipVideo(!isFlip);
        }
    }

    private final void applyControlContainerConfig(Map<ControlContainerType, ControlContainerConfig> map, ControlContainerType initializeType) {
        if (!Intrinsics.areEqual(this.mCurrentControlContainerConfig, map)) {
            IPlayerContainer iPlayerContainer = this.mPlayerContainer;
            if (iPlayerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer = null;
            }
            iPlayerContainer.getControlContainerService().setControlContainerConfig(map);
            this.mCurrentControlContainerConfig = map;
        }
        if (initializeType != this.mCurrentContainerType) {
            setControlContainerType(initializeType);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public void setHardwareDelegate(IHardwareDelegate delegate) {
        this.mDefaultCustomHardwareDelegate = delegate;
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public boolean performBackPressed() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        if (iPlayerContainer.onBackPressed()) {
            return true;
        }
        HardwareService service = this.mHardwareServiceClient.getService();
        if (service != null) {
            return service.performBackPressed();
        }
        return false;
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public void performConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.onConfigurationChanged(newConfig);
        HardwareService service = this.mHardwareServiceClient.getService();
        if (service != null) {
            service.onConfigurationChanged(newConfig);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public void performMultiWindowModeChanged(boolean isInMultiWindowMode) {
        HardwareService service = this.mHardwareServiceClient.getService();
        if (service != null) {
            service.onMultiWindowModeChanged(isInMultiWindowMode);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void addDoubleTapListener(OnDoubleTapListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IGestureService iGestureService = (GestureService) this.mGestureClient.getService();
        if (iGestureService != null) {
            IGestureService.-CC.addOnDoubleTapListener$default(iGestureService, listener, 0, 2, (Object) null);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void removerDoubleTapListener(OnDoubleTapListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        GestureService service = this.mGestureClient.getService();
        if (service != null) {
            service.removeOnDoubleTapListener(listener);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void addSingleTapListener(OnSingleTapListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IGestureService iGestureService = (GestureService) this.mGestureClient.getService();
        if (iGestureService != null) {
            IGestureService.-CC.addOnSingleTapListener$default(iGestureService, listener, 0, 2, (Object) null);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void removerSingleTapListener(OnSingleTapListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        GestureService service = this.mGestureClient.getService();
        if (service != null) {
            service.removeOnSingleTapListener(listener);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void addLongPressListener(OnLongPressListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IGestureService iGestureService = (GestureService) this.mGestureClient.getService();
        if (iGestureService != null) {
            IGestureService.-CC.addOnLongPressListener$default(iGestureService, listener, 0, 2, (Object) null);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void removeLongPressListener(OnLongPressListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        GestureService service = this.mGestureClient.getService();
        if (service != null) {
            service.removeOnLongPressListener(listener);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void registerPlayerProgressRangeObserver(PlayerProgressRangeObserver observer, long startPosition, long endPosition) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerCoreService().registerPlayerProgressRangeObserver(observer, startPosition, endPosition);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void unregisterPlayerProgressRangeObserver(PlayerProgressRangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerCoreService().unregisterPlayerProgressRangeObserver(observer);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void registerPlayerProgressObserver(PlayerProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerCoreService().registerPlayerProgressObserver(observer);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void unregisterPlayerProgressObserver(PlayerProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerCoreService().unregisterPlayerProgressObserver(observer);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void registerChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler) {
        Intrinsics.checkNotNullParameter(chronosRequestHandler, "handler");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getInteractLayerService().registerChronosMessageHandler(chronosRequestHandler);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void unregisterChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler) {
        Intrinsics.checkNotNullParameter(chronosRequestHandler, "handler");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getInteractLayerService().unregisterChronosMessageHandler(chronosRequestHandler);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public IRemoteHandler getChronosRemoteHandler() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        return iPlayerContainer.getInteractLayerService().getRemoteHandler();
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setVisibleRect(DanmakuConfigChange.VisibleRect visibleRect) {
        Intrinsics.checkNotNullParameter(visibleRect, "visibleRect");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getInteractLayerService().setVisibleRect(visibleRect);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public MediaSessionCompat getMediaSession(boolean autoCreate) {
        PlayerHeadsetService service = this.mPlayerHeadsetServiceClient.getService();
        if (service != null) {
            return service.getMediaSession(autoCreate);
        }
        return null;
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public IMediaSessionPlayback getMediaSessionPlayback() {
        PlayerHeadsetService service = this.mPlayerHeadsetServiceClient.getService();
        if (service != null) {
            return service.getMediaSessionPlayback();
        }
        return null;
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setMediaSessionPlayback(IMediaSessionPlayback playback) {
        Intrinsics.checkNotNullParameter(playback, "playback");
        PlayerHeadsetService service = this.mPlayerHeadsetServiceClient.getService();
        if (service != null) {
            service.setMediaSessionPlayback(playback);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setMediaSessionControllerCallback(MediaSessionControllerCallback callback) {
        PlayerHeadsetService service = this.mPlayerHeadsetServiceClient.getService();
        if (service != null) {
            service.setMediaSessionControllerCallback(callback);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void updateMediaSessionPlaybackState() {
        PlayerHeadsetService service = this.mPlayerHeadsetServiceClient.getService();
        if (service != null) {
            service.updatePlaybackState();
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setRenderViewOffset(int offsetY) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        IRenderContainerService.CC.setViewportOffset$default(iPlayerContainer.getRenderContainerService(), 0, offsetY, false, 5, null);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void blockBottomChronos(boolean block) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getInteractLayerService().setBlockBottom(block, false);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setDanmakuAvoidScript(boolean avoidScript) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getInteractLayerService().setDanmakuAvoidScript(avoidScript, false);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setSceneAndBizParams(ChronosScene scene, ChronosBiz biz) {
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        Intrinsics.checkNotNullParameter(biz, "biz");
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getInteractLayerService().setSceneAndBizParams(scene, biz);
    }

    @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
    public void setBackgroundImage(Bitmap bitmap, boolean recycle, Rect rect) {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getRenderContainerService().setBackgroundImage(bitmap, recycle, rect);
    }

    private final void installRequestServices(List<? extends Class<? extends IPlayerService>> list) {
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append('[');
        for (Class clazz : list) {
            startServiceInternal(clazz);
            msgBuilder.append(clazz.getCanonicalName()).append(", ");
        }
        msgBuilder.append(']');
        CardPlayerLog.i(TAG, "install request services: " + ((Object) msgBuilder));
    }

    private final void uninstallRequestServices(List<? extends Class<? extends IPlayerService>> list) {
        for (Class clazz : list) {
            stopServiceInternal(clazz);
        }
        CardPlayerLog.i(TAG, "uninstall request services");
    }

    private final void installRequestLayer(List<ICardPlayTask.PlayerLayerDescriptor> list) {
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append('[');
        for (ICardPlayTask.PlayerLayerDescriptor d : list) {
            d.getLayer().setCardPlayerContext(this);
            IPlayerContainer iPlayerContainer = this.mPlayerContainer;
            if (iPlayerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer = null;
            }
            iPlayerContainer.addPlayerLayer(d.getOver(), d.getLayer());
            msgBuilder.append(d.getLayer().getClass().getCanonicalName()).append(", ");
        }
        msgBuilder.append(']');
        CardPlayerLog.i(TAG, "install request layers: " + ((Object) msgBuilder));
    }

    private final void uninstallRequestLayer(List<ICardPlayTask.PlayerLayerDescriptor> list) {
        for (ICardPlayTask.PlayerLayerDescriptor d : list) {
            IPlayerContainer iPlayerContainer = this.mPlayerContainer;
            if (iPlayerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer = null;
            }
            iPlayerContainer.removePlayerLayer(d.getLayer());
            d.getLayer().setCardPlayerContext(null);
        }
        CardPlayerLog.i(TAG, "uninstall request layer");
    }

    @Override // tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer
    public ICardPlayTask detachFromTask(ICardPlayTask detachTask, boolean changeContainer) {
        if (Intrinsics.areEqual(this.detachingTask, detachTask)) {
            CardPlayerLog.i(TAG, "detach from same task");
            return null;
        }
        CardPlayerLog.i(TAG, "detach from request: " + this.mCardPlayTask);
        ICardPlayTask request = this.mCardPlayTask;
        if (request == null) {
            this.mCardPlayTask = null;
            CardPlayerLog.w(TAG, "do not have a host attached to the player");
            return null;
        }
        this.detachingTask = request;
        detachFromTaskInMainThread(changeContainer, request);
        return request;
    }

    private final void detachFromTaskInMainThread(boolean changeContainer, ICardPlayTask request) {
        CardTaskRepository cardTaskRepository;
        IHeartbeatService heartbeatService;
        CardPlayerLog.i(TAG, "detach from request in main thread");
        setPlayEnable(false);
        uninstallRequestServices(CollectionsKt.emptyList());
        uninstallRequestLayer(request.getPlayerLayerDescriptors());
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getFunctionWidgetService().hideAllWidget();
        View view2 = this.mPlayerRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
            view2 = null;
        }
        view2.setAlpha(1.0f);
        if (changeContainer) {
            ViewGroup container = request.getContainer();
            View view3 = this.mPlayerRootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
                view3 = null;
            }
            container.removeView(view3);
        }
        IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
        if (iPlayerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer2 = null;
        }
        PlayerContainer playerContainer = iPlayerContainer2 instanceof PlayerContainer ? (PlayerContainer) iPlayerContainer2 : null;
        if (playerContainer != null && (heartbeatService = playerContainer.getHeartbeatService()) != null) {
            heartbeatService.notifyMiniPlayerSwitch(false);
        }
        HardwareService service = this.mHardwareServiceClient.getService();
        if (service != null) {
            service.stopGravitySensor();
        }
        IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
        if (iPlayerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer3 = null;
        }
        iPlayerContainer3.getPlayerCoreService().stop();
        IPlayerContainer iPlayerContainer4 = this.mPlayerContainer;
        if (iPlayerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer4 = null;
        }
        iPlayerContainer4.getReporterService().notifySceneChange(PlayScene.INLINEV3);
        Iterable $this$forEach$iv = request.getSeekInterceptor();
        for (Object element$iv : $this$forEach$iv) {
            ISeekInterceptor it = (ISeekInterceptor) element$iv;
            IPlayerContainer iPlayerContainer5 = this.mPlayerContainer;
            if (iPlayerContainer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer5 = null;
            }
            iPlayerContainer5.getPlayerCoreService().removeSeekInterceptor(it);
        }
        resetChronosPackageForLiveInline();
        CardDanmakuManager cardDanmakuManager = this.mCardDanmakuManager;
        if (cardDanmakuManager != null) {
            cardDanmakuManager.release();
        }
        this.mCardDanmakuManager = null;
        IPlayerContainer iPlayerContainer6 = this.mPlayerContainer;
        if (iPlayerContainer6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer6 = null;
        }
        iPlayerContainer6.getPlayerCoreService().setCurrentPositionInterceptor(null);
        IPlayerContainer iPlayerContainer7 = this.mPlayerContainer;
        if (iPlayerContainer7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer7 = null;
        }
        iPlayerContainer7.getPlayerCoreService().setDurationInterceptor(null);
        ICardPlayTask iCardPlayTask = this.mCardPlayTask;
        if (iCardPlayTask != null && (cardTaskRepository = iCardPlayTask.getCardTaskRepository()) != null) {
            cardTaskRepository.setRelationShipChangeObserver(null);
        }
        IPlayerContainer iPlayerContainer8 = this.mPlayerContainer;
        if (iPlayerContainer8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer8 = null;
        }
        ILocalHandler localHandler = iPlayerContainer8.getInteractLayerService().getLocalHandler();
        if (localHandler != null) {
            localHandler.unregisterRpcInvokeObserver();
        }
        this.mTaskMediaItemParamsInterceptor = null;
        this.mCardPlayTask = null;
        this.detachingTask = null;
    }

    private final void resetChronosPackageForLiveInline() {
        ICardPlayTask it = this.mCardPlayTask;
        if (it != null && isLiveInlineTask(it)) {
            BLog.d(TAG, "clear chronos package");
            IPlayerContainer iPlayerContainer = this.mPlayerContainer;
            if (iPlayerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer = null;
            }
            iPlayerContainer.getInteractLayerService().clearChronosPackage();
        }
    }

    private final boolean isLiveInlineTask(ICardPlayTask cardPlayTask) {
        Video.PlayableParams params = cardPlayTask.getPlayableParamsList().get(0);
        return Intrinsics.areEqual(params.getFrom(), "live") && cardPlayTask.isDanmakuInlineMode();
    }

    private final void releaseCardDanmaku() {
        CardDanmakuManager cardDanmakuManager = this.mCardDanmakuManager;
        if (cardDanmakuManager != null) {
            cardDanmakuManager.release();
        }
        this.mCardDanmakuManager = null;
    }

    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        CardPlayerLog.i(TAG, "on lifecycle start");
        onStartInternal();
    }

    private final void onStartInternal() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.onStart();
    }

    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        CardPlayerLog.i(TAG, "on lifecycle resume");
        onResumeInternal();
    }

    private final void onResumeInternal() {
        HardwareService service;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.onResume();
        ICardPlayTask iCardPlayTask = this.mCardPlayTask;
        boolean z = false;
        if (iCardPlayTask != null && iCardPlayTask.enableGravitySensor()) {
            z = true;
        }
        if (!z || !this.alreadyLoadedHardwareService || (service = this.mHardwareServiceClient.getService()) == null) {
            return;
        }
        service.startGravitySensor();
    }

    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        CardPlayerLog.i(TAG, "on lifecycle pause");
        onPauseInternal();
    }

    private final void onPauseInternal() {
        HardwareService service;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.onPause();
        ICardPlayTask iCardPlayTask = this.mCardPlayTask;
        boolean z = false;
        if (iCardPlayTask != null && iCardPlayTask.enableGravitySensor()) {
            z = true;
        }
        if (!z || !this.alreadyLoadedHardwareService || (service = this.mHardwareServiceClient.getService()) == null) {
            return;
        }
        service.stopGravitySensor();
    }

    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        CardPlayerLog.i(TAG, "on lifecycle stop");
        onStopInternal();
    }

    private final void onStopInternal() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.onStop();
    }

    public void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        CardPlayerLog.i(TAG, "on lifecycle destroy");
        onDestroyInternal();
    }

    private final void onDestroyInternal() {
        Lifecycle lifecycle;
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getPlayerServiceManager().unbindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(GestureService.class), this.mGestureClient);
        IPlayerContainer iPlayerContainer2 = this.mPlayerContainer;
        if (iPlayerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer2 = null;
        }
        iPlayerContainer2.getPlayerServiceManager().unbindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(AudioFocusService.class), this.mAudioFocusClient);
        View view2 = this.mPlayerRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
            view2 = null;
        }
        view2.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusChangeListener);
        ICardPlayTask it = this.mCardPlayTask;
        if (it != null) {
            uninstallRequestLayer(it.getPlayerLayerDescriptors());
            View view3 = this.mPlayerRootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
                view3 = null;
            }
            view3.setAlpha(1.0f);
            ViewGroup container = it.getContainer();
            View view4 = this.mPlayerRootView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
                view4 = null;
            }
            container.removeView(view4);
        }
        View view5 = this.mPlayerRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
            view5 = null;
        }
        ViewParent parent = view5.getParent();
        if (parent instanceof ViewGroup) {
            if (BuildConfig.DEBUG) {
                throw new IllegalStateException("biliCardPlayer is attach on viewTree when destroy");
            }
            CardPlayerLog.e(TAG, "biliCardPlayer is attach on viewTree when destroy, remove it anyway");
            ViewGroup viewGroup = (ViewGroup) parent;
            View view6 = this.mPlayerRootView;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerRootView");
                view6 = null;
            }
            viewGroup.removeView(view6);
        }
        DisablePlayLock it2 = this.mDisablePlayLock;
        if (it2 != null) {
            IPlayerContainer iPlayerContainer3 = this.mPlayerContainer;
            if (iPlayerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer3 = null;
            }
            iPlayerContainer3.getPlayerCoreService().releaseDisablePlayLock(it2);
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver((LifecycleObserver) this);
        }
        IPlayerContainer iPlayerContainer4 = this.mPlayerContainer;
        if (iPlayerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer4 = null;
        }
        iPlayerContainer4.onDestroyView();
        IPlayerContainer iPlayerContainer5 = this.mPlayerContainer;
        if (iPlayerContainer5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer5 = null;
        }
        iPlayerContainer5.onDestroy();
        this.alreadyLoadedHardwareService = false;
        this.mTaskMediaItemParamsInterceptor = null;
        this.mCardPlayTask = null;
        this.mContext = null;
    }
}