package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebSocketReader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketReader", f = "WebSocketReader.kt", i = {0, 0, 1, 1}, l = {69, 75}, m = "readLoop", n = {"this", "buffer", "this", "buffer"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class WebSocketReader$readLoop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebSocketReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketReader$readLoop$1(WebSocketReader webSocketReader, Continuation<? super WebSocketReader$readLoop$1> continuation) {
        super(continuation);
        this.this$0 = webSocketReader;
    }

    public final Object invokeSuspend(Object obj) {
        Object readLoop;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readLoop = this.this$0.readLoop(null, (Continuation) this);
        return readLoop;
    }
}