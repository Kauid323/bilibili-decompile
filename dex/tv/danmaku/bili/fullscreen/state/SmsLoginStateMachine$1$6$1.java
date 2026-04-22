package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final /* synthetic */ class SmsLoginStateMachine$1$6$1 extends FunctionReferenceImpl implements Function2<State<ISmsLoginLoadingState>, Continuation<? super ChangedState<? extends ISmsLoginPageState>>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SmsLoginStateMachine$1$6$1(Object obj) {
        super(2, obj, SmsLoginStateMachine.class, "handleLoginState", "handleLoginState(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(State<ISmsLoginLoadingState> state, Continuation<? super ChangedState<? extends ISmsLoginPageState>> continuation) {
        Object handleLoginState;
        handleLoginState = ((SmsLoginStateMachine) this.receiver).handleLoginState(state, continuation);
        return handleLoginState;
    }
}