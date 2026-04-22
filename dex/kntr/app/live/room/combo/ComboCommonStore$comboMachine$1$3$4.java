package kntr.app.live.room.combo;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.live.room.combo.LiveRoomComboBaseState;
import kntr.app.live.room.combo.LiveRoomComboCommonEvent;
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
/* compiled from: ComboCommonStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState;", "action", "Lkntr/app/live/room/combo/LiveRoomComboCommonEvent$CardClick;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState$CardShowing;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.combo.ComboCommonStore$comboMachine$1$3$4", f = "ComboCommonStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ComboCommonStore$comboMachine$1$3$4 extends SuspendLambda implements Function3<LiveRoomComboCommonEvent.CardClick, State<LiveRoomComboBaseState.CardShowing>, Continuation<? super ChangedState<? extends LiveRoomComboBaseState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ ComboCommonStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComboCommonStore$comboMachine$1$3$4(ComboCommonStore comboCommonStore, Continuation<? super ComboCommonStore$comboMachine$1$3$4> continuation) {
        super(3, continuation);
        this.this$0 = comboCommonStore;
    }

    public final Object invoke(LiveRoomComboCommonEvent.CardClick cardClick, State<LiveRoomComboBaseState.CardShowing> state, Continuation<? super ChangedState<? extends LiveRoomComboBaseState>> continuation) {
        ComboCommonStore$comboMachine$1$3$4 comboCommonStore$comboMachine$1$3$4 = new ComboCommonStore$comboMachine$1$3$4(this.this$0, continuation);
        comboCommonStore$comboMachine$1$3$4.L$0 = cardClick;
        comboCommonStore$comboMachine$1$3$4.L$1 = state;
        return comboCommonStore$comboMachine$1$3$4.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005d, code lost:
        r2 = r7.this$0.cardFadeFlow;
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
        final LiveRoomComboCommonEvent.CardClick action = (LiveRoomComboCommonEvent.CardClick) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d(ComboCommonStore.TAG, "LiveRoomComboCommonEvent.CardClick");
                i = this.this$0.tempCount;
                this.this$0.tempCount = i + 1;
                i2 = this.this$0.resetCnt;
                if (i2 > 0) {
                    intervalCountDownTimer2 = this.this$0.cardFadeFlow;
                    if (intervalCountDownTimer2 != null) {
                        intervalCountDownTimer2.reset();
                    }
                    ComboCommonStore comboCommonStore = this.this$0;
                    i5 = this.this$0.resetCnt;
                    comboCommonStore.resetCnt = i5 - 1;
                } else {
                    i3 = this.this$0.resetCnt;
                    if (i3 == -1 && intervalCountDownTimer != null) {
                        intervalCountDownTimer.reset();
                    }
                }
                ILogger kLog = KLog_androidKt.getKLog();
                i4 = this.this$0.tempCount;
                kLog.d(ComboCommonStore.TAG, "LiveRoomComboCommonEvent.CardClick ，this.count :" + i4);
                return state.mutate(new Function1() { // from class: kntr.app.live.room.combo.ComboCommonStore$comboMachine$1$3$4$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        LiveRoomComboBaseState.CardShowing invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ComboCommonStore$comboMachine$1$3$4.invokeSuspend$lambda$0(LiveRoomComboCommonEvent.CardClick.this, (LiveRoomComboBaseState.CardShowing) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveRoomComboBaseState.CardShowing invokeSuspend$lambda$0(LiveRoomComboCommonEvent.CardClick $action, LiveRoomComboBaseState.CardShowing $this$mutate) {
        return LiveRoomComboBaseState.CardShowing.copy$default($this$mutate, 0.0f, $action.getNeedAdd() ? $this$mutate.getCount() + 1 : $this$mutate.getCount(), 3, 1, null);
    }
}