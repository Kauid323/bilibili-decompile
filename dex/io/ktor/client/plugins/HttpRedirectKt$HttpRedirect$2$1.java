package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpRedirect.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRedirectKt$HttpRedirect$2$1", f = "HttpRedirect.kt", i = {0, 0}, l = {97, 102}, m = "invokeSuspend", n = {"$this$on", SocialConstants.TYPE_REQUEST}, s = {"L$0", "L$1"})
public final class HttpRedirectKt$HttpRedirect$2$1 extends SuspendLambda implements Function3<Send.Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ boolean $allowHttpsDowngrade;
    final /* synthetic */ boolean $checkHttpMethod;
    final /* synthetic */ ClientPluginBuilder<HttpRedirectConfig> $this_createClientPlugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRedirectKt$HttpRedirect$2$1(boolean z, boolean z2, ClientPluginBuilder<HttpRedirectConfig> clientPluginBuilder, Continuation<? super HttpRedirectKt$HttpRedirect$2$1> continuation) {
        super(3, continuation);
        this.$checkHttpMethod = z;
        this.$allowHttpsDowngrade = z2;
        this.$this_createClientPlugin = clientPluginBuilder;
    }

    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpRedirectKt$HttpRedirect$2$1 httpRedirectKt$HttpRedirect$2$1 = new HttpRedirectKt$HttpRedirect$2$1(this.$checkHttpMethod, this.$allowHttpsDowngrade, this.$this_createClientPlugin, continuation);
        httpRedirectKt$HttpRedirect$2$1.L$0 = sender;
        httpRedirectKt$HttpRedirect$2$1.L$1 = httpRequestBuilder;
        return httpRedirectKt$HttpRedirect$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        HttpRequestBuilder request;
        Send.Sender $this$on;
        Object $result2;
        Object HttpRedirect$lambda$2$handleCall;
        Set set;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Send.Sender $this$on2 = (Send.Sender) this.L$0;
                HttpRequestBuilder request2 = (HttpRequestBuilder) this.L$1;
                this.L$0 = $this$on2;
                this.L$1 = request2;
                this.label = 1;
                Object proceed = $this$on2.proceed(request2, (Continuation) this);
                if (proceed != coroutine_suspended) {
                    request = request2;
                    $this$on = $this$on2;
                    $result2 = $result;
                    $result = proceed;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                request = (HttpRequestBuilder) this.L$1;
                $this$on = (Send.Sender) this.L$0;
                $result2 = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        HttpClientCall origin = (HttpClientCall) $result;
        if (this.$checkHttpMethod) {
            set = HttpRedirectKt.ALLOWED_FOR_REDIRECT;
            if (!set.contains(origin.getRequest().getMethod())) {
                return origin;
            }
        }
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        HttpRedirect$lambda$2$handleCall = HttpRedirectKt.HttpRedirect$lambda$2$handleCall($this$on, request, origin, this.$allowHttpsDowngrade, this.$this_createClientPlugin.getClient(), (Continuation) this);
        return HttpRedirect$lambda$2$handleCall == coroutine_suspended ? coroutine_suspended : HttpRedirect$lambda$2$handleCall;
    }
}