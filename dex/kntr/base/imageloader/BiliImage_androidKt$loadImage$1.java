package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliImage.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.imageloader.BiliImage_androidKt", f = "BiliImage.android.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {382, 134}, m = "loadImage", n = {"request", "lifecycle", "error", "$i$f$suspendCancellableCoroutine", "request", "lifecycle", "error", "originSource"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class BiliImage_androidKt$loadImage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliImage_androidKt$loadImage$1(Continuation<? super BiliImage_androidKt$loadImage$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BiliImage_androidKt.loadImage(null, null, (Continuation) this);
    }
}