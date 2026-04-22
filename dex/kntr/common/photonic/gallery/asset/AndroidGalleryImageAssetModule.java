package kntr.common.photonic.gallery.asset;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.finder.AssetFinder;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;

/* compiled from: AndroidGalleryImageFinder.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0007J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\bH\u0007¨\u0006\t"}, d2 = {"Lkntr/common/photonic/gallery/asset/AndroidGalleryImageAssetModule;", "", "<init>", "()V", "provideAndroidGalleryImageFinder", "Lkntr/common/photonic/finder/AssetFinder;", "Lkntr/common/photonic/Asset;", "provideAndroidGalleryImageShower", "Lkntr/common/photonic/shower/AssetShower;", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public final class AndroidGalleryImageAssetModule {
    public static final int $stable = 0;
    public static final AndroidGalleryImageAssetModule INSTANCE = new AndroidGalleryImageAssetModule();

    private AndroidGalleryImageAssetModule() {
    }

    @Provides
    @IntoSet
    public final AssetFinder<? extends Asset> provideAndroidGalleryImageFinder() {
        return new AndroidGalleryImageFinder();
    }

    @Provides
    @IntoSet
    public final AssetShower<? extends Asset> provideAndroidGalleryImageShower() {
        return new AndroidGalleryImageFinder();
    }
}