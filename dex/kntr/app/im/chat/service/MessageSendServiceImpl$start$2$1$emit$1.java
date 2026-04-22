package kntr.app.im.chat.service;

import java.util.LinkedHashMap;
import kntr.app.im.chat.core.service.MessageTask;
import kntr.app.im.chat.service.MessageSendServiceImpl$start$2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageSendServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.MessageSendServiceImpl$start$2$1", f = "MessageSendServiceImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1}, l = {79, 80}, m = "emit", n = {"map", "started", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-MessageSendServiceImpl$start$2$1$1", "map", "started"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1"}, v = 1)
public final class MessageSendServiceImpl$start$2$1$emit$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageSendServiceImpl$start$2.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MessageSendServiceImpl$start$2$1$emit$1(MessageSendServiceImpl$start$2.AnonymousClass1<? super T> anonymousClass1, Continuation<? super MessageSendServiceImpl$start$2$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((LinkedHashMap<String, MessageTask>) null, (Continuation) this);
    }
}