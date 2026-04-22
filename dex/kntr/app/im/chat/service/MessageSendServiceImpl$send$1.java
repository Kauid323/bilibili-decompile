package kntr.app.im.chat.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageSendServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.MessageSendServiceImpl", f = "MessageSendServiceImpl.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {145, 152, 159}, m = "send", n = {"sessionId", "content", "imageType", "userPlaceholder", "sessionId", "content", "imageType", "userPlaceholder", "sessionId", "content", "imageType", "userPlaceholder", "taskList"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
public final class MessageSendServiceImpl$send$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageSendServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSendServiceImpl$send$1(MessageSendServiceImpl messageSendServiceImpl, Continuation<? super MessageSendServiceImpl$send$1> continuation) {
        super(continuation);
        this.this$0 = messageSendServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.send(null, null, null, null, (Continuation) this);
    }
}