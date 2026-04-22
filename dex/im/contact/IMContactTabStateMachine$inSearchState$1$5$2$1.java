package im.contact;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import im.contact.model.IMContactSearchingTabData;
import im.contact.service.ContactSearchService;
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
/* compiled from: IMContactTabStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lim/contact/model/IMContactSearchingTabData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactTabStateMachine$inSearchState$1$5$2$1", f = "IMContactTabStateMachine.kt", i = {0}, l = {145}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class IMContactTabStateMachine$inSearchState$1$5$2$1 extends SuspendLambda implements Function2<IMContactSearchingTabData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMContactTabStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMContactTabStateMachine$inSearchState$1$5$2$1(IMContactTabStateMachine iMContactTabStateMachine, Continuation<? super IMContactTabStateMachine$inSearchState$1$5$2$1> continuation) {
        super(2, continuation);
        this.this$0 = iMContactTabStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMContactTabStateMachine$inSearchState$1$5$2$1 = new IMContactTabStateMachine$inSearchState$1$5$2$1(this.this$0, continuation);
        iMContactTabStateMachine$inSearchState$1$5$2$1.L$0 = obj;
        return iMContactTabStateMachine$inSearchState$1$5$2$1;
    }

    public final Object invoke(IMContactSearchingTabData iMContactSearchingTabData, Continuation<? super Unit> continuation) {
        return create(iMContactSearchingTabData, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ContactSearchService contactSearchService;
        KContactTabType kContactTabType;
        IMContactSearchingTabData state = (IMContactSearchingTabData) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                contactSearchService = this.this$0.searchService;
                String searchWord = state.getSearchWord();
                kContactTabType = this.this$0.currentTab;
                this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                if (ContactSearchService.load$contact_debug$default(contactSearchService, searchWord, kContactTabType, null, (Continuation) this, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
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