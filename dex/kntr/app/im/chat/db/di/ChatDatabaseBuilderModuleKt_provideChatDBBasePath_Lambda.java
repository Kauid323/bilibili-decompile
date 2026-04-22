package kntr.app.im.chat.db.di;

import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.io.files.Path;

/* compiled from: ChatDatabaseBuilderModuleKt_provideChatDBBasePath_Lambda.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\u0000H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u000e\u0010\u0011\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/im/chat/db/di/ChatDatabaseBuilderModuleKt_provideChatDBBasePath_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lkotlinx/io/files/Path;", "v0", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "compatJavaParam", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lcom/bilibili/lib/gripper/api/SuspendProducer;Lkotlin/Unit;)V", "d_v0", "Lcom/bilibili/lib/gripper/api/GDeferred;", "create", "prepareParams", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseBuilderModuleKt_provideChatDBBasePath_Lambda extends ProducerBase<Path> {
    private GDeferred<Path> d_v0;
    private final SuspendProducer<Path> v0;

    public ChatDatabaseBuilderModuleKt_provideChatDBBasePath_Lambda(SuspendProducer<Path> suspendProducer, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(suspendProducer, "v0");
        this.v0 = suspendProducer;
    }

    public ChatDatabaseBuilderModuleKt_provideChatDBBasePath_Lambda create() {
        return new ChatDatabaseBuilderModuleKt_provideChatDBBasePath_Lambda(this.v0, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferred(context, r, this.v0);
        return r;
    }

    protected Object invokeProducer(Continuation<? super Path> continuation) {
        GDeferred<Path> gDeferred = this.d_v0;
        if (gDeferred == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v0");
            gDeferred = null;
        }
        return ChatDatabaseBuilderModuleKt.provideChatDBBasePath((Path) gDeferred.getCompleted());
    }
}