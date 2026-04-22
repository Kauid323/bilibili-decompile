package tv.danmaku.bili.inner;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginViewModel$dispatchAction$1", f = "InnerLoginViewModel.kt", i = {}, l = {BR.bottomDesc}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerLoginViewModel$dispatchAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFullscreenAction $action;
    int label;
    final /* synthetic */ InnerLoginViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginViewModel$dispatchAction$1(InnerLoginViewModel innerLoginViewModel, IFullscreenAction iFullscreenAction, Continuation<? super InnerLoginViewModel$dispatchAction$1> continuation) {
        super(2, continuation);
        this.this$0 = innerLoginViewModel;
        this.$action = iFullscreenAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerLoginViewModel$dispatchAction$1(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        InnerLoginStateMachine innerLoginStateMachine;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                innerLoginStateMachine = this.this$0.stateMachine;
                this.label = 1;
                if (innerLoginStateMachine.dispatch(this.$action, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}