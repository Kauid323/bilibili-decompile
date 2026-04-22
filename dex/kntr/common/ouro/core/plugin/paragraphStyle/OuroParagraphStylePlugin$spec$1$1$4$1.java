package kntr.common.ouro.core.plugin.paragraphStyle;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
/* compiled from: OuroParagraphStylePlugin.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/OuroState;", "action", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleTextAlignAction;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$spec$1$1$4$1", f = "OuroParagraphStylePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroParagraphStylePlugin$spec$1$1$4$1 extends SuspendLambda implements Function3<OuroToggleTextAlignAction, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroParagraphStylePlugin$spec$1$1$4$1(Continuation<? super OuroParagraphStylePlugin$spec$1$1$4$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OuroToggleTextAlignAction ouroToggleTextAlignAction, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        OuroParagraphStylePlugin$spec$1$1$4$1 ouroParagraphStylePlugin$spec$1$1$4$1 = new OuroParagraphStylePlugin$spec$1$1$4$1(continuation);
        ouroParagraphStylePlugin$spec$1$1$4$1.L$0 = ouroToggleTextAlignAction;
        ouroParagraphStylePlugin$spec$1$1$4$1.L$1 = state;
        return ouroParagraphStylePlugin$spec$1$1$4$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final OuroToggleTextAlignAction action = (OuroToggleTextAlignAction) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$spec$1$1$4$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OuroState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OuroParagraphStylePlugin$spec$1$1$4$1.invokeSuspend$lambda$0(OuroToggleTextAlignAction.this, (OuroState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState invokeSuspend$lambda$0(OuroToggleTextAlignAction $action, OuroState $this$mutate) {
        OuroState addParagraphMarks;
        OuroState removeParagraphMarks;
        KClass key$iv = Reflection.getOrCreateKotlinClass(OuroParagraphStylePlugin.class);
        OuroPluginState ouroPluginState = $this$mutate.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroParagraphStyleState)) {
            ouroPluginState = null;
        }
        OuroParagraphStyleState ouroParagraphStyleState = (OuroParagraphStyleState) ouroPluginState;
        if (ouroParagraphStyleState != null) {
            Intrinsics.checkNotNull(ouroParagraphStyleState, "null cannot be cast to non-null type kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState.Active");
            OuroParagraphStyleState.Active paragraphMarkState = (OuroParagraphStyleState.Active) ouroParagraphStyleState;
            if (Intrinsics.areEqual(paragraphMarkState.getMarks().get($action.getMark().getKey()), $action.getMark())) {
                removeParagraphMarks = OuroParagraphStylePlugin.INSTANCE.removeParagraphMarks($this$mutate, CollectionsKt.listOf($action.getMark()));
                return removeParagraphMarks;
            }
            addParagraphMarks = OuroParagraphStylePlugin.INSTANCE.addParagraphMarks($this$mutate, CollectionsKt.listOf($action.getMark()));
            return addParagraphMarks;
        }
        throw new NoSuchElementException("No plugin state for " + key$iv);
    }
}