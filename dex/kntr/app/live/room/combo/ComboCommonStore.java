package kntr.app.live.room.combo;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.live.room.combo.LiveRoomComboBaseState;
import kntr.app.live.room.combo.LiveRoomComboCommonEvent;
import kntr.app.live.room.combo.utils.IntervalCountDownTimer;
import kntr.app.live.room.combo.utils.TotalCountDownTimer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
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

/* compiled from: ComboCommonStore.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0097@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lkntr/app/live/room/combo/ComboCommonStore;", "Lkntr/base/udf/Store;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState;", "Lkntr/app/live/room/combo/LiveRoomComboCommonEvent;", "resetCnt", RoomRecommendViewModel.EMPTY_CURSOR, "leftDuration", RoomRecommendViewModel.EMPTY_CURSOR, "fadeDuration", "<init>", "(IJJ)V", "cardFadeFlow", "Lkntr/app/live/room/combo/utils/IntervalCountDownTimer;", "totalDownTimer", "Lkntr/app/live/room/combo/utils/TotalCountDownTimer;", "tempCount", "comboMachine", "Lkntr/base/udf/StoreMachine;", "getComboMachine$annotations", "()V", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "action", "(Lkntr/app/live/room/combo/LiveRoomComboCommonEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ComboCommonStore implements Store<LiveRoomComboBaseState, LiveRoomComboCommonEvent> {
    public static final Companion Companion = new Companion(null);
    public static final int FROM_CARD_CLICK = 3;
    public static final int FROM_CARD_COUNT_DOWN = 2;
    public static final int FROM_DO_COMBO = 4;
    public static final int FROM_IDLE = 1;
    public static final long INTERVAL_MILLISECOND = 17;
    public static final String TAG = "LIVE_ROOM_COMBO_STORE_BASE";
    private IntervalCountDownTimer cardFadeFlow;
    private final StoreMachine<LiveRoomComboBaseState, LiveRoomComboCommonEvent> comboMachine;
    private final long fadeDuration;
    private final long leftDuration;
    private int resetCnt;
    private final Flow<LiveRoomComboBaseState> state;
    private int tempCount;
    private final TotalCountDownTimer totalDownTimer = new TotalCountDownTimer();

    private static /* synthetic */ void getComboMachine$annotations() {
    }

    public static /* synthetic */ void getState$annotations() {
    }

    public ComboCommonStore(int resetCnt, long leftDuration, long fadeDuration) {
        this.resetCnt = resetCnt;
        this.leftDuration = leftDuration;
        this.fadeDuration = fadeDuration;
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = LiveRoomComboBaseState.Idle.INSTANCE;
        Function1 specBlock$iv = new Function1() { // from class: kntr.app.live.room.combo.ComboCommonStore$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit comboMachine$lambda$0;
                comboMachine$lambda$0 = ComboCommonStore.comboMachine$lambda$0(ComboCommonStore.this, (FlowReduxStoreBuilder) obj);
                return comboMachine$lambda$0;
            }
        };
        this.comboMachine = new StoreMachine<>(initialState$iv, specBlock$iv);
        this.state = this.comboMachine.getState();
    }

    public /* bridge */ /* synthetic */ Object dispatch(Object action, Continuation $completion) {
        return dispatch((LiveRoomComboCommonEvent) action, (Continuation<? super Unit>) $completion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit comboMachine$lambda$0(final ComboCommonStore this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: kntr.app.live.room.combo.ComboCommonStore$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit comboMachine$lambda$0$0;
                comboMachine$lambda$0$0 = ComboCommonStore.comboMachine$lambda$0$0((InStateBuilderBlock) obj);
                return comboMachine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(LiveRoomComboBaseState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.live.room.combo.ComboCommonStore$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit comboMachine$lambda$0$1;
                comboMachine$lambda$0$1 = ComboCommonStore.comboMachine$lambda$0$1((InStateBuilderBlock) obj);
                return comboMachine$lambda$0$1;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(LiveRoomComboBaseState.Idle.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: kntr.app.live.room.combo.ComboCommonStore$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit comboMachine$lambda$0$2;
                comboMachine$lambda$0$2 = ComboCommonStore.comboMachine$lambda$0$2(ComboCommonStore.this, (InStateBuilderBlock) obj);
                return comboMachine$lambda$0$2;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(LiveRoomComboBaseState.CardShowing.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: kntr.app.live.room.combo.ComboCommonStore$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit comboMachine$lambda$0$3;
                comboMachine$lambda$0$3 = ComboCommonStore.comboMachine$lambda$0$3((InStateBuilderBlock) obj);
                return comboMachine$lambda$0$3;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(LiveRoomComboBaseState.CardDismiss.class), block$iv4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit comboMachine$lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit comboMachine$lambda$0$1(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new ComboCommonStore$comboMachine$1$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(LiveRoomComboCommonEvent.CardShow.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit comboMachine$lambda$0$2(ComboCommonStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new ComboCommonStore$comboMachine$1$3$1(this$0, null));
        KLog_androidKt.getKLog().d(TAG, "LiveRoomComboBaseState CardShowing onEnter");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$inState, this$0.totalDownTimer.createFlow(), (ExecutionPolicy) null, new ComboCommonStore$comboMachine$1$3$2(null), 2, (Object) null);
        this$0.cardFadeFlow = new IntervalCountDownTimer(this$0.fadeDuration, 17L);
        IntervalCountDownTimer intervalCountDownTimer = this$0.cardFadeFlow;
        Intrinsics.checkNotNull(intervalCountDownTimer);
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$inState, intervalCountDownTimer.createFlow(), (ExecutionPolicy) null, new ComboCommonStore$comboMachine$1$3$3(null), 2, (Object) null);
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new ComboCommonStore$comboMachine$1$3$4(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(LiveRoomComboCommonEvent.CardClick.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new ComboCommonStore$comboMachine$1$3$5(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(LiveRoomComboCommonEvent.UpdateBySocket.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new ComboCommonStore$comboMachine$1$3$6(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(LiveRoomComboCommonEvent.CancelByOther.class), executionPolicy$iv3, handler$iv3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit comboMachine$lambda$0$3(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new ComboCommonStore$comboMachine$1$4$1(null));
        return Unit.INSTANCE;
    }

    /* compiled from: ComboCommonStore.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/live/room/combo/ComboCommonStore$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "FROM_IDLE", RoomRecommendViewModel.EMPTY_CURSOR, "FROM_CARD_COUNT_DOWN", "FROM_CARD_CLICK", "FROM_DO_COMBO", "INTERVAL_MILLISECOND", RoomRecommendViewModel.EMPTY_CURSOR, "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Flow<LiveRoomComboBaseState> getState() {
        return this.state;
    }

    public Object dispatch(LiveRoomComboCommonEvent action, Continuation<? super Unit> continuation) {
        Object dispatch = this.comboMachine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }
}