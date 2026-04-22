package kntr.app.tribee.publish.core.v2.di;

import dagger.Binds;
import dagger.Module;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter;
import kntr.app.tribee.publish.core.v2.serviceImpl.TribeePublishDataConverterImpl;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: TribeePublishDataConverterModule.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/TribeePublishDataConverterModule;", "", "bindDataConverter", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "impl", "Lkntr/app/tribee/publish/core/v2/serviceImpl/TribeePublishDataConverterImpl;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public interface TribeePublishDataConverterModule {
    @TribeePublishScope
    @Binds
    TribeePublishDataConverter bindDataConverter(TribeePublishDataConverterImpl tribeePublishDataConverterImpl);
}