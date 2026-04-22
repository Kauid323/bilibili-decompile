package kotlinx.atomicfu;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.TraceBase;

/* compiled from: Trace.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001c\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0001H\u0007\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a\u0012\u0010\f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\n\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000e"}, d2 = {"traceFormatDefault", "Lkotlinx/atomicfu/TraceFormat;", "getTraceFormatDefault", "()Lkotlinx/atomicfu/TraceFormat;", "Trace", "Lkotlinx/atomicfu/TraceBase;", "size", "", "format", "getSystemProperty", "", "key", "named", "name", "atomicfu"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TraceKt {
    private static final TraceFormat traceFormatDefault;

    public static /* synthetic */ TraceBase Trace$default(int i, TraceFormat traceFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 32;
        }
        if ((i2 & 2) != 0) {
            traceFormat = traceFormatDefault;
        }
        return Trace(i, traceFormat);
    }

    public static final TraceBase Trace(int size, TraceFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return new TraceImpl(size, format);
    }

    public static final TraceBase named(TraceBase $this$named, String name) {
        Intrinsics.checkNotNullParameter($this$named, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return $this$named == TraceBase.None.INSTANCE ? $this$named : new NamedTrace($this$named, name);
    }

    private static final String getSystemProperty(String key) {
        try {
            return System.getProperty(key);
        } catch (SecurityException e) {
            return null;
        }
    }

    public static final TraceFormat getTraceFormatDefault() {
        return traceFormatDefault;
    }

    static {
        traceFormatDefault = getSystemProperty("kotlinx.atomicfu.trace.thread") != null ? new TraceFormatThread() : new TraceFormat();
    }
}