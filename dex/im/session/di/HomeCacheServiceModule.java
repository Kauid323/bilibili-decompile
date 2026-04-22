package im.session.di;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import dagger.Module;
import dagger.Provides;
import im.session.service.IMSessionDataCacheService;
import im.session.service.IMSessionInteractiveService;
import im.session.service.IMSessionListCacheService;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMHomeComponent.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lim/session/di/HomeCacheServiceModule;", "", "<init>", "()V", "provideCacheService", "Lim/session/service/IMSessionListCacheService;", "accountStore", "Lkntr/base/account/KAccountStore;", "dataCacheService", "Lim/session/service/IMSessionDataCacheService;", "provideSessionPageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "provideInteractionService", "Lim/session/service/IMSessionInteractiveService;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class HomeCacheServiceModule {
    public static final HomeCacheServiceModule INSTANCE = new HomeCacheServiceModule();

    private HomeCacheServiceModule() {
    }

    @Provides
    public final IMSessionListCacheService provideCacheService(KAccountStore accountStore, IMSessionDataCacheService dataCacheService) {
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        Intrinsics.checkNotNullParameter(dataCacheService, "dataCacheService");
        return new IMSessionListCacheService(accountStore, dataCacheService);
    }

    @Provides
    public final KSessionPageType provideSessionPageType() {
        return KSessionPageType.SESSION_PAGE_TYPE_HOME.INSTANCE;
    }

    @Provides
    @IMSessionScope
    public final IMSessionInteractiveService provideInteractionService() {
        return new IMSessionInteractiveService();
    }
}