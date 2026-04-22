package kntr.common.photonic.compressor;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* compiled from: AssetCompressor.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"compress", "Lkotlin/Result;", "Lkntr/common/photonic/Asset;", "T", "Lkntr/common/photonic/compressor/AssetCompressor;", "asset", "expectResolution", "Lkntr/common/photonic/Resolution;", "expectRatio", "", "(Lkntr/common/photonic/compressor/AssetCompressor;Lkntr/common/photonic/Asset;Lkntr/common/photonic/Resolution;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "image_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetCompressorKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T extends Asset> Object compress(AssetCompressor<T> assetCompressor, T t, Resolution expectResolution, double expectRatio, Continuation<? super Result<? extends Asset>> continuation) {
        Continuation<? super Result<? extends Asset>> assetCompressorKt$compress$1;
        double m2192timeszLmOkFI;
        if (continuation instanceof AssetCompressorKt$compress$1) {
            assetCompressorKt$compress$1 = (AssetCompressorKt$compress$1) continuation;
            if ((assetCompressorKt$compress$1.label & Integer.MIN_VALUE) != 0) {
                assetCompressorKt$compress$1.label -= Integer.MIN_VALUE;
                Object $result = assetCompressorKt$compress$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (assetCompressorKt$compress$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (expectRatio >= 1.0d) {
                            m2192timeszLmOkFI = t.mo2158getContentSizeQJZHGII();
                        } else {
                            m2192timeszLmOkFI = ContentSize.m2192timeszLmOkFI(t.mo2158getContentSizeQJZHGII(), expectRatio);
                        }
                        double expectContentSize = m2192timeszLmOkFI;
                        assetCompressorKt$compress$1.L$0 = SpillingKt.nullOutSpilledVariable(assetCompressor);
                        assetCompressorKt$compress$1.L$1 = SpillingKt.nullOutSpilledVariable(t);
                        assetCompressorKt$compress$1.L$2 = SpillingKt.nullOutSpilledVariable(expectResolution);
                        assetCompressorKt$compress$1.D$0 = expectRatio;
                        assetCompressorKt$compress$1.D$1 = expectContentSize;
                        assetCompressorKt$compress$1.label = 1;
                        Object m2330compressOkegGBo = assetCompressor.m2330compressOkegGBo(t, expectResolution, expectContentSize, assetCompressorKt$compress$1);
                        return m2330compressOkegGBo == coroutine_suspended ? coroutine_suspended : m2330compressOkegGBo;
                    case 1:
                        double d = assetCompressorKt$compress$1.D$1;
                        double d2 = assetCompressorKt$compress$1.D$0;
                        Resolution resolution = (Resolution) assetCompressorKt$compress$1.L$2;
                        Asset asset = (Asset) assetCompressorKt$compress$1.L$1;
                        AssetCompressor assetCompressor2 = (AssetCompressor) assetCompressorKt$compress$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return ((Result) $result).m2645unboximpl();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        assetCompressorKt$compress$1 = new AssetCompressorKt$compress$1<>(continuation);
        Object $result2 = assetCompressorKt$compress$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (assetCompressorKt$compress$1.label) {
        }
    }
}