package im.contact;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.contact.model.ContactsReply;
import im.contact.model.IMContactTab;
import im.contact.model.IMContactTabData;
import im.contact.model.IMContactTabDataLensKt;
import im.contact.model.StatusError;
import im.contact.service.ContactLoadService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMContactTabStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/contact/model/IMContactTab;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lim/contact/model/IMContactTabData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactTabStateMachine$inCommonState$1$10$1", f = "IMContactTabStateMachine.kt", i = {0}, l = {98}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class IMContactTabStateMachine$inCommonState$1$10$1 extends SuspendLambda implements Function2<State<IMContactTabData>, Continuation<? super ChangedState<? extends IMContactTab>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMContactTabStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMContactTabStateMachine$inCommonState$1$10$1(IMContactTabStateMachine iMContactTabStateMachine, Continuation<? super IMContactTabStateMachine$inCommonState$1$10$1> continuation) {
        super(2, continuation);
        this.this$0 = iMContactTabStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMContactTabStateMachine$inCommonState$1$10$1 = new IMContactTabStateMachine$inCommonState$1$10$1(this.this$0, continuation);
        iMContactTabStateMachine$inCommonState$1$10$1.L$0 = obj;
        return iMContactTabStateMachine$inCommonState$1$10$1;
    }

    public final Object invoke(State<IMContactTabData> state, Continuation<? super ChangedState<? extends IMContactTab>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ContactLoadService contactLoadService;
        KContactTabType kContactTabType;
        Object loadResult;
        ChangedState updateFromReply;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                contactLoadService = this.this$0.loadService;
                kContactTabType = this.this$0.currentTab;
                this.L$0 = state;
                this.label = 1;
                Object m3160load0E7RQCE$contact_debug = contactLoadService.m3160load0E7RQCE$contact_debug(kContactTabType, ((IMContactTabData) state.getSnapshot()).getPagingParams$contact_debug(), (Continuation) this);
                if (m3160load0E7RQCE$contact_debug == coroutine_suspended) {
                    return coroutine_suspended;
                }
                loadResult = m3160load0E7RQCE$contact_debug;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                loadResult = ((Result) $result).unbox-impl();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        IMContactTabStateMachine iMContactTabStateMachine = this.this$0;
        final Throwable error = Result.exceptionOrNull-impl(loadResult);
        if (error == null) {
            ContactsReply it = (ContactsReply) loadResult;
            updateFromReply = iMContactTabStateMachine.updateFromReply(state, it);
            return updateFromReply;
        }
        return state.mutate(new Function1() { // from class: im.contact.IMContactTabStateMachine$inCommonState$1$10$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                IMContactTabData invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = IMContactTabStateMachine$inCommonState$1$10$1.invokeSuspend$lambda$1$0(error, (IMContactTabData) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactTabData invokeSuspend$lambda$1$0(Throwable $error, IMContactTabData $this$mutate) {
        return (IMContactTabData) IMContactTabDataLensKt.getStatus(IMContactTabData.Companion).set($this$mutate, new StatusError($error));
    }
}