package kotlinx.io;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.io.unsafe.BufferIterationContext;
import kotlinx.io.unsafe.UnsafeBufferOperations;
import kotlinx.io.unsafe.UnsafeBufferOperationsKt;

/* compiled from: BuffersJvm.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a$\u0010\u0004\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001c\u0010\n\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a&\u0010\r\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u001a\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013\u001a\n\u0010\u0015\u001a\u00020\u0016*\u00020\u0001¨\u0006\u0017"}, d2 = {"transferFrom", "Lkotlinx/io/Buffer;", "input", "Ljava/io/InputStream;", "write", "byteCount", "", "", "forever", "", "readTo", "out", "Ljava/io/OutputStream;", "copyTo", "startIndex", "endIndex", "readAtMostTo", "", "sink", "Ljava/nio/ByteBuffer;", "source", "asByteChannel", "Ljava/nio/channels/ByteChannel;", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BuffersJvmKt {
    public static final Buffer transferFrom(Buffer $this$transferFrom, InputStream input) {
        Intrinsics.checkNotNullParameter($this$transferFrom, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        write($this$transferFrom, input, LongCompanionObject.MAX_VALUE, true);
        return $this$transferFrom;
    }

    public static final Buffer write(Buffer $this$write, InputStream input, long byteCount) {
        Intrinsics.checkNotNullParameter($this$write, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (byteCount >= 0) {
            write($this$write, input, byteCount, false);
            return $this$write;
        }
        throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
    }

    private static final void write(Buffer $this$write, InputStream input, long byteCount, boolean forever) {
        int bytesWritten$iv;
        long remainingByteCount = byteCount;
        boolean exchaused = false;
        while (!exchaused) {
            if (remainingByteCount > 0 || forever) {
                UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
                Segment tail$iv = $this$write.writableSegment(1);
                byte[] data$iv = tail$iv.dataAsByteArray(false);
                int pos = tail$iv.getLimit();
                int limit = data$iv.length;
                int b$iv = limit - pos;
                long a$iv = remainingByteCount;
                boolean exchaused2 = exchaused;
                int maxToCopy = (int) Math.min(a$iv, b$iv);
                int bytesRead = input.read(data$iv, pos, maxToCopy);
                if (bytesRead == -1) {
                    if (!forever) {
                        throw new EOFException("Stream exhausted before " + byteCount + " bytes were read.");
                    }
                    exchaused = true;
                    bytesWritten$iv = 0;
                } else {
                    remainingByteCount -= bytesRead;
                    bytesWritten$iv = bytesRead;
                    exchaused = exchaused2;
                }
                if (bytesWritten$iv == 1) {
                    tail$iv.writeBackData(data$iv, bytesWritten$iv);
                    tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                    $this$write.setSizeMut($this$write.getSizeMut() + bytesWritten$iv);
                } else {
                    if (!(bytesWritten$iv >= 0 && bytesWritten$iv <= tail$iv.getRemainingCapacity())) {
                        throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten$iv + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
                    }
                    if (bytesWritten$iv != 0) {
                        tail$iv.writeBackData(data$iv, bytesWritten$iv);
                        tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                        $this$write.setSizeMut($this$write.getSizeMut() + bytesWritten$iv);
                    } else if (SegmentKt.isEmpty(tail$iv)) {
                        $this$write.recycleTail();
                    }
                }
            } else {
                return;
            }
        }
    }

    public static /* synthetic */ void readTo$default(Buffer buffer, OutputStream outputStream, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = buffer.getSize();
        }
        readTo(buffer, outputStream, j);
    }

    public static final void readTo(Buffer $this$readTo, OutputStream out, long byteCount) {
        Intrinsics.checkNotNullParameter($this$readTo, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        _UtilKt.checkOffsetAndCount($this$readTo.getSize(), 0L, byteCount);
        long remainingByteCount = byteCount;
        while (remainingByteCount > 0) {
            UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
            if ($this$readTo.exhausted()) {
                throw new IllegalArgumentException("Buffer is empty".toString());
            }
            Segment head$iv = $this$readTo.getHead();
            Intrinsics.checkNotNull(head$iv);
            byte[] data = head$iv.dataAsByteArray(true);
            int pos = head$iv.getPos();
            int limit = head$iv.getLimit();
            int b$iv = limit - pos;
            long a$iv = remainingByteCount;
            int toCopy = (int) Math.min(a$iv, b$iv);
            out.write(data, pos, toCopy);
            remainingByteCount -= toCopy;
            if (toCopy != 0) {
                if (toCopy < 0) {
                    throw new IllegalStateException("Returned negative read bytes count");
                }
                if (toCopy > head$iv.getSize()) {
                    throw new IllegalStateException("Returned too many bytes");
                }
                $this$readTo.skip(toCopy);
            }
        }
    }

    public static /* synthetic */ void copyTo$default(Buffer buffer, OutputStream outputStream, long j, long j2, int i, Object obj) {
        long j3;
        long j4;
        if ((i & 2) == 0) {
            j3 = j;
        } else {
            j3 = 0;
        }
        if ((i & 4) == 0) {
            j4 = j2;
        } else {
            j4 = buffer.getSize();
        }
        copyTo(buffer, outputStream, j3, j4);
    }

    public static final void copyTo(Buffer $this$copyTo, OutputStream out, long startIndex, long endIndex) {
        BufferIterationContext ctx;
        BufferIterationContext ctx2;
        BufferIterationContext ctx3;
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        _UtilKt.checkBounds($this$copyTo.getSize(), startIndex, endIndex);
        if (startIndex == endIndex) {
            return;
        }
        long remainingByteCount = endIndex - startIndex;
        UnsafeBufferOperations this_$iv = UnsafeBufferOperations.INSTANCE;
        boolean z = false;
        if (!(startIndex >= 0)) {
            throw new IllegalArgumentException(("Offset must be non-negative: " + startIndex).toString());
        }
        if (startIndex >= $this$copyTo.getSize()) {
            throw new IndexOutOfBoundsException("Offset should be less than buffer's size (" + $this$copyTo.getSize() + "): " + startIndex);
        }
        Buffer $this$seek$iv$iv = $this$copyTo;
        if ($this$seek$iv$iv.getHead() == null) {
            Segment s$iv = null;
            long o$iv = -1;
            ctx3 = UnsafeBufferOperationsKt.BufferIterationContextImpl;
            BufferIterationContext ctx4 = ctx3;
            Intrinsics.checkNotNull(null);
            int currentOffset = (int) (startIndex - (-1));
            Segment curr = null;
            for (long j = 0; remainingByteCount > j; j = 0) {
                BufferIterationContext ctx5 = ctx4;
                UnsafeBufferOperations this_$iv2 = this_$iv;
                boolean z2 = z;
                byte[] data = curr.dataAsByteArray(true);
                int pos = curr.getPos();
                int limit = curr.getLimit();
                long b$iv = remainingByteCount;
                Segment s$iv2 = s$iv;
                long o$iv2 = o$iv;
                int toCopy = (int) Math.min((limit - pos) - currentOffset, b$iv);
                out.write(data, pos + currentOffset, toCopy);
                remainingByteCount -= toCopy;
                Segment next = ctx5.next(curr);
                if (next == null) {
                    break;
                }
                curr = next;
                currentOffset = 0;
                ctx4 = ctx5;
                this_$iv = this_$iv2;
                z = z2;
                s$iv = s$iv2;
                o$iv = o$iv2;
            }
        } else if ($this$seek$iv$iv.getSize() - startIndex < startIndex) {
            Segment s$iv$iv = $this$seek$iv$iv.getTail();
            long offset$iv$iv = $this$seek$iv$iv.getSize();
            while (s$iv$iv != null && offset$iv$iv > startIndex) {
                offset$iv$iv -= s$iv$iv.getLimit() - s$iv$iv.getPos();
                if (offset$iv$iv <= startIndex) {
                    break;
                }
                s$iv$iv = s$iv$iv.getPrev();
            }
            Segment s$iv3 = s$iv$iv;
            long o$iv3 = offset$iv$iv;
            ctx2 = UnsafeBufferOperationsKt.BufferIterationContextImpl;
            Intrinsics.checkNotNull(s$iv3);
            Segment curr2 = s$iv3;
            int currentOffset2 = (int) (startIndex - o$iv3);
            long remainingByteCount2 = remainingByteCount;
            while (remainingByteCount2 > 0) {
                Segment s$iv4 = s$iv3;
                long offset$iv$iv2 = offset$iv$iv;
                byte[] data2 = curr2.dataAsByteArray(true);
                int pos2 = curr2.getPos();
                int limit2 = curr2.getLimit();
                long b$iv2 = remainingByteCount2;
                long o$iv4 = o$iv3;
                int toCopy2 = (int) Math.min((limit2 - pos2) - currentOffset2, b$iv2);
                out.write(data2, pos2 + currentOffset2, toCopy2);
                remainingByteCount2 -= toCopy2;
                Segment next2 = ctx2.next(curr2);
                if (next2 == null) {
                    return;
                }
                curr2 = next2;
                currentOffset2 = 0;
                s$iv3 = s$iv4;
                offset$iv$iv = offset$iv$iv2;
                o$iv3 = o$iv4;
            }
        } else {
            Segment s$iv$iv2 = $this$seek$iv$iv.getHead();
            long offset$iv$iv3 = 0;
            while (s$iv$iv2 != null) {
                long nextOffset$iv$iv = (s$iv$iv2.getLimit() - s$iv$iv2.getPos()) + offset$iv$iv3;
                if (nextOffset$iv$iv > startIndex) {
                    break;
                }
                s$iv$iv2 = s$iv$iv2.getNext();
                offset$iv$iv3 = nextOffset$iv$iv;
            }
            Segment s$iv5 = s$iv$iv2;
            long o$iv5 = offset$iv$iv3;
            boolean z3 = false;
            ctx = UnsafeBufferOperationsKt.BufferIterationContextImpl;
            long segOffset = o$iv5;
            Intrinsics.checkNotNull(s$iv5);
            int currentOffset3 = (int) (startIndex - segOffset);
            long remainingByteCount3 = remainingByteCount;
            Segment curr3 = s$iv5;
            while (remainingByteCount3 > 0) {
                long o$iv6 = o$iv5;
                byte[] data3 = curr3.dataAsByteArray(true);
                int pos3 = curr3.getPos();
                int limit3 = curr3.getLimit();
                long b$iv3 = remainingByteCount3;
                boolean z4 = z3;
                Buffer $this$seek$iv$iv2 = $this$seek$iv$iv;
                long segOffset2 = segOffset;
                int a$iv = (int) Math.min((limit3 - pos3) - currentOffset3, b$iv3);
                out.write(data3, pos3 + currentOffset3, a$iv);
                remainingByteCount3 -= a$iv;
                Segment next3 = ctx.next(curr3);
                if (next3 == null) {
                    return;
                }
                curr3 = next3;
                currentOffset3 = 0;
                o$iv5 = o$iv6;
                $this$seek$iv$iv = $this$seek$iv$iv2;
                z3 = z4;
                segOffset = segOffset2;
            }
        }
    }

    public static final int readAtMostTo(Buffer $this$readAtMostTo, ByteBuffer sink) {
        Intrinsics.checkNotNullParameter($this$readAtMostTo, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if ($this$readAtMostTo.exhausted()) {
            return -1;
        }
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        if ($this$readAtMostTo.exhausted()) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head$iv = $this$readAtMostTo.getHead();
        Intrinsics.checkNotNull(head$iv);
        byte[] data = head$iv.dataAsByteArray(true);
        int pos = head$iv.getPos();
        int limit = head$iv.getLimit();
        int toCopy = Math.min(sink.remaining(), limit - pos);
        sink.put(data, pos, toCopy);
        if (toCopy != 0) {
            if (toCopy >= 0) {
                if (toCopy > head$iv.getSize()) {
                    throw new IllegalStateException("Returned too many bytes");
                }
                $this$readAtMostTo.skip(toCopy);
            } else {
                throw new IllegalStateException("Returned negative read bytes count");
            }
        }
        return toCopy;
    }

    public static final Buffer transferFrom(Buffer $this$transferFrom, ByteBuffer source) {
        Intrinsics.checkNotNullParameter($this$transferFrom, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int byteCount = source.remaining();
        int remaining = byteCount;
        while (remaining > 0) {
            UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
            Segment tail$iv = $this$transferFrom.writableSegment(1);
            boolean z = false;
            byte[] data$iv = tail$iv.dataAsByteArray(false);
            int pos = tail$iv.getLimit();
            int limit = data$iv.length;
            int toCopy = Math.min(remaining, limit - pos);
            source.get(data$iv, pos, toCopy);
            remaining -= toCopy;
            if (toCopy == 1) {
                tail$iv.writeBackData(data$iv, toCopy);
                tail$iv.setLimit(tail$iv.getLimit() + toCopy);
                $this$transferFrom.setSizeMut($this$transferFrom.getSizeMut() + toCopy);
            } else {
                if (toCopy >= 0 && toCopy <= tail$iv.getRemainingCapacity()) {
                    z = true;
                }
                if (!z) {
                    throw new IllegalStateException(("Invalid number of bytes written: " + toCopy + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
                }
                if (toCopy != 0) {
                    tail$iv.writeBackData(data$iv, toCopy);
                    tail$iv.setLimit(tail$iv.getLimit() + toCopy);
                    $this$transferFrom.setSizeMut($this$transferFrom.getSizeMut() + toCopy);
                } else if (SegmentKt.isEmpty(tail$iv)) {
                    $this$transferFrom.recycleTail();
                }
            }
        }
        return $this$transferFrom;
    }

    public static final ByteChannel asByteChannel(final Buffer $this$asByteChannel) {
        Intrinsics.checkNotNullParameter($this$asByteChannel, "<this>");
        return new ByteChannel() { // from class: kotlinx.io.BuffersJvmKt$asByteChannel$1
            @Override // java.nio.channels.ReadableByteChannel
            public int read(ByteBuffer sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                return BuffersJvmKt.readAtMostTo(Buffer.this, sink);
            }

            @Override // java.nio.channels.WritableByteChannel
            public int write(ByteBuffer source) {
                Intrinsics.checkNotNullParameter(source, "source");
                long sizeBefore = Buffer.this.getSize();
                BuffersJvmKt.transferFrom(Buffer.this, source);
                return (int) (Buffer.this.getSize() - sizeBefore);
            }

            @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.nio.channels.Channel
            public boolean isOpen() {
                return true;
            }
        };
    }
}