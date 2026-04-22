package im.session.service;

import im.session.model.IMSessionPartialPage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMMessageSummaryService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMMessageSummaryServiceKt", f = "IMMessageSummaryService.kt", i = {0, 0}, l = {259}, m = "collectFirstSummary", n = {"$this$collectFirstSummary", "partialData"}, s = {"L$0", "L$1"}, v = 1)
public final class IMMessageSummaryServiceKt$collectFirstSummary$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMMessageSummaryServiceKt$collectFirstSummary$2(Continuation<? super IMMessageSummaryServiceKt$collectFirstSummary$2> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return IMMessageSummaryServiceKt.collectFirstSummary((IMSummaryCacheService) null, (IMSessionPartialPage) null, (Continuation) this);
    }
}