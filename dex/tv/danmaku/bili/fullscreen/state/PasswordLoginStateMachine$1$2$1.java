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
/* compiled from: PasswordLoginPageState.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final /* synthetic */ class PasswordLoginStateMachine$1$2$1 extends FunctionReferenceImpl implements Function2<State<PasswordLoginLoadingState>, Continuation<? super ChangedState<? extends PasswordLoginPageState>>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PasswordLoginStateMachine$1$2$1(Object obj) {
        super(2, obj, PasswordLoginStateMachine.class, "handlePwdLogin", "handlePwdLogin(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(State<PasswordLoginLoadingState> state, Continuation<? super ChangedState<PasswordLoginPageState>> continuation) {
        Object handlePwdLogin;
        handlePwdLogin = ((PasswordLoginStateMachine) this.receiver).handlePwdLogin(state, continuation);
        return handlePwdLogin;
    }
}