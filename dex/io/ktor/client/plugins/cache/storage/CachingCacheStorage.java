package io.ktor.client.plugins.cache.storage;

import im.setting.UtilsKt;
import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0014R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CachingCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "delegate", "<init>", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;)V", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", UtilsKt.DATA_KEY, "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Lio/ktor/util/collections/ConcurrentMap;", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CachingCacheStorage implements CacheStorage {
    private final CacheStorage delegate;
    private final ConcurrentMap<Url, Set<CachedResponseData>> store;

    public CachingCacheStorage(CacheStorage delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.store = new ConcurrentMap<>(0, 1, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e A[RETURN] */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object store(Url url, CachedResponseData data, Continuation<? super Unit> continuation) {
        CachingCacheStorage$store$1 cachingCacheStorage$store$1;
        CachingCacheStorage cachingCacheStorage;
        Map map;
        Object findAll;
        if (continuation instanceof CachingCacheStorage$store$1) {
            cachingCacheStorage$store$1 = (CachingCacheStorage$store$1) continuation;
            if ((cachingCacheStorage$store$1.label & Integer.MIN_VALUE) != 0) {
                cachingCacheStorage$store$1.label -= Integer.MIN_VALUE;
                Object $result = cachingCacheStorage$store$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (cachingCacheStorage$store$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CacheStorage cacheStorage = this.delegate;
                        cachingCacheStorage$store$1.L$0 = this;
                        cachingCacheStorage$store$1.L$1 = url;
                        cachingCacheStorage$store$1.label = 1;
                        if (cacheStorage.store(url, data, cachingCacheStorage$store$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        cachingCacheStorage = this;
                        map = (Map) cachingCacheStorage.store;
                        CacheStorage cacheStorage2 = cachingCacheStorage.delegate;
                        cachingCacheStorage$store$1.L$0 = map;
                        cachingCacheStorage$store$1.L$1 = url;
                        cachingCacheStorage$store$1.label = 2;
                        findAll = cacheStorage2.findAll(url, cachingCacheStorage$store$1);
                        if (findAll == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map.put(url, findAll);
                        return Unit.INSTANCE;
                    case 1:
                        url = (Url) cachingCacheStorage$store$1.L$1;
                        cachingCacheStorage = (CachingCacheStorage) cachingCacheStorage$store$1.L$0;
                        ResultKt.throwOnFailure($result);
                        map = (Map) cachingCacheStorage.store;
                        CacheStorage cacheStorage22 = cachingCacheStorage.delegate;
                        cachingCacheStorage$store$1.L$0 = map;
                        cachingCacheStorage$store$1.L$1 = url;
                        cachingCacheStorage$store$1.label = 2;
                        findAll = cacheStorage22.findAll(url, cachingCacheStorage$store$1);
                        if (findAll == coroutine_suspended) {
                        }
                        map.put(url, findAll);
                        return Unit.INSTANCE;
                    case 2:
                        url = (Url) cachingCacheStorage$store$1.L$1;
                        ResultKt.throwOnFailure($result);
                        map = (Map) cachingCacheStorage$store$1.L$0;
                        findAll = $result;
                        map.put(url, findAll);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        cachingCacheStorage$store$1 = new CachingCacheStorage$store$1(this, continuation);
        Object $result2 = cachingCacheStorage$store$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (cachingCacheStorage$store$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object find(Url url, Map<String, String> map, Continuation<? super CachedResponseData> continuation) {
        CachingCacheStorage$find$1 cachingCacheStorage$find$1;
        CachingCacheStorage cachingCacheStorage;
        Map varyKeys;
        Url url2;
        Object findAll;
        Url url3;
        Map map2;
        Url url4;
        if (continuation instanceof CachingCacheStorage$find$1) {
            cachingCacheStorage$find$1 = (CachingCacheStorage$find$1) continuation;
            if ((cachingCacheStorage$find$1.label & Integer.MIN_VALUE) != 0) {
                cachingCacheStorage$find$1.label -= Integer.MIN_VALUE;
                Object $result = cachingCacheStorage$find$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (cachingCacheStorage$find$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        cachingCacheStorage = this;
                        varyKeys = map;
                        url2 = url;
                        if (!cachingCacheStorage.store.containsKey(url2)) {
                            Map map3 = cachingCacheStorage.store;
                            CacheStorage cacheStorage = cachingCacheStorage.delegate;
                            cachingCacheStorage$find$1.L$0 = cachingCacheStorage;
                            cachingCacheStorage$find$1.L$1 = url2;
                            cachingCacheStorage$find$1.L$2 = varyKeys;
                            cachingCacheStorage$find$1.L$3 = map3;
                            cachingCacheStorage$find$1.L$4 = url2;
                            cachingCacheStorage$find$1.label = 1;
                            findAll = cacheStorage.findAll(url2, cachingCacheStorage$find$1);
                            if (findAll == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            url3 = url2;
                            map2 = map3;
                            url4 = url3;
                            map2.put(url3, findAll);
                            url2 = url4;
                            break;
                        }
                        break;
                    case 1:
                        url3 = (Url) cachingCacheStorage$find$1.L$4;
                        map2 = (Map) cachingCacheStorage$find$1.L$3;
                        varyKeys = (Map) cachingCacheStorage$find$1.L$2;
                        url4 = (Url) cachingCacheStorage$find$1.L$1;
                        cachingCacheStorage = (CachingCacheStorage) cachingCacheStorage$find$1.L$0;
                        ResultKt.throwOnFailure($result);
                        findAll = $result;
                        map2.put(url3, findAll);
                        url2 = url4;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Set data = (Set) MapsKt.getValue(cachingCacheStorage.store, url2);
                for (Object obj : data) {
                    CachedResponseData it = (CachedResponseData) obj;
                    Map $this$all$iv = varyKeys;
                    if (!$this$all$iv.isEmpty()) {
                        Iterator<Map.Entry<String, String>> it2 = $this$all$iv.entrySet().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                Map.Entry element$iv = it2.next();
                                String key = element$iv.getKey();
                                String value = element$iv.getValue();
                                if (!Intrinsics.areEqual(it.getVaryKeys().get(key), value)) {
                                    z = false;
                                }
                            } else {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        return obj;
                    }
                    z = true;
                }
                return null;
            }
        }
        cachingCacheStorage$find$1 = new CachingCacheStorage$find$1(this, continuation);
        Object $result2 = cachingCacheStorage$find$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (cachingCacheStorage$find$1.label) {
        }
        Set data2 = (Set) MapsKt.getValue(cachingCacheStorage.store, url2);
        while (r4.hasNext()) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object findAll(Url url, Continuation<? super Set<CachedResponseData>> continuation) {
        CachingCacheStorage$findAll$1 cachingCacheStorage$findAll$1;
        CachingCacheStorage cachingCacheStorage;
        Object findAll;
        Map map;
        Url url2;
        if (continuation instanceof CachingCacheStorage$findAll$1) {
            cachingCacheStorage$findAll$1 = (CachingCacheStorage$findAll$1) continuation;
            if ((cachingCacheStorage$findAll$1.label & Integer.MIN_VALUE) != 0) {
                cachingCacheStorage$findAll$1.label -= Integer.MIN_VALUE;
                Object $result = cachingCacheStorage$findAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (cachingCacheStorage$findAll$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        cachingCacheStorage = this;
                        if (!cachingCacheStorage.store.containsKey(url)) {
                            Map map2 = cachingCacheStorage.store;
                            CacheStorage cacheStorage = cachingCacheStorage.delegate;
                            cachingCacheStorage$findAll$1.L$0 = cachingCacheStorage;
                            cachingCacheStorage$findAll$1.L$1 = url;
                            cachingCacheStorage$findAll$1.L$2 = map2;
                            cachingCacheStorage$findAll$1.L$3 = url;
                            cachingCacheStorage$findAll$1.label = 1;
                            findAll = cacheStorage.findAll(url, cachingCacheStorage$findAll$1);
                            if (findAll == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            map = map2;
                            url2 = url;
                            map.put(url, findAll);
                            url = url2;
                            break;
                        }
                        break;
                    case 1:
                        url = (Url) cachingCacheStorage$findAll$1.L$3;
                        map = (Map) cachingCacheStorage$findAll$1.L$2;
                        url2 = (Url) cachingCacheStorage$findAll$1.L$1;
                        cachingCacheStorage = (CachingCacheStorage) cachingCacheStorage$findAll$1.L$0;
                        ResultKt.throwOnFailure($result);
                        findAll = $result;
                        map.put(url, findAll);
                        url = url2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return MapsKt.getValue(cachingCacheStorage.store, url);
            }
        }
        cachingCacheStorage$findAll$1 = new CachingCacheStorage$findAll$1(this, continuation);
        Object $result2 = cachingCacheStorage$findAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (cachingCacheStorage$findAll$1.label) {
        }
        return MapsKt.getValue(cachingCacheStorage.store, url);
    }
}