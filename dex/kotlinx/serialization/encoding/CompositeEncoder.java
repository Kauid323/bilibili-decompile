package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: Encoding.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH&J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011H&J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H&J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0015H&J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u001aH&J?\u0010\u001b\u001a\u00020\u0007\"\b\b\u0000\u0010\u001c*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e2\b\u0010\f\u001a\u0004\u0018\u0001H\u001cH'¢\u0006\u0002\u0010\u001fJ9\u0010 \u001a\u00020\u0007\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e2\u0006\u0010\f\u001a\u0002H\u001cH&¢\u0006\u0002\u0010\u001fJ \u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\"H&J \u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020$H&J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010&\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006'"}, d2 = {"Lkotlinx/serialization/encoding/CompositeEncoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeBooleanElement", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "value", "", "encodeByteElement", "", "encodeCharElement", "", "encodeDoubleElement", "", "encodeFloatElement", "", "encodeInlineElement", "Lkotlinx/serialization/encoding/Encoder;", "encodeIntElement", "encodeLongElement", "", "encodeNullableSerializableElement", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShortElement", "", "encodeStringElement", "", "endStructure", "shouldEncodeElementDefault", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CompositeEncoder {
    void encodeBooleanElement(SerialDescriptor serialDescriptor, int i, boolean z);

    void encodeByteElement(SerialDescriptor serialDescriptor, int i, byte b);

    void encodeCharElement(SerialDescriptor serialDescriptor, int i, char c);

    void encodeDoubleElement(SerialDescriptor serialDescriptor, int i, double d);

    void encodeFloatElement(SerialDescriptor serialDescriptor, int i, float f);

    Encoder encodeInlineElement(SerialDescriptor serialDescriptor, int i);

    void encodeIntElement(SerialDescriptor serialDescriptor, int i, int i2);

    void encodeLongElement(SerialDescriptor serialDescriptor, int i, long j);

    @ExperimentalSerializationApi
    <T> void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy<? super T> serializationStrategy, T t);

    <T> void encodeSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy<? super T> serializationStrategy, T t);

    void encodeShortElement(SerialDescriptor serialDescriptor, int i, short s);

    void encodeStringElement(SerialDescriptor serialDescriptor, int i, String str);

    void endStructure(SerialDescriptor serialDescriptor);

    SerializersModule getSerializersModule();

    @ExperimentalSerializationApi
    boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i);

    /* compiled from: Encoding.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        public static boolean shouldEncodeElementDefault(CompositeEncoder $this, SerialDescriptor descriptor, int index) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return true;
        }
    }
}