package im.keywordBlocking.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.keywordBlocking.log.LogTagKt;
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
/* compiled from: KBAddItemStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/keywordBlocking/stateMachine/KBAddItemStatus;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Lim/keywordBlocking/stateMachine/KBAddItemStatusLoading;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBAddItemStateMachine$1$2$1", f = "KBAddItemStateMachine.kt", i = {0}, l = {88}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
public final class KBAddItemStateMachine$1$2$1 extends SuspendLambda implements Function2<State<KBAddItemStatusLoading>, Continuation<? super ChangedState<? extends KBAddItemStatus>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KBAddItemStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBAddItemStateMachine$1$2$1(KBAddItemStateMachine kBAddItemStateMachine, Continuation<? super KBAddItemStateMachine$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = kBAddItemStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kBAddItemStateMachine$1$2$1 = new KBAddItemStateMachine$1$2$1(this.this$0, continuation);
        kBAddItemStateMachine$1$2$1.L$0 = obj;
        return kBAddItemStateMachine$1$2$1;
    }

    public final Object invoke(State<KBAddItemStatusLoading> state, Continuation<? super ChangedState<? extends KBAddItemStatus>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        Object request;
        State it = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion companion = IMLog.Companion;
                str = this.this$0.text;
                companion.i(LogTagKt.KB_LOG_TAG, "开始新增关键词: " + str);
                this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                this.label = 1;
                request = this.this$0.request(it, (Continuation) this);
                if (request == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return request;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}