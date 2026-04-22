package kntr.common.ouro.core.plugin.textStyle;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Map;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.mark.OuroUnderlineMark;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroTextStylePlugin.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/OuroState;", "<unused var>", "Lkntr/common/ouro/core/plugin/textStyle/OuroToggleUnderlineAction;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$spec$1$1$6$3", f = "OuroTextStylePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroTextStylePlugin$spec$1$1$6$3 extends SuspendLambda implements Function3<OuroToggleUnderlineAction, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroTextStylePlugin$spec$1$1$6$3(Continuation<? super OuroTextStylePlugin$spec$1$1$6$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OuroToggleUnderlineAction ouroToggleUnderlineAction, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        OuroTextStylePlugin$spec$1$1$6$3 ouroTextStylePlugin$spec$1$1$6$3 = new OuroTextStylePlugin$spec$1$1$6$3(continuation);
        ouroTextStylePlugin$spec$1$1$6$3.L$0 = state;
        return ouroTextStylePlugin$spec$1$1$6$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$spec$1$1$6$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OuroState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OuroTextStylePlugin$spec$1$1$6$3.invokeSuspend$lambda$0((OuroState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState invokeSuspend$lambda$0(OuroState $this$mutate) {
        OuroTextStyleState.Preview newState;
        KClass key$iv = Reflection.getOrCreateKotlinClass(OuroTextStylePlugin.class);
        OuroPluginState ouroPluginState = $this$mutate.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroTextStyleState)) {
            ouroPluginState = null;
        }
        OuroTextStyleState ouroTextStyleState = (OuroTextStyleState) ouroPluginState;
        if (ouroTextStyleState != null) {
            Intrinsics.checkNotNull(ouroTextStyleState, "null cannot be cast to non-null type kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState.Preview");
            OuroTextStyleState.Preview currentState = (OuroTextStyleState.Preview) ouroTextStyleState;
            if (currentState.getDisplayPanelStyle().isUnderline()) {
                newState = new OuroTextStyleState.Preview(currentState.getDisplayPanelStyle().getMarks().minus((OuroMarks<OuroTextMark>) OuroUnderlineMark.INSTANCE));
            } else {
                newState = new OuroTextStyleState.Preview(currentState.getDisplayPanelStyle().getMarks().plus((OuroMarks<OuroTextMark>) OuroUnderlineMark.INSTANCE));
            }
            KClass forKey$iv = Reflection.getOrCreateKotlinClass(OuroTextStylePlugin.class);
            Map newPluginStates$iv = MapsKt.toMutableMap($this$mutate.getPluginStates());
            newPluginStates$iv.put(forKey$iv, newState);
            return OuroState.copy$default($this$mutate, null, null, null, null, MapsKt.toMap(newPluginStates$iv), 15, null);
        }
        throw new NoSuchElementException("No plugin state for " + key$iv);
    }
}