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
@DebugMetadata(c = "kntr.base.dd.impl.internal.update.UpdateEngine", f = "UpdateEngine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {117}, m = "fallback-0E7RQCE", n = {AppKey.VERSION, "env", "$this$fallback_0E7RQCE_u24lambda_u240", "dataType", "dataDir", "dataFilePath", "curl", "$i$a$-runCatching-UpdateEngine$fallback$2", "remoteV"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "J$0"}, v = 1)
public final class UpdateEngine$fallback$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateEngine$fallback$1(UpdateEngine updateEngine, Continuation<? super UpdateEngine$fallback$1> continuation) {
        super(continuation);
        this.this$0 = updateEngine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1364fallback0E7RQCE = this.this$0.mo1364fallback0E7RQCE(null, null, (Continuation) this);
        return mo1364fallback0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1364fallback0E7RQCE : Result.m2635boximpl(mo1364fallback0E7RQCE);
    }
}