package kntr.app.tribee.publish.core.v2.di;

import dagger.BindsOptionalOf;
import dagger.Module;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: TribeePublishDraftModule.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/TribeePublishNoDraftModule;", "", "provideDraftService", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public interface TribeePublishNoDraftModule {
    @BindsOptionalOf
    TribeePublishDraftService provideDraftService();
}