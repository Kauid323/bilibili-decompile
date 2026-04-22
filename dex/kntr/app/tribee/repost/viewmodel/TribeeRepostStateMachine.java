package kntr.app.tribee.repost.viewmodel;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import javax.inject.Inject;
import kntr.app.tribee.repost.action.TribeeRepostStateAction;
import kntr.app.tribee.repost.service.TribeeRepostDataService;
import kntr.app.tribee.repost.state.TribeeRepostState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: TribeeRepostStateMachine.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/tribee/repost/viewmodel/TribeeRepostStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/tribee/repost/state/TribeeRepostState;", "Lkntr/app/tribee/repost/action/TribeeRepostStateAction;", "dataService", "Lkntr/app/tribee/repost/service/TribeeRepostDataService;", "originDynamicId", "", "<init>", "(Lkntr/app/tribee/repost/service/TribeeRepostDataService;J)V", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeRepostStateMachine extends FlowReduxStateMachine<TribeeRepostState, TribeeRepostStateAction> {
    public static final int $stable = 8;
    private final TribeeRepostDataService dataService;
    private final long originDynamicId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public TribeeRepostStateMachine(TribeeRepostDataService dataService, long originDynamicId) {
        super(TribeeRepostState.TribeeRepostLoadingState.INSTANCE);
        Intrinsics.checkNotNullParameter(dataService, "dataService");
        this.dataService = dataService;
        this.originDynamicId = originDynamicId;
        spec(new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = TribeeRepostStateMachine._init_$lambda$0(TribeeRepostStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final TribeeRepostStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return TribeeRepostStateMachine.lambda$0$0(TribeeRepostStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeRepostState.TribeeRepostLoadingState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return TribeeRepostStateMachine.lambda$0$1((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeRepostState.TribeeRepostErrorState.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: kntr.app.tribee.repost.viewmodel.TribeeRepostStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return TribeeRepostStateMachine.lambda$0$2(TribeeRepostStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeRepostState.TribeeRepostContentState.class), block$iv3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(TribeeRepostStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeeRepostStateMachine$1$1$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeRepostStateMachine$1$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.Loading.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(TribeeRepostStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeRepostStateMachine$1$3$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.ShowSelectTribeeBottomSheet.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new TribeeRepostStateMachine$1$3$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.SelectTribeeBottomSheetHasLoaded.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new TribeeRepostStateMachine$1$3$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.SelectTribeeBottomSheetTribeeItemExposed.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new TribeeRepostStateMachine$1$3$4(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.SelectedTribeeOrPartitionChanged.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv5 = new TribeeRepostStateMachine$1$3$5(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.DismissSelectTribeeBottomSheet.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock $this$iv6 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv6 = new TribeeRepostStateMachine$1$3$6(null);
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv6.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.ShowIntroBottomSheet.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock $this$iv7 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv7 = new TribeeRepostStateMachine$1$3$7(this$0, null);
        ExecutionPolicy executionPolicy$iv7 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv7.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.IntroBottomSheetExposed.class), executionPolicy$iv7, handler$iv7);
        BaseBuilderBlock $this$iv8 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv8 = new TribeeRepostStateMachine$1$3$8(this$0, null);
        ExecutionPolicy executionPolicy$iv8 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv8.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.IntroBottomSheetConfirmClick.class), executionPolicy$iv8, handler$iv8);
        BaseBuilderBlock $this$iv9 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv9 = new TribeeRepostStateMachine$1$3$9(null);
        ExecutionPolicy executionPolicy$iv9 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv9.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.DismissIntroBottomSheet.class), executionPolicy$iv9, handler$iv9);
        BaseBuilderBlock $this$iv10 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv10 = new TribeeRepostStateMachine$1$3$10(this$0, null);
        ExecutionPolicy executionPolicy$iv10 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv10.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.ShowEditMainTextBottomSheet.class), executionPolicy$iv10, handler$iv10);
        BaseBuilderBlock $this$iv11 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv11 = new TribeeRepostStateMachine$1$3$11(this$0, null);
        ExecutionPolicy executionPolicy$iv11 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv11.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.EditMainTextBottomSheetExposed.class), executionPolicy$iv11, handler$iv11);
        BaseBuilderBlock $this$iv12 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv12 = new TribeeRepostStateMachine$1$3$12(null);
        ExecutionPolicy executionPolicy$iv12 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv12.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.MainTextChanged.class), executionPolicy$iv12, handler$iv12);
        BaseBuilderBlock $this$iv13 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv13 = new TribeeRepostStateMachine$1$3$13(this$0, null);
        ExecutionPolicy executionPolicy$iv13 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv13.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.EditMainTextBottomSheetConfirmClick.class), executionPolicy$iv13, handler$iv13);
        BaseBuilderBlock $this$iv14 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv14 = new TribeeRepostStateMachine$1$3$14(null);
        ExecutionPolicy executionPolicy$iv14 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv14.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.DismissEditMainTextBottomSheet.class), executionPolicy$iv14, handler$iv14);
        BaseBuilderBlock $this$iv15 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv15 = new TribeeRepostStateMachine$1$3$15(null);
        ExecutionPolicy executionPolicy$iv15 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv15.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.ShowEditTitleTextBottomSheet.class), executionPolicy$iv15, handler$iv15);
        BaseBuilderBlock $this$iv16 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv16 = new TribeeRepostStateMachine$1$3$16(this$0, null);
        ExecutionPolicy executionPolicy$iv16 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv16.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.EditTitleTextBottomSheetExposed.class), executionPolicy$iv16, handler$iv16);
        BaseBuilderBlock $this$iv17 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv17 = new TribeeRepostStateMachine$1$3$17(null);
        ExecutionPolicy executionPolicy$iv17 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv17.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.TitleTextChanged.class), executionPolicy$iv17, handler$iv17);
        BaseBuilderBlock $this$iv18 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv18 = new TribeeRepostStateMachine$1$3$18(this$0, null);
        ExecutionPolicy executionPolicy$iv18 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv18.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.EditTitleTextBottomSheetConfirmClick.class), executionPolicy$iv18, handler$iv18);
        BaseBuilderBlock $this$iv19 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv19 = new TribeeRepostStateMachine$1$3$19(null);
        ExecutionPolicy executionPolicy$iv19 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv19.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.DismissEditTitleTextBottomSheet.class), executionPolicy$iv19, handler$iv19);
        BaseBuilderBlock $this$iv20 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv20 = new TribeeRepostStateMachine$1$3$20(this$0, null);
        ExecutionPolicy executionPolicy$iv20 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv20.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.RepostToFollowingChanged.class), executionPolicy$iv20, handler$iv20);
        BaseBuilderBlock $this$iv21 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv21 = new TribeeRepostStateMachine$1$3$21(this$0, null);
        ExecutionPolicy executionPolicy$iv21 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv21.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.RepostWithSourceChanged.class), executionPolicy$iv21, handler$iv21);
        BaseBuilderBlock $this$iv22 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv22 = new TribeeRepostStateMachine$1$3$22(this$0, null);
        ExecutionPolicy executionPolicy$iv22 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv22.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.RepostClick.class), executionPolicy$iv22, handler$iv22);
        BaseBuilderBlock $this$iv23 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv23 = new TribeeRepostStateMachine$1$3$23(this$0, $this$inState, null);
        ExecutionPolicy executionPolicy$iv23 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv23.on(Reflection.getOrCreateKotlinClass(TribeeRepostStateAction.RequestRepost.class), executionPolicy$iv23, handler$iv23);
        return Unit.INSTANCE;
    }
}