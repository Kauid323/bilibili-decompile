package kntr.app.ad.domain.report.internal.cache.local;

import kntr.app.ad.domain.report.internal.ReportRecord;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdReportFileStorageCache.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache", f = "AdReportFileStorageCache.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {40, 244}, m = "saveOrUpdateToLocalStorage", n = {"key", "value", "retryCount", "key", "value", "$this$withLock_u24default$iv", "retryCount", "$i$f$withLock"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
public final class AdReportFileStorageCache$saveOrUpdateToLocalStorage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdReportFileStorageCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdReportFileStorageCache$saveOrUpdateToLocalStorage$1(AdReportFileStorageCache adReportFileStorageCache, Continuation<? super AdReportFileStorageCache$saveOrUpdateToLocalStorage$1> continuation) {
        super(continuation);
        this.this$0 = adReportFileStorageCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.saveOrUpdateToLocalStorage2((String) null, (ReportRecord) null, (Continuation) this);
    }
}