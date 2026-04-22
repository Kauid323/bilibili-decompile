package kntr.app.live.room.lolracerscore;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoomLOLRacerScoreVM.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM", f = "RoomLOLRacerScoreVM.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {471, 472, 353}, m = "getLplPlayers", n = {"urlStr", "$this$get_u24default$iv", "urlString$iv", "$this$get$iv$iv", "$this$get$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "urlStr", "httpResponse", "$this$body$iv", "$i$f$body", "urlStr", "httpResponse", "response", "teamBlue", "teamRed", "teamBluePlayers", "teamRedPlayers"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 1)
public final class RoomLOLRacerScoreVM$getLplPlayers$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomLOLRacerScoreVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomLOLRacerScoreVM$getLplPlayers$1(RoomLOLRacerScoreVM roomLOLRacerScoreVM, Continuation<? super RoomLOLRacerScoreVM$getLplPlayers$1> continuation) {
        super(continuation);
        this.this$0 = roomLOLRacerScoreVM;
    }

    public final Object invokeSuspend(Object obj) {
        Object lplPlayers;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        lplPlayers = this.this$0.getLplPlayers((Continuation) this);
        return lplPlayers;
    }
}