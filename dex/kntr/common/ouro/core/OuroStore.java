package kntr.common.ouro.core;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.action.OuroSyncAction;
import kntr.common.ouro.core.di.OuroCoroutineScope;
import kntr.common.ouro.core.di.OuroInitialState;
import kntr.common.ouro.core.di.OuroScope;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: OuroStore.kt */
@OuroScope
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B>\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u001bH\u0087@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lkntr/common/ouro/core/OuroStore;", "", "parentScope", "Lkotlinx/coroutines/CoroutineScope;", "initialState", "Lkntr/common/ouro/core/OuroState;", "plugins", "", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "Lkotlin/jvm/JvmSuppressWildcards;", "stateMachine", "Lkntr/common/ouro/core/OuroStateMachine;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkntr/common/ouro/core/OuroState;Ljava/util/Set;Lkntr/common/ouro/core/OuroStateMachine;)V", "scope", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow$annotations", "()V", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "dispatch", "", "action", "Lkntr/common/ouro/core/action/OuroAction;", "dispatchAndWait", "Lkntr/common/ouro/core/action/OuroSyncAction;", "(Lkntr/common/ouro/core/action/OuroSyncAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroStore {
    private final CoroutineScope parentScope;
    private final CoroutineScope scope;
    private final StateFlow<OuroState> stateFlow;
    private final OuroStateMachine stateMachine;

    public static /* synthetic */ void getStateFlow$annotations() {
    }

    @Inject
    public OuroStore(@OuroCoroutineScope CoroutineScope parentScope, @OuroInitialState OuroState initialState, Set<OuroPlugin<OuroPluginState>> set, OuroStateMachine stateMachine) {
        Intrinsics.checkNotNullParameter(parentScope, "parentScope");
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(set, "plugins");
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        this.parentScope = parentScope;
        this.stateMachine = stateMachine;
        this.scope = CoroutineScopeKt.CoroutineScope(this.parentScope.getCoroutineContext().plus(Dispatchers.getDefault().limitedParallelism(1)).plus(new CoroutineName("OuroCoroutineScope")));
        Flow state = this.stateMachine.getState();
        CoroutineScope coroutineScope = this.scope;
        SharingStarted eagerly = SharingStarted.Companion.getEagerly();
        Set<OuroPlugin<OuroPluginState>> $this$associate$iv = set;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            OuroPlugin it = (OuroPlugin) element$iv$iv;
            Pair pair = TuplesKt.to(Reflection.getOrCreateKotlinClass(it.getClass()), it.getInitState());
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        this.stateFlow = FlowKt.stateIn(state, coroutineScope, eagerly, OuroState.copy$default(initialState, null, null, null, null, destination$iv$iv, 15, null));
    }

    public final StateFlow<OuroState> getStateFlow() {
        return this.stateFlow;
    }

    public final void dispatch(OuroAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        KLog_androidKt.getKLog().d("OuroStore", "dispatching action " + action);
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new OuroStore$dispatch$1(this, action, null), 3, (Object) null);
    }

    public final Object dispatchAndWait(OuroSyncAction action, Continuation<? super OuroState> continuation) {
        dispatch(action);
        return action.getDeferred().await(continuation);
    }
}