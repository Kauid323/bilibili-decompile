package kotlin.reflect.jvm.internal.impl.km.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;

/* compiled from: FlagDelegatesImpl.kt */
public final class BooleanFlagDelegate<Node> {
    private final FlagImpl flag;
    private final KMutableProperty1<Node, Integer> flags;
    private final int mask;

    public BooleanFlagDelegate(KMutableProperty1<Node, Integer> flags, FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.flags = flags;
        this.flag = flag;
        if (!(this.flag.getBitWidth$kotlin_metadata() == 1 && this.flag.getValue$kotlin_metadata() == 1)) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + this.flag + " was passed").toString());
        }
        this.mask = 1 << this.flag.getOffset$kotlin_metadata();
    }

    public final boolean getValue(Node node, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.flag.invoke(this.flags.get(node).intValue());
    }

    public final void setValue(Node node, KProperty<?> property, boolean value) {
        Intrinsics.checkNotNullParameter(property, "property");
        int intValue = this.flags.get(node).intValue();
        int i = this.mask;
        int newValue = value ? intValue | i : intValue & (~i);
        this.flags.set(node, Integer.valueOf(newValue));
    }
}