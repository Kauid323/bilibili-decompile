package kntr.common.photonic.aphro.ui.preview.model;

import androidx.compose.ui.unit.IntRect;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreviewableAsset.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"asPreviewableAsset", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "Lkntr/common/photonic/Asset;", "thumbnailImageSource", "Lkntr/base/imageloader/ImageSource;", "thumbnailRect", "Landroidx/compose/ui/unit/IntRect;", "supportThumbnail", "", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PreviewableAssetKt {
    public static /* synthetic */ PreviewableAsset asPreviewableAsset$default(Asset asset, ImageSource imageSource, IntRect intRect, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            imageSource = null;
        }
        if ((i & 2) != 0) {
            intRect = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return asPreviewableAsset(asset, imageSource, intRect, z);
    }

    public static final PreviewableAsset asPreviewableAsset(Asset $this$asPreviewableAsset, ImageSource thumbnailImageSource, IntRect thumbnailRect, boolean supportThumbnail) {
        Intrinsics.checkNotNullParameter($this$asPreviewableAsset, "<this>");
        return new WrapPreviewableAsset($this$asPreviewableAsset, thumbnailImageSource, thumbnailRect, supportThumbnail);
    }
}