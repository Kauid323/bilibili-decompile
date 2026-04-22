package im.contact;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.contact.model.IMContactActionSearch;
import im.contact.model.IMContactSearchingTabData;
import im.contact.model.IMContactSearchingTabDataLensKt;
import im.contact.model.IMContactTab;
import im.contact.model.StatusIdle;
import im.contact.model.StatusLoading;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMContactTabStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/contact/model/IMContactTab;", AuthActivity.ACTION_KEY, "Lim/contact/model/IMContactActionSearch;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lim/contact/model/IMContactSearchingTabData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactTabStateMachine$inSearchState$1$1", f = "IMContactTabStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMContactTabStateMachine$inSearchState$1$1 extends SuspendLambda implements Function3<IMContactActionSearch, State<IMContactSearchingTabData>, Continuation<? super ChangedState<? extends IMContactTab>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMContactTabStateMachine$inSearchState$1$1(Continuation<? super IMContactTabStateMachine$inSearchState$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMContactActionSearch iMContactActionSearch, State<IMContactSearchingTabData> state, Continuation<? super ChangedState<? extends IMContactTab>> continuation) {
        IMContactTabStateMachine$inSearchState$1$1 iMContactTabStateMachine$inSearchState$1$1 = new IMContactTabStateMachine$inSearchState$1$1(continuation);
        iMContactTabStateMachine$inSearchState$1$1.L$0 = iMContactActionSearch;
        iMContactTabStateMachine$inSearchState$1$1.L$1 = state;
        return iMContactTabStateMachine$inSearchState$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final IMContactActionSearch action = (IMContactActionSearch) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: im.contact.IMContactTabStateMachine$inSearchState$1$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        IMContactSearchingTabData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IMContactTabStateMachine$inSearchState$1$1.invokeSuspend$lambda$0(IMContactActionSearch.this, (IMContactSearchingTabData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactSearchingTabData invokeSuspend$lambda$0(final IMContactActionSearch $action, IMContactSearchingTabData $this$mutate) {
        return (IMContactSearchingTabData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: im.contact.IMContactTabStateMachine$inSearchState$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = IMContactTabStateMachine$inSearchState$1$1.invokeSuspend$lambda$0$0(IMContactActionSearch.this, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(IMContactActionSearch $action, CopyScope $this$copy) {
        $this$copy.set(IMContactSearchingTabDataLensKt.getSearchWord(IMContactSearchingTabData.Companion), $action.getSearchWord());
        if (!StringsKt.isBlank($action.getSearchWord())) {
            $this$copy.set(IMContactSearchingTabDataLensKt.getStatus(IMContactSearchingTabData.Companion), StatusLoading.INSTANCE);
        } else {
            $this$copy.set(IMContactSearchingTabDataLensKt.getStatus(IMContactSearchingTabData.Companion), StatusIdle.INSTANCE);
        }
        $this$copy.set(IMContactSearchingTabDataLensKt.getSearchResult(IMContactSearchingTabData.Companion), CollectionsKt.emptyList());
        $this$copy.set(IMContactSearchingTabDataLensKt.getPagingParams(IMContactSearchingTabData.Companion), (Object) null);
        return Unit.INSTANCE;
    }
}