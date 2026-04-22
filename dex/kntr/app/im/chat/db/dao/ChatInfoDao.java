package kntr.app.im.chat.db.dao;

import kntr.app.im.chat.db.entity.ChatInfoEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: ChatInfoDao.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\tJ>\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0014J&\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\bH§@¢\u0006\u0002\u0010\u0017J0\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0018¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/dao/ChatInfoDao;", RoomRecommendViewModel.EMPTY_CURSOR, "chatInfo", "Lkntr/app/im/chat/db/entity/ChatInfoEntity;", "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOrReplace", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/im/chat/db/entity/ChatInfoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateChatInfo", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "content", RoomRecommendViewModel.EMPTY_CURSOR, "updateTime", "(IJJJLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllChatInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(IJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatInfoDao {
    Object chatInfo(int i, long j2, long j3, long j4, Continuation<? super ChatInfoEntity> continuation);

    Object chatInfo(SessionIdEntity sessionIdEntity, Continuation<? super ChatInfoEntity> continuation);

    Object deleteAllChatInfo(Continuation<? super Unit> continuation);

    Object insertOrReplace(ChatInfoEntity chatInfoEntity, Continuation<? super Unit> continuation);

    Object updateChatInfo(int i, long j2, long j3, long j4, String str, long j5, Continuation<? super Unit> continuation);

    Object updateChatInfo(SessionIdEntity sessionIdEntity, String str, long j2, Continuation<? super Unit> continuation);

    /* compiled from: ChatInfoDao.kt */
    /* renamed from: kntr.app.im.chat.db.dao.ChatInfoDao$-CC */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static Object $default$chatInfo(ChatInfoDao _this, SessionIdEntity sessionIdEntity, Continuation continuation) {
            return chatInfo$suspendImpl(_this, sessionIdEntity, continuation);
        }

        public static Object $default$updateChatInfo(ChatInfoDao _this, SessionIdEntity sessionIdEntity, String str, long j2, Continuation continuation) {
            return updateChatInfo$suspendImpl(_this, sessionIdEntity, str, j2, continuation);
        }

        public static /* synthetic */ Object chatInfo$suspendImpl(ChatInfoDao $this, SessionIdEntity sessionId, Continuation<? super ChatInfoEntity> continuation) {
            return $this.chatInfo(sessionId.getSessionType(), sessionId.getPrimaryId(), sessionId.getSecondaryId(), sessionId.getThirdId(), continuation);
        }

        public static /* synthetic */ Object updateChatInfo$suspendImpl(ChatInfoDao $this, SessionIdEntity sessionId, String content, long updateTime, Continuation<? super Unit> continuation) {
            Object updateChatInfo = $this.updateChatInfo(sessionId.getSessionType(), sessionId.getPrimaryId(), sessionId.getSecondaryId(), sessionId.getThirdId(), content, updateTime, continuation);
            return updateChatInfo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateChatInfo : Unit.INSTANCE;
        }
    }

    /* compiled from: ChatInfoDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Object chatInfo(ChatInfoDao $this, SessionIdEntity sessionId, Continuation<? super ChatInfoEntity> continuation) {
            return CC.chatInfo$suspendImpl($this, sessionId, continuation);
        }

        @Deprecated
        public static Object updateChatInfo(ChatInfoDao $this, SessionIdEntity sessionId, String content, long updateTime, Continuation<? super Unit> continuation) {
            return CC.updateChatInfo$suspendImpl($this, sessionId, content, updateTime, continuation);
        }
    }
}