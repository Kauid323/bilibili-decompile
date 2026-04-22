package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: PackedArrayEncoder.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0018\u0010\u0018\u001a\u00060\u0007j\u0002`\b*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0011H\u0014¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/protobuf/internal/PackedArrayEncoder;", "Lkotlinx/serialization/protobuf/internal/NestedRepeatedEncoder;", "proto", "Lkotlinx/serialization/protobuf/ProtoBuf;", "writer", "Lkotlinx/serialization/protobuf/internal/ProtobufWriter;", "curTag", "", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "stream", "Lkotlinx/serialization/protobuf/internal/ByteArrayOutput;", "(Lkotlinx/serialization/protobuf/ProtoBuf;Lkotlinx/serialization/protobuf/internal/ProtobufWriter;JLkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/protobuf/internal/ByteArrayOutput;)V", "beginCollection", "Lkotlinx/serialization/encoding/CompositeEncoder;", "collectionSize", "", "beginStructure", "encodeTaggedString", "", "tag", "value", "", "getTag", "index", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PackedArrayEncoder extends NestedRepeatedEncoder {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PackedArrayEncoder(ProtoBuf protoBuf, ProtobufWriter protobufWriter, long j, SerialDescriptor serialDescriptor, ByteArrayOutput byteArrayOutput, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(protoBuf, protobufWriter, j, serialDescriptor, r6);
        ByteArrayOutput byteArrayOutput2;
        if ((i & 16) == 0) {
            byteArrayOutput2 = byteArrayOutput;
        } else {
            byteArrayOutput2 = new ByteArrayOutput();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PackedArrayEncoder(ProtoBuf proto, ProtobufWriter writer, long curTag, SerialDescriptor descriptor, ByteArrayOutput stream) {
        super(proto, writer, curTag, descriptor, stream);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(stream, "stream");
    }

    @Override // kotlinx.serialization.protobuf.internal.NestedRepeatedEncoder, kotlinx.serialization.protobuf.internal.ProtobufEncoder, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected long getTag(SerialDescriptor $this$getTag, int index) {
        Intrinsics.checkNotNullParameter($this$getTag, "<this>");
        return ProtobufTaggedBaseKt.MISSING_TAG;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufEncoder, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginCollection(SerialDescriptor descriptor, int collectionSize) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new SerializationException("Packing only supports primitive number types");
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new SerializationException("Packing only supports primitive number types");
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufEncoder, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void encodeTaggedString(long tag, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Packing only supports primitive number types");
    }
}