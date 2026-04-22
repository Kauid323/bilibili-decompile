package kntr.app.digital.backpack.card;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.backpack.lottery.LotterySelectedService;
import kntr.app.digital.backpack.tab.TabsService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CategoriesService_Factory.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014Bi\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/app/digital/backpack/card/CategoriesService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/backpack/card/CategoriesService;", "routerProvider", "Ljavax/inject/Provider;", "Lkntr/base/router/Router;", "actIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "vmidProvider", RoomRecommendViewModel.EMPTY_CURSOR, "fromProvider", RoomRecommendViewModel.EMPTY_CURSOR, "fromSourceProvider", "tabsServiceProvider", "Lkntr/app/digital/backpack/tab/TabsService;", "lotterySelectedServiceProvider", "Lkntr/app/digital/backpack/lottery/LotterySelectedService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CategoriesService_Factory implements Factory<CategoriesService> {
    private final Provider<Integer> actIdProvider;
    private final Provider<String> fromProvider;
    private final Provider<String> fromSourceProvider;
    private final Provider<LotterySelectedService> lotterySelectedServiceProvider;
    private final Provider<Router> routerProvider;
    private final Provider<TabsService> tabsServiceProvider;
    private final Provider<Long> vmidProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public CategoriesService_Factory(Provider<Router> provider, Provider<Integer> provider2, Provider<Long> provider3, Provider<String> provider4, Provider<String> provider5, Provider<TabsService> provider6, Provider<LotterySelectedService> provider7) {
        Intrinsics.checkNotNullParameter(provider, "routerProvider");
        Intrinsics.checkNotNullParameter(provider2, "actIdProvider");
        Intrinsics.checkNotNullParameter(provider3, "vmidProvider");
        Intrinsics.checkNotNullParameter(provider4, "fromProvider");
        Intrinsics.checkNotNullParameter(provider5, "fromSourceProvider");
        Intrinsics.checkNotNullParameter(provider6, "tabsServiceProvider");
        Intrinsics.checkNotNullParameter(provider7, "lotterySelectedServiceProvider");
        this.routerProvider = provider;
        this.actIdProvider = provider2;
        this.vmidProvider = provider3;
        this.fromProvider = provider4;
        this.fromSourceProvider = provider5;
        this.tabsServiceProvider = provider6;
        this.lotterySelectedServiceProvider = provider7;
    }

    public CategoriesService get() {
        Companion companion = Companion;
        Router router = this.routerProvider.get();
        Intrinsics.checkNotNullExpressionValue(router, "get(...)");
        Integer num = this.actIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        int intValue = num.intValue();
        Long l = this.vmidProvider.get();
        Intrinsics.checkNotNullExpressionValue(l, "get(...)");
        long longValue = l.longValue();
        String str = this.fromProvider.get();
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String str2 = this.fromSourceProvider.get();
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        TabsService tabsService = this.tabsServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(tabsService, "get(...)");
        LotterySelectedService lotterySelectedService = this.lotterySelectedServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(lotterySelectedService, "get(...)");
        return companion.newInstance(router, intValue, longValue, str, str2, tabsService, lotterySelectedService);
    }

    /* compiled from: CategoriesService_Factory.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jj\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007H\u0007J@\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0013H\u0007¨\u0006\u001d"}, d2 = {"Lkntr/app/digital/backpack/card/CategoriesService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/backpack/card/CategoriesService_Factory;", "routerProvider", "Ljavax/inject/Provider;", "Lkntr/base/router/Router;", "actIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "vmidProvider", RoomRecommendViewModel.EMPTY_CURSOR, "fromProvider", RoomRecommendViewModel.EMPTY_CURSOR, "fromSourceProvider", "tabsServiceProvider", "Lkntr/app/digital/backpack/tab/TabsService;", "lotterySelectedServiceProvider", "Lkntr/app/digital/backpack/lottery/LotterySelectedService;", "newInstance", "Lkntr/app/digital/backpack/card/CategoriesService;", "router", "actId", "vmid", "from", "fromSource", "tabsService", "lotterySelectedService", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CategoriesService_Factory create(Provider<Router> provider, Provider<Integer> provider2, Provider<Long> provider3, Provider<String> provider4, Provider<String> provider5, Provider<TabsService> provider6, Provider<LotterySelectedService> provider7) {
            Intrinsics.checkNotNullParameter(provider, "routerProvider");
            Intrinsics.checkNotNullParameter(provider2, "actIdProvider");
            Intrinsics.checkNotNullParameter(provider3, "vmidProvider");
            Intrinsics.checkNotNullParameter(provider4, "fromProvider");
            Intrinsics.checkNotNullParameter(provider5, "fromSourceProvider");
            Intrinsics.checkNotNullParameter(provider6, "tabsServiceProvider");
            Intrinsics.checkNotNullParameter(provider7, "lotterySelectedServiceProvider");
            return new CategoriesService_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
        }

        @JvmStatic
        public final CategoriesService newInstance(Router router, int actId, long vmid, String from, String fromSource, TabsService tabsService, LotterySelectedService lotterySelectedService) {
            Intrinsics.checkNotNullParameter(router, "router");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(fromSource, "fromSource");
            Intrinsics.checkNotNullParameter(tabsService, "tabsService");
            Intrinsics.checkNotNullParameter(lotterySelectedService, "lotterySelectedService");
            return new CategoriesService(router, actId, vmid, from, fromSource, tabsService, lotterySelectedService);
        }
    }

    @JvmStatic
    public static final CategoriesService_Factory create(Provider<Router> provider, Provider<Integer> provider2, Provider<Long> provider3, Provider<String> provider4, Provider<String> provider5, Provider<TabsService> provider6, Provider<LotterySelectedService> provider7) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @JvmStatic
    public static final CategoriesService newInstance(Router router, int actId, long vmid, String from, String fromSource, TabsService tabsService, LotterySelectedService lotterySelectedService) {
        return Companion.newInstance(router, actId, vmid, from, fromSource, tabsService, lotterySelectedService);
    }
}