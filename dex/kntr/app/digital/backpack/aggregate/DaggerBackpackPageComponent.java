package kntr.app.digital.backpack.aggregate;

import androidx.lifecycle.Lifecycle;
import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import dagger.internal.DoubleCheck;
import java.util.Map;
import javax.inject.Provider;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.digital.backpack.BackpackPageModel;
import kntr.app.digital.backpack.BackpackUIService;
import kntr.app.digital.backpack.CreateBackpackKomponent;
import kntr.app.digital.backpack.aggregate.BackpackBusinessComponent;
import kntr.app.digital.backpack.aggregate.BackpackPageComponent;
import kntr.app.digital.backpack.api.BackpackAssetBagModel;
import kntr.app.digital.backpack.api.GetBackpackAssetBag;
import kntr.app.digital.backpack.card.CategoriesService;
import kntr.app.digital.backpack.dismiss.DismissRequest;
import kntr.app.digital.backpack.lottery.LotteryCollectionModel;
import kntr.app.digital.backpack.lottery.LotteryCollectionService;
import kntr.app.digital.backpack.lottery.LotterySelectedService;
import kntr.app.digital.backpack.navigation.NavigationBarService;
import kntr.app.digital.backpack.navigation.NavigationModel;
import kntr.app.digital.backpack.pager.PagerService;
import kntr.app.digital.backpack.tab.TabsModel;
import kntr.app.digital.backpack.tab.TabsService;
import kntr.app.digital.backpack.topbackground.TopBackgroundModel;
import kntr.app.digital.backpack.topbackground.TopBackgroundService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DaggerBackpackPageComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Factory", "BackpackBusinessComponentFactory", "BackpackBusinessComponentImpl", "BackpackPageComponentImpl", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DaggerBackpackPageComponent {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    private DaggerBackpackPageComponent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerBackpackPageComponent.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$Factory;", "Lkntr/app/digital/backpack/aggregate/BackpackPageComponent$Factory;", "<init>", "()V", "create", "Lkntr/app/digital/backpack/aggregate/BackpackPageComponent;", "activityId", RoomRecommendViewModel.EMPTY_CURSOR, "vmid", RoomRecommendViewModel.EMPTY_CURSOR, "lifecycle", "Landroidx/lifecycle/Lifecycle;", "router", "Lkntr/base/router/Router;", "reportParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "from", "fromSource", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Factory implements BackpackPageComponent.Factory {
        @Override // kntr.app.digital.backpack.aggregate.BackpackPageComponent.Factory
        public BackpackPageComponent create(int activityId, long vmid, Lifecycle lifecycle, Router router, Map<String, String> map, String from, String fromSource, KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            Intrinsics.checkNotNullParameter(router, "router");
            Intrinsics.checkNotNullParameter(map, "reportParams");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(fromSource, "fromSource");
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            return new BackpackPageComponentImpl(activityId, vmid, lifecycle, router, map, from, fromSource, komponentScope);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerBackpackPageComponent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackBusinessComponentFactory;", "Lkntr/app/digital/backpack/aggregate/BackpackBusinessComponent$Factory;", "backpackPageComponentImpl", "Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackPageComponentImpl;", "<init>", "(Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackPageComponentImpl;)V", "create", "Lkntr/app/digital/backpack/aggregate/BackpackBusinessComponent;", "assetBagModel", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class BackpackBusinessComponentFactory implements BackpackBusinessComponent.Factory {
        private final BackpackPageComponentImpl backpackPageComponentImpl;

        public BackpackBusinessComponentFactory(BackpackPageComponentImpl backpackPageComponentImpl) {
            Intrinsics.checkNotNullParameter(backpackPageComponentImpl, "backpackPageComponentImpl");
            this.backpackPageComponentImpl = backpackPageComponentImpl;
        }

        @Override // kntr.app.digital.backpack.aggregate.BackpackBusinessComponent.Factory
        public BackpackBusinessComponent create(BackpackAssetBagModel assetBagModel, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(assetBagModel, "assetBagModel");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return new BackpackBusinessComponentImpl(this.backpackPageComponentImpl, assetBagModel, scope);
        }
    }

    /* compiled from: DaggerBackpackPageComponent.kt */
    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001IB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010G\u001a\u00020H2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R \u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R \u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R \u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R \u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R \u00100\u001a\b\u0012\u0004\u0012\u0002010\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R \u00104\u001a\b\u0012\u0004\u0012\u0002050\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0015\"\u0004\b7\u0010\u0017R \u00108\u001a\b\u0012\u0004\u0012\u0002090\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R \u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0015\"\u0004\b?\u0010\u0017R \u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0015\"\u0004\bC\u0010\u0017R\u0014\u0010D\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackBusinessComponentImpl;", "Lkntr/app/digital/backpack/aggregate/BackpackBusinessComponent;", "backpackPageComponentImpl", "Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackPageComponentImpl;", "assetBagModelParam", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel;", "scopeParam", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackPageComponentImpl;Lkntr/app/digital/backpack/api/BackpackAssetBagModel;Lkotlinx/coroutines/CoroutineScope;)V", "assetBagModel", "getAssetBagModel", "()Lkntr/app/digital/backpack/api/BackpackAssetBagModel;", "scope", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "backpackBusinessComponentImpl", "provideNavigationModelProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/navigation/NavigationModel;", "getProvideNavigationModelProvider", "()Ljavax/inject/Provider;", "setProvideNavigationModelProvider", "(Ljavax/inject/Provider;)V", "navigationBarServiceProvider", "Lkntr/app/digital/backpack/navigation/NavigationBarService;", "getNavigationBarServiceProvider", "setNavigationBarServiceProvider", "provideTopBackgroundModelProvider", "Lkntr/app/digital/backpack/topbackground/TopBackgroundModel;", "getProvideTopBackgroundModelProvider", "setProvideTopBackgroundModelProvider", "topBackgroundServiceProvider", "Lkntr/app/digital/backpack/topbackground/TopBackgroundService;", "getTopBackgroundServiceProvider", "setTopBackgroundServiceProvider", "provideCardPoolCollectionModelProvider", "Lkntr/app/digital/backpack/lottery/LotteryCollectionModel;", "getProvideCardPoolCollectionModelProvider", "setProvideCardPoolCollectionModelProvider", "provideTabsModelProvider", "Lkntr/app/digital/backpack/tab/TabsModel;", "getProvideTabsModelProvider", "setProvideTabsModelProvider", "lotterySelectedServiceProvider", "Lkntr/app/digital/backpack/lottery/LotterySelectedService;", "getLotterySelectedServiceProvider", "setLotterySelectedServiceProvider", "lotteryCollectionServiceProvider", "Lkntr/app/digital/backpack/lottery/LotteryCollectionService;", "getLotteryCollectionServiceProvider", "setLotteryCollectionServiceProvider", "tabsServiceProvider", "Lkntr/app/digital/backpack/tab/TabsService;", "getTabsServiceProvider", "setTabsServiceProvider", "categoriesServiceProvider", "Lkntr/app/digital/backpack/card/CategoriesService;", "getCategoriesServiceProvider", "setCategoriesServiceProvider", "pagerServiceProvider", "Lkntr/app/digital/backpack/pager/PagerService;", "getPagerServiceProvider", "setPagerServiceProvider", "backpackUIServiceProvider", "Lkntr/app/digital/backpack/BackpackUIService;", "getBackpackUIServiceProvider", "setBackpackUIServiceProvider", "pageService", "getPageService", "()Lkntr/app/digital/backpack/BackpackUIService;", "initialize", RoomRecommendViewModel.EMPTY_CURSOR, "SwitchingProvider", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    private static final class BackpackBusinessComponentImpl implements BackpackBusinessComponent {
        private final BackpackAssetBagModel assetBagModel;
        private final BackpackBusinessComponentImpl backpackBusinessComponentImpl;
        private final BackpackPageComponentImpl backpackPageComponentImpl;
        public Provider<BackpackUIService> backpackUIServiceProvider;
        public Provider<CategoriesService> categoriesServiceProvider;
        public Provider<LotteryCollectionService> lotteryCollectionServiceProvider;
        public Provider<LotterySelectedService> lotterySelectedServiceProvider;
        public Provider<NavigationBarService> navigationBarServiceProvider;
        public Provider<PagerService> pagerServiceProvider;
        public Provider<LotteryCollectionModel> provideCardPoolCollectionModelProvider;
        public Provider<NavigationModel> provideNavigationModelProvider;
        public Provider<TabsModel> provideTabsModelProvider;
        public Provider<TopBackgroundModel> provideTopBackgroundModelProvider;
        private final CoroutineScope scope;
        public Provider<TabsService> tabsServiceProvider;
        public Provider<TopBackgroundService> topBackgroundServiceProvider;

        public BackpackBusinessComponentImpl(BackpackPageComponentImpl backpackPageComponentImpl, BackpackAssetBagModel assetBagModelParam, CoroutineScope scopeParam) {
            Intrinsics.checkNotNullParameter(backpackPageComponentImpl, "backpackPageComponentImpl");
            Intrinsics.checkNotNullParameter(assetBagModelParam, "assetBagModelParam");
            Intrinsics.checkNotNullParameter(scopeParam, "scopeParam");
            this.backpackBusinessComponentImpl = this;
            this.backpackPageComponentImpl = backpackPageComponentImpl;
            this.assetBagModel = assetBagModelParam;
            this.scope = scopeParam;
            initialize(assetBagModelParam, scopeParam);
        }

        public final BackpackAssetBagModel getAssetBagModel() {
            return this.assetBagModel;
        }

        public final CoroutineScope getScope() {
            return this.scope;
        }

        public final Provider<NavigationModel> getProvideNavigationModelProvider() {
            Provider<NavigationModel> provider = this.provideNavigationModelProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideNavigationModelProvider");
            return null;
        }

        public final void setProvideNavigationModelProvider(Provider<NavigationModel> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideNavigationModelProvider = provider;
        }

        public final Provider<NavigationBarService> getNavigationBarServiceProvider() {
            Provider<NavigationBarService> provider = this.navigationBarServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navigationBarServiceProvider");
            return null;
        }

        public final void setNavigationBarServiceProvider(Provider<NavigationBarService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.navigationBarServiceProvider = provider;
        }

        public final Provider<TopBackgroundModel> getProvideTopBackgroundModelProvider() {
            Provider<TopBackgroundModel> provider = this.provideTopBackgroundModelProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideTopBackgroundModelProvider");
            return null;
        }

        public final void setProvideTopBackgroundModelProvider(Provider<TopBackgroundModel> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideTopBackgroundModelProvider = provider;
        }

        public final Provider<TopBackgroundService> getTopBackgroundServiceProvider() {
            Provider<TopBackgroundService> provider = this.topBackgroundServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("topBackgroundServiceProvider");
            return null;
        }

        public final void setTopBackgroundServiceProvider(Provider<TopBackgroundService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.topBackgroundServiceProvider = provider;
        }

        public final Provider<LotteryCollectionModel> getProvideCardPoolCollectionModelProvider() {
            Provider<LotteryCollectionModel> provider = this.provideCardPoolCollectionModelProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideCardPoolCollectionModelProvider");
            return null;
        }

        public final void setProvideCardPoolCollectionModelProvider(Provider<LotteryCollectionModel> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideCardPoolCollectionModelProvider = provider;
        }

        public final Provider<TabsModel> getProvideTabsModelProvider() {
            Provider<TabsModel> provider = this.provideTabsModelProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideTabsModelProvider");
            return null;
        }

        public final void setProvideTabsModelProvider(Provider<TabsModel> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideTabsModelProvider = provider;
        }

        public final Provider<LotterySelectedService> getLotterySelectedServiceProvider() {
            Provider<LotterySelectedService> provider = this.lotterySelectedServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("lotterySelectedServiceProvider");
            return null;
        }

        public final void setLotterySelectedServiceProvider(Provider<LotterySelectedService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.lotterySelectedServiceProvider = provider;
        }

        public final Provider<LotteryCollectionService> getLotteryCollectionServiceProvider() {
            Provider<LotteryCollectionService> provider = this.lotteryCollectionServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("lotteryCollectionServiceProvider");
            return null;
        }

        public final void setLotteryCollectionServiceProvider(Provider<LotteryCollectionService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.lotteryCollectionServiceProvider = provider;
        }

        public final Provider<TabsService> getTabsServiceProvider() {
            Provider<TabsService> provider = this.tabsServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("tabsServiceProvider");
            return null;
        }

        public final void setTabsServiceProvider(Provider<TabsService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.tabsServiceProvider = provider;
        }

        public final Provider<CategoriesService> getCategoriesServiceProvider() {
            Provider<CategoriesService> provider = this.categoriesServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("categoriesServiceProvider");
            return null;
        }

        public final void setCategoriesServiceProvider(Provider<CategoriesService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.categoriesServiceProvider = provider;
        }

        public final Provider<PagerService> getPagerServiceProvider() {
            Provider<PagerService> provider = this.pagerServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pagerServiceProvider");
            return null;
        }

        public final void setPagerServiceProvider(Provider<PagerService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.pagerServiceProvider = provider;
        }

        public final Provider<BackpackUIService> getBackpackUIServiceProvider() {
            Provider<BackpackUIService> provider = this.backpackUIServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("backpackUIServiceProvider");
            return null;
        }

        public final void setBackpackUIServiceProvider(Provider<BackpackUIService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.backpackUIServiceProvider = provider;
        }

        @Override // kntr.app.digital.backpack.aggregate.BackpackBusinessComponent
        public BackpackUIService getPageService() {
            BackpackUIService backpackUIService = getBackpackUIServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(backpackUIService, "get(...)");
            return backpackUIService;
        }

        private final void initialize(BackpackAssetBagModel assetBagModelParam, CoroutineScope scopeParam) {
            Provider<NavigationModel> provider = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 2));
            Intrinsics.checkNotNullExpressionValue(provider, "provider(...)");
            setProvideNavigationModelProvider(provider);
            Provider<NavigationBarService> provider2 = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 1));
            Intrinsics.checkNotNullExpressionValue(provider2, "provider(...)");
            setNavigationBarServiceProvider(provider2);
            Provider<TopBackgroundModel> provider3 = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 4));
            Intrinsics.checkNotNullExpressionValue(provider3, "provider(...)");
            setProvideTopBackgroundModelProvider(provider3);
            Provider<TopBackgroundService> provider4 = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 3));
            Intrinsics.checkNotNullExpressionValue(provider4, "provider(...)");
            setTopBackgroundServiceProvider(provider4);
            Provider<LotteryCollectionModel> provider5 = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 6));
            Intrinsics.checkNotNullExpressionValue(provider5, "provider(...)");
            setProvideCardPoolCollectionModelProvider(provider5);
            Provider<TabsModel> provider6 = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 8));
            Intrinsics.checkNotNullExpressionValue(provider6, "provider(...)");
            setProvideTabsModelProvider(provider6);
            Provider<LotterySelectedService> provider7 = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 7));
            Intrinsics.checkNotNullExpressionValue(provider7, "provider(...)");
            setLotterySelectedServiceProvider(provider7);
            Provider<LotteryCollectionService> provider8 = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 5));
            Intrinsics.checkNotNullExpressionValue(provider8, "provider(...)");
            setLotteryCollectionServiceProvider(provider8);
            Provider<TabsService> provider9 = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 9));
            Intrinsics.checkNotNullExpressionValue(provider9, "provider(...)");
            setTabsServiceProvider(provider9);
            Provider<CategoriesService> provider10 = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 11));
            Intrinsics.checkNotNullExpressionValue(provider10, "provider(...)");
            setCategoriesServiceProvider(provider10);
            Provider<PagerService> provider11 = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 10));
            Intrinsics.checkNotNullExpressionValue(provider11, "provider(...)");
            setPagerServiceProvider(provider11);
            Provider<BackpackUIService> provider12 = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, this.backpackBusinessComponentImpl, 0));
            Intrinsics.checkNotNullExpressionValue(provider12, "provider(...)");
            setBackpackUIServiceProvider(provider12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DaggerBackpackPageComponent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackBusinessComponentImpl$SwitchingProvider;", "T", "Ljavax/inject/Provider;", "backpackPageComponentImpl", "Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackPageComponentImpl;", "backpackBusinessComponentImpl", "Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackBusinessComponentImpl;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackPageComponentImpl;Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackBusinessComponentImpl;I)V", "get", "()Ljava/lang/Object;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final BackpackBusinessComponentImpl backpackBusinessComponentImpl;
            private final BackpackPageComponentImpl backpackPageComponentImpl;
            private final int id;

            public SwitchingProvider(BackpackPageComponentImpl backpackPageComponentImpl, BackpackBusinessComponentImpl backpackBusinessComponentImpl, int id) {
                Intrinsics.checkNotNullParameter(backpackPageComponentImpl, "backpackPageComponentImpl");
                Intrinsics.checkNotNullParameter(backpackBusinessComponentImpl, "backpackBusinessComponentImpl");
                this.backpackPageComponentImpl = backpackPageComponentImpl;
                this.backpackBusinessComponentImpl = backpackBusinessComponentImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        NavigationBarService navigationBarService = this.backpackBusinessComponentImpl.getNavigationBarServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(navigationBarService, "get(...)");
                        TopBackgroundService topBackgroundService = this.backpackBusinessComponentImpl.getTopBackgroundServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(topBackgroundService, "get(...)");
                        LotteryCollectionService lotteryCollectionService = this.backpackBusinessComponentImpl.getLotteryCollectionServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(lotteryCollectionService, "get(...)");
                        TabsService tabsService = this.backpackBusinessComponentImpl.getTabsServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(tabsService, "get(...)");
                        PagerService pagerService = this.backpackBusinessComponentImpl.getPagerServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(pagerService, "get(...)");
                        return (T) new BackpackUIService(navigationBarService, topBackgroundService, lotteryCollectionService, tabsService, pagerService);
                    case 1:
                        NavigationModel navigationModel = this.backpackBusinessComponentImpl.getProvideNavigationModelProvider().get();
                        Intrinsics.checkNotNullExpressionValue(navigationModel, "get(...)");
                        return (T) new NavigationBarService(navigationModel, this.backpackPageComponentImpl.dismissRequest());
                    case 2:
                        return (T) BackpackModelBackedModule_ProvideNavigationModelFactory.Companion.provideNavigationModel(this.backpackBusinessComponentImpl.getAssetBagModel());
                    case 3:
                        TopBackgroundModel topBackgroundModel = this.backpackBusinessComponentImpl.getProvideTopBackgroundModelProvider().get();
                        Intrinsics.checkNotNullExpressionValue(topBackgroundModel, "get(...)");
                        return (T) new TopBackgroundService(topBackgroundModel, this.backpackPageComponentImpl.getRouter(), this.backpackPageComponentImpl.getReportParams());
                    case 4:
                        return (T) BackpackModelBackedModule_ProvideTopBackgroundModelFactory.Companion.provideTopBackgroundModel(this.backpackBusinessComponentImpl.getAssetBagModel());
                    case 5:
                        LotteryCollectionModel lotteryCollectionModel = this.backpackBusinessComponentImpl.getProvideCardPoolCollectionModelProvider().get();
                        Intrinsics.checkNotNullExpressionValue(lotteryCollectionModel, "get(...)");
                        LotterySelectedService lotterySelectedService = this.backpackBusinessComponentImpl.getLotterySelectedServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(lotterySelectedService, "get(...)");
                        return (T) new LotteryCollectionService(lotteryCollectionModel, lotterySelectedService);
                    case 6:
                        return (T) BackpackModelBackedModule_ProvideCardPoolCollectionModelFactory.Companion.provideCardPoolCollectionModel(this.backpackBusinessComponentImpl.getAssetBagModel());
                    case 7:
                        LotteryCollectionModel lotteryCollectionModel2 = this.backpackBusinessComponentImpl.getProvideCardPoolCollectionModelProvider().get();
                        Intrinsics.checkNotNullExpressionValue(lotteryCollectionModel2, "get(...)");
                        TabsModel tabsModel = this.backpackBusinessComponentImpl.getProvideTabsModelProvider().get();
                        Intrinsics.checkNotNullExpressionValue(tabsModel, "get(...)");
                        return (T) new LotterySelectedService(lotteryCollectionModel2, tabsModel, this.backpackBusinessComponentImpl.getScope(), this.backpackPageComponentImpl.getBackpackAssetBag());
                    case 8:
                        return (T) BackpackModelBackedModule_ProvideTabsModelFactory.Companion.provideTabsModel(this.backpackBusinessComponentImpl.getAssetBagModel());
                    case 9:
                        TabsModel tabsModel2 = this.backpackBusinessComponentImpl.getProvideTabsModelProvider().get();
                        Intrinsics.checkNotNullExpressionValue(tabsModel2, "get(...)");
                        LotterySelectedService lotterySelectedService2 = this.backpackBusinessComponentImpl.getLotterySelectedServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(lotterySelectedService2, "get(...)");
                        return (T) new TabsService(tabsModel2, lotterySelectedService2);
                    case 10:
                        CategoriesService categoriesService = this.backpackBusinessComponentImpl.getCategoriesServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(categoriesService, "get(...)");
                        LotterySelectedService lotterySelectedService3 = this.backpackBusinessComponentImpl.getLotterySelectedServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(lotterySelectedService3, "get(...)");
                        TabsService tabsService2 = this.backpackBusinessComponentImpl.getTabsServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(tabsService2, "get(...)");
                        return (T) new PagerService(categoriesService, lotterySelectedService3, tabsService2);
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        Router router = this.backpackPageComponentImpl.getRouter();
                        int activityId = this.backpackPageComponentImpl.getActivityId();
                        long vmid = this.backpackPageComponentImpl.getVmid();
                        String from = this.backpackPageComponentImpl.getFrom();
                        String fromSource = this.backpackPageComponentImpl.getFromSource();
                        TabsService tabsService3 = this.backpackBusinessComponentImpl.getTabsServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(tabsService3, "get(...)");
                        TabsService tabsService4 = tabsService3;
                        LotterySelectedService lotterySelectedService4 = this.backpackBusinessComponentImpl.getLotterySelectedServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(lotterySelectedService4, "get(...)");
                        return (T) new CategoriesService(router, activityId, vmid, from, fromSource, tabsService4, lotterySelectedService4);
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerBackpackPageComponent.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u00018BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000205JZ\u00106\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u00107\u001a\u00020+H\u0016R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u000e\u0010(\u001a\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00069"}, d2 = {"Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackPageComponentImpl;", "Lkntr/app/digital/backpack/aggregate/BackpackPageComponent;", "activityIdParam", RoomRecommendViewModel.EMPTY_CURSOR, "vmidParam", RoomRecommendViewModel.EMPTY_CURSOR, "lifecycleParam", "Landroidx/lifecycle/Lifecycle;", "routerParam", "Lkntr/base/router/Router;", "reportParamsParam", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "fromParam", "fromSourceParam", "komponentScopeParam", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(IJLandroidx/lifecycle/Lifecycle;Lkntr/base/router/Router;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lkntr/common/komponent/KomponentScope;)V", "activityId", "getActivityId", "()I", "vmid", "getVmid", "()J", "komponentScope", "getKomponentScope", "()Lkntr/common/komponent/KomponentScope;", "router", "getRouter", "()Lkntr/base/router/Router;", "reportParams", "getReportParams", "()Ljava/util/Map;", "from", "getFrom", "()Ljava/lang/String;", "fromSource", "getFromSource", "backpackPageComponentImpl", "backpackPageModelProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/BackpackPageModel;", "getBackpackPageModelProvider", "()Ljavax/inject/Provider;", "setBackpackPageModelProvider", "(Ljavax/inject/Provider;)V", "createBackpackKomponent", "Lkntr/app/digital/backpack/CreateBackpackKomponent;", "getBackpackAssetBag", "Lkntr/app/digital/backpack/api/GetBackpackAssetBag;", "dismissRequest", "Lkntr/app/digital/backpack/dismiss/DismissRequest;", "initialize", "pageModel", "SwitchingProvider", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class BackpackPageComponentImpl implements BackpackPageComponent {
        private final int activityId;
        private final BackpackPageComponentImpl backpackPageComponentImpl;
        public Provider<BackpackPageModel> backpackPageModelProvider;
        private final String from;
        private final String fromSource;
        private final KomponentScope<Unit> komponentScope;
        private final Map<String, String> reportParams;
        private final Router router;
        private final long vmid;

        public BackpackPageComponentImpl(int activityIdParam, long vmidParam, Lifecycle lifecycleParam, Router routerParam, Map<String, String> map, String fromParam, String fromSourceParam, KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(lifecycleParam, "lifecycleParam");
            Intrinsics.checkNotNullParameter(routerParam, "routerParam");
            Intrinsics.checkNotNullParameter(map, "reportParamsParam");
            Intrinsics.checkNotNullParameter(fromParam, "fromParam");
            Intrinsics.checkNotNullParameter(fromSourceParam, "fromSourceParam");
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScopeParam");
            this.backpackPageComponentImpl = this;
            this.activityId = activityIdParam;
            this.vmid = vmidParam;
            this.komponentScope = komponentScope;
            this.router = routerParam;
            this.reportParams = map;
            this.from = fromParam;
            this.fromSource = fromSourceParam;
            initialize(activityIdParam, vmidParam, lifecycleParam, routerParam, map, fromParam, fromSourceParam, komponentScope);
        }

        public final int getActivityId() {
            return this.activityId;
        }

        public final long getVmid() {
            return this.vmid;
        }

        public final KomponentScope<Unit> getKomponentScope() {
            return this.komponentScope;
        }

        public final Router getRouter() {
            return this.router;
        }

        public final Map<String, String> getReportParams() {
            return this.reportParams;
        }

        public final String getFrom() {
            return this.from;
        }

        public final String getFromSource() {
            return this.fromSource;
        }

        public final Provider<BackpackPageModel> getBackpackPageModelProvider() {
            Provider<BackpackPageModel> provider = this.backpackPageModelProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("backpackPageModelProvider");
            return null;
        }

        public final void setBackpackPageModelProvider(Provider<BackpackPageModel> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.backpackPageModelProvider = provider;
        }

        public final CreateBackpackKomponent createBackpackKomponent() {
            return BackpackPageComponent_Impl_ProvideCreatePreviewKomponentFactory.Companion.provideCreatePreviewKomponent(new BackpackBusinessComponentFactory(this.backpackPageComponentImpl));
        }

        public final GetBackpackAssetBag getBackpackAssetBag() {
            return BackpackPageComponent_Impl_ProvideGetBackpackAssetBagFactory.Companion.provideGetBackpackAssetBag(BackpackPageComponent_Impl_ProvideHttpClientFactory.Companion.provideHttpClient(), this.activityId, this.vmid);
        }

        public final DismissRequest dismissRequest() {
            return BackpackPageComponent_Impl_ProvideDismissRequestFactory.Companion.provideDismissRequest(this.komponentScope);
        }

        private final void initialize(int activityIdParam, long vmidParam, Lifecycle lifecycleParam, Router routerParam, Map<String, String> map, String fromParam, String fromSourceParam, KomponentScope<? super Unit> komponentScope) {
            Provider<BackpackPageModel> provider = DoubleCheck.provider(new SwitchingProvider(this.backpackPageComponentImpl, 0));
            Intrinsics.checkNotNullExpressionValue(provider, "provider(...)");
            setBackpackPageModelProvider(provider);
        }

        @Override // kntr.app.digital.backpack.aggregate.BackpackPageComponent
        public BackpackPageModel pageModel() {
            BackpackPageModel backpackPageModel = getBackpackPageModelProvider().get();
            Intrinsics.checkNotNullExpressionValue(backpackPageModel, "get(...)");
            return backpackPageModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DaggerBackpackPageComponent.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackPageComponentImpl$SwitchingProvider;", "T", "Ljavax/inject/Provider;", "backpackPageComponentImpl", "Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackPageComponentImpl;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$BackpackPageComponentImpl;I)V", "get", "()Ljava/lang/Object;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final BackpackPageComponentImpl backpackPageComponentImpl;
            private final int id;

            public SwitchingProvider(BackpackPageComponentImpl backpackPageComponentImpl, int id) {
                Intrinsics.checkNotNullParameter(backpackPageComponentImpl, "backpackPageComponentImpl");
                this.backpackPageComponentImpl = backpackPageComponentImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider
            public T get() {
                if (this.id == 0) {
                    return (T) new BackpackPageModel(this.backpackPageComponentImpl.createBackpackKomponent(), this.backpackPageComponentImpl.getBackpackAssetBag());
                }
                throw new AssertionError(this.id);
            }
        }
    }

    /* compiled from: DaggerBackpackPageComponent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lkntr/app/digital/backpack/aggregate/DaggerBackpackPageComponent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "factory", "Lkntr/app/digital/backpack/aggregate/BackpackPageComponent$Factory;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BackpackPageComponent.Factory factory() {
            return new Factory();
        }
    }
}