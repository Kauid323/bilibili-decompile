package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.CompletableJob;
import org.slf4j.Logger;

/* compiled from: HttpRequestRetry.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\"\u0018\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0006¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a\"\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 \"7\u0010%\u001a%\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\b\u00040\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010 \"7\u0010&\u001a%\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0!¢\u0006\u0002\b\u00040\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010 \"1\u0010)\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030'¢\u0006\u0002\b\u00040\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010 \"1\u0010,\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020+0'¢\u0006\u0002\b\u00040\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010 ¨\u0006-"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpRequestRetryConfig;", "", "Lkotlin/ExtensionFunctionType;", "block", "retry", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/jvm/functions/Function1;)V", "", "", "isTimeoutException", "(Ljava/lang/Throwable;)Z", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/HttpRetryEventData;", "HttpRequestRetryEvent", "Lio/ktor/events/EventDefinition;", "getHttpRequestRetryEvent", "()Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpRequestRetry", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRequestRetry", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRequestRetry$annotations", "()V", "Lio/ktor/util/AttributeKey;", "", "MaxRetriesPerRequestAttributeKey", "Lio/ktor/util/AttributeKey;", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRetryShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "ShouldRetryPerRequestAttributeKey", "ShouldRetryOnExceptionPerRequestAttributeKey", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRetryModifyRequestContext;", "ModifyRequestPerRequestAttributeKey", "Lio/ktor/client/plugins/HttpRetryDelayContext;", "", "RetryDelayPerRequestAttributeKey", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpRequestRetryKt {
    private static final AttributeKey<Integer> MaxRetriesPerRequestAttributeKey;
    private static final AttributeKey<Function2<HttpRetryModifyRequestContext, HttpRequestBuilder, Unit>> ModifyRequestPerRequestAttributeKey;
    private static final AttributeKey<Function2<HttpRetryDelayContext, Integer, Long>> RetryDelayPerRequestAttributeKey;
    private static final AttributeKey<Function3<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean>> ShouldRetryOnExceptionPerRequestAttributeKey;
    private static final AttributeKey<Function3<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean>> ShouldRetryPerRequestAttributeKey;
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRequestRetry");
    private static final EventDefinition<HttpRetryEventData> HttpRequestRetryEvent = new EventDefinition<>();
    private static final ClientPlugin<HttpRequestRetryConfig> HttpRequestRetry = CreatePluginUtilsKt.createClientPlugin("RetryFeature", HttpRequestRetryKt$HttpRequestRetry$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.HttpRequestRetryKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit HttpRequestRetry$lambda$1;
            HttpRequestRetry$lambda$1 = HttpRequestRetryKt.HttpRequestRetry$lambda$1((ClientPluginBuilder) obj);
            return HttpRequestRetry$lambda$1;
        }
    });

    public static /* synthetic */ void getHttpRequestRetry$annotations() {
    }

    static {
        KType kType;
        KType kType2;
        KType kType3;
        KType kType4;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
        KType kType5 = null;
        try {
            kType = Reflection.typeOf(Integer.TYPE);
        } catch (Throwable th) {
            kType = null;
        }
        MaxRetriesPerRequestAttributeKey = new AttributeKey<>("MaxRetriesPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass, kType));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Function3.class);
        try {
            kType2 = Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(HttpRetryShouldRetryContext.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(HttpRequest.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(HttpResponse.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Boolean.TYPE))});
        } catch (Throwable th2) {
            kType2 = null;
        }
        ShouldRetryPerRequestAttributeKey = new AttributeKey<>("ShouldRetryPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass2, kType2));
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Function3.class);
        try {
            kType3 = Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(HttpRetryShouldRetryContext.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(HttpRequestBuilder.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Throwable.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Boolean.TYPE))});
        } catch (Throwable th3) {
            kType3 = null;
        }
        ShouldRetryOnExceptionPerRequestAttributeKey = new AttributeKey<>("ShouldRetryOnExceptionPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass3, kType3));
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Function2.class);
        try {
            kType4 = Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(HttpRetryModifyRequestContext.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(HttpRequestBuilder.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))});
        } catch (Throwable th4) {
            kType4 = null;
        }
        ModifyRequestPerRequestAttributeKey = new AttributeKey<>("ModifyRequestPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass4, kType4));
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Function2.class);
        try {
            kType5 = Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(HttpRetryDelayContext.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Long.TYPE))});
        } catch (Throwable th5) {
        }
        RetryDelayPerRequestAttributeKey = new AttributeKey<>("RetryDelayPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass5, kType5));
    }

    public static final EventDefinition<HttpRetryEventData> getHttpRequestRetryEvent() {
        return HttpRequestRetryEvent;
    }

    public static final ClientPlugin<HttpRequestRetryConfig> getHttpRequestRetry() {
        return HttpRequestRetry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpRequestRetry$lambda$1(ClientPluginBuilder $this$createClientPlugin) {
        Intrinsics.checkNotNullParameter($this$createClientPlugin, "$this$createClientPlugin");
        Function3 shouldRetry = ((HttpRequestRetryConfig) $this$createClientPlugin.getPluginConfig()).getShouldRetry$ktor_client_core();
        Function3 shouldRetryOnException = ((HttpRequestRetryConfig) $this$createClientPlugin.getPluginConfig()).getShouldRetryOnException$ktor_client_core();
        Function2 delayMillis = ((HttpRequestRetryConfig) $this$createClientPlugin.getPluginConfig()).getDelayMillis$ktor_client_core();
        Function2 delay = ((HttpRequestRetryConfig) $this$createClientPlugin.getPluginConfig()).getDelay$ktor_client_core();
        int maxRetries = ((HttpRequestRetryConfig) $this$createClientPlugin.getPluginConfig()).getMaxRetries();
        Function2 modifyRequest = ((HttpRequestRetryConfig) $this$createClientPlugin.getPluginConfig()).getModifyRequest$ktor_client_core();
        $this$createClientPlugin.on(Send.INSTANCE, new HttpRequestRetryKt$HttpRequestRetry$2$1(shouldRetry, shouldRetryOnException, maxRetries, delayMillis, modifyRequest, $this$createClientPlugin, delay, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HttpRequestRetry$lambda$1$shouldRetry(int retryCount, int maxRetries, Function3<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> function3, HttpClientCall call) {
        return retryCount < maxRetries && ((Boolean) function3.invoke(new HttpRetryShouldRetryContext(retryCount + 1), call.getRequest(), call.getResponse())).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HttpRequestRetry$lambda$1$shouldRetryOnException(int retryCount, int maxRetries, Function3<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> function3, HttpRequestBuilder subRequest, Throwable cause) {
        return retryCount < maxRetries && ((Boolean) function3.invoke(new HttpRetryShouldRetryContext(retryCount + 1), subRequest, cause)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpRequestBuilder HttpRequestRetry$lambda$1$prepareRequest(HttpRequestBuilder request) {
        final HttpRequestBuilder subRequest = new HttpRequestBuilder().takeFrom(request);
        request.getExecutionContext().invokeOnCompletion(new Function1() { // from class: io.ktor.client.plugins.HttpRequestRetryKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit HttpRequestRetry$lambda$1$prepareRequest$lambda$0;
                HttpRequestRetry$lambda$1$prepareRequest$lambda$0 = HttpRequestRetryKt.HttpRequestRetry$lambda$1$prepareRequest$lambda$0(HttpRequestBuilder.this, (Throwable) obj);
                return HttpRequestRetry$lambda$1$prepareRequest$lambda$0;
            }
        });
        return subRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpRequestRetry$lambda$1$prepareRequest$lambda$0(HttpRequestBuilder $subRequest, Throwable cause) {
        CompletableJob executionContext = $subRequest.getExecutionContext();
        Intrinsics.checkNotNull(executionContext, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        CompletableJob subRequestJob = executionContext;
        if (cause == null) {
            subRequestJob.complete();
        } else {
            subRequestJob.completeExceptionally(cause);
        }
        return Unit.INSTANCE;
    }

    public static final void retry(HttpRequestBuilder $this$retry, Function1<? super HttpRequestRetryConfig, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$retry, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpRequestRetryConfig configuration = new HttpRequestRetryConfig();
        function1.invoke(configuration);
        $this$retry.getAttributes().put(ShouldRetryPerRequestAttributeKey, configuration.getShouldRetry$ktor_client_core());
        $this$retry.getAttributes().put(ShouldRetryOnExceptionPerRequestAttributeKey, configuration.getShouldRetryOnException$ktor_client_core());
        $this$retry.getAttributes().put(RetryDelayPerRequestAttributeKey, configuration.getDelayMillis$ktor_client_core());
        $this$retry.getAttributes().put(MaxRetriesPerRequestAttributeKey, Integer.valueOf(configuration.getMaxRetries()));
        $this$retry.getAttributes().put(ModifyRequestPerRequestAttributeKey, configuration.getModifyRequest$ktor_client_core());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isTimeoutException(Throwable $this$isTimeoutException) {
        Throwable exception = ExceptionUtilsJvmKt.unwrapCancellationException($this$isTimeoutException);
        return (exception instanceof HttpRequestTimeoutException) || (exception instanceof ConnectTimeoutException) || (exception instanceof SocketTimeoutException);
    }
}