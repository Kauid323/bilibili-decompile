package im.session.di;

import dagger.Binds;
import dagger.Module;
import im.session.service.IMSessionDataSourceServiceLike;
import im.session.service.IMSessionHomeDataSourceService;
import im.session.service.IMSessionRequestServiceLike;
import im.session.service.request.IMSessionMossRequestService;
import kotlin.Metadata;

/* compiled from: IMHomeComponent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lim/session/di/HomeDataSourceServiceModule;", "", "bindHomeDataSourceService", "Lim/session/service/IMSessionDataSourceServiceLike;", "impl", "Lim/session/service/IMSessionHomeDataSourceService;", "bindMossRequest", "Lim/session/service/IMSessionRequestServiceLike;", "service", "Lim/session/service/request/IMSessionMossRequestService;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public interface HomeDataSourceServiceModule {
    @Binds
    IMSessionDataSourceServiceLike bindHomeDataSourceService(IMSessionHomeDataSourceService iMSessionHomeDataSourceService);

    @Binds
    IMSessionRequestServiceLike bindMossRequest(IMSessionMossRequestService iMSessionMossRequestService);
}