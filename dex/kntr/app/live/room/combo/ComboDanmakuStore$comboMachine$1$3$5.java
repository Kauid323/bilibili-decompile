package kntr.app.live.room.combo;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.live.room.combo.LiveRoomComboDanmakuEvent;
import kntr.app.live.room.combo.LiveRoomComboDanmakuState;
import kntr.app.live.room.combo.utils.IntervalCountDownTimer;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComboDanmakuStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState;", "<unused var>", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$CardClick;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState$CardShowing;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$3$5", f = "ComboDanmakuStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ComboDanmakuStore$comboMachine$1$3$5 extends SuspendLambda implements Function3<LiveRoomComboDanmakuEvent.CardClick, State<LiveRoomComboDanmakuState.CardShowing>, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ComboDanmakuStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboDanmakuStore$comboMachine$1$3$5(ComboDanmakuStore comboDanmakuStore, Continuation<? super ComboDanmakuStore$comboMachine$1$3$5> continuation) {
        super(3, continuation);
        this.this$0 = comboDanmakuStore;
    }

    public final Object invoke(LiveRoomComboDanmakuEvent.CardClick cardClick, State<LiveRoomComboDanmakuState.CardShowing> state, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>> continuation) {
        ComboDanmakuStore$comboMachine$1$3$5 comboDanmakuStore$comboMachine$1$3$5 = new ComboDanmakuStore$comboMachine$1$3$5(this.this$0, continuation);
        comboDanmakuStore$comboMachine$1$3$5.L$0 = state;
        return comboDanmakuStore$comboMachine$1$3$5.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
        r1 = r6.this$0.cardFadeFlow;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int i;
        int i2;
        int i3;
        IntervalCountDownTimer intervalCountDownTimer;
        int i4;
        IntervalCountDownTimer intervalCountDownTimer2;
        int i5;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d(ComboDanmakuStore.TAG, "LiveRoomComboEvent.CardClick");
                i = this.this$0.tempCount;
                this.this$0.tempCount = i + 1;
                i2 = this.this$0.resetCnt;
                if (i2 > 0) {
                    intervalCountDownTimer2 = this.this$0.cardFadeFlow;
                    if (intervalCountDownTimer2 != null) {
                        intervalCountDownTimer2.reset();
                    }
                    ComboDanmakuStore comboDanmakuStore = this.this$0;
                    i5 = this.this$0.resetCnt;
                    comboDanmakuStore.resetCnt = i5 - 1;
                } else {
                    i3 = this.this$0.resetCnt;
                    if (i3 == -1 && intervalCountDownTimer != null) {
                        intervalCountDownTimer.reset();
                    }
                }
                ILogger kLog = KLog_androidKt.getKLog();
                i4 = this.this$0.tempCount;
                kLog.d(ComboDanmakuStore.TAG, "LiveRoomComboEvent.CardClick ，this.count :" + i4);
                return state.mutate(new Function1() { // from class: kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$3$5$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        LiveRoomComboDanmakuState.CardShowing invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ComboDanmakuStore$comboMachine$1$3$5.invokeSuspend$lambda$0((LiveRoomComboDanmakuState.CardShowing) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomComboDanmakuState.CardShowing invokeSuspend$lambda$0(LiveRoomComboDanmakuState.CardShowing $this$mutate) {
        return LiveRoomComboDanmakuState.CardShowing.copy$default($this$mutate, 0.0f, $this$mutate.getCount() + 1, 3, 0L, 9, null);
    }
}