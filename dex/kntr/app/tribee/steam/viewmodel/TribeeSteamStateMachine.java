package kntr.app.tribee.steam.viewmodel;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import javax.inject.Inject;
import kntr.app.tribee.steam.service.TribeeSteamDataService;
import kntr.app.tribee.steam.state.TribeeSteamGameAchievementState;
import kntr.app.tribee.steam.state.TribeeSteamShareState;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ui.ShareMenuVM;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: TribeeSteamStateMachine.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B;\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "hostId", "", "tribeeId", "", "fromSpmid", "dataService", "Lkntr/app/tribee/steam/service/TribeeSteamDataService;", "shareScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lkntr/app/tribee/steam/service/TribeeSteamDataService;Lkotlinx/coroutines/CoroutineScope;)V", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamStateMachine extends FlowReduxStateMachine<TribeeSteamState, TribeeSteamStateAction> {
    public static final int $stable = 8;
    private final TribeeSteamDataService dataService;
    private final String fromSpmid;
    private final long hostId;
    private final CoroutineScope shareScope;
    private final String tribeeId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public TribeeSteamStateMachine(long hostId, @TribeeId String tribeeId, @FromSpmid String fromSpmid, TribeeSteamDataService dataService, @TribeeSteamShareCoroutineScope CoroutineScope shareScope) {
        super(new TribeeSteamState.InitialState(null, null, 3, null));
        Intrinsics.checkNotNullParameter(dataService, "dataService");
        Intrinsics.checkNotNullParameter(shareScope, "shareScope");
        this.hostId = hostId;
        this.tribeeId = tribeeId;
        this.fromSpmid = fromSpmid;
        this.dataService = dataService;
        this.shareScope = shareScope;
        spec(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = TribeeSteamStateMachine._init_$lambda$0(TribeeSteamStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final TribeeSteamStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return TribeeSteamStateMachine.lambda$0$0(TribeeSteamStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeSteamState.InitialState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return TribeeSteamStateMachine.lambda$0$1(TribeeSteamStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeSteamState.SteamInfoState.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return TribeeSteamStateMachine.lambda$0$2(TribeeSteamStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeSteamState.class), block$iv3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(TribeeSteamStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeeSteamStateMachine$1$1$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(final TribeeSteamStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeSteamStateMachine$1$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeSteamStateAction.ToggleGameAchievement.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new TribeeSteamStateMachine$1$2$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(TribeeSteamStateAction.StartShare.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new TribeeSteamStateMachine$1$2$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(TribeeSteamStateAction.EndShare.class), executionPolicy$iv3, handler$iv3);
        $this$inState.condition(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TribeeSteamStateMachine.lambda$0$1$0((TribeeSteamState.SteamInfoState) obj));
            }
        }, new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return TribeeSteamStateMachine.lambda$0$1$1(TribeeSteamStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TribeeSteamStateMachine.lambda$0$1$2((TribeeSteamState.SteamInfoState) obj));
            }
        }, new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return TribeeSteamStateMachine.lambda$0$1$3(TribeeSteamStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TribeeSteamStateMachine.lambda$0$1$4((TribeeSteamState.SteamInfoState) obj));
            }
        }, new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return TribeeSteamStateMachine.lambda$0$1$5((ConditionBuilderBlock) obj);
            }
        });
        $this$inState.condition(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TribeeSteamStateMachine.lambda$0$1$6((TribeeSteamState.SteamInfoState) obj));
            }
        }, new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return TribeeSteamStateMachine.lambda$0$1$7(TribeeSteamStateMachine.this, (ConditionBuilderBlock) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$1$0(TribeeSteamState.SteamInfoState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getShareState() instanceof TribeeSteamShareState.LoadingState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1$1(TribeeSteamStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new TribeeSteamStateMachine$1$2$5$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$1$2(TribeeSteamState.SteamInfoState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getShareState() instanceof TribeeSteamShareState.MaterialLoadedSuccessState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1$3(TribeeSteamStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new TribeeSteamStateMachine$1$2$7$1(null));
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new TribeeSteamStateMachine$1$2$7$2(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeSteamStateAction.CaptureScreenShot.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv2 = new TribeeSteamStateMachine$1$2$7$3(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(TribeeSteamStateAction.ToggleShareRange.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$1$4(TribeeSteamState.SteamInfoState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getShareMenuVM() != null && ((it.getShareState() instanceof TribeeSteamShareState.MaterialRefreshState) || (it.getShareState() instanceof TribeeSteamShareState.LoadingState));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1$5(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$condition, new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return TribeeSteamStateMachine.lambda$0$1$5$0((TribeeSteamState.SteamInfoState) obj);
            }
        }, (ExecutionPolicy) null, new TribeeSteamStateMachine$1$2$9$2(null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Flow lambda$0$1$5$0(TribeeSteamState.SteamInfoState state) {
        Flow state2;
        Intrinsics.checkNotNullParameter(state, "state");
        ShareMenuVM shareMenuVM = state.getShareMenuVM();
        return (shareMenuVM == null || (state2 = shareMenuVM.getState()) == null) ? FlowKt.emptyFlow() : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$1$6(TribeeSteamState.SteamInfoState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getAchievementState() instanceof TribeeSteamGameAchievementState.LoadingGameAchievementState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1$7(TribeeSteamStateMachine this$0, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new TribeeSteamStateMachine$1$2$11$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(TribeeSteamStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeSteamStateMachine$1$3$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeSteamStateAction.Initiate.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new TribeeSteamStateMachine$1$3$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(TribeeSteamStateAction.LaunchPolling.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new TribeeSteamStateMachine$1$3$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(TribeeSteamStateAction.UnbindSteamAccount.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new TribeeSteamStateMachine$1$3$4(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(TribeeSteamStateAction.AwaitSteamBindResult.class), executionPolicy$iv4, handler$iv4);
        return Unit.INSTANCE;
    }
}