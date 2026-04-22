package kntr.app.im.chat.db.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
import kntr.app.im.chat.db.converter.InstantConverter;
import kntr.app.im.chat.db.dao.PushInfoMessageDao;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.im.chat.db.entity.SessionPushInfoMessage;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.datetime.Instant;

/* compiled from: PushInfoMessageDao_Impl.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0017J0\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkntr/app/im/chat/db/dao/PushInfoMessageDao_Impl;", "Lkntr/app/im/chat/db/dao/PushInfoMessageDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfMessageEntity", "Landroidx/room/EntityInsertAdapter;", "Lkntr/app/im/chat/db/entity/MessageEntity;", "__instantConverter", "Lkntr/app/im/chat/db/converter/InstantConverter;", "__upsertAdapterOfSessionPushInfoMessage", "Landroidx/room/EntityUpsertAdapter;", "Lkntr/app/im/chat/db/entity/SessionPushInfoMessage;", "insertPushInfoMessage", RoomRecommendViewModel.EMPTY_CURSOR, "pushInfoMessage", "(Lkntr/app/im/chat/db/entity/MessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePhaseOnePushInfoMessage", "pushInfoRecord", "(Lkntr/app/im/chat/db/entity/SessionPushInfoMessage;Lkntr/app/im/chat/db/entity/MessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePhaseTwoPushInfoMessage", "insertPushInfoRecord", "(Lkntr/app/im/chat/db/entity/SessionPushInfoMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPushInfo", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", "secondaryId", "thirdId", "(IJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PushInfoMessageDao_Impl implements PushInfoMessageDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<MessageEntity> __insertAdapterOfMessageEntity;
    private final InstantConverter __instantConverter;
    private final EntityUpsertAdapter<SessionPushInfoMessage> __upsertAdapterOfSessionPushInfoMessage;

    public PushInfoMessageDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__instantConverter = new InstantConverter();
        this.__db = __db;
        this.__insertAdapterOfMessageEntity = new EntityInsertAdapter<MessageEntity>() { // from class: kntr.app.im.chat.db.dao.PushInfoMessageDao_Impl.1
            protected String createQuery() {
                return "INSERT OR ABORT INTO `message_table` (`id`,`msg_key`,`sequence_number`,`sub_sequence_number`,`token`,`content`,`send_status`,`c_time`,`m_time`,`d_time`,`is_realtime_message`,`session_type`,`primary_id`,`secondary_id`,`third_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                Long _tmp = PushInfoMessageDao_Impl.this.__instantConverter.instantToLong(entity.getCreateTime());
                if (_tmp != null) {
                    statement.bindLong(8, _tmp.longValue());
                } else {
                    statement.bindNull(8);
                }
                Long _tmp_1 = PushInfoMessageDao_Impl.this.__instantConverter.instantToLong(entity.getUpdateTime());
                if (_tmp_1 != null) {
                    statement.bindLong(9, _tmp_1.longValue());
                } else {
                    statement.bindNull(9);
                }
                Instant _tmpDeleteTime = entity.getDeleteTime();
                Long _tmp_2 = PushInfoMessageDao_Impl.this.__instantConverter.instantToLong(_tmpDeleteTime);
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
        };
        this.__upsertAdapterOfSessionPushInfoMessage = new EntityUpsertAdapter<>(new EntityInsertAdapter<SessionPushInfoMessage>() { // from class: kntr.app.im.chat.db.dao.PushInfoMessageDao_Impl.2
            protected String createQuery() {
                return "INSERT INTO `session_push_info` (`phase_one`,`session_type`,`primary_id`,`secondary_id`,`third_id`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, SessionPushInfoMessage entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                Long _tmpPhaseOneId = entity.getPhaseOneId();
                if (_tmpPhaseOneId != null) {
                    statement.bindLong(1, _tmpPhaseOneId.longValue());
                } else {
                    statement.bindNull(1);
                }
                SessionIdEntity _tmpSessionId = entity.getSessionId();
                statement.bindLong(2, _tmpSessionId.getSessionType());
                statement.bindLong(3, _tmpSessionId.getPrimaryId());
                statement.bindLong(4, _tmpSessionId.getSecondaryId());
                statement.bindLong(5, _tmpSessionId.getThirdId());
            }
        }, new EntityDeleteOrUpdateAdapter<SessionPushInfoMessage>() { // from class: kntr.app.im.chat.db.dao.PushInfoMessageDao_Impl.3
            protected String createQuery() {
                return "UPDATE `session_push_info` SET `phase_one` = ?,`session_type` = ?,`primary_id` = ?,`secondary_id` = ?,`third_id` = ? WHERE `session_type` = ? AND `primary_id` = ? AND `secondary_id` = ? AND `third_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, SessionPushInfoMessage entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                Long _tmpPhaseOneId = entity.getPhaseOneId();
                if (_tmpPhaseOneId != null) {
                    statement.bindLong(1, _tmpPhaseOneId.longValue());
                } else {
                    statement.bindNull(1);
                }
                SessionIdEntity _tmpSessionId = entity.getSessionId();
                statement.bindLong(2, _tmpSessionId.getSessionType());
                statement.bindLong(3, _tmpSessionId.getPrimaryId());
                statement.bindLong(4, _tmpSessionId.getSecondaryId());
                statement.bindLong(5, _tmpSessionId.getThirdId());
                SessionIdEntity _tmpSessionId_1 = entity.getSessionId();
                statement.bindLong(6, _tmpSessionId_1.getSessionType());
                statement.bindLong(7, _tmpSessionId_1.getPrimaryId());
                statement.bindLong(8, _tmpSessionId_1.getSecondaryId());
                statement.bindLong(9, _tmpSessionId_1.getThirdId());
            }
        });
    }

    @Override // kntr.app.im.chat.db.dao.PushInfoMessageDao
    public /* bridge */ Object getPushInfo(SessionIdEntity sessionIdEntity, Continuation<? super SessionPushInfoMessage> continuation) {
        return PushInfoMessageDao.CC.getPushInfo$suspendImpl(this, sessionIdEntity, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.PushInfoMessageDao
    public Object insertPushInfoMessage(final MessageEntity pushInfoMessage, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.PushInfoMessageDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                long insertPushInfoMessage$lambda$0;
                insertPushInfoMessage$lambda$0 = PushInfoMessageDao_Impl.insertPushInfoMessage$lambda$0(PushInfoMessageDao_Impl.this, pushInfoMessage, (SQLiteConnection) obj);
                return Long.valueOf(insertPushInfoMessage$lambda$0);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertPushInfoMessage$lambda$0(PushInfoMessageDao_Impl this$0, MessageEntity $pushInfoMessage, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__insertAdapterOfMessageEntity.insertAndReturnId(_connection, $pushInfoMessage);
        return _result;
    }

    @Override // kntr.app.im.chat.db.dao.PushInfoMessageDao
    public Object savePhaseOnePushInfoMessage(SessionPushInfoMessage pushInfoRecord, MessageEntity pushInfoMessage, Continuation<? super Long> continuation) {
        return DBUtil.performInTransactionSuspending(this.__db, new PushInfoMessageDao_Impl$savePhaseOnePushInfoMessage$2(this, pushInfoRecord, pushInfoMessage, null), continuation);
    }

    @Override // kntr.app.im.chat.db.dao.PushInfoMessageDao
    public Object savePhaseTwoPushInfoMessage(SessionPushInfoMessage pushInfoRecord, MessageEntity pushInfoMessage, Continuation<? super Long> continuation) {
        return DBUtil.performInTransactionSuspending(this.__db, new PushInfoMessageDao_Impl$savePhaseTwoPushInfoMessage$2(this, pushInfoRecord, pushInfoMessage, null), continuation);
    }

    @Override // kntr.app.im.chat.db.dao.PushInfoMessageDao
    public Object insertPushInfoRecord(final SessionPushInfoMessage pushInfoRecord, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.PushInfoMessageDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                long insertPushInfoRecord$lambda$0;
                insertPushInfoRecord$lambda$0 = PushInfoMessageDao_Impl.insertPushInfoRecord$lambda$0(PushInfoMessageDao_Impl.this, pushInfoRecord, (SQLiteConnection) obj);
                return Long.valueOf(insertPushInfoRecord$lambda$0);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertPushInfoRecord$lambda$0(PushInfoMessageDao_Impl this$0, SessionPushInfoMessage $pushInfoRecord, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        long _result = this$0.__upsertAdapterOfSessionPushInfoMessage.upsertAndReturnId(_connection, $pushInfoRecord);
        return _result;
    }

    @Override // kntr.app.im.chat.db.dao.PushInfoMessageDao
    public Object getPushInfo(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, Continuation<? super SessionPushInfoMessage> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: kntr.app.im.chat.db.dao.PushInfoMessageDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                SessionPushInfoMessage pushInfo$lambda$0;
                pushInfo$lambda$0 = PushInfoMessageDao_Impl.getPushInfo$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, (SQLiteConnection) obj);
                return pushInfo$lambda$0;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionPushInfoMessage getPushInfo$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, SQLiteConnection _connection) {
        SessionPushInfoMessage _result;
        Long _tmpPhaseOneId;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            try {
                _stmt.bindLong(2, $primaryId);
                try {
                    _stmt.bindLong(3, $secondaryId);
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
        }
        try {
            _stmt.bindLong(4, $thirdId);
            int _cursorIndexOfPhaseOneId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "phase_one");
            int _cursorIndexOfSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "session_type");
            int _cursorIndexOfPrimaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "primary_id");
            int _cursorIndexOfSecondaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "secondary_id");
            int _cursorIndexOfThirdId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "third_id");
            if (_stmt.step()) {
                if (_stmt.isNull(_cursorIndexOfPhaseOneId)) {
                    _tmpPhaseOneId = null;
                } else {
                    Long _tmpPhaseOneId2 = Long.valueOf(_stmt.getLong(_cursorIndexOfPhaseOneId));
                    _tmpPhaseOneId = _tmpPhaseOneId2;
                }
                int _tmpSessionType = (int) _stmt.getLong(_cursorIndexOfSessionType);
                long _tmpPrimaryId = _stmt.getLong(_cursorIndexOfPrimaryId);
                long _tmpSecondaryId = _stmt.getLong(_cursorIndexOfSecondaryId);
                long _tmpThirdId = _stmt.getLong(_cursorIndexOfThirdId);
                SessionIdEntity _tmpSessionId = new SessionIdEntity(_tmpSessionType, _tmpPrimaryId, _tmpSecondaryId, _tmpThirdId);
                _result = new SessionPushInfoMessage(_tmpSessionId, _tmpPhaseOneId);
            } else {
                _result = null;
            }
            _stmt.close();
            return _result;
        } catch (Throwable th4) {
            th = th4;
            _stmt.close();
            throw th;
        }
    }

    /* compiled from: PushInfoMessageDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/db/dao/PushInfoMessageDao_Impl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "getRequiredConverters", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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