package kntr.common.photonic.gallery.entity;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumContentReader;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: PlatformAlbumInfo.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0096@¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/common/photonic/gallery/entity/AlbumContentReaderImpl;", "Lkntr/common/photonic/AlbumContentReader;", "list", "", "Lkntr/common/photonic/Asset;", "<init>", "(Ljava/util/List;)V", "read", "Lkotlinx/coroutines/flow/Flow;", "thumbnail", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AlbumContentReaderImpl implements AlbumContentReader {
    public static final int $stable = 8;
    private final List<Asset> list;

    /* JADX WARN: Multi-variable type inference failed */
    public AlbumContentReaderImpl(List<? extends Asset> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    @Override // kntr.common.photonic.AlbumContentReader
    public Flow<Asset> read() {
        return FlowKt.asFlow(this.list);
    }

    @Override // kntr.common.photonic.AlbumContentReader
    public Object thumbnail(Continuation<? super Asset> continuation) {
        return CollectionsKt.firstOrNull(this.list);
    }
}