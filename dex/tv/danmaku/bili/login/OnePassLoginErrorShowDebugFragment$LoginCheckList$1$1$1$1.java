package tv.danmaku.bili.login;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnePassLoginErrorShowDebugFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/bili/login/LoginCheckActionHandler;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$LoginCheckList$1$1$1$1", f = "OnePassLoginErrorShowDebugFragment.kt", i = {}, l = {BR.buttonWidths}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OnePassLoginErrorShowDebugFragment$LoginCheckList$1$1$1$1 extends SuspendLambda implements Function2<LoginCheckActionHandler, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OnePassLoginErrorShowDebugFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePassLoginErrorShowDebugFragment$LoginCheckList$1$1$1$1(OnePassLoginErrorShowDebugFragment onePassLoginErrorShowDebugFragment, Continuation<? super OnePassLoginErrorShowDebugFragment$LoginCheckList$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = onePassLoginErrorShowDebugFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnePassLoginErrorShowDebugFragment$LoginCheckList$1$1$1$1(this.this$0, continuation);
    }

    public final Object invoke(LoginCheckActionHandler loginCheckActionHandler, Continuation<? super Unit> continuation) {
        return create(loginCheckActionHandler, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OnePassLoginCheckViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                viewModel = this.this$0.getViewModel();
                this.label = 1;
                if (viewModel.load((Continuation) this) == coroutine_suspended) {
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