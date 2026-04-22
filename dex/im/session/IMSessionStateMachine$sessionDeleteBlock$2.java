package im.session;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.session.model.IMSessionPageData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", "<unused var>", "Lim/session/IMActionSessionDeleteConfirm;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$sessionDeleteBlock$2", f = "IMSessionStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMSessionStateMachine$sessionDeleteBlock$2 extends SuspendLambda implements Function3<IMActionSessionDeleteConfirm, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionStateMachine$sessionDeleteBlock$2(Continuation<? super IMSessionStateMachine$sessionDeleteBlock$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMActionSessionDeleteConfirm iMActionSessionDeleteConfirm, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$sessionDeleteBlock$2 iMSessionStateMachine$sessionDeleteBlock$2 = new IMSessionStateMachine$sessionDeleteBlock$2(continuation);
        iMSessionStateMachine$sessionDeleteBlock$2.L$0 = state;
        return iMSessionStateMachine$sessionDeleteBlock$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$sessionDeleteBlock$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IMSessionStateMachine$sessionDeleteBlock$2.invokeSuspend$lambda$0((IMState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$0(IMState $this$mutate) {
        return IMState.copy$default($this$mutate, null, IMSessionPageData.copy$default($this$mutate.getData(), null, null, null, null, null, null, null, null, null, null, false, 1791, null), null, false, null, null, false, null, 253, null);
    }
}