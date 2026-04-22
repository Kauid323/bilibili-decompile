package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.exp.LoginExpType;
import tv.danmaku.bili.fullscreen.service.IPhoneService;
import tv.danmaku.bili.fullscreen.service.IspCode;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.PhoneInfo;
import tv.danmaku.bili.fullscreen.service.TechTrackService;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginPhoneIdlePage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$1$1$1", f = "IFullscreenLoginPage.kt", i = {0}, l = {302}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
public final class FullscreenLoginStateMachine$1$1$1 extends SuspendLambda implements Function2<State<FullscreenLoginPhoneIdlePage>, Continuation<? super ChangedState<? extends IFullscreenLoginState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FullscreenLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenLoginStateMachine$1$1$1(FullscreenLoginStateMachine fullscreenLoginStateMachine, Continuation<? super FullscreenLoginStateMachine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = fullscreenLoginStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fullscreenLoginStateMachine$1$1$1 = new FullscreenLoginStateMachine$1$1$1(this.this$0, continuation);
        fullscreenLoginStateMachine$1$1$1.L$0 = obj;
        return fullscreenLoginStateMachine$1$1$1;
    }

    public final Object invoke(State<FullscreenLoginPhoneIdlePage> state, Continuation<? super ChangedState<? extends IFullscreenLoginState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State it;
        TechTrackService techTrackService;
        LoginReportService loginReportService;
        TechTrackService techTrackService2;
        LoginReportService loginReportService2;
        IPhoneService iPhoneService;
        LoginExpType loginExpType;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                it = (State) this.L$0;
                JobKt.ensureActive(getContext());
                techTrackService = this.this$0.techTrackService;
                loginReportService = this.this$0.loginReportService;
                techTrackService.onPhase(loginReportService.getSpmid(), OnePassLoginPhaseType.Trigger.INSTANCE);
                techTrackService2 = this.this$0.techTrackService;
                loginReportService2 = this.this$0.loginReportService;
                techTrackService2.onPhase(loginReportService2.getSpmid(), OnePassLoginPhaseType.PrepareRemoteLoginInfo.INSTANCE);
                iPhoneService = this.this$0.phoneService;
                this.L$0 = it;
                this.label = 1;
                Object phoneInfo = iPhoneService.getPhoneInfo((Continuation) this);
                if (phoneInfo != coroutine_suspended) {
                    $result = phoneInfo;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                it = (State) this.L$0;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final PhoneInfo phone = (PhoneInfo) $result;
        if (StringsKt.isBlank(phone.getSecurePhone()) || phone.getIspCode() == IspCode.Unknown) {
            loginExpType = this.this$0.loginExp;
            if (loginExpType.getShowSms()) {
                BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Fail to get phone number");
                final FullscreenLoginStateMachine fullscreenLoginStateMachine = this.this$0;
                return it.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$1$1$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        FullscreenLoginIdlePage invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = FullscreenLoginStateMachine$1$1$1.invokeSuspend$lambda$1(FullscreenLoginStateMachine.this, (FullscreenLoginPhoneIdlePage) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            }
            BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Fail to get phone number, skip sms page");
            return it.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$1$1$1$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    FullscreenLoginInvalidPage invokeSuspend$lambda$2;
                    invokeSuspend$lambda$2 = FullscreenLoginStateMachine$1$1$1.invokeSuspend$lambda$2((FullscreenLoginPhoneIdlePage) obj);
                    return invokeSuspend$lambda$2;
                }
            });
        }
        return it.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$1$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                FullscreenLoginPhonePage invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = FullscreenLoginStateMachine$1$1$1.invokeSuspend$lambda$0(PhoneInfo.this, (FullscreenLoginPhoneIdlePage) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FullscreenLoginPhonePage invokeSuspend$lambda$0(PhoneInfo $phone, FullscreenLoginPhoneIdlePage $this$override) {
        return new FullscreenLoginPhonePage(new PhoneOnePassLoginState($phone, false, null, false, null, null, null, BR.countdownTotal, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FullscreenLoginIdlePage invokeSuspend$lambda$1(FullscreenLoginStateMachine this$0, FullscreenLoginPhoneIdlePage $this$override) {
        LoginExpType loginExpType;
        loginExpType = this$0.loginExp;
        return new FullscreenLoginIdlePage(loginExpType.getSmsSkippable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FullscreenLoginInvalidPage invokeSuspend$lambda$2(FullscreenLoginPhoneIdlePage $this$override) {
        return FullscreenLoginInvalidPage.INSTANCE;
    }
}