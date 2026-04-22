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
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.normal.ui.EulaTriggerType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$NetCodeAuth;", "stateSnapshot", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$1$7$4", f = "SmsLoginPageState.kt", i = {0, 1}, l = {BR.vipBadgeVisible, BR.vipBarAnimIconStartMargin}, m = "invokeSuspend", n = {"stateSnapshot", "stateSnapshot"}, s = {"L$0", "L$0"}, v = 1)
public final class SmsLoginStateMachine$1$7$4 extends SuspendLambda implements Function3<IFullscreenLoginAction.NetCodeAuth, ISmsLoginPageState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ SmsLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginStateMachine$1$7$4(SmsLoginStateMachine smsLoginStateMachine, Continuation<? super SmsLoginStateMachine$1$7$4> continuation) {
        super(3, continuation);
        this.this$0 = smsLoginStateMachine;
    }

    public final Object invoke(IFullscreenLoginAction.NetCodeAuth netCodeAuth, ISmsLoginPageState iSmsLoginPageState, Continuation<? super Unit> continuation) {
        SmsLoginStateMachine$1$7$4 smsLoginStateMachine$1$7$4 = new SmsLoginStateMachine$1$7$4(this.this$0, continuation);
        smsLoginStateMachine$1$7$4.L$0 = netCodeAuth;
        smsLoginStateMachine$1$7$4.L$1 = iSmsLoginPageState;
        return smsLoginStateMachine$1$7$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ISmsLoginPageState stateSnapshot;
        LoginReportService loginReportService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IFullscreenLoginAction.NetCodeAuth action = (IFullscreenLoginAction.NetCodeAuth) this.L$0;
                ISmsLoginPageState stateSnapshot2 = (ISmsLoginPageState) this.L$1;
                if (action.getCheckEula()) {
                    if (stateSnapshot2.getAgreementChecked()) {
                        this.L$0 = stateSnapshot2;
                        this.label = 1;
                        if (this.this$0.dispatch(new IFullscreenLoginAction.NetCodeAuth(false), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        stateSnapshot = stateSnapshot2;
                    } else {
                        this.L$0 = stateSnapshot2;
                        this.label = 2;
                        if (this.this$0.dispatch(new IFullscreenLoginAction.ShowEulaAction(EulaTriggerType.NetCode), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        stateSnapshot = stateSnapshot2;
                    }
                    loginReportService = this.this$0.loginReportService;
                    loginReportService.report("app.login.switch-option.0.click", stateSnapshot.getLoginType(), TuplesKt.to("type", "netcode"));
                    break;
                }
                break;
            case 1:
                stateSnapshot = (ISmsLoginPageState) this.L$0;
                ResultKt.throwOnFailure($result);
                loginReportService = this.this$0.loginReportService;
                loginReportService.report("app.login.switch-option.0.click", stateSnapshot.getLoginType(), TuplesKt.to("type", "netcode"));
                break;
            case 2:
                stateSnapshot = (ISmsLoginPageState) this.L$0;
                ResultKt.throwOnFailure($result);
                loginReportService = this.this$0.loginReportService;
                loginReportService.report("app.login.switch-option.0.click", stateSnapshot.getLoginType(), TuplesKt.to("type", "netcode"));
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}