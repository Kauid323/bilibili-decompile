package shark;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.Buffer;
import okio.BufferedSource;
import shark.RandomAccessSource;

/* compiled from: ByteArraySourceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lshark/ByteArraySourceProvider;", "Lshark/DualSourceProvider;", "byteArray", "", "([B)V", "openRandomAccessSource", "Lshark/RandomAccessSource;", "openStreamingSource", "Lokio/BufferedSource;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class ByteArraySourceProvider implements DualSourceProvider {
    private final byte[] byteArray;

    public ByteArraySourceProvider(byte[] byteArray) {
        Intrinsics.checkParameterIsNotNull(byteArray, "byteArray");
        this.byteArray = byteArray;
    }

    @Override // shark.StreamingSourceProvider
    public BufferedSource openStreamingSource() {
        BufferedSource buffer = new Buffer();
        buffer.write(this.byteArray);
        return buffer;
    }

    @Override // shark.RandomAccessSourceProvider
    public RandomAccessSource openRandomAccessSource() {
        return new RandomAccessSource() { // from class: shark.ByteArraySourceProvider$openRandomAccessSource$1
            private boolean closed;

            @Override // shark.RandomAccessSource
            public BufferedSource asStreamingSource() {
                return RandomAccessSource.DefaultImpls.asStreamingSource(this);
            }

            public final boolean getClosed() {
                return this.closed;
            }

            public final void setClosed(boolean z) {
                this.closed = z;
            }

            @Override // shark.RandomAccessSource
            public long read(Buffer sink, long position, long byteCount) {
                byte[] bArr;
                byte[] bArr2;
                Intrinsics.checkParameterIsNotNull(sink, "sink");
                if (!this.closed) {
                    bArr = ByteArraySourceProvider.this.byteArray;
                    long maxByteCount = RangesKt.coerceAtMost(byteCount, bArr.length - position);
                    bArr2 = ByteArraySourceProvider.this.byteArray;
                    sink.write(bArr2, (int) position, (int) maxByteCount);
                    return maxByteCount;
                }
                throw new IOException("Source closed");
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.closed = true;
            }
        };
    }
}