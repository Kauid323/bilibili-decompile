package kntr.common.photonic.aphro.ui.preview.model;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePreviewDataSource.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewSelectResult;", "", "selectedAssets", "", "Lkntr/common/photonic/Asset;", "useOriginImage", "", "<init>", "(Ljava/util/List;Z)V", "getSelectedAssets", "()Ljava/util/List;", "getUseOriginImage", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewSelectResult {
    public static final int $stable = 8;
    private final List<Asset> selectedAssets;
    private final boolean useOriginImage;

    public ImagePreviewSelectResult() {
        this(null, false, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImagePreviewSelectResult copy$default(ImagePreviewSelectResult imagePreviewSelectResult, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = imagePreviewSelectResult.selectedAssets;
        }
        if ((i & 2) != 0) {
            z = imagePreviewSelectResult.useOriginImage;
        }
        return imagePreviewSelectResult.copy(list, z);
    }

    public final List<Asset> component1() {
        return this.selectedAssets;
    }

    public final boolean component2() {
        return this.useOriginImage;
    }

    public final ImagePreviewSelectResult copy(List<? extends Asset> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "selectedAssets");
        return new ImagePreviewSelectResult(list, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImagePreviewSelectResult) {
            ImagePreviewSelectResult imagePreviewSelectResult = (ImagePreviewSelectResult) obj;
            return Intrinsics.areEqual(this.selectedAssets, imagePreviewSelectResult.selectedAssets) && this.useOriginImage == imagePreviewSelectResult.useOriginImage;
        }
        return false;
    }

    public int hashCode() {
        return (this.selectedAssets.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOriginImage);
    }

    public String toString() {
        List<Asset> list = this.selectedAssets;
        return "ImagePreviewSelectResult(selectedAssets=" + list + ", useOriginImage=" + this.useOriginImage + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImagePreviewSelectResult(List<? extends Asset> list, boolean useOriginImage) {
        Intrinsics.checkNotNullParameter(list, "selectedAssets");
        this.selectedAssets = list;
        this.useOriginImage = useOriginImage;
    }

    public /* synthetic */ ImagePreviewSelectResult(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? false : z);
    }

    public final List<Asset> getSelectedAssets() {
        return this.selectedAssets;
    }

    public final boolean getUseOriginImage() {
        return this.useOriginImage;
    }
}