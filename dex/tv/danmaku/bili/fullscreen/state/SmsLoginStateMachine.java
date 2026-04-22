package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import com.freeletics.mad.statemachine.StateMachine;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.service.ILoginResult;
import tv.danmaku.bili.fullscreen.service.INetCodeStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.ISmsLoginService;
import tv.danmaku.bili.fullscreen.service.LoginCaptcha;
import tv.danmaku.bili.fullscreen.service.LoginIntercepted;
import tv.danmaku.bili.fullscreen.service.LoginRedirected;
import tv.danmaku.bili.fullscreen.service.LoginReportParams;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.LoginSucceed;
import tv.danmaku.bili.fullscreen.service.SmsCaptchaStatus;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;
import tv.danmaku.bili.fullscreen.state.ISmsLoginAction;
import tv.danmaku.bili.fullscreen.state.NetCodeAction;
import tv.danmaku.bili.sms.SnsPhoneBindingData;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0082@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/SmsLoginStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "initialState", "smsLoginService", "Ltv/danmaku/bili/fullscreen/service/ISmsLoginService;", "loginReportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "netCodeStateMachineProvider", "Ltv/danmaku/bili/fullscreen/service/INetCodeStateMachineFactory;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;Ltv/danmaku/bili/fullscreen/service/ISmsLoginService;Ltv/danmaku/bili/fullscreen/service/LoginReportService;Ltv/danmaku/bili/fullscreen/service/INetCodeStateMachineFactory;)V", "getInitialState", "()Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "loginType", "", "handleLoginState", "Lcom/freeletics/flowredux/dsl/ChangedState;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginLoadingState;", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCountingFlow", "Lkotlinx/coroutines/flow/Flow;", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginStateMachine extends FlowReduxStateMachine<ISmsLoginPageState, IFullscreenAction> {
    public static final int $stable = 8;
    private final ISmsLoginPageState initialState;
    private final LoginReportService loginReportService;
    private final String loginType;
    private final INetCodeStateMachineFactory netCodeStateMachineProvider;
    private final ISmsLoginService smsLoginService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public SmsLoginStateMachine(@Assisted ISmsLoginPageState initialState, ISmsLoginService smsLoginService, LoginReportService loginReportService, INetCodeStateMachineFactory netCodeStateMachineProvider) {
        super(initialState);
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(smsLoginService, "smsLoginService");
        Intrinsics.checkNotNullParameter(loginReportService, "loginReportService");
        Intrinsics.checkNotNullParameter(netCodeStateMachineProvider, "netCodeStateMachineProvider");
        this.initialState = initialState;
        this.smsLoginService = smsLoginService;
        this.loginReportService = loginReportService;
        this.netCodeStateMachineProvider = netCodeStateMachineProvider;
        this.loginType = "sms_fullscreen_new";
        spec(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = SmsLoginStateMachine._init_$lambda$0(SmsLoginStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    public final ISmsLoginPageState getInitialState() {
        return this.initialState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final SmsLoginStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return SmsLoginStateMachine.lambda$0$0(SmsLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(SmsLoginPageInitialState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return SmsLoginStateMachine.lambda$0$1(SmsLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(ISmsLoginValidState.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return SmsLoginStateMachine.lambda$0$2((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(SmsLoginSelectCountryCodeState.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return SmsLoginStateMachine.lambda$0$3(SmsLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(SmsLoginPageInputIdleState.class), block$iv4);
        Function1 block$iv5 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return SmsLoginStateMachine.lambda$0$4(SmsLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(ISmsLoginCountingState.class), block$iv5);
        Function1 block$iv6 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                return SmsLoginStateMachine.lambda$0$5(SmsLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(ISmsLoginLoadingState.class), block$iv6);
        Function1 block$iv7 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return SmsLoginStateMachine.lambda$0$6(SmsLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(ISmsLoginPageState.class), block$iv7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(SmsLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new SmsLoginStateMachine$1$1$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(SmsLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new SmsLoginStateMachine$1$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ISmsLoginAction.PhoneInputAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new SmsLoginStateMachine$1$2$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(ISmsLoginAction.SmsCodeInputAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new SmsLoginStateMachine$1$2$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.AgreementCheckedAction.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new SmsLoginStateMachine$1$2$4(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.AgreementCheckedAction.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new SmsLoginStateMachine$1$2$5(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.LoginAction.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv6 = new SmsLoginStateMachine$1$2$6(this$0, null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.LoginAction.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock $this$iv7 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv7 = new SmsLoginStateMachine$1$2$7(null);
        ExecutionPolicy executionPolicy$iv7 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv7.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.DismissCaptchaAction.class), executionPolicy$iv7, handler$iv7);
        BaseBuilderBlock $this$iv8 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv8 = new SmsLoginStateMachine$1$2$8(null);
        ExecutionPolicy executionPolicy$iv8 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv8.on(Reflection.getOrCreateKotlinClass(ISmsLoginAction.SelectCountryCode.class), executionPolicy$iv8, handler$iv8);
        BaseBuilderBlock $this$iv9 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv9 = new SmsLoginStateMachine$1$2$9(this$0, null);
        ExecutionPolicy executionPolicy$iv9 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv9.onActionEffect(Reflection.getOrCreateKotlinClass(ISmsLoginAction.SelectCountryCode.class), executionPolicy$iv9, handler$iv9);
        BaseBuilderBlock $this$iv10 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv10 = new SmsLoginStateMachine$1$2$10(null);
        ExecutionPolicy executionPolicy$iv10 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv10.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.ShowEulaAction.class), executionPolicy$iv10, handler$iv10);
        BaseBuilderBlock $this$iv11 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv11 = new SmsLoginStateMachine$1$2$11(null);
        ExecutionPolicy executionPolicy$iv11 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv11.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.DismissEulaAction.class), executionPolicy$iv11, handler$iv11);
        BaseBuilderBlock $this$iv12 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv12 = new SmsLoginStateMachine$1$2$12(this$0, null);
        ExecutionPolicy executionPolicy$iv12 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv12.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.LoginHelpClick.class), executionPolicy$iv12, handler$iv12);
        BaseBuilderBlock $this$iv13 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv13 = new SmsLoginStateMachine$1$2$13(this$0, null);
        ExecutionPolicy executionPolicy$iv13 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv13.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.SwitchToSms.class), executionPolicy$iv13, handler$iv13);
        BaseBuilderBlock $this$iv14 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv14 = new SmsLoginStateMachine$1$2$14(this$0, null);
        ExecutionPolicy executionPolicy$iv14 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv14.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.SwitchToPassword.class), executionPolicy$iv14, handler$iv14);
        BaseBuilderBlock $this$iv15 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv15 = new SmsLoginStateMachine$1$2$15(this$0, null);
        ExecutionPolicy executionPolicy$iv15 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv15.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.LoginForgetClick.class), executionPolicy$iv15, handler$iv15);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new SmsLoginStateMachine$1$3$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ISmsLoginAction.OnCountryCodeSelected.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new SmsLoginStateMachine$1$3$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(ISmsLoginAction.OnCountryCodeSelectCancel.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$3(SmsLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new SmsLoginStateMachine$1$4$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(ISmsLoginAction.ClickSendSmsAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new SmsLoginStateMachine$1$4$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(ISmsLoginAction.SendSmsAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new SmsLoginStateMachine$1$4$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.ShowCaptchaDialog.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new SmsLoginStateMachine$1$4$4(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.CaptchaVerified.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new SmsLoginStateMachine$1$4$5(this$0, null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.CaptchaClosed.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv6 = new SmsLoginStateMachine$1$4$6(this$0, null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.EulaLinkClicked.class), executionPolicy$iv6, handler$iv6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$4(SmsLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$inState, this$0.getCountingFlow(), (ExecutionPolicy) null, new SmsLoginStateMachine$1$5$1(null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$5(SmsLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new SmsLoginStateMachine$1$6$1(this$0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$6(final SmsLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterStartStateMachine(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return SmsLoginStateMachine.lambda$0$6$0(SmsLoginStateMachine.this, (ISmsLoginPageState) obj);
            }
        }, new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return SmsLoginStateMachine.lambda$0$6$1(SmsLoginStateMachine.this, (IFullscreenAction) obj);
            }
        }, new Function2() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                return SmsLoginStateMachine.lambda$0$6$2((State) obj, (NetCodeState) obj2);
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new SmsLoginStateMachine$1$7$4(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.NetCodeAuth.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final StateMachine lambda$0$6$0(SmsLoginStateMachine this$0, ISmsLoginPageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.netCodeStateMachineProvider.create(it.getNetCodeState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final NetCodeAction lambda$0$6$1(SmsLoginStateMachine this$0, IFullscreenAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof IFullscreenLoginAction.NetCodeAuth) {
            return ((IFullscreenLoginAction.NetCodeAuth) it).getCheckEula() ? null : NetCodeAction.Authorize.INSTANCE;
        } else if (it instanceof IFullscreenLoginAction.NetCodeAuthResult) {
            return new NetCodeAction.AuthorizeResult(((IFullscreenLoginAction.NetCodeAuthResult) it).m1110getResultd1pmJ48());
        } else {
            if (it instanceof IFullscreenLoginAction.NetCodeVerifyResult) {
                return new NetCodeAction.VerifyResult(((IFullscreenLoginAction.NetCodeVerifyResult) it).m1112getResultd1pmJ48(), this$0.loginType);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ChangedState lambda$0$6$2(State state, final NetCodeState subState) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(subState, "subState");
        return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return SmsLoginStateMachine.lambda$0$6$2$0(NetCodeState.this, (ISmsLoginPageState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ISmsLoginPageState lambda$0$6$2$0(final NetCodeState $subState, ISmsLoginPageState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        ISmsLoginPageState $this$lambda_u240_u246_u242_u240_u241 = $this$mutate.mutateInput(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return SmsLoginStateMachine.lambda$0$6$2$0$0(NetCodeState.this, (SmsLoginInput) obj);
            }
        });
        return $subState instanceof Toasting ? $this$lambda_u240_u246_u242_u240_u241.toast(((Toasting) $subState).getToastInfo()) : $this$lambda_u240_u246_u242_u240_u241;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final SmsLoginInput lambda$0$6$2$0$0(NetCodeState $subState, SmsLoginInput $this$mutateInput) {
        Intrinsics.checkNotNullParameter($this$mutateInput, "$this$mutateInput");
        return SmsLoginInput.copy$default($this$mutateInput, null, null, false, null, null, false, null, null, null, null, null, $subState, 2047, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleLoginState(State<ISmsLoginLoadingState> state, Continuation<? super ChangedState<? extends ISmsLoginPageState>> continuation) {
        Continuation<? super ILoginResult> smsLoginStateMachine$handleLoginState$1;
        SmsLoginStateMachine smsLoginStateMachine;
        Object login;
        State state2;
        final ISmsLoginLoadingState current;
        ILoginResult result;
        final Pair newInput;
        if (continuation instanceof SmsLoginStateMachine$handleLoginState$1) {
            smsLoginStateMachine$handleLoginState$1 = (SmsLoginStateMachine$handleLoginState$1) continuation;
            if ((smsLoginStateMachine$handleLoginState$1.label & Integer.MIN_VALUE) != 0) {
                smsLoginStateMachine$handleLoginState$1.label -= Integer.MIN_VALUE;
                Object $result = smsLoginStateMachine$handleLoginState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (smsLoginStateMachine$handleLoginState$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        smsLoginStateMachine = this;
                        final ISmsLoginLoadingState current2 = (ISmsLoginLoadingState) state.getSnapshot();
                        final SmsLoginInput input = current2.getInput();
                        SmsCaptchaStatus status = input.getCaptchaStatus();
                        if (status != null) {
                            ISmsLoginService iSmsLoginService = smsLoginStateMachine.smsLoginService;
                            LoginWay loginWay = input.getLoginWay();
                            String smsCode = current2.getInput().getSmsCode();
                            LoginReportParams reportParams = smsLoginStateMachine.loginReportService.getReportParams(smsLoginStateMachine.loginType);
                            SnsPhoneBindingData snsPhoneBindingData = NetCodeStateKt.getSnsPhoneBindingData(input.getNetCodeState());
                            smsLoginStateMachine$handleLoginState$1.L$0 = state;
                            smsLoginStateMachine$handleLoginState$1.L$1 = current2;
                            smsLoginStateMachine$handleLoginState$1.label = 1;
                            login = iSmsLoginService.login(loginWay, status, smsCode, reportParams, snsPhoneBindingData, smsLoginStateMachine$handleLoginState$1);
                            if (login == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            state2 = state;
                            current = current2;
                            break;
                        } else {
                            return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda14
                                public final Object invoke(Object obj) {
                                    ISmsLoginValidState handleLoginState$lambda$1;
                                    handleLoginState$lambda$1 = SmsLoginStateMachine.handleLoginState$lambda$1(ISmsLoginLoadingState.this, input, (ISmsLoginLoadingState) obj);
                                    return handleLoginState$lambda$1;
                                }
                            });
                        }
                    case 1:
                        current = (ISmsLoginLoadingState) smsLoginStateMachine$handleLoginState$1.L$1;
                        state2 = (State) smsLoginStateMachine$handleLoginState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        smsLoginStateMachine = this;
                        login = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                result = (ILoginResult) login;
                if (result instanceof LoginSucceed) {
                    smsLoginStateMachine.loginReportService.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, smsLoginStateMachine.loginType, TuplesKt.to("method", ((LoginSucceed) result).getLoginWay().getSucceedMethod()), TuplesKt.to("type", "sms"));
                    if (((LoginSucceed) result).getNewUser()) {
                        LoginReportService.report$default(smsLoginStateMachine.loginReportService, LoginReporterV2.Show.APP_REGISTER_PASSED_0_SHOW, smsLoginStateMachine.loginType, null, 4, null);
                    }
                }
                if (!(result instanceof tv.danmaku.bili.fullscreen.service.LoginFailed)) {
                    Boolean boxBoolean = Boxing.boxBoolean(false);
                    SmsLoginInput input2 = current.getInput();
                    Exception loginError = ((tv.danmaku.bili.fullscreen.service.LoginFailed) result).getLoginError();
                    newInput = TuplesKt.to(boxBoolean, SmsLoginInput.copy$default(input2, null, null, false, null, null, false, null, null, new ToastInfo((loginError == null || (r3 = loginError.getMessage()) == null) ? "" : "", 0L, 2, null), null, null, null, 3839, null));
                } else if (result instanceof LoginIntercepted) {
                    newInput = TuplesKt.to(Boxing.boxBoolean(false), SmsLoginInput.copy$default(current.getInput(), null, null, false, null, null, false, null, ((LoginIntercepted) result).getIntercepted(), null, null, null, null, 3967, null));
                } else if (result instanceof LoginRedirected) {
                    newInput = TuplesKt.to(Boxing.boxBoolean(false), SmsLoginInput.copy$default(current.getInput(), null, null, false, null, null, false, null, ((LoginRedirected) result).getRedirect(), null, null, null, null, 3967, null));
                } else if (result instanceof LoginSucceed) {
                    newInput = TuplesKt.to(Boxing.boxBoolean(true), current.getInput());
                } else if (!(result instanceof LoginCaptcha)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    newInput = TuplesKt.to(Boxing.boxBoolean(false), current.getInput());
                }
                return state2.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        ISmsLoginValidState handleLoginState$lambda$0;
                        handleLoginState$lambda$0 = SmsLoginStateMachine.handleLoginState$lambda$0(ISmsLoginLoadingState.this, newInput, (ISmsLoginLoadingState) obj);
                        return handleLoginState$lambda$0;
                    }
                });
            }
        }
        smsLoginStateMachine$handleLoginState$1 = new SmsLoginStateMachine$handleLoginState$1(this, continuation);
        Object $result2 = smsLoginStateMachine$handleLoginState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (smsLoginStateMachine$handleLoginState$1.label) {
        }
        result = (ILoginResult) login;
        if (result instanceof LoginSucceed) {
        }
        if (!(result instanceof tv.danmaku.bili.fullscreen.service.LoginFailed)) {
        }
        return state2.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.SmsLoginStateMachine$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                ISmsLoginValidState handleLoginState$lambda$0;
                handleLoginState$lambda$0 = SmsLoginStateMachine.handleLoginState$lambda$0(ISmsLoginLoadingState.this, newInput, (ISmsLoginLoadingState) obj);
                return handleLoginState$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ISmsLoginValidState handleLoginState$lambda$0(ISmsLoginLoadingState $current, Pair $newInput, ISmsLoginLoadingState $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        if ($current instanceof SmsLoginLoadingCountingState) {
            return new SmsLoginPageInputCountingState((SmsLoginInput) $newInput.getSecond(), ((SmsLoginLoadingCountingState) $current).getCountDown(), ((Boolean) $newInput.getFirst()).booleanValue());
        }
        if (!($current instanceof SmsLoginLoadingIdleState)) {
            throw new NoWhenBranchMatchedException();
        }
        return new SmsLoginPageInputIdleState((SmsLoginInput) $newInput.getSecond(), ((Boolean) $newInput.getFirst()).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ISmsLoginValidState handleLoginState$lambda$1(ISmsLoginLoadingState $current, SmsLoginInput $input, ISmsLoginLoadingState $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        if ($current instanceof SmsLoginLoadingCountingState) {
            return new SmsLoginPageInputCountingState($input, ((SmsLoginLoadingCountingState) $current).getCountDown(), false);
        }
        if (!($current instanceof SmsLoginLoadingIdleState)) {
            throw new NoWhenBranchMatchedException();
        }
        return new SmsLoginPageInputIdleState($input, false);
    }

    private final Flow<Integer> getCountingFlow() {
        return FlowKt.flow(new SmsLoginStateMachine$getCountingFlow$1(null));
    }
}