package live.room.recommend;

import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KViewHistory;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.ArrayList;
import java.util.List;
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
import live.room.recommend.LiveRoomHistoryEvent;
import live.room.recommend.LiveRoomHistoryState;

/* compiled from: LiveRoomHistoryViewModel.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0097@¢\u0006\u0002\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0017X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Llive/room/recommend/LiveRoomHistoryViewModel;", "Lkntr/base/udf/Store;", "Llive/room/recommend/LiveRoomHistoryState;", "Llive/room/recommend/LiveRoomHistoryEvent;", "uid", "", "fnval", "<init>", "(JJ)V", "getUid", "()J", "getFnval", "nextCursor", "", "mHistorys", "Ljava/util/ArrayList;", "Lcom/bapis/bilibili/live/app/interfaces/api/grpc/v1/KViewHistory;", "Lkotlin/collections/ArrayList;", "mDeletedKids", "", "isLoading", "", "machine", "Lkntr/base/udf/StoreMachine;", "getMachine$annotations", "()V", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", "", "action", "(Llive/room/recommend/LiveRoomHistoryEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LiveRoomHistoryViewModel implements Store<LiveRoomHistoryState, LiveRoomHistoryEvent> {
    public static final Companion Companion = new Companion(null);
    private static final int RECOMMEND_PAGE_SIZE = 20;
    private static final String REQUEST_FIRST_CURSOR = "";
    public static final String TAG = "RoomRecommendViewModel";
    private final long fnval;
    private boolean isLoading;
    private final StoreMachine<LiveRoomHistoryState, LiveRoomHistoryEvent> machine;
    private final Flow<LiveRoomHistoryState> state;
    private final long uid;
    private String nextCursor = "";
    private ArrayList<KViewHistory> mHistorys = new ArrayList<>();
    private List<Long> mDeletedKids = new ArrayList();

    private static /* synthetic */ void getMachine$annotations() {
    }

    public static /* synthetic */ void getState$annotations() {
    }

    public LiveRoomHistoryViewModel(long uid, long fnval) {
        this.uid = uid;
        this.fnval = fnval;
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = LiveRoomHistoryState.Idle.INSTANCE;
        Function1 specBlock$iv = new Function1() { // from class: live.room.recommend.LiveRoomHistoryViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit machine$lambda$0;
                machine$lambda$0 = LiveRoomHistoryViewModel.machine$lambda$0(LiveRoomHistoryViewModel.this, (FlowReduxStoreBuilder) obj);
                return machine$lambda$0;
            }
        };
        this.machine = new StoreMachine<>(initialState$iv, specBlock$iv);
        this.state = this.machine.getState();
    }

    public /* bridge */ /* synthetic */ Object dispatch(Object action, Continuation $completion) {
        return dispatch((LiveRoomHistoryEvent) action, (Continuation<? super Unit>) $completion);
    }

    public final long getUid() {
        return this.uid;
    }

    public final long getFnval() {
        return this.fnval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0(final LiveRoomHistoryViewModel this$0, FlowReduxStoreBuilder StoreMachine) {
        Intrinsics.checkNotNullParameter(StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: live.room.recommend.LiveRoomHistoryViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$0;
                machine$lambda$0$0 = LiveRoomHistoryViewModel.machine$lambda$0$0(LiveRoomHistoryViewModel.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$0;
            }
        };
        StoreMachine.inState(Reflection.getOrCreateKotlinClass(LiveRoomHistoryState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$0(LiveRoomHistoryViewModel this$0, InStateBuilderBlock inState) {
        Intrinsics.checkNotNullParameter(inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inState;
        Function3 handler$iv = new LiveRoomHistoryViewModel$machine$1$1$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(LiveRoomHistoryEvent.RequestAll.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inState;
        Function3 handler$iv2 = new LiveRoomHistoryViewModel$machine$1$1$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(LiveRoomHistoryEvent.RequestLoadMore.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inState;
        Function3 handler$iv3 = new LiveRoomHistoryViewModel$machine$1$1$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(LiveRoomHistoryEvent.deleteHistory.class), executionPolicy$iv3, handler$iv3);
        return Unit.INSTANCE;
    }

    public Flow<LiveRoomHistoryState> getState() {
        return this.state;
    }

    public Object dispatch(LiveRoomHistoryEvent action, Continuation<? super Unit> continuation) {
        Object dispatch = this.machine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    /* compiled from: LiveRoomHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Llive/room/recommend/LiveRoomHistoryViewModel$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_FIRST_CURSOR", "RECOMMEND_PAGE_SIZE", "", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}