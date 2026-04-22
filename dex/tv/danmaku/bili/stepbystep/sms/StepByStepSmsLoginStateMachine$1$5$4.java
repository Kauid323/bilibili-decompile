package tv.danmaku.bili.stepbystep.sms;

import com.bilibili.lib.accounts.AccountException;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Map;
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
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.service.ISmsLoginService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.SmsCaptchaStatus;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "action", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$GetSmsAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$5$4", f = "StepByStepSmsLoginStateMachine.kt", i = {0}, l = {BR.errorText}, m = "invokeSuspend", n = {AuthResultCbHelper.ARGS_STATE}, s = {"L$0"}, v = 1)
public final class StepByStepSmsLoginStateMachine$1$5$4 extends SuspendLambda implements Function3<StepByStepSmsLoginAction.GetSmsAction, State<StepByStepSmsLoginVerifyPage>, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ StepByStepSmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginStateMachine$1$5$4(StepByStepSmsLoginStateMachine stepByStepSmsLoginStateMachine, Continuation<? super StepByStepSmsLoginStateMachine$1$5$4> continuation) {
        super(3, continuation);
        this.this$0 = stepByStepSmsLoginStateMachine;
    }

    public final Object invoke(StepByStepSmsLoginAction.GetSmsAction getSmsAction, State<StepByStepSmsLoginVerifyPage> state, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>> continuation) {
        StepByStepSmsLoginStateMachine$1$5$4 stepByStepSmsLoginStateMachine$1$5$4 = new StepByStepSmsLoginStateMachine$1$5$4(this.this$0, continuation);
        stepByStepSmsLoginStateMachine$1$5$4.L$0 = getSmsAction;
        stepByStepSmsLoginStateMachine$1$5$4.L$1 = state;
        return stepByStepSmsLoginStateMachine$1$5$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state;
        ISmsLoginService iSmsLoginService;
        LoginReportService loginReportService;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StepByStepSmsLoginAction.GetSmsAction action = (StepByStepSmsLoginAction.GetSmsAction) this.L$0;
                state = (State) this.L$1;
                StepByStepSmsLoginPhoneInputState input = ((StepByStepSmsLoginVerifyPage) state.getSnapshot()).getPhoneInputState();
                iSmsLoginService = this.this$0.smsLoginService;
                String phone = input.getPhone();
                PhoneCountryCode selectedCountry = input.getSelectedCountry();
                Map<String, String> captcha = action.getCaptcha();
                loginReportService = this.this$0.reportService;
                str = this.this$0.reportLoginType;
                this.L$0 = state;
                this.label = 1;
                Object sendSmsCode = iSmsLoginService.sendSmsCode(phone, selectedCountry, captcha, loginReportService.getReportParams(str), (Continuation) this);
                if (sendSmsCode != coroutine_suspended) {
                    $result = sendSmsCode;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                state = (State) this.L$0;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final SmsCaptchaStatus status = (SmsCaptchaStatus) $result;
        return state.mutate(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$1$5$4$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                StepByStepSmsLoginVerifyPage invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = StepByStepSmsLoginStateMachine$1$5$4.invokeSuspend$lambda$0(SmsCaptchaStatus.this, (StepByStepSmsLoginVerifyPage) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginVerifyPage invokeSuspend$lambda$0(SmsCaptchaStatus $status, StepByStepSmsLoginVerifyPage $this$mutate) {
        int i;
        AccountException loginError = $status.getLoginError();
        ToastInfo toastInfo = new ToastInfo((loginError == null || (r0 = loginError.getMessage()) == null) ? "" : "", 0L, 2, null);
        if ($status.getLoginError() == null && StringsKt.isBlank($status.getCaptchaUrl())) {
            Duration.Companion companion = Duration.Companion;
            i = 60;
        } else {
            Duration.Companion companion2 = Duration.Companion;
            i = 0;
        }
        return StepByStepSmsLoginVerifyPage.m1531copyvXyWBk$default($this$mutate, null, null, 0, null, false, toastInfo, null, 0.0f, false, null, DurationKt.toDuration(i, DurationUnit.SECONDS), $status, null, 5087, null);
    }
}