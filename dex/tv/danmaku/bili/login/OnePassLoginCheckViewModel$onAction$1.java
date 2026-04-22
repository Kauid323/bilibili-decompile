package tv.danmaku.bili.login;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.login.ActionResult;

/* compiled from: OnePassLoginCheckViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.login.OnePassLoginCheckViewModel$onAction$1", f = "OnePassLoginCheckViewModel.kt", i = {}, l = {BR.avatarUrl, BR.backgroundHeaderImageUrl}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OnePassLoginCheckViewModel$onAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoginCheckAction $action;
    int label;
    final /* synthetic */ OnePassLoginCheckViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePassLoginCheckViewModel$onAction$1(OnePassLoginCheckViewModel onePassLoginCheckViewModel, LoginCheckAction loginCheckAction, Continuation<? super OnePassLoginCheckViewModel$onAction$1> continuation) {
        super(2, continuation);
        this.this$0 = onePassLoginCheckViewModel;
        this.$action = loginCheckAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnePassLoginCheckViewModel$onAction$1(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow mutableStateFlow;
        Object $result2;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutableStateFlow = this.this$0._state;
                LoginCheckState state = (LoginCheckState) mutableStateFlow.getValue();
                this.label = 1;
                Object reduce = this.$action.reduce(state, (Continuation) this);
                if (reduce != coroutine_suspended) {
                    $result2 = $result;
                    $result = reduce;
                    break;
                } else {
                    return coroutine_suspended;
                }
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
        ActionResult result = (ActionResult) $result;
        if (result instanceof ActionResult.StateChange) {
            mutableStateFlow3 = this.this$0._state;
            mutableStateFlow3.setValue(((ActionResult.StateChange) result).getState());
            return Unit.INSTANCE;
        } else if (result instanceof ActionResult.StateWithSideEffect) {
            mutableStateFlow2 = this.this$0._state;
            mutableStateFlow2.setValue(((ActionResult.StateWithSideEffect) result).getState());
            Function2<LoginCheckActionHandler, Continuation<? super Unit>, Object> sideEffect = ((ActionResult.StateWithSideEffect) result).getSideEffect();
            OnePassLoginCheckViewModel onePassLoginCheckViewModel = this.this$0;
            this.label = 2;
            if (sideEffect.invoke(onePassLoginCheckViewModel, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            $result = $result2;
            return Unit.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}