package io.ktor.client.plugins.cache.storage;

import im.setting.UtilsKt;
import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.util.collections.ConcurrentSetKt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnlimitedCacheStorage.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/cache/storage/UnlimitedStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "<init>", "()V", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", UtilsKt.DATA_KEY, "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/collections/ConcurrentMap;", "", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnlimitedStorage implements CacheStorage {
    private final ConcurrentMap<Url, Set<CachedResponseData>> store = new ConcurrentMap<>(0, 1, (DefaultConstructorMarker) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set store$lambda$0() {
        return ConcurrentSetKt.ConcurrentSet();
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData data, Continuation<? super Unit> continuation) {
        Set cache = (Set) this.store.computeIfAbsent(url, new Function0() { // from class: io.ktor.client.plugins.cache.storage.UnlimitedStorage$$ExternalSyntheticLambda1
            public final Object invoke() {
                Set store$lambda$0;
                store$lambda$0 = UnlimitedStorage.store$lambda$0();
                return store$lambda$0;
            }
        });
        if (!cache.add(data)) {
            cache.remove(data);
            cache.add(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set find$lambda$1() {
        return ConcurrentSetKt.ConcurrentSet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
        continue;
     */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object find(Url url, Map<String, String> map, Continuation<? super CachedResponseData> continuation) {
        Set data = (Set) this.store.computeIfAbsent(url, new Function0() { // from class: io.ktor.client.plugins.cache.storage.UnlimitedStorage$$ExternalSyntheticLambda0
            public final Object invoke() {
                Set find$lambda$1;
                find$lambda$1 = UnlimitedStorage.find$lambda$1();
                return find$lambda$1;
            }
        });
        for (Object obj : data) {
            CachedResponseData it = (CachedResponseData) obj;
            boolean z = true;
            if (!map.isEmpty()) {
                Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Map.Entry element$iv = it2.next();
                        String key = element$iv.getKey();
                        String value = element$iv.getValue();
                        if (!Intrinsics.areEqual(it.getVaryKeys().get(key), value)) {
                            z = false;
                            continue;
                            break;
                        }
                    }
                }
            }
            if (z) {
                return obj;
            }
        }
        return null;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object findAll(Url url, Continuation<? super Set<CachedResponseData>> continuation) {
        Set set = (Set) this.store.get(url);
        return set == null ? SetsKt.emptySet() : set;
    }
}