package tv.danmaku.bili.ui.splash.brand.service;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.converter.IParser;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.ResponseBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashStorage;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingMoreData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSource;
import tv.danmaku.bili.ui.splash.utils.SplashUtils;
import tv.danmaku.bili.videopage.common.performance.PerformanceConstants;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashServiceHelper.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J:\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\b\u0010\u001f\u001a\u00020\u0012H\u0002J\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120!2\u0006\u0010\"\u001a\u00020#R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010$\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/service/BrandSplashServiceHelper;", "", "<init>", "()V", "api", "Ltv/danmaku/bili/ui/splash/brand/service/BrandSplashService;", "getApi", "()Ltv/danmaku/bili/ui/splash/brand/service/BrandSplashService;", "api$delegate", "Lkotlin/Lazy;", "fetchSettingData", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBrandSplashData", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplashData;", "fetchNextPage", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingMoreData;", "source", "", "lastSplashBizId", "", "groupNo", "type", "", ChronosDanmakuSender.KEY_MARK_DANMAKU, "(Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportBrandSelect", "", "brands", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "getNetwork", "getBrandListParams", "", "context", "Landroid/content/Context;", "NETWORK_WIFI", "NETWORK_MOBILE", "TAG", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashServiceHelper {
    private static final String NETWORK_MOBILE = "mobile";
    private static final String NETWORK_WIFI = "wifi";
    private static final String TAG = "[BrandSplash]BrandSplashServiceHelper";
    public static final BrandSplashServiceHelper INSTANCE = new BrandSplashServiceHelper();
    private static final Lazy api$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper$$ExternalSyntheticLambda1
        public final Object invoke() {
            BrandSplashService api_delegate$lambda$0;
            api_delegate$lambda$0 = BrandSplashServiceHelper.api_delegate$lambda$0();
            return api_delegate$lambda$0;
        }
    });
    public static final int $stable = 8;

    private BrandSplashServiceHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrandSplashService getApi() {
        return (BrandSplashService) api$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrandSplashService api_delegate$lambda$0() {
        return (BrandSplashService) ServiceGenerator.createService(BrandSplashService.class);
    }

    public final Object fetchSettingData(Continuation<? super BrandSplashSettingData> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BrandSplashServiceHelper$fetchSettingData$2(null), continuation);
    }

    public final BrandSplashData getBrandSplashData() {
        Application context = BiliContext.application();
        if (context == null) {
            return null;
        }
        Map map = getBrandListParams(context);
        String accessKey = BiliAccounts.get(context).getAccessKey();
        if (accessKey == null) {
            accessKey = "";
        }
        String accessKey2 = accessKey;
        try {
            BrandSplashService api = getApi();
            int versionCode = Foundation.Companion.instance().getApps().getVersionCode();
            String str = map.get(PerformanceConstants.EXTRA_KEY_NETWORK);
            String str2 = map.get("screen_width");
            int parseInt = str2 != null ? Integer.parseInt(str2) : 0;
            String str3 = map.get("screen_height");
            GeneralResponse generalResponse = (GeneralResponse) api.fetchBrandSplashList(accessKey2, "android", versionCode, "phone", str, parseInt, str3 != null ? Integer.parseInt(str3) : 0, map.get("selected")).setParser(new IParser() { // from class: tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper$$ExternalSyntheticLambda0
                public final Object convert(ResponseBody responseBody) {
                    Object brandSplashData$lambda$0;
                    brandSplashData$lambda$0 = BrandSplashServiceHelper.getBrandSplashData$lambda$0(responseBody);
                    return brandSplashData$lambda$0;
                }
            }).execute().body();
            if (generalResponse != null) {
                return (BrandSplashData) generalResponse.data;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getBrandSplashData$lambda$0(ResponseBody body) {
        JSONObject jsonObject = JSON.parseObject(body.string());
        Object fromJson = new Gson().fromJson(jsonObject.getString("data"), BrandSplashData.class);
        Intrinsics.checkNotNull(fromJson, "null cannot be cast to non-null type tv.danmaku.bili.ui.splash.brand.model.BrandSplashData");
        BrandSplashData brandData = (BrandSplashData) fromJson;
        GeneralResponse resp = new GeneralResponse();
        resp.data = brandData;
        return resp;
    }

    public final Object fetchNextPage(String source, long lastSplashBizId, String groupNo, int type, String keyword, Continuation<? super BrandSplashSettingMoreData> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BrandSplashServiceHelper$fetchNextPage$2(source, lastSplashBizId, groupNo, type, keyword, null), continuation);
    }

    public final void reportBrandSelect(List<BrandSplash> list) {
        Iterable brands = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(brands, "brands");
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        List ids = new ArrayList();
        List vipIds = new ArrayList();
        List dlcIds = new ArrayList();
        Iterable $this$forEach$iv = brands;
        for (Object element$iv : $this$forEach$iv) {
            BrandSplash it = (BrandSplash) element$iv;
            String source = it.getSource();
            if (Intrinsics.areEqual(source, BrandSplashSource.VIP.getValue())) {
                vipIds.add(Long.valueOf(it.getId()));
            } else if (Intrinsics.areEqual(source, BrandSplashSource.BRAND.getValue())) {
                ids.add(Long.valueOf(it.getId()));
            } else if (Intrinsics.areEqual(source, BrandSplashSource.DLC.getValue())) {
                dlcIds.add(Long.valueOf(it.getId()));
            }
        }
        BLog.i(TAG, "save brands: " + CollectionsKt.joinToString$default(ids, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        String accessKey = BiliAccounts.get(context).getAccessKey();
        if (accessKey == null) {
            accessKey = "";
        }
        String accessKey2 = accessKey;
        String idsStr = CollectionsKt.joinToString$default(ids, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        getApi().reportBrandSelect(accessKey2, getNetwork(), idsStr, CollectionsKt.joinToString$default(vipIds, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), CollectionsKt.joinToString$default(dlcIds, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), "phone").enqueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getNetwork() {
        return SplashUtils.isWifiConnected() ? "wifi" : "mobile";
    }

    public final Map<String, String> getBrandListParams(Context context) {
        String str;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        HashMap map = new HashMap();
        List selectedList = BrandSplashStorage.INSTANCE.readCustomBrands(true);
        if (selectedList.isEmpty()) {
            str = "";
        } else {
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : selectedList) {
                BrandSplash it = (BrandSplash) element$iv$iv;
                if (Intrinsics.areEqual(it.getSource(), BrandSplashSource.BRAND.getValue())) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            String brandList = CollectionsKt.joinToString$default((List) destination$iv$iv, ",", "[", "]", 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    CharSequence brandListParams$lambda$1;
                    brandListParams$lambda$1 = BrandSplashServiceHelper.getBrandListParams$lambda$1((BrandSplash) obj);
                    return brandListParams$lambda$1;
                }
            }, 24, (Object) null);
            List $this$filter$iv = selectedList;
            boolean z = false;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filter$iv) {
                BrandSplash it2 = (BrandSplash) element$iv$iv2;
                Iterable $this$filter$iv2 = $this$filter$iv;
                boolean z2 = z;
                if (Intrinsics.areEqual(it2.getSource(), BrandSplashSource.VIP.getValue())) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
                $this$filter$iv = $this$filter$iv2;
                z = z2;
            }
            String vipList = CollectionsKt.joinToString$default((List) destination$iv$iv2, ",", "[", "]", 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    CharSequence brandListParams$lambda$3;
                    brandListParams$lambda$3 = BrandSplashServiceHelper.getBrandListParams$lambda$3((BrandSplash) obj);
                    return brandListParams$lambda$3;
                }
            }, 24, (Object) null);
            List $this$filter$iv3 = selectedList;
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv3 : $this$filter$iv3) {
                BrandSplash it3 = (BrandSplash) element$iv$iv3;
                List selectedList2 = selectedList;
                Iterable $this$filter$iv4 = $this$filter$iv3;
                if (Intrinsics.areEqual(it3.getSource(), BrandSplashSource.DLC.getValue())) {
                    destination$iv$iv3.add(element$iv$iv3);
                }
                selectedList = selectedList2;
                $this$filter$iv3 = $this$filter$iv4;
            }
            String dlcList = CollectionsKt.joinToString$default((List) destination$iv$iv3, ",", "[", "]", 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.service.BrandSplashServiceHelper$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    CharSequence brandListParams$lambda$5;
                    brandListParams$lambda$5 = BrandSplashServiceHelper.getBrandListParams$lambda$5((BrandSplash) obj);
                    return brandListParams$lambda$5;
                }
            }, 24, (Object) null);
            str = "{\"brand\":" + brandList + ",\"vip\":" + vipList + ", \"dlc\":" + dlcList + "}";
        }
        String dlcList2 = str;
        DisplayMetrics metrics = context2.getResources().getDisplayMetrics();
        int width = Math.min(metrics.widthPixels, metrics.heightPixels);
        int height = Math.max(metrics.widthPixels, metrics.heightPixels);
        map.put("device", "phone");
        map.put(PerformanceConstants.EXTRA_KEY_NETWORK, getNetwork());
        map.put("screen_width", String.valueOf(width));
        map.put("screen_height", String.valueOf(height));
        map.put("selected", dlcList2);
        return EnhancedUnmodifiabilityKt.unmodifiable(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getBrandListParams$lambda$1(BrandSplash it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getBrandListParams$lambda$3(BrandSplash it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getBrandListParams$lambda$5(BrandSplash it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getId());
    }
}