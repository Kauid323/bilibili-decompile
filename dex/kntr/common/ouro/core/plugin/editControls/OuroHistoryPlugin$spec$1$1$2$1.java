package kntr.common.ouro.core.plugin.editControls;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Map;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroHistoryPlugin.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/OuroState;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$spec$1$1$2$1", f = "OuroHistoryPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroHistoryPlugin$spec$1$1$2$1 extends SuspendLambda implements Function2<State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroHistoryPlugin$spec$1$1$2$1(Continuation<? super OuroHistoryPlugin$spec$1$1$2$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> ouroHistoryPlugin$spec$1$1$2$1 = new OuroHistoryPlugin$spec$1$1$2$1(continuation);
        ouroHistoryPlugin$spec$1$1$2$1.L$0 = obj;
        return ouroHistoryPlugin$spec$1$1$2$1;
    }

    public final Object invoke(State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$spec$1$1$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OuroState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OuroHistoryPlugin$spec$1$1$2$1.invokeSuspend$lambda$0((OuroState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState invokeSuspend$lambda$0(OuroState $this$mutate) {
        KClass key$iv;
        KClass forKey$iv;
        key$iv = OuroHistoryPlugin.key;
        OuroPluginState ouroPluginState = $this$mutate.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroHistoryState)) {
            ouroPluginState = null;
        }
        OuroHistoryState ouroHistoryState = (OuroHistoryState) ouroPluginState;
        if (ouroHistoryState != null) {
            OuroHistoryState currentState = ouroHistoryState;
            OuroHistoryState newState = OuroHistoryState.update$core_debug$default(currentState, $this$mutate, null, 2, null);
            forKey$iv = OuroHistoryPlugin.key;
            Map newPluginStates$iv = MapsKt.toMutableMap($this$mutate.getPluginStates());
            newPluginStates$iv.put(forKey$iv, newState);
            return OuroState.copy$default($this$mutate, null, null, null, null, MapsKt.toMap(newPluginStates$iv), 15, null);
        }
        throw new NoSuchElementException("No plugin state for " + key$iv);
    }
}