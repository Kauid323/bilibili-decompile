package tv.danmaku.android.log.cache;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.adapters.DiskLogAdapter;
import tv.danmaku.android.log.cache.Meta;
import tv.danmaku.bili.BR;

/* compiled from: DayExpiredCache.kt */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"tv/danmaku/android/log/cache/DayExpiredCache$asSink$1", "Ljava/io/OutputStream;", "head", "Ltv/danmaku/android/log/cache/Meta$Block;", "flush", "", "peek", "write", "b", "", "off", "", "len", "", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class DayExpiredCache$asSink$1 extends OutputStream {
    private Meta.Block head;
    final /* synthetic */ DayExpiredCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DayExpiredCache$asSink$1(final DayExpiredCache $receiver) {
        ScheduledExecutorService scheduledExecutorService;
        long j;
        long j2;
        this.this$0 = $receiver;
        scheduledExecutorService = $receiver.submitExecutor;
        Runnable runnable = new Runnable() { // from class: tv.danmaku.android.log.cache.DayExpiredCache$asSink$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DayExpiredCache$asSink$1._init_$lambda$6(DayExpiredCache$asSink$1.this, $receiver);
            }
        };
        j = $receiver.flushMillis;
        j2 = $receiver.flushMillis;
        scheduledExecutorService.scheduleWithFixedDelay(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    @Override // java.io.OutputStream
    public Void write(int b) {
        throw new AssertionError();
    }

    @Override // java.io.OutputStream
    public void write(byte[] b) {
        Intrinsics.checkNotNullParameter(b, "b");
        write(b, 0, b.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] b, int off, int len) {
        Meta meta;
        Intrinsics.checkNotNullParameter(b, "b");
        int written = 0;
        while (written < len) {
            try {
                Meta.Block $this$write_u24lambda_u240 = peek();
                DayExpiredCache dayExpiredCache = this.this$0;
                written += $this$write_u24lambda_u240.append(b, off + written, len - written);
                $this$write_u24lambda_u240.syncSize();
                if ($this$write_u24lambda_u240.getRemaining() <= 0) {
                    meta = dayExpiredCache.getMeta();
                    meta.onBlockFlush($this$write_u24lambda_u240);
                    this.head = null;
                }
            } catch (InterruptedException e) {
                throw new IOException(e);
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        CountDownLatch countDownLatch;
        Meta meta;
        DayExpiredCache dayExpiredCache = this.this$0;
        synchronized (this) {
            Meta.Block it = this.head;
            countDownLatch = null;
            if (it != null) {
                CountDownLatch latch = new CountDownLatch(1);
                it.setLatch(latch);
                meta = dayExpiredCache.getMeta();
                meta.onBlockFlush(it);
                this.head = null;
                countDownLatch = latch;
            }
        }
        if (countDownLatch != null) {
            countDownLatch.await();
        }
    }

    private final Meta.Block peek() {
        Meta meta;
        Meta.Block block = this.head;
        if (block == null) {
            meta = this.this$0.getMeta();
            Meta.Block $this$peek_u24lambda_u243 = meta.take();
            this.head = $this$peek_u24lambda_u243;
            return $this$peek_u24lambda_u243;
        }
        return block;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(DayExpiredCache$asSink$1 this$0, DayExpiredCache this$1) {
        Meta meta;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        try {
            synchronized (this$0) {
                Meta.Block it = this$0.head;
                if (it != null) {
                    meta = this$1.getMeta();
                    meta.onBlockFlush(it);
                    this$0.head = null;
                    Unit unit = Unit.INSTANCE;
                }
            }
        } catch (IOException e) {
            Log.w(DiskLogAdapter.TAG, "Flush Fail", e);
        }
    }
}