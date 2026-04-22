package kntr.app.im.chat.db.clean;

import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.im.chat.db.ChatDatabaseProvider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.io.files.Path;

/* compiled from: ChatDatabaseCleanerKt_produceChatDatabaseCleaner_Lambda.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000f\u001a\u00020\u0000H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u000e\u0010\u0015\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/app/im/chat/db/clean/ChatDatabaseCleanerKt_produceChatDatabaseCleaner_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lkntr/app/im/chat/db/clean/ChatDatabaseCleaner;", "v0", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkotlinx/io/files/Path;", "v1", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "compatJavaParam", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lkotlin/Unit;)V", "d_v0", "Lcom/bilibili/lib/gripper/api/GDeferred;", "d_v1", "create", "prepareParams", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseCleanerKt_produceChatDatabaseCleaner_Lambda extends ProducerBase<ChatDatabaseCleaner> {
    private GDeferred<Path> d_v0;
    private GDeferred<? extends ChatDatabaseProvider> d_v1;
    private final SuspendProducer<Path> v0;
    private final SuspendProducer<ChatDatabaseProvider> v1;

    public ChatDatabaseCleanerKt_produceChatDatabaseCleaner_Lambda(SuspendProducer<Path> suspendProducer, SuspendProducer<ChatDatabaseProvider> suspendProducer2, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(suspendProducer, "v0");
        Intrinsics.checkNotNullParameter(suspendProducer2, "v1");
        this.v0 = suspendProducer;
        this.v1 = suspendProducer2;
    }

    public ChatDatabaseCleanerKt_produceChatDatabaseCleaner_Lambda create() {
        return new ChatDatabaseCleanerKt_produceChatDatabaseCleaner_Lambda(this.v0, this.v1, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferred(context, r, this.v0);
        this.d_v1 = GenerateHelper.deferred(context, r, this.v1);
        return r;
    }

    protected Object invokeProducer(Continuation<? super ChatDatabaseCleaner> continuation) {
        GDeferred<Path> gDeferred = this.d_v0;
        GDeferred<? extends ChatDatabaseProvider> gDeferred2 = null;
        if (gDeferred == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v0");
            gDeferred = null;
        }
        Path path = (Path) gDeferred.getCompleted();
        GDeferred<? extends ChatDatabaseProvider> gDeferred3 = this.d_v1;
        if (gDeferred3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v1");
        } else {
            gDeferred2 = gDeferred3;
        }
        return ChatDatabaseCleanerKt.produceChatDatabaseCleaner(path, (ChatDatabaseProvider) gDeferred2.getCompleted());
    }
}