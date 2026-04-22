package im.base;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMTotalUnreadBroadcastService_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lim/base/IMTotalUnreadBroadcastService_Factory;", "Ldagger/internal/Factory;", "Lim/base/IMTotalUnreadBroadcastService;", "managerProvider", "Ljavax/inject/Provider;", "Lim/base/IMBroadcastManager;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMTotalUnreadBroadcastService_Factory implements Factory<IMTotalUnreadBroadcastService> {
    public static final Companion Companion = new Companion(null);
    private final Provider<IMBroadcastManager> managerProvider;

    public IMTotalUnreadBroadcastService_Factory(Provider<IMBroadcastManager> provider) {
        Intrinsics.checkNotNullParameter(provider, "managerProvider");
        this.managerProvider = provider;
    }

    /* renamed from: get */
    public IMTotalUnreadBroadcastService m3091get() {
        Companion companion = Companion;
        Object obj = this.managerProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance((IMBroadcastManager) obj);
    }

    /* compiled from: IMTotalUnreadBroadcastService_Factory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lim/base/IMTotalUnreadBroadcastService_Factory$Companion;", "", "<init>", "()V", "create", "Lim/base/IMTotalUnreadBroadcastService_Factory;", "managerProvider", "Ljavax/inject/Provider;", "Lim/base/IMBroadcastManager;", "newInstance", "Lim/base/IMTotalUnreadBroadcastService;", "manager", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IMTotalUnreadBroadcastService_Factory create(Provider<IMBroadcastManager> provider) {
            Intrinsics.checkNotNullParameter(provider, "managerProvider");
            return new IMTotalUnreadBroadcastService_Factory(provider);
        }

        @JvmStatic
        public final IMTotalUnreadBroadcastService newInstance(IMBroadcastManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            return new IMTotalUnreadBroadcastService(manager);
        }
    }

    @JvmStatic
    public static final IMTotalUnreadBroadcastService_Factory create(Provider<IMBroadcastManager> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final IMTotalUnreadBroadcastService newInstance(IMBroadcastManager manager) {
        return Companion.newInstance(manager);
    }
}