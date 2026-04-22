package kntr.app.im.chat.db.di;

import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.im.chat.db.ChatDatabaseConfigurationSet;
import kntr.app.im.chat.db.ChatDatabaseConfigurer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: ChatDatabaseConfigModuleKt_provideChatDatabaseConfig_Lambda.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000e\u001a\u00020\u0000H\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u000e\u0010\u0013\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/db/di/ChatDatabaseConfigModuleKt_provideChatDatabaseConfig_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lkntr/app/im/chat/db/ChatDatabaseConfigurationSet;", "v0", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/app/im/chat/db/ChatDatabaseConfigurer;", "compatJavaParam", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/util/Set;Lkotlin/Unit;)V", "d_v0", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bilibili/lib/gripper/api/GDeferred;", "create", "prepareParams", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatDatabaseConfigModuleKt_provideChatDatabaseConfig_Lambda extends ProducerBase<ChatDatabaseConfigurationSet> {
    private Collection<? extends GDeferred<? extends ChatDatabaseConfigurer>> d_v0;
    private final Set<SuspendProducer<ChatDatabaseConfigurer>> v0;

    public ChatDatabaseConfigModuleKt_provideChatDatabaseConfig_Lambda(Set<? extends SuspendProducer<ChatDatabaseConfigurer>> set, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(set, "v0");
        this.v0 = set;
    }

    public ChatDatabaseConfigModuleKt_provideChatDatabaseConfig_Lambda create() {
        return new ChatDatabaseConfigModuleKt_provideChatDatabaseConfig_Lambda(this.v0, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferredSet(context, r, this.v0);
        return r;
    }

    protected Object invokeProducer(Continuation<? super ChatDatabaseConfigurationSet> continuation) {
        Collection<? extends GDeferred<? extends ChatDatabaseConfigurer>> collection = this.d_v0;
        if (collection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v0");
            collection = null;
        }
        return ChatDatabaseConfigModuleKt.provideChatDatabaseConfig(GenerateHelper.getDeferredCompletedSet(collection));
    }
}