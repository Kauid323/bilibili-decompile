package io.ktor.client.plugins.cache;

import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.DateUtilsKt;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.DateKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: HttpCacheEntry.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\u000e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"", "isShared", "Lio/ktor/client/statement/HttpResponse;", "response", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "HttpCacheEntry", "(ZLio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "(Lio/ktor/client/statement/HttpResponse;)Ljava/util/Map;", "Lkotlin/Function0;", "Lio/ktor/util/date/GMTDate;", "fallback", "cacheExpires", "(Lio/ktor/client/statement/HttpResponse;ZLkotlin/jvm/functions/Function0;)Lio/ktor/util/date/GMTDate;", "Lio/ktor/http/Headers;", "responseHeaders", "Lio/ktor/client/request/HttpRequestBuilder;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/plugins/cache/ValidateStatus;", "shouldValidate", "(Lio/ktor/util/date/GMTDate;Lio/ktor/http/Headers;Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/plugins/cache/ValidateStatus;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpCacheEntryKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object HttpCacheEntry(boolean isShared, HttpResponse response, Continuation<? super HttpCacheEntry> continuation) {
        HttpCacheEntryKt$HttpCacheEntry$1 httpCacheEntryKt$HttpCacheEntry$1;
        Object readRemaining;
        if (continuation instanceof HttpCacheEntryKt$HttpCacheEntry$1) {
            httpCacheEntryKt$HttpCacheEntry$1 = (HttpCacheEntryKt$HttpCacheEntry$1) continuation;
            if ((httpCacheEntryKt$HttpCacheEntry$1.label & Integer.MIN_VALUE) != 0) {
                httpCacheEntryKt$HttpCacheEntry$1.label -= Integer.MIN_VALUE;
                Object $result = httpCacheEntryKt$HttpCacheEntry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCacheEntryKt$HttpCacheEntry$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ByteReadChannel rawContent = response.getRawContent();
                        httpCacheEntryKt$HttpCacheEntry$1.L$0 = response;
                        httpCacheEntryKt$HttpCacheEntry$1.Z$0 = isShared;
                        httpCacheEntryKt$HttpCacheEntry$1.label = 1;
                        readRemaining = ByteReadChannelOperationsKt.readRemaining(rawContent, httpCacheEntryKt$HttpCacheEntry$1);
                        if (readRemaining == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        isShared = httpCacheEntryKt$HttpCacheEntry$1.Z$0;
                        response = (HttpResponse) httpCacheEntryKt$HttpCacheEntry$1.L$0;
                        ResultKt.throwOnFailure($result);
                        readRemaining = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byte[] body = SourcesKt.readByteArray((Source) readRemaining);
                return new HttpCacheEntry(cacheExpires$default(response, isShared, null, 2, null), varyKeys(response), response, body);
            }
        }
        httpCacheEntryKt$HttpCacheEntry$1 = new HttpCacheEntryKt$HttpCacheEntry$1(continuation);
        Object $result2 = httpCacheEntryKt$HttpCacheEntry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCacheEntryKt$HttpCacheEntry$1.label) {
        }
        byte[] body2 = SourcesKt.readByteArray((Source) readRemaining);
        return new HttpCacheEntry(cacheExpires$default(response, isShared, null, 2, null), varyKeys(response), response, body2);
    }

    public static final Map<String, String> varyKeys(HttpResponse $this$varyKeys) {
        Intrinsics.checkNotNullParameter($this$varyKeys, "<this>");
        List validationKeys = HttpMessagePropertiesKt.vary($this$varyKeys);
        if (validationKeys == null) {
            return MapsKt.emptyMap();
        }
        Map result = new LinkedHashMap();
        Headers requestHeaders = $this$varyKeys.getCall().getRequest().getHeaders();
        for (String key : validationKeys) {
            String str = requestHeaders.get(key);
            if (str == null) {
                str = "";
            }
            result.put(key, str);
        }
        return result;
    }

    public static /* synthetic */ GMTDate cacheExpires$default(HttpResponse httpResponse, boolean z, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function0 = new Function0() { // from class: io.ktor.client.plugins.cache.HttpCacheEntryKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    GMTDate cacheExpires$lambda$0;
                    cacheExpires$lambda$0 = HttpCacheEntryKt.cacheExpires$lambda$0();
                    return cacheExpires$lambda$0;
                }
            };
        }
        return cacheExpires(httpResponse, z, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GMTDate cacheExpires$lambda$0() {
        return DateJvmKt.GMTDate$default((Long) null, 1, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r5 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final GMTDate cacheExpires(HttpResponse $this$cacheExpires, boolean isShared, Function0<GMTDate> function0) {
        String str;
        Object element$iv;
        String value;
        List split$default;
        String str2;
        Iterable $this$any$iv;
        Intrinsics.checkNotNullParameter($this$cacheExpires, "<this>");
        Intrinsics.checkNotNullParameter(function0, "fallback");
        Iterable cacheControl = HttpMessagePropertiesKt.cacheControl($this$cacheExpires);
        Long l = null;
        if (isShared) {
            Iterable $this$any$iv2 = cacheControl;
            boolean z = $this$any$iv2 instanceof Collection;
            str = io.ktor.client.utils.CacheControl.S_MAX_AGE;
            if (!z || !((Collection) $this$any$iv2).isEmpty()) {
                Iterator<T> it = $this$any$iv2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        $this$any$iv = null;
                        break;
                    }
                    Object element$iv2 = it.next();
                    HeaderValue it2 = (HeaderValue) element$iv2;
                    if (StringsKt.startsWith$default(it2.getValue(), io.ktor.client.utils.CacheControl.S_MAX_AGE, false, 2, (Object) null)) {
                        $this$any$iv = 1;
                        break;
                    }
                }
            } else {
                $this$any$iv = null;
            }
        }
        str = io.ktor.client.utils.CacheControl.MAX_AGE;
        String maxAgeKey = str;
        Iterable $this$firstOrNull$iv = cacheControl;
        Iterator<T> it3 = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it3.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it3.next();
            HeaderValue it4 = (HeaderValue) element$iv;
            if (StringsKt.startsWith$default(it4.getValue(), maxAgeKey, false, 2, (Object) null)) {
                break;
            }
        }
        HeaderValue headerValue = (HeaderValue) element$iv;
        if (headerValue != null && (value = headerValue.getValue()) != null && (split$default = StringsKt.split$default(value, new String[]{"="}, false, 0, 6, (Object) null)) != null && (str2 = (String) CollectionsKt.getOrNull(split$default, 1)) != null) {
            l = StringsKt.toLongOrNull(str2);
        }
        Long maxAge = l;
        if (maxAge != null) {
            return DateKt.plus($this$cacheExpires.getRequestTime(), maxAge.longValue() * 1000);
        }
        String expires = $this$cacheExpires.getHeaders().get(HttpHeaders.INSTANCE.getExpires());
        if (expires != null) {
            if (Intrinsics.areEqual(expires, "0") || StringsKt.isBlank(expires)) {
                return (GMTDate) function0.invoke();
            }
            try {
                return DateUtilsKt.fromHttpToGmtDate(expires);
            } catch (Throwable th) {
                return (GMTDate) function0.invoke();
            }
        }
        return (GMTDate) function0.invoke();
    }

    public static final ValidateStatus shouldValidate(GMTDate cacheExpires, Headers responseHeaders, HttpRequestBuilder request) {
        int i2;
        Object element$iv;
        Integer requestMaxAge;
        String value;
        Integer intOrNull;
        String value2;
        List split$default;
        String it;
        Intrinsics.checkNotNullParameter(cacheExpires, "cacheExpires");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(request, SocialConstants.TYPE_REQUEST);
        HeadersBuilder requestHeaders = request.getHeaders();
        List all = responseHeaders.getAll(HttpHeaders.INSTANCE.getCacheControl());
        Object obj = null;
        List responseCacheControl = HttpHeaderValueParserKt.parseHeaderValue(all != null ? CollectionsKt.joinToString$default(all, Constants.ACCEPT_TIME_SEPARATOR_SP, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : null);
        List all2 = requestHeaders.getAll(HttpHeaders.INSTANCE.getCacheControl());
        List requestCacheControl = HttpHeaderValueParserKt.parseHeaderValue(all2 != null ? CollectionsKt.joinToString$default(all2, Constants.ACCEPT_TIME_SEPARATOR_SP, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : null);
        if (requestCacheControl.contains(CacheControl.INSTANCE.getNO_CACHE$ktor_client_core())) {
            HttpCacheKt.getLOGGER().trace("\"no-cache\" is set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        List $this$firstOrNull$iv = requestCacheControl;
        Iterator<T> it2 = $this$firstOrNull$iv.iterator();
        while (true) {
            i2 = 0;
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
            HeadersBuilder requestHeaders2 = requestHeaders;
            if (StringsKt.startsWith$default(((HeaderValue) element$iv).getValue(), "max-age=", false, 2, (Object) null)) {
                break;
            }
            requestHeaders = requestHeaders2;
        }
        HeaderValue headerValue = (HeaderValue) element$iv;
        if (headerValue == null || (value2 = headerValue.getValue()) == null || (split$default = StringsKt.split$default(value2, new String[]{"="}, false, 0, 6, (Object) null)) == null || (it = (String) split$default.get(1)) == null) {
            requestMaxAge = null;
        } else {
            Integer intOrNull2 = StringsKt.toIntOrNull(it);
            requestMaxAge = Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : 0);
        }
        if (requestMaxAge != null && requestMaxAge.intValue() == 0) {
            HttpCacheKt.getLOGGER().trace("\"max-age\" is not set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        } else if (responseCacheControl.contains(CacheControl.INSTANCE.getNO_CACHE$ktor_client_core())) {
            HttpCacheKt.getLOGGER().trace("\"no-cache\" is set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        } else {
            long validMillis = cacheExpires.getTimestamp() - DateJvmKt.getTimeMillis();
            if (validMillis > 0) {
                HttpCacheKt.getLOGGER().trace("Cached response is valid for " + request.getUrl() + ", should not validate");
                return ValidateStatus.ShouldNotValidate;
            } else if (responseCacheControl.contains(CacheControl.INSTANCE.getMUST_REVALIDATE$ktor_client_core())) {
                HttpCacheKt.getLOGGER().trace("\"must-revalidate\" is set for " + request.getUrl() + ", should validate cached response");
                return ValidateStatus.ShouldValidate;
            } else {
                List $this$firstOrNull$iv2 = requestCacheControl;
                Iterator<T> it3 = $this$firstOrNull$iv2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object element$iv2 = it3.next();
                    if (StringsKt.startsWith$default(((HeaderValue) element$iv2).getValue(), "max-stale=", false, 2, (Object) null)) {
                        obj = element$iv2;
                        break;
                    }
                }
                HeaderValue headerValue2 = (HeaderValue) obj;
                if (headerValue2 != null && (value = headerValue2.getValue()) != null) {
                    String substring = value.substring(10);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    if (substring != null && (intOrNull = StringsKt.toIntOrNull(substring)) != null) {
                        i2 = intOrNull.intValue();
                    }
                }
                int maxStale = i2;
                long maxStaleMillis = maxStale * 1000;
                if (validMillis + maxStaleMillis > 0) {
                    HttpCacheKt.getLOGGER().trace("Cached response is stale for " + request.getUrl() + " but less than max-stale, should warn");
                    return ValidateStatus.ShouldWarn;
                }
                HttpCacheKt.getLOGGER().trace("Cached response is stale for " + request.getUrl() + ", should validate cached response");
                return ValidateStatus.ShouldValidate;
            }
        }
    }
}