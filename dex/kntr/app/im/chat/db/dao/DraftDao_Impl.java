package kntr.app.im.chat.db.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
import kntr.app.im.chat.db.dao.DraftDao;
import kntr.app.im.chat.db.entity.DraftEntity;
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
import kotlinx.coroutines.flow.Flow;

/* compiled from: DraftDao_Impl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ0\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0017J0\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u001a\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkntr/app/im/chat/db/dao/DraftDao_Impl;", "Lkntr/app/im/chat/db/dao/DraftDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__deleteAdapterOfDraftEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "Lkntr/app/im/chat/db/entity/DraftEntity;", "__upsertAdapterOfDraftEntity", "Landroidx/room/EntityUpsertAdapter;", "deleteDraft", RoomRecommendViewModel.EMPTY_CURSOR, "draft", "(Lkntr/app/im/chat/db/entity/DraftEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsert", "query", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "(IJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observe", "Lkotlinx/coroutines/flow/Flow;", "deleteAllDraft", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DraftDao_Impl implements DraftDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<DraftEntity> __deleteAdapterOfDraftEntity;
    private final EntityUpsertAdapter<DraftEntity> __upsertAdapterOfDraftEntity;

    public DraftDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__deleteAdapterOfDraftEntity = new EntityDeleteOrUpdateAdapter<DraftEntity>() { // from class: kntr.app.im.chat.db.dao.DraftDao_Impl.1
            protected String createQuery() {
                return "DELETE FROM `draft_entity_table` WHERE `session_type` = ? AND `primary_id` = ? AND `secondary_id` = ? AND `third_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, DraftEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                SessionIdEntity _tmpSessionId = entity.getSessionId();
                statement.bindLong(1, _tmpSessionId.getSessionType());
                statement.bindLong(2, _tmpSessionId.getPrimaryId());
                statement.bindLong(3, _tmpSessionId.getSecondaryId());
                statement.bindLong(4, _tmpSessionId.getThirdId());
            }
        };
        this.__upsertAdapterOfDraftEntity = new EntityUpsertAdapter<>(new EntityInsertAdapter<DraftEntity>() { // from class: kntr.app.im.chat.db.dao.DraftDao_Impl.2
            protected String createQuery() {
                return "INSERT INTO `draft_entity_table` (`contentJson`,`session_type`,`primary_id`,`secondary_id`,`third_id`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, DraftEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindText(1, entity.getContentJson$db_debug());
                SessionIdEntity _tmpSessionId = entity.getSessionId();
                statement.bindLong(2, _tmpSessionId.getSessionType());
                statement.bindLong(3, _tmpSessionId.getPrimaryId());
                statement.bindLong(4, _tmpSessionId.getSecondaryId());
                statement.bindLong(5, _tmpSessionId.getThirdId());
            }
        }, new EntityDeleteOrUpdateAdapter<DraftEntity>() { // from class: kntr.app.im.chat.db.dao.DraftDao_Impl.3
            protected String createQuery() {
                return "UPDATE `draft_entity_table` SET `contentJson` = ?,`session_type` = ?,`primary_id` = ?,`secondary_id` = ?,`third_id` = ? WHERE `session_type` = ? AND `primary_id` = ? AND `secondary_id` = ? AND `third_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, DraftEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindText(1, entity.getContentJson$db_debug());
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

    @Override // kntr.app.im.chat.db.dao.DraftDao
    public /* bridge */ Object deleteDraft(SessionIdEntity sessionId, Continuation<? super Unit> continuation) {
        return DraftDao.CC.deleteDraft$suspendImpl(this, sessionId, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.DraftDao
    public /* bridge */ Flow<DraftEntity> observe(SessionIdEntity sessionId) {
        return DraftDao.CC.$default$observe(this, sessionId);
    }

    @Override // kntr.app.im.chat.db.dao.DraftDao
    public /* bridge */ Object query(SessionIdEntity sessionId, Continuation<? super DraftEntity> continuation) {
        return DraftDao.CC.query$suspendImpl(this, sessionId, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.DraftDao
    public Object deleteDraft(final DraftEntity draft, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.DraftDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit deleteDraft$lambda$0;
                deleteDraft$lambda$0 = DraftDao_Impl.deleteDraft$lambda$0(DraftDao_Impl.this, draft, (SQLiteConnection) obj);
                return deleteDraft$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteDraft$lambda$0(DraftDao_Impl this$0, DraftEntity $draft, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__deleteAdapterOfDraftEntity.handle(_connection, $draft);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.db.dao.DraftDao
    public Object upsert(final DraftEntity draft, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.DraftDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit upsert$lambda$0;
                upsert$lambda$0 = DraftDao_Impl.upsert$lambda$0(DraftDao_Impl.this, draft, (SQLiteConnection) obj);
                return upsert$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upsert$lambda$0(DraftDao_Impl this$0, DraftEntity $draft, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__upsertAdapterOfDraftEntity.upsert(_connection, $draft);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.db.dao.DraftDao
    public Object query(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, Continuation<? super DraftEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: kntr.app.im.chat.db.dao.DraftDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                DraftEntity query$lambda$0;
                query$lambda$0 = DraftDao_Impl.query$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, (SQLiteConnection) obj);
                return query$lambda$0;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DraftEntity query$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, SQLiteConnection _connection) {
        DraftEntity _result;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            try {
                _stmt.bindLong(2, $primaryId);
            } catch (Throwable th) {
                th = th;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            _stmt.bindLong(3, $secondaryId);
            try {
                _stmt.bindLong(4, $thirdId);
                int _cursorIndexOfContentJson = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "contentJson");
                int _cursorIndexOfSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "session_type");
                int _cursorIndexOfPrimaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "primary_id");
                int _cursorIndexOfSecondaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "secondary_id");
                int _cursorIndexOfThirdId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "third_id");
                if (_stmt.step()) {
                    String _tmpContentJson = _stmt.getText(_cursorIndexOfContentJson);
                    int _tmpSessionType = (int) _stmt.getLong(_cursorIndexOfSessionType);
                    long _tmpPrimaryId = _stmt.getLong(_cursorIndexOfPrimaryId);
                    long _tmpSecondaryId = _stmt.getLong(_cursorIndexOfSecondaryId);
                    long _tmpThirdId = _stmt.getLong(_cursorIndexOfThirdId);
                    SessionIdEntity _tmpSessionId = new SessionIdEntity(_tmpSessionType, _tmpPrimaryId, _tmpSecondaryId, _tmpThirdId);
                    _result = new DraftEntity(_tmpSessionId, _tmpContentJson);
                } else {
                    _result = null;
                }
                _stmt.close();
                return _result;
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
    }

    @Override // kntr.app.im.chat.db.dao.DraftDao
    public Flow<DraftEntity> observe(final int sessionType, final long primaryId, final long secondaryId, final long thirdId) {
        return FlowUtil.createFlow(this.__db, false, new String[]{"draft_entity_table"}, new Function1() { // from class: kntr.app.im.chat.db.dao.DraftDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                DraftEntity observe$lambda$0;
                observe$lambda$0 = DraftDao_Impl.observe$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, (SQLiteConnection) obj);
                return observe$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DraftEntity observe$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, SQLiteConnection _connection) {
        DraftEntity _result;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            try {
                _stmt.bindLong(2, $primaryId);
            } catch (Throwable th) {
                th = th;
                _stmt.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            _stmt.bindLong(3, $secondaryId);
            try {
                _stmt.bindLong(4, $thirdId);
                int _cursorIndexOfContentJson = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "contentJson");
                int _cursorIndexOfSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "session_type");
                int _cursorIndexOfPrimaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "primary_id");
                int _cursorIndexOfSecondaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "secondary_id");
                int _cursorIndexOfThirdId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "third_id");
                if (_stmt.step()) {
                    String _tmpContentJson = _stmt.getText(_cursorIndexOfContentJson);
                    int _tmpSessionType = (int) _stmt.getLong(_cursorIndexOfSessionType);
                    long _tmpPrimaryId = _stmt.getLong(_cursorIndexOfPrimaryId);
                    long _tmpSecondaryId = _stmt.getLong(_cursorIndexOfSecondaryId);
                    long _tmpThirdId = _stmt.getLong(_cursorIndexOfThirdId);
                    SessionIdEntity _tmpSessionId = new SessionIdEntity(_tmpSessionType, _tmpPrimaryId, _tmpSecondaryId, _tmpThirdId);
                    _result = new DraftEntity(_tmpSessionId, _tmpContentJson);
                } else {
                    _result = null;
                }
                _stmt.close();
                return _result;
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
    }

    @Override // kntr.app.im.chat.db.dao.DraftDao
    public Object deleteDraft(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.DraftDao_Impl$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit deleteDraft$lambda$1;
                deleteDraft$lambda$1 = DraftDao_Impl.deleteDraft$lambda$1(r1, sessionType, primaryId, secondaryId, thirdId, (SQLiteConnection) obj);
                return deleteDraft$lambda$1;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteDraft$lambda$1(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            _stmt.bindLong(2, $primaryId);
            _stmt.bindLong(3, $secondaryId);
            _stmt.bindLong(4, $thirdId);
            _stmt.step();
            _stmt.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            _stmt.close();
            throw th;
        }
    }

    @Override // kntr.app.im.chat.db.dao.DraftDao
    public Object deleteAllDraft(Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.DraftDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit deleteAllDraft$lambda$0;
                deleteAllDraft$lambda$0 = DraftDao_Impl.deleteAllDraft$lambda$0(r1, (SQLiteConnection) obj);
                return deleteAllDraft$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteAllDraft$lambda$0(String $_sql, SQLiteConnection _connection) {
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

    /* compiled from: DraftDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/db/dao/DraftDao_Impl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "getRequiredConverters", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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