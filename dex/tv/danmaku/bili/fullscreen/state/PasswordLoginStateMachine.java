package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.ILoginResult;
import tv.danmaku.bili.fullscreen.service.IPasswordLoginService;
import tv.danmaku.bili.fullscreen.service.LoginCaptcha;
import tv.danmaku.bili.fullscreen.service.LoginIntercepted;
import tv.danmaku.bili.fullscreen.service.LoginRedirected;
import tv.danmaku.bili.fullscreen.service.LoginReportParams;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.LoginSucceed;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;
import tv.danmaku.bili.fullscreen.state.IPasswordLoginAction;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: PasswordLoginPageState.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0082@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/PasswordLoginStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Ltv/danmaku/bili/fullscreen/state/IPasswordLoginPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "loginService", "Ltv/danmaku/bili/fullscreen/service/IPasswordLoginService;", "loginReportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "<init>", "(Ltv/danmaku/bili/fullscreen/service/IPasswordLoginService;Ltv/danmaku/bili/fullscreen/service/LoginReportService;)V", "loginType", "", "handlePwdLogin", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/PasswordLoginPageState;", "inState", "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/PasswordLoginLoadingState;", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PasswordLoginStateMachine extends FlowReduxStateMachine<IPasswordLoginPage, IFullscreenAction> {
    public static final int $stable = 8;
    private final LoginReportService loginReportService;
    private final IPasswordLoginService loginService;
    private final String loginType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PasswordLoginStateMachine(IPasswordLoginService loginService, LoginReportService loginReportService) {
        super(new PasswordLoginPageState(null, null, false, null, false, null, null, null, null, BR.roleTitle, null));
        Intrinsics.checkNotNullParameter(loginService, "loginService");
        Intrinsics.checkNotNullParameter(loginReportService, "loginReportService");
        this.loginService = loginService;
        this.loginReportService = loginReportService;
        this.loginType = "pwd_fullscreen_new";
        spec(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PasswordLoginStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = PasswordLoginStateMachine._init_$lambda$0(PasswordLoginStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final PasswordLoginStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PasswordLoginStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return PasswordLoginStateMachine.lambda$0$0(PasswordLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(PasswordLoginPageState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PasswordLoginStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return PasswordLoginStateMachine.lambda$0$1(PasswordLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(PasswordLoginLoadingState.class), block$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(PasswordLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new PasswordLoginStateMachine$1$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IPasswordLoginAction.AccountInputAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new PasswordLoginStateMachine$1$1$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(IPasswordLoginAction.PasswordInputAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new PasswordLoginStateMachine$1$1$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.DismissEulaAction.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new PasswordLoginStateMachine$1$1$4(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.AgreementCheckedAction.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new PasswordLoginStateMachine$1$1$5(this$0, null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.AgreementCheckedAction.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv6 = new PasswordLoginStateMachine$1$1$6(null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.LoginAction.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock $this$iv7 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv7 = new PasswordLoginStateMachine$1$1$7(this$0, null);
        ExecutionPolicy executionPolicy$iv7 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv7.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.LoginAction.class), executionPolicy$iv7, handler$iv7);
        BaseBuilderBlock $this$iv8 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv8 = new PasswordLoginStateMachine$1$1$8(null);
        ExecutionPolicy executionPolicy$iv8 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv8.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.DismissCaptchaAction.class), executionPolicy$iv8, handler$iv8);
        BaseBuilderBlock $this$iv9 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv9 = new PasswordLoginStateMachine$1$1$9(null);
        ExecutionPolicy executionPolicy$iv9 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv9.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.ShowEulaAction.class), executionPolicy$iv9, handler$iv9);
        BaseBuilderBlock $this$iv10 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv10 = new PasswordLoginStateMachine$1$1$10(this$0, null);
        ExecutionPolicy executionPolicy$iv10 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv10.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.ShowCaptchaDialog.class), executionPolicy$iv10, handler$iv10);
        BaseBuilderBlock $this$iv11 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv11 = new PasswordLoginStateMachine$1$1$11(this$0, null);
        ExecutionPolicy executionPolicy$iv11 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv11.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.CaptchaVerified.class), executionPolicy$iv11, handler$iv11);
        BaseBuilderBlock $this$iv12 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv12 = new PasswordLoginStateMachine$1$1$12(this$0, null);
        ExecutionPolicy executionPolicy$iv12 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv12.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.CaptchaClosed.class), executionPolicy$iv12, handler$iv12);
        BaseBuilderBlock $this$iv13 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv13 = new PasswordLoginStateMachine$1$1$13(this$0, null);
        ExecutionPolicy executionPolicy$iv13 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv13.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.EulaLinkClicked.class), executionPolicy$iv13, handler$iv13);
        BaseBuilderBlock $this$iv14 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv14 = new PasswordLoginStateMachine$1$1$14(this$0, null);
        ExecutionPolicy executionPolicy$iv14 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv14.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.FindPwdByPhone.class), executionPolicy$iv14, handler$iv14);
        BaseBuilderBlock $this$iv15 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv15 = new PasswordLoginStateMachine$1$1$15(this$0, null);
        ExecutionPolicy executionPolicy$iv15 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv15.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.FindPwdByEMail.class), executionPolicy$iv15, handler$iv15);
        BaseBuilderBlock $this$iv16 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv16 = new PasswordLoginStateMachine$1$1$16(this$0, null);
        ExecutionPolicy executionPolicy$iv16 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv16.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.SwitchToSms.class), executionPolicy$iv16, handler$iv16);
        BaseBuilderBlock $this$iv17 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv17 = new PasswordLoginStateMachine$1$1$17(this$0, null);
        ExecutionPolicy executionPolicy$iv17 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv17.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.SwitchToPassword.class), executionPolicy$iv17, handler$iv17);
        BaseBuilderBlock $this$iv18 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv18 = new PasswordLoginStateMachine$1$1$18(this$0, null);
        ExecutionPolicy executionPolicy$iv18 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv18.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.LoginForgetClick.class), executionPolicy$iv18, handler$iv18);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(PasswordLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new PasswordLoginStateMachine$1$2$1(this$0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handlePwdLogin(State<PasswordLoginLoadingState> state, Continuation<? super ChangedState<PasswordLoginPageState>> continuation) {
        Continuation<? super ILoginResult> passwordLoginStateMachine$handlePwdLogin$1;
        Object login;
        State inState;
        PasswordLoginStateMachine passwordLoginStateMachine;
        final ILoginResult loginResult;
        if (continuation instanceof PasswordLoginStateMachine$handlePwdLogin$1) {
            passwordLoginStateMachine$handlePwdLogin$1 = (PasswordLoginStateMachine$handlePwdLogin$1) continuation;
            if ((passwordLoginStateMachine$handlePwdLogin$1.label & Integer.MIN_VALUE) != 0) {
                passwordLoginStateMachine$handlePwdLogin$1.label -= Integer.MIN_VALUE;
                Object $result = passwordLoginStateMachine$handlePwdLogin$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (passwordLoginStateMachine$handlePwdLogin$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        PasswordLoginPageState state2 = ((PasswordLoginLoadingState) state.getSnapshot()).getOriginal();
                        IPasswordLoginService iPasswordLoginService = this.loginService;
                        LoginWay loginWay = state2.getLoginWay();
                        String account = state2.getAccount();
                        String password = state2.getPassword();
                        Map<String, String> captchaInput = ((PasswordLoginLoadingState) state.getSnapshot()).getCaptchaInput();
                        LoginReportParams reportParams = this.loginReportService.getReportParams(this.loginType);
                        passwordLoginStateMachine$handlePwdLogin$1.L$0 = state;
                        passwordLoginStateMachine$handlePwdLogin$1.label = 1;
                        login = iPasswordLoginService.login(loginWay, account, password, captchaInput, reportParams, passwordLoginStateMachine$handlePwdLogin$1);
                        if (login == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inState = state;
                        passwordLoginStateMachine = this;
                        break;
                    case 1:
                        passwordLoginStateMachine = this;
                        State inState2 = (State) passwordLoginStateMachine$handlePwdLogin$1.L$0;
                        ResultKt.throwOnFailure($result);
                        inState = inState2;
                        login = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                loginResult = (ILoginResult) login;
                if (loginResult instanceof LoginSucceed) {
                    passwordLoginStateMachine.loginReportService.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, passwordLoginStateMachine.loginType, TuplesKt.to("method", ((LoginSucceed) loginResult).getLoginWay().getSucceedMethod()), TuplesKt.to("type", "pwd"));
                }
                return inState.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PasswordLoginStateMachine$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        PasswordLoginPageState handlePwdLogin$lambda$0;
                        handlePwdLogin$lambda$0 = PasswordLoginStateMachine.handlePwdLogin$lambda$0(ILoginResult.this, (PasswordLoginLoadingState) obj);
                        return handlePwdLogin$lambda$0;
                    }
                });
            }
        }
        passwordLoginStateMachine$handlePwdLogin$1 = new PasswordLoginStateMachine$handlePwdLogin$1(this, continuation);
        Object $result2 = passwordLoginStateMachine$handlePwdLogin$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (passwordLoginStateMachine$handlePwdLogin$1.label) {
        }
        loginResult = (ILoginResult) login;
        if (loginResult instanceof LoginSucceed) {
        }
        return inState.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PasswordLoginStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                PasswordLoginPageState handlePwdLogin$lambda$0;
                handlePwdLogin$lambda$0 = PasswordLoginStateMachine.handlePwdLogin$lambda$0(ILoginResult.this, (PasswordLoginLoadingState) obj);
                return handlePwdLogin$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PasswordLoginPageState handlePwdLogin$lambda$0(ILoginResult $loginResult, PasswordLoginLoadingState $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        if ($loginResult instanceof tv.danmaku.bili.fullscreen.service.LoginFailed) {
            PasswordLoginPageState original = $this$override.getOriginal();
            Exception loginError = ((tv.danmaku.bili.fullscreen.service.LoginFailed) $loginResult).getLoginError();
            return PasswordLoginPageState.copy$default(original, null, null, false, null, false, null, null, new ToastInfo((loginError == null || (r0 = loginError.getMessage()) == null) ? "" : "", 0L, 2, null), null, BR.microphoneVolume, null);
        } else if ($loginResult instanceof LoginIntercepted) {
            return PasswordLoginPageState.copy$default($this$override.getOriginal(), null, null, false, null, false, ((LoginIntercepted) $loginResult).getIntercepted(), null, null, null, BR.protocalTips, null);
        } else {
            if ($loginResult instanceof LoginRedirected) {
                return PasswordLoginPageState.copy$default($this$override.getOriginal(), null, null, false, null, false, ((LoginRedirected) $loginResult).getRedirect(), null, null, null, BR.protocalTips, null);
            }
            if ($loginResult instanceof LoginCaptcha) {
                return PasswordLoginPageState.copy$default($this$override.getOriginal(), null, null, false, null, false, null, ((LoginCaptcha) $loginResult).getCaptchaDisplay(), null, null, BR.playingLottieVisible, null);
            }
            if ($loginResult instanceof LoginSucceed) {
                return PasswordLoginPageState.copy$default($this$override.getOriginal(), null, null, false, null, true, null, null, null, null, BR.rightBottomBadgeMaskDrawable, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}