package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientEngine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/request/HttpResponseData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2", f = "HttpClientEngine.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
public final class HttpClientEngine$executeWithinCallContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponseData>, Object> {
    final /* synthetic */ HttpRequestData $requestData;
    int label;
    final /* synthetic */ HttpClientEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientEngine$executeWithinCallContext$2(HttpClientEngine httpClientEngine, HttpRequestData httpRequestData, Continuation<? super HttpClientEngine$executeWithinCallContext$2> continuation) {
        super(2, continuation);
        this.this$0 = httpClientEngine;
        this.$requestData = httpRequestData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HttpClientEngine$executeWithinCallContext$2(this.this$0, this.$requestData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponseData> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean closed;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                closed = HttpClientEngine.DefaultImpls.getClosed(this.this$0);
                if (closed) {
                    throw new ClientEngineClosedException(null, 1, null);
                }
                this.label = 1;
                Object execute = this.this$0.execute(this.$requestData, (Continuation) this);
                if (execute == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return execute;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}