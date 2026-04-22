package kntr.app.deepsearch.history;

import javax.inject.Inject;
import kntr.app.deepsearch.base.model.history.DSHistoryAction;
import kntr.app.deepsearch.base.model.history.DSHistoryData;
import kntr.app.deepsearch.history.di.DSHistoryScope;
import kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: DSHistoryViewModel.kt */
@DSHistoryScope
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/history/DSHistoryViewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "stateMachine", "Lkntr/app/deepsearch/history/stateMachine/DSHistoryStateMachine;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljava/lang/String;Lkntr/app/deepsearch/history/stateMachine/DSHistoryStateMachine;Lkotlinx/coroutines/CoroutineScope;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "data", "Lkotlinx/coroutines/flow/StateFlow;", "Lkntr/app/deepsearch/base/model/history/DSHistoryData;", "getData$annotations", "()V", "getData", "()Lkotlinx/coroutines/flow/StateFlow;", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction;", "history_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DSHistoryViewModel {
    private final StateFlow<DSHistoryData> data;
    private final CoroutineScope scope;
    private final DSHistoryStateMachine stateMachine;

    public static /* synthetic */ void getData$annotations() {
    }

    @Inject
    public DSHistoryViewModel(String sessionId, DSHistoryStateMachine stateMachine, @DSHistoryScope CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.stateMachine = stateMachine;
        this.scope = scope;
        this.data = FlowKt.stateIn(this.stateMachine.getState(), this.scope, SharingStarted.Companion.getLazily(), new DSHistoryData(sessionId, null, null, null, null, null, 62, null));
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final StateFlow<DSHistoryData> getData() {
        return this.data;
    }

    public final void dispatch(DSHistoryAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new DSHistoryViewModel$dispatch$1(this, action, null), 3, (Object) null);
    }
}