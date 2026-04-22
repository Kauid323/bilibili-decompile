package kntr.base.mod.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.internal.KModImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkntr/base/mod/internal/KModImpl$ModPoolImpl;", "Lkntr/base/mod/internal/KModImpl;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$StorageManager$startUp$2", f = "KModImpl.kt", i = {0}, l = {803}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"}, v = 1)
public final class KModImpl$StorageManager$startUp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends KModImpl.ModPoolImpl>>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KModImpl.StorageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$StorageManager$startUp$2(KModImpl.StorageManager storageManager, Continuation<? super KModImpl$StorageManager$startUp$2> continuation) {
        super(2, continuation);
        this.this$0 = storageManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kModImpl$StorageManager$startUp$2 = new KModImpl$StorageManager$startUp$2(this.this$0, continuation);
        kModImpl$StorageManager$startUp$2.L$0 = obj;
        return kModImpl$StorageManager$startUp$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<KModImpl.ModPoolImpl>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = FileSystemJvmKt.SystemFileSystem.list(this.this$0.getModsDir());
                KModImpl.StorageManager storageManager = this.this$0;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Path d = (Path) item$iv$iv;
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new KModImpl$StorageManager$startUp$2$1$1(storageManager, d, null), 3, (Object) null));
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.label = 1;
                Object awaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                if (awaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return awaitAll;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}