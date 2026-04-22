package kotlinx.atomicfu;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Trace.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lkotlinx/atomicfu/TraceFormatThread;", "Lkotlinx/atomicfu/TraceFormat;", "()V", "format", "", "index", "", "event", "", "atomicfu"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class TraceFormatThread extends TraceFormat {
    @Override // kotlinx.atomicfu.TraceFormat
    public String format(int index, Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return index + ": [" + Thread.currentThread().getName() + "] " + event;
    }
}