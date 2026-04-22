package kntr.app.tribee.invite.viewmodel;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import javax.inject.Inject;
import kntr.app.tribee.invite.service.TribeeInviteDataService;
import kntr.app.tribee.invite.state.TribeeInviteState;
import kntr.app.tribee.invite.viewmodel.TribeeInviteStateAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: TribeeInviteStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/tribee/invite/state/TribeeInviteState;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateAction;", "dataService", "Lkntr/app/tribee/invite/service/TribeeInviteDataService;", "<init>", "(Lkntr/app/tribee/invite/service/TribeeInviteDataService;)V", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInviteStateMachine extends FlowReduxStateMachine<TribeeInviteState, TribeeInviteStateAction> {
    public static final int $stable = 8;
    private final TribeeInviteDataService dataService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public TribeeInviteStateMachine(TribeeInviteDataService dataService) {
        super(TribeeInviteState.TribeeInviteInitiateState.INSTANCE);
        Intrinsics.checkNotNullParameter(dataService, "dataService");
        this.dataService = dataService;
        spec(new Function1() { // from class: kntr.app.tribee.invite.viewmodel.TribeeInviteStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = TribeeInviteStateMachine._init_$lambda$0(TribeeInviteStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final TribeeInviteStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.invite.viewmodel.TribeeInviteStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return TribeeInviteStateMachine.lambda$0$0(TribeeInviteStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeInviteState.TribeeInviteInitiateState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.tribee.invite.viewmodel.TribeeInviteStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return TribeeInviteStateMachine.lambda$0$1((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(TribeeInviteState.TribeeInviteErrorState.class), block$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(TribeeInviteStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeeInviteStateMachine$1$1$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeInviteStateMachine$1$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeInviteStateAction.Initiate.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }
}