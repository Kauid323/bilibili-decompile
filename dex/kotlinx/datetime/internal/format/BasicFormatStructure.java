package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;

/* compiled from: FormatStructure.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lkotlinx/datetime/internal/format/BasicFormatStructure;", "T", "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "directive", "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "(Lkotlinx/datetime/internal/format/FieldFormatDirective;)V", "getDirective", "()Lkotlinx/datetime/internal/format/FieldFormatDirective;", "equals", "", "other", "", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "hashCode", "", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "toString", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BasicFormatStructure<T> implements NonConcatenatedFormatStructure<T> {
    private final FieldFormatDirective<T> directive;

    /* JADX WARN: Multi-variable type inference failed */
    public BasicFormatStructure(FieldFormatDirective<? super T> directive) {
        Intrinsics.checkNotNullParameter(directive, "directive");
        this.directive = directive;
    }

    public final FieldFormatDirective<T> getDirective() {
        return this.directive;
    }

    public String toString() {
        return "BasicFormatStructure(" + this.directive + ')';
    }

    public boolean equals(Object other) {
        return (other instanceof BasicFormatStructure) && Intrinsics.areEqual(this.directive, ((BasicFormatStructure) other).directive);
    }

    public int hashCode() {
        return this.directive.hashCode();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public ParserStructure<T> parser() {
        return this.directive.parser();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public FormatterStructure<T> formatter() {
        return this.directive.formatter();
    }
}