package kntr.app.tribee.search.viewModels;

import androidx.compose.foundation.text.input.TextFieldStateKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.search.event.TribeeSearchEvent;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSearchViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/search/state/TribeeSearchState;", "<unused var>", "Lkntr/app/tribee/search/event/TribeeSearchEvent$ClearQueryText;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$1$1", f = "TribeeSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSearchViewModel$machine$1$1$1 extends SuspendLambda implements Function3<TribeeSearchEvent.ClearQueryText, State<TribeeSearchState>, Continuation<? super ChangedState<? extends TribeeSearchState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeSearchViewModel$machine$1$1$1(Continuation<? super TribeeSearchViewModel$machine$1$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeeSearchEvent.ClearQueryText clearQueryText, State<TribeeSearchState> state, Continuation<? super ChangedState<? extends TribeeSearchState>> continuation) {
        TribeeSearchViewModel$machine$1$1$1 tribeeSearchViewModel$machine$1$1$1 = new TribeeSearchViewModel$machine$1$1$1(continuation);
        tribeeSearchViewModel$machine$1$1$1.L$0 = state;
        return tribeeSearchViewModel$machine$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TribeeSearchState snapshot = (TribeeSearchState) state.getSnapshot();
                TextFieldStateKt.clearText(snapshot.getSearchBarState().getTextFieldState());
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}