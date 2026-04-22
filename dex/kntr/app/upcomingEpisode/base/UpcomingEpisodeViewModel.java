package kntr.app.upcomingEpisode.base;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeAction;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeStateMachine;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: UpcomingEpisodeViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkntr/app/upcomingEpisode/base/UpcomingEpisodeViewModel;", "", "stateMachine", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeStateMachine;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeStateMachine;Lkotlinx/coroutines/CoroutineScope;)V", "dataFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "getDataFlow$annotations", "()V", "getDataFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "dispatch", "", "action", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeViewModel {
    public static final int $stable = 8;
    private final StateFlow<UpcomingEpisodeData> dataFlow;
    private final CoroutineScope scope;
    private final UpcomingEpisodeStateMachine stateMachine;

    public static /* synthetic */ void getDataFlow$annotations() {
    }

    public UpcomingEpisodeViewModel(UpcomingEpisodeStateMachine stateMachine, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.stateMachine = stateMachine;
        this.scope = scope;
        this.dataFlow = FlowKt.stateIn(this.stateMachine.getState(), this.scope, SharingStarted.Companion.getLazily(), new UpcomingEpisodeData(false, null, null, null, null, null, null, null, false, 511, null));
    }

    public final StateFlow<UpcomingEpisodeData> getDataFlow() {
        return this.dataFlow;
    }

    public final void dispatch(UpcomingEpisodeAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new UpcomingEpisodeViewModel$dispatch$1(this, action, null), 3, (Object) null);
    }
}