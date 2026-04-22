package kotlinx.io;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmCore.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/io/OutputStreamSink;", "Lkotlinx/io/RawSink;", "out", "Ljava/io/OutputStream;", "<init>", "(Ljava/io/OutputStream;)V", "write", "", "source", "Lkotlinx/io/Buffer;", "byteCount", "", "flush", "close", "toString", "", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OutputStreamSink implements RawSink {
    private final OutputStream out;

    public OutputStreamSink(OutputStream out) {
        Intrinsics.checkNotNullParameter(out, "out");
        this.out = out;
    }

    @Override // kotlinx.io.RawSink
    public void write(Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        _UtilKt.checkOffsetAndCount(source.getSize(), 0L, byteCount);
        long remaining = byteCount;
        while (remaining > 0) {
            UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
            if (source.exhausted()) {
                throw new IllegalArgumentException("Buffer is empty".toString());
            }
            Segment head$iv = source.getHead();
            Intrinsics.checkNotNull(head$iv);
            byte[] data = head$iv.dataAsByteArray(true);
            int pos = head$iv.getPos();
            int limit = head$iv.getLimit();
            long a$iv = remaining;
            int b$iv = (int) Math.min(a$iv, limit - pos);
            this.out.write(data, pos, b$iv);
            remaining -= b$iv;
            if (b$iv != 0) {
                if (b$iv >= 0) {
                    if (b$iv > head$iv.getSize()) {
                        throw new IllegalStateException("Returned too many bytes");
                    }
                    source.skip(b$iv);
                } else {
                    throw new IllegalStateException("Returned negative read bytes count");
                }
            }
        }
    }

    @Override // kotlinx.io.RawSink, java.io.Flushable
    public void flush() {
        this.out.flush();
    }

    @Override // kotlinx.io.RawSink
    public void close() {
        this.out.close();
    }

    public String toString() {
        return "RawSink(" + this.out + ')';
    }
}