package kntr.app.live.room.combo;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.live.room.combo.LiveRoomComboDanmakuEvent;
import kntr.app.live.room.combo.LiveRoomComboDanmakuState;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComboDanmakuStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState;", "event", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$SendComboMsg;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState$CardShowing;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$3$6", f = "ComboDanmakuStore.kt", i = {0, 0}, l = {226}, m = "invokeSuspend", n = {"event", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class ComboDanmakuStore$comboMachine$1$3$6 extends SuspendLambda implements Function3<LiveRoomComboDanmakuEvent.SendComboMsg, State<LiveRoomComboDanmakuState.CardShowing>, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ ComboDanmakuStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboDanmakuStore$comboMachine$1$3$6(ComboDanmakuStore comboDanmakuStore, Continuation<? super ComboDanmakuStore$comboMachine$1$3$6> continuation) {
        super(3, continuation);
        this.this$0 = comboDanmakuStore;
    }

    public final Object invoke(LiveRoomComboDanmakuEvent.SendComboMsg sendComboMsg, State<LiveRoomComboDanmakuState.CardShowing> state, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>> continuation) {
        ComboDanmakuStore$comboMachine$1$3$6 comboDanmakuStore$comboMachine$1$3$6 = new ComboDanmakuStore$comboMachine$1$3$6(this.this$0, continuation);
        comboDanmakuStore$comboMachine$1$3$6.L$0 = sendComboMsg;
        comboDanmakuStore$comboMachine$1$3$6.L$1 = state;
        return comboDanmakuStore$comboMachine$1$3$6.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long j2;
        Object sendComboMsg;
        LiveRoomComboDanmakuEvent.SendComboMsg event = (LiveRoomComboDanmakuEvent.SendComboMsg) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d(ComboDanmakuStore.TAG, "LiveRoomComboEvent.SendComboMsg");
                ComboDanmakuStore comboDanmakuStore = this.this$0;
                j2 = this.this$0.roomId;
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.label = 1;
                sendComboMsg = comboDanmakuStore.sendComboMsg(j2, event.getMsg(), event.getRnd(), (Continuation) this);
                if (sendComboMsg == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.noChange();
    }
}