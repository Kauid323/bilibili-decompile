package im.keywordBlocking.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.keywordBlocking.KBPageData;
import im.keywordBlocking.KBPageDataLensKt;
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
/* compiled from: KBStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/keywordBlocking/KBPageData;", "it", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBStateMachine$initialLoad$10$1", f = "KBStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KBStateMachine$initialLoad$10$1 extends SuspendLambda implements Function2<State<KBPageData>, Continuation<? super ChangedState<? extends KBPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KBStateMachine$initialLoad$10$1(Continuation<? super KBStateMachine$initialLoad$10$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kBStateMachine$initialLoad$10$1 = new KBStateMachine$initialLoad$10$1(continuation);
        kBStateMachine$initialLoad$10$1.L$0 = obj;
        return kBStateMachine$initialLoad$10$1;
    }

    public final Object invoke(State<KBPageData> state, Continuation<? super ChangedState<KBPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State it = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return it.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$initialLoad$10$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        KBPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = KBStateMachine$initialLoad$10$1.invokeSuspend$lambda$0((KBPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData invokeSuspend$lambda$0(KBPageData $this$mutate) {
        return (KBPageData) KBPageDataLensKt.getFirstLoad(KBPageData.Companion).set($this$mutate, false);
    }
}