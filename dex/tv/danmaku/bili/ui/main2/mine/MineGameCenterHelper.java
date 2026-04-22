package tv.danmaku.bili.ui.main2.mine;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bilibili.biligame.GameCenterService;
import com.bilibili.biligame.bean.GameCenterEntrance;
import com.bilibili.biligame.external.GameCenterEntryService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.homepage.mine.MenuGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.notice.NoticeCacheService;

/* compiled from: MineGameCenterHelper.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\rJ\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\f*\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\f*\b\u0012\u0004\u0012\u00020#0\fH\u0002J\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\f*\b\u0012\u0004\u0012\u00020\r0\fH\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/MineGameCenterHelper;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "service", "Lcom/bilibili/biligame/external/GameCenterEntryService;", "getService", "()Lcom/bilibili/biligame/external/GameCenterEntryService;", "service$delegate", "Lkotlin/Lazy;", "validCheckerList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "mediatorGameData", "Landroidx/lifecycle/MediatorLiveData;", "originGameData", "Landroidx/lifecycle/LiveData;", "getOriginGameData", "()Landroidx/lifecycle/LiveData;", "originGameData$delegate", "gameData", "getGameData", "tipsCache", "Ltv/danmaku/bili/ui/notice/NoticeCacheService;", "getTipsCache", "()Ltv/danmaku/bili/ui/notice/NoticeCacheService;", "tipsCache$delegate", "syncWithGameCenter", "remoteData", "notifyGameCenterUpdate", "", "onItemClicked", "item", "transformToGame", "Lcom/bilibili/biligame/bean/GameCenterEntrance;", "transformFromGame", "toChecked", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineGameCenterHelper extends ViewModel {
    public static final int $stable = 8;
    private final Lazy service$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.MineGameCenterHelper$$ExternalSyntheticLambda0
        public final Object invoke() {
            GameCenterEntryService service_delegate$lambda$0;
            service_delegate$lambda$0 = MineGameCenterHelper.service_delegate$lambda$0();
            return service_delegate$lambda$0;
        }
    });
    private final MutableLiveData<List<MenuGroup.Item>> validCheckerList = new MutableLiveData<>();
    private final MediatorLiveData<List<MenuGroup.Item>> mediatorGameData = new MediatorLiveData<>();
    private final Lazy originGameData$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.MineGameCenterHelper$$ExternalSyntheticLambda1
        public final Object invoke() {
            LiveData originGameData_delegate$lambda$0;
            originGameData_delegate$lambda$0 = MineGameCenterHelper.originGameData_delegate$lambda$0(MineGameCenterHelper.this);
            return originGameData_delegate$lambda$0;
        }
    });
    private final LiveData<List<MenuGroup.Item>> gameData = Transformations.distinctUntilChanged(this.mediatorGameData);
    private final Lazy tipsCache$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.MineGameCenterHelper$$ExternalSyntheticLambda2
        public final Object invoke() {
            NoticeCacheService tipsCache_delegate$lambda$0;
            tipsCache_delegate$lambda$0 = MineGameCenterHelper.tipsCache_delegate$lambda$0();
            return tipsCache_delegate$lambda$0;
        }
    });

    public MineGameCenterHelper() {
        this.mediatorGameData.addSource(getOriginGameData(), new MineGameCenterHelperKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.MineGameCenterHelper$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = MineGameCenterHelper._init_$lambda$0(MineGameCenterHelper.this, (List) obj);
                return _init_$lambda$0;
            }
        }));
        this.mediatorGameData.addSource(this.validCheckerList, new MineGameCenterHelperKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.MineGameCenterHelper$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit _init_$lambda$1;
                _init_$lambda$1 = MineGameCenterHelper._init_$lambda$1(MineGameCenterHelper.this, (List) obj);
                return _init_$lambda$1;
            }
        }));
    }

    private final GameCenterEntryService getService() {
        return (GameCenterEntryService) this.service$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameCenterEntryService service_delegate$lambda$0() {
        GameCenterService gameCenterService = (GameCenterService) BLRouter.INSTANCE.get(GameCenterService.class, AppConfig.HOST_GAME_CENTER);
        if (gameCenterService != null) {
            return gameCenterService.getGameCenterEntryService((List) null);
        }
        return null;
    }

    private final LiveData<List<MenuGroup.Item>> getOriginGameData() {
        return (LiveData) this.originGameData$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData originGameData_delegate$lambda$0(final MineGameCenterHelper this$0) {
        Flow gameCenterEntrancesFlow;
        LiveData asLiveData$default;
        LiveData map;
        GameCenterEntryService service = this$0.getService();
        return (service == null || (gameCenterEntrancesFlow = service.getGameCenterEntrancesFlow()) == null || (asLiveData$default = FlowLiveDataConversions.asLiveData$default(gameCenterEntrancesFlow, ViewModelKt.getViewModelScope(this$0).getCoroutineContext(), 0L, 2, (Object) null)) == null || (map = Transformations.map(asLiveData$default, new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.MineGameCenterHelper$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                List originGameData_delegate$lambda$0$0;
                originGameData_delegate$lambda$0$0 = MineGameCenterHelper.originGameData_delegate$lambda$0$0(MineGameCenterHelper.this, (List) obj);
                return originGameData_delegate$lambda$0$0;
            }
        })) == null) ? new MutableLiveData() : map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List originGameData_delegate$lambda$0$0(MineGameCenterHelper this$0, List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return this$0.transformFromGame(list);
    }

    public final LiveData<List<MenuGroup.Item>> getGameData() {
        return this.gameData;
    }

    public final NoticeCacheService getTipsCache() {
        return (NoticeCacheService) this.tipsCache$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NoticeCacheService tipsCache_delegate$lambda$0() {
        return new NoticeCacheService("mine_game_tips");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(MineGameCenterHelper this$0, List it) {
        MediatorLiveData<List<MenuGroup.Item>> mediatorLiveData = this$0.mediatorGameData;
        Intrinsics.checkNotNull(it);
        mediatorLiveData.setValue(this$0.toChecked(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(MineGameCenterHelper this$0, List it) {
        MediatorLiveData<List<MenuGroup.Item>> mediatorLiveData = this$0.mediatorGameData;
        List<? extends MenuGroup.Item> list = (List) this$0.getOriginGameData().getValue();
        mediatorLiveData.setValue(list != null ? this$0.toChecked(list) : null);
        return Unit.INSTANCE;
    }

    public final List<MenuGroup.Item> syncWithGameCenter(List<? extends MenuGroup.Item> list) {
        if (list == null) {
            return null;
        }
        this.validCheckerList.setValue(list);
        GameCenterEntryService service = getService();
        if (service != null) {
            service.updateGameCenterEntrances(transformToGame(list));
        }
        List<? extends MenuGroup.Item> list2 = (List) getOriginGameData().getValue();
        if (list2 != null) {
            return toChecked(list2);
        }
        return null;
    }

    public final void notifyGameCenterUpdate() {
        GameCenterEntryService service = getService();
        if (service != null) {
            service.updateDownloadInfo();
        }
    }

    public final void onItemClicked(MenuGroup.Item item) {
        GameCenterEntryService service;
        Iterable $this$any$iv;
        MenuGroup.Item it;
        Intrinsics.checkNotNullParameter(item, "item");
        Iterable iterable = (List) this.validCheckerList.getValue();
        boolean z = false;
        if (iterable != null) {
            Iterable $this$any$iv2 = iterable;
            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                Iterator it2 = $this$any$iv2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object element$iv = it2.next();
                        MenuGroup.Item it3 = (MenuGroup.Item) element$iv;
                        if (it3.id == item.id) {
                            it = 1;
                            continue;
                        } else {
                            it = null;
                            continue;
                        }
                        if (it != null) {
                            $this$any$iv = 1;
                            break;
                        }
                    } else {
                        $this$any$iv = null;
                        break;
                    }
                }
            } else {
                $this$any$iv = null;
            }
            if ($this$any$iv == 1) {
                z = true;
            }
        }
        if (!z || (service = getService()) == null) {
            return;
        }
        service.gameCenterStrongEntryClick(MineGameCenterHelperKt.transformToGameCenterEntrance(item));
    }

    private final List<GameCenterEntrance> transformToGame(List<? extends MenuGroup.Item> list) {
        List<? extends MenuGroup.Item> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MenuGroup.Item p0 = (MenuGroup.Item) item$iv$iv;
            destination$iv$iv.add(MineGameCenterHelperKt.transformToGameCenterEntrance(p0));
        }
        return (List) destination$iv$iv;
    }

    private final List<MenuGroup.Item> transformFromGame(List<GameCenterEntrance> list) {
        List<GameCenterEntrance> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            GameCenterEntrance p0 = (GameCenterEntrance) item$iv$iv;
            destination$iv$iv.add(MineGameCenterHelperKt.transformFromGameCenterEntrance(p0));
        }
        return (List) destination$iv$iv;
    }

    private final List<MenuGroup.Item> toChecked(List<? extends MenuGroup.Item> list) {
        List<? extends MenuGroup.Item> $this$filter$iv = list;
        List list2 = (List) this.validCheckerList.getValue();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            MenuGroup.Item p0 = (MenuGroup.Item) element$iv$iv;
            if (MineGameCenterHelperKt.access$checkValidOf(list2, p0)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }
}