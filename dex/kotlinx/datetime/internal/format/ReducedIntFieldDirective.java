package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.ReducedIntFormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserOperationKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;

/* compiled from: FieldFormatDirective.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B)\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/internal/format/ReducedIntFieldDirective;", "Target", "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "field", "Lkotlinx/datetime/internal/format/FieldSpec;", "", "digits", "base", "(Lkotlinx/datetime/internal/format/FieldSpec;II)V", "getField", "()Lkotlinx/datetime/internal/format/FieldSpec;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ReducedIntFieldDirective<Target> implements FieldFormatDirective<Target> {
    private final int base;
    private final int digits;
    private final FieldSpec<Target, Integer> field;

    /* JADX WARN: Multi-variable type inference failed */
    public ReducedIntFieldDirective(FieldSpec<? super Target, Integer> field, int digits, int base) {
        Intrinsics.checkNotNullParameter(field, "field");
        this.field = field;
        this.digits = digits;
        this.base = base;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FieldSpec<Target, Integer> getField() {
        return this.field;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public FormatterStructure<Target> formatter() {
        return new ReducedIntFormatterStructure(new ReducedIntFieldDirective$formatter$1(this.field.getAccessor()), this.digits, this.base);
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public ParserStructure<Target> parser() {
        return ParserOperationKt.ReducedIntParser(this.digits, this.base, this.field.getAccessor(), this.field.getName());
    }
}