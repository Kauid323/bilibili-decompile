package tv.danmaku.bili.ui.garb;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.digital.DigitalWebContainer;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailContainerRenderData;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRenderData;
import tv.danmaku.bili.ui.garb.digital.base.data.DigitalCardDetailRouterInfo;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalFromType;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardRewardModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCDetailModel;
import tv.danmaku.bili.ui.garb.nft.model.DigitalCardDetailIdModel;
import tv.danmaku.bili.ui.garb.nft.model.DigitalCardDetailModel;

/* compiled from: DigitalFragment.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u00142\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010-\u001a\u00020+H\u0002J\"\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00104\u001a\u0004\u0018\u00010\u001c2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0012H\u0002J\u0014\u00108\u001a\u0004\u0018\u00010\u00162\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u00109\u001a\b\u0012\u0004\u0012\u00020;0:*\b\u0012\u0004\u0012\u00020<0:H\u0002J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0018H\u0002J\b\u0010@\u001a\u00020+H\u0002R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006A"}, d2 = {"Ltv/danmaku/bili/ui/garb/DigitalFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "digitalJsHandler", "Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;", "result", "", "method", "<init>", "(Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;Ljava/lang/String;Ljava/lang/String;)V", "()V", "getDigitalJsHandler", "()Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;", "setDigitalJsHandler", "(Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;)V", "getResult", "()Ljava/lang/String;", "getMethod", "isHalfScreen", "", "rootView", "Landroid/view/ViewGroup;", "drawModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawModel;", "rewardModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardRewardModel;", "detailModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCDetailModel;", "digitalCardRouterInfo", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRouterInfo;", "digitalWebContainer", "Ltv/danmaku/bili/ui/garb/digital/DigitalWebContainer;", "getDigitalWebContainer", "()Ltv/danmaku/bili/ui/garb/digital/DigitalWebContainer;", "digitalWebContainer$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initArgs", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "buildDigitalRouterInfo", "mid", "", "isMe", "parseDrawCardData", "formatCardRenderDataList", "", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;", "Ltv/danmaku/bili/ui/garb/nft/model/DigitalCardDetailModel;", "getRewardContainerRenderData", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;", "rm", "initViews", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalFragment extends BaseFragment {
    public static final int $stable = 8;
    private DLCDetailModel detailModel;
    private DigitalCardDetailRouterInfo digitalCardRouterInfo;
    private DigitalJsCallHandler digitalJsHandler;
    private final Lazy digitalWebContainer$delegate;
    private DLCCardDrawModel drawModel;
    private boolean isHalfScreen;
    private final String method;
    private final String result;
    private DLCCardRewardModel rewardModel;
    private ViewGroup rootView;

    public DigitalFragment(DigitalJsCallHandler digitalJsHandler, String result, String method) {
        this.digitalJsHandler = digitalJsHandler;
        this.result = result;
        this.method = method;
        this.digitalWebContainer$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.DigitalFragment$$ExternalSyntheticLambda0
            public final Object invoke() {
                DigitalWebContainer digitalWebContainer_delegate$lambda$0;
                digitalWebContainer_delegate$lambda$0 = DigitalFragment.digitalWebContainer_delegate$lambda$0(DigitalFragment.this);
                return digitalWebContainer_delegate$lambda$0;
            }
        });
    }

    public /* synthetic */ DigitalFragment(DigitalJsCallHandler digitalJsCallHandler, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : digitalJsCallHandler, str, str2);
    }

    public final DigitalJsCallHandler getDigitalJsHandler() {
        return this.digitalJsHandler;
    }

    public final void setDigitalJsHandler(DigitalJsCallHandler digitalJsCallHandler) {
        this.digitalJsHandler = digitalJsCallHandler;
    }

    public final String getResult() {
        return this.result;
    }

    public final String getMethod() {
        return this.method;
    }

    public DigitalFragment() {
        this(null, null, null);
    }

    private final DigitalWebContainer getDigitalWebContainer() {
        return (DigitalWebContainer) this.digitalWebContainer$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DigitalWebContainer digitalWebContainer_delegate$lambda$0(DigitalFragment this$0) {
        DigitalWebContainer $this$digitalWebContainer_delegate_u24lambda_u240_u240 = new DigitalWebContainer((Fragment) this$0, this$0.digitalJsHandler);
        $this$digitalWebContainer_delegate_u24lambda_u240_u240.setMDigitalJsHandler(this$0.digitalJsHandler);
        return $this$digitalWebContainer_delegate_u24lambda_u240_u240;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.bili_app_dialog_digital_detail_root, container, false);
        this.rootView = inflate instanceof ViewGroup ? (ViewGroup) inflate : null;
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            viewGroup.setClickable(true);
        }
        return this.rootView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initArgs();
        initViews();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [tv.danmaku.bili.ui.garb.DigitalFragment$initArgs$$inlined$parseJson$2] */
    /* JADX WARN: Type inference failed for: r3v7, types: [tv.danmaku.bili.ui.garb.DigitalFragment$initArgs$$inlined$parseJson$1] */
    private final void initArgs() {
        BLog.d("DigitalFragment_JSB", this.method + ":" + this.result);
        try {
            String str = this.method;
            if (str != null) {
                DLCCardRewardModel dLCCardRewardModel = null;
                DLCDetailModel dLCDetailModel = null;
                boolean z = false;
                switch (str.hashCode()) {
                    case -688037092:
                        if (str.equals(DigitalJsCallHandler.H5_TO_NA_SHOW_DLC_ITEM_DETAIL_FROM_REWARD)) {
                            String $this$parseJson$iv = this.result;
                            if ($this$parseJson$iv != null) {
                                Type type = new TypeToken<DLCCardRewardModel>() { // from class: tv.danmaku.bili.ui.garb.DigitalFragment$initArgs$$inlined$parseJson$2
                                }.getType();
                                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                                dLCCardRewardModel = (DLCCardRewardModel) JsonUtilKt.parseJson($this$parseJson$iv, type);
                            }
                            this.rewardModel = dLCCardRewardModel;
                            DLCCardRewardModel dLCCardRewardModel2 = this.rewardModel;
                            if (dLCCardRewardModel2 != null && dLCCardRewardModel2.getScreenType() == 1) {
                                z = true;
                            }
                            this.isHalfScreen = z;
                            this.digitalCardRouterInfo = buildDigitalRouterInfo(BiliAccounts.get(getActivity()).mid(), true);
                            return;
                        }
                        return;
                    case 462936938:
                        if (str.equals(DigitalJsCallHandler.H5_TO_NA_SHOW_DLC_ITEM_DETAIL)) {
                            String $this$parseJson$iv2 = this.result;
                            if ($this$parseJson$iv2 != null) {
                                Type type2 = new TypeToken<DLCDetailModel>() { // from class: tv.danmaku.bili.ui.garb.DigitalFragment$initArgs$$inlined$parseJson$1
                                }.getType();
                                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                                dLCDetailModel = (DLCDetailModel) JsonUtilKt.parseJson($this$parseJson$iv2, type2);
                            }
                            this.detailModel = dLCDetailModel;
                            DLCDetailModel dLCDetailModel2 = this.detailModel;
                            this.isHalfScreen = dLCDetailModel2 != null && dLCDetailModel2.getScreenType() == 1;
                            DLCDetailModel dLCDetailModel3 = this.detailModel;
                            long mid = dLCDetailModel3 != null ? dLCDetailModel3.getMid() : BiliAccounts.get(getActivity()).mid();
                            DLCDetailModel dLCDetailModel4 = this.detailModel;
                            if (dLCDetailModel4 != null && dLCDetailModel4.getMid() == BiliAccounts.get(getActivity()).mid()) {
                                z = true;
                            }
                            this.digitalCardRouterInfo = buildDigitalRouterInfo(mid, z);
                            return;
                        }
                        return;
                    case 1581021766:
                        if (str.equals(DigitalJsCallHandler.H5_TO_NA_DRAW_DLC_ITEM)) {
                            this.drawModel = parseDrawCardData(this.result);
                            DLCCardDrawModel dLCCardDrawModel = this.drawModel;
                            if (dLCCardDrawModel != null && dLCCardDrawModel.getScreenType() == 1) {
                                z = true;
                            }
                            this.isHalfScreen = z;
                            this.digitalCardRouterInfo = buildDigitalRouterInfo(BiliAccounts.get(getActivity()).mid(), true);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable t) {
            BLog.e("dlc act parse error:" + t);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getDigitalWebContainer().onActivityResult(requestCode, resultCode, data);
    }

    private final DigitalCardDetailRouterInfo buildDigitalRouterInfo(long mid, boolean isMe) {
        return new DigitalCardDetailRouterInfo(0, mid, 0L, null, null, null, false, isMe, false);
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [tv.danmaku.bili.ui.garb.DigitalFragment$parseDrawCardData$$inlined$parseJson$1] */
    /* JADX WARN: Type inference failed for: r5v2, types: [tv.danmaku.bili.ui.garb.DigitalFragment$parseDrawCardData$$inlined$parseJson$3] */
    /* JADX WARN: Type inference failed for: r5v4, types: [tv.danmaku.bili.ui.garb.DigitalFragment$parseDrawCardData$$inlined$parseJson$2] */
    private final DLCCardDrawModel parseDrawCardData(String data) {
        DLCCardDrawModel model;
        JSONObject drawUrls;
        HashMap<Integer, String> animEntryMap;
        HashMap<Integer, String> animDrawMap;
        String $this$parseJson$iv;
        String $this$parseJson$iv2;
        JSONObject jSONObject = null;
        if (data == null) {
            model = null;
        } else {
            Type type = new TypeToken<DLCCardDrawModel>() { // from class: tv.danmaku.bili.ui.garb.DigitalFragment$parseDrawCardData$$inlined$parseJson$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            model = (DLCCardDrawModel) JsonUtilKt.parseJson(data, type);
        }
        if (model == null || ($this$parseJson$iv2 = model.getAnimDrawUrl()) == null) {
            drawUrls = null;
        } else {
            Type type2 = new TypeToken<JSONObject>() { // from class: tv.danmaku.bili.ui.garb.DigitalFragment$parseDrawCardData$$inlined$parseJson$2
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            drawUrls = (JSONObject) JsonUtilKt.parseJson($this$parseJson$iv2, type2);
        }
        if (model != null && ($this$parseJson$iv = model.getAnimEntryUrl()) != null) {
            Type type3 = new TypeToken<JSONObject>() { // from class: tv.danmaku.bili.ui.garb.DigitalFragment$parseDrawCardData$$inlined$parseJson$3
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type3, "getType(...)");
            jSONObject = (JSONObject) JsonUtilKt.parseJson($this$parseJson$iv, type3);
        }
        JSONObject entryUrls = jSONObject;
        if (model != null) {
            model.setAnimDrawMap(new HashMap<>());
        }
        if (model != null) {
            model.setAnimEntryMap(new HashMap<>());
        }
        if (drawUrls != null) {
            Map $this$forEach$iv = (Map) drawUrls;
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                if (model != null && (animDrawMap = model.getAnimDrawMap()) != null) {
                    Object key = element$iv.getKey();
                    Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.String");
                    Integer valueOf = Integer.valueOf(Integer.parseInt((String) key));
                    Object value = element$iv.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                    animDrawMap.put(valueOf, (String) value);
                }
            }
        }
        if (entryUrls != null) {
            Map $this$forEach$iv2 = (Map) entryUrls;
            for (Map.Entry element$iv2 : $this$forEach$iv2.entrySet()) {
                if (model != null && (animEntryMap = model.getAnimEntryMap()) != null) {
                    Object key2 = element$iv2.getKey();
                    Intrinsics.checkNotNull(key2, "null cannot be cast to non-null type kotlin.String");
                    Integer valueOf2 = Integer.valueOf(Integer.parseInt((String) key2));
                    Object value2 = element$iv2.getValue();
                    Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.String");
                    animEntryMap.put(valueOf2, (String) value2);
                }
            }
        }
        return model;
    }

    private final List<DigitalCardDetailRenderData> formatCardRenderDataList(List<DigitalCardDetailModel> list) {
        ArrayList newList = new ArrayList();
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<DigitalCardDetailModel> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            DigitalCardDetailModel cardDetail = (DigitalCardDetailModel) element$iv;
            if (!cardDetail.getCardIdList().isEmpty()) {
                Iterable $this$forEach$iv2 = cardDetail.getCardIdList();
                for (Object element$iv2 : $this$forEach$iv2) {
                    DigitalCardDetailIdModel card = (DigitalCardDetailIdModel) element$iv2;
                    newList.add(new DigitalCardDetailRenderData(cardDetail, card));
                }
            } else {
                newList.add(new DigitalCardDetailRenderData(cardDetail, (DigitalCardDetailIdModel) null));
            }
        }
        return newList;
    }

    private final DigitalCardDetailContainerRenderData getRewardContainerRenderData(DLCCardRewardModel rm) {
        switch (rm.getRedeemItemType()) {
            case 1:
            case 2:
            case 3:
            case 4:
                if (rm.getGained() == 1 && rm.getRedeemItemType() == 1) {
                    return new DigitalCardDetailContainerRenderData(rm);
                }
                return new DigitalCardDetailContainerRenderData(Integer.valueOf(Integer.parseInt(rm.getActivityId())), null, false, rm.getHorizontalCardLightUrl(), rm.getHorizontalCardShadowUrl(), rm.getVerticalCardLightUrl(), rm.getVerticalCardShadowUrl(), rm.getSpaceBgSetUrl(), null, null, null, null, null, rm.getGarbSuitUrl(), rm.getGarbApplyUrl(), null, null, Integer.valueOf(rm.getShareType()), null, null, null, 0, Boolean.valueOf(rm.getHasCardAnimation() != 0), false, Integer.valueOf(rm.getPageType()), rm.getRedeemItemId(), new DigitalCardDetailRenderData(rm), rm.getCollectProgressButton(), 8388610, null);
            default:
                return new DigitalCardDetailContainerRenderData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 268435455, null);
        }
    }

    private final void initViews() {
        DLCCardRewardModel rewardModel;
        List cardRenderDataList;
        List<DigitalCardDetailModel> cardList;
        ViewGroup root = this.rootView;
        if (root != null) {
            View view = getDigitalWebContainer().getView(this.isHalfScreen, root);
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            if (viewGroup == null) {
                return;
            }
            ViewGroup realContainer = viewGroup;
            String str = this.method;
            if (str != null) {
                boolean z = false;
                switch (str.hashCode()) {
                    case -688037092:
                        if (str.equals(DigitalJsCallHandler.H5_TO_NA_SHOW_DLC_ITEM_DETAIL_FROM_REWARD) && (rewardModel = this.rewardModel) != null) {
                            getDigitalWebContainer().initViews(realContainer);
                            getDigitalWebContainer().initData(root, DigitalFromType.TASK, getRewardContainerRenderData(rewardModel), this.digitalCardRouterInfo, null, 0, !this.isHalfScreen, false, rewardModel.getRedeemItemType());
                            return;
                        }
                        return;
                    case 462936938:
                        if (str.equals(DigitalJsCallHandler.H5_TO_NA_SHOW_DLC_ITEM_DETAIL)) {
                            DLCDetailModel dLCDetailModel = this.detailModel;
                            if (dLCDetailModel == null || (cardList = dLCDetailModel.getCardList()) == null || (cardRenderDataList = formatCardRenderDataList(cardList)) == null) {
                                cardRenderDataList = CollectionsKt.emptyList();
                            }
                            if (cardRenderDataList.isEmpty()) {
                                return;
                            }
                            DigitalFromType.Companion companion = DigitalFromType.Companion;
                            DLCDetailModel dLCDetailModel2 = this.detailModel;
                            DigitalFromType fromType = companion.toType(dLCDetailModel2 != null ? dLCDetailModel2.getType() : 0);
                            DLCDetailModel dLCDetailModel3 = this.detailModel;
                            int initDisplayIndex = dLCDetailModel3 != null ? dLCDetailModel3.getJumpId() : 0;
                            if (initDisplayIndex >= 0 && initDisplayIndex < cardRenderDataList.size()) {
                                z = true;
                            }
                            DigitalCardDetailRenderData initDisplayCard = z ? cardRenderDataList.get(initDisplayIndex) : (DigitalCardDetailRenderData) CollectionsKt.first(cardRenderDataList);
                            getDigitalWebContainer().initViews(realContainer);
                            getDigitalWebContainer().initData(root, fromType, new DigitalCardDetailContainerRenderData(this.detailModel, initDisplayCard), this.digitalCardRouterInfo, cardRenderDataList, initDisplayIndex, !this.isHalfScreen, false, 1);
                            return;
                        }
                        return;
                    case 1581021766:
                        if (str.equals(DigitalJsCallHandler.H5_TO_NA_DRAW_DLC_ITEM)) {
                            getDigitalWebContainer().initViews(realContainer);
                            DigitalWebContainer digitalWebContainer = getDigitalWebContainer();
                            DigitalFromType digitalFromType = DigitalFromType.DRAW;
                            DLCCardDrawModel dLCCardDrawModel = this.drawModel;
                            int actId = dLCCardDrawModel != null ? (int) dLCCardDrawModel.getActId() : 0;
                            DLCCardDrawModel dLCCardDrawModel2 = this.drawModel;
                            Integer valueOf = dLCCardDrawModel2 != null ? Integer.valueOf(dLCCardDrawModel2.getShareType()) : null;
                            DLCCardDrawModel dLCCardDrawModel3 = this.drawModel;
                            String fromWhere = dLCCardDrawModel3 != null ? dLCCardDrawModel3.getFromWhere() : null;
                            DLCCardDrawModel dLCCardDrawModel4 = this.drawModel;
                            String fromId = dLCCardDrawModel4 != null ? dLCCardDrawModel4.getFromId() : null;
                            DLCCardDrawModel dLCCardDrawModel5 = this.drawModel;
                            String fSource = dLCCardDrawModel5 != null ? dLCCardDrawModel5.getFSource() : null;
                            DLCCardDrawModel dLCCardDrawModel6 = this.drawModel;
                            String horizontalCardLightUrl = dLCCardDrawModel6 != null ? dLCCardDrawModel6.getHorizontalCardLightUrl() : null;
                            DLCCardDrawModel dLCCardDrawModel7 = this.drawModel;
                            String horizontalCardShadowUrl = dLCCardDrawModel7 != null ? dLCCardDrawModel7.getHorizontalCardShadowUrl() : null;
                            DLCCardDrawModel dLCCardDrawModel8 = this.drawModel;
                            String verticalCardLightUrl = dLCCardDrawModel8 != null ? dLCCardDrawModel8.getVerticalCardLightUrl() : null;
                            DLCCardDrawModel dLCCardDrawModel9 = this.drawModel;
                            String verticalCardShadowUrl = dLCCardDrawModel9 != null ? dLCCardDrawModel9.getVerticalCardShadowUrl() : null;
                            DLCCardDrawModel dLCCardDrawModel10 = this.drawModel;
                            String holderListUrl = dLCCardDrawModel10 != null ? dLCCardDrawModel10.getHolderListUrl() : null;
                            DLCCardDrawModel dLCCardDrawModel11 = this.drawModel;
                            Integer valueOf2 = dLCCardDrawModel11 != null ? Integer.valueOf(dLCCardDrawModel11.getCanDonate()) : null;
                            DLCCardDrawModel dLCCardDrawModel12 = this.drawModel;
                            if (dLCCardDrawModel12 != null && dLCCardDrawModel12.getHasCardAnimation() == 0) {
                                z = true;
                            }
                            boolean z2 = !z;
                            DLCCardDrawModel dLCCardDrawModel13 = this.drawModel;
                            digitalWebContainer.initData(root, digitalFromType, new DigitalCardDetailContainerRenderData(Integer.valueOf(actId), null, null, horizontalCardLightUrl, horizontalCardShadowUrl, verticalCardLightUrl, verticalCardShadowUrl, null, null, null, null, null, null, null, null, holderListUrl, null, valueOf, fromWhere, fromId, fSource, valueOf2, Boolean.valueOf(z2), false, dLCCardDrawModel13 != null ? Integer.valueOf(dLCCardDrawModel13.getPageType()) : null, null, null, null, 243367814, null), this.digitalCardRouterInfo, null, 0, !this.isHalfScreen, true, -2);
                            getDigitalWebContainer().initDrawCardData(getDigitalWebContainer().getMultiViewContainer(), getDigitalWebContainer().getBottomFloatContainer(), getDigitalWebContainer().getDrawCardContainer(), this.drawModel, (Fragment) this);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}