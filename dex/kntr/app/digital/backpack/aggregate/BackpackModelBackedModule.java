package kntr.app.digital.backpack.aggregate;

import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.digital.backpack.api.BackpackAssetBagModel;
import kntr.app.digital.backpack.card.CardModel;
import kntr.app.digital.backpack.di.BusinessScope;
import kntr.app.digital.backpack.lottery.LotteryCollectionModel;
import kntr.app.digital.backpack.navigation.NavigationModel;
import kntr.app.digital.backpack.pager.CategoryModel;
import kntr.app.digital.backpack.tab.TabModel;
import kntr.app.digital.backpack.tab.TabsModel;
import kntr.app.digital.backpack.topbackground.TopBackgroundModel;
import kntr.app.digital.backpack.topbackground.TopButtonModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import srcs.app.digital.backpack.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.backpack.generated.resources.Res;

/* compiled from: BackpackModelBackedModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u000e"}, d2 = {"Lkntr/app/digital/backpack/aggregate/BackpackModelBackedModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideNavigationModel", "Lkntr/app/digital/backpack/navigation/NavigationModel;", "assetBagModel", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel;", "provideTopBackgroundModel", "Lkntr/app/digital/backpack/topbackground/TopBackgroundModel;", "provideCardPoolCollectionModel", "Lkntr/app/digital/backpack/lottery/LotteryCollectionModel;", "provideTabsModel", "Lkntr/app/digital/backpack/tab/TabsModel;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class BackpackModelBackedModule {
    public static final int $stable = 0;
    public static final BackpackModelBackedModule INSTANCE = new BackpackModelBackedModule();

    private BackpackModelBackedModule() {
    }

    @Provides
    @BusinessScope
    public final NavigationModel provideNavigationModel(BackpackAssetBagModel assetBagModel) {
        Intrinsics.checkNotNullParameter(assetBagModel, "assetBagModel");
        return new NavigationModel(assetBagModel.getUserFace(), "我的背包");
    }

    @Provides
    @BusinessScope
    public final TopBackgroundModel provideTopBackgroundModel(BackpackAssetBagModel assetBagModel) {
        BackpackAssetBagModel.SubModule subModule;
        BackpackAssetBagModel.SubModule subModule2;
        TopButtonModel topButtonModel;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(assetBagModel, "assetBagModel");
        List<BackpackAssetBagModel.SubModule> subModuleList = assetBagModel.getSubModuleList();
        if (subModuleList != null) {
            Iterator<T> it = subModuleList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                BackpackAssetBagModel.SubModule it2 = (BackpackAssetBagModel.SubModule) obj2;
                if (Intrinsics.areEqual(it2.getType(), "decompose")) {
                    break;
                }
            }
            subModule = (BackpackAssetBagModel.SubModule) obj2;
        } else {
            subModule = null;
        }
        BackpackAssetBagModel.SubModule decomposed = subModule;
        List<BackpackAssetBagModel.SubModule> subModuleList2 = assetBagModel.getSubModuleList();
        if (subModuleList2 != null) {
            Iterator<T> it3 = subModuleList2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it3.next();
                BackpackAssetBagModel.SubModule it4 = (BackpackAssetBagModel.SubModule) obj;
                if (Intrinsics.areEqual(it4.getType(), "donate_record")) {
                    break;
                }
            }
            subModule2 = (BackpackAssetBagModel.SubModule) obj;
        } else {
            subModule2 = null;
        }
        BackpackAssetBagModel.SubModule gift = subModule2;
        String actYImg = assetBagModel.getActYImg();
        if (decomposed != null) {
            topButtonModel = new TopButtonModel(decomposed.getData().getUrl(), Drawable0_commonMainKt.getIcon_stardust_20(Res.drawable.INSTANCE), "分解", decomposed.getData().getHasDot(), "sqzz.activity.bag.fenjie.click");
        } else {
            topButtonModel = null;
        }
        return new TopBackgroundModel(actYImg, topButtonModel, gift != null ? new TopButtonModel(gift.getData().getUrl(), Drawable0_commonMainKt.getIcon_user_20(Res.drawable.INSTANCE), "转赠", gift.getData().getHasDot(), "sqzz.activity.bag.gift.click") : null);
    }

    @Provides
    @BusinessScope
    public final LotteryCollectionModel provideCardPoolCollectionModel(BackpackAssetBagModel assetBagModel) {
        List emptyList;
        Intrinsics.checkNotNullParameter(assetBagModel, "assetBagModel");
        Iterable lotterySimpleList = assetBagModel.getLotterySimpleList();
        if (lotterySimpleList == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            Iterable $this$map$iv = lotterySimpleList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                BackpackAssetBagModel.Lottery it = (BackpackAssetBagModel.Lottery) item$iv$iv;
                destination$iv$iv.add(new LotteryCollectionModel.CardPool(it.getLotteryId(), it.getLotteryName()));
            }
            emptyList = (List) destination$iv$iv;
        }
        return new LotteryCollectionModel(emptyList);
    }

    @Provides
    @BusinessScope
    public final TabsModel provideTabsModel(BackpackAssetBagModel assetBagModel) {
        ArrayList arrayList;
        List tabs2;
        List tabs3;
        List ownedTabs1;
        List ownedTabs2;
        List ownedTabs3;
        List notOwnedTabs1;
        List notOwnedTabs2;
        List notOwnedTabs3;
        Intrinsics.checkNotNullParameter(assetBagModel, "assetBagModel");
        Iterable itemList = assetBagModel.getItemList();
        int i = 10;
        boolean z = true;
        if (itemList != null) {
            Iterable $this$filter$iv = itemList;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                BackpackAssetBagModel.Item it = (BackpackAssetBagModel.Item) element$iv$iv;
                BackpackAssetBagModel.Item it2 = it.getScarcityLevel() == 1 ? 1 : null;
                if (it2 != null) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable<BackpackAssetBagModel.Item> $this$flatMap$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (BackpackAssetBagModel.Item cardItems : $this$flatMap$iv) {
                Iterable $this$map$iv = cardItems.getCardItems();
                Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    BackpackAssetBagModel.CardItem it3 = (BackpackAssetBagModel.CardItem) item$iv$iv;
                    destination$iv$iv3.add(new CardModel(it3.getCardTypeId(), it3.getAnchorId(), it3.getCardImg(), it3.getCardName(), it3.getHoldingRate(), it3.getOwnedCount(), it3.getBadgeUrl(), true, it3.getOwnedCount() > 0 ? z : false, it3.getTag(), it3.getStockInfo()));
                    z = true;
                }
                Iterable list$iv$iv = (List) destination$iv$iv3;
                CollectionsKt.addAll(destination$iv$iv2, list$iv$iv);
                z = true;
            }
            arrayList = (List) destination$iv$iv2;
        } else {
            arrayList = null;
        }
        List tabs1 = arrayList;
        Iterable itemList2 = assetBagModel.getItemList();
        if (itemList2 != null) {
            Iterable $this$filter$iv2 = itemList2;
            Collection destination$iv$iv4 = new ArrayList();
            for (Object element$iv$iv2 : $this$filter$iv2) {
                BackpackAssetBagModel.Item it4 = (BackpackAssetBagModel.Item) element$iv$iv2;
                if (it4.getScarcityLevel() == 2) {
                    destination$iv$iv4.add(element$iv$iv2);
                }
            }
            Iterable<BackpackAssetBagModel.Item> $this$flatMap$iv2 = (List) destination$iv$iv4;
            Collection destination$iv$iv5 = new ArrayList();
            for (BackpackAssetBagModel.Item cardItems2 : $this$flatMap$iv2) {
                Iterable $this$map$iv2 = cardItems2.getCardItems();
                Collection destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, i));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    BackpackAssetBagModel.CardItem it5 = (BackpackAssetBagModel.CardItem) item$iv$iv2;
                    destination$iv$iv6.add(new CardModel(it5.getCardTypeId(), it5.getAnchorId(), it5.getCardImg(), it5.getCardName(), it5.getHoldingRate(), it5.getOwnedCount(), it5.getBadgeUrl(), false, it5.getOwnedCount() > 0, it5.getTag(), it5.getStockInfo()));
                }
                Iterable list$iv$iv2 = (List) destination$iv$iv6;
                CollectionsKt.addAll(destination$iv$iv5, list$iv$iv2);
                i = 10;
            }
            tabs2 = (List) destination$iv$iv5;
        } else {
            tabs2 = null;
        }
        Iterable collectList = assetBagModel.getCollectList();
        if (collectList != null) {
            Iterable $this$map$iv3 = collectList;
            Collection destination$iv$iv7 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
            for (Object item$iv$iv3 : $this$map$iv3) {
                BackpackAssetBagModel.Collect it6 = (BackpackAssetBagModel.Collect) item$iv$iv3;
                destination$iv$iv7.add(new CardModel(0L, it6.getAnchorId(), it6.getRedeemItemImage(), it6.getRedeemItemName(), RoomRecommendViewModel.EMPTY_CURSOR, it6.getOwnedCount(), RoomRecommendViewModel.EMPTY_CURSOR, false, it6.getOwnedCount() > 0, null, null, 1536, null));
            }
            tabs3 = (List) destination$iv$iv7;
        } else {
            tabs3 = null;
        }
        List $this$provideTabsModel_u24lambda_u245 = CollectionsKt.createListBuilder();
        List list = tabs1;
        if (!(list == null || list.isEmpty())) {
            $this$provideTabsModel_u24lambda_u245.add(new CategoryModel("隐藏款", tabs1));
        }
        List list2 = tabs2;
        if (!(list2 == null || list2.isEmpty())) {
            $this$provideTabsModel_u24lambda_u245.add(new CategoryModel("普通款", tabs2));
        }
        List list3 = tabs3;
        if (!(list3 == null || list3.isEmpty())) {
            $this$provideTabsModel_u24lambda_u245.add(new CategoryModel("任务奖励", tabs3));
        }
        List categories = CollectionsKt.build($this$provideTabsModel_u24lambda_u245);
        List $this$provideTabsModel_u24lambda_u246 = CollectionsKt.createListBuilder();
        boolean z2 = false;
        if (tabs1 != null) {
            List $this$filter$iv3 = tabs1;
            Collection destination$iv$iv8 = new ArrayList();
            for (Object element$iv$iv3 : $this$filter$iv3) {
                CardModel it7 = (CardModel) element$iv$iv3;
                if (it7.getCount() > 0) {
                    destination$iv$iv8.add(element$iv$iv3);
                }
            }
            ownedTabs1 = (List) destination$iv$iv8;
        } else {
            ownedTabs1 = CollectionsKt.emptyList();
        }
        if (tabs2 != null) {
            Iterable $this$filter$iv4 = tabs2;
            Collection destination$iv$iv9 = new ArrayList();
            for (Object element$iv$iv4 : $this$filter$iv4) {
                boolean z3 = z2;
                CardModel it8 = (CardModel) element$iv$iv4;
                if (it8.getCount() > 0) {
                    destination$iv$iv9.add(element$iv$iv4);
                }
                z2 = z3;
            }
            ownedTabs2 = (List) destination$iv$iv9;
        } else {
            ownedTabs2 = CollectionsKt.emptyList();
        }
        if (tabs3 != null) {
            Iterable $this$filter$iv5 = tabs3;
            Collection destination$iv$iv10 = new ArrayList();
            for (Object element$iv$iv5 : $this$filter$iv5) {
                Iterable $this$filter$iv6 = $this$filter$iv5;
                CardModel it9 = (CardModel) element$iv$iv5;
                if (it9.getCount() > 0) {
                    destination$iv$iv10.add(element$iv$iv5);
                }
                $this$filter$iv5 = $this$filter$iv6;
            }
            ownedTabs3 = (List) destination$iv$iv10;
        } else {
            ownedTabs3 = CollectionsKt.emptyList();
        }
        if (!ownedTabs1.isEmpty()) {
            $this$provideTabsModel_u24lambda_u246.add(new CategoryModel("隐藏款", ownedTabs1));
        }
        if (!ownedTabs2.isEmpty()) {
            $this$provideTabsModel_u24lambda_u246.add(new CategoryModel("普通款", ownedTabs2));
        }
        if (!ownedTabs3.isEmpty()) {
            $this$provideTabsModel_u24lambda_u246.add(new CategoryModel("任务奖励", ownedTabs3));
        }
        List ownedCategories = CollectionsKt.build($this$provideTabsModel_u24lambda_u246);
        List $this$provideTabsModel_u24lambda_u247 = CollectionsKt.createListBuilder();
        if (tabs1 != null) {
            List $this$filter$iv7 = tabs1;
            Collection destination$iv$iv11 = new ArrayList();
            for (Object element$iv$iv6 : $this$filter$iv7) {
                List tabs12 = tabs1;
                CardModel it10 = (CardModel) element$iv$iv6;
                if (it10.getCount() <= 0) {
                    destination$iv$iv11.add(element$iv$iv6);
                }
                tabs1 = tabs12;
            }
            notOwnedTabs1 = (List) destination$iv$iv11;
        } else {
            notOwnedTabs1 = CollectionsKt.emptyList();
        }
        if (tabs2 != null) {
            Iterable $this$filter$iv8 = tabs2;
            Collection destination$iv$iv12 = new ArrayList();
            for (Object element$iv$iv7 : $this$filter$iv8) {
                List tabs22 = tabs2;
                CardModel it11 = (CardModel) element$iv$iv7;
                if (it11.getCount() <= 0) {
                    destination$iv$iv12.add(element$iv$iv7);
                }
                tabs2 = tabs22;
            }
            notOwnedTabs2 = (List) destination$iv$iv12;
        } else {
            notOwnedTabs2 = CollectionsKt.emptyList();
        }
        if (tabs3 != null) {
            Iterable $this$filter$iv9 = tabs3;
            Collection destination$iv$iv13 = new ArrayList();
            for (Object element$iv$iv8 : $this$filter$iv9) {
                List tabs32 = tabs3;
                CardModel it12 = (CardModel) element$iv$iv8;
                if (it12.getCount() <= 0) {
                    destination$iv$iv13.add(element$iv$iv8);
                }
                tabs3 = tabs32;
            }
            notOwnedTabs3 = (List) destination$iv$iv13;
        } else {
            notOwnedTabs3 = CollectionsKt.emptyList();
        }
        if (!notOwnedTabs1.isEmpty()) {
            $this$provideTabsModel_u24lambda_u247.add(new CategoryModel("隐藏款", notOwnedTabs1));
        }
        if (!notOwnedTabs2.isEmpty()) {
            $this$provideTabsModel_u24lambda_u247.add(new CategoryModel("普通款", notOwnedTabs2));
        }
        if (!notOwnedTabs3.isEmpty()) {
            $this$provideTabsModel_u24lambda_u247.add(new CategoryModel("任务奖励", notOwnedTabs3));
        }
        List notOwnedCategories = CollectionsKt.build($this$provideTabsModel_u24lambda_u247);
        List $this$provideTabsModel_u24lambda_u248 = CollectionsKt.createListBuilder();
        $this$provideTabsModel_u24lambda_u248.add(new TabModel(0L, "全部", categories));
        $this$provideTabsModel_u24lambda_u248.add(new TabModel(1L, "已拥有", ownedCategories));
        $this$provideTabsModel_u24lambda_u248.add(new TabModel(2L, "未拥有", notOwnedCategories));
        return new TabsModel(CollectionsKt.build($this$provideTabsModel_u24lambda_u248), "卡牌已收集 " + assetBagModel.getOwnedItemCount() + "/" + assetBagModel.getTotalItemCount());
    }
}