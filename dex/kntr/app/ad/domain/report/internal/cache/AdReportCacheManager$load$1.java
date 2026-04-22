package kntr.app.ad.domain.report.internal.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdReportCacheManager.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.cache.AdReportCacheManager", f = "AdReportCacheManager.kt", i = {0, 1}, l = {35, 46}, m = "load", n = {"isFromStartUp", "isFromStartUp"}, s = {"Z$0", "Z$0"}, v = 1)
public final class AdReportCacheManager$load$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdReportCacheManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdReportCacheManager$load$1(AdReportCacheManager adReportCacheManager, Continuation<? super AdReportCacheManager$load$1> continuation) {
        super(continuation);
        this.this$0 = adReportCacheManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.load(false, (Continuation) this);
    }
}