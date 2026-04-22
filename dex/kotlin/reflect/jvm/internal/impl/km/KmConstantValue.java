package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Contracts.kt */
public final class KmConstantValue {
    private final Object value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KmConstantValue) && Intrinsics.areEqual(this.value, ((KmConstantValue) obj).value);
    }

    public int hashCode() {
        if (this.value == null) {
            return 0;
        }
        return this.value.hashCode();
    }

    public String toString() {
        return "KmConstantValue(value=" + this.value + ')';
    }

    public KmConstantValue(Object value) {
        this.value = value;
    }
}