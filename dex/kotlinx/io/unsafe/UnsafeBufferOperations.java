package kotlinx.io.unsafe;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.AlwaysSharedCopyTracker;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.SegmentKt;
import kotlinx.io._UtilKt;

/* compiled from: UnsafeBufferOperations.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005Jn\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2K\u0010\u0011\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u0012H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001J;\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0017H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001Jv\u0010\u001a\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00052K\u0010\u001c\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u0012H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001Ja\u0010\u001a\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000526\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00050\u0017H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001J[\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b28\u0010!\u001a4\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001e\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\t0\u0017H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001Jx\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2M\u0010!\u001aI\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001e\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110%¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\t0\u0012H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001JL\u0010(\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b26\u0010)\u001a2\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\t0\u0017H\u0086\bø\u0001\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"Lkotlinx/io/unsafe/UnsafeBufferOperations;", "", "<init>", "()V", "maxSafeWriteCapacity", "", "getMaxSafeWriteCapacity", "()I", "moveToTail", "", "buffer", "Lkotlinx/io/Buffer;", "bytes", "", "startIndex", "endIndex", "readFromHead", "readAction", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "startIndexInclusive", "endIndexExclusive", "Lkotlin/Function2;", "Lkotlinx/io/unsafe/SegmentReadContext;", "Lkotlinx/io/Segment;", "writeToTail", "minimumCapacity", "writeAction", "Lkotlinx/io/unsafe/SegmentWriteContext;", "context", "tail", "iterate", "iterationAction", "Lkotlinx/io/unsafe/BufferIterationContext;", "head", "offset", "", "segment", "startOfTheSegmentOffset", "forEachSegment", "action", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnsafeBufferOperations {
    public static final UnsafeBufferOperations INSTANCE = new UnsafeBufferOperations();

    private UnsafeBufferOperations() {
    }

    public final int getMaxSafeWriteCapacity() {
        return 8192;
    }

    public static /* synthetic */ void moveToTail$default(UnsafeBufferOperations unsafeBufferOperations, Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = bArr.length;
        }
        unsafeBufferOperations.moveToTail(buffer, bArr, i, i2);
    }

    public final void moveToTail(Buffer buffer, byte[] bytes, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int size$iv = bytes.length;
        _UtilKt.checkBounds(size$iv, startIndex, endIndex);
        Segment segment = Segment.Companion.new$kotlinx_io_core(bytes, startIndex, endIndex, AlwaysSharedCopyTracker.INSTANCE, false);
        Segment tail = buffer.getTail();
        if (tail == null) {
            buffer.setHead(segment);
            buffer.setTail(segment);
        } else {
            buffer.setTail(tail.push$kotlinx_io_core(segment));
        }
        buffer.setSizeMut(buffer.getSizeMut() + (endIndex - startIndex));
    }

    public final int readFromHead(Buffer buffer, Function3<? super byte[], ? super Integer, ? super Integer, Integer> readAction) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(readAction, "readAction");
        if (buffer.exhausted()) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head = buffer.getHead();
        Intrinsics.checkNotNull(head);
        int bytesRead = readAction.invoke(head.dataAsByteArray(true), Integer.valueOf(head.getPos()), Integer.valueOf(head.getLimit())).intValue();
        if (bytesRead != 0) {
            if (bytesRead < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (bytesRead > head.getSize()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            buffer.skip(bytesRead);
        }
        return bytesRead;
    }

    public final int readFromHead(Buffer buffer, Function2<? super SegmentReadContext, ? super Segment, Integer> readAction) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(readAction, "readAction");
        if (buffer.exhausted()) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head = buffer.getHead();
        Intrinsics.checkNotNull(head);
        int bytesRead = readAction.invoke(UnsafeBufferOperationsKt.getSegmentReadContextImpl(), head).intValue();
        if (bytesRead != 0) {
            if (bytesRead < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (bytesRead > head.getSize()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            buffer.skip(bytesRead);
        }
        return bytesRead;
    }

    public final int writeToTail(Buffer buffer, int minimumCapacity, Function3<? super byte[], ? super Integer, ? super Integer, Integer> writeAction) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(writeAction, "writeAction");
        Segment tail = buffer.writableSegment(minimumCapacity);
        boolean z = false;
        byte[] data = tail.dataAsByteArray(false);
        int bytesWritten = writeAction.invoke(data, Integer.valueOf(tail.getLimit()), Integer.valueOf(data.length)).intValue();
        if (bytesWritten == minimumCapacity) {
            tail.writeBackData(data, bytesWritten);
            tail.setLimit(tail.getLimit() + bytesWritten);
            buffer.setSizeMut(buffer.getSizeMut() + bytesWritten);
            return bytesWritten;
        }
        if (bytesWritten >= 0 && bytesWritten <= tail.getRemainingCapacity()) {
            z = true;
        }
        if (!z) {
            throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten + ". Should be in 0.." + tail.getRemainingCapacity()).toString());
        }
        if (bytesWritten != 0) {
            tail.writeBackData(data, bytesWritten);
            tail.setLimit(tail.getLimit() + bytesWritten);
            buffer.setSizeMut(buffer.getSizeMut() + bytesWritten);
            return bytesWritten;
        }
        if (SegmentKt.isEmpty(tail)) {
            buffer.recycleTail();
        }
        return bytesWritten;
    }

    public final int writeToTail(Buffer buffer, int minimumCapacity, Function2<? super SegmentWriteContext, ? super Segment, Integer> writeAction) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(writeAction, "writeAction");
        Segment tail = buffer.writableSegment(minimumCapacity);
        int bytesWritten = writeAction.invoke(UnsafeBufferOperationsKt.getSegmentWriteContextImpl(), tail).intValue();
        if (bytesWritten == minimumCapacity) {
            tail.setLimit(tail.getLimit() + bytesWritten);
            buffer.setSizeMut(buffer.getSizeMut() + bytesWritten);
            return bytesWritten;
        }
        boolean z = false;
        if (bytesWritten >= 0 && bytesWritten <= tail.getRemainingCapacity()) {
            z = true;
        }
        if (!z) {
            throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten + ". Should be in 0.." + tail.getRemainingCapacity()).toString());
        }
        if (bytesWritten != 0) {
            tail.setLimit(tail.getLimit() + bytesWritten);
            buffer.setSizeMut(buffer.getSizeMut() + bytesWritten);
            return bytesWritten;
        }
        if (SegmentKt.isEmpty(tail)) {
            buffer.recycleTail();
        }
        return bytesWritten;
    }

    public final void iterate(Buffer buffer, Function2<? super BufferIterationContext, ? super Segment, Unit> iterationAction) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(iterationAction, "iterationAction");
        iterationAction.invoke(UnsafeBufferOperationsKt.getBufferIterationContextImpl(), buffer.getHead());
    }

    public final void iterate(Buffer buffer, long offset, Function3<? super BufferIterationContext, ? super Segment, ? super Long, Unit> iterationAction) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(iterationAction, "iterationAction");
        if (!(offset >= 0)) {
            throw new IllegalArgumentException(("Offset must be non-negative: " + offset).toString());
        }
        if (offset >= buffer.getSize()) {
            throw new IndexOutOfBoundsException("Offset should be less than buffer's size (" + buffer.getSize() + "): " + offset);
        }
        if (buffer.getHead() == null) {
            iterationAction.invoke(UnsafeBufferOperationsKt.getBufferIterationContextImpl(), null, -1L);
        } else if (buffer.getSize() - offset < offset) {
            Segment s$iv = buffer.getTail();
            long offset$iv = buffer.getSize();
            while (s$iv != null && offset$iv > offset) {
                offset$iv -= s$iv.getLimit() - s$iv.getPos();
                if (offset$iv <= offset) {
                    break;
                }
                s$iv = s$iv.getPrev();
            }
            Segment s = s$iv;
            long o = offset$iv;
            iterationAction.invoke(UnsafeBufferOperationsKt.getBufferIterationContextImpl(), s, Long.valueOf(o));
        } else {
            Segment s$iv2 = buffer.getHead();
            long offset$iv2 = 0;
            while (s$iv2 != null) {
                long nextOffset$iv = (s$iv2.getLimit() - s$iv2.getPos()) + offset$iv2;
                if (nextOffset$iv > offset) {
                    break;
                }
                s$iv2 = s$iv2.getNext();
                offset$iv2 = nextOffset$iv;
            }
            Segment s2 = s$iv2;
            long o2 = offset$iv2;
            iterationAction.invoke(UnsafeBufferOperationsKt.getBufferIterationContextImpl(), s2, Long.valueOf(o2));
        }
    }

    public final void forEachSegment(Buffer buffer, Function2<? super SegmentReadContext, ? super Segment, Unit> action) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(action, "action");
        for (Segment curr = buffer.getHead(); curr != null; curr = curr.getNext()) {
            action.invoke(UnsafeBufferOperationsKt.getSegmentReadContextImpl(), curr);
        }
    }
}