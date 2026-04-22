package kntr.common.paragraph.assetuploader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.base.AssetUploaderParams;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: AssetUploader.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH¦@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/common/paragraph/assetuploader/AssetUploader;", "", "uploadAsset", "Lkntr/common/paragraph/assetuploader/UploadTask;", "asset", "Lkntr/common/photonic/Asset;", "useOriginImage", "", "params", "Lkntr/common/paragraph/assetuploader/base/AssetUploaderParams;", "(Lkntr/common/photonic/Asset;ZLkntr/common/paragraph/assetuploader/base/AssetUploaderParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AssetUploader {
    Object uploadAsset(Asset asset, boolean z, AssetUploaderParams assetUploaderParams, Continuation<? super UploadTask> continuation);
}