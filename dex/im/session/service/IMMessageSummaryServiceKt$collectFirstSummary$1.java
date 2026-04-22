package im.session.service;

import im.session.model.IMSessionPageData;
import im.setting.UtilsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMMessageSummaryService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMMessageSummaryServiceKt", f = "IMMessageSummaryService.kt", i = {0, 0}, l = {252}, m = "collectFirstSummary", n = {"$this$collectFirstSummary", UtilsKt.DATA_KEY}, s = {"L$0", "L$1"}, v = 1)
public final class IMMessageSummaryServiceKt$collectFirstSummary$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMMessageSummaryServiceKt$collectFirstSummary$1(Continuation<? super IMMessageSummaryServiceKt$collectFirstSummary$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return IMMessageSummaryServiceKt.collectFirstSummary((IMSummaryCacheService) null, (IMSessionPageData) null, (Continuation) this);
    }
}