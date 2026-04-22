package kntr.app.im.chat.sticker.asset;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kntr.common.photonic.finder.AssetFinder;
import kotlin.Metadata;

/* compiled from: StickerAssetModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/sticker/asset/StickerAssetModule;", RoomRecommendViewModel.EMPTY_CURSOR, "provideStickerAssetFinder", "Lkntr/common/photonic/finder/AssetFinder;", "Lkntr/common/photonic/Asset;", "impl", "Lkntr/app/im/chat/sticker/asset/StickerAssetFinder;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public interface StickerAssetModule {
    @Binds
    @IntoSet
    AssetFinder<? extends Asset> provideStickerAssetFinder(StickerAssetFinder stickerAssetFinder);
}