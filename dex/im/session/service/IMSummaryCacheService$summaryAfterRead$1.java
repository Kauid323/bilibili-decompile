package im.session.service;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMMessageSummaryService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSummaryCacheService", f = "IMMessageSummaryService.kt", i = {0}, l = {TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION}, m = "summaryAfterRead", n = {"card"}, s = {"L$0"}, v = 1)
public final class IMSummaryCacheService$summaryAfterRead$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSummaryCacheService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSummaryCacheService$summaryAfterRead$1(IMSummaryCacheService iMSummaryCacheService, Continuation<? super IMSummaryCacheService$summaryAfterRead$1> continuation) {
        super(continuation);
        this.this$0 = iMSummaryCacheService;
    }

    public final Object invokeSuspend(Object obj) {
        Object summaryAfterRead;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        summaryAfterRead = this.this$0.summaryAfterRead(null, (Continuation) this);
        return summaryAfterRead;
    }
}