package tv.danmaku.bili.stepbystep.sms;

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
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "action", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$InputPhoneAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginPhonePage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$4$1", f = "StepByStepSmsLoginStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginStateMachine$1$4$1 extends SuspendLambda implements Function3<StepByStepSmsLoginAction.InputPhoneAction, State<StepByStepSmsLoginPhonePage>, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StepByStepSmsLoginStateMachine$1$4$1(Continuation<? super StepByStepSmsLoginStateMachine$1$4$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(StepByStepSmsLoginAction.InputPhoneAction inputPhoneAction, State<StepByStepSmsLoginPhonePage> state, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>> continuation) {
        StepByStepSmsLoginStateMachine$1$4$1 stepByStepSmsLoginStateMachine$1$4$1 = new StepByStepSmsLoginStateMachine$1$4$1(continuation);
        stepByStepSmsLoginStateMachine$1$4$1.L$0 = inputPhoneAction;
        stepByStepSmsLoginStateMachine$1$4$1.L$1 = state;
        return stepByStepSmsLoginStateMachine$1$4$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                StepByStepSmsLoginAction.InputPhoneAction action = (StepByStepSmsLoginAction.InputPhoneAction) this.L$0;
                State state = (State) this.L$1;
                CharSequence $this$filter$iv = action.getPhone();
                CharSequence $this$filterTo$iv$iv = $this$filter$iv;
                Appendable destination$iv$iv = new StringBuilder();
                int length = $this$filterTo$iv$iv.length();
                for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
                    char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                    char it = element$iv$iv;
                    if (Character.isDigit(it)) {
                        destination$iv$iv.append(element$iv$iv);
                    }
                }
                String onlyDigit = ((StringBuilder) destination$iv$iv).toString();
                final String limitLengthInput = StringsKt.take(onlyDigit, ((StepByStepSmsLoginPhonePage) state.getSnapshot()).getPhoneLimitLength());
                return state.mutate(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$4$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        StepByStepSmsLoginPhonePage invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = StepByStepSmsLoginStateMachine$1$4$1.invokeSuspend$lambda$1(limitLengthInput, (StepByStepSmsLoginPhonePage) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginPhonePage invokeSuspend$lambda$1(String $limitLengthInput, StepByStepSmsLoginPhonePage $this$mutate) {
        StepByStepSmsLoginPhonePage m1519copyzIkEtRU$default = StepByStepSmsLoginPhonePage.m1519copyzIkEtRU$default($this$mutate, StepByStepSmsLoginPhoneInputState.copy$default($this$mutate.getPhoneInputState(), $limitLengthInput, null, null, false, 14, null), null, false, null, null, 0.0f, 0L, null, null, BR.roleName, null);
        BLog.i(StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS, "mutate state : StepByStepSmsLoginPhonePage , action ：InputPhoneAction -> phone=" + $limitLengthInput);
        return m1519copyzIkEtRU$default;
    }
}