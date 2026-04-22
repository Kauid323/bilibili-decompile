package kntr.app.tribee.publish.core.v2.di;

import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService;
import kntr.app.tribee.publish.core.v2.serviceImpl.TribeeDraftServiceImpl;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: TribeePublishDraftModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/TribeePublishDraftModule;", "", "bindDraftService", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;", "impl", "Lkntr/app/tribee/publish/core/v2/serviceImpl/TribeeDraftServiceImpl;", "bindOptionalDraftService", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {TribeePublishDraftBaseDirModule.class}, subcomponents = {})
public interface TribeePublishDraftModule {
    @TribeePublishScope
    @Binds
    TribeePublishDraftService bindDraftService(TribeeDraftServiceImpl tribeeDraftServiceImpl);

    @BindsOptionalOf
    TribeePublishDraftService bindOptionalDraftService();
}