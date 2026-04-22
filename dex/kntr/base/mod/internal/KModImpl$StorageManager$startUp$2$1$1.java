package kntr.base.mod.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.internal.KModImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.files.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001R\u00020\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkntr/base/mod/internal/KModImpl$ModPoolImpl;", "Lkntr/base/mod/internal/KModImpl;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$StorageManager$startUp$2$1$1", f = "KModImpl.kt", i = {0}, l = {801}, m = "invokeSuspend", n = {"$this$async"}, s = {"L$0"}, v = 1)
public final class KModImpl$StorageManager$startUp$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KModImpl.ModPoolImpl>, Object> {
    final /* synthetic */ Path $d;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KModImpl.StorageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$StorageManager$startUp$2$1$1(KModImpl.StorageManager storageManager, Path path, Continuation<? super KModImpl$StorageManager$startUp$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = storageManager;
        this.$d = path;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kModImpl$StorageManager$startUp$2$1$1 = new KModImpl$StorageManager$startUp$2$1$1(this.this$0, this.$d, continuation);
        kModImpl$StorageManager$startUp$2$1$1.L$0 = obj;
        return kModImpl$StorageManager$startUp$2$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KModImpl.ModPoolImpl> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$async = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$async);
                this.label = 1;
                Object loadPool = this.this$0.loadPool($this$async, this.$d, (Continuation) this);
                if (loadPool == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return loadPool;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}