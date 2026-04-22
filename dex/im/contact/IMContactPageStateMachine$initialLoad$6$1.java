package im.contact;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.contact.model.ContactsReply;
import im.contact.model.IMContactPageData;
import im.contact.model.IMContactPageDataLensKt;
import im.contact.model.StatusError;
import im.contact.model.StatusSuccess;
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
/* compiled from: IMContactPageStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/contact/model/IMContactPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactPageStateMachine$initialLoad$6$1", f = "IMContactPageStateMachine.kt", i = {0}, l = {74}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class IMContactPageStateMachine$initialLoad$6$1 extends SuspendLambda implements Function2<State<IMContactPageData>, Continuation<? super ChangedState<? extends IMContactPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMContactPageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMContactPageStateMachine$initialLoad$6$1(IMContactPageStateMachine iMContactPageStateMachine, Continuation<? super IMContactPageStateMachine$initialLoad$6$1> continuation) {
        super(2, continuation);
        this.this$0 = iMContactPageStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMContactPageStateMachine$initialLoad$6$1 = new IMContactPageStateMachine$initialLoad$6$1(this.this$0, continuation);
        iMContactPageStateMachine$initialLoad$6$1.L$0 = obj;
        return iMContactPageStateMachine$initialLoad$6$1;
    }

    public final Object invoke(State<IMContactPageData> state, Continuation<? super ChangedState<IMContactPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ContactLoadService contactLoadService;
        Object result;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                contactLoadService = this.this$0.loadService;
                this.L$0 = state;
                this.label = 1;
                Object m3159load0E7RQCE$contact_debug$default = ContactLoadService.m3159load0E7RQCE$contact_debug$default(contactLoadService, null, null, (Continuation) this, 3, null);
                if (m3159load0E7RQCE$contact_debug$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = m3159load0E7RQCE$contact_debug$default;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                result = ((Result) $result).unbox-impl();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final Throwable error = Result.exceptionOrNull-impl(result);
        if (error == null) {
            final ContactsReply data = (ContactsReply) result;
            return state.override(new Function1() { // from class: im.contact.IMContactPageStateMachine$initialLoad$6$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    IMContactPageData invokeSuspend$lambda$0$0;
                    invokeSuspend$lambda$0$0 = IMContactPageStateMachine$initialLoad$6$1.invokeSuspend$lambda$0$0(ContactsReply.this, (IMContactPageData) obj);
                    return invokeSuspend$lambda$0$0;
                }
            });
        }
        return state.mutate(new Function1() { // from class: im.contact.IMContactPageStateMachine$initialLoad$6$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                IMContactPageData invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = IMContactPageStateMachine$initialLoad$6$1.invokeSuspend$lambda$1$0(error, (IMContactPageData) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactPageData invokeSuspend$lambda$0$0(ContactsReply $data, IMContactPageData $this$override) {
        return (IMContactPageData) CopyScopeKt.copy(IMContactPageData.Companion.fromReply($data), new Function1() { // from class: im.contact.IMContactPageStateMachine$initialLoad$6$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0$0;
                invokeSuspend$lambda$0$0$0 = IMContactPageStateMachine$initialLoad$6$1.invokeSuspend$lambda$0$0$0((CopyScope) obj);
                return invokeSuspend$lambda$0$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0$0(CopyScope $this$copy) {
        $this$copy.set(IMContactPageDataLensKt.getStatus(IMContactPageData.Companion), StatusSuccess.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactPageData invokeSuspend$lambda$1$0(Throwable $error, IMContactPageData $this$mutate) {
        return (IMContactPageData) IMContactPageDataLensKt.getStatus(IMContactPageData.Companion).set($this$mutate, new StatusError($error));
    }
}