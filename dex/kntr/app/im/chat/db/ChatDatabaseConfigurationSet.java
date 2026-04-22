package kntr.app.im.chat.db;

import java.util.Set;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DatabaseBuilder.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkntr/app/im/chat/db/ChatDatabaseConfigurationSet;", RoomRecommendViewModel.EMPTY_CURSOR, "set", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/ChatDatabaseConfigurer;", "<init>", "(Ljava/util/Set;)V", "getSet", "()Ljava/util/Set;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseConfigurationSet {
    private final Set<ChatDatabaseConfigurer> set;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatDatabaseConfigurationSet(Set<? extends ChatDatabaseConfigurer> set) {
        Intrinsics.checkNotNullParameter(set, "set");
        this.set = set;
    }

    public final Set<ChatDatabaseConfigurer> getSet() {
        return this.set;
    }
}