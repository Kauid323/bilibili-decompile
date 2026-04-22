package kntr.base.dd.impl.internal.common;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* compiled from: AtomicMutableMap.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u0006\u0010\u001a\u001a\u00020\u000fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lkntr/base/dd/impl/internal/common/AtomicMutableMap;", "K", "V", "", "<init>", "()V", "map", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "contains", "", "(Ljava/lang/Object;)Z", "keys", "", "getKeys", "()Ljava/util/Set;", "remove", "clear", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AtomicMutableMap<K, V> {
    private final Map<K, V> map = new LinkedHashMap();
    private final ReentrantLock lock = new ReentrantLock();

    public final V get(K k) {
        ReentrantLock $this$with$iv = this.lock;
        $this$with$iv.lock();
        try {
            return this.map.get(k);
        } finally {
            $this$with$iv.unlock();
        }
    }

    public final void put(K k, V v) {
        ReentrantLock $this$with$iv = this.lock;
        $this$with$iv.lock();
        try {
            this.map.put(k, v);
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$with$iv.unlock();
        }
    }

    public final boolean contains(K k) {
        ReentrantLock $this$with$iv = this.lock;
        $this$with$iv.lock();
        try {
            return this.map.containsKey(k);
        } finally {
            $this$with$iv.unlock();
        }
    }

    public final Set<K> getKeys() {
        ReentrantLock $this$with$iv = this.lock;
        $this$with$iv.lock();
        try {
            return CollectionsKt.toSet(this.map.keySet());
        } finally {
            $this$with$iv.unlock();
        }
    }

    public final V remove(K k) {
        ReentrantLock $this$with$iv = this.lock;
        $this$with$iv.lock();
        try {
            return this.map.remove(k);
        } finally {
            $this$with$iv.unlock();
        }
    }

    public final void clear() {
        ReentrantLock $this$with$iv = this.lock;
        $this$with$iv.lock();
        try {
            this.map.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$with$iv.unlock();
        }
    }
}