package im.contact;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.contact.model.IMContactActionEnterSearch;
import im.contact.model.IMContactSearchingTabData;
import im.contact.model.IMContactTab;
import im.contact.model.IMContactTabData;
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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/contact/model/IMContactTab;", "<unused var>", "Lim/contact/model/IMContactActionEnterSearch;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lim/contact/model/IMContactTabData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactTabStateMachine$inCommonState$1$11", f = "IMContactTabStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMContactTabStateMachine$inCommonState$1$11 extends SuspendLambda implements Function3<IMContactActionEnterSearch, State<IMContactTabData>, Continuation<? super ChangedState<? extends IMContactTab>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMContactTabStateMachine$inCommonState$1$11(Continuation<? super IMContactTabStateMachine$inCommonState$1$11> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMContactActionEnterSearch iMContactActionEnterSearch, State<IMContactTabData> state, Continuation<? super ChangedState<? extends IMContactTab>> continuation) {
        IMContactTabStateMachine$inCommonState$1$11 iMContactTabStateMachine$inCommonState$1$11 = new IMContactTabStateMachine$inCommonState$1$11(continuation);
        iMContactTabStateMachine$inCommonState$1$11.L$0 = state;
        return iMContactTabStateMachine$inCommonState$1$11.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: im.contact.IMContactTabStateMachine$inCommonState$1$11$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMContactSearchingTabData searchData;
                        searchData = ((IMContactTabData) obj).toSearchData();
                        return searchData;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}