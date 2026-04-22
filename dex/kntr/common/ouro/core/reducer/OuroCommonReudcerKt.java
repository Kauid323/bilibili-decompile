package kntr.common.ouro.core.reducer;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.action.OuroUpdateSelectionAction;
import kntr.common.ouro.core.model.OuroSelection;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.utils.FlowReduxUtilsKt;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: OuroCommonReudcer.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0000\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0002¨\u0006\u000b"}, d2 = {"onCommonAction", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/common/ouro/core/OuroState;", "Lkntr/common/ouro/core/action/OuroAction;", "handleUpdateSelectionAction", "Lcom/freeletics/flowredux/dsl/ChangedState;", "action", "Lkntr/common/ouro/core/action/OuroUpdateSelectionAction;", "state", "Lcom/freeletics/flowredux/dsl/State;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroCommonReudcerKt {
    public static final void onCommonAction(InStateBuilderBlock<OuroState, OuroState, OuroAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock this_$iv = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.ORDERED;
        Function3 handler$iv = OuroCommonReudcerKt$onCommonAction$1.INSTANCE;
        this_$iv.on(Reflection.getOrCreateKotlinClass(OuroUpdateSelectionAction.class), executionPolicy$iv, handler$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleUpdateSelectionAction(final OuroUpdateSelectionAction action, State<OuroState> state) {
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroCommonReudcerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                OuroState handleUpdateSelectionAction$lambda$0;
                handleUpdateSelectionAction$lambda$0 = OuroCommonReudcerKt.handleUpdateSelectionAction$lambda$0(OuroUpdateSelectionAction.this, (OuroState) obj);
                return handleUpdateSelectionAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleUpdateSelectionAction$lambda$0(OuroUpdateSelectionAction $action, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        if (!$action.getNeedConstrain()) {
            if (!Intrinsics.areEqual($this$mutate.getTextRange(), $action.getRange())) {
                return OuroState.copy$default($this$mutate, null, $action.getRange(), null, null, null, 29, null);
            }
        } else {
            OuroSelection selection = $this$mutate.getSelection($action.getRange());
            OuroSelection constrainedSelection = OuroNodeStorageUtilsKt.constrainSelection$default(selection, $this$mutate.getStorage().getAllSelectables(), false, 4, null);
            OuroTextRange constrainedTextRange = $this$mutate.getTextRange(constrainedSelection);
            if (!Intrinsics.areEqual($this$mutate.getTextRange(), constrainedTextRange)) {
                return OuroState.copy$default($this$mutate, null, constrainedTextRange, null, null, null, 29, null);
            }
        }
        return $this$mutate;
    }
}