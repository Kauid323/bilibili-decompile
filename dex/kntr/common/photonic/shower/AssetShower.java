package kntr.common.photonic.shower;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.Asset;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.reflect.KClass;

/* compiled from: AssetShower.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J,\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH'¢\u0006\u0002\u0010\u0015R \u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/shower/AssetShower;", "T", "Lkntr/common/photonic/Asset;", "", "acceptType", "", "Lkotlin/reflect/KClass;", "getAcceptType", "()Ljava/util/Set;", "getImageSource", "Lkntr/base/imageloader/ImageSource;", "asset", "expectResolution", "Lkntr/common/photonic/Resolution;", "animated", "", "(Lkntr/common/photonic/Asset;Lkntr/common/photonic/Resolution;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Content", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/photonic/Asset;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;I)V", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AssetShower<T extends Asset> {
    void Content(T t, Modifier modifier, boolean z, Composer composer, int i);

    Set<KClass<? extends T>> getAcceptType();

    Object getImageSource(T t, Resolution resolution, boolean z, Continuation<? super ImageSource> continuation);

    /* compiled from: AssetShower.kt */
    /* renamed from: kntr.common.photonic.shower.AssetShower$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object getImageSource$default(AssetShower assetShower, Asset asset, Resolution resolution, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                return assetShower.getImageSource(asset, resolution, z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getImageSource");
        }
    }

    /* compiled from: AssetShower.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}