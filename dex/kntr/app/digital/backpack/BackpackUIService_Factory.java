package kntr.app.digital.backpack;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.backpack.lottery.LotteryCollectionService;
import kntr.app.digital.backpack.navigation.NavigationBarService;
import kntr.app.digital.backpack.pager.PagerService;
import kntr.app.digital.backpack.tab.TabsService;
import kntr.app.digital.backpack.topbackground.TopBackgroundService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackpackUIService_Factory.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011BM\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/backpack/BackpackUIService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/backpack/BackpackUIService;", "navigationBarServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/navigation/NavigationBarService;", "topBackgroundServiceProvider", "Lkntr/app/digital/backpack/topbackground/TopBackgroundService;", "lotteryCollectionServiceProvider", "Lkntr/app/digital/backpack/lottery/LotteryCollectionService;", "tabsServiceProvider", "Lkntr/app/digital/backpack/tab/TabsService;", "pagerServiceProvider", "Lkntr/app/digital/backpack/pager/PagerService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BackpackUIService_Factory implements Factory<BackpackUIService> {
    private final Provider<LotteryCollectionService> lotteryCollectionServiceProvider;
    private final Provider<NavigationBarService> navigationBarServiceProvider;
    private final Provider<PagerService> pagerServiceProvider;
    private final Provider<TabsService> tabsServiceProvider;
    private final Provider<TopBackgroundService> topBackgroundServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public BackpackUIService_Factory(Provider<NavigationBarService> provider, Provider<TopBackgroundService> provider2, Provider<LotteryCollectionService> provider3, Provider<TabsService> provider4, Provider<PagerService> provider5) {
        Intrinsics.checkNotNullParameter(provider, "navigationBarServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "topBackgroundServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "lotteryCollectionServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "tabsServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "pagerServiceProvider");
        this.navigationBarServiceProvider = provider;
        this.topBackgroundServiceProvider = provider2;
        this.lotteryCollectionServiceProvider = provider3;
        this.tabsServiceProvider = provider4;
        this.pagerServiceProvider = provider5;
    }

    public BackpackUIService get() {
        Companion companion = Companion;
        NavigationBarService navigationBarService = this.navigationBarServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(navigationBarService, "get(...)");
        TopBackgroundService topBackgroundService = this.topBackgroundServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(topBackgroundService, "get(...)");
        LotteryCollectionService lotteryCollectionService = this.lotteryCollectionServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(lotteryCollectionService, "get(...)");
        TabsService tabsService = this.tabsServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(tabsService, "get(...)");
        PagerService pagerService = this.pagerServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(pagerService, "get(...)");
        return companion.newInstance(navigationBarService, topBackgroundService, lotteryCollectionService, tabsService, pagerService);
    }

    /* compiled from: BackpackUIService_Factory.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0007J0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0010H\u0007¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/backpack/BackpackUIService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/backpack/BackpackUIService_Factory;", "navigationBarServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/navigation/NavigationBarService;", "topBackgroundServiceProvider", "Lkntr/app/digital/backpack/topbackground/TopBackgroundService;", "lotteryCollectionServiceProvider", "Lkntr/app/digital/backpack/lottery/LotteryCollectionService;", "tabsServiceProvider", "Lkntr/app/digital/backpack/tab/TabsService;", "pagerServiceProvider", "Lkntr/app/digital/backpack/pager/PagerService;", "newInstance", "Lkntr/app/digital/backpack/BackpackUIService;", "navigationBarService", "topBackgroundService", "lotteryCollectionService", "tabsService", "pagerService", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BackpackUIService_Factory create(Provider<NavigationBarService> provider, Provider<TopBackgroundService> provider2, Provider<LotteryCollectionService> provider3, Provider<TabsService> provider4, Provider<PagerService> provider5) {
            Intrinsics.checkNotNullParameter(provider, "navigationBarServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "topBackgroundServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "lotteryCollectionServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "tabsServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "pagerServiceProvider");
            return new BackpackUIService_Factory(provider, provider2, provider3, provider4, provider5);
        }

        @JvmStatic
        public final BackpackUIService newInstance(NavigationBarService navigationBarService, TopBackgroundService topBackgroundService, LotteryCollectionService lotteryCollectionService, TabsService tabsService, PagerService pagerService) {
            Intrinsics.checkNotNullParameter(navigationBarService, "navigationBarService");
            Intrinsics.checkNotNullParameter(topBackgroundService, "topBackgroundService");
            Intrinsics.checkNotNullParameter(lotteryCollectionService, "lotteryCollectionService");
            Intrinsics.checkNotNullParameter(tabsService, "tabsService");
            Intrinsics.checkNotNullParameter(pagerService, "pagerService");
            return new BackpackUIService(navigationBarService, topBackgroundService, lotteryCollectionService, tabsService, pagerService);
        }
    }

    @JvmStatic
    public static final BackpackUIService_Factory create(Provider<NavigationBarService> provider, Provider<TopBackgroundService> provider2, Provider<LotteryCollectionService> provider3, Provider<TabsService> provider4, Provider<PagerService> provider5) {
        return Companion.create(provider, provider2, provider3, provider4, provider5);
    }

    @JvmStatic
    public static final BackpackUIService newInstance(NavigationBarService navigationBarService, TopBackgroundService topBackgroundService, LotteryCollectionService lotteryCollectionService, TabsService tabsService, PagerService pagerService) {
        return Companion.newInstance(navigationBarService, topBackgroundService, lotteryCollectionService, tabsService, pagerService);
    }
}