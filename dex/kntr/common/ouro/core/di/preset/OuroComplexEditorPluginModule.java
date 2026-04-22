package kntr.common.ouro.core.di.preset;

import dagger.Module;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: PresetModules.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/common/ouro/core/di/preset/OuroComplexEditorPluginModule;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {EditControlModule.class, ParagraphStyleModule.class, TextStyleModule.class, LocalImageModule.class, RemoteImageModule.class, PasteboardModule.class, AtMentionModule.class})
public final class OuroComplexEditorPluginModule {
    public static final OuroComplexEditorPluginModule INSTANCE = new OuroComplexEditorPluginModule();

    private OuroComplexEditorPluginModule() {
    }
}