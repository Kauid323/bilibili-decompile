package kntr.common.paragraph.assetuploader.base;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;

/* compiled from: AssetUploaderResult.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r\u0082\u0001\u0004\u0012\u0013\u0014\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "", "asset", "Lkntr/common/photonic/Asset;", "getAsset", "()Lkntr/common/photonic/Asset;", "resolution", "Lkntr/common/photonic/Resolution;", "getResolution", "()Lkntr/common/photonic/Resolution;", "useOrigin", "", "getUseOrigin", "()Z", "uploadFinished", "getUploadFinished", "uploadSucceed", "getUploadSucceed", "Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "Lkntr/common/paragraph/assetuploader/base/UploadFailAssetUploadState;", "Lkntr/common/paragraph/assetuploader/base/UploadingAssetUploadState;", "Lkntr/common/paragraph/assetuploader/base/UrlAssetUploadState;", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AssetUploadState {
    Asset getAsset();

    Resolution getResolution();

    boolean getUploadFinished();

    boolean getUploadSucceed();

    boolean getUseOrigin();
}