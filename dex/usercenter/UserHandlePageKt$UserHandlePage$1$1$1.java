package usercenter;

import androidx.activity.OnBackPressedDispatcher;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import usercenter.UserHandleSideEffect;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserHandlePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "usercenter.UserHandlePageKt$UserHandlePage$1$1$1", f = "UserHandlePage.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UserHandlePageKt$UserHandlePage$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnBackPressedDispatcher $backHandler;
    final /* synthetic */ Toaster $toaster;
    final /* synthetic */ UserHandleViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHandlePageKt$UserHandlePage$1$1$1(UserHandleViewModel userHandleViewModel, Toaster toaster, OnBackPressedDispatcher onBackPressedDispatcher, Continuation<? super UserHandlePageKt$UserHandlePage$1$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = userHandleViewModel;
        this.$toaster = toaster;
        this.$backHandler = onBackPressedDispatcher;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserHandlePageKt$UserHandlePage$1$1$1(this.$viewModel, this.$toaster, this.$backHandler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow<UserHandleSideEffect> sideEffect = this.$viewModel.getSideEffect();
                final Toaster toaster = this.$toaster;
                final OnBackPressedDispatcher onBackPressedDispatcher = this.$backHandler;
                this.label = 1;
                if (sideEffect.collect(new FlowCollector() { // from class: usercenter.UserHandlePageKt$UserHandlePage$1$1$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((UserHandleSideEffect) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(UserHandleSideEffect it, Continuation<? super Unit> continuation) {
                        if (it instanceof UserHandleSideEffect.ShowToast) {
                            Toaster.-CC.showToast$default(toaster, ((UserHandleSideEffect.ShowToast) it).getMessage(), (ToastDuration) null, 2, (Object) null);
                        } else if (!(it instanceof UserHandleSideEffect.ExitPage)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            onBackPressedDispatcher.onBackPressed();
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
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