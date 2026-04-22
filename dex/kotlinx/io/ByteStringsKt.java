package kotlinx.io;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.bytestring.ByteString;
import kotlinx.io.bytestring.ByteStringKt;
import kotlinx.io.bytestring.unsafe.UnsafeByteStringOperations;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: ByteStrings.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\t\u001a\u0012\u0010\b\u001a\u00020\u0004*\u00020\t2\u0006\u0010\n\u001a\u00020\u0006\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\f\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\f¨\u0006\u000e"}, d2 = {"write", "", "Lkotlinx/io/Sink;", "byteString", "Lkotlinx/io/bytestring/ByteString;", "startIndex", "", "endIndex", "readByteString", "Lkotlinx/io/Source;", "byteCount", "indexOf", "", "Lkotlinx/io/Buffer;", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ByteStringsKt {
    public static /* synthetic */ void write$default(Sink sink, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.getSize();
        }
        write(sink, byteString, i, i2);
    }

    public static final void write(Sink $this$write, ByteString byteString, int startIndex, int endIndex) {
        int $i$f$withByteArrayUnsafe;
        UnsafeByteStringOperations this_$iv;
        int written = endIndex;
        Intrinsics.checkNotNullParameter($this$write, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        int size$iv = byteString.getSize();
        _UtilKt.checkBounds(size$iv, startIndex, written);
        if (written == startIndex) {
            return;
        }
        int $i$f$writeToInternalBuffer = 0;
        Buffer buffer = $this$write.getBuffer();
        int $i$f$withByteArrayUnsafe2 = 0;
        int offset = startIndex;
        UnsafeByteStringOperations this_$iv2 = UnsafeByteStringOperations.INSTANCE;
        int $i$f$withByteArrayUnsafe3 = 0;
        byte[] data = byteString.getBackingArrayReference();
        while (offset < written) {
            UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
            Segment tail$iv = buffer.writableSegment(1);
            byte[] data$iv = tail$iv.dataAsByteArray(false);
            int pos = tail$iv.getLimit();
            int $i$f$writeToInternalBuffer2 = $i$f$writeToInternalBuffer;
            int $i$f$writeToInternalBuffer3 = data$iv.length;
            int i = $i$f$withByteArrayUnsafe2;
            int written2 = Math.min(written - offset, $i$f$writeToInternalBuffer3 - pos);
            ArraysKt.copyInto(data, data$iv, pos, offset, offset + written2);
            if (written2 == 1) {
                tail$iv.writeBackData(data$iv, written2);
                tail$iv.setLimit(tail$iv.getLimit() + written2);
                $i$f$withByteArrayUnsafe = $i$f$withByteArrayUnsafe3;
                buffer.setSizeMut(buffer.getSizeMut() + written2);
                this_$iv = this_$iv2;
            } else {
                UnsafeByteStringOperations this_$iv3 = this_$iv2;
                $i$f$withByteArrayUnsafe = $i$f$withByteArrayUnsafe3;
                if (!(written2 >= 0 && written2 <= tail$iv.getRemainingCapacity())) {
                    throw new IllegalStateException(("Invalid number of bytes written: " + written2 + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
                }
                if (written2 != 0) {
                    tail$iv.writeBackData(data$iv, written2);
                    tail$iv.setLimit(tail$iv.getLimit() + written2);
                    this_$iv = this_$iv3;
                    buffer.setSizeMut(buffer.getSizeMut() + written2);
                } else {
                    this_$iv = this_$iv3;
                    if (SegmentKt.isEmpty(tail$iv)) {
                        buffer.recycleTail();
                    }
                }
            }
            offset += written2;
            written = endIndex;
            $i$f$withByteArrayUnsafe3 = $i$f$withByteArrayUnsafe;
            this_$iv2 = this_$iv;
            $i$f$writeToInternalBuffer = $i$f$writeToInternalBuffer2;
            $i$f$withByteArrayUnsafe2 = i;
        }
        $this$write.hintEmit();
    }

    public static final ByteString readByteString(Source $this$readByteString) {
        Intrinsics.checkNotNullParameter($this$readByteString, "<this>");
        return UnsafeByteStringOperations.INSTANCE.wrapUnsafe(SourcesKt.readByteArray($this$readByteString));
    }

    public static final ByteString readByteString(Source $this$readByteString, int byteCount) {
        Intrinsics.checkNotNullParameter($this$readByteString, "<this>");
        return UnsafeByteStringOperations.INSTANCE.wrapUnsafe(SourcesKt.readByteArray($this$readByteString, byteCount));
    }

    public static /* synthetic */ long indexOf$default(Source source, ByteString byteString, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return indexOf(source, byteString, j);
    }

    public static final long indexOf(Source $this$indexOf, ByteString byteString, long startIndex) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        long startIndex2 = Math.max(0L, startIndex);
        if (ByteStringKt.isEmpty(byteString)) {
            $this$indexOf.request(startIndex2);
            return Math.min(startIndex2, $this$indexOf.getBuffer().getSize());
        }
        long offset = startIndex2;
        while ($this$indexOf.request(byteString.getSize() + offset)) {
            long idx = indexOf($this$indexOf.getBuffer(), byteString, offset);
            if (idx < 0) {
                offset = ($this$indexOf.getBuffer().getSize() - byteString.getSize()) + 1;
            } else {
                return idx;
            }
        }
        return -1L;
    }

    public static /* synthetic */ long indexOf$default(Buffer buffer, ByteString byteString, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return indexOf(buffer, byteString, j);
    }

    public static final long indexOf(Buffer $this$indexOf, ByteString byteString, long startIndex) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        long startIndex2 = Math.max(0L, Math.min(startIndex, $this$indexOf.getSize()));
        if (ByteStringKt.isEmpty(byteString)) {
            return startIndex2;
        }
        if (startIndex2 > $this$indexOf.getSize() - byteString.getSize()) {
            return -1L;
        }
        UnsafeByteStringOperations this_$iv = UnsafeByteStringOperations.INSTANCE;
        byte[] byteStringData = byteString.getBackingArrayReference();
        if ($this$indexOf.getHead() != null) {
            if ($this$indexOf.getSize() - startIndex2 < startIndex2) {
                Segment s$iv = $this$indexOf.getTail();
                long offset$iv = $this$indexOf.getSize();
                while (s$iv != null && offset$iv > startIndex2) {
                    offset$iv -= s$iv.getLimit() - s$iv.getPos();
                    if (offset$iv <= startIndex2) {
                        break;
                    }
                    s$iv = s$iv.getPrev();
                }
                Segment seg = s$iv;
                long o = offset$iv;
                if (o == -1) {
                    return -1L;
                }
                Segment segment = seg;
                long offset = o;
                while (true) {
                    Intrinsics.checkNotNull(segment);
                    Segment s$iv2 = s$iv;
                    long offset$iv2 = offset$iv;
                    int startOffset = Math.max((int) (startIndex2 - offset), 0);
                    int idx = SegmentKt.indexOfBytesInbound(segment, byteStringData, startOffset);
                    if (idx != -1) {
                        return offset + idx;
                    }
                    int firstOutboundOffset = Math.max(startOffset, (segment.getSize() - byteStringData.length) + 1);
                    int idx1 = SegmentKt.indexOfBytesOutbound(segment, byteStringData, firstOutboundOffset);
                    if (idx1 != -1) {
                        return offset + idx1;
                    }
                    offset += segment.getSize();
                    segment = segment.getNext();
                    if (segment == null || offset + byteString.getSize() > $this$indexOf.getSize()) {
                        return -1L;
                    }
                    s$iv = s$iv2;
                    offset$iv = offset$iv2;
                }
            } else {
                Segment s$iv3 = $this$indexOf.getHead();
                long offset$iv3 = 0;
                while (s$iv3 != null) {
                    long nextOffset$iv = (s$iv3.getLimit() - s$iv3.getPos()) + offset$iv3;
                    if (nextOffset$iv > startIndex2) {
                        break;
                    }
                    s$iv3 = s$iv3.getNext();
                    offset$iv3 = nextOffset$iv;
                }
                Segment seg2 = s$iv3;
                long o2 = offset$iv3;
                if (o2 == -1) {
                    return -1L;
                }
                Segment segment2 = seg2;
                long offset2 = o2;
                while (true) {
                    Intrinsics.checkNotNull(segment2);
                    Segment s$iv4 = s$iv3;
                    long offset$iv4 = offset$iv3;
                    int startOffset2 = Math.max((int) (startIndex2 - offset2), 0);
                    int idx2 = SegmentKt.indexOfBytesInbound(segment2, byteStringData, startOffset2);
                    if (idx2 != -1) {
                        long startIndex3 = idx2;
                        return offset2 + startIndex3;
                    }
                    long startIndex4 = startIndex2;
                    int firstOutboundOffset2 = Math.max(startOffset2, (segment2.getSize() - byteStringData.length) + 1);
                    int idx12 = SegmentKt.indexOfBytesOutbound(segment2, byteStringData, firstOutboundOffset2);
                    if (idx12 != -1) {
                        return offset2 + idx12;
                    }
                    offset2 += segment2.getSize();
                    segment2 = segment2.getNext();
                    if (segment2 == null || offset2 + byteString.getSize() > $this$indexOf.getSize()) {
                        return -1L;
                    }
                    s$iv3 = s$iv4;
                    offset$iv3 = offset$iv4;
                    startIndex2 = startIndex4;
                }
            }
        } else if (-1 == -1) {
            return -1L;
        } else {
            long offset3 = -1;
            Segment segment3 = null;
            while (true) {
                Intrinsics.checkNotNull(segment3);
                int startOffset3 = Math.max((int) (startIndex2 - offset3), 0);
                UnsafeByteStringOperations this_$iv2 = this_$iv;
                Segment segment4 = segment3;
                int idx3 = SegmentKt.indexOfBytesInbound(segment4, byteStringData, startOffset3);
                if (idx3 != -1) {
                    return offset3 + idx3;
                }
                int firstOutboundOffset3 = Math.max(startOffset3, (segment4.getSize() - byteStringData.length) + 1);
                int idx13 = SegmentKt.indexOfBytesOutbound(segment4, byteStringData, firstOutboundOffset3);
                if (idx13 != -1) {
                    return offset3 + idx13;
                }
                offset3 += segment4.getSize();
                segment3 = segment4.getNext();
                if (segment3 == null || offset3 + byteString.getSize() > $this$indexOf.getSize()) {
                    return -1L;
                }
                this_$iv = this_$iv2;
            }
        }
    }
}