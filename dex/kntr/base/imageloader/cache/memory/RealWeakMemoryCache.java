package kntr.base.imageloader.cache.memory;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.Image;
import kntr.base.imageloader.cache.memory.MemoryCache;
import kntr.base.imageloader.cache.memory.RealWeakMemoryCache;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeakMemoryCache.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u0000 '2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J4\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0002J\r\u0010$\u001a\u00020\u0017H\u0000¢\u0006\u0002\b%RP\u0010\u0004\u001a>\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0005j\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t`\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, d2 = {"Lkntr/base/imageloader/cache/memory/RealWeakMemoryCache;", "Lkntr/base/imageloader/cache/memory/WeakMemoryCache;", "<init>", "()V", "cache", "Ljava/util/LinkedHashMap;", "Lkntr/base/imageloader/cache/memory/MemoryCache$Key;", "Ljava/util/ArrayList;", "Lkntr/base/imageloader/cache/memory/RealWeakMemoryCache$InternalValue;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "getCache$imageloader_debug", "()Ljava/util/LinkedHashMap;", "operationsSinceCleanUp", "", "keys", "", "getKeys", "()Ljava/util/Set;", "get", "Lkntr/base/imageloader/cache/memory/MemoryCache$Value;", "key", "set", "", "image", "Lkntr/base/imageloader/Image;", "extras", "", "", "", "size", "", "remove", "", "clear", "cleanUpIfNecessary", "cleanUp", "cleanUp$imageloader_debug", "InternalValue", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RealWeakMemoryCache implements WeakMemoryCache {
    private static final int CLEAN_UP_INTERVAL = 10;
    private final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> cache = new LinkedHashMap<>();
    private int operationsSinceCleanUp;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> getCache$imageloader_debug() {
        return this.cache;
    }

    @Override // kntr.base.imageloader.cache.memory.WeakMemoryCache
    public Set<MemoryCache.Key> getKeys() {
        Set<MemoryCache.Key> keySet = this.cache.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        return CollectionsKt.toSet(keySet);
    }

    @Override // kntr.base.imageloader.cache.memory.WeakMemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        MemoryCache.Value value;
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayList values = this.cache.get(key);
        MemoryCache.Value value2 = null;
        if (values == null) {
            return null;
        }
        Iterator<T> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            InternalValue value3 = (InternalValue) it.next();
            Image it2 = value3.getImage().get();
            if (it2 != null) {
                value = new MemoryCache.Value(it2, value3.getExtras());
                continue;
            } else {
                value = null;
                continue;
            }
            if (value != null) {
                value2 = value;
                break;
            }
        }
        cleanUpIfNecessary();
        return value2;
    }

    @Override // kntr.base.imageloader.cache.memory.WeakMemoryCache
    public void set(MemoryCache.Key key, Image image, Map<String, ? extends Object> map, long size) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(map, "extras");
        Map $this$getOrPut$iv = this.cache;
        ArrayList<InternalValue> arrayList2 = $this$getOrPut$iv.get(key);
        if (arrayList2 == null) {
            arrayList = new ArrayList<>();
            $this$getOrPut$iv.put(key, arrayList);
        } else {
            arrayList = arrayList2;
        }
        ArrayList values = arrayList;
        InternalValue newValue = new InternalValue(new WeakReference(image), map, size);
        if (values.isEmpty()) {
            values.add(newValue);
        } else {
            boolean inserted = false;
            int index = 0;
            int size2 = values.size();
            while (true) {
                if (index >= size2) {
                    break;
                }
                InternalValue internalValue = values.get(index);
                Intrinsics.checkNotNullExpressionValue(internalValue, "get(...)");
                InternalValue value = internalValue;
                if (size < value.getSize()) {
                    index++;
                } else {
                    if (value.getImage().get() == image) {
                        values.set(index, newValue);
                    } else {
                        values.add(index, newValue);
                    }
                    inserted = true;
                }
            }
            if (!inserted) {
                values.add(newValue);
            }
        }
        cleanUpIfNecessary();
    }

    @Override // kntr.base.imageloader.cache.memory.WeakMemoryCache
    public boolean remove(MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.cache.remove(key) != null;
    }

    @Override // kntr.base.imageloader.cache.memory.WeakMemoryCache
    public void clear() {
        this.operationsSinceCleanUp = 0;
        this.cache.clear();
    }

    private final void cleanUpIfNecessary() {
        int i = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = i + 1;
        if (i >= 10) {
            cleanUp$imageloader_debug();
        }
    }

    public final void cleanUp$imageloader_debug() {
        WeakReference<Image> image;
        this.operationsSinceCleanUp = 0;
        Iterator iterator = this.cache.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<InternalValue> next = iterator.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ArrayList<InternalValue> list = next;
            if (list.size() <= 1) {
                InternalValue internalValue = (InternalValue) CollectionsKt.firstOrNull(list);
                if (((internalValue == null || (image = internalValue.getImage()) == null) ? null : image.get()) == null) {
                    iterator.remove();
                }
            } else {
                CollectionsKt.removeAll(list, new Function1() { // from class: kntr.base.imageloader.cache.memory.RealWeakMemoryCache$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        boolean cleanUp$lambda$0;
                        cleanUp$lambda$0 = RealWeakMemoryCache.cleanUp$lambda$0((RealWeakMemoryCache.InternalValue) obj);
                        return Boolean.valueOf(cleanUp$lambda$0);
                    }
                });
                if (list.isEmpty()) {
                    iterator.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cleanUp$lambda$0(InternalValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getImage().get() == null;
    }

    /* compiled from: WeakMemoryCache.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B;\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR#\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkntr/base/imageloader/cache/memory/RealWeakMemoryCache$InternalValue;", "", "image", "Ljava/lang/ref/WeakReference;", "Lkntr/base/imageloader/Image;", "Lkntr/base/imageloader/utils/WeakReference;", "extras", "", "", "size", "", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/util/Map;J)V", "getImage", "()Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "getExtras", "()Ljava/util/Map;", "getSize", "()J", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class InternalValue {
        public static final int $stable = 8;
        private final Map<String, Object> extras;
        private final WeakReference<Image> image;
        private final long size;

        public InternalValue(WeakReference<Image> weakReference, Map<String, ? extends Object> map, long size) {
            Intrinsics.checkNotNullParameter(weakReference, "image");
            Intrinsics.checkNotNullParameter(map, "extras");
            this.image = weakReference;
            this.extras = map;
            this.size = size;
        }

        public final WeakReference<Image> getImage() {
            return this.image;
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public final long getSize() {
            return this.size;
        }
    }

    /* compiled from: WeakMemoryCache.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/base/imageloader/cache/memory/RealWeakMemoryCache$Companion;", "", "<init>", "()V", "CLEAN_UP_INTERVAL", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}