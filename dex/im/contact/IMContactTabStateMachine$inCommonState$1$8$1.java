package im.contact;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.contact.model.IMContactActionLoadMore;
import im.contact.model.IMContactTab;
import im.contact.model.IMContactTabData;
import im.contact.model.IMContactTabDataLensKt;
import im.contact.model.StatusLoadingMore;
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
/* compiled from: IMContactTabStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/contact/model/IMContactTab;", "<unused var>", "Lim/contact/model/IMContactActionLoadMore;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lim/contact/model/IMContactTabData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactTabStateMachine$inCommonState$1$8$1", f = "IMContactTabStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMContactTabStateMachine$inCommonState$1$8$1 extends SuspendLambda implements Function3<IMContactActionLoadMore, State<IMContactTabData>, Continuation<? super ChangedState<? extends IMContactTab>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMContactTabStateMachine$inCommonState$1$8$1(Continuation<? super IMContactTabStateMachine$inCommonState$1$8$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMContactActionLoadMore iMContactActionLoadMore, State<IMContactTabData> state, Continuation<? super ChangedState<? extends IMContactTab>> continuation) {
        IMContactTabStateMachine$inCommonState$1$8$1 iMContactTabStateMachine$inCommonState$1$8$1 = new IMContactTabStateMachine$inCommonState$1$8$1(continuation);
        iMContactTabStateMachine$inCommonState$1$8$1.L$0 = state;
        return iMContactTabStateMachine$inCommonState$1$8$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: im.contact.IMContactTabStateMachine$inCommonState$1$8$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMContactTabData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IMContactTabStateMachine$inCommonState$1$8$1.invokeSuspend$lambda$0((IMContactTabData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactTabData invokeSuspend$lambda$0(IMContactTabData $this$mutate) {
        return (IMContactTabData) IMContactTabDataLensKt.getStatus(IMContactTabData.Companion).set($this$mutate, StatusLoadingMore.INSTANCE);
    }
}