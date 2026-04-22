package io.ktor.client.plugins.sse;

import io.ktor.client.call.HttpClientCall;
import io.ktor.sse.ServerSentEvent;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ClientSSESession.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/sse/ClientSSESession;", "Lio/ktor/client/plugins/sse/SSESession;", "Lio/ktor/client/call/HttpClientCall;", "call", "delegate", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/client/plugins/sse/SSESession;)V", "Lio/ktor/client/call/HttpClientCall;", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlinx/coroutines/flow/Flow;", "Lio/ktor/sse/ServerSentEvent;", "getIncoming", "()Lkotlinx/coroutines/flow/Flow;", "incoming", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClientSSESession implements SSESession {
    private final /* synthetic */ SSESession $$delegate_0;
    private final HttpClientCall call;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // io.ktor.client.plugins.sse.SSESession
    public Flow<ServerSentEvent> getIncoming() {
        return this.$$delegate_0.getIncoming();
    }

    public ClientSSESession(HttpClientCall call, SSESession delegate) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.$$delegate_0 = delegate;
        this.call = call;
    }

    public final HttpClientCall getCall() {
        return this.call;
    }
}