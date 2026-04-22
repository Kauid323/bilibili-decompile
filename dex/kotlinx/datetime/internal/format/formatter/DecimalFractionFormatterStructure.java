package kotlinx.datetime.internal.format.formatter;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.MathKt;

/* compiled from: FormatterOperation.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B7\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlinx/datetime/internal/format/formatter/DecimalFractionFormatterStructure;", "T", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "number", "Lkotlin/Function1;", "Lkotlinx/datetime/internal/DecimalFraction;", "minDigits", "", "maxDigits", "zerosToAdd", "", "(Lkotlin/jvm/functions/Function1;IILjava/util/List;)V", "format", "", "obj", "builder", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "minusNotRequired", "", "(Ljava/lang/Object;Ljava/lang/Appendable;Z)V", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DecimalFractionFormatterStructure<T> implements FormatterStructure<T> {
    private final int maxDigits;
    private final int minDigits;
    private final Function1<T, DecimalFraction> number;
    private final List<Integer> zerosToAdd;

    /* JADX WARN: Multi-variable type inference failed */
    public DecimalFractionFormatterStructure(Function1<? super T, DecimalFraction> number, int minDigits, int maxDigits, List<Integer> zerosToAdd) {
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(zerosToAdd, "zerosToAdd");
        this.number = number;
        this.minDigits = minDigits;
        this.maxDigits = maxDigits;
        this.zerosToAdd = zerosToAdd;
        int i = this.minDigits;
        boolean z = false;
        if (!(1 <= i && i < 10)) {
            throw new IllegalArgumentException(("The minimum number of digits (" + this.minDigits + ") is not in range 1..9").toString());
        }
        int i2 = this.minDigits;
        int i3 = this.maxDigits;
        if (i2 <= i3 && i3 < 10) {
            z = true;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("The maximum number of digits (" + this.maxDigits + ") is not in range " + this.minDigits + "..9").toString());
    }

    @Override // kotlinx.datetime.internal.format.formatter.FormatterStructure
    public void format(T t, Appendable builder, boolean minusNotRequired) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        DecimalFraction number = this.number.invoke(t);
        int numberWithRequiredPrecision = number.fractionalPartWithNDigits(this.maxDigits);
        int zerosToStrip = 0;
        while (this.maxDigits > this.minDigits + zerosToStrip && numberWithRequiredPrecision % MathKt.getPOWERS_OF_TEN()[zerosToStrip + 1] == 0) {
            zerosToStrip++;
        }
        int zerosToAddBack = this.zerosToAdd.get((this.maxDigits - zerosToStrip) - 1).intValue();
        if (zerosToStrip >= zerosToAddBack) {
            zerosToStrip -= zerosToAddBack;
        }
        int digitsToOutput = this.maxDigits - zerosToStrip;
        int numberToOutput = numberWithRequiredPrecision / MathKt.getPOWERS_OF_TEN()[zerosToStrip];
        String substring = String.valueOf(MathKt.getPOWERS_OF_TEN()[digitsToOutput] + numberToOutput).substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        builder.append(substring);
    }
}