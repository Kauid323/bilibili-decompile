package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastLoginPage.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$EulaLinkClicked;", "stateSnapshot", "Ltv/danmaku/bili/fullscreen/state/FastLoginPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$1$3", f = "FastLoginPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FastLoginStateMachine$1$1$3 extends SuspendLambda implements Function3<IFullscreenLoginReportAction.EulaLinkClicked, FastLoginPage, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ FastLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastLoginStateMachine$1$1$3(FastLoginStateMachine fastLoginStateMachine, Continuation<? super FastLoginStateMachine$1$1$3> continuation) {
        super(3, continuation);
        this.this$0 = fastLoginStateMachine;
    }

    public final Object invoke(IFullscreenLoginReportAction.EulaLinkClicked eulaLinkClicked, FastLoginPage fastLoginPage, Continuation<? super Unit> continuation) {
        FastLoginStateMachine$1$1$3 fastLoginStateMachine$1$1$3 = new FastLoginStateMachine$1$1$3(this.this$0, continuation);
        fastLoginStateMachine$1$1$3.L$0 = eulaLinkClicked;
        fastLoginStateMachine$1$1$3.L$1 = fastLoginPage;
        return fastLoginStateMachine$1$1$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        LoginReportService loginReportService;
        String str2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                IFullscreenLoginReportAction.EulaLinkClicked action = (IFullscreenLoginReportAction.EulaLinkClicked) this.L$0;
                FastLoginPage stateSnapshot = (FastLoginPage) this.L$1;
                if (action.getInDialog()) {
                    str = "app.login.provision-popup.terms.click";
                } else {
                    str = "app.login.provision.terms.click";
                }
                loginReportService = this.this$0.loginReportService;
                String loginType = stateSnapshot.getLoginType();
                Pair<String, String>[] pairArr = new Pair[2];
                EulaLinkType type = action.getType();
                if (type instanceof EulaLinkType.Agreement) {
                    str2 = "agreement";
                } else if (type instanceof EulaLinkType.Privacy) {
                    str2 = "privacy";
                } else if (!(type instanceof EulaLinkType.Help) && !(type instanceof EulaLinkType.IspAgreement)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    str2 = "other";
                }
                pairArr[0] = TuplesKt.to("type", str2);
                EulaTriggerType triggerType = action.getTriggerType();
                String reportTypeValue = triggerType != null ? triggerType.getReportTypeValue() : null;
                if (reportTypeValue == null) {
                    reportTypeValue = "";
                }
                pairArr[1] = TuplesKt.to(LoginReporterV2.TRIGGER_TYPE_KEY, reportTypeValue);
                loginReportService.report(str, loginType, pairArr);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}