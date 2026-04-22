package kntr.app.im.chat.db.clean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.im.chat.db.ChatDatabaseProvider;
import kntr.app.im.chat.db.di.ChatDatabaseDirectory;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.Path;

/* compiled from: ChatDatabaseCleaner.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0001¨\u0006\t"}, d2 = {"produceChatDatabaseCleaner", "Lkntr/app/im/chat/db/clean/ChatDatabaseCleaner;", "baseDir", "Lkotlinx/io/files/Path;", "chatDatabaseProvider", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "listDBFilePaths", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "db_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseCleanerKt {
    public static final ChatDatabaseCleaner produceChatDatabaseCleaner(@ChatDatabaseDirectory Path baseDir, ChatDatabaseProvider chatDatabaseProvider) {
        Intrinsics.checkNotNullParameter(baseDir, "baseDir");
        Intrinsics.checkNotNullParameter(chatDatabaseProvider, "chatDatabaseProvider");
        return new ChatDatabaseCleaner(baseDir, chatDatabaseProvider);
    }

    public static final List<String> listDBFilePaths(ChatDatabaseCleaner $this$listDBFilePaths) {
        Intrinsics.checkNotNullParameter($this$listDBFilePaths, "<this>");
        Iterable $this$map$iv = $this$listDBFilePaths.listDBFiles();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Path it = (Path) item$iv$iv;
            destination$iv$iv.add(it.toString());
        }
        return (List) destination$iv$iv;
    }
}