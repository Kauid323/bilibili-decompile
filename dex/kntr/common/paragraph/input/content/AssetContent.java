package kntr.common.paragraph.input.content;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.base.AssetUploadState;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetContent.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\rHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lkntr/common/paragraph/input/content/AssetContent;", "Lkntr/common/paragraph/input/content/ParagraphContent;", "uploadState", "Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "<init>", "(Lkntr/common/paragraph/assetuploader/base/AssetUploadState;)V", "getUploadState", "()Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "asset", "Lkntr/common/photonic/Asset;", "getAsset", "()Lkntr/common/photonic/Asset;", "textCount", "", "getTextCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetContent implements ParagraphContent {
    private final AssetUploadState uploadState;

    public static /* synthetic */ AssetContent copy$default(AssetContent assetContent, AssetUploadState assetUploadState, int i, Object obj) {
        if ((i & 1) != 0) {
            assetUploadState = assetContent.uploadState;
        }
        return assetContent.copy(assetUploadState);
    }

    public final AssetUploadState component1() {
        return this.uploadState;
    }

    public final AssetContent copy(AssetUploadState assetUploadState) {
        Intrinsics.checkNotNullParameter(assetUploadState, "uploadState");
        return new AssetContent(assetUploadState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AssetContent) && Intrinsics.areEqual(this.uploadState, ((AssetContent) obj).uploadState);
    }

    public int hashCode() {
        return this.uploadState.hashCode();
    }

    public String toString() {
        return "AssetContent(uploadState=" + this.uploadState + ")";
    }

    public AssetContent(AssetUploadState uploadState) {
        Intrinsics.checkNotNullParameter(uploadState, "uploadState");
        this.uploadState = uploadState;
    }

    public final AssetUploadState getUploadState() {
        return this.uploadState;
    }

    public final Asset getAsset() {
        return this.uploadState.getAsset();
    }

    @Override // kntr.common.paragraph.input.content.ParagraphContent
    public int getTextCount() {
        return 0;
    }
}