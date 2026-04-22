package kntr.app.im.chat.db;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: DatabaseService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/DatabaseService;", RoomRecommendViewModel.EMPTY_CURSOR, "db", "Lkntr/app/im/chat/db/ChatDatabase;", "getDb", "()Lkntr/app/im/chat/db/ChatDatabase;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DatabaseService {
    ChatDatabase getDb();
}