package kntr.app.tribee.search.viewModels;

import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchAllResp;
import com.bapis.bilibili.pagination.KPaginationReply;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.search.event.TribeeSearchEvent;
import kntr.app.tribee.search.service.TribeeSearchService;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSearchViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/search/state/TribeeSearchState;", "<unused var>", "Lkntr/app/tribee/search/event/TribeeSearchEvent$LoadMore;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/search/state/TribeeSearchState$Result$Success;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$5$1", f = "TribeeSearchViewModel.kt", i = {0, 0, 0, 0, 0}, l = {208}, m = "invokeSuspend", n = {"state", "snapshot", "next", "query", "tribeeIdLong"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"}, v = 1)
public final class TribeeSearchViewModel$machine$1$5$1 extends SuspendLambda implements Function3<TribeeSearchEvent.LoadMore, State<TribeeSearchState.Result.Success>, Continuation<? super ChangedState<? extends TribeeSearchState>>, Object> {
    long J$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TribeeSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSearchViewModel$machine$1$5$1(TribeeSearchViewModel tribeeSearchViewModel, Continuation<? super TribeeSearchViewModel$machine$1$5$1> continuation) {
        super(3, continuation);
        this.this$0 = tribeeSearchViewModel;
    }

    public final Object invoke(TribeeSearchEvent.LoadMore loadMore, State<TribeeSearchState.Result.Success> state, Continuation<? super ChangedState<? extends TribeeSearchState>> continuation) {
        TribeeSearchViewModel$machine$1$5$1 tribeeSearchViewModel$machine$1$5$1 = new TribeeSearchViewModel$machine$1$5$1(this.this$0, continuation);
        tribeeSearchViewModel$machine$1$5$1.L$0 = state;
        return tribeeSearchViewModel$machine$1$5$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final TribeeSearchState.Result.Success snapshot;
        String query;
        String query2;
        Object obj;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                snapshot = (TribeeSearchState.Result.Success) state.getSnapshot();
                KPaginationReply nextPage = snapshot.getNextPage();
                String next = nextPage != null ? nextPage.getNext() : null;
                if (!snapshot.isLoadingMore()) {
                    String str = next;
                    if (!(str == null || str.length() == 0)) {
                        state.mutate(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$5$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                TribeeSearchState.Result.Success copy$default;
                                TribeeSearchState.Result.Success success = (TribeeSearchState.Result.Success) obj2;
                                copy$default = TribeeSearchState.Result.Success.copy$default(TribeeSearchState.Result.Success.this, null, null, null, null, null, null, true, 63, null);
                                return copy$default;
                            }
                        });
                        query = this.this$0.sanitizeQuery(snapshot.getSearchBarState().getTextFieldState().getText().toString());
                        Long longOrNull = StringsKt.toLongOrNull(snapshot.getTribeeId());
                        if (longOrNull != null) {
                            long tribeeIdLong = longOrNull.longValue();
                            try {
                                this.L$0 = state;
                                this.L$1 = snapshot;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(next);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(query);
                                this.J$0 = tribeeIdLong;
                                this.label = 1;
                                Object loadNextSearchData = new TribeeSearchService().loadNextSearchData(query, tribeeIdLong, next, (Continuation) this);
                                if (loadNextSearchData == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = loadNextSearchData;
                                try {
                                    final KTribeeSearchAllResp reply = (KTribeeSearchAllResp) obj;
                                    return state.mutate(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$5$1$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj2) {
                                            TribeeSearchState.Result.Success invokeSuspend$lambda$2;
                                            invokeSuspend$lambda$2 = TribeeSearchViewModel$machine$1$5$1.invokeSuspend$lambda$2(TribeeSearchState.Result.Success.this, reply, (TribeeSearchState.Result.Success) obj2);
                                            return invokeSuspend$lambda$2;
                                        }
                                    });
                                } catch (Exception e) {
                                    query2 = query;
                                    return state.mutate(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$5$1$$ExternalSyntheticLambda3
                                        public final Object invoke(Object obj2) {
                                            TribeeSearchState.Result.Success copy$default;
                                            TribeeSearchState.Result.Success success = (TribeeSearchState.Result.Success) obj2;
                                            copy$default = TribeeSearchState.Result.Success.copy$default(TribeeSearchState.Result.Success.this, null, null, null, null, null, null, false, 63, null);
                                            return copy$default;
                                        }
                                    });
                                }
                            } catch (Exception e2) {
                                query2 = query;
                                return state.mutate(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$5$1$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj2) {
                                        TribeeSearchState.Result.Success copy$default;
                                        TribeeSearchState.Result.Success success = (TribeeSearchState.Result.Success) obj2;
                                        copy$default = TribeeSearchState.Result.Success.copy$default(TribeeSearchState.Result.Success.this, null, null, null, null, null, null, false, 63, null);
                                        return copy$default;
                                    }
                                });
                            }
                        }
                        return state.mutate(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$5$1$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj2) {
                                TribeeSearchState.Result.Success copy$default;
                                TribeeSearchState.Result.Success success = (TribeeSearchState.Result.Success) obj2;
                                copy$default = TribeeSearchState.Result.Success.copy$default(TribeeSearchState.Result.Success.this, null, null, null, null, null, null, false, 63, null);
                                return copy$default;
                            }
                        });
                    }
                }
                return state.noChange();
            case 1:
                long j = this.J$0;
                query2 = (String) this.L$3;
                String str2 = (String) this.L$2;
                snapshot = (TribeeSearchState.Result.Success) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    query = query2;
                    obj = $result;
                    final KTribeeSearchAllResp reply2 = (KTribeeSearchAllResp) obj;
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$5$1$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj2) {
                            TribeeSearchState.Result.Success invokeSuspend$lambda$2;
                            invokeSuspend$lambda$2 = TribeeSearchViewModel$machine$1$5$1.invokeSuspend$lambda$2(TribeeSearchState.Result.Success.this, reply2, (TribeeSearchState.Result.Success) obj2);
                            return invokeSuspend$lambda$2;
                        }
                    });
                } catch (Exception e3) {
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$5$1$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj2) {
                            TribeeSearchState.Result.Success copy$default;
                            TribeeSearchState.Result.Success success = (TribeeSearchState.Result.Success) obj2;
                            copy$default = TribeeSearchState.Result.Success.copy$default(TribeeSearchState.Result.Success.this, null, null, null, null, null, null, false, 63, null);
                            return copy$default;
                        }
                    });
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSearchState.Result.Success invokeSuspend$lambda$2(TribeeSearchState.Result.Success $snapshot, KTribeeSearchAllResp $reply, TribeeSearchState.Result.Success $this$mutate) {
        return TribeeSearchState.Result.Success.copy$default($snapshot, null, null, null, null, CollectionsKt.plus($snapshot.getContents(), $reply.getContents()), $reply.getNextPage(), false, 15, null);
    }
}