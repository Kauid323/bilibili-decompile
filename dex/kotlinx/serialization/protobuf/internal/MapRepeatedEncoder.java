package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.protobuf.ProtoBuf;
import kotlinx.serialization.protobuf.ProtoIntegerType;

/* compiled from: ProtobufEncoding.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00060\u0005j\u0002`\u0006*\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/protobuf/internal/MapRepeatedEncoder;", "Lkotlinx/serialization/protobuf/internal/ObjectEncoder;", "proto", "Lkotlinx/serialization/protobuf/ProtoBuf;", "parentTag", "", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "parentWriter", "Lkotlinx/serialization/protobuf/internal/ProtobufWriter;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/protobuf/ProtoBuf;JLkotlinx/serialization/protobuf/internal/ProtobufWriter;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getTag", "index", "", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MapRepeatedEncoder extends ObjectEncoder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapRepeatedEncoder(ProtoBuf proto, long parentTag, ProtobufWriter parentWriter, SerialDescriptor descriptor) {
        super(proto, parentTag, parentWriter, null, descriptor, 8, null);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(parentWriter, "parentWriter");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufEncoder, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected long getTag(SerialDescriptor $this$getTag, int index) {
        Intrinsics.checkNotNullParameter($this$getTag, "<this>");
        if (index % 2 != 0) {
            ProtoIntegerType type$iv = HelpersKt.getIntegerType(this.parentTag);
            return type$iv.getSignature$kotlinx_serialization_protobuf() | 2;
        }
        ProtoIntegerType type$iv2 = HelpersKt.getIntegerType(this.parentTag);
        return type$iv2.getSignature$kotlinx_serialization_protobuf() | 1;
    }
}