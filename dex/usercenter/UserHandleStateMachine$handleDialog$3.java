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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import usercenter.DialogState;
import usercenter.UserHandleAction;
import usercenter.UserHandleState;

/* compiled from: UserHandleStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lusercenter/UserHandleState;", "<unused var>", "Lusercenter/UserHandleAction$DismissDialog;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lusercenter/UserHandleState$Mutable;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "usercenter.UserHandleStateMachine$handleDialog$3", f = "UserHandleStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class UserHandleStateMachine$handleDialog$3 extends SuspendLambda implements Function3<UserHandleAction.DismissDialog, State<UserHandleState.Mutable>, Continuation<? super ChangedState<? extends UserHandleState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserHandleStateMachine$handleDialog$3(Continuation<? super UserHandleStateMachine$handleDialog$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(UserHandleAction.DismissDialog dismissDialog, State<UserHandleState.Mutable> state, Continuation<? super ChangedState<? extends UserHandleState>> continuation) {
        UserHandleStateMachine$handleDialog$3 userHandleStateMachine$handleDialog$3 = new UserHandleStateMachine$handleDialog$3(continuation);
        userHandleStateMachine$handleDialog$3.L$0 = state;
        return userHandleStateMachine$handleDialog$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i("UserHandleStateMachine", "DismissDialog");
                return state.mutate(new Function1() { // from class: usercenter.UserHandleStateMachine$handleDialog$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        UserHandleState.Mutable invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = UserHandleStateMachine$handleDialog$3.invokeSuspend$lambda$0((UserHandleState.Mutable) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserHandleState.Mutable invokeSuspend$lambda$0(UserHandleState.Mutable $this$mutate) {
        return UserHandleState.Mutable.copy$default($this$mutate, null, DialogState.None.INSTANCE, 1, null);
    }
}