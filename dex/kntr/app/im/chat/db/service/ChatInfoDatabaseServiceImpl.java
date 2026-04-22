package kntr.app.im.chat.db.service;

import com.bapis.bilibili.app.im.v1.KChatInfoReply;
import im.base.IMLog;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.service.ChatInfoDatabaseService;
import kntr.app.im.chat.db.DatabaseService;
import kntr.app.im.chat.db.dao.ChatInfoDao;
import kntr.app.im.chat.db.dao.SessionIdDao;
import kntr.app.im.chat.db.entity.ChatInfoEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;

/* compiled from: ChatInfoDatabaseServiceImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/db/service/ChatInfoDatabaseServiceImpl;", "Lkntr/app/im/chat/core/service/ChatInfoDatabaseService;", "json", "Lkotlinx/serialization/json/Json;", "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "databaseService", "Lkntr/app/im/chat/db/DatabaseService;", "<init>", "(Lkotlinx/serialization/json/Json;Lkntr/app/im/chat/db/entity/SessionIdEntity;Lkntr/app/im/chat/db/DatabaseService;)V", "sessionIdDao", "Lkntr/app/im/chat/db/dao/SessionIdDao;", "chatInfoDao", "Lkntr/app/im/chat/db/dao/ChatInfoDao;", "load", "Lkntr/app/im/chat/core/model/ChatInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "add", RoomRecommendViewModel.EMPTY_CURSOR, "chatInfo", "(Lkntr/app/im/chat/core/model/ChatInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatInfoDatabaseServiceImpl implements ChatInfoDatabaseService {
    private final ChatInfoDao chatInfoDao;
    private final DatabaseService databaseService;
    private final Json json;
    private final SessionIdEntity sessionId;
    private final SessionIdDao sessionIdDao;

    @Inject
    public ChatInfoDatabaseServiceImpl(Json json, SessionIdEntity sessionId, DatabaseService databaseService) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(databaseService, "databaseService");
        this.json = json;
        this.sessionId = sessionId;
        this.databaseService = databaseService;
        this.sessionIdDao = this.databaseService.getDb().sessionIdDao();
        this.chatInfoDao = this.databaseService.getDb().chatInfoDao();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    @Override // kntr.app.im.chat.core.service.ChatInfoDatabaseService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object load(Continuation<? super ChatInfo> continuation) {
        Continuation<? super ChatInfoEntity> chatInfoDatabaseServiceImpl$load$1;
        Object chatInfo;
        ChatInfoEntity chatInfoEntity;
        KChatInfoReply it;
        if (continuation instanceof ChatInfoDatabaseServiceImpl$load$1) {
            chatInfoDatabaseServiceImpl$load$1 = (ChatInfoDatabaseServiceImpl$load$1) continuation;
            if ((chatInfoDatabaseServiceImpl$load$1.label & Integer.MIN_VALUE) != 0) {
                chatInfoDatabaseServiceImpl$load$1.label -= Integer.MIN_VALUE;
                Object $result = chatInfoDatabaseServiceImpl$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (chatInfoDatabaseServiceImpl$load$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ChatInfoDao chatInfoDao = this.databaseService.getDb().chatInfoDao();
                        int sessionType = this.sessionId.getSessionType();
                        long primaryId = this.sessionId.getPrimaryId();
                        long secondaryId = this.sessionId.getSecondaryId();
                        long thirdId = this.sessionId.getThirdId();
                        chatInfoDatabaseServiceImpl$load$1.label = 1;
                        chatInfo = chatInfoDao.chatInfo(sessionType, primaryId, secondaryId, thirdId, chatInfoDatabaseServiceImpl$load$1);
                        if (chatInfo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        chatInfo = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                chatInfoEntity = (ChatInfoEntity) chatInfo;
                if (chatInfoEntity != null || (it = chatInfoEntity.getContent(this.json)) == null) {
                    return null;
                }
                return new ChatInfo(it, null, null, null, null, null, 62, null);
            }
        }
        chatInfoDatabaseServiceImpl$load$1 = new ChatInfoDatabaseServiceImpl$load$1(this, continuation);
        Object $result2 = chatInfoDatabaseServiceImpl$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (chatInfoDatabaseServiceImpl$load$1.label) {
        }
        chatInfoEntity = (ChatInfoEntity) chatInfo;
        if (chatInfoEntity != null) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    @Override // kntr.app.im.chat.core.service.ChatInfoDatabaseService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object add(ChatInfo chatInfo, Continuation<? super Unit> continuation) {
        ChatInfoDatabaseServiceImpl$add$1 chatInfoDatabaseServiceImpl$add$1;
        ChatInfoEntity newEntity;
        ChatInfoDao chatInfoDao;
        if (continuation instanceof ChatInfoDatabaseServiceImpl$add$1) {
            chatInfoDatabaseServiceImpl$add$1 = (ChatInfoDatabaseServiceImpl$add$1) continuation;
            if ((chatInfoDatabaseServiceImpl$add$1.label & Integer.MIN_VALUE) != 0) {
                chatInfoDatabaseServiceImpl$add$1.label -= Integer.MIN_VALUE;
                Object $result = chatInfoDatabaseServiceImpl$add$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (chatInfoDatabaseServiceImpl$add$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        SessionIdDao sessionIdDao = this.sessionIdDao;
                        SessionIdEntity sessionIdEntity = this.sessionId;
                        chatInfoDatabaseServiceImpl$add$1.L$0 = chatInfo;
                        chatInfoDatabaseServiceImpl$add$1.label = 1;
                        if (sessionIdDao.insert(sessionIdEntity, chatInfoDatabaseServiceImpl$add$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        try {
                            newEntity = ChatInfoEntity.Companion.build(this.json, this.sessionId, chatInfo.getReply());
                            chatInfoDao = this.chatInfoDao;
                            chatInfoDatabaseServiceImpl$add$1.L$0 = SpillingKt.nullOutSpilledVariable(chatInfo);
                            chatInfoDatabaseServiceImpl$add$1.L$1 = SpillingKt.nullOutSpilledVariable(newEntity);
                            chatInfoDatabaseServiceImpl$add$1.label = 2;
                            if (chatInfoDao.insertOrReplace(newEntity, chatInfoDatabaseServiceImpl$add$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        } catch (SerializationException newEntity2) {
                            IMLog.Companion.e("Chat", "ChatInfo转换为Entity失败, SessionId=" + this.sessionId, (Throwable) newEntity2);
                            return Unit.INSTANCE;
                        }
                    case 1:
                        chatInfo = (ChatInfo) chatInfoDatabaseServiceImpl$add$1.L$0;
                        ResultKt.throwOnFailure($result);
                        newEntity = ChatInfoEntity.Companion.build(this.json, this.sessionId, chatInfo.getReply());
                        chatInfoDao = this.chatInfoDao;
                        chatInfoDatabaseServiceImpl$add$1.L$0 = SpillingKt.nullOutSpilledVariable(chatInfo);
                        chatInfoDatabaseServiceImpl$add$1.L$1 = SpillingKt.nullOutSpilledVariable(newEntity);
                        chatInfoDatabaseServiceImpl$add$1.label = 2;
                        if (chatInfoDao.insertOrReplace(newEntity, chatInfoDatabaseServiceImpl$add$1) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        ChatInfoEntity chatInfoEntity = (ChatInfoEntity) chatInfoDatabaseServiceImpl$add$1.L$1;
                        ChatInfo chatInfo2 = (ChatInfo) chatInfoDatabaseServiceImpl$add$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        chatInfoDatabaseServiceImpl$add$1 = new ChatInfoDatabaseServiceImpl$add$1(this, continuation);
        Object $result2 = chatInfoDatabaseServiceImpl$add$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (chatInfoDatabaseServiceImpl$add$1.label) {
        }
    }
}