package kntr.common.paragraph.assetuploader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.ContentSize;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: AssetUploader.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH¦@¢\u0006\u0004\b\r\u0010\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/common/paragraph/assetuploader/UploadTask;", "", "asset", "Lkntr/common/photonic/Asset;", "getAsset", "()Lkntr/common/photonic/Asset;", "taskContentSize", "Lkntr/common/photonic/ContentSize;", "getTaskContentSize-QJZHGII", "()D", "awaitResult", "Lkotlin/Result;", "Lkntr/common/paragraph/assetuploader/ImageUploadResult;", "awaitResult-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "progress", "Lkotlinx/coroutines/flow/Flow;", "getProgress", "()Lkotlinx/coroutines/flow/Flow;", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface UploadTask {
    /* renamed from: awaitResult-IoAF18A  reason: not valid java name */
    Object mo2150awaitResultIoAF18A(Continuation<? super Result<ImageUploadResult>> continuation);

    Asset getAsset();

    Flow<ContentSize> getProgress();

    /* renamed from: getTaskContentSize-QJZHGII  reason: not valid java name */
    double mo2151getTaskContentSizeQJZHGII();
}