package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.protobuf.ProtoBuf;
import kotlinx.serialization.protobuf.ProtoIntegerType;

/* compiled from: ProtobufEncoding.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0010\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0018\u0010\u0010\u001a\u00060\u0007j\u0002`\b*\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/serialization/protobuf/internal/NestedRepeatedEncoder;", "Lkotlinx/serialization/protobuf/internal/ProtobufEncoder;", "proto", "Lkotlinx/serialization/protobuf/ProtoBuf;", "writer", "Lkotlinx/serialization/protobuf/internal/ProtobufWriter;", "curTag", "", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "stream", "Lkotlinx/serialization/protobuf/internal/ByteArrayOutput;", "(Lkotlinx/serialization/protobuf/ProtoBuf;Lkotlinx/serialization/protobuf/internal/ProtobufWriter;JLkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/protobuf/internal/ByteArrayOutput;)V", "endEncode", "", "getTag", "index", "", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class NestedRepeatedEncoder extends ProtobufEncoder {
    public final long curTag;
    public final ByteArrayOutput stream;
    public final ProtobufWriter writer;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ NestedRepeatedEncoder(ProtoBuf protoBuf, ProtobufWriter protobufWriter, long j, SerialDescriptor serialDescriptor, ByteArrayOutput byteArrayOutput, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(protoBuf, protobufWriter, j, serialDescriptor, r6);
        ByteArrayOutput byteArrayOutput2;
        if ((i & 16) == 0) {
            byteArrayOutput2 = byteArrayOutput;
        } else {
            byteArrayOutput2 = new ByteArrayOutput();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedRepeatedEncoder(ProtoBuf proto, ProtobufWriter writer, long curTag, SerialDescriptor descriptor, ByteArrayOutput stream) {
        super(proto, new ProtobufWriter(stream), descriptor);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.writer = writer;
        this.curTag = curTag;
        this.stream = stream;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufEncoder, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected long getTag(SerialDescriptor $this$getTag, int index) {
        Intrinsics.checkNotNullParameter($this$getTag, "<this>");
        ProtoIntegerType type$iv = ProtoIntegerType.DEFAULT;
        return type$iv.getSignature$kotlinx_serialization_protobuf() | 1;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void endEncode(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        ProtobufWriter protobufWriter = this.writer;
        ByteArrayOutput byteArrayOutput = this.stream;
        long $this$protoId$iv = this.curTag;
        protobufWriter.writeOutput(byteArrayOutput, (int) (2147483647L & $this$protoId$iv));
    }
}