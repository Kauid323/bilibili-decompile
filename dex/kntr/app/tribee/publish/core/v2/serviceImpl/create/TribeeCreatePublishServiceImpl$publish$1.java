package kntr.app.tribee.publish.core.v2.serviceImpl.create;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeCreatePublishServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.core.v2.serviceImpl.create.TribeeCreatePublishServiceImpl", f = "TribeeCreatePublishServiceImpl.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {42, ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH, 58}, m = "publish-gIAlu-s", n = {"content", "moss", "content", "moss", "req", "$this$publish_gIAlu_s_u24lambda_u240", "$i$a$-runCatching-TribeeCreatePublishServiceImpl$publish$2", "content", "moss", "req", "$this$publish_gIAlu_s_u24lambda_u240", "result", "$i$a$-runCatching-TribeeCreatePublishServiceImpl$publish$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
public final class TribeeCreatePublishServiceImpl$publish$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TribeeCreatePublishServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeCreatePublishServiceImpl$publish$1(TribeeCreatePublishServiceImpl tribeeCreatePublishServiceImpl, Continuation<? super TribeeCreatePublishServiceImpl$publish$1> continuation) {
        super(continuation);
        this.this$0 = tribeeCreatePublishServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo881publishgIAlus = this.this$0.mo881publishgIAlus(null, (Continuation) this);
        return mo881publishgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo881publishgIAlus : Result.m2635boximpl(mo881publishgIAlus);
    }
}