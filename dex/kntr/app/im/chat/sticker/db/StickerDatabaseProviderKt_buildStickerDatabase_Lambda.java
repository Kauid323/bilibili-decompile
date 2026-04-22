package kntr.app.im.chat.sticker.db;

import android.app.Application;
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

/* compiled from: StickerDatabaseProviderKt_buildStickerDatabase_Lambda.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000f\u001a\u00020\u0000H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u000e\u0010\u0015\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/app/im/chat/sticker/db/StickerDatabaseProviderKt_buildStickerDatabase_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lkntr/app/im/chat/sticker/db/StickerDatabase;", "v0", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Landroid/app/Application;", "v1", "Lkotlinx/io/files/Path;", "compatJavaParam", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lkotlin/Unit;)V", "d_v0", "Lcom/bilibili/lib/gripper/api/GDeferred;", "d_v1", "create", "prepareParams", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerDatabaseProviderKt_buildStickerDatabase_Lambda extends ProducerBase<StickerDatabase> {
    public static final int $stable = 8;
    private GDeferred<? extends Application> d_v0;
    private GDeferred<Path> d_v1;
    private final SuspendProducer<Application> v0;
    private final SuspendProducer<Path> v1;

    public StickerDatabaseProviderKt_buildStickerDatabase_Lambda(SuspendProducer<Application> suspendProducer, SuspendProducer<Path> suspendProducer2, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(suspendProducer, "v0");
        Intrinsics.checkNotNullParameter(suspendProducer2, "v1");
        this.v0 = suspendProducer;
        this.v1 = suspendProducer2;
    }

    public StickerDatabaseProviderKt_buildStickerDatabase_Lambda create() {
        return new StickerDatabaseProviderKt_buildStickerDatabase_Lambda(this.v0, this.v1, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferred(context, r, this.v0);
        this.d_v1 = GenerateHelper.deferred(context, r, this.v1);
        return r;
    }

    protected Object invokeProducer(Continuation<? super StickerDatabase> continuation) {
        GDeferred<? extends Application> gDeferred = this.d_v0;
        GDeferred<Path> gDeferred2 = null;
        if (gDeferred == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v0");
            gDeferred = null;
        }
        Application application = (Application) gDeferred.getCompleted();
        GDeferred<Path> gDeferred3 = this.d_v1;
        if (gDeferred3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v1");
        } else {
            gDeferred2 = gDeferred3;
        }
        return StickerDatabaseProvider_androidKt.buildStickerDatabase(application, (Path) gDeferred2.getCompleted());
    }
}