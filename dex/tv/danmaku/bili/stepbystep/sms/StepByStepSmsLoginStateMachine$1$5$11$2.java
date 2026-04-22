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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "action", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$InputSmsCodeAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$5$11$2", f = "StepByStepSmsLoginStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginStateMachine$1$5$11$2 extends SuspendLambda implements Function3<StepByStepSmsLoginAction.InputSmsCodeAction, State<StepByStepSmsLoginVerifyPage>, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StepByStepSmsLoginStateMachine$1$5$11$2(Continuation<? super StepByStepSmsLoginStateMachine$1$5$11$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(StepByStepSmsLoginAction.InputSmsCodeAction inputSmsCodeAction, State<StepByStepSmsLoginVerifyPage> state, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>> continuation) {
        StepByStepSmsLoginStateMachine$1$5$11$2 stepByStepSmsLoginStateMachine$1$5$11$2 = new StepByStepSmsLoginStateMachine$1$5$11$2(continuation);
        stepByStepSmsLoginStateMachine$1$5$11$2.L$0 = inputSmsCodeAction;
        stepByStepSmsLoginStateMachine$1$5$11$2.L$1 = state;
        return stepByStepSmsLoginStateMachine$1$5$11$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final StepByStepSmsLoginAction.InputSmsCodeAction action = (StepByStepSmsLoginAction.InputSmsCodeAction) this.L$0;
                State state = (State) this.L$1;
                return state.override(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$5$11$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        StepByStepSmsLoginVerifyPage invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = StepByStepSmsLoginStateMachine$1$5$11$2.invokeSuspend$lambda$0(StepByStepSmsLoginAction.InputSmsCodeAction.this, (StepByStepSmsLoginVerifyPage) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginVerifyPage invokeSuspend$lambda$0(StepByStepSmsLoginAction.InputSmsCodeAction $action, StepByStepSmsLoginVerifyPage $this$override) {
        CharSequence $this$filter$iv = $action.getSmsCode();
        CharSequence $this$filterTo$iv$iv = $this$filter$iv;
        Appendable destination$iv$iv = new StringBuilder();
        int length = $this$filterTo$iv$iv.length();
        for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
            char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
            if (Character.isDigit(element$iv$iv)) {
                destination$iv$iv.append(element$iv$iv);
            }
        }
        String $this$filter$iv2 = ((StringBuilder) destination$iv$iv).toString();
        String newSmsCode = StringsKt.take($this$filter$iv2, 6);
        StepByStepSmsLoginVerifyPage it = StepByStepSmsLoginVerifyPage.m1531copyvXyWBk$default($this$override, newSmsCode, newSmsCode.length() < 6 ? "" : $this$override.getExceptionMessage(), newSmsCode.length() < 6 ? 0 : $this$override.getExceptionMessageResourceId(), null, false, null, null, 0.0f, false, null, 0L, null, null, 8184, null);
        BLog.i(StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS, "override state : StepByStepSmsLoginSubmitPage to StepByStepSmsLoginVerifyPage, action : InputSmsCodeAction -> \nsmsCode=" + newSmsCode + " ,\neMsg=" + it.getExceptionMessage() + " ,\neMsgId=" + it.getExceptionMessageResourceId());
        return it;
    }
}