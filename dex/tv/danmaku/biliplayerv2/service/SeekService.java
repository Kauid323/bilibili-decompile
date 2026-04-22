package tv.danmaku.biliplayerv2.service;

import androidx.lifecycle.Observer;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.injection.InjectPlayerService;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.IWatchPointsLoadListener;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PlayerControlBarChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.model.ChronosThumbnailInfo;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.IFunctionContainer;
import tv.danmaku.biliplayerv2.widget.function.progress.SimpleProgressFunctionWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SeekService.kt */
@Metadata(d1 = {"\u0000Í\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0011\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0005>BEHO\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u00109\u001a\u00020\u0006*\u00020*2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\b\u0010;\u001a\u00020<H\u0002J\u0018\u0010@\u001a\u00020<2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0016J\b\u0010J\u001a\u00020<H\u0002J\u0010\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020\u0006H\u0002J\b\u0010M\u001a\u00020<H\u0002J\b\u0010T\u001a\u00020<H\u0002J\u0010\u0010U\u001a\u00020<2\u0006\u0010V\u001a\u00020\u0006H\u0002J\b\u0010W\u001a\u00020<H\u0002J\b\u0010X\u001a\u00020\u0006H\u0002J\b\u0010Y\u001a\u00020\u0006H\u0002J\b\u0010Z\u001a\u00020<H\u0016J\b\u0010[\u001a\u00020<H\u0002J\b\u0010\\\u001a\u00020<H\u0016J\b\u0010]\u001a\u00020\u0006H\u0016J\u0018\u0010^\u001a\u00020<2\u0006\u0010_\u001a\u00020\r2\u0006\u0010`\u001a\u00020\rH\u0016J\u0010\u0010a\u001a\u00020<2\u0006\u0010b\u001a\u00020\u0013H\u0016J\u0010\u0010c\u001a\u00020<2\u0006\u0010b\u001a\u00020\u0013H\u0016J\u0010\u0010d\u001a\u00020<2\u0006\u0010e\u001a\u00020\u0006H\u0016J\u0018\u0010f\u001a\u00020<2\u0006\u0010_\u001a\u00020\r2\u0006\u0010`\u001a\u00020\rH\u0016J\u0010\u0010g\u001a\u00020<2\u0006\u0010b\u001a\u00020\u0010H\u0016J\u0010\u0010h\u001a\u00020<2\u0006\u0010b\u001a\u00020\u0010H\u0016J!\u0010i\u001a\u00020<2\u0012\u0010j\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0k\"\u00020!H\u0016¢\u0006\u0002\u0010lJ\u0010\u0010m\u001a\u00020<2\u0006\u0010n\u001a\u00020\u0006H\u0016J\u0010\u0010o\u001a\u00020<2\u0006\u0010p\u001a\u00020\u0006H\u0016J\b\u0010q\u001a\u00020\u0006H\u0016J\u0010\u0010r\u001a\u00020<2\u0006\u0010p\u001a\u00020\u0006H\u0016J\b\u0010s\u001a\u00020\u0006H\u0016J\u0010\u0010t\u001a\u00020<2\u0006\u0010b\u001a\u00020\u0015H\u0016J\u0010\u0010u\u001a\u00020<2\u0006\u0010b\u001a\u00020\u0015H\u0016J\u0010\u0010v\u001a\u00020<2\u0006\u0010p\u001a\u00020\u0006H\u0016J\u0010\u0010w\u001a\u00020<2\u0006\u0010x\u001a\u00020\u0018H\u0016J\u0010\u0010y\u001a\u00020<2\u0006\u0010x\u001a\u00020\u0018H\u0016J\b\u0010z\u001a\u00020\u0006H\u0016J\u0012\u0010{\u001a\u00020<2\b\u0010|\u001a\u0004\u0018\u00010}H\u0016J\b\u0010~\u001a\u00020<H\u0016J\u001a\u0010\u007f\u001a\u00020<2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u0010|\u001a\u00020}H\u0016J\u001d\u0010\u0082\u0001\u001a\u00020<2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010|\u001a\u0004\u0018\u00010}H\u0016J\u0012\u0010\u0083\u0001\u001a\u00020<2\u0007\u0010\u0084\u0001\u001a\u00020\u001aH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020<2\u0007\u0010\u0086\u0001\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0012\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00130\u0013 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0014\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00150\u0015 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u000bR\u0012\u0010-\u001a\u00020.8\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u0002008\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u000602X\u0082\u0004¢\u0006\u0002\n\u0000R.\u00104\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b5\u00106R.\u00107\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b8\u00106R\u0010\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?R\u0010\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010CR\u0010\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010FR\u0010\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0004\n\u0002\u0010IR\u0010\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0004\n\u0002\u0010PR\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/SeekService;", "Ltv/danmaku/biliplayerv2/service/ISeekService;", "<init>", "()V", "_isDraggingByUserFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isDraggingByUser", "()Z", "isDraggingByUserFlow", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "mDraggingProgress", "", "mDraggingProgressObserverList", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/biliplayerv2/service/DraggingProgressObserver;", "kotlin.jvm.PlatformType", "mPlayerProgressObserverList", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "mSeekGestureObserverList", "Ltv/danmaku/biliplayerv2/service/SeekGestureEnableObserver;", "mSimpleProgressConditionList", "Ljava/util/LinkedList;", "Ltv/danmaku/biliplayerv2/service/SimpleProgressCondition;", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mCoreService", "Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "mSimpleProgressToken", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;", "mShowSimpleProgressControlTypes", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "mProgressMutuallyExclusive", "mSeekEnable", "mSeekGestureEnable", "mThumbnailEnable", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "_watchPointListFlow", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo$WatchPoint;", "watchPointListFlow", "getWatchPointListFlow", "mInteractLayerService", "Ltv/danmaku/biliplayerv2/service/interact/biz/IInteractLayerService;", "mControlContainerService", "Ltv/danmaku/biliplayerv2/service/IControlContainerService;", "mSegmentObserver", "Landroidx/lifecycle/Observer;", "value", "watchPoints", "setWatchPoints", "(Ljava/util/List;)V", "headerTailPoints", "setHeaderTailPoints", "conflictTo", "list", "mergeWatchPointAndHeaderTail", "", "mWatchPointsLoadListener", "tv/danmaku/biliplayerv2/service/SeekService$mWatchPointsLoadListener$1", "Ltv/danmaku/biliplayerv2/service/SeekService$mWatchPointsLoadListener$1;", "updateHeaderTailPoints", "mVideoEventListener", "tv/danmaku/biliplayerv2/service/SeekService$mVideoEventListener$1", "Ltv/danmaku/biliplayerv2/service/SeekService$mVideoEventListener$1;", "mControlContainerVisibleObserver", "tv/danmaku/biliplayerv2/service/SeekService$mControlContainerVisibleObserver$1", "Ltv/danmaku/biliplayerv2/service/SeekService$mControlContainerVisibleObserver$1;", "mControlTypeObserver", "tv/danmaku/biliplayerv2/service/SeekService$mControlTypeObserver$1", "Ltv/danmaku/biliplayerv2/service/SeekService$mControlTypeObserver$1;", "notifySimpleProgressVisibility", "notifySimpleProgressVisibilityToChronos", "visible", "checkAndHideSimpleProgress", "mRefreshRunnable", "tv/danmaku/biliplayerv2/service/SeekService$mRefreshRunnable$1", "Ltv/danmaku/biliplayerv2/service/SeekService$mRefreshRunnable$1;", "mCheckSimpleProgressVisibility", "Ljava/lang/Runnable;", "mCheckSimpleProgressWhenVideoItemStart", "refresh", "startRefreshRunnable", "immediately", "stopRefreshRunnable", "needHideSimpleProgress", "needHideSimpleProgressNormalCase", "tryToShowSimpleProgress", "showSimpleProgress", "hideSimpleProgress", "isSimpleProgressShowing", "refreshPlayerProgress", "progress", "duration", "registerPlayerProgressObserver", "observer", "unregisterPlayerProgressObserver", "setDraggingByUser", "fromUser", "setDraggingProgress", "registerDraggingProgress", "unregisterDraggingProgress", "setShowSimpleProgressControlTypes", "types", "", "([Ltv/danmaku/biliplayerv2/ControlContainerType;)V", "setProgressMutuallyExclusive", "exclusive", "setSeekEnable", "enable", "isSeekEnable", "setSeekGestureEnable", "isSeekGestureEnable", "addSeekGestureEnableObserver", "removeSeekGestureEnableObserver", "setThumbnailEnable", "addSimpleProgressCondition", "condition", "removeSimpleProgressCondition", "isThumbnailEnable", "onStart", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onStop", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "onAttachByShared", "bindPlayerContainer", "playerContainer", "configPlayerUI", "isChronosSegmentShow", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SeekService implements ISeekService {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SeekService";
    private CoroutineScope coroutineScope;
    private List<ChronosThumbnailInfo.WatchPoint> headerTailPoints;
    @InjectPlayerService
    private IControlContainerService mControlContainerService;
    private IPlayerCoreService mCoreService;
    private int mDraggingProgress;
    @InjectPlayerService
    private IInteractLayerService mInteractLayerService;
    private PlayerContainer mPlayerContainer;
    private FunctionWidgetToken mSimpleProgressToken;
    private List<ChronosThumbnailInfo.WatchPoint> watchPoints;
    private final MutableStateFlow<Boolean> _isDraggingByUserFlow = StateFlowKt.MutableStateFlow(false);
    private final Collections.SafeIteratorList<DraggingProgressObserver> mDraggingProgressObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<PlayerProgressObserver> mPlayerProgressObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<SeekGestureEnableObserver> mSeekGestureObserverList = Collections.safeIteratorList(new ArrayList());
    private final LinkedList<SimpleProgressCondition> mSimpleProgressConditionList = new LinkedList<>();
    private List<ControlContainerType> mShowSimpleProgressControlTypes = new ArrayList();
    private boolean mProgressMutuallyExclusive = true;
    private boolean mSeekEnable = true;
    private boolean mSeekGestureEnable = true;
    private boolean mThumbnailEnable = true;
    private final MutableStateFlow<List<ChronosThumbnailInfo.WatchPoint>> _watchPointListFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final StateFlow<List<ChronosThumbnailInfo.WatchPoint>> watchPointListFlow = this._watchPointListFlow;
    private final Observer<Boolean> mSegmentObserver = new Observer() { // from class: tv.danmaku.biliplayerv2.service.SeekService$$ExternalSyntheticLambda2
        public final void onChanged(Object obj) {
            SeekService.this.configPlayerUI(((Boolean) obj).booleanValue());
        }
    };
    private final SeekService$mWatchPointsLoadListener$1 mWatchPointsLoadListener = new IWatchPointsLoadListener() { // from class: tv.danmaku.biliplayerv2.service.SeekService$mWatchPointsLoadListener$1
        @Override // tv.danmaku.biliplayerv2.service.interact.biz.IWatchPointsLoadListener
        public void onLoaded(List<ChronosThumbnailInfo.WatchPoint> list) {
            PlayerContainer playerContainer;
            List watchPoints = EnhancedUnmodifiabilityKt.unmodifiable(list);
            playerContainer = SeekService.this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            int duration = playerContainer.getPlayerCoreService().getDuration();
            if (duration > 0) {
                SeekService.this.setWatchPoints(watchPoints);
            }
        }
    };
    private final SeekService$mVideoEventListener$1 mVideoEventListener = new VideoDirectorObserver() { // from class: tv.danmaku.biliplayerv2.service.SeekService$mVideoEventListener$1
        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        public /* synthetic */ void onItemCompleted(Video.PlayableParams playableParams) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        }

        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        public /* synthetic */ void onPlayableParamsChanged(Video.PlayableParams playableParams) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        }

        @Override // tv.danmaku.biliplayerv2.service.ResolveListener
        public /* synthetic */ void onResolveFailed(Video.PlayableParams playableParams, String str) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        }

        @Override // tv.danmaku.biliplayerv2.service.ResolveListener
        public /* synthetic */ void onResolveSucceed(Video.PlayableParams playableParams) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        }

        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        public void onItemStart(Video.PlayableParams item) {
            Runnable runnable;
            Intrinsics.checkNotNullParameter(item, "item");
            runnable = SeekService.this.mCheckSimpleProgressWhenVideoItemStart;
            HandlerThreads.post(0, runnable);
        }

        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        public void onItemWillChange(Video.PlayableParams playableParams, Video.PlayableParams old) {
            Intrinsics.checkNotNullParameter(playableParams, "new");
            if (!Intrinsics.areEqual(old, playableParams)) {
                SeekService.this.setWatchPoints(null);
                SeekService.this.setHeaderTailPoints(null);
            }
            Intrinsics.checkNotNullParameter(playableParams, "new");
        }
    };
    private final SeekService$mControlContainerVisibleObserver$1 mControlContainerVisibleObserver = new ControlContainerVisibleObserver() { // from class: tv.danmaku.biliplayerv2.service.SeekService$mControlContainerVisibleObserver$1
        @Override // tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver
        public void onControlContainerVisibleChanged(boolean visible) {
            SeekService.this.notifySimpleProgressVisibility();
            SeekService.this.notifySimpleProgressVisibilityToChronos(visible);
            if (visible) {
                SeekService.this.startRefreshRunnable(true);
            } else {
                SeekService.this.stopRefreshRunnable();
            }
        }

        @Override // tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver
        public void onControlContainerImmersiveChanged(int type, boolean immersive) {
            IControlContainerService iControlContainerService;
            if (immersive) {
                SeekService.this.startRefreshRunnable(true);
                return;
            }
            iControlContainerService = SeekService.this.mControlContainerService;
            if (iControlContainerService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mControlContainerService");
                iControlContainerService = null;
            }
            if (!iControlContainerService.isShowing()) {
                SeekService.this.stopRefreshRunnable();
            }
        }
    };
    private final SeekService$mControlTypeObserver$1 mControlTypeObserver = new ControlContainerObserver() { // from class: tv.danmaku.biliplayerv2.service.SeekService$mControlTypeObserver$1
        @Override // tv.danmaku.biliplayerv2.service.ControlContainerObserver
        public void onControlContainerChanged(ControlContainerType state, ScreenModeType screenType) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(screenType, "screenType");
            SeekService.this.notifySimpleProgressVisibility();
        }
    };
    private final SeekService$mRefreshRunnable$1 mRefreshRunnable = new SeekService$mRefreshRunnable$1(this);
    private final Runnable mCheckSimpleProgressVisibility = new Runnable() { // from class: tv.danmaku.biliplayerv2.service.SeekService$$ExternalSyntheticLambda3
        @Override // java.lang.Runnable
        public final void run() {
            SeekService.mCheckSimpleProgressVisibility$lambda$0(SeekService.this);
        }
    };
    private final Runnable mCheckSimpleProgressWhenVideoItemStart = new Runnable() { // from class: tv.danmaku.biliplayerv2.service.SeekService$$ExternalSyntheticLambda4
        @Override // java.lang.Runnable
        public final void run() {
            SeekService.mCheckSimpleProgressWhenVideoItemStart$lambda$0(SeekService.this);
        }
    };

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onPlayerReset() {
        IPlayerService.CC.$default$onPlayerReset(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ PlayerServiceManager.ServiceConfig serviceConfig() {
        return IPlayerService.CC.$default$serviceConfig(this);
    }

    private final boolean isDraggingByUser() {
        return ((Boolean) this._isDraggingByUserFlow.getValue()).booleanValue();
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public StateFlow<Boolean> isDraggingByUserFlow() {
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.asStateFlow(this._isDraggingByUserFlow));
    }

    public final StateFlow<List<ChronosThumbnailInfo.WatchPoint>> getWatchPointListFlow() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.watchPointListFlow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setWatchPoints(List<ChronosThumbnailInfo.WatchPoint> list) {
        List value = EnhancedUnmodifiabilityKt.unmodifiable(list);
        this.watchPoints = value;
        mergeWatchPointAndHeaderTail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHeaderTailPoints(List<ChronosThumbnailInfo.WatchPoint> list) {
        List value = EnhancedUnmodifiabilityKt.unmodifiable(list);
        this.headerTailPoints = value;
        mergeWatchPointAndHeaderTail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean conflictTo(ChronosThumbnailInfo.WatchPoint $this$conflictTo, List<ChronosThumbnailInfo.WatchPoint> list) {
        Object element$iv;
        ChronosThumbnailInfo.WatchPoint it;
        Iterable list2 = EnhancedUnmodifiabilityKt.unmodifiable(list);
        IntRange conflictRange = new IntRange($this$conflictTo.getFrom() - 30, $this$conflictTo.getFrom() + 30);
        Iterable $this$firstOrNull$iv = list2;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it2.hasNext()) {
                element$iv = it2.next();
                ChronosThumbnailInfo.WatchPoint it3 = (ChronosThumbnailInfo.WatchPoint) element$iv;
                int first = conflictRange.getFirst();
                int last = conflictRange.getLast();
                int from = it3.getFrom();
                if (first > from || from > last) {
                    it = null;
                    continue;
                } else {
                    it = 1;
                    continue;
                }
                if (it != null) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        return element$iv != null;
    }

    private final void mergeWatchPointAndHeaderTail() {
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2 = this.coroutineScope;
        if (coroutineScope2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
            coroutineScope = null;
        } else {
            coroutineScope = coroutineScope2;
        }
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SeekService$mergeWatchPointAndHeaderTail$1(this, null), 3, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void updateHeaderTailPoints(List<ChronosThumbnailInfo.WatchPoint> list) {
        List headerTailPoints = EnhancedUnmodifiabilityKt.unmodifiable(list);
        setHeaderTailPoints(headerTailPoints);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySimpleProgressVisibility() {
        HandlerThreads.post(0, this.mCheckSimpleProgressVisibility);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySimpleProgressVisibilityToChronos(boolean visible) {
        IInteractLayerService iInteractLayerService = this.mInteractLayerService;
        IInteractLayerService iInteractLayerService2 = null;
        if (iInteractLayerService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractLayerService");
            iInteractLayerService = null;
        }
        if (iInteractLayerService.isCustomSubtitleMargin()) {
            return;
        }
        PlayerControlBarChange.Request req = new PlayerControlBarChange.Request();
        req.setDisplay(Boolean.valueOf(visible));
        req.setTinyProgress(Boolean.valueOf(isSimpleProgressShowing()));
        IInteractLayerService iInteractLayerService3 = this.mInteractLayerService;
        if (iInteractLayerService3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractLayerService");
        } else {
            iInteractLayerService2 = iInteractLayerService3;
        }
        IRemoteHandler remoteHandler = iInteractLayerService2.getRemoteHandler();
        if (remoteHandler != null) {
            remoteHandler.onPlayerControlBarChanged(req);
        }
    }

    private final void checkAndHideSimpleProgress() {
        if (needHideSimpleProgress()) {
            hideSimpleProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCheckSimpleProgressVisibility$lambda$0(SeekService this$0) {
        if (this$0.needHideSimpleProgress()) {
            this$0.hideSimpleProgress();
        } else {
            this$0.showSimpleProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCheckSimpleProgressWhenVideoItemStart$lambda$0(SeekService this$0) {
        if (this$0.needHideSimpleProgressNormalCase()) {
            this$0.hideSimpleProgress();
        } else {
            this$0.showSimpleProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refresh() {
        IPlayerCoreService it = this.mCoreService;
        if (it != null) {
            int duration = it.getDuration();
            int currentPosition = it.getCurrentPosition();
            if (currentPosition >= 0 && duration > 0) {
                if (currentPosition > duration) {
                    currentPosition = duration;
                }
                refreshPlayerProgress(currentPosition, duration);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startRefreshRunnable(boolean immediately) {
        IControlContainerService iControlContainerService = this.mControlContainerService;
        if (iControlContainerService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mControlContainerService");
            iControlContainerService = null;
        }
        if (!iControlContainerService.isShowing()) {
            return;
        }
        if (immediately) {
            this.mRefreshRunnable.run();
        } else {
            HandlerThreads.postDelayed(0, this.mRefreshRunnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopRefreshRunnable() {
        HandlerThreads.getHandler(0).removeCallbacks(this.mRefreshRunnable);
    }

    private final boolean needHideSimpleProgress() {
        return needHideSimpleProgressNormalCase();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
        if (r0.getControlContainerService().isShowing() != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean needHideSimpleProgressNormalCase() {
        List<ControlContainerType> list = this.mShowSimpleProgressControlTypes;
        PlayerContainer playerContainer = this.mPlayerContainer;
        IInteractLayerService iInteractLayerService = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        if (list.contains(playerContainer.getControlContainerService().getState())) {
            if (this.mProgressMutuallyExclusive) {
                PlayerContainer playerContainer2 = this.mPlayerContainer;
                if (playerContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer2 = null;
                }
            }
            IInteractLayerService iInteractLayerService2 = this.mInteractLayerService;
            if (iInteractLayerService2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInteractLayerService");
            } else {
                iInteractLayerService = iInteractLayerService2;
            }
            if (iInteractLayerService.getSegmentSwitchValue()) {
                BLog.i(TAG, "needHideSimpleProgressNormalCase, getSegmentSwitchValue");
                return true;
            }
            Iterable $this$forEach$iv = this.mSimpleProgressConditionList;
            for (Object element$iv : $this$forEach$iv) {
                SimpleProgressCondition it = (SimpleProgressCondition) element$iv;
                if (!it.canSimpleProgressShow()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void tryToShowSimpleProgress() {
        if (!needHideSimpleProgress()) {
            showSimpleProgress();
        }
    }

    private final void showSimpleProgress() {
        FunctionWidgetToken functionWidgetToken = this.mSimpleProgressToken;
        boolean z = true;
        if (functionWidgetToken != null && functionWidgetToken.isShowing()) {
            return;
        }
        PlayerContainer playerContainer = null;
        if (this.mSimpleProgressToken != null) {
            FunctionWidgetToken functionWidgetToken2 = this.mSimpleProgressToken;
            if (functionWidgetToken2 == null || !functionWidgetToken2.isRemoved()) {
                z = false;
            }
            if (!z) {
                PlayerContainer playerContainer2 = this.mPlayerContainer;
                if (playerContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    playerContainer = playerContainer2;
                }
                AbsFunctionWidgetService functionWidgetService = playerContainer.getFunctionWidgetService();
                FunctionWidgetToken functionWidgetToken3 = this.mSimpleProgressToken;
                Intrinsics.checkNotNull(functionWidgetToken3);
                functionWidgetService.showWidget(functionWidgetToken3);
                return;
            }
        }
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        IFunctionContainer.LayoutParams layoutParams = new IFunctionContainer.LayoutParams(-1, (int) DpUtils.dp2px(playerContainer3.getContext(), 2.0f));
        layoutParams.setFunctionType(0);
        layoutParams.setLayoutType(8);
        layoutParams.setExitAnim(-1);
        layoutParams.setEnterAnim(-1);
        layoutParams.touchEnable(false);
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer = playerContainer4;
        }
        this.mSimpleProgressToken = playerContainer.getFunctionWidgetService().showWidget(SimpleProgressFunctionWidget.class, layoutParams);
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void hideSimpleProgress() {
        FunctionWidgetToken it;
        boolean z = false;
        HandlerThreads.remove(0, this.mCheckSimpleProgressVisibility);
        FunctionWidgetToken functionWidgetToken = this.mSimpleProgressToken;
        if ((functionWidgetToken == null || functionWidgetToken.isShowing()) ? false : true) {
            return;
        }
        FunctionWidgetToken functionWidgetToken2 = this.mSimpleProgressToken;
        if (functionWidgetToken2 != null && functionWidgetToken2.isRemoved()) {
            z = true;
        }
        if (!z && (it = this.mSimpleProgressToken) != null) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getFunctionWidgetService().hideWidget(it);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public boolean isSimpleProgressShowing() {
        FunctionWidgetToken functionWidgetToken = this.mSimpleProgressToken;
        if (functionWidgetToken != null) {
            return functionWidgetToken.isShowing();
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void refreshPlayerProgress(final int progress, final int duration) {
        this.mPlayerProgressObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.SeekService$$ExternalSyntheticLambda1
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((PlayerProgressObserver) obj).onPlayerProgressChange(progress, duration);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void registerPlayerProgressObserver(PlayerProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mPlayerProgressObserverList.contains(observer)) {
            this.mPlayerProgressObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void unregisterPlayerProgressObserver(PlayerProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerProgressObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void setDraggingByUser(final boolean fromUser) {
        this._isDraggingByUserFlow.setValue(Boolean.valueOf(fromUser));
        this.mDraggingProgressObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.SeekService$$ExternalSyntheticLambda6
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((DraggingProgressObserver) obj).onDraggingByUserChanged(fromUser);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void setDraggingProgress(final int progress, final int duration) {
        this.mDraggingProgress = progress;
        this.mDraggingProgressObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.SeekService$$ExternalSyntheticLambda0
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((DraggingProgressObserver) obj).onDraggingProgressChanged(progress, duration);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void registerDraggingProgress(DraggingProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mDraggingProgressObserverList.contains(observer)) {
            this.mDraggingProgressObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void unregisterDraggingProgress(DraggingProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mDraggingProgressObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void setShowSimpleProgressControlTypes(ControlContainerType... types) {
        Intrinsics.checkNotNullParameter(types, "types");
        this.mShowSimpleProgressControlTypes.clear();
        this.mShowSimpleProgressControlTypes.addAll(ArraysKt.toList(types));
        checkAndHideSimpleProgress();
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void setProgressMutuallyExclusive(boolean exclusive) {
        this.mProgressMutuallyExclusive = exclusive;
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void setSeekEnable(boolean enable) {
        this.mSeekEnable = enable;
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public boolean isSeekEnable() {
        return this.mSeekEnable;
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void setSeekGestureEnable(final boolean enable) {
        this.mSeekGestureEnable = enable;
        this.mSeekGestureObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerv2.service.SeekService$$ExternalSyntheticLambda5
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((SeekGestureEnableObserver) obj).onSeekGestureEnableChange(enable);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public boolean isSeekGestureEnable() {
        return this.mSeekGestureEnable;
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void addSeekGestureEnableObserver(SeekGestureEnableObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mSeekGestureObserverList.contains(observer)) {
            this.mSeekGestureObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void removeSeekGestureEnableObserver(SeekGestureEnableObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mSeekGestureObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void setThumbnailEnable(boolean enable) {
        this.mThumbnailEnable = enable;
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void addSimpleProgressCondition(SimpleProgressCondition condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        if (this.mSimpleProgressConditionList.contains(condition)) {
            return;
        }
        this.mSimpleProgressConditionList.add(condition);
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public void removeSimpleProgressCondition(SimpleProgressCondition condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        this.mSimpleProgressConditionList.remove(condition);
    }

    @Override // tv.danmaku.biliplayerv2.service.ISeekService
    public boolean isThumbnailEnable() {
        return this.mThumbnailEnable;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        this.coroutineScope = CoroutineScopeKt.MainScope();
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        PlayerContainerKt.getPlayDirector(playerContainer).addVideoDirectorObserver(this.mVideoEventListener);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        playerContainer3.getInteractLayerService().addWatchPointsLoadListener(this.mWatchPointsLoadListener);
        IControlContainerService iControlContainerService = this.mControlContainerService;
        if (iControlContainerService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mControlContainerService");
            iControlContainerService = null;
        }
        iControlContainerService.registerControlContainerVisible(this.mControlContainerVisibleObserver);
        IControlContainerService iControlContainerService2 = this.mControlContainerService;
        if (iControlContainerService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mControlContainerService");
            iControlContainerService2 = null;
        }
        iControlContainerService2.registerState(this.mControlTypeObserver);
        IInteractLayerService iInteractLayerService = this.mInteractLayerService;
        if (iInteractLayerService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractLayerService");
            iInteractLayerService = null;
        }
        iInteractLayerService.addSegmentSwitchObserver(this.mSegmentObserver);
        startRefreshRunnable(false);
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer4 = null;
        }
        int duration = playerContainer4.getPlayerCoreService().getDuration();
        if (duration > 0) {
            PlayerContainer playerContainer5 = this.mPlayerContainer;
            if (playerContainer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainer2 = playerContainer5;
            }
            setWatchPoints(playerContainer2.getInteractLayerService().getWatchPoints());
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        CoroutineScope coroutineScope = this.coroutineScope;
        IInteractLayerService iInteractLayerService = null;
        if (coroutineScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
            coroutineScope = null;
        }
        CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        PlayerContainerKt.getPlayDirector(playerContainer).removeVideoDirectorObserver(this.mVideoEventListener);
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer2 = null;
        }
        playerContainer2.getInteractLayerService().removeWatchPointsLoadListener(this.mWatchPointsLoadListener);
        IControlContainerService iControlContainerService = this.mControlContainerService;
        if (iControlContainerService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mControlContainerService");
            iControlContainerService = null;
        }
        iControlContainerService.unregisterControlContainerVisible(this.mControlContainerVisibleObserver);
        IControlContainerService iControlContainerService2 = this.mControlContainerService;
        if (iControlContainerService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mControlContainerService");
            iControlContainerService2 = null;
        }
        iControlContainerService2.unregisterState(this.mControlTypeObserver);
        IInteractLayerService iInteractLayerService2 = this.mInteractLayerService;
        if (iInteractLayerService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInteractLayerService");
        } else {
            iInteractLayerService = iInteractLayerService2;
        }
        iInteractLayerService.removeSegmentSwitchObserver(this.mSegmentObserver);
        HandlerThreads.remove(0, this.mCheckSimpleProgressVisibility);
        stopRefreshRunnable();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        HandlerThreads.remove(0, this.mCheckSimpleProgressVisibility);
        stopRefreshRunnable();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onAttachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        startRefreshRunnable(false);
        tryToShowSimpleProgress();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
        this.mCoreService = playerContainer.getPlayerCoreService();
        this.mControlContainerService = playerContainer.getControlContainerService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configPlayerUI(boolean isChronosSegmentShow) {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        IControlContainerService containerService = playerContainer.getControlContainerService();
        if (isChronosSegmentShow) {
            containerService.hide();
            hideSimpleProgress();
            return;
        }
        tryToShowSimpleProgress();
    }

    /* compiled from: SeekService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/SeekService$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}