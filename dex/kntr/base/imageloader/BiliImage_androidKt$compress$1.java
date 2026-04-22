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
@DebugMetadata(c = "kntr.base.imageloader.BiliImage_androidKt", f = "BiliImage.android.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {343}, m = "compress", n = {"$this$compress", "options", "targetFormat", "$this$compress_u24lambda_u240", "it", "compressFormat", "quality", "$i$a$-runCatching-BiliImage_androidKt$compress$2", "$i$a$-use-BiliImage_androidKt$compress$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
public final class BiliImage_androidKt$compress$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliImage_androidKt$compress$1(Continuation<? super BiliImage_androidKt$compress$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object compress;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        compress = BiliImage_androidKt.compress(null, null, 0, null, (Continuation) this);
        return compress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? compress : Result.m2635boximpl(compress);
    }
}