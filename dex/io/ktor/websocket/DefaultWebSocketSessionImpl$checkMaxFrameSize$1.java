package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultWebSocketSession.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0}, l = {336}, m = "checkMaxFrameSize", n = {"size"}, s = {"I$0"})
public final class DefaultWebSocketSessionImpl$checkMaxFrameSize$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$checkMaxFrameSize$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation<? super DefaultWebSocketSessionImpl$checkMaxFrameSize$1> continuation) {
        super(continuation);
        this.this$0 = defaultWebSocketSessionImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object checkMaxFrameSize;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkMaxFrameSize = this.this$0.checkMaxFrameSize(null, null, (Continuation) this);
        return checkMaxFrameSize;
    }
}