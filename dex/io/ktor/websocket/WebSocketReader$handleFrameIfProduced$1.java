package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebSocketReader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketReader", f = "WebSocketReader.kt", i = {0}, l = {116}, m = "handleFrameIfProduced", n = {"this"}, s = {"L$0"})
public final class WebSocketReader$handleFrameIfProduced$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebSocketReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketReader$handleFrameIfProduced$1(WebSocketReader webSocketReader, Continuation<? super WebSocketReader$handleFrameIfProduced$1> continuation) {
        super(continuation);
        this.this$0 = webSocketReader;
    }

    public final Object invokeSuspend(Object obj) {
        Object handleFrameIfProduced;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleFrameIfProduced = this.this$0.handleFrameIfProduced((Continuation) this);
        return handleFrameIfProduced;
    }
}