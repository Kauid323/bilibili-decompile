package kntr.app.live.room.lolracerscore;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.live.room.lolracerscore.RoomLOLRacerScoreEvent;
import kntr.app.live.room.lolracerscore.RoomLOLRacerScoreState;
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
/* compiled from: RoomLOLRacerScoreVM.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState;", "event", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$DidSelectPlayer;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$racerScoreMachine$1$1$2", f = "RoomLOLRacerScoreVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RoomLOLRacerScoreVM$racerScoreMachine$1$1$2 extends SuspendLambda implements Function3<RoomLOLRacerScoreEvent.DidSelectPlayer, State<RoomLOLRacerScoreState>, Continuation<? super ChangedState<? extends RoomLOLRacerScoreState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ RoomLOLRacerScoreVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomLOLRacerScoreVM$racerScoreMachine$1$1$2(RoomLOLRacerScoreVM roomLOLRacerScoreVM, Continuation<? super RoomLOLRacerScoreVM$racerScoreMachine$1$1$2> continuation) {
        super(3, continuation);
        this.this$0 = roomLOLRacerScoreVM;
    }

    public final Object invoke(RoomLOLRacerScoreEvent.DidSelectPlayer didSelectPlayer, State<RoomLOLRacerScoreState> state, Continuation<? super ChangedState<? extends RoomLOLRacerScoreState>> continuation) {
        RoomLOLRacerScoreVM$racerScoreMachine$1$1$2 roomLOLRacerScoreVM$racerScoreMachine$1$1$2 = new RoomLOLRacerScoreVM$racerScoreMachine$1$1$2(this.this$0, continuation);
        roomLOLRacerScoreVM$racerScoreMachine$1$1$2.L$0 = didSelectPlayer;
        roomLOLRacerScoreVM$racerScoreMachine$1$1$2.L$1 = state;
        return roomLOLRacerScoreVM$racerScoreMachine$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final RoomLOLRacerScoreEvent.DidSelectPlayer event = (RoomLOLRacerScoreEvent.DidSelectPlayer) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d("LIVE_ROOM_LOL_RACER_SCORE", "DidSelectPlayer: " + event);
                final RoomLOLRacerScoreVM roomLOLRacerScoreVM = this.this$0;
                return state.override(new Function1() { // from class: kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$racerScoreMachine$1$1$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        RoomLOLRacerScoreState.DidUpdatePlayers invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = RoomLOLRacerScoreVM$racerScoreMachine$1$1$2.invokeSuspend$lambda$0(RoomLOLRacerScoreVM.this, event, (RoomLOLRacerScoreState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomLOLRacerScoreState.DidUpdatePlayers invokeSuspend$lambda$0(RoomLOLRacerScoreVM this$0, RoomLOLRacerScoreEvent.DidSelectPlayer $event, RoomLOLRacerScoreState $this$override) {
        List list;
        List selectRacer;
        list = this$0.dataModel;
        selectRacer = this$0.selectRacer(list, $event.getRacerID());
        return new RoomLOLRacerScoreState.DidUpdatePlayers(3, selectRacer);
    }
}