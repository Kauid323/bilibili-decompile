package kotlin.reflect.jvm.internal.impl.km.internal;

import java.lang.Enum;
import java.util.List;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;

/* compiled from: FlagDelegatesImpl.kt */
public final class EnumFlagDelegate<Node, E extends Enum<E>> {
    private final EnumEntries<E> entries;
    private final List<FlagImpl> flagValues;
    private final KMutableProperty1<Node, Integer> flags;
    private final Flags.FlagField<? extends Internal.EnumLite> protoSet;

    public EnumFlagDelegate(KMutableProperty1<Node, Integer> flags, Flags.FlagField<? extends Internal.EnumLite> protoSet, EnumEntries<E> entries, List<FlagImpl> flagValues) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(protoSet, "protoSet");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(flagValues, "flagValues");
        this.flags = flags;
        this.protoSet = protoSet;
        this.entries = entries;
        this.flagValues = flagValues;
    }

    public final E getValue(Node node, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return (E) this.entries.get(this.protoSet.get(this.flags.get(node).intValue()).getNumber());
    }
}