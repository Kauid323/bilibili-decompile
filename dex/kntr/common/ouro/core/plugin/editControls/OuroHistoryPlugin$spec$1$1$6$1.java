package kntr.common.ouro.core.plugin.editControls;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Map;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.editControls.OuroHistoryAction;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroHistoryPlugin.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/OuroState;", "action", "Lkntr/common/ouro/core/plugin/editControls/OuroHistoryAction$Redo;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$spec$1$1$6$1", f = "OuroHistoryPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroHistoryPlugin$spec$1$1$6$1 extends SuspendLambda implements Function3<OuroHistoryAction.Redo, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroHistoryPlugin$spec$1$1$6$1(Continuation<? super OuroHistoryPlugin$spec$1$1$6$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OuroHistoryAction.Redo redo, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        OuroHistoryPlugin$spec$1$1$6$1 ouroHistoryPlugin$spec$1$1$6$1 = new OuroHistoryPlugin$spec$1$1$6$1(continuation);
        ouroHistoryPlugin$spec$1$1$6$1.L$0 = state;
        return ouroHistoryPlugin$spec$1$1$6$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        KClass key$iv;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                OuroState this_$iv = (OuroState) state.getSnapshot();
                key$iv = OuroHistoryPlugin.key;
                OuroPluginState ouroPluginState = this_$iv.getPluginStates().get(key$iv);
                if (!(ouroPluginState instanceof OuroHistoryState)) {
                    ouroPluginState = null;
                }
                OuroHistoryState ouroHistoryState = (OuroHistoryState) ouroPluginState;
                if (ouroHistoryState != null) {
                    final OuroHistoryState historyState = ouroHistoryState.redo$core_debug();
                    OuroState this_$iv2 = (OuroState) state.getSnapshot();
                    OuroPluginState ouroPluginState2 = this_$iv2.getPluginStates().get(Reflection.getOrCreateKotlinClass(OuroLocalImagePlugin.class));
                    final OuroLocalImageState localImageState = ouroPluginState2 instanceof OuroLocalImageState ? ouroPluginState2 : null;
                    final OuroState redoState = historyState.getCurrent();
                    if (redoState != null) {
                        return state.override(new Function1() { // from class: kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin$spec$1$1$6$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                OuroState invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = OuroHistoryPlugin$spec$1$1$6$1.invokeSuspend$lambda$0(OuroHistoryState.this, localImageState, redoState, (OuroState) obj);
                                return invokeSuspend$lambda$0;
                            }
                        });
                    }
                    return state.noChange();
                }
                throw new NoSuchElementException("No plugin state for " + key$iv);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState invokeSuspend$lambda$0(OuroHistoryState $historyState, OuroLocalImageState $localImageState, OuroState $redoState, OuroState $this$override) {
        KClass kClass;
        Map newPluginStates = MapsKt.toMutableMap($this$override.getPluginStates());
        kClass = OuroHistoryPlugin.key;
        newPluginStates.put(kClass, $historyState);
        if ($localImageState != null) {
            newPluginStates.put(Reflection.getOrCreateKotlinClass(OuroLocalImagePlugin.class), $localImageState);
        }
        return OuroState.copy$default($redoState, null, null, null, null, MapsKt.toMap(newPluginStates), 15, null);
    }
}