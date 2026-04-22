package kntr.app.ad.domain.report.internal.cache;

import kntr.app.ad.domain.report.internal.ReportRecord;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MemoryCache.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.cache.MemoryCache", f = "MemoryCache.kt", i = {0, 0, 0, 0}, l = {48}, m = "delete", n = {"key", "value", "$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class MemoryCache$delete$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemoryCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryCache$delete$1(MemoryCache memoryCache, Continuation<? super MemoryCache$delete$1> continuation) {
        super(continuation);
        this.this$0 = memoryCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.delete2((String) null, (ReportRecord) null, (Continuation) this);
    }
}