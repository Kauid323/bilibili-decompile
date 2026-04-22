package kntr.common.ouro.core.reducer;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroOutdentAction;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroEditActionReducer.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class OuroEditActionReducerKt$onEditAction$9 extends AdaptedFunctionReference implements Function3<OuroOutdentAction, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object>, SuspendFunction {
    public static final OuroEditActionReducerKt$onEditAction$9 INSTANCE = new OuroEditActionReducerKt$onEditAction$9();

    OuroEditActionReducerKt$onEditAction$9() {
        super(3, OuroEditActionReducerKt.class, "handleOutdentAction", "handleOutdentAction(Lkntr/common/ouro/core/action/OuroOutdentAction;Lcom/freeletics/flowredux/dsl/State;)Lcom/freeletics/flowredux/dsl/ChangedState;", 5);
    }

    public final Object invoke(OuroOutdentAction p0, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        Object handleOutdentAction;
        handleOutdentAction = OuroEditActionReducerKt.handleOutdentAction(p0, state);
        return handleOutdentAction;
    }
}