package kntr.app.im.chat.service.sender.image;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.utils.foundation.AppCacheDirectory;
import kntr.common.photonic.Asset;
import kntr.common.photonic.compressor.AssetCompressor;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.Path;

/* compiled from: LocalImageAsset.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0007J\u001a\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/service/sender/image/LocalImageAssetAndroidModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideLocalImageAssetShower", "Lkntr/common/photonic/shower/AssetShower;", "Lkntr/common/photonic/Asset;", "provideLocalImageAssetCompressor", "Lkntr/common/photonic/compressor/AssetCompressor;", "cacheDir", "Lkotlinx/io/files/Path;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class LocalImageAssetAndroidModule {
    public static final int $stable = 0;
    public static final LocalImageAssetAndroidModule INSTANCE = new LocalImageAssetAndroidModule();

    private LocalImageAssetAndroidModule() {
    }

    @Provides
    @IntoSet
    public final AssetShower<? extends Asset> provideLocalImageAssetShower() {
        return new LocalImageAssetAndroidShower();
    }

    @Provides
    @IntoSet
    public final AssetCompressor<? extends Asset> provideLocalImageAssetCompressor(@AppCacheDirectory Path cacheDir) {
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        return new LocalImageAssetAndroidCompressor(cacheDir);
    }
}