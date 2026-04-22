package kntr.app.digital.backpack.pager;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.backpack.card.CategoriesService;
import kntr.app.digital.backpack.lottery.LotterySelectedService;
import kntr.app.digital.backpack.tab.TabsService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagerService_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/digital/backpack/pager/PagerService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/backpack/pager/PagerService;", "categoriesServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/card/CategoriesService;", "lotterySelectedServiceProvider", "Lkntr/app/digital/backpack/lottery/LotterySelectedService;", "tabsServiceProvider", "Lkntr/app/digital/backpack/tab/TabsService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PagerService_Factory implements Factory<PagerService> {
    private final Provider<CategoriesService> categoriesServiceProvider;
    private final Provider<LotterySelectedService> lotterySelectedServiceProvider;
    private final Provider<TabsService> tabsServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public PagerService_Factory(Provider<CategoriesService> provider, Provider<LotterySelectedService> provider2, Provider<TabsService> provider3) {
        Intrinsics.checkNotNullParameter(provider, "categoriesServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "lotterySelectedServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "tabsServiceProvider");
        this.categoriesServiceProvider = provider;
        this.lotterySelectedServiceProvider = provider2;
        this.tabsServiceProvider = provider3;
    }

    public PagerService get() {
        Companion companion = Companion;
        CategoriesService categoriesService = this.categoriesServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(categoriesService, "get(...)");
        LotterySelectedService lotterySelectedService = this.lotterySelectedServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(lotterySelectedService, "get(...)");
        TabsService tabsService = this.tabsServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(tabsService, "get(...)");
        return companion.newInstance(categoriesService, lotterySelectedService, tabsService);
    }

    /* compiled from: PagerService_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/backpack/pager/PagerService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/backpack/pager/PagerService_Factory;", "categoriesServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/card/CategoriesService;", "lotterySelectedServiceProvider", "Lkntr/app/digital/backpack/lottery/LotterySelectedService;", "tabsServiceProvider", "Lkntr/app/digital/backpack/tab/TabsService;", "newInstance", "Lkntr/app/digital/backpack/pager/PagerService;", "categoriesService", "lotterySelectedService", "tabsService", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PagerService_Factory create(Provider<CategoriesService> provider, Provider<LotterySelectedService> provider2, Provider<TabsService> provider3) {
            Intrinsics.checkNotNullParameter(provider, "categoriesServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "lotterySelectedServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "tabsServiceProvider");
            return new PagerService_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final PagerService newInstance(CategoriesService categoriesService, LotterySelectedService lotterySelectedService, TabsService tabsService) {
            Intrinsics.checkNotNullParameter(categoriesService, "categoriesService");
            Intrinsics.checkNotNullParameter(lotterySelectedService, "lotterySelectedService");
            Intrinsics.checkNotNullParameter(tabsService, "tabsService");
            return new PagerService(categoriesService, lotterySelectedService, tabsService);
        }
    }

    @JvmStatic
    public static final PagerService_Factory create(Provider<CategoriesService> provider, Provider<LotterySelectedService> provider2, Provider<TabsService> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final PagerService newInstance(CategoriesService categoriesService, LotterySelectedService lotterySelectedService, TabsService tabsService) {
        return Companion.newInstance(categoriesService, lotterySelectedService, tabsService);
    }
}