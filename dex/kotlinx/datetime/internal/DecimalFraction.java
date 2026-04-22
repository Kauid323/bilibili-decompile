package kotlinx.datetime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: math.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0096\u0002J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/internal/DecimalFraction;", "", "fractionalPart", "", "digits", "(II)V", "getDigits", "()I", "getFractionalPart", "compareTo", "other", "equals", "", "", "fractionalPartWithNDigits", "newDigits", "hashCode", "toString", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DecimalFraction implements Comparable<DecimalFraction> {
    private final int digits;
    private final int fractionalPart;

    public DecimalFraction(int fractionalPart, int digits) {
        this.fractionalPart = fractionalPart;
        this.digits = digits;
        if (this.digits >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Digits must be non-negative, but was " + this.digits).toString());
    }

    public final int getFractionalPart() {
        return this.fractionalPart;
    }

    public final int getDigits() {
        return this.digits;
    }

    public final int fractionalPartWithNDigits(int newDigits) {
        return newDigits == this.digits ? this.fractionalPart : newDigits > this.digits ? this.fractionalPart * MathKt.getPOWERS_OF_TEN()[newDigits - this.digits] : this.fractionalPart / MathKt.getPOWERS_OF_TEN()[this.digits - newDigits];
    }

    @Override // java.lang.Comparable
    public int compareTo(DecimalFraction other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int maxPrecision = Math.max(this.digits, other.digits);
        return Intrinsics.compare(fractionalPartWithNDigits(maxPrecision), other.fractionalPartWithNDigits(maxPrecision));
    }

    public boolean equals(Object other) {
        return (other instanceof DecimalFraction) && compareTo((DecimalFraction) other) == 0;
    }

    public String toString() {
        StringBuilder $this$toString_u24lambda_u242 = new StringBuilder();
        int denominator = MathKt.getPOWERS_OF_TEN()[this.digits];
        $this$toString_u24lambda_u242.append(this.fractionalPart / denominator);
        $this$toString_u24lambda_u242.append(FilenameUtils.EXTENSION_SEPARATOR);
        $this$toString_u24lambda_u242.append(StringsKt.removePrefix(String.valueOf((this.fractionalPart % denominator) + denominator), (CharSequence) "1"));
        String sb = $this$toString_u24lambda_u242.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public int hashCode() {
        throw new UnsupportedOperationException("DecimalFraction is not supposed to be used as a hash key");
    }
}