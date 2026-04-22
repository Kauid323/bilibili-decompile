package kntr.common.ouro.common.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommonAtMentionServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.service.CommonAtMentionServiceImpl", f = "CommonAtMentionServiceImpl.kt", i = {0, 0, 0, 0}, l = {23}, m = "search-gIAlu-s", n = {"keyword", "req", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-CommonAtMentionServiceImpl$search$result$1"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
public final class CommonAtMentionServiceImpl$search$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonAtMentionServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonAtMentionServiceImpl$search$1(CommonAtMentionServiceImpl commonAtMentionServiceImpl, Continuation<? super CommonAtMentionServiceImpl$search$1> continuation) {
        super(continuation);
        this.this$0 = commonAtMentionServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1884searchgIAlus = this.this$0.mo1884searchgIAlus(null, (Continuation) this);
        return mo1884searchgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1884searchgIAlus : Result.m2635boximpl(mo1884searchgIAlus);
    }
}