package im.keywordBlocking.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBAddItemStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/keywordBlocking/stateMachine/KBAddItemStatus;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Lim/keywordBlocking/stateMachine/KBAddItemStatusIdle;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBAddItemStateMachine$1$1$4$1", f = "KBAddItemStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KBAddItemStateMachine$1$1$4$1 extends SuspendLambda implements Function2<State<KBAddItemStatusIdle>, Continuation<? super ChangedState<? extends KBAddItemStatus>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KBAddItemStateMachine$1$1$4$1(Continuation<? super KBAddItemStateMachine$1$1$4$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kBAddItemStateMachine$1$1$4$1 = new KBAddItemStateMachine$1$1$4$1(continuation);
        kBAddItemStateMachine$1$1$4$1.L$0 = obj;
        return kBAddItemStateMachine$1$1$4$1;
    }

    public final Object invoke(State<KBAddItemStatusIdle> state, Continuation<? super ChangedState<? extends KBAddItemStatus>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State it = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return it.override(new Function1() { // from class: im.keywordBlocking.stateMachine.KBAddItemStateMachine$1$1$4$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        KBAddItemStatusCancel invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = KBAddItemStateMachine$1$1$4$1.invokeSuspend$lambda$0((KBAddItemStatusIdle) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBAddItemStatusCancel invokeSuspend$lambda$0(KBAddItemStatusIdle $this$override) {
        return new KBAddItemStatusCancel($this$override.getText(), new IllegalArgumentException("添加失败，屏蔽词重复"));
    }
}