package kotlinx.coroutines.rx3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxScheduler.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx3.RxSchedulerKt", f = "RxScheduler.kt", i = {0}, l = {126}, m = "scheduleTask$task", n = {"ctx"}, s = {"L$0"})
public final class RxSchedulerKt$scheduleTask$task$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxSchedulerKt$scheduleTask$task$1(Continuation<? super RxSchedulerKt$scheduleTask$task$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object scheduleTask$task;
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        scheduleTask$task = RxSchedulerKt.scheduleTask$task(null, null, null, this);
        return scheduleTask$task;
    }
}