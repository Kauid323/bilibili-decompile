package tv.danmaku.bili.ui.garb;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.MainThread;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.bson.dsl.JsonObjectBuilder;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import com.bilibili.digital.PageInfo;
import com.bilibili.digital.card.DigitalPageFragment;
import com.bilibili.digital.card.action.share.DigitalShareInfo;
import com.bilibili.lib.gson.GsonKt;
import com.bilibili.ogv.infra.app.ConfigsKt;
import com.bililive.bililive.infra.hybrid.ui.WebViewActivity;
import com.bililive.bililive.infra.hybrid.ui.fragment.comm.CommonWebFragment;
import com.google.gson.JsonObject;
import comm.bili.digital.bridge.IDigitalJsMethodInvoker;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardShareModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCPurchaseModel;
import tv.danmaku.bili.ui.garb.nft.util.DLCResDownloader;
import tv.danmaku.bili.ui.webview.MWebActivity;

/* compiled from: DigitalJsCallHandler.kt */
@Singleton
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0016J4\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u0000H\u0002J\u001a\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0019H\u0002J\u000e\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020'H\u0002J\u000e\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0019J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0006H\u0002J\u0006\u0010,\u001a\u00020\u0011J\u001a\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0013\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000600H\u0016¢\u0006\u0002\u00101J\u0006\u00102\u001a\u00020\u0011R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler;", "Lcomm/bili/digital/bridge/IDigitalJsMethodInvoker;", "<init>", "()V", "map", "", "", "Lkotlin/Pair;", "", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "supportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "digitalFragment", "Ltv/danmaku/bili/ui/garb/DigitalFragment;", "digitalPageFragment", "Lcom/bilibili/digital/card/DigitalPageFragment;", "invokeNative", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "handlerV2", "method", "data", "Lcom/alibaba/fastjson/JSONObject;", "callbackId", "goNativeContainer", "result", "digitalJsbHandler", NftCardJsBridgeCallHandler.PRELOAD_RESOURCE, "purchaseCardPkg", "purchaseModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCPurchaseModel;", "toPayFinished", "jsonObject", "toShareDLC", "shareModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardShareModel;", "Lcom/bilibili/digital/card/action/share/DigitalShareInfo;", "onCardInfoChange", "jsonObj", "onPageInfoChange", "scene", "toDismiss", "directCallBack", "handler", "getSupportFunctions", "", "()[Ljava/lang/String;", FavoritesConstsKt.CLEAR_INVALID_CLEAR, "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalJsCallHandler implements IDigitalJsMethodInvoker {
    public static final String H5_TO_NA_DRAW_DLC_ITEM = "cardPkgGacha";
    public static final String H5_TO_NA_PAY_FINISHED = "payFinished";
    public static final String H5_TO_NA_PRELOAD_DLC_RESOURCE = "preloadUAMResource";
    public static final String H5_TO_NA_SHOW_DLC_ITEM_DETAIL = "cardPkgShowDetail";
    public static final String H5_TO_NA_SHOW_DLC_ITEM_DETAIL_FROM_REWARD = "cardPkgRewardDetail";
    public static final String NA_TO_H5_CARD_INFO_CHANGE = "observeCardInfoChange";
    public static final String NA_TO_H5_CARD_PKG_PURCHASE = "observeCardPkgPurchase";
    public static final String NA_TO_H5_CARD_PKG_SHARE = "observeCardPkgShare";
    public static final String NA_TO_H5_DLC_DETAIL_VIEW_DISAPPEAR = "observeCardPkgDetailViewDisappear";
    public static final String NA_TO_H5_PAGE_INFO_CHANGE = "observePageInfoChange";
    public static final String NA_TO_H5_PAY_FINISHED = "observePayFinished";
    private DigitalFragment digitalFragment;
    private DigitalPageFragment digitalPageFragment;
    private final Map<String, Pair<Integer, JsBridgeCallHandlerV2>> map = new LinkedHashMap();
    private FragmentManager supportFragmentManager;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = Reflection.getOrCreateKotlinClass(DigitalJsCallHandler.class).getSimpleName();

    public void invokeNative(final Activity activity, final Fragment fragment, final JsBridgeCallHandlerV2 handlerV2, final String method, final JSONObject data, String callbackId) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(handlerV2, "handlerV2");
        Intrinsics.checkNotNullParameter(method, "method");
        MainThread.runOnMainThread(new Function0() { // from class: tv.danmaku.bili.ui.garb.DigitalJsCallHandler$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit invokeNative$lambda$0;
                invokeNative$lambda$0 = DigitalJsCallHandler.invokeNative$lambda$0(method, data, this, activity, fragment, handlerV2);
                return invokeNative$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeNative$lambda$0(String $method, JSONObject $data, DigitalJsCallHandler this$0, Activity $activity, Fragment $fragment, JsBridgeCallHandlerV2 $handlerV2) {
        String result;
        String result2;
        String result3;
        try {
            switch ($method.hashCode()) {
                case -1544704710:
                    if ($method.equals(H5_TO_NA_PAY_FINISHED)) {
                        if ($data != null) {
                            this$0.toPayFinished($data);
                            break;
                        } else {
                            return Unit.INSTANCE;
                        }
                    }
                    break;
                case -1458312854:
                    if (!$method.equals(NA_TO_H5_CARD_INFO_CHANGE)) {
                        break;
                    } else if ($data != null) {
                        int cardInfoChangeCallback = $data.getIntValue("onChangeCallbackId");
                        this$0.map.put(NA_TO_H5_CARD_INFO_CHANGE, new Pair<>(Integer.valueOf(cardInfoChangeCallback), $handlerV2));
                        break;
                    } else {
                        return Unit.INSTANCE;
                    }
                case -688037092:
                    if (!$method.equals(H5_TO_NA_SHOW_DLC_ITEM_DETAIL_FROM_REWARD)) {
                        break;
                    } else {
                        if ($data != null && (result = $data.toJSONString()) != null) {
                            this$0.goNativeContainer(result, H5_TO_NA_SHOW_DLC_ITEM_DETAIL_FROM_REWARD, $activity, $fragment, this$0);
                            break;
                        }
                        return Unit.INSTANCE;
                    }
                    break;
                case -26613331:
                    if (!$method.equals(NA_TO_H5_DLC_DETAIL_VIEW_DISAPPEAR)) {
                        break;
                    } else if ($data != null) {
                        int dismissCallback = $data.getIntValue("onCardPkgDetailViewDisappearCallbackId");
                        this$0.map.put(NA_TO_H5_DLC_DETAIL_VIEW_DISAPPEAR, new Pair<>(Integer.valueOf(dismissCallback), $handlerV2));
                        this$0.directCallBack($handlerV2, $data);
                        break;
                    } else {
                        return Unit.INSTANCE;
                    }
                case 351223041:
                    if (!$method.equals(NA_TO_H5_CARD_PKG_PURCHASE)) {
                        break;
                    } else if ($data != null) {
                        int purchaseCallback = $data.getIntValue("onPurchaseCallbackId");
                        this$0.map.put(NA_TO_H5_CARD_PKG_PURCHASE, new Pair<>(Integer.valueOf(purchaseCallback), $handlerV2));
                        this$0.directCallBack($handlerV2, $data);
                        break;
                    } else {
                        return Unit.INSTANCE;
                    }
                case 462936938:
                    if (!$method.equals(H5_TO_NA_SHOW_DLC_ITEM_DETAIL)) {
                        break;
                    } else {
                        if ($data != null && (result2 = $data.toJSONString()) != null) {
                            this$0.goNativeContainer(result2, H5_TO_NA_SHOW_DLC_ITEM_DETAIL, $activity, $fragment, this$0);
                            break;
                        }
                        return Unit.INSTANCE;
                    }
                case 561660102:
                    if (!$method.equals(H5_TO_NA_PRELOAD_DLC_RESOURCE)) {
                        break;
                    } else {
                        this$0.preloadResource($activity, $data);
                        break;
                    }
                case 1240078303:
                    if (!$method.equals(NA_TO_H5_CARD_PKG_SHARE)) {
                        break;
                    } else if ($data != null) {
                        int shareCallback = $data.getIntValue("onShareCallbackId");
                        this$0.map.put(NA_TO_H5_CARD_PKG_SHARE, new Pair<>(Integer.valueOf(shareCallback), $handlerV2));
                        this$0.directCallBack($handlerV2, $data);
                        break;
                    } else {
                        return Unit.INSTANCE;
                    }
                case 1581021766:
                    if (!$method.equals(H5_TO_NA_DRAW_DLC_ITEM)) {
                        break;
                    } else {
                        if ($data != null && (result3 = $data.toJSONString()) != null) {
                            this$0.goNativeContainer(result3, H5_TO_NA_DRAW_DLC_ITEM, $activity, $fragment, this$0);
                            break;
                        }
                        return Unit.INSTANCE;
                    }
                    break;
                case 1637465641:
                    if (!$method.equals(NA_TO_H5_PAGE_INFO_CHANGE)) {
                        break;
                    } else if ($data != null) {
                        int pageInfoChangeCallback = $data.getIntValue("onChangeCallbackId");
                        this$0.map.put(NA_TO_H5_PAGE_INFO_CHANGE, new Pair<>(Integer.valueOf(pageInfoChangeCallback), $handlerV2));
                        break;
                    } else {
                        return Unit.INSTANCE;
                    }
                case 2046163582:
                    if (!$method.equals(NA_TO_H5_PAY_FINISHED)) {
                        break;
                    } else if ($data != null) {
                        int payFinishedCallback = $data.getIntValue("onPayFinishedCallbackId");
                        this$0.map.put(NA_TO_H5_PAY_FINISHED, new Pair<>(Integer.valueOf(payFinishedCallback), $handlerV2));
                        this$0.directCallBack($handlerV2, $data);
                        break;
                    } else {
                        return Unit.INSTANCE;
                    }
            }
        } catch (Throwable e) {
            BLog.e(TAG, "invoke jsb error " + e);
        }
        return Unit.INSTANCE;
    }

    private final void goNativeContainer(String result, String method, Activity activity, Fragment fragment, DigitalJsCallHandler digitalJsbHandler) {
        Integer rootId;
        View webContainer;
        FragmentManager fragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction replace;
        FragmentTransaction beginTransaction2;
        FragmentTransaction replace2;
        CommonWebFragment commonWebFragment = fragment instanceof CommonWebFragment ? (CommonWebFragment) fragment : null;
        if (commonWebFragment == null || (rootId = commonWebFragment.getRootId()) == null) {
            WebViewActivity webViewActivity = activity instanceof WebViewActivity ? (WebViewActivity) activity : null;
            rootId = webViewActivity != null ? webViewActivity.getNativeViewId() : null;
            if (rootId == null) {
                MWebActivity mWebActivity = activity instanceof MWebActivity ? (MWebActivity) activity : null;
                rootId = (mWebActivity == null || (webContainer = mWebActivity.getWebContainer()) == null) ? null : Integer.valueOf(webContainer.getId());
            }
        }
        if (rootId != null) {
            int id = rootId.intValue();
            org.json.JSONObject resultJson = new org.json.JSONObject(result);
            boolean usingNewDigitalPage = ConfigsKt.abConfig("ff_use_new_digital_page", false);
            boolean enable = (resultJson.has("type") && (Intrinsics.areEqual(resultJson.get("type"), 3) || Intrinsics.areEqual(resultJson.get("type"), 0) || Intrinsics.areEqual(resultJson.get("type"), 2))) || Intrinsics.areEqual(method, H5_TO_NA_SHOW_DLC_ITEM_DETAIL_FROM_REWARD);
            if (!usingNewDigitalPage || !enable) {
                FragmentManager fragmentManager2 = null;
                this.digitalFragment = new DigitalFragment(digitalJsbHandler, result, method);
                Fragment fragment2 = this.digitalFragment;
                if (fragment2 != null) {
                    if (fragment != null) {
                        fragmentManager2 = fragment.getChildFragmentManager();
                    } else {
                        FragmentActivity findFragmentActivityOrNull = ContextUtilKt.findFragmentActivityOrNull(activity);
                        if (findFragmentActivityOrNull != null) {
                            fragmentManager2 = findFragmentActivityOrNull.getSupportFragmentManager();
                        }
                    }
                    this.supportFragmentManager = fragmentManager2;
                    if (!fragment2.isAdded() && (fragmentManager = this.supportFragmentManager) != null && (beginTransaction = fragmentManager.beginTransaction()) != null && (replace = beginTransaction.replace(id, fragment2)) != null) {
                        replace.commitAllowingStateLoss();
                        return;
                    }
                    return;
                }
                return;
            }
            Fragment digitalPageFragment = new DigitalPageFragment();
            digitalPageFragment.getPageJsonFlow().setValue(new PageInfo(result, method));
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) digitalPageFragment), (CoroutineContext) null, (CoroutineStart) null, new DigitalJsCallHandler$goNativeContainer$1$1$1(digitalPageFragment, digitalJsbHandler, null), 3, (Object) null);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) digitalPageFragment), (CoroutineContext) null, (CoroutineStart) null, new DigitalJsCallHandler$goNativeContainer$1$1$2(digitalPageFragment, digitalJsbHandler, null), 3, (Object) null);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) digitalPageFragment), (CoroutineContext) null, (CoroutineStart) null, new DigitalJsCallHandler$goNativeContainer$1$1$3(digitalPageFragment, digitalJsbHandler, null), 3, (Object) null);
            FragmentManager fragmentManager3 = null;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) digitalPageFragment), (CoroutineContext) null, (CoroutineStart) null, new DigitalJsCallHandler$goNativeContainer$1$1$4(digitalPageFragment, digitalJsbHandler, null), 3, (Object) null);
            if (fragment != null) {
                fragmentManager3 = fragment.getChildFragmentManager();
            } else {
                FragmentActivity findFragmentActivityOrNull2 = ContextUtilKt.findFragmentActivityOrNull(activity);
                if (findFragmentActivityOrNull2 != null) {
                    fragmentManager3 = findFragmentActivityOrNull2.getSupportFragmentManager();
                }
            }
            this.supportFragmentManager = fragmentManager3;
            FragmentManager fragmentManager4 = this.supportFragmentManager;
            if (fragmentManager4 != null && (beginTransaction2 = fragmentManager4.beginTransaction()) != null && (replace2 = beginTransaction2.replace(id, digitalPageFragment)) != null) {
                replace2.commitAllowingStateLoss();
            }
            this.digitalPageFragment = digitalPageFragment;
        }
    }

    private final void preloadResource(Activity activity, JSONObject data) {
        String resources;
        if (data == null || (resources = data.getString("resources")) == null) {
            return;
        }
        List urlList = JSONArray.parseArray(resources, String.class);
        Intrinsics.checkNotNull(urlList);
        DLCResDownloader.downloadRes$default(new DLCResDownloader(), activity, urlList, null, 4, null);
    }

    public final void purchaseCardPkg(DLCPurchaseModel purchaseModel) {
        Intrinsics.checkNotNullParameter(purchaseModel, "purchaseModel");
        Pair it = this.map.get(NA_TO_H5_CARD_PKG_PURCHASE);
        if (it != null) {
            ((JsBridgeCallHandlerV2) it.getSecond()).callbackToJs(new Object[]{it.getFirst(), JSON.toJSONString(purchaseModel)});
        }
        toDismiss();
    }

    private final void toPayFinished(JSONObject jsonObject) {
        Pair it = this.map.get(NA_TO_H5_PAY_FINISHED);
        if (it != null) {
            ((JsBridgeCallHandlerV2) it.getSecond()).callbackToJs(new Object[]{it.getFirst(), JSON.toJSONString(jsonObject)});
        }
    }

    public final void toShareDLC(DLCCardShareModel shareModel) {
        Intrinsics.checkNotNullParameter(shareModel, "shareModel");
        Pair it = this.map.get(NA_TO_H5_CARD_PKG_SHARE);
        if (it != null) {
            ((JsBridgeCallHandlerV2) it.getSecond()).callbackToJs(new Object[]{it.getFirst(), JSON.toJSONString(shareModel)});
        }
        toDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toShareDLC(DigitalShareInfo shareModel) {
        Pair it = this.map.get(NA_TO_H5_CARD_PKG_SHARE);
        if (it != null) {
            ((JsBridgeCallHandlerV2) it.getSecond()).callbackToJs(new Object[]{it.getFirst(), JSON.toJSONString(shareModel)});
        }
        toDismiss();
    }

    public final void onCardInfoChange(JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        Pair it = this.map.get(NA_TO_H5_CARD_INFO_CHANGE);
        if (it != null) {
            ((JsBridgeCallHandlerV2) it.getSecond()).callbackToJs(new Object[]{it.getFirst(), jsonObj});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPageInfoChange(String scene) {
        Pair it = this.map.get(NA_TO_H5_PAGE_INFO_CHANGE);
        if (it != null) {
            Object first = it.getFirst();
            JsonObject jsonObject$iv$iv = new JsonObject();
            JsonObject builder$iv$iv = JsonObjectBuilder.constructor-impl(jsonObject$iv$iv);
            JsonObjectBuilder.kv-impl(builder$iv$iv, "scene", scene);
            Unit unit = Unit.INSTANCE;
            ((JsBridgeCallHandlerV2) it.getSecond()).callbackToJs(new Object[]{first, GsonKt.toJsonString(builder$iv$iv)});
        }
    }

    public final void toDismiss() {
        FragmentManager fragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        FragmentManager fragmentManager2;
        FragmentTransaction beginTransaction2;
        FragmentTransaction remove2;
        Pair it = this.map.get(NA_TO_H5_DLC_DETAIL_VIEW_DISAPPEAR);
        if (it != null) {
            ((JsBridgeCallHandlerV2) it.getSecond()).callbackToJs(new Object[]{it.getFirst(), JSON.toJSONString("")});
        }
        Fragment fragment = this.digitalFragment;
        if (fragment != null && (fragmentManager2 = this.supportFragmentManager) != null && (beginTransaction2 = fragmentManager2.beginTransaction()) != null && (remove2 = beginTransaction2.remove(fragment)) != null) {
            remove2.commitAllowingStateLoss();
        }
        Fragment fragment2 = this.digitalPageFragment;
        if (fragment2 == null || (fragmentManager = this.supportFragmentManager) == null || (beginTransaction = fragmentManager.beginTransaction()) == null || (remove = beginTransaction.remove(fragment2)) == null) {
            return;
        }
        remove.commitAllowingStateLoss();
    }

    private final void directCallBack(JsBridgeCallHandlerV2 handler, JSONObject data) {
        if (data == null) {
            return;
        }
        try {
            int callbackId = data.getIntValue("callbackId");
            handler.callbackToJs(new Object[]{Integer.valueOf(callbackId), "ok"});
        } catch (Throwable th) {
            BLog.e(TAG, "invoke jsb error");
        }
    }

    public String[] getSupportFunctions() {
        return new String[]{H5_TO_NA_DRAW_DLC_ITEM, H5_TO_NA_SHOW_DLC_ITEM_DETAIL, H5_TO_NA_PRELOAD_DLC_RESOURCE, NA_TO_H5_CARD_PKG_PURCHASE, NA_TO_H5_CARD_PKG_SHARE, NA_TO_H5_CARD_INFO_CHANGE, NA_TO_H5_PAGE_INFO_CHANGE, NA_TO_H5_DLC_DETAIL_VIEW_DISAPPEAR, H5_TO_NA_SHOW_DLC_ITEM_DETAIL_FROM_REWARD, NA_TO_H5_PAY_FINISHED, H5_TO_NA_PAY_FINISHED};
    }

    public final void clear() {
        this.map.clear();
    }

    /* compiled from: DigitalJsCallHandler.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/garb/DigitalJsCallHandler$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "H5_TO_NA_DRAW_DLC_ITEM", "H5_TO_NA_PRELOAD_DLC_RESOURCE", "NA_TO_H5_CARD_PKG_PURCHASE", "NA_TO_H5_CARD_PKG_SHARE", "NA_TO_H5_CARD_INFO_CHANGE", "NA_TO_H5_DLC_DETAIL_VIEW_DISAPPEAR", "H5_TO_NA_SHOW_DLC_ITEM_DETAIL", "H5_TO_NA_SHOW_DLC_ITEM_DETAIL_FROM_REWARD", "NA_TO_H5_PAY_FINISHED", "H5_TO_NA_PAY_FINISHED", "NA_TO_H5_PAGE_INFO_CHANGE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return DigitalJsCallHandler.TAG;
        }
    }
}