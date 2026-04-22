package kntr.common.photonic.gallery.entity;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumContentReader;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformAlbumInfo.android.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/common/photonic/gallery/entity/AndroidAlbumInfo;", "Lkntr/common/photonic/AlbumInfo;", "title", "", "id", "assetList", "", "Lkntr/common/photonic/Asset;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getId", "reader", "Lkntr/common/photonic/AlbumContentReader;", "resourceCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "", "other", "", "hashCode", "", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AndroidAlbumInfo implements AlbumInfo {
    public static final int $stable = 8;
    private final List<Asset> assetList;
    private final String id;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidAlbumInfo(String title, String id, List<? extends Asset> list) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(list, "assetList");
        this.title = title;
        this.id = id;
        this.assetList = list;
    }

    public /* synthetic */ AndroidAlbumInfo(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @Override // kntr.common.photonic.AlbumInfo
    public String getTitle() {
        return this.title;
    }

    @Override // kntr.common.photonic.AlbumInfo
    public String getId() {
        return this.id;
    }

    @Override // kntr.common.photonic.AlbumInfo
    public AlbumContentReader reader() {
        return new AlbumContentReaderImpl(this.assetList);
    }

    @Override // kntr.common.photonic.AlbumInfo
    public Object resourceCount(Continuation<? super Long> continuation) {
        return Boxing.boxLong(this.assetList.size());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AndroidAlbumInfo) && Intrinsics.areEqual(getTitle(), ((AndroidAlbumInfo) other).getTitle()) && Intrinsics.areEqual(getId(), ((AndroidAlbumInfo) other).getId());
    }

    public int hashCode() {
        return (getTitle().hashCode() * 31) + getId().hashCode();
    }
}