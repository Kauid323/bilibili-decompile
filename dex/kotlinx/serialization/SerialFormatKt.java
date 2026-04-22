package kotlinx.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.internal.InternalHexConverter;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: SerialFormat.kt */
@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0005\u001a\"\u0010\u0006\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\t\u001a+\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\f\u001a\"\u0010\r\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\u0010\u001a\"\u0010\u0011\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0012\u001a\u0002H\u0001H\u0086\b¢\u0006\u0002\u0010\u0013\u001a\"\u0010\u0014\u001a\u00020\b\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0012\u001a\u0002H\u0001H\u0086\b¢\u0006\u0002\u0010\u0015\u001a+\u0010\u0014\u001a\u00020\b\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00172\u0006\u0010\u0012\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0018\u001a\"\u0010\u0019\u001a\u00020\b\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u000e2\u0006\u0010\u0012\u001a\u0002H\u0001H\u0086\b¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"decodeFromByteArray", "T", "Lkotlinx/serialization/BinaryFormat;", "bytes", "", "(Lkotlinx/serialization/BinaryFormat;[B)Ljava/lang/Object;", "decodeFromHexString", "hex", "", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/String;)Ljava/lang/Object;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "decodeFromString", "Lkotlinx/serialization/StringFormat;", "string", "(Lkotlinx/serialization/StringFormat;Ljava/lang/String;)Ljava/lang/Object;", "encodeToByteArray", "value", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)[B", "encodeToHexString", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)Ljava/lang/String;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "encodeToString", "(Lkotlinx/serialization/StringFormat;Ljava/lang/Object;)Ljava/lang/String;", "kotlinx-serialization-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SerialFormatKt {
    public static final /* synthetic */ <T> String encodeToString(StringFormat $this$encodeToString, T t) {
        Intrinsics.checkNotNullParameter($this$encodeToString, "<this>");
        SerializersModule serializersModule = $this$encodeToString.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return $this$encodeToString.encodeToString(SerializersKt.serializer(serializersModule, (KType) null), t);
    }

    public static final /* synthetic */ <T> T decodeFromString(StringFormat $this$decodeFromString, String string) {
        Intrinsics.checkNotNullParameter($this$decodeFromString, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        SerializersModule serializersModule = $this$decodeFromString.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return (T) $this$decodeFromString.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), string);
    }

    public static final <T> String encodeToHexString(BinaryFormat $this$encodeToHexString, SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter($this$encodeToHexString, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        return InternalHexConverter.INSTANCE.printHexBinary($this$encodeToHexString.encodeToByteArray(serializer, t), true);
    }

    public static final <T> T decodeFromHexString(BinaryFormat $this$decodeFromHexString, DeserializationStrategy<? extends T> deserializer, String hex) {
        Intrinsics.checkNotNullParameter($this$decodeFromHexString, "<this>");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(hex, "hex");
        return (T) $this$decodeFromHexString.decodeFromByteArray(deserializer, InternalHexConverter.INSTANCE.parseHexBinary(hex));
    }

    public static final /* synthetic */ <T> String encodeToHexString(BinaryFormat $this$encodeToHexString, T t) {
        Intrinsics.checkNotNullParameter($this$encodeToHexString, "<this>");
        SerializersModule serializersModule = $this$encodeToHexString.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return encodeToHexString($this$encodeToHexString, SerializersKt.serializer(serializersModule, (KType) null), t);
    }

    public static final /* synthetic */ <T> T decodeFromHexString(BinaryFormat $this$decodeFromHexString, String hex) {
        Intrinsics.checkNotNullParameter($this$decodeFromHexString, "<this>");
        Intrinsics.checkNotNullParameter(hex, "hex");
        SerializersModule serializersModule = $this$decodeFromHexString.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return (T) decodeFromHexString($this$decodeFromHexString, SerializersKt.serializer(serializersModule, (KType) null), hex);
    }

    public static final /* synthetic */ <T> byte[] encodeToByteArray(BinaryFormat $this$encodeToByteArray, T t) {
        Intrinsics.checkNotNullParameter($this$encodeToByteArray, "<this>");
        SerializersModule serializersModule = $this$encodeToByteArray.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return $this$encodeToByteArray.encodeToByteArray(SerializersKt.serializer(serializersModule, (KType) null), t);
    }

    public static final /* synthetic */ <T> T decodeFromByteArray(BinaryFormat $this$decodeFromByteArray, byte[] bytes) {
        Intrinsics.checkNotNullParameter($this$decodeFromByteArray, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        SerializersModule serializersModule = $this$decodeFromByteArray.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return (T) $this$decodeFromByteArray.decodeFromByteArray(SerializersKt.serializer(serializersModule, (KType) null), bytes);
    }
}