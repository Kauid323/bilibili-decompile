package usercenter;

import androidx.compose.runtime.MutableState;
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
import kotlinx.coroutines.DelayKt;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import usercenter.UserHandleAction;
import usercenter.UserHandleState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserHandlePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "usercenter.UserHandlePageKt$UserHandlePage$1$2$1$1$1$1", f = "UserHandlePage.kt", i = {}, l = {AddCustomDanmaku.TYPE_LIVE_DANMU_V2, 113, 116}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UserHandlePageKt$UserHandlePage$1$2$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $text$delegate;
    final /* synthetic */ UserHandleViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHandlePageKt$UserHandlePage$1$2$1$1$1$1(UserHandleViewModel userHandleViewModel, MutableState<String> mutableState, Continuation<? super UserHandlePageKt$UserHandlePage$1$2$1$1$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = userHandleViewModel;
        this.$text$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserHandlePageKt$UserHandlePage$1$2$1$1$1$1(this.$viewModel, this.$text$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        UserHandleState userHandleState;
        String UserHandlePage$lambda$2$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(300L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                userHandleState = (UserHandleState) this.$viewModel.getState().getValue();
                if (!(userHandleState instanceof UserHandleState.Immutable)) {
                    this.label = 2;
                    if (this.$viewModel.dispatch(UserHandleAction.ShowNoEditPermissionToast.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(userHandleState instanceof UserHandleState.Mutable)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    UserHandleViewModel userHandleViewModel = this.$viewModel;
                    UserHandlePage$lambda$2$1 = UserHandlePageKt.UserHandlePage$lambda$2$1(this.$text$delegate);
                    this.label = 3;
                    if (userHandleViewModel.dispatch(new UserHandleAction.ShowDoubleCheckDialog(UserHandlePage$lambda$2$1), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                userHandleState = (UserHandleState) this.$viewModel.getState().getValue();
                if (!(userHandleState instanceof UserHandleState.Immutable)) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}