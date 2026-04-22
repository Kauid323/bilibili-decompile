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
import java.util.List;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.exp.LoginExpType;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;
import tv.danmaku.bili.fullscreen.service.IPhoneOnePassStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.IPhoneService;
import tv.danmaku.bili.fullscreen.service.ISmsLoginStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.TechTrackService;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;

/* compiled from: IFullscreenLoginPage.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001Ba\b\u0007\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/FullscreenLoginStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "validLoginTypes", "", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "initial", "loginExp", "Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "loginReportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "phoneService", "Ltv/danmaku/bili/fullscreen/service/IPhoneService;", "techTrackService", "Ltv/danmaku/bili/fullscreen/service/TechTrackService;", "phoneStateMachineProvider", "Ltv/danmaku/bili/fullscreen/service/IPhoneOnePassStateMachineFactory;", "smsStateMachineProvider", "Ltv/danmaku/bili/fullscreen/service/ISmsLoginStateMachineFactory;", "passwordStateMachineProvider", "Ljavax/inject/Provider;", "Ltv/danmaku/bili/fullscreen/state/PasswordLoginStateMachine;", "<init>", "(Ljava/util/List;Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;Ltv/danmaku/bili/fullscreen/exp/LoginExpType;Ltv/danmaku/bili/fullscreen/service/LoginReportService;Ltv/danmaku/bili/fullscreen/service/IPhoneService;Ltv/danmaku/bili/fullscreen/service/TechTrackService;Ltv/danmaku/bili/fullscreen/service/IPhoneOnePassStateMachineFactory;Ltv/danmaku/bili/fullscreen/service/ISmsLoginStateMachineFactory;Ljavax/inject/Provider;)V", "getInitial", "()Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginStateMachine extends FlowReduxStateMachine<IFullscreenLoginState, IFullscreenAction> {
    public static final int $stable = 8;
    private final IFullscreenLoginState initial;
    private final LoginExpType loginExp;
    private final LoginReportService loginReportService;
    private final Provider<PasswordLoginStateMachine> passwordStateMachineProvider;
    private final IPhoneService phoneService;
    private final IPhoneOnePassStateMachineFactory phoneStateMachineProvider;
    private final ISmsLoginStateMachineFactory smsStateMachineProvider;
    private final TechTrackService techTrackService;
    private final List<ValidLoginType> validLoginTypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @AssistedInject
    public FullscreenLoginStateMachine(@Assisted List<? extends ValidLoginType> list, @Assisted IFullscreenLoginState initial, LoginExpType loginExp, LoginReportService loginReportService, IPhoneService phoneService, TechTrackService techTrackService, IPhoneOnePassStateMachineFactory phoneStateMachineProvider, ISmsLoginStateMachineFactory smsStateMachineProvider, Provider<PasswordLoginStateMachine> provider) {
        super(initial);
        Intrinsics.checkNotNullParameter(list, "validLoginTypes");
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(loginExp, "loginExp");
        Intrinsics.checkNotNullParameter(loginReportService, "loginReportService");
        Intrinsics.checkNotNullParameter(phoneService, "phoneService");
        Intrinsics.checkNotNullParameter(techTrackService, "techTrackService");
        Intrinsics.checkNotNullParameter(phoneStateMachineProvider, "phoneStateMachineProvider");
        Intrinsics.checkNotNullParameter(smsStateMachineProvider, "smsStateMachineProvider");
        Intrinsics.checkNotNullParameter(provider, "passwordStateMachineProvider");
        this.validLoginTypes = list;
        this.initial = initial;
        this.loginExp = loginExp;
        this.loginReportService = loginReportService;
        this.phoneService = phoneService;
        this.techTrackService = techTrackService;
        this.phoneStateMachineProvider = phoneStateMachineProvider;
        this.smsStateMachineProvider = smsStateMachineProvider;
        this.passwordStateMachineProvider = provider;
        spec(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = FullscreenLoginStateMachine._init_$lambda$0(FullscreenLoginStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    public final IFullscreenLoginState getInitial() {
        return this.initial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final FullscreenLoginStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$0(FullscreenLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FullscreenLoginPhoneIdlePage.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$1(FullscreenLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FullscreenLoginPhonePage.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$2(FullscreenLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FullscreenLoginIdlePage.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$3(FullscreenLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FullscreenLoginSmsPage.class), block$iv4);
        Function1 block$iv5 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$4(FullscreenLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FullscreenLoginPasswordPage.class), block$iv5);
        Function1 block$iv6 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$5((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(IFullscreenActionPage.class), block$iv6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(FullscreenLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new FullscreenLoginStateMachine$1$1$1(this$0, null));
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new FullscreenLoginStateMachine$1$1$2(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.OnPhoneGetAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(final FullscreenLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterEffect(new FullscreenLoginStateMachine$1$2$1(this$0, null));
        $this$inState.onEnterStartStateMachine(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$1$0(FullscreenLoginStateMachine.this, (FullscreenLoginPhonePage) obj);
            }
        }, new Function2() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda12
            public final Object invoke(Object obj, Object obj2) {
                return FullscreenLoginStateMachine.lambda$0$1$1((State) obj, (IPhoneOnePassState) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final StateMachine lambda$0$1$0(FullscreenLoginStateMachine this$0, FullscreenLoginPhonePage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.phoneStateMachineProvider.create(it.getCurrentPage());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ChangedState lambda$0$1$1(State state, final IPhoneOnePassState iPhoneOnePassState) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(iPhoneOnePassState, "iPhoneOnePassState");
        return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$1$1$0(IPhoneOnePassState.this, (FullscreenLoginPhonePage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FullscreenLoginPhonePage lambda$0$1$1$0(IPhoneOnePassState $iPhoneOnePassState, FullscreenLoginPhonePage $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return new FullscreenLoginPhonePage($iPhoneOnePassState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(FullscreenLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterEffect(new FullscreenLoginStateMachine$1$3$1(this$0, null));
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new FullscreenLoginStateMachine$1$3$2(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.SkipLogin.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$3(final FullscreenLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterEffect(new FullscreenLoginStateMachine$1$4$1(this$0, null));
        $this$inState.onEnterStartStateMachine(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$3$0(FullscreenLoginStateMachine.this, (FullscreenLoginSmsPage) obj);
            }
        }, new Function2() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                return FullscreenLoginStateMachine.lambda$0$3$1((State) obj, (ISmsLoginPageState) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final StateMachine lambda$0$3$0(FullscreenLoginStateMachine this$0, FullscreenLoginSmsPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.smsStateMachineProvider.create(it.getCurrentPage());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ChangedState lambda$0$3$1(State state, final ISmsLoginPageState iSmsLoginPageState) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(iSmsLoginPageState, "iSmsLoginPageState");
        return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$3$1$0(ISmsLoginPageState.this, (FullscreenLoginSmsPage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FullscreenLoginSmsPage lambda$0$3$1$0(ISmsLoginPageState $iSmsLoginPageState, FullscreenLoginSmsPage $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return new FullscreenLoginSmsPage($iSmsLoginPageState, $this$override.getRootPage$accountui_apinkDebug());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$4(final FullscreenLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterEffect(new FullscreenLoginStateMachine$1$5$1(this$0, null));
        $this$inState.onEnterStartStateMachine(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$4$0(FullscreenLoginStateMachine.this, (FullscreenLoginPasswordPage) obj);
            }
        }, new Function2() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                return FullscreenLoginStateMachine.lambda$0$4$1((State) obj, (IPasswordLoginPage) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final StateMachine lambda$0$4$0(FullscreenLoginStateMachine this$0, FullscreenLoginPasswordPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object obj = this$0.passwordStateMachineProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (StateMachine) obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ChangedState lambda$0$4$1(State state, final IPasswordLoginPage iPasswordLoginPage) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(iPasswordLoginPage, "iPasswordLoginPage");
        return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return FullscreenLoginStateMachine.lambda$0$4$1$0(IPasswordLoginPage.this, (FullscreenLoginPasswordPage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FullscreenLoginPasswordPage lambda$0$4$1$0(IPasswordLoginPage $iPasswordLoginPage, FullscreenLoginPasswordPage $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return new FullscreenLoginPasswordPage($iPasswordLoginPage, $this$override.getRootPage$accountui_apinkDebug());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$5(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new FullscreenLoginStateMachine$1$6$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.BackToLastPage.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new FullscreenLoginStateMachine$1$6$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.SkipLogin.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new FullscreenLoginStateMachine$1$6$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.SwitchToSms.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new FullscreenLoginStateMachine$1$6$4(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.SwitchToPassword.class), executionPolicy$iv4, handler$iv4);
        return Unit.INSTANCE;
    }
}