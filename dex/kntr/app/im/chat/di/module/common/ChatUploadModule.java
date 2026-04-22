package kntr.app.im.chat.di.module.common;

import dagger.Binds;
import dagger.Module;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.impl.MossAssetUploaderImpl;
import kotlin.Metadata;

/* compiled from: ChatUploadModule.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/di/module/common/ChatUploadModule;", RoomRecommendViewModel.EMPTY_CURSOR, "provideAssetUploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "uploader", "Lkntr/common/paragraph/assetuploader/impl/MossAssetUploaderImpl;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {ChatUploadBucketModule.class}, subcomponents = {})
public interface ChatUploadModule {
    @ChatScope
    @Binds
    AssetUploader provideAssetUploader(MossAssetUploaderImpl mossAssetUploaderImpl);
}