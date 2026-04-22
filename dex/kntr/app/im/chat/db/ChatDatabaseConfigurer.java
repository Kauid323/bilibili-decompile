package kntr.app.im.chat.db;

import androidx.room.RoomDatabase;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: DatabaseBuilder.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/ChatDatabaseConfigurer;", RoomRecommendViewModel.EMPTY_CURSOR, "configDatabase", "Landroidx/room/RoomDatabase$Builder;", "Lkntr/app/im/chat/db/ChatDatabase;", "databaseBuilder", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatDatabaseConfigurer {
    RoomDatabase.Builder<ChatDatabase> configDatabase(RoomDatabase.Builder<ChatDatabase> builder);
}