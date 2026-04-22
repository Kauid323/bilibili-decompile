package kotlinx.serialization.internal;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: Primitives.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a$\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u0004\"\b\b\u0000\u0010\u0010*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00100\u0002H\u0000\u001a\f\u0010\u0011\u001a\u00020\n*\u00020\nH\u0002\"2\u0010\u0000\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00040\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"BUILTIN_SERIALIZERS", "", "Lkotlin/reflect/KClass;", "", "Lkotlinx/serialization/KSerializer;", "getBUILTIN_SERIALIZERS$annotations", "()V", "PrimitiveDescriptorSafe", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "checkName", "", "builtinSerializerOrNull", "T", "capitalize", "kotlinx-serialization-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PrimitivesKt {
    private static final Map<KClass<? extends Object>, KSerializer<? extends Object>> BUILTIN_SERIALIZERS = MapsKt.mapOf(kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(Character.TYPE), BuiltinSerializersKt.serializer(CharCompanionObject.INSTANCE)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(char[].class), BuiltinSerializersKt.CharArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(Double.TYPE), BuiltinSerializersKt.serializer(DoubleCompanionObject.INSTANCE)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(double[].class), BuiltinSerializersKt.DoubleArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(Float.TYPE), BuiltinSerializersKt.serializer(FloatCompanionObject.INSTANCE)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(float[].class), BuiltinSerializersKt.FloatArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(Long.TYPE), BuiltinSerializersKt.serializer(LongCompanionObject.INSTANCE)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(long[].class), BuiltinSerializersKt.LongArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(ULong.class), BuiltinSerializersKt.serializer(ULong.Companion)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(ULongArray.class), BuiltinSerializersKt.ULongArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(Integer.TYPE), BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(int[].class), BuiltinSerializersKt.IntArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(UInt.class), BuiltinSerializersKt.serializer(UInt.Companion)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(UIntArray.class), BuiltinSerializersKt.UIntArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(Short.TYPE), BuiltinSerializersKt.serializer(ShortCompanionObject.INSTANCE)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(short[].class), BuiltinSerializersKt.ShortArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(UShort.class), BuiltinSerializersKt.serializer(UShort.Companion)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(UShortArray.class), BuiltinSerializersKt.UShortArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(Byte.TYPE), BuiltinSerializersKt.serializer(ByteCompanionObject.INSTANCE)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(byte[].class), BuiltinSerializersKt.ByteArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(UByte.class), BuiltinSerializersKt.serializer(UByte.Companion)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(UByteArray.class), BuiltinSerializersKt.UByteArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(Boolean.TYPE), BuiltinSerializersKt.serializer(BooleanCompanionObject.INSTANCE)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(boolean[].class), BuiltinSerializersKt.BooleanArraySerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(Unit.class), BuiltinSerializersKt.serializer(Unit.INSTANCE)), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(Void.class), BuiltinSerializersKt.NothingSerializer()), kotlin.TuplesKt.to(Reflection.getOrCreateKotlinClass(Duration.class), BuiltinSerializersKt.serializer(Duration.Companion)));

    private static /* synthetic */ void getBUILTIN_SERIALIZERS$annotations() {
    }

    public static final SerialDescriptor PrimitiveDescriptorSafe(String serialName, PrimitiveKind kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        checkName(serialName);
        return new PrimitiveSerialDescriptor(serialName, kind);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void checkName(String serialName) {
        Set keys = BUILTIN_SERIALIZERS.keySet();
        for (KClass primitive : keys) {
            String simpleName = primitive.getSimpleName();
            Intrinsics.checkNotNull(simpleName);
            String simpleName2 = capitalize(simpleName);
            String qualifiedName = "kotlin." + simpleName2;
            if (StringsKt.equals(serialName, qualifiedName, true) || StringsKt.equals(serialName, simpleName2, true)) {
                throw new IllegalArgumentException(StringsKt.trimIndent("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + serialName + " there already exist " + capitalize(simpleName2) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
            while (r1.hasNext()) {
            }
        }
    }

    private static final String capitalize(String $this$capitalize) {
        if ($this$capitalize.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char it = $this$capitalize.charAt(0);
            StringBuilder append = sb.append((Object) (Character.isLowerCase(it) ? CharsKt.titlecase(it) : String.valueOf(it)));
            String substring = $this$capitalize.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return append.append(substring).toString();
        }
        return $this$capitalize;
    }

    public static final <T> KSerializer<T> builtinSerializerOrNull(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return (KSerializer<T>) BUILTIN_SERIALIZERS.get(kClass);
    }
}