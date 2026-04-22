package kntr.app.im.chat.service;

import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.im.chat.service.MessageSendServiceImpl$start$4;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageSendServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.MessageSendServiceImpl$start$4$2", f = "MessageSendServiceImpl.kt", i = {0, 1, 1, 1, 2, 2, 2}, l = {124, 129, 130}, m = "emit", n = {"it", "it", "it", "$i$a$-onSuccess-MessageSendServiceImpl$start$4$2$1", "it", "it", "$i$a$-onSuccess-MessageSendServiceImpl$start$4$2$1"}, s = {"L$0", "L$0", "L$3", "I$0", "L$0", "L$2", "I$0"}, v = 1)
public final class MessageSendServiceImpl$start$4$2$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageSendServiceImpl$start$4.AnonymousClass2<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MessageSendServiceImpl$start$4$2$emit$1(MessageSendServiceImpl$start$4.AnonymousClass2<? super T> anonymousClass2, Continuation<? super MessageSendServiceImpl$start$4$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass2;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((MessageTask) null, (Continuation) this);
    }
}