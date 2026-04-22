package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.plugins.sse.SSEClientContent;
import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLProtocolKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpTimeout.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeoutKt$HttpTimeout$2$1", f = "HttpTimeout.kt", i = {}, l = {144, 175}, m = "invokeSuspend", n = {}, s = {})
public final class HttpTimeoutKt$HttpTimeout$2$1 extends SuspendLambda implements Function3<Send.Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ Long $connectTimeoutMillis;
    final /* synthetic */ Long $requestTimeoutMillis;
    final /* synthetic */ Long $socketTimeoutMillis;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTimeoutKt$HttpTimeout$2$1(Long l, Long l2, Long l3, Continuation<? super HttpTimeoutKt$HttpTimeout$2$1> continuation) {
        super(3, continuation);
        this.$requestTimeoutMillis = l;
        this.$connectTimeoutMillis = l2;
        this.$socketTimeoutMillis = l3;
    }

    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpTimeoutKt$HttpTimeout$2$1 httpTimeoutKt$HttpTimeout$2$1 = new HttpTimeoutKt$HttpTimeout$2$1(this.$requestTimeoutMillis, this.$connectTimeoutMillis, this.$socketTimeoutMillis, continuation);
        httpTimeoutKt$HttpTimeout$2$1.L$0 = sender;
        httpTimeoutKt$HttpTimeout$2$1.L$1 = httpRequestBuilder;
        return httpTimeoutKt$HttpTimeout$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean HttpTimeout$lambda$1$hasNotNullTimeouts;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Send.Sender $this$on = (Send.Sender) this.L$0;
                HttpRequestBuilder request = (HttpRequestBuilder) this.L$1;
                boolean isWebSocket = URLProtocolKt.isWebsocket(request.getUrl().getProtocol());
                if (isWebSocket || (request.getBody() instanceof ClientUpgradeContent) || (request.getBody() instanceof SSEClientContent)) {
                    this.L$0 = null;
                    this.label = 1;
                    Object proceed = $this$on.proceed(request, (Continuation) this);
                    if (proceed == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return proceed;
                }
                HttpTimeoutConfig configuration = (HttpTimeoutConfig) request.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
                if (configuration == null) {
                    HttpTimeout$lambda$1$hasNotNullTimeouts = HttpTimeoutKt.HttpTimeout$lambda$1$hasNotNullTimeouts(this.$requestTimeoutMillis, this.$connectTimeoutMillis, this.$socketTimeoutMillis);
                    if (HttpTimeout$lambda$1$hasNotNullTimeouts) {
                        configuration = new HttpTimeoutConfig(null, null, null, 7, null);
                        request.setCapability(HttpTimeoutCapability.INSTANCE, configuration);
                    }
                }
                if (configuration != null) {
                    Long l = this.$connectTimeoutMillis;
                    Long l2 = this.$socketTimeoutMillis;
                    Long l3 = this.$requestTimeoutMillis;
                    Long connectTimeoutMillis = configuration.getConnectTimeoutMillis();
                    if (connectTimeoutMillis != null) {
                        l = connectTimeoutMillis;
                    }
                    configuration.setConnectTimeoutMillis(l);
                    Long socketTimeoutMillis = configuration.getSocketTimeoutMillis();
                    if (socketTimeoutMillis != null) {
                        l2 = socketTimeoutMillis;
                    }
                    configuration.setSocketTimeoutMillis(l2);
                    Long requestTimeoutMillis = configuration.getRequestTimeoutMillis();
                    if (requestTimeoutMillis != null) {
                        l3 = requestTimeoutMillis;
                    }
                    configuration.setRequestTimeoutMillis(l3);
                    Long requestTimeout = configuration.getRequestTimeoutMillis();
                    if (requestTimeout != null && requestTimeout.longValue() != Long.MAX_VALUE) {
                        Job executionContext = request.getExecutionContext();
                        final Job killer = BuildersKt.launch$default($this$on, (CoroutineContext) null, (CoroutineStart) null, new HttpTimeoutKt$HttpTimeout$2$1$1$killer$1(requestTimeout, request, executionContext, null), 3, (Object) null);
                        request.getExecutionContext().invokeOnCompletion(new Function1() { // from class: io.ktor.client.plugins.HttpTimeoutKt$HttpTimeout$2$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                Unit invokeSuspend$lambda$1$lambda$0;
                                invokeSuspend$lambda$1$lambda$0 = HttpTimeoutKt$HttpTimeout$2$1.invokeSuspend$lambda$1$lambda$0(killer, (Throwable) obj);
                                return invokeSuspend$lambda$1$lambda$0;
                            }
                        });
                    }
                }
                this.L$0 = null;
                this.label = 2;
                Object proceed2 = $this$on.proceed(request, (Continuation) this);
                return proceed2 == coroutine_suspended ? coroutine_suspended : proceed2;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$lambda$0(Job $killer, Throwable it) {
        Job.DefaultImpls.cancel$default($killer, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }
}