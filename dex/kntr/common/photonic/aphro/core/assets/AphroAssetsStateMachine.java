package kntr.common.photonic.aphro.core.assets;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.assets.AphroAssetsAction;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: AphroAssetsStateMachine.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0002J\u0018\u0010\u000b\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0002J\u001e\u0010\f\u001a\u00020\t*\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/common/photonic/aphro/core/assets/AphroAssetsStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsAction;", "init", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$Init;", "<init>", "(Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$Init;)V", "buildSpec", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "initLoad", "handleLoadMore", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$AphroContent;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AphroAssetsStateMachine extends FlowReduxStateMachine<AphroAssetsState, AphroAssetsAction> {
    public static final int $stable = 8;
    private final AphroAssetsState.Init init;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public AphroAssetsStateMachine(@Assisted("") AphroAssetsState.Init init) {
        super(init);
        Intrinsics.checkNotNullParameter(init, "init");
        this.init = init;
        spec(new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = AphroAssetsStateMachine._init_$lambda$0(AphroAssetsStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(AphroAssetsStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        this$0.buildSpec($this$spec);
        return Unit.INSTANCE;
    }

    private final void buildSpec(FlowReduxStoreBuilder<AphroAssetsState, AphroAssetsAction> flowReduxStoreBuilder) {
        initLoad(flowReduxStoreBuilder);
        Function1 block$iv = new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit buildSpec$lambda$0;
                buildSpec$lambda$0 = AphroAssetsStateMachine.buildSpec$lambda$0(AphroAssetsStateMachine.this, (InStateBuilderBlock) obj);
                return buildSpec$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(AphroAssetsState.AphroContent.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildSpec$lambda$0(AphroAssetsStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        this$0.handleLoadMore($this$inState);
        return Unit.INSTANCE;
    }

    private final void initLoad(FlowReduxStoreBuilder<AphroAssetsState, AphroAssetsAction> flowReduxStoreBuilder) {
        Function1 block$iv = new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit initLoad$lambda$0;
                initLoad$lambda$0 = AphroAssetsStateMachine.initLoad$lambda$0((InStateBuilderBlock) obj);
                return initLoad$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(AphroAssetsState.Init.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit initLoad$lambda$1;
                initLoad$lambda$1 = AphroAssetsStateMachine.initLoad$lambda$1((InStateBuilderBlock) obj);
                return initLoad$lambda$1;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(AphroAssetsState.LoadingAssets.class), block$iv2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initLoad$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new AphroAssetsStateMachine$initLoad$1$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initLoad$lambda$1(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new AphroAssetsStateMachine$initLoad$2$1(null));
        return Unit.INSTANCE;
    }

    private final void handleLoadMore(InStateBuilderBlock<AphroAssetsState.AphroContent, AphroAssetsState, AphroAssetsAction> inStateBuilderBlock) {
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new AphroAssetsStateMachine$handleLoadMore$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(AphroAssetsAction.LoadMore.class), executionPolicy$iv, handler$iv);
    }
}