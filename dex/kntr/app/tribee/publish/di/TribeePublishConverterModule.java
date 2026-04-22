package kntr.app.tribee.publish.di;

import dagger.Binds;
import dagger.Module;
import kntr.app.tribee.publish.service.TribeeContentConverter;
import kntr.app.tribee.publish.service.impl.TribeeContentConverterImpl;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.impl.MossAssetUploaderImpl;
import kotlin.Metadata;

/* compiled from: TribeePublishConverterModule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/di/TribeePublishConverterModule;", "", "bindConverter", "Lkntr/app/tribee/publish/service/TribeeContentConverter;", "impl", "Lkntr/app/tribee/publish/service/impl/TribeeContentConverterImpl;", "bindUploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "Lkntr/common/paragraph/assetuploader/impl/MossAssetUploaderImpl;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {TribeePublishUploadBucketModule.class}, subcomponents = {})
public interface TribeePublishConverterModule {
    @Binds
    @TribeePublishScope
    TribeeContentConverter bindConverter(TribeeContentConverterImpl tribeeContentConverterImpl);

    @Binds
    @TribeePublishScope
    AssetUploader bindUploader(MossAssetUploaderImpl mossAssetUploaderImpl);
}