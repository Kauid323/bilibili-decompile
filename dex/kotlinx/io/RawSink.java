package kotlinx.io;

import java.io.Flushable;
import kotlin.Metadata;

/* compiled from: RawSink.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lkotlinx/io/RawSink;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Ljava/io/Flushable;", "write", "", "source", "Lkotlinx/io/Buffer;", "byteCount", "", "flush", "close", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RawSink extends AutoCloseable, Flushable {
    @Override // kotlinx.io.RawSink
    void close();

    void flush();

    void write(Buffer buffer, long j);
}