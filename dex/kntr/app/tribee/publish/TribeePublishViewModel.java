package kntr.app.tribee.publish;

import javax.inject.Inject;
import kntr.app.tribee.publish.di.TribeePublishCoroutineScope;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: TribeePublishViewModel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishViewModel;", "", "stateMachine", "Lkntr/app/tribee/publish/TribeePublishStateMachine;", "initState", "Lkntr/app/tribee/publish/TribeePublishState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkntr/app/tribee/publish/TribeePublishStateMachine;Lkntr/app/tribee/publish/TribeePublishState;Lkotlinx/coroutines/CoroutineScope;)V", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "dispatch", "", "action", "Lkntr/app/tribee/publish/TribeePublishAction;", "(Lkntr/app/tribee/publish/TribeePublishAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishViewModel {
    private final CoroutineScope coroutineScope;
    private final TribeePublishState initState;
    private final StateFlow<TribeePublishState> state;
    private final TribeePublishStateMachine stateMachine;

    @Inject
    public TribeePublishViewModel(TribeePublishStateMachine stateMachine, TribeePublishState initState, @TribeePublishCoroutineScope CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        Intrinsics.checkNotNullParameter(initState, "initState");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.stateMachine = stateMachine;
        this.initState = initState;
        this.coroutineScope = coroutineScope;
        this.state = FlowKt.stateIn(this.stateMachine.getState(), this.coroutineScope, SharingStarted.Companion.getLazily(), this.initState);
    }

    public final StateFlow<TribeePublishState> getState() {
        return this.state;
    }

    public final Object dispatch(TribeePublishAction action, Continuation<? super Unit> continuation) {
        Object dispatch = this.stateMachine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }
}