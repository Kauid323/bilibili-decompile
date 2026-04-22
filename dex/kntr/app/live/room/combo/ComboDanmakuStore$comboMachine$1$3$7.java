package kntr.app.live.room.combo;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.live.room.combo.LiveRoomComboDanmakuEvent;
import kntr.app.live.room.combo.LiveRoomComboDanmakuState;
import kntr.app.live.room.combo.utils.IntervalCountDownTimer;
import kntr.app.live.room.combo.utils.TotalCountDownTimer;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComboDanmakuStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState;", "action", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$UpdateBySocket;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState$CardShowing;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$3$7", f = "ComboDanmakuStore.kt", i = {0, 0}, l = {237}, m = "invokeSuspend", n = {"action", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class ComboDanmakuStore$comboMachine$1$3$7 extends SuspendLambda implements Function3<LiveRoomComboDanmakuEvent.UpdateBySocket, State<LiveRoomComboDanmakuState.CardShowing>, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ ComboDanmakuStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboDanmakuStore$comboMachine$1$3$7(ComboDanmakuStore comboDanmakuStore, Continuation<? super ComboDanmakuStore$comboMachine$1$3$7> continuation) {
        super(3, continuation);
        this.this$0 = comboDanmakuStore;
    }

    public final Object invoke(LiveRoomComboDanmakuEvent.UpdateBySocket updateBySocket, State<LiveRoomComboDanmakuState.CardShowing> state, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>> continuation) {
        ComboDanmakuStore$comboMachine$1$3$7 comboDanmakuStore$comboMachine$1$3$7 = new ComboDanmakuStore$comboMachine$1$3$7(this.this$0, continuation);
        comboDanmakuStore$comboMachine$1$3$7.L$0 = updateBySocket;
        comboDanmakuStore$comboMachine$1$3$7.L$1 = state;
        return comboDanmakuStore$comboMachine$1$3$7.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        TotalCountDownTimer totalCountDownTimer;
        IntervalCountDownTimer intervalCountDownTimer;
        final LiveRoomComboDanmakuEvent.UpdateBySocket action = (LiveRoomComboDanmakuEvent.UpdateBySocket) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d(ComboDanmakuStore.TAG, "LiveRoomComboEvent.UpdateBySocket");
                String msg = action.getMsg();
                str = this.this$0.msg;
                if (Intrinsics.areEqual(msg, str)) {
                    totalCountDownTimer = this.this$0.totalDownTimer;
                    this.L$0 = action;
                    this.L$1 = state;
                    this.label = 1;
                    if (totalCountDownTimer.restart(action.getLeftDuration(), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return state.noChange();
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        intervalCountDownTimer = this.this$0.comboUploadFlow;
        if (intervalCountDownTimer != null) {
            intervalCountDownTimer.update(0L, action.getMergeInterval());
        }
        return state.mutate(new Function1() { // from class: kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$3$7$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                LiveRoomComboDanmakuState.CardShowing invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = ComboDanmakuStore$comboMachine$1$3$7.invokeSuspend$lambda$0(LiveRoomComboDanmakuEvent.UpdateBySocket.this, (LiveRoomComboDanmakuState.CardShowing) obj);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomComboDanmakuState.CardShowing invokeSuspend$lambda$0(LiveRoomComboDanmakuEvent.UpdateBySocket $action, LiveRoomComboDanmakuState.CardShowing $this$mutate) {
        long count;
        if ($action.getCount() >= $this$mutate.getCount()) {
            count = $action.getCount();
        } else {
            count = $this$mutate.getCount();
        }
        return LiveRoomComboDanmakuState.CardShowing.copy$default($this$mutate, 0.0f, count, 0, $action.getMergeInterval(), 5, null);
    }
}