package usercenter;

import bili.resource.profile.ProfileRes;
import bili.resource.profile.String0_commonMainKt;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.text.Regex;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayableParams;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import usercenter.DialogState;
import usercenter.UserHandleAction;
import usercenter.UserHandleSideEffect;
import usercenter.UserHandleState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserHandleStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lusercenter/UserHandleState;", "action", "Lusercenter/UserHandleAction$ShowDoubleCheckDialog;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lusercenter/UserHandleState$Mutable;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "usercenter.UserHandleStateMachine$handleDialog$1", f = "UserHandleStateMachine.kt", i = {0, 0, 0}, l = {AuthorSpaceHeaderPlayableParams.AUTHOR_SPACE_HEADER_PLAYER_REPORT_AUTO_PLAY}, m = "invokeSuspend", n = {"action", "state", "pattern"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class UserHandleStateMachine$handleDialog$1 extends SuspendLambda implements Function3<UserHandleAction.ShowDoubleCheckDialog, State<UserHandleState.Mutable>, Continuation<? super ChangedState<? extends UserHandleState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ UserHandleStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHandleStateMachine$handleDialog$1(UserHandleStateMachine userHandleStateMachine, Continuation<? super UserHandleStateMachine$handleDialog$1> continuation) {
        super(3, continuation);
        this.this$0 = userHandleStateMachine;
    }

    public final Object invoke(UserHandleAction.ShowDoubleCheckDialog showDoubleCheckDialog, State<UserHandleState.Mutable> state, Continuation<? super ChangedState<? extends UserHandleState>> continuation) {
        UserHandleStateMachine$handleDialog$1 userHandleStateMachine$handleDialog$1 = new UserHandleStateMachine$handleDialog$1(this.this$0, continuation);
        userHandleStateMachine$handleDialog$1.L$0 = showDoubleCheckDialog;
        userHandleStateMachine$handleDialog$1.L$1 = state;
        return userHandleStateMachine$handleDialog$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow mutableSharedFlow;
        Regex pattern;
        final UserHandleAction.ShowDoubleCheckDialog action = (UserHandleAction.ShowDoubleCheckDialog) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i("UserHandleStateMachine", "ShowDoubleCheckDialog: " + action.getNewHandle());
                Regex pattern2 = new Regex("^[a-zA-Z0-9_]+$");
                if (!pattern2.matches(action.getNewHandle())) {
                    mutableSharedFlow = this.this$0.sideEffect;
                    this.L$0 = action;
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(pattern2);
                    this.label = 1;
                    if (mutableSharedFlow.emit(new UserHandleSideEffect.ShowToast(ProfileRes.INSTANCE.getString(String0_commonMainKt.getProfile_global_string_72(ProfileRes.INSTANCE.getString()))), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pattern = pattern2;
                    break;
                } else {
                    return state.mutate(new Function1() { // from class: usercenter.UserHandleStateMachine$handleDialog$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            UserHandleState.Mutable invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = UserHandleStateMachine$handleDialog$1.invokeSuspend$lambda$1(UserHandleAction.ShowDoubleCheckDialog.this, (UserHandleState.Mutable) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
            case 1:
                pattern = (Regex) this.L$2;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.mutate(new Function1() { // from class: usercenter.UserHandleStateMachine$handleDialog$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                UserHandleState.Mutable invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = UserHandleStateMachine$handleDialog$1.invokeSuspend$lambda$0(UserHandleAction.ShowDoubleCheckDialog.this, (UserHandleState.Mutable) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserHandleState.Mutable invokeSuspend$lambda$0(UserHandleAction.ShowDoubleCheckDialog $action, UserHandleState.Mutable $this$mutate) {
        return UserHandleState.Mutable.copy$default($this$mutate, $action.getNewHandle(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserHandleState.Mutable invokeSuspend$lambda$1(UserHandleAction.ShowDoubleCheckDialog $action, UserHandleState.Mutable $this$mutate) {
        return $this$mutate.copy($action.getNewHandle(), new DialogState.DoubleCheck($action.getNewHandle()));
    }
}