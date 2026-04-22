package im.session.service;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMMessageSummaryService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSummaryCacheService", f = "IMMessageSummaryService.kt", i = {0}, l = {TbsListener.ErrorCode.UNZIP_IO_ERROR}, m = "markAsRead", n = {"card"}, s = {"L$0"}, v = 1)
public final class IMSummaryCacheService$markAsRead$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSummaryCacheService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSummaryCacheService$markAsRead$1(IMSummaryCacheService iMSummaryCacheService, Continuation<? super IMSummaryCacheService$markAsRead$1> continuation) {
        super(continuation);
        this.this$0 = iMSummaryCacheService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.markAsRead(null, (Continuation) this);
    }
}