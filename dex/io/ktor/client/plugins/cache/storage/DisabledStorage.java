package io.ktor.client.plugins.cache.storage;

import im.setting.UtilsKt;
import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;

/* compiled from: DisabledCacheStorage.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/cache/storage/DisabledStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "<init>", "()V", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", UtilsKt.DATA_KEY, "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DisabledStorage implements CacheStorage {
    public static final DisabledStorage INSTANCE = new DisabledStorage();

    private DisabledStorage() {
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData data, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object find(Url url, Map<String, String> map, Continuation<? super CachedResponseData> continuation) {
        return null;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object findAll(Url url, Continuation<? super Set<CachedResponseData>> continuation) {
        return SetsKt.emptySet();
    }
}