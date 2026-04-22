package tv.danmaku.bili.fullscreen.state;

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
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.service.ISmsLoginService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.SmsCaptchaStatus;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.state.ISmsLoginAction;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "action", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$SendSmsAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInputIdleState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$4$2", f = "SmsLoginPageState.kt", i = {0}, l = {BR.showImgBadge}, m = "invokeSuspend", n = {AuthResultCbHelper.ARGS_STATE}, s = {"L$0"}, v = 1)
public final class SmsLoginStateMachine$1$4$2 extends SuspendLambda implements Function3<ISmsLoginAction.SendSmsAction, State<SmsLoginPageInputIdleState>, Continuation<? super ChangedState<? extends ISmsLoginPageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ SmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginStateMachine$1$4$2(SmsLoginStateMachine smsLoginStateMachine, Continuation<? super SmsLoginStateMachine$1$4$2> continuation) {
        super(3, continuation);
        this.this$0 = smsLoginStateMachine;
    }

    public final Object invoke(ISmsLoginAction.SendSmsAction sendSmsAction, State<SmsLoginPageInputIdleState> state, Continuation<? super ChangedState<? extends ISmsLoginPageState>> continuation) {
        SmsLoginStateMachine$1$4$2 smsLoginStateMachine$1$4$2 = new SmsLoginStateMachine$1$4$2(this.this$0, continuation);
        smsLoginStateMachine$1$4$2.L$0 = sendSmsAction;
        smsLoginStateMachine$1$4$2.L$1 = state;
        return smsLoginStateMachine$1$4$2.invokeSuspend(Unit.INSTANCE);
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
                ISmsLoginAction.SendSmsAction action = (ISmsLoginAction.SendSmsAction) this.L$0;
                state = (State) this.L$1;
                SmsLoginInput input = ((SmsLoginPageInputIdleState) state.getSnapshot()).getInput();
                iSmsLoginService = this.this$0.smsLoginService;
                String phone = input.getPhone();
                PhoneCountryCode selectedCountry = input.getSelectedCountry();
                Map<String, String> captcha = action.getCaptcha();
                loginReportService = this.this$0.loginReportService;
                str = this.this$0.loginType;
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
        if (!StringsKt.isBlank(status.getCaptchaUrl())) {
            return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$4$2$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    SmsLoginPageInputIdleState invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = SmsLoginStateMachine$1$4$2.invokeSuspend$lambda$0(SmsCaptchaStatus.this, (SmsLoginPageInputIdleState) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        }
        if (status.getLoginError() == null) {
            return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$4$2$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    SmsLoginPageInputCountingState invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = SmsLoginStateMachine$1$4$2.invokeSuspend$lambda$1(SmsCaptchaStatus.this, (SmsLoginPageInputIdleState) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
        return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$4$2$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                SmsLoginPageInputIdleState invokeSuspend$lambda$2;
                invokeSuspend$lambda$2 = SmsLoginStateMachine$1$4$2.invokeSuspend$lambda$2(SmsCaptchaStatus.this, (SmsLoginPageInputIdleState) obj);
                return invokeSuspend$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SmsLoginPageInputIdleState invokeSuspend$lambda$0(SmsCaptchaStatus $status, SmsLoginPageInputIdleState $this$mutate) {
        SmsLoginInput copy;
        copy = r0.copy((r26 & 1) != 0 ? r0.phone : null, (r26 & 2) != 0 ? r0.smsCode : null, (r26 & 4) != 0 ? r0.agreementChecked : false, (r26 & 8) != 0 ? r0.availableCountryCode : null, (r26 & 16) != 0 ? r0.selectedCountry : null, (r26 & 32) != 0 ? r0.showCountryCodeSelect : false, (r26 & 64) != 0 ? r0.captchaStatus : $status, (r26 & BR.cover) != 0 ? r0.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? r0.toastInfo : null, (r26 & BR.roleType) != 0 ? r0.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? r0.loginWay : null, (r26 & 2048) != 0 ? $this$mutate.getInput().netCodeState : null);
        return $this$mutate.copyState(copy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SmsLoginPageInputCountingState invokeSuspend$lambda$1(SmsCaptchaStatus $status, SmsLoginPageInputIdleState $this$override) {
        SmsLoginInput copy;
        copy = r7.copy((r26 & 1) != 0 ? r7.phone : null, (r26 & 2) != 0 ? r7.smsCode : null, (r26 & 4) != 0 ? r7.agreementChecked : false, (r26 & 8) != 0 ? r7.availableCountryCode : null, (r26 & 16) != 0 ? r7.selectedCountry : null, (r26 & 32) != 0 ? r7.showCountryCodeSelect : false, (r26 & 64) != 0 ? r7.captchaStatus : $status, (r26 & BR.cover) != 0 ? r7.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? r7.toastInfo : null, (r26 & BR.roleType) != 0 ? r7.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? r7.loginWay : null, (r26 & 2048) != 0 ? $this$override.getInput().netCodeState : null);
        return new SmsLoginPageInputCountingState(copy, 0, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SmsLoginPageInputIdleState invokeSuspend$lambda$2(SmsCaptchaStatus $status, SmsLoginPageInputIdleState $this$mutate) {
        SmsLoginInput copy;
        SmsLoginInput input = $this$mutate.getInput();
        String message = $status.getLoginError().getMessage();
        if (message == null) {
            message = "";
        }
        copy = input.copy((r26 & 1) != 0 ? input.phone : null, (r26 & 2) != 0 ? input.smsCode : null, (r26 & 4) != 0 ? input.agreementChecked : false, (r26 & 8) != 0 ? input.availableCountryCode : null, (r26 & 16) != 0 ? input.selectedCountry : null, (r26 & 32) != 0 ? input.showCountryCodeSelect : false, (r26 & 64) != 0 ? input.captchaStatus : null, (r26 & BR.cover) != 0 ? input.redirected : null, (r26 & BR.hallEnterHotText) != 0 ? input.toastInfo : new ToastInfo(message, 0L, 2, null), (r26 & BR.roleType) != 0 ? input.eulaDisplayInfo : null, (r26 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? input.loginWay : null, (r26 & 2048) != 0 ? input.netCodeState : null);
        return $this$mutate.copyState(copy);
    }
}