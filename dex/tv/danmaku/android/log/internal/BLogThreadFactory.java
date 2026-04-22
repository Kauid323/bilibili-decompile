package tv.danmaku.android.log.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: Util.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/android/log/internal/BLogThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "type", "", "(Ljava/lang/String;)V", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class BLogThreadFactory implements ThreadFactory {
    private final AtomicInteger c;
    private final String type;

    public BLogThreadFactory(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.c = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r) {
        Intrinsics.checkNotNullParameter(r, "r");
        Thread t = new Thread(r);
        t.setName("BLog-" + this.type + '-' + this.c.getAndIncrement());
        t.setPriority(10);
        t.setDaemon(false);
        return t;
    }
}