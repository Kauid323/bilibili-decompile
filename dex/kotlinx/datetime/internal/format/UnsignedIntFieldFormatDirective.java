package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.SpacePaddedFormatter;
import kotlinx.datetime.internal.format.formatter.UnsignedIntFormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserOperationKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;

/* compiled from: FieldFormatDirective.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/internal/format/UnsignedIntFieldFormatDirective;", "Target", "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "field", "Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "minDigits", "", "spacePadding", "(Lkotlinx/datetime/internal/format/UnsignedFieldSpec;ILjava/lang/Integer;)V", "getField", "()Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "maxDigits", "Ljava/lang/Integer;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class UnsignedIntFieldFormatDirective<Target> implements FieldFormatDirective<Target> {
    private final UnsignedFieldSpec<Target> field;
    private final int maxDigits;
    private final int minDigits;
    private final Integer spacePadding;

    /* JADX WARN: Multi-variable type inference failed */
    public UnsignedIntFieldFormatDirective(UnsignedFieldSpec<? super Target> field, int minDigits, Integer spacePadding) {
        Intrinsics.checkNotNullParameter(field, "field");
        this.field = field;
        this.minDigits = minDigits;
        this.spacePadding = spacePadding;
        this.maxDigits = this.field.getMaxDigits();
        if (!(this.minDigits >= 0)) {
            throw new IllegalArgumentException(("The minimum number of digits (" + this.minDigits + ") is negative").toString());
        }
        if (!(this.maxDigits >= this.minDigits)) {
            throw new IllegalArgumentException(("The maximum number of digits (" + this.maxDigits + ") is less than the minimum number of digits (" + this.minDigits + ')').toString());
        }
        if (this.spacePadding == null) {
            return;
        }
        if (this.spacePadding.intValue() > this.minDigits) {
            return;
        }
        throw new IllegalArgumentException(("The space padding (" + this.spacePadding + ") should be more than the minimum number of digits (" + this.minDigits + ')').toString());
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public /* bridge */ /* synthetic */ FieldSpec getField() {
        return this.field;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final UnsignedFieldSpec<Target> getField() {
        return this.field;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public FormatterStructure<Target> formatter() {
        UnsignedIntFormatterStructure formatter = new UnsignedIntFormatterStructure(new UnsignedIntFieldFormatDirective$formatter$formatter$1(this.field.getAccessor()), this.minDigits);
        return this.spacePadding != null ? new SpacePaddedFormatter(formatter, this.spacePadding.intValue()) : formatter;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public ParserStructure<Target> parser() {
        return ParserOperationKt.spaceAndZeroPaddedUnsignedInt$default(Integer.valueOf(this.minDigits), Integer.valueOf(this.maxDigits), this.spacePadding, this.field.getAccessor(), this.field.getName(), false, 32, null);
    }
}