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
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;

/* compiled from: FastLoginPage.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/FastLoginStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Ltv/danmaku/bili/fullscreen/state/IFastLoginPage;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "initialState", "loginReportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/IFastLoginPage;Ltv/danmaku/bili/fullscreen/service/LoginReportService;)V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FastLoginStateMachine extends FlowReduxStateMachine<IFastLoginPage, IFullscreenAction> {
    public static final int $stable = 8;
    private final IFastLoginPage initialState;
    private final LoginReportService loginReportService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public FastLoginStateMachine(@Assisted IFastLoginPage initialState, LoginReportService loginReportService) {
        super(initialState);
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(loginReportService, "loginReportService");
        this.initialState = initialState;
        this.loginReportService = loginReportService;
        spec(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = FastLoginStateMachine._init_$lambda$0(FastLoginStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final FastLoginStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return FastLoginStateMachine.lambda$0$0(FastLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FastLoginPage.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return FastLoginStateMachine.lambda$0$1(FastLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FastLoginLoadingPage.class), block$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(FastLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new FastLoginStateMachine$1$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.AgreementCheckedAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new FastLoginStateMachine$1$1$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.AgreementCheckedAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new FastLoginStateMachine$1$1$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginReportAction.EulaLinkClicked.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new FastLoginStateMachine$1$1$4(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.ShowEulaAction.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new FastLoginStateMachine$1$1$5(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.DismissEulaAction.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv6 = new FastLoginStateMachine$1$1$6($this$inState, this$0, null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.LoginAction.class), executionPolicy$iv6, handler$iv6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(FastLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new FastLoginStateMachine$1$2$1(this$0, null));
        return Unit.INSTANCE;
    }
}