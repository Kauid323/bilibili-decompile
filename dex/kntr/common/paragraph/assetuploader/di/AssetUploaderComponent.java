package kntr.common.paragraph.assetuploader.di;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.AssetUploaderViewModelFactory;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AssetUploaderComponent.kt */
@AssetUploaderScope
@Subcomponent(modules = {MossUploaderModule.class})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/common/paragraph/assetuploader/di/AssetUploaderComponent;", "", "viewModelFactory", "Lkntr/common/paragraph/assetuploader/AssetUploaderViewModelFactory;", "uploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "Builder", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AssetUploaderComponent {

    /* compiled from: AssetUploaderComponent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/common/paragraph/assetuploader/di/AssetUploaderComponent$Builder;", "", "build", "Lkntr/common/paragraph/assetuploader/di/AssetUploaderComponent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "bucket", "", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Builder {
        AssetUploaderComponent build(@BindsInstance @AssetUploaderCoroutineScope CoroutineScope coroutineScope, @BindsInstance @AssetUploadBucket String str);
    }

    AssetUploader uploader();

    AssetUploaderViewModelFactory viewModelFactory();
}