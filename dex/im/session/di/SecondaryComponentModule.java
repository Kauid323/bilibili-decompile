package im.session.di;

import dagger.Module;
import dagger.Provides;
import im.session.service.IMSessionInteractiveService;
import im.session.service.IMSessionListCacheService;
import kotlin.Metadata;

/* compiled from: IMSecondaryComponent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Lim/session/di/SecondaryComponentModule;", "", "<init>", "()V", "provideCacheService", "Lim/session/service/IMSessionListCacheService;", "provideInteractionService", "Lim/session/service/IMSessionInteractiveService;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class SecondaryComponentModule {
    public static final SecondaryComponentModule INSTANCE = new SecondaryComponentModule();

    private SecondaryComponentModule() {
    }

    @Provides
    public final IMSessionListCacheService provideCacheService() {
        return null;
    }

    @Provides
    public final IMSessionInteractiveService provideInteractionService() {
        return null;
    }
}