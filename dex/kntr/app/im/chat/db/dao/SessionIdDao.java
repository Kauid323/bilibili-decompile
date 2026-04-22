package kntr.app.im.chat.db.dao;

import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: SessionIdDao.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u000e\u0010\b\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/dao/SessionIdDao;", RoomRecommendViewModel.EMPTY_CURSOR, "insert", RoomRecommendViewModel.EMPTY_CURSOR, "session", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSessionId", "deleteAllSessions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SessionIdDao {
    Object deleteAllSessions(Continuation<? super Unit> continuation);

    Object deleteSessionId(SessionIdEntity sessionIdEntity, Continuation<? super Unit> continuation);

    Object insert(SessionIdEntity sessionIdEntity, Continuation<? super Unit> continuation);
}