package kntr.app.im.chat.db.combinedDao;

import java.util.Collection;
import kntr.app.im.chat.db.dao.RangeDao;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.LongRange;

/* compiled from: DeletingDao_Impl.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.combinedDao.DeletingDao_Impl$removeAndAdd$2", f = "DeletingDao_Impl.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DeletingDao_Impl$removeAndAdd$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionIdEntity $sessionId;
    final /* synthetic */ Collection<LongRange> $toDelete;
    final /* synthetic */ Collection<LongRange> $toInsert;
    int label;
    final /* synthetic */ DeletingDao_Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeletingDao_Impl$removeAndAdd$2(DeletingDao_Impl deletingDao_Impl, SessionIdEntity sessionIdEntity, Collection<LongRange> collection, Collection<LongRange> collection2, Continuation<? super DeletingDao_Impl$removeAndAdd$2> continuation) {
        super(1, continuation);
        this.this$0 = deletingDao_Impl;
        this.$sessionId = sessionIdEntity;
        this.$toDelete = collection;
        this.$toInsert = collection2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DeletingDao_Impl$removeAndAdd$2(this.this$0, this.$sessionId, this.$toDelete, this.$toInsert, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object removeAndAdd$suspendImpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                removeAndAdd$suspendImpl = RangeDao.CC.removeAndAdd$suspendImpl(this.this$0, this.$sessionId, this.$toDelete, this.$toInsert, (Continuation) this);
                if (removeAndAdd$suspendImpl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}