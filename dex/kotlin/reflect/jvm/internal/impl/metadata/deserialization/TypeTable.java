package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: TypeTable.kt */
public final class TypeTable {
    private final List<ProtoBuf.Type> types;

    public TypeTable(ProtoBuf.TypeTable typeTable) {
        TypeTable $this$types_u24lambda_u240;
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        TypeTable $this$types_u24lambda_u2402 = this;
        List originalTypes = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            Iterable typeList = typeTable.getTypeList();
            Intrinsics.checkNotNullExpressionValue(typeList, "getTypeList(...)");
            Iterable $this$mapIndexed$iv = typeList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ProtoBuf.Type type = (ProtoBuf.Type) item$iv$iv;
                if (index$iv$iv >= firstNullable) {
                    $this$types_u24lambda_u240 = $this$types_u24lambda_u2402;
                    type = type.toBuilder().setNullable(true).build();
                } else {
                    $this$types_u24lambda_u240 = $this$types_u24lambda_u2402;
                }
                destination$iv$iv.add(type);
                index$iv$iv = index$iv$iv2;
                $this$types_u24lambda_u2402 = $this$types_u24lambda_u240;
            }
            originalTypes = (List) destination$iv$iv;
        }
        Intrinsics.checkNotNullExpressionValue(originalTypes, "run(...)");
        this.types = originalTypes;
    }

    public final ProtoBuf.Type get(int index) {
        return this.types.get(index);
    }
}