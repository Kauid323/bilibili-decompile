package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: PackedArrayDecoder.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0014J\u0018\u0010\u0013\u001a\u00060\u0011j\u0002`\u0012*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\nH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/protobuf/internal/PackedArrayDecoder;", "Lkotlinx/serialization/protobuf/internal/ProtobufDecoder;", "proto", "Lkotlinx/serialization/protobuf/ProtoBuf;", "reader", "Lkotlinx/serialization/protobuf/internal/ProtobufReader;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/protobuf/ProtoBuf;Lkotlinx/serialization/protobuf/internal/ProtobufReader;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "nextIndex", "", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeElementIndex", "decodeTaggedString", "", "tag", "", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "getTag", "index", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PackedArrayDecoder extends ProtobufDecoder {
    private int nextIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PackedArrayDecoder(ProtoBuf proto, ProtobufReader reader, SerialDescriptor descriptor) {
        super(proto, reader, descriptor);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected long getTag(SerialDescriptor $this$getTag, int index) {
        Intrinsics.checkNotNullParameter($this$getTag, "<this>");
        return ProtobufTaggedBaseKt.MISSING_TAG;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new SerializationException("Packing only supports primitive number types. The input type however was a struct: " + descriptor);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.reader.getEof()) {
            return -1;
        }
        int i = this.nextIndex;
        this.nextIndex = i + 1;
        return i;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected String decodeTaggedString(long tag) {
        throw new SerializationException("Packing only supports primitive number types. The actual reading is for string.");
    }
}