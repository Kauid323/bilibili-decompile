package usercenter;

import bili.resource.profile.ProfileRes;
import bili.resource.profile.String0_commonMainKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import usercenter.UpdateHandleResult;
import usercenter.UserHandleAction;
import usercenter.UserHandleSideEffect;
import usercenter.UserHandleState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserHandleStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lusercenter/UserHandleState;", "action", "Lusercenter/UserHandleAction$Submit;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lusercenter/UserHandleState$Mutable;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "usercenter.UserHandleStateMachine$handleMutableState$1", f = "UserHandleStateMachine.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8}, l = {154, 159, 165, 178, 185, 192, 196, 205, 209}, m = "invokeSuspend", n = {"action", "state", "action", "state", "action", "state", "result", "action", "state", "result", "action", "state", "result", "suggestions", "action", "state", "result", "action", "state", "result", "it", "$i$a$-let-UserHandleStateMachine$handleMutableState$1$2", "action", "state", "e", "it", "$i$a$-let-UserHandleStateMachine$handleMutableState$1$3", "action", "state", "e"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2"}, v = 1)
public final class UserHandleStateMachine$handleMutableState$1 extends SuspendLambda implements Function3<UserHandleAction.Submit, State<UserHandleState.Mutable>, Continuation<? super ChangedState<? extends UserHandleState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ UserHandleStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHandleStateMachine$handleMutableState$1(UserHandleStateMachine userHandleStateMachine, Continuation<? super UserHandleStateMachine$handleMutableState$1> continuation) {
        super(3, continuation);
        this.this$0 = userHandleStateMachine;
    }

    public final Object invoke(UserHandleAction.Submit submit, State<UserHandleState.Mutable> state, Continuation<? super ChangedState<? extends UserHandleState>> continuation) {
        UserHandleStateMachine$handleMutableState$1 userHandleStateMachine$handleMutableState$1 = new UserHandleStateMachine$handleMutableState$1(this.this$0, continuation);
        userHandleStateMachine$handleMutableState$1.L$0 = submit;
        userHandleStateMachine$handleMutableState$1.L$1 = state;
        return userHandleStateMachine$handleMutableState$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4 A[Catch: all -> 0x0070, TRY_ENTER, TryCatch #0 {all -> 0x0070, blocks: (B:9:0x003d, B:12:0x0046, B:60:0x01b9, B:68:0x01d5, B:15:0x0054, B:18:0x005d, B:21:0x0066, B:22:0x006b, B:34:0x00aa, B:37:0x00b4, B:41:0x0111, B:43:0x0115, B:45:0x0123, B:51:0x0155, B:56:0x0193, B:74:0x0205, B:75:0x020a, B:31:0x008f), top: B:90:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0111 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:9:0x003d, B:12:0x0046, B:60:0x01b9, B:68:0x01d5, B:15:0x0054, B:18:0x005d, B:21:0x0066, B:22:0x006b, B:34:0x00aa, B:37:0x00b4, B:41:0x0111, B:43:0x0115, B:45:0x0123, B:51:0x0155, B:56:0x0193, B:74:0x0205, B:75:0x020a, B:31:0x008f), top: B:90:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d5 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:9:0x003d, B:12:0x0046, B:60:0x01b9, B:68:0x01d5, B:15:0x0054, B:18:0x005d, B:21:0x0066, B:22:0x006b, B:34:0x00aa, B:37:0x00b4, B:41:0x0111, B:43:0x0115, B:45:0x0123, B:51:0x0155, B:56:0x0193, B:74:0x0205, B:75:0x020a, B:31:0x008f), top: B:90:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Throwable e;
        MutableSharedFlow mutableSharedFlow;
        Object updateHandle;
        UpdateHandleResult result;
        UpdateHandleResult result2;
        String it;
        MutableSharedFlow mutableSharedFlow2;
        UserHandleAction.Submit action = (UserHandleAction.Submit) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        try {
        } catch (Throwable th) {
            e = th;
            String it2 = e.getMessage();
            if (it2 != null) {
                mutableSharedFlow = this.this$0.sideEffect;
                UserHandleSideEffect.ShowToast showToast = new UserHandleSideEffect.ShowToast(it2);
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(e);
                this.L$3 = SpillingKt.nullOutSpilledVariable(it2);
                this.I$0 = 0;
                this.label = 8;
                if (mutableSharedFlow.emit(showToast, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = action;
                this.L$1 = state;
                this.label = 1;
                if (this.this$0.dispatch(UserHandleAction.ShowLoadingDialog.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.label = 2;
                updateHandle = UserHandleApiService.INSTANCE.updateHandle(action.getNewHandle(), (Continuation) this);
                if (updateHandle == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = (UpdateHandleResult) updateHandle;
                if (result instanceof UpdateHandleResult.Success) {
                    KLog_androidKt.getKLog().i("UserHandleStateMachine", "更新用户名成功: " + ((UpdateHandleResult.Success) result).getNewHandle());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(result);
                    this.label = 3;
                    if (this.this$0.dispatch(new UserHandleAction.SubmitSuccess(ProfileRes.INSTANCE.getString(String0_commonMainKt.getProfile_global_string_73(ProfileRes.INSTANCE.getString())), ((UpdateHandleResult.Success) result).getNewHandle()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(result instanceof UpdateHandleResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    long code = ((UpdateHandleResult.Failure) result).getCode();
                    if (code == 40016) {
                        KLog_androidKt.getKLog().i("UserHandleStateMachine", "需要绑定手机号才能修改用户名");
                        this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                        this.L$1 = state;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(result);
                        this.label = 4;
                        if (this.this$0.dispatch(UserHandleAction.ShowBindPhoneDialog.INSTANCE, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (code == 102009) {
                        KLog_androidKt.getKLog().i("UserHandleStateMachine", "用户名已被占用，显示推荐用户名");
                        List suggestions = ((UpdateHandleResult.Failure) result).getOptionHandleList();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                        this.L$1 = state;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(result);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(suggestions);
                        this.label = 5;
                        return this.this$0.dispatch(new UserHandleAction.ShowRecommendDialog(suggestions), (Continuation) this) == coroutine_suspended ? coroutine_suspended : state.noChange();
                    } else {
                        KLog_androidKt.getKLog().i("UserHandleStateMachine", "更新用户名失败");
                        this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                        this.L$1 = state;
                        this.L$2 = result;
                        this.label = 6;
                        if (this.this$0.dispatch(UserHandleAction.DismissDialog.INSTANCE, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        result2 = result;
                        it = ((UpdateHandleResult.Failure) result2).getMessage();
                        if (it.length() > 0) {
                            z = false;
                        }
                        if (z) {
                            it = null;
                        }
                        if (it != null) {
                            mutableSharedFlow2 = this.this$0.sideEffect;
                            UserHandleSideEffect.ShowToast showToast2 = new UserHandleSideEffect.ShowToast(it);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(it);
                            this.I$0 = 0;
                            this.label = 7;
                            if (mutableSharedFlow2.emit(showToast2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.label = 2;
                updateHandle = UserHandleApiService.INSTANCE.updateHandle(action.getNewHandle(), (Continuation) this);
                if (updateHandle == coroutine_suspended) {
                }
                result = (UpdateHandleResult) updateHandle;
                if (result instanceof UpdateHandleResult.Success) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                updateHandle = $result;
                result = (UpdateHandleResult) updateHandle;
                if (result instanceof UpdateHandleResult.Success) {
                }
                break;
            case 3:
                UpdateHandleResult updateHandleResult = (UpdateHandleResult) this.L$2;
                ResultKt.throwOnFailure($result);
            case 4:
                UpdateHandleResult updateHandleResult2 = (UpdateHandleResult) this.L$2;
                ResultKt.throwOnFailure($result);
            case 5:
                List list = (List) this.L$3;
                UpdateHandleResult updateHandleResult3 = (UpdateHandleResult) this.L$2;
                ResultKt.throwOnFailure($result);
            case 6:
                UpdateHandleResult result3 = (UpdateHandleResult) this.L$2;
                ResultKt.throwOnFailure($result);
                result2 = result3;
                it = ((UpdateHandleResult.Failure) result2).getMessage();
                if (it.length() > 0) {
                }
                if (z) {
                }
                if (it != null) {
                }
            case 7:
                int i = this.I$0;
                String str = (String) this.L$3;
                UpdateHandleResult updateHandleResult4 = (UpdateHandleResult) this.L$2;
                ResultKt.throwOnFailure($result);
            case 8:
                int i2 = this.I$0;
                String str2 = (String) this.L$3;
                e = (Throwable) this.L$2;
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(e);
                this.L$3 = null;
                this.label = 9;
                if (this.this$0.dispatch(UserHandleAction.DismissDialog.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            case 9:
                Throwable th2 = (Throwable) this.L$2;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}