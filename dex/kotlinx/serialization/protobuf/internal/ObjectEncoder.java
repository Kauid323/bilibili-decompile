package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: ProtobufEncoding.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u0014\u0010\u0004\u001a\u00060\u0005j\u0002`\u00068\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ObjectEncoder;", "Lkotlinx/serialization/protobuf/internal/ProtobufEncoder;", "proto", "Lkotlinx/serialization/protobuf/ProtoBuf;", "parentTag", "", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "parentWriter", "Lkotlinx/serialization/protobuf/internal/ProtobufWriter;", "stream", "Lkotlinx/serialization/protobuf/internal/ByteArrayOutput;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/protobuf/ProtoBuf;JLkotlinx/serialization/protobuf/internal/ProtobufWriter;Lkotlinx/serialization/protobuf/internal/ByteArrayOutput;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "endEncode", "", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
class ObjectEncoder extends ProtobufEncoder {
    protected final long parentTag;
    protected final ProtobufWriter parentWriter;
    protected final ByteArrayOutput stream;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ObjectEncoder(ProtoBuf protoBuf, long j, ProtobufWriter protobufWriter, ByteArrayOutput byteArrayOutput, SerialDescriptor serialDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(protoBuf, j, protobufWriter, r5, serialDescriptor);
        ByteArrayOutput byteArrayOutput2;
        if ((i & 8) == 0) {
            byteArrayOutput2 = byteArrayOutput;
        } else {
            byteArrayOutput2 = new ByteArrayOutput();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectEncoder(ProtoBuf proto, long parentTag, ProtobufWriter parentWriter, ByteArrayOutput stream, SerialDescriptor descriptor) {
        super(proto, new ProtobufWriter(stream), descriptor);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(parentWriter, "parentWriter");
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.parentTag = parentTag;
        this.parentWriter = parentWriter;
        this.stream = stream;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void endEncode(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.parentTag != ProtobufTaggedBaseKt.MISSING_TAG) {
            ProtobufWriter protobufWriter = this.parentWriter;
            ByteArrayOutput byteArrayOutput = this.stream;
            long $this$protoId$iv = this.parentTag;
            protobufWriter.writeOutput(byteArrayOutput, (int) (2147483647L & $this$protoId$iv));
            return;
        }
        this.parentWriter.writeOutput(this.stream);
    }
}