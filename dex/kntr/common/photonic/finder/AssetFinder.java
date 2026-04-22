package kntr.common.photonic.finder;

import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.reflect.KClass;

/* compiled from: AssetFinder.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/common/photonic/finder/AssetFinder;", "T", "Lkntr/common/photonic/Asset;", "", "acceptType", "", "Lkotlin/reflect/KClass;", "getAcceptType", "()Ljava/util/Set;", "findAssetByIdentifier", "Lkotlin/Result;", "identifier", "", "findAssetByIdentifier-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AssetFinder<T extends Asset> {
    /* renamed from: findAssetByIdentifier-gIAlu-s  reason: not valid java name */
    Object mo2332findAssetByIdentifiergIAlus(String str, Continuation<? super Result<? extends T>> continuation);

    Set<KClass<? extends T>> getAcceptType();
}