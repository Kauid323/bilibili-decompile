package tv.danmaku.android.log.cache;

import java.io.OutputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.internal.BLogThreadFactory;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: MemoryCache.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0007J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/android/log/cache/MemoryCache;", "", "cacheSize", "", "maxLogSize", "", "(IJ)V", "block", "", "buffer", "Ltv/danmaku/android/log/cache/RingBuffer;", "deflater", "Ljava/util/zip/Deflater;", "os", "Ljava/io/OutputStream;", "getOs", "()Ljava/io/OutputStream;", "queue", "Ljava/util/concurrent/LinkedBlockingDeque;", "submitExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "totalSize", "add", "", "bytes", FavoritesConstsKt.CLEAR_INVALID_CLEAR, "getBufferData", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class MemoryCache {
    private final byte[] block;
    private final RingBuffer buffer;
    private final int cacheSize;
    private final Deflater deflater;
    private final long maxLogSize;
    private final ScheduledExecutorService submitExecutor;
    private volatile int totalSize;
    private final LinkedBlockingDeque<byte[]> queue = new LinkedBlockingDeque<>();
    private final OutputStream os = new OutputStream() { // from class: tv.danmaku.android.log.cache.MemoryCache$os$1
        @Override // java.io.OutputStream
        public void write(int b) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] b) {
            Intrinsics.checkNotNullParameter(b, "b");
            write(b, 0, b.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b, int off, int len) {
            MemoryCache.this.add(b != null ? ArraysKt.copyOfRange(b, off, off + len) : null);
        }
    };

    public MemoryCache(int cacheSize, long maxLogSize) {
        this.cacheSize = cacheSize;
        this.maxLogSize = maxLogSize;
        this.block = new byte[this.cacheSize];
        this.buffer = new RingBuffer(this.cacheSize, new MemoryCache$buffer$1(this));
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new BLogThreadFactory("memory"));
        Intrinsics.checkNotNullExpressionValue(newScheduledThreadPool, "newScheduledThreadPool(...)");
        this.submitExecutor = newScheduledThreadPool;
        this.deflater = new Deflater(-1, true);
    }

    public final OutputStream getOs() {
        return this.os;
    }

    public final void add(byte[] bytes) {
        if (bytes != null) {
            this.buffer.write(bytes);
        }
    }

    public final byte[] getBufferData() {
        byte[] result = new byte[this.totalSize];
        int start = 0;
        Iterable $this$forEach$iv = this.queue;
        for (Object element$iv : $this$forEach$iv) {
            byte[] buf = (byte[]) element$iv;
            System.arraycopy(buf, 0, result, start, buf.length);
            start += buf.length;
        }
        return result;
    }

    public final void clear() {
        this.queue.clear();
    }
}