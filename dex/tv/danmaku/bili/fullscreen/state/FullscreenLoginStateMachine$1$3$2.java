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
/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$SkipLogin;", "stateSnapshot", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginIdlePage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$1$3$2", f = "IFullscreenLoginPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FullscreenLoginStateMachine$1$3$2 extends SuspendLambda implements Function3<IFullscreenLoginAction.SkipLogin, FullscreenLoginIdlePage, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FullscreenLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginStateMachine$1$3$2(FullscreenLoginStateMachine fullscreenLoginStateMachine, Continuation<? super FullscreenLoginStateMachine$1$3$2> continuation) {
        super(3, continuation);
        this.this$0 = fullscreenLoginStateMachine;
    }

    public final Object invoke(IFullscreenLoginAction.SkipLogin skipLogin, FullscreenLoginIdlePage fullscreenLoginIdlePage, Continuation<? super Unit> continuation) {
        FullscreenLoginStateMachine$1$3$2 fullscreenLoginStateMachine$1$3$2 = new FullscreenLoginStateMachine$1$3$2(this.this$0, continuation);
        fullscreenLoginStateMachine$1$3$2.L$0 = fullscreenLoginIdlePage;
        return fullscreenLoginStateMachine$1$3$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginReportService loginReportService;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                FullscreenLoginIdlePage stateSnapshot = (FullscreenLoginIdlePage) this.L$0;
                loginReportService = this.this$0.loginReportService;
                loginReportService.report("app.login.close.0.click", stateSnapshot.getCurrentPage().getLoginType(), TuplesKt.to("type", "skip"));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}