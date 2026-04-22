package tv.danmaku.bili.state;

import com.bilibili.module.state.PlayState;
import com.bilibili.module.state.PlayStateUpdater;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.ijk.media.player.IjkPlayerManager;

/* compiled from: AppState.kt */
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/state/PlayStateImp;", "Lcom/bilibili/module/state/PlayStateUpdater;", "<init>", "()V", "stateFlowInternal", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bilibili/module/state/PlayState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "currentState", ReportUtilKt.POS_UPDATE, "", "info", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PlayStateImp implements PlayStateUpdater {
    public static final int $stable = 8;
    private final MutableStateFlow<PlayState> stateFlowInternal = StateFlowKt.MutableStateFlow(PlayState.INVALID.INSTANCE);
    private final StateFlow<PlayState> stateFlow = FlowKt.asStateFlow(this.stateFlowInternal);

    public StateFlow<PlayState> getStateFlow() {
        return this.stateFlow;
    }

    public PlayState currentState() {
        boolean isActive = IjkPlayerManager.getInstance().hasActivePlayer();
        PlayState state = (PlayState) (isActive ? PlayState.PLAYING.INSTANCE : PlayState.IDLE.INSTANCE);
        if (!Intrinsics.areEqual(state, this.stateFlowInternal.getValue())) {
            this.stateFlowInternal.setValue(state);
        }
        return state;
    }

    public void update(PlayState info) {
        Intrinsics.checkNotNullParameter(info, "info");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new PlayStateImp$update$1(this, info, null), 3, (Object) null);
    }
}