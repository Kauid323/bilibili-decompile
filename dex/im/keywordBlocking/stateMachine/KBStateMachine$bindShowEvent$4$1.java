package im.keywordBlocking.stateMachine;

import im.keywordBlocking.KBActionDropListShow;
import im.keywordBlocking.KBPageData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lim/keywordBlocking/KBPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBStateMachine$bindShowEvent$4$1", f = "KBStateMachine.kt", i = {0}, l = {184}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
public final class KBStateMachine$bindShowEvent$4$1 extends SuspendLambda implements Function2<KBPageData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KBStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBStateMachine$bindShowEvent$4$1(KBStateMachine kBStateMachine, Continuation<? super KBStateMachine$bindShowEvent$4$1> continuation) {
        super(2, continuation);
        this.this$0 = kBStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kBStateMachine$bindShowEvent$4$1 = new KBStateMachine$bindShowEvent$4$1(this.this$0, continuation);
        kBStateMachine$bindShowEvent$4$1.L$0 = obj;
        return kBStateMachine$bindShowEvent$4$1;
    }

    public final Object invoke(KBPageData kBPageData, Continuation<? super Unit> continuation) {
        return create(kBPageData, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        KBPageData it = (KBPageData) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (it.getDropList() != null) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.label = 1;
                    if (this.this$0.dispatch(KBActionDropListShow.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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