package kntr.app.im.chat.db.dao;

import java.util.List;
import kntr.app.im.chat.db.dao.MessageDao;
import kntr.app.im.chat.db.entity.MessageEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageDao.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.dao.MessageDao", f = "MessageDao.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {72}, m = "upsertWithToken$suspendImpl", n = {"$this", "messages", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-MessageDao$upsertWithToken$5"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1"}, v = 1)
public final class MessageDao$upsertWithToken$4 extends ContinuationImpl {
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
    final /* synthetic */ MessageDao this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageDao$upsertWithToken$4(MessageDao messageDao, Continuation<? super MessageDao$upsertWithToken$4> continuation) {
        super(continuation);
        this.this$0 = messageDao;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MessageDao.CC.upsertWithToken$suspendImpl(this.this$0, (List<MessageEntity>) null, (Continuation) this);
    }
}