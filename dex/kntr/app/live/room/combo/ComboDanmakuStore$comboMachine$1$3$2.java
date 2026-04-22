package kntr.app.live.room.combo;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.live.room.combo.LiveRoomComboDanmakuState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState;", "<unused var>", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState$CardShowing;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$3$2", f = "ComboDanmakuStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ComboDanmakuStore$comboMachine$1$3$2 extends SuspendLambda implements Function3<Unit, State<LiveRoomComboDanmakuState.CardShowing>, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComboDanmakuStore$comboMachine$1$3$2(Continuation<? super ComboDanmakuStore$comboMachine$1$3$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(Unit unit, State<LiveRoomComboDanmakuState.CardShowing> state, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>> continuation) {
        ComboDanmakuStore$comboMachine$1$3$2 comboDanmakuStore$comboMachine$1$3$2 = new ComboDanmakuStore$comboMachine$1$3$2(continuation);
        comboDanmakuStore$comboMachine$1$3$2.L$0 = state;
        return comboDanmakuStore$comboMachine$1$3$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$3$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        LiveRoomComboDanmakuState.CardDismiss invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ComboDanmakuStore$comboMachine$1$3$2.invokeSuspend$lambda$0((LiveRoomComboDanmakuState.CardShowing) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomComboDanmakuState.CardDismiss invokeSuspend$lambda$0(LiveRoomComboDanmakuState.CardShowing $this$override) {
        return new LiveRoomComboDanmakuState.CardDismiss(2);
    }
}