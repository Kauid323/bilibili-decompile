package usercenter;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import usercenter.UserHandleAction;
import usercenter.UserHandleSideEffect;
import usercenter.UserHandleState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserHandleStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lusercenter/UserHandleState;", "<unused var>", "Lusercenter/UserHandleAction$ShowNoEditPermissionToast;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lusercenter/UserHandleState$Immutable;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "usercenter.UserHandleStateMachine$handleImmutableState$1", f = "UserHandleStateMachine.kt", i = {0}, l = {235}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class UserHandleStateMachine$handleImmutableState$1 extends SuspendLambda implements Function3<UserHandleAction.ShowNoEditPermissionToast, State<UserHandleState.Immutable>, Continuation<? super ChangedState<? extends UserHandleState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UserHandleStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHandleStateMachine$handleImmutableState$1(UserHandleStateMachine userHandleStateMachine, Continuation<? super UserHandleStateMachine$handleImmutableState$1> continuation) {
        super(3, continuation);
        this.this$0 = userHandleStateMachine;
    }

    public final Object invoke(UserHandleAction.ShowNoEditPermissionToast showNoEditPermissionToast, State<UserHandleState.Immutable> state, Continuation<? super ChangedState<? extends UserHandleState>> continuation) {
        UserHandleStateMachine$handleImmutableState$1 userHandleStateMachine$handleImmutableState$1 = new UserHandleStateMachine$handleImmutableState$1(this.this$0, continuation);
        userHandleStateMachine$handleImmutableState$1.L$0 = state;
        return userHandleStateMachine$handleImmutableState$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow mutableSharedFlow;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutableSharedFlow = this.this$0.sideEffect;
                this.L$0 = state;
                this.label = 1;
                if (mutableSharedFlow.emit(new UserHandleSideEffect.ShowToast(((UserHandleState.Immutable) state.getSnapshot()).getTip()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.noChange();
    }
}