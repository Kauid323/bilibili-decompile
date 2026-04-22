package video.biz.offline.base.model.db;

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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;
import video.biz.offline.base.model.dao.OfflineVideoDao;
import video.biz.offline.base.model.dao.OfflineVideoDao_Impl;

/* compiled from: AppDatabase_Impl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u00100\u000eH\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f0\u0012H\u0016J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f\u0012\u0004\u0012\u00020\u00130\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lvideo/biz/offline/base/model/db/AppDatabase_Impl;", "Lvideo/biz/offline/base/model/db/AppDatabase;", "<init>", "()V", "_offlineVideoDao", "Lkotlin/Lazy;", "Lvideo/biz/offline/base/model/dao/OfflineVideoDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "videoDao", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AppDatabase_Impl extends AppDatabase {
    public static final int $stable = 8;
    private final Lazy<OfflineVideoDao> _offlineVideoDao = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.model.db.AppDatabase_Impl$$ExternalSyntheticLambda0
        public final Object invoke() {
            OfflineVideoDao_Impl _offlineVideoDao$lambda$0;
            _offlineVideoDao$lambda$0 = AppDatabase_Impl._offlineVideoDao$lambda$0(AppDatabase_Impl.this);
            return _offlineVideoDao$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineVideoDao_Impl _offlineVideoDao$lambda$0(AppDatabase_Impl this$0) {
        return new OfflineVideoDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: createOpenDelegate */
    public RoomOpenDelegate m2763createOpenDelegate() {
        RoomOpenDelegate _openDelegate = new RoomOpenDelegate() { // from class: video.biz.offline.base.model.db.AppDatabase_Impl$createOpenDelegate$_openDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1, "9381ec8bb5affcee6dc08d824acfbf66", "bdeba37b2d65f241d860a1e05fbf9ec8");
            }

            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `video_info` (`group_id` INTEGER NOT NULL, `group_title` TEXT NOT NULL, `aid` INTEGER NOT NULL, `cid` INTEGER NOT NULL, `season_id` INTEGER NOT NULL, `episode_id` INTEGER NOT NULL, `biz_type` INTEGER NOT NULL, `key` TEXT NOT NULL, `video_attr` INTEGER NOT NULL, `video_id` INTEGER NOT NULL, `archive_title` TEXT NOT NULL, `page_id` INTEGER NOT NULL, `page_title` TEXT NOT NULL, `cover` TEXT NOT NULL, `author` TEXT NOT NULL, `author_mid` INTEGER NOT NULL, `bvid` TEXT NOT NULL, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `rotate` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `danmaku_count` INTEGER NOT NULL, `real_videoQuality` INTEGER NOT NULL, `preferred_videoQuality` INTEGER NOT NULL, `quality_display` TEXT NOT NULL, `quality_name` TEXT NOT NULL, `media_type` TEXT NOT NULL, `qn_path` TEXT NOT NULL, `video_info` TEXT NOT NULL, `state_value` INTEGER NOT NULL, `error_code` INTEGER NOT NULL, `total_size` INTEGER NOT NULL, `downloaded_size` INTEGER NOT NULL, `storage_path` TEXT NOT NULL, `create_time` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `videoIndex` INTEGER NOT NULL, `pageIndex` INTEGER NOT NULL, `season_type` INTEGER NOT NULL, `from` TEXT NOT NULL, `app_version` INTEGER NOT NULL, `extended` TEXT NOT NULL, `auth_code` INTEGER NOT NULL, `link` TEXT NOT NULL, `sectionsLengthList` TEXT NOT NULL, `sectionsContentTime` TEXT NOT NULL, `sectionsDownloadedList` TEXT NOT NULL, PRIMARY KEY(`key`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9381ec8bb5affcee6dc08d824acfbf66')");
            }

            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `video_info`");
            }

            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                AppDatabase_Impl.this.internalInitInvalidationTracker(connection);
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
                Map _columnsVideoInfo = new LinkedHashMap();
                _columnsVideoInfo.put("group_id", new TableInfo.Column("group_id", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("group_title", new TableInfo.Column("group_title", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("aid", new TableInfo.Column("aid", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("cid", new TableInfo.Column("cid", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("season_id", new TableInfo.Column("season_id", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("episode_id", new TableInfo.Column("episode_id", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put(MediaItemParams.IJK_REPORT_KEY_BIZ_TYPE, new TableInfo.Column(MediaItemParams.IJK_REPORT_KEY_BIZ_TYPE, "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("key", new TableInfo.Column("key", "TEXT", true, 1, (String) null, 1));
                _columnsVideoInfo.put("video_attr", new TableInfo.Column("video_attr", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put(DownloadedPageActivity.KEY_VIDEO_ID, new TableInfo.Column(DownloadedPageActivity.KEY_VIDEO_ID, "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("archive_title", new TableInfo.Column("archive_title", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("page_id", new TableInfo.Column("page_id", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("page_title", new TableInfo.Column("page_title", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put(RankRouter.BundleKey.VIDEO_DETAIL_COVER, new TableInfo.Column(RankRouter.BundleKey.VIDEO_DETAIL_COVER, "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("author", new TableInfo.Column("author", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("author_mid", new TableInfo.Column("author_mid", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("bvid", new TableInfo.Column("bvid", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("width", new TableInfo.Column("width", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("height", new TableInfo.Column("height", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("rotate", new TableInfo.Column("rotate", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("danmaku_count", new TableInfo.Column("danmaku_count", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("real_videoQuality", new TableInfo.Column("real_videoQuality", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("preferred_videoQuality", new TableInfo.Column("preferred_videoQuality", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("quality_display", new TableInfo.Column("quality_display", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("quality_name", new TableInfo.Column("quality_name", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("media_type", new TableInfo.Column("media_type", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("qn_path", new TableInfo.Column("qn_path", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("video_info", new TableInfo.Column("video_info", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("state_value", new TableInfo.Column("state_value", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("error_code", new TableInfo.Column("error_code", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("total_size", new TableInfo.Column("total_size", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("downloaded_size", new TableInfo.Column("downloaded_size", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("storage_path", new TableInfo.Column("storage_path", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("create_time", new TableInfo.Column("create_time", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("update_time", new TableInfo.Column("update_time", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("videoIndex", new TableInfo.Column("videoIndex", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("pageIndex", new TableInfo.Column("pageIndex", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put(MediaItemParams.IJK_REPORT_KEY_SEASON_TYPE, new TableInfo.Column(MediaItemParams.IJK_REPORT_KEY_SEASON_TYPE, "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("from", new TableInfo.Column("from", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("app_version", new TableInfo.Column("app_version", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("extended", new TableInfo.Column("extended", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("auth_code", new TableInfo.Column("auth_code", "INTEGER", true, 0, (String) null, 1));
                _columnsVideoInfo.put("link", new TableInfo.Column("link", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("sectionsLengthList", new TableInfo.Column("sectionsLengthList", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("sectionsContentTime", new TableInfo.Column("sectionsContentTime", "TEXT", true, 0, (String) null, 1));
                _columnsVideoInfo.put("sectionsDownloadedList", new TableInfo.Column("sectionsDownloadedList", "TEXT", true, 0, (String) null, 1));
                Set _foreignKeysVideoInfo = new LinkedHashSet();
                Set _indicesVideoInfo = new LinkedHashSet();
                TableInfo _infoVideoInfo = new TableInfo("video_info", _columnsVideoInfo, _foreignKeysVideoInfo, _indicesVideoInfo);
                TableInfo _existingVideoInfo = TableInfo.Companion.read(connection, "video_info");
                if (!_infoVideoInfo.equals(_existingVideoInfo)) {
                    return new RoomOpenDelegate.ValidationResult(false, "video_info(video.biz.offline.base.model.entity.OfflineVideoEntity).\n Expected:\n" + _infoVideoInfo + "\n Found:\n" + _existingVideoInfo);
                }
                return new RoomOpenDelegate.ValidationResult(true, (String) null);
            }
        };
        return _openDelegate;
    }

    protected InvalidationTracker createInvalidationTracker() {
        Map _shadowTablesMap = new LinkedHashMap();
        Map _viewTables = new LinkedHashMap();
        return new InvalidationTracker(this, _shadowTablesMap, _viewTables, new String[]{"video_info"});
    }

    public void clearAllTables() {
        super.performClear(false, new String[]{"video_info"});
    }

    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        Map _typeConvertersMap = new LinkedHashMap();
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(OfflineVideoDao.class), OfflineVideoDao_Impl.Companion.getRequiredConverters());
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

    @Override // video.biz.offline.base.model.db.AppDatabase
    public OfflineVideoDao videoDao() {
        return (OfflineVideoDao) this._offlineVideoDao.getValue();
    }
}