package kntr.app.im.chat.db.clean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.im.chat.db.ChatDatabaseProvider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* compiled from: ChatDatabaseCleaner.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tJ\u000e\u0010\n\u001a\u00020\u000bH\u0087@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u0087@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/db/clean/ChatDatabaseCleaner;", RoomRecommendViewModel.EMPTY_CURSOR, "baseDir", "Lkotlinx/io/files/Path;", "chatDatabaseProvider", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "<init>", "(Lkotlinx/io/files/Path;Lkntr/app/im/chat/db/ChatDatabaseProvider;)V", "listDBFiles", RoomRecommendViewModel.EMPTY_CURSOR, "clean", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalSizeByte", RoomRecommendViewModel.EMPTY_CURSOR, "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseCleaner {
    private final Path baseDir;
    private final ChatDatabaseProvider chatDatabaseProvider;

    public ChatDatabaseCleaner(Path baseDir, ChatDatabaseProvider chatDatabaseProvider) {
        Intrinsics.checkNotNullParameter(baseDir, "baseDir");
        Intrinsics.checkNotNullParameter(chatDatabaseProvider, "chatDatabaseProvider");
        this.baseDir = baseDir;
        this.chatDatabaseProvider = chatDatabaseProvider;
    }

    public final Collection<Path> listDBFiles() {
        Iterable $this$filter$iv = FileSystemJvmKt.SystemFileSystem.list(this.baseDir);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Path it = (Path) element$iv$iv;
            if (StringsKt.endsWith$default(it.getName(), ".db", false, 2, (Object) null)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final Object clean(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new ChatDatabaseCleaner$clean$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getTotalSizeByte(Continuation<? super Long> continuation) {
        return BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new ChatDatabaseCleaner$getTotalSizeByte$2(this, null), continuation);
    }
}