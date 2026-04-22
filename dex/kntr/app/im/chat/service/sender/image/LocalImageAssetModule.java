package kntr.app.im.chat.service.sender.image;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javax.inject.Singleton;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kntr.common.photonic.finder.AssetFinder;
import kotlin.Metadata;

/* compiled from: LocalImageAsset.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/service/sender/image/LocalImageAssetModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideLocalImageAssetFinder", "Lkntr/common/photonic/finder/AssetFinder;", "Lkntr/common/photonic/Asset;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class LocalImageAssetModule {
    public static final int $stable = 0;
    public static final LocalImageAssetModule INSTANCE = new LocalImageAssetModule();

    private LocalImageAssetModule() {
    }

    @Provides
    @Singleton
    @IntoSet
    public final AssetFinder<? extends Asset> provideLocalImageAssetFinder() {
        return new LocalImageAssetFinder();
    }
}