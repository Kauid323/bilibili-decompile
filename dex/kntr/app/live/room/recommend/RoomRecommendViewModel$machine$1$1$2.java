package kntr.app.live.room.recommend;

import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KGetMoreLiveRoomsReq;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KGetMoreLiveRoomsResp;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KMoreLiveMoss;
import com.bapis.bilibili.pagination.KPagination;
import com.bapis.bilibili.pagination.KPaginationReply;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/recommend/LiveRoomRecommendState;", "event", "Lkntr/app/live/room/recommend/LiveRoomRecommendEvent$RequestLoadMore;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.recommend.RoomRecommendViewModel$machine$1$1$2", f = "RoomRecommendViewModel.kt", i = {0, 0, 0, 0, 0}, l = {131}, m = "invokeSuspend", n = {"event", "state", "idolsNext", "roomNext", "req"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
public final class RoomRecommendViewModel$machine$1$1$2 extends SuspendLambda implements Function3<LiveRoomRecommendEvent.RequestLoadMore, State<LiveRoomRecommendState>, Continuation<? super ChangedState<? extends LiveRoomRecommendState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ RoomRecommendViewModel this$0;

    /* compiled from: RoomRecommendViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LiveRoomRecommendEvent.LoadType.values().length];
            try {
                iArr[LiveRoomRecommendEvent.LoadType.ROOM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LiveRoomRecommendEvent.LoadType.IDOL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomRecommendViewModel$machine$1$1$2(RoomRecommendViewModel roomRecommendViewModel, Continuation<? super RoomRecommendViewModel$machine$1$1$2> continuation) {
        super(3, continuation);
        this.this$0 = roomRecommendViewModel;
    }

    public final Object invoke(LiveRoomRecommendEvent.RequestLoadMore requestLoadMore, State<LiveRoomRecommendState> state, Continuation<? super ChangedState<? extends LiveRoomRecommendState>> continuation) {
        RoomRecommendViewModel$machine$1$1$2 roomRecommendViewModel$machine$1$1$2 = new RoomRecommendViewModel$machine$1$1$2(this.this$0, continuation);
        roomRecommendViewModel$machine$1$1$2.L$0 = requestLoadMore;
        roomRecommendViewModel$machine$1$1$2.L$1 = state;
        return roomRecommendViewModel$machine$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0100, code lost:
        r6 = r8.mRooms;
        r6.addAll(r9.getMoreLiveInfo());
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e1 A[Catch: all -> 0x0032, KMossException -> 0x0035, Merged into TryCatch #0 {all -> 0x0032, KMossException -> 0x0035, blocks: (B:7:0x002b, B:26:0x00c8, B:28:0x00d5, B:34:0x00e1, B:35:0x00ee, B:37:0x00f6, B:42:0x0100, B:43:0x010d, B:46:0x011e, B:14:0x003e, B:16:0x0046, B:17:0x004c, B:18:0x0058, B:22:0x0072, B:20:0x005d, B:21:0x0066), top: B:51:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f6 A[Catch: all -> 0x0032, KMossException -> 0x0035, Merged into TryCatch #0 {all -> 0x0032, KMossException -> 0x0035, blocks: (B:7:0x002b, B:26:0x00c8, B:28:0x00d5, B:34:0x00e1, B:35:0x00ee, B:37:0x00f6, B:42:0x0100, B:43:0x010d, B:46:0x011e, B:14:0x003e, B:16:0x0046, B:17:0x004c, B:18:0x0058, B:22:0x0072, B:20:0x005d, B:21:0x0066), top: B:51:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean z;
        String str;
        String str2;
        Object moreLiveRooms;
        ChangedState noChange;
        List myIdolInfo;
        boolean z2;
        List moreLiveInfo;
        ArrayList arrayList;
        String idolsNext = RoomRecommendViewModel.EMPTY_CURSOR;
        final LiveRoomRecommendEvent.RequestLoadMore event = (LiveRoomRecommendEvent.RequestLoadMore) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z3 = true;
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String idolsNext2 = RoomRecommendViewModel.EMPTY_CURSOR;
                    z = this.this$0.isLoading;
                    if (z) {
                        noChange = state.noChange();
                        break;
                    } else {
                        switch (WhenMappings.$EnumSwitchMapping$0[event.getType().ordinal()]) {
                            case 1:
                                str = this.this$0.nextRoomCursor;
                                idolsNext2 = RoomRecommendViewModel.EMPTY_CURSOR;
                                idolsNext = str;
                                break;
                            case 2:
                                str2 = this.this$0.nextIdolCursor;
                                idolsNext2 = str2;
                                break;
                            default:
                                idolsNext = RoomRecommendViewModel.EMPTY_CURSOR;
                                break;
                        }
                        KGetMoreLiveRoomsReq req = new KGetMoreLiveRoomsReq(this.this$0.getRoomId(), new KPagination(30, idolsNext2), new KPagination(30, idolsNext), this.this$0.getUid(), this.this$0.getFnval());
                        this.this$0.isLoading = true;
                        this.L$0 = event;
                        this.L$1 = state;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(idolsNext2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(idolsNext);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(req);
                        this.label = 1;
                        moreLiveRooms = new KMoreLiveMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).getMoreLiveRooms(req, (Continuation) this);
                        if (moreLiveRooms == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        final RoomRecommendViewModel roomRecommendViewModel = this.this$0;
                        final KGetMoreLiveRoomsResp it = (KGetMoreLiveRoomsResp) moreLiveRooms;
                        myIdolInfo = it.getMyIdolInfo();
                        if (myIdolInfo != null && !myIdolInfo.isEmpty()) {
                            z2 = false;
                            if (!z2) {
                                arrayList = roomRecommendViewModel.mIdols;
                                arrayList.addAll(it.getMyIdolInfo());
                            }
                            moreLiveInfo = it.getMoreLiveInfo();
                            if (moreLiveInfo != null && !moreLiveInfo.isEmpty()) {
                                z3 = false;
                                break;
                            }
                            noChange = state.override(new Function1() { // from class: kntr.app.live.room.recommend.RoomRecommendViewModel$machine$1$1$2$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    LiveRoomRecommendState.Content invokeSuspend$lambda$0$0;
                                    invokeSuspend$lambda$0$0 = RoomRecommendViewModel$machine$1$1$2.invokeSuspend$lambda$0$0(LiveRoomRecommendEvent.RequestLoadMore.this, roomRecommendViewModel, it, (LiveRoomRecommendState) obj);
                                    return invokeSuspend$lambda$0$0;
                                }
                            });
                            break;
                        }
                        z2 = true;
                        if (!z2) {
                        }
                        moreLiveInfo = it.getMoreLiveInfo();
                        if (moreLiveInfo != null) {
                            z3 = false;
                        }
                        noChange = state.override(new Function1() { // from class: kntr.app.live.room.recommend.RoomRecommendViewModel$machine$1$1$2$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                LiveRoomRecommendState.Content invokeSuspend$lambda$0$0;
                                invokeSuspend$lambda$0$0 = RoomRecommendViewModel$machine$1$1$2.invokeSuspend$lambda$0$0(LiveRoomRecommendEvent.RequestLoadMore.this, roomRecommendViewModel, it, (LiveRoomRecommendState) obj);
                                return invokeSuspend$lambda$0$0;
                            }
                        });
                    }
                    break;
                case 1:
                    KGetMoreLiveRoomsReq kGetMoreLiveRoomsReq = (KGetMoreLiveRoomsReq) this.L$4;
                    String str3 = (String) this.L$3;
                    String str4 = (String) this.L$2;
                    ResultKt.throwOnFailure($result);
                    moreLiveRooms = $result;
                    final RoomRecommendViewModel roomRecommendViewModel2 = this.this$0;
                    final KGetMoreLiveRoomsResp it2 = (KGetMoreLiveRoomsResp) moreLiveRooms;
                    myIdolInfo = it2.getMyIdolInfo();
                    if (myIdolInfo != null) {
                        z2 = false;
                        if (!z2) {
                        }
                        moreLiveInfo = it2.getMoreLiveInfo();
                        if (moreLiveInfo != null) {
                        }
                        noChange = state.override(new Function1() { // from class: kntr.app.live.room.recommend.RoomRecommendViewModel$machine$1$1$2$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                LiveRoomRecommendState.Content invokeSuspend$lambda$0$0;
                                invokeSuspend$lambda$0$0 = RoomRecommendViewModel$machine$1$1$2.invokeSuspend$lambda$0$0(LiveRoomRecommendEvent.RequestLoadMore.this, roomRecommendViewModel2, it2, (LiveRoomRecommendState) obj);
                                return invokeSuspend$lambda$0$0;
                            }
                        });
                        break;
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    moreLiveInfo = it2.getMoreLiveInfo();
                    if (moreLiveInfo != null) {
                    }
                    noChange = state.override(new Function1() { // from class: kntr.app.live.room.recommend.RoomRecommendViewModel$machine$1$1$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            LiveRoomRecommendState.Content invokeSuspend$lambda$0$0;
                            invokeSuspend$lambda$0$0 = RoomRecommendViewModel$machine$1$1$2.invokeSuspend$lambda$0$0(LiveRoomRecommendEvent.RequestLoadMore.this, roomRecommendViewModel2, it2, (LiveRoomRecommendState) obj);
                            return invokeSuspend$lambda$0$0;
                        }
                    });
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return noChange;
        } catch (KMossException e) {
            return state.override(new Function1() { // from class: kntr.app.live.room.recommend.RoomRecommendViewModel$machine$1$1$2$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    LiveRoomRecommendState.Error invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = RoomRecommendViewModel$machine$1$1$2.invokeSuspend$lambda$1(e, (LiveRoomRecommendState) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        } finally {
            this.this$0.isLoading = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomRecommendState.Content invokeSuspend$lambda$0$0(LiveRoomRecommendEvent.RequestLoadMore $event, RoomRecommendViewModel this$0, KGetMoreLiveRoomsResp $it, LiveRoomRecommendState $this$override) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String str;
        String str2;
        switch (WhenMappings.$EnumSwitchMapping$0[$event.getType().ordinal()]) {
            case 1:
                KPaginationReply roomsPaginationReply = $it.getRoomsPaginationReply();
                if (roomsPaginationReply == null || (str = roomsPaginationReply.getNext()) == null) {
                    str = this$0.nextRoomCursor;
                }
                this$0.nextRoomCursor = str;
                break;
            case 2:
                KPaginationReply idolPaginationReply = $it.getIdolPaginationReply();
                if (idolPaginationReply == null || (str2 = idolPaginationReply.getNext()) == null) {
                    str2 = this$0.nextIdolCursor;
                }
                this$0.nextIdolCursor = str2;
                break;
        }
        arrayList = this$0.mIdols;
        arrayList2 = this$0.mRooms;
        arrayList3 = this$0.mHistorys;
        return new LiveRoomRecommendState.Content(arrayList, arrayList2, arrayList3);
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