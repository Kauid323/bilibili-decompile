package tv.danmaku.bili.stepbystep.sms;

import bili.resource.account.R;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.service.ILoginResult;
import tv.danmaku.bili.fullscreen.service.ISmsLoginService;
import tv.danmaku.bili.fullscreen.service.LoginCaptcha;
import tv.danmaku.bili.fullscreen.service.LoginFailed;
import tv.danmaku.bili.fullscreen.service.LoginIntercepted;
import tv.danmaku.bili.fullscreen.service.LoginRedirected;
import tv.danmaku.bili.fullscreen.service.LoginReportParams;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.LoginSucceed;
import tv.danmaku.bili.fullscreen.service.SmsCaptchaStatus;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.stepbystep.IStepByStepLoginAction;
import tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginAction;

/* compiled from: StepByStepSmsLoginStateMachine.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJF\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0012H\u0082@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Ltv/danmaku/bili/stepbystep/sms/IStepByStepSmsLoginPageState;", "Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;", "smsLoginService", "Ltv/danmaku/bili/fullscreen/service/ISmsLoginService;", "reportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "reportLoginType", "", "<init>", "(Ltv/danmaku/bili/fullscreen/service/ISmsLoginService;Ltv/danmaku/bili/fullscreen/service/LoginReportService;Ljava/lang/String;)V", "handleLoginState", "Lcom/freeletics/flowredux/dsl/ChangedState;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginVerifyPage;", "dispatchAction", "Lkotlin/Function2;", "Ltv/danmaku/bili/stepbystep/sms/StepByStepSmsLoginAction$ReportAction;", "Lkotlin/coroutines/Continuation;", "", "", "(Lcom/freeletics/flowredux/dsl/State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCountDownFlow", "Lkotlinx/coroutines/flow/Flow;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StepByStepSmsLoginStateMachine extends FlowReduxStateMachine<IStepByStepSmsLoginPageState, IStepByStepLoginAction> {
    public static final int $stable = 8;
    private final String reportLoginType;
    private final LoginReportService reportService;
    private final ISmsLoginService smsLoginService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public StepByStepSmsLoginStateMachine(ISmsLoginService smsLoginService, LoginReportService reportService, @Assisted String reportLoginType) {
        super(StepByStepSmsLoginIdlePage.INSTANCE);
        Intrinsics.checkNotNullParameter(smsLoginService, "smsLoginService");
        Intrinsics.checkNotNullParameter(reportService, "reportService");
        Intrinsics.checkNotNullParameter(reportLoginType, "reportLoginType");
        this.smsLoginService = smsLoginService;
        this.reportService = reportService;
        this.reportLoginType = reportLoginType;
        spec(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = StepByStepSmsLoginStateMachine._init_$lambda$0(StepByStepSmsLoginStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final StepByStepSmsLoginStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return StepByStepSmsLoginStateMachine.lambda$0$0(StepByStepSmsLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(IStepByStepSmsLoginPageState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return StepByStepSmsLoginStateMachine.lambda$0$1((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginPageTransitionState.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return StepByStepSmsLoginStateMachine.lambda$0$2(StepByStepSmsLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginIdlePage.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return StepByStepSmsLoginStateMachine.lambda$0$3(StepByStepSmsLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginPhonePage.class), block$iv4);
        Function1 block$iv5 = new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return StepByStepSmsLoginStateMachine.lambda$0$4(StepByStepSmsLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginVerifyPage.class), block$iv5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(final StepByStepSmsLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new StepByStepSmsLoginStateMachine$1$1$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.ReportAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new StepByStepSmsLoginStateMachine$1$1$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(IStepByStepLoginAction.OnFocusChanged.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new StepByStepSmsLoginStateMachine$1$1$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.PageTransitionAction.class), executionPolicy$iv3, handler$iv3);
        $this$inState.condition(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StepByStepSmsLoginStateMachine.lambda$0$0$0((IStepByStepSmsLoginPageState) obj));
            }
        }, new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return StepByStepSmsLoginStateMachine.lambda$0$0$1(StepByStepSmsLoginStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$0$0(IStepByStepSmsLoginPageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Duration.compareTo-LRDsOJo(it.mo1508getCountingUwyO8pc(), Duration.Companion.getZERO-UwyO8pc()) > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$1(StepByStepSmsLoginStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$condition, this$0.getCountDownFlow(), (ExecutionPolicy) null, new StepByStepSmsLoginStateMachine$1$1$5$1(null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new StepByStepSmsLoginStateMachine$1$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.OverrideTransitionStateAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(StepByStepSmsLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new StepByStepSmsLoginStateMachine$1$3$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$3(StepByStepSmsLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BLog.i(StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS, "in state : StepByStepSmsLoginPhonePage");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new StepByStepSmsLoginStateMachine$1$4$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.InputPhoneAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new StepByStepSmsLoginStateMachine$1$4$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.ClearOutPhone.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new StepByStepSmsLoginStateMachine$1$4$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.onActionEffect(Reflection.getOrCreateKotlinClass(IStepByStepLoginAction.AgreementCheckedAction.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new StepByStepSmsLoginStateMachine$1$4$4(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(IStepByStepLoginAction.AgreementCheckedAction.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new StepByStepSmsLoginStateMachine$1$4$5(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.SelectCountryCodeAction.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv6 = new StepByStepSmsLoginStateMachine$1$4$6(null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(IStepByStepLoginAction.ShowEulaAction.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock $this$iv7 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv7 = new StepByStepSmsLoginStateMachine$1$4$7(null);
        ExecutionPolicy executionPolicy$iv7 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv7.on(Reflection.getOrCreateKotlinClass(IStepByStepLoginAction.DismissEulaAction.class), executionPolicy$iv7, handler$iv7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$4(final StepByStepSmsLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterEffect(new StepByStepSmsLoginStateMachine$1$5$1(this$0, null));
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new StepByStepSmsLoginStateMachine$1$5$2(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.ClearOutVerifyCode.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new StepByStepSmsLoginStateMachine$1$5$3(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.GetSmsAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new StepByStepSmsLoginStateMachine$1$5$4(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.GetSmsAction.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new StepByStepSmsLoginStateMachine$1$5$5(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.InputSmsCodeAction.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new StepByStepSmsLoginStateMachine$1$5$6(this$0, null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.onActionEffect(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.InputSmsCodeAction.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv6 = new StepByStepSmsLoginStateMachine$1$5$7(null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.DismissCaptchaAction.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock $this$iv7 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv7 = new StepByStepSmsLoginStateMachine$1$5$8(this$0, null);
        ExecutionPolicy executionPolicy$iv7 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv7.onActionEffect(Reflection.getOrCreateKotlinClass(IStepByStepLoginAction.LoginAction.class), executionPolicy$iv7, handler$iv7);
        BaseBuilderBlock $this$iv8 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv8 = new StepByStepSmsLoginStateMachine$1$5$9(null);
        ExecutionPolicy executionPolicy$iv8 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv8.on(Reflection.getOrCreateKotlinClass(IStepByStepLoginAction.LoginAction.class), executionPolicy$iv8, handler$iv8);
        $this$inState.condition(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StepByStepSmsLoginStateMachine.lambda$0$4$0((StepByStepSmsLoginVerifyPage) obj));
            }
        }, new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                return StepByStepSmsLoginStateMachine.lambda$0$4$1(StepByStepSmsLoginStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$4$0(StepByStepSmsLoginVerifyPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getVerifying();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$4$1(StepByStepSmsLoginStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new StepByStepSmsLoginStateMachine$1$5$11$1(this$0, null));
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new StepByStepSmsLoginStateMachine$1$5$11$2(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(StepByStepSmsLoginAction.InputSmsCodeAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleLoginState(State<StepByStepSmsLoginVerifyPage> state, Function2<? super StepByStepSmsLoginAction.ReportAction, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ChangedState<? extends IStepByStepSmsLoginPageState>> continuation) {
        StepByStepSmsLoginStateMachine$handleLoginState$1 stepByStepSmsLoginStateMachine$handleLoginState$1;
        String str;
        String str2;
        Object login$default;
        State state2;
        Function2 dispatchAction;
        StepByStepSmsLoginVerifyPage current;
        final ILoginResult result;
        String str3;
        State state3;
        StepByStepSmsLoginVerifyPage current2;
        State state4;
        Exception loginError;
        if (continuation instanceof StepByStepSmsLoginStateMachine$handleLoginState$1) {
            stepByStepSmsLoginStateMachine$handleLoginState$1 = (StepByStepSmsLoginStateMachine$handleLoginState$1) continuation;
            if ((stepByStepSmsLoginStateMachine$handleLoginState$1.label & Integer.MIN_VALUE) != 0) {
                stepByStepSmsLoginStateMachine$handleLoginState$1.label -= Integer.MIN_VALUE;
                Object $result = stepByStepSmsLoginStateMachine$handleLoginState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (stepByStepSmsLoginStateMachine$handleLoginState$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        StepByStepSmsLoginVerifyPage current3 = (StepByStepSmsLoginVerifyPage) state.getSnapshot();
                        SmsCaptchaStatus status = current3.getCaptchaStatus();
                        BLog.i(StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS, "handleLoginState: current=" + current3 + ", captchaStatus=" + status);
                        if (status == null) {
                            BLog.i(StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS, "handleLoginState: [phone:" + current3.getPhoneInputState().getPhone() + ",smsCode=" + current3.getSmsCode() + "], \ncaptchaStatus is null!!!");
                            return state.override(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj) {
                                    StepByStepSmsLoginVerifyPage handleLoginState$lambda$5;
                                    handleLoginState$lambda$5 = StepByStepSmsLoginStateMachine.handleLoginState$lambda$5((StepByStepSmsLoginVerifyPage) obj);
                                    return handleLoginState$lambda$5;
                                }
                            });
                        }
                        ISmsLoginService iSmsLoginService = this.smsLoginService;
                        LoginWay loginWay = current3.getCaptchaDisplay().getLoginWay();
                        String smsCode = current3.getSmsCode();
                        LoginReportParams reportParams = this.reportService.getReportParams(this.reportLoginType);
                        stepByStepSmsLoginStateMachine$handleLoginState$1.L$0 = state;
                        stepByStepSmsLoginStateMachine$handleLoginState$1.L$1 = function2;
                        stepByStepSmsLoginStateMachine$handleLoginState$1.L$2 = current3;
                        stepByStepSmsLoginStateMachine$handleLoginState$1.label = 1;
                        str = StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS;
                        str2 = ",smsCode=";
                        login$default = ISmsLoginService.CC.login$default(iSmsLoginService, loginWay, status, smsCode, reportParams, null, stepByStepSmsLoginStateMachine$handleLoginState$1, 16, null);
                        if (login$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        state2 = state;
                        dispatchAction = function2;
                        current = current3;
                        result = (ILoginResult) login$default;
                        if (result instanceof LoginSucceed) {
                            str3 = null;
                            if (!(result instanceof LoginFailed)) {
                            }
                        } else {
                            StepByStepSmsLoginAction.ReportAction.OnLoginSuccess onLoginSuccess = new StepByStepSmsLoginAction.ReportAction.OnLoginSuccess(((LoginSucceed) result).getLoginWay().getSucceedMethod());
                            stepByStepSmsLoginStateMachine$handleLoginState$1.L$0 = state2;
                            stepByStepSmsLoginStateMachine$handleLoginState$1.L$1 = dispatchAction;
                            stepByStepSmsLoginStateMachine$handleLoginState$1.L$2 = current;
                            stepByStepSmsLoginStateMachine$handleLoginState$1.L$3 = result;
                            stepByStepSmsLoginStateMachine$handleLoginState$1.label = 2;
                            if (dispatchAction.invoke(onLoginSuccess, stepByStepSmsLoginStateMachine$handleLoginState$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            state3 = state2;
                            current2 = current;
                            if (!((LoginSucceed) result).getNewUser()) {
                                StepByStepSmsLoginAction.ReportAction.OnRegisterSuccess onRegisterSuccess = StepByStepSmsLoginAction.ReportAction.OnRegisterSuccess.INSTANCE;
                                stepByStepSmsLoginStateMachine$handleLoginState$1.L$0 = state3;
                                stepByStepSmsLoginStateMachine$handleLoginState$1.L$1 = current2;
                                stepByStepSmsLoginStateMachine$handleLoginState$1.L$2 = result;
                                str3 = null;
                                stepByStepSmsLoginStateMachine$handleLoginState$1.L$3 = null;
                                stepByStepSmsLoginStateMachine$handleLoginState$1.label = 3;
                                if (dispatchAction.invoke(onRegisterSuccess, stepByStepSmsLoginStateMachine$handleLoginState$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                state4 = state3;
                                current = current2;
                                state2 = state4;
                                if (!(result instanceof LoginFailed)) {
                                    BLog.i(str, "handleLoginState, [phone:" + current.getPhoneInputState().getPhone() + str2 + current.getSmsCode() + "] , \nresult is failed!! (" + (((LoginFailed) result).getLoginError() != null ? loginError.getMessage() : str3) + ")");
                                    return state2.override(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda15
                                        public final Object invoke(Object obj) {
                                            StepByStepSmsLoginVerifyPage handleLoginState$lambda$0;
                                            handleLoginState$lambda$0 = StepByStepSmsLoginStateMachine.handleLoginState$lambda$0(ILoginResult.this, (StepByStepSmsLoginVerifyPage) obj);
                                            return handleLoginState$lambda$0;
                                        }
                                    });
                                }
                                String str4 = str;
                                if (result instanceof LoginIntercepted) {
                                    BLog.i(str4, "handleLoginState: [phone:" + current.getPhoneInputState().getPhone() + str2 + current.getSmsCode() + "], \nresult is intercepted!! (" + ((LoginIntercepted) result).getIntercepted().getRedirectUrl() + ")");
                                    return state2.mutate(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj) {
                                            StepByStepSmsLoginVerifyPage handleLoginState$lambda$1;
                                            handleLoginState$lambda$1 = StepByStepSmsLoginStateMachine.handleLoginState$lambda$1(ILoginResult.this, (StepByStepSmsLoginVerifyPage) obj);
                                            return handleLoginState$lambda$1;
                                        }
                                    });
                                } else if (result instanceof LoginRedirected) {
                                    BLog.i(str4, "handleLoginState: [phone:" + current.getPhoneInputState().getPhone() + str2 + current.getSmsCode() + "], \nresult is redirected!! (" + ((LoginRedirected) result).getRedirect().getRedirectUrl() + ")");
                                    return state2.mutate(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj) {
                                            StepByStepSmsLoginVerifyPage handleLoginState$lambda$2;
                                            handleLoginState$lambda$2 = StepByStepSmsLoginStateMachine.handleLoginState$lambda$2(ILoginResult.this, (StepByStepSmsLoginVerifyPage) obj);
                                            return handleLoginState$lambda$2;
                                        }
                                    });
                                } else if (result instanceof LoginSucceed) {
                                    BLog.i(str4, "handleLoginState: [phone:" + current.getPhoneInputState().getPhone() + str2 + current.getSmsCode() + "], \nresult is successful!!");
                                    return state2.mutate(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda3
                                        public final Object invoke(Object obj) {
                                            StepByStepSmsLoginVerifyPage handleLoginState$lambda$3;
                                            handleLoginState$lambda$3 = StepByStepSmsLoginStateMachine.handleLoginState$lambda$3((StepByStepSmsLoginVerifyPage) obj);
                                            return handleLoginState$lambda$3;
                                        }
                                    });
                                } else if (result instanceof LoginCaptcha) {
                                    BLog.i(str4, "handleLoginState: [phone:" + current.getPhoneInputState().getPhone() + str2 + current.getSmsCode() + "], \nresult is LoginCaptcha.(result=" + result + ")");
                                    return state2.override(new Function1() { // from class: tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginStateMachine$$ExternalSyntheticLambda4
                                        public final Object invoke(Object obj) {
                                            StepByStepSmsLoginVerifyPage handleLoginState$lambda$4;
                                            handleLoginState$lambda$4 = StepByStepSmsLoginStateMachine.handleLoginState$lambda$4((StepByStepSmsLoginVerifyPage) obj);
                                            return handleLoginState$lambda$4;
                                        }
                                    });
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                            str3 = null;
                            current = current2;
                            state2 = state3;
                            if (!(result instanceof LoginFailed)) {
                            }
                        }
                    case 1:
                        Function2 dispatchAction2 = (Function2) stepByStepSmsLoginStateMachine$handleLoginState$1.L$1;
                        State state5 = (State) stepByStepSmsLoginStateMachine$handleLoginState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        current = (StepByStepSmsLoginVerifyPage) stepByStepSmsLoginStateMachine$handleLoginState$1.L$2;
                        str = StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS;
                        str2 = ",smsCode=";
                        login$default = $result;
                        dispatchAction = dispatchAction2;
                        state2 = state5;
                        result = (ILoginResult) login$default;
                        if (result instanceof LoginSucceed) {
                        }
                        break;
                    case 2:
                        result = (ILoginResult) stepByStepSmsLoginStateMachine$handleLoginState$1.L$3;
                        current2 = (StepByStepSmsLoginVerifyPage) stepByStepSmsLoginStateMachine$handleLoginState$1.L$2;
                        dispatchAction = (Function2) stepByStepSmsLoginStateMachine$handleLoginState$1.L$1;
                        state3 = (State) stepByStepSmsLoginStateMachine$handleLoginState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        str = StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS;
                        str2 = ",smsCode=";
                        if (!((LoginSucceed) result).getNewUser()) {
                        }
                        break;
                    case 3:
                        result = (ILoginResult) stepByStepSmsLoginStateMachine$handleLoginState$1.L$2;
                        current2 = (StepByStepSmsLoginVerifyPage) stepByStepSmsLoginStateMachine$handleLoginState$1.L$1;
                        state4 = (State) stepByStepSmsLoginStateMachine$handleLoginState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        str = StepByStepSmsLoginPageStateKt.TAG_STEP_BY_STEP_SMS;
                        str2 = ",smsCode=";
                        str3 = null;
                        current = current2;
                        state2 = state4;
                        if (!(result instanceof LoginFailed)) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        stepByStepSmsLoginStateMachine$handleLoginState$1 = new StepByStepSmsLoginStateMachine$handleLoginState$1(this, continuation);
        Object $result2 = stepByStepSmsLoginStateMachine$handleLoginState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (stepByStepSmsLoginStateMachine$handleLoginState$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginVerifyPage handleLoginState$lambda$0(ILoginResult $result, StepByStepSmsLoginVerifyPage $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        Exception loginError = ((LoginFailed) $result).getLoginError();
        return StepByStepSmsLoginVerifyPage.m1531copyvXyWBk$default($this$override, null, (loginError == null || (r0 = loginError.getMessage()) == null) ? "" : "", 0, null, false, null, null, 0.0f, false, null, 0L, null, null, 7913, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginVerifyPage handleLoginState$lambda$1(ILoginResult $result, StepByStepSmsLoginVerifyPage $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return StepByStepSmsLoginVerifyPage.m1531copyvXyWBk$default($this$mutate, null, "", 0, null, false, null, null, 0.0f, false, ((LoginIntercepted) $result).getIntercepted(), 0L, null, null, 7401, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginVerifyPage handleLoginState$lambda$2(ILoginResult $result, StepByStepSmsLoginVerifyPage $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return StepByStepSmsLoginVerifyPage.m1531copyvXyWBk$default($this$mutate, null, "", 0, null, false, null, null, 0.0f, false, ((LoginRedirected) $result).getRedirect(), 0L, null, null, 7401, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginVerifyPage handleLoginState$lambda$3(StepByStepSmsLoginVerifyPage $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return StepByStepSmsLoginVerifyPage.m1531copyvXyWBk$default($this$mutate, null, "", 0, null, true, null, null, 0.0f, false, null, 0L, null, null, 7913, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginVerifyPage handleLoginState$lambda$4(StepByStepSmsLoginVerifyPage $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return StepByStepSmsLoginVerifyPage.m1531copyvXyWBk$default($this$override, null, "", R.string.account_global_string_2, null, false, null, null, 0.0f, false, null, 0L, null, null, 7913, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepByStepSmsLoginVerifyPage handleLoginState$lambda$5(StepByStepSmsLoginVerifyPage $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return StepByStepSmsLoginVerifyPage.m1531copyvXyWBk$default($this$override, null, "", R.string.account_global_string_2, null, false, null, null, 0.0f, false, null, 0L, null, null, 7913, null);
    }

    private final Flow<Unit> getCountDownFlow() {
        return FlowKt.flow(new StepByStepSmsLoginStateMachine$getCountDownFlow$1(null));
    }
}