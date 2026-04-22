package kntr.app.live.room.combo;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.live.room.combo.LiveRoomComboBaseState;
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
/* compiled from: ComboCommonStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState;", "item", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState$CardShowing;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboCommonStore$comboMachine$1$3$3", f = "ComboCommonStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ComboCommonStore$comboMachine$1$3$3 extends SuspendLambda implements Function3<Float, State<LiveRoomComboBaseState.CardShowing>, Continuation<? super ChangedState<? extends LiveRoomComboBaseState>>, Object> {
    /* synthetic */ float F$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComboCommonStore$comboMachine$1$3$3(Continuation<? super ComboCommonStore$comboMachine$1$3$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(float f, State<LiveRoomComboBaseState.CardShowing> state, Continuation<? super ChangedState<? extends LiveRoomComboBaseState>> continuation) {
        ComboCommonStore$comboMachine$1$3$3 comboCommonStore$comboMachine$1$3$3 = new ComboCommonStore$comboMachine$1$3$3(continuation);
        comboCommonStore$comboMachine$1$3$3.F$0 = f;
        comboCommonStore$comboMachine$1$3$3.L$0 = state;
        return comboCommonStore$comboMachine$1$3$3.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).floatValue(), (State) obj2, (Continuation) obj3);
    }

    public final Object invokeSuspend(Object $result) {
        final float item = this.F$0;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (item > 0.05d) {
                    return state.mutate(new Function1() { // from class: kntr.app.live.room.combo.ComboCommonStore$comboMachine$1$3$3$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            LiveRoomComboBaseState.CardShowing invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = ComboCommonStore$comboMachine$1$3$3.invokeSuspend$lambda$0(item, (LiveRoomComboBaseState.CardShowing) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
                return state.override(new Function1() { // from class: kntr.app.live.room.combo.ComboCommonStore$comboMachine$1$3$3$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        LiveRoomComboBaseState.CardDismiss invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = ComboCommonStore$comboMachine$1$3$3.invokeSuspend$lambda$1((LiveRoomComboBaseState.CardShowing) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomComboBaseState.CardShowing invokeSuspend$lambda$0(float $item, LiveRoomComboBaseState.CardShowing $this$mutate) {
        return LiveRoomComboBaseState.CardShowing.copy$default($this$mutate, $item, 0L, 2, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomComboBaseState.CardDismiss invokeSuspend$lambda$1(LiveRoomComboBaseState.CardShowing $this$override) {
        return new LiveRoomComboBaseState.CardDismiss(1);
    }
}