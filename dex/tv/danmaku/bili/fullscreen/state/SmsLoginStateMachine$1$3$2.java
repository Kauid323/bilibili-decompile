package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.state.ISmsLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "<unused var>", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$OnCountryCodeSelectCancel;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginSelectCountryCodeState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$3$2", f = "SmsLoginPageState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginStateMachine$1$3$2 extends SuspendLambda implements Function3<ISmsLoginAction.OnCountryCodeSelectCancel, State<SmsLoginSelectCountryCodeState>, Continuation<? super ChangedState<? extends ISmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmsLoginStateMachine$1$3$2(Continuation<? super SmsLoginStateMachine$1$3$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ISmsLoginAction.OnCountryCodeSelectCancel onCountryCodeSelectCancel, State<SmsLoginSelectCountryCodeState> state, Continuation<? super ChangedState<? extends ISmsLoginPageState>> continuation) {
        SmsLoginStateMachine$1$3$2 smsLoginStateMachine$1$3$2 = new SmsLoginStateMachine$1$3$2(continuation);
        smsLoginStateMachine$1$3$2.L$0 = state;
        return smsLoginStateMachine$1$3$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                State state = (State) this.L$0;
                return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$3$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        SmsLoginPageInputIdleState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SmsLoginStateMachine$1$3$2.invokeSuspend$lambda$0((SmsLoginSelectCountryCodeState) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SmsLoginPageInputIdleState invokeSuspend$lambda$0(SmsLoginSelectCountryCodeState $this$override) {
        return new SmsLoginPageInputIdleState($this$override.getCurrentInput(), false, 2, null);
    }
}