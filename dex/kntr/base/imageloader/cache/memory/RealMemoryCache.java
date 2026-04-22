package kntr.base.imageloader.cache.memory;

import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.AnimateImage;
import kntr.base.imageloader.Image;
import kntr.base.imageloader.StaticImage;
import kntr.base.imageloader.cache.memory.MemoryCache;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RealMemoryCache.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0096\u0002J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u001cH\u0096\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\u001fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lkntr/base/imageloader/cache/memory/RealMemoryCache;", "Lkntr/base/imageloader/cache/memory/MemoryCache;", "strongMemoryCache", "Lkntr/base/imageloader/cache/memory/StrongMemoryCache;", "weakMemoryCache", "Lkntr/base/imageloader/cache/memory/WeakMemoryCache;", "<init>", "(Lkntr/base/imageloader/cache/memory/StrongMemoryCache;Lkntr/base/imageloader/cache/memory/WeakMemoryCache;)V", "lock", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "size", "", "getSize", "()I", "value", "maxSize", "getMaxSize", "setMaxSize", "(I)V", "initialMaxSize", "getInitialMaxSize", "keys", "", "Lkntr/base/imageloader/cache/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lkntr/base/imageloader/cache/memory/MemoryCache$Value;", "key", "set", "", "remove", "", "trimToSize", "clear", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RealMemoryCache implements MemoryCache {
    public static final int $stable = 8;
    private final Object lock;
    private final StrongMemoryCache strongMemoryCache;
    private final WeakMemoryCache weakMemoryCache;

    public RealMemoryCache(StrongMemoryCache strongMemoryCache, WeakMemoryCache weakMemoryCache) {
        Intrinsics.checkNotNullParameter(strongMemoryCache, "strongMemoryCache");
        Intrinsics.checkNotNullParameter(weakMemoryCache, "weakMemoryCache");
        this.strongMemoryCache = strongMemoryCache;
        this.weakMemoryCache = weakMemoryCache;
        this.lock = new Object();
    }

    @Override // kntr.base.imageloader.cache.memory.MemoryCache
    public int getSize() {
        int size;
        synchronized (this.lock) {
            size = this.strongMemoryCache.getSize();
        }
        return size;
    }

    @Override // kntr.base.imageloader.cache.memory.MemoryCache
    public int getMaxSize() {
        int maxSize;
        synchronized (this.lock) {
            maxSize = this.strongMemoryCache.getMaxSize();
        }
        return maxSize;
    }

    @Override // kntr.base.imageloader.cache.memory.MemoryCache
    public void setMaxSize(int value) {
        synchronized (this.lock) {
            this.strongMemoryCache.setMaxSize(value);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // kntr.base.imageloader.cache.memory.MemoryCache
    public int getInitialMaxSize() {
        int initialMaxSize;
        synchronized (this.lock) {
            initialMaxSize = this.strongMemoryCache.getInitialMaxSize();
        }
        return initialMaxSize;
    }

    @Override // kntr.base.imageloader.cache.memory.MemoryCache
    public Set<MemoryCache.Key> getKeys() {
        Set<MemoryCache.Key> plus;
        synchronized (this.lock) {
            plus = SetsKt.plus(this.strongMemoryCache.getKeys(), this.weakMemoryCache.getKeys());
        }
        return plus;
    }

    @Override // kntr.base.imageloader.cache.memory.MemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        MemoryCache.Value value;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            value = this.strongMemoryCache.get(key);
            if (value == null) {
                value = this.weakMemoryCache.get(key);
            }
        }
        return value;
    }

    @Override // kntr.base.imageloader.cache.memory.MemoryCache
    public void set(MemoryCache.Key key, MemoryCache.Value value) {
        long byteSize;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            Image image = value.getImage();
            if (image instanceof StaticImage) {
                byteSize = ((StaticImage) image).getImageInfo().getByteSize();
            } else if (!(image instanceof AnimateImage)) {
                throw new NoWhenBranchMatchedException();
            } else {
                byteSize = ((AnimateImage) image).getImageInfo().getByteSize();
            }
            KLog_androidKt.getKLog().i("RealMemoryCache", "set key: " + key.getKey() + ", byteSize: " + byteSize);
            if (byteSize <= 0) {
                KLog_androidKt.getKLog().w("RealMemoryCache", "byteSize <= 0, skipping cache storage for key: " + key.getKey());
            } else {
                this.strongMemoryCache.set(key, value.getImage(), value.getExtras(), byteSize);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // kntr.base.imageloader.cache.memory.MemoryCache
    public boolean remove(MemoryCache.Key key) {
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            boolean removedStrong = this.strongMemoryCache.remove(key);
            boolean removedWeak = this.weakMemoryCache.remove(key);
            z = removedStrong || removedWeak;
        }
        return z;
    }

    @Override // kntr.base.imageloader.cache.memory.MemoryCache
    public void trimToSize(int size) {
        synchronized (this.lock) {
            this.strongMemoryCache.trimToSize(size);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // kntr.base.imageloader.cache.memory.MemoryCache
    public void clear() {
        synchronized (this.lock) {
            this.strongMemoryCache.clear();
            this.weakMemoryCache.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}