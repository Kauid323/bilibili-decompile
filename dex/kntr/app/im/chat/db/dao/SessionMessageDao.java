package kntr.app.im.chat.db.dao;

import java.util.List;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: SessionMessageDao.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH§@¢\u0006\u0002\u0010\rJL\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH'J4\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/dao/SessionMessageDao;", RoomRecommendViewModel.EMPTY_CURSOR, "queryInRangeAsList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/entity/MessageEntity;", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "start", "end", "(IJJJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryInRangeAndLatestAsFlow", "Lkotlinx/coroutines/flow/Flow;", "baselineTime", "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SessionMessageDao {
    Flow<List<MessageEntity>> queryInRangeAndLatestAsFlow(int i, long j2, long j3, long j4, long j5, long j6, long j7);

    Flow<List<MessageEntity>> queryInRangeAndLatestAsFlow(SessionIdEntity sessionIdEntity, long j2, long j3, long j4);

    Object queryInRangeAsList(int i, long j2, long j3, long j4, long j5, long j6, Continuation<? super List<MessageEntity>> continuation);

    /* compiled from: SessionMessageDao.kt */
    /* renamed from: kntr.app.im.chat.db.dao.SessionMessageDao$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static Flow $default$queryInRangeAndLatestAsFlow(SessionMessageDao _this, SessionIdEntity sessionId, long start, long end, long baselineTime) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return _this.queryInRangeAndLatestAsFlow(sessionId.getSessionType(), sessionId.getPrimaryId(), sessionId.getSecondaryId(), sessionId.getThirdId(), start, end, baselineTime);
        }
    }

    /* compiled from: SessionMessageDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Flow<List<MessageEntity>> queryInRangeAndLatestAsFlow(SessionMessageDao $this, SessionIdEntity sessionId, long start, long end, long baselineTime) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return CC.$default$queryInRangeAndLatestAsFlow($this, sessionId, start, end, baselineTime);
        }
    }
}