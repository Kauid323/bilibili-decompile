package kntr.app.im.chat.di.module.common;

import dagger.Module;
import dagger.Provides;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.paragraph.assetuploader.di.AssetUploadBucket;
import kotlin.Metadata;

/* compiled from: ChatUploadModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/di/module/common/ChatUploadBucketModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideBucket", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ChatUploadBucketModule {
    public static final int $stable = 0;
    public static final ChatUploadBucketModule INSTANCE = new ChatUploadBucketModule();

    private ChatUploadBucketModule() {
    }

    @Provides
    @ChatScope
    @AssetUploadBucket
    public final String provideBucket() {
        return "im";
    }
}