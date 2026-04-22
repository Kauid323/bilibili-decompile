package im.contact;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.contact.model.IMContactSearchingTabData;
import im.contact.model.IMContactSearchingTabDataLensKt;
import im.contact.model.IMContactTab;
import im.contact.model.StatusError;
import im.contact.service.SearchResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMContactTabStateMachine.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/contact/model/IMContactTab;", "result", "Lkotlin/Result;", "Lim/contact/service/SearchResult;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lim/contact/model/IMContactSearchingTabData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactTabStateMachine$inSearchState$1$10", f = "IMContactTabStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMContactTabStateMachine$inSearchState$1$10 extends SuspendLambda implements Function3<Result<? extends SearchResult>, State<IMContactSearchingTabData>, Continuation<? super ChangedState<? extends IMContactTab>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ IMContactTabStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMContactTabStateMachine$inSearchState$1$10(IMContactTabStateMachine iMContactTabStateMachine, Continuation<? super IMContactTabStateMachine$inSearchState$1$10> continuation) {
        super(3, continuation);
        this.this$0 = iMContactTabStateMachine;
    }

    public final Object invoke(Object obj, State<IMContactSearchingTabData> state, Continuation<? super ChangedState<? extends IMContactTab>> continuation) {
        IMContactTabStateMachine$inSearchState$1$10 iMContactTabStateMachine$inSearchState$1$10 = new IMContactTabStateMachine$inSearchState$1$10(this.this$0, continuation);
        iMContactTabStateMachine$inSearchState$1$10.L$0 = obj;
        iMContactTabStateMachine$inSearchState$1$10.L$1 = state;
        return iMContactTabStateMachine$inSearchState$1$10.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Result) obj).unbox-impl(), (State) obj2, (Continuation) obj3);
    }

    public final Object invokeSuspend(Object $result) {
        ChangedState updateFromReply;
        Object result = this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMContactTabStateMachine iMContactTabStateMachine = this.this$0;
                final Throwable error = Result.exceptionOrNull-impl(result);
                if (error == null) {
                    SearchResult it = (SearchResult) result;
                    if (Intrinsics.areEqual(it.getSearchWord(), ((IMContactSearchingTabData) state.getSnapshot()).getSearchWord())) {
                        updateFromReply = iMContactTabStateMachine.updateFromReply(state, it.getReply());
                        return updateFromReply;
                    }
                    return state.noChange();
                }
                return state.mutate(new Function1() { // from class: im.contact.IMContactTabStateMachine$inSearchState$1$10$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMContactSearchingTabData invokeSuspend$lambda$1$0;
                        invokeSuspend$lambda$1$0 = IMContactTabStateMachine$inSearchState$1$10.invokeSuspend$lambda$1$0(error, (IMContactSearchingTabData) obj);
                        return invokeSuspend$lambda$1$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactSearchingTabData invokeSuspend$lambda$1$0(Throwable $error, IMContactSearchingTabData $this$mutate) {
        return (IMContactSearchingTabData) IMContactSearchingTabDataLensKt.getStatus(IMContactSearchingTabData.Companion).set($this$mutate, new StatusError($error));
    }
}