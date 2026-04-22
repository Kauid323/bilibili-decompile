package kntr.common.photonic.gallery;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetType;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;

/* compiled from: Gallery.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/common/photonic/gallery/AndroidAsset;", "Lkntr/common/photonic/Asset;", "albumInfo", "Lkntr/common/photonic/AlbumInfo;", "getAlbumInfo", "()Lkntr/common/photonic/AlbumInfo;", "path", "", "getPath", "()Ljava/lang/String;", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AndroidAsset extends Asset {
    AlbumInfo getAlbumInfo();

    String getPath();

    /* compiled from: Gallery.android.kt */
    /* renamed from: kntr.common.photonic.gallery.AndroidAsset$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
    }

    /* compiled from: Gallery.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static AssetType getAssetType(AndroidAsset $this) {
            return Asset.CC.$default$getAssetType($this);
        }

        @Deprecated
        public static Resolution getRotatedResolution(AndroidAsset $this) {
            return Asset.CC.$default$getRotatedResolution($this);
        }
    }
}