package kntr.app.tribee.publish.core.v2;

import javax.inject.Inject;
import kntr.app.tribee.publish.core.v2.di.TribeePublishCoroutineScope;
import kntr.app.tribee.publish.core.v2.di.TribeePublishOuroStore;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroStore;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishViewModel;", "", "stateMachine", "Lkntr/app/tribee/publish/core/v2/TribeePublishStateMachine;", "initState", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "ouroStore", "Lkntr/common/ouro/core/OuroStore;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkntr/app/tribee/publish/core/v2/TribeePublishStateMachine;Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;Lkntr/common/ouro/core/OuroStore;Lkotlinx/coroutines/CoroutineScope;)V", "getOuroStore", "()Lkntr/common/ouro/core/OuroStore;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "dispatch", "", "action", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "(Lkntr/app/tribee/publish/core/v2/TribeePublishAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishViewModel {
    private final CoroutineScope coroutineScope;
    private final TribeePublishState initState;
    private final OuroStore ouroStore;
    private final StateFlow<TribeePublishState> state;
    private final TribeePublishStateMachine stateMachine;

    @Inject
    public TribeePublishViewModel(TribeePublishStateMachine stateMachine, TribeePublishState initState, @TribeePublishOuroStore OuroStore ouroStore, @TribeePublishCoroutineScope CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        Intrinsics.checkNotNullParameter(initState, "initState");
        Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.stateMachine = stateMachine;
        this.initState = initState;
        this.ouroStore = ouroStore;
        this.coroutineScope = coroutineScope;
        this.state = FlowKt.stateIn(this.stateMachine.getState(), this.coroutineScope, SharingStarted.Companion.getLazily(), this.initState);
    }

    public final OuroStore getOuroStore() {
        return this.ouroStore;
    }

    public final StateFlow<TribeePublishState> getState() {
        return this.state;
    }

    public final Object dispatch(TribeePublishAction action, Continuation<? super Unit> continuation) {
        Object dispatch = this.stateMachine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }
}