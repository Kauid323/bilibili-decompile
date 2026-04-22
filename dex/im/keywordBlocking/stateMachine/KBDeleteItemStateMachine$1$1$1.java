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
/* compiled from: KBDeleteItemStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/keywordBlocking/stateMachine/KBDeleteItemStatus;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Lim/keywordBlocking/stateMachine/KBDeleteItemStatusIdle;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBDeleteItemStateMachine$1$1$1", f = "KBDeleteItemStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KBDeleteItemStateMachine$1$1$1 extends SuspendLambda implements Function2<State<KBDeleteItemStatusIdle>, Continuation<? super ChangedState<? extends KBDeleteItemStatus>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KBDeleteItemStateMachine$1$1$1(Continuation<? super KBDeleteItemStateMachine$1$1$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kBDeleteItemStateMachine$1$1$1 = new KBDeleteItemStateMachine$1$1$1(continuation);
        kBDeleteItemStateMachine$1$1$1.L$0 = obj;
        return kBDeleteItemStateMachine$1$1$1;
    }

    public final Object invoke(State<KBDeleteItemStatusIdle> state, Continuation<? super ChangedState<? extends KBDeleteItemStatus>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State it = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return it.override(new Function1() { // from class: im.keywordBlocking.stateMachine.KBDeleteItemStateMachine$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        KBDeleteItemStatusLoading invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = KBDeleteItemStateMachine$1$1$1.invokeSuspend$lambda$0((KBDeleteItemStatusIdle) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBDeleteItemStatusLoading invokeSuspend$lambda$0(KBDeleteItemStatusIdle $this$override) {
        return new KBDeleteItemStatusLoading($this$override.getItem());
    }
}