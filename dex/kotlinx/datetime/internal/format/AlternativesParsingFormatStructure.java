package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;

/* compiled from: FormatStructure.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkotlinx/datetime/internal/format/AlternativesParsingFormatStructure;", "T", "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "mainFormat", "Lkotlinx/datetime/internal/format/FormatStructure;", "formats", "", "(Lkotlinx/datetime/internal/format/FormatStructure;Ljava/util/List;)V", "getFormats", "()Ljava/util/List;", "getMainFormat", "()Lkotlinx/datetime/internal/format/FormatStructure;", "equals", "", "other", "", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "hashCode", "", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "toString", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AlternativesParsingFormatStructure<T> implements NonConcatenatedFormatStructure<T> {
    private final List<FormatStructure<T>> formats;
    private final FormatStructure<T> mainFormat;

    /* JADX WARN: Multi-variable type inference failed */
    public AlternativesParsingFormatStructure(FormatStructure<? super T> mainFormat, List<? extends FormatStructure<? super T>> formats) {
        Intrinsics.checkNotNullParameter(mainFormat, "mainFormat");
        Intrinsics.checkNotNullParameter(formats, "formats");
        this.mainFormat = mainFormat;
        this.formats = formats;
    }

    public final FormatStructure<T> getMainFormat() {
        return this.mainFormat;
    }

    public final List<FormatStructure<T>> getFormats() {
        return this.formats;
    }

    public String toString() {
        return "AlternativesParsing(" + this.formats + ')';
    }

    public boolean equals(Object other) {
        return (other instanceof AlternativesParsingFormatStructure) && Intrinsics.areEqual(this.mainFormat, ((AlternativesParsingFormatStructure) other).mainFormat) && Intrinsics.areEqual(this.formats, ((AlternativesParsingFormatStructure) other).formats);
    }

    public int hashCode() {
        return (this.mainFormat.hashCode() * 31) + this.formats.hashCode();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public ParserStructure<T> parser() {
        List emptyList = CollectionsKt.emptyList();
        List $this$parser_u24lambda_u240 = CollectionsKt.createListBuilder();
        $this$parser_u24lambda_u240.add(this.mainFormat.parser());
        for (FormatStructure format : this.formats) {
            $this$parser_u24lambda_u240.add(format.parser());
        }
        return new ParserStructure<>(emptyList, CollectionsKt.build($this$parser_u24lambda_u240));
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public FormatterStructure<T> formatter() {
        return this.mainFormat.formatter();
    }
}