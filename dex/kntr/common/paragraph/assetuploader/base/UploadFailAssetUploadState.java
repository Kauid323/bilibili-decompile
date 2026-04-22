package kntr.common.paragraph.assetuploader.base;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetUploaderResult.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020!X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0012\u0010$\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010\u000f¨\u0006&"}, d2 = {"Lkntr/common/paragraph/assetuploader/base/UploadFailAssetUploadState;", "Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "originAssetState", "Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "failure", "", "<init>", "(Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;Ljava/lang/Throwable;)V", "getOriginAssetState", "()Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "getFailure", "()Ljava/lang/Throwable;", "uploadFinished", "", "getUploadFinished", "()Z", "uploadSucceed", "getUploadSucceed", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "asset", "Lkntr/common/photonic/Asset;", "getAsset", "()Lkntr/common/photonic/Asset;", "resolution", "Lkntr/common/photonic/Resolution;", "getResolution", "()Lkntr/common/photonic/Resolution;", "useOrigin", "getUseOrigin", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UploadFailAssetUploadState implements AssetUploadState {
    private final Throwable failure;
    private final OriginAssetUploadState originAssetState;

    public static /* synthetic */ UploadFailAssetUploadState copy$default(UploadFailAssetUploadState uploadFailAssetUploadState, OriginAssetUploadState originAssetUploadState, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            originAssetUploadState = uploadFailAssetUploadState.originAssetState;
        }
        if ((i & 2) != 0) {
            th = uploadFailAssetUploadState.failure;
        }
        return uploadFailAssetUploadState.copy(originAssetUploadState, th);
    }

    public final OriginAssetUploadState component1() {
        return this.originAssetState;
    }

    public final Throwable component2() {
        return this.failure;
    }

    public final UploadFailAssetUploadState copy(OriginAssetUploadState originAssetUploadState, Throwable th) {
        Intrinsics.checkNotNullParameter(originAssetUploadState, "originAssetState");
        return new UploadFailAssetUploadState(originAssetUploadState, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UploadFailAssetUploadState) {
            UploadFailAssetUploadState uploadFailAssetUploadState = (UploadFailAssetUploadState) obj;
            return Intrinsics.areEqual(this.originAssetState, uploadFailAssetUploadState.originAssetState) && Intrinsics.areEqual(this.failure, uploadFailAssetUploadState.failure);
        }
        return false;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public Asset getAsset() {
        return this.originAssetState.getAsset();
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public Resolution getResolution() {
        return this.originAssetState.getResolution();
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUseOrigin() {
        return this.originAssetState.getUseOrigin();
    }

    public int hashCode() {
        return (this.originAssetState.hashCode() * 31) + (this.failure == null ? 0 : this.failure.hashCode());
    }

    public String toString() {
        OriginAssetUploadState originAssetUploadState = this.originAssetState;
        return "UploadFailAssetUploadState(originAssetState=" + originAssetUploadState + ", failure=" + this.failure + ")";
    }

    public UploadFailAssetUploadState(OriginAssetUploadState originAssetState, Throwable failure) {
        Intrinsics.checkNotNullParameter(originAssetState, "originAssetState");
        this.originAssetState = originAssetState;
        this.failure = failure;
    }

    public final OriginAssetUploadState getOriginAssetState() {
        return this.originAssetState;
    }

    public final Throwable getFailure() {
        return this.failure;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUploadFinished() {
        return true;
    }

    @Override // kntr.common.paragraph.assetuploader.base.AssetUploadState
    public boolean getUploadSucceed() {
        return false;
    }
}