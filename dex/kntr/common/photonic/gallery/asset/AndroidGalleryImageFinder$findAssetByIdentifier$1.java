package kntr.common.photonic.gallery.asset;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidGalleryImageFinder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.gallery.asset.AndroidGalleryImageFinder", f = "AndroidGalleryImageFinder.kt", i = {0, 0, 0}, l = {37}, m = "findAssetByIdentifier-gIAlu-s", n = {"identifier", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-AndroidGalleryImageFinder$findAssetByIdentifier$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class AndroidGalleryImageFinder$findAssetByIdentifier$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidGalleryImageFinder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidGalleryImageFinder$findAssetByIdentifier$1(AndroidGalleryImageFinder androidGalleryImageFinder, Continuation<? super AndroidGalleryImageFinder$findAssetByIdentifier$1> continuation) {
        super(continuation);
        this.this$0 = androidGalleryImageFinder;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo2332findAssetByIdentifiergIAlus = this.this$0.mo2332findAssetByIdentifiergIAlus(null, (Continuation) this);
        return mo2332findAssetByIdentifiergIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo2332findAssetByIdentifiergIAlus : Result.m2635boximpl(mo2332findAssetByIdentifiergIAlus);
    }
}