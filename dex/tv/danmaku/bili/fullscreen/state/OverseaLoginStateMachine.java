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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.service.ISmsLoginStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;

/* compiled from: OverseaLoginPage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB#\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/OverseaLoginStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Ltv/danmaku/bili/fullscreen/state/IOverseaLoginState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "initialState", "loginReportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "smsStateMachineProvider", "Ltv/danmaku/bili/fullscreen/service/ISmsLoginStateMachineFactory;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/IOverseaLoginState;Ltv/danmaku/bili/fullscreen/service/LoginReportService;Ltv/danmaku/bili/fullscreen/service/ISmsLoginStateMachineFactory;)V", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OverseaLoginStateMachine extends FlowReduxStateMachine<IOverseaLoginState, IFullscreenAction> {
    private static final String TAG = "OverseaLoginStateMachine";
    private final IOverseaLoginState initialState;
    private final LoginReportService loginReportService;
    private final ISmsLoginStateMachineFactory smsStateMachineProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public OverseaLoginStateMachine(@Assisted IOverseaLoginState initialState, LoginReportService loginReportService, ISmsLoginStateMachineFactory smsStateMachineProvider) {
        super(initialState);
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(loginReportService, "loginReportService");
        Intrinsics.checkNotNullParameter(smsStateMachineProvider, "smsStateMachineProvider");
        this.initialState = initialState;
        this.loginReportService = loginReportService;
        this.smsStateMachineProvider = smsStateMachineProvider;
        spec(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = OverseaLoginStateMachine._init_$lambda$0(OverseaLoginStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final OverseaLoginStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return OverseaLoginStateMachine.lambda$0$0(OverseaLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(OverseaLoginState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(final OverseaLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterStartStateMachine(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return OverseaLoginStateMachine.lambda$0$0$0(OverseaLoginStateMachine.this, (OverseaLoginState) obj);
            }
        }, new Function2() { // from class: tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                return OverseaLoginStateMachine.lambda$0$0$1((State) obj, (ISmsLoginPageState) obj2);
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new OverseaLoginStateMachine$1$1$3(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.GoogleLogin.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new OverseaLoginStateMachine$1$1$4(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.FacebookLogin.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final StateMachine lambda$0$0$0(OverseaLoginStateMachine this$0, OverseaLoginState state) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        return this$0.smsStateMachineProvider.create(SmsLoginPageStateKt.ISmsLoginPageState$default(null, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ChangedState lambda$0$0$1(State state, final ISmsLoginPageState iLoginPageState) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(iLoginPageState, "iLoginPageState");
        return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return OverseaLoginStateMachine.lambda$0$0$1$0(ISmsLoginPageState.this, (OverseaLoginState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final OverseaLoginState lambda$0$0$1$0(ISmsLoginPageState $iLoginPageState, OverseaLoginState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return OverseaLoginState.copy$default($this$mutate, $iLoginPageState, null, $iLoginPageState.getEulaDisplay(), $iLoginPageState.getCaptchaDisplay(), $iLoginPageState.getRedirect(), false, false, null, BR.followLottieAnimationVisible, null);
    }

    /* compiled from: OverseaLoginPage.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/OverseaLoginStateMachine$Companion;", "", "<init>", "()V", "TAG", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}