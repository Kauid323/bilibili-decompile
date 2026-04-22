package tv.danmaku.bili.inner;

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
import tv.danmaku.bili.fullscreen.state.IFullscreenActionPage;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$TryOtherLoginWay;", "stateSnapshot", "Ltv/danmaku/bili/fullscreen/state/IFullscreenActionPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginStateMachine$1$7$2", f = "InnerLoginStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerLoginStateMachine$1$7$2 extends SuspendLambda implements Function3<IFullscreenLoginAction.TryOtherLoginWay, IFullscreenActionPage, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InnerLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginStateMachine$1$7$2(InnerLoginStateMachine innerLoginStateMachine, Continuation<? super InnerLoginStateMachine$1$7$2> continuation) {
        super(3, continuation);
        this.this$0 = innerLoginStateMachine;
    }

    public final Object invoke(IFullscreenLoginAction.TryOtherLoginWay tryOtherLoginWay, IFullscreenActionPage iFullscreenActionPage, Continuation<? super Unit> continuation) {
        InnerLoginStateMachine$1$7$2 innerLoginStateMachine$1$7$2 = new InnerLoginStateMachine$1$7$2(this.this$0, continuation);
        innerLoginStateMachine$1$7$2.L$0 = iFullscreenActionPage;
        return innerLoginStateMachine$1$7$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginReportService loginReportService;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                IFullscreenActionPage stateSnapshot = (IFullscreenActionPage) this.L$0;
                loginReportService = this.this$0.loginReportService;
                loginReportService.report("app.login.switch-option.0.click", stateSnapshot.getLoginType(), TuplesKt.to("type", "other"));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}