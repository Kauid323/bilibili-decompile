package kntr.common.ouro.core.reducer;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroUpdateSelectionAction;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroCommonReudcer.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class OuroCommonReudcerKt$onCommonAction$1 extends AdaptedFunctionReference implements Function3<OuroUpdateSelectionAction, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object>, SuspendFunction {
    public static final OuroCommonReudcerKt$onCommonAction$1 INSTANCE = new OuroCommonReudcerKt$onCommonAction$1();

    OuroCommonReudcerKt$onCommonAction$1() {
        super(3, OuroCommonReudcerKt.class, "handleUpdateSelectionAction", "handleUpdateSelectionAction(Lkntr/common/ouro/core/action/OuroUpdateSelectionAction;Lcom/freeletics/flowredux/dsl/State;)Lcom/freeletics/flowredux/dsl/ChangedState;", 5);
    }

    public final Object invoke(OuroUpdateSelectionAction p0, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        Object handleUpdateSelectionAction;
        handleUpdateSelectionAction = OuroCommonReudcerKt.handleUpdateSelectionAction(p0, state);
        return handleUpdateSelectionAction;
    }
}