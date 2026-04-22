package kntr.app.im.chat.db;

import androidx.room.RoomDatabase;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.model.UserInfo;
import kotlin.Metadata;

/* compiled from: ChatDatabaseProvider.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/ChatDatabaseBuilder;", RoomRecommendViewModel.EMPTY_CURSOR, "getChatDatabaseBuilder", "Landroidx/room/RoomDatabase$Builder;", "Lkntr/app/im/chat/db/ChatDatabase;", "userInfo", "Lkntr/base/account/model/UserInfo;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatDatabaseBuilder {
    RoomDatabase.Builder<ChatDatabase> getChatDatabaseBuilder(UserInfo userInfo);
}