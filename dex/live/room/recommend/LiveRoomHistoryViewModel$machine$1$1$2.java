package live.room.recommend;

import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KGetViewHistoryReq;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KGetViewHistoryResp;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KMoreLiveMoss;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KViewHistory;
import com.bapis.bilibili.pagination.KPagination;
import com.bapis.bilibili.pagination.KPaginationReply;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.List;
import kntr.base.moss.api.KCallOptions;
import kntr.base.moss.api.KMossException;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import live.room.recommend.LiveRoomHistoryEvent;
import live.room.recommend.LiveRoomHistoryState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LiveRoomHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Llive/room/recommend/LiveRoomHistoryState;", "<unused var>", "Llive/room/recommend/LiveRoomHistoryEvent$RequestLoadMore;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$2", f = "LiveRoomHistoryViewModel.kt", i = {0, 0, 0}, l = {122}, m = "invokeSuspend", n = {"state", "next", "req"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class LiveRoomHistoryViewModel$machine$1$1$2 extends SuspendLambda implements Function3<LiveRoomHistoryEvent.RequestLoadMore, State<LiveRoomHistoryState>, Continuation<? super ChangedState<? extends LiveRoomHistoryState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ LiveRoomHistoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRoomHistoryViewModel$machine$1$1$2(LiveRoomHistoryViewModel liveRoomHistoryViewModel, Continuation<? super LiveRoomHistoryViewModel$machine$1$1$2> continuation) {
        super(3, continuation);
        this.this$0 = liveRoomHistoryViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(LiveRoomHistoryEvent.RequestLoadMore requestLoadMore, State<LiveRoomHistoryState> state, Continuation<? super ChangedState<? extends LiveRoomHistoryState>> continuation) {
        LiveRoomHistoryViewModel$machine$1$1$2 liveRoomHistoryViewModel$machine$1$1$2 = new LiveRoomHistoryViewModel$machine$1$1$2(this.this$0, continuation);
        liveRoomHistoryViewModel$machine$1$1$2.L$0 = state;
        return liveRoomHistoryViewModel$machine$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0091 A[Catch: all -> 0x00bd, KMossException -> 0x00bf, Merged into TryCatch #1 {all -> 0x00bd, KMossException -> 0x00bf, blocks: (B:7:0x001e, B:17:0x0080, B:19:0x0091, B:20:0x009e, B:26:0x00c0, B:10:0x0028, B:12:0x0030, B:13:0x0036), top: B:31:0x000b }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean z;
        String next;
        Object viewHistory;
        ChangedState noChange;
        final KGetViewHistoryResp it;
        ArrayList arrayList;
        ArrayList arrayList2;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    z = this.this$0.isLoading;
                    if (!z) {
                        next = this.this$0.nextCursor;
                        KGetViewHistoryReq req = new KGetViewHistoryReq(this.this$0.getUid(), new KPagination(20, next), this.this$0.getFnval());
                        this.this$0.isLoading = true;
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(next);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(req);
                        this.label = 1;
                        viewHistory = new KMoreLiveMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).getViewHistory(req, this);
                        if (viewHistory != coroutine_suspended) {
                            final LiveRoomHistoryViewModel liveRoomHistoryViewModel = this.this$0;
                            it = (KGetViewHistoryResp) viewHistory;
                            if (!it.getHistory().isEmpty()) {
                                arrayList2 = liveRoomHistoryViewModel.mHistorys;
                                arrayList2.addAll(it.getHistory());
                            }
                            arrayList = liveRoomHistoryViewModel.mHistorys;
                            CollectionsKt.removeAll((List) arrayList, new Function1() { // from class: live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$2$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    boolean invokeSuspend$lambda$0$0;
                                    invokeSuspend$lambda$0$0 = LiveRoomHistoryViewModel$machine$1$1$2.invokeSuspend$lambda$0$0(LiveRoomHistoryViewModel.this, (KViewHistory) obj);
                                    return Boolean.valueOf(invokeSuspend$lambda$0$0);
                                }
                            });
                            noChange = state.override(new Function1() { // from class: live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$2$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    LiveRoomHistoryState.Content invokeSuspend$lambda$0$1;
                                    invokeSuspend$lambda$0$1 = LiveRoomHistoryViewModel$machine$1$1$2.invokeSuspend$lambda$0$1(it, liveRoomHistoryViewModel, (LiveRoomHistoryState) obj);
                                    return invokeSuspend$lambda$0$1;
                                }
                            });
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    } else {
                        noChange = state.noChange();
                        break;
                    }
                case 1:
                    KGetViewHistoryReq kGetViewHistoryReq = (KGetViewHistoryReq) this.L$2;
                    String str = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    viewHistory = $result;
                    final LiveRoomHistoryViewModel liveRoomHistoryViewModel2 = this.this$0;
                    it = (KGetViewHistoryResp) viewHistory;
                    if (!it.getHistory().isEmpty()) {
                    }
                    arrayList = liveRoomHistoryViewModel2.mHistorys;
                    CollectionsKt.removeAll((List) arrayList, new Function1() { // from class: live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            boolean invokeSuspend$lambda$0$0;
                            invokeSuspend$lambda$0$0 = LiveRoomHistoryViewModel$machine$1$1$2.invokeSuspend$lambda$0$0(LiveRoomHistoryViewModel.this, (KViewHistory) obj);
                            return Boolean.valueOf(invokeSuspend$lambda$0$0);
                        }
                    });
                    noChange = state.override(new Function1() { // from class: live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$2$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            LiveRoomHistoryState.Content invokeSuspend$lambda$0$1;
                            invokeSuspend$lambda$0$1 = LiveRoomHistoryViewModel$machine$1$1$2.invokeSuspend$lambda$0$1(it, liveRoomHistoryViewModel2, (LiveRoomHistoryState) obj);
                            return invokeSuspend$lambda$0$1;
                        }
                    });
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return noChange;
        } catch (KMossException e) {
            return state.override(new Function1() { // from class: live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$2$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    LiveRoomHistoryState.Error invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = LiveRoomHistoryViewModel$machine$1$1$2.invokeSuspend$lambda$1(e, (LiveRoomHistoryState) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        } finally {
            this.this$0.isLoading = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0$0(LiveRoomHistoryViewModel this$0, KViewHistory history) {
        List list;
        list = this$0.mDeletedKids;
        return list.contains(Long.valueOf(history.getKid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomHistoryState.Content invokeSuspend$lambda$0$1(KGetViewHistoryResp $it, LiveRoomHistoryViewModel this$0, LiveRoomHistoryState $this$override) {
        String str;
        ArrayList arrayList;
        boolean hasMore = true;
        KPaginationReply paginationReply = $it.getPaginationReply();
        String next = paginationReply != null ? paginationReply.getNext() : null;
        if (next == null || StringsKt.isBlank(next)) {
            hasMore = false;
        }
        KPaginationReply paginationReply2 = $it.getPaginationReply();
        if (paginationReply2 == null || (str = paginationReply2.getNext()) == null) {
            str = this$0.nextCursor;
        }
        this$0.nextCursor = str;
        arrayList = this$0.mHistorys;
        return new LiveRoomHistoryState.Content(arrayList, Boolean.valueOf(hasMore));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomHistoryState.Error invokeSuspend$lambda$1(KMossException $e, LiveRoomHistoryState $this$override) {
        String message = $e.getMessage();
        if (message == null) {
            message = "unknown";
        }
        return new LiveRoomHistoryState.Error(message);
    }
}