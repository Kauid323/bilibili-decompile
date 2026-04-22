package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HttpCacheStorage.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Use new [CacheStorage] instead.")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\b'\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "", "<init>", "()V", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "value", "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/HttpCacheEntry;)V", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;)Lio/ktor/client/plugins/cache/HttpCacheEntry;", "", "findByUrl", "(Lio/ktor/http/Url;)Ljava/util/Set;", "Companion", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class HttpCacheStorage {
    public static final Companion Companion = new Companion(null);
    private static final Function0<HttpCacheStorage> Unlimited = new Function0() { // from class: io.ktor.client.plugins.cache.storage.HttpCacheStorage$$ExternalSyntheticLambda0
        public final Object invoke() {
            UnlimitedCacheStorage Unlimited$lambda$0;
            Unlimited$lambda$0 = HttpCacheStorage.Unlimited$lambda$0();
            return Unlimited$lambda$0;
        }
    };
    private static final HttpCacheStorage Disabled = DisabledCacheStorage.INSTANCE;

    public abstract HttpCacheEntry find(Url url, Map<String, String> map);

    public abstract Set<HttpCacheEntry> findByUrl(Url url);

    public abstract void store(Url url, HttpCacheEntry httpCacheEntry);

    /* compiled from: HttpCacheStorage.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/cache/storage/HttpCacheStorage$Companion;", "", "<init>", "()V", "Lkotlin/Function0;", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "Unlimited", "Lkotlin/jvm/functions/Function0;", "getUnlimited", "()Lkotlin/jvm/functions/Function0;", "Disabled", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getDisabled", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<HttpCacheStorage> getUnlimited() {
            return HttpCacheStorage.Unlimited;
        }

        public final HttpCacheStorage getDisabled() {
            return HttpCacheStorage.Disabled;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UnlimitedCacheStorage Unlimited$lambda$0() {
        return new UnlimitedCacheStorage();
    }
}