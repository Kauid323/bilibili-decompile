package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.ContentDisposition;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.utils.io.KtorDsl;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;

/* compiled from: HttpRequestRetry.kt */
@KtorDsl
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J,\u0010\u000b\u001a\u00020\u00042\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\u000b\u0010\fJ<\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2#\u0010\n\u001a\u001f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0002\b\t¢\u0006\u0004\b\u0014\u0010\u0015J<\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2#\u0010\n\u001a\u001f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0002\b\t¢\u0006\u0004\b\u0017\u0010\u0015J!\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001cJE\u0010$\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00132,\u0010\n\u001a(\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b$\u0010%J+\u0010(\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\b(\u0010)J?\u0010.\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020*2\b\b\u0002\u0010,\u001a\u00020#2\b\b\u0002\u0010-\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020#2\b\b\u0002\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\b.\u0010/J1\u00101\u001a\u00020\u00042\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000400\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b1\u0010\fJ\u0017\u00102\u001a\u00020#2\u0006\u0010'\u001a\u00020#H\u0002¢\u0006\u0004\b2\u00103R?\u00104\u001a\u001f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0002\b\t8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R?\u0010:\u001a\u001f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0002\b\t8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b:\u00105\u001a\u0004\b;\u00107\"\u0004\b<\u00109R9\u0010$\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020#0\u0006¢\u0006\u0002\b\t8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b$\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010\fR9\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010=\u001a\u0004\bA\u0010?\"\u0004\bB\u0010\fR>\u00101\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000400\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u0010=\u001a\u0004\bC\u0010?\"\u0004\bD\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010\u001c¨\u0006I"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetryConfig;", "", "<init>", "()V", "", "noRetry", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRetryModifyRequestContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/ExtensionFunctionType;", "block", "modifyRequest", "(Lkotlin/jvm/functions/Function2;)V", "", "maxRetries", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRetryShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "", "retryIf", "(ILkotlin/jvm/functions/Function3;)V", "", "retryOnExceptionIf", "retryOnTimeout", "retryOnException", "(IZ)V", "retryOnServerErrors", "(I)V", "retryOnExceptionOrServerErrors", "respectRetryAfterHeader", "Lio/ktor/client/plugins/HttpRetryDelayContext;", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, "retry", "", "delayMillis", "(ZLkotlin/jvm/functions/Function2;)V", "millis", "randomizationMs", "constantDelay", "(JJZ)V", "", "base", "baseDelayMs", "maxDelayMs", "exponentialDelay", "(DJJJZ)V", "Lkotlin/coroutines/Continuation;", "delay", "randomMs", "(J)J", "shouldRetry", "Lkotlin/jvm/functions/Function3;", "getShouldRetry$ktor_client_core", "()Lkotlin/jvm/functions/Function3;", "setShouldRetry$ktor_client_core", "(Lkotlin/jvm/functions/Function3;)V", "shouldRetryOnException", "getShouldRetryOnException$ktor_client_core", "setShouldRetryOnException$ktor_client_core", "Lkotlin/jvm/functions/Function2;", "getDelayMillis$ktor_client_core", "()Lkotlin/jvm/functions/Function2;", "setDelayMillis$ktor_client_core", "getModifyRequest$ktor_client_core", "setModifyRequest$ktor_client_core", "getDelay$ktor_client_core", "setDelay$ktor_client_core", "I", "getMaxRetries", "()I", "setMaxRetries", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpRequestRetryConfig {
    public Function2<? super HttpRetryDelayContext, ? super Integer, Long> delayMillis;
    private int maxRetries;
    public Function3<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> shouldRetry;
    public Function3<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> shouldRetryOnException;
    private Function2<? super HttpRetryModifyRequestContext, ? super HttpRequestBuilder, Unit> modifyRequest = new Function2() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2) {
            Unit modifyRequest$lambda$0;
            modifyRequest$lambda$0 = HttpRequestRetryConfig.modifyRequest$lambda$0((HttpRetryModifyRequestContext) obj, (HttpRequestBuilder) obj2);
            return modifyRequest$lambda$0;
        }
    };
    private Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> delay = new HttpRequestRetryConfig$delay$1(null);

    public HttpRequestRetryConfig() {
        retryOnExceptionOrServerErrors(3);
        exponentialDelay$default(this, 0.0d, 0L, 0L, 0L, false, 31, null);
    }

    public final Function3<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> getShouldRetry$ktor_client_core() {
        Function3 function3 = this.shouldRetry;
        if (function3 != null) {
            return function3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shouldRetry");
        return null;
    }

    public final void setShouldRetry$ktor_client_core(Function3<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.shouldRetry = function3;
    }

    public final Function3<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> getShouldRetryOnException$ktor_client_core() {
        Function3 function3 = this.shouldRetryOnException;
        if (function3 != null) {
            return function3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shouldRetryOnException");
        return null;
    }

    public final void setShouldRetryOnException$ktor_client_core(Function3<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.shouldRetryOnException = function3;
    }

    public final Function2<HttpRetryDelayContext, Integer, Long> getDelayMillis$ktor_client_core() {
        Function2 function2 = this.delayMillis;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("delayMillis");
        return null;
    }

    public final void setDelayMillis$ktor_client_core(Function2<? super HttpRetryDelayContext, ? super Integer, Long> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.delayMillis = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit modifyRequest$lambda$0(HttpRetryModifyRequestContext httpRetryModifyRequestContext, HttpRequestBuilder it) {
        Intrinsics.checkNotNullParameter(httpRetryModifyRequestContext, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function2<HttpRetryModifyRequestContext, HttpRequestBuilder, Unit> getModifyRequest$ktor_client_core() {
        return this.modifyRequest;
    }

    public final void setModifyRequest$ktor_client_core(Function2<? super HttpRetryModifyRequestContext, ? super HttpRequestBuilder, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.modifyRequest = function2;
    }

    public final Function2<Long, Continuation<? super Unit>, Object> getDelay$ktor_client_core() {
        return this.delay;
    }

    public final void setDelay$ktor_client_core(Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.delay = function2;
    }

    public final int getMaxRetries() {
        return this.maxRetries;
    }

    public final void setMaxRetries(int i2) {
        this.maxRetries = i2;
    }

    public final void noRetry() {
        this.maxRetries = 0;
        setShouldRetry$ktor_client_core(new Function3() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                boolean noRetry$lambda$1;
                noRetry$lambda$1 = HttpRequestRetryConfig.noRetry$lambda$1((HttpRetryShouldRetryContext) obj, (HttpRequest) obj2, (HttpResponse) obj3);
                return Boolean.valueOf(noRetry$lambda$1);
            }
        });
        setShouldRetryOnException$ktor_client_core(new Function3() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                boolean noRetry$lambda$2;
                noRetry$lambda$2 = HttpRequestRetryConfig.noRetry$lambda$2((HttpRetryShouldRetryContext) obj, (HttpRequestBuilder) obj2, (Throwable) obj3);
                return Boolean.valueOf(noRetry$lambda$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean noRetry$lambda$1(HttpRetryShouldRetryContext httpRetryShouldRetryContext, HttpRequest httpRequest, HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpRetryShouldRetryContext, "<this>");
        Intrinsics.checkNotNullParameter(httpRequest, "<unused var>");
        Intrinsics.checkNotNullParameter(httpResponse, "<unused var>");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean noRetry$lambda$2(HttpRetryShouldRetryContext httpRetryShouldRetryContext, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        Intrinsics.checkNotNullParameter(httpRetryShouldRetryContext, "<this>");
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<unused var>");
        Intrinsics.checkNotNullParameter(th, "<unused var>");
        return false;
    }

    public final void modifyRequest(Function2<? super HttpRetryModifyRequestContext, ? super HttpRequestBuilder, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.modifyRequest = function2;
    }

    public static /* synthetic */ void retryIf$default(HttpRequestRetryConfig httpRequestRetryConfig, int i2, Function3 function3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -1;
        }
        httpRequestRetryConfig.retryIf(i2, function3);
    }

    public final void retryIf(int maxRetries, Function3<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        if (maxRetries != -1) {
            this.maxRetries = maxRetries;
        }
        setShouldRetry$ktor_client_core(function3);
    }

    public static /* synthetic */ void retryOnExceptionIf$default(HttpRequestRetryConfig httpRequestRetryConfig, int i2, Function3 function3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -1;
        }
        httpRequestRetryConfig.retryOnExceptionIf(i2, function3);
    }

    public final void retryOnExceptionIf(int maxRetries, Function3<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        if (maxRetries != -1) {
            this.maxRetries = maxRetries;
        }
        setShouldRetryOnException$ktor_client_core(function3);
    }

    public static /* synthetic */ void retryOnException$default(HttpRequestRetryConfig httpRequestRetryConfig, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -1;
        }
        if ((i3 & 2) != 0) {
            z = false;
        }
        httpRequestRetryConfig.retryOnException(i2, z);
    }

    public final void retryOnException(int maxRetries, final boolean retryOnTimeout) {
        retryOnExceptionIf(maxRetries, new Function3() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                boolean retryOnException$lambda$3;
                retryOnException$lambda$3 = HttpRequestRetryConfig.retryOnException$lambda$3(retryOnTimeout, (HttpRetryShouldRetryContext) obj, (HttpRequestBuilder) obj2, (Throwable) obj3);
                return Boolean.valueOf(retryOnException$lambda$3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retryOnException$lambda$3(boolean $retryOnTimeout, HttpRetryShouldRetryContext $this$retryOnExceptionIf, HttpRequestBuilder httpRequestBuilder, Throwable cause) {
        boolean isTimeoutException;
        Intrinsics.checkNotNullParameter($this$retryOnExceptionIf, "$this$retryOnExceptionIf");
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<unused var>");
        Intrinsics.checkNotNullParameter(cause, "cause");
        isTimeoutException = HttpRequestRetryKt.isTimeoutException(cause);
        return isTimeoutException ? $retryOnTimeout : !(cause instanceof CancellationException);
    }

    public static /* synthetic */ void retryOnServerErrors$default(HttpRequestRetryConfig httpRequestRetryConfig, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -1;
        }
        httpRequestRetryConfig.retryOnServerErrors(i2);
    }

    public final void retryOnServerErrors(int maxRetries) {
        retryIf(maxRetries, new Function3() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                boolean retryOnServerErrors$lambda$5;
                retryOnServerErrors$lambda$5 = HttpRequestRetryConfig.retryOnServerErrors$lambda$5((HttpRetryShouldRetryContext) obj, (HttpRequest) obj2, (HttpResponse) obj3);
                return Boolean.valueOf(retryOnServerErrors$lambda$5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retryOnServerErrors$lambda$5(HttpRetryShouldRetryContext $this$retryIf, HttpRequest httpRequest, HttpResponse response) {
        Intrinsics.checkNotNullParameter($this$retryIf, "$this$retryIf");
        Intrinsics.checkNotNullParameter(httpRequest, "<unused var>");
        Intrinsics.checkNotNullParameter(response, "response");
        int it = response.getStatus().getValue();
        return 500 <= it && it < 600;
    }

    public static /* synthetic */ void retryOnExceptionOrServerErrors$default(HttpRequestRetryConfig httpRequestRetryConfig, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -1;
        }
        httpRequestRetryConfig.retryOnExceptionOrServerErrors(i2);
    }

    public final void retryOnExceptionOrServerErrors(int maxRetries) {
        retryOnServerErrors(maxRetries);
        retryOnException$default(this, maxRetries, false, 2, null);
    }

    public static /* synthetic */ void delayMillis$default(HttpRequestRetryConfig httpRequestRetryConfig, boolean z, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        httpRequestRetryConfig.delayMillis(z, function2);
    }

    public final void delayMillis(final boolean respectRetryAfterHeader, final Function2<? super HttpRetryDelayContext, ? super Integer, Long> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        setDelayMillis$ktor_client_core(new Function2() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                long delayMillis$lambda$6;
                delayMillis$lambda$6 = HttpRequestRetryConfig.delayMillis$lambda$6(respectRetryAfterHeader, function2, (HttpRetryDelayContext) obj, ((Integer) obj2).intValue());
                return Long.valueOf(delayMillis$lambda$6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long delayMillis$lambda$6(boolean $respectRetryAfterHeader, Function2 $block, HttpRetryDelayContext httpRetryDelayContext, int it) {
        Headers headers;
        String str;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(httpRetryDelayContext, "<this>");
        if ($respectRetryAfterHeader) {
            HttpResponse response = httpRetryDelayContext.getResponse();
            Long retryAfter = (response == null || (headers = response.getHeaders()) == null || (str = headers.get(HttpHeaders.INSTANCE.getRetryAfter())) == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) ? null : Long.valueOf(longOrNull.longValue() * 1000);
            return Math.max(((Number) $block.invoke(httpRetryDelayContext, Integer.valueOf(it))).longValue(), retryAfter != null ? retryAfter.longValue() : 0L);
        }
        return ((Number) $block.invoke(httpRetryDelayContext, Integer.valueOf(it))).longValue();
    }

    public static /* synthetic */ void constantDelay$default(HttpRequestRetryConfig httpRequestRetryConfig, long j, long j2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 1000;
        }
        if ((i2 & 2) != 0) {
            j2 = 1000;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        httpRequestRetryConfig.constantDelay(j, j2, z);
    }

    public final void constantDelay(final long millis, final long randomizationMs, boolean respectRetryAfterHeader) {
        if (!(millis > 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(randomizationMs >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        delayMillis(respectRetryAfterHeader, new Function2() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                long constantDelay$lambda$7;
                constantDelay$lambda$7 = HttpRequestRetryConfig.constantDelay$lambda$7(millis, this, randomizationMs, (HttpRetryDelayContext) obj, ((Integer) obj2).intValue());
                return Long.valueOf(constantDelay$lambda$7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constantDelay$lambda$7(long $millis, HttpRequestRetryConfig this$0, long $randomizationMs, HttpRetryDelayContext $this$delayMillis, int it) {
        Intrinsics.checkNotNullParameter($this$delayMillis, "$this$delayMillis");
        return this$0.randomMs($randomizationMs) + $millis;
    }

    public static /* synthetic */ void exponentialDelay$default(HttpRequestRetryConfig httpRequestRetryConfig, double d2, long j, long j2, long j3, boolean z, int i2, Object obj) {
        httpRequestRetryConfig.exponentialDelay((i2 & 1) != 0 ? 2.0d : d2, (i2 & 2) != 0 ? 1000L : j, (i2 & 4) != 0 ? 60000L : j2, (i2 & 8) == 0 ? j3 : 1000L, (i2 & 16) != 0 ? true : z);
    }

    public final void exponentialDelay(final double base, final long baseDelayMs, final long maxDelayMs, final long randomizationMs, boolean respectRetryAfterHeader) {
        if (!(base > 0.0d)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(baseDelayMs > 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(maxDelayMs > 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(randomizationMs >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        delayMillis(respectRetryAfterHeader, new Function2() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                long exponentialDelay$lambda$8;
                exponentialDelay$lambda$8 = HttpRequestRetryConfig.exponentialDelay$lambda$8(base, baseDelayMs, maxDelayMs, this, randomizationMs, (HttpRetryDelayContext) obj, ((Integer) obj2).intValue());
                return Long.valueOf(exponentialDelay$lambda$8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long exponentialDelay$lambda$8(double $base, long $baseDelayMs, long $maxDelayMs, HttpRequestRetryConfig this$0, long $randomizationMs, HttpRetryDelayContext $this$delayMillis, int retry) {
        Intrinsics.checkNotNullParameter($this$delayMillis, "$this$delayMillis");
        long delay = Math.min((long) (Math.pow($base, retry - 1) * $baseDelayMs), $maxDelayMs);
        return this$0.randomMs($randomizationMs) + delay;
    }

    public final void delay(Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.delay = function2;
    }

    private final long randomMs(long randomizationMs) {
        if (randomizationMs == 0) {
            return 0L;
        }
        return Random.Default.nextLong(randomizationMs);
    }
}