package kntr.common.ouro.core.di;

import dagger.Module;
import dagger.Provides;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.version.OuroEditVersionKt;
import kotlin.Metadata;

/* compiled from: OuroComponent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lkntr/common/ouro/core/di/OuroBaseModule;", "", "<init>", "()V", "provideVersion", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module
public final class OuroBaseModule {
    public static final OuroBaseModule INSTANCE = new OuroBaseModule();

    private OuroBaseModule() {
    }

    @Provides
    @OuroEditorVersion
    public final String provideVersion() {
        return OuroEditVersionKt.OURO_EDITOR_VERSION;
    }
}