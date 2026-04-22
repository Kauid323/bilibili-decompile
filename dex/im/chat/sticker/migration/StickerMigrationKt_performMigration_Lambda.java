package im.chat.sticker.migration;

import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import im.base.config.IMConfigSetting;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: StickerMigrationKt_performMigration_Lambda.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0014\u001a\u00020\u0000H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u000e\u0010\u001a\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lim/chat/sticker/migration/StickerMigrationKt_performMigration_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "", "v0", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lim/chat/sticker/migration/LegacyStickerCollectionProvider;", "v1", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "v2", "Lkntr/base/account/KAccountStore;", "v3", "Lim/base/config/IMConfigSetting;", "compatJavaParam", "<init>", "(Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lkotlin/Unit;)V", "d_v0", "Lcom/bilibili/lib/gripper/api/GDeferred;", "d_v1", "d_v2", "d_v3", "create", "prepareParams", "", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migration_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerMigrationKt_performMigration_Lambda extends ProducerBase<Unit> {
    private GDeferred<? extends LegacyStickerCollectionProvider> d_v0;
    private GDeferred<? extends StickerManagerService> d_v1;
    private GDeferred<KAccountStore> d_v2;
    private GDeferred<IMConfigSetting> d_v3;
    private final SuspendProducer<LegacyStickerCollectionProvider> v0;
    private final SuspendProducer<StickerManagerService> v1;
    private final SuspendProducer<KAccountStore> v2;
    private final SuspendProducer<IMConfigSetting> v3;

    public StickerMigrationKt_performMigration_Lambda(SuspendProducer<LegacyStickerCollectionProvider> suspendProducer, SuspendProducer<StickerManagerService> suspendProducer2, SuspendProducer<KAccountStore> suspendProducer3, SuspendProducer<IMConfigSetting> suspendProducer4, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(suspendProducer, "v0");
        Intrinsics.checkNotNullParameter(suspendProducer2, "v1");
        Intrinsics.checkNotNullParameter(suspendProducer3, "v2");
        Intrinsics.checkNotNullParameter(suspendProducer4, "v3");
        this.v0 = suspendProducer;
        this.v1 = suspendProducer2;
        this.v2 = suspendProducer3;
        this.v3 = suspendProducer4;
    }

    public StickerMigrationKt_performMigration_Lambda create() {
        return new StickerMigrationKt_performMigration_Lambda(this.v0, this.v1, this.v2, this.v3, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferred(context, r, this.v0);
        this.d_v1 = GenerateHelper.deferred(context, r, this.v1);
        this.d_v2 = GenerateHelper.deferred(context, r, this.v2);
        this.d_v3 = GenerateHelper.deferred(context, r, this.v3);
        return r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invokeProducer(Continuation<? super Unit> continuation) {
        StickerMigrationKt_performMigration_Lambda$invokeProducer$1 stickerMigrationKt_performMigration_Lambda$invokeProducer$1;
        if (continuation instanceof StickerMigrationKt_performMigration_Lambda$invokeProducer$1) {
            stickerMigrationKt_performMigration_Lambda$invokeProducer$1 = (StickerMigrationKt_performMigration_Lambda$invokeProducer$1) continuation;
            if ((stickerMigrationKt_performMigration_Lambda$invokeProducer$1.label & Integer.MIN_VALUE) != 0) {
                stickerMigrationKt_performMigration_Lambda$invokeProducer$1.label -= Integer.MIN_VALUE;
                Object $result = stickerMigrationKt_performMigration_Lambda$invokeProducer$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (stickerMigrationKt_performMigration_Lambda$invokeProducer$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        GDeferred<? extends LegacyStickerCollectionProvider> gDeferred = this.d_v0;
                        GDeferred<IMConfigSetting> gDeferred2 = null;
                        if (gDeferred == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("d_v0");
                            gDeferred = null;
                        }
                        LegacyStickerCollectionProvider legacyStickerCollectionProvider = (LegacyStickerCollectionProvider) gDeferred.getCompleted();
                        GDeferred<? extends StickerManagerService> gDeferred3 = this.d_v1;
                        if (gDeferred3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("d_v1");
                            gDeferred3 = null;
                        }
                        StickerManagerService stickerManagerService = (StickerManagerService) gDeferred3.getCompleted();
                        GDeferred<KAccountStore> gDeferred4 = this.d_v2;
                        if (gDeferred4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("d_v2");
                            gDeferred4 = null;
                        }
                        KAccountStore kAccountStore = (KAccountStore) gDeferred4.getCompleted();
                        GDeferred<IMConfigSetting> gDeferred5 = this.d_v3;
                        if (gDeferred5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("d_v3");
                        } else {
                            gDeferred2 = gDeferred5;
                        }
                        stickerMigrationKt_performMigration_Lambda$invokeProducer$1.label = 1;
                        if (StickerMigrationKt.performMigration(legacyStickerCollectionProvider, stickerManagerService, kAccountStore, (IMConfigSetting) gDeferred2.getCompleted(), stickerMigrationKt_performMigration_Lambda$invokeProducer$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        stickerMigrationKt_performMigration_Lambda$invokeProducer$1 = new StickerMigrationKt_performMigration_Lambda$invokeProducer$1(this, continuation);
        Object $result2 = stickerMigrationKt_performMigration_Lambda$invokeProducer$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (stickerMigrationKt_performMigration_Lambda$invokeProducer$1.label) {
        }
        return Unit.INSTANCE;
    }
}