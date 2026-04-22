package kntr.common.photonic.gallery.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidImageGallery.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.gallery.internal.AndroidImageGallery", f = "AndroidImageGallery.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {53}, m = "buildAlbumList", n = {"cr", "bucketId", "options", "forType", "imageMimeType", "args", "order", "isDefaultAlbum"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 1)
public final class AndroidImageGallery$buildAlbumList$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidImageGallery this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidImageGallery$buildAlbumList$1(AndroidImageGallery androidImageGallery, Continuation<? super AndroidImageGallery$buildAlbumList$1> continuation) {
        super(continuation);
        this.this$0 = androidImageGallery;
    }

    public final Object invokeSuspend(Object obj) {
        Object buildAlbumList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        buildAlbumList = this.this$0.buildAlbumList(null, null, null, (Continuation) this);
        return buildAlbumList;
    }
}