package kntr.app.im.chat.db.di;

import java.util.Set;
import kntr.app.im.chat.db.ChatDatabaseConfigurationSet;
import kntr.app.im.chat.db.ChatDatabaseConfigurer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatDatabaseConfigModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¨\u0006\u0005"}, d2 = {"provideChatDatabaseConfig", "Lkntr/app/im/chat/db/ChatDatabaseConfigurationSet;", "set", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/ChatDatabaseConfigurer;", "db_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseConfigModuleKt {
    public static final ChatDatabaseConfigurationSet provideChatDatabaseConfig(Set<? extends ChatDatabaseConfigurer> set) {
        Intrinsics.checkNotNullParameter(set, "set");
        return new ChatDatabaseConfigurationSet(set);
    }
}