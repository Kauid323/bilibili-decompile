package kntr.app.im.chat.db.dao;

import kntr.app.im.chat.db.dao.RangeDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RangeDao.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.dao.RangeDao", f = "RangeDao.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {135, 138}, m = "removeAndAdd$suspendImpl", n = {"$this", "sessionId", "toDelete", "toInsert", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-RangeDao$removeAndAdd$2", "$this", "sessionId", "toDelete", "toInsert", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-RangeDao$removeAndAdd$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1"}, v = 1)
public final class RangeDao$removeAndAdd$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RangeDao this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RangeDao$removeAndAdd$1(RangeDao rangeDao, Continuation<? super RangeDao$removeAndAdd$1> continuation) {
        super(continuation);
        this.this$0 = rangeDao;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RangeDao.CC.removeAndAdd$suspendImpl(this.this$0, null, null, null, (Continuation) this);
    }
}