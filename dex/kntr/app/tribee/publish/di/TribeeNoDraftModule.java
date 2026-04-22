package kntr.app.tribee.publish.di;

import dagger.Module;
import dagger.Provides;
import kntr.app.tribee.publish.draft.TribeeDraftService;
import kntr.app.tribee.publish.draft.TribeeNoDraftImpl;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: TribeeDraftModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lkntr/app/tribee/publish/di/TribeeNoDraftModule;", "", "<init>", "()V", "provideNoDraftService", "Lkntr/app/tribee/publish/draft/TribeeDraftService;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public final class TribeeNoDraftModule {
    public static final TribeeNoDraftModule INSTANCE = new TribeeNoDraftModule();

    private TribeeNoDraftModule() {
    }

    @Provides
    @TribeePublishScope
    public final TribeeDraftService provideNoDraftService() {
        return new TribeeNoDraftImpl();
    }
}