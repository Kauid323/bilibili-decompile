package io.ktor.client.plugins.cache.storage;

import com.tencent.open.SocialConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.client.plugins.cache.HttpCacheEntryKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Url;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.InternalAPI;
import io.ktor.utils.io.core.StringsKt;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;

/* compiled from: HttpCacheStorage.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0080@¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\b\u001a\u00020\f*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0087@¢\u0006\u0004\b\b\u0010\r\u001a:\u0010\b\u001a\u00020\f*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\b\u0010\u0011\u001a+\u0010\u0018\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/statement/HttpResponse;", "value", "", "isShared", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "store", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/http/Url;Lio/ktor/client/statement/HttpResponse;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "response", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/statement/HttpResponse;Ljava/util/Map;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/HttpClient;", "client", "Lio/ktor/client/request/HttpRequest;", SocialConstants.TYPE_REQUEST, "Lkotlin/coroutines/CoroutineContext;", "responseContext", "createResponse", "(Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequest;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/client/statement/HttpResponse;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpCacheStorageKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object store(HttpCacheStorage $this$store, Url url, HttpResponse value, boolean isShared, Continuation<? super HttpCacheEntry> continuation) {
        HttpCacheStorageKt$store$1 httpCacheStorageKt$store$1;
        Object HttpCacheEntry;
        HttpCacheStorage $this$store2;
        Url url2;
        if (continuation instanceof HttpCacheStorageKt$store$1) {
            httpCacheStorageKt$store$1 = (HttpCacheStorageKt$store$1) continuation;
            if ((httpCacheStorageKt$store$1.label & Integer.MIN_VALUE) != 0) {
                httpCacheStorageKt$store$1.label -= Integer.MIN_VALUE;
                Object $result = httpCacheStorageKt$store$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCacheStorageKt$store$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        boolean isShared2 = isShared;
                        httpCacheStorageKt$store$1.L$0 = $this$store;
                        httpCacheStorageKt$store$1.L$1 = url;
                        httpCacheStorageKt$store$1.label = 1;
                        HttpCacheEntry = HttpCacheEntryKt.HttpCacheEntry(isShared2, value, httpCacheStorageKt$store$1);
                        if (HttpCacheEntry == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$store2 = $this$store;
                        url2 = url;
                        break;
                    case 1:
                        url2 = (Url) httpCacheStorageKt$store$1.L$1;
                        $this$store2 = (HttpCacheStorage) httpCacheStorageKt$store$1.L$0;
                        ResultKt.throwOnFailure($result);
                        HttpCacheEntry = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                HttpCacheEntry result = (HttpCacheEntry) HttpCacheEntry;
                $this$store2.store(url2, result);
                return result;
            }
        }
        httpCacheStorageKt$store$1 = new HttpCacheStorageKt$store$1(continuation);
        Object $result2 = httpCacheStorageKt$store$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCacheStorageKt$store$1.label) {
        }
        HttpCacheEntry result2 = (HttpCacheEntry) HttpCacheEntry;
        $this$store2.store(url2, result2);
        return result2;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use method with `response.varyKeys()` and `isShared` arguments", replaceWith = @ReplaceWith(expression = "store(response, response.varyKeys(), isShared)", imports = {}))
    public static final Object store(CacheStorage $this$store, HttpResponse response, Continuation<? super CachedResponseData> continuation) {
        return store$default($this$store, response, HttpCacheEntryKt.varyKeys(response), false, continuation, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object store(CacheStorage $this$store, HttpResponse httpResponse, Map<String, String> map, boolean z, Continuation<? super CachedResponseData> continuation) {
        HttpCacheStorageKt$store$3 httpCacheStorageKt$store$3;
        Object coroutine_suspended;
        HttpResponse response;
        boolean isShared;
        Url url;
        Object readRemaining;
        Map varyKeys;
        CacheStorage $this$store2;
        CachedResponseData data;
        if (continuation instanceof HttpCacheStorageKt$store$3) {
            httpCacheStorageKt$store$3 = (HttpCacheStorageKt$store$3) continuation;
            if ((httpCacheStorageKt$store$3.label & Integer.MIN_VALUE) != 0) {
                httpCacheStorageKt$store$3.label -= Integer.MIN_VALUE;
                Object $result = httpCacheStorageKt$store$3.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCacheStorageKt$store$3.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        response = httpResponse;
                        isShared = z;
                        url = response.getCall().getRequest().getUrl();
                        ByteReadChannel rawContent = response.getRawContent();
                        httpCacheStorageKt$store$3.L$0 = $this$store;
                        httpCacheStorageKt$store$3.L$1 = response;
                        httpCacheStorageKt$store$3.L$2 = map;
                        httpCacheStorageKt$store$3.L$3 = url;
                        httpCacheStorageKt$store$3.Z$0 = isShared;
                        httpCacheStorageKt$store$3.label = 1;
                        readRemaining = ByteReadChannelOperationsKt.readRemaining(rawContent, httpCacheStorageKt$store$3);
                        if (readRemaining == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        varyKeys = map;
                        $this$store2 = $this$store;
                        break;
                    case 1:
                        isShared = httpCacheStorageKt$store$3.Z$0;
                        url = (Url) httpCacheStorageKt$store$3.L$3;
                        Map varyKeys2 = (Map) httpCacheStorageKt$store$3.L$2;
                        response = (HttpResponse) httpCacheStorageKt$store$3.L$1;
                        ResultKt.throwOnFailure($result);
                        readRemaining = $result;
                        varyKeys = varyKeys2;
                        $this$store2 = (CacheStorage) httpCacheStorageKt$store$3.L$0;
                        break;
                    case 2:
                        CachedResponseData data2 = (CachedResponseData) httpCacheStorageKt$store$3.L$0;
                        ResultKt.throwOnFailure($result);
                        return data2;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byte[] readBytes = StringsKt.readBytes((Source) readRemaining);
                Url url2 = response.getCall().getRequest().getUrl();
                HttpStatusCode status = response.getStatus();
                GMTDate requestTime = response.getRequestTime();
                Headers headers = response.getHeaders();
                data = new CachedResponseData(url2, status, requestTime, response.getResponseTime(), response.getVersion(), HttpCacheEntryKt.cacheExpires$default(response, isShared, null, 2, null), headers, varyKeys, readBytes);
                httpCacheStorageKt$store$3.L$0 = data;
                httpCacheStorageKt$store$3.L$1 = null;
                httpCacheStorageKt$store$3.L$2 = null;
                httpCacheStorageKt$store$3.L$3 = null;
                httpCacheStorageKt$store$3.label = 2;
                if ($this$store2.store(url, data, httpCacheStorageKt$store$3) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return data;
            }
        }
        httpCacheStorageKt$store$3 = new HttpCacheStorageKt$store$3(continuation);
        Object $result2 = httpCacheStorageKt$store$3.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCacheStorageKt$store$3.label) {
        }
        byte[] readBytes2 = StringsKt.readBytes((Source) readRemaining);
        Url url22 = response.getCall().getRequest().getUrl();
        HttpStatusCode status2 = response.getStatus();
        GMTDate requestTime2 = response.getRequestTime();
        Headers headers2 = response.getHeaders();
        data = new CachedResponseData(url22, status2, requestTime2, response.getResponseTime(), response.getVersion(), HttpCacheEntryKt.cacheExpires$default(response, isShared, null, 2, null), headers2, varyKeys, readBytes2);
        httpCacheStorageKt$store$3.L$0 = data;
        httpCacheStorageKt$store$3.L$1 = null;
        httpCacheStorageKt$store$3.L$2 = null;
        httpCacheStorageKt$store$3.L$3 = null;
        httpCacheStorageKt$store$3.label = 2;
        if ($this$store2.store(url, data, httpCacheStorageKt$store$3) != coroutine_suspended) {
        }
    }

    public static /* synthetic */ Object store$default(CacheStorage cacheStorage, HttpResponse httpResponse, Map map, boolean z, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return store(cacheStorage, httpResponse, map, z, continuation);
    }

    public static final HttpResponse createResponse(final CachedResponseData $this$createResponse, HttpClient client, HttpRequest request, final CoroutineContext responseContext) {
        Intrinsics.checkNotNullParameter($this$createResponse, "<this>");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(request, SocialConstants.TYPE_REQUEST);
        Intrinsics.checkNotNullParameter(responseContext, "responseContext");
        return new SavedHttpCall(client, request, new HttpResponse($this$createResponse, responseContext) { // from class: io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$createResponse$response$1
            private final CoroutineContext coroutineContext;
            private final Headers headers;
            private final GMTDate requestTime;
            private final GMTDate responseTime;
            private final HttpStatusCode status;
            private final HttpProtocolVersion version;

            @InternalAPI
            public static /* synthetic */ void getRawContent$annotations() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.status = $this$createResponse.getStatusCode();
                this.version = $this$createResponse.getVersion();
                this.requestTime = $this$createResponse.getRequestTime();
                this.responseTime = $this$createResponse.getResponseTime();
                this.headers = $this$createResponse.getHeaders();
                this.coroutineContext = responseContext;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpClientCall getCall() {
                throw new IllegalStateException("This is a fake response");
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpStatusCode getStatus() {
                return this.status;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpProtocolVersion getVersion() {
                return this.version;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public GMTDate getRequestTime() {
                return this.requestTime;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public GMTDate getResponseTime() {
                return this.responseTime;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public ByteReadChannel getRawContent() {
                throw new IllegalStateException("This is a fake response");
            }

            @Override // io.ktor.http.HttpMessage
            public Headers getHeaders() {
                return this.headers;
            }

            public CoroutineContext getCoroutineContext() {
                return this.coroutineContext;
            }
        }, $this$createResponse.getBody()).getResponse();
    }
}