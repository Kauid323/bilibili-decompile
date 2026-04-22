package kntr.app.im.chat.db.dao;

import im.base.IMLog;
import java.util.Iterator;
import java.util.List;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.datetime.Clock;

/* compiled from: MessageDao.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b$\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0097@¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0097@¢\u0006\u0002\u0010\nJH\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0015J0\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001bJF\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0015J.\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u001d\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u001eJV\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u000fH§@¢\u0006\u0002\u0010)J>\u0010\u001f\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010+J^\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u000fH§@¢\u0006\u0002\u0010-JF\u0010\u001f\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010.Jx\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH§@¢\u0006\u0002\u00101J`\u0010\u001f\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096@¢\u0006\u0002\u00102JV\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000fH§@¢\u0006\u0002\u00103J>\u0010\u001f\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u00104JX\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\b\u00105\u001a\u0004\u0018\u00010\u000fH§@¢\u0006\u0002\u00106J@\u0010\u001f\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\b\u00105\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u00107JL\u00108\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\rH§@¢\u0006\u0002\u0010<J\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050\tH§@¢\u0006\u0002\u0010\u001e¨\u0006>À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/dao/MessageDao;", RoomRecommendViewModel.EMPTY_CURSOR, "insert", RoomRecommendViewModel.EMPTY_CURSOR, "message", "Lkntr/app/im/chat/db/entity/MessageEntity;", "(Lkntr/app/im/chat/db/entity/MessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertWithToken", "messages", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "query", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "msgKey", "sequenceNumber", "subsequenceNumber", "(IJJJJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;JJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "token", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "deleteAllMessages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "forSessionType", "forPrimaryId", "forSecondaryId", "forThirdId", "forMsgKey", "forSequenceNumber", "forSubsequenceNumber", "sendStatus", "updateTime", "(IJJJJJJIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forSessionId", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;JJJIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "(IJJJJJJLjava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;JJJLjava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newSequenceNumber", "newSubsequenceNumber", "(IJJJJJJJJLjava/lang/String;IJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;JJJJJLjava/lang/String;IJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(IJJJJJJLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;JJJLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTime", "(IJJJJJJJLjava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;JJJJLjava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryLaterSequenceNumberInRange", "start", "end", "limit", "(IJJJJJILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "all", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MessageDao {
    Object all(Continuation<? super List<MessageEntity>> continuation);

    Object delete(int i, long j2, long j3, long j4, long j5, long j6, long j7, Continuation<? super Unit> continuation);

    Object delete(SessionIdEntity sessionIdEntity, long j2, long j3, long j4, Continuation<? super Unit> continuation);

    Object deleteAllMessages(Continuation<? super Unit> continuation);

    Object insert(MessageEntity messageEntity, Continuation<? super Unit> continuation);

    Object query(int i, long j2, long j3, long j4, long j5, long j6, long j7, Continuation<? super MessageEntity> continuation);

    Object query(String str, Continuation<? super MessageEntity> continuation);

    Object query(SessionIdEntity sessionIdEntity, long j2, long j3, long j4, Continuation<? super MessageEntity> continuation);

    Object queryLaterSequenceNumberInRange(int i, long j2, long j3, long j4, long j5, long j6, int i2, Continuation<? super List<Long>> continuation);

    Object update(int i, long j2, long j3, long j4, long j5, long j6, long j7, int i2, long j8, Continuation<? super Integer> continuation);

    Object update(int i, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, String str, int i2, long j10, String str2, Continuation<? super Integer> continuation);

    Object update(int i, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Long l, Continuation<? super Unit> continuation);

    Object update(int i, long j2, long j3, long j4, long j5, long j6, long j7, String str, int i2, long j8, Continuation<? super Integer> continuation);

    Object update(int i, long j2, long j3, long j4, long j5, long j6, long j7, String str, long j8, Continuation<? super Unit> continuation);

    Object update(SessionIdEntity sessionIdEntity, long j2, long j3, long j4, int i, long j5, Continuation<? super Integer> continuation);

    Object update(SessionIdEntity sessionIdEntity, long j2, long j3, long j4, long j5, long j6, String str, int i, long j7, String str2, Continuation<? super Integer> continuation);

    Object update(SessionIdEntity sessionIdEntity, long j2, long j3, long j4, long j5, Long l, Continuation<? super Unit> continuation);

    Object update(SessionIdEntity sessionIdEntity, long j2, long j3, long j4, String str, int i, long j5, Continuation<? super Integer> continuation);

    Object update(SessionIdEntity sessionIdEntity, long j2, long j3, long j4, String str, long j5, Continuation<? super Unit> continuation);

    Object upsertWithToken(List<MessageEntity> list, Continuation<? super Unit> continuation);

    Object upsertWithToken(MessageEntity messageEntity, Continuation<? super Unit> continuation);

    /* compiled from: MessageDao.kt */
    /* renamed from: kntr.app.im.chat.db.dao.MessageDao$-CC */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static Object $default$delete(MessageDao _this, SessionIdEntity sessionIdEntity, long j2, long j3, long j4, Continuation continuation) {
            return delete$suspendImpl(_this, sessionIdEntity, j2, j3, j4, continuation);
        }

        public static Object $default$query(MessageDao _this, SessionIdEntity sessionIdEntity, long j2, long j3, long j4, Continuation continuation) {
            return query$suspendImpl(_this, sessionIdEntity, j2, j3, j4, continuation);
        }

        public static Object $default$update(MessageDao _this, SessionIdEntity sessionIdEntity, long j2, long j3, long j4, int i, long j5, Continuation continuation) {
            return update$suspendImpl(_this, sessionIdEntity, j2, j3, j4, i, j5, continuation);
        }

        public static Object $default$update(MessageDao _this, SessionIdEntity sessionIdEntity, long j2, long j3, long j4, long j5, long j6, String str, int i, long j7, String str2, Continuation continuation) {
            return update$suspendImpl(_this, sessionIdEntity, j2, j3, j4, j5, j6, str, i, j7, str2, continuation);
        }

        public static Object $default$update(MessageDao _this, SessionIdEntity sessionIdEntity, long j2, long j3, long j4, long j5, Long l, Continuation continuation) {
            return update$suspendImpl(_this, sessionIdEntity, j2, j3, j4, j5, l, continuation);
        }

        public static Object $default$update(MessageDao _this, SessionIdEntity sessionIdEntity, long j2, long j3, long j4, String str, int i, long j5, Continuation continuation) {
            return update$suspendImpl(_this, sessionIdEntity, j2, j3, j4, str, i, j5, continuation);
        }

        public static Object $default$update(MessageDao _this, SessionIdEntity sessionIdEntity, long j2, long j3, long j4, String str, long j5, Continuation continuation) {
            return update$suspendImpl(_this, sessionIdEntity, j2, j3, j4, str, j5, continuation);
        }

        public static Object $default$upsertWithToken(MessageDao _this, List list, Continuation continuation) {
            return upsertWithToken$suspendImpl(_this, list, continuation);
        }

        public static Object $default$upsertWithToken(MessageDao _this, MessageEntity messageEntity, Continuation continuation) {
            return upsertWithToken$suspendImpl(_this, messageEntity, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x021f  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x025d  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01c3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ Object upsertWithToken$suspendImpl(MessageDao $this, MessageEntity message, Continuation<? super Unit> continuation) {
            MessageDao$upsertWithToken$1 messageDao$upsertWithToken$1;
            MessageDao$upsertWithToken$1 messageDao$upsertWithToken$12;
            String str;
            Object obj;
            MessageDao$upsertWithToken$1 messageDao$upsertWithToken$13;
            MessageEntity message2;
            MessageDao $this2;
            Object obj2;
            MessageEntity copy;
            Pair pair;
            MessageEntity it;
            MessageEntity copy2;
            MessageEntity existingMessage;
            MessageEntity it2;
            MessageEntity copy3;
            if (continuation instanceof MessageDao$upsertWithToken$1) {
                messageDao$upsertWithToken$1 = (MessageDao$upsertWithToken$1) continuation;
                if ((messageDao$upsertWithToken$1.label & Integer.MIN_VALUE) != 0) {
                    messageDao$upsertWithToken$1.label -= Integer.MIN_VALUE;
                    messageDao$upsertWithToken$12 = messageDao$upsertWithToken$1;
                    Object $result = messageDao$upsertWithToken$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (messageDao$upsertWithToken$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            IMLog.Companion.i("DB_MessageDao", "Upserting message with token: " + message.getToken() + " id " + message.getSequenceNumber() + "-" + message.getSubsequenceNumber());
                            if (message.getId() != 0) {
                                copy = message.copy((r33 & 1) != 0 ? message.id : 0L, (r33 & 2) != 0 ? message.sessionId : null, (r33 & 4) != 0 ? message.msgKey : 0L, (r33 & 8) != 0 ? message.sequenceNumber : 0L, (r33 & 16) != 0 ? message.subsequenceNumber : 0L, (r33 & 32) != 0 ? message.token : null, (r33 & 64) != 0 ? message.content : null, (r33 & 128) != 0 ? message.sendStatus : 0, (r33 & 256) != 0 ? message.createTime : null, (r33 & 512) != 0 ? message.updateTime : Clock.System.INSTANCE.now(), (r33 & 1024) != 0 ? message.deleteTime : null, (r33 & 2048) != 0 ? message.isRealtimeMessage : false);
                                str = "DB_MessageDao";
                                obj = coroutine_suspended;
                                messageDao$upsertWithToken$13 = messageDao$upsertWithToken$12;
                                $this2 = $this;
                                pair = TuplesKt.to(copy, Boxing.boxBoolean(true));
                                message2 = message;
                                existingMessage = (MessageEntity) pair.component1();
                                boolean update = ((Boolean) pair.component2()).booleanValue();
                                if (existingMessage == null) {
                                    IMLog.Companion.i(str, "Inserting new message.");
                                    messageDao$upsertWithToken$13.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                                    messageDao$upsertWithToken$13.L$1 = SpillingKt.nullOutSpilledVariable(message2);
                                    messageDao$upsertWithToken$13.L$2 = SpillingKt.nullOutSpilledVariable(existingMessage);
                                    messageDao$upsertWithToken$13.Z$0 = update;
                                    messageDao$upsertWithToken$13.label = 4;
                                    return $this2.insert(message2, messageDao$upsertWithToken$13) == obj ? obj : Unit.INSTANCE;
                                } else if (!update) {
                                    IMLog.Companion.i(str, "Message content is the same, skipping update.");
                                    return Unit.INSTANCE;
                                } else {
                                    IMLog.Companion.i(str, "Updating existing message.");
                                    messageDao$upsertWithToken$13.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                                    messageDao$upsertWithToken$13.L$1 = SpillingKt.nullOutSpilledVariable(message2);
                                    messageDao$upsertWithToken$13.L$2 = SpillingKt.nullOutSpilledVariable(existingMessage);
                                    messageDao$upsertWithToken$13.Z$0 = update;
                                    messageDao$upsertWithToken$13.label = 3;
                                    return $this2.insert(existingMessage, messageDao$upsertWithToken$13) == obj ? obj : Unit.INSTANCE;
                                }
                            } else if (message.getToken() != null) {
                                IMLog.Companion.i("DB_MessageDao", "Attempting to update existing message with token: " + message.getToken());
                                String token = message.getToken();
                                messageDao$upsertWithToken$12.L$0 = $this;
                                messageDao$upsertWithToken$12.L$1 = message;
                                messageDao$upsertWithToken$12.label = 1;
                                Object query = $this.query(token, messageDao$upsertWithToken$12);
                                if (query == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj2 = query;
                                message2 = message;
                                $this2 = $this;
                                it = (MessageEntity) obj2;
                                if (it != null) {
                                    copy2 = r17.copy((r33 & 1) != 0 ? r17.id : it.getId(), (r33 & 2) != 0 ? r17.sessionId : null, (r33 & 4) != 0 ? r17.msgKey : 0L, (r33 & 8) != 0 ? r17.sequenceNumber : 0L, (r33 & 16) != 0 ? r17.subsequenceNumber : 0L, (r33 & 32) != 0 ? r17.token : null, (r33 & 64) != 0 ? r17.content : null, (r33 & 128) != 0 ? r17.sendStatus : 0, (r33 & 256) != 0 ? r17.createTime : null, (r33 & 512) != 0 ? r17.updateTime : Clock.System.INSTANCE.now(), (r33 & 1024) != 0 ? r17.deleteTime : null, (r33 & 2048) != 0 ? message2.isRealtimeMessage : false);
                                    Pair pair2 = TuplesKt.to(copy2, Boxing.boxBoolean(message2.checkNeedUpdate(it)));
                                    if (pair2 != null) {
                                        str = "DB_MessageDao";
                                        obj = coroutine_suspended;
                                        messageDao$upsertWithToken$13 = messageDao$upsertWithToken$12;
                                        pair = pair2;
                                        existingMessage = (MessageEntity) pair.component1();
                                        boolean update2 = ((Boolean) pair.component2()).booleanValue();
                                        if (existingMessage == null) {
                                        }
                                    }
                                }
                                str = "DB_MessageDao";
                                pair = TuplesKt.to((Object) null, Boxing.boxBoolean(false));
                                obj = coroutine_suspended;
                                messageDao$upsertWithToken$13 = messageDao$upsertWithToken$12;
                                existingMessage = (MessageEntity) pair.component1();
                                boolean update22 = ((Boolean) pair.component2()).booleanValue();
                                if (existingMessage == null) {
                                }
                            } else {
                                IMLog.Companion.i("DB_MessageDao", "No token provided, query with id.");
                                SessionIdEntity sessionId = message.getSessionId();
                                long msgKey = message.getMsgKey();
                                long sequenceNumber = message.getSequenceNumber();
                                long subsequenceNumber = message.getSubsequenceNumber();
                                messageDao$upsertWithToken$12.L$0 = $this;
                                messageDao$upsertWithToken$12.L$1 = message;
                                messageDao$upsertWithToken$12.label = 2;
                                str = "DB_MessageDao";
                                obj = coroutine_suspended;
                                messageDao$upsertWithToken$13 = messageDao$upsertWithToken$12;
                                $result = $this.query(sessionId, msgKey, sequenceNumber, subsequenceNumber, messageDao$upsertWithToken$13);
                                if ($result == obj) {
                                    return obj;
                                }
                                message2 = message;
                                $this2 = $this;
                                it2 = (MessageEntity) $result;
                                if (it2 != null) {
                                    copy3 = r17.copy((r33 & 1) != 0 ? r17.id : it2.getId(), (r33 & 2) != 0 ? r17.sessionId : null, (r33 & 4) != 0 ? r17.msgKey : 0L, (r33 & 8) != 0 ? r17.sequenceNumber : 0L, (r33 & 16) != 0 ? r17.subsequenceNumber : 0L, (r33 & 32) != 0 ? r17.token : null, (r33 & 64) != 0 ? r17.content : null, (r33 & 128) != 0 ? r17.sendStatus : 0, (r33 & 256) != 0 ? r17.createTime : null, (r33 & 512) != 0 ? r17.updateTime : Clock.System.INSTANCE.now(), (r33 & 1024) != 0 ? r17.deleteTime : null, (r33 & 2048) != 0 ? message2.isRealtimeMessage : false);
                                    Pair pair3 = TuplesKt.to(copy3, Boxing.boxBoolean(message2.checkNeedUpdate(it2)));
                                    if (pair3 != null) {
                                        pair = pair3;
                                        existingMessage = (MessageEntity) pair.component1();
                                        boolean update222 = ((Boolean) pair.component2()).booleanValue();
                                        if (existingMessage == null) {
                                        }
                                    }
                                }
                                pair = TuplesKt.to((Object) null, Boxing.boxBoolean(false));
                                existingMessage = (MessageEntity) pair.component1();
                                boolean update2222 = ((Boolean) pair.component2()).booleanValue();
                                if (existingMessage == null) {
                                }
                            }
                        case 1:
                            message2 = (MessageEntity) messageDao$upsertWithToken$12.L$1;
                            $this2 = (MessageDao) messageDao$upsertWithToken$12.L$0;
                            ResultKt.throwOnFailure($result);
                            obj2 = $result;
                            it = (MessageEntity) obj2;
                            if (it != null) {
                            }
                            str = "DB_MessageDao";
                            pair = TuplesKt.to((Object) null, Boxing.boxBoolean(false));
                            obj = coroutine_suspended;
                            messageDao$upsertWithToken$13 = messageDao$upsertWithToken$12;
                            existingMessage = (MessageEntity) pair.component1();
                            boolean update22222 = ((Boolean) pair.component2()).booleanValue();
                            if (existingMessage == null) {
                            }
                            break;
                        case 2:
                            message2 = (MessageEntity) messageDao$upsertWithToken$12.L$1;
                            $this2 = (MessageDao) messageDao$upsertWithToken$12.L$0;
                            ResultKt.throwOnFailure($result);
                            str = "DB_MessageDao";
                            obj = coroutine_suspended;
                            messageDao$upsertWithToken$13 = messageDao$upsertWithToken$12;
                            it2 = (MessageEntity) $result;
                            if (it2 != null) {
                            }
                            pair = TuplesKt.to((Object) null, Boxing.boxBoolean(false));
                            existingMessage = (MessageEntity) pair.component1();
                            boolean update222222 = ((Boolean) pair.component2()).booleanValue();
                            if (existingMessage == null) {
                            }
                            break;
                        case 3:
                            boolean update3 = messageDao$upsertWithToken$12.Z$0;
                            MessageEntity messageEntity = (MessageEntity) messageDao$upsertWithToken$12.L$2;
                            MessageEntity messageEntity2 = (MessageEntity) messageDao$upsertWithToken$12.L$1;
                            MessageDao messageDao = (MessageDao) messageDao$upsertWithToken$12.L$0;
                            ResultKt.throwOnFailure($result);
                        case 4:
                            boolean z = messageDao$upsertWithToken$12.Z$0;
                            MessageEntity messageEntity3 = (MessageEntity) messageDao$upsertWithToken$12.L$2;
                            MessageEntity messageEntity4 = (MessageEntity) messageDao$upsertWithToken$12.L$1;
                            MessageDao messageDao2 = (MessageDao) messageDao$upsertWithToken$12.L$0;
                            ResultKt.throwOnFailure($result);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            messageDao$upsertWithToken$1 = new MessageDao$upsertWithToken$1($this, continuation);
            messageDao$upsertWithToken$12 = messageDao$upsertWithToken$1;
            Object $result2 = messageDao$upsertWithToken$12.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (messageDao$upsertWithToken$12.label) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x005f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ Object upsertWithToken$suspendImpl(MessageDao $this, List<MessageEntity> list, Continuation<? super Unit> continuation) {
            MessageDao$upsertWithToken$4 messageDao$upsertWithToken$4;
            int $i$f$forEach;
            Iterable $this$forEach$iv;
            Iterator it;
            if (continuation instanceof MessageDao$upsertWithToken$4) {
                messageDao$upsertWithToken$4 = (MessageDao$upsertWithToken$4) continuation;
                if ((messageDao$upsertWithToken$4.label & Integer.MIN_VALUE) != 0) {
                    messageDao$upsertWithToken$4.label -= Integer.MIN_VALUE;
                    Object $result = messageDao$upsertWithToken$4.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (messageDao$upsertWithToken$4.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            List<MessageEntity> $this$forEach$iv2 = list;
                            $i$f$forEach = 0;
                            $this$forEach$iv = $this$forEach$iv2;
                            it = $this$forEach$iv2.iterator();
                            break;
                        case 1:
                            int i = messageDao$upsertWithToken$4.I$1;
                            $i$f$forEach = messageDao$upsertWithToken$4.I$0;
                            MessageEntity messageEntity = (MessageEntity) messageDao$upsertWithToken$4.L$5;
                            Object obj = messageDao$upsertWithToken$4.L$4;
                            it = (Iterator) messageDao$upsertWithToken$4.L$3;
                            $this$forEach$iv = (Iterable) messageDao$upsertWithToken$4.L$2;
                            list = (List) messageDao$upsertWithToken$4.L$1;
                            $this = (MessageDao) messageDao$upsertWithToken$4.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    while (it.hasNext()) {
                        Object element$iv = it.next();
                        MessageEntity it2 = (MessageEntity) element$iv;
                        messageDao$upsertWithToken$4.L$0 = $this;
                        messageDao$upsertWithToken$4.L$1 = SpillingKt.nullOutSpilledVariable(list);
                        messageDao$upsertWithToken$4.L$2 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                        messageDao$upsertWithToken$4.L$3 = it;
                        messageDao$upsertWithToken$4.L$4 = SpillingKt.nullOutSpilledVariable(element$iv);
                        messageDao$upsertWithToken$4.L$5 = SpillingKt.nullOutSpilledVariable(it2);
                        messageDao$upsertWithToken$4.I$0 = $i$f$forEach;
                        messageDao$upsertWithToken$4.I$1 = 0;
                        messageDao$upsertWithToken$4.label = 1;
                        if ($this.upsertWithToken(it2, (Continuation<? super Unit>) messageDao$upsertWithToken$4) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            messageDao$upsertWithToken$4 = new MessageDao$upsertWithToken$4($this, continuation);
            Object $result2 = messageDao$upsertWithToken$4.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (messageDao$upsertWithToken$4.label) {
            }
            while (it.hasNext()) {
            }
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Object query$suspendImpl(MessageDao $this, SessionIdEntity sessionId, long msgKey, long sequenceNumber, long subsequenceNumber, Continuation<? super MessageEntity> continuation) {
            return $this.query(sessionId.getSessionType(), sessionId.getPrimaryId(), sessionId.getSecondaryId(), sessionId.getThirdId(), msgKey, sequenceNumber, subsequenceNumber, continuation);
        }

        public static /* synthetic */ Object delete$suspendImpl(MessageDao $this, SessionIdEntity sessionId, long msgKey, long sequenceNumber, long subsequenceNumber, Continuation<? super Unit> continuation) {
            Object delete = $this.delete(sessionId.getSessionType(), sessionId.getPrimaryId(), sessionId.getSecondaryId(), sessionId.getThirdId(), msgKey, sequenceNumber, subsequenceNumber, continuation);
            return delete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delete : Unit.INSTANCE;
        }

        public static /* synthetic */ Object update$suspendImpl(MessageDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, int sendStatus, long updateTime, Continuation<? super Integer> continuation) {
            return $this.update(forSessionId.getSessionType(), forSessionId.getPrimaryId(), forSessionId.getSecondaryId(), forSessionId.getThirdId(), forMsgKey, forSequenceNumber, forSubsequenceNumber, sendStatus, updateTime, continuation);
        }

        public static /* synthetic */ Object update$suspendImpl(MessageDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, String content, int sendStatus, long updateTime, Continuation<? super Integer> continuation) {
            return $this.update(forSessionId.getSessionType(), forSessionId.getPrimaryId(), forSessionId.getSecondaryId(), forSessionId.getThirdId(), forMsgKey, forSequenceNumber, forSubsequenceNumber, content, sendStatus, updateTime, continuation);
        }

        public static /* synthetic */ Object update$suspendImpl(MessageDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, long newSequenceNumber, long newSubsequenceNumber, String content, int sendStatus, long updateTime, String token, Continuation<? super Integer> continuation) {
            return $this.update(forSessionId.getSessionType(), forSessionId.getPrimaryId(), forSessionId.getSecondaryId(), forSessionId.getThirdId(), forMsgKey, forSequenceNumber, forSubsequenceNumber, newSequenceNumber, newSubsequenceNumber, content, sendStatus, updateTime, token, continuation);
        }

        public static /* synthetic */ Object update$suspendImpl(MessageDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, String content, long updateTime, Continuation<? super Unit> continuation) {
            Object update = $this.update(forSessionId.getSessionType(), forSessionId.getPrimaryId(), forSessionId.getSecondaryId(), forSessionId.getThirdId(), forMsgKey, forSequenceNumber, forSubsequenceNumber, content, updateTime, continuation);
            return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
        }

        public static /* synthetic */ Object update$suspendImpl(MessageDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, long updateTime, Long deleteTime, Continuation<? super Unit> continuation) {
            Object update = $this.update(forSessionId.getSessionType(), forSessionId.getPrimaryId(), forSessionId.getSecondaryId(), forSessionId.getThirdId(), forMsgKey, forSequenceNumber, forSubsequenceNumber, updateTime, deleteTime, continuation);
            return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
        }
    }

    /* compiled from: MessageDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Object upsertWithToken(MessageDao $this, MessageEntity message, Continuation<? super Unit> continuation) {
            return CC.upsertWithToken$suspendImpl($this, message, continuation);
        }

        @Deprecated
        public static Object upsertWithToken(MessageDao $this, List<MessageEntity> list, Continuation<? super Unit> continuation) {
            return CC.upsertWithToken$suspendImpl($this, list, continuation);
        }

        @Deprecated
        public static Object query(MessageDao $this, SessionIdEntity sessionId, long msgKey, long sequenceNumber, long subsequenceNumber, Continuation<? super MessageEntity> continuation) {
            return CC.query$suspendImpl($this, sessionId, msgKey, sequenceNumber, subsequenceNumber, continuation);
        }

        @Deprecated
        public static Object delete(MessageDao $this, SessionIdEntity sessionId, long msgKey, long sequenceNumber, long subsequenceNumber, Continuation<? super Unit> continuation) {
            return CC.delete$suspendImpl($this, sessionId, msgKey, sequenceNumber, subsequenceNumber, continuation);
        }

        @Deprecated
        public static Object update(MessageDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, int sendStatus, long updateTime, Continuation<? super Integer> continuation) {
            return CC.update$suspendImpl($this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, sendStatus, updateTime, continuation);
        }

        @Deprecated
        public static Object update(MessageDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, String content, int sendStatus, long updateTime, Continuation<? super Integer> continuation) {
            return CC.update$suspendImpl($this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, content, sendStatus, updateTime, continuation);
        }

        @Deprecated
        public static Object update(MessageDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, long newSequenceNumber, long newSubsequenceNumber, String content, int sendStatus, long updateTime, String token, Continuation<? super Integer> continuation) {
            return CC.update$suspendImpl($this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, newSequenceNumber, newSubsequenceNumber, content, sendStatus, updateTime, token, continuation);
        }

        @Deprecated
        public static Object update(MessageDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, String content, long updateTime, Continuation<? super Unit> continuation) {
            return CC.update$suspendImpl($this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, content, updateTime, continuation);
        }

        @Deprecated
        public static Object update(MessageDao $this, SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, long updateTime, Long deleteTime, Continuation<? super Unit> continuation) {
            return CC.update$suspendImpl($this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, updateTime, deleteTime, continuation);
        }
    }
}