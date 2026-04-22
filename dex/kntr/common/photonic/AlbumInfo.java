package kntr.common.photonic;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: Album.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\u000e\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/common/photonic/AlbumInfo;", "", "title", "", "getTitle", "()Ljava/lang/String;", "id", "getId", "reader", "Lkntr/common/photonic/AlbumContentReader;", "resourceCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AlbumInfo {
    String getId();

    String getTitle();

    AlbumContentReader reader();

    Object resourceCount(Continuation<? super Long> continuation);
}