package kntr.app.ad.domain.report.internal.scheduler;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadRunnable.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.scheduler.UploadRunnable", f = "UploadRunnable.kt", i = {1, 1, 1, 1, 1, 1, 2}, l = {AdditionVote2.VOTE_OWNER_MID_FIELD_NUMBER, 30, 34}, m = "run$report_debug", n = {"dataList", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-UploadRunnable$run$2", "dataList"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "L$0"}, v = 1)
public final class UploadRunnable$run$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadRunnable this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadRunnable$run$1(UploadRunnable uploadRunnable, Continuation<? super UploadRunnable$run$1> continuation) {
        super(continuation);
        this.this$0 = uploadRunnable;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run$report_debug((Continuation) this);
    }
}