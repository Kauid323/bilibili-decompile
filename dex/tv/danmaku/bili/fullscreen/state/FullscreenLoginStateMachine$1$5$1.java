package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.LoginReportService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginPasswordPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$1$5$1", f = "IFullscreenLoginPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FullscreenLoginStateMachine$1$5$1 extends SuspendLambda implements Function2<FullscreenLoginPasswordPage, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FullscreenLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginStateMachine$1$5$1(FullscreenLoginStateMachine fullscreenLoginStateMachine, Continuation<? super FullscreenLoginStateMachine$1$5$1> continuation) {
        super(2, continuation);
        this.this$0 = fullscreenLoginStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fullscreenLoginStateMachine$1$5$1 = new FullscreenLoginStateMachine$1$5$1(this.this$0, continuation);
        fullscreenLoginStateMachine$1$5$1.L$0 = obj;
        return fullscreenLoginStateMachine$1$5$1;
    }

    public final Object invoke(FullscreenLoginPasswordPage fullscreenLoginPasswordPage, Continuation<? super Unit> continuation) {
        return create(fullscreenLoginPasswordPage, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginReportService loginReportService;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                FullscreenLoginPasswordPage it = (FullscreenLoginPasswordPage) this.L$0;
                loginReportService = this.this$0.loginReportService;
                LoginReportService.report$default(loginReportService, "app.login.0.0.show", it.getLoginType(), null, 4, null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}