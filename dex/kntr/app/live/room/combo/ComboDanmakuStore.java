package kntr.app.live.room.combo;

import com.bapis.bilibili.live.approom.api.grpc.v1.KDanmuMoss;
import com.bapis.bilibili.live.approom.api.grpc.v1.KDoComboReq;
import com.bapis.bilibili.live.approom.api.grpc.v1.KDoComboResp;
import com.bapis.bilibili.live.approom.api.grpc.v1.KSendComboMsgReq;
import com.bapis.bilibili.live.approom.api.grpc.v1.KSendComboMsgResp;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.live.room.combo.LiveRoomComboDanmakuEvent;
import kntr.app.live.room.combo.LiveRoomComboDanmakuState;
import kntr.app.live.room.combo.utils.IntervalCountDownTimer;
import kntr.app.live.room.combo.utils.TotalCountDownTimer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kntr.base.moss.api.KMossException;
import kntr.base.udf.Store;
import kntr.base.udf.StoreMachine;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ComboDanmakuStore.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001+BA\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u001dJ(\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010!J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003H\u0097@¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0017X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lkntr/app/live/room/combo/ComboDanmakuStore;", "Lkntr/base/udf/Store;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent;", "roomId", RoomRecommendViewModel.EMPTY_CURSOR, "resetCnt", RoomRecommendViewModel.EMPTY_CURSOR, "interactionId", "msg", RoomRecommendViewModel.EMPTY_CURSOR, "leftDuration", "fadeDuration", "mergeInterval", "<init>", "(JIJLjava/lang/String;JJJ)V", "cardFadeFlow", "Lkntr/app/live/room/combo/utils/IntervalCountDownTimer;", "comboUploadFlow", "totalDownTimer", "Lkntr/app/live/room/combo/utils/TotalCountDownTimer;", "tempCount", "comboMachine", "Lkntr/base/udf/StoreMachine;", "getComboMachine$annotations", "()V", "doCombo", "Lcom/bapis/bilibili/live/approom/api/grpc/v1/KDoComboResp;", "cnt", "(JJILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendComboMsg", "Lcom/bapis/bilibili/live/approom/api/grpc/v1/KSendComboMsgResp;", "rnd", "(JLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "action", "(Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ComboDanmakuStore implements Store<LiveRoomComboDanmakuState, LiveRoomComboDanmakuEvent> {
    public static final Companion Companion = new Companion(null);
    public static final int FROM_CARD_CLICK = 3;
    public static final int FROM_CARD_COUNT_DOWN = 2;
    public static final int FROM_DO_COMBO = 4;
    public static final int FROM_IDLE = 1;
    public static final long INTERVAL_MILLISECOND = 17;
    public static final String TAG = "LIVE_ROOM_COMBO_DANMAKU";
    private IntervalCountDownTimer cardFadeFlow;
    private final StoreMachine<LiveRoomComboDanmakuState, LiveRoomComboDanmakuEvent> comboMachine;
    private IntervalCountDownTimer comboUploadFlow;
    private final long fadeDuration;
    private final long interactionId;
    private final long leftDuration;
    private final long mergeInterval;
    private final String msg;
    private int resetCnt;
    private final long roomId;
    private final Flow<LiveRoomComboDanmakuState> state;
    private int tempCount;
    private final TotalCountDownTimer totalDownTimer;

    private static /* synthetic */ void getComboMachine$annotations() {
    }

    public static /* synthetic */ void getState$annotations() {
    }

    public ComboDanmakuStore(long roomId, int resetCnt, long interactionId, String msg, long leftDuration, long fadeDuration, long mergeInterval) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.roomId = roomId;
        this.resetCnt = resetCnt;
        this.interactionId = interactionId;
        this.msg = msg;
        this.leftDuration = leftDuration;
        this.fadeDuration = fadeDuration;
        this.mergeInterval = mergeInterval;
        this.totalDownTimer = new TotalCountDownTimer();
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = LiveRoomComboDanmakuState.Idle.INSTANCE;
        Function1 specBlock$iv = new Function1() { // from class: kntr.app.live.room.combo.ComboDanmakuStore$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit comboMachine$lambda$0;
                comboMachine$lambda$0 = ComboDanmakuStore.comboMachine$lambda$0(ComboDanmakuStore.this, (FlowReduxStoreBuilder) obj);
                return comboMachine$lambda$0;
            }
        };
        this.comboMachine = new StoreMachine<>(initialState$iv, specBlock$iv);
        this.state = this.comboMachine.getState();
    }

    public /* bridge */ /* synthetic */ Object dispatch(Object action, Continuation $completion) {
        return dispatch((LiveRoomComboDanmakuEvent) action, (Continuation<? super Unit>) $completion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit comboMachine$lambda$0(final ComboDanmakuStore this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: kntr.app.live.room.combo.ComboDanmakuStore$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit comboMachine$lambda$0$0;
                comboMachine$lambda$0$0 = ComboDanmakuStore.comboMachine$lambda$0$0((InStateBuilderBlock) obj);
                return comboMachine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(LiveRoomComboDanmakuState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.live.room.combo.ComboDanmakuStore$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit comboMachine$lambda$0$1;
                comboMachine$lambda$0$1 = ComboDanmakuStore.comboMachine$lambda$0$1(ComboDanmakuStore.this, (InStateBuilderBlock) obj);
                return comboMachine$lambda$0$1;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(LiveRoomComboDanmakuState.Idle.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: kntr.app.live.room.combo.ComboDanmakuStore$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit comboMachine$lambda$0$2;
                comboMachine$lambda$0$2 = ComboDanmakuStore.comboMachine$lambda$0$2(ComboDanmakuStore.this, (InStateBuilderBlock) obj);
                return comboMachine$lambda$0$2;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(LiveRoomComboDanmakuState.CardShowing.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: kntr.app.live.room.combo.ComboDanmakuStore$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit comboMachine$lambda$0$3;
                comboMachine$lambda$0$3 = ComboDanmakuStore.comboMachine$lambda$0$3(ComboDanmakuStore.this, (InStateBuilderBlock) obj);
                return comboMachine$lambda$0$3;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(LiveRoomComboDanmakuState.CardDismiss.class), block$iv4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit comboMachine$lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit comboMachine$lambda$0$1(ComboDanmakuStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new ComboDanmakuStore$comboMachine$1$2$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(LiveRoomComboDanmakuEvent.CardShow.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit comboMachine$lambda$0$2(ComboDanmakuStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new ComboDanmakuStore$comboMachine$1$3$1(this$0, null));
        KLog_androidKt.getKLog().d(TAG, "LiveRoomComboState CardShowing onEnter");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$inState, this$0.totalDownTimer.createFlow(), (ExecutionPolicy) null, new ComboDanmakuStore$comboMachine$1$3$2(null), 2, (Object) null);
        this$0.cardFadeFlow = new IntervalCountDownTimer(this$0.fadeDuration, 17L);
        IntervalCountDownTimer intervalCountDownTimer = this$0.cardFadeFlow;
        Intrinsics.checkNotNull(intervalCountDownTimer);
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$inState, intervalCountDownTimer.createFlow(), (ExecutionPolicy) null, new ComboDanmakuStore$comboMachine$1$3$3(null), 2, (Object) null);
        this$0.comboUploadFlow = new IntervalCountDownTimer(0L, this$0.mergeInterval);
        IntervalCountDownTimer intervalCountDownTimer2 = this$0.comboUploadFlow;
        Intrinsics.checkNotNull(intervalCountDownTimer2);
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$inState, intervalCountDownTimer2.createFlow(), (ExecutionPolicy) null, new ComboDanmakuStore$comboMachine$1$3$4(this$0, null), 2, (Object) null);
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new ComboDanmakuStore$comboMachine$1$3$5(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(LiveRoomComboDanmakuEvent.CardClick.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new ComboDanmakuStore$comboMachine$1$3$6(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(LiveRoomComboDanmakuEvent.SendComboMsg.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new ComboDanmakuStore$comboMachine$1$3$7(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(LiveRoomComboDanmakuEvent.UpdateBySocket.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new ComboDanmakuStore$comboMachine$1$3$8(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(LiveRoomComboDanmakuEvent.CancelByOther.class), executionPolicy$iv4, handler$iv4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit comboMachine$lambda$0$3(ComboDanmakuStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new ComboDanmakuStore$comboMachine$1$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doCombo(long roomId, long interactionId, int cnt, String msg, Continuation<? super KDoComboResp> continuation) {
        ComboDanmakuStore$doCombo$1 comboDanmakuStore$doCombo$1;
        ComboDanmakuStore$doCombo$1 comboDanmakuStore$doCombo$12;
        KDanmuMoss kDanmuMoss;
        String message;
        if (continuation instanceof ComboDanmakuStore$doCombo$1) {
            comboDanmakuStore$doCombo$1 = (ComboDanmakuStore$doCombo$1) continuation;
            if ((comboDanmakuStore$doCombo$1.label & Integer.MIN_VALUE) != 0) {
                comboDanmakuStore$doCombo$1.label -= Integer.MIN_VALUE;
                comboDanmakuStore$doCombo$12 = comboDanmakuStore$doCombo$1;
                Object $result = comboDanmakuStore$doCombo$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (comboDanmakuStore$doCombo$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.tempCount = 0;
                        KLog_androidKt.getKLog().d(TAG, "doCombo ,cnt:" + cnt);
                        KDoComboReq req = new KDoComboReq(roomId, interactionId, cnt, msg);
                        try {
                            kDanmuMoss = new KDanmuMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            comboDanmakuStore$doCombo$12.L$0 = SpillingKt.nullOutSpilledVariable(msg);
                            comboDanmakuStore$doCombo$12.L$1 = SpillingKt.nullOutSpilledVariable(req);
                        } catch (KMossException e) {
                            mossEx = e;
                        }
                        try {
                            comboDanmakuStore$doCombo$12.J$0 = roomId;
                        } catch (KMossException e2) {
                            mossEx = e2;
                            ILogger kLog = KLog_androidKt.getKLog();
                            message = mossEx.getMessage();
                            if (message == null) {
                            }
                            kLog.e(TAG, message);
                            return null;
                        }
                        try {
                            comboDanmakuStore$doCombo$12.J$1 = interactionId;
                            comboDanmakuStore$doCombo$12.I$0 = cnt;
                            comboDanmakuStore$doCombo$12.label = 1;
                            Object doCombo = kDanmuMoss.doCombo(req, comboDanmakuStore$doCombo$12);
                            if (doCombo == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return doCombo;
                        } catch (KMossException e3) {
                            mossEx = e3;
                            ILogger kLog2 = KLog_androidKt.getKLog();
                            message = mossEx.getMessage();
                            if (message == null) {
                            }
                            kLog2.e(TAG, message);
                            return null;
                        }
                    case 1:
                        int i = comboDanmakuStore$doCombo$12.I$0;
                        long j2 = comboDanmakuStore$doCombo$12.J$1;
                        long j3 = comboDanmakuStore$doCombo$12.J$0;
                        KDoComboReq kDoComboReq = (KDoComboReq) comboDanmakuStore$doCombo$12.L$1;
                        String str = (String) comboDanmakuStore$doCombo$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            return $result;
                        } catch (KMossException e4) {
                            mossEx = e4;
                            break;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ILogger kLog22 = KLog_androidKt.getKLog();
                message = mossEx.getMessage();
                if (message == null) {
                    message = "doCombo moss error is null";
                }
                kLog22.e(TAG, message);
                return null;
            }
        }
        comboDanmakuStore$doCombo$1 = new ComboDanmakuStore$doCombo$1(this, continuation);
        comboDanmakuStore$doCombo$12 = comboDanmakuStore$doCombo$1;
        Object $result2 = comboDanmakuStore$doCombo$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (comboDanmakuStore$doCombo$12.label) {
        }
        ILogger kLog222 = KLog_androidKt.getKLog();
        message = mossEx.getMessage();
        if (message == null) {
        }
        kLog222.e(TAG, message);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendComboMsg(long roomId, String msg, long rnd, Continuation<? super KSendComboMsgResp> continuation) {
        ComboDanmakuStore$sendComboMsg$1 comboDanmakuStore$sendComboMsg$1;
        KMossException mossEx;
        String message;
        if (continuation instanceof ComboDanmakuStore$sendComboMsg$1) {
            comboDanmakuStore$sendComboMsg$1 = (ComboDanmakuStore$sendComboMsg$1) continuation;
            if ((comboDanmakuStore$sendComboMsg$1.label & Integer.MIN_VALUE) != 0) {
                comboDanmakuStore$sendComboMsg$1.label -= Integer.MIN_VALUE;
                Object $result = comboDanmakuStore$sendComboMsg$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (comboDanmakuStore$sendComboMsg$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KSendComboMsgReq req = new KSendComboMsgReq(roomId, msg, String.valueOf(rnd));
                        try {
                            KDanmuMoss kDanmuMoss = new KDanmuMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            comboDanmakuStore$sendComboMsg$1.L$0 = SpillingKt.nullOutSpilledVariable(msg);
                            comboDanmakuStore$sendComboMsg$1.L$1 = SpillingKt.nullOutSpilledVariable(req);
                            comboDanmakuStore$sendComboMsg$1.J$0 = roomId;
                            comboDanmakuStore$sendComboMsg$1.J$1 = rnd;
                            comboDanmakuStore$sendComboMsg$1.label = 1;
                            Object sendComboMsg = kDanmuMoss.sendComboMsg(req, comboDanmakuStore$sendComboMsg$1);
                            if (sendComboMsg == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return sendComboMsg;
                        } catch (KMossException e) {
                            mossEx = e;
                            break;
                        }
                    case 1:
                        long rnd2 = comboDanmakuStore$sendComboMsg$1.J$1;
                        long roomId2 = comboDanmakuStore$sendComboMsg$1.J$0;
                        KSendComboMsgReq kSendComboMsgReq = (KSendComboMsgReq) comboDanmakuStore$sendComboMsg$1.L$1;
                        String str = (String) comboDanmakuStore$sendComboMsg$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            return $result;
                        } catch (KMossException e2) {
                            mossEx = e2;
                            break;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ILogger kLog = KLog_androidKt.getKLog();
                message = mossEx.getMessage();
                if (message == null) {
                    message = "sendComboMsg moss error is null";
                }
                kLog.e(TAG, message);
                return null;
            }
        }
        comboDanmakuStore$sendComboMsg$1 = new ComboDanmakuStore$sendComboMsg$1(this, continuation);
        Object $result2 = comboDanmakuStore$sendComboMsg$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (comboDanmakuStore$sendComboMsg$1.label) {
        }
        ILogger kLog2 = KLog_androidKt.getKLog();
        message = mossEx.getMessage();
        if (message == null) {
        }
        kLog2.e(TAG, message);
        return null;
    }

    /* compiled from: ComboDanmakuStore.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/live/room/combo/ComboDanmakuStore$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "FROM_IDLE", RoomRecommendViewModel.EMPTY_CURSOR, "FROM_CARD_COUNT_DOWN", "FROM_CARD_CLICK", "FROM_DO_COMBO", "INTERVAL_MILLISECOND", RoomRecommendViewModel.EMPTY_CURSOR, "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Flow<LiveRoomComboDanmakuState> getState() {
        return this.state;
    }

    public Object dispatch(LiveRoomComboDanmakuEvent action, Continuation<? super Unit> continuation) {
        Object dispatch = this.comboMachine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }
}