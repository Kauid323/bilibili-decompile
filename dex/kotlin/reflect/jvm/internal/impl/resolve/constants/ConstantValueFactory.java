package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: ConstantValueFactory.kt */
public final class ConstantValueFactory {
    public static final ConstantValueFactory INSTANCE = new ConstantValueFactory();

    private ConstantValueFactory() {
    }

    public final ArrayValue createArrayValue(List<? extends ConstantValue<?>> value, KotlinType type) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        return new TypedArrayValue(value, type);
    }

    public static /* synthetic */ ConstantValue createConstantValue$default(ConstantValueFactory constantValueFactory, Object obj, ModuleDescriptor moduleDescriptor, int i, Object obj2) {
        if ((i & 2) != 0) {
            moduleDescriptor = null;
        }
        return constantValueFactory.createConstantValue(obj, moduleDescriptor);
    }

    public final ConstantValue<?> createConstantValue(Object value, ModuleDescriptor module) {
        if (value instanceof Byte) {
            return new ByteValue(((Number) value).byteValue());
        }
        if (value instanceof Short) {
            return new ShortValue(((Number) value).shortValue());
        }
        if (value instanceof Integer) {
            return new IntValue(((Number) value).intValue());
        }
        if (value instanceof Long) {
            return new LongValue(((Number) value).longValue());
        }
        if (value instanceof Character) {
            return new CharValue(((Character) value).charValue());
        }
        if (value instanceof Float) {
            return new FloatValue(((Number) value).floatValue());
        }
        if (value instanceof Double) {
            return new DoubleValue(((Number) value).doubleValue());
        }
        if (value instanceof Boolean) {
            return new BooleanValue(((Boolean) value).booleanValue());
        }
        if (value instanceof String) {
            return new StringValue((String) value);
        }
        if (value instanceof byte[]) {
            return createArrayValue(ArraysKt.toList((byte[]) value), module, PrimitiveType.BYTE);
        }
        if (value instanceof short[]) {
            return createArrayValue(ArraysKt.toList((short[]) value), module, PrimitiveType.SHORT);
        }
        if (value instanceof int[]) {
            return createArrayValue(ArraysKt.toList((int[]) value), module, PrimitiveType.INT);
        }
        if (value instanceof long[]) {
            return createArrayValue(ArraysKt.toList((long[]) value), module, PrimitiveType.LONG);
        }
        if (value instanceof char[]) {
            return createArrayValue(ArraysKt.toList((char[]) value), module, PrimitiveType.CHAR);
        }
        if (value instanceof float[]) {
            return createArrayValue(ArraysKt.toList((float[]) value), module, PrimitiveType.FLOAT);
        }
        if (value instanceof double[]) {
            return createArrayValue(ArraysKt.toList((double[]) value), module, PrimitiveType.DOUBLE);
        }
        if (value instanceof boolean[]) {
            return createArrayValue(ArraysKt.toList((boolean[]) value), module, PrimitiveType.BOOLEAN);
        }
        if (value == null) {
            return new NullValue();
        }
        return null;
    }

    private final ArrayValue createArrayValue(List<?> list, ModuleDescriptor module, PrimitiveType componentType) {
        Iterable $this$mapNotNull$iv = CollectionsKt.toList(list);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            ConstantValue createConstantValue$default = createConstantValue$default(this, element$iv$iv$iv, null, 2, null);
            if (createConstantValue$default != null) {
                destination$iv$iv.add(createConstantValue$default);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
        }
        List elements = (List) destination$iv$iv;
        if (module != null) {
            SimpleType primitiveArrayKotlinType = module.getBuiltIns().getPrimitiveArrayKotlinType(componentType);
            Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "getPrimitiveArrayKotlinType(...)");
            return new TypedArrayValue(elements, primitiveArrayKotlinType);
        }
        return new ArrayValue(elements, new Function1(componentType) { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory$$Lambda$0
            private final PrimitiveType arg$0;

            {
                this.arg$0 = componentType;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                KotlinType createArrayValue$lambda$0;
                createArrayValue$lambda$0 = ConstantValueFactory.createArrayValue$lambda$0(this.arg$0, (ModuleDescriptor) obj);
                return createArrayValue$lambda$0;
            }
        });
    }

    public static final KotlinType createArrayValue$lambda$0(PrimitiveType $componentType, ModuleDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        SimpleType primitiveArrayKotlinType = it.getBuiltIns().getPrimitiveArrayKotlinType($componentType);
        Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "getPrimitiveArrayKotlinType(...)");
        return primitiveArrayKotlinType;
    }
}