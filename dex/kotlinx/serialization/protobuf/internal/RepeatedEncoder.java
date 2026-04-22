package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: ProtobufEncoding.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00060\u0007j\u0002`\b*\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/protobuf/internal/RepeatedEncoder;", "Lkotlinx/serialization/protobuf/internal/ProtobufEncoder;", "proto", "Lkotlinx/serialization/protobuf/ProtoBuf;", "writer", "Lkotlinx/serialization/protobuf/internal/ProtobufWriter;", "curTag", "", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/protobuf/ProtoBuf;Lkotlinx/serialization/protobuf/internal/ProtobufWriter;JLkotlinx/serialization/descriptors/SerialDescriptor;)V", "getTag", "index", "", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RepeatedEncoder extends ProtobufEncoder {
    public final long curTag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepeatedEncoder(ProtoBuf proto, ProtobufWriter writer, long curTag, SerialDescriptor descriptor) {
        super(proto, writer, descriptor);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.curTag = curTag;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufEncoder, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected long getTag(SerialDescriptor $this$getTag, int index) {
        Intrinsics.checkNotNullParameter($this$getTag, "<this>");
        return this.curTag;
    }
}