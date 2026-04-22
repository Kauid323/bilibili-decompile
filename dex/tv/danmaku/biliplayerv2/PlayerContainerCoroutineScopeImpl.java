package tv.danmaku.biliplayerv2;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import tv.danmaku.biliplayerv2.service.IActivityStateService;
import tv.danmaku.biliplayerv2.service.LifecycleObserver;
import tv.danmaku.biliplayerv2.service.LifecycleState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerContainerCoroutine.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerv2/PlayerContainerCoroutineScopeImpl;", "Ltv/danmaku/biliplayerv2/PlayerContainerCoroutineScope;", "Ltv/danmaku/biliplayerv2/service/LifecycleObserver;", "activityService", "Ltv/danmaku/biliplayerv2/service/IActivityStateService;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Ltv/danmaku/biliplayerv2/service/IActivityStateService;Lkotlin/coroutines/CoroutineContext;)V", "getActivityService$biliplayerv2_debug", "()Ltv/danmaku/biliplayerv2/service/IActivityStateService;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "register", "", "onLifecycleChanged", "state", "Ltv/danmaku/biliplayerv2/service/LifecycleState;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerContainerCoroutineScopeImpl extends PlayerContainerCoroutineScope implements LifecycleObserver {
    private final IActivityStateService activityService;
    private final CoroutineContext coroutineContext;

    public PlayerContainerCoroutineScopeImpl(IActivityStateService activityService, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(activityService, "activityService");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.activityService = activityService;
        this.coroutineContext = coroutineContext;
        if (getActivityService$biliplayerv2_debug().getLifecycleState() != LifecycleState.ACTIVITY_DESTROY) {
            return;
        }
        JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.PlayerContainerCoroutineScope
    public IActivityStateService getActivityService$biliplayerv2_debug() {
        return this.activityService;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final void register() {
        BuildersKt.launch$default(this, Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new PlayerContainerCoroutineScopeImpl$register$1(this, null), 2, (Object) null);
    }

    @Override // tv.danmaku.biliplayerv2.service.LifecycleObserver
    public void onLifecycleChanged(LifecycleState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == LifecycleState.ACTIVITY_DESTROY) {
            getActivityService$biliplayerv2_debug().unregisterLifecycle(this);
            JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }
}