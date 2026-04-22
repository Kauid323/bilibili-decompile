package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateTimeComponents.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0086\u0002¢\u0006\u0002\u0010\nJ.\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0086\u0002¢\u0006\u0002\u0010\u000eR\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/TwoDigitNumber;", "", "reference", "Lkotlin/reflect/KMutableProperty0;", "", "(Lkotlin/reflect/KMutableProperty0;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Integer;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Integer;)V", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TwoDigitNumber {
    private final KMutableProperty0<Integer> reference;

    public TwoDigitNumber(KMutableProperty0<Integer> reference) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        this.reference = reference;
    }

    public final Integer getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.reference.get();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (new kotlin.ranges.IntRange(0, 99).contains(r6.intValue()) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setValue(Object thisRef, KProperty<?> property, Integer value) {
        Intrinsics.checkNotNullParameter(property, "property");
        boolean z = value == null;
        if (!z) {
            throw new IllegalArgumentException((property.getName() + " must be a two-digit number, got '" + value + '\'').toString());
        }
        this.reference.set(value);
    }
}