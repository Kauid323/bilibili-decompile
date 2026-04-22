package kotlinx.io;

import java.io.EOFException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.io.unsafe.SegmentReadContext;
import kotlinx.io.unsafe.UnsafeBufferOperations;
import kotlinx.io.unsafe.UnsafeBufferOperationsKt;

/* compiled from: Buffer.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u000f\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0011H\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0011H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0011H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010!\u001a\u00020\u0011H\u0002J\b\u0010,\u001a\u00020 H\u0017J\b\u0010-\u001a\u00020 H\u0016J\b\u0010.\u001a\u00020 H\u0016J\"\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u00002\b\b\u0002\u00101\u001a\u00020\u00112\b\b\u0002\u00102\u001a\u00020\u0011J\r\u00103\u001a\u00020\u0011H\u0000¢\u0006\u0002\b4J\u0011\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u0011H\u0086\u0002J\u0006\u00107\u001a\u00020 J\u0010\u00108\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0011H\u0016J \u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020(H\u0016J\u0018\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0011H\u0016J\u0018\u0010<\u001a\u00020 2\u0006\u0010:\u001a\u00020=2\u0006\u0010!\u001a\u00020\u0011H\u0016J\u0010\u0010>\u001a\u00020\u00112\u0006\u0010:\u001a\u00020=H\u0016J\b\u0010?\u001a\u00020\u0001H\u0016J\u0010\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020(H\u0001J \u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020;2\u0006\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020(H\u0016J\u0018\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020D2\u0006\u0010!\u001a\u00020\u0011H\u0016J\u0018\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0011H\u0016J\u0010\u0010E\u001a\u00020\u00112\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020$H\u0016J\u0010\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020&H\u0016J\u0010\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020(H\u0016J\u0010\u0010L\u001a\u00020 2\u0006\u0010M\u001a\u00020\u0011H\u0016J\u0006\u0010N\u001a\u00020\u0000J\b\u0010O\u001a\u00020 H\u0016J\b\u0010P\u001a\u00020QH\u0016J\r\u0010R\u001a\u00020 H\u0000¢\u0006\u0002\bSJ\b\u0010T\u001a\u00020 H\u0001J\u001b\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u00062\b\b\u0002\u0010W\u001a\u00020\u001eH\u0082\bR&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\f\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00008VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u001c¨\u0006X"}, d2 = {"Lkotlinx/io/Buffer;", "Lkotlinx/io/Source;", "Lkotlinx/io/Sink;", "<init>", "()V", "head", "Lkotlinx/io/Segment;", "getHead$annotations", "getHead", "()Lkotlinx/io/Segment;", "setHead", "(Lkotlinx/io/Segment;)V", "tail", "getTail$annotations", "getTail", "setTail", "size", "", "getSize", "()J", "sizeMut", "getSizeMut$annotations", "getSizeMut", "setSizeMut", "(J)V", "buffer", "getBuffer$annotations", "getBuffer", "()Lkotlinx/io/Buffer;", "exhausted", "", "require", "", "byteCount", "request", "readByte", "", "readShort", "", "readInt", "", "readLong", "throwEof", "", "hintEmit", "emit", "flush", "copyTo", "out", "startIndex", "endIndex", "completeSegmentByteCount", "completeSegmentByteCount$kotlinx_io_core", "get", "position", "clear", "skip", "readAtMostTo", "sink", "", "readTo", "Lkotlinx/io/RawSink;", "transferTo", "peek", "writableSegment", "minimumCapacity", "write", "source", "Lkotlinx/io/RawSource;", "transferFrom", "writeByte", "byte", "writeShort", "short", "writeInt", "int", "writeLong", "long", "copy", "close", "toString", "", "recycleHead", "recycleHead$kotlinx_io_core", "recycleTail", "pushSegment", "newTail", "tryCompact", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Buffer implements Source, Sink {
    private Segment head;
    private long sizeMut;
    private Segment tail;

    public static /* synthetic */ void getBuffer$annotations() {
    }

    public static /* synthetic */ void getHead$annotations() {
    }

    public static /* synthetic */ void getSizeMut$annotations() {
    }

    public static /* synthetic */ void getTail$annotations() {
    }

    public final /* synthetic */ Segment getHead() {
        return this.head;
    }

    public final /* synthetic */ void setHead(Segment segment) {
        this.head = segment;
    }

    public final /* synthetic */ Segment getTail() {
        return this.tail;
    }

    public final /* synthetic */ void setTail(Segment segment) {
        this.tail = segment;
    }

    public final long getSize() {
        return this.sizeMut;
    }

    public final /* synthetic */ long getSizeMut() {
        return this.sizeMut;
    }

    public final /* synthetic */ void setSizeMut(long j) {
        this.sizeMut = j;
    }

    @Override // kotlinx.io.Source, kotlinx.io.Sink
    public Buffer getBuffer() {
        return this;
    }

    @Override // kotlinx.io.Source
    public boolean exhausted() {
        return getSize() == 0;
    }

    @Override // kotlinx.io.Source
    public void require(long byteCount) {
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (getSize() < byteCount) {
            throw new EOFException("Buffer doesn't contain required number of bytes (size: " + getSize() + ", required: " + byteCount + ')');
        }
    }

    @Override // kotlinx.io.Source
    public boolean request(long byteCount) {
        if (byteCount >= 0) {
            return getSize() >= byteCount;
        }
        throw new IllegalArgumentException(("byteCount: " + byteCount + " < 0").toString());
    }

    @Override // kotlinx.io.Source
    public byte readByte() {
        Segment segment = this.head;
        if (segment == null) {
            throwEof(1L);
            throw new KotlinNothingValueException();
        }
        int segmentSize = segment.getSize();
        if (segmentSize == 0) {
            recycleHead$kotlinx_io_core();
            return readByte();
        }
        byte v = segment.readByte$kotlinx_io_core();
        this.sizeMut--;
        if (segmentSize == 1) {
            recycleHead$kotlinx_io_core();
        }
        return v;
    }

    @Override // kotlinx.io.Source
    public short readShort() {
        Segment segment = this.head;
        if (segment == null) {
            throwEof(2L);
            throw new KotlinNothingValueException();
        }
        int segmentSize = segment.getSize();
        if (segmentSize < 2) {
            require(2L);
            if (segmentSize == 0) {
                recycleHead$kotlinx_io_core();
                return readShort();
            }
            byte $this$and$iv = readByte();
            byte $this$and$iv2 = readByte();
            return (short) ((($this$and$iv & 255) << 8) | ($this$and$iv2 & 255));
        }
        short v = segment.readShort$kotlinx_io_core();
        this.sizeMut -= 2;
        if (segmentSize == 2) {
            recycleHead$kotlinx_io_core();
        }
        return v;
    }

    @Override // kotlinx.io.Source
    public int readInt() {
        Segment segment = this.head;
        if (segment == null) {
            throwEof(4L);
            throw new KotlinNothingValueException();
        }
        int segmentSize = segment.getSize();
        if (segmentSize < 4) {
            require(4L);
            if (segmentSize == 0) {
                recycleHead$kotlinx_io_core();
                return readInt();
            }
            return (readShort() << 16) | (readShort() & 65535);
        }
        int v = segment.readInt$kotlinx_io_core();
        this.sizeMut -= 4;
        if (segmentSize == 4) {
            recycleHead$kotlinx_io_core();
        }
        return v;
    }

    @Override // kotlinx.io.Source
    public long readLong() {
        Segment segment = this.head;
        if (segment == null) {
            throwEof(8L);
            throw new KotlinNothingValueException();
        }
        int segmentSize = segment.getSize();
        if (segmentSize < 8) {
            require(8L);
            if (segmentSize == 0) {
                recycleHead$kotlinx_io_core();
                return readLong();
            }
            return (readInt() << 32) | (readInt() & 4294967295L);
        }
        long v = segment.readLong$kotlinx_io_core();
        this.sizeMut -= 8;
        if (segmentSize == 8) {
            recycleHead$kotlinx_io_core();
        }
        return v;
    }

    private final Void throwEof(long byteCount) {
        throw new EOFException("Buffer doesn't contain required number of bytes (size: " + getSize() + ", required: " + byteCount + ')');
    }

    @Override // kotlinx.io.Sink
    public void hintEmit() {
    }

    @Override // kotlinx.io.Sink
    public void emit() {
    }

    @Override // kotlinx.io.Sink, kotlinx.io.RawSink, java.io.Flushable
    public void flush() {
    }

    public static /* synthetic */ void copyTo$default(Buffer buffer, Buffer buffer2, long j, long j2, int i, Object obj) {
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
        buffer.copyTo(buffer2, j3, j4);
    }

    public final void copyTo(Buffer out, long startIndex, long endIndex) {
        Intrinsics.checkNotNullParameter(out, "out");
        _UtilKt.checkBounds(getSize(), startIndex, endIndex);
        if (startIndex == endIndex) {
            return;
        }
        long currentOffset = startIndex;
        long remainingByteCount = endIndex - startIndex;
        out.sizeMut += remainingByteCount;
        Segment s = this.head;
        while (true) {
            Intrinsics.checkNotNull(s);
            if (currentOffset < s.getLimit() - s.getPos()) {
                break;
            }
            currentOffset -= s.getLimit() - s.getPos();
            s = s.getNext();
        }
        while (remainingByteCount > 0) {
            Intrinsics.checkNotNull(s);
            Segment copy = s.sharedCopy$kotlinx_io_core();
            copy.setPos(copy.getPos() + ((int) currentOffset));
            copy.setLimit(Math.min(copy.getPos() + ((int) remainingByteCount), copy.getLimit()));
            if (out.getHead() == null) {
                out.setHead(copy);
                out.setTail(copy);
            } else {
                Segment tail = out.getTail();
                Intrinsics.checkNotNull(tail);
                out.setTail(tail.push$kotlinx_io_core(copy));
            }
            remainingByteCount -= copy.getLimit() - copy.getPos();
            currentOffset = 0;
            s = s.getNext();
        }
    }

    public final long completeSegmentByteCount$kotlinx_io_core() {
        long result = getSize();
        if (result == 0) {
            return 0L;
        }
        Segment tail = this.tail;
        Intrinsics.checkNotNull(tail);
        if (tail.getLimit() < 8192 && tail.owner) {
            return result - (tail.getLimit() - tail.getPos());
        }
        return result;
    }

    public final byte get(long position) {
        Segment s;
        long offset;
        if (position < 0 || position >= getSize()) {
            throw new IndexOutOfBoundsException("position (" + position + ") is not within the range [0..size(" + getSize() + "))");
        }
        if (position == 0) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            return segment.getUnchecked$kotlinx_io_core(0);
        } else if (getHead() == null) {
            Segment s2 = null;
            Intrinsics.checkNotNull(null);
            return s2.getUnchecked$kotlinx_io_core((int) (position - (-1)));
        } else {
            if (getSize() - position < position) {
                Segment s$iv = getTail();
                long offset$iv = getSize();
                while (s$iv != null && offset$iv > position) {
                    offset$iv -= s$iv.getLimit() - s$iv.getPos();
                    if (offset$iv <= position) {
                        break;
                    }
                    s$iv = s$iv.getPrev();
                }
                s = s$iv;
                offset = offset$iv;
            } else {
                Segment s$iv2 = getHead();
                long offset$iv2 = 0;
                while (s$iv2 != null) {
                    long nextOffset$iv = (s$iv2.getLimit() - s$iv2.getPos()) + offset$iv2;
                    if (nextOffset$iv > position) {
                        break;
                    }
                    s$iv2 = s$iv2.getNext();
                    offset$iv2 = nextOffset$iv;
                }
                s = s$iv2;
                offset = offset$iv2;
            }
            Intrinsics.checkNotNull(s);
            return s.getUnchecked$kotlinx_io_core((int) (position - offset));
        }
    }

    public final void clear() {
        skip(getSize());
    }

    @Override // kotlinx.io.Source
    public void skip(long byteCount) {
        if (byteCount >= 0) {
            long remainingByteCount = byteCount;
            while (remainingByteCount > 0) {
                Segment head = this.head;
                if (head == null) {
                    throw new EOFException("Buffer exhausted before skipping " + byteCount + " bytes.");
                }
                int b$iv = (int) Math.min(remainingByteCount, head.getLimit() - head.getPos());
                this.sizeMut -= b$iv;
                remainingByteCount -= b$iv;
                head.setPos(head.getPos() + b$iv);
                if (head.getPos() == head.getLimit()) {
                    recycleHead$kotlinx_io_core();
                }
            }
            return;
        }
        throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
    }

    @Override // kotlinx.io.Source
    public int readAtMostTo(byte[] sink, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int size$iv = sink.length;
        _UtilKt.checkBounds(size$iv, startIndex, endIndex);
        Segment s = this.head;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(endIndex - startIndex, s.getSize());
        s.readTo$kotlinx_io_core(sink, startIndex, startIndex + toCopy);
        this.sizeMut -= toCopy;
        if (SegmentKt.isEmpty(s)) {
            recycleHead$kotlinx_io_core();
        }
        return toCopy;
    }

    @Override // kotlinx.io.RawSource
    public long readAtMostTo(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount >= 0) {
            if (getSize() == 0) {
                return -1L;
            }
            long bytesWritten = byteCount > getSize() ? getSize() : byteCount;
            sink.write(this, bytesWritten);
            return bytesWritten;
        }
        throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
    }

    @Override // kotlinx.io.Source
    public void readTo(RawSink sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount >= 0) {
            if (getSize() < byteCount) {
                sink.write(this, getSize());
                throw new EOFException("Buffer exhausted before writing " + byteCount + " bytes. Only " + getSize() + " bytes were written.");
            } else {
                sink.write(this, byteCount);
                return;
            }
        }
        throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
    }

    @Override // kotlinx.io.Source
    public long transferTo(RawSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long byteCount = getSize();
        if (byteCount > 0) {
            sink.write(this, byteCount);
        }
        return byteCount;
    }

    @Override // kotlinx.io.Source
    public Source peek() {
        return CoreKt.buffered(new PeekSource(this));
    }

    public final /* synthetic */ Segment writableSegment(int minimumCapacity) {
        boolean z = true;
        if (!((minimumCapacity < 1 || minimumCapacity > 8192) ? false : false)) {
            throw new IllegalArgumentException(("unexpected capacity (" + minimumCapacity + "), should be in range [1, 8192]").toString());
        }
        if (this.tail == null) {
            Segment result = SegmentPool.take();
            this.head = result;
            this.tail = result;
            return result;
        }
        Segment t = this.tail;
        Intrinsics.checkNotNull(t);
        if (t.getLimit() + minimumCapacity > 8192 || !t.owner) {
            Segment newTail = t.push$kotlinx_io_core(SegmentPool.take());
            this.tail = newTail;
            return newTail;
        }
        return t;
    }

    @Override // kotlinx.io.Sink
    public void write(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        int size$iv = source.length;
        _UtilKt.checkBounds(size$iv, startIndex, endIndex);
        int currentOffset = startIndex;
        while (currentOffset < endIndex) {
            Segment tail = writableSegment(1);
            int toCopy = Math.min(endIndex - currentOffset, tail.getRemainingCapacity());
            tail.write$kotlinx_io_core(source, currentOffset, currentOffset + toCopy);
            currentOffset += toCopy;
        }
        this.sizeMut += endIndex - startIndex;
    }

    @Override // kotlinx.io.Sink
    public void write(RawSource source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (byteCount >= 0) {
            long remainingByteCount = byteCount;
            while (remainingByteCount > 0) {
                long read = source.readAtMostTo(this, remainingByteCount);
                if (read == -1) {
                    throw new EOFException("Source exhausted before reading " + byteCount + " bytes. Only " + (byteCount - remainingByteCount) + " were read.");
                }
                remainingByteCount -= read;
            }
            return;
        }
        throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
    }

    @Override // kotlinx.io.RawSink
    public void write(Buffer source, long byteCount) {
        Segment segment;
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(source != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        _UtilKt.checkOffsetAndCount(source.sizeMut, 0L, byteCount);
        long remainingByteCount = byteCount;
        while (remainingByteCount > 0) {
            Intrinsics.checkNotNull(source.head);
            if (remainingByteCount < segment.getSize()) {
                Segment tail = this.tail;
                if (tail != null && tail.owner) {
                    if ((tail.getLimit() + remainingByteCount) - (tail.getShared$kotlinx_io_core() ? 0 : tail.getPos()) <= 8192) {
                        Segment segment2 = source.head;
                        Intrinsics.checkNotNull(segment2);
                        segment2.writeTo$kotlinx_io_core(tail, (int) remainingByteCount);
                        source.sizeMut -= remainingByteCount;
                        this.sizeMut += remainingByteCount;
                        return;
                    }
                }
                Segment segment3 = source.head;
                Intrinsics.checkNotNull(segment3);
                source.head = segment3.split$kotlinx_io_core((int) remainingByteCount);
            }
            Segment tail2 = source.head;
            Intrinsics.checkNotNull(tail2);
            long movedByteCount = tail2.getSize();
            source.head = tail2.pop$kotlinx_io_core();
            if (source.head == null) {
                source.tail = null;
            }
            if (getHead() == null) {
                setHead(tail2);
                setTail(tail2);
            } else {
                Segment tail3 = getTail();
                Intrinsics.checkNotNull(tail3);
                setTail(tail3.push$kotlinx_io_core(tail2).compact$kotlinx_io_core());
                Segment tail4 = getTail();
                Intrinsics.checkNotNull(tail4);
                if (tail4.getPrev() == null) {
                    setHead(getTail());
                }
            }
            source.sizeMut -= movedByteCount;
            this.sizeMut += movedByteCount;
            remainingByteCount -= movedByteCount;
        }
    }

    @Override // kotlinx.io.Sink
    public long transferFrom(RawSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long totalBytesRead = 0;
        while (true) {
            long readCount = source.readAtMostTo(this, 8192L);
            if (readCount != -1) {
                totalBytesRead += readCount;
            } else {
                return totalBytesRead;
            }
        }
    }

    @Override // kotlinx.io.Sink
    public void writeByte(byte b) {
        writableSegment(1).writeByte$kotlinx_io_core(b);
        this.sizeMut++;
    }

    @Override // kotlinx.io.Sink
    public void writeShort(short s) {
        writableSegment(2).writeShort$kotlinx_io_core(s);
        this.sizeMut += 2;
    }

    @Override // kotlinx.io.Sink
    public void writeInt(int i) {
        writableSegment(4).writeInt$kotlinx_io_core(i);
        this.sizeMut += 4;
    }

    @Override // kotlinx.io.Sink
    public void writeLong(long j) {
        writableSegment(8).writeLong$kotlinx_io_core(j);
        this.sizeMut += 8;
    }

    public final Buffer copy() {
        Buffer result = new Buffer();
        if (getSize() == 0) {
            return result;
        }
        Segment head = this.head;
        Intrinsics.checkNotNull(head);
        Segment headCopy = head.sharedCopy$kotlinx_io_core();
        result.head = headCopy;
        result.tail = headCopy;
        for (Segment s = head.getNext(); s != null; s = s.getNext()) {
            Segment segment = result.tail;
            Intrinsics.checkNotNull(segment);
            result.tail = segment.push$kotlinx_io_core(s.sharedCopy$kotlinx_io_core());
        }
        result.sizeMut = getSize();
        return result;
    }

    @Override // kotlinx.io.RawSource, java.lang.AutoCloseable, kotlinx.io.RawSink
    public void close() {
    }

    public String toString() {
        SegmentReadContext ctx;
        if (getSize() == 0) {
            return "Buffer(size=0)";
        }
        long b$iv = getSize();
        int len = (int) Math.min(64, b$iv);
        StringBuilder builder = new StringBuilder((len * 2) + (getSize() > ((long) 64) ? 1 : 0));
        int bytesWritten = 0;
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        for (Segment curr$iv = getHead(); curr$iv != null; curr$iv = curr$iv.getNext()) {
            ctx = UnsafeBufferOperationsKt.SegmentReadContextImpl;
            Segment segment = curr$iv;
            int idx = 0;
            while (bytesWritten < len && idx < segment.getSize()) {
                int idx2 = idx + 1;
                byte b = ctx.getUnchecked(segment, idx);
                bytesWritten++;
                int other$iv = b >> 4;
                int other$iv2 = 15 & b;
                builder.append(_UtilKt.getHEX_DIGIT_CHARS()[other$iv & 15]).append(_UtilKt.getHEX_DIGIT_CHARS()[other$iv2]);
                idx = idx2;
            }
        }
        if (getSize() > 64) {
            builder.append(Typography.ellipsis);
        }
        return "Buffer(size=" + getSize() + " hex=" + ((Object) builder) + ')';
    }

    public final void recycleHead$kotlinx_io_core() {
        Segment oldHead = this.head;
        Intrinsics.checkNotNull(oldHead);
        Segment nextHead = oldHead.getNext();
        this.head = nextHead;
        if (nextHead == null) {
            this.tail = null;
        } else {
            nextHead.setPrev(null);
        }
        oldHead.setNext(null);
        SegmentPool.recycle(oldHead);
    }

    public final /* synthetic */ void recycleTail() {
        Segment oldTail = this.tail;
        Intrinsics.checkNotNull(oldTail);
        Segment newTail = oldTail.getPrev();
        this.tail = newTail;
        if (newTail == null) {
            this.head = null;
        } else {
            newTail.setNext(null);
        }
        oldTail.setPrev(null);
        SegmentPool.recycle(oldTail);
    }

    static /* synthetic */ void pushSegment$default(Buffer $this, Segment newTail, boolean tryCompact, int i, Object obj) {
        if ((i & 2) != 0) {
            tryCompact = false;
        }
        if ($this.getHead() == null) {
            $this.setHead(newTail);
            $this.setTail(newTail);
        } else if (tryCompact) {
            Segment tail = $this.getTail();
            Intrinsics.checkNotNull(tail);
            $this.setTail(tail.push$kotlinx_io_core(newTail).compact$kotlinx_io_core());
            Segment tail2 = $this.getTail();
            Intrinsics.checkNotNull(tail2);
            if (tail2.getPrev() == null) {
                $this.setHead($this.getTail());
            }
        } else {
            Segment tail3 = $this.getTail();
            Intrinsics.checkNotNull(tail3);
            $this.setTail(tail3.push$kotlinx_io_core(newTail));
        }
    }

    private final void pushSegment(Segment newTail, boolean tryCompact) {
        if (getHead() == null) {
            setHead(newTail);
            setTail(newTail);
        } else if (tryCompact) {
            Segment tail = getTail();
            Intrinsics.checkNotNull(tail);
            setTail(tail.push$kotlinx_io_core(newTail).compact$kotlinx_io_core());
            Segment tail2 = getTail();
            Intrinsics.checkNotNull(tail2);
            if (tail2.getPrev() == null) {
                setHead(getTail());
            }
        } else {
            Segment tail3 = getTail();
            Intrinsics.checkNotNull(tail3);
            setTail(tail3.push$kotlinx_io_core(newTail));
        }
    }
}