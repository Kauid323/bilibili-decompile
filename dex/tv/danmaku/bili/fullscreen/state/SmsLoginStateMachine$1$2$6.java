package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
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
import tv.danmaku.bili.fullscreen.service.LoginReportServiceKt;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$LoginAction;", "stateSnapshot", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginValidState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$2$6", f = "SmsLoginPageState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginStateMachine$1$2$6 extends SuspendLambda implements Function3<IFullscreenLoginAction.LoginAction, ISmsLoginValidState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ SmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginStateMachine$1$2$6(SmsLoginStateMachine smsLoginStateMachine, Continuation<? super SmsLoginStateMachine$1$2$6> continuation) {
        super(3, continuation);
        this.this$0 = smsLoginStateMachine;
    }

    public final Object invoke(IFullscreenLoginAction.LoginAction loginAction, ISmsLoginValidState iSmsLoginValidState, Continuation<? super Unit> continuation) {
        SmsLoginStateMachine$1$2$6 smsLoginStateMachine$1$2$6 = new SmsLoginStateMachine$1$2$6(this.this$0, continuation);
        smsLoginStateMachine$1$2$6.L$0 = loginAction;
        smsLoginStateMachine$1$2$6.L$1 = iSmsLoginValidState;
        return smsLoginStateMachine$1$2$6.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginReportService loginReportService;
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                IFullscreenLoginAction.LoginAction action = (IFullscreenLoginAction.LoginAction) this.L$0;
                ISmsLoginValidState stateSnapshot = (ISmsLoginValidState) this.L$1;
                if (action.getReport()) {
                    loginReportService = this.this$0.loginReportService;
                    str = this.this$0.loginType;
                    loginReportService.report("app.login.submit.0.click", str, TuplesKt.to("is_agree", LoginReportServiceKt.getReportString(stateSnapshot.getInput().getAgreementChecked())));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}