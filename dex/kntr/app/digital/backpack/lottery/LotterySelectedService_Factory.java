package kntr.app.digital.backpack.lottery;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.backpack.api.GetBackpackAssetBag;
import kntr.app.digital.backpack.tab.TabsModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LotterySelectedService_Factory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/backpack/lottery/LotterySelectedService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/backpack/lottery/LotterySelectedService;", "lotteryCollectionModelProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/lottery/LotteryCollectionModel;", "tabsModelInitializerProvider", "Lkntr/app/digital/backpack/tab/TabsModel;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "getBackpackAssetBagProvider", "Lkntr/app/digital/backpack/api/GetBackpackAssetBag;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LotterySelectedService_Factory implements Factory<LotterySelectedService> {
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<GetBackpackAssetBag> getBackpackAssetBagProvider;
    private final Provider<LotteryCollectionModel> lotteryCollectionModelProvider;
    private final Provider<TabsModel> tabsModelInitializerProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public LotterySelectedService_Factory(Provider<LotteryCollectionModel> provider, Provider<TabsModel> provider2, Provider<CoroutineScope> provider3, Provider<GetBackpackAssetBag> provider4) {
        Intrinsics.checkNotNullParameter(provider, "lotteryCollectionModelProvider");
        Intrinsics.checkNotNullParameter(provider2, "tabsModelInitializerProvider");
        Intrinsics.checkNotNullParameter(provider3, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider4, "getBackpackAssetBagProvider");
        this.lotteryCollectionModelProvider = provider;
        this.tabsModelInitializerProvider = provider2;
        this.coroutineScopeProvider = provider3;
        this.getBackpackAssetBagProvider = provider4;
    }

    public LotterySelectedService get() {
        Companion companion = Companion;
        LotteryCollectionModel lotteryCollectionModel = this.lotteryCollectionModelProvider.get();
        Intrinsics.checkNotNullExpressionValue(lotteryCollectionModel, "get(...)");
        TabsModel tabsModel = this.tabsModelInitializerProvider.get();
        Intrinsics.checkNotNullExpressionValue(tabsModel, "get(...)");
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        GetBackpackAssetBag getBackpackAssetBag = this.getBackpackAssetBagProvider.get();
        Intrinsics.checkNotNullExpressionValue(getBackpackAssetBag, "get(...)");
        return companion.newInstance(lotteryCollectionModel, tabsModel, coroutineScope, getBackpackAssetBag);
    }

    /* compiled from: LotterySelectedService_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/digital/backpack/lottery/LotterySelectedService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/backpack/lottery/LotterySelectedService_Factory;", "lotteryCollectionModelProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/lottery/LotteryCollectionModel;", "tabsModelInitializerProvider", "Lkntr/app/digital/backpack/tab/TabsModel;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "getBackpackAssetBagProvider", "Lkntr/app/digital/backpack/api/GetBackpackAssetBag;", "newInstance", "Lkntr/app/digital/backpack/lottery/LotterySelectedService;", "lotteryCollectionModel", "tabsModelInitializer", "coroutineScope", "getBackpackAssetBag", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LotterySelectedService_Factory create(Provider<LotteryCollectionModel> provider, Provider<TabsModel> provider2, Provider<CoroutineScope> provider3, Provider<GetBackpackAssetBag> provider4) {
            Intrinsics.checkNotNullParameter(provider, "lotteryCollectionModelProvider");
            Intrinsics.checkNotNullParameter(provider2, "tabsModelInitializerProvider");
            Intrinsics.checkNotNullParameter(provider3, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider4, "getBackpackAssetBagProvider");
            return new LotterySelectedService_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final LotterySelectedService newInstance(LotteryCollectionModel lotteryCollectionModel, TabsModel tabsModelInitializer, CoroutineScope coroutineScope, GetBackpackAssetBag getBackpackAssetBag) {
            Intrinsics.checkNotNullParameter(lotteryCollectionModel, "lotteryCollectionModel");
            Intrinsics.checkNotNullParameter(tabsModelInitializer, "tabsModelInitializer");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(getBackpackAssetBag, "getBackpackAssetBag");
            return new LotterySelectedService(lotteryCollectionModel, tabsModelInitializer, coroutineScope, getBackpackAssetBag);
        }
    }

    @JvmStatic
    public static final LotterySelectedService_Factory create(Provider<LotteryCollectionModel> provider, Provider<TabsModel> provider2, Provider<CoroutineScope> provider3, Provider<GetBackpackAssetBag> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final LotterySelectedService newInstance(LotteryCollectionModel lotteryCollectionModel, TabsModel tabsModelInitializer, CoroutineScope coroutineScope, GetBackpackAssetBag getBackpackAssetBag) {
        return Companion.newInstance(lotteryCollectionModel, tabsModelInitializer, coroutineScope, getBackpackAssetBag);
    }
}