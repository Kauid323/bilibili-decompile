package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.parser.NumberConsumptionError;

/* compiled from: NumberConsumer.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ/\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/datetime/internal/format/parser/FractionPartConsumer;", "Receiver", "Lkotlinx/datetime/internal/format/parser/NumberConsumer;", "minLength", "", "maxLength", "setter", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "Lkotlinx/datetime/internal/DecimalFraction;", "name", "", "(IILkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/String;)V", "consume", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "storage", "input", "", "start", "end", "(Ljava/lang/Object;Ljava/lang/CharSequence;II)Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FractionPartConsumer<Receiver> extends NumberConsumer<Receiver> {
    private final int maxLength;
    private final int minLength;
    private final AssignableField<Receiver, DecimalFraction> setter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FractionPartConsumer(int minLength, int maxLength, AssignableField<? super Receiver, DecimalFraction> setter, String name) {
        super(minLength == maxLength ? Integer.valueOf(minLength) : null, name, null);
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.setter = setter;
        int i = this.minLength;
        boolean z = true;
        if (!(1 <= i && i < 10)) {
            throw new IllegalArgumentException(("Invalid minimum length " + this.minLength + " for field " + getWhatThisExpects() + ": expected 1..9").toString());
        }
        int i2 = this.minLength;
        int i3 = this.maxLength;
        if ((i2 > i3 || i3 >= 10) ? false : z) {
            return;
        }
        throw new IllegalArgumentException(("Invalid maximum length " + this.maxLength + " for field " + getWhatThisExpects() + ": expected " + this.minLength + "..9").toString());
    }

    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public NumberConsumptionError consume(Receiver receiver, CharSequence input, int start, int end) {
        Intrinsics.checkNotNullParameter(input, "input");
        return end - start < this.minLength ? new NumberConsumptionError.TooFewDigits(this.minLength) : end - start > this.maxLength ? new NumberConsumptionError.TooManyDigits(this.maxLength) : NumberConsumerKt.access$setWithoutReassigning(this.setter, receiver, new DecimalFraction(NumberConsumerKt.access$parseAsciiInt(input, start, end), end - start));
    }
}