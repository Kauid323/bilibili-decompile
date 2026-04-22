package kotlinx.io;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmCore.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/io/InputStreamSource;", "Lkotlinx/io/RawSource;", "input", "Ljava/io/InputStream;", "<init>", "(Ljava/io/InputStream;)V", "readAtMostTo", "", "sink", "Lkotlinx/io/Buffer;", "byteCount", "close", "", "toString", "", "kotlinx-io-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class InputStreamSource implements RawSource {
    private final InputStream input;

    public InputStreamSource(InputStream input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.input = input;
    }

    @Override // kotlinx.io.RawSource
    public long readAtMostTo(Buffer sink, long byteCount) {
        Segment tail$iv;
        byte[] data$iv;
        int pos;
        int b$iv;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount == 0) {
            return 0L;
        }
        if (byteCount >= 0) {
            try {
                UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
                tail$iv = sink.writableSegment(1);
                data$iv = tail$iv.dataAsByteArray(false);
                pos = tail$iv.getLimit();
                int limit = data$iv.length;
                b$iv = limit - pos;
            } catch (AssertionError e) {
                e = e;
            }
            try {
                long readTotal = this.input.read(data$iv, pos, (int) Math.min(byteCount, b$iv));
                int bytesWritten$iv = readTotal == -1 ? 0 : (int) readTotal;
                if (bytesWritten$iv == 1) {
                    tail$iv.writeBackData(data$iv, bytesWritten$iv);
                    tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                    sink.setSizeMut(sink.getSizeMut() + bytesWritten$iv);
                } else {
                    if (!(bytesWritten$iv >= 0 && bytesWritten$iv <= tail$iv.getRemainingCapacity())) {
                        throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten$iv + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
                    }
                    if (bytesWritten$iv != 0) {
                        tail$iv.writeBackData(data$iv, bytesWritten$iv);
                        tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                        sink.setSizeMut(sink.getSizeMut() + bytesWritten$iv);
                    } else if (SegmentKt.isEmpty(tail$iv)) {
                        sink.recycleTail();
                    }
                }
                return readTotal;
            } catch (AssertionError e2) {
                e = e2;
                if (JvmCoreKt.isAndroidGetsocknameError(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }
        throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
    }

    @Override // kotlinx.io.RawSource, java.lang.AutoCloseable, kotlinx.io.RawSink
    public void close() {
        this.input.close();
    }

    public String toString() {
        return "RawSource(" + this.input + ')';
    }
}