package tv.danmaku.bili.inner;

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
import tv.danmaku.bili.fullscreen.state.FullscreenLoginFastPage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginFastPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginStateMachine$1$2$1", f = "InnerLoginStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerLoginStateMachine$1$2$1 extends SuspendLambda implements Function2<FullscreenLoginFastPage, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InnerLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginStateMachine$1$2$1(InnerLoginStateMachine innerLoginStateMachine, Continuation<? super InnerLoginStateMachine$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = innerLoginStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> innerLoginStateMachine$1$2$1 = new InnerLoginStateMachine$1$2$1(this.this$0, continuation);
        innerLoginStateMachine$1$2$1.L$0 = obj;
        return innerLoginStateMachine$1$2$1;
    }

    public final Object invoke(FullscreenLoginFastPage fullscreenLoginFastPage, Continuation<? super Unit> continuation) {
        return create(fullscreenLoginFastPage, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginReportService loginReportService;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                FullscreenLoginFastPage it = (FullscreenLoginFastPage) this.L$0;
                loginReportService = this.this$0.loginReportService;
                LoginReportService.report$default(loginReportService, "app.login.0.0.show", it.getLoginType(), null, 4, null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}