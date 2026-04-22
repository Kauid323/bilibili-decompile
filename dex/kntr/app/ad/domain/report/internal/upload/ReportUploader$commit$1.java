package kntr.app.ad.domain.report.internal.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReportUploader.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.upload.ReportUploader", f = "ReportUploader.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {172, 173}, m = "commit$report_debug", n = {"requestAction", "successAction", "failureAction", "request", "$this$request$iv", "builder$iv", "$i$f$request", "requestAction", "successAction", "failureAction", "request", "response", "$this$body$iv", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 1)
public final class ReportUploader$commit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReportUploader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportUploader$commit$1(ReportUploader reportUploader, Continuation<? super ReportUploader$commit$1> continuation) {
        super(continuation);
        this.this$0 = reportUploader;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.commit$report_debug(null, null, null, (Continuation) this);
    }
}