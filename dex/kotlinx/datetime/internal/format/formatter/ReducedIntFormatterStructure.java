package kotlinx.datetime.internal.format.formatter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.MathKt;
import org.slf4j.Marker;

/* compiled from: FormatterOperation.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B)\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/internal/format/formatter/ReducedIntFormatterStructure;", "T", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "number", "Lkotlin/Function1;", "", "digits", "base", "(Lkotlin/jvm/functions/Function1;II)V", "format", "", "obj", "builder", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "minusNotRequired", "", "(Ljava/lang/Object;Ljava/lang/Appendable;Z)V", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ReducedIntFormatterStructure<T> implements FormatterStructure<T> {
    private final int base;
    private final int digits;
    private final Function1<T, Integer> number;

    /* JADX WARN: Multi-variable type inference failed */
    public ReducedIntFormatterStructure(Function1<? super T, Integer> number, int digits, int base) {
        Intrinsics.checkNotNullParameter(number, "number");
        this.number = number;
        this.digits = digits;
        this.base = base;
    }

    @Override // kotlinx.datetime.internal.format.formatter.FormatterStructure
    public void format(T t, Appendable builder, boolean minusNotRequired) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        int number = this.number.invoke(t).intValue();
        int i = MathKt.getPOWERS_OF_TEN()[this.digits];
        int i2 = number - this.base;
        if (i2 >= 0 && i2 < i) {
            String numberStr = String.valueOf(number % MathKt.getPOWERS_OF_TEN()[this.digits]);
            String zeroPaddingStr = StringsKt.repeat("0", Math.max(0, this.digits - numberStr.length()));
            StringsKt.append(builder, zeroPaddingStr, numberStr);
            return;
        }
        if (number >= 0) {
            builder.append(Marker.ANY_NON_NULL_MARKER);
        }
        builder.append(String.valueOf(number));
    }
}