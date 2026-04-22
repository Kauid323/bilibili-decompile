package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: ProtobufDecoding.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00060\u0007j\u0002`\b*\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/serialization/protobuf/internal/RepeatedDecoder;", "Lkotlinx/serialization/protobuf/internal/ProtobufDecoder;", "proto", "Lkotlinx/serialization/protobuf/ProtoBuf;", "decoder", "Lkotlinx/serialization/protobuf/internal/ProtobufReader;", "currentTag", "", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/protobuf/ProtoBuf;Lkotlinx/serialization/protobuf/internal/ProtobufReader;JLkotlinx/serialization/descriptors/SerialDescriptor;)V", "index", "", "tagOrSize", "decodeElementIndex", "decodeListIndexNoTag", "decodeTaggedListIndex", "getTag", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RepeatedDecoder extends ProtobufDecoder {
    private int index;
    private final long tagOrSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepeatedDecoder(ProtoBuf proto, ProtobufReader decoder, long currentTag, SerialDescriptor descriptor) {
        super(proto, decoder, descriptor);
        long j;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.index = -1;
        if (currentTag == ProtobufTaggedBaseKt.MISSING_TAG) {
            int length = this.reader.readInt32NoTag();
            if (!(length >= 0)) {
                throw new IllegalArgumentException(("Expected positive length for " + descriptor + ", but got " + length).toString());
            }
            j = -length;
        } else {
            j = currentTag;
        }
        this.tagOrSize = j;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.tagOrSize > 0) {
            return decodeTaggedListIndex();
        }
        return decodeListIndexNoTag();
    }

    private final int decodeListIndexNoTag() {
        long size = -this.tagOrSize;
        this.index++;
        int idx = this.index;
        if (idx == size || this.reader.getEof()) {
            return -1;
        }
        return idx;
    }

    private final int decodeTaggedListIndex() {
        int protoId;
        if (this.index == -1) {
            protoId = this.reader.currentId;
        } else {
            protoId = this.reader.readTag();
        }
        long $this$protoId$iv = this.tagOrSize;
        if (protoId == ((int) (2147483647L & $this$protoId$iv))) {
            this.index++;
            return this.index;
        }
        this.reader.pushBackTag();
        return -1;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.protobuf.internal.ProtobufTaggedDecoder
    protected long getTag(SerialDescriptor $this$getTag, int index) {
        Intrinsics.checkNotNullParameter($this$getTag, "<this>");
        return this.tagOrSize > 0 ? this.tagOrSize : ProtobufTaggedBaseKt.MISSING_TAG;
    }
}