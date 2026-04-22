package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Tuples.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B#\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0007J\u0015\u0010\u0010\u001a\u00028\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0018J\u001d\u0010\u0019\u001a\u00028\u00022\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H$¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00028\u0000*\u00028\u0002X¤\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00028\u0001*\u00028\u0002X¤\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u0082\u0001\u0002\u001b\u001c¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "key", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "getValue", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class KeyValueSerializer<K, V, R> implements KSerializer<R> {
    private final KSerializer<K> keySerializer;
    private final KSerializer<V> valueSerializer;

    public /* synthetic */ KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    protected abstract K getKey(R r);

    protected abstract V getValue(R r);

    protected abstract R toResult(K k, V v);

    private KeyValueSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }

    protected final KSerializer<K> getKeySerializer() {
        return this.keySerializer;
    }

    protected final KSerializer<V> getValueSerializer() {
        return this.valueSerializer;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, R r) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        CompositeEncoder structuredEncoder = encoder.beginStructure(getDescriptor());
        structuredEncoder.encodeSerializableElement(getDescriptor(), 0, this.keySerializer, getKey(r));
        structuredEncoder.encodeSerializableElement(getDescriptor(), 1, this.valueSerializer, getValue(r));
        structuredEncoder.endStructure(getDescriptor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.DeserializationStrategy
    public R deserialize(Decoder decoder) {
        Object key;
        Object obj;
        Object obj2;
        Object obj3;
        Object result;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        if (!composite$iv.decodeSequentially()) {
            key = TuplesKt.NULL;
            obj = TuplesKt.NULL;
            Object key2 = key;
            Object value = obj;
            while (true) {
                int idx = composite$iv.decodeElementIndex(getDescriptor());
                switch (idx) {
                    case -1:
                        Object value2 = value;
                        obj2 = TuplesKt.NULL;
                        if (key2 != obj2) {
                            obj3 = TuplesKt.NULL;
                            if (value2 == obj3) {
                                throw new SerializationException("Element 'value' is missing");
                            }
                            result = toResult(key2, value2);
                            break;
                        } else {
                            throw new SerializationException("Element 'key' is missing");
                        }
                    case 0:
                        key2 = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, getDescriptor(), 0, getKeySerializer(), null, 8, null);
                        value = value;
                        break;
                    case 1:
                        value = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, getDescriptor(), 1, getValueSerializer(), null, 8, null);
                        break;
                    default:
                        throw new SerializationException("Invalid index: " + idx);
                }
            }
        } else {
            Object key3 = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, getDescriptor(), 0, getKeySerializer(), null, 8, null);
            Object value3 = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite$iv, getDescriptor(), 1, getValueSerializer(), null, 8, null);
            result = toResult(key3, value3);
        }
        Object value4 = result;
        R r = (R) value4;
        composite$iv.endStructure(descriptor$iv);
        return r;
    }
}