package kntr.base.mod.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.internal.KModImpl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$StorageManager", f = "KModImpl.kt", i = {0, 0, 0}, l = {819}, m = "loadPool", n = {"scope", "poolRoot", "poolName"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class KModImpl$StorageManager$loadPool$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KModImpl.StorageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$StorageManager$loadPool$1(KModImpl.StorageManager storageManager, Continuation<? super KModImpl$StorageManager$loadPool$1> continuation) {
        super(continuation);
        this.this$0 = storageManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadPool(null, null, (Continuation) this);
    }
}