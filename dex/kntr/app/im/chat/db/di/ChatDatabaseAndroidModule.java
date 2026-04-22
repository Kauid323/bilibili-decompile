package kntr.app.im.chat.db.di;

import android.app.Application;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.util.KClassUtil;
import dagger.Module;
import dagger.Provides;
import kntr.app.im.chat.db.ChatDatabase;
import kntr.app.im.chat.db.ChatDatabaseBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: ChatDatabaseBuilderModule.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/db/di/ChatDatabaseAndroidModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideChatDatabaseBuilder", "Lkntr/app/im/chat/db/ChatDatabaseBuilder;", "application", "Landroid/app/Application;", "path", "Lkotlinx/io/files/Path;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ChatDatabaseAndroidModule {
    public static final ChatDatabaseAndroidModule INSTANCE = new ChatDatabaseAndroidModule();

    private ChatDatabaseAndroidModule() {
    }

    @Provides
    public final ChatDatabaseBuilder provideChatDatabaseBuilder(final Application application, @ChatDatabaseDirectory final Path path) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(path, "path");
        return new ChatDatabaseBuilder() { // from class: kntr.app.im.chat.db.di.ChatDatabaseAndroidModule$$ExternalSyntheticLambda0
            @Override // kntr.app.im.chat.db.ChatDatabaseBuilder
            public final RoomDatabase.Builder getChatDatabaseBuilder(UserInfo userInfo) {
                RoomDatabase.Builder provideChatDatabaseBuilder$lambda$0;
                provideChatDatabaseBuilder$lambda$0 = ChatDatabaseAndroidModule.provideChatDatabaseBuilder$lambda$0(path, application, userInfo);
                return provideChatDatabaseBuilder$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomDatabase.Builder provideChatDatabaseBuilder$lambda$0(Path $path, Application $application, UserInfo userInfo) {
        long mid = userInfo != null ? userInfo.getMid() : 0L;
        String dbFile = PathsKt.Path($path, new String[]{"im_" + mid + ".db"}).toString();
        Room room = Room.INSTANCE;
        Application context$iv = $application;
        Function0 factory$iv = new Function0<ChatDatabase>() { // from class: kntr.app.im.chat.db.di.ChatDatabaseAndroidModule$provideChatDatabaseBuilder$lambda$0$$inlined$databaseBuilder$default$1
            /* JADX WARN: Type inference failed for: r0v2, types: [androidx.room.RoomDatabase, kntr.app.im.chat.db.ChatDatabase] */
            /* renamed from: invoke */
            public final ChatDatabase m1403invoke() {
                return (RoomDatabase) KClassUtil.findAndInstantiateDatabaseImpl$default(ChatDatabase.class, (String) null, 2, (Object) null);
            }
        };
        if (StringsKt.isBlank(dbFile)) {
            throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().".toString());
        }
        if (Intrinsics.areEqual(dbFile, ":memory:")) {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().".toString());
        }
        return new RoomDatabase.Builder(Reflection.getOrCreateKotlinClass(ChatDatabase.class), dbFile, factory$iv, context$iv);
    }
}