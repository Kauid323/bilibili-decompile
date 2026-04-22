package kntr.app.im.chat.db.dao;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.db.dao.RangeDao;
import kntr.app.im.chat.db.entity.RangeEntity;
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
import kotlin.ranges.LongRange;
import kotlin.reflect.KClass;

/* compiled from: RangeDao_Impl.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\fJ2\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0002\u0010\u0014J4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001dJ8\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010 J>\u0010!\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lkntr/app/im/chat/db/dao/RangeDao_Impl;", "Lkntr/app/im/chat/db/dao/RangeDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfRangeEntity", "Landroidx/room/EntityInsertAdapter;", "Lkntr/app/im/chat/db/entity/RangeEntity;", "insert", RoomRecommendViewModel.EMPTY_CURSOR, "range", "(Lkntr/app/im/chat/db/entity/RangeEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAndAdd", "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "toDelete", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ranges/LongRange;", "toInsert", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Ljava/util/Collection;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAll", RoomRecommendViewModel.EMPTY_CURSOR, "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "(IJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPrevious", "base", "(IJJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "start", "end", "(IJJJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllRange", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RangeDao_Impl implements RangeDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<RangeEntity> __insertAdapterOfRangeEntity;

    public RangeDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfRangeEntity = new EntityInsertAdapter<RangeEntity>() { // from class: kntr.app.im.chat.db.dao.RangeDao_Impl.1
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `range_table` (`id`,`start`,`end`,`session_type`,`primary_id`,`secondary_id`,`third_id`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, RangeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getStart());
                statement.bindLong(3, entity.getEnd());
                SessionIdEntity _tmpSessionId = entity.getSessionId();
                statement.bindLong(4, _tmpSessionId.getSessionType());
                statement.bindLong(5, _tmpSessionId.getPrimaryId());
                statement.bindLong(6, _tmpSessionId.getSecondaryId());
                statement.bindLong(7, _tmpSessionId.getThirdId());
            }
        };
    }

    @Override // kntr.app.im.chat.db.dao.RangeDao
    public /* bridge */ Object delete(SessionIdEntity sessionId, long start, long end, Continuation<? super Unit> continuation) {
        return RangeDao.CC.delete$suspendImpl(this, sessionId, start, end, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.RangeDao
    public /* bridge */ Object queryAll(SessionIdEntity sessionId, Continuation<? super List<RangeEntity>> continuation) {
        return RangeDao.CC.queryAll$suspendImpl(this, sessionId, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.RangeDao
    public /* bridge */ Object queryPrevious(SessionIdEntity sessionId, long base, Continuation<? super RangeEntity> continuation) {
        return RangeDao.CC.queryPrevious$suspendImpl(this, sessionId, base, continuation);
    }

    @Override // kntr.app.im.chat.db.dao.RangeDao
    public Object insert(final RangeEntity range, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.RangeDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit insert$lambda$0;
                insert$lambda$0 = RangeDao_Impl.insert$lambda$0(RangeDao_Impl.this, range, (SQLiteConnection) obj);
                return insert$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insert$lambda$0(RangeDao_Impl this$0, RangeEntity $range, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__insertAdapterOfRangeEntity.insert(_connection, $range);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.db.dao.RangeDao
    public Object removeAndAdd(SessionIdEntity sessionId, Collection<LongRange> collection, Collection<LongRange> collection2, Continuation<? super Unit> continuation) {
        Object performInTransactionSuspending = DBUtil.performInTransactionSuspending(this.__db, new RangeDao_Impl$removeAndAdd$2(this, sessionId, collection, collection2, null), continuation);
        return performInTransactionSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performInTransactionSuspending : Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.db.dao.RangeDao
    public Object queryAll(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, Continuation<? super List<RangeEntity>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: kntr.app.im.chat.db.dao.RangeDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                List queryAll$lambda$0;
                queryAll$lambda$0 = RangeDao_Impl.queryAll$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, (SQLiteConnection) obj);
                return queryAll$lambda$0;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List queryAll$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            _stmt.bindLong(2, $primaryId);
            try {
                _stmt.bindLong(3, $secondaryId);
                try {
                    _stmt.bindLong(4, $thirdId);
                    int _cursorIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, ReportBuildInParam.ID);
                    int _cursorIndexOfStart = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "start");
                    int _cursorIndexOfEnd = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "end");
                    int _cursorIndexOfSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "session_type");
                    int _cursorIndexOfPrimaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "primary_id");
                    int _cursorIndexOfSecondaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "secondary_id");
                    int _cursorIndexOfThirdId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "third_id");
                    List _result = new ArrayList();
                    while (_stmt.step()) {
                        long _tmpId = _stmt.getLong(_cursorIndexOfId);
                        long _tmpStart = _stmt.getLong(_cursorIndexOfStart);
                        long _tmpEnd = _stmt.getLong(_cursorIndexOfEnd);
                        int _tmpSessionType = (int) _stmt.getLong(_cursorIndexOfSessionType);
                        long _tmpPrimaryId = _stmt.getLong(_cursorIndexOfPrimaryId);
                        long _tmpSecondaryId = _stmt.getLong(_cursorIndexOfSecondaryId);
                        long _tmpThirdId = _stmt.getLong(_cursorIndexOfThirdId);
                        SessionIdEntity _tmpSessionId = new SessionIdEntity(_tmpSessionType, _tmpPrimaryId, _tmpSecondaryId, _tmpThirdId);
                        RangeEntity _item = new RangeEntity(_tmpId, _tmpSessionId, _tmpStart, _tmpEnd);
                        List _result2 = _result;
                        _result2.add(_item);
                        _result = _result2;
                    }
                    List _result3 = _result;
                    _stmt.close();
                    return _result3;
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

    @Override // kntr.app.im.chat.db.dao.RangeDao
    public Object queryPrevious(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, final long base, Continuation<? super RangeEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: kntr.app.im.chat.db.dao.RangeDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                RangeEntity queryPrevious$lambda$0;
                queryPrevious$lambda$0 = RangeDao_Impl.queryPrevious$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, base, (SQLiteConnection) obj);
                return queryPrevious$lambda$0;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RangeEntity queryPrevious$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, long $base, SQLiteConnection _connection) {
        RangeEntity _result;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            _stmt.bindLong(2, $primaryId);
            try {
                _stmt.bindLong(3, $secondaryId);
                try {
                    _stmt.bindLong(4, $thirdId);
                    try {
                        _stmt.bindLong(5, $base);
                        int _cursorIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, ReportBuildInParam.ID);
                        int _cursorIndexOfStart = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "start");
                        int _cursorIndexOfEnd = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "end");
                        int _cursorIndexOfSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "session_type");
                        int _cursorIndexOfPrimaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "primary_id");
                        int _cursorIndexOfSecondaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "secondary_id");
                        int _cursorIndexOfThirdId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "third_id");
                        if (_stmt.step()) {
                            long _tmpId = _stmt.getLong(_cursorIndexOfId);
                            long _tmpStart = _stmt.getLong(_cursorIndexOfStart);
                            long _tmpEnd = _stmt.getLong(_cursorIndexOfEnd);
                            int _tmpSessionType = (int) _stmt.getLong(_cursorIndexOfSessionType);
                            long _tmpPrimaryId = _stmt.getLong(_cursorIndexOfPrimaryId);
                            long _tmpSecondaryId = _stmt.getLong(_cursorIndexOfSecondaryId);
                            long _tmpThirdId = _stmt.getLong(_cursorIndexOfThirdId);
                            SessionIdEntity _tmpSessionId = new SessionIdEntity(_tmpSessionType, _tmpPrimaryId, _tmpSecondaryId, _tmpThirdId);
                            _result = new RangeEntity(_tmpId, _tmpSessionId, _tmpStart, _tmpEnd);
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
                _stmt.close();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // kntr.app.im.chat.db.dao.RangeDao
    public Object delete(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, final long start, final long end, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.RangeDao_Impl$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit delete$lambda$0;
                delete$lambda$0 = RangeDao_Impl.delete$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, start, end, (SQLiteConnection) obj);
                return delete$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, long $start, long $end, SQLiteConnection _connection) {
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
            _stmt.bindLong(5, $start);
            try {
                _stmt.bindLong(6, $end);
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
    }

    @Override // kntr.app.im.chat.db.dao.RangeDao
    public Object deleteAllRange(Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.RangeDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit deleteAllRange$lambda$0;
                deleteAllRange$lambda$0 = RangeDao_Impl.deleteAllRange$lambda$0(r1, (SQLiteConnection) obj);
                return deleteAllRange$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteAllRange$lambda$0(String $_sql, SQLiteConnection _connection) {
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

    /* compiled from: RangeDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/db/dao/RangeDao_Impl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "getRequiredConverters", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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