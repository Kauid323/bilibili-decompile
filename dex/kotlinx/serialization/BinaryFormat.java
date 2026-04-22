package kotlinx.serialization;

import kotlin.Metadata;

/* compiled from: SerialFormat.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\bJ)\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010\f\u001a\u0002H\u0003H&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/serialization/BinaryFormat;", "Lkotlinx/serialization/SerialFormat;", "decodeFromByteArray", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "bytes", "", "(Lkotlinx/serialization/DeserializationStrategy;[B)Ljava/lang/Object;", "encodeToByteArray", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)[B", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BinaryFormat extends SerialFormat {
    <T> T decodeFromByteArray(DeserializationStrategy<? extends T> deserializationStrategy, byte[] bArr);

    <T> byte[] encodeToByteArray(SerializationStrategy<? super T> serializationStrategy, T t);
}