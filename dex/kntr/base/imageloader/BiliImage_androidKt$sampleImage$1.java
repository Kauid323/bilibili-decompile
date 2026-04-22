package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliImage.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.imageloader.BiliImage_androidKt", f = "BiliImage.android.kt", i = {0, 0, 0, 0}, l = {243}, m = "sampleImage", n = {"$this$sampleImage", "options", "bitmap", "inSampleSize"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class BiliImage_androidKt$sampleImage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliImage_androidKt$sampleImage$1(Continuation<? super BiliImage_androidKt$sampleImage$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object sampleImage = BiliImage_androidKt.sampleImage(null, 0, (Continuation) this);
        return sampleImage == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sampleImage : Result.m2635boximpl(sampleImage);
    }
}