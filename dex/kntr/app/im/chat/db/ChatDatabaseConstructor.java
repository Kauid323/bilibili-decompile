package kntr.app.im.chat.db;

import androidx.room.RoomDatabaseConstructor;
import kotlin.Metadata;

/* compiled from: ChatDatabaseConstructor.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/db/ChatDatabaseConstructor;", "Landroidx/room/RoomDatabaseConstructor;", "Lkntr/app/im/chat/db/ChatDatabase;", "<init>", "()V", "initialize", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseConstructor implements RoomDatabaseConstructor<ChatDatabase> {
    public static final ChatDatabaseConstructor INSTANCE = new ChatDatabaseConstructor();

    private ChatDatabaseConstructor() {
    }

    public ChatDatabase initialize() {
        return new ChatDatabase_Impl();
    }
}