package kntr.app.live.room.lolracerscore;

import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoomLOLRacerScoreVM.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM", f = "RoomLOLRacerScoreVM.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {467, 468}, m = "postRacerSingleScore", n = {"urlStr", "$this$post$iv", "urlString$iv", "$this$post$iv$iv", "$this$post$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", AdAlarmExtraKey.CID, "racerID", "uid", "score", "bo", "$i$f$post", "$i$f$post", "$i$f$post", "$i$f$request", "urlStr", "httpResponse", "$this$body$iv", AdAlarmExtraKey.CID, "racerID", "uid", "score", "bo", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "J$1", "J$2", "I$0", "J$3", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "I$0", "J$3", "I$1"}, v = 1)
public final class RoomLOLRacerScoreVM$postRacerSingleScore$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    long J$0;
    long J$1;
    long J$2;
    long J$3;
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
    public RoomLOLRacerScoreVM$postRacerSingleScore$1(RoomLOLRacerScoreVM roomLOLRacerScoreVM, Continuation<? super RoomLOLRacerScoreVM$postRacerSingleScore$1> continuation) {
        super(continuation);
        this.this$0 = roomLOLRacerScoreVM;
    }

    public final Object invokeSuspend(Object obj) {
        Object postRacerSingleScore;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        postRacerSingleScore = this.this$0.postRacerSingleScore(0L, 0L, 0L, 0, 0L, (Continuation) this);
        return postRacerSingleScore;
    }
}