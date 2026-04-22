package kotlinx.atomicfu;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraceFormat.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u001aF\u0010\u0000\u001a\u00020\u000128\b\u0004\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"TraceFormat", "Lkotlinx/atomicfu/TraceFormat;", "format", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "", "event", "", "atomicfu"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TraceFormatKt {
    private static final TraceFormat TraceFormat(final Function2<? super Integer, Object, String> format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return new TraceFormat() { // from class: kotlinx.atomicfu.TraceFormatKt$TraceFormat$1
            @Override // kotlinx.atomicfu.TraceFormat
            public String format(int index, Object event) {
                Intrinsics.checkNotNullParameter(event, "event");
                return format.invoke(Integer.valueOf(index), event);
            }
        };
    }
}