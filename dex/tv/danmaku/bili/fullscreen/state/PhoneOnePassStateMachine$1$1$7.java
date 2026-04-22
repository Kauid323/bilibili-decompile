package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhoneOnePassLoginState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$ShowCaptchaDialog;", "stateSnapshot", "Ltv/danmaku/bili/fullscreen/state/PhoneOnePassLoginState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.PhoneOnePassStateMachine$1$1$7", f = "PhoneOnePassLoginState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PhoneOnePassStateMachine$1$1$7 extends SuspendLambda implements Function3<IFullscreenLoginReportAction.ShowCaptchaDialog, PhoneOnePassLoginState, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PhoneOnePassStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneOnePassStateMachine$1$1$7(PhoneOnePassStateMachine phoneOnePassStateMachine, Continuation<? super PhoneOnePassStateMachine$1$1$7> continuation) {
        super(3, continuation);
        this.this$0 = phoneOnePassStateMachine;
    }

    public final Object invoke(IFullscreenLoginReportAction.ShowCaptchaDialog showCaptchaDialog, PhoneOnePassLoginState phoneOnePassLoginState, Continuation<? super Unit> continuation) {
        return new PhoneOnePassStateMachine$1$1$7(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginReportService loginReportService;
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                loginReportService = this.this$0.loginReportService;
                str = this.this$0.loginType;
                LoginReportService.report$default(loginReportService, "app.login.verification.0.show", str, null, 4, null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}