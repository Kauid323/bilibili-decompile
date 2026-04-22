package kntr.app.tribee.search.viewModels;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.tribee.search.base.TribeeSearchStore;
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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/search/state/TribeeSearchState;", "<unused var>", "Lkntr/app/tribee/search/event/TribeeSearchEvent$RefreshHistory;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/search/state/TribeeSearchState$Find;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$2$2", f = "TribeeSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSearchViewModel$machine$1$2$2 extends SuspendLambda implements Function3<TribeeSearchEvent.RefreshHistory, State<TribeeSearchState.Find>, Continuation<? super ChangedState<? extends TribeeSearchState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TribeeSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSearchViewModel$machine$1$2$2(TribeeSearchViewModel tribeeSearchViewModel, Continuation<? super TribeeSearchViewModel$machine$1$2$2> continuation) {
        super(3, continuation);
        this.this$0 = tribeeSearchViewModel;
    }

    public final Object invoke(TribeeSearchEvent.RefreshHistory refreshHistory, State<TribeeSearchState.Find> state, Continuation<? super ChangedState<? extends TribeeSearchState>> continuation) {
        TribeeSearchViewModel$machine$1$2$2 tribeeSearchViewModel$machine$1$2$2 = new TribeeSearchViewModel$machine$1$2$2(this.this$0, continuation);
        tribeeSearchViewModel$machine$1$2$2.L$0 = state;
        return tribeeSearchViewModel$machine$1$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final TribeeSearchState.Find snapshot = (TribeeSearchState.Find) state.getSnapshot();
                TribeeSearchStore tribeeSearchStore = TribeeSearchStore.INSTANCE;
                str = this.this$0.tribeeId;
                final List latestHistory = tribeeSearchStore.getHistories(str);
                return state.mutate(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$2$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeSearchState.Find copy$default;
                        TribeeSearchState.Find find = (TribeeSearchState.Find) obj;
                        copy$default = TribeeSearchState.Find.copy$default(TribeeSearchState.Find.this, null, null, null, false, false, latestHistory, 31, null);
                        return copy$default;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}