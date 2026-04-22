package kntr.common.ouro.core.reducer;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroReplacePlainNodesWithStoragesAction;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroEditActionReducer.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class OuroEditActionReducerKt$onEditAction$12 extends AdaptedFunctionReference implements Function3<OuroReplacePlainNodesWithStoragesAction, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object>, SuspendFunction {
    public static final OuroEditActionReducerKt$onEditAction$12 INSTANCE = new OuroEditActionReducerKt$onEditAction$12();

    OuroEditActionReducerKt$onEditAction$12() {
        super(3, OuroEditActionReducerKt.class, "handleReplacePlainNodesWithStoragesAction", "handleReplacePlainNodesWithStoragesAction(Lkntr/common/ouro/core/action/OuroReplacePlainNodesWithStoragesAction;Lcom/freeletics/flowredux/dsl/State;)Lcom/freeletics/flowredux/dsl/ChangedState;", 5);
    }

    public final Object invoke(OuroReplacePlainNodesWithStoragesAction p0, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        Object handleReplacePlainNodesWithStoragesAction;
        handleReplacePlainNodesWithStoragesAction = OuroEditActionReducerKt.handleReplacePlainNodesWithStoragesAction(p0, state);
        return handleReplacePlainNodesWithStoragesAction;
    }
}