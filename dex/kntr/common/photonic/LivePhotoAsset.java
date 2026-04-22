package kntr.common.photonic;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: LivePhotoAsset.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0006\u001a\u00020\u0001H¦@¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/common/photonic/LivePhotoAsset;", "Lkntr/common/photonic/Asset;", "mimeType", "Lkntr/common/photonic/MimeType;", "getMimeType", "()Lkntr/common/photonic/MimeType;", "getImageAsset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoAsset", "Lkntr/common/photonic/VideoAsset;", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface LivePhotoAsset extends Asset {
    Object getImageAsset(Continuation<? super Asset> continuation);

    @Override // kntr.common.photonic.Asset
    MimeType getMimeType();

    Object getVideoAsset(Continuation<? super VideoAsset> continuation);

    /* compiled from: LivePhotoAsset.kt */
    /* renamed from: kntr.common.photonic.LivePhotoAsset$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static MimeType $default$getMimeType(LivePhotoAsset _this) {
            return MimeType.Companion.getLivePhoto();
        }
    }

    /* compiled from: LivePhotoAsset.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static AssetType getAssetType(LivePhotoAsset $this) {
            return Asset.CC.$default$getAssetType($this);
        }

        @Deprecated
        public static Resolution getRotatedResolution(LivePhotoAsset $this) {
            return Asset.CC.$default$getRotatedResolution($this);
        }

        @Deprecated
        public static MimeType getMimeType(LivePhotoAsset $this) {
            return CC.$default$getMimeType($this);
        }
    }
}