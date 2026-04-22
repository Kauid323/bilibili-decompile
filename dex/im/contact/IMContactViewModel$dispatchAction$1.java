package im.contact;

import host.R;
import im.contact.model.IMContactAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMContactViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactViewModel$dispatchAction$1", f = "IMContactViewModel.kt", i = {}, l = {R.styleable.CameraView_cameraVideoSizeSmallest}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMContactViewModel$dispatchAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMContactAction $action;
    int label;
    final /* synthetic */ IMContactViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMContactViewModel$dispatchAction$1(IMContactViewModel iMContactViewModel, IMContactAction iMContactAction, Continuation<? super IMContactViewModel$dispatchAction$1> continuation) {
        super(2, continuation);
        this.this$0 = iMContactViewModel;
        this.$action = iMContactAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMContactViewModel$dispatchAction$1(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMContactPageStateMachine iMContactPageStateMachine;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                iMContactPageStateMachine = this.this$0.stateMachine;
                this.label = 1;
                if (iMContactPageStateMachine.dispatch(this.$action, (Continuation) this) == coroutine_suspended) {
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