package io.ktor.client.plugins.api;

import com.tencent.open.SocialConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.Sender;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommonHooks.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/Sender;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.api.Send$install$1", f = "CommonHooks.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class Send$install$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ HttpClient $client;
    final /* synthetic */ Function3<Send.Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> $handler;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Send$install$1(Function3<? super Send.Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> function3, HttpClient httpClient, Continuation<? super Send$install$1> continuation) {
        super(3, continuation);
        this.$handler = function3;
        this.$client = httpClient;
    }

    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        Send$install$1 send$install$1 = new Send$install$1(this.$handler, this.$client, continuation);
        send$install$1.L$0 = sender;
        send$install$1.L$1 = httpRequestBuilder;
        return send$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Sender $this$intercept = (Sender) this.L$0;
                HttpRequestBuilder request = (HttpRequestBuilder) this.L$1;
                Function3<Send.Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> function3 = this.$handler;
                Send.Sender sender = new Send.Sender($this$intercept, this.$client.getCoroutineContext());
                this.L$0 = null;
                this.label = 1;
                Object invoke = function3.invoke(sender, request, this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return invoke;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}