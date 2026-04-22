package kotlinx.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.bytestring.ByteString;
import kotlinx.io.bytestring.ByteStringBuilder;
import kotlinx.io.bytestring.ByteStringKt;
import kotlinx.io.unsafe.SegmentReadContext;
import kotlinx.io.unsafe.UnsafeBufferOperations;
import kotlinx.io.unsafe.UnsafeBufferOperationsKt;

/* compiled from: Buffers.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a&\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"snapshot", "Lkotlinx/io/bytestring/ByteString;", "Lkotlinx/io/Buffer;", "indexOf", "", "byte", "", "startIndex", "endIndex", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BuffersKt {
    public static final ByteString snapshot(Buffer $this$snapshot) {
        SegmentReadContext segmentReadContext;
        Intrinsics.checkNotNullParameter($this$snapshot, "<this>");
        if ($this$snapshot.getSize() == 0) {
            return ByteStringKt.ByteString();
        }
        boolean z = true;
        if (!($this$snapshot.getSize() <= 2147483647L)) {
            throw new IllegalStateException(("Buffer is too long (" + $this$snapshot.getSize() + ") to be converted into a byte string.").toString());
        }
        int capacity$iv = (int) $this$snapshot.getSize();
        ByteStringBuilder $this$snapshot_u24lambda_u242 = new ByteStringBuilder(capacity$iv);
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Segment curr$iv = $this$snapshot.getHead();
        while (curr$iv != null) {
            segmentReadContext = UnsafeBufferOperationsKt.SegmentReadContextImpl;
            Segment segment = curr$iv;
            byte[] p0 = segment.dataAsByteArray(z);
            int p1 = segment.getPos();
            int capacity$iv2 = capacity$iv;
            int p2 = segment.getLimit();
            $this$snapshot_u24lambda_u242.append(p0, p1, p2);
            curr$iv = curr$iv.getNext();
            capacity$iv = capacity$iv2;
            z = true;
        }
        return $this$snapshot_u24lambda_u242.toByteString();
    }

    public static /* synthetic */ long indexOf$default(Buffer buffer, byte b, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = buffer.getSize();
        }
        return indexOf(buffer, b, j3, j2);
    }

    public static final long indexOf(Buffer $this$indexOf, byte b, long startIndex, long endIndex) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        long endOffset = Math.min(endIndex, $this$indexOf.getSize());
        _UtilKt.checkBounds($this$indexOf.getSize(), startIndex, endOffset);
        if (startIndex == endOffset) {
            return -1L;
        }
        Buffer $this$seek$iv = $this$indexOf;
        boolean z = false;
        int $i$f$seek = 0;
        if ($this$seek$iv.getHead() == null) {
            if (-1 == -1) {
                return -1L;
            }
            long offset = -1;
            Segment segment = null;
            while (true) {
                if ((endOffset > offset ? 1 : $i$f$seek) == 0) {
                    throw new IllegalStateException("Check failed.");
                }
                Intrinsics.checkNotNull(segment);
                Segment segment2 = segment;
                int idx = SegmentKt.indexOf(segment2, b, Math.max((int) (startIndex - offset), $i$f$seek), Math.min(segment.getSize(), (int) (endOffset - offset)));
                if (idx != -1) {
                    return offset + idx;
                }
                boolean z2 = z;
                offset += segment2.getSize();
                segment = segment2.getNext();
                if (segment == null || offset >= endOffset) {
                    return -1L;
                }
                z = z2;
                $i$f$seek = 0;
            }
        } else if ($this$seek$iv.getSize() - startIndex < startIndex) {
            Segment s$iv = $this$seek$iv.getTail();
            long offset$iv = $this$seek$iv.getSize();
            while (s$iv != null && offset$iv > startIndex) {
                offset$iv -= s$iv.getLimit() - s$iv.getPos();
                if (offset$iv <= startIndex) {
                    break;
                }
                s$iv = s$iv.getPrev();
            }
            Segment seg = s$iv;
            long o = offset$iv;
            if (o == -1) {
                return -1L;
            }
            long offset2 = o;
            Segment segment3 = seg;
            while (true) {
                if (!(endOffset > offset2)) {
                    throw new IllegalStateException("Check failed.");
                }
                Intrinsics.checkNotNull(segment3);
                Segment s$iv2 = s$iv;
                long offset$iv2 = offset$iv;
                Segment seg2 = seg;
                Segment segment4 = segment3;
                int idx2 = SegmentKt.indexOf(segment4, b, Math.max((int) (startIndex - offset2), 0), Math.min(segment3.getSize(), (int) (endOffset - offset2)));
                if (idx2 != -1) {
                    return offset2 + idx2;
                }
                offset2 += segment4.getSize();
                segment3 = segment4.getNext();
                if (segment3 == null || offset2 >= endOffset) {
                    return -1L;
                }
                s$iv = s$iv2;
                offset$iv = offset$iv2;
                seg = seg2;
            }
        } else {
            Segment s$iv3 = $this$seek$iv.getHead();
            long offset$iv3 = 0;
            while (s$iv3 != null) {
                long nextOffset$iv = (s$iv3.getLimit() - s$iv3.getPos()) + offset$iv3;
                if (nextOffset$iv > startIndex) {
                    break;
                }
                s$iv3 = s$iv3.getNext();
                offset$iv3 = nextOffset$iv;
            }
            Segment seg3 = s$iv3;
            long o2 = offset$iv3;
            if (o2 == -1) {
                return -1L;
            }
            long offset3 = o2;
            Segment segment5 = seg3;
            while (true) {
                if (!(endOffset > offset3)) {
                    throw new IllegalStateException("Check failed.");
                }
                Intrinsics.checkNotNull(segment5);
                Buffer $this$seek$iv2 = $this$seek$iv;
                Segment s$iv4 = s$iv3;
                int max = Math.max((int) (startIndex - offset3), 0);
                long offset$iv4 = offset$iv3;
                long offset$iv5 = endOffset - offset3;
                int min = Math.min(segment5.getSize(), (int) offset$iv5);
                Segment segment6 = segment5;
                int idx3 = SegmentKt.indexOf(segment6, b, max, min);
                if (idx3 != -1) {
                    return offset3 + idx3;
                }
                Segment seg4 = seg3;
                offset3 += segment6.getSize();
                segment5 = segment6.getNext();
                if (segment5 == null || offset3 >= endOffset) {
                    return -1L;
                }
                seg3 = seg4;
                $this$seek$iv = $this$seek$iv2;
                s$iv3 = s$iv4;
                offset$iv3 = offset$iv4;
            }
        }
    }
}