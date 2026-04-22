package kntr.common.router;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Interceptor;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalRouterModule_Companion_ProvideGlobalRouterFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/common/router/GlobalRouterModule_Companion_ProvideGlobalRouterFactory;", "Ldagger/internal/Factory;", "Lkntr/base/router/Router;", "globalInterceptorsProvider", "Ljavax/inject/Provider;", "", "Lkntr/base/router/Interceptor;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "router_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GlobalRouterModule_Companion_ProvideGlobalRouterFactory implements Factory<Router> {
    public static final Companion Companion = new Companion(null);
    private final Provider<Set<Interceptor>> globalInterceptorsProvider;

    public GlobalRouterModule_Companion_ProvideGlobalRouterFactory(Provider<Set<Interceptor>> provider) {
        Intrinsics.checkNotNullParameter(provider, "globalInterceptorsProvider");
        this.globalInterceptorsProvider = provider;
    }

    public Router get() {
        Companion companion = Companion;
        Object obj = this.globalInterceptorsProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.provideGlobalRouter((Set) obj);
    }

    /* compiled from: GlobalRouterModule_Companion_ProvideGlobalRouterFactory.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0007J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¨\u0006\r"}, d2 = {"Lkntr/common/router/GlobalRouterModule_Companion_ProvideGlobalRouterFactory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/router/GlobalRouterModule_Companion_ProvideGlobalRouterFactory;", "globalInterceptorsProvider", "Ljavax/inject/Provider;", "", "Lkntr/base/router/Interceptor;", "provideGlobalRouter", "Lkntr/base/router/Router;", "globalInterceptors", "router_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GlobalRouterModule_Companion_ProvideGlobalRouterFactory create(Provider<Set<Interceptor>> provider) {
            Intrinsics.checkNotNullParameter(provider, "globalInterceptorsProvider");
            return new GlobalRouterModule_Companion_ProvideGlobalRouterFactory(provider);
        }

        @JvmStatic
        public final Router provideGlobalRouter(Set<? extends Interceptor> set) {
            Intrinsics.checkNotNullParameter(set, "globalInterceptors");
            return GlobalRouterModule.Companion.provideGlobalRouter(set);
        }
    }

    @JvmStatic
    public static final GlobalRouterModule_Companion_ProvideGlobalRouterFactory create(Provider<Set<Interceptor>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final Router provideGlobalRouter(Set<? extends Interceptor> set) {
        return Companion.provideGlobalRouter(set);
    }
}