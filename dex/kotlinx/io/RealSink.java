package kotlinx.io;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RealSink.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u001bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0018H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020\u0012H\u0017J\b\u0010'\u001a\u00020\u0012H\u0016J\b\u0010(\u001a\u00020\u0012H\u0016J\b\u0010)\u001a\u00020\u0012H\u0016J\b\u0010*\u001a\u00020+H\u0016J\t\u0010,\u001a\u00020\u0012H\u0082\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006-"}, d2 = {"Lkotlinx/io/RealSink;", "Lkotlinx/io/Sink;", "sink", "Lkotlinx/io/RawSink;", "<init>", "(Lkotlinx/io/RawSink;)V", "getSink", "()Lkotlinx/io/RawSink;", "closed", "", "bufferField", "Lkotlinx/io/Buffer;", "buffer", "getBuffer$annotations", "()V", "getBuffer", "()Lkotlinx/io/Buffer;", "write", "", "source", "byteCount", "", "", "startIndex", "", "endIndex", "transferFrom", "Lkotlinx/io/RawSource;", "writeByte", "byte", "", "writeShort", "short", "", "writeInt", "int", "writeLong", "long", "hintEmit", "emit", "flush", "close", "toString", "", "checkNotClosed", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealSink implements Sink {
    private final Buffer bufferField;
    public boolean closed;
    private final RawSink sink;

    public static /* synthetic */ void getBuffer$annotations() {
    }

    public RealSink(RawSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    public final RawSink getSink() {
        return this.sink;
    }

    @Override // kotlinx.io.Sink
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // kotlinx.io.RawSink
    public void write(Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        this.bufferField.write(source, byteCount);
        hintEmit();
    }

    @Override // kotlinx.io.Sink
    public void write(byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        int size$iv = source.length;
        _UtilKt.checkBounds(size$iv, startIndex, endIndex);
        this.bufferField.write(source, startIndex, endIndex);
        hintEmit();
    }

    @Override // kotlinx.io.Sink
    public long transferFrom(RawSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        long totalBytesRead = 0;
        while (true) {
            long readCount = source.readAtMostTo(this.bufferField, 8192L);
            if (readCount != -1) {
                totalBytesRead += readCount;
                hintEmit();
            } else {
                return totalBytesRead;
            }
        }
    }

    @Override // kotlinx.io.Sink
    public void write(RawSource source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        long remainingByteCount = byteCount;
        while (remainingByteCount > 0) {
            long read = source.readAtMostTo(this.bufferField, remainingByteCount);
            if (read == -1) {
                long bytesRead = byteCount - remainingByteCount;
                throw new EOFException("Source exhausted before reading " + byteCount + " bytes from it (number of bytes read: " + bytesRead + ").");
            } else {
                remainingByteCount -= read;
                hintEmit();
            }
        }
    }

    @Override // kotlinx.io.Sink
    public void writeByte(byte b) {
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        this.bufferField.writeByte(b);
        hintEmit();
    }

    @Override // kotlinx.io.Sink
    public void writeShort(short s) {
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        this.bufferField.writeShort(s);
        hintEmit();
    }

    @Override // kotlinx.io.Sink
    public void writeInt(int i) {
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        this.bufferField.writeInt(i);
        hintEmit();
    }

    @Override // kotlinx.io.Sink
    public void writeLong(long j) {
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        this.bufferField.writeLong(j);
        hintEmit();
    }

    @Override // kotlinx.io.Sink
    public void hintEmit() {
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        long byteCount = this.bufferField.completeSegmentByteCount$kotlinx_io_core();
        if (byteCount > 0) {
            this.sink.write(this.bufferField, byteCount);
        }
    }

    @Override // kotlinx.io.Sink
    public void emit() {
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        long byteCount = this.bufferField.getSize();
        if (byteCount > 0) {
            this.sink.write(this.bufferField, byteCount);
        }
    }

    @Override // kotlinx.io.Sink, kotlinx.io.RawSink, java.io.Flushable
    public void flush() {
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
        if (this.bufferField.getSize() > 0) {
            this.sink.write(this.bufferField, this.bufferField.getSize());
        }
        this.sink.flush();
    }

    @Override // kotlinx.io.RawSink
    public void close() {
        if (this.closed) {
            return;
        }
        Throwable thrown = null;
        try {
            if (this.bufferField.getSize() > 0) {
                this.sink.write(this.bufferField, this.bufferField.getSize());
            }
        } catch (Throwable e) {
            thrown = e;
        }
        try {
            this.sink.close();
        } catch (Throwable e2) {
            if (thrown == null) {
                thrown = e2;
            }
        }
        this.closed = true;
        if (thrown != null) {
            throw thrown;
        }
    }

    public String toString() {
        return "buffered(" + this.sink + ')';
    }

    private final void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("Sink is closed.".toString());
        }
    }
}