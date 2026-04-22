package kntr.app.tribee.publish.core.v2.di.create;

import dagger.Binds;
import dagger.Module;
import kntr.app.tribee.publish.core.v2.di.TribeePublishScope;
import kntr.app.tribee.publish.core.v2.service.TribeePublishInitService;
import kntr.app.tribee.publish.core.v2.service.TribeePublishService;
import kntr.app.tribee.publish.core.v2.serviceImpl.create.TribeeCreatePublishServiceImpl;
import kntr.app.tribee.publish.core.v2.serviceImpl.create.TribeePublishCreateInitServiceImpl;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: TribeePublishCreateModule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/create/TribeePublishCreateModule;", "", "bindInitService", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishInitService;", "impl", "Lkntr/app/tribee/publish/core/v2/serviceImpl/create/TribeePublishCreateInitServiceImpl;", "bindPublishService", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishService;", "Lkntr/app/tribee/publish/core/v2/serviceImpl/create/TribeeCreatePublishServiceImpl;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {TribeePublishServiceModule.class}, subcomponents = {})
public interface TribeePublishCreateModule {
    @TribeePublishScope
    @Binds
    TribeePublishInitService bindInitService(TribeePublishCreateInitServiceImpl tribeePublishCreateInitServiceImpl);

    @TribeePublishScope
    @Binds
    TribeePublishService bindPublishService(TribeeCreatePublishServiceImpl tribeeCreatePublishServiceImpl);
}