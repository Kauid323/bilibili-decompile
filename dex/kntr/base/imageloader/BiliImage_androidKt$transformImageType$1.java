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
@DebugMetadata(c = "kntr.base.imageloader.BiliImage_androidKt", f = "BiliImage.android.kt", i = {0, 0, 0, 0}, l = {228}, m = "transformImageType", n = {"$this$transformImageType", "imageType", "options", "targetFormat"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class BiliImage_androidKt$transformImageType$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliImage_androidKt$transformImageType$1(Continuation<? super BiliImage_androidKt$transformImageType$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object transformImageType = BiliImage_androidKt.transformImageType(null, null, (Continuation) this);
        return transformImageType == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transformImageType : Result.m2635boximpl(transformImageType);
    }
}