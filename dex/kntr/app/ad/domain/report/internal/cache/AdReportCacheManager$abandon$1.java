package kntr.app.ad.domain.report.internal.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdReportCacheManager.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.cache.AdReportCacheManager", f = "AdReportCacheManager.kt", i = {0, 0, 1, 1}, l = {28, 29}, m = "abandon", n = {"record", "key", "record", "key"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class AdReportCacheManager$abandon$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdReportCacheManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdReportCacheManager$abandon$1(AdReportCacheManager adReportCacheManager, Continuation<? super AdReportCacheManager$abandon$1> continuation) {
        super(continuation);
        this.this$0 = adReportCacheManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.abandon(null, (Continuation) this);
    }
}