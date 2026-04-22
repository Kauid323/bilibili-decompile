package live.room.recommend;

import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KGetViewHistoryReq;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KGetViewHistoryResp;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KMoreLiveMoss;
import com.bapis.bilibili.pagination.KPagination;
import com.bapis.bilibili.pagination.KPaginationReply;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import kntr.base.moss.api.KCallOptions;
import kntr.base.moss.api.KMossException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Llive/room/recommend/LiveRoomHistoryState;", "<unused var>", "Llive/room/recommend/LiveRoomHistoryEvent$RequestAll;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$1", f = "LiveRoomHistoryViewModel.kt", i = {0, 0}, l = {85}, m = "invokeSuspend", n = {"state", "req"}, s = {"L$0", "L$1"}, v = 1)
public final class LiveRoomHistoryViewModel$machine$1$1$1 extends SuspendLambda implements Function3<LiveRoomHistoryEvent.RequestAll, State<LiveRoomHistoryState>, Continuation<? super ChangedState<? extends LiveRoomHistoryState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LiveRoomHistoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRoomHistoryViewModel$machine$1$1$1(LiveRoomHistoryViewModel liveRoomHistoryViewModel, Continuation<? super LiveRoomHistoryViewModel$machine$1$1$1> continuation) {
        super(3, continuation);
        this.this$0 = liveRoomHistoryViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(LiveRoomHistoryEvent.RequestAll requestAll, State<LiveRoomHistoryState> state, Continuation<? super ChangedState<? extends LiveRoomHistoryState>> continuation) {
        LiveRoomHistoryViewModel$machine$1$1$1 liveRoomHistoryViewModel$machine$1$1$1 = new LiveRoomHistoryViewModel$machine$1$1$1(this.this$0, continuation);
        liveRoomHistoryViewModel$machine$1$1$1.L$0 = state;
        return liveRoomHistoryViewModel$machine$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object viewHistory;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    KGetViewHistoryReq req = new KGetViewHistoryReq(this.this$0.getUid(), new KPagination(20, ""), this.this$0.getFnval());
                    this.L$0 = state;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                    this.label = 1;
                    viewHistory = new KMoreLiveMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).getViewHistory(req, this);
                    if (viewHistory != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    KGetViewHistoryReq kGetViewHistoryReq = (KGetViewHistoryReq) this.L$1;
                    ResultKt.throwOnFailure($result);
                    viewHistory = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final LiveRoomHistoryViewModel liveRoomHistoryViewModel = this.this$0;
            final KGetViewHistoryResp it = (KGetViewHistoryResp) viewHistory;
            return state.override(new Function1() { // from class: live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    LiveRoomHistoryState.Content invokeSuspend$lambda$0$0;
                    invokeSuspend$lambda$0$0 = LiveRoomHistoryViewModel$machine$1$1$1.invokeSuspend$lambda$0$0(LiveRoomHistoryViewModel.this, it, (LiveRoomHistoryState) obj);
                    return invokeSuspend$lambda$0$0;
                }
            });
        } catch (KMossException e) {
            return state.override(new Function1() { // from class: live.room.recommend.LiveRoomHistoryViewModel$machine$1$1$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    LiveRoomHistoryState.Error invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = LiveRoomHistoryViewModel$machine$1$1$1.invokeSuspend$lambda$1(e, (LiveRoomHistoryState) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomHistoryState.Content invokeSuspend$lambda$0$0(LiveRoomHistoryViewModel this$0, KGetViewHistoryResp $it, LiveRoomHistoryState $this$override) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        KPaginationReply paginationReply = $it.getPaginationReply();
        this$0.nextCursor = (paginationReply == null || (r0 = paginationReply.getNext()) == null) ? "" : "";
        arrayList = this$0.mHistorys;
        arrayList.clear();
        arrayList2 = this$0.mHistorys;
        arrayList2.addAll($it.getHistory());
        boolean hasMore = true;
        KPaginationReply paginationReply2 = $it.getPaginationReply();
        String next = paginationReply2 != null ? paginationReply2.getNext() : null;
        if (next == null || StringsKt.isBlank(next)) {
            hasMore = false;
        }
        arrayList3 = this$0.mHistorys;
        return new LiveRoomHistoryState.Content(arrayList3, Boolean.valueOf(hasMore));
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