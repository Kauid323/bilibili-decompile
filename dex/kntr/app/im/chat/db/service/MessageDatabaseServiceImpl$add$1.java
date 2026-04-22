package kntr.app.im.chat.db.service;

import kntr.app.im.chat.core.model.EntityMessage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageDatabaseServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.service.MessageDatabaseServiceImpl", f = "MessageDatabaseServiceImpl.kt", i = {0, 0, 1, 1, 1}, l = {110, 113}, m = "add", n = {"message", "sessionIdEntity", "message", "sessionIdEntity", "messageEntity"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
public final class MessageDatabaseServiceImpl$add$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageDatabaseServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageDatabaseServiceImpl$add$1(MessageDatabaseServiceImpl messageDatabaseServiceImpl, Continuation<? super MessageDatabaseServiceImpl$add$1> continuation) {
        super(continuation);
        this.this$0 = messageDatabaseServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.add((EntityMessage) null, (Continuation) this);
    }
}