package kotlin.reflect.jvm.internal.impl.km.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* compiled from: FlagImpl.kt */
public final class FlagImpl {
    private final int bitWidth;
    private final int offset;
    private final int value;

    public FlagImpl(int offset, int bitWidth, int value) {
        this.offset = offset;
        this.bitWidth = bitWidth;
        this.value = value;
    }

    public final int getBitWidth$kotlin_metadata() {
        return this.bitWidth;
    }

    public final int getOffset$kotlin_metadata() {
        return this.offset;
    }

    public final int getValue$kotlin_metadata() {
        return this.value;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlagImpl(Flags.FlagField<?> field, int value) {
        this(field.offset, field.bitWidth, value);
        Intrinsics.checkNotNullParameter(field, "field");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlagImpl(Flags.BooleanFlagField field) {
        this(field, 1);
        Intrinsics.checkNotNullParameter(field, "field");
    }

    public final boolean invoke(int flags) {
        return ((flags >>> this.offset) & ((1 << this.bitWidth) - 1)) == this.value;
    }
}