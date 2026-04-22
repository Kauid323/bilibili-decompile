package kntr.app.im.chat.db.di.module;

import androidx.room.RoomDatabase;
import kntr.app.im.chat.db.ChatDatabaseConfigurer;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicConfig.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\b\u0010\u0002\u001a\u00020\u0001H\u0007¨\u0006\u0003"}, d2 = {"chatDatabaseMigrationConfig", "Lkntr/app/im/chat/db/ChatDatabaseConfigurer;", "chatDatabaseQueryContextConfig", "db_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BasicConfigKt {
    public static final ChatDatabaseConfigurer chatDatabaseMigrationConfig() {
        return new ChatDatabaseConfigurer() { // from class: kntr.app.im.chat.db.di.module.BasicConfigKt$$ExternalSyntheticLambda1
            @Override // kntr.app.im.chat.db.ChatDatabaseConfigurer
            public final RoomDatabase.Builder configDatabase(RoomDatabase.Builder builder) {
                RoomDatabase.Builder chatDatabaseMigrationConfig$lambda$0;
                chatDatabaseMigrationConfig$lambda$0 = BasicConfigKt.chatDatabaseMigrationConfig$lambda$0(builder);
                return chatDatabaseMigrationConfig$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomDatabase.Builder chatDatabaseMigrationConfig$lambda$0(RoomDatabase.Builder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.fallbackToDestructiveMigration(true);
    }

    public static final ChatDatabaseConfigurer chatDatabaseQueryContextConfig() {
        return new ChatDatabaseConfigurer() { // from class: kntr.app.im.chat.db.di.module.BasicConfigKt$$ExternalSyntheticLambda0
            @Override // kntr.app.im.chat.db.ChatDatabaseConfigurer
            public final RoomDatabase.Builder configDatabase(RoomDatabase.Builder builder) {
                RoomDatabase.Builder chatDatabaseQueryContextConfig$lambda$0;
                chatDatabaseQueryContextConfig$lambda$0 = BasicConfigKt.chatDatabaseQueryContextConfig$lambda$0(builder);
                return chatDatabaseQueryContextConfig$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomDatabase.Builder chatDatabaseQueryContextConfig$lambda$0(RoomDatabase.Builder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.setQueryCoroutineContext(CoroutineExJvmKt.getIoContext());
    }
}