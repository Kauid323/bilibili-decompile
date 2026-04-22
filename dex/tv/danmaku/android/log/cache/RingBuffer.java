package tv.danmaku.android.log.cache;

import android.util.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.bili.BR;

/* compiled from: MemoryCache.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u000e\u0010\u0016\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/android/log/cache/RingBuffer;", "", "cacheSize", "", "consumer", "Lkotlin/Function3;", "", "", "(ILkotlin/jvm/functions/Function3;)V", "getConsumer", "()Lkotlin/jvm/functions/Function3;", "isEmpty", "", "()Z", "isFull", "length", "getLength", "()I", "mBuffer", "read", "remain", "getRemain", "write", "consumeBuffer", "size", "bytes", "Companion", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class RingBuffer {
    public static final int CONSUME_SIZE = 16384;
    public static final Companion Companion = new Companion(null);
    private final int cacheSize;
    private final Function3<byte[], Integer, Integer, Unit> consumer;
    private final byte[] mBuffer;
    private volatile int read;
    private volatile int write;

    /* compiled from: MemoryCache.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ltv/danmaku/android/log/cache/RingBuffer$Companion;", "", "()V", "CONSUME_SIZE", "", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RingBuffer(int cacheSize, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "consumer");
        this.cacheSize = cacheSize;
        this.consumer = function3;
        if (this.cacheSize < 16384) {
            throw new IllegalStateException("user useMemoryCacheSize must greater than 16384");
        }
        this.mBuffer = new byte[this.cacheSize];
    }

    public final Function3<byte[], Integer, Integer, Unit> getConsumer() {
        return this.consumer;
    }

    private final int getLength() {
        return ((this.write - this.read) + this.cacheSize) & (this.cacheSize - 1);
    }

    private final boolean isEmpty() {
        return this.write == this.read;
    }

    private final boolean isFull() {
        return this.read == ((this.write + 1) & (this.cacheSize - 1));
    }

    private final int getRemain() {
        return this.cacheSize - getLength();
    }

    public final synchronized boolean write(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (isFull()) {
            Log.w(DayExpiredCacheKt.TAG, "buffer is full, so drop the data");
            return false;
        }
        int totalSize = bytes.length;
        int start = 0;
        while (totalSize > 0) {
            int perConsumeSize = RangesKt.coerceAtMost(totalSize, getRemain());
            int temp = this.write + perConsumeSize;
            if (temp > this.cacheSize) {
                System.arraycopy(bytes, start, this.mBuffer, this.write, this.cacheSize - this.write);
                System.arraycopy(bytes, this.cacheSize - this.write, this.mBuffer, 0, perConsumeSize - (this.cacheSize - this.write));
            } else {
                System.arraycopy(bytes, start, this.mBuffer, this.write, perConsumeSize);
            }
            this.write = temp & (this.cacheSize - 1);
            start += perConsumeSize;
            totalSize -= perConsumeSize;
            if (getLength() >= 16384) {
                consumeBuffer(getLength());
            }
        }
        return true;
    }

    private final void consumeBuffer(int size) {
        int temp = this.read + size;
        if (temp > this.cacheSize) {
            this.consumer.invoke(this.mBuffer, Integer.valueOf(this.read), Integer.valueOf(this.cacheSize - this.read));
            this.consumer.invoke(this.mBuffer, 0, Integer.valueOf(size - (this.cacheSize - this.read)));
        } else {
            this.consumer.invoke(this.mBuffer, Integer.valueOf(this.read), Integer.valueOf(size));
        }
        this.read = (this.read + size) & (this.cacheSize - 1);
    }
}