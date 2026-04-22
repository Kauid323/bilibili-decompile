package io.ktor.client.plugins.websocket;

import io.ktor.client.call.HttpClientCall;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: ClientSessions.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/ktor/client/plugins/websocket/ClientWebSocketSession;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/client/call/HttpClientCall;", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "call", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ClientWebSocketSession extends WebSocketSession {
    HttpClientCall getCall();

    /* compiled from: ClientSessions.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        public static Object send(ClientWebSocketSession $this, Frame frame, Continuation<? super Unit> continuation) {
            Object send = WebSocketSession.DefaultImpls.send($this, frame, continuation);
            return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
        }
    }
}