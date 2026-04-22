package tv.danmaku.android.log.cache;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MemoryCache.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "unCompressCache", "", "off", "", "len", "invoke"}, k = 3, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class MemoryCache$buffer$1 extends Lambda implements Function3<byte[], Integer, Integer, Unit> {
    final /* synthetic */ MemoryCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryCache$buffer$1(MemoryCache memoryCache) {
        super(3);
        this.this$0 = memoryCache;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((byte[]) p1, ((Number) p2).intValue(), ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final byte[] unCompressCache, final int off, final int len) {
        ScheduledExecutorService scheduledExecutorService;
        Intrinsics.checkNotNullParameter(unCompressCache, "unCompressCache");
        scheduledExecutorService = this.this$0.submitExecutor;
        final MemoryCache memoryCache = this.this$0;
        scheduledExecutorService.submit(new Runnable() { // from class: tv.danmaku.android.log.cache.MemoryCache$buffer$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MemoryCache$buffer$1.invoke$lambda$1(MemoryCache.this, unCompressCache, off, len);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Incorrect condition in loop: B:5:0x001d */
    /* JADX WARN: Incorrect condition in loop: B:8:0x003e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void invoke$lambda$1(MemoryCache this$0, byte[] $unCompressCache, int $off, int $len) {
        Deflater deflater;
        Deflater deflater2;
        int i;
        long j;
        LinkedBlockingDeque linkedBlockingDeque;
        byte[] bArr;
        int i2;
        LinkedBlockingDeque linkedBlockingDeque2;
        int i3;
        Deflater deflater3;
        byte[] bArr2;
        byte[] bArr3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($unCompressCache, "$unCompressCache");
        int l = 0;
        try {
            deflater = this$0.deflater;
            deflater.setInput($unCompressCache, $off, $len);
            while (!deflater2.needsInput()) {
                deflater3 = this$0.deflater;
                bArr2 = this$0.block;
                bArr3 = this$0.block;
                l += deflater3.deflate(bArr2, 0, bArr3.length, 2);
            }
            while (i > j) {
                linkedBlockingDeque2 = this$0.queue;
                byte[] it = (byte[]) linkedBlockingDeque2.poll();
                if (it != null) {
                    i3 = this$0.totalSize;
                    this$0.totalSize = i3 - it.length;
                }
            }
            linkedBlockingDeque = this$0.queue;
            bArr = this$0.block;
            linkedBlockingDeque.offer(ArraysKt.copyOfRange(bArr, 0, l));
            i2 = this$0.totalSize;
            this$0.totalSize = i2 + l;
        } catch (Exception e) {
        }
    }
}