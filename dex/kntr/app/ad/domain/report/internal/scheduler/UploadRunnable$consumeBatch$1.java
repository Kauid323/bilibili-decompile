package kntr.app.ad.domain.report.internal.scheduler;

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
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.scheduler.UploadRunnable", f = "UploadRunnable.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {42, 46, 49}, m = "consumeBatch", n = {"data", "needRetry", "data", "needRetry", AdAlarmExtraKey.STATUS, "data", "needRetry", AdAlarmExtraKey.STATUS}, s = {"L$0", "Z$0", "L$0", "Z$0", "Z$1", "L$0", "Z$0", "Z$1"}, v = 1)
public final class UploadRunnable$consumeBatch$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadRunnable this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadRunnable$consumeBatch$1(UploadRunnable uploadRunnable, Continuation<? super UploadRunnable$consumeBatch$1> continuation) {
        super(continuation);
        this.this$0 = uploadRunnable;
    }

    public final Object invokeSuspend(Object obj) {
        Object consumeBatch;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        consumeBatch = this.this$0.consumeBatch((ReportRecord) null, false, (Continuation<? super Unit>) this);
        return consumeBatch;
    }
}