package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.IPhoneOnePassLoginService;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;

/* compiled from: PhoneOnePassLoginState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/PhoneOnePassStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Ltv/danmaku/bili/fullscreen/state/IPhoneOnePassState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "initial", "service", "Ltv/danmaku/bili/fullscreen/service/IPhoneOnePassLoginService;", "loginReportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/IPhoneOnePassState;Ltv/danmaku/bili/fullscreen/service/IPhoneOnePassLoginService;Ltv/danmaku/bili/fullscreen/service/LoginReportService;)V", "loginType", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PhoneOnePassStateMachine extends FlowReduxStateMachine<IPhoneOnePassState, IFullscreenAction> {
    public static final int $stable = 8;
    private final IPhoneOnePassState initial;
    private final LoginReportService loginReportService;
    private final String loginType;
    private final IPhoneOnePassLoginService service;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public PhoneOnePassStateMachine(@Assisted IPhoneOnePassState initial, IPhoneOnePassLoginService service, LoginReportService loginReportService) {
        super(initial);
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(loginReportService, "loginReportService");
        this.initial = initial;
        this.service = service;
        this.loginReportService = loginReportService;
        this.loginType = "onepass_fullscreen_new";
        spec(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PhoneOnePassStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = PhoneOnePassStateMachine._init_$lambda$0(PhoneOnePassStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final PhoneOnePassStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PhoneOnePassStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return PhoneOnePassStateMachine.lambda$0$0(PhoneOnePassStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(PhoneOnePassLoginState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PhoneOnePassStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return PhoneOnePassStateMachine.lambda$0$1(PhoneOnePassStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(PhoneOnePassLoginLoadingState.class), block$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(PhoneOnePassStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new PhoneOnePassStateMachine$1$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.AgreementCheckedAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new PhoneOnePassStateMachine$1$1$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.AgreementCheckedAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new PhoneOnePassStateMachine$1$1$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.LoginAction.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new PhoneOnePassStateMachine$1$1$4(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.LoginAction.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new PhoneOnePassStateMachine$1$1$5(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.ShowEulaAction.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv6 = new PhoneOnePassStateMachine$1$1$6(null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.DismissEulaAction.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock $this$iv7 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv7 = new PhoneOnePassStateMachine$1$1$7(this$0, null);
        ExecutionPolicy executionPolicy$iv7 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv7.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.ShowCaptchaDialog.class), executionPolicy$iv7, handler$iv7);
        BaseBuilderBlock $this$iv8 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv8 = new PhoneOnePassStateMachine$1$1$8(this$0, null);
        ExecutionPolicy executionPolicy$iv8 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv8.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.CaptchaVerified.class), executionPolicy$iv8, handler$iv8);
        BaseBuilderBlock $this$iv9 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv9 = new PhoneOnePassStateMachine$1$1$9(this$0, null);
        ExecutionPolicy executionPolicy$iv9 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv9.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.CaptchaClosed.class), executionPolicy$iv9, handler$iv9);
        BaseBuilderBlock $this$iv10 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv10 = new PhoneOnePassStateMachine$1$1$10(this$0, null);
        ExecutionPolicy executionPolicy$iv10 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv10.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.EulaLinkClicked.class), executionPolicy$iv10, handler$iv10);
        BaseBuilderBlock $this$iv11 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv11 = new PhoneOnePassStateMachine$1$1$11(this$0, null);
        ExecutionPolicy executionPolicy$iv11 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv11.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.SwitchToSms.class), executionPolicy$iv11, handler$iv11);
        BaseBuilderBlock $this$iv12 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv12 = new PhoneOnePassStateMachine$1$1$12(this$0, null);
        ExecutionPolicy executionPolicy$iv12 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv12.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.SwitchToPassword.class), executionPolicy$iv12, handler$iv12);
        BaseBuilderBlock $this$iv13 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv13 = new PhoneOnePassStateMachine$1$1$13(this$0, null);
        ExecutionPolicy executionPolicy$iv13 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv13.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.LoginForgetClick.class), executionPolicy$iv13, handler$iv13);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(PhoneOnePassStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new PhoneOnePassStateMachine$1$2$1(this$0, null));
        return Unit.INSTANCE;
    }
}