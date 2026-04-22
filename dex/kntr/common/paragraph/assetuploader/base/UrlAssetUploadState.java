package kntr.common.paragraph.assetuploader.base;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.ImageUploadResult;
import kntr.common.photonic.Asset;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetUploaderResult.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015¨\u0006("}, d2 = {"Lkntr/common/paragraph/assetuploader/base/UrlAssetUploadState;", "Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "originAssetState", "Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "result", "Lkntr/common/paragraph/assetuploader/ImageUploadResult;", "<init>", "(Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;Lkntr/common/paragraph/assetuploader/ImageUploadResult;)V", "getOriginAssetState", "()Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "getResult$annotations", "()V", "getResult", "()Lkntr/common/paragraph/assetuploader/ImageUploadResult;", "asset", "Lkntr/common/photonic/Asset;", "getAsset", "()Lkntr/common/photonic/Asset;", "useOrigin", "", "getUseOrigin", "()Z", "resolution", "Lkntr/common/photonic/Resolution;", "getResolution", "()Lkntr/common/photonic/Resolution;", "uploadFinished", "getUploadFinished", "uploadSucceed", "getUploadSucceed", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UrlAssetUploadState implements AssetUploadState {
    private final OriginAssetUploadState originAssetState;
    private final ImageUploadResult result;

    public static /* synthetic */ UrlAssetUploadState copy$default(UrlAssetUploadState urlAssetUploadState, OriginAssetUploadState originAssetUploadState, ImageUploadResult imageUploadResult, int i, Object obj) {
        if ((i & 1) != 0) {
            originAssetUploadState = urlAssetUploadState.originAssetState;
        }
        if ((i & 2) != 0) {
            imageUploadResult = urlAssetUploadState.result;
        }
        return urlAssetUploadState.copy(originAssetUploadState, imageUploadResult);
    }

    public static /* synthetic */ void getResult$annotations() {
    }

    public final OriginAssetUploadState component1() {
        return this.originAssetState;
    }

    public final ImageUploadResult component2() {
        return this.result;
    }

    public final UrlAssetUploadState copy(OriginAssetUploadState originAssetUploadState, ImageUploadResult imageUploadResult) {
        Intrinsics.checkNotNullParameter(imageUploadResult, "result");
        return new UrlAssetUploadState(originAssetUploadState, imageUploadResult);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UrlAssetUploadState) {
            UrlAssetUploadState urlAssetUploadState = (UrlAssetUploadState) obj;
            return Intrinsics.areEqual(this.originAssetState, urlAssetUploadState.originAssetState) && Intrinsics.areEqual(this.result, urlAssetUploadState.result);
        }
        return false;
    }

    public int hashCode() {
        return ((this.originAssetState == null ? 0 : this.originAssetState.hashCode()) * 31) + this.result.hashCode();
    }

    public String toString() {
        OriginAssetUploadState originAssetUploadState = this.originAssetState;
        return "UrlAssetUploadState(originAssetState=" + originAssetUploadState + ", result=" + this.result + ")";
    }

    public UrlAssetUploadState(OriginAssetUploadState originAssetState, ImageUploadResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.originAssetState = originAssetState;
        this.result = result;
    }

    public final OriginAssetUploadState getOriginAssetState() {
        return this.originAssetState;
    }

    public final ImageUploadResult getResult() {
        return this.result;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public Asset getAsset() {
        OriginAssetUploadState originAssetUploadState = this.originAssetState;
        if (originAssetUploadState != null) {
            return originAssetUploadState.getAsset();
        }
        return null;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUseOrigin() {
        return false;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public Resolution getResolution() {
        return this.result.getResolution();
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUploadFinished() {
        return true;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUploadSucceed() {
        return true;
    }
}