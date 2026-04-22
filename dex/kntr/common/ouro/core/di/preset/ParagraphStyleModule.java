package kntr.common.ouro.core.di.preset;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PresetModules.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/di/preset/ParagraphStyleModule;", "", "<init>", "()V", "provideParagraphStylePlugin", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module
public final class ParagraphStyleModule {
    public static final ParagraphStyleModule INSTANCE = new ParagraphStyleModule();

    private ParagraphStyleModule() {
    }

    @Provides
    @IntoSet
    public final OuroPlugin<OuroPluginState> provideParagraphStylePlugin() {
        OuroParagraphStylePlugin ouroParagraphStylePlugin = OuroParagraphStylePlugin.INSTANCE;
        Intrinsics.checkNotNull(ouroParagraphStylePlugin, "null cannot be cast to non-null type kntr.common.ouro.core.plugin.OuroPlugin<kntr.common.ouro.core.plugin.OuroPluginState>");
        return ouroParagraphStylePlugin;
    }
}