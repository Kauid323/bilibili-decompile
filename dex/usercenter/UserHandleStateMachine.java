package usercenter;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import usercenter.UserHandleAction;
import usercenter.UserHandleState;

/* compiled from: UserHandleStateMachine.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0002J\u001e\u0010\r\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u0010\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J\u001e\u0010\u0011\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lusercenter/UserHandleStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lusercenter/UserHandleState;", "Lusercenter/UserHandleAction;", "initialState", "sideEffect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lusercenter/UserHandleSideEffect;", "<init>", "(Lusercenter/UserHandleState;Lkotlinx/coroutines/flow/MutableSharedFlow;)V", "storeBuilder", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "handleDialog", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lusercenter/UserHandleState$Mutable;", "handleMutableState", "handleImmutableState", "Lusercenter/UserHandleState$Immutable;", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UserHandleStateMachine extends FlowReduxStateMachine<UserHandleState, UserHandleAction> {
    public static final int $stable = 8;
    private final MutableSharedFlow<UserHandleSideEffect> sideEffect;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserHandleStateMachine(UserHandleState initialState, MutableSharedFlow<UserHandleSideEffect> mutableSharedFlow) {
        super(initialState);
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(mutableSharedFlow, "sideEffect");
        this.sideEffect = mutableSharedFlow;
        spec(new Function1() { // from class: usercenter.UserHandleStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = UserHandleStateMachine._init_$lambda$0(UserHandleStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(UserHandleStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        this$0.storeBuilder($this$spec);
        return Unit.INSTANCE;
    }

    private final void storeBuilder(FlowReduxStoreBuilder<UserHandleState, UserHandleAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: usercenter.UserHandleStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit storeBuilder$lambda$0;
                storeBuilder$lambda$0 = UserHandleStateMachine.storeBuilder$lambda$0(UserHandleStateMachine.this, (InStateBuilderBlock) obj);
                return storeBuilder$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(UserHandleState.Mutable.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: usercenter.UserHandleStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit storeBuilder$lambda$1;
                storeBuilder$lambda$1 = UserHandleStateMachine.storeBuilder$lambda$1(UserHandleStateMachine.this, (InStateBuilderBlock) obj);
                return storeBuilder$lambda$1;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(UserHandleState.Immutable.class), block$iv2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit storeBuilder$lambda$0(UserHandleStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.handleDialog($this$inState);
        this$0.handleMutableState($this$inState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit storeBuilder$lambda$1(UserHandleStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.handleImmutableState($this$inState);
        return Unit.INSTANCE;
    }

    private final void handleDialog(InStateBuilderBlock<UserHandleState.Mutable, UserHandleState, UserHandleAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new UserHandleStateMachine$handleDialog$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(UserHandleAction.ShowDoubleCheckDialog.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new UserHandleStateMachine$handleDialog$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(UserHandleAction.ShowRecommendDialog.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = new UserHandleStateMachine$handleDialog$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(UserHandleAction.DismissDialog.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv4 = new UserHandleStateMachine$handleDialog$4(null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(UserHandleAction.ShowLoadingDialog.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv5 = new UserHandleStateMachine$handleDialog$5(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(UserHandleAction.ShowBindPhoneDialog.class), executionPolicy$iv5, handler$iv5);
    }

    private final void handleMutableState(InStateBuilderBlock<UserHandleState.Mutable, UserHandleState, UserHandleAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new UserHandleStateMachine$handleMutableState$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(UserHandleAction.Submit.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new UserHandleStateMachine$handleMutableState$2(this, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(UserHandleAction.SubmitSuccess.class), executionPolicy$iv2, handler$iv2);
    }

    private final void handleImmutableState(InStateBuilderBlock<UserHandleState.Immutable, UserHandleState, UserHandleAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new UserHandleStateMachine$handleImmutableState$1(this, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(UserHandleAction.ShowNoEditPermissionToast.class), executionPolicy$iv, handler$iv);
    }
}