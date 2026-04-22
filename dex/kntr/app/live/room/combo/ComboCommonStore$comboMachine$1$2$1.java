package kntr.app.live.room.combo;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.live.room.combo.LiveRoomComboBaseState;
import kntr.app.live.room.combo.LiveRoomComboCommonEvent;
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
/* compiled from: ComboCommonStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState;", "action", "Lkntr/app/live/room/combo/LiveRoomComboCommonEvent$CardShow;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState$Idle;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboCommonStore$comboMachine$1$2$1", f = "ComboCommonStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ComboCommonStore$comboMachine$1$2$1 extends SuspendLambda implements Function3<LiveRoomComboCommonEvent.CardShow, State<LiveRoomComboBaseState.Idle>, Continuation<? super ChangedState<? extends LiveRoomComboBaseState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComboCommonStore$comboMachine$1$2$1(Continuation<? super ComboCommonStore$comboMachine$1$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(LiveRoomComboCommonEvent.CardShow cardShow, State<LiveRoomComboBaseState.Idle> state, Continuation<? super ChangedState<? extends LiveRoomComboBaseState>> continuation) {
        ComboCommonStore$comboMachine$1$2$1 comboCommonStore$comboMachine$1$2$1 = new ComboCommonStore$comboMachine$1$2$1(continuation);
        comboCommonStore$comboMachine$1$2$1.L$0 = cardShow;
        comboCommonStore$comboMachine$1$2$1.L$1 = state;
        return comboCommonStore$comboMachine$1$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final LiveRoomComboCommonEvent.CardShow action = (LiveRoomComboCommonEvent.CardShow) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d(ComboCommonStore.TAG, "LiveRoomComboCommonEvent.CardShow");
                return state.override(new Function1() { // from class: kntr.app.live.room.combo.ComboCommonStore$comboMachine$1$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        LiveRoomComboBaseState.CardShowing invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ComboCommonStore$comboMachine$1$2$1.invokeSuspend$lambda$0(LiveRoomComboCommonEvent.CardShow.this, (LiveRoomComboBaseState.Idle) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomComboBaseState.CardShowing invokeSuspend$lambda$0(LiveRoomComboCommonEvent.CardShow $action, LiveRoomComboBaseState.Idle $this$override) {
        return new LiveRoomComboBaseState.CardShowing(1.0f, $action.getCount(), 1);
    }
}