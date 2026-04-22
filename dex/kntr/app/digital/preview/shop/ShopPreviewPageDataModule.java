package kntr.app.digital.preview.shop;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.bilibili.lib.brouter.uri.Builder;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.FromParams;
import kntr.app.digital.preview.VMid;
import kntr.app.digital.preview.ViewBlockchainInfoAction;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.Report;
import kntr.app.digital.preview.api.ActionItem;
import kntr.app.digital.preview.api.CardData;
import kntr.app.digital.preview.api.CardPreviewModel;
import kntr.app.digital.preview.api.CollectionRewardData;
import kntr.app.digital.preview.api.DescTag;
import kntr.app.digital.preview.api.ModuleItem;
import kntr.app.digital.preview.api.Play;
import kntr.app.digital.preview.api.ReshapingModel;
import kntr.app.digital.preview.api.ResultItem;
import kntr.app.digital.preview.api.RewardData;
import kntr.app.digital.preview.api.RewardEnd;
import kntr.app.digital.preview.api.RewardNotReceived;
import kntr.app.digital.preview.api.RewardReceived;
import kntr.app.digital.preview.api.ShareModel;
import kntr.app.digital.preview.api.SmeltGuideModel;
import kntr.app.digital.preview.api.TopText;
import kntr.app.digital.preview.api.Using;
import kntr.app.digital.preview.api.ViewActivity;
import kntr.app.digital.preview.api.ViewMoreModel;
import kntr.app.digital.preview.api.ViewingHolding;
import kntr.app.digital.preview.button.DigitalButton;
import kntr.app.digital.preview.card.CardBasic;
import kntr.app.digital.preview.card.DigitalCardListUIService;
import kntr.app.digital.preview.card.InitialBackAnchorId;
import kntr.app.digital.preview.card.InitialBackHasMore;
import kntr.app.digital.preview.card.InitialFrontAnchorId;
import kntr.app.digital.preview.card.InitialFrontHasMore;
import kntr.app.digital.preview.card.InitialRequestExtraParams;
import kntr.app.digital.preview.card.image.ImageCard;
import kntr.app.digital.preview.card.video.VideoCard;
import kntr.app.digital.preview.card.web.WebCard;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.digital.preview.closing.ClosingAction;
import kntr.app.digital.preview.gift.GiftAction;
import kntr.app.digital.preview.reshaping.ReshapingAction;
import kntr.app.digital.preview.router.RouterAction;
import kntr.app.digital.preview.smelting.SmeltingTutorialAction;
import kntr.app.digital.preview.toast.ToastAction;
import kntr.app.digital.preview.usage.UsageAction;
import kntr.app.digital.preview.viewmore.ViewMoreAction;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: ShopPreviewPageDataModule.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0004\u001a\u0011\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0006¢\u0006\u0002\b\u00070\u00052\b\b\u0001\u0010\b\u001a\u00020\t2\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001f\u0010\u000f\u001a\u00020\u00102\u0015\u0010\u0011\u001a\u0011\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0006¢\u0006\u0002\b\u00070\u0005H\u0007J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewPageDataModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideDigitalCardList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "Lkotlin/jvm/JvmSuppressWildcards;", "vMid", RoomRecommendViewModel.EMPTY_CURSOR, "fromParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "originModel", "Lkntr/app/digital/preview/api/CardPreviewModel;", "provideInitialPage", RoomRecommendViewModel.EMPTY_CURSOR, "cardList", "provideInitialRequestExtraParams", "provideInitialFrontAnchorId", "provideInitialBackAnchorId", "provideInitialFrontHasMore", RoomRecommendViewModel.EMPTY_CURSOR, "provideInitialBackHasMore", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ShopPreviewPageDataModule {
    public static final int $stable = 0;
    public static final ShopPreviewPageDataModule INSTANCE = new ShopPreviewPageDataModule();

    private ShopPreviewPageDataModule() {
    }

    private static final Action<?> provideDigitalCardList$generateTopBar(long $vMid, Map<String, String> map, ModuleItem moduleItem) {
        boolean z = moduleItem instanceof SmeltGuideModel;
        String arrive = AdSearchSubCardType.CARD_TYPE_2;
        if (z) {
            SmeltGuideModel.Data model = ((SmeltGuideModel) moduleItem).getData();
            isMe = $vMid == ShopPreviewPageDataModuleKt.getMid();
            Builder buildUpon = UrisKt.toUri("bilibili://digital/smelting_tutorial/kntr").buildUpon();
            JsonObjectBuilder builder$iv = new JsonObjectBuilder();
            for (Map.Entry element$iv : map.entrySet()) {
                String key = element$iv.getKey();
                String value = element$iv.getValue();
                JsonElementBuildersKt.put(builder$iv, key, value);
            }
            String str = AdSearchSubCardType.CARD_TYPE_NONE;
            JsonElementBuildersKt.put(builder$iv, "is_huixingka", (isMe || model.getHoldingSmelt()) ? "1" : AdSearchSubCardType.CARD_TYPE_NONE);
            Unit unit = Unit.INSTANCE;
            SmeltingTutorialAction smeltingTutorialAction = new SmeltingTutorialAction(buildUpon.appendQueryParameter("report_params", builder$iv.build().toString()).build().toString());
            Map $this$provideDigitalCardList_u24generateTopBar_u24lambda_u241 = MapsKt.createMapBuilder();
            if (isMe) {
                arrive = "1";
            }
            $this$provideDigitalCardList_u24generateTopBar_u24lambda_u241.put("arrive", arrive);
            $this$provideDigitalCardList_u24generateTopBar_u24lambda_u241.put("is_huixingka", (isMe || model.getHoldingSmelt()) ? "1" : "1");
            Unit unit2 = Unit.INSTANCE;
            return new Action<>(smeltingTutorialAction, new Report("sqzz.dressing.rebuild.guide.click", MapsKt.build($this$provideDigitalCardList_u24generateTopBar_u24lambda_u241)));
        } else if (moduleItem instanceof ViewMoreModel) {
            ViewMoreModel.Data model2 = ((ViewMoreModel) moduleItem).getData();
            List $this$provideDigitalCardList_u24generateTopBar_u24lambda_u242 = CollectionsKt.createListBuilder();
            if (model2.getCanTransfer()) {
                GiftAction giftAction = GiftAction.INSTANCE;
                Map $this$provideDigitalCardList_u24generateTopBar_u24lambda_u242_u240 = MapsKt.createMapBuilder();
                $this$provideDigitalCardList_u24generateTopBar_u24lambda_u242_u240.put("bottom_id", AdSearchSubCardType.CARD_TYPE_2);
                Unit unit3 = Unit.INSTANCE;
                $this$provideDigitalCardList_u24generateTopBar_u24lambda_u242.add(new ViewMoreAction.Item("转赠", new Action(giftAction, new Report("sqzz.activity.bag.card-more.click", MapsKt.build($this$provideDigitalCardList_u24generateTopBar_u24lambda_u242_u240)))));
            }
            String blockChainLink = model2.getBlockChainLink();
            if (blockChainLink != null && !StringsKt.isBlank(blockChainLink)) {
                isMe = false;
            }
            if (!isMe) {
                $this$provideDigitalCardList_u24generateTopBar_u24lambda_u242.add(new ViewMoreAction.Item("区块链信息", new Action(new ViewBlockchainInfoAction(model2.getBlockChainLink()), null, 2, null)));
            }
            return new Action<>(new ViewMoreAction(CollectionsKt.build($this$provideDigitalCardList_u24generateTopBar_u24lambda_u242)), null, 2, null);
        } else if (!(moduleItem instanceof ShareModel)) {
            throw new NoWhenBranchMatchedException();
        } else {
            return new Action<>(((ShareModel) moduleItem).getData(), new Report("sqzz.activity.bag.card-share.click", null, 2, null));
        }
    }

    private static final DigitalButton provideDigitalCardList$generateButton(ActionItem actionItem) {
        Action action;
        long Color;
        long Color2;
        if (actionItem instanceof ViewingHolding) {
            RouterAction routerAction = ((ViewingHolding) actionItem).getData();
            return new DigitalButton(((ViewingHolding) actionItem).getTitle(), ColorKt.Color(4294967295L), ColorKt.Color(2164260863L), CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(620756991)), Color.box-impl(ColorKt.Color(788529151))}), null, new Action(routerAction, null, 2, null), 16, null);
        } else if (actionItem instanceof Using) {
            UsageAction usingAction = ((Using) actionItem).getData();
            String title = ((Using) actionItem).getTitle();
            if (usingAction.getCanUse()) {
                Color = ColorKt.Color(4294967295L);
            } else {
                Color = ColorKt.Color(1291845631);
            }
            if (usingAction.getCanUse()) {
                Color2 = ColorKt.Color(2164260863L);
            } else {
                Color2 = ColorKt.Color(1308622847);
            }
            List listOf = usingAction.getCanUse() ? CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(620756991)), Color.box-impl(ColorKt.Color(788529151))}) : null;
            String badgeUrl = usingAction.getBadgeUrl();
            if (badgeUrl == null) {
                badgeUrl = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            return new DigitalButton(title, Color, Color2, listOf, badgeUrl, new Action(usingAction, new Report("sqzz.dressing.single-card.use.click", MapsKt.emptyMap())), null);
        } else if (actionItem instanceof ReshapingModel) {
            ReshapingAction reshapingAction = ((ReshapingModel) actionItem).getData();
            String title2 = ((ReshapingModel) actionItem).getTitle();
            long Color3 = ColorKt.Color(4279834905L);
            List listOf2 = CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4294967295L)), Color.box-impl(ColorKt.Color(4294964413L))});
            if (IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "smelting_usage_restriction", false, 2, (Object) null)) {
                action = new Action(reshapingAction, new Report("sqzz.dressing.collection.rebuild.click", null, 2, null));
            } else {
                action = new Action(new ToastAction("由于系统限制，您当前的版本可能无法支持该功能"), new Report("sqzz.dressing.collection.rebuild.click", null, 2, null));
            }
            return new DigitalButton(title2, Color3, 0L, listOf2, null, action, 20, null);
        } else if (actionItem instanceof ViewActivity) {
            RouterAction routerAction2 = ((ViewActivity) actionItem).getData();
            return new DigitalButton(((ViewActivity) actionItem).getTitle(), ColorKt.Color(4294967295L), ColorKt.Color(Integer.MAX_VALUE), CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(570425343)), Color.box-impl(ColorKt.Color(872415231))}), null, new Action(routerAction2, null, 2, null), 16, null);
        } else if (actionItem instanceof RewardNotReceived) {
            RewardData rewardData = ((RewardNotReceived) actionItem).getData();
            return new DigitalButton(((RewardNotReceived) actionItem).getTitle(), ColorKt.Color(4294964669L), 0L, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(ColorKt.Color(4294964669L), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(ColorKt.Color(4294964669L), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), null, new Action(new RouterAction(rewardData.getLink()), new Report("sqzz.activity.bag.rewards-get.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("bottom_type", "1"), TuplesKt.to("rewards_id", rewardData.getRewardsId())}))), 20, null);
        } else if (actionItem instanceof RewardEnd) {
            return new DigitalButton(((RewardEnd) actionItem).getTitle(), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), null, null, new Action(Unit.INSTANCE, new Report("sqzz.activity.bag.rewards-get.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("bottom_type", AdSearchSubCardType.CARD_TYPE_3), TuplesKt.to("rewards_id", ((RewardEnd) actionItem).getData().getRewardsId())}))), 24, null);
        } else if (!(actionItem instanceof RewardReceived)) {
            throw new NoWhenBranchMatchedException();
        } else {
            RewardData rewardData2 = ((RewardReceived) actionItem).getData();
            return new DigitalButton(((RewardReceived) actionItem).getTitle(), ColorKt.Color(4294964669L), Color.copy-wmQWz5c$default(ColorKt.Color(4294964669L), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), null, null, new Action(new RouterAction(rewardData2.getLink()), new Report("sqzz.activity.bag.rewards-get.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("bottom_type", AdSearchSubCardType.CARD_TYPE_2), TuplesKt.to("rewards_id", rewardData2.getRewardsId())}))), 24, null);
        }
    }

    private static final CardBasic provideDigitalCardList$generateCardBasic(CardPreviewModel $originModel, long $vMid, Map<String, String> map, ResultItem resultItem, CollectionRewardData.Data data) {
        List emptyList;
        boolean z;
        String uniqueId = data.getUniqueId();
        boolean isAnchorItem = resultItem.isAnchorItem();
        CardBasic.CardIdInfo cardIdInfo = new CardBasic.CardIdInfo(0L, 0L, data.getUniqueId());
        boolean z2 = !data.getHighlighted();
        Map $this$provideDigitalCardList_u24generateCardBasic_u24lambda_u243 = MapsKt.createMapBuilder();
        $this$provideDigitalCardList_u24generateCardBasic_u24lambda_u243.put("activity_status", String.valueOf($originModel.getActivityStatus()));
        $this$provideDigitalCardList_u24generateCardBasic_u24lambda_u243.put("card_id", data.getRedeemItemId());
        Map build = MapsKt.build($this$provideDigitalCardList_u24generateCardBasic_u24lambda_u243);
        String redeemItemName = data.getRedeemItemName();
        DescTag descTag = data.getDescTag();
        String holdingRate = data.getHoldingRate();
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        if (holdingRate == null) {
            holdingRate = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        String holdingRateUrl = data.getHoldingRateUrl();
        if (holdingRateUrl != null) {
            str = holdingRateUrl;
        }
        CardBasic.Rarity rarity = new CardBasic.Rarity(holdingRate, UrisKt.toUri(str).buildUpon().build().toString());
        TopText topText = data.getTopText();
        Iterable actions = data.getActions();
        if (actions != null) {
            Iterable $this$map$iv = actions;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ActionItem it = (ActionItem) item$iv$iv;
                destination$iv$iv.add(provideDigitalCardList$generateButton(it));
                $this$map$iv = $this$map$iv;
            }
            emptyList = (List) destination$iv$iv;
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        List list = emptyList;
        List createListBuilder = CollectionsKt.createListBuilder();
        List $this$provideDigitalCardList_u24generateCardBasic_u24lambda_u245 = createListBuilder;
        $this$provideDigitalCardList_u24generateCardBasic_u24lambda_u245.add(new Action(ClosingAction.INSTANCE, null, 2, null));
        Iterable modules = data.getModules();
        if (modules != null) {
            Iterable $this$mapTo$iv = modules;
            List destination$iv = $this$provideDigitalCardList_u24generateCardBasic_u24lambda_u245;
            boolean z3 = false;
            Iterator it2 = $this$mapTo$iv.iterator();
            while (it2.hasNext()) {
                Object item$iv = it2.next();
                List $this$provideDigitalCardList_u24generateCardBasic_u24lambda_u2452 = $this$provideDigitalCardList_u24generateCardBasic_u24lambda_u245;
                ModuleItem it3 = (ModuleItem) item$iv;
                destination$iv.add(provideDigitalCardList$generateTopBar($vMid, map, it3));
                $this$provideDigitalCardList_u24generateCardBasic_u24lambda_u245 = $this$provideDigitalCardList_u24generateCardBasic_u24lambda_u2452;
                z2 = z2;
                it2 = it2;
                z3 = z3;
            }
            z = z2;
        } else {
            z = z2;
        }
        return new CardBasic(uniqueId, isAnchorItem, redeemItemName, null, data.getRedeemItemImage(), null, true, false, z, rarity, list, cardIdInfo, build, topText, descTag, CollectionsKt.build(createListBuilder), null, 65576, null);
    }

    private static final CardBasic provideDigitalCardList$generateCardBasic$6(long $vMid, CardPreviewModel $originModel, Map<String, String> map, ResultItem resultItem, CardData.Data data) {
        String str;
        CardBasic.Rarity rarity;
        List emptyList;
        String uniqueId = data.getUniqueId();
        boolean isAnchorItem = resultItem.isAnchorItem();
        CardBasic.CardIdInfo cardIdInfo = new CardBasic.CardIdInfo(data.getCardId() == 0 ? data.getCardTypeId() : data.getCardId(), data.getCardTypeId(), data.getCardNo());
        String cardImage = data.getCardImage();
        boolean z = !data.getHighlighted();
        Map $this$provideDigitalCardList_u24generateCardBasic_u246_u24lambda_u247 = MapsKt.createMapBuilder();
        $this$provideDigitalCardList_u24generateCardBasic_u246_u24lambda_u247.put("activity_status", String.valueOf($originModel.getActivityStatus()));
        $this$provideDigitalCardList_u24generateCardBasic_u246_u24lambda_u247.put("card_id", String.valueOf(data.getCardId() == 0 ? data.getCardTypeId() : data.getCardId()));
        Map build = MapsKt.build($this$provideDigitalCardList_u24generateCardBasic_u246_u24lambda_u247);
        String cardName = data.getCardName();
        int cardScarcity = data.getCardScarcity();
        String str2 = RoomRecommendViewModel.EMPTY_CURSOR;
        if (cardScarcity == 30 || data.getCardScarcity() == 40) {
            str = "https://i1.hdslb.com/bfs/static/jinkela/mall-digital-card/assets/card-frame.05fad8e6.png";
        } else {
            str = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        String badgeUrl = data.getBadgeUrl();
        boolean z2 = false;
        boolean z3 = data.getSmeltInfo() == null || $vMid != ShopPreviewPageDataModuleKt.getMid();
        if (data.getHighlighted() && data.getSmeltInfo() != null && $vMid == ShopPreviewPageDataModuleKt.getMid()) {
            z2 = true;
        }
        DescTag descTag = data.getDescTag();
        String holdingRate = data.getHoldingRate();
        if (holdingRate == null) {
            holdingRate = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        String holdingRateUrl = data.getHoldingRateUrl();
        if (holdingRateUrl != null) {
            str2 = holdingRateUrl;
        }
        CardBasic.Rarity rarity2 = new CardBasic.Rarity(holdingRate, UrisKt.toUri(str2).buildUpon().build().toString());
        TopText topText = data.getTopText();
        Iterable actions = data.getActions();
        if (actions != null) {
            Iterable $this$map$iv = actions;
            rarity = rarity2;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ActionItem it = (ActionItem) item$iv$iv;
                destination$iv$iv.add(provideDigitalCardList$generateButton(it));
                $this$map$iv = $this$map$iv;
            }
            emptyList = (List) destination$iv$iv;
        } else {
            rarity = rarity2;
            emptyList = CollectionsKt.emptyList();
        }
        List list = emptyList;
        List createListBuilder = CollectionsKt.createListBuilder();
        List $this$provideDigitalCardList_u24generateCardBasic_u246_u24lambda_u249 = createListBuilder;
        $this$provideDigitalCardList_u24generateCardBasic_u246_u24lambda_u249.add(new Action(ClosingAction.INSTANCE, null, 2, null));
        Iterable modules = data.getModules();
        if (modules != null) {
            Iterable $this$mapTo$iv = modules;
            List destination$iv = $this$provideDigitalCardList_u24generateCardBasic_u246_u24lambda_u249;
            for (Iterator it2 = $this$mapTo$iv.iterator(); it2.hasNext(); it2 = it2) {
                Object item$iv = it2.next();
                List $this$provideDigitalCardList_u24generateCardBasic_u246_u24lambda_u2492 = $this$provideDigitalCardList_u24generateCardBasic_u246_u24lambda_u249;
                ModuleItem it3 = (ModuleItem) item$iv;
                destination$iv.add(provideDigitalCardList$generateTopBar($vMid, map, it3));
                $this$provideDigitalCardList_u24generateCardBasic_u246_u24lambda_u249 = $this$provideDigitalCardList_u24generateCardBasic_u246_u24lambda_u2492;
            }
        }
        return new CardBasic(uniqueId, isAnchorItem, cardName, str, cardImage, badgeUrl, z3, z2, z, rarity, list, cardIdInfo, build, topText, descTag, CollectionsKt.build(createListBuilder), data.getCardLockStatus());
    }

    @Provides
    @BusinessScope
    public final List<CardItem<?>> provideDigitalCardList(@VMid long vMid, @FromParams Map<String, String> map, CardPreviewModel originModel) {
        Iterable $this$map$iv;
        CardItem cardItem;
        Play play;
        boolean z;
        String subtitlesUrl;
        String link;
        boolean z2;
        Intrinsics.checkNotNullParameter(map, "fromParams");
        Intrinsics.checkNotNullParameter(originModel, "originModel");
        Iterable $this$map$iv2 = originModel.getResult();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv : $this$map$iv2) {
            ResultItem it = (ResultItem) item$iv$iv;
            if (it instanceof CardData) {
                CardData.Data cardData = ((CardData) it).getData();
                if (cardData.getSmeltInfo() == null || !cardData.getSmeltInfo().getHasSmeltedParams()) {
                    $this$map$iv = $this$map$iv2;
                    if (cardData.getCardType() == 1) {
                        cardItem = new CardItem(provideDigitalCardList$generateCardBasic$6(vMid, originModel, map, it, cardData), new ImageCard(cardData.getCardImage()));
                    } else {
                        String cardImage = cardData.getCardImage();
                        List<String> cardVideo = cardData.getCardVideo();
                        if (cardVideo == null) {
                            cardVideo = CollectionsKt.emptyList();
                        }
                        List<String> list = cardVideo;
                        Play play2 = cardData.getPlay();
                        long duration = play2 != null ? play2.getDuration() : 0L;
                        long trialDuration = cardData.getPlay() != null ? play.getTrialDuration() : 0L;
                        Play play3 = cardData.getPlay();
                        boolean z3 = (play3 != null ? play3.getTrialDuration() : 0) > 0;
                        Play play4 = cardData.getPlay();
                        String str = (play4 == null || (link = play4.getLink()) == null) ? RoomRecommendViewModel.EMPTY_CURSOR : link;
                        Play play5 = cardData.getPlay();
                        boolean z4 = (play5 != null && play5.getShowSubtitles()) && cardData.getPlay().getTrialDuration() <= 0;
                        Play play6 = cardData.getPlay();
                        String str2 = (play6 == null || (subtitlesUrl = play6.getSubtitlesUrl()) == null) ? RoomRecommendViewModel.EMPTY_CURSOR : subtitlesUrl;
                        Play play7 = cardData.getPlay();
                        boolean z5 = play7 != null && play7.getShowProgressBar();
                        if (!cardData.getSilence()) {
                            Play play8 = cardData.getPlay();
                            if (!(play8 != null && play8.getShowProgressBar())) {
                                z = true;
                                cardItem = new CardItem(provideDigitalCardList$generateCardBasic$6(vMid, originModel, map, it, cardData), new VideoCard(cardImage, list, duration, trialDuration, z3, str, z4, str2, z5, z, !cardData.getSilence()));
                            }
                        }
                        z = false;
                        cardItem = new CardItem(provideDigitalCardList$generateCardBasic$6(vMid, originModel, map, it, cardData), new VideoCard(cardImage, list, duration, trialDuration, z3, str, z4, str2, z5, z, !cardData.getSilence()));
                    }
                } else {
                    String cardImage2 = cardData.getCardImage();
                    String renderUrl = cardData.getSmeltInfo().getRenderUrl();
                    if (cardData.getCardType() != 1 && !cardData.getSilence()) {
                        Play play9 = cardData.getPlay();
                        if (!(play9 != null && play9.getShowProgressBar())) {
                            z2 = true;
                            $this$map$iv = $this$map$iv2;
                            cardItem = new CardItem(provideDigitalCardList$generateCardBasic$6(vMid, originModel, map, it, cardData), new WebCard(cardImage2, renderUrl, z2, cardData.getCardType() == 1 && !cardData.getSilence()));
                        }
                    }
                    z2 = false;
                    $this$map$iv = $this$map$iv2;
                    cardItem = new CardItem(provideDigitalCardList$generateCardBasic$6(vMid, originModel, map, it, cardData), new WebCard(cardImage2, renderUrl, z2, cardData.getCardType() == 1 && !cardData.getSilence()));
                }
            } else {
                $this$map$iv = $this$map$iv2;
                if (!(it instanceof CollectionRewardData)) {
                    throw new NoWhenBranchMatchedException();
                }
                CollectionRewardData.Data collectionRewardData = ((CollectionRewardData) it).getData();
                List<String> redeemItemVideo = collectionRewardData.getRedeemItemVideo();
                if (redeemItemVideo == null || redeemItemVideo.isEmpty()) {
                    cardItem = new CardItem(provideDigitalCardList$generateCardBasic(originModel, vMid, map, it, collectionRewardData), new ImageCard(collectionRewardData.getRedeemItemImage()));
                } else {
                    cardItem = new CardItem(provideDigitalCardList$generateCardBasic(originModel, vMid, map, it, collectionRewardData), new VideoCard(collectionRewardData.getRedeemItemImage(), collectionRewardData.getRedeemItemVideo(), 0L, 0L, false, RoomRecommendViewModel.EMPTY_CURSOR, false, RoomRecommendViewModel.EMPTY_CURSOR, false, false, true));
                }
            }
            destination$iv$iv.add(cardItem);
            $this$map$iv2 = $this$map$iv;
        }
        return (List) destination$iv$iv;
    }

    @Provides
    @BusinessScope
    @DigitalCardListUIService.InitialPage
    public final int provideInitialPage(List<CardItem<?>> list) {
        Intrinsics.checkNotNullParameter(list, "cardList");
        int index$iv = 0;
        Iterator<CardItem<?>> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                CardItem item$iv = it.next();
                if (item$iv.getBasic().isSelected()) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int it2 = index$iv;
        if (it2 == -1) {
            return 0;
        }
        return it2;
    }

    @Provides
    @BusinessScope
    @InitialRequestExtraParams
    public final String provideInitialRequestExtraParams(CardPreviewModel originModel) {
        Intrinsics.checkNotNullParameter(originModel, "originModel");
        return originModel.extraJsonString();
    }

    @Provides
    @BusinessScope
    @InitialFrontAnchorId
    public final String provideInitialFrontAnchorId(CardPreviewModel originModel) {
        Intrinsics.checkNotNullParameter(originModel, "originModel");
        return originModel.getFrontAnchorId();
    }

    @Provides
    @BusinessScope
    @InitialBackAnchorId
    public final String provideInitialBackAnchorId(CardPreviewModel originModel) {
        Intrinsics.checkNotNullParameter(originModel, "originModel");
        return originModel.getBackAnchorId();
    }

    @Provides
    @BusinessScope
    @InitialFrontHasMore
    public final boolean provideInitialFrontHasMore(CardPreviewModel originModel) {
        Intrinsics.checkNotNullParameter(originModel, "originModel");
        return originModel.getFrontHasMore();
    }

    @Provides
    @BusinessScope
    @InitialBackHasMore
    public final boolean provideInitialBackHasMore(CardPreviewModel originModel) {
        Intrinsics.checkNotNullParameter(originModel, "originModel");
        return originModel.getBackHasMore();
    }
}