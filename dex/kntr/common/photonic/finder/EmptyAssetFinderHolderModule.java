package kntr.common.photonic.finder;

import dagger.Module;
import dagger.multibindings.Multibinds;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;

/* compiled from: AssetFinderHolder.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u00060\u0003H'¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/finder/EmptyAssetFinderHolderModule;", "", "provideEmptyAssetFinderHolder", "", "Lkntr/common/photonic/finder/AssetFinder;", "Lkntr/common/photonic/Asset;", "Lkotlin/jvm/JvmSuppressWildcards;", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public interface EmptyAssetFinderHolderModule {
    @Multibinds
    Set<AssetFinder<? extends Asset>> provideEmptyAssetFinderHolder();
}