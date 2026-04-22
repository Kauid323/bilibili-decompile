package kntr.app.ad.domain.report.internal.scheduler;

import java.util.List;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadRunnable.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.scheduler.UploadRunnable", f = "UploadRunnable.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {57, 58, 61, 63}, m = "consumeBatch", n = {"dataList", "needRetry", "dataList", "$this$forEach$iv", "element$iv", "batch", "needRetry", "$i$f$forEach", "$i$a$-forEach-UploadRunnable$consumeBatch$3", "dataList", "$this$forEach$iv", "element$iv", "batch", "$this$forEach$iv", "element$iv", "data", "needRetry", "$i$f$forEach", "$i$a$-forEach-UploadRunnable$consumeBatch$3", AdAlarmExtraKey.STATUS, "$i$f$forEach", "$i$a$-forEach-UploadRunnable$consumeBatch$3$1", "dataList", "$this$forEach$iv", "element$iv", "batch", "$this$forEach$iv", "element$iv", "data", "needRetry", "$i$f$forEach", "$i$a$-forEach-UploadRunnable$consumeBatch$3", AdAlarmExtraKey.STATUS, "$i$f$forEach", "$i$a$-forEach-UploadRunnable$consumeBatch$3$1"}, s = {"L$0", "Z$0", "L$0", "L$1", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8", "Z$0", "I$0", "I$1", "Z$1", "I$2", "I$3", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8", "Z$0", "I$0", "I$1", "Z$1", "I$2", "I$3"}, v = 1)
public final class UploadRunnable$consumeBatch$2 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadRunnable this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadRunnable$consumeBatch$2(UploadRunnable uploadRunnable, Continuation<? super UploadRunnable$consumeBatch$2> continuation) {
        super(continuation);
        this.this$0 = uploadRunnable;
    }

    public final Object invokeSuspend(Object obj) {
        Object consumeBatch;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        consumeBatch = this.this$0.consumeBatch((List<ReportRecord>) null, false, (Continuation<? super Unit>) this);
        return consumeBatch;
    }
}