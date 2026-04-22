package im.session;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.session.model.IMSessionCard;
import im.session.service.PinResult;
import java.util.Iterator;
import kntr.app.im.base.SessionPinEvent;
import kotlin.Metadata;
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
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", "event", "Lkntr/app/im/base/SessionPinEvent;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$15$3", f = "IMSessionStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionStateMachine$1$1$15$3 extends SuspendLambda implements Function3<SessionPinEvent, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionStateMachine$1$1$15$3(Continuation<? super IMSessionStateMachine$1$1$15$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(SessionPinEvent sessionPinEvent, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$1$1$15$3 iMSessionStateMachine$1$1$15$3 = new IMSessionStateMachine$1$1$15$3(continuation);
        iMSessionStateMachine$1$1$15$3.L$0 = sessionPinEvent;
        iMSessionStateMachine$1$1$15$3.L$1 = state;
        return iMSessionStateMachine$1$1$15$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object element$iv;
        final SessionPinEvent event = (SessionPinEvent) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$firstOrNull$iv = ((IMState) state.getSnapshot()).getData().getSessions();
                Iterator<T> it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        IMSessionCard it2 = (IMSessionCard) element$iv;
                        if (Intrinsics.areEqual(it2.getId(), event.getSessionID())) {
                        }
                    } else {
                        element$iv = null;
                    }
                }
                final IMSessionCard session = (IMSessionCard) element$iv;
                if (session != null) {
                    return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$1$1$15$3$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            IMState invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = IMSessionStateMachine$1$1$15$3.invokeSuspend$lambda$1(IMSessionCard.this, event, (IMState) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$1(IMSessionCard $session, SessionPinEvent $event, IMState $this$mutate) {
        return IMState.copy$default($this$mutate, null, $this$mutate.getData().pinOrNot$session_debug($session, new PinResult($event.isPinned(), $event.getSequenceNumber())), null, false, null, null, false, null, 253, null);
    }
}