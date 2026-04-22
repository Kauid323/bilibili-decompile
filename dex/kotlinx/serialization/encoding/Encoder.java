package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: Encoding.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0016H&J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000bH&J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH&J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u000eH\u0017J\b\u0010!\u001a\u00020\u000eH'J/\u0010\"\u001a\u00020\u000e\"\b\b\u0000\u0010#*\u00020\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%2\b\u0010\u000f\u001a\u0004\u0018\u0001H#H\u0017¢\u0006\u0002\u0010&J)\u0010'\u001a\u00020\u000e\"\u0004\b\u0000\u0010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%2\u0006\u0010\u000f\u001a\u0002H#H\u0016¢\u0006\u0002\u0010&J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020)H&J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020+H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006,"}, d2 = {"Lkotlinx/serialization/encoding/Encoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginCollection", "Lkotlinx/serialization/encoding/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "collectionSize", "", "beginStructure", "encodeBoolean", "", "value", "", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeEnum", "enumDescriptor", "index", "encodeFloat", "", "encodeInline", "encodeInt", "encodeLong", "", "encodeNotNullMark", "encodeNull", "encodeNullableSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableValue", "encodeShort", "", "encodeString", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Encoder {
    CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i);

    CompositeEncoder beginStructure(SerialDescriptor serialDescriptor);

    void encodeBoolean(boolean z);

    void encodeByte(byte b);

    void encodeChar(char c);

    void encodeDouble(double d);

    void encodeEnum(SerialDescriptor serialDescriptor, int i);

    void encodeFloat(float f);

    Encoder encodeInline(SerialDescriptor serialDescriptor);

    void encodeInt(int i);

    void encodeLong(long j);

    @ExperimentalSerializationApi
    void encodeNotNullMark();

    @ExperimentalSerializationApi
    void encodeNull();

    @ExperimentalSerializationApi
    <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t);

    <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t);

    void encodeShort(short s);

    void encodeString(String str);

    SerializersModule getSerializersModule();

    /* compiled from: Encoding.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        public static void encodeNotNullMark(Encoder $this) {
        }

        public static CompositeEncoder beginCollection(Encoder $this, SerialDescriptor descriptor, int collectionSize) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return $this.beginStructure(descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T> void encodeSerializableValue(Encoder $this, SerializationStrategy<? super T> serializer, T t) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            serializer.serialize($this, t);
        }

        @ExperimentalSerializationApi
        public static <T> void encodeNullableSerializableValue(Encoder $this, SerializationStrategy<? super T> serializer, T t) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            boolean isNullabilitySupported = serializer.getDescriptor().isNullable();
            if (isNullabilitySupported) {
                $this.encodeSerializableValue(serializer, t);
            } else if (t == null) {
                $this.encodeNull();
            } else {
                $this.encodeNotNullMark();
                $this.encodeSerializableValue(serializer, t);
            }
        }
    }
}