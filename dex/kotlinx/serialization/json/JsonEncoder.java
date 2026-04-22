package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: JsonEncoder.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "encodeJsonElement", "", "element", "Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface JsonEncoder extends Encoder, CompositeEncoder {
    void encodeJsonElement(JsonElement jsonElement);

    Json getJson();

    /* compiled from: JsonEncoder.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        public static CompositeEncoder beginCollection(JsonEncoder $this, SerialDescriptor descriptor, int collectionSize) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return Encoder.DefaultImpls.beginCollection($this, descriptor, collectionSize);
        }

        @ExperimentalSerializationApi
        public static void encodeNotNullMark(JsonEncoder $this) {
            Encoder.DefaultImpls.encodeNotNullMark($this);
        }

        @ExperimentalSerializationApi
        public static <T> void encodeNullableSerializableValue(JsonEncoder $this, SerializationStrategy<? super T> serializer, T t) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            Encoder.DefaultImpls.encodeNullableSerializableValue($this, serializer, t);
        }

        public static <T> void encodeSerializableValue(JsonEncoder $this, SerializationStrategy<? super T> serializer, T t) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            Encoder.DefaultImpls.encodeSerializableValue($this, serializer, t);
        }

        @ExperimentalSerializationApi
        public static boolean shouldEncodeElementDefault(JsonEncoder $this, SerialDescriptor descriptor, int index) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return CompositeEncoder.DefaultImpls.shouldEncodeElementDefault($this, descriptor, index);
        }
    }
}