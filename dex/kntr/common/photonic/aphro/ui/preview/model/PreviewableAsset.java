package kntr.common.photonic.aphro.ui.preview.model;

import androidx.compose.ui.unit.IntRect;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetType;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;

/* compiled from: PreviewableAsset.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "Lkntr/common/photonic/Asset;", "thumbnailImageSource", "Lkntr/base/imageloader/ImageSource;", "getThumbnailImageSource", "()Lkntr/base/imageloader/ImageSource;", "thumbnailRect", "Landroidx/compose/ui/unit/IntRect;", "getThumbnailRect", "()Landroidx/compose/ui/unit/IntRect;", "supportThumbnail", "", "getSupportThumbnail", "()Z", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface PreviewableAsset extends Asset {
    boolean getSupportThumbnail();

    ImageSource getThumbnailImageSource();

    IntRect getThumbnailRect();

    /* compiled from: PreviewableAsset.kt */
    /* renamed from: kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
    }

    /* compiled from: PreviewableAsset.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static AssetType getAssetType(PreviewableAsset $this) {
            return Asset.CC.$default$getAssetType($this);
        }

        @Deprecated
        public static Resolution getRotatedResolution(PreviewableAsset $this) {
            return Asset.CC.$default$getRotatedResolution($this);
        }
    }
}