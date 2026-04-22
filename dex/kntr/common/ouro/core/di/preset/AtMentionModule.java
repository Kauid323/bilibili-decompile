package kntr.common.ouro.core.di.preset;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.di.OuroAtMentionFontColor;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.atMention.AtMentionService;
import kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PresetModules.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/di/preset/AtMentionModule;", "", "<init>", "()V", "provideAtMentionPlugin", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "atMentionService", "Lkntr/common/ouro/core/plugin/atMention/AtMentionService;", "fontColor", "Lkntr/common/ouro/core/model/mark/OuroColor;", "provideAtMentionFontColor", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module
public final class AtMentionModule {
    public static final AtMentionModule INSTANCE = new AtMentionModule();

    private AtMentionModule() {
    }

    @Provides
    @IntoSet
    public final OuroPlugin<OuroPluginState> provideAtMentionPlugin(AtMentionService atMentionService, @OuroAtMentionFontColor OuroColor fontColor) {
        Intrinsics.checkNotNullParameter(atMentionService, "atMentionService");
        Intrinsics.checkNotNullParameter(fontColor, "fontColor");
        return new OuroAtMentionPlugin(atMentionService, fontColor);
    }

    @Provides
    @OuroAtMentionFontColor
    public final OuroColor provideAtMentionFontColor() {
        return OuroColor.Companion.getLb7();
    }
}