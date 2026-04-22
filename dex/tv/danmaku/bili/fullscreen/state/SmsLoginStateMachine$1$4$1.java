package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.ISmsLoginAction;
import tv.danmaku.bili.normal.ui.EulaTriggerType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginAction$ClickSendSmsAction;", "stateSnapshot", "Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInputIdleState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$4$1", f = "SmsLoginPageState.kt", i = {0, 1}, l = {BR.selected, BR.sexDrawableId}, m = "invokeSuspend", n = {"stateSnapshot", "stateSnapshot"}, s = {"L$0", "L$0"}, v = 1)
public final class SmsLoginStateMachine$1$4$1 extends SuspendLambda implements Function3<ISmsLoginAction.ClickSendSmsAction, SmsLoginPageInputIdleState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ SmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginStateMachine$1$4$1(SmsLoginStateMachine smsLoginStateMachine, Continuation<? super SmsLoginStateMachine$1$4$1> continuation) {
        super(3, continuation);
        this.this$0 = smsLoginStateMachine;
    }

    public final Object invoke(ISmsLoginAction.ClickSendSmsAction clickSendSmsAction, SmsLoginPageInputIdleState smsLoginPageInputIdleState, Continuation<? super Unit> continuation) {
        SmsLoginStateMachine$1$4$1 smsLoginStateMachine$1$4$1 = new SmsLoginStateMachine$1$4$1(this.this$0, continuation);
        smsLoginStateMachine$1$4$1.L$0 = clickSendSmsAction;
        smsLoginStateMachine$1$4$1.L$1 = smsLoginPageInputIdleState;
        return smsLoginStateMachine$1$4$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SmsLoginPageInputIdleState stateSnapshot;
        LoginReportService loginReportService;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ISmsLoginAction.ClickSendSmsAction action = (ISmsLoginAction.ClickSendSmsAction) this.L$0;
                SmsLoginPageInputIdleState stateSnapshot2 = (SmsLoginPageInputIdleState) this.L$1;
                if (stateSnapshot2.getInput().getAgreementChecked()) {
                    this.L$0 = stateSnapshot2;
                    this.label = 1;
                    if (this.this$0.dispatch(new ISmsLoginAction.SendSmsAction(action.getNewLoginWay(), action.getCaptcha()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    stateSnapshot = stateSnapshot2;
                    break;
                } else {
                    this.L$0 = stateSnapshot2;
                    this.label = 2;
                    if (this.this$0.dispatch(new IFullscreenLoginAction.ShowEulaAction(EulaTriggerType.GetSms), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    stateSnapshot = stateSnapshot2;
                    break;
                }
            case 1:
                stateSnapshot = (SmsLoginPageInputIdleState) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                stateSnapshot = (SmsLoginPageInputIdleState) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        loginReportService = this.this$0.loginReportService;
        str = this.this$0.loginType;
        Pair<String, String>[] pairArr = new Pair[1];
        pairArr[0] = TuplesKt.to("is_agree", stateSnapshot.getInput().getAgreementChecked() ? "1" : "0");
        loginReportService.report("app.login.getsms.0.click", str, pairArr);
        return Unit.INSTANCE;
    }
}