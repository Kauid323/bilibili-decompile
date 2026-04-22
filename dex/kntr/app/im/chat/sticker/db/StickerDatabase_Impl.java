package kntr.app.im.chat.sticker.db;

import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: StickerDatabase_Impl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u00100\u000eH\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f0\u0012H\u0016J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f\u0012\u0004\u0012\u00020\u00130\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/app/im/chat/sticker/db/StickerDatabase_Impl;", "Lkntr/app/im/chat/sticker/db/StickerDatabase;", "<init>", "()V", "_stickerDao", "Lkotlin/Lazy;", "Lkntr/app/im/chat/sticker/db/StickerDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", RoomRecommendViewModel.EMPTY_CURSOR, "getRequiredTypeConverterClasses", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", RoomRecommendViewModel.EMPTY_CURSOR, "getRequiredAutoMigrationSpecClasses", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "stickerDao", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerDatabase_Impl extends StickerDatabase {
    public static final int $stable = 8;
    private final Lazy<StickerDao> _stickerDao = LazyKt.lazy(new Function0() { // from class: kntr.app.im.chat.sticker.db.StickerDatabase_Impl$$ExternalSyntheticLambda0
        public final Object invoke() {
            StickerDao_Impl _stickerDao$lambda$0;
            _stickerDao$lambda$0 = StickerDatabase_Impl._stickerDao$lambda$0(StickerDatabase_Impl.this);
            return _stickerDao$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final StickerDao_Impl _stickerDao$lambda$0(StickerDatabase_Impl this$0) {
        return new StickerDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: createOpenDelegate */
    public RoomOpenDelegate m1658createOpenDelegate() {
        RoomOpenDelegate _openDelegate = new RoomOpenDelegate() { // from class: kntr.app.im.chat.sticker.db.StickerDatabase_Impl$createOpenDelegate$_openDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1, "39c53b6c8931223c8d3fb21c665e4982", "e56680b49e923ef2f2051b7496298003");
            }

            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `chat_sticker` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `file_name` TEXT NOT NULL, `cTime` INTEGER NOT NULL, `mid` INTEGER NOT NULL, `mime` TEXT NOT NULL, `widthPx` INTEGER NOT NULL, `heightPx` INTEGER NOT NULL)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '39c53b6c8931223c8d3fb21c665e4982')");
            }

            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `chat_sticker`");
            }

            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                StickerDatabase_Impl.this.internalInitInvalidationTracker(connection);
            }

            public void onPreMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                DBUtil.dropFtsSyncTriggers(connection);
            }

            public void onPostMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                Map _columnsChatSticker = new LinkedHashMap();
                _columnsChatSticker.put(ReportBuildInParam.ID, new TableInfo.Column(ReportBuildInParam.ID, "INTEGER", true, 1, (String) null, 1));
                _columnsChatSticker.put("file_name", new TableInfo.Column("file_name", "TEXT", true, 0, (String) null, 1));
                _columnsChatSticker.put("cTime", new TableInfo.Column("cTime", "INTEGER", true, 0, (String) null, 1));
                _columnsChatSticker.put(ReportBuildInParam.MID, new TableInfo.Column(ReportBuildInParam.MID, "INTEGER", true, 0, (String) null, 1));
                _columnsChatSticker.put("mime", new TableInfo.Column("mime", "TEXT", true, 0, (String) null, 1));
                _columnsChatSticker.put("widthPx", new TableInfo.Column("widthPx", "INTEGER", true, 0, (String) null, 1));
                _columnsChatSticker.put("heightPx", new TableInfo.Column("heightPx", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysChatSticker = new LinkedHashSet();
                Set _indicesChatSticker = new LinkedHashSet();
                TableInfo _infoChatSticker = new TableInfo("chat_sticker", _columnsChatSticker, _foreignKeysChatSticker, _indicesChatSticker);
                TableInfo _existingChatSticker = TableInfo.Companion.read(connection, "chat_sticker");
                if (!_infoChatSticker.equals(_existingChatSticker)) {
                    return new RoomOpenDelegate.ValidationResult(false, "chat_sticker(kntr.app.im.chat.sticker.entity.StickerEntity).\n Expected:\n" + _infoChatSticker + "\n Found:\n" + _existingChatSticker);
                }
                return new RoomOpenDelegate.ValidationResult(true, (String) null);
            }
        };
        return _openDelegate;
    }

    protected InvalidationTracker createInvalidationTracker() {
        Map _shadowTablesMap = new LinkedHashMap();
        Map _viewTables = new LinkedHashMap();
        return new InvalidationTracker(this, _shadowTablesMap, _viewTables, new String[]{"chat_sticker"});
    }

    public void clearAllTables() {
        super.performClear(false, new String[]{"chat_sticker"});
    }

    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        Map _typeConvertersMap = new LinkedHashMap();
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(StickerDao.class), StickerDao_Impl.Companion.getRequiredConverters());
        return _typeConvertersMap;
    }

    public Set<KClass<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        Set _autoMigrationSpecsSet = new LinkedHashSet();
        return _autoMigrationSpecsSet;
    }

    public List<Migration> createAutoMigrations(Map<KClass<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> map) {
        Intrinsics.checkNotNullParameter(map, "autoMigrationSpecs");
        List _autoMigrations = new ArrayList();
        return _autoMigrations;
    }

    @Override // kntr.app.im.chat.sticker.db.StickerDatabase
    public StickerDao stickerDao() {
        return (StickerDao) this._stickerDao.getValue();
    }
}