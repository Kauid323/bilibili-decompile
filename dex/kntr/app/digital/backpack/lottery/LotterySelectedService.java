package kntr.app.digital.backpack.lottery;

import javax.inject.Inject;
import kntr.app.digital.backpack.api.GetBackpackAssetBag;
import kntr.app.digital.backpack.di.BusinessCoroutineScope;
import kntr.app.digital.backpack.di.BusinessScope;
import kntr.app.digital.backpack.lottery.LotteryCollectionModel;
import kntr.app.digital.backpack.tab.TabsModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: LotterySelectedService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lkntr/app/digital/backpack/lottery/LotterySelectedService;", RoomRecommendViewModel.EMPTY_CURSOR, "lotteryCollectionModel", "Lkntr/app/digital/backpack/lottery/LotteryCollectionModel;", "tabsModelInitializer", "Lkntr/app/digital/backpack/tab/TabsModel;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getBackpackAssetBag", "Lkntr/app/digital/backpack/api/GetBackpackAssetBag;", "<init>", "(Lkntr/app/digital/backpack/lottery/LotteryCollectionModel;Lkntr/app/digital/backpack/tab/TabsModel;Lkotlinx/coroutines/CoroutineScope;Lkntr/app/digital/backpack/api/GetBackpackAssetBag;)V", "_currentLotteryIdFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", RoomRecommendViewModel.EMPTY_CURSOR, "currentLotteryIdFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentLotteryIdFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_currentTabsModel", "currentTabsModel", "getCurrentTabsModel", "select", RoomRecommendViewModel.EMPTY_CURSOR, "lotteryId", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LotterySelectedService {
    public static final int $stable = 8;
    private final MutableStateFlow<Long> _currentLotteryIdFlow;
    private final MutableStateFlow<TabsModel> _currentTabsModel;
    private final CoroutineScope coroutineScope;
    private final StateFlow<Long> currentLotteryIdFlow;
    private final StateFlow<TabsModel> currentTabsModel;
    private final GetBackpackAssetBag getBackpackAssetBag;
    private final LotteryCollectionModel lotteryCollectionModel;
    private final TabsModel tabsModelInitializer;

    @Inject
    public LotterySelectedService(LotteryCollectionModel lotteryCollectionModel, TabsModel tabsModelInitializer, @BusinessCoroutineScope CoroutineScope coroutineScope, GetBackpackAssetBag getBackpackAssetBag) {
        Intrinsics.checkNotNullParameter(lotteryCollectionModel, "lotteryCollectionModel");
        Intrinsics.checkNotNullParameter(tabsModelInitializer, "tabsModelInitializer");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(getBackpackAssetBag, "getBackpackAssetBag");
        this.lotteryCollectionModel = lotteryCollectionModel;
        this.tabsModelInitializer = tabsModelInitializer;
        this.coroutineScope = coroutineScope;
        this.getBackpackAssetBag = getBackpackAssetBag;
        LotteryCollectionModel.CardPool cardPool = (LotteryCollectionModel.CardPool) CollectionsKt.firstOrNull(this.lotteryCollectionModel.getList());
        this._currentLotteryIdFlow = StateFlowKt.MutableStateFlow(Long.valueOf(cardPool != null ? cardPool.getLotteryId() : 0L));
        this.currentLotteryIdFlow = this._currentLotteryIdFlow;
        this._currentTabsModel = StateFlowKt.MutableStateFlow(this.tabsModelInitializer);
        this.currentTabsModel = this._currentTabsModel;
    }

    public final StateFlow<Long> getCurrentLotteryIdFlow() {
        return this.currentLotteryIdFlow;
    }

    public final StateFlow<TabsModel> getCurrentTabsModel() {
        return this.currentTabsModel;
    }

    public final void select(long lotteryId) {
        this._currentLotteryIdFlow.setValue(Long.valueOf(lotteryId));
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LotterySelectedService$select$1(this, lotteryId, null), 3, (Object) null);
    }
}