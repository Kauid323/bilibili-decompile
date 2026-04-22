package kntr.app.tribee.search.viewModels;

import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchAllResp;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.search.service.TribeeSearchService;
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
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSearchViewModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/search/state/TribeeSearchState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/search/state/TribeeSearchState$Result$Loading;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$4$1", f = "TribeeSearchViewModel.kt", i = {0, 0, 0, 0}, l = {150}, m = "invokeSuspend", n = {"state", "query", "snapshot", "tribeeIdLong"}, s = {"L$0", "L$1", "L$2", "J$0"}, v = 1)
public final class TribeeSearchViewModel$machine$1$4$1 extends SuspendLambda implements Function2<State<TribeeSearchState.Result.Loading>, Continuation<? super ChangedState<? extends TribeeSearchState>>, Object> {
    long J$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TribeeSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSearchViewModel$machine$1$4$1(TribeeSearchViewModel tribeeSearchViewModel, Continuation<? super TribeeSearchViewModel$machine$1$4$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeeSearchViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeeSearchViewModel$machine$1$4$1 = new TribeeSearchViewModel$machine$1$4$1(this.this$0, continuation);
        tribeeSearchViewModel$machine$1$4$1.L$0 = obj;
        return tribeeSearchViewModel$machine$1$4$1;
    }

    public final Object invoke(State<TribeeSearchState.Result.Loading> state, Continuation<? super ChangedState<? extends TribeeSearchState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0086 A[Catch: Exception -> 0x0024, TryCatch #1 {Exception -> 0x0024, blocks: (B:7:0x001f, B:18:0x0077, B:20:0x0086, B:21:0x0090), top: B:31:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090 A[Catch: Exception -> 0x0024, TRY_LEAVE, TryCatch #1 {Exception -> 0x0024, blocks: (B:7:0x001f, B:18:0x0077, B:20:0x0086, B:21:0x0090), top: B:31:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        String sanitizeQuery;
        final String query;
        final TribeeSearchState.Result.Loading snapshot;
        Object loadSearchData;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                sanitizeQuery = this.this$0.sanitizeQuery(((TribeeSearchState.Result.Loading) state.getSnapshot()).getSearchBarState().getQuery());
                query = sanitizeQuery;
                Long longOrNull = StringsKt.toLongOrNull(((TribeeSearchState.Result.Loading) state.getSnapshot()).getTribeeId());
                if (longOrNull != null) {
                    long tribeeIdLong = longOrNull.longValue();
                    TribeeSearchState.Result.Loading snapshot2 = (TribeeSearchState.Result.Loading) state.getSnapshot();
                    try {
                        this.L$0 = state;
                        this.L$1 = query;
                        this.L$2 = snapshot2;
                        this.J$0 = tribeeIdLong;
                        this.label = 1;
                        loadSearchData = new TribeeSearchService().loadSearchData(query, tribeeIdLong, (Continuation) this);
                        if (loadSearchData == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        snapshot = snapshot2;
                        final KTribeeSearchAllResp reply = (KTribeeSearchAllResp) loadSearchData;
                        return reply.getContents().isEmpty() ? state.override(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$4$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                TribeeSearchState.Result.Success invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = TribeeSearchViewModel$machine$1$4$1.invokeSuspend$lambda$0(TribeeSearchState.Result.Loading.this, reply, (TribeeSearchState.Result.Loading) obj);
                                return invokeSuspend$lambda$0;
                            }
                        }) : state.override(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$4$1$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                TribeeSearchState.Result.Empty invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = TribeeSearchViewModel$machine$1$4$1.invokeSuspend$lambda$1(TribeeSearchState.Result.Loading.this, reply, query, (TribeeSearchState.Result.Loading) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    } catch (Exception e) {
                        snapshot = snapshot2;
                        return state.override(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$4$1$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                TribeeSearchState.Result.Empty invokeSuspend$lambda$2;
                                invokeSuspend$lambda$2 = TribeeSearchViewModel$machine$1$4$1.invokeSuspend$lambda$2(TribeeSearchState.Result.Loading.this, query, (TribeeSearchState.Result.Loading) obj);
                                return invokeSuspend$lambda$2;
                            }
                        });
                    }
                }
                return state.noChange();
            case 1:
                long j = this.J$0;
                snapshot = (TribeeSearchState.Result.Loading) this.L$2;
                query = (String) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    loadSearchData = $result;
                    final KTribeeSearchAllResp reply2 = (KTribeeSearchAllResp) loadSearchData;
                    if (reply2.getContents().isEmpty()) {
                    }
                } catch (Exception e2) {
                    return state.override(new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$machine$1$4$1$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            TribeeSearchState.Result.Empty invokeSuspend$lambda$2;
                            invokeSuspend$lambda$2 = TribeeSearchViewModel$machine$1$4$1.invokeSuspend$lambda$2(TribeeSearchState.Result.Loading.this, query, (TribeeSearchState.Result.Loading) obj);
                            return invokeSuspend$lambda$2;
                        }
                    });
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSearchState.Result.Success invokeSuspend$lambda$0(TribeeSearchState.Result.Loading $snapshot, KTribeeSearchAllResp $reply, TribeeSearchState.Result.Loading $this$override) {
        return new TribeeSearchState.Result.Success($snapshot.getSearchBarState(), $snapshot.getGlobalSearchUri(), $snapshot.getTribeeId(), $reply.getQvId(), $reply.getContents(), $reply.getNextPage(), false, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSearchState.Result.Empty invokeSuspend$lambda$1(TribeeSearchState.Result.Loading $snapshot, KTribeeSearchAllResp $reply, String $query, TribeeSearchState.Result.Loading $this$override) {
        return new TribeeSearchState.Result.Empty($snapshot.getSearchBarState(), $snapshot.getGlobalSearchUri(), $snapshot.getTribeeId(), $reply.getQvId(), $query);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSearchState.Result.Empty invokeSuspend$lambda$2(TribeeSearchState.Result.Loading $snapshot, String $query, TribeeSearchState.Result.Loading $this$override) {
        return new TribeeSearchState.Result.Empty($snapshot.getSearchBarState(), $snapshot.getGlobalSearchUri(), $snapshot.getTribeeId(), null, $query);
    }
}