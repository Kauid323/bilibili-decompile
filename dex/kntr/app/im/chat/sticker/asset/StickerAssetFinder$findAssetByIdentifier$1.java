package kntr.app.im.chat.sticker.asset;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerAssetFinder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.asset.StickerAssetFinder", f = "StickerAssetFinder.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {39, 40}, m = "findAssetByIdentifier-gIAlu-s", n = {"identifier", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-StickerAssetFinder$findAssetByIdentifier$2", "identifier", "entity", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-StickerAssetFinder$findAssetByIdentifier$2"}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 1)
public final class StickerAssetFinder$findAssetByIdentifier$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerAssetFinder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerAssetFinder$findAssetByIdentifier$1(StickerAssetFinder stickerAssetFinder, Continuation<? super StickerAssetFinder$findAssetByIdentifier$1> continuation) {
        super(continuation);
        this.this$0 = stickerAssetFinder;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m1647findAssetByIdentifiergIAlus = this.this$0.m1647findAssetByIdentifiergIAlus(null, (Continuation) this);
        return m1647findAssetByIdentifiergIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1647findAssetByIdentifiergIAlus : Result.box-impl(m1647findAssetByIdentifiergIAlus);
    }
}