package io.ktor.client.plugins.websocket;

import io.ktor.client.call.HttpClientCall;
import io.ktor.utils.io.InternalAPI;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketExtension;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: ClientSessions.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096A¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0096A¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0012\u001a\u00020\b2\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fH\u0097\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bH\u0097\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00198\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0%8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001c\u0010.\u001a\u00020)8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u00104\u001a\u00020/8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b058\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00107R\u001c\u0010;\u001a\u00020/8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b9\u00101\"\u0004\b:\u00103R\u001c\u0010>\u001a\u00020/8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b<\u00101\"\u0004\b=\u00103¨\u0006?"}, d2 = {"Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "Lio/ktor/client/plugins/websocket/ClientWebSocketSession;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/client/call/HttpClientCall;", "call", "delegate", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/websocket/DefaultWebSocketSession;)V", "", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/websocket/Frame;", "frame", "send", "(Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "start", "(Ljava/util/List;)V", "terminate", "()V", "Lio/ktor/client/call/HttpClientCall;", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "Lkotlinx/coroutines/Deferred;", "Lio/ktor/websocket/CloseReason;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "closeReason", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getExtensions", "()Ljava/util/List;", "extensions", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "", "getMasking", "()Z", "setMasking", "(Z)V", "masking", "", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "maxFrameSize", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "getPingIntervalMillis", "setPingIntervalMillis", "pingIntervalMillis", "getTimeoutMillis", "setTimeoutMillis", "timeoutMillis", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultClientWebSocketSession implements ClientWebSocketSession, DefaultWebSocketSession {
    private final /* synthetic */ DefaultWebSocketSession $$delegate_0;
    private final HttpClientCall call;

    public Object flush(Continuation<? super Unit> continuation) {
        return this.$$delegate_0.flush(continuation);
    }

    public Deferred<CloseReason> getCloseReason() {
        return this.$$delegate_0.getCloseReason();
    }

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public List<WebSocketExtension<?>> getExtensions() {
        return this.$$delegate_0.getExtensions();
    }

    public ReceiveChannel<Frame> getIncoming() {
        return this.$$delegate_0.getIncoming();
    }

    public boolean getMasking() {
        return this.$$delegate_0.getMasking();
    }

    public long getMaxFrameSize() {
        return this.$$delegate_0.getMaxFrameSize();
    }

    public SendChannel<Frame> getOutgoing() {
        return this.$$delegate_0.getOutgoing();
    }

    public long getPingIntervalMillis() {
        return this.$$delegate_0.getPingIntervalMillis();
    }

    public long getTimeoutMillis() {
        return this.$$delegate_0.getTimeoutMillis();
    }

    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return this.$$delegate_0.send(frame, continuation);
    }

    public void setMasking(boolean z) {
        this.$$delegate_0.setMasking(z);
    }

    public void setMaxFrameSize(long j) {
        this.$$delegate_0.setMaxFrameSize(j);
    }

    public void setPingIntervalMillis(long j) {
        this.$$delegate_0.setPingIntervalMillis(j);
    }

    public void setTimeoutMillis(long j) {
        this.$$delegate_0.setTimeoutMillis(j);
    }

    @InternalAPI
    public void start(List<? extends WebSocketExtension<?>> list) {
        Intrinsics.checkNotNullParameter(list, "negotiatedExtensions");
        this.$$delegate_0.start(list);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        this.$$delegate_0.terminate();
    }

    public DefaultClientWebSocketSession(HttpClientCall call, DefaultWebSocketSession delegate) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.$$delegate_0 = delegate;
        this.call = call;
    }

    @Override // io.ktor.client.plugins.websocket.ClientWebSocketSession
    public HttpClientCall getCall() {
        return this.call;
    }
}