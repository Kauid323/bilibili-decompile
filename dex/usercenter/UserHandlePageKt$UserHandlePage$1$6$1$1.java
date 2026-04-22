package usercenter;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import usercenter.UserHandleAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserHandlePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "usercenter.UserHandlePageKt$UserHandlePage$1$6$1$1", f = "UserHandlePage.kt", i = {1, 1}, l = {169, 171}, m = "invokeSuspend", n = {"it", "$i$a$-let-UserHandlePageKt$UserHandlePage$1$6$1$1$1"}, s = {"L$0", "I$0"}, v = 1)
public final class UserHandlePageKt$UserHandlePage$1$6$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $selectedAlias;
    final /* synthetic */ UserHandleViewModel $viewModel;
    int I$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHandlePageKt$UserHandlePage$1$6$1$1(UserHandleViewModel userHandleViewModel, String str, Continuation<? super UserHandlePageKt$UserHandlePage$1$6$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = userHandleViewModel;
        this.$selectedAlias = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserHandlePageKt$UserHandlePage$1$6$1$1(this.$viewModel, this.$selectedAlias, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        String it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$viewModel.dispatch(UserHandleAction.DismissDialog.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = this.$selectedAlias;
                if (it != null) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.I$0 = 0;
                    this.label = 2;
                    if (this.$viewModel.dispatch(new UserHandleAction.Submit(it), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                it = this.$selectedAlias;
                if (it != null) {
                }
                return Unit.INSTANCE;
            case 2:
                int i = this.I$0;
                String str = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}