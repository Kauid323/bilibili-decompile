package im.session.service;

import dagger.internal.Factory;
import im.base.IMBroadcastManager;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionBroadcastServiceModule_ProvideBroadcastServiceFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lim/session/service/IMSessionBroadcastServiceModule_ProvideBroadcastServiceFactory;", "Ldagger/internal/Factory;", "Lim/session/service/IMSessionBroadcastService;", "managerProvider", "Ljavax/inject/Provider;", "Lim/base/IMBroadcastManager;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionBroadcastServiceModule_ProvideBroadcastServiceFactory implements Factory<IMSessionBroadcastService> {
    public static final Companion Companion = new Companion(null);
    private final Provider<IMBroadcastManager> managerProvider;

    public IMSessionBroadcastServiceModule_ProvideBroadcastServiceFactory(Provider<IMBroadcastManager> provider) {
        Intrinsics.checkNotNullParameter(provider, "managerProvider");
        this.managerProvider = provider;
    }

    /* renamed from: get */
    public IMSessionBroadcastService m3345get() {
        Companion companion = Companion;
        Object obj = this.managerProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.provideBroadcastService((IMBroadcastManager) obj);
    }

    /* compiled from: IMSessionBroadcastServiceModule_ProvideBroadcastServiceFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lim/session/service/IMSessionBroadcastServiceModule_ProvideBroadcastServiceFactory$Companion;", "", "<init>", "()V", "create", "Lim/session/service/IMSessionBroadcastServiceModule_ProvideBroadcastServiceFactory;", "managerProvider", "Ljavax/inject/Provider;", "Lim/base/IMBroadcastManager;", "provideBroadcastService", "Lim/session/service/IMSessionBroadcastService;", "manager", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IMSessionBroadcastServiceModule_ProvideBroadcastServiceFactory create(Provider<IMBroadcastManager> provider) {
            Intrinsics.checkNotNullParameter(provider, "managerProvider");
            return new IMSessionBroadcastServiceModule_ProvideBroadcastServiceFactory(provider);
        }

        @JvmStatic
        public final IMSessionBroadcastService provideBroadcastService(IMBroadcastManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            return IMSessionBroadcastServiceModule.INSTANCE.provideBroadcastService(manager);
        }
    }

    @JvmStatic
    public static final IMSessionBroadcastServiceModule_ProvideBroadcastServiceFactory create(Provider<IMBroadcastManager> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final IMSessionBroadcastService provideBroadcastService(IMBroadcastManager manager) {
        return Companion.provideBroadcastService(manager);
    }
}