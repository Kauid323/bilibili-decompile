package kotlinx.io;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RealSource.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u0011\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\b\u0010%\u001a\u00020\u0012H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010'\u001a\u00020\u0001H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J\b\u0010)\u001a\u00020*H\u0016J\t\u0010+\u001a\u00020\u0017H\u0082\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006,"}, d2 = {"Lkotlinx/io/RealSource;", "Lkotlinx/io/Source;", "source", "Lkotlinx/io/RawSource;", "<init>", "(Lkotlinx/io/RawSource;)V", "getSource", "()Lkotlinx/io/RawSource;", "closed", "", "bufferField", "Lkotlinx/io/Buffer;", "buffer", "getBuffer$annotations", "()V", "getBuffer", "()Lkotlinx/io/Buffer;", "readAtMostTo", "", "sink", "byteCount", "exhausted", "require", "", "request", "readByte", "", "", "", "startIndex", "endIndex", "readTo", "Lkotlinx/io/RawSink;", "transferTo", "readShort", "", "readInt", "readLong", "skip", "peek", "close", "toString", "", "checkNotClosed", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealSource implements Source {
    private final Buffer bufferField;
    public boolean closed;
    private final RawSource source;

    public static /* synthetic */ void getBuffer$annotations() {
    }

    public RealSource(RawSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    public final RawSource getSource() {
        return this.source;
    }

    @Override // kotlinx.io.Source, kotlinx.io.Sink
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // kotlinx.io.RawSource
    public long readAtMostTo(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.closed) {
            throw new IllegalStateException("Source is closed.".toString());
        }
        if (byteCount >= 0) {
            if (this.bufferField.getSize() == 0) {
                long read = this.source.readAtMostTo(this.bufferField, 8192L);
                if (read == -1) {
                    return -1L;
                }
            }
            long toRead = Math.min(byteCount, this.bufferField.getSize());
            return this.bufferField.readAtMostTo(sink, toRead);
        }
        throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
    }

    @Override // kotlinx.io.Source
    public boolean exhausted() {
        if (this.closed) {
            throw new IllegalStateException("Source is closed.".toString());
        }
        return this.bufferField.exhausted() && this.source.readAtMostTo(this.bufferField, 8192L) == -1;
    }

    @Override // kotlinx.io.Source
    public void require(long byteCount) {
        if (!request(byteCount)) {
            throw new EOFException("Source doesn't contain required number of bytes (" + byteCount + ").");
        }
    }

    @Override // kotlinx.io.Source
    public boolean request(long byteCount) {
        if (this.closed) {
            throw new IllegalStateException("Source is closed.".toString());
        }
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        while (this.bufferField.getSize() < byteCount) {
            if (this.source.readAtMostTo(this.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.io.Source
    public byte readByte() {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // kotlinx.io.Source
    public int readAtMostTo(byte[] sink, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int size$iv = sink.length;
        _UtilKt.checkBounds(size$iv, startIndex, endIndex);
        if (this.bufferField.getSize() == 0) {
            long read = this.source.readAtMostTo(this.bufferField, 8192L);
            if (read == -1) {
                return -1;
            }
        }
        int a$iv = endIndex - startIndex;
        long b$iv = this.bufferField.getSize();
        return this.bufferField.readAtMostTo(sink, startIndex, startIndex + ((int) Math.min(a$iv, b$iv)));
    }

    @Override // kotlinx.io.Source
    public void readTo(RawSink sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            require(byteCount);
            this.bufferField.readTo(sink, byteCount);
        } catch (EOFException e) {
            sink.write(this.bufferField, this.bufferField.getSize());
            throw e;
        }
    }

    @Override // kotlinx.io.Source
    public long transferTo(RawSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long totalBytesWritten = 0;
        while (this.source.readAtMostTo(this.bufferField, 8192L) != -1) {
            long emitByteCount = this.bufferField.completeSegmentByteCount$kotlinx_io_core();
            if (emitByteCount > 0) {
                totalBytesWritten += emitByteCount;
                sink.write(this.bufferField, emitByteCount);
            }
        }
        if (this.bufferField.getSize() > 0) {
            long totalBytesWritten2 = totalBytesWritten + this.bufferField.getSize();
            sink.write(this.bufferField, this.bufferField.getSize());
            return totalBytesWritten2;
        }
        return totalBytesWritten;
    }

    @Override // kotlinx.io.Source
    public short readShort() {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // kotlinx.io.Source
    public int readInt() {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override // kotlinx.io.Source
    public long readLong() {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override // kotlinx.io.Source
    public void skip(long byteCount) {
        if (this.closed) {
            throw new IllegalStateException("Source is closed.".toString());
        }
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        long remainingByteCount = byteCount;
        while (remainingByteCount > 0) {
            if (this.bufferField.getSize() == 0 && this.source.readAtMostTo(this.bufferField, 8192L) == -1) {
                throw new EOFException("Source exhausted before skipping " + byteCount + " bytes (only " + (remainingByteCount - byteCount) + " bytes were skipped).");
            }
            long toSkip = Math.min(remainingByteCount, this.bufferField.getSize());
            this.bufferField.skip(toSkip);
            remainingByteCount -= toSkip;
        }
    }

    @Override // kotlinx.io.Source
    public Source peek() {
        if (this.closed) {
            throw new IllegalStateException("Source is closed.".toString());
        }
        return CoreKt.buffered(new PeekSource(this));
    }

    @Override // kotlinx.io.RawSource, java.lang.AutoCloseable, kotlinx.io.RawSink
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    public String toString() {
        return "buffered(" + this.source + ')';
    }

    private final void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("Source is closed.".toString());
        }
    }
}