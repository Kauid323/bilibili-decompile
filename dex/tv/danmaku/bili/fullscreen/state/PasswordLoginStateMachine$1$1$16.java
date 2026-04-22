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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PasswordLoginPageState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$SwitchToSms;", "stateSnapshot", "Ltv/danmaku/bili/fullscreen/state/PasswordLoginPageState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.PasswordLoginStateMachine$1$1$16", f = "PasswordLoginPageState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PasswordLoginStateMachine$1$1$16 extends SuspendLambda implements Function3<IFullscreenLoginAction.SwitchToSms, PasswordLoginPageState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ PasswordLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordLoginStateMachine$1$1$16(PasswordLoginStateMachine passwordLoginStateMachine, Continuation<? super PasswordLoginStateMachine$1$1$16> continuation) {
        super(3, continuation);
        this.this$0 = passwordLoginStateMachine;
    }

    public final Object invoke(IFullscreenLoginAction.SwitchToSms switchToSms, PasswordLoginPageState passwordLoginPageState, Continuation<? super Unit> continuation) {
        PasswordLoginStateMachine$1$1$16 passwordLoginStateMachine$1$1$16 = new PasswordLoginStateMachine$1$1$16(this.this$0, continuation);
        passwordLoginStateMachine$1$1$16.L$0 = switchToSms;
        passwordLoginStateMachine$1$1$16.L$1 = passwordLoginPageState;
        return passwordLoginStateMachine$1$1$16.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginReportService loginReportService;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                IFullscreenLoginAction.SwitchToSms action = (IFullscreenLoginAction.SwitchToSms) this.L$0;
                PasswordLoginPageState stateSnapshot = (PasswordLoginPageState) this.L$1;
                if (action.getReport()) {
                    loginReportService = this.this$0.loginReportService;
                    loginReportService.report("app.login.switch-option.0.click", stateSnapshot.getLoginType(), TuplesKt.to("type", "sms"));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}