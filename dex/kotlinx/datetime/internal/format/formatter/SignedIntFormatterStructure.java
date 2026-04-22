package kotlinx.datetime.internal.format.formatter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.MathKt;

/* compiled from: FormatterOperation.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B+\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ)\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/internal/format/formatter/SignedIntFormatterStructure;", "T", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "number", "Lkotlin/Function1;", "", "zeroPadding", "outputPlusOnExceededWidth", "(Lkotlin/jvm/functions/Function1;ILjava/lang/Integer;)V", "Ljava/lang/Integer;", "format", "", "obj", "builder", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "minusNotRequired", "", "(Ljava/lang/Object;Ljava/lang/Appendable;Z)V", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SignedIntFormatterStructure<T> implements FormatterStructure<T> {
    private final Function1<T, Integer> number;
    private final Integer outputPlusOnExceededWidth;
    private final int zeroPadding;

    /* JADX WARN: Multi-variable type inference failed */
    public SignedIntFormatterStructure(Function1<? super T, Integer> number, int zeroPadding, Integer outputPlusOnExceededWidth) {
        Intrinsics.checkNotNullParameter(number, "number");
        this.number = number;
        this.zeroPadding = zeroPadding;
        this.outputPlusOnExceededWidth = outputPlusOnExceededWidth;
        if (!(this.zeroPadding >= 0)) {
            throw new IllegalArgumentException(("The minimum number of digits (" + this.zeroPadding + ") is negative").toString());
        }
        if (this.zeroPadding <= 9) {
            return;
        }
        throw new IllegalArgumentException(("The minimum number of digits (" + this.zeroPadding + ") exceeds the length of an Int").toString());
    }

    @Override // kotlinx.datetime.internal.format.formatter.FormatterStructure
    public void format(T t, Appendable builder, boolean minusNotRequired) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        StringBuilder innerBuilder = new StringBuilder();
        int it = this.number.invoke(t).intValue();
        if (minusNotRequired && it < 0) {
            it = -it;
        }
        if (this.outputPlusOnExceededWidth != null && it >= MathKt.getPOWERS_OF_TEN()[this.outputPlusOnExceededWidth.intValue()]) {
            innerBuilder.append('+');
        }
        if (Math.abs(it) >= MathKt.getPOWERS_OF_TEN()[this.zeroPadding - 1]) {
            innerBuilder.append(it);
        } else if (it >= 0) {
            StringBuilder append = innerBuilder.append(MathKt.getPOWERS_OF_TEN()[this.zeroPadding] + it);
            Intrinsics.checkNotNullExpressionValue(append, "append(...)");
            Intrinsics.checkNotNullExpressionValue(append.deleteCharAt(0), "deleteCharAt(...)");
        } else {
            StringBuilder append2 = innerBuilder.append(it - MathKt.getPOWERS_OF_TEN()[this.zeroPadding]);
            Intrinsics.checkNotNullExpressionValue(append2, "append(...)");
            Intrinsics.checkNotNullExpressionValue(append2.deleteCharAt(1), "deleteCharAt(...)");
        }
        builder.append(innerBuilder);
    }
}