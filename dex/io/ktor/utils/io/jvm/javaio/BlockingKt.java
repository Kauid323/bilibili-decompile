package io.ktor.utils.io.jvm.javaio;

import com.lynx.tasm.behavior.PropertyIDConstants;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* compiled from: Blocking.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/Job;", "parent", "Ljava/io/InputStream;", "toInputStream", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/coroutines/Job;)Ljava/io/InputStream;", "Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/io/OutputStream;", "toOutputStream", "(Lio/ktor/utils/io/ByteWriteChannel;)Ljava/io/OutputStream;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class BlockingKt {
    public static /* synthetic */ InputStream toInputStream$default(ByteReadChannel byteReadChannel, Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return toInputStream(byteReadChannel, job);
    }

    public static final InputStream toInputStream(final ByteReadChannel $this$toInputStream, Job parent) {
        Intrinsics.checkNotNullParameter($this$toInputStream, "<this>");
        return new InputStream() { // from class: io.ktor.utils.io.jvm.javaio.BlockingKt$toInputStream$1
            @Override // java.io.InputStream
            public int read() {
                if (ByteReadChannel.this.isClosedForRead()) {
                    return -1;
                }
                if (ByteReadChannel.this.mo1388getReadBuffer().exhausted()) {
                    blockingWait();
                }
                if (ByteReadChannel.this.isClosedForRead()) {
                    return -1;
                }
                return ByteReadChannel.this.mo1388getReadBuffer().readByte() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] b, int off, int len) {
                Intrinsics.checkNotNullParameter(b, "b");
                if (ByteReadChannel.this.isClosedForRead()) {
                    return -1;
                }
                if (ByteReadChannel.this.mo1388getReadBuffer().exhausted()) {
                    blockingWait();
                }
                int count = Math.min(ByteReadChannelOperationsKt.getAvailableForRead(ByteReadChannel.this), len);
                int result = ByteReadChannel.this.mo1388getReadBuffer().readAtMostTo(b, off, off + count);
                return result >= 0 ? result : ByteReadChannel.this.isClosedForRead() ? -1 : 0;
            }

            private final void blockingWait() {
                BuildersKt.runBlocking$default((CoroutineContext) null, new BlockingKt$toInputStream$1$blockingWait$1(ByteReadChannel.this, null), 1, (Object) null);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                ByteReadChannelKt.cancel(ByteReadChannel.this);
            }
        };
    }

    public static final OutputStream toOutputStream(final ByteWriteChannel $this$toOutputStream) {
        Intrinsics.checkNotNullParameter($this$toOutputStream, "<this>");
        return new OutputStream() { // from class: io.ktor.utils.io.jvm.javaio.BlockingKt$toOutputStream$1
            @Override // java.io.OutputStream
            public void write(int b) {
                BuildersKt.runBlocking$default((CoroutineContext) null, new BlockingKt$toOutputStream$1$write$1(ByteWriteChannel.this, b, null), 1, (Object) null);
            }

            @Override // java.io.OutputStream
            public void write(byte[] b, int off, int len) {
                Intrinsics.checkNotNullParameter(b, "b");
                BuildersKt.runBlocking$default((CoroutineContext) null, new BlockingKt$toOutputStream$1$write$2(ByteWriteChannel.this, b, off, len, null), 1, (Object) null);
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
                BuildersKt.runBlocking$default((CoroutineContext) null, new BlockingKt$toOutputStream$1$flush$1(ByteWriteChannel.this, null), 1, (Object) null);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                BuildersKt.runBlocking$default((CoroutineContext) null, new BlockingKt$toOutputStream$1$close$1(ByteWriteChannel.this, null), 1, (Object) null);
            }
        };
    }
}