package im.session;

import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.session.model.IMSessionCard;
import im.session.service.IMSessionUpdateService;
import im.session.service.SessionRemovedFromTypeException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", "event", "Lim/session/IMActionRefreshSession;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$updateBlock$3", f = "IMSessionStateMachine.kt", i = {0, 0}, l = {558}, m = "invokeSuspend", n = {"event", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class IMSessionStateMachine$updateBlock$3 extends SuspendLambda implements Function3<IMActionRefreshSession, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$updateBlock$3(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$updateBlock$3> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionRefreshSession iMActionRefreshSession, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$updateBlock$3 iMSessionStateMachine$updateBlock$3 = new IMSessionStateMachine$updateBlock$3(this.this$0, continuation);
        iMSessionStateMachine$updateBlock$3.L$0 = iMActionRefreshSession;
        iMSessionStateMachine$updateBlock$3.L$1 = state;
        return iMSessionStateMachine$updateBlock$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMSessionUpdateService iMSessionUpdateService;
        KSessionPageType kSessionPageType;
        Object obj;
        ChangedState removeSession;
        ChangedState mutate;
        IMActionRefreshSession event = (IMActionRefreshSession) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                iMSessionUpdateService = this.this$0.updateService;
                KSessionId sessionId = event.getSessionId();
                kSessionPageType = this.this$0.pageType;
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.label = 1;
                Object m3366updateBWLJW6A = iMSessionUpdateService.m3366updateBWLJW6A(sessionId, kSessionPageType, event.getKSessionFilterType(), (Continuation) this);
                if (m3366updateBWLJW6A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = m3366updateBWLJW6A;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = ((Result) $result).unbox-impl();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        IMSessionStateMachine iMSessionStateMachine = this.this$0;
        Throwable it = Result.exceptionOrNull-impl(obj);
        if (it == null) {
            final IMSessionCard it2 = (IMSessionCard) obj;
            if (it2 == null || (mutate = state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$updateBlock$3$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    IMState invokeSuspend$lambda$0$0$0;
                    invokeSuspend$lambda$0$0$0 = IMSessionStateMachine$updateBlock$3.invokeSuspend$lambda$0$0$0(IMSessionCard.this, (IMState) obj2);
                    return invokeSuspend$lambda$0$0$0;
                }
            })) == null) {
                return state.noChange();
            }
            return mutate;
        } else if ((it instanceof SessionRemovedFromTypeException) && Intrinsics.areEqual(((SessionRemovedFromTypeException) it).getPageType(), ((IMState) state.getSnapshot()).getPageType())) {
            removeSession = iMSessionStateMachine.removeSession(state, ((SessionRemovedFromTypeException) it).getSessionId());
            return removeSession;
        } else {
            return state.noChange();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$0$0$0(IMSessionCard $it, IMState $this$mutate) {
        IMState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : $this$mutate.getData().update$session_debug($it), (r18 & 4) != 0 ? $this$mutate.toast : null, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }
}