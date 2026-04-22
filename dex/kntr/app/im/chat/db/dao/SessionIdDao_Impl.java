package kntr.app.im.chat.db.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
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

/* compiled from: SessionIdDao_Impl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0010\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/im/chat/db/dao/SessionIdDao_Impl;", "Lkntr/app/im/chat/db/dao/SessionIdDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfSessionIdEntity", "Landroidx/room/EntityInsertAdapter;", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "__deleteAdapterOfSessionIdEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "insert", RoomRecommendViewModel.EMPTY_CURSOR, "session", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSessionId", "deleteAllSessions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionIdDao_Impl implements SessionIdDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<SessionIdEntity> __deleteAdapterOfSessionIdEntity;
    private final EntityInsertAdapter<SessionIdEntity> __insertAdapterOfSessionIdEntity;

    public SessionIdDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfSessionIdEntity = new EntityInsertAdapter<SessionIdEntity>() { // from class: kntr.app.im.chat.db.dao.SessionIdDao_Impl.1
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `session_id_table` (`session_type`,`primary_id`,`secondary_id`,`third_id`) VALUES (?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, SessionIdEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getSessionType());
                statement.bindLong(2, entity.getPrimaryId());
                statement.bindLong(3, entity.getSecondaryId());
                statement.bindLong(4, entity.getThirdId());
            }
        };
        this.__deleteAdapterOfSessionIdEntity = new EntityDeleteOrUpdateAdapter<SessionIdEntity>() { // from class: kntr.app.im.chat.db.dao.SessionIdDao_Impl.2
            protected String createQuery() {
                return "DELETE FROM `session_id_table` WHERE `session_type` = ? AND `primary_id` = ? AND `secondary_id` = ? AND `third_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, SessionIdEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getSessionType());
                statement.bindLong(2, entity.getPrimaryId());
                statement.bindLong(3, entity.getSecondaryId());
                statement.bindLong(4, entity.getThirdId());
            }
        };
    }

    @Override // kntr.app.im.chat.db.dao.SessionIdDao
    public Object insert(final SessionIdEntity session, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.SessionIdDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit insert$lambda$0;
                insert$lambda$0 = SessionIdDao_Impl.insert$lambda$0(SessionIdDao_Impl.this, session, (SQLiteConnection) obj);
                return insert$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insert$lambda$0(SessionIdDao_Impl this$0, SessionIdEntity $session, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__insertAdapterOfSessionIdEntity.insert(_connection, $session);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.db.dao.SessionIdDao
    public Object deleteSessionId(final SessionIdEntity session, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.SessionIdDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit deleteSessionId$lambda$0;
                deleteSessionId$lambda$0 = SessionIdDao_Impl.deleteSessionId$lambda$0(SessionIdDao_Impl.this, session, (SQLiteConnection) obj);
                return deleteSessionId$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteSessionId$lambda$0(SessionIdDao_Impl this$0, SessionIdEntity $session, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__deleteAdapterOfSessionIdEntity.handle(_connection, $session);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.db.dao.SessionIdDao
    public Object deleteAllSessions(Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.db.dao.SessionIdDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit deleteAllSessions$lambda$0;
                deleteAllSessions$lambda$0 = SessionIdDao_Impl.deleteAllSessions$lambda$0(r1, (SQLiteConnection) obj);
                return deleteAllSessions$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteAllSessions$lambda$0(String $_sql, SQLiteConnection _connection) {
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

    /* compiled from: SessionIdDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/db/dao/SessionIdDao_Impl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "getRequiredConverters", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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