package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.ILoginResult;
import tv.danmaku.bili.fullscreen.service.IPhoneOnePassLoginService;
import tv.danmaku.bili.fullscreen.service.LoginCaptcha;
import tv.danmaku.bili.fullscreen.service.LoginIntercepted;
import tv.danmaku.bili.fullscreen.service.LoginRedirected;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.LoginSucceed;
import tv.danmaku.bili.fullscreen.service.PhoneInfo;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhoneOnePassLoginState.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/IPhoneOnePassState;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/PhoneOnePassLoginLoadingState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.PhoneOnePassStateMachine$1$2$1", f = "PhoneOnePassLoginState.kt", i = {0, 0}, l = {BR.episodeDurationText}, m = "invokeSuspend", n = {"it", "origin"}, s = {"L$0", "L$1"}, v = 1)
public final class PhoneOnePassStateMachine$1$2$1 extends SuspendLambda implements Function2<State<PhoneOnePassLoginLoadingState>, Continuation<? super ChangedState<? extends IPhoneOnePassState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PhoneOnePassStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneOnePassStateMachine$1$2$1(PhoneOnePassStateMachine phoneOnePassStateMachine, Continuation<? super PhoneOnePassStateMachine$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = phoneOnePassStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> phoneOnePassStateMachine$1$2$1 = new PhoneOnePassStateMachine$1$2$1(this.this$0, continuation);
        phoneOnePassStateMachine$1$2$1.L$0 = obj;
        return phoneOnePassStateMachine$1$2$1;
    }

    public final Object invoke(State<PhoneOnePassLoginLoadingState> state, Continuation<? super ChangedState<? extends IPhoneOnePassState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State it;
        final PhoneOnePassLoginState origin;
        IPhoneOnePassLoginService iPhoneOnePassLoginService;
        LoginReportService loginReportService;
        String str;
        LoginReportService loginReportService2;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                it = (State) this.L$0;
                origin = ((PhoneOnePassLoginLoadingState) it.getSnapshot()).getOrigin();
                iPhoneOnePassLoginService = this.this$0.service;
                LoginWay loginWay = origin.getLoginWay();
                PhoneInfo phone = origin.getPhone();
                loginReportService = this.this$0.loginReportService;
                str = this.this$0.loginType;
                this.L$0 = it;
                this.L$1 = origin;
                this.label = 1;
                Object login = iPhoneOnePassLoginService.login(loginWay, phone, loginReportService.getReportParams(str), (Continuation) this);
                if (login != coroutine_suspended) {
                    $result = login;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                it = (State) this.L$0;
                ResultKt.throwOnFailure($result);
                origin = (PhoneOnePassLoginState) this.L$1;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final ILoginResult result = (ILoginResult) $result;
        if (result instanceof LoginSucceed) {
            loginReportService2 = this.this$0.loginReportService;
            str2 = this.this$0.loginType;
            loginReportService2.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, str2, TuplesKt.to("method", ((LoginSucceed) result).getLoginWay().getSucceedMethod()), TuplesKt.to("type", "onepass"));
        }
        return it.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PhoneOnePassStateMachine$1$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                PhoneOnePassLoginState invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = PhoneOnePassStateMachine$1$2$1.invokeSuspend$lambda$0(ILoginResult.this, origin, (PhoneOnePassLoginLoadingState) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PhoneOnePassLoginState invokeSuspend$lambda$0(ILoginResult $result, PhoneOnePassLoginState $origin, PhoneOnePassLoginLoadingState $this$override) {
        if ($result instanceof tv.danmaku.bili.fullscreen.service.LoginFailed) {
            Exception loginError = ((tv.danmaku.bili.fullscreen.service.LoginFailed) $result).getLoginError();
            return PhoneOnePassLoginState.copy$default($origin, null, false, null, false, null, new ToastInfo((loginError == null || (r0 = loginError.getMessage()) == null) ? "" : "", 0L, 2, null), null, 87, null);
        } else if ($result instanceof LoginIntercepted) {
            return PhoneOnePassLoginState.copy$default($origin, null, false, null, false, ((LoginIntercepted) $result).getIntercepted(), null, null, 103, null);
        } else {
            if ($result instanceof LoginRedirected) {
                return PhoneOnePassLoginState.copy$default($origin, null, false, null, false, ((LoginRedirected) $result).getRedirect(), null, null, 103, null);
            }
            if ($result instanceof LoginCaptcha) {
                return $origin;
            }
            if ($result instanceof LoginSucceed) {
                return PhoneOnePassLoginState.copy$default($origin, null, false, null, true, null, null, null, 119, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}