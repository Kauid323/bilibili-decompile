package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLProtocolKt;
import io.ktor.http.UrlKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.slf4j.Logger;

/* compiled from: HttpRedirect.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0018\u0010\n\u001a\u00060\bj\u0002`\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/ktor/http/HttpStatusCode;", "", "isRedirect", "(Lio/ktor/http/HttpStatusCode;)Z", "", "Lio/ktor/http/HttpMethod;", "ALLOWED_FOR_REDIRECT", "Ljava/util/Set;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "HttpResponseRedirectEvent", "Lio/ktor/events/EventDefinition;", "getHttpResponseRedirectEvent", "()Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/HttpRedirectConfig;", "HttpRedirect", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRedirect", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRedirect$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpRedirectKt {
    private static final Set<HttpMethod> ALLOWED_FOR_REDIRECT = SetsKt.setOf(new HttpMethod[]{HttpMethod.Companion.getGet(), HttpMethod.Companion.getHead()});
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRedirect");
    private static final EventDefinition<HttpResponse> HttpResponseRedirectEvent = new EventDefinition<>();
    private static final ClientPlugin<HttpRedirectConfig> HttpRedirect = CreatePluginUtilsKt.createClientPlugin("HttpRedirect", HttpRedirectKt$HttpRedirect$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.HttpRedirectKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit HttpRedirect$lambda$2;
            HttpRedirect$lambda$2 = HttpRedirectKt.HttpRedirect$lambda$2((ClientPluginBuilder) obj);
            return HttpRedirect$lambda$2;
        }
    });

    public static /* synthetic */ void getHttpRedirect$annotations() {
    }

    public static final EventDefinition<HttpResponse> getHttpResponseRedirectEvent() {
        return HttpResponseRedirectEvent;
    }

    public static final ClientPlugin<HttpRedirectConfig> getHttpRedirect() {
        return HttpRedirect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpRedirect$lambda$2(ClientPluginBuilder $this$createClientPlugin) {
        Intrinsics.checkNotNullParameter($this$createClientPlugin, "$this$createClientPlugin");
        boolean checkHttpMethod = ((HttpRedirectConfig) $this$createClientPlugin.getPluginConfig()).getCheckHttpMethod();
        boolean allowHttpsDowngrade = ((HttpRedirectConfig) $this$createClientPlugin.getPluginConfig()).getAllowHttpsDowngrade();
        $this$createClientPlugin.on(Send.INSTANCE, new HttpRedirectKt$HttpRedirect$2$1(checkHttpMethod, allowHttpsDowngrade, $this$createClientPlugin, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x01bd -> B:35:0x01cb). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object HttpRedirect$lambda$2$handleCall(Send.Sender $this$HttpRedirect_u24lambda_u242_u24handleCall, HttpRequestBuilder context, HttpClientCall origin, boolean allowHttpsDowngrade, HttpClient client, Continuation<? super HttpClientCall> continuation) {
        HttpRedirectKt$HttpRedirect$2$handleCall$1 httpRedirectKt$HttpRedirect$2$handleCall$1;
        Object $result;
        Ref.ObjectRef call;
        Send.Sender $this$HttpRedirect_u24lambda_u242_u24handleCall2;
        HttpRequestBuilder context2;
        boolean allowHttpsDowngrade2;
        HttpClient client2;
        Object obj;
        Ref.ObjectRef requestBuilder;
        Object $result2;
        URLProtocol originProtocol;
        String originAuthority;
        Ref.ObjectRef objectRef;
        Continuation $completion = continuation;
        if ($completion instanceof HttpRedirectKt$HttpRedirect$2$handleCall$1) {
            httpRedirectKt$HttpRedirect$2$handleCall$1 = (HttpRedirectKt$HttpRedirect$2$handleCall$1) $completion;
            if ((httpRedirectKt$HttpRedirect$2$handleCall$1.label & Integer.MIN_VALUE) != 0) {
                httpRedirectKt$HttpRedirect$2$handleCall$1.label -= Integer.MIN_VALUE;
                Object $result3 = httpRedirectKt$HttpRedirect$2$handleCall$1.result;
                Object $result4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpRedirectKt$HttpRedirect$2$handleCall$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        if (!isRedirect(origin.getResponse().getStatus())) {
                            return origin;
                        }
                        Ref.ObjectRef call2 = new Ref.ObjectRef();
                        call2.element = origin;
                        Ref.ObjectRef requestBuilder2 = new Ref.ObjectRef();
                        requestBuilder2.element = context;
                        URLProtocol originProtocol2 = origin.getRequest().getUrl().getProtocol();
                        Ref.ObjectRef call3 = call2;
                        Send.Sender $this$HttpRedirect_u24lambda_u242_u24handleCall3 = $this$HttpRedirect_u24lambda_u242_u24handleCall;
                        boolean allowHttpsDowngrade3 = allowHttpsDowngrade;
                        Ref.ObjectRef requestBuilder3 = requestBuilder2;
                        HttpClient client3 = client;
                        String originAuthority2 = UrlKt.getAuthority(origin.getRequest().getUrl());
                        HttpRequestBuilder context3 = context;
                        URLProtocol originProtocol3 = originProtocol2;
                        client3.getMonitor().raise(HttpResponseRedirectEvent, ((HttpClientCall) call3.element).getResponse());
                        String location = ((HttpClientCall) call3.element).getResponse().getHeaders().get(HttpHeaders.INSTANCE.getLocation());
                        LOGGER.trace("Received redirect response to " + location + " for request " + context3.getUrl());
                        HttpRequestBuilder $this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u241 = new HttpRequestBuilder();
                        Continuation $completion2 = $completion;
                        $this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u241.takeFromWithExecutionContext((HttpRequestBuilder) requestBuilder3.element);
                        $this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u241.getUrl().getParameters().clear();
                        if (location == null) {
                            $result = $result3;
                            URLParserKt.takeFrom($this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u241.getUrl(), location);
                        } else {
                            $result = $result3;
                        }
                        if (allowHttpsDowngrade3 && URLProtocolKt.isSecure(originProtocol3) && !URLProtocolKt.isSecure($this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u241.getUrl().getProtocol())) {
                            LOGGER.trace("Can not redirect " + context3.getUrl() + " because of security downgrade");
                            return call3.element;
                        }
                        if (!Intrinsics.areEqual(originAuthority2, URLBuilderKt.getAuthority($this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u241.getUrl()))) {
                            $this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u241.getHeaders().remove(HttpHeaders.INSTANCE.getAuthorization());
                            LOGGER.trace("Removing Authorization header from redirect for " + context3.getUrl());
                        }
                        requestBuilder3.element = $this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u241;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$0 = $this$HttpRedirect_u24lambda_u242_u24handleCall3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$1 = context3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$2 = client3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$3 = call3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$4 = requestBuilder3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$5 = originProtocol3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$6 = originAuthority2;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$7 = call3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.Z$0 = allowHttpsDowngrade3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.label = 1;
                        $result3 = $this$HttpRedirect_u24lambda_u242_u24handleCall3.proceed((HttpRequestBuilder) requestBuilder3.element, httpRedirectKt$HttpRedirect$2$handleCall$1);
                        if ($result3 != $result4) {
                            return $result4;
                        }
                        $completion = $completion2;
                        call = call3;
                        $this$HttpRedirect_u24lambda_u242_u24handleCall2 = $this$HttpRedirect_u24lambda_u242_u24handleCall3;
                        context2 = context3;
                        allowHttpsDowngrade2 = allowHttpsDowngrade3;
                        client2 = client3;
                        obj = $result4;
                        requestBuilder = requestBuilder3;
                        $result2 = $result;
                        originProtocol = originProtocol3;
                        originAuthority = originAuthority2;
                        objectRef = call;
                        objectRef.element = $result3;
                        if (isRedirect(((HttpClientCall) call.element).getResponse().getStatus())) {
                            return call.element;
                        }
                        $result3 = $result2;
                        $result4 = obj;
                        allowHttpsDowngrade3 = allowHttpsDowngrade2;
                        originAuthority2 = originAuthority;
                        originProtocol3 = originProtocol;
                        call3 = call;
                        requestBuilder3 = requestBuilder;
                        client3 = client2;
                        context3 = context2;
                        $this$HttpRedirect_u24lambda_u242_u24handleCall3 = $this$HttpRedirect_u24lambda_u242_u24handleCall2;
                        client3.getMonitor().raise(HttpResponseRedirectEvent, ((HttpClientCall) call3.element).getResponse());
                        String location2 = ((HttpClientCall) call3.element).getResponse().getHeaders().get(HttpHeaders.INSTANCE.getLocation());
                        LOGGER.trace("Received redirect response to " + location2 + " for request " + context3.getUrl());
                        HttpRequestBuilder $this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u2412 = new HttpRequestBuilder();
                        Continuation $completion22 = $completion;
                        $this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u2412.takeFromWithExecutionContext((HttpRequestBuilder) requestBuilder3.element);
                        $this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u2412.getUrl().getParameters().clear();
                        if (location2 == null) {
                        }
                        if (allowHttpsDowngrade3) {
                        }
                        if (!Intrinsics.areEqual(originAuthority2, URLBuilderKt.getAuthority($this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u2412.getUrl()))) {
                        }
                        requestBuilder3.element = $this$HttpRedirect_u24lambda_u242_u24handleCall_u24lambda_u2412;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$0 = $this$HttpRedirect_u24lambda_u242_u24handleCall3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$1 = context3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$2 = client3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$3 = call3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$4 = requestBuilder3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$5 = originProtocol3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$6 = originAuthority2;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.L$7 = call3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.Z$0 = allowHttpsDowngrade3;
                        httpRedirectKt$HttpRedirect$2$handleCall$1.label = 1;
                        $result3 = $this$HttpRedirect_u24lambda_u242_u24handleCall3.proceed((HttpRequestBuilder) requestBuilder3.element, httpRedirectKt$HttpRedirect$2$handleCall$1);
                        if ($result3 != $result4) {
                        }
                    case 1:
                        boolean allowHttpsDowngrade4 = httpRedirectKt$HttpRedirect$2$handleCall$1.Z$0;
                        String originAuthority3 = (String) httpRedirectKt$HttpRedirect$2$handleCall$1.L$6;
                        URLProtocol originProtocol4 = (URLProtocol) httpRedirectKt$HttpRedirect$2$handleCall$1.L$5;
                        call = (Ref.ObjectRef) httpRedirectKt$HttpRedirect$2$handleCall$1.L$3;
                        HttpClient client4 = (HttpClient) httpRedirectKt$HttpRedirect$2$handleCall$1.L$2;
                        Send.Sender $this$HttpRedirect_u24lambda_u242_u24handleCall4 = (Send.Sender) httpRedirectKt$HttpRedirect$2$handleCall$1.L$0;
                        ResultKt.throwOnFailure($result3);
                        $this$HttpRedirect_u24lambda_u242_u24handleCall2 = $this$HttpRedirect_u24lambda_u242_u24handleCall4;
                        context2 = (HttpRequestBuilder) httpRedirectKt$HttpRedirect$2$handleCall$1.L$1;
                        client2 = client4;
                        requestBuilder = (Ref.ObjectRef) httpRedirectKt$HttpRedirect$2$handleCall$1.L$4;
                        originProtocol = originProtocol4;
                        originAuthority = originAuthority3;
                        objectRef = (Ref.ObjectRef) httpRedirectKt$HttpRedirect$2$handleCall$1.L$7;
                        allowHttpsDowngrade2 = allowHttpsDowngrade4;
                        obj = $result4;
                        $result2 = $result3;
                        objectRef.element = $result3;
                        if (isRedirect(((HttpClientCall) call.element).getResponse().getStatus())) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        httpRedirectKt$HttpRedirect$2$handleCall$1 = new HttpRedirectKt$HttpRedirect$2$handleCall$1($completion);
        Object $result32 = httpRedirectKt$HttpRedirect$2$handleCall$1.result;
        Object $result42 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpRedirectKt$HttpRedirect$2$handleCall$1.label) {
        }
    }

    private static final boolean isRedirect(HttpStatusCode $this$isRedirect) {
        int value = $this$isRedirect.getValue();
        if (value == HttpStatusCode.Companion.getMovedPermanently().getValue() || value == HttpStatusCode.Companion.getFound().getValue() || value == HttpStatusCode.Companion.getTemporaryRedirect().getValue() || value == HttpStatusCode.Companion.getPermanentRedirect().getValue() || value == HttpStatusCode.Companion.getSeeOther().getValue()) {
            return true;
        }
        return false;
    }
}