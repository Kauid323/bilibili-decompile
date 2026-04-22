package io.ktor.client.plugins.cookies;

import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.Cookie;
import io.ktor.http.CookieEncoding;
import io.ktor.http.CookieKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.Url;
import io.ktor.util.AttributeKey;
import io.ktor.util.date.GMTDate;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.slf4j.Logger;

/* compiled from: HttpCookies.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00060\u0001j\u0002`\u0002:\u0002('B@\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012-\u0010\u000b\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n0\u0005¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0080@¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0080@¢\u0006\u0004\b\u0018\u0010\u0016J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0080@¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R;\u0010\u000b\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n0\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u001a\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b$\u0010%\u0012\u0004\b&\u0010 ¨\u0006)"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "storage", "", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "defaults", "<init>", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/util/List;)V", "Lio/ktor/http/Url;", "requestUrl", "Lio/ktor/http/Cookie;", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "captureHeaderCookies$ktor_client_core", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captureHeaderCookies", "sendCookiesWith$ktor_client_core", "sendCookiesWith", "Lio/ktor/client/statement/HttpResponse;", "response", "saveCookiesFrom$ktor_client_core", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveCookiesFrom", "close", "()V", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Ljava/util/List;", "Lkotlinx/coroutines/Job;", "initializer", "Lkotlinx/coroutines/Job;", "getInitializer$annotations", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpCookies implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final AttributeKey<HttpCookies> key;
    private final List<Function2<CookiesStorage, Continuation<? super Unit>, Object>> defaults;
    private final Job initializer;
    private final CookiesStorage storage;

    private static /* synthetic */ void getInitializer$annotations() {
    }

    public HttpCookies(CookiesStorage storage, List<? extends Function2<? super CookiesStorage, ? super Continuation<? super Unit>, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(list, "defaults");
        this.storage = storage;
        this.defaults = list;
        this.initializer = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), (CoroutineStart) null, new HttpCookies$initializer$1(this, null), 2, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(Url requestUrl, Continuation<? super List<Cookie>> continuation) {
        HttpCookies$get$1 httpCookies$get$1;
        Object coroutine_suspended;
        HttpCookies httpCookies;
        Object obj;
        if (continuation instanceof HttpCookies$get$1) {
            httpCookies$get$1 = (HttpCookies$get$1) continuation;
            if ((httpCookies$get$1.label & Integer.MIN_VALUE) != 0) {
                httpCookies$get$1.label -= Integer.MIN_VALUE;
                Object $result = httpCookies$get$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCookies$get$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        httpCookies = this;
                        Job job = httpCookies.initializer;
                        httpCookies$get$1.L$0 = httpCookies;
                        httpCookies$get$1.L$1 = requestUrl;
                        httpCookies$get$1.label = 1;
                        if (job.join(httpCookies$get$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        requestUrl = (Url) httpCookies$get$1.L$1;
                        httpCookies = (HttpCookies) httpCookies$get$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CookiesStorage cookiesStorage = httpCookies.storage;
                httpCookies$get$1.L$0 = null;
                httpCookies$get$1.L$1 = null;
                httpCookies$get$1.label = 2;
                obj = cookiesStorage.get(requestUrl, httpCookies$get$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        httpCookies$get$1 = new HttpCookies$get$1(this, continuation);
        Object $result2 = httpCookies$get$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCookies$get$1.label) {
        }
        CookiesStorage cookiesStorage2 = httpCookies.storage;
        httpCookies$get$1.L$0 = null;
        httpCookies$get$1.L$1 = null;
        httpCookies$get$1.label = 2;
        obj = cookiesStorage2.get(requestUrl, httpCookies$get$1);
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object captureHeaderCookies$ktor_client_core(HttpRequestBuilder builder, Continuation<? super Unit> continuation) {
        HttpCookies$captureHeaderCookies$1 httpCookies$captureHeaderCookies$1;
        Url url;
        HttpCookies httpCookies;
        Iterator it;
        Logger logger;
        if (continuation instanceof HttpCookies$captureHeaderCookies$1) {
            httpCookies$captureHeaderCookies$1 = (HttpCookies$captureHeaderCookies$1) continuation;
            if ((httpCookies$captureHeaderCookies$1.label & Integer.MIN_VALUE) != 0) {
                httpCookies$captureHeaderCookies$1.label -= Integer.MIN_VALUE;
                Object $result = httpCookies$captureHeaderCookies$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCookies$captureHeaderCookies$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        url = URLBuilderKt.clone(builder.getUrl()).build();
                        String cookieHeader = builder.getHeaders().get(HttpHeaders.INSTANCE.getCookie());
                        Collection destination$iv$iv = null;
                        if (cookieHeader != null) {
                            logger = HttpCookiesKt.LOGGER;
                            logger.trace("Saving cookie " + cookieHeader + " for " + builder.getUrl());
                            Map $this$map$iv = CookieKt.parseClientCookiesHeader$default(cookieHeader, false, 2, null);
                            Collection destination$iv$iv2 = new ArrayList($this$map$iv.size());
                            for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
                                String name = (String) item$iv$iv.getKey();
                                String encodedValue = (String) item$iv$iv.getValue();
                                destination$iv$iv2.add(new Cookie(name, encodedValue, (CookieEncoding) null, (Integer) null, (GMTDate) null, (String) null, (String) null, false, false, (Map) null, 1020, (DefaultConstructorMarker) null));
                            }
                            destination$iv$iv = (List) destination$iv$iv2;
                        }
                        Collection cookies = destination$iv$iv;
                        if (cookies != null) {
                            Collection $this$forEach$iv = cookies;
                            httpCookies = this;
                            it = $this$forEach$iv.iterator();
                            while (it.hasNext()) {
                                Object element$iv = it.next();
                                Cookie it2 = (Cookie) element$iv;
                                CookiesStorage cookiesStorage = httpCookies.storage;
                                httpCookies$captureHeaderCookies$1.L$0 = httpCookies;
                                httpCookies$captureHeaderCookies$1.L$1 = url;
                                httpCookies$captureHeaderCookies$1.L$2 = it;
                                httpCookies$captureHeaderCookies$1.label = 1;
                                if (cookiesStorage.addCookie(url, it2, httpCookies$captureHeaderCookies$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        it = (Iterator) httpCookies$captureHeaderCookies$1.L$2;
                        url = (Url) httpCookies$captureHeaderCookies$1.L$1;
                        httpCookies = (HttpCookies) httpCookies$captureHeaderCookies$1.L$0;
                        ResultKt.throwOnFailure($result);
                        while (it.hasNext()) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        httpCookies$captureHeaderCookies$1 = new HttpCookies$captureHeaderCookies$1(this, continuation);
        Object $result2 = httpCookies$captureHeaderCookies$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCookies$captureHeaderCookies$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendCookiesWith$ktor_client_core(HttpRequestBuilder builder, Continuation<? super Unit> continuation) {
        HttpCookies$sendCookiesWith$1 httpCookies$sendCookiesWith$1;
        Object obj;
        List cookies;
        String cookieHeader;
        Logger logger;
        if (continuation instanceof HttpCookies$sendCookiesWith$1) {
            httpCookies$sendCookiesWith$1 = (HttpCookies$sendCookiesWith$1) continuation;
            if ((httpCookies$sendCookiesWith$1.label & Integer.MIN_VALUE) != 0) {
                httpCookies$sendCookiesWith$1.label -= Integer.MIN_VALUE;
                Object $result = httpCookies$sendCookiesWith$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCookies$sendCookiesWith$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url build = URLBuilderKt.clone(builder.getUrl()).build();
                        httpCookies$sendCookiesWith$1.L$0 = builder;
                        httpCookies$sendCookiesWith$1.label = 1;
                        obj = get(build, httpCookies$sendCookiesWith$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        builder = (HttpRequestBuilder) httpCookies$sendCookiesWith$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cookies = (List) obj;
                HttpRequestBuilder $this$sendCookiesWith_u24lambda_u244 = builder;
                if (cookies.isEmpty()) {
                    cookieHeader = HttpCookiesKt.renderClientCookies(cookies);
                    $this$sendCookiesWith_u24lambda_u244.getHeaders().set(HttpHeaders.INSTANCE.getCookie(), cookieHeader);
                    logger = HttpCookiesKt.LOGGER;
                    logger.trace("Sending cookie " + cookieHeader + " for " + builder.getUrl());
                } else {
                    $this$sendCookiesWith_u24lambda_u244.getHeaders().remove(HttpHeaders.INSTANCE.getCookie());
                }
                return Unit.INSTANCE;
            }
        }
        httpCookies$sendCookiesWith$1 = new HttpCookies$sendCookiesWith$1(this, continuation);
        Object $result2 = httpCookies$sendCookiesWith$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCookies$sendCookiesWith$1.label) {
        }
        cookies = (List) obj;
        HttpRequestBuilder $this$sendCookiesWith_u24lambda_u2442 = builder;
        if (cookies.isEmpty()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object saveCookiesFrom$ktor_client_core(HttpResponse response, Continuation<? super Unit> continuation) {
        HttpCookies$saveCookiesFrom$1 httpCookies$saveCookiesFrom$1;
        Url url;
        Iterator it;
        HttpCookies httpCookies;
        Logger logger;
        if (continuation instanceof HttpCookies$saveCookiesFrom$1) {
            httpCookies$saveCookiesFrom$1 = (HttpCookies$saveCookiesFrom$1) continuation;
            if ((httpCookies$saveCookiesFrom$1.label & Integer.MIN_VALUE) != 0) {
                httpCookies$saveCookiesFrom$1.label -= Integer.MIN_VALUE;
                Object $result = httpCookies$saveCookiesFrom$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCookies$saveCookiesFrom$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Url url2 = HttpResponseKt.getRequest(response).getUrl();
                        Iterable all = response.getHeaders().getAll(HttpHeaders.INSTANCE.getSetCookie());
                        if (all != null) {
                            Iterable $this$forEach$iv = all;
                            for (Object element$iv : $this$forEach$iv) {
                                String it2 = (String) element$iv;
                                logger = HttpCookiesKt.LOGGER;
                                logger.trace("Received cookie " + it2 + " in response for " + response.getCall().getRequest().getUrl());
                            }
                        }
                        Iterable $this$forEach$iv2 = HttpMessagePropertiesKt.setCookie(response);
                        url = url2;
                        it = $this$forEach$iv2.iterator();
                        httpCookies = this;
                        break;
                    case 1:
                        it = (Iterator) httpCookies$saveCookiesFrom$1.L$2;
                        url = (Url) httpCookies$saveCookiesFrom$1.L$1;
                        httpCookies = (HttpCookies) httpCookies$saveCookiesFrom$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (it.hasNext()) {
                    Object element$iv2 = it.next();
                    Cookie it3 = (Cookie) element$iv2;
                    CookiesStorage cookiesStorage = httpCookies.storage;
                    httpCookies$saveCookiesFrom$1.L$0 = httpCookies;
                    httpCookies$saveCookiesFrom$1.L$1 = url;
                    httpCookies$saveCookiesFrom$1.L$2 = it;
                    httpCookies$saveCookiesFrom$1.label = 1;
                    if (cookiesStorage.addCookie(url, it3, httpCookies$saveCookiesFrom$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        httpCookies$saveCookiesFrom$1 = new HttpCookies$saveCookiesFrom$1(this, continuation);
        Object $result2 = httpCookies$saveCookiesFrom$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCookies$saveCookiesFrom$1.label) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.storage.close();
    }

    /* compiled from: HttpCookies.kt */
    @KtorDsl
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\n\u001a\u00020\u00072'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0002\b\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eR;\u0010\u0011\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0002\b\b0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "", "<init>", "()V", "Lkotlin/Function2;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "default", "(Lkotlin/jvm/functions/Function2;)V", "Lio/ktor/client/plugins/cookies/HttpCookies;", "build$ktor_client_core", "()Lio/ktor/client/plugins/cookies/HttpCookies;", "build", "", "defaults", "Ljava/util/List;", "storage", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "getStorage", "()Lio/ktor/client/plugins/cookies/CookiesStorage;", "setStorage", "(Lio/ktor/client/plugins/cookies/CookiesStorage;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Config {
        private final List<Function2<CookiesStorage, Continuation<? super Unit>, Object>> defaults = new ArrayList();
        private CookiesStorage storage = new AcceptAllCookiesStorage(null, 1, null);

        public final CookiesStorage getStorage() {
            return this.storage;
        }

        public final void setStorage(CookiesStorage cookiesStorage) {
            Intrinsics.checkNotNullParameter(cookiesStorage, "<set-?>");
            this.storage = cookiesStorage;
        }

        /* renamed from: default  reason: not valid java name */
        public final void m3467default(Function2<? super CookiesStorage, ? super Continuation<? super Unit>, ? extends Object> function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            this.defaults.add(function2);
        }

        public final HttpCookies build$ktor_client_core() {
            return new HttpCookies(this.storage, this.defaults);
        }
    }

    /* compiled from: HttpCookies.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "Lio/ktor/client/plugins/cookies/HttpCookies;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/cookies/HttpCookies;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/plugins/cookies/HttpCookies;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion implements HttpClientPlugin<Config, HttpCookies> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpCookies prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return config.build$ktor_client_core();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCookies> getKey() {
            return HttpCookies.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpCookies plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getState(), new HttpCookies$Companion$install$1(plugin, null));
            scope.getSendPipeline().intercept(HttpSendPipeline.Phases.getState(), new HttpCookies$Companion$install$2(plugin, null));
            scope.getReceivePipeline().intercept(HttpReceivePipeline.Phases.getState(), new HttpCookies$Companion$install$3(plugin, null));
        }
    }

    static {
        KType kType = null;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpCookies.class);
        try {
            kType = Reflection.typeOf(HttpCookies.class);
        } catch (Throwable th) {
        }
        key = new AttributeKey<>("HttpCookies", new TypeInfo(orCreateKotlinClass, kType));
    }
}