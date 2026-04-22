package kntr.app.im.chat.db.dao;

import kntr.app.im.chat.db.entity.DraftEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DraftDao.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J0\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J0\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH'J\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0015\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/dao/DraftDao;", RoomRecommendViewModel.EMPTY_CURSOR, "upsert", RoomRecommendViewModel.EMPTY_CURSOR, "draft", "Lkntr/app/im/chat/db/entity/DraftEntity;", "(Lkntr/app/im/chat/db/entity/DraftEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDraft", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "(IJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "query", "observe", "Lkotlinx/coroutines/flow/Flow;", "deleteAllDraft", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DraftDao {
    Object deleteAllDraft(Continuation<? super Unit> continuation);

    Object deleteDraft(int i, long j2, long j3, long j4, Continuation<? super Unit> continuation);

    Object deleteDraft(DraftEntity draftEntity, Continuation<? super Unit> continuation);

    Object deleteDraft(SessionIdEntity sessionIdEntity, Continuation<? super Unit> continuation);

    Flow<DraftEntity> observe(int i, long j2, long j3, long j4);

    Flow<DraftEntity> observe(SessionIdEntity sessionIdEntity);

    Object query(int i, long j2, long j3, long j4, Continuation<? super DraftEntity> continuation);

    Object query(SessionIdEntity sessionIdEntity, Continuation<? super DraftEntity> continuation);

    Object upsert(DraftEntity draftEntity, Continuation<? super Unit> continuation);

    /* compiled from: DraftDao.kt */
    /* renamed from: kntr.app.im.chat.db.dao.DraftDao$-CC */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static Object $default$deleteDraft(DraftDao _this, SessionIdEntity sessionIdEntity, Continuation continuation) {
            return deleteDraft$suspendImpl(_this, sessionIdEntity, continuation);
        }

        public static Object $default$query(DraftDao _this, SessionIdEntity sessionIdEntity, Continuation continuation) {
            return query$suspendImpl(_this, sessionIdEntity, continuation);
        }

        public static /* synthetic */ Object deleteDraft$suspendImpl(DraftDao $this, SessionIdEntity sessionId, Continuation<? super Unit> continuation) {
            Object deleteDraft = $this.deleteDraft(sessionId.getSessionType(), sessionId.getPrimaryId(), sessionId.getSecondaryId(), sessionId.getThirdId(), continuation);
            return deleteDraft == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteDraft : Unit.INSTANCE;
        }

        public static /* synthetic */ Object query$suspendImpl(DraftDao $this, SessionIdEntity sessionId, Continuation<? super DraftEntity> continuation) {
            return $this.query(sessionId.getSessionType(), sessionId.getPrimaryId(), sessionId.getSecondaryId(), sessionId.getThirdId(), continuation);
        }

        public static Flow $default$observe(DraftDao _this, SessionIdEntity sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return _this.observe(sessionId.getSessionType(), sessionId.getPrimaryId(), sessionId.getSecondaryId(), sessionId.getThirdId());
        }
    }

    /* compiled from: DraftDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Object deleteDraft(DraftDao $this, SessionIdEntity sessionId, Continuation<? super Unit> continuation) {
            return CC.deleteDraft$suspendImpl($this, sessionId, continuation);
        }

        @Deprecated
        public static Object query(DraftDao $this, SessionIdEntity sessionId, Continuation<? super DraftEntity> continuation) {
            return CC.query$suspendImpl($this, sessionId, continuation);
        }

        @Deprecated
        public static Flow<DraftEntity> observe(DraftDao $this, SessionIdEntity sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return CC.$default$observe($this, sessionId);
        }
    }
}