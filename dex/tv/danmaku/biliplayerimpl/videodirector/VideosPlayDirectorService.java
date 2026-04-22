package tv.danmaku.biliplayerimpl.videodirector;

import androidx.collection.SparseArrayCompat;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.player.history.IMediaHistoryStorage;
import com.bilibili.player.history.MediaHistoryEntry;
import java.util.LinkedList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerimpl.AbsCorePlayerService;
import tv.danmaku.biliplayerimpl.BuildConfig;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerv2.PlayerContainerCoroutineKt;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.CurrentVideoPointer;
import tv.danmaku.biliplayerv2.service.IAssetUpdateObserver;
import tv.danmaku.biliplayerv2.service.IMediaItemParamsInterceptor;
import tv.danmaku.biliplayerv2.service.IPlayDirector;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerShareInterceptor;
import tv.danmaku.biliplayerv2.service.IShareDataInterceptor;
import tv.danmaku.biliplayerv2.service.IToastService;
import tv.danmaku.biliplayerv2.service.IVideoQualityProvider;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.NormalVideoPlayHandler;
import tv.danmaku.biliplayerv2.service.OnAssetUpdateListener;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.ResolveListener;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.VideoDirectorObserver;
import tv.danmaku.biliplayerv2.service.VideoPlayHandler;
import tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask;
import tv.danmaku.biliplayerv2.service.resolve.CommonResolveTaskProvider;
import tv.danmaku.biliplayerv2.service.resolve.DefaultCommonResolveTaskProvider;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.service.setting.Scope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;
import tv.danmaku.videoplayer.coreV2.MediaItem;

