package kotlinx.serialization.protobuf.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.MapLikeSerializer;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.protobuf.ProtoBuf;
import kotlinx.serialization.protobuf.ProtoIntegerType;

/* compiled from: ProtobufEncoding.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J)\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010\u0019\u001a\u0002H\u0016H\u0016¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u0019\u001a\u00020\u001fH\u0014J\u001c\u0010 \u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u0019\u001a\u00020!H\u0014J\u001c\u0010\"\u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u0019\u001a\u00020#H\u0014J\u001c\u0010$\u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u0019\u001a\u00020%H\u0014J$\u0010&\u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0012H\u0014J\u001c\u0010)\u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u0019\u001a\u00020*H\u0014J\u001c\u0010+\u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u0019\u001a\u00020\u0012H\u0014J\u001c\u0010,\u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u0019\u001a\u00020\u001dH\u0014J\u001c\u0010-\u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u0019\u001a\u00020.H\u0014J\u001c\u0010/\u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u0019\u001a\u000200H\u0014J\u0010\u00101\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u000202H\u0002J)\u00103\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010\u0019\u001a\u0002H\u0016H\u0002¢\u0006\u0002\u0010\u001aJ\u0018\u00104\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0012H\u0016J\u0018\u00106\u001a\u00060\u001dj\u0002`\u001e*\u00020\u00072\u0006\u00105\u001a\u00020\u0012H\u0014R\u0010\u0010\u0006\u001a\u00020\u00078\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ProtobufEncoder;", "Lkotlinx/serialization/protobuf/internal/ProtobufTaggedEncoder;", "proto", "Lkotlinx/serialization/protobuf/ProtoBuf;", "writer", "Lkotlinx/serialization/protobuf/internal/ProtobufWriter;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/protobuf/ProtoBuf;Lkotlinx/serialization/protobuf/internal/ProtobufWriter;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule$annotations", "()V", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginCollection", "Lkotlinx/serialization/encoding/CompositeEncoder;", "collectionSize", "", "beginStructure", "encodeSerializableValue", "", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeTaggedBoolean", "tag", "", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "", "encodeTaggedByte", "", "encodeTaggedChar", "", "encodeTaggedDouble", "", "encodeTaggedEnum", "enumDescriptor", "ordinal", "encodeTaggedFloat", "", "encodeTaggedInt", "encodeTaggedLong", "encodeTaggedShort", "", "encodeTaggedString", "", "serializeByteArray", "", "serializeMap", "shouldEncodeElementDefault", "index", "getTag", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ProtobufEncoder extends ProtobufTaggedEncoder {
    protected final SerialDescriptor descriptor;
    protected final ProtoBuf proto;
    private final ProtobufWriter writer;

    public static /* synthetic */ void getSerializersModule$annotations() {
    }

    public ProtobufEncoder(ProtoBuf proto, ProtobufWriter writer, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.proto = proto;
        this.writer = writer;
        this.descriptor = descriptor;
    }

    @Override // kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
    public SerializersModule getSerializersModule() {
        return this.proto.getSerializersModule();
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.proto.getEncodeDefaults$kotlinx_serialization_protobuf();
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginCollection(SerialDescriptor descriptor, int collectionSize) {
        RepeatedEncoder repeatedEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        SerialKind kind = descriptor.getKind();
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE)) {
            long tag = getCurrentTagOrDefault();
            if (HelpersKt.isPacked(tag) && HelpersKt.isPackable(descriptor.getElementDescriptor(0))) {
                repeatedEncoder = new PackedArrayEncoder(this.proto, this.writer, getCurrentTagOrDefault(), descriptor, null, 16, null);
            } else {
                if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
                    this.writer.writeInt(collectionSize);
                }
                if (Intrinsics.areEqual(this.descriptor.getKind(), StructureKind.LIST.INSTANCE) && tag != ProtobufTaggedBaseKt.MISSING_TAG && !Intrinsics.areEqual(this.descriptor, descriptor)) {
                    repeatedEncoder = new NestedRepeatedEncoder(this.proto, this.writer, tag, descriptor, null, 16, null);
                } else {
                    repeatedEncoder = new RepeatedEncoder(this.proto, this.writer, tag, descriptor);
                }
            }
            return repeatedEncoder;
        } else if (Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            return new MapRepeatedEncoder(this.proto, getCurrentTag(), this.writer, descriptor);
        } else {
            throw new SerializationException("This serial kind is not supported as collection: " + descriptor);
        }
    }

    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        RepeatedEncoder repeatedEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        SerialKind kind = descriptor.getKind();
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE)) {
            if (HelpersKt.isPackable(descriptor.getElementDescriptor(0)) && HelpersKt.isPacked(getCurrentTagOrDefault())) {
                repeatedEncoder = new PackedArrayEncoder(this.proto, this.writer, getCurrentTagOrDefault(), descriptor, null, 16, null);
            } else {
                repeatedEncoder = new RepeatedEncoder(this.proto, this.writer, getCurrentTagOrDefault(), descriptor);
            }
            return repeatedEncoder;
        }
        if (Intrinsics.areEqual(kind, StructureKind.CLASS.INSTANCE) ? true : Intrinsics.areEqual(kind, StructureKind.OBJECT.INSTANCE) ? true : kind instanceof PolymorphicKind) {
            long tag = getCurrentTagOrDefault();
            return (tag == ProtobufTaggedBaseKt.MISSING_TAG && Intrinsics.areEqual(descriptor, this.descriptor)) ? this : new ObjectEncoder(this.proto, getCurrentTagOrDefault(), this.writer, null, descriptor, 8, null);
        } else if (Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            return new MapRepeatedEncoder(this.proto, getCurrentTagOrDefault(), this.writer, descriptor);
        } else {
            throw new SerializationException("This serial kind is not supported as structure: " + descriptor);
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void encodeTaggedInt(long tag, int value) {
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            this.writer.writeInt(value);
        } else {
            this.writer.writeInt(value, (int) (2147483647L & tag), HelpersKt.getIntegerType(tag));
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void encodeTaggedByte(long tag, byte value) {
        encodeTaggedInt(tag, value);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void encodeTaggedShort(long tag, short value) {
        encodeTaggedInt(tag, value);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void encodeTaggedBoolean(long tag, boolean value) {
        encodeTaggedInt(tag, value ? 1 : 0);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void encodeTaggedChar(long tag, char value) {
        encodeTaggedInt(tag, value);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void encodeTaggedLong(long tag, long value) {
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            this.writer.writeLong(value);
        } else {
            this.writer.writeLong(value, (int) (2147483647L & tag), HelpersKt.getIntegerType(tag));
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void encodeTaggedFloat(long tag, float value) {
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            this.writer.writeFloat(value);
        } else {
            this.writer.writeFloat(value, (int) (2147483647L & tag));
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void encodeTaggedDouble(long tag, double value) {
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            this.writer.writeDouble(value);
        } else {
            this.writer.writeDouble(value, (int) (2147483647L & tag));
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void encodeTaggedString(long tag, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            this.writer.writeString(value);
        } else {
            this.writer.writeString(value, (int) (2147483647L & tag));
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void encodeTaggedEnum(long tag, SerialDescriptor enumDescriptor, int ordinal) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            this.writer.writeInt(HelpersKt.extractProtoId(enumDescriptor, ordinal, true));
        } else {
            this.writer.writeInt(HelpersKt.extractProtoId(enumDescriptor, ordinal, true), (int) (2147483647L & tag), ProtoIntegerType.DEFAULT);
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected long getTag(SerialDescriptor $this$getTag, int index) {
        Intrinsics.checkNotNullParameter($this$getTag, "<this>");
        return HelpersKt.extractParameters($this$getTag, index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder, kotlinx.serialization.encoding.Encoder
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (serializer instanceof MapLikeSerializer) {
            serializeMap(serializer, t);
        } else if (!Intrinsics.areEqual(serializer.getDescriptor(), BuiltinSerializersKt.ByteArraySerializer().getDescriptor())) {
            serializer.serialize(this, t);
        } else {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.ByteArray");
            serializeByteArray((byte[]) t);
        }
    }

    private final void serializeByteArray(byte[] value) {
        long tag = popTagOrDefault();
        if (tag == ProtobufTaggedBaseKt.MISSING_TAG) {
            this.writer.writeBytes(value);
        } else {
            this.writer.writeBytes(value, (int) (2147483647L & tag));
        }
    }

    private final <T> void serializeMap(SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNull(serializationStrategy, "null cannot be cast to non-null type kotlinx.serialization.internal.MapLikeSerializer<kotlin.Any?, kotlin.Any?, T of kotlinx.serialization.protobuf.internal.ProtobufEncoder.serializeMap, *>");
        MapLikeSerializer casted = (MapLikeSerializer) serializationStrategy;
        KSerializer mapEntrySerial = BuiltinSerializersKt.MapEntrySerializer(casted.getKeySerializer(), casted.getValueSerializer());
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        BuiltinSerializersKt.SetSerializer(mapEntrySerial).serialize(this, ((Map) t).entrySet());
    }
}