package kntr.app.live.room.recommend;

import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KMoreLiveRoomInfo;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KMyIdolInfo;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KViewHistory;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.ArrayList;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.LiveRoomRecommendEvent;
import kntr.app.live.room.recommend.LiveRoomRecommendState;
import kntr.base.udf.Store;
import kntr.base.udf.StoreMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: RoomRecommendViewModel.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0097@¢\u0006\u0002\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0012j\b\u0012\u0004\u0012\u00020\u0016`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0012j\b\u0012\u0004\u0012\u00020\u0018`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001cX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lkntr/app/live/room/recommend/RoomRecommendViewModel;", "Lkntr/base/udf/Store;", "Lkntr/app/live/room/recommend/LiveRoomRecommendState;", "Lkntr/app/live/room/recommend/LiveRoomRecommendEvent;", "roomId", RoomRecommendViewModel.EMPTY_CURSOR, "uid", "fnval", "<init>", "(JJJ)V", "getRoomId", "()J", "getUid", "getFnval", "nextRoomCursor", RoomRecommendViewModel.EMPTY_CURSOR, "nextIdolCursor", "mIdols", "Ljava/util/ArrayList;", "Lcom/bapis/bilibili/live/app/interfaces/api/grpc/v1/KMyIdolInfo;", "Lkotlin/collections/ArrayList;", "mRooms", "Lcom/bapis/bilibili/live/app/interfaces/api/grpc/v1/KMoreLiveRoomInfo;", "mHistorys", "Lcom/bapis/bilibili/live/app/interfaces/api/grpc/v1/KViewHistory;", "isLoading", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.MACHINE, "Lkntr/base/udf/StoreMachine;", "getMachine$annotations", "()V", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "action", "(Lkntr/app/live/room/recommend/LiveRoomRecommendEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RoomRecommendViewModel implements Store<LiveRoomRecommendState, LiveRoomRecommendEvent> {
    public static final Companion Companion = new Companion(null);
    public static final String EMPTY_CURSOR = "";
    public static final int RECOMMEND_PAGE_SIZE = 30;
    public static final String REQUEST_FIRST_CURSOR = "1";
    public static final String TAG = "RoomRecommendViewModel";
    private final long fnval;
    private boolean isLoading;
    private final StoreMachine<LiveRoomRecommendState, LiveRoomRecommendEvent> machine;
    private final long roomId;
    private final Flow<LiveRoomRecommendState> state;
    private final long uid;
    private String nextRoomCursor = "1";
    private String nextIdolCursor = "1";
    private ArrayList<KMyIdolInfo> mIdols = new ArrayList<>();
    private ArrayList<KMoreLiveRoomInfo> mRooms = new ArrayList<>();
    private ArrayList<KViewHistory> mHistorys = new ArrayList<>();

    private static /* synthetic */ void getMachine$annotations() {
    }

    public static /* synthetic */ void getState$annotations() {
    }

    public RoomRecommendViewModel(long roomId, long uid, long fnval) {
        this.roomId = roomId;
        this.uid = uid;
        this.fnval = fnval;
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = LiveRoomRecommendState.Idle.INSTANCE;
        Function1 specBlock$iv = new Function1() { // from class: kntr.app.live.room.recommend.RoomRecommendViewModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit machine$lambda$0;
                machine$lambda$0 = RoomRecommendViewModel.machine$lambda$0(RoomRecommendViewModel.this, (FlowReduxStoreBuilder) obj);
                return machine$lambda$0;
            }
        };
        this.machine = new StoreMachine<>(initialState$iv, specBlock$iv);
        this.state = this.machine.getState();
    }

    public /* bridge */ /* synthetic */ Object dispatch(Object action, Continuation $completion) {
        return dispatch((LiveRoomRecommendEvent) action, (Continuation<? super Unit>) $completion);
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getUid() {
        return this.uid;
    }

    public final long getFnval() {
        return this.fnval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0(final RoomRecommendViewModel this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: kntr.app.live.room.recommend.RoomRecommendViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$0;
                machine$lambda$0$0 = RoomRecommendViewModel.machine$lambda$0$0(RoomRecommendViewModel.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(LiveRoomRecommendState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$0(RoomRecommendViewModel this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new RoomRecommendViewModel$machine$1$1$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(LiveRoomRecommendEvent.RequestAll.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new RoomRecommendViewModel$machine$1$1$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(LiveRoomRecommendEvent.RequestLoadMore.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    /* compiled from: RoomRecommendViewModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/live/room/recommend/RoomRecommendViewModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "EMPTY_CURSOR", "REQUEST_FIRST_CURSOR", "RECOMMEND_PAGE_SIZE", RoomRecommendViewModel.EMPTY_CURSOR, "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Flow<LiveRoomRecommendState> getState() {
        return this.state;
    }

    public Object dispatch(LiveRoomRecommendEvent action, Continuation<? super Unit> continuation) {
        Object dispatch = this.machine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }
}