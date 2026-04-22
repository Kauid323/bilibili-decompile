package tv.danmaku.biliplayerimpl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bilibili.base.util.ContextUtilKt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.IActivityStateService;
import tv.danmaku.biliplayerv2.service.IWindowInsetObserver;
import tv.danmaku.biliplayerv2.service.LifecycleObserver;
import tv.danmaku.biliplayerv2.service.LifecycleState;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceInner;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: ActivityStateService.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J)\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\f2\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0$\"\u00020\tH\u0016¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\fH\u0016J\u0012\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u0012H\u0016J\u0010\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0014H\u0016J\b\u00101\u001a\u00020\u0014H\u0016J\u0010\u00102\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u000fH\u0016J\u0010\u00103\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u000fH\u0016J\b\u00104\u001a\u000205H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000Rl\u0010\u0007\u001aZ\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \n*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b \n*,\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \n*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b\u0018\u00010\b0\bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0004R2\u0010\u000e\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000f0\u000f \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u00066"}, d2 = {"Ltv/danmaku/biliplayerimpl/ActivityStateService;", "Ltv/danmaku/biliplayerv2/service/IActivityStateService;", "Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "mObserverMap", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorMap;", "Ltv/danmaku/biliplayerv2/service/LifecycleState;", "kotlin.jvm.PlatformType", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/biliplayerv2/service/LifecycleObserver;", "getMObserverMap$annotations", "mWindowInsetObservers", "Ltv/danmaku/biliplayerv2/service/IWindowInsetObserver;", "mCurrentLifecycleState", "mCurrentOrientation", "", "mWindowInset", "Ltv/danmaku/biliplayerv2/service/WindowInset;", "mLifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "setLifecycleState", "", "state", "bindPlayerContainer", "playerContainer", "getLifecycleState", "onStart", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onStop", "registerLifecycle", "observer", "states", "", "(Ltv/danmaku/biliplayerv2/service/LifecycleObserver;[Ltv/danmaku/biliplayerv2/service/LifecycleState;)V", "unregisterLifecycle", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "setActivityOrientation", "newConfig", "Landroid/content/res/Configuration;", "getOrientation", "dispatchWindowInsetChanged", "windowInset", "getWindowInset", "registerWindowInset", "unregisterWindowInset", "getContext", "Landroid/content/Context;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ActivityStateService extends AbsCorePlayerService implements IActivityStateService {
    private int mCurrentOrientation;
    private PlayerContainerImpl mPlayerContainer;
    private final Collections.SafeIteratorMap<LifecycleState, Collections.SafeIteratorList<LifecycleObserver>> mObserverMap = Collections.safeIteratorMap(new HashMap());
    private final Collections.SafeIteratorList<IWindowInsetObserver> mWindowInsetObservers = Collections.safeIteratorList(new LinkedList());
    private LifecycleState mCurrentLifecycleState = LifecycleState.INITIAL;
    private WindowInset mWindowInset = new WindowInset(0, 0, 0, 0, 15, null);
    private final LifecycleRegistry mLifecycle = new LifecycleRegistry(this);

    /* compiled from: ActivityStateService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LifecycleState.values().length];
            try {
                iArr[LifecycleState.ACTIVITY_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LifecycleState.ACTIVITY_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LifecycleState.ACTIVITY_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[LifecycleState.ACTIVITY_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[LifecycleState.ACTIVITY_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[LifecycleState.ACTIVITY_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static /* synthetic */ void getMObserverMap$annotations() {
    }

    @Override // tv.danmaku.biliplayerv2.service.IActivityStateService
    public void setLifecycleState(final LifecycleState state) {
        Lifecycle.Event event;
        Intrinsics.checkNotNullParameter(state, "state");
        this.mCurrentLifecycleState = state;
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                this.mLifecycle.setCurrentState(Lifecycle.State.CREATED);
                break;
            case 2:
                this.mLifecycle.setCurrentState(Lifecycle.State.STARTED);
                break;
            case 3:
                this.mLifecycle.setCurrentState(Lifecycle.State.RESUMED);
                break;
            case 4:
                this.mLifecycle.setCurrentState(Lifecycle.State.STARTED);
                break;
            case 5:
                this.mLifecycle.setCurrentState(Lifecycle.State.CREATED);
                break;
            case 6:
                this.mLifecycle.setCurrentState(Lifecycle.State.DESTROYED);
                break;
        }
        PlayerLog.i(PlayerLogModule.ActivityState, "activity lifecycle to " + this.mCurrentLifecycleState);
        Collections.SafeIteratorList receivers = this.mObserverMap.get(state);
        Collections.SafeIteratorList safeIteratorList = receivers;
        if (safeIteratorList == null || safeIteratorList.isEmpty()) {
            return;
        }
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        IHeartbeatServiceInner heartbeatService = playerContainerImpl.getHeartbeatService();
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                event = Lifecycle.Event.ON_CREATE;
                break;
            case 2:
                event = Lifecycle.Event.ON_START;
                break;
            case 3:
                event = Lifecycle.Event.ON_RESUME;
                break;
            case 4:
                event = Lifecycle.Event.ON_PAUSE;
                break;
            case 5:
                event = Lifecycle.Event.ON_STOP;
                break;
            case 6:
                event = Lifecycle.Event.ON_DESTROY;
                break;
            default:
                event = Lifecycle.Event.ON_DESTROY;
                break;
        }
        heartbeatService.notifyLifecycleChanged(event);
        receivers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.ActivityStateService$$ExternalSyntheticLambda2
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((LifecycleObserver) obj).onLifecycleChanged(LifecycleState.this);
            }
        });
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService
    public void bindPlayerContainer(PlayerContainerImpl playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.IActivityStateService
    public LifecycleState getLifecycleState() {
        return this.mCurrentLifecycleState;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        Collections.SafeIteratorMap<LifecycleState, Collections.SafeIteratorList<LifecycleObserver>> safeIteratorMap = this.mObserverMap;
        Intrinsics.checkNotNullExpressionValue(safeIteratorMap, "mObserverMap");
        if (!safeIteratorMap.isEmpty()) {
            this.mObserverMap.clear();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IActivityStateService
    public void registerLifecycle(LifecycleObserver observer, LifecycleState... states) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(states, "states");
        if (states.length == 0) {
            return;
        }
        for (LifecycleState state : states) {
            Collections.SafeIteratorList receivers = this.mObserverMap.get(state);
            if (receivers == null) {
                receivers = Collections.safeIteratorList(new LinkedList());
            }
            if (!(receivers != null && receivers.contains(observer))) {
                if (receivers != null) {
                    receivers.add(observer);
                }
                Collections.SafeIteratorMap<LifecycleState, Collections.SafeIteratorList<LifecycleObserver>> safeIteratorMap = this.mObserverMap;
                Intrinsics.checkNotNullExpressionValue(safeIteratorMap, "mObserverMap");
                safeIteratorMap.put(state, receivers);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IActivityStateService
    public void unregisterLifecycle(final LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mObserverMap.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.ActivityStateService$$ExternalSyntheticLambda1
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ActivityStateService.unregisterLifecycle$lambda$0(LifecycleObserver.this, this, (Map.Entry) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unregisterLifecycle$lambda$0(LifecycleObserver $observer, ActivityStateService this$0, Map.Entry it) {
        Collections.SafeIteratorList receivers = (Collections.SafeIteratorList) it.getValue();
        if (receivers != null && !receivers.isEmpty() && receivers.contains($observer)) {
            receivers.remove($observer);
            if (receivers.isEmpty()) {
                this$0.mObserverMap.remove(it.getKey());
            }
        }
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    @Override // tv.danmaku.biliplayerv2.service.IActivityStateService
    public void setActivityOrientation(Configuration newConfig) {
        if (newConfig == null) {
            return;
        }
        this.mCurrentOrientation = newConfig.orientation;
    }

    @Override // tv.danmaku.biliplayerv2.service.IActivityStateService
    public int getOrientation() {
        if (this.mCurrentOrientation == 0) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            Activity findActivityOrNull = ContextUtilKt.findActivityOrNull(playerContainerImpl.getContext());
            this.mCurrentOrientation = findActivityOrNull != null ? findActivityOrNull.getRequestedOrientation() : 0;
        }
        return this.mCurrentOrientation;
    }

    @Override // tv.danmaku.biliplayerv2.service.IActivityStateService
    public void dispatchWindowInsetChanged(final WindowInset windowInset) {
        Intrinsics.checkNotNullParameter(windowInset, "windowInset");
        this.mWindowInset = windowInset;
        this.mWindowInsetObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.ActivityStateService$$ExternalSyntheticLambda0
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IWindowInsetObserver) obj).onWindowInsetChanged(WindowInset.this);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.IActivityStateService
    public WindowInset getWindowInset() {
        return this.mWindowInset;
    }

    @Override // tv.danmaku.biliplayerv2.service.IActivityStateService
    public void registerWindowInset(IWindowInsetObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mWindowInsetObservers.contains(observer)) {
            return;
        }
        this.mWindowInsetObservers.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IActivityStateService
    public void unregisterWindowInset(IWindowInsetObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mWindowInsetObservers.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IActivityStateService
    public Context getContext() {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        return playerContainerImpl.getContext();
    }
}