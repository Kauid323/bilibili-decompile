package im.session;

import com.bapis.bilibili.app.im.v1.KSessionId;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.session.model.IMSessionCard;
import java.util.Iterator;
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

/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$sessionDeleteBlock$6", f = "IMSessionStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMSessionStateMachine$sessionDeleteBlock$6 extends SuspendLambda implements Function3<KSessionId, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionStateMachine$sessionDeleteBlock$6(Continuation<? super IMSessionStateMachine$sessionDeleteBlock$6> continuation) {
        super(3, continuation);
    }

    public final Object invoke(KSessionId kSessionId, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$sessionDeleteBlock$6 iMSessionStateMachine$sessionDeleteBlock$6 = new IMSessionStateMachine$sessionDeleteBlock$6(continuation);
        iMSessionStateMachine$sessionDeleteBlock$6.L$0 = kSessionId;
        iMSessionStateMachine$sessionDeleteBlock$6.L$1 = state;
        return iMSessionStateMachine$sessionDeleteBlock$6.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object element$iv;
        KSessionId sessionId = (KSessionId) this.L$0;
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
                        if (Intrinsics.areEqual(it2.getId(), sessionId)) {
                        }
                    } else {
                        element$iv = null;
                    }
                }
                final IMSessionCard session = (IMSessionCard) element$iv;
                if (session != null) {
                    return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$sessionDeleteBlock$6$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            IMState invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = IMSessionStateMachine$sessionDeleteBlock$6.invokeSuspend$lambda$1(IMSessionCard.this, (IMState) obj);
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
    public static final IMState invokeSuspend$lambda$1(IMSessionCard $session, IMState $this$mutate) {
        return IMState.copy$default($this$mutate, null, $this$mutate.getData().delete$session_debug($session), null, false, null, null, false, null, 253, null);
    }
}