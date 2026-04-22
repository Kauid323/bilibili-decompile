package kntr.common.paragraph.assetuploader.base;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetUploaderResult.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u001e"}, d2 = {"Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "asset", "Lkntr/common/photonic/Asset;", "useOrigin", "", "<init>", "(Lkntr/common/photonic/Asset;Z)V", "getAsset", "()Lkntr/common/photonic/Asset;", "getUseOrigin", "()Z", "resolution", "Lkntr/common/photonic/Resolution;", "getResolution", "()Lkntr/common/photonic/Resolution;", "uploadFinished", "getUploadFinished", "uploadSucceed", "getUploadSucceed", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OriginAssetUploadState implements AssetUploadState {
    private final Asset asset;
    private final boolean useOrigin;

    public static /* synthetic */ OriginAssetUploadState copy$default(OriginAssetUploadState originAssetUploadState, Asset asset, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            asset = originAssetUploadState.asset;
        }
        if ((i & 2) != 0) {
            z = originAssetUploadState.useOrigin;
        }
        return originAssetUploadState.copy(asset, z);
    }

    public final Asset component1() {
        return this.asset;
    }

    public final boolean component2() {
        return this.useOrigin;
    }

    public final OriginAssetUploadState copy(Asset asset, boolean z) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        return new OriginAssetUploadState(asset, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OriginAssetUploadState) {
            OriginAssetUploadState originAssetUploadState = (OriginAssetUploadState) obj;
            return Intrinsics.areEqual(this.asset, originAssetUploadState.asset) && this.useOrigin == originAssetUploadState.useOrigin;
        }
        return false;
    }

    public int hashCode() {
        return (this.asset.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOrigin);
    }

    public String toString() {
        Asset asset = this.asset;
        return "OriginAssetUploadState(asset=" + asset + ", useOrigin=" + this.useOrigin + ")";
    }

    public OriginAssetUploadState(Asset asset, boolean useOrigin) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        this.asset = asset;
        this.useOrigin = useOrigin;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public Asset getAsset() {
        return this.asset;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUseOrigin() {
        return this.useOrigin;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public Resolution getResolution() {
        return getAsset().getRotatedResolution();
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUploadFinished() {
        return false;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUploadSucceed() {
        return false;
    }
}