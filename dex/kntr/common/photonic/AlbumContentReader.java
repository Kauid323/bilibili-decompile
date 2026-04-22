package kntr.common.photonic;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: Album.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/AlbumContentReader;", "", "read", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/common/photonic/Asset;", "thumbnail", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AlbumContentReader {
    Flow<Asset> read();

    Object thumbnail(Continuation<? super Asset> continuation);
}