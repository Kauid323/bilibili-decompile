package kntr.app.live.room.recommend;

import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KGetMoreLiveRoomsReq;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KGetMoreLiveRoomsResp;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KMoreLiveMoss;
import com.bapis.bilibili.pagination.KPagination;
import com.bapis.bilibili.pagination.KPaginationReply;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import kntr.app.ad.protocol.report.SubmitActionFrom;
import kntr.app.live.room.recommend.LiveRoomRecommendEvent;
import kntr.app.live.room.recommend.LiveRoomRecommendState;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoomRecommendViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/recommend/LiveRoomRecommendState;", "<unused var>", "Lkntr/app/live/room/recommend/LiveRoomRecommendEvent$RequestAll;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.recommend.RoomRecommendViewModel$machine$1$1$1", f = "RoomRecommendViewModel.kt", i = {0, 0}, l = {84}, m = "invokeSuspend", n = {"state", "req"}, s = {"L$0", "L$1"}, v = 1)
public final class RoomRecommendViewModel$machine$1$1$1 extends SuspendLambda implements Function3<LiveRoomRecommendEvent.RequestAll, State<LiveRoomRecommendState>, Continuation<? super ChangedState<? extends LiveRoomRecommendState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RoomRecommendViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomRecommendViewModel$machine$1$1$1(RoomRecommendViewModel roomRecommendViewModel, Continuation<? super RoomRecommendViewModel$machine$1$1$1> continuation) {
        super(3, continuation);
        this.this$0 = roomRecommendViewModel;
    }

    public final Object invoke(LiveRoomRecommendEvent.RequestAll requestAll, State<LiveRoomRecommendState> state, Continuation<? super ChangedState<? extends LiveRoomRecommendState>> continuation) {
        RoomRecommendViewModel$machine$1$1$1 roomRecommendViewModel$machine$1$1$1 = new RoomRecommendViewModel$machine$1$1$1(this.this$0, continuation);
        roomRecommendViewModel$machine$1$1$1.L$0 = state;
        return roomRecommendViewModel$machine$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object moreLiveRooms;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    KGetMoreLiveRoomsReq req = new KGetMoreLiveRoomsReq(this.this$0.getRoomId(), new KPagination(30, "1"), new KPagination(30, "1"), this.this$0.getUid(), this.this$0.getFnval());
                    this.L$0 = state;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                    this.label = 1;
                    moreLiveRooms = new KMoreLiveMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).getMoreLiveRooms(req, (Continuation) this);
                    if (moreLiveRooms == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    KGetMoreLiveRoomsReq kGetMoreLiveRoomsReq = (KGetMoreLiveRoomsReq) this.L$1;
                    ResultKt.throwOnFailure($result);
                    moreLiveRooms = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final RoomRecommendViewModel roomRecommendViewModel = this.this$0;
            final KGetMoreLiveRoomsResp it = (KGetMoreLiveRoomsResp) moreLiveRooms;
            return state.override(new Function1() { // from class: kntr.app.live.room.recommend.RoomRecommendViewModel$machine$1$1$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    LiveRoomRecommendState.Content invokeSuspend$lambda$0$0;
                    invokeSuspend$lambda$0$0 = RoomRecommendViewModel$machine$1$1$1.invokeSuspend$lambda$0$0(RoomRecommendViewModel.this, it, (LiveRoomRecommendState) obj);
                    return invokeSuspend$lambda$0$0;
                }
            });
        } catch (KMossException e) {
            return state.override(new Function1() { // from class: kntr.app.live.room.recommend.RoomRecommendViewModel$machine$1$1$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    LiveRoomRecommendState.Error invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = RoomRecommendViewModel$machine$1$1$1.invokeSuspend$lambda$1(e, (LiveRoomRecommendState) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomRecommendState.Content invokeSuspend$lambda$0$0(RoomRecommendViewModel this$0, KGetMoreLiveRoomsResp $it, LiveRoomRecommendState $this$override) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        String next;
        KPaginationReply roomsPaginationReply = $it.getRoomsPaginationReply();
        String str = "1";
        this$0.nextRoomCursor = (roomsPaginationReply == null || (r0 = roomsPaginationReply.getNext()) == null) ? "1" : "1";
        KPaginationReply idolPaginationReply = $it.getIdolPaginationReply();
        if (idolPaginationReply != null && (next = idolPaginationReply.getNext()) != null) {
            str = next;
        }
        this$0.nextIdolCursor = str;
        arrayList = this$0.mIdols;
        arrayList.clear();
        arrayList2 = this$0.mIdols;
        arrayList2.addAll($it.getMyIdolInfo());
        arrayList3 = this$0.mRooms;
        arrayList3.clear();
        arrayList4 = this$0.mRooms;
        arrayList4.addAll($it.getMoreLiveInfo());
        arrayList5 = this$0.mHistorys;
        arrayList5.clear();
        arrayList6 = this$0.mHistorys;
        arrayList6.addAll($it.getViewHistory());
        arrayList7 = this$0.mIdols;
        arrayList8 = this$0.mRooms;
        arrayList9 = this$0.mHistorys;
        return new LiveRoomRecommendState.Content(arrayList7, arrayList8, arrayList9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomRecommendState.Error invokeSuspend$lambda$1(KMossException $e, LiveRoomRecommendState $this$override) {
        String message = $e.getMessage();
        if (message == null) {
            message = SubmitActionFrom.MMA_KEY_UNKNOWN;
        }
        return new LiveRoomRecommendState.Error(message);
    }
}