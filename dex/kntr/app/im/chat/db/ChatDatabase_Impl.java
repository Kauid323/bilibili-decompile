package kntr.app.im.chat.db;

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
import kntr.app.im.chat.db.combinedDao.DeletingDao;
import kntr.app.im.chat.db.combinedDao.DeletingDao_Impl;
import kntr.app.im.chat.db.dao.ChatInfoDao;
import kntr.app.im.chat.db.dao.ChatInfoDao_Impl;
import kntr.app.im.chat.db.dao.DraftDao;
import kntr.app.im.chat.db.dao.DraftDao_Impl;
import kntr.app.im.chat.db.dao.MessageDao;
import kntr.app.im.chat.db.dao.MessageDao_Impl;
import kntr.app.im.chat.db.dao.PushInfoMessageDao;
import kntr.app.im.chat.db.dao.PushInfoMessageDao_Impl;
import kntr.app.im.chat.db.dao.RangeDao;
import kntr.app.im.chat.db.dao.RangeDao_Impl;
import kntr.app.im.chat.db.dao.SessionIdDao;
import kntr.app.im.chat.db.dao.SessionIdDao_Impl;
import kntr.app.im.chat.db.dao.SessionMessageDao;
import kntr.app.im.chat.db.dao.SessionMessageDao_Impl;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ChatDatabase_Impl.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\"\u0010\u001b\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001e0\u001cH\u0014J\u0016\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0\u001d0 H\u0016J*\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001e2\u001a\u0010$\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0\u001d\u0012\u0004\u0012\u00020!0\u001cH\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\nH\u0016J\b\u0010(\u001a\u00020\fH\u0016J\b\u0010)\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lkntr/app/im/chat/db/ChatDatabase_Impl;", "Lkntr/app/im/chat/db/ChatDatabase;", "<init>", "()V", "_chatInfoDao", "Lkotlin/Lazy;", "Lkntr/app/im/chat/db/dao/ChatInfoDao;", "_messageDao", "Lkntr/app/im/chat/db/dao/MessageDao;", "_rangeDao", "Lkntr/app/im/chat/db/dao/RangeDao;", "_sessionIdDao", "Lkntr/app/im/chat/db/dao/SessionIdDao;", "_sessionMessageDao", "Lkntr/app/im/chat/db/dao/SessionMessageDao;", "_draftDao", "Lkntr/app/im/chat/db/dao/DraftDao;", "_deletingDao", "Lkntr/app/im/chat/db/combinedDao/DeletingDao;", "_pushInfoMessageDao", "Lkntr/app/im/chat/db/dao/PushInfoMessageDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", RoomRecommendViewModel.EMPTY_CURSOR, "getRequiredTypeConverterClasses", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", RoomRecommendViewModel.EMPTY_CURSOR, "getRequiredAutoMigrationSpecClasses", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "chatInfoDao", "messageDao", "rangeDao", "sessionIdDao", "sessionMessageDao", "draftDao", "deletingDao", "pushInfoDao", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabase_Impl extends ChatDatabase {
    private final Lazy<ChatInfoDao> _chatInfoDao = LazyKt.lazy(new Function0() { // from class: kntr.app.im.chat.db.ChatDatabase_Impl$$ExternalSyntheticLambda0
        public final Object invoke() {
            ChatInfoDao_Impl _chatInfoDao$lambda$0;
            _chatInfoDao$lambda$0 = ChatDatabase_Impl._chatInfoDao$lambda$0(ChatDatabase_Impl.this);
            return _chatInfoDao$lambda$0;
        }
    });
    private final Lazy<MessageDao> _messageDao = LazyKt.lazy(new Function0() { // from class: kntr.app.im.chat.db.ChatDatabase_Impl$$ExternalSyntheticLambda1
        public final Object invoke() {
            MessageDao_Impl _messageDao$lambda$0;
            _messageDao$lambda$0 = ChatDatabase_Impl._messageDao$lambda$0(ChatDatabase_Impl.this);
            return _messageDao$lambda$0;
        }
    });
    private final Lazy<RangeDao> _rangeDao = LazyKt.lazy(new Function0() { // from class: kntr.app.im.chat.db.ChatDatabase_Impl$$ExternalSyntheticLambda2
        public final Object invoke() {
            RangeDao_Impl _rangeDao$lambda$0;
            _rangeDao$lambda$0 = ChatDatabase_Impl._rangeDao$lambda$0(ChatDatabase_Impl.this);
            return _rangeDao$lambda$0;
        }
    });
    private final Lazy<SessionIdDao> _sessionIdDao = LazyKt.lazy(new Function0() { // from class: kntr.app.im.chat.db.ChatDatabase_Impl$$ExternalSyntheticLambda3
        public final Object invoke() {
            SessionIdDao_Impl _sessionIdDao$lambda$0;
            _sessionIdDao$lambda$0 = ChatDatabase_Impl._sessionIdDao$lambda$0(ChatDatabase_Impl.this);
            return _sessionIdDao$lambda$0;
        }
    });
    private final Lazy<SessionMessageDao> _sessionMessageDao = LazyKt.lazy(new Function0() { // from class: kntr.app.im.chat.db.ChatDatabase_Impl$$ExternalSyntheticLambda4
        public final Object invoke() {
            SessionMessageDao_Impl _sessionMessageDao$lambda$0;
            _sessionMessageDao$lambda$0 = ChatDatabase_Impl._sessionMessageDao$lambda$0(ChatDatabase_Impl.this);
            return _sessionMessageDao$lambda$0;
        }
    });
    private final Lazy<DraftDao> _draftDao = LazyKt.lazy(new Function0() { // from class: kntr.app.im.chat.db.ChatDatabase_Impl$$ExternalSyntheticLambda5
        public final Object invoke() {
            DraftDao_Impl _draftDao$lambda$0;
            _draftDao$lambda$0 = ChatDatabase_Impl._draftDao$lambda$0(ChatDatabase_Impl.this);
            return _draftDao$lambda$0;
        }
    });
    private final Lazy<DeletingDao> _deletingDao = LazyKt.lazy(new Function0() { // from class: kntr.app.im.chat.db.ChatDatabase_Impl$$ExternalSyntheticLambda6
        public final Object invoke() {
            DeletingDao_Impl _deletingDao$lambda$0;
            _deletingDao$lambda$0 = ChatDatabase_Impl._deletingDao$lambda$0(ChatDatabase_Impl.this);
            return _deletingDao$lambda$0;
        }
    });
    private final Lazy<PushInfoMessageDao> _pushInfoMessageDao = LazyKt.lazy(new Function0() { // from class: kntr.app.im.chat.db.ChatDatabase_Impl$$ExternalSyntheticLambda7
        public final Object invoke() {
            PushInfoMessageDao_Impl _pushInfoMessageDao$lambda$0;
            _pushInfoMessageDao$lambda$0 = ChatDatabase_Impl._pushInfoMessageDao$lambda$0(ChatDatabase_Impl.this);
            return _pushInfoMessageDao$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatInfoDao_Impl _chatInfoDao$lambda$0(ChatDatabase_Impl this$0) {
        return new ChatInfoDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageDao_Impl _messageDao$lambda$0(ChatDatabase_Impl this$0) {
        return new MessageDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RangeDao_Impl _rangeDao$lambda$0(ChatDatabase_Impl this$0) {
        return new RangeDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionIdDao_Impl _sessionIdDao$lambda$0(ChatDatabase_Impl this$0) {
        return new SessionIdDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionMessageDao_Impl _sessionMessageDao$lambda$0(ChatDatabase_Impl this$0) {
        return new SessionMessageDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DraftDao_Impl _draftDao$lambda$0(ChatDatabase_Impl this$0) {
        return new DraftDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeletingDao_Impl _deletingDao$lambda$0(ChatDatabase_Impl this$0) {
        return new DeletingDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PushInfoMessageDao_Impl _pushInfoMessageDao$lambda$0(ChatDatabase_Impl this$0) {
        return new PushInfoMessageDao_Impl(this$0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: createOpenDelegate */
    public RoomOpenDelegate m1370createOpenDelegate() {
        RoomOpenDelegate _openDelegate = new RoomOpenDelegate() { // from class: kntr.app.im.chat.db.ChatDatabase_Impl$createOpenDelegate$_openDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3, "4f7f2c9918654f19d0f0a4bfe45556e7", "a8c54d4b289a182158768cfd61500918");
            }

            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `message_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `msg_key` INTEGER NOT NULL, `sequence_number` INTEGER NOT NULL, `sub_sequence_number` INTEGER NOT NULL, `token` TEXT, `content` TEXT NOT NULL, `send_status` INTEGER NOT NULL, `c_time` INTEGER NOT NULL, `m_time` INTEGER NOT NULL, `d_time` INTEGER, `is_realtime_message` INTEGER NOT NULL, `session_type` INTEGER NOT NULL, `primary_id` INTEGER NOT NULL, `secondary_id` INTEGER NOT NULL, `third_id` INTEGER NOT NULL, FOREIGN KEY(`session_type`, `primary_id`, `secondary_id`, `third_id`) REFERENCES `session_id_table`(`session_type`, `primary_id`, `secondary_id`, `third_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_message_table_session_type_primary_id_secondary_id_third_id_msg_key_sequence_number_sub_sequence_number` ON `message_table` (`session_type`, `primary_id`, `secondary_id`, `third_id`, `msg_key`, `sequence_number`, `sub_sequence_number`)");
                SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_message_table_token` ON `message_table` (`token`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `range_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `session_type` INTEGER NOT NULL, `primary_id` INTEGER NOT NULL, `secondary_id` INTEGER NOT NULL, `third_id` INTEGER NOT NULL, FOREIGN KEY(`session_type`, `primary_id`, `secondary_id`, `third_id`) REFERENCES `session_id_table`(`session_type`, `primary_id`, `secondary_id`, `third_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_range_table_session_type_primary_id_secondary_id_third_id_start_end` ON `range_table` (`session_type`, `primary_id`, `secondary_id`, `third_id`, `start`, `end`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `session_id_table` (`session_type` INTEGER NOT NULL, `primary_id` INTEGER NOT NULL, `secondary_id` INTEGER NOT NULL, `third_id` INTEGER NOT NULL, PRIMARY KEY(`session_type`, `primary_id`, `secondary_id`, `third_id`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `chat_info_table` (`content` TEXT NOT NULL, `c_time` INTEGER NOT NULL, `m_time` INTEGER NOT NULL, `session_type` INTEGER NOT NULL, `primary_id` INTEGER NOT NULL, `secondary_id` INTEGER NOT NULL, `third_id` INTEGER NOT NULL, PRIMARY KEY(`session_type`, `primary_id`, `secondary_id`, `third_id`), FOREIGN KEY(`session_type`, `primary_id`, `secondary_id`, `third_id`) REFERENCES `session_id_table`(`session_type`, `primary_id`, `secondary_id`, `third_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `draft_entity_table` (`contentJson` TEXT NOT NULL, `session_type` INTEGER NOT NULL, `primary_id` INTEGER NOT NULL, `secondary_id` INTEGER NOT NULL, `third_id` INTEGER NOT NULL, PRIMARY KEY(`session_type`, `primary_id`, `secondary_id`, `third_id`), FOREIGN KEY(`session_type`, `primary_id`, `secondary_id`, `third_id`) REFERENCES `session_id_table`(`session_type`, `primary_id`, `secondary_id`, `third_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `session_push_info` (`phase_one` INTEGER, `session_type` INTEGER NOT NULL, `primary_id` INTEGER NOT NULL, `secondary_id` INTEGER NOT NULL, `third_id` INTEGER NOT NULL, PRIMARY KEY(`session_type`, `primary_id`, `secondary_id`, `third_id`), FOREIGN KEY(`session_type`, `primary_id`, `secondary_id`, `third_id`) REFERENCES `session_id_table`(`session_type`, `primary_id`, `secondary_id`, `third_id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`phase_one`) REFERENCES `message_table`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4f7f2c9918654f19d0f0a4bfe45556e7')");
            }

            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `message_table`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `range_table`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `session_id_table`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `chat_info_table`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `draft_entity_table`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `session_push_info`");
            }

            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "PRAGMA foreign_keys = ON");
                ChatDatabase_Impl.this.internalInitInvalidationTracker(connection);
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
                Map _columnsMessageTable = new LinkedHashMap();
                _columnsMessageTable.put(ReportBuildInParam.ID, new TableInfo.Column(ReportBuildInParam.ID, "INTEGER", true, 1, (String) null, 1));
                _columnsMessageTable.put("msg_key", new TableInfo.Column("msg_key", "INTEGER", true, 0, (String) null, 1));
                _columnsMessageTable.put("sequence_number", new TableInfo.Column("sequence_number", "INTEGER", true, 0, (String) null, 1));
                _columnsMessageTable.put("sub_sequence_number", new TableInfo.Column("sub_sequence_number", "INTEGER", true, 0, (String) null, 1));
                _columnsMessageTable.put("token", new TableInfo.Column("token", "TEXT", false, 0, (String) null, 1));
                _columnsMessageTable.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
                _columnsMessageTable.put("send_status", new TableInfo.Column("send_status", "INTEGER", true, 0, (String) null, 1));
                _columnsMessageTable.put("c_time", new TableInfo.Column("c_time", "INTEGER", true, 0, (String) null, 1));
                _columnsMessageTable.put("m_time", new TableInfo.Column("m_time", "INTEGER", true, 0, (String) null, 1));
                _columnsMessageTable.put("d_time", new TableInfo.Column("d_time", "INTEGER", false, 0, (String) null, 1));
                _columnsMessageTable.put("is_realtime_message", new TableInfo.Column("is_realtime_message", "INTEGER", true, 0, (String) null, 1));
                _columnsMessageTable.put("session_type", new TableInfo.Column("session_type", "INTEGER", true, 0, (String) null, 1));
                _columnsMessageTable.put("primary_id", new TableInfo.Column("primary_id", "INTEGER", true, 0, (String) null, 1));
                _columnsMessageTable.put("secondary_id", new TableInfo.Column("secondary_id", "INTEGER", true, 0, (String) null, 1));
                _columnsMessageTable.put("third_id", new TableInfo.Column("third_id", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysMessageTable = new LinkedHashSet();
                _foreignKeysMessageTable.add(new TableInfo.ForeignKey("session_id_table", "CASCADE", "NO ACTION", CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id"}), CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id"})));
                Set _indicesMessageTable = new LinkedHashSet();
                _indicesMessageTable.add(new TableInfo.Index("index_message_table_session_type_primary_id_secondary_id_third_id_msg_key_sequence_number_sub_sequence_number", true, CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id", "msg_key", "sequence_number", "sub_sequence_number"}), CollectionsKt.listOf(new String[]{"ASC", "ASC", "ASC", "ASC", "ASC", "ASC", "ASC"})));
                _indicesMessageTable.add(new TableInfo.Index("index_message_table_token", true, CollectionsKt.listOf("token"), CollectionsKt.listOf("ASC")));
                TableInfo _infoMessageTable = new TableInfo("message_table", _columnsMessageTable, _foreignKeysMessageTable, _indicesMessageTable);
                TableInfo _existingMessageTable = TableInfo.Companion.read(connection, "message_table");
                if (!_infoMessageTable.equals(_existingMessageTable)) {
                    return new RoomOpenDelegate.ValidationResult(false, "message_table(kntr.app.im.chat.db.entity.MessageEntity).\n Expected:\n" + _infoMessageTable + "\n Found:\n" + _existingMessageTable);
                }
                Map _columnsRangeTable = new LinkedHashMap();
                _columnsRangeTable.put(ReportBuildInParam.ID, new TableInfo.Column(ReportBuildInParam.ID, "INTEGER", true, 1, (String) null, 1));
                _columnsRangeTable.put("start", new TableInfo.Column("start", "INTEGER", true, 0, (String) null, 1));
                _columnsRangeTable.put("end", new TableInfo.Column("end", "INTEGER", true, 0, (String) null, 1));
                _columnsRangeTable.put("session_type", new TableInfo.Column("session_type", "INTEGER", true, 0, (String) null, 1));
                _columnsRangeTable.put("primary_id", new TableInfo.Column("primary_id", "INTEGER", true, 0, (String) null, 1));
                _columnsRangeTable.put("secondary_id", new TableInfo.Column("secondary_id", "INTEGER", true, 0, (String) null, 1));
                _columnsRangeTable.put("third_id", new TableInfo.Column("third_id", "INTEGER", true, 0, (String) null, 1));
                Set _foreignKeysRangeTable = new LinkedHashSet();
                _foreignKeysRangeTable.add(new TableInfo.ForeignKey("session_id_table", "CASCADE", "NO ACTION", CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id"}), CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id"})));
                Set _indicesRangeTable = new LinkedHashSet();
                _indicesRangeTable.add(new TableInfo.Index("index_range_table_session_type_primary_id_secondary_id_third_id_start_end", true, CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id", "start", "end"}), CollectionsKt.listOf(new String[]{"ASC", "ASC", "ASC", "ASC", "ASC", "ASC"})));
                TableInfo _infoRangeTable = new TableInfo("range_table", _columnsRangeTable, _foreignKeysRangeTable, _indicesRangeTable);
                TableInfo _existingRangeTable = TableInfo.Companion.read(connection, "range_table");
                if (!_infoRangeTable.equals(_existingRangeTable)) {
                    return new RoomOpenDelegate.ValidationResult(false, "range_table(kntr.app.im.chat.db.entity.RangeEntity).\n Expected:\n" + _infoRangeTable + "\n Found:\n" + _existingRangeTable);
                }
                Map _columnsSessionIdTable = new LinkedHashMap();
                _columnsSessionIdTable.put("session_type", new TableInfo.Column("session_type", "INTEGER", true, 1, (String) null, 1));
                _columnsSessionIdTable.put("primary_id", new TableInfo.Column("primary_id", "INTEGER", true, 2, (String) null, 1));
                _columnsSessionIdTable.put("secondary_id", new TableInfo.Column("secondary_id", "INTEGER", true, 3, (String) null, 1));
                _columnsSessionIdTable.put("third_id", new TableInfo.Column("third_id", "INTEGER", true, 4, (String) null, 1));
                Set _foreignKeysSessionIdTable = new LinkedHashSet();
                Set _indicesSessionIdTable = new LinkedHashSet();
                TableInfo _infoSessionIdTable = new TableInfo("session_id_table", _columnsSessionIdTable, _foreignKeysSessionIdTable, _indicesSessionIdTable);
                TableInfo _existingSessionIdTable = TableInfo.Companion.read(connection, "session_id_table");
                if (!_infoSessionIdTable.equals(_existingSessionIdTable)) {
                    return new RoomOpenDelegate.ValidationResult(false, "session_id_table(kntr.app.im.chat.db.entity.SessionIdEntity).\n Expected:\n" + _infoSessionIdTable + "\n Found:\n" + _existingSessionIdTable);
                }
                Map _columnsChatInfoTable = new LinkedHashMap();
                _columnsChatInfoTable.put("content", new TableInfo.Column("content", "TEXT", true, 0, (String) null, 1));
                _columnsChatInfoTable.put("c_time", new TableInfo.Column("c_time", "INTEGER", true, 0, (String) null, 1));
                _columnsChatInfoTable.put("m_time", new TableInfo.Column("m_time", "INTEGER", true, 0, (String) null, 1));
                _columnsChatInfoTable.put("session_type", new TableInfo.Column("session_type", "INTEGER", true, 1, (String) null, 1));
                _columnsChatInfoTable.put("primary_id", new TableInfo.Column("primary_id", "INTEGER", true, 2, (String) null, 1));
                _columnsChatInfoTable.put("secondary_id", new TableInfo.Column("secondary_id", "INTEGER", true, 3, (String) null, 1));
                _columnsChatInfoTable.put("third_id", new TableInfo.Column("third_id", "INTEGER", true, 4, (String) null, 1));
                Set _foreignKeysChatInfoTable = new LinkedHashSet();
                _foreignKeysChatInfoTable.add(new TableInfo.ForeignKey("session_id_table", "CASCADE", "NO ACTION", CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id"}), CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id"})));
                Set _indicesChatInfoTable = new LinkedHashSet();
                TableInfo _infoChatInfoTable = new TableInfo("chat_info_table", _columnsChatInfoTable, _foreignKeysChatInfoTable, _indicesChatInfoTable);
                TableInfo _existingChatInfoTable = TableInfo.Companion.read(connection, "chat_info_table");
                if (!_infoChatInfoTable.equals(_existingChatInfoTable)) {
                    return new RoomOpenDelegate.ValidationResult(false, "chat_info_table(kntr.app.im.chat.db.entity.ChatInfoEntity).\n Expected:\n" + _infoChatInfoTable + "\n Found:\n" + _existingChatInfoTable);
                }
                Map _columnsDraftEntityTable = new LinkedHashMap();
                _columnsDraftEntityTable.put("contentJson", new TableInfo.Column("contentJson", "TEXT", true, 0, (String) null, 1));
                _columnsDraftEntityTable.put("session_type", new TableInfo.Column("session_type", "INTEGER", true, 1, (String) null, 1));
                _columnsDraftEntityTable.put("primary_id", new TableInfo.Column("primary_id", "INTEGER", true, 2, (String) null, 1));
                _columnsDraftEntityTable.put("secondary_id", new TableInfo.Column("secondary_id", "INTEGER", true, 3, (String) null, 1));
                _columnsDraftEntityTable.put("third_id", new TableInfo.Column("third_id", "INTEGER", true, 4, (String) null, 1));
                Set _foreignKeysDraftEntityTable = new LinkedHashSet();
                _foreignKeysDraftEntityTable.add(new TableInfo.ForeignKey("session_id_table", "CASCADE", "NO ACTION", CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id"}), CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id"})));
                Set _indicesDraftEntityTable = new LinkedHashSet();
                TableInfo _infoDraftEntityTable = new TableInfo("draft_entity_table", _columnsDraftEntityTable, _foreignKeysDraftEntityTable, _indicesDraftEntityTable);
                TableInfo _existingDraftEntityTable = TableInfo.Companion.read(connection, "draft_entity_table");
                if (!_infoDraftEntityTable.equals(_existingDraftEntityTable)) {
                    return new RoomOpenDelegate.ValidationResult(false, "draft_entity_table(kntr.app.im.chat.db.entity.DraftEntity).\n Expected:\n" + _infoDraftEntityTable + "\n Found:\n" + _existingDraftEntityTable);
                }
                Map _columnsSessionPushInfo = new LinkedHashMap();
                _columnsSessionPushInfo.put("phase_one", new TableInfo.Column("phase_one", "INTEGER", false, 0, (String) null, 1));
                _columnsSessionPushInfo.put("session_type", new TableInfo.Column("session_type", "INTEGER", true, 1, (String) null, 1));
                _columnsSessionPushInfo.put("primary_id", new TableInfo.Column("primary_id", "INTEGER", true, 2, (String) null, 1));
                _columnsSessionPushInfo.put("secondary_id", new TableInfo.Column("secondary_id", "INTEGER", true, 3, (String) null, 1));
                _columnsSessionPushInfo.put("third_id", new TableInfo.Column("third_id", "INTEGER", true, 4, (String) null, 1));
                Set _foreignKeysSessionPushInfo = new LinkedHashSet();
                _foreignKeysSessionPushInfo.add(new TableInfo.ForeignKey("session_id_table", "CASCADE", "NO ACTION", CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id"}), CollectionsKt.listOf(new String[]{"session_type", "primary_id", "secondary_id", "third_id"})));
                _foreignKeysSessionPushInfo.add(new TableInfo.ForeignKey("message_table", "NO ACTION", "NO ACTION", CollectionsKt.listOf("phase_one"), CollectionsKt.listOf(ReportBuildInParam.ID)));
                Set _indicesSessionPushInfo = new LinkedHashSet();
                TableInfo _infoSessionPushInfo = new TableInfo("session_push_info", _columnsSessionPushInfo, _foreignKeysSessionPushInfo, _indicesSessionPushInfo);
                TableInfo _existingSessionPushInfo = TableInfo.Companion.read(connection, "session_push_info");
                if (!_infoSessionPushInfo.equals(_existingSessionPushInfo)) {
                    return new RoomOpenDelegate.ValidationResult(false, "session_push_info(kntr.app.im.chat.db.entity.SessionPushInfoMessage).\n Expected:\n" + _infoSessionPushInfo + "\n Found:\n" + _existingSessionPushInfo);
                }
                return new RoomOpenDelegate.ValidationResult(true, (String) null);
            }
        };
        return _openDelegate;
    }

    protected InvalidationTracker createInvalidationTracker() {
        Map _shadowTablesMap = new LinkedHashMap();
        Map _viewTables = new LinkedHashMap();
        return new InvalidationTracker(this, _shadowTablesMap, _viewTables, new String[]{"message_table", "range_table", "session_id_table", "chat_info_table", "draft_entity_table", "session_push_info"});
    }

    public void clearAllTables() {
        super.performClear(true, new String[]{"message_table", "range_table", "session_id_table", "chat_info_table", "draft_entity_table", "session_push_info"});
    }

    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        Map _typeConvertersMap = new LinkedHashMap();
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(ChatInfoDao.class), ChatInfoDao_Impl.Companion.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(MessageDao.class), MessageDao_Impl.Companion.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(RangeDao.class), RangeDao_Impl.Companion.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(SessionIdDao.class), SessionIdDao_Impl.Companion.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(SessionMessageDao.class), SessionMessageDao_Impl.Companion.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(DraftDao.class), DraftDao_Impl.Companion.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(DeletingDao.class), DeletingDao_Impl.Companion.getRequiredConverters());
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(PushInfoMessageDao.class), PushInfoMessageDao_Impl.Companion.getRequiredConverters());
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

    @Override // kntr.app.im.chat.db.ChatDatabase
    public ChatInfoDao chatInfoDao() {
        return (ChatInfoDao) this._chatInfoDao.getValue();
    }

    @Override // kntr.app.im.chat.db.ChatDatabase
    public MessageDao messageDao() {
        return (MessageDao) this._messageDao.getValue();
    }

    @Override // kntr.app.im.chat.db.ChatDatabase
    public RangeDao rangeDao() {
        return (RangeDao) this._rangeDao.getValue();
    }

    @Override // kntr.app.im.chat.db.ChatDatabase
    public SessionIdDao sessionIdDao() {
        return (SessionIdDao) this._sessionIdDao.getValue();
    }

    @Override // kntr.app.im.chat.db.ChatDatabase
    public SessionMessageDao sessionMessageDao() {
        return (SessionMessageDao) this._sessionMessageDao.getValue();
    }

    @Override // kntr.app.im.chat.db.ChatDatabase
    public DraftDao draftDao() {
        return (DraftDao) this._draftDao.getValue();
    }

    @Override // kntr.app.im.chat.db.ChatDatabase
    public DeletingDao deletingDao() {
        return (DeletingDao) this._deletingDao.getValue();
    }

    @Override // kntr.app.im.chat.db.ChatDatabase
    public PushInfoMessageDao pushInfoDao() {
        return (PushInfoMessageDao) this._pushInfoMessageDao.getValue();
    }
}