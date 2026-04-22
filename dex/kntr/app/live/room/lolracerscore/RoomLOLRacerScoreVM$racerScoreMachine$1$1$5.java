package kntr.app.live.room.lolracerscore;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.HashMap;
import kntr.app.live.room.lolracerscore.RoomLOLRacerScoreEvent;
import kntr.app.live.room.lolracerscore.RoomLOLRacerScoreState;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoomLOLRacerScoreVM.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreState;", "event", "Lkntr/app/live/room/lolracerscore/RoomLOLRacerScoreEvent$PostRacerScore;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$racerScoreMachine$1$1$5", f = "RoomLOLRacerScoreVM.kt", i = {0, 0}, l = {271}, m = "invokeSuspend", n = {"event", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class RoomLOLRacerScoreVM$racerScoreMachine$1$1$5 extends SuspendLambda implements Function3<RoomLOLRacerScoreEvent.PostRacerScore, State<RoomLOLRacerScoreState>, Continuation<? super ChangedState<? extends RoomLOLRacerScoreState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ RoomLOLRacerScoreVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomLOLRacerScoreVM$racerScoreMachine$1$1$5(RoomLOLRacerScoreVM roomLOLRacerScoreVM, Continuation<? super RoomLOLRacerScoreVM$racerScoreMachine$1$1$5> continuation) {
        super(3, continuation);
        this.this$0 = roomLOLRacerScoreVM;
    }

    public final Object invoke(RoomLOLRacerScoreEvent.PostRacerScore postRacerScore, State<RoomLOLRacerScoreState> state, Continuation<? super ChangedState<? extends RoomLOLRacerScoreState>> continuation) {
        RoomLOLRacerScoreVM$racerScoreMachine$1$1$5 roomLOLRacerScoreVM$racerScoreMachine$1$1$5 = new RoomLOLRacerScoreVM$racerScoreMachine$1$1$5(this.this$0, continuation);
        roomLOLRacerScoreVM$racerScoreMachine$1$1$5.L$0 = postRacerScore;
        roomLOLRacerScoreVM$racerScoreMachine$1$1$5.L$1 = state;
        return roomLOLRacerScoreVM$racerScoreMachine$1$1$5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        HashMap hashMap;
        Object postRacerSingleScore;
        final RoomLOLRacerScoreEvent.PostRacerScore event = (RoomLOLRacerScoreEvent.PostRacerScore) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d("LIVE_ROOM_LOL_RACER_SCORE", "PostRacerScore: " + event);
                hashMap = this.this$0.scoreMap;
                hashMap.put(Boxing.boxLong(event.getRacerID()), Boxing.boxInt(event.getScore()));
                this.L$0 = event;
                this.L$1 = state;
                this.label = 1;
                postRacerSingleScore = this.this$0.postRacerSingleScore(event.getCid(), event.getRacerID(), event.getUid(), event.getScore(), event.getBo(), (Continuation) this);
                if (postRacerSingleScore == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                postRacerSingleScore = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final boolean it = ((Boolean) postRacerSingleScore).booleanValue();
        return state.override(new Function1() { // from class: kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM$racerScoreMachine$1$1$5$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                RoomLOLRacerScoreState.DidPostRacerScore invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = RoomLOLRacerScoreVM$racerScoreMachine$1$1$5.invokeSuspend$lambda$0$0(it, event, (RoomLOLRacerScoreState) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomLOLRacerScoreState.DidPostRacerScore invokeSuspend$lambda$0$0(boolean $it, RoomLOLRacerScoreEvent.PostRacerScore $event, RoomLOLRacerScoreState $this$override) {
        return new RoomLOLRacerScoreState.DidPostRacerScore($it, $event.getCid(), $event.getRacerID(), $event.getRacerName(), $event.getScore(), $event.getBo(), 1);
    }
}