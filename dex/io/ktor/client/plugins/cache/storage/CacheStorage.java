package io.ktor.client.plugins.cache.storage;

import im.setting.UtilsKt;
import io.ktor.client.plugins.cache.storage.CacheStorage;
import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* compiled from: HttpCacheStorage.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH¦@¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CacheStorage;", "", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", UtilsKt.DATA_KEY, "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface CacheStorage {
    public static final Companion Companion = Companion.$$INSTANCE;

    Object find(Url url, Map<String, String> map, Continuation<? super CachedResponseData> continuation);

    Object findAll(Url url, Continuation<? super Set<CachedResponseData>> continuation);

    Object store(Url url, CachedResponseData cachedResponseData, Continuation<? super Unit> continuation);

    /* compiled from: HttpCacheStorage.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CacheStorage$Companion;", "", "<init>", "()V", "Lkotlin/Function0;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Unlimited", "Lkotlin/jvm/functions/Function0;", "getUnlimited", "()Lkotlin/jvm/functions/Function0;", "Disabled", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "getDisabled", "()Lio/ktor/client/plugins/cache/storage/CacheStorage;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Function0<CacheStorage> Unlimited = new Function0() { // from class: io.ktor.client.plugins.cache.storage.CacheStorage$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                UnlimitedStorage Unlimited$lambda$0;
                Unlimited$lambda$0 = CacheStorage.Companion.Unlimited$lambda$0();
                return Unlimited$lambda$0;
            }
        };
        private static final CacheStorage Disabled = DisabledStorage.INSTANCE;

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final UnlimitedStorage Unlimited$lambda$0() {
            return new UnlimitedStorage();
        }

        public final Function0<CacheStorage> getUnlimited() {
            return Unlimited;
        }

        public final CacheStorage getDisabled() {
            return Disabled;
        }
    }
}