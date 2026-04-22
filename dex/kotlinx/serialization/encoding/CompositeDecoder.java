package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: Decoding.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 )2\u00020\u0001:\u0001)J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&JE\u0010\u001b\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u0001H\u001cH'¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0007H\u0017J=\u0010\"\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u0001H\u001cH&¢\u0006\u0002\u0010 J\u0018\u0010#\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010%\u001a\u00020&2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010'\u001a\u00020(2\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006*"}, d2 = {"Lkotlinx/serialization/encoding/CompositeDecoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeBooleanElement", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "decodeByteElement", "", "decodeCharElement", "", "decodeCollectionSize", "decodeDoubleElement", "", "decodeElementIndex", "decodeFloatElement", "", "decodeInlineElement", "Lkotlinx/serialization/encoding/Decoder;", "decodeIntElement", "decodeLongElement", "", "decodeNullableSerializableElement", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSequentially", "decodeSerializableElement", "decodeShortElement", "", "decodeStringElement", "", "endStructure", "", "Companion", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CompositeDecoder {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DECODE_DONE = -1;
    public static final int UNKNOWN_NAME = -3;

    boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int i);

    byte decodeByteElement(SerialDescriptor serialDescriptor, int i);

    char decodeCharElement(SerialDescriptor serialDescriptor, int i);

    int decodeCollectionSize(SerialDescriptor serialDescriptor);

    double decodeDoubleElement(SerialDescriptor serialDescriptor, int i);

    int decodeElementIndex(SerialDescriptor serialDescriptor);

    float decodeFloatElement(SerialDescriptor serialDescriptor, int i);

    Decoder decodeInlineElement(SerialDescriptor serialDescriptor, int i);

    int decodeIntElement(SerialDescriptor serialDescriptor, int i);

    long decodeLongElement(SerialDescriptor serialDescriptor, int i);

    @ExperimentalSerializationApi
    <T> T decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy<? extends T> deserializationStrategy, T t);

    @ExperimentalSerializationApi
    boolean decodeSequentially();

    <T> T decodeSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy<? extends T> deserializationStrategy, T t);

    short decodeShortElement(SerialDescriptor serialDescriptor, int i);

    String decodeStringElement(SerialDescriptor serialDescriptor, int i);

    void endStructure(SerialDescriptor serialDescriptor);

    SerializersModule getSerializersModule();

    /* compiled from: Decoding.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/encoding/CompositeDecoder$Companion;", "", "()V", "DECODE_DONE", "", "UNKNOWN_NAME", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DECODE_DONE = -1;
        public static final int UNKNOWN_NAME = -3;

        private Companion() {
        }
    }

    /* compiled from: Decoding.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        public static boolean decodeSequentially(CompositeDecoder $this) {
            return false;
        }

        public static int decodeCollectionSize(CompositeDecoder $this, SerialDescriptor descriptor) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return -1;
        }

        public static /* synthetic */ Object decodeSerializableElement$default(CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 8) != 0) {
                    obj = null;
                }
                return compositeDecoder.decodeSerializableElement(serialDescriptor, i, deserializationStrategy, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
        }

        public static /* synthetic */ Object decodeNullableSerializableElement$default(CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 8) != 0) {
                    obj = null;
                }
                return compositeDecoder.decodeNullableSerializableElement(serialDescriptor, i, deserializationStrategy, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeNullableSerializableElement");
        }
    }
}