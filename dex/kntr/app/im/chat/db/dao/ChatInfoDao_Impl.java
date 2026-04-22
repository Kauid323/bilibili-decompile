package kntr.app.im.chat.db.dao;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
import kntr.app.im.chat.db.dao.ChatInfoDao;
import kntr.app.im.chat.db.entity.ChatInfoEntity;
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

/* compiled from: ChatInfoDao_Impl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\fJ0\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0013J>\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkntr/app/im/chat/db/dao/ChatInfoDao_Impl;", "Lkntr/app/im/chat/db/dao/ChatInfoDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfChatInfoEntity", "Landroidx/room/EntityInsertAdapter;", "Lkntr/app/im/chat/db/entity/ChatInfoEntity;", "insertOrReplace", RoomRecommendViewModel.EMPTY_CURSOR, "chatInfo", "(Lkntr/app/im/chat/db/entity/ChatInfoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "(IJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateChatInfo", "content", RoomRecommendViewModel.EMPTY_CURSOR, "updateTime", "(IJJJLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllChatInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatInfoDao_Impl implements ChatInfoDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<ChatInfoEntity> __insertAdapterOfChatInfoEntity;

    public ChatInfoDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfChatInfoEntity = new EntityInsertAdapter<ChatInfoEntity>() { // from class: kntr.app.im.chat.db.dao.ChatInfoDao_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `chat_info_table` (`content`,`c_time`,`m_time`,`session_type`,`primary_id`,`secondary_id`,`third_id`) VALUES (?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, ChatInfoEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindText(1, entity.getContent());
                statement.bindLong(2, entity.getCreateTime());
                statement.bindLong(3, entity.getUpdateTime());
                SessionIdEntity _tmpSessionId = entity.getSessionId();
                statement.bindLong(4, _tmpSessionId.getSessionType());
                statement.bindLong(5, _tmpSessionId.getPrimaryId());
                statement.bindLong(6, _tmpSessionId.getSecondaryId());
                statement.bindLong(7, _tmpSessionId.getThirdId());
            }
        };
    }

    @Override // kntr.app.im.chat.db.dao.ChatInfoDao
    public /* bridge */ Object chatInfo(SessionIdEntity sessionId, Continuation<? super ChatInfoEntity> continuation) {
        return ChatInfoDao.CC.chatInfo$suspendImpl(this, sessionId, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.ChatInfoDao
    public /* bridge */ Object updateChatInfo(SessionIdEntity sessionId, String content, long updateTime, Continuation<? super Unit> continuation) {
        return ChatInfoDao.CC.updateChatInfo$suspendImpl(this, sessionId, content, updateTime, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.ChatInfoDao
    public Object insertOrReplace(final ChatInfoEntity chatInfo, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.ChatInfoDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit insertOrReplace$lambda$0;
                insertOrReplace$lambda$0 = ChatInfoDao_Impl.insertOrReplace$lambda$0(ChatInfoDao_Impl.this, chatInfo, (SQLiteConnection) obj);
                return insertOrReplace$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertOrReplace$lambda$0(ChatInfoDao_Impl this$0, ChatInfoEntity $chatInfo, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__insertAdapterOfChatInfoEntity.insert(_connection, $chatInfo);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.db.dao.ChatInfoDao
    public Object chatInfo(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, Continuation<? super ChatInfoEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: kntr.app.im.chat.db.dao.ChatInfoDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                ChatInfoEntity chatInfo$lambda$0;
                chatInfo$lambda$0 = ChatInfoDao_Impl.chatInfo$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, (SQLiteConnection) obj);
                return chatInfo$lambda$0;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatInfoEntity chatInfo$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, SQLiteConnection _connection) {
        ChatInfoEntity _result;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            _stmt.bindLong(2, $primaryId);
            try {
                _stmt.bindLong(3, $secondaryId);
                try {
                    _stmt.bindLong(4, $thirdId);
                    int _cursorIndexOfContent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "content");
                    int _cursorIndexOfCreateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "c_time");
                    int _cursorIndexOfUpdateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "m_time");
                    int _cursorIndexOfSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "session_type");
                    int _cursorIndexOfPrimaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "primary_id");
                    int _cursorIndexOfSecondaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "secondary_id");
                    int _cursorIndexOfThirdId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "third_id");
                    if (_stmt.step()) {
                        String _tmpContent = _stmt.getText(_cursorIndexOfContent);
                        long _tmpCreateTime = _stmt.getLong(_cursorIndexOfCreateTime);
                        long _tmpUpdateTime = _stmt.getLong(_cursorIndexOfUpdateTime);
                        int _tmpSessionType = (int) _stmt.getLong(_cursorIndexOfSessionType);
                        long _tmpPrimaryId = _stmt.getLong(_cursorIndexOfPrimaryId);
                        long _tmpSecondaryId = _stmt.getLong(_cursorIndexOfSecondaryId);
                        long _tmpThirdId = _stmt.getLong(_cursorIndexOfThirdId);
                        SessionIdEntity _tmpSessionId = new SessionIdEntity(_tmpSessionType, _tmpPrimaryId, _tmpSecondaryId, _tmpThirdId);
                        _result = new ChatInfoEntity(_tmpSessionId, _tmpContent, _tmpCreateTime, _tmpUpdateTime);
                    } else {
                        _result = null;
                    }
                    _stmt.close();
                    return _result;
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
    }

    @Override // kntr.app.im.chat.db.dao.ChatInfoDao
    public Object updateChatInfo(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, final String content, final long updateTime, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.ChatInfoDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit updateChatInfo$lambda$0;
                updateChatInfo$lambda$0 = ChatInfoDao_Impl.updateChatInfo$lambda$0(r1, content, updateTime, sessionType, primaryId, secondaryId, thirdId, (SQLiteConnection) obj);
                return updateChatInfo$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateChatInfo$lambda$0(String $_sql, String $content, long $updateTime, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindText(1, $content);
            _stmt.bindLong(2, $updateTime);
            _stmt.bindLong(3, $sessionType);
            _stmt.bindLong(4, $primaryId);
            _stmt.bindLong(5, $secondaryId);
            _stmt.bindLong(6, $thirdId);
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // kntr.app.im.chat.db.dao.ChatInfoDao
    public Object deleteAllChatInfo(Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.ChatInfoDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit deleteAllChatInfo$lambda$0;
                deleteAllChatInfo$lambda$0 = ChatInfoDao_Impl.deleteAllChatInfo$lambda$0(r1, (SQLiteConnection) obj);
                return deleteAllChatInfo$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteAllChatInfo$lambda$0(String $_sql, SQLiteConnection _connection) {
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

    /* compiled from: ChatInfoDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/db/dao/ChatInfoDao_Impl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "getRequiredConverters", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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