package kntr.common.photonic.di;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.compressor.AssetCompressorHolder;
import kntr.common.photonic.finder.AssetFinderHolder;
import kntr.common.photonic.shower.AssetShowerHolder;
import kotlin.Metadata;

/* compiled from: AssetEntryPoint.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/common/photonic/di/AssetEntryPoint;", "", "getAssetFinderHolder", "Lkntr/common/photonic/finder/AssetFinderHolder;", "getAssetShowerHolder", "Lkntr/common/photonic/shower/AssetShowerHolder;", "getAssetCompressorHolder", "Lkntr/common/photonic/compressor/AssetCompressorHolder;", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AssetEntryPoint {
    AssetCompressorHolder getAssetCompressorHolder();

    AssetFinderHolder getAssetFinderHolder();

    AssetShowerHolder getAssetShowerHolder();
}