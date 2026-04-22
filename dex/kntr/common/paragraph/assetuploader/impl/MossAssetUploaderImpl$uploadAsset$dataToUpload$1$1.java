package kntr.common.paragraph.assetuploader.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetEntry;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.ContentSizeKt;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.compressor.AssetCompressor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MossAssetUploaderImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/common/photonic/Asset;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.assetuploader.impl.MossAssetUploaderImpl$uploadAsset$dataToUpload$1$1", f = "MossAssetUploaderImpl.kt", i = {0}, l = {87}, m = "invokeSuspend", n = {"compressor"}, s = {"L$0"}, v = 1)
public final class MossAssetUploaderImpl$uploadAsset$dataToUpload$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Asset>, Object> {
    final /* synthetic */ Asset $asset;
    final /* synthetic */ int $assetIndex;
    final /* synthetic */ boolean $useOriginImage;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MossAssetUploaderImpl$uploadAsset$dataToUpload$1$1(int i, Asset asset, boolean z, Continuation<? super MossAssetUploaderImpl$uploadAsset$dataToUpload$1$1> continuation) {
        super(2, continuation);
        this.$assetIndex = i;
        this.$asset = asset;
        this.$useOriginImage = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MossAssetUploaderImpl$uploadAsset$dataToUpload$1$1(this.$assetIndex, this.$asset, this.$useOriginImage, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Asset> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AssetCompressor compressor;
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i(MossAssetUploaderImpl.TAG, "Start upload for index " + this.$assetIndex + " asset " + this.$asset.getIdentifier());
                KLog_androidKt.getKLog().i(MossAssetUploaderImpl.TAG, "Compress image for index " + this.$assetIndex + " asset " + this.$asset.getIdentifier() + ", use origin image: " + this.$useOriginImage);
                AssetCompressor compressor2 = AssetEntry.INSTANCE.getCompressor().getCompressorForAssetType(Reflection.getOrCreateKotlinClass(this.$asset.getClass()));
                if (!(compressor2 instanceof AssetCompressor)) {
                    compressor2 = null;
                }
                if (compressor2 == null) {
                    KLog_androidKt.getKLog().w(MossAssetUploaderImpl.TAG, "No compressor found for asset type " + Reflection.getOrCreateKotlinClass(this.$asset.getClass()).getQualifiedName() + ", use origin asset directly");
                    return this.$asset;
                }
                Asset asset = this.$asset;
                Resolution resolution = this.$asset.getResolution();
                int i = this.$useOriginImage ? 20 : 10;
                this.L$0 = SpillingKt.nullOutSpilledVariable(compressor2);
                this.label = 1;
                Object m2330compressOkegGBo = compressor2.m2330compressOkegGBo(asset, resolution, ContentSizeKt.megabytes(Boxing.boxInt(i)), (Continuation) this);
                if (m2330compressOkegGBo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                compressor = compressor2;
                obj = m2330compressOkegGBo;
                break;
            case 1:
                compressor = (AssetCompressor) this.L$0;
                ResultKt.throwOnFailure($result);
                obj = ((Result) $result).m2645unboximpl();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Asset asset2 = this.$asset;
        if (Result.m2643isSuccessimpl(obj)) {
            Asset it = (Asset) obj;
            KLog_androidKt.getKLog().i(MossAssetUploaderImpl.TAG, "Succeed to compress asset " + asset2.getIdentifier() + " to " + it.getIdentifier() + ", mime type " + it.getMimeType() + ", content length " + ContentSize.m2189getMegabytesimpl(it.mo2158getContentSizeQJZHGII()) + "m");
        }
        Asset asset3 = this.$asset;
        Throwable it2 = Result.m2639exceptionOrNullimpl(obj);
        if (it2 != null) {
            KLog_androidKt.getKLog().e(MossAssetUploaderImpl.TAG, "Fail to compress asset " + asset3.getIdentifier() + ", use origin asset directly", it2.getCause());
        }
        Asset asset4 = Result.m2642isFailureimpl(obj) ? null : obj;
        if (asset4 != null) {
            return asset4;
        }
        return this.$asset;
    }
}