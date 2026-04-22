package kntr.common.photonic.gallery.entity;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumContentReader;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: PlatformAlbumInfo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lkntr/common/photonic/gallery/entity/AlbumContentNonPaginationReader;", "", "reader", "Lkntr/common/photonic/AlbumContentReader;", "<init>", "(Lkntr/common/photonic/AlbumContentReader;)V", "getReader", "()Lkntr/common/photonic/AlbumContentReader;", "read", "Lkotlinx/coroutines/flow/Flow;", "", "Lkntr/common/photonic/Asset;", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AlbumContentNonPaginationReader {
    public static final int $stable = 8;
    private final AlbumContentReader reader;

    public AlbumContentNonPaginationReader(AlbumContentReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.reader = reader;
    }

    public final AlbumContentReader getReader() {
        return this.reader;
    }

    public final Flow<List<Asset>> read() {
        return FlowKt.flow(new AlbumContentNonPaginationReader$read$1(this, null));
    }
}