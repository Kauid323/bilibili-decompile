package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: CollectionSerializers.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0014\b\u0003\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00052 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006B#\b\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0002\u0010\u000bJ-\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0004¢\u0006\u0002\u0010\u001bJ-\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00028\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0004¢\u0006\u0002\u0010 J\u001d\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010%J)\u0010&\u001a\u00020\u0014*\u00028\u00032\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010'\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H$¢\u0006\u0002\u0010(R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011\u0082\u0001\u0002)*¨\u0006+"}, d2 = {"Lkotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", "Builder", "", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "readAll", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/util/Map;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/util/Map;Z)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "insertKeyValuePair", "key", "(Ljava/util/Map;ILjava/lang/Object;Ljava/lang/Object;)V", "Lkotlinx/serialization/internal/HashMapSerializer;", "Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@InternalSerializationApi
public abstract class MapLikeSerializer<Key, Value, Collection, Builder extends Map<Key, Value>> extends AbstractCollectionSerializer<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {
    private final KSerializer<Key> keySerializer;
    private final KSerializer<Value> valueSerializer;

    public /* synthetic */ MapLikeSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public abstract SerialDescriptor getDescriptor();

    protected abstract void insertKeyValuePair(Builder builder, int i, Key key, Value value);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ void readAll(CompositeDecoder decoder, Object builder, int startIndex, int size) {
        readAll(decoder, (CompositeDecoder) ((Map) builder), startIndex, size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ void readElement(CompositeDecoder decoder, int index, Object builder, boolean checkIndex) {
        readElement(decoder, index, (int) ((Map) builder), checkIndex);
    }

    public final KSerializer<Key> getKeySerializer() {
        return this.keySerializer;
    }

    public final KSerializer<Value> getValueSerializer() {
        return this.valueSerializer;
    }

    private MapLikeSerializer(KSerializer<Key> kSerializer, KSerializer<Value> kSerializer2) {
        super(null);
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }

    protected final void readAll(CompositeDecoder decoder, Builder builder, int startIndex, int size) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (!(size >= 0)) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
        IntProgression step = RangesKt.step(RangesKt.until(0, size * 2), 2);
        int index = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || index > last) && (step2 >= 0 || last > index)) {
            return;
        }
        while (true) {
            readElement(decoder, startIndex + index, (int) builder, false);
            if (index == last) {
                return;
            }
            index += step2;
        }
    }

    protected final void readElement(CompositeDecoder decoder, int index, Builder builder, boolean checkIndex) {
        int it;
        Object value;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Object key = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(decoder, getDescriptor(), index, this.keySerializer, null, 8, null);
        if (checkIndex) {
            it = decoder.decodeElementIndex(getDescriptor());
            if (!(it == index + 1)) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + index + ", returned index for value: " + it).toString());
            }
        } else {
            it = index + 1;
        }
        if (builder.containsKey(key) && !(this.valueSerializer.getDescriptor().getKind() instanceof PrimitiveKind)) {
            value = decoder.decodeSerializableElement(getDescriptor(), it, this.valueSerializer, MapsKt.getValue(builder, key));
        } else {
            value = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(decoder, getDescriptor(), it, this.valueSerializer, null, 8, null);
        }
        builder.put(key, value);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer, kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Collection collection) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int size = collectionSize(collection);
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginCollection(descriptor$iv, size);
        Iterator iterator = collectionIterator(collection);
        int index = 0;
        while (iterator.hasNext()) {
            Object element$iv = iterator.next();
            Map.Entry<? extends Key, ? extends Value> entry = (Map.Entry) element$iv;
            Key key = entry.getKey();
            Value value = entry.getValue();
            int size2 = size;
            int size3 = index + 1;
            composite$iv.encodeSerializableElement(getDescriptor(), index, getKeySerializer(), key);
            index = size3 + 1;
            composite$iv.encodeSerializableElement(getDescriptor(), size3, getValueSerializer(), value);
            size = size2;
        }
        composite$iv.endStructure(descriptor$iv);
    }
}