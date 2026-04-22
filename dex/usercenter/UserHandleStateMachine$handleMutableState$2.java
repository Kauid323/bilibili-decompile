package usercenter;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import usercenter.UserHandleAction;
import usercenter.UserHandleSideEffect;
import usercenter.UserHandleState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserHandleStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lusercenter/UserHandleState;", "action", "Lusercenter/UserHandleAction$SubmitSuccess;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lusercenter/UserHandleState$Mutable;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "usercenter.UserHandleStateMachine$handleMutableState$2", f = "UserHandleStateMachine.kt", i = {0, 0, 0, 0, 1, 1}, l = {220, 225}, m = "invokeSuspend", n = {"action", "state", "it", "$i$a$-let-UserHandleStateMachine$handleMutableState$2$2", "action", "state"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1"}, v = 1)
public final class UserHandleStateMachine$handleMutableState$2 extends SuspendLambda implements Function3<UserHandleAction.SubmitSuccess, State<UserHandleState.Mutable>, Continuation<? super ChangedState<? extends UserHandleState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ UserHandleStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHandleStateMachine$handleMutableState$2(UserHandleStateMachine userHandleStateMachine, Continuation<? super UserHandleStateMachine$handleMutableState$2> continuation) {
        super(3, continuation);
        this.this$0 = userHandleStateMachine;
    }

    public final Object invoke(UserHandleAction.SubmitSuccess submitSuccess, State<UserHandleState.Mutable> state, Continuation<? super ChangedState<? extends UserHandleState>> continuation) {
        UserHandleStateMachine$handleMutableState$2 userHandleStateMachine$handleMutableState$2 = new UserHandleStateMachine$handleMutableState$2(this.this$0, continuation);
        userHandleStateMachine$handleMutableState$2.L$0 = submitSuccess;
        userHandleStateMachine$handleMutableState$2.L$1 = state;
        return userHandleStateMachine$handleMutableState$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        UserHandleAction.SubmitSuccess action = (UserHandleAction.SubmitSuccess) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String it = action.getToast();
                if (!(it.length() > 0)) {
                    it = null;
                }
                if (it != null) {
                    UserHandleStateMachine userHandleStateMachine = this.this$0;
                    KLog_androidKt.getKLog().i("UserHandleStateMachine", "更新用户名成功");
                    mutableSharedFlow = userHandleStateMachine.sideEffect;
                    UserHandleSideEffect.ShowToast showToast = new UserHandleSideEffect.ShowToast(action.getToast());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(it);
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutableSharedFlow.emit(showToast, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                mutableSharedFlow2 = this.this$0.sideEffect;
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = null;
                this.label = 2;
                if (mutableSharedFlow2.emit(UserHandleSideEffect.ExitPage.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return state.noChange();
            case 1:
                int i = this.I$0;
                String str = (String) this.L$2;
                ResultKt.throwOnFailure($result);
                mutableSharedFlow2 = this.this$0.sideEffect;
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = null;
                this.label = 2;
                if (mutableSharedFlow2.emit(UserHandleSideEffect.ExitPage.INSTANCE, (Continuation) this) == coroutine_suspended) {
                }
                return state.noChange();
            case 2:
                ResultKt.throwOnFailure($result);
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}