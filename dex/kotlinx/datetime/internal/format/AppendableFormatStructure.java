package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Builder.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "T", "", "()V", "list", "", "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "add", "", "format", "Lkotlinx/datetime/internal/format/FormatStructure;", "build", "Lkotlinx/datetime/internal/format/ConcatenatedFormatStructure;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppendableFormatStructure<T> {
    private final List<NonConcatenatedFormatStructure<T>> list = new ArrayList();

    public final ConcatenatedFormatStructure<T> build() {
        return new ConcatenatedFormatStructure<>(this.list);
    }

    public final void add(FormatStructure<? super T> format) {
        Intrinsics.checkNotNullParameter(format, "format");
        if (!(format instanceof NonConcatenatedFormatStructure)) {
            if (!(format instanceof ConcatenatedFormatStructure)) {
                return;
            }
            Iterable $this$forEach$iv = ((ConcatenatedFormatStructure) format).getFormats();
            for (Object element$iv : $this$forEach$iv) {
                NonConcatenatedFormatStructure it = (NonConcatenatedFormatStructure) element$iv;
                this.list.add(it);
            }
            return;
        }
        this.list.add(format);
    }
}