package kntr.app.live.room.lolracerscore;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import java.util.ListIterator;
import kntr.app.live.room.lolracerscore.RoomLOLRacerScoreEvent;
import kntr.app.live.room.lolracerscore.RoomLOLRacerScoreState;
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
/* compiled from: RoomLOLRacerScoreVM.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState;", "event", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$ScoreToPlayer;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$racerScoreMachine$1$1$3", f = "RoomLOLRacerScoreVM.kt", i = {0, 0, 0}, l = {225}, m = "invokeSuspend", n = {"event", "state", "selectedOne"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class RoomLOLRacerScoreVM$racerScoreMachine$1$1$3 extends SuspendLambda implements Function3<RoomLOLRacerScoreEvent.ScoreToPlayer, State<RoomLOLRacerScoreState>, Continuation<? super ChangedState<? extends RoomLOLRacerScoreState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RoomLOLRacerScoreVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomLOLRacerScoreVM$racerScoreMachine$1$1$3(RoomLOLRacerScoreVM roomLOLRacerScoreVM, Continuation<? super RoomLOLRacerScoreVM$racerScoreMachine$1$1$3> continuation) {
        super(3, continuation);
        this.this$0 = roomLOLRacerScoreVM;
    }

    public final Object invoke(RoomLOLRacerScoreEvent.ScoreToPlayer scoreToPlayer, State<RoomLOLRacerScoreState> state, Continuation<? super ChangedState<? extends RoomLOLRacerScoreState>> continuation) {
        RoomLOLRacerScoreVM$racerScoreMachine$1$1$3 roomLOLRacerScoreVM$racerScoreMachine$1$1$3 = new RoomLOLRacerScoreVM$racerScoreMachine$1$1$3(this.this$0, continuation);
        roomLOLRacerScoreVM$racerScoreMachine$1$1$3.L$0 = scoreToPlayer;
        roomLOLRacerScoreVM$racerScoreMachine$1$1$3.L$1 = state;
        return roomLOLRacerScoreVM$racerScoreMachine$1$1$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List list;
        boolean z;
        Object obj;
        Object postRacerSingleScore;
        LiveRacerScoreDataModel selectedOne;
        LiveRacerScoreDataModel it;
        final int res;
        RoomLOLRacerScoreEvent.ScoreToPlayer event = (RoomLOLRacerScoreEvent.ScoreToPlayer) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d("LIVE_ROOM_LOL_RACER_SCORE", "ScoreToPlayer: " + event);
                list = this.this$0.dataModel;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    z = false;
                    if (listIterator.hasPrevious()) {
                        obj = listIterator.previous();
                        LiveRacerScoreDataModel it2 = (LiveRacerScoreDataModel) obj;
                        if (it2.getRacerID() == event.getRacerID()) {
                            it = 1;
                            continue;
                        } else {
                            it = null;
                            continue;
                        }
                        if (it != null) {
                        }
                    } else {
                        obj = null;
                    }
                }
                LiveRacerScoreDataModel selectedOne2 = (LiveRacerScoreDataModel) obj;
                if (selectedOne2 != null && selectedOne2.isSelected()) {
                    z = true;
                }
                if (!z) {
                    final RoomLOLRacerScoreVM roomLOLRacerScoreVM = this.this$0;
                    return state.override(new Function1() { // from class: kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$racerScoreMachine$1$1$3$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            RoomLOLRacerScoreState.DidUpdatePlayers invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = RoomLOLRacerScoreVM$racerScoreMachine$1$1$3.invokeSuspend$lambda$1(RoomLOLRacerScoreVM.this, (RoomLOLRacerScoreState) obj2);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
                selectedOne2.setUserGrade(String.valueOf(event.getScore()));
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(selectedOne2);
                this.label = 1;
                postRacerSingleScore = this.this$0.postRacerSingleScore(selectedOne2.getCid(), selectedOne2.getRacerID(), -1L, event.getScore(), selectedOne2.getBo(), (Continuation) this);
                if (postRacerSingleScore == coroutine_suspended) {
                    return coroutine_suspended;
                }
                selectedOne = selectedOne2;
                break;
            case 1:
                selectedOne = (LiveRacerScoreDataModel) this.L$2;
                ResultKt.throwOnFailure($result);
                postRacerSingleScore = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) postRacerSingleScore).booleanValue()) {
            res = 8;
        } else {
            res = 10;
        }
        final RoomLOLRacerScoreVM roomLOLRacerScoreVM2 = this.this$0;
        return state.override(new Function1() { // from class: kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$racerScoreMachine$1$1$3$$ExternalSyntheticLambda1
            public final Object invoke(Object obj2) {
                RoomLOLRacerScoreState.DidUpdatePlayers invokeSuspend$lambda$2;
                invokeSuspend$lambda$2 = RoomLOLRacerScoreVM$racerScoreMachine$1$1$3.invokeSuspend$lambda$2(res, roomLOLRacerScoreVM2, (RoomLOLRacerScoreState) obj2);
                return invokeSuspend$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomLOLRacerScoreState.DidUpdatePlayers invokeSuspend$lambda$1(RoomLOLRacerScoreVM this$0, RoomLOLRacerScoreState $this$override) {
        List list;
        list = this$0.dataModel;
        return new RoomLOLRacerScoreState.DidUpdatePlayers(4, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomLOLRacerScoreState.DidUpdatePlayers invokeSuspend$lambda$2(int $res, RoomLOLRacerScoreVM this$0, RoomLOLRacerScoreState $this$override) {
        List list;
        list = this$0.dataModel;
        return new RoomLOLRacerScoreState.DidUpdatePlayers($res, list);
    }
}