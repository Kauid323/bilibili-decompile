package kntr.common.photonic.aphro.ui.preview.model;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;

/* compiled from: WebImageAsset.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/WebAssetModule;", "", "<init>", "()V", "provideWebAssetShower", "Lkntr/common/photonic/shower/AssetShower;", "Lkntr/common/photonic/Asset;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public final class WebAssetModule {
    public static final int $stable = 0;
    public static final WebAssetModule INSTANCE = new WebAssetModule();

    private WebAssetModule() {
    }

    @Provides
    @IntoSet
    public final AssetShower<? extends Asset> provideWebAssetShower() {
        return new WebImageAssetShower();
    }
}