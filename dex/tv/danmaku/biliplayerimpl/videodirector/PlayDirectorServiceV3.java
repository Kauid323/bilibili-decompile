package tv.danmaku.biliplayerimpl.videodirector;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.biliplayerimpl.AbsCorePlayerService;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerimpl.report.heartbeat.HeartbeatService;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.injection.InjectPlayerService;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.service.IPlayDirectorServiceV3;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.service.IToastService;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.VideoDirectorObserver;
import tv.danmaku.biliplayerv2.service.report.IReporterService;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayDirectorServiceV3.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010*H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020*H\u0002J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u000102H\u0016J \u00103\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u00182\b\u00104\u001a\u0004\u0018\u00010\u0018H\u0082@¢\u0006\u0002\u00105J\b\u00106\u001a\u00020(H\u0016J\n\u00107\u001a\u0004\u0018\u00010*H\u0016J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u0015H\u0016J\u0010\u0010:\u001a\u00020(2\u0006\u00109\u001a\u00020\u0015H\u0016J\u0018\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020=2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020@H\u0016J\u0010\u0010C\u001a\u00020(2\u0006\u0010B\u001a\u00020@H\u0016J\b\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020@2\u0006\u0010G\u001a\u00020@H\u0016J\u0010\u0010H\u001a\u00020@2\u0006\u0010G\u001a\u00020@H\u0016J\b\u0010I\u001a\u00020EH\u0016R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0002@\u0002X\u0083.¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R(\u0010\u001c\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006J"}, d2 = {"Ltv/danmaku/biliplayerimpl/videodirector/PlayDirectorServiceV3;", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3;", "Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "<init>", "()V", "toastService", "Ltv/danmaku/biliplayerv2/service/IToastService;", "heartbeatService", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatService;", "reportService", "Ltv/danmaku/biliplayerv2/service/report/IReporterService;", "functionService", "Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;", "playerCoreService", "Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "mPlayerSettingService", "Ltv/danmaku/biliplayerv2/service/setting/IPlayerSettingService;", "renderContainerService", "Ltv/danmaku/biliplayerv2/service/IRenderContainerService;", "observers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ltv/danmaku/biliplayerv2/service/VideoDirectorObserver;", "itemFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$Item;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "value", "item", "getItem", "()Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$Item;", "setItem", "(Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$Item;)V", "directorSerialOperations", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$DirectorSerialOperations;", "getDirectorSerialOperations", "()Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$DirectorSerialOperations;", "setDirectorSerialOperations", "(Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$DirectorSerialOperations;)V", "dispatchItemWillChange", "", "new", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "old", "dispatchItemStart", "bindPlayerContainer", "playerContainer", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "onStart", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "processItem", "previousItem", "(Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$Item;Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3$Item;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStop", "getCurrentPlayableParams", "addVideoDirectorObserver", "observer", "removeVideoDirectorObserver", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "triggerResolveAndAutoStart", "autoStart", "", "switchToNext", "canLoop", "switchToPrevious", "itemCount", "", "hasNext", "loop", "hasPrevious", "getPlayingItemIndex", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayDirectorServiceV3 extends AbsCorePlayerService implements IPlayDirectorServiceV3 {
    private CoroutineScope coroutineScope;
    private IPlayDirectorServiceV3.DirectorSerialOperations directorSerialOperations;
    @InjectPlayerService
    private AbsFunctionWidgetService functionService;
    @InjectPlayerService
    private HeartbeatService heartbeatService;
    @InjectPlayerService
    private IPlayerSettingService mPlayerSettingService;
    @InjectPlayerService
    private IPlayerCoreService playerCoreService;
    @InjectPlayerService
    private IRenderContainerService renderContainerService;
    @InjectPlayerService
    private IReporterService reportService;
    @InjectPlayerService
    private IToastService toastService;
    private final CopyOnWriteArrayList<VideoDirectorObserver> observers = new CopyOnWriteArrayList<>();
    private final MutableStateFlow<IPlayDirectorServiceV3.Item> itemFlow = StateFlowKt.MutableStateFlow((Object) null);

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirectorServiceV3
    public IPlayDirectorServiceV3.Item getItem() {
        return (IPlayDirectorServiceV3.Item) this.itemFlow.getValue();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirectorServiceV3
    public void setItem(IPlayDirectorServiceV3.Item value) {
        this.itemFlow.setValue(value);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirectorServiceV3
    public IPlayDirectorServiceV3.DirectorSerialOperations getDirectorSerialOperations() {
        return this.directorSerialOperations;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirectorServiceV3
    public void setDirectorSerialOperations(IPlayDirectorServiceV3.DirectorSerialOperations directorSerialOperations) {
        this.directorSerialOperations = directorSerialOperations;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchItemWillChange(Video.PlayableParams playableParams, Video.PlayableParams old) {
        Iterable $this$forEach$iv = this.observers;
        for (Object element$iv : $this$forEach$iv) {
            VideoDirectorObserver it = (VideoDirectorObserver) element$iv;
            it.onItemWillChange(playableParams, old);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchItemStart(Video.PlayableParams item) {
        Iterable $this$forEach$iv = this.observers;
        for (Object element$iv : $this$forEach$iv) {
            VideoDirectorObserver it = (VideoDirectorObserver) element$iv;
            it.onItemStart(item);
        }
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService
    public void bindPlayerContainer(PlayerContainerImpl playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        CoroutineScope coroutineScope;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        CoroutineScope coroutineScope2 = this.coroutineScope;
        if (coroutineScope2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
            coroutineScope = null;
        } else {
            coroutineScope = coroutineScope2;
        }
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PlayDirectorServiceV3$onStart$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processItem(IPlayDirectorServiceV3.Item item, IPlayDirectorServiceV3.Item previousItem, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PlayDirectorServiceV3$processItem$2(item, this, previousItem, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
            coroutineScope = null;
        }
        CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public Video.PlayableParams getCurrentPlayableParams() {
        IPlayDirectorServiceV3.Item item = getItem();
        if (item != null) {
            return item.getPlayableParams();
        }
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public void addVideoDirectorObserver(VideoDirectorObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public void removeVideoDirectorObserver(VideoDirectorObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Video.PlayableParams playableParams = getCurrentPlayableParams();
        if (playableParams == null) {
            return;
        }
        bundle.putSharableObject("key_share_player_playable_params", playableParams);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public void triggerResolveAndAutoStart(boolean autoStart) {
        Function0<Unit> triggerResolve;
        IPlayDirectorServiceV3.Item item = getItem();
        if (item != null && (triggerResolve = item.getTriggerResolve()) != null) {
            triggerResolve.invoke();
        }
        IPlayerCoreService iPlayerCoreService = null;
        if (autoStart) {
            IPlayerCoreService iPlayerCoreService2 = this.playerCoreService;
            if (iPlayerCoreService2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerCoreService");
            } else {
                iPlayerCoreService = iPlayerCoreService2;
            }
            iPlayerCoreService.resume();
            return;
        }
        IPlayerCoreService iPlayerCoreService3 = this.playerCoreService;
        if (iPlayerCoreService3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCoreService");
        } else {
            iPlayerCoreService = iPlayerCoreService3;
        }
        iPlayerCoreService.pause();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public void switchToNext(boolean canLoop) {
        IPlayDirectorServiceV3.DirectorSerialOperations directorSerialOperations = getDirectorSerialOperations();
        if (directorSerialOperations != null) {
            directorSerialOperations.switchToNext(canLoop);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public void switchToPrevious(boolean canLoop) {
        IPlayDirectorServiceV3.DirectorSerialOperations directorSerialOperations = getDirectorSerialOperations();
        if (directorSerialOperations != null) {
            directorSerialOperations.switchToPrevious(canLoop);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public int itemCount() {
        IPlayDirectorServiceV3.DirectorSerialOperations directorSerialOperations = getDirectorSerialOperations();
        if (directorSerialOperations != null) {
            return directorSerialOperations.itemCount();
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public boolean hasNext(boolean loop) {
        IPlayDirectorServiceV3.DirectorSerialOperations directorSerialOperations = getDirectorSerialOperations();
        if (directorSerialOperations != null) {
            return directorSerialOperations.hasNext(loop);
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public boolean hasPrevious(boolean loop) {
        IPlayDirectorServiceV3.DirectorSerialOperations directorSerialOperations = getDirectorSerialOperations();
        if (directorSerialOperations != null) {
            return directorSerialOperations.hasPrevious(loop);
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayDirector
    public int getPlayingItemIndex() {
        IPlayDirectorServiceV3.DirectorSerialOperations directorSerialOperations = getDirectorSerialOperations();
        if (directorSerialOperations != null) {
            return directorSerialOperations.getPlayingItemIndex();
        }
        return -1;
    }
}