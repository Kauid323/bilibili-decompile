package kntr.app.tribee.search.viewModels;

import androidx.compose.foundation.text.input.TextFieldStateKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.search.base.TribeeSearchStore;
import kntr.app.tribee.search.event.TribeeSearchEvent;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.tribee.search.track.SearchTrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/search/state/TribeeSearchState;", "action", "Lkntr/app/tribee/search/event/TribeeSearchEvent$DoSearch;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$1$2", f = "TribeeSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSearchViewModel$machine$1$1$2 extends SuspendLambda implements Function3<TribeeSearchEvent.DoSearch, State<TribeeSearchState>, Continuation<? super ChangedState<? extends TribeeSearchState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ TribeeSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSearchViewModel$machine$1$1$2(TribeeSearchViewModel tribeeSearchViewModel, Continuation<? super TribeeSearchViewModel$machine$1$1$2> continuation) {
        super(3, continuation);
        this.this$0 = tribeeSearchViewModel;
    }

    public final Object invoke(TribeeSearchEvent.DoSearch doSearch, State<TribeeSearchState> state, Continuation<? super ChangedState<? extends TribeeSearchState>> continuation) {
        TribeeSearchViewModel$machine$1$1$2 tribeeSearchViewModel$machine$1$1$2 = new TribeeSearchViewModel$machine$1$1$2(this.this$0, continuation);
        tribeeSearchViewModel$machine$1$1$2.L$0 = doSearch;
        tribeeSearchViewModel$machine$1$1$2.L$1 = state;
        return tribeeSearchViewModel$machine$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        String tribeeSearchUri;
        TribeeSearchEvent.DoSearch action = (TribeeSearchEvent.DoSearch) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String keyword = action.getKeyword();
                final TribeeSearchState snapshot = (TribeeSearchState) state.getSnapshot();
                if (keyword.length() > 0) {
                    TribeeSearchStore tribeeSearchStore = TribeeSearchStore.INSTANCE;
                    str = this.this$0.tribeeId;
                    tribeeSearchStore.store(keyword, str);
                    if (snapshot instanceof TribeeSearchState.Find) {
                        TextFieldStateKt.clearText(((TribeeSearchState.Find) snapshot).getSearchBarState().getTextFieldState());
                        TribeeSearchViewModel tribeeSearchViewModel = this.this$0;
                        tribeeSearchUri = this.this$0.tribeeSearchUri(keyword, SearchTrackerKt.SEARCH_DISCOVER_SPMID);
                        tribeeSearchViewModel.onJumpUriChanged(tribeeSearchUri);
                        return state.noChange();
                    } else if (!(snapshot instanceof TribeeSearchState.Result)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        return state.override(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$1$2$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                TribeeSearchState.Result.Loading invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = TribeeSearchViewModel$machine$1$1$2.invokeSuspend$lambda$0(TribeeSearchState.this, (TribeeSearchState) obj);
                                return invokeSuspend$lambda$0;
                            }
                        });
                    }
                }
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSearchState.Result.Loading invokeSuspend$lambda$0(TribeeSearchState $snapshot, TribeeSearchState $this$override) {
        return new TribeeSearchState.Result.Loading($snapshot.getSearchBarState(), $snapshot.getGlobalSearchUri(), $snapshot.getTribeeId(), null, 8, null);
    }
}