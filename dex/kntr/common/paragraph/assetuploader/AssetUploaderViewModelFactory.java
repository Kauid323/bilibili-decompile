package kntr.common.paragraph.assetuploader;

import dagger.assisted.AssistedFactory;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;

/* compiled from: AssetUploaderViewModel.kt */
@AssistedFactory
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/common/paragraph/assetuploader/AssetUploaderViewModelFactory;", "", "create", "Lkntr/common/paragraph/assetuploader/AssetUploaderViewModel;", "asset", "Lkntr/common/photonic/Asset;", "useOrigin", "", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AssetUploaderViewModelFactory {
    AssetUploaderViewModel create(Asset asset, boolean z);
}