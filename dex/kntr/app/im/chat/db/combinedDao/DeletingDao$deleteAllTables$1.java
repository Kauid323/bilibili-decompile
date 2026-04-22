package kntr.app.im.chat.db.combinedDao;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.im.chat.db.combinedDao.DeletingDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeletingDao.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.combinedDao.DeletingDao", f = "DeletingDao.kt", i = {0, 1, 2, 3, 4}, l = {AdditionVote2.DEFAULE_SELECT_SHARE_FIELD_NUMBER, AdditionVote2.ONLY_FANS_VOTE_FIELD_NUMBER, AdditionVote2.VOTE_OWNER_MID_FIELD_NUMBER, 23, 24}, m = "deleteAllTables$suspendImpl", n = {"$this", "$this", "$this", "$this", "$this"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0"}, v = 1)
public final class DeletingDao$deleteAllTables$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeletingDao this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeletingDao$deleteAllTables$1(DeletingDao deletingDao, Continuation<? super DeletingDao$deleteAllTables$1> continuation) {
        super(continuation);
        this.this$0 = deletingDao;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DeletingDao.CC.deleteAllTables$suspendImpl(this.this$0, (Continuation) this);
    }
}