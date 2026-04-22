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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComboDanmakuStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState;", "action", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$CardShow;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState$Idle;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$2$1", f = "ComboDanmakuStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ComboDanmakuStore$comboMachine$1$2$1 extends SuspendLambda implements Function3<LiveRoomComboDanmakuEvent.CardShow, State<LiveRoomComboDanmakuState.Idle>, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ ComboDanmakuStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboDanmakuStore$comboMachine$1$2$1(ComboDanmakuStore comboDanmakuStore, Continuation<? super ComboDanmakuStore$comboMachine$1$2$1> continuation) {
        super(3, continuation);
        this.this$0 = comboDanmakuStore;
    }

    public final Object invoke(LiveRoomComboDanmakuEvent.CardShow cardShow, State<LiveRoomComboDanmakuState.Idle> state, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>> continuation) {
        ComboDanmakuStore$comboMachine$1$2$1 comboDanmakuStore$comboMachine$1$2$1 = new ComboDanmakuStore$comboMachine$1$2$1(this.this$0, continuation);
        comboDanmakuStore$comboMachine$1$2$1.L$0 = cardShow;
        comboDanmakuStore$comboMachine$1$2$1.L$1 = state;
        return comboDanmakuStore$comboMachine$1$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final LiveRoomComboDanmakuEvent.CardShow action = (LiveRoomComboDanmakuEvent.CardShow) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d(ComboDanmakuStore.TAG, "LiveRoomComboEvent.CardShow");
                final ComboDanmakuStore comboDanmakuStore = this.this$0;
                return state.override(new Function1() { // from class: kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        LiveRoomComboDanmakuState.CardShowing invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ComboDanmakuStore$comboMachine$1$2$1.invokeSuspend$lambda$0(LiveRoomComboDanmakuEvent.CardShow.this, comboDanmakuStore, (LiveRoomComboDanmakuState.Idle) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomComboDanmakuState.CardShowing invokeSuspend$lambda$0(LiveRoomComboDanmakuEvent.CardShow $action, ComboDanmakuStore this$0, LiveRoomComboDanmakuState.Idle $this$override) {
        long j2;
        long count = $action.getCount();
        j2 = this$0.mergeInterval;
        return new LiveRoomComboDanmakuState.CardShowing(1.0f, count, 1, j2);
    }
}