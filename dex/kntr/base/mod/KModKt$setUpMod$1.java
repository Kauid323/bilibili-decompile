package kntr.base.mod;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KMod.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.KModKt", f = "KMod.kt", i = {0, 0, 0, 0, 0}, l = {24}, m = "setUpMod", n = {"downloader", "neuron", "options", "$this$setUpMod_u24lambda_u240", "$i$a$-apply-KModKt$setUpMod$2"}, s = {"L$0", "L$1", "L$2", "L$4", "I$0"}, v = 1)
public final class KModKt$setUpMod$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KModKt$setUpMod$1(Continuation<? super KModKt$setUpMod$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return KModKt.setUpMod(null, null, null, (Continuation) this);
    }
}