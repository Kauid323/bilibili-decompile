package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.SignedIntFormatterStructure;
import kotlinx.datetime.internal.format.formatter.SpacePaddedFormatter;
import kotlinx.datetime.internal.format.parser.ParserOperationKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;

/* compiled from: FieldFormatDirective.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002BA\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/internal/format/SignedIntFieldFormatDirective;", "Target", "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "field", "Lkotlinx/datetime/internal/format/FieldSpec;", "", "minDigits", "maxDigits", "spacePadding", "outputPlusOnExceededWidth", "(Lkotlinx/datetime/internal/format/FieldSpec;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getField", "()Lkotlinx/datetime/internal/format/FieldSpec;", "Ljava/lang/Integer;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class SignedIntFieldFormatDirective<Target> implements FieldFormatDirective<Target> {
    private final FieldSpec<Target, Integer> field;
    private final Integer maxDigits;
    private final Integer minDigits;
    private final Integer outputPlusOnExceededWidth;
    private final Integer spacePadding;

    /* JADX WARN: Multi-variable type inference failed */
    public SignedIntFieldFormatDirective(FieldSpec<? super Target, Integer> field, Integer minDigits, Integer maxDigits, Integer spacePadding, Integer outputPlusOnExceededWidth) {
        Intrinsics.checkNotNullParameter(field, "field");
        this.field = field;
        this.minDigits = minDigits;
        this.maxDigits = maxDigits;
        this.spacePadding = spacePadding;
        this.outputPlusOnExceededWidth = outputPlusOnExceededWidth;
        boolean z = false;
        if (!(this.minDigits == null || this.minDigits.intValue() >= 0)) {
            throw new IllegalArgumentException(("The minimum number of digits (" + this.minDigits + ") is negative").toString());
        }
        if ((this.maxDigits == null || this.minDigits == null || this.maxDigits.intValue() >= this.minDigits.intValue()) ? true : z) {
            return;
        }
        throw new IllegalArgumentException(("The maximum number of digits (" + this.maxDigits + ") is less than the minimum number of digits (" + this.minDigits + ')').toString());
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FieldSpec<Target, Integer> getField() {
        return this.field;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public FormatterStructure<Target> formatter() {
        SignedIntFieldFormatDirective$formatter$formatter$1 signedIntFieldFormatDirective$formatter$formatter$1 = new SignedIntFieldFormatDirective$formatter$formatter$1(this.field.getAccessor());
        Integer num = this.minDigits;
        SignedIntFormatterStructure formatter = new SignedIntFormatterStructure(signedIntFieldFormatDirective$formatter$formatter$1, num != null ? num.intValue() : 0, this.outputPlusOnExceededWidth);
        return this.spacePadding != null ? new SpacePaddedFormatter(formatter, this.spacePadding.intValue()) : formatter;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public ParserStructure<Target> parser() {
        return ParserOperationKt.SignedIntParser(this.minDigits, this.maxDigits, this.spacePadding, this.field.getAccessor(), this.field.getName(), this.outputPlusOnExceededWidth);
    }
}