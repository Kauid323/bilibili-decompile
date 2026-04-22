package shark;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;
import shark.RandomAccessSource;
import shark.SharkLog;

/* compiled from: ThrowingCancelableFileSourceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lshark/ThrowingCancelableFileSourceProvider;", "Lshark/DualSourceProvider;", "file", "Ljava/io/File;", "throwIfCanceled", "Ljava/lang/Runnable;", "(Ljava/io/File;Ljava/lang/Runnable;)V", "openRandomAccessSource", "Lshark/RandomAccessSource;", "openStreamingSource", "Lokio/BufferedSource;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class ThrowingCancelableFileSourceProvider implements DualSourceProvider {
    private final File file;
    private final Runnable throwIfCanceled;

    public ThrowingCancelableFileSourceProvider(File file, Runnable throwIfCanceled) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        Intrinsics.checkParameterIsNotNull(throwIfCanceled, "throwIfCanceled");
        this.file = file;
        this.throwIfCanceled = throwIfCanceled;
    }

    @Override // shark.StreamingSourceProvider
    public BufferedSource openStreamingSource() {
        final Source realSource = Okio.source(new FileInputStream(this.file));
        BufferedSource buffer = Okio.buffer(new Source(realSource) { // from class: shark.ThrowingCancelableFileSourceProvider$openStreamingSource$1
            private final /* synthetic */ Source $$delegate_0;
            final /* synthetic */ Source $realSource;

            public void close() {
                this.$$delegate_0.close();
            }

            public Timeout timeout() {
                return this.$$delegate_0.timeout();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$realSource = realSource;
                Intrinsics.checkExpressionValueIsNotNull(realSource, "realSource");
                this.$$delegate_0 = realSource;
            }

            public long read(Buffer sink, long byteCount) {
                Runnable runnable;
                Intrinsics.checkParameterIsNotNull(sink, "sink");
                runnable = ThrowingCancelableFileSourceProvider.this.throwIfCanceled;
                runnable.run();
                return this.$realSource.read(sink, byteCount);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(buffer, "Okio.buffer(object : Sou…byteCount)\n      }\n    })");
        return buffer;
    }

    @Override // shark.RandomAccessSourceProvider
    public RandomAccessSource openRandomAccessSource() {
        final FileChannel channel = new FileInputStream(this.file).getChannel();
        return new RandomAccessSource() { // from class: shark.ThrowingCancelableFileSourceProvider$openRandomAccessSource$1
            @Override // shark.RandomAccessSource
            public BufferedSource asStreamingSource() {
                return RandomAccessSource.DefaultImpls.asStreamingSource(this);
            }

            @Override // shark.RandomAccessSource
            public long read(Buffer sink, long position, long byteCount) {
                Runnable runnable;
                Intrinsics.checkParameterIsNotNull(sink, "sink");
                runnable = ThrowingCancelableFileSourceProvider.this.throwIfCanceled;
                runnable.run();
                return channel.transferTo(position, byteCount, (WritableByteChannel) sink);
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    channel.close();
                } catch (Throwable ignored) {
                    SharkLog this_$iv = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv = this_$iv.getLogger();
                    if (logger$iv != null) {
                        logger$iv.d(ignored, "Failed to close file, ignoring");
                    }
                }
            }
        };
    }
}