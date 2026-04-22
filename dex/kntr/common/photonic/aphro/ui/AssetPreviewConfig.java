package kntr.common.photonic.aphro.ui;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetPreview.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JM\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lkntr/common/photonic/aphro/ui/AssetPreviewConfig;", "", "currentAsset", "Lkntr/common/photonic/Asset;", "maxSelectCount", "", "remainingSelectCount", "selectedAsset", "", "albumInfo", "Lkntr/common/photonic/AlbumInfo;", "useOriginImage", "", "<init>", "(Lkntr/common/photonic/Asset;IILjava/util/List;Lkntr/common/photonic/AlbumInfo;Z)V", "getCurrentAsset", "()Lkntr/common/photonic/Asset;", "getMaxSelectCount", "()I", "getRemainingSelectCount", "getSelectedAsset", "()Ljava/util/List;", "getAlbumInfo", "()Lkntr/common/photonic/AlbumInfo;", "getUseOriginImage", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetPreviewConfig {
    public static final int $stable = 8;
    private final AlbumInfo albumInfo;
    private final Asset currentAsset;
    private final int maxSelectCount;
    private final int remainingSelectCount;
    private final List<Asset> selectedAsset;
    private final boolean useOriginImage;

    public static /* synthetic */ AssetPreviewConfig copy$default(AssetPreviewConfig assetPreviewConfig, Asset asset, int i, int i2, List list, AlbumInfo albumInfo, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            asset = assetPreviewConfig.currentAsset;
        }
        if ((i3 & 2) != 0) {
            i = assetPreviewConfig.maxSelectCount;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = assetPreviewConfig.remainingSelectCount;
        }
        int i5 = i2;
        List<Asset> list2 = list;
        if ((i3 & 8) != 0) {
            list2 = assetPreviewConfig.selectedAsset;
        }
        List list3 = list2;
        if ((i3 & 16) != 0) {
            albumInfo = assetPreviewConfig.albumInfo;
        }
        AlbumInfo albumInfo2 = albumInfo;
        if ((i3 & 32) != 0) {
            z = assetPreviewConfig.useOriginImage;
        }
        return assetPreviewConfig.copy(asset, i4, i5, list3, albumInfo2, z);
    }

    public final Asset component1() {
        return this.currentAsset;
    }

    public final int component2() {
        return this.maxSelectCount;
    }

    public final int component3() {
        return this.remainingSelectCount;
    }

    public final List<Asset> component4() {
        return this.selectedAsset;
    }

    public final AlbumInfo component5() {
        return this.albumInfo;
    }

    public final boolean component6() {
        return this.useOriginImage;
    }

    public final AssetPreviewConfig copy(Asset asset, int i, int i2, List<? extends Asset> list, AlbumInfo albumInfo, boolean z) {
        Intrinsics.checkNotNullParameter(asset, "currentAsset");
        Intrinsics.checkNotNullParameter(list, "selectedAsset");
        return new AssetPreviewConfig(asset, i, i2, list, albumInfo, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AssetPreviewConfig) {
            AssetPreviewConfig assetPreviewConfig = (AssetPreviewConfig) obj;
            return Intrinsics.areEqual(this.currentAsset, assetPreviewConfig.currentAsset) && this.maxSelectCount == assetPreviewConfig.maxSelectCount && this.remainingSelectCount == assetPreviewConfig.remainingSelectCount && Intrinsics.areEqual(this.selectedAsset, assetPreviewConfig.selectedAsset) && Intrinsics.areEqual(this.albumInfo, assetPreviewConfig.albumInfo) && this.useOriginImage == assetPreviewConfig.useOriginImage;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.currentAsset.hashCode() * 31) + this.maxSelectCount) * 31) + this.remainingSelectCount) * 31) + this.selectedAsset.hashCode()) * 31) + (this.albumInfo == null ? 0 : this.albumInfo.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOriginImage);
    }

    public String toString() {
        Asset asset = this.currentAsset;
        int i = this.maxSelectCount;
        int i2 = this.remainingSelectCount;
        List<Asset> list = this.selectedAsset;
        AlbumInfo albumInfo = this.albumInfo;
        return "AssetPreviewConfig(currentAsset=" + asset + ", maxSelectCount=" + i + ", remainingSelectCount=" + i2 + ", selectedAsset=" + list + ", albumInfo=" + albumInfo + ", useOriginImage=" + this.useOriginImage + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AssetPreviewConfig(Asset currentAsset, int maxSelectCount, int remainingSelectCount, List<? extends Asset> list, AlbumInfo albumInfo, boolean useOriginImage) {
        Intrinsics.checkNotNullParameter(currentAsset, "currentAsset");
        Intrinsics.checkNotNullParameter(list, "selectedAsset");
        this.currentAsset = currentAsset;
        this.maxSelectCount = maxSelectCount;
        this.remainingSelectCount = remainingSelectCount;
        this.selectedAsset = list;
        this.albumInfo = albumInfo;
        this.useOriginImage = useOriginImage;
    }

    public /* synthetic */ AssetPreviewConfig(Asset asset, int i, int i2, List list, AlbumInfo albumInfo, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(asset, i, i2, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list, (i3 & 16) != 0 ? null : albumInfo, (i3 & 32) != 0 ? false : z);
    }

    public final Asset getCurrentAsset() {
        return this.currentAsset;
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final int getRemainingSelectCount() {
        return this.remainingSelectCount;
    }

    public final List<Asset> getSelectedAsset() {
        return this.selectedAsset;
    }

    public final AlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public final boolean getUseOriginImage() {
        return this.useOriginImage;
    }
}