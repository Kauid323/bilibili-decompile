package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultWebSocketSession.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0, 0, 0}, l = {290}, m = "sendCloseSequence", n = {"this", "exception", "reasonToSend"}, s = {"L$0", "L$1", "L$2"})
public final class DefaultWebSocketSessionImpl$sendCloseSequence$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$sendCloseSequence$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation<? super DefaultWebSocketSessionImpl$sendCloseSequence$1> continuation) {
        super(continuation);
        this.this$0 = defaultWebSocketSessionImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object sendCloseSequence;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        sendCloseSequence = this.this$0.sendCloseSequence(null, null, (Continuation) this);
        return sendCloseSequence;
    }
}