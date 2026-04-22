package kntr.app.tribee.search.viewModels;

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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSearchViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/search/state/TribeeSearchState;", "<unused var>", "Lkntr/app/tribee/search/event/TribeeSearchEvent$ShowClearHistoryDialog;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/search/state/TribeeSearchState$Find;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$2$3", f = "TribeeSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSearchViewModel$machine$1$2$3 extends SuspendLambda implements Function3<TribeeSearchEvent.ShowClearHistoryDialog, State<TribeeSearchState.Find>, Continuation<? super ChangedState<? extends TribeeSearchState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeSearchViewModel$machine$1$2$3(Continuation<? super TribeeSearchViewModel$machine$1$2$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeeSearchEvent.ShowClearHistoryDialog showClearHistoryDialog, State<TribeeSearchState.Find> state, Continuation<? super ChangedState<? extends TribeeSearchState>> continuation) {
        TribeeSearchViewModel$machine$1$2$3 tribeeSearchViewModel$machine$1$2$3 = new TribeeSearchViewModel$machine$1$2$3(continuation);
        tribeeSearchViewModel$machine$1$2$3.L$0 = state;
        return tribeeSearchViewModel$machine$1$2$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final TribeeSearchState.Find snapshot = (TribeeSearchState.Find) state.getSnapshot();
                return state.mutate(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$2$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeSearchState.Find copy$default;
                        TribeeSearchState.Find find = (TribeeSearchState.Find) obj;
                        copy$default = TribeeSearchState.Find.copy$default(TribeeSearchState.Find.this, null, null, null, false, true, null, 47, null);
                        return copy$default;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}