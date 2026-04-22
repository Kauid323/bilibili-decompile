package io.ktor.client.plugins.cache;

import com.tencent.open.SocialConstants;
import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.date.GMTDate;
import io.ktor.util.pipeline.PipelineContext;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCacheLegacy.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a8\u0010\n\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0080@¢\u0006\u0004\b\n\u0010\u000b\u001a8\u0010\u000e\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0080@¢\u0006\u0004\b\u000e\u0010\u000f\u001a0\u0010\u0012\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00020\f*\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015\u001a%\u0010\u0018\u001a\u0004\u0018\u00010\f*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001aA\u0010\"\u001a\u0004\u0018\u00010!*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\"\u0010#\u001a%\u0010\"\u001a\u0004\u0018\u00010!*\u00020\u00032\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010%¨\u0006&"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/plugins/cache/HttpCache;", "plugin", "Lio/ktor/http/content/OutgoingContent;", q.KEY_RES_9_CONTENT, "Lio/ktor/client/HttpClient;", "scope", "", "interceptSendLegacy", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/http/content/OutgoingContent;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", "response", "interceptReceiveLegacy", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/statement/HttpResponse;Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/call/HttpClientCall;", "cachedCall", "proceedWithWarning", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/call/HttpClientCall;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheResponse", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequest;", SocialConstants.TYPE_REQUEST, "findAndRefresh", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;)Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "storage", "", "", "varyKeys", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "findResponse", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Ljava/util/Map;Lio/ktor/http/Url;Lio/ktor/client/request/HttpRequest;)Lio/ktor/client/plugins/cache/HttpCacheEntry;", "context", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/content/OutgoingContent;)Lio/ktor/client/plugins/cache/HttpCacheEntry;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpCacheLegacyKt {
    public static final Object interceptSendLegacy(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpCache plugin, OutgoingContent content, HttpClient scope, Continuation<? super Unit> continuation) {
        Object proceedWithMissingCache$ktor_client_core;
        HttpCacheEntry cache = findResponse(plugin, (HttpRequestBuilder) pipelineContext.getContext(), content);
        if (cache == null) {
            List header = HttpHeaderValueParserKt.parseHeaderValue(((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().get(HttpHeaders.INSTANCE.getCacheControl()));
            return (header.contains(CacheControl.INSTANCE.getONLY_IF_CACHED$ktor_client_core()) && (proceedWithMissingCache$ktor_client_core = HttpCache.Companion.proceedWithMissingCache$ktor_client_core(pipelineContext, scope, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? proceedWithMissingCache$ktor_client_core : Unit.INSTANCE;
        }
        HttpClientCall cachedCall = cache.produceResponse$ktor_client_core().getCall();
        ValidateStatus validateStatus = HttpCacheEntryKt.shouldValidate(cache.getExpires(), cache.getResponse().getHeaders(), (HttpRequestBuilder) pipelineContext.getContext());
        if (validateStatus == ValidateStatus.ShouldNotValidate) {
            Object proceedWithCache$ktor_client_core = HttpCache.Companion.proceedWithCache$ktor_client_core(pipelineContext, scope, cachedCall, continuation);
            return proceedWithCache$ktor_client_core == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWithCache$ktor_client_core : Unit.INSTANCE;
        } else if (validateStatus == ValidateStatus.ShouldWarn) {
            Object proceedWithWarning = proceedWithWarning(pipelineContext, cachedCall, scope, continuation);
            return proceedWithWarning == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWithWarning : Unit.INSTANCE;
        } else {
            String etag = cache.getResponseHeaders$ktor_client_core().get(HttpHeaders.INSTANCE.getETag());
            if (etag != null) {
                UtilsKt.header((HttpMessageBuilder) pipelineContext.getContext(), HttpHeaders.INSTANCE.getIfNoneMatch(), etag);
            }
            String it = cache.getResponseHeaders$ktor_client_core().get(HttpHeaders.INSTANCE.getLastModified());
            if (it != null) {
                UtilsKt.header((HttpMessageBuilder) pipelineContext.getContext(), HttpHeaders.INSTANCE.getIfModifiedSince(), it);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object interceptReceiveLegacy(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse response, HttpCache plugin, HttpClient scope, Continuation<? super Unit> continuation) {
        HttpCacheLegacyKt$interceptReceiveLegacy$1 httpCacheLegacyKt$interceptReceiveLegacy$1;
        Object cacheResponse;
        HttpResponse reusableResponse;
        if (continuation instanceof HttpCacheLegacyKt$interceptReceiveLegacy$1) {
            httpCacheLegacyKt$interceptReceiveLegacy$1 = (HttpCacheLegacyKt$interceptReceiveLegacy$1) continuation;
            if ((httpCacheLegacyKt$interceptReceiveLegacy$1.label & Integer.MIN_VALUE) != 0) {
                httpCacheLegacyKt$interceptReceiveLegacy$1.label -= Integer.MIN_VALUE;
                Object $result = httpCacheLegacyKt$interceptReceiveLegacy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCacheLegacyKt$interceptReceiveLegacy$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!HttpStatusCodeKt.isSuccess(response.getStatus())) {
                            if (Intrinsics.areEqual(response.getStatus(), HttpStatusCode.Companion.getNotModified())) {
                                HttpResponse responseFromCache = findAndRefresh(plugin, response.getCall().getRequest(), response);
                                if (responseFromCache == null) {
                                    throw new InvalidCacheStateException(response.getCall().getRequest().getUrl());
                                }
                                scope.getMonitor().raise(HttpCache.Companion.getHttpResponseFromCache(), responseFromCache);
                                httpCacheLegacyKt$interceptReceiveLegacy$1.label = 3;
                                if (pipelineContext.proceedWith(responseFromCache, httpCacheLegacyKt$interceptReceiveLegacy$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        httpCacheLegacyKt$interceptReceiveLegacy$1.L$0 = pipelineContext;
                        httpCacheLegacyKt$interceptReceiveLegacy$1.label = 1;
                        cacheResponse = cacheResponse(plugin, response, httpCacheLegacyKt$interceptReceiveLegacy$1);
                        if (cacheResponse == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        reusableResponse = (HttpResponse) cacheResponse;
                        httpCacheLegacyKt$interceptReceiveLegacy$1.L$0 = null;
                        httpCacheLegacyKt$interceptReceiveLegacy$1.label = 2;
                        if (pipelineContext.proceedWith(reusableResponse, httpCacheLegacyKt$interceptReceiveLegacy$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        pipelineContext = (PipelineContext) httpCacheLegacyKt$interceptReceiveLegacy$1.L$0;
                        ResultKt.throwOnFailure($result);
                        cacheResponse = $result;
                        reusableResponse = (HttpResponse) cacheResponse;
                        httpCacheLegacyKt$interceptReceiveLegacy$1.L$0 = null;
                        httpCacheLegacyKt$interceptReceiveLegacy$1.label = 2;
                        if (pipelineContext.proceedWith(reusableResponse, httpCacheLegacyKt$interceptReceiveLegacy$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        httpCacheLegacyKt$interceptReceiveLegacy$1 = new HttpCacheLegacyKt$interceptReceiveLegacy$1(continuation);
        Object $result2 = httpCacheLegacyKt$interceptReceiveLegacy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCacheLegacyKt$interceptReceiveLegacy$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object proceedWithWarning(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClientCall cachedCall, HttpClient scope, Continuation<? super Unit> continuation) {
        HttpRequestData request = ((HttpRequestBuilder) pipelineContext.getContext()).build();
        HttpStatusCode status = cachedCall.getResponse().getStatus();
        GMTDate requestTime = cachedCall.getResponse().getRequestTime();
        Headers.Companion companion = Headers.Companion;
        HeadersBuilder $this$proceedWithWarning_u24lambda_u242 = new HeadersBuilder(0, 1, null);
        $this$proceedWithWarning_u24lambda_u242.appendAll(cachedCall.getResponse().getHeaders());
        $this$proceedWithWarning_u24lambda_u242.append(HttpHeaders.INSTANCE.getWarning(), "110");
        Unit unit = Unit.INSTANCE;
        HttpResponseData response = new HttpResponseData(status, requestTime, $this$proceedWithWarning_u24lambda_u242.m3526build(), cachedCall.getResponse().getVersion(), cachedCall.getResponse().getRawContent(), cachedCall.getResponse().getCoroutineContext());
        HttpClientCall call = new HttpClientCall(scope, request, response);
        pipelineContext.finish();
        scope.getMonitor().raise(HttpCache.Companion.getHttpResponseFromCache(), call.getResponse());
        Object proceedWith = pipelineContext.proceedWith(call, continuation);
        return proceedWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWith : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object cacheResponse(HttpCache $this$cacheResponse, HttpResponse response, Continuation<? super HttpResponse> continuation) {
        HttpCacheLegacyKt$cacheResponse$1 httpCacheLegacyKt$cacheResponse$1;
        Object store;
        if (continuation instanceof HttpCacheLegacyKt$cacheResponse$1) {
            httpCacheLegacyKt$cacheResponse$1 = (HttpCacheLegacyKt$cacheResponse$1) continuation;
            if ((httpCacheLegacyKt$cacheResponse$1.label & Integer.MIN_VALUE) != 0) {
                httpCacheLegacyKt$cacheResponse$1.label -= Integer.MIN_VALUE;
                Object $result = httpCacheLegacyKt$cacheResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCacheLegacyKt$cacheResponse$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HttpRequest request = response.getCall().getRequest();
                        List responseCacheControl = HttpMessagePropertiesKt.cacheControl(response);
                        List requestCacheControl = HttpMessagePropertiesKt.cacheControl(request);
                        HttpCacheStorage storage = responseCacheControl.contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core()) ? $this$cacheResponse.getPrivateStorage$ktor_client_core() : $this$cacheResponse.getPublicStorage$ktor_client_core();
                        if (responseCacheControl.contains(CacheControl.INSTANCE.getNO_STORE$ktor_client_core()) || requestCacheControl.contains(CacheControl.INSTANCE.getNO_STORE$ktor_client_core())) {
                            return response;
                        }
                        Url url = request.getUrl();
                        boolean isSharedClient$ktor_client_core = $this$cacheResponse.isSharedClient$ktor_client_core();
                        httpCacheLegacyKt$cacheResponse$1.label = 1;
                        store = HttpCacheStorageKt.store(storage, url, response, isSharedClient$ktor_client_core, (Continuation<? super HttpCacheEntry>) httpCacheLegacyKt$cacheResponse$1);
                        if (store == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        store = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                HttpCacheEntry cacheEntry = (HttpCacheEntry) store;
                return cacheEntry.produceResponse$ktor_client_core();
            }
        }
        httpCacheLegacyKt$cacheResponse$1 = new HttpCacheLegacyKt$cacheResponse$1(continuation);
        Object $result2 = httpCacheLegacyKt$cacheResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCacheLegacyKt$cacheResponse$1.label) {
        }
        HttpCacheEntry cacheEntry2 = (HttpCacheEntry) store;
        return cacheEntry2.produceResponse$ktor_client_core();
    }

    private static final HttpResponse findAndRefresh(HttpCache $this$findAndRefresh, HttpRequest request, HttpResponse response) {
        Url url = response.getCall().getRequest().getUrl();
        List cacheControl = HttpMessagePropertiesKt.cacheControl(response);
        HttpCacheStorage storage = cacheControl.contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core()) ? $this$findAndRefresh.getPrivateStorage$ktor_client_core() : $this$findAndRefresh.getPublicStorage$ktor_client_core();
        Map varyKeysFrom304 = HttpCacheEntryKt.varyKeys(response);
        HttpCacheEntry cache = findResponse($this$findAndRefresh, storage, varyKeysFrom304, url, request);
        if (cache == null) {
            return null;
        }
        Map newVaryKeys = varyKeysFrom304.isEmpty() ? cache.getVaryKeys() : varyKeysFrom304;
        storage.store(url, new HttpCacheEntry(HttpCacheEntryKt.cacheExpires$default(response, $this$findAndRefresh.isSharedClient$ktor_client_core(), null, 2, null), newVaryKeys, cache.getResponse(), cache.getBody()));
        return cache.produceResponse$ktor_client_core();
    }

    private static final HttpCacheEntry findResponse(HttpCache $this$findResponse, HttpCacheStorage storage, Map<String, String> map, Url url, HttpRequest request) {
        Object element$iv;
        boolean z;
        if (!map.isEmpty()) {
            return storage.find(url, map);
        }
        Function1 requestHeaders = HttpCacheKt.mergedHeadersLookup(request.getContent(), new HttpCacheLegacyKt$findResponse$requestHeaders$1(request.getHeaders()), new HttpCacheLegacyKt$findResponse$requestHeaders$2(request.getHeaders()));
        Iterable $this$sortedByDescending$iv = storage.findByUrl(url);
        Iterable $this$firstOrNull$iv = CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: io.ktor.client.plugins.cache.HttpCacheLegacyKt$findResponse$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                HttpCacheEntry it = (HttpCacheEntry) t2;
                HttpCacheEntry it2 = (HttpCacheEntry) t;
                return ComparisonsKt.compareValues((Comparable) it.getResponse().getResponseTime(), (Comparable) it2.getResponse().getResponseTime());
            }
        });
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                HttpCacheEntry cachedResponse = (HttpCacheEntry) element$iv;
                Map $this$all$iv = cachedResponse.getVaryKeys();
                if (!$this$all$iv.isEmpty()) {
                    Iterator<Map.Entry<String, String>> it2 = $this$all$iv.entrySet().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Map.Entry element$iv2 = it2.next();
                            String key = element$iv2.getKey();
                            String value = element$iv2.getValue();
                            if (!Intrinsics.areEqual(requestHeaders.invoke(key), value)) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                } else {
                    z = true;
                }
                if (z) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        return (HttpCacheEntry) element$iv;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final HttpCacheEntry findResponse(HttpCache $this$findResponse, HttpRequestBuilder context, OutgoingContent content) {
        Url url = URLUtilsKt.Url(context.getUrl());
        Function1 lookup = HttpCacheKt.mergedHeadersLookup(content, new HttpCacheLegacyKt$findResponse$lookup$1(context.getHeaders()), new HttpCacheLegacyKt$findResponse$lookup$2(context.getHeaders()));
        Set<HttpCacheEntry> cachedResponses = SetsKt.plus($this$findResponse.getPrivateStorage$ktor_client_core().findByUrl(url), $this$findResponse.getPublicStorage$ktor_client_core().findByUrl(url));
        for (HttpCacheEntry item : cachedResponses) {
            Map varyKeys = item.getVaryKeys();
            if (!varyKeys.isEmpty()) {
                boolean z = true;
                if (!varyKeys.isEmpty()) {
                    Iterator<Map.Entry<String, String>> it = varyKeys.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Map.Entry element$iv = it.next();
                            String key = element$iv.getKey();
                            String value = element$iv.getValue();
                            if (!Intrinsics.areEqual(lookup.invoke(key), value)) {
                                z = false;
                                continue;
                                break;
                            }
                        }
                    }
                }
                if (z) {
                }
            }
            return item;
        }
        return null;
    }
}