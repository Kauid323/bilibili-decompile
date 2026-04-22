package kntr.common.photonic.aphro.core;

import javax.inject.Inject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: AphroViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroViewModel;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "initState", "Lkntr/common/photonic/aphro/core/AphroState$Init;", "stateMachine", "Lkntr/common/photonic/aphro/core/AphroStateMachine;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkntr/common/photonic/aphro/core/AphroState$Init;Lkntr/common/photonic/aphro/core/AphroStateMachine;)V", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkntr/common/photonic/aphro/core/AphroState;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "dispatch", "", "action", "Lkntr/common/photonic/aphro/core/AphroAction;", "(Lkntr/common/photonic/aphro/core/AphroAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AphroViewModel {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    private final AphroState.Init initState;
    private final StateFlow<AphroState> stateFlow;
    private final AphroStateMachine stateMachine;

    @Inject
    public AphroViewModel(@AphroCoroutineScope CoroutineScope coroutineScope, AphroState.Init initState, AphroStateMachine stateMachine) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(initState, "initState");
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        this.coroutineScope = coroutineScope;
        this.initState = initState;
        this.stateMachine = stateMachine;
        KLog_androidKt.getKLog().i("AphroViewModel", "Init with " + this.initState);
        this.stateFlow = FlowKt.stateIn(this.stateMachine.getState(), this.coroutineScope, SharingStarted.Companion.getLazily(), this.initState);
    }

    public final StateFlow<AphroState> getStateFlow() {
        return this.stateFlow;
    }

    public final Object dispatch(AphroAction action, Continuation<? super Unit> continuation) {
        Object dispatch = this.stateMachine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }
}