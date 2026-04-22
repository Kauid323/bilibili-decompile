package kntr.base.mod.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.internal.KModImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.files.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/base/mod/internal/KModImpl$ModResourceImpl;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$StorageManager$loadPool$resources$1$1", f = "KModImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KModImpl$StorageManager$loadPool$resources$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KModImpl.ModResourceImpl>, Object> {
    final /* synthetic */ Path $it;
    final /* synthetic */ String $poolName;
    int label;
    final /* synthetic */ KModImpl.StorageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$StorageManager$loadPool$resources$1$1(KModImpl.StorageManager storageManager, String str, Path path, Continuation<? super KModImpl$StorageManager$loadPool$resources$1$1> continuation) {
        super(2, continuation);
        this.this$0 = storageManager;
        this.$poolName = str;
        this.$it = path;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KModImpl$StorageManager$loadPool$resources$1$1(this.this$0, this.$poolName, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KModImpl.ModResourceImpl> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return this.this$0.loadModResource(this.$poolName, this.$it);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}