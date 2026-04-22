package kntr.app.im.chat.db.di;

import dagger.Binds;
import dagger.Module;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.im.chat.db.DatabaseService;
import kntr.app.im.chat.db.DatabaseServiceImpl;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: ChatDatabaseModule.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/di/ChatDatabaseModule;", RoomRecommendViewModel.EMPTY_CURSOR, "databaseService", "Lkntr/app/im/chat/db/DatabaseService;", "impl", "Lkntr/app/im/chat/db/DatabaseServiceImpl;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public interface ChatDatabaseModule {
    @ChatScope
    @Binds
    DatabaseService databaseService(DatabaseServiceImpl databaseServiceImpl);
}