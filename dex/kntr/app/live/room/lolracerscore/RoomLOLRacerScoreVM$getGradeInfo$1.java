package kntr.app.live.room.lolracerscore;

import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoomLOLRacerScoreVM.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.lolracerscore.RoomLOLRacerScoreVM", f = "RoomLOLRacerScoreVM.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {467, 468}, m = "getGradeInfo", n = {"urlStr", "$this$get$iv", "urlString$iv", "$this$get$iv$iv", "$this$get$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", AdAlarmExtraKey.CID, "bo", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "urlStr", "httpResponse", "$this$body$iv", AdAlarmExtraKey.CID, "bo", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "J$1", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "J$0", "J$1", "I$0"}, v = 1)
public final class RoomLOLRacerScoreVM$getGradeInfo$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    long J$1;
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
    public RoomLOLRacerScoreVM$getGradeInfo$1(RoomLOLRacerScoreVM roomLOLRacerScoreVM, Continuation<? super RoomLOLRacerScoreVM$getGradeInfo$1> continuation) {
        super(continuation);
        this.this$0 = roomLOLRacerScoreVM;
    }

    public final Object invokeSuspend(Object obj) {
        Object gradeInfo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        gradeInfo = this.this$0.getGradeInfo(0L, 0L, (Continuation) this);
        return gradeInfo;
    }
}