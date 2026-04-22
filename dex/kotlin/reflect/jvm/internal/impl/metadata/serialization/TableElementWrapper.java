package kotlin.reflect.jvm.internal.impl.metadata.serialization;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableTable.kt */
public final class TableElementWrapper<Element extends GeneratedMessageLite.Builder<?, Element>> {
    private final Element builder;
    private final byte[] bytes;
    private final int hashCode;

    public TableElementWrapper(Element builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        byte[] byteArray = this.builder.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        this.bytes = byteArray;
        this.hashCode = Arrays.hashCode(this.bytes);
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean equals(Object other) {
        return (other instanceof TableElementWrapper) && Arrays.equals(this.bytes, ((TableElementWrapper) other).bytes);
    }
}