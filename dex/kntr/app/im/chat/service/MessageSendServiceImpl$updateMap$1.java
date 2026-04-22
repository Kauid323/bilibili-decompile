package kntr.app.im.chat.service;

import java.util.Collection;
import kntr.app.im.chat.core.service.MessageTask;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageSendServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.MessageSendServiceImpl", f = "MessageSendServiceImpl.kt", i = {0, 0, 0}, l = {234}, m = "updateMap", n = {"taskList", "$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class MessageSendServiceImpl$updateMap$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageSendServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSendServiceImpl$updateMap$1(MessageSendServiceImpl messageSendServiceImpl, Continuation<? super MessageSendServiceImpl$updateMap$1> continuation) {
        super(continuation);
        this.this$0 = messageSendServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object updateMap;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateMap = this.this$0.updateMap((Collection<? extends MessageTask>) null, (Continuation) this);
        return updateMap;
    }
}