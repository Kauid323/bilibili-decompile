package io.ktor.util.converters;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ConversionServiceJvm.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "value", "Lkotlin/reflect/KClass;", "klass", "", "platformDefaultFromValues", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "convertSimpleTypes", "", "platformDefaultToValues", "(Ljava/lang/Object;)Ljava/util/List;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ConversionServiceJvmKt {
    public static final Object platformDefaultFromValues(String value, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(kClass, "klass");
        Object converted = convertSimpleTypes(value, kClass);
        if (converted != null) {
            return converted;
        }
        Object obj = null;
        if (JvmClassMappingKt.getJavaClass(kClass).isEnum()) {
            Object[] $this$firstOrNull$iv = JvmClassMappingKt.getJavaClass(kClass).getEnumConstants();
            if ($this$firstOrNull$iv != null) {
                int length = $this$firstOrNull$iv.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Object element$iv = $this$firstOrNull$iv[i];
                    Intrinsics.checkNotNull(element$iv, "null cannot be cast to non-null type kotlin.Enum<*>");
                    if (Intrinsics.areEqual(((Enum) element$iv).name(), value)) {
                        obj = element$iv;
                        break;
                    }
                    i++;
                }
                if (obj != null) {
                    return obj;
                }
            }
            throw new DataConversionException("Value " + value + " is not a enum member name of " + kClass);
        }
        return null;
    }

    private static final Object convertSimpleTypes(String value, KClass<?> kClass) {
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            return Integer.valueOf(Integer.parseInt(value));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Float.class))) {
            return Float.valueOf(Float.parseFloat(value));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Double.class))) {
            return Double.valueOf(Double.parseDouble(value));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.class))) {
            return Long.valueOf(Long.parseLong(value));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Short.class))) {
            return Short.valueOf(Short.parseShort(value));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Boolean.class))) {
            return Boolean.valueOf(Boolean.parseBoolean(value));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(String.class))) {
            return value;
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Character.class))) {
            return Character.valueOf(value.charAt(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(BigDecimal.class))) {
            return new BigDecimal(value);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(BigInteger.class))) {
            return new BigInteger(value);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(UUID.class))) {
            return UUID.fromString(value);
        }
        return null;
    }

    public static final List<String> platformDefaultToValues(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof Enum) {
            return CollectionsKt.listOf(((Enum) value).name());
        }
        if (value instanceof Integer) {
            return CollectionsKt.listOf(((Integer) value).toString());
        }
        if (value instanceof Float) {
            return CollectionsKt.listOf(((Float) value).toString());
        }
        if (value instanceof Double) {
            return CollectionsKt.listOf(((Double) value).toString());
        }
        if (value instanceof Long) {
            return CollectionsKt.listOf(((Long) value).toString());
        }
        if (value instanceof Boolean) {
            return CollectionsKt.listOf(((Boolean) value).toString());
        }
        if (value instanceof Short) {
            return CollectionsKt.listOf(((Short) value).toString());
        }
        if (value instanceof String) {
            return CollectionsKt.listOf(((String) value).toString());
        }
        if (value instanceof Character) {
            return CollectionsKt.listOf(((Character) value).toString());
        }
        if (value instanceof BigDecimal) {
            return CollectionsKt.listOf(((BigDecimal) value).toString());
        }
        if (value instanceof BigInteger) {
            return CollectionsKt.listOf(((BigInteger) value).toString());
        }
        if (value instanceof UUID) {
            return CollectionsKt.listOf(((UUID) value).toString());
        }
        return null;
    }
}