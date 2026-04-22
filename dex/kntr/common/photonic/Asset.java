package kntr.common.photonic;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.datetime.Instant;
import kotlinx.io.Source;

/* compiled from: Asset.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010 \u001a\u00020!H§@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0011H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006$À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/Asset;", "", "identifier", "", "getIdentifier", "()Ljava/lang/String;", "contentSize", "Lkntr/common/photonic/ContentSize;", "getContentSize-QJZHGII", "()D", "createTime", "Lkotlinx/datetime/Instant;", "getCreateTime", "()Lkotlinx/datetime/Instant;", "modifyTime", "getModifyTime", "resolution", "Lkntr/common/photonic/Resolution;", "getResolution", "()Lkntr/common/photonic/Resolution;", "orientation", "Lkntr/common/photonic/Orientation;", "getOrientation", "()Lkntr/common/photonic/Orientation;", "mimeType", "Lkntr/common/photonic/MimeType;", "getMimeType", "()Lkntr/common/photonic/MimeType;", "assetType", "Lkntr/common/photonic/AssetType;", "getAssetType", "()Lkntr/common/photonic/AssetType;", "reader", "Lkotlinx/io/Source;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRotatedResolution", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface Asset {
    AssetType getAssetType();

    /* renamed from: getContentSize-QJZHGII */
    double mo2158getContentSizeQJZHGII();

    Instant getCreateTime();

    String getIdentifier();

    MimeType getMimeType();

    Instant getModifyTime();

    Orientation getOrientation();

    Resolution getResolution();

    Resolution getRotatedResolution();

    Object reader(Continuation<? super Source> continuation) throws Exception;

    /* compiled from: Asset.kt */
    /* renamed from: kntr.common.photonic.Asset$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static AssetType $default$getAssetType(Asset _this) {
            return _this.getMimeType().getType();
        }

        public static Resolution $default$getRotatedResolution(Asset _this) {
            return AssetKt.withOrientation(_this.getResolution(), _this.getOrientation());
        }
    }

    /* compiled from: Asset.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static AssetType getAssetType(Asset $this) {
            return CC.$default$getAssetType($this);
        }

        @Deprecated
        public static Resolution getRotatedResolution(Asset $this) {
            return CC.$default$getRotatedResolution($this);
        }
    }
}