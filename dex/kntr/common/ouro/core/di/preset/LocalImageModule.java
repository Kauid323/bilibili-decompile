package kntr.common.ouro.core.di.preset;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.di.OuroAssetUploader;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PresetModules.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lkntr/common/ouro/core/di/preset/LocalImageModule;", "", "<init>", "()V", "provideLocalImagePlugin", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "assetUploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {RemoteImageModule.class})
public final class LocalImageModule {
    public static final LocalImageModule INSTANCE = new LocalImageModule();

    private LocalImageModule() {
    }

    @Provides
    @IntoSet
    public final OuroPlugin<OuroPluginState> provideLocalImagePlugin(@OuroAssetUploader AssetUploader assetUploader) {
        Intrinsics.checkNotNullParameter(assetUploader, "assetUploader");
        return new OuroLocalImagePlugin(assetUploader);
    }
}