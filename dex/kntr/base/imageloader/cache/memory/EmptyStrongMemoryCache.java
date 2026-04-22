package kntr.base.imageloader.cache.memory;

import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.Image;
import kntr.base.imageloader.cache.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StrongMemoryCache.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J4\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\tR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lkntr/base/imageloader/cache/memory/EmptyStrongMemoryCache;", "Lkntr/base/imageloader/cache/memory/StrongMemoryCache;", "weakMemoryCache", "Lkntr/base/imageloader/cache/memory/WeakMemoryCache;", "<init>", "(Lkntr/base/imageloader/cache/memory/WeakMemoryCache;)V", "size", "", "getSize", "()I", "value", "maxSize", "getMaxSize", "setMaxSize", "(I)V", "initialMaxSize", "getInitialMaxSize", "keys", "", "Lkntr/base/imageloader/cache/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lkntr/base/imageloader/cache/memory/MemoryCache$Value;", "key", "set", "", "image", "Lkntr/base/imageloader/Image;", "extras", "", "", "", "byteSize", "", "remove", "", "trimToSize", "clear", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class EmptyStrongMemoryCache implements StrongMemoryCache {
    public static final int $stable = 8;
    private final WeakMemoryCache weakMemoryCache;

    public EmptyStrongMemoryCache(WeakMemoryCache weakMemoryCache) {
        Intrinsics.checkNotNullParameter(weakMemoryCache, "weakMemoryCache");
        this.weakMemoryCache = weakMemoryCache;
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public int getSize() {
        return 0;
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public int getMaxSize() {
        return 0;
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public void setMaxSize(int value) {
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public int getInitialMaxSize() {
        return 1;
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public Set<MemoryCache.Key> getKeys() {
        return SetsKt.emptySet();
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public void set(MemoryCache.Key key, Image image, Map<String, ? extends Object> map, long byteSize) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(map, "extras");
        this.weakMemoryCache.set(key, image, map, byteSize);
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public boolean remove(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return false;
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public void trimToSize(int size) {
    }

    @Override // kntr.base.imageloader.cache.memory.StrongMemoryCache
    public void clear() {
    }
}