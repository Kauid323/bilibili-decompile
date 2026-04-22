package kntr.common.photonic.gallery.entity;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.gallery.entity.AlbumContentPaginationReader$read$2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlatformAlbumInfo.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.gallery.entity.AlbumContentPaginationReader$read$2$1", f = "PlatformAlbumInfo.kt", i = {0}, l = {40}, m = "emit", n = {"asset"}, s = {"L$0"}, v = 1)
public final class AlbumContentPaginationReader$read$2$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlbumContentPaginationReader$read$2.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AlbumContentPaginationReader$read$2$1$emit$1(AlbumContentPaginationReader$read$2.AnonymousClass1<? super T> anonymousClass1, Continuation<? super AlbumContentPaginationReader$read$2$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Asset) null, (Continuation) this);
    }
}