/* compiled from: VideosPlayDirectorService.kt */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0004-03h\u0018\u0000 \u0093\u00012\u00020\u00012\u00020\u0002:\u0002\u0093\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u00105\u001a\u0004\u0018\u000106H\u0016J\n\u00107\u001a\u0004\u0018\u00010\nH\u0016J\b\u00108\u001a\u00020\bH\u0016J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0006H\u0016J\n\u0010<\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010=\u001a\u00020:2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010B\u001a\u00020:H\u0016J\u0018\u0010C\u001a\u00020:2\u0006\u0010D\u001a\u00020E2\u0006\u0010>\u001a\u00020?H\u0016J\u001a\u0010F\u001a\u00020:2\u0006\u0010D\u001a\u00020E2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010G\u001a\u00020\u00172\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0010\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020\u001bH\u0016J\u0018\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\bH\u0016J \u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u0017H\u0016J\b\u0010N\u001a\u00020:H\u0016J\b\u0010O\u001a\u00020:H\u0016J\b\u0010P\u001a\u00020:H\u0016J\b\u0010Q\u001a\u00020\u0017H\u0016J\b\u0010R\u001a\u00020\u0017H\u0016J\b\u0010S\u001a\u00020\u0017H\u0016J\b\u0010T\u001a\u00020\u0017H\u0016J\b\u0010U\u001a\u00020\u0017H\u0016J\u0010\u0010V\u001a\u00020:2\u0006\u0010W\u001a\u00020\u0017H\u0016J\u0010\u0010X\u001a\u00020:2\u0006\u0010W\u001a\u00020\u0017H\u0016J\u0010\u0010Y\u001a\u00020:2\u0006\u0010W\u001a\u00020\u0017H\u0016J\b\u0010Z\u001a\u00020:H\u0016J\u0010\u0010[\u001a\u00020:2\u0006\u0010W\u001a\u00020\u0017H\u0016J\u0010\u0010\\\u001a\u00020:2\u0006\u0010]\u001a\u00020\u0017H\u0016J\u0010\u0010^\u001a\u00020:2\u0006\u0010_\u001a\u00020`H\u0016J\u0010\u0010a\u001a\u00020:2\u0006\u0010b\u001a\u00020\u0012H\u0016J\u0010\u0010c\u001a\u00020:2\u0006\u0010b\u001a\u00020\u0012H\u0016J\u0010\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010f\u001a\u00020:2\u0006\u0010e\u001a\u00020\u0015H\u0016J\b\u0010j\u001a\u00020\u0017H\u0016J\u001a\u0010k\u001a\u00020:2\u0006\u0010M\u001a\u00020\u00172\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\b\u0010n\u001a\u00020:H\u0016J\b\u0010o\u001a\u00020:H\u0002J\u0018\u0010p\u001a\u00020:2\u0006\u0010q\u001a\u00020\b2\u0006\u0010r\u001a\u00020\u000fH\u0016J\u0010\u0010s\u001a\u00020:2\u0006\u0010q\u001a\u00020\bH\u0016J\u0010\u0010s\u001a\u00020:2\u0006\u0010r\u001a\u00020\u000fH\u0016J\u0012\u0010t\u001a\u00020:2\b\u0010u\u001a\u0004\u0018\u00010#H\u0016J\n\u0010v\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010w\u001a\u00020:2\b\u0010x\u001a\u0004\u0018\u00010%H\u0016J\n\u0010y\u001a\u0004\u0018\u00010%H\u0016J\b\u0010z\u001a\u00020\bH\u0016J\u0010\u0010{\u001a\u00020:2\u0006\u0010|\u001a\u00020\u0017H\u0016J\b\u0010}\u001a\u00020\u0017H\u0016J\u0010\u0010~\u001a\u00020:2\u0006\u0010\u007f\u001a\u00020\u0017H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0017H\u0016J\u0011\u0010\u0081\u0001\u001a\u00020:2\u0006\u0010u\u001a\u00020)H\u0016J\t\u0010\u0082\u0001\u001a\u00020)H\u0016J\u0015\u0010\u0083\u0001\u001a\u00020:2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\u001c\u0010\u0086\u0001\u001a\u00020:2\u0011\u0010\u0087\u0001\u001a\f\u0012\u0005\u0012\u00030\u0089\u0001\u0018\u00010\u0088\u0001H\u0016J\t\u0010\u008a\u0001\u001a\u00020:H\u0002J\u0013\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010q\u001a\u00020\bH\u0002J\u0012\u0010\u008c\u0001\u001a\u00020:2\u0007\u0010\u008d\u0001\u001a\u00020\u0017H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020:2\u0007\u0010\u008d\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u008f\u0001\u001a\u00020\bH\u0016J\u0010\u0010S\u001a\u00020\u00172\u0006\u0010W\u001a\u00020\u0017H\u0016J\t\u0010\u0090\u0001\u001a\u00020\bH\u0016J\t\u0010\u0091\u0001\u001a\u00020:H\u0016J\t\u0010\u0092\u0001\u001a\u00020:H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0010\u001a&\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u0012 \u0013*\u0012\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u0012\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0014\u001a&\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00150\u0015 \u0013*\u0012\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R\u0010\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0004\n\u0002\u00101R\u0010\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0004\n\u0002\u00104R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0004\n\u0002\u0010i¨\u0006\u0094\u0001"}, d2 = {"Ltv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService;", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService;", "Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "<init>", "()V", "mPlayerDataSource", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "mPendingPlayIndex", "", "mCurrentVideo", "Ltv/danmaku/biliplayerv2/service/Video;", "mPreviousVideo", "mCurrentVideoIndex", "mVideoPlayHandlers", "Landroidx/collection/SparseArrayCompat;", "Ltv/danmaku/biliplayerv2/service/VideoPlayHandler;", "mVideoPlayEventListeners", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService$VideoPlayEventListener;", "kotlin.jvm.PlatformType", "mVideoDirectorObservers", "Ltv/danmaku/biliplayerv2/service/VideoDirectorObserver;", "mHandlingComplete", "", "mProcessCompleteActionEnable", "mProcessCompleteActionAvailable", "mPlayerContainer", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "mPlayerCoreService", "Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "mPlayerSettingService", "Ltv/danmaku/biliplayerv2/service/setting/IPlayerSettingService;", "mToastService", "Ltv/danmaku/biliplayerv2/service/IToastService;", "mVideoQualityProvider", "Ltv/danmaku/biliplayerv2/service/IVideoQualityProvider;", "mItemParamsInterceptor", "Ltv/danmaku/biliplayerv2/service/IMediaItemParamsInterceptor;", "mExpectedQuality", "mPlayFromSharedEnable", "mCommonResolveTaskProvider", "Ltv/danmaku/biliplayerv2/service/resolve/CommonResolveTaskProvider;", "mDanmakuJob", "Lkotlinx/coroutines/Job;", "mPlayerStateObserver", "tv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService$mPlayerStateObserver$1", "Ltv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService$mPlayerStateObserver$1;", "mAssetUpdateObserver", "tv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService$mAssetUpdateObserver$1", "Ltv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService$mAssetUpdateObserver$1;", "mDataSetChangedObserver", "tv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService$mDataSetChangedObserver$1", "Ltv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService$mDataSetChangedObserver$1;", "getCurrentPlayableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "getCurrentVideo", "getCurrentVideoIndex", "setPlayerDataSource", "", "source", "getPlayerDataSource", "onStart", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "mAssetUpdateListener", "Ltv/danmaku/biliplayerv2/service/OnAssetUpdateListener;", "onStop", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "onAttachByShared", "restoreStateFromShare", "bindPlayerContainer", "playerContainer", "play", "index", "itemIndex", "autoStart", "playFromShared", "replayCurrentVideo", "replayCurrentVideoItem", "hasPrevious", "hasPreVideo", "hasNext", "hasNextVideo", "hasNextVideoItem", "playNext", "loop", "playPrevious", "playNextVideoItem", "playNextVideo", "playPreVideoItem", "playPreVideo", "fromBegin", "playVideoItem", "item", "Ltv/danmaku/biliplayerv2/service/CurrentVideoPointer;", "addVideoPlayEventListener", "listener", "removeVideoPlayEventListener", "addVideoDirectorObserver", "observer", "removeVideoDirectorObserver", "mVideoPlayEventDispatcher", "tv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService$mVideoPlayEventDispatcher$1", "Ltv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService$mVideoPlayEventDispatcher$1;", "willAutoPlayNext", "updateMediaResource", "outerResolveListener", "Ltv/danmaku/biliplayerv2/service/ResolveListener;", "reloadCurrentVideoItem", "dispatchAllVideoCompleted", "registerVideoPlayHandler", "type", "handler", "unregisterVideoPlayHandler", "setVideoQualityProvider", "provider", "getVideoQualityProvider", "setMediaItemSettingInterceptor", "interceptor", "getMediaItemSettingInterceptor", "getCurrentExpectedQuality", "setProcessCompleteActionEnable", "enable", "isProcessCompleteActionEnable", "setProcessCompleteActionAvailable", "available", "isProcessCompleteActionAvailable", "setCommonResolveTaskProvider", "getCommonResolveTaskProvider", "setHistoryProgressReader", "reader", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$IHistoryProgressReader;", "setMediaHistoryStorage", "storage", "Lcom/bilibili/player/history/IMediaHistoryStorage;", "Lcom/bilibili/player/history/MediaHistoryEntry;", "handleCompletion", "getPlayerHandler", "switchToNext", "canLoop", "switchToPrevious", "itemCount", "getPlayingItemIndex", "resolveDanmaku", "cancelDanmakuTask", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideosPlayDirectorService extends AbsCorePlayerService implements IVideosPlayDirectorService {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "VideosPlayDirectorService";
    public static final int UNKNOWN_QUALITY = -1;
    private Video mCurrentVideo;
    private int mCurrentVideoIndex;
    private Job mDanmakuJob;
    private boolean mHandlingComplete;
    private IMediaItemParamsInterceptor mItemParamsInterceptor;
    private boolean mPlayFromSharedEnable;
    private PlayerContainerImpl mPlayerContainer;
    private IPlayerCoreService mPlayerCoreService;
    private PlayerDataSource mPlayerDataSource;
    private IPlayerSettingService mPlayerSettingService;
    private Video mPreviousVideo;
    private IToastService mToastService;
    private IVideoQualityProvider mVideoQualityProvider;
    private int mPendingPlayIndex = -1;
    private final SparseArrayCompat<VideoPlayHandler> mVideoPlayHandlers = new SparseArrayCompat<>(0, 1, (DefaultConstructorMarker) null);
    private final Collections.SafeIteratorList<IVideosPlayDirectorService.VideoPlayEventListener> mVideoPlayEventListeners = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<VideoDirectorObserver> mVideoDirectorObservers = Collections.safeIteratorList(new LinkedList());
    private boolean mProcessCompleteActionEnable = true;
    private boolean mProcessCompleteActionAvailable = true;
    private int mExpectedQuality = -1;
    private CommonResolveTaskProvider mCommonResolveTaskProvider = new DefaultCommonResolveTaskProvider();
    private final VideosPlayDirectorService$mPlayerStateObserver$1 mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mPlayerStateObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        public void onPlayerStateChanged(int state) {
            if (state == 6) {
                VideosPlayDirectorService.this.handleCompletion();
            }
        }
    };
    private final VideosPlayDirectorService$mAssetUpdateObserver$1 mAssetUpdateObserver = new IAssetUpdateObserver() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mAssetUpdateObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IAssetUpdateObserver
        public void onHttpResponseInvalid() {
            Video.PlayableParams currentPlayableParams = VideosPlayDirectorService.this.getCurrentPlayableParams();
            if (currentPlayableParams != null) {
                currentPlayableParams.setEnableSafeConnection(true);
            }
        }
    };
    private final VideosPlayDirectorService$mDataSetChangedObserver$1 mDataSetChangedObserver = new VideosPlayDirectorService$mDataSetChangedObserver$1(this);
    private final OnAssetUpdateListener mAssetUpdateListener = new OnAssetUpdateListener() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$mAssetUpdateListener$1
        @Override // tv.danmaku.biliplayerv2.service.OnAssetUpdateListener
        /* renamed from: obtainUpdateAsset-4pVzu0o  reason: not valid java name */
        public MediaResource mo2211obtainUpdateAsset4pVzu0o(int reason, int i, int format) {
            Video currentVideo;
            IVideoQualityProvider iVideoQualityProvider;
            SparseArrayCompat sparseArrayCompat;
            MediaResource mediaResource;
            IPlayerCoreService iPlayerCoreService;
            String id;
            currentVideo = VideosPlayDirectorService.this.mCurrentVideo;
            IPlayerCoreService iPlayerCoreService2 = null;
            if (currentVideo == null) {
                return null;
            }
            VideosPlayDirectorService videosPlayDirectorService = VideosPlayDirectorService.this;
            iVideoQualityProvider = VideosPlayDirectorService.this.mVideoQualityProvider;
            videosPlayDirectorService.mExpectedQuality = iVideoQualityProvider != null ? iVideoQualityProvider.getExpectedQuality(IVideoQualityProvider.ResolveFrom.ASSET_ITEM_UPDATE) : -1;
            Video.PlayableParams currentPlayableParams = VideosPlayDirectorService.this.getCurrentPlayableParams();
            String str = "";
            String resolverId = (currentPlayableParams == null || (resolverId = currentPlayableParams.id()) == null) ? "" : "";
            sparseArrayCompat = VideosPlayDirectorService.this.mVideoPlayHandlers;
            VideoPlayHandler videoPlayHandler = (VideoPlayHandler) sparseArrayCompat.get(currentVideo.getType());
            if (videoPlayHandler == null) {
                mediaResource = null;
            } else {
                mediaResource = videoPlayHandler.mo2235obtainMediaResourceSync4pVzu0o(reason, i, format);
            }
            iPlayerCoreService = VideosPlayDirectorService.this.mPlayerCoreService;
            if (iPlayerCoreService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
            } else {
                iPlayerCoreService2 = iPlayerCoreService;
            }
            MediaItem<?> currentMediaItem = iPlayerCoreService2.getCurrentMediaItem();
            if (currentMediaItem != null && (id = currentMediaItem.getId()) != null) {
                str = id;
            }
            String currentPlayID = str;
            PlayerLog.i("VideosPlayDirectorService", "mediaItem-id: " + currentPlayID + " current-id:" + resolverId);
            return mediaResource;
        }
    };
    private final VideosPlayDirectorService$mVideoPlayEventDispatcher$1 mVideoPlayEventDispatcher = new VideosPlayDirectorService$mVideoPlayEventDispatcher$1(this);

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public /* synthetic */ boolean hasPrevious(boolean z) {
        return IPlayDirector.CC.$default$hasPrevious(this, z);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService, tv.danmaku.biliplayerv2.service.IPlayDirector
    public /* synthetic */ void triggerResolveAndAutoStart(boolean z) {
        IVideosPlayDirectorService.CC.updateMediaResource$default(this, z, null, 2, null);
    }

    /* compiled from: VideosPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerimpl/videodirector/VideosPlayDirectorService$Companion;", "", "<init>", "()V", "TAG", "", "UNKNOWN_QUALITY", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public Video.PlayableParams getCurrentPlayableParams() {
        VideoPlayHandler handler;
        CurrentVideoPointer currentVideoItem;
        Video video2 = this.mCurrentVideo;
        if (video2 == null || (handler = getPlayerHandler(video2.getType())) == null || (currentVideoItem = handler.getCurrentVideoItem()) == null) {
            return null;
        }
        int itemIndex = currentVideoItem.getIndex();
        PlayerDataSource playerDataSource = this.mPlayerDataSource;
        if (playerDataSource != null) {
            return playerDataSource.getVideoItem(video2, itemIndex);
        }
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public Video getCurrentVideo() {
        return this.mCurrentVideo;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public int getCurrentVideoIndex() {
        return this.mCurrentVideoIndex;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void setPlayerDataSource(PlayerDataSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        PlayerLog.i(TAG, "set playerDataSource...");
        if (Intrinsics.areEqual(source, this.mPlayerDataSource)) {
            PlayerLog.i(TAG, "source is current PlayerDataSource, do nothing");
            return;
        }
        PlayerDataSource playerDataSource = this.mPlayerDataSource;
        if (playerDataSource != null) {
            playerDataSource.removeDataSetChangedObserver(this.mDataSetChangedObserver);
        }
        this.mPlayerDataSource = source;
        PlayerDataSource playerDataSource2 = this.mPlayerDataSource;
        if (playerDataSource2 != null) {
            playerDataSource2.addDataSetChangedObserver(this.mDataSetChangedObserver);
        }
        if (this.mPendingPlayIndex >= 0) {
            IPlayerCoreService iPlayerCoreService = this.mPlayerCoreService;
            if (iPlayerCoreService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                iPlayerCoreService = null;
            }
            if (iPlayerCoreService.getState() == 4) {
                IPlayerCoreService iPlayerCoreService2 = this.mPlayerCoreService;
                if (iPlayerCoreService2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                    iPlayerCoreService2 = null;
                }
                iPlayerCoreService2.pause();
            }
            IVideosPlayDirectorService.CC.play$default(this, this.mPendingPlayIndex, 0, 2, null);
            this.mPendingPlayIndex = -1;
            return;
        }
        PlayerDataSource playerDataSource3 = this.mPlayerDataSource;
        if (playerDataSource3 != null) {
            playerDataSource3.notifyDataSetChanged(true);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public PlayerDataSource getPlayerDataSource() {
        return this.mPlayerDataSource;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        VideoPlayHandler handler = new NormalVideoPlayHandler();
        registerVideoPlayHandler(2, handler);
        if (BuildConfig.DEBUG) {
            addVideoPlayEventListener(new MockVideoPlayEventListener());
        }
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        IPlayerCoreService iPlayerCoreService = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        this.mPlayerCoreService = playerContainerImpl.getPlayerCoreService();
        IPlayerCoreService iPlayerCoreService2 = this.mPlayerCoreService;
        if (iPlayerCoreService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
            iPlayerCoreService2 = null;
        }
        iPlayerCoreService2.registerState(this.mPlayerStateObserver, 6);
        IPlayerCoreService iPlayerCoreService3 = this.mPlayerCoreService;
        if (iPlayerCoreService3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
            iPlayerCoreService3 = null;
        }
        iPlayerCoreService3.setAssetUpdateListener(this.mAssetUpdateListener);
        PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
        if (playerContainerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl2 = null;
        }
        this.mPlayerSettingService = playerContainerImpl2.getPlayerSettingService();
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        this.mToastService = playerContainerImpl3.getToastService();
        if (!restoreStateFromShare(bundle)) {
            PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
            if (playerContainerImpl4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl4 = null;
            }
            playerContainerImpl4.getPlayerParams().setSharingBundle(null);
        }
        IPlayerCoreService iPlayerCoreService4 = this.mPlayerCoreService;
        if (iPlayerCoreService4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
        } else {
            iPlayerCoreService = iPlayerCoreService4;
        }
        iPlayerCoreService.addAssetUpdateObserver(this.mAssetUpdateObserver);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        int size = this.mVideoPlayHandlers.size();
        for (int index = 0; index < size; index++) {
            ((VideoPlayHandler) this.mVideoPlayHandlers.valueAt(index)).release();
        }
        cancelDanmakuTask();
        this.mVideoPlayHandlers.clear();
        this.mVideoPlayEventListeners.clear();
        IPlayerCoreService iPlayerCoreService = this.mPlayerCoreService;
        if (iPlayerCoreService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
            iPlayerCoreService = null;
        }
        iPlayerCoreService.removeAssetUpdateObserver(this.mAssetUpdateObserver);
        IPlayerCoreService iPlayerCoreService2 = this.mPlayerCoreService;
        if (iPlayerCoreService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
            iPlayerCoreService2 = null;
        }
        iPlayerCoreService2.unregisterState(this.mPlayerStateObserver);
        IPlayerCoreService iPlayerCoreService3 = this.mPlayerCoreService;
        if (iPlayerCoreService3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
            iPlayerCoreService3 = null;
        }
        iPlayerCoreService3.setAssetUpdateListener(null);
        PlayerDataSource playerDataSource = this.mPlayerDataSource;
        if (playerDataSource != null) {
            playerDataSource.removeDataSetChangedObserver(this.mDataSetChangedObserver);
        }
        this.mPlayerDataSource = null;
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Video currentVideo;
        Video.PlayableParams playableParams;
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        PlayerDataSource dataSource = this.mPlayerDataSource;
        if (dataSource == null || (currentVideo = this.mCurrentVideo) == null || (playableParams = getCurrentPlayableParams()) == null) {
            return;
        }
        bundle.putSharableObject("key_share_player_playable_params", playableParams);
        VideoPlayHandler playerHandler = getPlayerHandler(currentVideo.getType());
        if (playerHandler != null) {
            playerHandler.onCollectSharedParams(bundle);
        }
        dataSource.detachByShared();
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onAttachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        if (!restoreStateFromShare(bundle)) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            playerContainerImpl.getPlayerParams().setSharingBundle(null);
        }
    }

    private final boolean restoreStateFromShare(PlayerSharingBundle bundle) {
        Video.PlayableParams playableParams;
        PlayerDataSource playerDataSource;
        this.mPlayFromSharedEnable = false;
        if (bundle != null) {
            this.mCurrentVideoIndex = bundle.getBundle().getInt("key_share_current_video_index");
            PlayerDataSource playerDataSource2 = this.mPlayerDataSource;
            if (playerDataSource2 != null) {
                playerDataSource2.removeDataSetChangedObserver(this.mDataSetChangedObserver);
            }
            PlayerDataSource dataSource = (PlayerDataSource) PlayerSharingBundle.getSharableObject$default(bundle, "key_share_player_data_source", false, 2, null);
            Video.PlayableParams playableParams2 = (Video.PlayableParams) PlayerSharingBundle.getSharableObject$default(bundle, "key_share_player_playable_params", false, 2, null);
            CurrentVideoPointer videoPointer = (CurrentVideoPointer) PlayerSharingBundle.getSharableObject$default(bundle, "key_share_current_video_item", false, 2, null);
            IPlayerShareInterceptor andRemoveInterceptor = bundle.getAndRemoveInterceptor();
            IShareDataInterceptor shareDataInterceptor = andRemoveInterceptor instanceof IShareDataInterceptor ? (IShareDataInterceptor) andRemoveInterceptor : null;
            if (dataSource != null && videoPointer != null) {
                this.mPlayerDataSource = dataSource;
                PlayerDataSource playerDataSource3 = this.mPlayerDataSource;
                this.mCurrentVideo = playerDataSource3 != null ? playerDataSource3.getVideo(this.mCurrentVideoIndex) : null;
                try {
                    if (this.mCurrentVideo == null || (playerDataSource = this.mPlayerDataSource) == null) {
                        playableParams = null;
                    } else {
                        Video video2 = this.mCurrentVideo;
                        Intrinsics.checkNotNull(video2);
                        playableParams = playerDataSource.getVideoItem(video2, videoPointer.getIndex());
                    }
                    playableParams2 = playableParams;
                } catch (Exception e) {
                    Video video3 = this.mCurrentVideo;
                    PlayerLog.w(PlayerLogModule.VideoDirector, "share fail!!, currentIndex:" + (video3 != null ? Integer.valueOf(video3.getCurrentIndex()) : null) + " index:" + videoPointer.getIndex() + " exception:" + e);
                }
                if (playableParams2 == null) {
                    PlayerLog.w(PlayerLogModule.VideoDirector, "share fail!!, get playableParams fail");
                    return false;
                }
                if (shareDataInterceptor != null) {
                    shareDataInterceptor.interceptPlayableParams(playableParams2);
                } else {
                    PlayerLog.w(PlayerLogModule.VideoDirector, "share player,please ensure report params");
                }
                bundle.putSharableObject("key_share_current_video_item", videoPointer);
            } else if (shareDataInterceptor != null && playableParams2 != null) {
                this.mPlayerDataSource = shareDataInterceptor.interceptDataSource(playableParams2);
                PlayerDataSource playerDataSource4 = this.mPlayerDataSource;
                if ((playerDataSource4 != null ? playerDataSource4.getVideoCount() : 0) > 0) {
                    this.mCurrentVideoIndex = 0;
                    PlayerDataSource playerDataSource5 = this.mPlayerDataSource;
                    this.mCurrentVideo = playerDataSource5 != null ? playerDataSource5.getVideo(this.mCurrentVideoIndex) : null;
                    CurrentVideoPointer currentVideoPointer = videoPointer == null ? new CurrentVideoPointer() : videoPointer;
                    CurrentVideoPointer $this$restoreStateFromShare_u24lambda_u240_u240 = currentVideoPointer;
                    $this$restoreStateFromShare_u24lambda_u240_u240.setIndex(0);
                    Video video4 = this.mCurrentVideo;
                    $this$restoreStateFromShare_u24lambda_u240_u240.setType(video4 != null ? video4.getType() : -1);
                    bundle.putSharableObject("key_share_current_video_item", currentVideoPointer);
                } else {
                    BLog.i(TAG, "share fail!! no data");
                    return false;
                }
            } else {
                BLog.i(TAG, "share fail!! " + (shareDataInterceptor != null) + " " + (playableParams2 != null));
                return false;
            }
            if (this.mCurrentVideo == null) {
                BLog.i(TAG, "share fail: no video!");
                return false;
            }
            PlayerDataSource playerDataSource6 = this.mPlayerDataSource;
            if (playerDataSource6 != null) {
                playerDataSource6.addDataSetChangedObserver(this.mDataSetChangedObserver);
            }
            this.mPlayFromSharedEnable = true;
            PlayerDataSource playerDataSource7 = this.mPlayerDataSource;
            if (playerDataSource7 != null) {
                playerDataSource7.attachByShared();
            }
            int i = this.mCurrentVideoIndex;
            PlayerLog.i(TAG, "sharedData[videoIndex: " + i + ", playerDataSource: " + this.mPlayerDataSource + ", video: " + this.mCurrentVideo + ", enable: " + this.mPlayFromSharedEnable + "]");
            return true;
        }
        return true;
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService
    public void bindPlayerContainer(PlayerContainerImpl playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void play(int index, int itemIndex) {
        play(index, itemIndex, true);
    }

    private static final void play$dispatchVideoWillChange(VideosPlayDirectorService this$0, final Video old, final Video video2) {
        this$0.mVideoPlayEventListeners.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda9
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideosPlayDirectorService.VideoPlayEventListener) obj).onVideoWillChange(Video.this, video2);
            }
        });
        IPlayerSettingService iPlayerSettingService = this$0.mPlayerSettingService;
        IToastService iToastService = null;
        if (iPlayerSettingService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerSettingService");
            iPlayerSettingService = null;
        }
        iPlayerSettingService.removeAll(Scope.Video);
        IToastService iToastService2 = this$0.mToastService;
        if (iToastService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToastService");
        } else {
            iToastService = iToastService2;
        }
        iToastService.removeAllToast();
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void play(final int index, final int itemIndex, boolean autoStart) {
        PlayerDataSource dataSource = this.mPlayerDataSource;
        if (dataSource == null) {
            this.mPendingPlayIndex = index;
            return;
        }
        PlayerLog.i(TAG, "play video:{index: " + index + ", itemIndex: " + itemIndex + "}");
        if (this.mHandlingComplete) {
            PlayerLog.i(TAG, "handling complete this moment, run in next loop");
            HandlerThreads.getHandler(0).post(new Runnable() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    VideosPlayDirectorService.this.play(index, itemIndex);
                }
            });
            return;
        }
        int videoSize = dataSource.getVideoCount();
        if (index < 0) {
            PlayerLog.e(TAG, "index = " + index + "不能小于0");
        } else if (index >= videoSize) {
            PlayerLog.e(TAG, "index = " + index + "不能大于videos的总长度: " + videoSize);
        } else {
            Video video2 = dataSource.getVideo(index);
            if (video2 == null) {
                return;
            }
            VideoPlayHandler playHandler = (VideoPlayHandler) this.mVideoPlayHandlers.get(video2.getType());
            if (playHandler == null) {
                PlayerLog.w(TAG, "not found playerHandler for type = " + video2.getType());
                return;
            }
            if (this.mCurrentVideo != null) {
                Video video3 = this.mCurrentVideo;
                Intrinsics.checkNotNull(video3);
                play$dispatchVideoWillChange(this, video3, video2);
            } else if (this.mPreviousVideo != null) {
                Video video4 = this.mPreviousVideo;
                Intrinsics.checkNotNull(video4);
                play$dispatchVideoWillChange(this, video4, video2);
            }
            this.mPreviousVideo = null;
            if (itemIndex >= 0 && itemIndex < dataSource.getVideoItemCount(video2)) {
                video2.setCurrentIndex(itemIndex);
                video2.setForceReplay(false);
            }
            this.mCurrentVideo = video2;
            this.mCurrentVideoIndex = index;
            Video video5 = this.mCurrentVideo;
            Intrinsics.checkNotNull(video5);
            video5.setPlayCompleted(false);
            IVideoQualityProvider iVideoQualityProvider = this.mVideoQualityProvider;
            this.mExpectedQuality = iVideoQualityProvider != null ? iVideoQualityProvider.getExpectedQuality(IVideoQualityProvider.ResolveFrom.NORMAL_PLAY) : -1;
            playHandler.start(video2, dataSource, autoStart);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void playFromShared() {
        Video video2;
        if (this.mPlayFromSharedEnable) {
            try {
                this.mPlayFromSharedEnable = false;
                if (this.mCurrentVideo == null) {
                    int i = this.mCurrentVideoIndex;
                    PlayerDataSource playerDataSource = this.mPlayerDataSource;
                    if (i <= (playerDataSource != null ? playerDataSource.getVideoCount() : 0)) {
                        PlayerDataSource playerDataSource2 = this.mPlayerDataSource;
                        this.mCurrentVideo = playerDataSource2 != null ? playerDataSource2.getVideo(this.mCurrentVideoIndex) : null;
                    }
                }
                Video it = this.mCurrentVideo;
                if (it != null) {
                    VideoPlayHandler handler = getPlayerHandler(it.getType());
                    if (handler == null) {
                        Intrinsics.checkNotNull(this.mCurrentVideo);
                        BLog.i(TAG, "share fail: no handler:" + video2.getType() + "!");
                        this.mCurrentVideo = null;
                        this.mCurrentVideoIndex = 0;
                        this.mPlayerDataSource = null;
                        IPlayerCoreService iPlayerCoreService = this.mPlayerCoreService;
                        if (iPlayerCoreService == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                            iPlayerCoreService = null;
                        }
                        iPlayerCoreService.stop();
                    }
                    if (handler != null) {
                        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
                        if (playerContainerImpl == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                            playerContainerImpl = null;
                        }
                        handler.onRestoreFromSharedParams(playerContainerImpl.getPlayerParams().getSharingBundle());
                    }
                    if (handler != null) {
                        PlayerDataSource playerDataSource3 = this.mPlayerDataSource;
                        Intrinsics.checkNotNull(playerDataSource3);
                        Boolean.valueOf(handler.startFromShared(it, playerDataSource3));
                    }
                }
            } catch (Exception e) {
                this.mCurrentVideo = null;
                this.mCurrentVideoIndex = 0;
                this.mPlayerDataSource = null;
                IPlayerCoreService iPlayerCoreService2 = this.mPlayerCoreService;
                if (iPlayerCoreService2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                    iPlayerCoreService2 = null;
                }
                iPlayerCoreService2.stop();
                e.printStackTrace();
                PlayerLog.w(PlayerLogModule.VideoDirector, "play from shared, and share exception:" + e);
                Unit unit = Unit.INSTANCE;
            }
        } else {
            IPlayerCoreService iPlayerCoreService3 = this.mPlayerCoreService;
            if (iPlayerCoreService3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                iPlayerCoreService3 = null;
            }
            iPlayerCoreService3.playFromShared(new Function0() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit playFromShared$lambda$1;
                    playFromShared$lambda$1 = VideosPlayDirectorService.playFromShared$lambda$1(VideosPlayDirectorService.this);
                    return playFromShared$lambda$1;
                }
            }, new Function0() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit playFromShared$lambda$2;
                    playFromShared$lambda$2 = VideosPlayDirectorService.playFromShared$lambda$2();
                    return playFromShared$lambda$2;
                }
            });
        }
        PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
        if (playerContainerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl2 = null;
        }
        playerContainerImpl2.getPlayerParams().setSharingBundle(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playFromShared$lambda$1(VideosPlayDirectorService this$0) {
        Video video2 = this$0.mCurrentVideo;
        if (video2 != null) {
            VideoPlayHandler playHandler = this$0.getPlayerHandler(video2.getType());
            CurrentVideoPointer videoItem = playHandler != null ? playHandler.getCurrentVideoItem() : null;
            if (videoItem != null) {
                this$0.mVideoPlayEventDispatcher.dispatchVideoItemWillChange(videoItem, videoItem, video2);
                this$0.mVideoPlayEventDispatcher.dispatchVideoItemStart(videoItem, video2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playFromShared$lambda$2() {
        PlayerLog.w(PlayerLogModule.VideoDirector, "play from shared, and share null");
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void replayCurrentVideo() {
        if (this.mHandlingComplete) {
            PlayerLog.i(TAG, "handling complete this moment, run in next loop");
            HandlerThreads.getHandler(0).post(new Runnable() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    VideosPlayDirectorService.this.replayCurrentVideo();
                }
            });
            return;
        }
        PlayerLog.i(TAG, "replay current video...");
        if (this.mCurrentVideo == null) {
            PlayerLog.w(TAG, "mCurrentVideo must not be null!!");
            return;
        }
        SparseArrayCompat<VideoPlayHandler> sparseArrayCompat = this.mVideoPlayHandlers;
        Video video2 = this.mCurrentVideo;
        Intrinsics.checkNotNull(video2);
        VideoPlayHandler handler = (VideoPlayHandler) sparseArrayCompat.get(video2.getType());
        if (handler == null) {
            PlayerLog.w(TAG, "something error!!can not found a VideoPlayHandler match with mCurrentVideo = " + this.mCurrentVideo);
            return;
        }
        Video video3 = this.mCurrentVideo;
        Intrinsics.checkNotNull(video3);
        video3.setForceReplay(true);
        Video video4 = this.mCurrentVideo;
        Intrinsics.checkNotNull(video4);
        video4.setPlayCompleted(false);
        Video video5 = this.mCurrentVideo;
        Intrinsics.checkNotNull(video5);
        PlayerDataSource playerDataSource = this.mPlayerDataSource;
        Intrinsics.checkNotNull(playerDataSource);
        handler.start(video5, playerDataSource);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void replayCurrentVideoItem() {
        if (this.mHandlingComplete) {
            PlayerLog.i(TAG, "handling complete this moment, run in next loop");
            HandlerThreads.getHandler(0).post(new Runnable() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    VideosPlayDirectorService.this.replayCurrentVideoItem();
                }
            });
            return;
        }
        PlayerLog.i(TAG, "replay current videoItem...");
        Video currentVideo = this.mCurrentVideo;
        if (currentVideo == null) {
            PlayerLog.w(TAG, "mCurrentVideo must not be null!!");
            return;
        }
        VideoPlayHandler handler = (VideoPlayHandler) this.mVideoPlayHandlers.get(currentVideo.getType());
        if (handler == null) {
            PlayerLog.w(TAG, "something error!!can not found a VideoPlayHandler match with mCurrentVideo = " + this.mCurrentVideo);
            return;
        }
        if (currentVideo.isPlayCompleted()) {
            currentVideo.setPlayCompleted(false);
            this.mVideoPlayEventDispatcher.dispatchVideoStart(currentVideo);
        }
        handler.replay();
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public boolean hasPrevious() {
        PlayerDataSource playerDataSource = this.mPlayerDataSource;
        int count = playerDataSource != null ? playerDataSource.getVideoCount() : 0;
        if (count <= 0) {
            return false;
        }
        if (this.mCurrentVideoIndex > 0) {
            return true;
        }
        Video video2 = this.mCurrentVideo;
        if (video2 == null) {
            PlayerDataSource playerDataSource2 = this.mPlayerDataSource;
            Intrinsics.checkNotNull(playerDataSource2);
            Video video3 = playerDataSource2.getVideo(0);
            if (video3 == null) {
                return false;
            }
            video2 = video3;
        }
        VideoPlayHandler it = (VideoPlayHandler) this.mVideoPlayHandlers.get(video2.getType());
        if (it != null) {
            return it.hasPrevious();
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public boolean hasPreVideo() {
        if (this.mCurrentVideoIndex > 0) {
            return true;
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public boolean hasNext() {
        PlayerDataSource playerDataSource = this.mPlayerDataSource;
        int count = playerDataSource != null ? playerDataSource.getVideoCount() : 0;
        if (this.mCurrentVideoIndex < count - 1) {
            return true;
        }
        if (count <= 0) {
            return false;
        }
        Video video2 = this.mCurrentVideo;
        if (video2 == null) {
            PlayerDataSource playerDataSource2 = this.mPlayerDataSource;
            Intrinsics.checkNotNull(playerDataSource2);
            Video video3 = playerDataSource2.getVideo(0);
            if (video3 == null) {
                return false;
            }
            video2 = video3;
        }
        VideoPlayHandler it = (VideoPlayHandler) this.mVideoPlayHandlers.get(video2.getType());
        if (it != null) {
            return it.hasNext();
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public boolean hasNextVideo() {
        PlayerDataSource playerDataSource = this.mPlayerDataSource;
        int count = playerDataSource != null ? playerDataSource.getVideoCount() : 0;
        return this.mCurrentVideoIndex < count + (-1);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public boolean hasNextVideoItem() {
        VideoPlayHandler handler;
        Video video2 = this.mCurrentVideo;
        if (video2 == null || (handler = (VideoPlayHandler) this.mVideoPlayHandlers.get(video2.getType())) == null) {
            return false;
        }
        return handler.hasNext();
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void playNext(final boolean loop) {
        if (this.mHandlingComplete) {
            PlayerLog.i(TAG, "handling complete this moment, run in next loop");
            HandlerThreads.getHandler(0).post(new Runnable() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    VideosPlayDirectorService.this.playNext(loop);
                }
            });
            return;
        }
        PlayerLog.i(TAG, "play next...");
        PlayerDataSource playerDataSource = this.mPlayerDataSource;
        int count = playerDataSource != null ? playerDataSource.getVideoCount() : 0;
        if (count <= 0) {
            PlayerLog.i(TAG, "videos is empty, do nothing!!!");
        } else if (this.mCurrentVideo == null) {
            PlayerLog.i(TAG, "not has currentVideo, play index of 0");
            IVideosPlayDirectorService.CC.play$default(this, 0, 0, 2, null);
        } else {
            SparseArrayCompat<VideoPlayHandler> sparseArrayCompat = this.mVideoPlayHandlers;
            Video video2 = this.mCurrentVideo;
            Intrinsics.checkNotNull(video2);
            VideoPlayHandler handler = (VideoPlayHandler) sparseArrayCompat.get(video2.getType());
            if (handler == null) {
                PlayerLog.e(TAG, "something error, could not found VideoPlayHandler for mCurrentVideo");
            } else if (handler.hasNext()) {
                playNextVideoItem(false);
            } else if (this.mCurrentVideoIndex >= count - 1) {
                if (loop) {
                    for (int i = 0; i < count; i++) {
                        PlayerDataSource playerDataSource2 = this.mPlayerDataSource;
                        Intrinsics.checkNotNull(playerDataSource2);
                        Video video3 = playerDataSource2.getVideo(i);
                        if (video3 != null) {
                            video3.setForceReplay(true);
                            video3.setPlayCompleted(false);
                        }
                    }
                    IVideosPlayDirectorService.CC.play$default(this, 0, 0, 2, null);
                }
            } else {
                playNextVideo();
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void playPrevious(final boolean loop) {
        Video video2;
        PlayerDataSource playerDataSource;
        if (this.mHandlingComplete) {
            PlayerLog.i(TAG, "handling complete this moment, run in next loop");
            HandlerThreads.getHandler(0).post(new Runnable() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    VideosPlayDirectorService.this.playPrevious(loop);
                }
            });
            return;
        }
        PlayerDataSource playerDataSource2 = this.mPlayerDataSource;
        int count = playerDataSource2 != null ? playerDataSource2.getVideoCount() : 0;
        PlayerLog.i(TAG, "play previous...");
        if (count <= 0) {
            PlayerLog.i(TAG, "videos is empty, do nothing!!!");
        } else if (this.mCurrentVideo == null) {
            PlayerLog.i(TAG, "not has currentVideo, play index of 0");
            IVideosPlayDirectorService.CC.play$default(this, 0, 0, 2, null);
        } else {
            SparseArrayCompat<VideoPlayHandler> sparseArrayCompat = this.mVideoPlayHandlers;
            Video video3 = this.mCurrentVideo;
            Intrinsics.checkNotNull(video3);
            VideoPlayHandler handler = (VideoPlayHandler) sparseArrayCompat.get(video3.getType());
            if (handler == null) {
                PlayerLog.e(TAG, "something error, could not found VideoPlayHandler for mCurrentVideo");
            } else if (handler.hasPrevious()) {
                playPreVideoItem(false);
            } else if (this.mCurrentVideoIndex == 0) {
                if (loop) {
                    for (int i = 0; i < count; i++) {
                        PlayerDataSource playerDataSource3 = this.mPlayerDataSource;
                        Intrinsics.checkNotNull(playerDataSource3);
                        Video video4 = playerDataSource3.getVideo(i);
                        if (video4 != null) {
                            video4.setForceReplay(true);
                            video4.setPlayCompleted(false);
                        }
                    }
                    PlayerDataSource playerDataSource4 = this.mPlayerDataSource;
                    if (playerDataSource4 == null || (video2 = playerDataSource4.getVideo(count - 1)) == null || (playerDataSource = this.mPlayerDataSource) == null) {
                        return;
                    }
                    int videoItemCount = playerDataSource.getVideoItemCount(video2);
                    play(count - 1, videoItemCount + (-1) > 0 ? videoItemCount - 1 : 0);
                }
            } else {
                playPreVideo(false);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void playNextVideoItem(final boolean loop) {
        if (this.mHandlingComplete) {
            PlayerLog.i(TAG, "handling complete this moment, run in next loop");
            HandlerThreads.getHandler(0).post(new Runnable() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    VideosPlayDirectorService.this.playNextVideoItem(loop);
                }
            });
            return;
        }
        PlayerLog.i(TAG, "try to play next videoItem");
        if (this.mCurrentVideo == null) {
            PlayerLog.w(TAG, "currentVideo is null!!!");
            return;
        }
        SparseArrayCompat<VideoPlayHandler> sparseArrayCompat = this.mVideoPlayHandlers;
        Video video2 = this.mCurrentVideo;
        Intrinsics.checkNotNull(video2);
        VideoPlayHandler handle = (VideoPlayHandler) sparseArrayCompat.get(video2.getType());
        if (handle == null) {
            Video video3 = this.mCurrentVideo;
            Intrinsics.checkNotNull(video3);
            PlayerLog.w(TAG, "could found videoHandler for type = " + video3.getType());
            return;
        }
        if (!handle.hasNext()) {
            if (!loop) {
                PlayerLog.w(TAG, "do not has next item for current video");
                return;
            }
            PlayerLog.w(TAG, "do not has next item for current video, will play first item");
        }
        IVideoQualityProvider iVideoQualityProvider = this.mVideoQualityProvider;
        this.mExpectedQuality = iVideoQualityProvider != null ? iVideoQualityProvider.getExpectedQuality(IVideoQualityProvider.ResolveFrom.NORMAL_PLAY) : -1;
        handle.playNext(loop);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void playNextVideo() {
        if (this.mHandlingComplete) {
            PlayerLog.i(TAG, "handling complete this moment, run in next loop");
            HandlerThreads.getHandler(0).post(new Runnable() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    VideosPlayDirectorService.this.playNextVideo();
                }
            });
            return;
        }
        PlayerLog.i(TAG, "try to play next video");
        PlayerDataSource playerDataSource = this.mPlayerDataSource;
        int count = playerDataSource != null ? playerDataSource.getVideoCount() : 0;
        if (this.mCurrentVideoIndex + 1 >= count) {
            PlayerLog.w(TAG, "do not has next video");
        } else {
            IVideosPlayDirectorService.CC.play$default(this, this.mCurrentVideoIndex + 1, 0, 2, null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void playPreVideoItem(final boolean loop) {
        if (this.mHandlingComplete) {
            PlayerLog.i(TAG, "handling complete this moment, run in next loop");
            HandlerThreads.getHandler(0).post(new Runnable() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    VideosPlayDirectorService.this.playPreVideoItem(loop);
                }
            });
            return;
        }
        PlayerLog.i(TAG, "try to play previous videoItem");
        if (this.mCurrentVideo == null) {
            PlayerLog.w(TAG, "currentVideo is null!!!");
            return;
        }
        SparseArrayCompat<VideoPlayHandler> sparseArrayCompat = this.mVideoPlayHandlers;
        Video video2 = this.mCurrentVideo;
        Intrinsics.checkNotNull(video2);
        VideoPlayHandler handle = (VideoPlayHandler) sparseArrayCompat.get(video2.getType());
        if (handle == null) {
            Video video3 = this.mCurrentVideo;
            Intrinsics.checkNotNull(video3);
            PlayerLog.w(TAG, "could found videoHandler for type = " + video3.getType());
        } else if (!handle.hasPrevious()) {
            PlayerLog.w(TAG, "do not has previous item for current video");
        } else {
            IVideoQualityProvider iVideoQualityProvider = this.mVideoQualityProvider;
            this.mExpectedQuality = iVideoQualityProvider != null ? iVideoQualityProvider.getExpectedQuality(IVideoQualityProvider.ResolveFrom.NORMAL_PLAY) : -1;
            handle.playPrevious(loop);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void playPreVideo(final boolean fromBegin) {
        Video video2;
        PlayerDataSource playerDataSource;
        if (this.mHandlingComplete) {
            PlayerLog.i(TAG, "handling complete this moment, run in next loop");
            HandlerThreads.getHandler(0).post(new Runnable() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    VideosPlayDirectorService.this.playPreVideo(fromBegin);
                }
            });
            return;
        }
        PlayerLog.i(TAG, "try to play previous video");
        if (this.mCurrentVideoIndex <= 0) {
            PlayerLog.w(TAG, "do not has previous video");
        } else if (fromBegin) {
            IVideosPlayDirectorService.CC.play$default(this, this.mCurrentVideoIndex - 1, 0, 2, null);
        } else {
            PlayerDataSource playerDataSource2 = this.mPlayerDataSource;
            if (playerDataSource2 == null || (video2 = playerDataSource2.getVideo(this.mCurrentVideoIndex - 1)) == null || (playerDataSource = this.mPlayerDataSource) == null) {
                return;
            }
            int videoItemCount = playerDataSource.getVideoItemCount(video2);
            play(this.mCurrentVideoIndex - 1, videoItemCount + (-1) > 0 ? videoItemCount - 1 : 0);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void playVideoItem(final CurrentVideoPointer item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.mHandlingComplete) {
            PlayerLog.i(TAG, "handling complete this moment, run in next loop");
            HandlerThreads.getHandler(0).post(new Runnable() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    VideosPlayDirectorService.this.playVideoItem(item);
                }
            });
            return;
        }
        PlayerLog.i(TAG, "play video item...");
        VideoPlayHandler playHandler = getPlayerHandler(item.getType());
        if (playHandler != null) {
            if (!Intrinsics.areEqual(playHandler.getCurrentVideo(), this.mCurrentVideo)) {
                PlayerLog.w(TAG, "playerHandler for type = " + item.getType() + " is inactive");
                return;
            }
            IVideoQualityProvider iVideoQualityProvider = this.mVideoQualityProvider;
            this.mExpectedQuality = iVideoQualityProvider != null ? iVideoQualityProvider.getExpectedQuality(IVideoQualityProvider.ResolveFrom.NORMAL_PLAY) : -1;
            playHandler.play(item);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void addVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.mVideoPlayEventListeners.contains(listener)) {
            return;
        }
        this.mVideoPlayEventListeners.add(listener);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void removeVideoPlayEventListener(IVideosPlayDirectorService.VideoPlayEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoPlayEventListeners.remove(listener);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public void addVideoDirectorObserver(VideoDirectorObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mVideoDirectorObservers.contains(observer)) {
            return;
        }
        this.mVideoDirectorObservers.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public void removeVideoDirectorObserver(VideoDirectorObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mVideoDirectorObservers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public boolean willAutoPlayNext() {
        if (this.mProcessCompleteActionEnable) {
            PlayerDataSource playerDataSource = this.mPlayerDataSource;
            if ((playerDataSource != null ? playerDataSource.getAvailableVideoItemCount() : 0) > 0) {
                IPlayerSettingService iPlayerSettingService = this.mPlayerSettingService;
                if (iPlayerSettingService == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerSettingService");
                    iPlayerSettingService = null;
                }
                int action = iPlayerSettingService.getInt(Player.KEY_PLAY_COMPLETED_ACTION, 0);
                switch (action) {
                    case 2:
                    case 4:
                        return true;
                    case 3:
                    default:
                        if (action == 0) {
                            return hasNext();
                        }
                        return false;
                }
            }
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void updateMediaResource(boolean autoStart, ResolveListener outerResolveListener) {
        Video video2 = this.mCurrentVideo;
        if (video2 != null) {
            IVideoQualityProvider iVideoQualityProvider = this.mVideoQualityProvider;
            this.mExpectedQuality = iVideoQualityProvider != null ? iVideoQualityProvider.getExpectedQuality(IVideoQualityProvider.ResolveFrom.UPDATE_MEDIA_RESOURCE) : -1;
            VideoPlayHandler playHandler = getPlayerHandler(video2.getType());
            if (playHandler != null) {
                playHandler.updateMediaResource(autoStart, outerResolveListener);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void reloadCurrentVideoItem() {
        Video video2 = this.mCurrentVideo;
        if (video2 != null) {
            IVideoQualityProvider iVideoQualityProvider = this.mVideoQualityProvider;
            this.mExpectedQuality = iVideoQualityProvider != null ? iVideoQualityProvider.getExpectedQuality(IVideoQualityProvider.ResolveFrom.RELOAD) : -1;
            VideoPlayHandler playHandler = getPlayerHandler(video2.getType());
            if (playHandler != null) {
                playHandler.reload();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchAllVideoCompleted() {
        this.mVideoPlayEventListeners.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.videodirector.VideosPlayDirectorService$$ExternalSyntheticLambda12
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideosPlayDirectorService.VideoPlayEventListener) obj).onAllVideoCompleted();
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void registerVideoPlayHandler(int type, VideoPlayHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.mVideoPlayHandlers.append(type, handler);
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        handler.attach(playerContainerImpl, this.mVideoPlayEventDispatcher);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void unregisterVideoPlayHandler(int type) {
        VideoPlayHandler videoPlayHandler = (VideoPlayHandler) this.mVideoPlayHandlers.get(type);
        if (videoPlayHandler != null) {
            videoPlayHandler.release();
        }
        this.mVideoPlayHandlers.remove(type);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void unregisterVideoPlayHandler(VideoPlayHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.mVideoPlayHandlers.removeAt(this.mVideoPlayHandlers.indexOfValue(handler));
        handler.release();
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void setVideoQualityProvider(IVideoQualityProvider provider) {
        this.mVideoQualityProvider = provider;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public IVideoQualityProvider getVideoQualityProvider() {
        return this.mVideoQualityProvider;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void setMediaItemSettingInterceptor(IMediaItemParamsInterceptor interceptor) {
        this.mItemParamsInterceptor = interceptor;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public IMediaItemParamsInterceptor getMediaItemSettingInterceptor() {
        return this.mItemParamsInterceptor;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public int getCurrentExpectedQuality() {
        return this.mExpectedQuality;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void setProcessCompleteActionEnable(boolean enable) {
        this.mProcessCompleteActionEnable = enable;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public boolean isProcessCompleteActionEnable() {
        return this.mProcessCompleteActionEnable;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void setProcessCompleteActionAvailable(boolean available) {
        this.mProcessCompleteActionAvailable = available;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public boolean isProcessCompleteActionAvailable() {
        return this.mProcessCompleteActionAvailable;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void setCommonResolveTaskProvider(CommonResolveTaskProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.mCommonResolveTaskProvider = provider;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public CommonResolveTaskProvider getCommonResolveTaskProvider() {
        return this.mCommonResolveTaskProvider;
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void setHistoryProgressReader(AbsMediaResourceResolveTask.IHistoryProgressReader reader) {
        VideoPlayHandler playerHandler;
        Video it = this.mCurrentVideo;
        if (it == null || (playerHandler = getPlayerHandler(it.getType())) == null) {
            return;
        }
        playerHandler.setHistoryProgressReader(reader);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void setMediaHistoryStorage(IMediaHistoryStorage<MediaHistoryEntry> iMediaHistoryStorage) {
        BLog.e(TAG, "无需设置这个了，现存的也不需要了，会根据[MediaHistoryType]通过路由自动匹配,请删除");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCompletion() {
        VideoPlayHandler playHandler;
        this.mHandlingComplete = true;
        Video video2 = this.mCurrentVideo;
        if (video2 != null && (playHandler = getPlayerHandler(video2.getType())) != null) {
            playHandler.onCompleted();
            this.mHandlingComplete = false;
        }
        this.mHandlingComplete = false;
    }

    private final VideoPlayHandler getPlayerHandler(int type) {
        VideoPlayHandler playHandler = (VideoPlayHandler) this.mVideoPlayHandlers.get(type);
        if (playHandler == null) {
            PlayerLog.w(TAG, "not found playerHandler for type = " + type);
            return null;
        }
        return playHandler;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public void switchToNext(boolean canLoop) {
        playNext(canLoop);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public void switchToPrevious(boolean canLoop) {
        playPrevious(canLoop);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public int itemCount() {
        PlayerDataSource playerDataSource = getPlayerDataSource();
        if (playerDataSource != null) {
            return playerDataSource.getAvailableVideoItemCount();
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public boolean hasNext(boolean loop) {
        return hasNext();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public int getPlayingItemIndex() {
        PlayerDataSource dataSource;
        Video.PlayableParams playableParams = getCurrentPlayableParams();
        if (playableParams == null || (dataSource = getPlayerDataSource()) == null) {
            return -1;
        }
        return dataSource.getPositionInAvailableVideoItemList(playableParams);
    }

    @Override // tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService
    public void resolveDanmaku() {
        cancelDanmakuTask();
        Video.PlayableParams playableParams = getCurrentPlayableParams();
        Video.DanmakuResolveParams danmakuResolveParams = playableParams != null ? playableParams.getDanmakuResolveParams() : null;
        if (danmakuResolveParams == null) {
            PlayerLog.i(TAG, "no danmaku params id:" + (playableParams != null ? playableParams.id() : null) + " from:" + (playableParams != null ? playableParams.getFrom() : null));
            return;
        }
        PlayerLog.i(TAG, "resolve danmaku params id:" + playableParams.id() + " from:" + playableParams.getFrom());
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        this.mDanmakuJob = BuildersKt.launch$default(PlayerContainerCoroutineKt.getCoroutineScope(playerContainerImpl), (CoroutineContext) null, (CoroutineStart) null, new VideosPlayDirectorService$resolveDanmaku$1(this, danmakuResolveParams, playableParams, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelDanmakuTask() {
        Job job;
        Job job2 = this.mDanmakuJob;
        boolean z = false;
        if (job2 != null && job2.isActive()) {
            z = true;
        }
        if (z && (job = this.mDanmakuJob) != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.mDanmakuJob = null;
    }
}