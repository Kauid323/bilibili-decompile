package kntr.app.live.room.combo;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.live.room.combo.LiveRoomComboDanmakuState;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComboDanmakuStore.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState$CardDismiss;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$4$1", f = "ComboDanmakuStore.kt", i = {0}, l = {274}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class ComboDanmakuStore$comboMachine$1$4$1 extends SuspendLambda implements Function2<State<LiveRoomComboDanmakuState.CardDismiss>, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ComboDanmakuStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboDanmakuStore$comboMachine$1$4$1(ComboDanmakuStore comboDanmakuStore, Continuation<? super ComboDanmakuStore$comboMachine$1$4$1> continuation) {
        super(2, continuation);
        this.this$0 = comboDanmakuStore;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> comboDanmakuStore$comboMachine$1$4$1 = new ComboDanmakuStore$comboMachine$1$4$1(this.this$0, continuation);
        comboDanmakuStore$comboMachine$1$4$1.L$0 = obj;
        return comboDanmakuStore$comboMachine$1$4$1;
    }

    public final Object invoke(State<LiveRoomComboDanmakuState.CardDismiss> state, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int i;
        long j2;
        long j3;
        int i2;
        String str;
        Object doCombo;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d(ComboDanmakuStore.TAG, "LiveRoomComboState.CardDismiss  onEnter");
                i = this.this$0.tempCount;
                if (i > 0) {
                    ComboDanmakuStore comboDanmakuStore = this.this$0;
                    j2 = this.this$0.roomId;
                    j3 = this.this$0.interactionId;
                    i2 = this.this$0.tempCount;
                    str = this.this$0.msg;
                    this.L$0 = state;
                    this.label = 1;
                    doCombo = comboDanmakuStore.doCombo(j2, j3, i2, str, (Continuation) this);
                    if (doCombo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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