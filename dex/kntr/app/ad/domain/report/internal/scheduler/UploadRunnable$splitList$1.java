package kntr.app.ad.domain.report.internal.scheduler;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadRunnable.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.scheduler.UploadRunnable", f = "UploadRunnable.kt", i = {0, 0, 0, 0}, l = {88}, m = "splitList", n = {"$this$splitList", "$this$withLock_u24default$iv", "pageSize", "$i$f$withLock"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
public final class UploadRunnable$splitList$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadRunnable this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadRunnable$splitList$1(UploadRunnable uploadRunnable, Continuation<? super UploadRunnable$splitList$1> continuation) {
        super(continuation);
        this.this$0 = uploadRunnable;
    }

    public final Object invokeSuspend(Object obj) {
        Object splitList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        splitList = this.this$0.splitList(null, 0, (Continuation) this);
        return splitList;
    }
}