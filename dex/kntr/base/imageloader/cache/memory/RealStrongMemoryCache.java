package kntr.base.imageloader.cache.memory;

import androidx.collection.LruCache;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.Image;
import kntr.base.imageloader.cache.memory.MemoryCache;
import kntr.base.imageloader.cache.memory.RealStrongMemoryCache;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: StrongMemoryCache.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0016J4\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lkntr/base/imageloader/cache/memory/RealStrongMemoryCache;", "Lkntr/base/imageloader/cache/memory/StrongMemoryCache;", "initialMaxSize", "", "weakMemoryCache", "Lkntr/base/imageloader/cache/memory/WeakMemoryCache;", "<init>", "(ILkntr/base/imageloader/cache/memory/WeakMemoryCache;)V", "getInitialMaxSize", "()I", "cache", "Landroidx/collection/LruCache;", "Lkntr/base/imageloader/cache/memory/MemoryCache$Key;", "Lkntr/base/imageloader/cache/memory/RealStrongMemoryCache$InternalValue;", "size", "getSize", "value", "maxSize", "getMaxSize", "setMaxSize", "(I)V", "keys", "", "getKeys", "()Ljava/util/Set;", "get", "Lkntr/base/imageloader/cache/memory/MemoryCache$Value;", "key", "set", "", "image", "Lkntr/base/imageloader/Image;", "extras", "", "", "", "byteSize", "", "remove", "", "clear", "trimToSize", "InternalValue", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RealStrongMemoryCache implements StrongMemoryCache {
    public static final int $stable = 8;
    private final LruCache<MemoryCache.Key, InternalValue> cache;
    private final int initialMaxSize;
    private final WeakMemoryCache weakMemoryCache;

    public RealStrongMemoryCache(int initialMaxSize, WeakMemoryCache weakMemoryCache) {
        Intrinsics.checkNotNullParameter(weakMemoryCache, "weakMemoryCache");
        this.initialMaxSize = initialMaxSize;
        this.weakMemoryCache = weakMemoryCache;
        final int initialMaxSize2 = getInitialMaxSize();
        this.cache = new LruCache<MemoryCache.Key, InternalValue>(initialMaxSize2) { // from class: kntr.base.imageloader.cache.memory.RealStrongMemoryCache$cache$1
            /* JADX INFO: Access modifiers changed from: protected */
            public void entryRemoved(boolean evicted, MemoryCache.Key key, RealStrongMemoryCache.InternalValue oldValue, RealStrongMemoryCache.InternalValue newValue) {
                WeakMemoryCache weakMemoryCache2;
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                if (evicted) {
                    weakMemoryCache2 = RealStrongMemoryCache.this.weakMemoryCache;
                    weakMemoryCache2.set(key, oldValue.getImage(), oldValue.getExtras(), oldValue.getSize());
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public int sizeOf(MemoryCache.Key key, RealStrongMemoryCache.InternalValue value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                return Math.max(1, (int) RangesKt.coerceAtMost(value.getSize(), 2147483647L));
            }
        };
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public int getInitialMaxSize() {
        return this.initialMaxSize;
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public int getSize() {
        return this.cache.size();
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public int getMaxSize() {
        return this.cache.maxSize();
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public void setMaxSize(int value) {
        this.cache.resize(value);
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public Set<MemoryCache.Key> getKeys() {
        return this.cache.snapshot().keySet();
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        InternalValue it = (InternalValue) this.cache.get(key);
        if (it != null) {
            return new MemoryCache.Value(it.getImage(), it.getExtras());
        }
        return null;
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public void set(MemoryCache.Key key, Image image, Map<String, ? extends Object> map, long byteSize) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(map, "extras");
        KLog_androidKt.getKLog().i("RealStrongMemoryCache", "set key: " + key + ", byteSize: " + byteSize + ", maxSize: " + getMaxSize());
        if (byteSize <= getMaxSize()) {
            this.cache.put(key, new InternalValue(image, map, byteSize));
            return;
        }
        this.cache.remove(key);
        this.weakMemoryCache.set(key, image, map, byteSize);
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public boolean remove(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        KLog_androidKt.getKLog().i("RealStrongMemoryCache", " remove key: " + key);
        return this.cache.remove(key) != null;
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public void clear() {
        KLog_androidKt.getKLog().i("RealStrongMemoryCache", " clear");
        this.cache.evictAll();
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public void trimToSize(int size) {
        KLog_androidKt.getKLog().i("RealStrongMemoryCache", " trimToSize");
        this.cache.trimToSize(size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StrongMemoryCache.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkntr/base/imageloader/cache/memory/RealStrongMemoryCache$InternalValue;", "", "image", "Lkntr/base/imageloader/Image;", "extras", "", "", "size", "", "<init>", "(Lkntr/base/imageloader/Image;Ljava/util/Map;J)V", "getImage", "()Lkntr/base/imageloader/Image;", "getExtras", "()Ljava/util/Map;", "getSize", "()J", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class InternalValue {
        private final Map<String, Object> extras;
        private final Image image;
        private final long size;

        public InternalValue(Image image, Map<String, ? extends Object> map, long size) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(map, "extras");
            this.image = image;
            this.extras = map;
            this.size = size;
        }

        public final Image getImage() {
            return this.image;
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public final long getSize() {
            return this.size;
        }
    }
}