package im.keywordBlocking.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.keywordBlocking.KBActionDeleteCancel;
import im.keywordBlocking.KBPageData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/keywordBlocking/KBPageData;", "<unused var>", "Lim/keywordBlocking/KBActionDeleteCancel;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBStateMachine$deleteKeyword$2$3", f = "KBStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KBStateMachine$deleteKeyword$2$3 extends SuspendLambda implements Function3<KBActionDeleteCancel, State<KBPageData>, Continuation<? super ChangedState<? extends KBPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KBStateMachine$deleteKeyword$2$3(Continuation<? super KBStateMachine$deleteKeyword$2$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(KBActionDeleteCancel kBActionDeleteCancel, State<KBPageData> state, Continuation<? super ChangedState<KBPageData>> continuation) {
        KBStateMachine$deleteKeyword$2$3 kBStateMachine$deleteKeyword$2$3 = new KBStateMachine$deleteKeyword$2$3(continuation);
        kBStateMachine$deleteKeyword$2$3.L$0 = state;
        return kBStateMachine$deleteKeyword$2$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$deleteKeyword$2$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        KBPageData copy$default;
                        copy$default = KBPageData.copy$default((KBPageData) obj, null, null, 0, null, 0, null, null, null, null, false, 767, null);
                        return copy$default;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}