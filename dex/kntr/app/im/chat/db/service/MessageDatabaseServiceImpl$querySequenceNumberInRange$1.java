package kntr.app.im.chat.db.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageDatabaseServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.service.MessageDatabaseServiceImpl", f = "MessageDatabaseServiceImpl.kt", i = {0, 0}, l = {97}, m = "querySequenceNumberInRange", n = {"range", "limit"}, s = {"L$0", "I$0"}, v = 1)
public final class MessageDatabaseServiceImpl$querySequenceNumberInRange$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageDatabaseServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageDatabaseServiceImpl$querySequenceNumberInRange$1(MessageDatabaseServiceImpl messageDatabaseServiceImpl, Continuation<? super MessageDatabaseServiceImpl$querySequenceNumberInRange$1> continuation) {
        super(continuation);
        this.this$0 = messageDatabaseServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.querySequenceNumberInRange(null, 0, (Continuation) this);
    }
}