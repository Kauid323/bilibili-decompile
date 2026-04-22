package io.ktor.client.plugins.cache;

import com.tencent.open.SocialConstants;
import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.cache.storage.CacheStorage;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.pipeline.PipelinePhase;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.KtorDsl;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: HttpCache.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 .2\u00020\u0001:\u0002/.B9\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J>\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0082@¢\u0006\u0004\b\u001c\u0010\"R \u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010#\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%R \u0010\u0004\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010#\u0012\u0004\b)\u0010'\u001a\u0004\b(\u0010%R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010*R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010*R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010+R\u001a\u0010\n\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010+\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache;", "", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "publicStorage", "privateStorage", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "publicStorageNew", "privateStorageNew", "", "useOldStorage", "isSharedClient", "<init>", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/plugins/cache/storage/CacheStorage;ZZ)V", "Lio/ktor/client/statement/HttpResponse;", "response", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "cacheResponse", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequest;", SocialConstants.TYPE_REQUEST, "findAndRefresh", "(Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "storage", "", "", "varyKeys", "Lio/ktor/http/Url;", "url", "findResponse", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Ljava/util/Map;Lio/ktor/http/Url;Lio/ktor/client/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestBuilder;", "context", "Lio/ktor/http/content/OutgoingContent;", q.KEY_RES_9_CONTENT, "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getPublicStorage$ktor_client_core", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getPublicStorage$ktor_client_core$annotations", "()V", "getPrivateStorage$ktor_client_core", "getPrivateStorage$ktor_client_core$annotations", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Z", "isSharedClient$ktor_client_core", "()Z", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpCache {
    public static final Companion Companion = new Companion(null);
    private static final EventDefinition<HttpResponse> HttpResponseFromCache;
    private static final AttributeKey<HttpCache> key;
    private final boolean isSharedClient;
    private final HttpCacheStorage privateStorage;
    private final CacheStorage privateStorageNew;
    private final HttpCacheStorage publicStorage;
    private final CacheStorage publicStorageNew;
    private final boolean useOldStorage;

    public /* synthetic */ HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, CacheStorage cacheStorage, CacheStorage cacheStorage2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpCacheStorage, httpCacheStorage2, cacheStorage, cacheStorage2, z, z2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This will become internal")
    public static /* synthetic */ void getPrivateStorage$ktor_client_core$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This will become internal")
    public static /* synthetic */ void getPublicStorage$ktor_client_core$annotations() {
    }

    private HttpCache(HttpCacheStorage publicStorage, HttpCacheStorage privateStorage, CacheStorage publicStorageNew, CacheStorage privateStorageNew, boolean useOldStorage, boolean isSharedClient) {
        this.publicStorage = publicStorage;
        this.privateStorage = privateStorage;
        this.publicStorageNew = publicStorageNew;
        this.privateStorageNew = privateStorageNew;
        this.useOldStorage = useOldStorage;
        this.isSharedClient = isSharedClient;
    }

    public final HttpCacheStorage getPublicStorage$ktor_client_core() {
        return this.publicStorage;
    }

    public final HttpCacheStorage getPrivateStorage$ktor_client_core() {
        return this.privateStorage;
    }

    public final boolean isSharedClient$ktor_client_core() {
        return this.isSharedClient;
    }

    /* compiled from: HttpCache.kt */
    @KtorDsl
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bR\"\u0010\n\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R0\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b\u0007\u0010\u001d\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010\t\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b\t\u0010\u001d\u0012\u0004\b%\u0010\u0003\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006&"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Config;", "", "<init>", "()V", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "storage", "", "publicStorage", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;)V", "privateStorage", "publicStorageNew", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "getPublicStorageNew$ktor_client_core", "()Lio/ktor/client/plugins/cache/storage/CacheStorage;", "setPublicStorageNew$ktor_client_core", "privateStorageNew", "getPrivateStorageNew$ktor_client_core", "setPrivateStorageNew$ktor_client_core", "", "useOldStorage", "Z", "getUseOldStorage$ktor_client_core", "()Z", "setUseOldStorage$ktor_client_core", "(Z)V", "isShared", "setShared", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "value", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getPublicStorage", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "setPublicStorage", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;)V", "getPublicStorage$annotations", "getPrivateStorage", "setPrivateStorage", "getPrivateStorage$annotations", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Config {
        private boolean isShared;
        private boolean useOldStorage;
        private CacheStorage publicStorageNew = (CacheStorage) CacheStorage.Companion.getUnlimited().invoke();
        private CacheStorage privateStorageNew = (CacheStorage) CacheStorage.Companion.getUnlimited().invoke();
        private HttpCacheStorage publicStorage = (HttpCacheStorage) HttpCacheStorage.Companion.getUnlimited().invoke();
        private HttpCacheStorage privateStorage = (HttpCacheStorage) HttpCacheStorage.Companion.getUnlimited().invoke();

        @Deprecated(level = DeprecationLevel.ERROR, message = "This will become internal. Use setter method instead with new storage interface")
        public static /* synthetic */ void getPrivateStorage$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "This will become internal. Use setter method instead with new storage interface")
        public static /* synthetic */ void getPublicStorage$annotations() {
        }

        public final CacheStorage getPublicStorageNew$ktor_client_core() {
            return this.publicStorageNew;
        }

        public final void setPublicStorageNew$ktor_client_core(CacheStorage cacheStorage) {
            Intrinsics.checkNotNullParameter(cacheStorage, "<set-?>");
            this.publicStorageNew = cacheStorage;
        }

        public final CacheStorage getPrivateStorageNew$ktor_client_core() {
            return this.privateStorageNew;
        }

        public final void setPrivateStorageNew$ktor_client_core(CacheStorage cacheStorage) {
            Intrinsics.checkNotNullParameter(cacheStorage, "<set-?>");
            this.privateStorageNew = cacheStorage;
        }

        public final boolean getUseOldStorage$ktor_client_core() {
            return this.useOldStorage;
        }

        public final void setUseOldStorage$ktor_client_core(boolean z) {
            this.useOldStorage = z;
        }

        public final boolean isShared() {
            return this.isShared;
        }

        public final void setShared(boolean z) {
            this.isShared = z;
        }

        public final HttpCacheStorage getPublicStorage() {
            return this.publicStorage;
        }

        public final void setPublicStorage(HttpCacheStorage value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.useOldStorage = true;
            this.publicStorage = value;
        }

        public final HttpCacheStorage getPrivateStorage() {
            return this.privateStorage;
        }

        public final void setPrivateStorage(HttpCacheStorage value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.useOldStorage = true;
            this.privateStorage = value;
        }

        public final void publicStorage(CacheStorage storage) {
            Intrinsics.checkNotNullParameter(storage, "storage");
            this.publicStorageNew = storage;
        }

        public final void privateStorage(CacheStorage storage) {
            Intrinsics.checkNotNullParameter(storage, "storage");
            this.privateStorageNew = storage;
        }
    }

    /* compiled from: HttpCache.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J0\u0010\u0018\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0080@¢\u0006\u0004\b\u0016\u0010\u0017J8\u0010\u001d\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@¢\u0006\u0004\b\u001d\u0010\u001eJ(\u0010!\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0080@¢\u0006\u0004\b\u001f\u0010 R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cache/HttpCache$Config;", "Lio/ktor/client/plugins/cache/HttpCache;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/cache/HttpCache;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/call/HttpClientCall;", "cachedCall", "proceedWithCache$ktor_client_core", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/HttpClient;Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWithCache", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "cachedResponse", "Lkotlin/coroutines/CoroutineContext;", "callContext", "proceedWithWarning", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lio/ktor/client/HttpClient;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWithMissingCache$ktor_client_core", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWithMissingCache", "Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "HttpResponseFromCache", "Lio/ktor/events/EventDefinition;", "getHttpResponseFromCache", "()Lio/ktor/events/EventDefinition;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion implements HttpClientPlugin<Config, HttpCache> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCache> getKey() {
            return HttpCache.key;
        }

        public final EventDefinition<HttpResponse> getHttpResponseFromCache() {
            return HttpCache.HttpResponseFromCache;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpCache prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new HttpCache(config.getPublicStorage(), config.getPrivateStorage(), config.getPublicStorageNew$ktor_client_core(), config.getPrivateStorageNew$ktor_client_core(), config.getUseOldStorage$ktor_client_core(), config.isShared(), null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpCache plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            PipelinePhase CachePhase = new PipelinePhase("Cache");
            scope.getSendPipeline().insertPhaseAfter(HttpSendPipeline.Phases.getState(), CachePhase);
            scope.getSendPipeline().intercept(CachePhase, new HttpCache$Companion$install$1(plugin, scope, null));
            scope.getReceivePipeline().intercept(HttpReceivePipeline.Phases.getState(), new HttpCache$Companion$install$2(plugin, scope, null));
        }

        public final Object proceedWithCache$ktor_client_core(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClient scope, HttpClientCall cachedCall, Continuation<? super Unit> continuation) {
            pipelineContext.finish();
            scope.getMonitor().raise(getHttpResponseFromCache(), cachedCall.getResponse());
            Object proceedWith = pipelineContext.proceedWith(cachedCall, continuation);
            return proceedWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWith : Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object proceedWithWarning(PipelineContext<Object, HttpRequestBuilder> pipelineContext, CachedResponseData cachedResponse, HttpClient scope, CoroutineContext callContext, Continuation<? super Unit> continuation) {
            HttpRequestData request = ((HttpRequestBuilder) pipelineContext.getContext()).build();
            HttpStatusCode statusCode = cachedResponse.getStatusCode();
            GMTDate requestTime = cachedResponse.getRequestTime();
            Headers.Companion companion = Headers.Companion;
            HeadersBuilder $this$proceedWithWarning_u24lambda_u241 = new HeadersBuilder(0, 1, null);
            $this$proceedWithWarning_u24lambda_u241.appendAll(cachedResponse.getHeaders());
            $this$proceedWithWarning_u24lambda_u241.append(HttpHeaders.INSTANCE.getWarning(), "110");
            Unit unit = Unit.INSTANCE;
            HttpResponseData response = new HttpResponseData(statusCode, requestTime, $this$proceedWithWarning_u24lambda_u241.m3526build(), cachedResponse.getVersion(), ByteChannelCtorKt.ByteReadChannel$default(cachedResponse.getBody(), 0, 0, 6, (Object) null), callContext);
            HttpClientCall call = new HttpClientCall(scope, request, response);
            pipelineContext.finish();
            scope.getMonitor().raise(getHttpResponseFromCache(), call.getResponse());
            Object proceedWith = pipelineContext.proceedWith(call, continuation);
            return proceedWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWith : Unit.INSTANCE;
        }

        public final Object proceedWithMissingCache$ktor_client_core(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClient scope, Continuation<? super Unit> continuation) {
            pipelineContext.finish();
            HttpRequestData request = ((HttpRequestBuilder) pipelineContext.getContext()).build();
            HttpResponseData response = new HttpResponseData(HttpStatusCode.Companion.getGatewayTimeout(), DateJvmKt.GMTDate$default((Long) null, 1, (Object) null), Headers.Companion.getEmpty(), HttpProtocolVersion.Companion.getHTTP_1_1(), ByteChannelCtorKt.ByteReadChannel$default(new byte[0], 0, 0, 6, (Object) null), request.getExecutionContext());
            HttpClientCall call = new HttpClientCall(scope, request, response);
            Object proceedWith = pipelineContext.proceedWith(call, continuation);
            return proceedWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWith : Unit.INSTANCE;
        }
    }

    static {
        KType kType = null;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpCache.class);
        try {
            kType = Reflection.typeOf(HttpCache.class);
        } catch (Throwable th) {
        }
        key = new AttributeKey<>("HttpCache", new TypeInfo(orCreateKotlinClass, kType));
        HttpResponseFromCache = new EventDefinition<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object cacheResponse(HttpResponse response, Continuation<? super CachedResponseData> continuation) {
        HttpRequest request = response.getCall().getRequest();
        List responseCacheControl = HttpMessagePropertiesKt.cacheControl(response);
        List requestCacheControl = HttpMessagePropertiesKt.cacheControl(request);
        boolean isPrivate = responseCacheControl.contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core());
        if (isPrivate && this.isSharedClient) {
            return null;
        }
        CacheStorage storage = isPrivate ? this.privateStorageNew : this.publicStorageNew;
        if (responseCacheControl.contains(CacheControl.INSTANCE.getNO_STORE$ktor_client_core()) || requestCacheControl.contains(CacheControl.INSTANCE.getNO_STORE$ktor_client_core())) {
            return null;
        }
        return HttpCacheStorageKt.store(storage, response, HttpCacheEntryKt.varyKeys(response), this.isSharedClient, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object findAndRefresh(HttpRequest httpRequest, HttpResponse response, Continuation<? super HttpResponse> continuation) {
        Continuation<? super Unit> httpCache$findAndRefresh$1;
        HttpRequest request;
        Map varyKeysFrom304;
        Object findResponse;
        HttpCache httpCache;
        HttpResponse response2;
        CacheStorage storage;
        CachedResponseData cache;
        HttpRequest request2;
        if (continuation instanceof HttpCache$findAndRefresh$1) {
            httpCache$findAndRefresh$1 = (HttpCache$findAndRefresh$1) continuation;
            if ((httpCache$findAndRefresh$1.label & Integer.MIN_VALUE) != 0) {
                httpCache$findAndRefresh$1.label -= Integer.MIN_VALUE;
                Object $result = httpCache$findAndRefresh$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCache$findAndRefresh$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        request = httpRequest;
                        Url url = response.getCall().getRequest().getUrl();
                        List cacheControl = HttpMessagePropertiesKt.cacheControl(response);
                        boolean isPrivate = cacheControl.contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core());
                        if (isPrivate && this.isSharedClient) {
                            return null;
                        }
                        CacheStorage cacheStorage = isPrivate ? this.privateStorageNew : this.publicStorageNew;
                        CacheStorage storage2 = cacheStorage;
                        Map varyKeysFrom3042 = HttpCacheEntryKt.varyKeys(response);
                        httpCache$findAndRefresh$1.L$0 = this;
                        httpCache$findAndRefresh$1.L$1 = request;
                        httpCache$findAndRefresh$1.L$2 = response;
                        httpCache$findAndRefresh$1.L$3 = storage2;
                        httpCache$findAndRefresh$1.L$4 = varyKeysFrom3042;
                        httpCache$findAndRefresh$1.label = 1;
                        varyKeysFrom304 = varyKeysFrom3042;
                        findResponse = findResponse(cacheStorage, varyKeysFrom3042, url, request, httpCache$findAndRefresh$1);
                        if (findResponse == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        httpCache = this;
                        response2 = response;
                        storage = storage2;
                        cache = (CachedResponseData) findResponse;
                        if (cache != null) {
                            return null;
                        }
                        if (varyKeysFrom304.isEmpty()) {
                            varyKeysFrom304 = cache.getVaryKeys();
                        }
                        Map newVaryKeys = varyKeysFrom304;
                        Url url2 = request.getUrl();
                        CachedResponseData copy$ktor_client_core = cache.copy$ktor_client_core(newVaryKeys, HttpCacheEntryKt.cacheExpires$default(response2, httpCache.isSharedClient, null, 2, null));
                        httpCache$findAndRefresh$1.L$0 = request;
                        httpCache$findAndRefresh$1.L$1 = response2;
                        httpCache$findAndRefresh$1.L$2 = cache;
                        httpCache$findAndRefresh$1.L$3 = null;
                        httpCache$findAndRefresh$1.L$4 = null;
                        httpCache$findAndRefresh$1.label = 2;
                        if (storage.store(url2, copy$ktor_client_core, httpCache$findAndRefresh$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        request2 = request;
                        return HttpCacheStorageKt.createResponse(cache, request2.getCall().getClient(), request2, response2.getCoroutineContext());
                    case 1:
                        HttpResponse response3 = (HttpResponse) httpCache$findAndRefresh$1.L$2;
                        httpCache = (HttpCache) httpCache$findAndRefresh$1.L$0;
                        ResultKt.throwOnFailure($result);
                        varyKeysFrom304 = (Map) httpCache$findAndRefresh$1.L$4;
                        request = (HttpRequest) httpCache$findAndRefresh$1.L$1;
                        findResponse = $result;
                        storage = (CacheStorage) httpCache$findAndRefresh$1.L$3;
                        response2 = response3;
                        cache = (CachedResponseData) findResponse;
                        if (cache != null) {
                        }
                        break;
                    case 2:
                        cache = (CachedResponseData) httpCache$findAndRefresh$1.L$2;
                        response2 = (HttpResponse) httpCache$findAndRefresh$1.L$1;
                        request2 = (HttpRequest) httpCache$findAndRefresh$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return HttpCacheStorageKt.createResponse(cache, request2.getCall().getClient(), request2, response2.getCoroutineContext());
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        httpCache$findAndRefresh$1 = new HttpCache$findAndRefresh$1(this, continuation);
        Object $result2 = httpCache$findAndRefresh$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCache$findAndRefresh$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object findResponse(CacheStorage storage, Map<String, String> map, Url url, HttpRequest request, Continuation<? super CachedResponseData> continuation) {
        HttpCache$findResponse$1 httpCache$findResponse$1;
        boolean z;
        Object findAll;
        Function1 requestHeaders;
        Iterator it;
        Object element$iv;
        if (continuation instanceof HttpCache$findResponse$1) {
            httpCache$findResponse$1 = (HttpCache$findResponse$1) continuation;
            if ((httpCache$findResponse$1.label & Integer.MIN_VALUE) != 0) {
                httpCache$findResponse$1.label -= Integer.MIN_VALUE;
                Object $result = httpCache$findResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                z = true;
                switch (httpCache$findResponse$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!map.isEmpty()) {
                            httpCache$findResponse$1.label = 1;
                            Object find = storage.find(url, map, httpCache$findResponse$1);
                            return find == coroutine_suspended ? coroutine_suspended : find;
                        }
                        Function1 requestHeaders2 = HttpCacheKt.mergedHeadersLookup(request.getContent(), new HttpCache$findResponse$requestHeaders$1(request.getHeaders()), new HttpCache$findResponse$requestHeaders$2(request.getHeaders()));
                        httpCache$findResponse$1.L$0 = requestHeaders2;
                        httpCache$findResponse$1.label = 2;
                        findAll = storage.findAll(url, httpCache$findResponse$1);
                        if (findAll != coroutine_suspended) {
                            requestHeaders = requestHeaders2;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 2:
                        requestHeaders = (Function1) httpCache$findResponse$1.L$0;
                        ResultKt.throwOnFailure($result);
                        findAll = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Iterable $this$sortedByDescending$iv = (Iterable) findAll;
                Iterable $this$firstOrNull$iv = CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: io.ktor.client.plugins.cache.HttpCache$findResponse$$inlined$sortedByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        CachedResponseData it2 = (CachedResponseData) t2;
                        CachedResponseData it3 = (CachedResponseData) t;
                        return ComparisonsKt.compareValues((Comparable) it2.getResponseTime(), (Comparable) it3.getResponseTime());
                    }
                });
                it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = null;
                    } else {
                        element$iv = it.next();
                        CachedResponseData cachedResponse = (CachedResponseData) element$iv;
                        Map $this$all$iv = cachedResponse.getVaryKeys();
                        if (!$this$all$iv.isEmpty()) {
                            Iterator<Map.Entry<String, String>> it2 = $this$all$iv.entrySet().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Map.Entry element$iv2 = it2.next();
                                    String key2 = element$iv2.getKey();
                                    String value = element$iv2.getValue();
                                    if (!Intrinsics.areEqual(requestHeaders.invoke(key2), value)) {
                                        z = false;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        }
                        if (!z) {
                            z = true;
                        }
                    }
                }
                return (CachedResponseData) element$iv;
            }
        }
        httpCache$findResponse$1 = new HttpCache$findResponse$1(this, continuation);
        Object $result2 = httpCache$findResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        z = true;
        switch (httpCache$findResponse$1.label) {
        }
        Iterable $this$sortedByDescending$iv2 = (Iterable) findAll;
        Iterable $this$firstOrNull$iv2 = CollectionsKt.sortedWith($this$sortedByDescending$iv2, new Comparator() { // from class: io.ktor.client.plugins.cache.HttpCache$findResponse$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                CachedResponseData it22 = (CachedResponseData) t2;
                CachedResponseData it3 = (CachedResponseData) t;
                return ComparisonsKt.compareValues((Comparable) it22.getResponseTime(), (Comparable) it3.getResponseTime());
            }
        });
        it = $this$firstOrNull$iv2.iterator();
        while (true) {
            if (it.hasNext()) {
            }
            z = true;
        }
        return (CachedResponseData) element$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object findResponse(HttpRequestBuilder context, OutgoingContent content, Continuation<? super CachedResponseData> continuation) {
        HttpCache$findResponse$4 httpCache$findResponse$4;
        HttpCache httpCache;
        Url url;
        Function1 lookup;
        Object findAll;
        Object findAll2;
        Set set;
        Map $this$all$iv;
        if (continuation instanceof HttpCache$findResponse$4) {
            httpCache$findResponse$4 = (HttpCache$findResponse$4) continuation;
            if ((httpCache$findResponse$4.label & Integer.MIN_VALUE) != 0) {
                httpCache$findResponse$4.label -= Integer.MIN_VALUE;
                Object $result = httpCache$findResponse$4.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCache$findResponse$4.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        httpCache = this;
                        url = URLUtilsKt.Url(context.getUrl());
                        lookup = HttpCacheKt.mergedHeadersLookup(content, new HttpCache$findResponse$lookup$1(context.getHeaders()), new HttpCache$findResponse$lookup$2(context.getHeaders()));
                        CacheStorage cacheStorage = httpCache.privateStorageNew;
                        httpCache$findResponse$4.L$0 = httpCache;
                        httpCache$findResponse$4.L$1 = url;
                        httpCache$findResponse$4.L$2 = lookup;
                        httpCache$findResponse$4.label = 1;
                        findAll = cacheStorage.findAll(url, httpCache$findResponse$4);
                        if (findAll == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Set set2 = (Set) findAll;
                        CacheStorage cacheStorage2 = httpCache.publicStorageNew;
                        httpCache$findResponse$4.L$0 = lookup;
                        httpCache$findResponse$4.L$1 = set2;
                        httpCache$findResponse$4.L$2 = null;
                        httpCache$findResponse$4.label = 2;
                        findAll2 = cacheStorage2.findAll(url, httpCache$findResponse$4);
                        if (findAll2 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        set = set2;
                        Set<CachedResponseData> cachedResponses = SetsKt.plus(set, (Iterable) findAll2);
                        for (CachedResponseData item : cachedResponses) {
                            Map varyKeys = item.getVaryKeys();
                            if (!varyKeys.isEmpty()) {
                                if (varyKeys.isEmpty()) {
                                    $this$all$iv = 1;
                                    continue;
                                } else {
                                    Iterator<Map.Entry<String, String>> it = varyKeys.entrySet().iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            Map.Entry element$iv = it.next();
                                            String key2 = element$iv.getKey();
                                            String value = element$iv.getValue();
                                            if (!Intrinsics.areEqual(lookup.invoke(key2), value)) {
                                                $this$all$iv = null;
                                                continue;
                                            }
                                        } else {
                                            $this$all$iv = 1;
                                            continue;
                                        }
                                    }
                                }
                                if ($this$all$iv != null) {
                                }
                            }
                            return item;
                            break;
                        }
                        return null;
                    case 1:
                        lookup = (Function1) httpCache$findResponse$4.L$2;
                        httpCache = (HttpCache) httpCache$findResponse$4.L$0;
                        ResultKt.throwOnFailure($result);
                        url = (Url) httpCache$findResponse$4.L$1;
                        findAll = $result;
                        Set set22 = (Set) findAll;
                        CacheStorage cacheStorage22 = httpCache.publicStorageNew;
                        httpCache$findResponse$4.L$0 = lookup;
                        httpCache$findResponse$4.L$1 = set22;
                        httpCache$findResponse$4.L$2 = null;
                        httpCache$findResponse$4.label = 2;
                        findAll2 = cacheStorage22.findAll(url, httpCache$findResponse$4);
                        if (findAll2 != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        set = (Set) httpCache$findResponse$4.L$1;
                        lookup = (Function1) httpCache$findResponse$4.L$0;
                        ResultKt.throwOnFailure($result);
                        findAll2 = $result;
                        Set<CachedResponseData> cachedResponses2 = SetsKt.plus(set, (Iterable) findAll2);
                        while (r8.hasNext()) {
                        }
                        return null;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        httpCache$findResponse$4 = new HttpCache$findResponse$4(this, continuation);
        Object $result2 = httpCache$findResponse$4.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCache$findResponse$4.label) {
        }
    }
}