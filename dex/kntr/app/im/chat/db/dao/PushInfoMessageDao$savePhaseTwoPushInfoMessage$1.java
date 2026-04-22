package kntr.app.im.chat.db.dao;

import kntr.app.im.chat.db.dao.PushInfoMessageDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushInfoMessageDao.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.dao.PushInfoMessageDao", f = "PushInfoMessageDao.kt", i = {0, 0, 0}, l = {64}, m = "savePhaseTwoPushInfoMessage$suspendImpl", n = {"$this", "pushInfoRecord", "pushInfoMessage"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class PushInfoMessageDao$savePhaseTwoPushInfoMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushInfoMessageDao this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushInfoMessageDao$savePhaseTwoPushInfoMessage$1(PushInfoMessageDao pushInfoMessageDao, Continuation<? super PushInfoMessageDao$savePhaseTwoPushInfoMessage$1> continuation) {
        super(continuation);
        this.this$0 = pushInfoMessageDao;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PushInfoMessageDao.CC.savePhaseTwoPushInfoMessage$suspendImpl(this.this$0, null, null, (Continuation) this);
    }
}