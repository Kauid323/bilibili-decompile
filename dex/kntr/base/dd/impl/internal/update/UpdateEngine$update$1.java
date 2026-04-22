package kntr.base.dd.impl.internal.update;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateEngine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.update.UpdateEngine", f = "UpdateEngine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {62, 67}, m = "update-yxL6bBk", n = {"from", AppKey.VERSION, "env", "remoteV", "$this$update_yxL6bBk_u24lambda_u240", "force", "localV", "$i$a$-runCatching-UpdateEngine$update$2", "from", AppKey.VERSION, "env", "remoteV", "$this$update_yxL6bBk_u24lambda_u240", "info", "force", "localV", "$i$a$-runCatching-UpdateEngine$update$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "J$0", "I$0"}, v = 1)
public final class UpdateEngine$update$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateEngine$update$1(UpdateEngine updateEngine, Continuation<? super UpdateEngine$update$1> continuation) {
        super(continuation);
        this.this$0 = updateEngine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1365updateyxL6bBk = this.this$0.mo1365updateyxL6bBk(null, null, null, false, (Continuation) this);
        return mo1365updateyxL6bBk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1365updateyxL6bBk : Result.m2635boximpl(mo1365updateyxL6bBk);
    }
}