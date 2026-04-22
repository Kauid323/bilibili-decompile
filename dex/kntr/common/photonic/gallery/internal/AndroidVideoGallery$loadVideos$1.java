package kntr.common.photonic.gallery.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidVideoGallery.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.gallery.internal.AndroidVideoGallery", f = "AndroidVideoGallery.kt", i = {0, 0, 0}, l = {47}, m = "loadVideos", n = {"cr", "pagination", "videoDataSet"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class AndroidVideoGallery$loadVideos$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidVideoGallery this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidVideoGallery$loadVideos$1(AndroidVideoGallery androidVideoGallery, Continuation<? super AndroidVideoGallery$loadVideos$1> continuation) {
        super(continuation);
        this.this$0 = androidVideoGallery;
    }

    public final Object invokeSuspend(Object obj) {
        Object loadVideos;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadVideos = this.this$0.loadVideos(null, null, (Continuation) this);
        return loadVideos;
    }
}