package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebSocketWriter.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}, l = {121, 125, 139}, m = "drainQueueAndSerialize", n = {"this", "buffer", "flush", "closeSent", "this", "buffer", "flush", "it", "closeSent", "flush", "closeSent"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "I$0"})
public final class WebSocketWriter$drainQueueAndSerialize$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebSocketWriter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketWriter$drainQueueAndSerialize$1(WebSocketWriter webSocketWriter, Continuation<? super WebSocketWriter$drainQueueAndSerialize$1> continuation) {
        super(continuation);
        this.this$0 = webSocketWriter;
    }

    public final Object invokeSuspend(Object obj) {
        Object drainQueueAndSerialize;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        drainQueueAndSerialize = this.this$0.drainQueueAndSerialize(null, null, (Continuation) this);
        return drainQueueAndSerialize;
    }
}