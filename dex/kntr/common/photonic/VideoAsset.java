package kntr.common.photonic;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;

/* compiled from: VideoAsset.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/VideoAsset;", "Lkntr/common/photonic/Asset;", "videoDuration", "Lkotlin/time/Duration;", "getVideoDuration-UwyO8pc", "()J", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface VideoAsset extends Asset {
    /* renamed from: getVideoDuration-UwyO8pc  reason: not valid java name */
    long mo2200getVideoDurationUwyO8pc();

    /* compiled from: VideoAsset.kt */
    /* renamed from: kntr.common.photonic.VideoAsset$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
    }

    /* compiled from: VideoAsset.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static AssetType getAssetType(VideoAsset $this) {
            return Asset.CC.$default$getAssetType($this);
        }

        @Deprecated
        public static Resolution getRotatedResolution(VideoAsset $this) {
            return Asset.CC.$default$getRotatedResolution($this);
        }
    }
}