package kntr.app.im.chat.db.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.db.converter.InstantConverter;
import kntr.app.im.chat.db.dao.MessageDao;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.datetime.Instant;

/* compiled from: MessageDao_Impl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u001f\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000b\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJH\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 JL\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0096@¢\u0006\u0002\u0010'JF\u0010(\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u001dJ\u000e\u0010)\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010'JV\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u00104J^\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u00106Jx\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096@¢\u0006\u0002\u00109JV\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010:JX\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00172\b\u0010;\u001a\u0004\u0018\u00010\u0017H\u0096@¢\u0006\u0002\u0010<R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lkntr/app/im/chat/db/dao/MessageDao_Impl;", "Lkntr/app/im/chat/db/dao/MessageDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__upsertAdapterOfMessageEntity", "Landroidx/room/EntityUpsertAdapter;", "Lkntr/app/im/chat/db/entity/MessageEntity;", "__instantConverter", "Lkntr/app/im/chat/db/converter/InstantConverter;", "upsertWithToken", RoomRecommendViewModel.EMPTY_CURSOR, "message", "(Lkntr/app/im/chat/db/entity/MessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messages", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "query", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "msgKey", "sequenceNumber", "subsequenceNumber", "(IJJJJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "token", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryLaterSequenceNumberInRange", "start", "end", "limit", "(IJJJJJILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "all", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "deleteAllMessages", "update", "forSessionType", "forPrimaryId", "forSecondaryId", "forThirdId", "forMsgKey", "forSequenceNumber", "forSubsequenceNumber", "sendStatus", "updateTime", "(IJJJJJJIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "(IJJJJJJLjava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newSequenceNumber", "newSubsequenceNumber", "(IJJJJJJJJLjava/lang/String;IJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(IJJJJJJLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTime", "(IJJJJJJJLjava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageDao_Impl implements MessageDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final InstantConverter __instantConverter;
    private final EntityUpsertAdapter<MessageEntity> __upsertAdapterOfMessageEntity;

    public MessageDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__instantConverter = new InstantConverter();
        this.__db = __db;
        this.__upsertAdapterOfMessageEntity = new EntityUpsertAdapter<>(new EntityInsertAdapter<MessageEntity>() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl.1
            protected String createQuery() {
                return "INSERT INTO `message_table` (`id`,`msg_key`,`sequence_number`,`sub_sequence_number`,`token`,`content`,`send_status`,`c_time`,`m_time`,`d_time`,`is_realtime_message`,`session_type`,`primary_id`,`secondary_id`,`third_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, MessageEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getMsgKey());
                statement.bindLong(3, entity.getSequenceNumber());
                statement.bindLong(4, entity.getSubsequenceNumber());
                String _tmpToken = entity.getToken();
                if (_tmpToken == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindText(5, _tmpToken);
                }
                statement.bindText(6, entity.getContent());
                statement.bindLong(7, entity.getSendStatus());
                Long _tmp = MessageDao_Impl.this.__instantConverter.instantToLong(entity.getCreateTime());
                if (_tmp != null) {
                    statement.bindLong(8, _tmp.longValue());
                } else {
                    statement.bindNull(8);
                }
                Long _tmp_1 = MessageDao_Impl.this.__instantConverter.instantToLong(entity.getUpdateTime());
                if (_tmp_1 != null) {
                    statement.bindLong(9, _tmp_1.longValue());
                } else {
                    statement.bindNull(9);
                }
                Instant _tmpDeleteTime = entity.getDeleteTime();
                Long _tmp_2 = MessageDao_Impl.this.__instantConverter.instantToLong(_tmpDeleteTime);
                if (_tmp_2 != null) {
                    statement.bindLong(10, _tmp_2.longValue());
                } else {
                    statement.bindNull(10);
                }
                statement.bindLong(11, entity.isRealtimeMessage() ? 1L : 0L);
                SessionIdEntity _tmpSessionId = entity.getSessionId();
                statement.bindLong(12, _tmpSessionId.getSessionType());
                statement.bindLong(13, _tmpSessionId.getPrimaryId());
                statement.bindLong(14, _tmpSessionId.getSecondaryId());
                statement.bindLong(15, _tmpSessionId.getThirdId());
            }
        }, new EntityDeleteOrUpdateAdapter<MessageEntity>() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl.2
            protected String createQuery() {
                return "UPDATE `message_table` SET `id` = ?,`msg_key` = ?,`sequence_number` = ?,`sub_sequence_number` = ?,`token` = ?,`content` = ?,`send_status` = ?,`c_time` = ?,`m_time` = ?,`d_time` = ?,`is_realtime_message` = ?,`session_type` = ?,`primary_id` = ?,`secondary_id` = ?,`third_id` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, MessageEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getMsgKey());
                statement.bindLong(3, entity.getSequenceNumber());
                statement.bindLong(4, entity.getSubsequenceNumber());
                String _tmpToken = entity.getToken();
                if (_tmpToken == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindText(5, _tmpToken);
                }
                statement.bindText(6, entity.getContent());
                statement.bindLong(7, entity.getSendStatus());
                Long _tmp = MessageDao_Impl.this.__instantConverter.instantToLong(entity.getCreateTime());
                if (_tmp != null) {
                    statement.bindLong(8, _tmp.longValue());
                } else {
                    statement.bindNull(8);
                }
                Long _tmp_1 = MessageDao_Impl.this.__instantConverter.instantToLong(entity.getUpdateTime());
                if (_tmp_1 != null) {
                    statement.bindLong(9, _tmp_1.longValue());
                } else {
                    statement.bindNull(9);
                }
                Instant _tmpDeleteTime = entity.getDeleteTime();
                Long _tmp_2 = MessageDao_Impl.this.__instantConverter.instantToLong(_tmpDeleteTime);
                if (_tmp_2 != null) {
                    statement.bindLong(10, _tmp_2.longValue());
                } else {
                    statement.bindNull(10);
                }
                statement.bindLong(11, entity.isRealtimeMessage() ? 1L : 0L);
                SessionIdEntity _tmpSessionId = entity.getSessionId();
                statement.bindLong(12, _tmpSessionId.getSessionType());
                statement.bindLong(13, _tmpSessionId.getPrimaryId());
                statement.bindLong(14, _tmpSessionId.getSecondaryId());
                statement.bindLong(15, _tmpSessionId.getThirdId());
                statement.bindLong(16, entity.getId());
            }
        });
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public /* bridge */ Object delete(SessionIdEntity sessionId, long msgKey, long sequenceNumber, long subsequenceNumber, Continuation<? super Unit> continuation) {
        return MessageDao.CC.delete$suspendImpl(this, sessionId, msgKey, sequenceNumber, subsequenceNumber, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public /* bridge */ Object query(SessionIdEntity sessionId, long msgKey, long sequenceNumber, long subsequenceNumber, Continuation<? super MessageEntity> continuation) {
        return MessageDao.CC.query$suspendImpl(this, sessionId, msgKey, sequenceNumber, subsequenceNumber, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public /* bridge */ Object update(SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, int sendStatus, long updateTime, Continuation<? super Integer> continuation) {
        return MessageDao.CC.update$suspendImpl(this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, sendStatus, updateTime, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public /* bridge */ Object update(SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, long newSequenceNumber, long newSubsequenceNumber, String content, int sendStatus, long updateTime, String token, Continuation<? super Integer> continuation) {
        return MessageDao.CC.update$suspendImpl(this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, newSequenceNumber, newSubsequenceNumber, content, sendStatus, updateTime, token, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public /* bridge */ Object update(SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, long updateTime, Long deleteTime, Continuation<? super Unit> continuation) {
        return MessageDao.CC.update$suspendImpl(this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, updateTime, deleteTime, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public /* bridge */ Object update(SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, String content, int sendStatus, long updateTime, Continuation<? super Integer> continuation) {
        return MessageDao.CC.update$suspendImpl(this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, content, sendStatus, updateTime, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public /* bridge */ Object update(SessionIdEntity forSessionId, long forMsgKey, long forSequenceNumber, long forSubsequenceNumber, String content, long updateTime, Continuation<? super Unit> continuation) {
        return MessageDao.CC.update$suspendImpl(this, forSessionId, forMsgKey, forSequenceNumber, forSubsequenceNumber, content, updateTime, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object upsertWithToken(MessageEntity message, Continuation<? super Unit> continuation) {
        Object performInTransactionSuspending = DBUtil.performInTransactionSuspending(this.__db, new MessageDao_Impl$upsertWithToken$2(this, message, null), continuation);
        return performInTransactionSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performInTransactionSuspending : Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object upsertWithToken(List<MessageEntity> list, Continuation<? super Unit> continuation) {
        Object performInTransactionSuspending = DBUtil.performInTransactionSuspending(this.__db, new MessageDao_Impl$upsertWithToken$4(this, list, null), continuation);
        return performInTransactionSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performInTransactionSuspending : Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object insert(final MessageEntity message, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit insert$lambda$0;
                insert$lambda$0 = MessageDao_Impl.insert$lambda$0(MessageDao_Impl.this, message, (SQLiteConnection) obj);
                return insert$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insert$lambda$0(MessageDao_Impl this$0, MessageEntity $message, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__upsertAdapterOfMessageEntity.upsert(_connection, $message);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object query(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, final long msgKey, final long sequenceNumber, final long subsequenceNumber, Continuation<? super MessageEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                MessageEntity query$lambda$0;
                query$lambda$0 = MessageDao_Impl.query$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, msgKey, sequenceNumber, subsequenceNumber, this, (SQLiteConnection) obj);
                return query$lambda$0;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageEntity query$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, long $msgKey, long $sequenceNumber, long $subsequenceNumber, MessageDao_Impl this$0, SQLiteConnection _connection) {
        MessageEntity _result;
        String _tmpToken;
        Long _tmp;
        Long _tmp2;
        Long _tmp_2;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            _stmt.bindLong(2, $primaryId);
            _stmt.bindLong(3, $secondaryId);
            _stmt.bindLong(4, $thirdId);
            _stmt.bindLong(5, $msgKey);
            _stmt.bindLong(6, $sequenceNumber);
            _stmt.bindLong(7, $subsequenceNumber);
            int _cursorIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, ReportBuildInParam.ID);
            int _cursorIndexOfMsgKey = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "msg_key");
            int _cursorIndexOfSequenceNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sequence_number");
            int _cursorIndexOfSubsequenceNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sub_sequence_number");
            int _cursorIndexOfToken = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "token");
            int _cursorIndexOfContent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "content");
            int _cursorIndexOfSendStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "send_status");
            int _cursorIndexOfCreateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "c_time");
            int _cursorIndexOfUpdateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "m_time");
            int _cursorIndexOfDeleteTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "d_time");
            int _cursorIndexOfIsRealtimeMessage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "is_realtime_message");
            int _cursorIndexOfSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "session_type");
            int _cursorIndexOfPrimaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "primary_id");
            int _cursorIndexOfSecondaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "secondary_id");
            int _cursorIndexOfThirdId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "third_id");
            if (_stmt.step()) {
                long _tmpId = _stmt.getLong(_cursorIndexOfId);
                long _tmpMsgKey = _stmt.getLong(_cursorIndexOfMsgKey);
                long _tmpSequenceNumber = _stmt.getLong(_cursorIndexOfSequenceNumber);
                long _tmpSubsequenceNumber = _stmt.getLong(_cursorIndexOfSubsequenceNumber);
                if (_stmt.isNull(_cursorIndexOfToken)) {
                    _tmpToken = null;
                } else {
                    _tmpToken = _stmt.getText(_cursorIndexOfToken);
                }
                String _tmpContent = _stmt.getText(_cursorIndexOfContent);
                int _tmpSendStatus = (int) _stmt.getLong(_cursorIndexOfSendStatus);
                if (_stmt.isNull(_cursorIndexOfCreateTime)) {
                    _tmp = null;
                } else {
                    Long _tmp3 = Long.valueOf(_stmt.getLong(_cursorIndexOfCreateTime));
                    _tmp = _tmp3;
                }
                Instant _tmp_1 = this$0.__instantConverter.longToInstant(_tmp);
                if (_tmp_1 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                }
                if (_stmt.isNull(_cursorIndexOfUpdateTime)) {
                    _tmp2 = null;
                } else {
                    Long _tmp_22 = Long.valueOf(_stmt.getLong(_cursorIndexOfUpdateTime));
                    _tmp2 = _tmp_22;
                }
                Instant _tmp_3 = this$0.__instantConverter.longToInstant(_tmp2);
                if (_tmp_3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                }
                if (_stmt.isNull(_cursorIndexOfDeleteTime)) {
                    _tmp_2 = null;
                } else {
                    Long _tmp_4 = Long.valueOf(_stmt.getLong(_cursorIndexOfDeleteTime));
                    _tmp_2 = _tmp_4;
                }
                Instant _tmpDeleteTime = this$0.__instantConverter.longToInstant(_tmp_2);
                int _tmp_5 = (int) _stmt.getLong(_cursorIndexOfIsRealtimeMessage);
                boolean _tmpIsRealtimeMessage = _tmp_5 != 0;
                int _tmpSessionType = (int) _stmt.getLong(_cursorIndexOfSessionType);
                long _tmpPrimaryId = _stmt.getLong(_cursorIndexOfPrimaryId);
                long _tmpSecondaryId = _stmt.getLong(_cursorIndexOfSecondaryId);
                long _tmpThirdId = _stmt.getLong(_cursorIndexOfThirdId);
                SessionIdEntity _tmpSessionId = new SessionIdEntity(_tmpSessionType, _tmpPrimaryId, _tmpSecondaryId, _tmpThirdId);
                _result = new MessageEntity(_tmpId, _tmpSessionId, _tmpMsgKey, _tmpSequenceNumber, _tmpSubsequenceNumber, _tmpToken, _tmpContent, _tmpSendStatus, _tmp_1, _tmp_3, _tmpDeleteTime, _tmpIsRealtimeMessage);
            } else {
                _result = null;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object query(final String token, Continuation<? super MessageEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                MessageEntity query$lambda$1;
                query$lambda$1 = MessageDao_Impl.query$lambda$1(r1, token, this, (SQLiteConnection) obj);
                return query$lambda$1;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageEntity query$lambda$1(String $_sql, String $token, MessageDao_Impl this$0, SQLiteConnection _connection) {
        MessageEntity _result;
        String _tmpToken;
        Long _tmp;
        Long _tmp2;
        Long _tmp_2;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindText(1, $token);
            int _cursorIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, ReportBuildInParam.ID);
            int _cursorIndexOfMsgKey = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "msg_key");
            int _cursorIndexOfSequenceNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sequence_number");
            int _cursorIndexOfSubsequenceNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sub_sequence_number");
            int _cursorIndexOfToken = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "token");
            int _cursorIndexOfContent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "content");
            int _cursorIndexOfSendStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "send_status");
            int _cursorIndexOfCreateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "c_time");
            int _cursorIndexOfUpdateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "m_time");
            int _cursorIndexOfDeleteTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "d_time");
            int _cursorIndexOfIsRealtimeMessage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "is_realtime_message");
            int _cursorIndexOfSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "session_type");
            int _cursorIndexOfPrimaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "primary_id");
            int _cursorIndexOfSecondaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "secondary_id");
            int _cursorIndexOfThirdId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "third_id");
            if (_stmt.step()) {
                long _tmpId = _stmt.getLong(_cursorIndexOfId);
                long _tmpMsgKey = _stmt.getLong(_cursorIndexOfMsgKey);
                long _tmpSequenceNumber = _stmt.getLong(_cursorIndexOfSequenceNumber);
                long _tmpSubsequenceNumber = _stmt.getLong(_cursorIndexOfSubsequenceNumber);
                if (_stmt.isNull(_cursorIndexOfToken)) {
                    _tmpToken = null;
                } else {
                    _tmpToken = _stmt.getText(_cursorIndexOfToken);
                }
                String _tmpContent = _stmt.getText(_cursorIndexOfContent);
                int _tmpSendStatus = (int) _stmt.getLong(_cursorIndexOfSendStatus);
                if (_stmt.isNull(_cursorIndexOfCreateTime)) {
                    _tmp = null;
                } else {
                    Long _tmp3 = Long.valueOf(_stmt.getLong(_cursorIndexOfCreateTime));
                    _tmp = _tmp3;
                }
                Instant _tmp_1 = this$0.__instantConverter.longToInstant(_tmp);
                if (_tmp_1 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                }
                if (_stmt.isNull(_cursorIndexOfUpdateTime)) {
                    _tmp2 = null;
                } else {
                    Long _tmp_22 = Long.valueOf(_stmt.getLong(_cursorIndexOfUpdateTime));
                    _tmp2 = _tmp_22;
                }
                Instant _tmp_3 = this$0.__instantConverter.longToInstant(_tmp2);
                if (_tmp_3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                }
                if (_stmt.isNull(_cursorIndexOfDeleteTime)) {
                    _tmp_2 = null;
                } else {
                    Long _tmp_4 = Long.valueOf(_stmt.getLong(_cursorIndexOfDeleteTime));
                    _tmp_2 = _tmp_4;
                }
                Instant _tmpDeleteTime = this$0.__instantConverter.longToInstant(_tmp_2);
                int _tmp_5 = (int) _stmt.getLong(_cursorIndexOfIsRealtimeMessage);
                boolean _tmpIsRealtimeMessage = _tmp_5 != 0;
                int _tmpSessionType = (int) _stmt.getLong(_cursorIndexOfSessionType);
                long _tmpPrimaryId = _stmt.getLong(_cursorIndexOfPrimaryId);
                long _tmpSecondaryId = _stmt.getLong(_cursorIndexOfSecondaryId);
                long _tmpThirdId = _stmt.getLong(_cursorIndexOfThirdId);
                SessionIdEntity _tmpSessionId = new SessionIdEntity(_tmpSessionType, _tmpPrimaryId, _tmpSecondaryId, _tmpThirdId);
                _result = new MessageEntity(_tmpId, _tmpSessionId, _tmpMsgKey, _tmpSequenceNumber, _tmpSubsequenceNumber, _tmpToken, _tmpContent, _tmpSendStatus, _tmp_1, _tmp_3, _tmpDeleteTime, _tmpIsRealtimeMessage);
            } else {
                _result = null;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object queryLaterSequenceNumberInRange(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, final long start, final long end, final int limit, Continuation<? super List<Long>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                List queryLaterSequenceNumberInRange$lambda$0;
                queryLaterSequenceNumberInRange$lambda$0 = MessageDao_Impl.queryLaterSequenceNumberInRange$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, start, end, limit, (SQLiteConnection) obj);
                return queryLaterSequenceNumberInRange$lambda$0;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List queryLaterSequenceNumberInRange$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, long $start, long $end, int $limit, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            try {
                _stmt.bindLong(2, $primaryId);
                try {
                    _stmt.bindLong(3, $secondaryId);
                    try {
                        _stmt.bindLong(4, $thirdId);
                        try {
                            _stmt.bindLong(5, $start);
                        } catch (Throwable th) {
                            th = th;
                            _stmt.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        _stmt.close();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    _stmt.close();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            _stmt.bindLong(6, $end);
            try {
                _stmt.bindLong(7, $limit);
                List _result = new ArrayList();
                while (_stmt.step()) {
                    long _item = _stmt.getLong(0);
                    _result.add(Long.valueOf(_item));
                }
                _stmt.close();
                return _result;
            } catch (Throwable th6) {
                th = th6;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            _stmt.close();
            throw th;
        }
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object all(Continuation<? super List<MessageEntity>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                List all$lambda$0;
                all$lambda$0 = MessageDao_Impl.all$lambda$0(r1, this, (SQLiteConnection) obj);
                return all$lambda$0;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List all$lambda$0(String $_sql, MessageDao_Impl this$0, SQLiteConnection _connection) {
        String _tmpToken;
        int _cursorIndexOfId;
        Long _tmp;
        Long _tmp2;
        Long _tmp_2;
        MessageDao_Impl messageDao_Impl = this$0;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            int _cursorIndexOfId2 = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, ReportBuildInParam.ID);
            int _tmpSendStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "msg_key");
            int _cursorIndexOfSequenceNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sequence_number");
            int _cursorIndexOfSubsequenceNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sub_sequence_number");
            int _cursorIndexOfToken = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "token");
            int _cursorIndexOfContent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "content");
            int _cursorIndexOfSendStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "send_status");
            int _cursorIndexOfCreateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "c_time");
            int _cursorIndexOfUpdateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "m_time");
            int _cursorIndexOfDeleteTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "d_time");
            int _cursorIndexOfIsRealtimeMessage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "is_realtime_message");
            int _cursorIndexOfSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "session_type");
            int _cursorIndexOfPrimaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "primary_id");
            int _tmpSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "secondary_id");
            int _cursorIndexOfThirdId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "third_id");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_cursorIndexOfId2);
                long _tmpMsgKey = _stmt.getLong(_tmpSendStatus);
                long _tmpSequenceNumber = _stmt.getLong(_cursorIndexOfSequenceNumber);
                long _tmpSubsequenceNumber = _stmt.getLong(_cursorIndexOfSubsequenceNumber);
                if (_stmt.isNull(_cursorIndexOfToken)) {
                    _tmpToken = null;
                } else {
                    _tmpToken = _stmt.getText(_cursorIndexOfToken);
                }
                String _tmpContent = _stmt.getText(_cursorIndexOfContent);
                int _cursorIndexOfMsgKey = _tmpSendStatus;
                int _cursorIndexOfSequenceNumber2 = _cursorIndexOfSequenceNumber;
                int _tmpSendStatus2 = (int) _stmt.getLong(_cursorIndexOfSendStatus);
                if (_stmt.isNull(_cursorIndexOfCreateTime)) {
                    _cursorIndexOfId = _cursorIndexOfId2;
                    _tmp = null;
                } else {
                    Long _tmp3 = Long.valueOf(_stmt.getLong(_cursorIndexOfCreateTime));
                    _cursorIndexOfId = _cursorIndexOfId2;
                    _tmp = _tmp3;
                }
                Instant _tmp_1 = messageDao_Impl.__instantConverter.longToInstant(_tmp);
                if (_tmp_1 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                }
                if (_stmt.isNull(_cursorIndexOfUpdateTime)) {
                    _tmp2 = null;
                } else {
                    Long _tmp_22 = Long.valueOf(_stmt.getLong(_cursorIndexOfUpdateTime));
                    _tmp2 = _tmp_22;
                }
                Instant _tmp_3 = messageDao_Impl.__instantConverter.longToInstant(_tmp2);
                if (_tmp_3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                }
                if (_stmt.isNull(_cursorIndexOfDeleteTime)) {
                    _tmp_2 = null;
                } else {
                    Long _tmp_4 = Long.valueOf(_stmt.getLong(_cursorIndexOfDeleteTime));
                    _tmp_2 = _tmp_4;
                }
                Instant _tmpDeleteTime = messageDao_Impl.__instantConverter.longToInstant(_tmp_2);
                int _tmp_5 = (int) _stmt.getLong(_cursorIndexOfIsRealtimeMessage);
                boolean _tmpIsRealtimeMessage = _tmp_5 != 0;
                int _tmpSessionType2 = (int) _stmt.getLong(_cursorIndexOfSessionType);
                long _tmpPrimaryId = _stmt.getLong(_cursorIndexOfPrimaryId);
                int _cursorIndexOfSecondaryId = _tmpSessionType;
                long _tmpSecondaryId = _stmt.getLong(_cursorIndexOfSecondaryId);
                long _tmpThirdId = _stmt.getLong(_cursorIndexOfThirdId);
                SessionIdEntity _tmpSessionId = new SessionIdEntity(_tmpSessionType2, _tmpPrimaryId, _tmpSecondaryId, _tmpThirdId);
                MessageEntity _item = new MessageEntity(_tmpId, _tmpSessionId, _tmpMsgKey, _tmpSequenceNumber, _tmpSubsequenceNumber, _tmpToken, _tmpContent, _tmpSendStatus2, _tmp_1, _tmp_3, _tmpDeleteTime, _tmpIsRealtimeMessage);
                List _result2 = _result;
                _result2.add(_item);
                _result = _result2;
                _tmpSessionType = _cursorIndexOfSecondaryId;
                _tmpSendStatus = _cursorIndexOfMsgKey;
                _cursorIndexOfSequenceNumber = _cursorIndexOfSequenceNumber2;
                _cursorIndexOfId2 = _cursorIndexOfId;
                messageDao_Impl = this$0;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object delete(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, final long msgKey, final long sequenceNumber, final long subsequenceNumber, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit delete$lambda$0;
                delete$lambda$0 = MessageDao_Impl.delete$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, msgKey, sequenceNumber, subsequenceNumber, (SQLiteConnection) obj);
                return delete$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, long $msgKey, long $sequenceNumber, long $subsequenceNumber, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            try {
                _stmt.bindLong(2, $primaryId);
                try {
                    _stmt.bindLong(3, $secondaryId);
                    try {
                        _stmt.bindLong(4, $thirdId);
                        try {
                            _stmt.bindLong(5, $msgKey);
                            try {
                                _stmt.bindLong(6, $sequenceNumber);
                                try {
                                    _stmt.bindLong(7, $subsequenceNumber);
                                    _stmt.step();
                                    _stmt.close();
                                    return Unit.INSTANCE;
                                } catch (Throwable th) {
                                    th = th;
                                    _stmt.close();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                _stmt.close();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            _stmt.close();
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        _stmt.close();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    _stmt.close();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object deleteAllMessages(Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit deleteAllMessages$lambda$0;
                deleteAllMessages$lambda$0 = MessageDao_Impl.deleteAllMessages$lambda$0(r1, (SQLiteConnection) obj);
                return deleteAllMessages$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteAllMessages$lambda$0(String $_sql, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object update(final int forSessionType, final long forPrimaryId, final long forSecondaryId, final long forThirdId, final long forMsgKey, final long forSequenceNumber, final long forSubsequenceNumber, final int sendStatus, final long updateTime, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                int update$lambda$0;
                update$lambda$0 = MessageDao_Impl.update$lambda$0(r4, sendStatus, updateTime, forSessionType, forPrimaryId, forSecondaryId, forThirdId, forMsgKey, forSequenceNumber, forSubsequenceNumber, (SQLiteConnection) obj);
                return Integer.valueOf(update$lambda$0);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int update$lambda$0(String $_sql, int $sendStatus, long $updateTime, int $forSessionType, long $forPrimaryId, long $forSecondaryId, long $forThirdId, long $forMsgKey, long $forSequenceNumber, long $forSubsequenceNumber, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sendStatus);
        } catch (Throwable th) {
            th = th;
        }
        try {
            _stmt.bindLong(2, $updateTime);
            try {
                _stmt.bindLong(3, $forSessionType);
                try {
                    _stmt.bindLong(4, $forPrimaryId);
                    try {
                        _stmt.bindLong(5, $forSecondaryId);
                        try {
                            _stmt.bindLong(6, $forThirdId);
                            try {
                                _stmt.bindLong(7, $forMsgKey);
                                _stmt.bindLong(8, $forSequenceNumber);
                                try {
                                    _stmt.bindLong(9, $forSubsequenceNumber);
                                    _stmt.step();
                                    int totalChangedRows = SQLiteConnectionUtil.getTotalChangedRows(_connection);
                                    _stmt.close();
                                    return totalChangedRows;
                                } catch (Throwable th2) {
                                    th = th2;
                                    _stmt.close();
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                _stmt.close();
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            _stmt.close();
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        _stmt.close();
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    _stmt.close();
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            _stmt.close();
            throw th;
        }
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object update(final int forSessionType, final long forPrimaryId, final long forSecondaryId, final long forThirdId, final long forMsgKey, final long forSequenceNumber, final long forSubsequenceNumber, final String content, final int sendStatus, final long updateTime, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                int update$lambda$1;
                update$lambda$1 = MessageDao_Impl.update$lambda$1(r4, sendStatus, content, updateTime, forSessionType, forPrimaryId, forSecondaryId, forThirdId, forMsgKey, forSequenceNumber, forSubsequenceNumber, (SQLiteConnection) obj);
                return Integer.valueOf(update$lambda$1);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int update$lambda$1(String $_sql, int $sendStatus, String $content, long $updateTime, int $forSessionType, long $forPrimaryId, long $forSecondaryId, long $forThirdId, long $forMsgKey, long $forSequenceNumber, long $forSubsequenceNumber, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sendStatus);
            try {
                _stmt.bindText(2, $content);
                try {
                    _stmt.bindLong(3, $updateTime);
                    try {
                        _stmt.bindLong(4, $forSessionType);
                        try {
                            _stmt.bindLong(5, $forPrimaryId);
                        } catch (Throwable th) {
                            th = th;
                            _stmt.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        _stmt.close();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    _stmt.close();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            _stmt.bindLong(6, $forSecondaryId);
            try {
                _stmt.bindLong(7, $forThirdId);
                _stmt.bindLong(8, $forMsgKey);
                _stmt.bindLong(9, $forSequenceNumber);
                try {
                    _stmt.bindLong(10, $forSubsequenceNumber);
                    _stmt.step();
                    int totalChangedRows = SQLiteConnectionUtil.getTotalChangedRows(_connection);
                    _stmt.close();
                    return totalChangedRows;
                } catch (Throwable th6) {
                    th = th6;
                    _stmt.close();
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            _stmt.close();
            throw th;
        }
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object update(final int forSessionType, final long forPrimaryId, final long forSecondaryId, final long forThirdId, final long forMsgKey, final long forSequenceNumber, final long forSubsequenceNumber, final long newSequenceNumber, final long newSubsequenceNumber, final String content, final int sendStatus, final long updateTime, final String token, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                int update$lambda$2;
                update$lambda$2 = MessageDao_Impl.update$lambda$2(r4, sendStatus, content, updateTime, newSequenceNumber, newSubsequenceNumber, token, forSessionType, forPrimaryId, forSecondaryId, forThirdId, forMsgKey, forSequenceNumber, forSubsequenceNumber, (SQLiteConnection) obj);
                return Integer.valueOf(update$lambda$2);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int update$lambda$2(String $_sql, int $sendStatus, String $content, long $updateTime, long $newSequenceNumber, long $newSubsequenceNumber, String $token, int $forSessionType, long $forPrimaryId, long $forSecondaryId, long $forThirdId, long $forMsgKey, long $forSequenceNumber, long $forSubsequenceNumber, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sendStatus);
            try {
                _stmt.bindText(2, $content);
            } catch (Throwable th) {
                th = th;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            _stmt.bindLong(3, $updateTime);
            try {
                _stmt.bindLong(4, $newSequenceNumber);
                try {
                    _stmt.bindLong(5, $newSubsequenceNumber);
                    if ($token == null) {
                        _stmt.bindNull(6);
                    } else {
                        _stmt.bindText(6, $token);
                    }
                    try {
                        _stmt.bindLong(7, $forSessionType);
                        try {
                            _stmt.bindLong(8, $forPrimaryId);
                            _stmt.bindLong(9, $forSecondaryId);
                            _stmt.bindLong(10, $forThirdId);
                            _stmt.bindLong(11, $forMsgKey);
                            _stmt.bindLong(12, $forSequenceNumber);
                            try {
                                _stmt.bindLong(13, $forSubsequenceNumber);
                                _stmt.step();
                                int totalChangedRows = SQLiteConnectionUtil.getTotalChangedRows(_connection);
                                _stmt.close();
                                return totalChangedRows;
                            } catch (Throwable th3) {
                                th = th3;
                                _stmt.close();
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            _stmt.close();
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        _stmt.close();
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    _stmt.close();
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            _stmt.close();
            throw th;
        }
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object update(final int forSessionType, final long forPrimaryId, final long forSecondaryId, final long forThirdId, final long forMsgKey, final long forSequenceNumber, final long forSubsequenceNumber, final String content, final long updateTime, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit update$lambda$3;
                update$lambda$3 = MessageDao_Impl.update$lambda$3(r4, content, updateTime, forSessionType, forPrimaryId, forSecondaryId, forThirdId, forMsgKey, forSequenceNumber, forSubsequenceNumber, (SQLiteConnection) obj);
                return update$lambda$3;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit update$lambda$3(String $_sql, String $content, long $updateTime, int $forSessionType, long $forPrimaryId, long $forSecondaryId, long $forThirdId, long $forMsgKey, long $forSequenceNumber, long $forSubsequenceNumber, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindText(1, $content);
            try {
                _stmt.bindLong(2, $updateTime);
                try {
                    _stmt.bindLong(3, $forSessionType);
                    try {
                        _stmt.bindLong(4, $forPrimaryId);
                        try {
                            _stmt.bindLong(5, $forSecondaryId);
                            try {
                                _stmt.bindLong(6, $forThirdId);
                                try {
                                    _stmt.bindLong(7, $forMsgKey);
                                    _stmt.bindLong(8, $forSequenceNumber);
                                    try {
                                        _stmt.bindLong(9, $forSubsequenceNumber);
                                        _stmt.step();
                                        _stmt.close();
                                        return Unit.INSTANCE;
                                    } catch (Throwable th) {
                                        th = th;
                                        _stmt.close();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    _stmt.close();
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                _stmt.close();
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            _stmt.close();
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        _stmt.close();
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    _stmt.close();
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    @Override // kntr.app.im.chat.db.dao.MessageDao
    public Object update(final int forSessionType, final long forPrimaryId, final long forSecondaryId, final long forThirdId, final long forMsgKey, final long forSequenceNumber, final long forSubsequenceNumber, final long updateTime, final Long deleteTime, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.MessageDao_Impl$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit update$lambda$4;
                update$lambda$4 = MessageDao_Impl.update$lambda$4(r4, deleteTime, updateTime, forSessionType, forPrimaryId, forSecondaryId, forThirdId, forMsgKey, forSequenceNumber, forSubsequenceNumber, (SQLiteConnection) obj);
                return update$lambda$4;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit update$lambda$4(String $_sql, Long $deleteTime, long $updateTime, int $forSessionType, long $forPrimaryId, long $forSecondaryId, long $forThirdId, long $forMsgKey, long $forSequenceNumber, long $forSubsequenceNumber, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            if ($deleteTime != null) {
                _stmt.bindLong(1, $deleteTime.longValue());
            } else {
                _stmt.bindNull(1);
            }
            try {
                _stmt.bindLong(2, $updateTime);
                try {
                    _stmt.bindLong(3, $forSessionType);
                    try {
                        _stmt.bindLong(4, $forPrimaryId);
                    } catch (Throwable th) {
                        th = th;
                        _stmt.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    _stmt.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        try {
            _stmt.bindLong(5, $forSecondaryId);
            try {
                _stmt.bindLong(6, $forThirdId);
                try {
                    _stmt.bindLong(7, $forMsgKey);
                    _stmt.bindLong(8, $forSequenceNumber);
                    try {
                        _stmt.bindLong(9, $forSubsequenceNumber);
                        _stmt.step();
                        _stmt.close();
                        return Unit.INSTANCE;
                    } catch (Throwable th5) {
                        th = th5;
                        _stmt.close();
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    _stmt.close();
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            _stmt.close();
            throw th;
        }
    }

    /* compiled from: MessageDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/db/dao/MessageDao_Impl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "getRequiredConverters", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}