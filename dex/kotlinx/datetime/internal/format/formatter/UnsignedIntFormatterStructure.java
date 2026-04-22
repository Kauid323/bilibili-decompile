package kotlinx.datetime.internal.format.formatter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FormatterOperation.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J)\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/internal/format/formatter/UnsignedIntFormatterStructure;", "T", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "number", "Lkotlin/Function1;", "", "zeroPadding", "(Lkotlin/jvm/functions/Function1;I)V", "format", "", "obj", "builder", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "minusNotRequired", "", "(Ljava/lang/Object;Ljava/lang/Appendable;Z)V", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UnsignedIntFormatterStructure<T> implements FormatterStructure<T> {
    private final Function1<T, Integer> number;
    private final int zeroPadding;

    /* JADX WARN: Multi-variable type inference failed */
    public UnsignedIntFormatterStructure(Function1<? super T, Integer> number, int zeroPadding) {
        Intrinsics.checkNotNullParameter(number, "number");
        this.number = number;
        this.zeroPadding = zeroPadding;
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
        int num = this.number.invoke(t).intValue();
        String numberStr = String.valueOf(num);
        int length = this.zeroPadding - numberStr.length();
        for (int i = 0; i < length; i++) {
            builder.append('0');
        }
        builder.append(numberStr);
    }
}