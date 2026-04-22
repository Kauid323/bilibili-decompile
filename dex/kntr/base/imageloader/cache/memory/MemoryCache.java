package kntr.base.imageloader.cache.memory;

import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.Image;
import kntr.base.imageloader.cache.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryCache.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000eH¦\u0002J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0012H¦\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u000eH&J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0015H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u0005\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lkntr/base/imageloader/cache/memory/MemoryCache;", "", "size", "", "getSize", "()I", "maxSize", "getMaxSize", "setMaxSize", "(I)V", "initialMaxSize", "getInitialMaxSize", "keys", "", "Lkntr/base/imageloader/cache/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "get", "Lkntr/base/imageloader/cache/memory/MemoryCache$Value;", "key", "set", "", "value", "remove", "", "trimToSize", "clear", "Key", "Value", "Builder", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface MemoryCache {
    void clear();

    Value get(Key key);

    int getInitialMaxSize();

    Set<Key> getKeys();

    int getMaxSize();

    int getSize();

    boolean remove(Key key);

    void set(Key key, Value value);

    void setMaxSize(int i);

    void trimToSize(int i);

    /* compiled from: MemoryCache.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lkntr/base/imageloader/cache/memory/MemoryCache$Key;", "", "key", "", "extras", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getKey", "()Ljava/lang/String;", "getExtras", "()Ljava/util/Map;", "copy", "equals", "", "other", "hashCode", "", "toString", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Key {
        public static final int $stable = 8;
        private final Map<String, String> extras;
        private final String key;

        public Key(String key, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(map, "extras");
            this.key = key;
            this.extras = map;
        }

        public /* synthetic */ Key(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final String getKey() {
            return this.key;
        }

        public final Map<String, String> getExtras() {
            return this.extras;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Key copy$default(Key key, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = key.key;
            }
            if ((i & 2) != 0) {
                map = key.extras;
            }
            return key.copy(str, map);
        }

        public final Key copy(String key, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(map, "extras");
            return new Key(key, map);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Key) && Intrinsics.areEqual(this.key, ((Key) other).key) && Intrinsics.areEqual(this.extras, ((Key) other).extras);
        }

        public int hashCode() {
            int result = this.key.hashCode();
            return (result * 31) + this.extras.hashCode();
        }

        public String toString() {
            String str = this.key;
            return "Key(key=" + str + ", extras=" + this.extras + ")";
        }
    }

    /* compiled from: MemoryCache.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lkntr/base/imageloader/cache/memory/MemoryCache$Value;", "", "image", "Lkntr/base/imageloader/Image;", "extras", "", "", "<init>", "(Lkntr/base/imageloader/Image;Ljava/util/Map;)V", "getImage", "()Lkntr/base/imageloader/Image;", "getExtras", "()Ljava/util/Map;", "copy", "equals", "", "other", "hashCode", "", "toString", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Value {
        public static final int $stable = 8;
        private final Map<String, Object> extras;
        private final Image image;

        public Value(Image image, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(map, "extras");
            this.image = image;
            this.extras = map;
        }

        public /* synthetic */ Value(Image image, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(image, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Image getImage() {
            return this.image;
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Value copy$default(Value value, Image image, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                image = value.image;
            }
            if ((i & 2) != 0) {
                map = value.extras;
            }
            return value.copy(image, map);
        }

        public final Value copy(Image image, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(map, "extras");
            return new Value(image, map);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Value) && Intrinsics.areEqual(this.image, ((Value) other).image) && Intrinsics.areEqual(this.extras, ((Value) other).extras);
        }

        public int hashCode() {
            int result = this.image.hashCode();
            return (result * 31) + this.extras.hashCode();
        }

        public String toString() {
            Image image = this.image;
            return "Value(image=" + image + ", extras=" + this.extras + ")";
        }
    }

    /* compiled from: MemoryCache.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/base/imageloader/cache/memory/MemoryCache$Builder;", "", "<init>", "()V", "maxSizeBytesFactory", "Lkotlin/Function0;", "", "strongReferencesEnabled", "", "weakReferencesEnabled", "maxSizeBytes", "size", "enable", "build", "Lkntr/base/imageloader/cache/memory/MemoryCache;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Builder {
        public static final int $stable = 8;
        private Function0<Integer> maxSizeBytesFactory;
        private boolean strongReferencesEnabled = true;
        private boolean weakReferencesEnabled = true;

        public final Builder maxSizeBytes(final int size) {
            Builder $this$maxSizeBytes_u24lambda_u240 = this;
            $this$maxSizeBytes_u24lambda_u240.maxSizeBytesFactory = new Function0() { // from class: kntr.base.imageloader.cache.memory.MemoryCache$Builder$$ExternalSyntheticLambda0
                public final Object invoke() {
                    int maxSizeBytes$lambda$0$0;
                    maxSizeBytes$lambda$0$0 = MemoryCache.Builder.maxSizeBytes$lambda$0$0(size);
                    return Integer.valueOf(maxSizeBytes$lambda$0$0);
                }
            };
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int maxSizeBytes$lambda$0$0(int $size) {
            return $size;
        }

        public final Builder strongReferencesEnabled(boolean enable) {
            Builder $this$strongReferencesEnabled_u24lambda_u240 = this;
            $this$strongReferencesEnabled_u24lambda_u240.strongReferencesEnabled = enable;
            return this;
        }

        public final Builder weakReferencesEnabled(boolean enable) {
            Builder $this$weakReferencesEnabled_u24lambda_u240 = this;
            $this$weakReferencesEnabled_u24lambda_u240.weakReferencesEnabled = enable;
            return this;
        }

        public final MemoryCache build() {
            EmptyWeakMemoryCache weakMemoryCache;
            EmptyStrongMemoryCache emptyStrongMemoryCache;
            if (this.weakReferencesEnabled) {
                weakMemoryCache = new RealWeakMemoryCache();
            } else {
                weakMemoryCache = new EmptyWeakMemoryCache();
            }
            if (this.strongReferencesEnabled) {
                Function0 maxSizeBytesFactory = this.maxSizeBytesFactory;
                if (maxSizeBytesFactory == null) {
                    throw new IllegalStateException("maxSizeBytesFactory == null".toString());
                }
                int maxSizeBytes = ((Number) maxSizeBytesFactory.invoke()).intValue();
                emptyStrongMemoryCache = new RealStrongMemoryCache(maxSizeBytes, weakMemoryCache);
            } else {
                emptyStrongMemoryCache = new EmptyStrongMemoryCache(weakMemoryCache);
            }
            StrongMemoryCache strongMemoryCache = emptyStrongMemoryCache;
            return new RealMemoryCache(strongMemoryCache, weakMemoryCache);
        }
    }
}