package kntr.app.live.room.combo;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.live.room.combo.LiveRoomComboDanmakuState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComboDanmakuStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState;", "<unused var>", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuState$CardShowing;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$3$4", f = "ComboDanmakuStore.kt", i = {0, 0}, l = {199}, m = "invokeSuspend", n = {"state", "snapshot"}, s = {"L$0", "L$1"}, v = 1)
public final class ComboDanmakuStore$comboMachine$1$3$4 extends SuspendLambda implements Function3<Float, State<LiveRoomComboDanmakuState.CardShowing>, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ComboDanmakuStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboDanmakuStore$comboMachine$1$3$4(ComboDanmakuStore comboDanmakuStore, Continuation<? super ComboDanmakuStore$comboMachine$1$3$4> continuation) {
        super(3, continuation);
        this.this$0 = comboDanmakuStore;
    }

    public final Object invoke(float f, State<LiveRoomComboDanmakuState.CardShowing> state, Continuation<? super ChangedState<? extends LiveRoomComboDanmakuState>> continuation) {
        ComboDanmakuStore$comboMachine$1$3$4 comboDanmakuStore$comboMachine$1$3$4 = new ComboDanmakuStore$comboMachine$1$3$4(this.this$0, continuation);
        comboDanmakuStore$comboMachine$1$3$4.L$0 = state;
        return comboDanmakuStore$comboMachine$1$3$4.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).floatValue(), (State) obj2, (Continuation) obj3);
    }

    public final Object invokeSuspend(Object $result) {
        int i;
        int i2;
        long j2;
        long j3;
        int i3;
        String str;
        Object doCombo;
        LiveRoomComboDanmakuState.CardShowing snapshot;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LiveRoomComboDanmakuState.CardShowing snapshot2 = (LiveRoomComboDanmakuState.CardShowing) state.getSnapshot();
                i = this.this$0.tempCount;
                if (i > 0 && snapshot2.getMergeInterval() > 0) {
                    ILogger kLog = KLog_androidKt.getKLog();
                    i2 = this.this$0.tempCount;
                    kLog.d(ComboDanmakuStore.TAG, "comboUploadFlow :" + i2);
                    ComboDanmakuStore comboDanmakuStore = this.this$0;
                    j2 = this.this$0.roomId;
                    j3 = this.this$0.interactionId;
                    i3 = this.this$0.tempCount;
                    str = this.this$0.msg;
                    this.L$0 = state;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(snapshot2);
                    this.label = 1;
                    doCombo = comboDanmakuStore.doCombo(j2, j3, i3, str, (Continuation) this);
                    if (doCombo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    snapshot = snapshot2;
                    break;
                }
                break;
            case 1:
                snapshot = (LiveRoomComboDanmakuState.CardShowing) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.mutate(new Function1() { // from class: kntr.app.live.room.combo.ComboDanmakuStore$comboMachine$1$3$4$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                LiveRoomComboDanmakuState.CardShowing copy$default;
                copy$default = LiveRoomComboDanmakuState.CardShowing.copy$default((LiveRoomComboDanmakuState.CardShowing) obj, 0.0f, 0L, 4, 0L, 11, null);
                return copy$default;
            }
        });
    }
}