package im.session;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", AuthActivity.ACTION_KEY, "Lim/session/IMActionSessionPin;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$15$1", f = "IMSessionStateMachine.kt", i = {0, 0}, l = {196}, m = "invokeSuspend", n = {AuthActivity.ACTION_KEY, "state"}, s = {"L$0", "L$1"}, v = 1)
public final class IMSessionStateMachine$1$1$15$1 extends SuspendLambda implements Function3<IMActionSessionPin, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$15$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$15$1> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionSessionPin iMActionSessionPin, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$1$1$15$1 iMSessionStateMachine$1$1$15$1 = new IMSessionStateMachine$1$1$15$1(this.this$0, continuation);
        iMSessionStateMachine$1$1$15$1.L$0 = iMActionSessionPin;
        iMSessionStateMachine$1$1$15$1.L$1 = state;
        return iMSessionStateMachine$1$1$15$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object pinOrNot;
        IMActionSessionPin action = (IMActionSessionPin) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                pinOrNot = this.this$0.pinOrNot(state, action.getCard(), (Continuation) this);
                if (pinOrNot == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return pinOrNot;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}