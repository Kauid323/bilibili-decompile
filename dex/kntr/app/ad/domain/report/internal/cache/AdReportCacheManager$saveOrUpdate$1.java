package kntr.app.ad.domain.report.internal.cache;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdReportCacheManager.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.cache.AdReportCacheManager", f = "AdReportCacheManager.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {AdditionVote2.IS_VOTED_FIELD_NUMBER, AdditionVote2.DEFAULE_SELECT_SHARE_FIELD_NUMBER, 23}, m = "saveOrUpdate", n = {"record", "key", "retryCount", "record", "key", "retryCount", "record", "key", "retryCount"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 1)
public final class AdReportCacheManager$saveOrUpdate$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdReportCacheManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdReportCacheManager$saveOrUpdate$1(AdReportCacheManager adReportCacheManager, Continuation<? super AdReportCacheManager$saveOrUpdate$1> continuation) {
        super(continuation);
        this.this$0 = adReportCacheManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.saveOrUpdate(null, (Continuation) this);
    }
}