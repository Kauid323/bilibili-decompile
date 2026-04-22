package kntr.common.photonic.compressor;

import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.reflect.KClass;

/* compiled from: AssetCompressor.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J.\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/compressor/AssetCompressor;", "T", "Lkntr/common/photonic/Asset;", "", "acceptType", "", "Lkotlin/reflect/KClass;", "getAcceptType", "()Ljava/util/Set;", "compress", "Lkotlin/Result;", "asset", "expectResolution", "Lkntr/common/photonic/Resolution;", "expectContentSize", "Lkntr/common/photonic/ContentSize;", "compress-OkegGBo", "(Lkntr/common/photonic/Asset;Lkntr/common/photonic/Resolution;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AssetCompressor<T extends Asset> {
    /* renamed from: compress-OkegGBo  reason: not valid java name */
    Object m2330compressOkegGBo(T t, Resolution resolution, double d, Continuation<? super Result<? extends Asset>> continuation);

    Set<KClass<? extends T>> getAcceptType();
}