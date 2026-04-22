package tv.danmaku.biliplayerv2;

import androidx.compose.animation.core.MutatorMutex$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerContainerCoroutine.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"coroutineScope", "Ltv/danmaku/biliplayerv2/PlayerContainerCoroutineScope;", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "getCoroutineScope", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;)Ltv/danmaku/biliplayerv2/PlayerContainerCoroutineScope;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerContainerCoroutineKt {
    public static final PlayerContainerCoroutineScope getCoroutineScope(IPlayerContainer $this$coroutineScope) {
        Intrinsics.checkNotNullParameter($this$coroutineScope, "<this>");
        while ($this$coroutineScope instanceof PlayerContainer) {
            PlayerContainerCoroutineScopeImpl existing = (PlayerContainerCoroutineScopeImpl) ((PlayerContainer) $this$coroutineScope).getScopeRef$biliplayerv2_debug().get();
            if (existing != null) {
                return existing;
            }
            PlayerContainerCoroutineScopeImpl newScope = new PlayerContainerCoroutineScopeImpl($this$coroutineScope.getActivityStateService(), SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(((PlayerContainer) $this$coroutineScope).getScopeRef$biliplayerv2_debug(), (Object) null, newScope)) {
                newScope.register();
                return newScope;
            }
        }
        throw new IllegalArgumentException("can not find player container coroutine scope from a IPlayerContainer but it is not PlayerContainer");
    }
}