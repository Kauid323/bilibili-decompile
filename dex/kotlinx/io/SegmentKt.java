package kotlinx.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Segment.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0001¨\u0006\r"}, d2 = {"indexOf", "", "Lkotlinx/io/Segment;", "byte", "", "startOffset", "endOffset", "indexOfBytesInbound", "bytes", "", "indexOfBytesOutbound", "isEmpty", "", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SegmentKt {
    public static final int indexOf(Segment $this$indexOf, byte b, int startOffset, int endOffset) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        boolean z = false;
        if (!(startOffset >= 0 && startOffset < $this$indexOf.getSize())) {
            throw new IllegalArgumentException(String.valueOf(startOffset).toString());
        }
        if (startOffset <= endOffset && endOffset <= $this$indexOf.getSize()) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(endOffset).toString());
        }
        int p = $this$indexOf.getPos();
        byte[] data = $this$indexOf.dataAsByteArray(true);
        for (int idx = startOffset; idx < endOffset; idx++) {
            if (data[p + idx] == b) {
                return idx;
            }
        }
        return -1;
    }

    public static final int indexOfBytesInbound(Segment $this$indexOfBytesInbound, byte[] bytes, int startOffset) {
        int idx;
        Intrinsics.checkNotNullParameter($this$indexOfBytesInbound, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int limit = ($this$indexOfBytesInbound.getSize() - bytes.length) + 1;
        byte firstByte = bytes[0];
        byte[] data = $this$indexOfBytesInbound.dataAsByteArray(true);
        for (int offset = startOffset; offset < limit && (idx = indexOf($this$indexOfBytesInbound, firstByte, offset, limit)) >= 0; offset++) {
            boolean found = true;
            int innerIdx = 1;
            int length = bytes.length;
            while (true) {
                if (innerIdx < length) {
                    if (data[$this$indexOfBytesInbound.getPos() + idx + innerIdx] == bytes[innerIdx]) {
                        innerIdx++;
                    } else {
                        found = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (found) {
                return idx;
            }
        }
        return -1;
    }

    public static final int indexOfBytesOutbound(Segment $this$indexOfBytesOutbound, byte[] bytes, int startOffset) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$indexOfBytesOutbound, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int offset = startOffset;
        byte firstByte = bytes[0];
        while (true) {
            if (offset < 0 || offset >= $this$indexOfBytesOutbound.getSize()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return -1;
            }
            int idx = indexOf($this$indexOfBytesOutbound, firstByte, offset, $this$indexOfBytesOutbound.getSize());
            if (idx < 0) {
                return -1;
            }
            Segment seg = $this$indexOfBytesOutbound;
            byte[] data = seg.dataAsByteArray(true);
            int scanOffset = offset;
            boolean found = true;
            int length = bytes.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                byte element = bytes[i];
                if (scanOffset == seg.getSize()) {
                    Segment next = seg.getNext();
                    if (next == null) {
                        return -1;
                    }
                    seg = next;
                    data = seg.dataAsByteArray(true);
                    scanOffset = 0;
                }
                if (element == data[seg.getPos() + scanOffset]) {
                    scanOffset++;
                    i++;
                } else {
                    found = false;
                    break;
                }
            }
            if (found) {
                return offset;
            }
            offset++;
        }
    }

    public static final boolean isEmpty(Segment $this$isEmpty) {
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        return $this$isEmpty.getSize() == 0;
    }
}