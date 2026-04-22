package shark;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/* compiled from: RandomAccessSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lshark/RandomAccessSource;", "Ljava/io/Closeable;", "asStreamingSource", "Lokio/BufferedSource;", "read", "", "sink", "Lokio/Buffer;", "position", "byteCount", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public interface RandomAccessSource extends Closeable {
    BufferedSource asStreamingSource();

    long read(Buffer buffer, long j, long j2) throws IOException;

    /* compiled from: RandomAccessSource.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DefaultImpls {
        public static BufferedSource asStreamingSource(final RandomAccessSource $this) {
            BufferedSource buffer = Okio.buffer(new Source() { // from class: shark.RandomAccessSource$asStreamingSource$1
                private long position;

                public final long getPosition() {
                    return this.position;
                }

                public final void setPosition(long j) {
                    this.position = j;
                }

                public Timeout timeout() {
                    return Timeout.NONE;
                }

                public void close() {
                    this.position = -1L;
                }

                public long read(Buffer sink, long byteCount) {
                    Intrinsics.checkParameterIsNotNull(sink, "sink");
                    if (this.position == -1) {
                        throw new IOException("Source closed");
                    }
                    long bytesRead = RandomAccessSource.this.read(sink, this.position, byteCount);
                    if (bytesRead == 0) {
                        return -1L;
                    }
                    this.position += bytesRead;
                    return bytesRead;
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(buffer, "Okio.buffer(object : Sou… bytesRead\n      }\n    })");
            return buffer;
        }
    }
}