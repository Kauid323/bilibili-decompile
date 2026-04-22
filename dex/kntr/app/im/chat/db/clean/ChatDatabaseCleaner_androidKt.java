package kntr.app.im.chat.db.clean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: ChatDatabaseCleaner.android.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"cleanBlocking", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/clean/ChatDatabaseCleaner;", "db_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseCleaner_androidKt {
    public static final void cleanBlocking(ChatDatabaseCleaner $this$cleanBlocking) {
        Intrinsics.checkNotNullParameter($this$cleanBlocking, "<this>");
        BuildersKt.runBlocking$default((CoroutineContext) null, new ChatDatabaseCleaner_androidKt$cleanBlocking$1($this$cleanBlocking, null), 1, (Object) null);
    }
}