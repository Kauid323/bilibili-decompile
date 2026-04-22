package kntr.base.imageloader.cache.memory;

import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.Image;
import kntr.base.imageloader.cache.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeakMemoryCache.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J4\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lkntr/base/imageloader/cache/memory/EmptyWeakMemoryCache;", "Lkntr/base/imageloader/cache/memory/WeakMemoryCache;", "<init>", "()V", "keys", "", "Lkntr/base/imageloader/cache/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lkntr/base/imageloader/cache/memory/MemoryCache$Value;", "key", "set", "", "image", "Lkntr/base/imageloader/Image;", "extras", "", "", "", "size", "", "remove", "", "clear", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class EmptyWeakMemoryCache implements WeakMemoryCache {
    public static final int $stable = 0;

    @Override // kntr.base.imageloader.cache.memory.WeakMemoryCache
    public Set<MemoryCache.Key> getKeys() {
        return SetsKt.emptySet();
    }

    @Override // kntr.base.imageloader.cache.memory.WeakMemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override // kntr.base.imageloader.cache.memory.WeakMemoryCache
    public void set(MemoryCache.Key key, Image image, Map<String, ? extends Object> map, long size) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(map, "extras");
    }

    @Override // kntr.base.imageloader.cache.memory.WeakMemoryCache
    public boolean remove(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return false;
    }

    @Override // kntr.base.imageloader.cache.memory.WeakMemoryCache
    public void clear() {
    }
}