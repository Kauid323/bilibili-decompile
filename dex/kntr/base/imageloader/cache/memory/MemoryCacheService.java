package kntr.base.imageloader.cache.memory;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageOptions;
import kntr.base.imageloader.Image;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.cache.CachePolicy;
import kntr.base.imageloader.cache.memory.MemoryCache;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryCacheService.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007J \u0010\r\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/base/imageloader/cache/memory/MemoryCacheService;", "", "memoryCache", "Lkntr/base/imageloader/cache/memory/MemoryCache;", "<init>", "(Lkntr/base/imageloader/cache/memory/MemoryCache;)V", "newCacheKey", "Lkntr/base/imageloader/cache/memory/MemoryCache$Key;", "request", "Lkntr/base/imageloader/ImmutableImageRequest;", "getCacheValue", "Lkntr/base/imageloader/cache/memory/MemoryCache$Value;", "cacheKey", "setCacheValue", "", "image", "Lkntr/base/imageloader/Image;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MemoryCacheService {
    public static final int $stable = 8;
    private final MemoryCache memoryCache;

    public MemoryCacheService(MemoryCache memoryCache) {
        Intrinsics.checkNotNullParameter(memoryCache, "memoryCache");
        this.memoryCache = memoryCache;
    }

    public final MemoryCache.Key newCacheKey(ImmutableImageRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        BiliImageOptions options = request.getOptions$imageloader_debug();
        if (options.getMemoryCachePolicy() == CachePolicy.DISABLED) {
            return null;
        }
        return new MemoryCache.Key(MemoryCacheServiceKt.getCacheKeyString(request), null, 2, null);
    }

    public final MemoryCache.Value getCacheValue(ImmutableImageRequest request, MemoryCache.Key cacheKey) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        BiliImageOptions options = request.getOptions$imageloader_debug();
        if (!options.getMemoryCachePolicy().getReadEnabled()) {
            return null;
        }
        MemoryCache.Value cacheValue = this.memoryCache.get(cacheKey);
        KLog_androidKt.getKLog().i("MemoryCacheService", "getCacheValue: key=" + cacheKey.getKey() + " hit=" + (cacheValue != null));
        return cacheValue;
    }

    public final boolean setCacheValue(MemoryCache.Key cacheKey, ImmutableImageRequest request, Image image) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(image, "image");
        BiliImageOptions options = request.getOptions$imageloader_debug();
        if (cacheKey == null || !options.getMemoryCachePolicy().getWriteEnabled()) {
            return false;
        }
        KLog_androidKt.getKLog().i("MemoryCacheService", "setCacheValue: key=" + cacheKey.getKey());
        this.memoryCache.set(cacheKey, new MemoryCache.Value(image, null, 2, null));
        return true;
    }
}