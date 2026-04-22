package kotlinx.serialization.protobuf.internal;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.AbstractCollectionSerializer;
import kotlinx.serialization.internal.ElementMarker;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.MapLikeSerializer;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.protobuf.ProtoBuf;
import kotlinx.serialization.protobuf.ProtoIntegerType;

/* compiled from: ProtobufDecoding.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0010\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J!\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001dH\u0016¢\u0006\u0002\u0010\u001eJ+\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001d2\b\u0010\u001f\u001a\u0004\u0018\u0001H\u001bH\u0014¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\u000e2\n\u0010\"\u001a\u00060#j\u0002`$H\u0014J\u0014\u0010%\u001a\u00020&2\n\u0010\"\u001a\u00060#j\u0002`$H\u0014J\u0014\u0010'\u001a\u00020(2\n\u0010\"\u001a\u00060#j\u0002`$H\u0014J\u0014\u0010)\u001a\u00020*2\n\u0010\"\u001a\u00060#j\u0002`$H\u0014J\u001c\u0010+\u001a\u00020\u00152\n\u0010\"\u001a\u00060#j\u0002`$2\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0014\u0010-\u001a\u00020.2\n\u0010\"\u001a\u00060#j\u0002`$H\u0014J\u0014\u0010/\u001a\u00020\u00152\n\u0010\"\u001a\u00060#j\u0002`$H\u0014J\u0014\u00100\u001a\u00020#2\n\u0010\"\u001a\u00060#j\u0002`$H\u0014J\u0014\u00101\u001a\u0002022\n\u0010\"\u001a\u00060#j\u0002`$H\u0014J\u0014\u00103\u001a\u0002042\n\u0010\"\u001a\u00060#j\u0002`$H\u0014J\u0012\u00105\u001a\u0002062\b\u0010\u001f\u001a\u0004\u0018\u000106H\u0002J+\u00107\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001d2\b\u0010\u001f\u001a\u0004\u0018\u0001H\u001bH\u0002¢\u0006\u0002\u0010 J\u0010\u00108\u001a\u0002092\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010:\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0015H\u0002J\u0018\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0015H\u0002J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u0015H\u0002J\u0010\u0010?\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u0015H\u0002J\u000e\u0010@\u001a\u0002092\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010A\u001a\u0002092\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0015H\u0002J\u0018\u0010C\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0015H\u0002J\u0018\u0010E\u001a\u00060#j\u0002`$*\u00020\u00072\u0006\u0010D\u001a\u00020\u0015H\u0014R\u0010\u0010\u0006\u001a\u00020\u00078\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ProtobufDecoder;", "Lkotlinx/serialization/protobuf/internal/ProtobufTaggedDecoder;", "proto", "Lkotlinx/serialization/protobuf/ProtoBuf;", "reader", "Lkotlinx/serialization/protobuf/internal/ProtobufReader;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/protobuf/ProtoBuf;Lkotlinx/serialization/protobuf/internal/ProtobufReader;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "elementMarker", "Lkotlinx/serialization/internal/ElementMarker;", "indexCache", "", "nullValue", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "sparseIndexCache", "", "", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeElementIndex", "decodeNotNullMark", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "previousValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeTaggedBoolean", "tag", "", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "decodeTaggedByte", "", "decodeTaggedChar", "", "decodeTaggedDouble", "", "decodeTaggedEnum", "enumDescription", "decodeTaggedFloat", "", "decodeTaggedInt", "decodeTaggedLong", "decodeTaggedShort", "", "decodeTaggedString", "", "deserializeByteArray", "", "deserializeMap", "endStructure", "", "findIndexByTag", "protoTag", "findIndexByTagSlowPath", "desc", "getIndexByTag", "getIndexByTagSlowPath", "populateCache", "populateCacheMap", "elements", "readIfAbsent", "index", "getTag", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ProtobufDecoder extends ProtobufTaggedDecoder {
    protected final SerialDescriptor descriptor;
    private final ElementMarker elementMarker;
    private int[] indexCache;
    private boolean nullValue;
    protected final ProtoBuf proto;
    protected final ProtobufReader reader;
    private Map<Integer, Integer> sparseIndexCache;

    public ProtobufDecoder(ProtoBuf proto, ProtobufReader reader, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.proto = proto;
        this.reader = reader;
        this.descriptor = descriptor;
        this.elementMarker = new ElementMarker(this.descriptor, new ProtobufDecoder$elementMarker$1(this));
        populateCache(this.descriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule getSerializersModule() {
        return this.proto.getSerializersModule();
    }

    public final void populateCache(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int elements = descriptor.getElementsCount();
        if (elements < 32) {
            int[] cache = new int[elements + 1];
            for (int i = 0; i < elements; i++) {
                int protoId = HelpersKt.extractProtoId(descriptor, i, false);
                if (protoId <= elements) {
                    cache[protoId] = i;
                } else {
                    populateCacheMap(descriptor, elements);
                    return;
                }
            }
            this.indexCache = cache;
            return;
        }
        populateCacheMap(descriptor, elements);
    }

    private final void populateCacheMap(SerialDescriptor descriptor, int elements) {
        HashMap map = new HashMap(elements);
        for (int i = 0; i < elements; i++) {
            map.put(Integer.valueOf(HelpersKt.extractProtoId(descriptor, i, false)), Integer.valueOf(i));
        }
        this.sparseIndexCache = map;
    }

    private final int getIndexByTag(int protoTag) {
        int[] array = this.indexCache;
        if (array != null) {
            if (protoTag < 0 || protoTag > ArraysKt.getLastIndex(array)) {
                return -1;
            }
            return array[protoTag];
        }
        return getIndexByTagSlowPath(protoTag);
    }

    private final int getIndexByTagSlowPath(int protoTag) {
        Map<Integer, Integer> map = this.sparseIndexCache;
        Intrinsics.checkNotNull(map);
        int i = map.get(Integer.valueOf(protoTag));
        if (i == null) {
            i = -1;
        }
        return i.intValue();
    }

    private final int findIndexByTag(SerialDescriptor descriptor, int protoTag) {
        if (protoTag < descriptor.getElementsCount()) {
            int protoId = HelpersKt.extractProtoId(descriptor, protoTag, true);
            if (protoId == protoTag) {
                return protoTag;
            }
        }
        int protoId2 = findIndexByTagSlowPath(descriptor, protoTag);
        return protoId2;
    }

    private final int findIndexByTagSlowPath(SerialDescriptor desc, int protoTag) {
        int elementsCount = desc.getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            int protoId = HelpersKt.extractProtoId(desc, i, true);
            if (protoId == protoTag) {
                return i;
            }
        }
        throw new ProtobufDecodingException(protoTag + " is not among valid " + this.descriptor.getSerialName() + " enum proto numbers");
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        SerialKind kind = descriptor.getKind();
        if (!Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE)) {
            if (Intrinsics.areEqual(kind, StructureKind.CLASS.INSTANCE) ? true : Intrinsics.areEqual(kind, StructureKind.OBJECT.INSTANCE) ? true : kind instanceof PolymorphicKind) {
                long tag = getCurrentTagOrDefault();
                return (tag == ProtobufTaggedBaseKt.MISSING_TAG && Intrinsics.areEqual(this.descriptor, descriptor)) ? this : new ProtobufDecoder(this.proto, ProtobufDecodingKt.access$makeDelimited(this.reader, tag), descriptor);
            } else if (Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
                return new MapEntryReader(this.proto, ProtobufDecodingKt.access$makeDelimitedForced(this.reader, getCurrentTagOrDefault()), getCurrentTagOrDefault(), descriptor);
            } else {
                throw new SerializationException("Primitives are not supported at top-level");
            }
        }
        long tag2 = getCurrentTagOrDefault();
        if (Intrinsics.areEqual(this.descriptor.getKind(), StructureKind.LIST.INSTANCE) && tag2 != ProtobufTaggedBaseKt.MISSING_TAG && !Intrinsics.areEqual(this.descriptor, descriptor)) {
            ProtobufReader reader = ProtobufDecodingKt.access$makeDelimited(this.reader, tag2);
            reader.readTag();
            ProtoBuf protoBuf = this.proto;
            ProtoIntegerType type$iv = ProtoIntegerType.DEFAULT;
            return new RepeatedDecoder(protoBuf, reader, type$iv.getSignature$kotlinx_serialization_protobuf() | 1, descriptor);
        } else if (this.reader.currentType == 2 && HelpersKt.isPackable(descriptor.getElementDescriptor(0))) {
            ProtobufReader sliceReader = new ProtobufReader(this.reader.objectInput());
            return new PackedArrayDecoder(this.proto, sliceReader, descriptor);
        } else {
            return new RepeatedDecoder(this.proto, this.reader, tag2, descriptor);
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected boolean decodeTaggedBoolean(long tag) {
        int value = decodeTaggedInt(tag);
        switch (value) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                throw new SerializationException("Unexpected boolean value: " + value);
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected byte decodeTaggedByte(long tag) {
        return (byte) decodeTaggedInt(tag);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected short decodeTaggedShort(long tag) {
        return (short) decodeTaggedInt(tag);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected int decodeTaggedInt(long tag) {
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            return this.reader.readInt32NoTag();
        }
        return this.reader.readInt(HelpersKt.getIntegerType(tag));
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected long decodeTaggedLong(long tag) {
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            return this.reader.readLongNoTag();
        }
        return this.reader.readLong(HelpersKt.getIntegerType(tag));
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected float decodeTaggedFloat(long tag) {
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            return this.reader.readFloatNoTag();
        }
        return this.reader.readFloat();
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected double decodeTaggedDouble(long tag) {
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            return this.reader.readDoubleNoTag();
        }
        return this.reader.readDouble();
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected char decodeTaggedChar(long tag) {
        return (char) decodeTaggedInt(tag);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected String decodeTaggedString(long tag) {
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            return this.reader.readStringNoTag();
        }
        return this.reader.readString();
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected int decodeTaggedEnum(long tag, SerialDescriptor enumDescription) {
        Intrinsics.checkNotNullParameter(enumDescription, "enumDescription");
        return findIndexByTag(enumDescription, decodeTaggedInt(tag));
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder, kotlinx.serialization.encoding.Decoder
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer, null);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer, T t) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        if (deserializer instanceof MapLikeSerializer) {
            return (T) deserializeMap(deserializer, t);
        }
        if (Intrinsics.areEqual(deserializer.getDescriptor(), BuiltinSerializersKt.ByteArraySerializer().getDescriptor())) {
            return (T) deserializeByteArray((byte[]) t);
        }
        if (deserializer instanceof AbstractCollectionSerializer) {
            return (T) ((AbstractCollectionSerializer) deserializer).merge(this, t);
        }
        return deserializer.deserialize(this);
    }

    private final byte[] deserializeByteArray(byte[] previousValue) {
        byte[] array;
        long tag = getCurrentTagOrDefault();
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            array = this.reader.readByteArrayNoTag();
        } else {
            array = this.reader.readByteArray();
        }
        return previousValue == null ? array : ArraysKt.plus(previousValue, array);
    }

    private final <T> T deserializeMap(DeserializationStrategy<? extends T> deserializationStrategy, T t) {
        Intrinsics.checkNotNull(deserializationStrategy, "null cannot be cast to non-null type kotlinx.serialization.internal.MapLikeSerializer<kotlin.Any?, kotlin.Any?, T of kotlinx.serialization.protobuf.internal.ProtobufDecoder.deserializeMap, *>");
        MapLikeSerializer serializer = (MapLikeSerializer) deserializationStrategy;
        KSerializer mapEntrySerial = BuiltinSerializersKt.MapEntrySerializer(serializer.getKeySerializer(), serializer.getValueSerializer());
        Map map = t instanceof Map ? (Map) t : null;
        Set oldSet = map != null ? map.entrySet() : null;
        Iterable setOfEntries = (Set) new LinkedHashSetSerializer(mapEntrySerial).merge(this, oldSet);
        Iterable $this$associateBy$iv = setOfEntries;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            Map.Entry it = (Map.Entry) element$iv$iv;
            Map.Entry it2 = (Map.Entry) element$iv$iv;
            destination$iv$iv.put(it.getKey(), it2.getValue());
        }
        return (T) destination$iv$iv;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected long getTag(SerialDescriptor $this$getTag, int index) {
        Intrinsics.checkNotNullParameter($this$getTag, "<this>");
        return HelpersKt.extractParameters($this$getTag, index);
    }

    public int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        while (true) {
            int protoId = this.reader.readTag();
            if (protoId == -1) {
                return this.elementMarker.nextUnmarkedIndex();
            }
            int index = getIndexByTag(protoId);
            if (index == -1) {
                this.reader.skipElement();
            } else {
                this.elementMarker.mark(index);
                return index;
            }
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !this.nullValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean readIfAbsent(SerialDescriptor descriptor, int index) {
        if (!descriptor.isElementOptional(index)) {
            SerialDescriptor elementDescriptor = descriptor.getElementDescriptor(index);
            SerialKind kind = elementDescriptor.getKind();
            if (Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE) || Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE)) {
                this.nullValue = false;
                return true;
            } else if (elementDescriptor.isNullable()) {
                this.nullValue = true;
                return true;
            }
        }
        return false;
    }
}