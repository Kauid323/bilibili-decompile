package im.session.di;

import dagger.internal.Factory;
import im.session.service.IMSessionListCacheService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SecondaryComponentModule_ProvideCacheServiceFactory.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00062\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lim/session/di/SecondaryComponentModule_ProvideCacheServiceFactory;", "Ldagger/internal/Factory;", "Lim/session/service/IMSessionListCacheService;", "<init>", "()V", "get", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SecondaryComponentModule_ProvideCacheServiceFactory implements Factory<IMSessionListCacheService> {
    public static final Companion Companion = new Companion(null);
    private static final SecondaryComponentModule_ProvideCacheServiceFactory INSTANCE = new SecondaryComponentModule_ProvideCacheServiceFactory();

    /* renamed from: get */
    public IMSessionListCacheService m3299get() {
        return Companion.provideCacheService();
    }

    /* compiled from: SecondaryComponentModule_ProvideCacheServiceFactory.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lim/session/di/SecondaryComponentModule_ProvideCacheServiceFactory$Companion;", "", "<init>", "()V", "INSTANCE", "Lim/session/di/SecondaryComponentModule_ProvideCacheServiceFactory;", "create", "provideCacheService", "Lim/session/service/IMSessionListCacheService;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SecondaryComponentModule_ProvideCacheServiceFactory create() {
            return SecondaryComponentModule_ProvideCacheServiceFactory.INSTANCE;
        }

        @JvmStatic
        public final IMSessionListCacheService provideCacheService() {
            return SecondaryComponentModule.INSTANCE.provideCacheService();
        }
    }

    @JvmStatic
    public static final SecondaryComponentModule_ProvideCacheServiceFactory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final IMSessionListCacheService provideCacheService() {
        return Companion.provideCacheService();
    }
}