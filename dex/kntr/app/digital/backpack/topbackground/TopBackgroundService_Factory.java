package kntr.app.digital.backpack.topbackground;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopBackgroundService_Factory.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB=\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u0004¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/digital/backpack/topbackground/TopBackgroundService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/backpack/topbackground/TopBackgroundService;", "topBackgroundModelProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/topbackground/TopBackgroundModel;", "routerProvider", "Lkntr/base/router/Router;", "reportParamsProvider", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TopBackgroundService_Factory implements Factory<TopBackgroundService> {
    private final Provider<Map<String, String>> reportParamsProvider;
    private final Provider<Router> routerProvider;
    private final Provider<TopBackgroundModel> topBackgroundModelProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public TopBackgroundService_Factory(Provider<TopBackgroundModel> provider, Provider<Router> provider2, Provider<Map<String, String>> provider3) {
        Intrinsics.checkNotNullParameter(provider, "topBackgroundModelProvider");
        Intrinsics.checkNotNullParameter(provider2, "routerProvider");
        Intrinsics.checkNotNullParameter(provider3, "reportParamsProvider");
        this.topBackgroundModelProvider = provider;
        this.routerProvider = provider2;
        this.reportParamsProvider = provider3;
    }

    public TopBackgroundService get() {
        Companion companion = Companion;
        TopBackgroundModel topBackgroundModel = this.topBackgroundModelProvider.get();
        Intrinsics.checkNotNullExpressionValue(topBackgroundModel, "get(...)");
        Router router = this.routerProvider.get();
        Intrinsics.checkNotNullExpressionValue(router, "get(...)");
        Map<String, String> map = this.reportParamsProvider.get();
        Intrinsics.checkNotNullExpressionValue(map, "get(...)");
        return companion.newInstance(topBackgroundModel, router, map);
    }

    /* compiled from: TopBackgroundService_Factory.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f0\u0007H\u0007J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0007¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/backpack/topbackground/TopBackgroundService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/backpack/topbackground/TopBackgroundService_Factory;", "topBackgroundModelProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/topbackground/TopBackgroundModel;", "routerProvider", "Lkntr/base/router/Router;", "reportParamsProvider", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "newInstance", "Lkntr/app/digital/backpack/topbackground/TopBackgroundService;", "topBackgroundModel", "router", "reportParams", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TopBackgroundService_Factory create(Provider<TopBackgroundModel> provider, Provider<Router> provider2, Provider<Map<String, String>> provider3) {
            Intrinsics.checkNotNullParameter(provider, "topBackgroundModelProvider");
            Intrinsics.checkNotNullParameter(provider2, "routerProvider");
            Intrinsics.checkNotNullParameter(provider3, "reportParamsProvider");
            return new TopBackgroundService_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final TopBackgroundService newInstance(TopBackgroundModel topBackgroundModel, Router router, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(topBackgroundModel, "topBackgroundModel");
            Intrinsics.checkNotNullParameter(router, "router");
            Intrinsics.checkNotNullParameter(map, "reportParams");
            return new TopBackgroundService(topBackgroundModel, router, map);
        }
    }

    @JvmStatic
    public static final TopBackgroundService_Factory create(Provider<TopBackgroundModel> provider, Provider<Router> provider2, Provider<Map<String, String>> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final TopBackgroundService newInstance(TopBackgroundModel topBackgroundModel, Router router, Map<String, String> map) {
        return Companion.newInstance(topBackgroundModel, router, map);
    }
}