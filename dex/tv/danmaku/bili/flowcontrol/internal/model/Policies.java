package tv.danmaku.bili.flowcontrol.internal.model;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.flowcontrol.internal.protocol.RetryAfterKt;
import tv.danmaku.bili.flowcontrol.internal.tracker.EventListener;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: Policies.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/flowcontrol/internal/model/Policies;", "", "tracker", "Ltv/danmaku/bili/flowcontrol/internal/tracker/EventListener;", "<init>", "(Ltv/danmaku/bili/flowcontrol/internal/tracker/EventListener;)V", "map", "Ljava/util/HashMap;", "", "Ltv/danmaku/bili/flowcontrol/internal/model/BlockPolicy;", "Lkotlin/collections/HashMap;", "isBlocked", "", ReportEvent.Tag.HOST, FileChooserActivity.PATH, "block", "", "retryAfter", "", "unblock", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "r", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;", "kotlin.jvm.PlatformType", "w", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Policies {
    private final ReentrantReadWriteLock lock;
    private final HashMap<String, BlockPolicy> map;
    private final ReentrantReadWriteLock.ReadLock r;
    private final EventListener tracker;
    private final ReentrantReadWriteLock.WriteLock w;

    public Policies(EventListener tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.tracker = tracker;
        this.map = new HashMap<>();
        this.lock = new ReentrantReadWriteLock();
        this.r = this.lock.readLock();
        this.w = this.lock.writeLock();
    }

    public final boolean isBlocked(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        String key = host + path;
        ReentrantReadWriteLock.ReadLock readLock = this.r;
        Intrinsics.checkNotNullExpressionValue(readLock, "r");
        ReentrantReadWriteLock.ReadLock readLock2 = readLock;
        readLock2.lock();
        try {
            BlockPolicy blockPolicy = this.map.get(key);
            boolean block = blockPolicy != null ? blockPolicy.block() : false;
            readLock2.unlock();
            boolean blocked = block;
            if (blocked) {
                BLog.w("net.flowcontrol.policy", "Blocked " + host + path + " for flow control");
                this.tracker.onBlocked(host, path);
            }
            return blocked;
        } catch (Throwable th) {
            readLock2.unlock();
            throw th;
        }
    }

    public final void block(String host, String path, int retryAfter) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        String key = host + path;
        ReentrantReadWriteLock.WriteLock writeLock = this.w;
        Intrinsics.checkNotNullExpressionValue(writeLock, "w");
        ReentrantReadWriteLock.WriteLock writeLock2 = writeLock;
        writeLock2.lock();
        try {
            BlockPolicy policy = new BlockPolicy(host, path, RetryAfterKt.blockPolicy(host, path, retryAfter));
            this.map.put(key, policy);
            policy.update();
            BLog.w("net.flowcontrol.policy", "Block " + host + path + " for " + policy.getDuration() + " ms " + policy.getUpdate() + " time");
            this.tracker.block(host, path, policy.getDuration(), policy.getUpdate());
            Unit unit = Unit.INSTANCE;
        } finally {
            writeLock2.unlock();
        }
    }

    public final void unblock(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        String key = host + path;
        ReentrantReadWriteLock.ReadLock readLock = this.r;
        Intrinsics.checkNotNullExpressionValue(readLock, "r");
        readLock.lock();
        try {
            if (this.map.containsKey(key)) {
                ReentrantReadWriteLock.WriteLock writeLock = this.w;
                Intrinsics.checkNotNullExpressionValue(writeLock, "w");
                writeLock.lock();
                try {
                    if (this.map.remove(key) != null) {
                        BLog.i("net.flowcontrol.policy", "Unblock " + host + path);
                        this.tracker.unblock(host, path);
                        Unit unit = Unit.INSTANCE;
                    }
                } finally {
                }
            }
        } finally {
        }
    }
}