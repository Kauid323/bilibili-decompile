package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "it", "", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginCountingState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$5$1", f = "SmsLoginPageState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginStateMachine$1$5$1 extends SuspendLambda implements Function3<Integer, State<ISmsLoginCountingState>, Continuation<? super ChangedState<? extends ISmsLoginPageState>>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmsLoginStateMachine$1$5$1(Continuation<? super SmsLoginStateMachine$1$5$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(int i, State<ISmsLoginCountingState> state, Continuation<? super ChangedState<? extends ISmsLoginPageState>> continuation) {
        SmsLoginStateMachine$1$5$1 smsLoginStateMachine$1$5$1 = new SmsLoginStateMachine$1$5$1(continuation);
        smsLoginStateMachine$1$5$1.I$0 = i;
        smsLoginStateMachine$1$5$1.L$0 = state;
        return smsLoginStateMachine$1$5$1.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).intValue(), (State) obj2, (Continuation) obj3);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final int it = this.I$0;
                State state = (State) this.L$0;
                if (it == 0) {
                    return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$5$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            NetCodeEnableState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = SmsLoginStateMachine$1$5$1.invokeSuspend$lambda$0((ISmsLoginCountingState) obj2);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
                return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$5$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        ISmsLoginCountingState invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = SmsLoginStateMachine$1$5$1.invokeSuspend$lambda$1(it, (ISmsLoginCountingState) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetCodeEnableState invokeSuspend$lambda$0(ISmsLoginCountingState $this$override) {
        if ($this$override instanceof SmsLoginLoadingCountingState) {
            return new SmsLoginLoadingIdleState(new SmsLoginPageInputIdleState(((SmsLoginLoadingCountingState) $this$override).getOriginal().getInput(), ((SmsLoginLoadingCountingState) $this$override).getOriginal().getLoggedIn()));
        }
        if (!($this$override instanceof SmsLoginPageInputCountingState)) {
            throw new NoWhenBranchMatchedException();
        }
        return new SmsLoginPageInputIdleState(((SmsLoginPageInputCountingState) $this$override).getInput(), ((SmsLoginPageInputCountingState) $this$override).getLoggedIn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ISmsLoginCountingState invokeSuspend$lambda$1(int $it, ISmsLoginCountingState $this$mutate) {
        return $this$mutate.countDownTo($it);
    }
}