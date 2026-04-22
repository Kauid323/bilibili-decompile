package kntr.app.im.chat.db.dao;

import kntr.app.im.chat.db.dao.MessageDao;
import kntr.app.im.chat.db.entity.MessageEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageDao.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.dao.MessageDao", f = "MessageDao.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {33, 41, 57, 63}, m = "upsertWithToken$suspendImpl", n = {"$this", "message", "$this", "message", "$this", "message", "existingMessage", "update", "$this", "message", "existingMessage", "update"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"}, v = 1)
public final class MessageDao$upsertWithToken$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageDao this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageDao$upsertWithToken$1(MessageDao messageDao, Continuation<? super MessageDao$upsertWithToken$1> continuation) {
        super(continuation);
        this.this$0 = messageDao;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MessageDao.CC.upsertWithToken$suspendImpl(this.this$0, (MessageEntity) null, (Continuation) this);
    }
}