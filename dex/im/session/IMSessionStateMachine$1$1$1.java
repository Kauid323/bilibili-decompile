package im.session;

import im.session.service.IMSummaryCacheService;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$1", f = "IMSessionStateMachine.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionStateMachine$1$1$1 extends SuspendLambda implements Function2<IMState, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMSessionStateMachine$1$1$1(this.this$0, continuation);
    }

    public final Object invoke(IMState iMState, Continuation<? super Unit> continuation) {
        return create(iMState, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMSummaryCacheService iMSummaryCacheService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                iMSummaryCacheService = this.this$0.summaryService;
                this.label = 1;
                if (iMSummaryCacheService.initScope$session_debug((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}