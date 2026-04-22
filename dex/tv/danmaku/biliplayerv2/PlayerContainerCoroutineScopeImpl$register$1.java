package tv.danmaku.biliplayerv2;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import tv.danmaku.biliplayerv2.service.LifecycleState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayerContainerCoroutine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.PlayerContainerCoroutineScopeImpl$register$1", f = "PlayerContainerCoroutine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PlayerContainerCoroutineScopeImpl$register$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlayerContainerCoroutineScopeImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerContainerCoroutineScopeImpl$register$1(PlayerContainerCoroutineScopeImpl playerContainerCoroutineScopeImpl, Continuation<? super PlayerContainerCoroutineScopeImpl$register$1> continuation) {
        super(2, continuation);
        this.this$0 = playerContainerCoroutineScopeImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> playerContainerCoroutineScopeImpl$register$1 = new PlayerContainerCoroutineScopeImpl$register$1(this.this$0, continuation);
        playerContainerCoroutineScopeImpl$register$1.L$0 = obj;
        return playerContainerCoroutineScopeImpl$register$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                if (this.this$0.getActivityService$biliplayerv2_debug().getLifecycleState().compareTo(LifecycleState.ACTIVITY_DESTROY) < 0) {
                    this.this$0.getActivityService$biliplayerv2_debug().registerLifecycle(this.this$0, LifecycleState.ACTIVITY_DESTROY);
                } else {
                    JobKt.cancel$default($this$launch.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}