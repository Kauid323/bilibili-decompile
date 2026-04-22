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
import tv.danmaku.bili.fullscreen.service.NetCodeLoginService;
import tv.danmaku.bili.fullscreen.state.LoginFailed;
import tv.danmaku.bili.fullscreen.state.NetCodeAction;

/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/NetCodeStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "Ltv/danmaku/bili/fullscreen/state/NetCodeAction;", "initialState", "loginReportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "netCodeService", "Ltv/danmaku/bili/fullscreen/service/NetCodeLoginService;", "<init>", "(Ltv/danmaku/bili/fullscreen/state/NetCodeState;Ltv/danmaku/bili/fullscreen/service/LoginReportService;Ltv/danmaku/bili/fullscreen/service/NetCodeLoginService;)V", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NetCodeStateMachine extends FlowReduxStateMachine<NetCodeState, NetCodeAction> {
    public static final int $stable = 8;
    private final LoginReportService loginReportService;
    private final NetCodeLoginService netCodeService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public NetCodeStateMachine(@Assisted NetCodeState initialState, LoginReportService loginReportService, NetCodeLoginService netCodeService) {
        super(initialState);
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(loginReportService, "loginReportService");
        Intrinsics.checkNotNullParameter(netCodeService, "netCodeService");
        this.loginReportService = loginReportService;
        this.netCodeService = netCodeService;
        spec(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = NetCodeStateMachine._init_$lambda$0(NetCodeStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final NetCodeStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return NetCodeStateMachine.lambda$0$0((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(Authorizing.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return NetCodeStateMachine.lambda$0$1(NetCodeStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(LoginRequesting.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return NetCodeStateMachine.lambda$0$2((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(LoginVerifying.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return NetCodeStateMachine.lambda$0$3((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(LoginFailed.Error.class), block$iv4);
        Function1 block$iv5 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return NetCodeStateMachine.lambda$0$4((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(NetCodeStartable.class), block$iv5);
        Function1 block$iv6 = new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return NetCodeStateMachine.lambda$0$5(NetCodeStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(LoginSuccess.class), block$iv6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new NetCodeStateMachine$1$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(NetCodeAction.AuthorizeResult.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(NetCodeStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new NetCodeStateMachine$1$2$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new NetCodeStateMachine$1$3$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(NetCodeAction.VerifyResult.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$3(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterEffect(new NetCodeStateMachine$1$4$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$4(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new NetCodeStateMachine$1$5$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(NetCodeAction.Authorize.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$5(NetCodeStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterEffect(new NetCodeStateMachine$1$6$1(this$0, null));
        return Unit.INSTANCE;
    }
}