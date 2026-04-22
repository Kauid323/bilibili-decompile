package kntr.common.ouro.core.reducer;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroIndentAction;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroEditActionReducer.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class OuroEditActionReducerKt$onEditAction$8 extends AdaptedFunctionReference implements Function3<OuroIndentAction, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object>, SuspendFunction {
    public static final OuroEditActionReducerKt$onEditAction$8 INSTANCE = new OuroEditActionReducerKt$onEditAction$8();

    OuroEditActionReducerKt$onEditAction$8() {
        super(3, OuroEditActionReducerKt.class, "handleIndentAction", "handleIndentAction(Lkntr/common/ouro/core/action/OuroIndentAction;Lcom/freeletics/flowredux/dsl/State;)Lcom/freeletics/flowredux/dsl/ChangedState;", 5);
    }

    public final Object invoke(OuroIndentAction p0, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        Object handleIndentAction;
        handleIndentAction = OuroEditActionReducerKt.handleIndentAction(p0, state);
        return handleIndentAction;
    }
}