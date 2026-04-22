package kntr.app.ad.domain.report.internal.cache.local;

import kntr.app.ad.domain.report.internal.ReportRecord;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdReportFileStorageCache.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.cache.local.AdReportFileStorageCache", f = "AdReportFileStorageCache.kt", i = {0, 0, 0}, l = {244}, m = "deleteLocalStorage", n = {"value", "$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class AdReportFileStorageCache$deleteLocalStorage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdReportFileStorageCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdReportFileStorageCache$deleteLocalStorage$1(AdReportFileStorageCache adReportFileStorageCache, Continuation<? super AdReportFileStorageCache$deleteLocalStorage$1> continuation) {
        super(continuation);
        this.this$0 = adReportFileStorageCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deleteLocalStorage2((ReportRecord) null, (Continuation) this);
    }
}