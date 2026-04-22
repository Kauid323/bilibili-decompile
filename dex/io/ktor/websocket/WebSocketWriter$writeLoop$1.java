package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebSocketWriter.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0, 1, 1, 2, 3, 4}, l = {46, 48, 63, 63, 63, 63}, m = "writeLoop", n = {"this", "buffer", "this", "buffer", "this", "this", "this"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
public final class WebSocketWriter$writeLoop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebSocketWriter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketWriter$writeLoop$1(WebSocketWriter webSocketWriter, Continuation<? super WebSocketWriter$writeLoop$1> continuation) {
        super(continuation);
        this.this$0 = webSocketWriter;
    }

    public final Object invokeSuspend(Object obj) {
        Object writeLoop;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        writeLoop = this.this$0.writeLoop(null, (Continuation) this);
        return writeLoop;
    }
}