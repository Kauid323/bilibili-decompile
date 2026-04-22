package tv.danmaku.bili.fullscreen;

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
/* compiled from: FullscreenLoginViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.FullscreenLoginViewModel$dispatchAction$1", f = "FullscreenLoginViewModel.kt", i = {}, l = {BR.cardDescType, BR.cardHeight}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FullscreenLoginViewModel$dispatchAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFullscreenAction $action;
    int label;
    final /* synthetic */ FullscreenLoginViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginViewModel$dispatchAction$1(FullscreenLoginViewModel fullscreenLoginViewModel, IFullscreenAction iFullscreenAction, Continuation<? super FullscreenLoginViewModel$dispatchAction$1> continuation) {
        super(2, continuation);
        this.this$0 = fullscreenLoginViewModel;
        this.$action = iFullscreenAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FullscreenLoginViewModel$dispatchAction$1(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object interceptAction;
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                interceptAction = this.this$0.interceptAction(this.$action, (Continuation) this);
                if (interceptAction == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = interceptAction;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!((Boolean) $result).booleanValue()) {
            this.label = 2;
            if (this.this$0.getStateMachine().dispatch(this.$action, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            $result = $result2;
        }
        return Unit.INSTANCE;
    }
}