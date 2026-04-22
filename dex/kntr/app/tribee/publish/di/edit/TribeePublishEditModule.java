package kntr.app.tribee.publish.di.edit;

import dagger.Binds;
import dagger.Module;
import kntr.app.tribee.publish.di.TribeePublishScope;
import kntr.app.tribee.publish.service.TribeeInitService;
import kntr.app.tribee.publish.service.TribeePublishService;
import kntr.app.tribee.publish.service.edit.TribeeEditPublishServiceImpl;
import kntr.app.tribee.publish.service.edit.TribeeInitEditServiceImpl;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: TribeePublishEditModule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/di/edit/TribeePublishEditModule;", "", "bindPublishService", "Lkntr/app/tribee/publish/service/TribeePublishService;", "impl", "Lkntr/app/tribee/publish/service/edit/TribeeEditPublishServiceImpl;", "bindInitService", "Lkntr/app/tribee/publish/service/TribeeInitService;", "Lkntr/app/tribee/publish/service/edit/TribeeInitEditServiceImpl;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {TribeeEditServiceModule.class}, subcomponents = {})
public interface TribeePublishEditModule {
    @Binds
    @TribeePublishScope
    TribeeInitService bindInitService(TribeeInitEditServiceImpl tribeeInitEditServiceImpl);

    @Binds
    @TribeePublishScope
    TribeePublishService bindPublishService(TribeeEditPublishServiceImpl tribeeEditPublishServiceImpl);
}