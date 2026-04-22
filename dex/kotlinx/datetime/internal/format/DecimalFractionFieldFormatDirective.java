package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.formatter.DecimalFractionFormatterStructure;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.FractionPartConsumer;
import kotlinx.datetime.internal.format.parser.NumberSpanParserOperation;
import kotlinx.datetime.internal.format.parser.ParserStructure;

/* compiled from: FieldFormatDirective.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B7\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/internal/format/DecimalFractionFieldFormatDirective;", "Target", "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "field", "Lkotlinx/datetime/internal/format/FieldSpec;", "Lkotlinx/datetime/internal/DecimalFraction;", "minDigits", "", "maxDigits", "zerosToAdd", "", "(Lkotlinx/datetime/internal/format/FieldSpec;IILjava/util/List;)V", "getField", "()Lkotlinx/datetime/internal/format/FieldSpec;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DecimalFractionFieldFormatDirective<Target> implements FieldFormatDirective<Target> {
    private final FieldSpec<Target, DecimalFraction> field;
    private final int maxDigits;
    private final int minDigits;
    private final List<Integer> zerosToAdd;

    /* JADX WARN: Multi-variable type inference failed */
    public DecimalFractionFieldFormatDirective(FieldSpec<? super Target, DecimalFraction> field, int minDigits, int maxDigits, List<Integer> zerosToAdd) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(zerosToAdd, "zerosToAdd");
        this.field = field;
        this.minDigits = minDigits;
        this.maxDigits = maxDigits;
        this.zerosToAdd = zerosToAdd;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FieldSpec<Target, DecimalFraction> getField() {
        return this.field;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public FormatterStructure<Target> formatter() {
        return new DecimalFractionFormatterStructure(new DecimalFractionFieldFormatDirective$formatter$1(this.field.getAccessor()), this.minDigits, this.maxDigits, this.zerosToAdd);
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public ParserStructure<Target> parser() {
        return new ParserStructure<>(CollectionsKt.listOf(new NumberSpanParserOperation(CollectionsKt.listOf(new FractionPartConsumer(this.minDigits, this.maxDigits, this.field.getAccessor(), this.field.getName())))), CollectionsKt.emptyList());
    }
}