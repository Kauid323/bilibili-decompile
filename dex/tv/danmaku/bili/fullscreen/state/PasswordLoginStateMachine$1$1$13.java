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
/* compiled from: PasswordLoginPageState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginReportAction$EulaLinkClicked;", "stateSnapshot", "Ltv/danmaku/bili/fullscreen/state/PasswordLoginPageState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.PasswordLoginStateMachine$1$1$13", f = "PasswordLoginPageState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PasswordLoginStateMachine$1$1$13 extends SuspendLambda implements Function3<IFullscreenLoginReportAction.EulaLinkClicked, PasswordLoginPageState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PasswordLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordLoginStateMachine$1$1$13(PasswordLoginStateMachine passwordLoginStateMachine, Continuation<? super PasswordLoginStateMachine$1$1$13> continuation) {
        super(3, continuation);
        this.this$0 = passwordLoginStateMachine;
    }

    public final Object invoke(IFullscreenLoginReportAction.EulaLinkClicked eulaLinkClicked, PasswordLoginPageState passwordLoginPageState, Continuation<? super Unit> continuation) {
        PasswordLoginStateMachine$1$1$13 passwordLoginStateMachine$1$1$13 = new PasswordLoginStateMachine$1$1$13(this.this$0, continuation);
        passwordLoginStateMachine$1$1$13.L$0 = eulaLinkClicked;
        return passwordLoginStateMachine$1$1$13.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        LoginReportService loginReportService;
        String str2;
        String str3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                IFullscreenLoginReportAction.EulaLinkClicked action = (IFullscreenLoginReportAction.EulaLinkClicked) this.L$0;
                if (action.getInDialog()) {
                    str = "app.login.provision-popup.terms.click";
                } else {
                    str = "app.login.provision.terms.click";
                }
                loginReportService = this.this$0.loginReportService;
                str2 = this.this$0.loginType;
                Pair<String, String>[] pairArr = new Pair[2];
                EulaLinkType type = action.getType();
                if (type instanceof EulaLinkType.Agreement) {
                    str3 = "agreement";
                } else if (type instanceof EulaLinkType.Privacy) {
                    str3 = "privacy";
                } else if (!(type instanceof EulaLinkType.Help) && !(type instanceof EulaLinkType.IspAgreement)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    str3 = "other";
                }
                pairArr[0] = TuplesKt.to("type", str3);
                EulaTriggerType triggerType = action.getTriggerType();
                String reportTypeValue = triggerType != null ? triggerType.getReportTypeValue() : null;
                if (reportTypeValue == null) {
                    reportTypeValue = "";
                }
                pairArr[1] = TuplesKt.to(LoginReporterV2.TRIGGER_TYPE_KEY, reportTypeValue);
                loginReportService.report(str, str2, pairArr);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}