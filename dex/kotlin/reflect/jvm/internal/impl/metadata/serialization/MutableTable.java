package kotlin.reflect.jvm.internal.impl.metadata.serialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

/* compiled from: MutableTable.kt */
public abstract class MutableTable<Element extends GeneratedMessageLite.Builder<?, Element>, Table extends GeneratedMessageLite, TableBuilder extends GeneratedMessageLite.Builder<Table, TableBuilder>> {
    private final Interner<TableElementWrapper<Element>> interner;

    public final int get(Element type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.interner.intern(new TableElementWrapper<>(type));
    }
}