package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.ConcatenatedFormatter;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;

/* compiled from: FormatStructure.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lkotlinx/datetime/internal/format/ConcatenatedFormatStructure;", "T", "Lkotlinx/datetime/internal/format/FormatStructure;", "formats", "", "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "(Ljava/util/List;)V", "getFormats", "()Ljava/util/List;", "equals", "", "other", "", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "hashCode", "", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "toString", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ConcatenatedFormatStructure<T> implements FormatStructure<T> {
    private final List<NonConcatenatedFormatStructure<T>> formats;

    /* JADX WARN: Multi-variable type inference failed */
    public ConcatenatedFormatStructure(List<? extends NonConcatenatedFormatStructure<? super T>> formats) {
        Intrinsics.checkNotNullParameter(formats, "formats");
        this.formats = formats;
    }

    public final List<NonConcatenatedFormatStructure<T>> getFormats() {
        return this.formats;
    }

    public String toString() {
        return "ConcatenatedFormatStructure(" + CollectionsKt.joinToString$default(this.formats, ", ", null, null, 0, null, null, 62, null) + ')';
    }

    public boolean equals(Object other) {
        return (other instanceof ConcatenatedFormatStructure) && Intrinsics.areEqual(this.formats, ((ConcatenatedFormatStructure) other).formats);
    }

    public int hashCode() {
        return this.formats.hashCode();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public ParserStructure<T> parser() {
        Iterable $this$map$iv = this.formats;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            NonConcatenatedFormatStructure it = (NonConcatenatedFormatStructure) item$iv$iv;
            destination$iv$iv.add(it.parser());
        }
        return ParserKt.concat((List) destination$iv$iv);
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public FormatterStructure<T> formatter() {
        Iterable $this$map$iv = this.formats;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            NonConcatenatedFormatStructure it = (NonConcatenatedFormatStructure) item$iv$iv;
            destination$iv$iv.add(it.formatter());
        }
        List formatters = (List) destination$iv$iv;
        if (formatters.size() != 1) {
            return new ConcatenatedFormatter(formatters);
        }
        return (FormatterStructure) CollectionsKt.single((List<? extends Object>) formatters);
    }
}