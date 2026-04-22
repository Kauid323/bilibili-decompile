package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.plugins.api.SetupRequest;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.ContentDisposition;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.slf4j.Logger;

/* compiled from: HttpCallValidator.kt */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a.\u0010\u000b\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00052\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\u000b\u0010\f\"\u0018\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"(\u0010\u001c\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\" \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!*`\u0010)\"-\b\u0001\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"2-\b\u0001\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"*`\u0010,\"-\b\u0001\u0012\u0013\u0012\u00110*¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"2-\b\u0001\u0012\u0013\u0012\u00110*¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"*\u008a\u0001\u00100\"B\b\u0001\u0012\u0013\u0012\u00110*¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110.¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0-2B\b\u0001\u0012\u0013\u0012\u00110*¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110.¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0-¨\u00061"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "builder", "io/ktor/client/plugins/HttpCallValidatorKt$HttpRequest$1", "HttpRequest", "(Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/plugins/HttpCallValidatorKt$HttpRequest$1;", "Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpCallValidatorConfig;", "", "Lkotlin/ExtensionFunctionType;", "block", "HttpResponseValidator", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpCallValidator", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpCallValidator", "()Lio/ktor/client/plugins/api/ClientPlugin;", "", "value", "getExpectSuccess", "(Lio/ktor/client/request/HttpRequestBuilder;)Z", "setExpectSuccess", "(Lio/ktor/client/request/HttpRequestBuilder;Z)V", "expectSuccess", "Lio/ktor/util/AttributeKey;", "ExpectSuccessAttributeKey", "Lio/ktor/util/AttributeKey;", "getExpectSuccessAttributeKey", "()Lio/ktor/util/AttributeKey;", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, "response", "Lkotlin/coroutines/Continuation;", "", "ResponseValidator", "", "cause", "CallExceptionHandler", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequest;", SocialConstants.TYPE_REQUEST, "CallRequestExceptionHandler", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpCallValidatorKt {
    private static final AttributeKey<Boolean> ExpectSuccessAttributeKey;
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpCallValidator");
    private static final ClientPlugin<HttpCallValidatorConfig> HttpCallValidator = CreatePluginUtilsKt.createClientPlugin("HttpResponseValidator", HttpCallValidatorKt$HttpCallValidator$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.HttpCallValidatorKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit HttpCallValidator$lambda$2;
            HttpCallValidator$lambda$2 = HttpCallValidatorKt.HttpCallValidator$lambda$2((ClientPluginBuilder) obj);
            return HttpCallValidator$lambda$2;
        }
    });

    static {
        KType kType;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            kType = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable th) {
            kType = null;
        }
        ExpectSuccessAttributeKey = new AttributeKey<>("ExpectSuccessAttributeKey", new TypeInfo(orCreateKotlinClass, kType));
    }

    public static final ClientPlugin<HttpCallValidatorConfig> getHttpCallValidator() {
        return HttpCallValidator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpCallValidator$lambda$2(ClientPluginBuilder $this$createClientPlugin) {
        Intrinsics.checkNotNullParameter($this$createClientPlugin, "$this$createClientPlugin");
        List responseValidators = CollectionsKt.reversed(((HttpCallValidatorConfig) $this$createClientPlugin.getPluginConfig()).getResponseValidators$ktor_client_core());
        List callExceptionHandlers = CollectionsKt.reversed(((HttpCallValidatorConfig) $this$createClientPlugin.getPluginConfig()).getResponseExceptionHandlers$ktor_client_core());
        boolean expectSuccess = ((HttpCallValidatorConfig) $this$createClientPlugin.getPluginConfig()).getExpectSuccess$ktor_client_core();
        $this$createClientPlugin.on(SetupRequest.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$1(expectSuccess, null));
        $this$createClientPlugin.on(Send.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$2(responseValidators, null));
        $this$createClientPlugin.on(RequestError.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$3(callExceptionHandlers, null));
        $this$createClientPlugin.on(ReceiveError.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$4(callExceptionHandlers, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object HttpCallValidator$lambda$2$validateResponse(List<? extends Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object>> list, HttpResponse response, Continuation<? super Unit> continuation) {
        HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1 httpCallValidatorKt$HttpCallValidator$2$validateResponse$1;
        Iterator it;
        HttpResponse response2;
        if (continuation instanceof HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1) {
            httpCallValidatorKt$HttpCallValidator$2$validateResponse$1 = (HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1) continuation;
            if ((httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.label & Integer.MIN_VALUE) != 0) {
                httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.label -= Integer.MIN_VALUE;
                Object $result = httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LOGGER.trace("Validating response for request " + response.getCall().getRequest().getUrl());
                        List<? extends Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object>> $this$forEach$iv = list;
                        it = $this$forEach$iv.iterator();
                        response2 = response;
                        break;
                    case 1:
                        it = (Iterator) httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$1;
                        response2 = (HttpResponse) httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (it.hasNext()) {
                    Object element$iv = it.next();
                    Function2 it2 = (Function2) element$iv;
                    httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$0 = response2;
                    httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.L$1 = it;
                    httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.label = 1;
                    if (it2.invoke(response2, httpCallValidatorKt$HttpCallValidator$2$validateResponse$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        httpCallValidatorKt$HttpCallValidator$2$validateResponse$1 = new HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1(continuation);
        Object $result2 = httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCallValidatorKt$HttpCallValidator$2$validateResponse$1.label) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object HttpCallValidator$lambda$2$processException(List<? extends HandlerWrapper> list, Throwable cause, HttpRequest request, Continuation<? super Unit> continuation) {
        HttpCallValidatorKt$HttpCallValidator$2$processException$1 httpCallValidatorKt$HttpCallValidator$2$processException$1;
        HttpRequest request2;
        Iterator it;
        Throwable cause2;
        if (continuation instanceof HttpCallValidatorKt$HttpCallValidator$2$processException$1) {
            httpCallValidatorKt$HttpCallValidator$2$processException$1 = (HttpCallValidatorKt$HttpCallValidator$2$processException$1) continuation;
            if ((httpCallValidatorKt$HttpCallValidator$2$processException$1.label & Integer.MIN_VALUE) != 0) {
                httpCallValidatorKt$HttpCallValidator$2$processException$1.label -= Integer.MIN_VALUE;
                Object $result = httpCallValidatorKt$HttpCallValidator$2$processException$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpCallValidatorKt$HttpCallValidator$2$processException$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LOGGER.trace("Processing exception " + cause + " for request " + request.getUrl());
                        List<? extends HandlerWrapper> $this$forEach$iv = list;
                        request2 = request;
                        it = $this$forEach$iv.iterator();
                        cause2 = cause;
                        break;
                    case 1:
                        it = (Iterator) httpCallValidatorKt$HttpCallValidator$2$processException$1.L$2;
                        request2 = (HttpRequest) httpCallValidatorKt$HttpCallValidator$2$processException$1.L$1;
                        cause2 = (Throwable) httpCallValidatorKt$HttpCallValidator$2$processException$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    case 2:
                        it = (Iterator) httpCallValidatorKt$HttpCallValidator$2$processException$1.L$2;
                        request2 = (HttpRequest) httpCallValidatorKt$HttpCallValidator$2$processException$1.L$1;
                        cause2 = (Throwable) httpCallValidatorKt$HttpCallValidator$2$processException$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (it.hasNext()) {
                    Object element$iv = it.next();
                    HandlerWrapper it2 = (HandlerWrapper) element$iv;
                    if (it2 instanceof ExceptionHandlerWrapper) {
                        Function2<Throwable, Continuation<? super Unit>, Object> handler = ((ExceptionHandlerWrapper) it2).getHandler();
                        httpCallValidatorKt$HttpCallValidator$2$processException$1.L$0 = cause2;
                        httpCallValidatorKt$HttpCallValidator$2$processException$1.L$1 = request2;
                        httpCallValidatorKt$HttpCallValidator$2$processException$1.L$2 = it;
                        httpCallValidatorKt$HttpCallValidator$2$processException$1.label = 1;
                        if (handler.invoke(cause2, httpCallValidatorKt$HttpCallValidator$2$processException$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (!(it2 instanceof RequestExceptionHandlerWrapper)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        Function3<Throwable, HttpRequest, Continuation<? super Unit>, Object> handler2 = ((RequestExceptionHandlerWrapper) it2).getHandler();
                        httpCallValidatorKt$HttpCallValidator$2$processException$1.L$0 = cause2;
                        httpCallValidatorKt$HttpCallValidator$2$processException$1.L$1 = request2;
                        httpCallValidatorKt$HttpCallValidator$2$processException$1.L$2 = it;
                        httpCallValidatorKt$HttpCallValidator$2$processException$1.label = 2;
                        if (handler2.invoke(cause2, request2, httpCallValidatorKt$HttpCallValidator$2$processException$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }
        httpCallValidatorKt$HttpCallValidator$2$processException$1 = new HttpCallValidatorKt$HttpCallValidator$2$processException$1(continuation);
        Object $result2 = httpCallValidatorKt$HttpCallValidator$2$processException$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpCallValidatorKt$HttpCallValidator$2$processException$1.label) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [io.ktor.client.plugins.HttpCallValidatorKt$HttpRequest$1] */
    public static final HttpCallValidatorKt$HttpRequest$1 HttpRequest(final HttpRequestBuilder builder) {
        return new HttpRequest() { // from class: io.ktor.client.plugins.HttpCallValidatorKt$HttpRequest$1
            private final Attributes attributes;
            private final Headers headers;
            private final HttpMethod method;
            private final Url url;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.method = HttpRequestBuilder.this.getMethod();
                this.url = HttpRequestBuilder.this.getUrl().build();
                this.attributes = HttpRequestBuilder.this.getAttributes();
                this.headers = HttpRequestBuilder.this.getHeaders().m3526build();
            }

            @Override // io.ktor.client.request.HttpRequest
            public CoroutineContext getCoroutineContext() {
                return HttpRequest.DefaultImpls.getCoroutineContext(this);
            }

            @Override // io.ktor.client.request.HttpRequest
            public HttpClientCall getCall() {
                throw new IllegalStateException("Call is not initialized".toString());
            }

            @Override // io.ktor.client.request.HttpRequest
            public HttpMethod getMethod() {
                return this.method;
            }

            @Override // io.ktor.client.request.HttpRequest
            public Url getUrl() {
                return this.url;
            }

            @Override // io.ktor.client.request.HttpRequest
            public Attributes getAttributes() {
                return this.attributes;
            }

            @Override // io.ktor.http.HttpMessage
            public Headers getHeaders() {
                return this.headers;
            }

            @Override // io.ktor.client.request.HttpRequest
            public OutgoingContent getContent() {
                Object body = HttpRequestBuilder.this.getBody();
                OutgoingContent outgoingContent = body instanceof OutgoingContent ? (OutgoingContent) body : null;
                if (outgoingContent != null) {
                    return outgoingContent;
                }
                throw new IllegalStateException(("Content was not transformed to OutgoingContent yet. Current body is " + HttpRequestBuilder.this.getBody()).toString());
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void HttpResponseValidator(HttpClientConfig<?> httpClientConfig, Function1<? super HttpCallValidatorConfig, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        httpClientConfig.install(HttpCallValidator, function1);
    }

    public static final boolean getExpectSuccess(HttpRequestBuilder $this$expectSuccess) {
        Intrinsics.checkNotNullParameter($this$expectSuccess, "<this>");
        Boolean bool = (Boolean) $this$expectSuccess.getAttributes().getOrNull(ExpectSuccessAttributeKey);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final void setExpectSuccess(HttpRequestBuilder $this$expectSuccess, boolean value) {
        Intrinsics.checkNotNullParameter($this$expectSuccess, "<this>");
        $this$expectSuccess.getAttributes().put(ExpectSuccessAttributeKey, Boolean.valueOf(value));
    }

    public static final AttributeKey<Boolean> getExpectSuccessAttributeKey() {
        return ExpectSuccessAttributeKey;
    }
}