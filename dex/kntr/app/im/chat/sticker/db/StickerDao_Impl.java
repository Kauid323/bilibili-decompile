package kntr.app.im.chat.sticker.db;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.db.converter.InstantConverter;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.app.im.chat.sticker.entity.StickerResolution;
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
import kotlinx.datetime.Instant;

/* compiled from: StickerDao_Impl.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J \u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001a0\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkntr/app/im/chat/sticker/db/StickerDao_Impl;", "Lkntr/app/im/chat/sticker/db/StickerDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfStickerEntity", "Landroidx/room/EntityInsertAdapter;", "Lkntr/app/im/chat/sticker/entity/StickerEntity;", "__instantConverter", "Lkntr/app/im/chat/db/converter/InstantConverter;", "__deleteAdapterOfStickerEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "add", RoomRecommendViewModel.EMPTY_CURSOR, "sticker", "(Lkntr/app/im/chat/sticker/entity/StickerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "findWithFile", "fileName", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllStickerOfUser", "Lkotlinx/coroutines/flow/Flow;", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerDao_Impl implements StickerDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<StickerEntity> __deleteAdapterOfStickerEntity;
    private final EntityInsertAdapter<StickerEntity> __insertAdapterOfStickerEntity;
    private final InstantConverter __instantConverter;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public StickerDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__instantConverter = new InstantConverter();
        this.__db = __db;
        this.__insertAdapterOfStickerEntity = new EntityInsertAdapter<StickerEntity>() { // from class: kntr.app.im.chat.sticker.db.StickerDao_Impl.1
            protected String createQuery() {
                return "INSERT OR ABORT INTO `chat_sticker` (`id`,`file_name`,`cTime`,`mid`,`mime`,`widthPx`,`heightPx`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, StickerEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
                statement.bindText(2, entity.getFileName());
                Long _tmp = StickerDao_Impl.this.__instantConverter.instantToLong(entity.getCTime());
                if (_tmp != null) {
                    statement.bindLong(3, _tmp.longValue());
                } else {
                    statement.bindNull(3);
                }
                statement.bindLong(4, entity.getMid());
                statement.bindText(5, entity.getMime$sticker_debug());
                StickerResolution _tmpResolution = entity.getResolution();
                statement.bindLong(6, _tmpResolution.getWidthPx());
                statement.bindLong(7, _tmpResolution.getHeightPx());
            }
        };
        this.__deleteAdapterOfStickerEntity = new EntityDeleteOrUpdateAdapter<StickerEntity>() { // from class: kntr.app.im.chat.sticker.db.StickerDao_Impl.2
            protected String createQuery() {
                return "DELETE FROM `chat_sticker` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SQLiteStatement statement, StickerEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.bindLong(1, entity.getId());
            }
        };
    }

    @Override // kntr.app.im.chat.sticker.db.StickerDao
    public Object add(final StickerEntity sticker, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.sticker.db.StickerDao_Impl$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit add$lambda$0;
                add$lambda$0 = StickerDao_Impl.add$lambda$0(StickerDao_Impl.this, sticker, (SQLiteConnection) obj);
                return add$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit add$lambda$0(StickerDao_Impl this$0, StickerEntity $sticker, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__insertAdapterOfStickerEntity.insert(_connection, $sticker);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.sticker.db.StickerDao
    public Object remove(final StickerEntity sticker, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: kntr.app.im.chat.sticker.db.StickerDao_Impl$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit remove$lambda$0;
                remove$lambda$0 = StickerDao_Impl.remove$lambda$0(StickerDao_Impl.this, sticker, (SQLiteConnection) obj);
                return remove$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit remove$lambda$0(StickerDao_Impl this$0, StickerEntity $sticker, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        this$0.__deleteAdapterOfStickerEntity.handle(_connection, $sticker);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.im.chat.sticker.db.StickerDao
    public Object findWithFile(final String fileName, final long mid, Continuation<? super StickerEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: kntr.app.im.chat.sticker.db.StickerDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                StickerEntity findWithFile$lambda$0;
                findWithFile$lambda$0 = StickerDao_Impl.findWithFile$lambda$0(r1, fileName, mid, this, (SQLiteConnection) obj);
                return findWithFile$lambda$0;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StickerEntity findWithFile$lambda$0(String $_sql, String $fileName, long $mid, StickerDao_Impl this$0, SQLiteConnection _connection) {
        StickerEntity _result;
        Long _tmp;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindText(1, $fileName);
            try {
                _stmt.bindLong(2, $mid);
                int _cursorIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, ReportBuildInParam.ID);
                int _cursorIndexOfFileName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "file_name");
                int _cursorIndexOfCTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "cTime");
                int _cursorIndexOfMid = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, ReportBuildInParam.MID);
                int _cursorIndexOfMime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "mime");
                int _cursorIndexOfWidthPx = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "widthPx");
                int _cursorIndexOfHeightPx = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "heightPx");
                if (_stmt.step()) {
                    long _tmpId = _stmt.getLong(_cursorIndexOfId);
                    String _tmpFileName = _stmt.getText(_cursorIndexOfFileName);
                    if (_stmt.isNull(_cursorIndexOfCTime)) {
                        _tmp = null;
                    } else {
                        Long _tmp2 = Long.valueOf(_stmt.getLong(_cursorIndexOfCTime));
                        _tmp = _tmp2;
                    }
                    Instant _tmp_1 = this$0.__instantConverter.longToInstant(_tmp);
                    if (_tmp_1 == null) {
                        throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                    }
                    long _tmpMid = _stmt.getLong(_cursorIndexOfMid);
                    String _tmpMime = _stmt.getText(_cursorIndexOfMime);
                    int _tmpWidthPx = (int) _stmt.getLong(_cursorIndexOfWidthPx);
                    int _tmpHeightPx = (int) _stmt.getLong(_cursorIndexOfHeightPx);
                    StickerResolution _tmpResolution = new StickerResolution(_tmpWidthPx, _tmpHeightPx);
                    _result = new StickerEntity(_tmpId, _tmpFileName, _tmp_1, _tmpMid, _tmpResolution, _tmpMime);
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
        }
    }

    @Override // kntr.app.im.chat.sticker.db.StickerDao
    public Flow<List<StickerEntity>> getAllStickerOfUser(final long mid) {
        return FlowUtil.createFlow(this.__db, false, new String[]{"chat_sticker"}, new Function1() { // from class: kntr.app.im.chat.sticker.db.StickerDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                List allStickerOfUser$lambda$0;
                allStickerOfUser$lambda$0 = StickerDao_Impl.getAllStickerOfUser$lambda$0(r1, mid, this, (SQLiteConnection) obj);
                return allStickerOfUser$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllStickerOfUser$lambda$0(String $_sql, long $mid, StickerDao_Impl this$0, SQLiteConnection _connection) {
        boolean z;
        Long _tmp;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        boolean z2 = true;
        try {
            _stmt.bindLong(1, $mid);
            int _cursorIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, ReportBuildInParam.ID);
            int _cursorIndexOfFileName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "file_name");
            int _cursorIndexOfCTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "cTime");
            int _cursorIndexOfMid = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, ReportBuildInParam.MID);
            int _cursorIndexOfMime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "mime");
            int _cursorIndexOfWidthPx = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "widthPx");
            int _cursorIndexOfHeightPx = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "heightPx");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_cursorIndexOfId);
                String _tmpFileName = _stmt.getText(_cursorIndexOfFileName);
                if (_stmt.isNull(_cursorIndexOfCTime)) {
                    z = z2;
                    _tmp = null;
                } else {
                    Long _tmp2 = Long.valueOf(_stmt.getLong(_cursorIndexOfCTime));
                    z = z2;
                    _tmp = _tmp2;
                }
                Instant _tmp_1 = this$0.__instantConverter.longToInstant(_tmp);
                if (_tmp_1 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                }
                long _tmpMid = _stmt.getLong(_cursorIndexOfMid);
                String _tmpMime = _stmt.getText(_cursorIndexOfMime);
                int _tmpWidthPx = (int) _stmt.getLong(_cursorIndexOfWidthPx);
                int _tmpHeightPx = (int) _stmt.getLong(_cursorIndexOfHeightPx);
                StickerResolution _tmpResolution = new StickerResolution(_tmpWidthPx, _tmpHeightPx);
                StickerEntity _item = new StickerEntity(_tmpId, _tmpFileName, _tmp_1, _tmpMid, _tmpResolution, _tmpMime);
                _result.add(_item);
                z2 = z;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    /* compiled from: StickerDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/sticker/db/StickerDao_Impl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "getRequiredConverters", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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