package kotlinx.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Core.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lkotlinx/io/DiscardingSink;", "Lkotlinx/io/RawSink;", "<init>", "()V", "write", "", "source", "Lkotlinx/io/Buffer;", "byteCount", "", "flush", "close", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DiscardingSink implements RawSink {
    @Override // kotlinx.io.RawSink
    public void write(Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        source.skip(byteCount);
    }

    @Override // kotlinx.io.RawSink, java.io.Flushable
    public void flush() {
    }

    @Override // kotlinx.io.RawSink
    public void close() {
    }
}