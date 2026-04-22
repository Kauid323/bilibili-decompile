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
import kotlin.jvm.functions.Function2;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.AvailableCountryCode;
import tv.danmaku.bili.fullscreen.service.ISmsLoginService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginIdlePage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$3$1", f = "StepByStepSmsLoginStateMachine.kt", i = {0}, l = {BR.buttonWidths}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
public final class StepByStepSmsLoginStateMachine$1$3$1 extends SuspendLambda implements Function2<State<StepByStepSmsLoginIdlePage>, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StepByStepSmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginStateMachine$1$3$1(StepByStepSmsLoginStateMachine stepByStepSmsLoginStateMachine, Continuation<? super StepByStepSmsLoginStateMachine$1$3$1> continuation) {
        super(2, continuation);
        this.this$0 = stepByStepSmsLoginStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stepByStepSmsLoginStateMachine$1$3$1 = new StepByStepSmsLoginStateMachine$1$3$1(this.this$0, continuation);
        stepByStepSmsLoginStateMachine$1$3$1.L$0 = obj;
        return stepByStepSmsLoginStateMachine$1$3$1;
    }

    public final Object invoke(State<StepByStepSmsLoginIdlePage> state, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State it;
        ISmsLoginService iSmsLoginService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                it = (State) this.L$0;
                iSmsLoginService = this.this$0.smsLoginService;
                this.L$0 = it;
                this.label = 1;
                Object allCountryCode = iSmsLoginService.getAllCountryCode((Continuation) this);
                if (allCountryCode != coroutine_suspended) {
                    $result = allCountryCode;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                it = (State) this.L$0;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final AvailableCountryCode code = (AvailableCountryCode) $result;
        BLog.i(StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS, String.valueOf(code.getList()));
        return it.override(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$3$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                StepByStepSmsLoginPhonePage invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = StepByStepSmsLoginStateMachine$1$3$1.invokeSuspend$lambda$0(AvailableCountryCode.this, (StepByStepSmsLoginIdlePage) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginPhonePage invokeSuspend$lambda$0(AvailableCountryCode $code, StepByStepSmsLoginIdlePage $this$override) {
        return new StepByStepSmsLoginPhonePage(new StepByStepSmsLoginPhoneInputState(null, $code, null, false, 13, null), null, false, null, null, 0.0f, 0L, null, null, BR.half, null);
    }
}