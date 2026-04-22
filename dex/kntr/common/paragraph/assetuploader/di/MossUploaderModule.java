package kntr.common.paragraph.assetuploader.di;

import dagger.Binds;
import dagger.Module;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.impl.MossAssetUploaderImpl;
import kotlin.Metadata;

/* compiled from: MossUploaderModule.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/paragraph/assetuploader/di/MossUploaderModule;", "", "bindUploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "impl", "Lkntr/common/paragraph/assetuploader/impl/MossAssetUploaderImpl;", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public interface MossUploaderModule {
    @AssetUploaderScope
    @Binds
    AssetUploader bindUploader(MossAssetUploaderImpl mossAssetUploaderImpl);
}