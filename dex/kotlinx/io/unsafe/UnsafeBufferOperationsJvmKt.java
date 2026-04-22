package kotlinx.io.unsafe;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.SegmentKt;

/* compiled from: UnsafeBufferOperationsJvm.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aA\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001az\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000f2>\u0010\u0005\u001a:\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u0010H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001¢\u0006\u0002\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"readFromHead", "", "Lkotlinx/io/unsafe/UnsafeBufferOperations;", "buffer", "Lkotlinx/io/Buffer;", "readAction", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "", "writeToTail", "minimumCapacity", "writeAction", "readBulk", "", "iovec", "", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "iovecSize", "(Lkotlinx/io/unsafe/UnsafeBufferOperations;Lkotlinx/io/Buffer;[Ljava/nio/ByteBuffer;Lkotlin/jvm/functions/Function2;)J", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UnsafeBufferOperationsJvmKt {
    public static final int readFromHead(UnsafeBufferOperations $this$readFromHead, Buffer buffer, Function1<? super ByteBuffer, Unit> readAction) {
        Intrinsics.checkNotNullParameter($this$readFromHead, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(readAction, "readAction");
        if (buffer.exhausted()) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head$iv = buffer.getHead();
        Intrinsics.checkNotNull(head$iv);
        byte[] rawData = head$iv.dataAsByteArray(true);
        int pos = head$iv.getPos();
        int limit = head$iv.getLimit();
        ByteBuffer bb = ByteBuffer.wrap(rawData, pos, limit - pos).slice().asReadOnlyBuffer();
        Intrinsics.checkNotNull(bb);
        readAction.invoke(bb);
        int bytesRead$iv = bb.position();
        if (bytesRead$iv != 0) {
            if (bytesRead$iv < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (bytesRead$iv > head$iv.getSize()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            buffer.skip(bytesRead$iv);
        }
        return bytesRead$iv;
    }

    public static final int writeToTail(UnsafeBufferOperations $this$writeToTail, Buffer buffer, int minimumCapacity, Function1<? super ByteBuffer, Unit> writeAction) {
        Intrinsics.checkNotNullParameter($this$writeToTail, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(writeAction, "writeAction");
        Segment tail$iv = buffer.writableSegment(minimumCapacity);
        boolean z = false;
        byte[] data$iv = tail$iv.dataAsByteArray(false);
        int pos = tail$iv.getLimit();
        int limit = data$iv.length;
        ByteBuffer bb = ByteBuffer.wrap(data$iv, pos, limit - pos).slice();
        Intrinsics.checkNotNull(bb);
        writeAction.invoke(bb);
        int pos2 = bb.position();
        if (pos2 == minimumCapacity) {
            tail$iv.writeBackData(data$iv, pos2);
            tail$iv.setLimit(tail$iv.getLimit() + pos2);
            buffer.setSizeMut(buffer.getSizeMut() + pos2);
        } else {
            if (pos2 >= 0 && pos2 <= tail$iv.getRemainingCapacity()) {
                z = true;
            }
            if (!z) {
                throw new IllegalStateException(("Invalid number of bytes written: " + pos2 + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
            }
            if (pos2 != 0) {
                tail$iv.writeBackData(data$iv, pos2);
                tail$iv.setLimit(tail$iv.getLimit() + pos2);
                buffer.setSizeMut(buffer.getSizeMut() + pos2);
            } else if (SegmentKt.isEmpty(tail$iv)) {
                buffer.recycleTail();
            }
        }
        return pos2;
    }

    public static final long readBulk(UnsafeBufferOperations $this$readBulk, Buffer buffer, ByteBuffer[] iovec, Function2<? super ByteBuffer[], ? super Integer, Long> readAction) {
        int idx;
        Intrinsics.checkNotNullParameter($this$readBulk, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(iovec, "iovec");
        Intrinsics.checkNotNullParameter(readAction, "readAction");
        Segment head = buffer.getHead();
        if (head == null) {
            throw new IllegalArgumentException("buffer is empty.");
        }
        boolean z = true;
        if (iovec.length == 0) {
            throw new IllegalArgumentException("iovec is empty.");
        }
        Segment currentSegment = head;
        int idx2 = 0;
        long capacity = 0;
        while (true) {
            int pos = currentSegment.getPos();
            int limit = currentSegment.getLimit();
            int len = limit - pos;
            idx = idx2 + 1;
            iovec[idx2] = ByteBuffer.wrap(currentSegment.dataAsByteArray(z), pos, len).slice().asReadOnlyBuffer();
            capacity += len;
            Segment next = currentSegment.getNext();
            if (next == null) {
                break;
            }
            currentSegment = next;
            if (idx >= iovec.length) {
                break;
            }
            idx2 = idx;
            z = true;
        }
        long bytesRead = readAction.invoke(iovec, Integer.valueOf(idx)).longValue();
        if (bytesRead != 0) {
            if (bytesRead < 0 || bytesRead > capacity) {
                throw new IllegalStateException("readAction should return a value in range [0, " + capacity + "], but returned: " + bytesRead);
            }
            buffer.skip(bytesRead);
        }
        return bytesRead;
    }
}