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
/* compiled from: FastLoginPage.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$AgreementCheckedAction;", "stateSnapshot", "Ltv/danmaku/bili/fullscreen/state/FastLoginPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$1$2", f = "FastLoginPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FastLoginStateMachine$1$1$2 extends SuspendLambda implements Function3<IFullscreenLoginAction.AgreementCheckedAction, FastLoginPage, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ FastLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastLoginStateMachine$1$1$2(FastLoginStateMachine fastLoginStateMachine, Continuation<? super FastLoginStateMachine$1$1$2> continuation) {
        super(3, continuation);
        this.this$0 = fastLoginStateMachine;
    }

    public final Object invoke(IFullscreenLoginAction.AgreementCheckedAction agreementCheckedAction, FastLoginPage fastLoginPage, Continuation<? super Unit> continuation) {
        FastLoginStateMachine$1$1$2 fastLoginStateMachine$1$1$2 = new FastLoginStateMachine$1$1$2(this.this$0, continuation);
        fastLoginStateMachine$1$1$2.L$0 = agreementCheckedAction;
        fastLoginStateMachine$1$1$2.L$1 = fastLoginPage;
        return fastLoginStateMachine$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginReportService loginReportService;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                IFullscreenLoginAction.AgreementCheckedAction action = (IFullscreenLoginAction.AgreementCheckedAction) this.L$0;
                FastLoginPage stateSnapshot = (FastLoginPage) this.L$1;
                loginReportService = this.this$0.loginReportService;
                loginReportService.report("app.login.provision.0.click", stateSnapshot.getLoginType(), TuplesKt.to("is_agree", LoginReportServiceKt.getReportString(action.getChecked())));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}