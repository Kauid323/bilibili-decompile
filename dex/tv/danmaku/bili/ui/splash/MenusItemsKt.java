package tv.danmaku.bili.ui.splash;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import androidx.appcompat.app.AlertDialog;
import com.alibaba.fastjson.JSON;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.SharedPrefX;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.resmanager.DownloadBizType;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.splash.ad.SplashHelper;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashData;
import tv.danmaku.bili.ui.splash.event.EventSplashData;
import tv.danmaku.bili.ui.splash.event.EventSplashDataList;
import tv.danmaku.bili.ui.splash.event.EventSplashStorage;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: MenusItems.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"menuItems", "", "Ltv/danmaku/bili/ui/splash/SplashTestItem;", "getMenuItems", "()Ljava/util/List;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MenusItemsKt {
    private static final List<SplashTestItem> menuItems = CollectionsKt.listOf(new SplashTestItem[]{new SplashTestItem("清除事件闪屏展示次数", new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda8
        public final Object invoke(Object obj) {
            Unit menuItems$lambda$0;
            menuItems$lambda$0 = MenusItemsKt.menuItems$lambda$0((Context) obj);
            return menuItems$lambda$0;
        }
    }), new SplashTestItem("清除生日闪屏展示次数", new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda9
        public final Object invoke(Object obj) {
            Unit menuItems$lambda$1;
            menuItems$lambda$1 = MenusItemsKt.menuItems$lambda$1((Context) obj);
            return menuItems$lambda$1;
        }
    }), new SplashTestItem("清除事件闪屏本地数据", new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda10
        public final Object invoke(Object obj) {
            Unit menuItems$lambda$2;
            menuItems$lambda$2 = MenusItemsKt.menuItems$lambda$2((Context) obj);
            return menuItems$lambda$2;
        }
    }), new SplashTestItem("闪屏传感器调试开关", new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda11
        public final Object invoke(Object obj) {
            Unit menuItems$lambda$3;
            menuItems$lambda$3 = MenusItemsKt.menuItems$lambda$3((Context) obj);
            return menuItems$lambda$3;
        }
    }), new SplashTestItem("手机传感器调试开关\n(强制按钮降级)", new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda12
        public final Object invoke(Object obj) {
            Unit menuItems$lambda$4;
            menuItems$lambda$4 = MenusItemsKt.menuItems$lambda$4((Context) obj);
            return menuItems$lambda$4;
        }
    }), new SplashTestItem("清除本地缓存闪屏资源", new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda13
        public final Object invoke(Object obj) {
            Unit menuItems$lambda$5;
            menuItems$lambda$5 = MenusItemsKt.menuItems$lambda$5((Context) obj);
            return menuItems$lambda$5;
        }
    }), new SplashTestItem("删除ResManager所有资源", new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj) {
            Unit menuItems$lambda$6;
            menuItems$lambda$6 = MenusItemsKt.menuItems$lambda$6((Context) obj);
            return menuItems$lambda$6;
        }
    }), new SplashTestItem("展示本地配置信息", new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj) {
            Unit menuItems$lambda$7;
            menuItems$lambda$7 = MenusItemsKt.menuItems$lambda$7((Context) obj);
            return menuItems$lambda$7;
        }
    }), new SplashTestItem("展示本地闪屏创意列表", new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda3
        public final Object invoke(Object obj) {
            Unit menuItems$lambda$8;
            menuItems$lambda$8 = MenusItemsKt.menuItems$lambda$8((Context) obj);
            return menuItems$lambda$8;
        }
    }), new SplashTestItem("获取本地闪屏list缓存", new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda4
        public final Object invoke(Object obj) {
            Unit menuItems$lambda$9;
            menuItems$lambda$9 = MenusItemsKt.menuItems$lambda$9((Context) obj);
            return menuItems$lambda$9;
        }
    })});

    public static final List<SplashTestItem> getMenuItems() {
        return EnhancedUnmodifiabilityKt.unmodifiable(menuItems);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$0(Context context) {
        List<EventSplashData> eventList;
        Iterable filterNotNull;
        Intrinsics.checkNotNullParameter(context, "context");
        EventSplashDataList localEventSplashData = EventSplashStorage.INSTANCE.getLocalEventSplashData();
        if (localEventSplashData != null && (eventList = localEventSplashData.getEventList()) != null && (filterNotNull = CollectionsKt.filterNotNull(eventList)) != null) {
            Iterable $this$forEach$iv = filterNotNull;
            for (Object element$iv : $this$forEach$iv) {
                EventSplashData it = (EventSplashData) element$iv;
                EventSplashStorage.INSTANCE.clearEventSplashShowCount(it);
                ToastHelper.showToast(context, "清除成功", 0);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        EventSplashStorage.INSTANCE.clearBirthdaySplashShowCount();
        ToastHelper.showToast(context, "清除成功", 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$2(Context context) {
        SharedPrefX bLSharedPreferences$default;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor clear;
        Intrinsics.checkNotNullParameter(context, "context");
        Application application = BiliContext.application();
        if (application != null && (bLSharedPreferences$default = BLKV.getBLSharedPreferences$default(application, "splash.event.splash.name", true, 0, 4, (Object) null)) != null && (edit = bLSharedPreferences$default.edit()) != null && (clear = edit.clear()) != null) {
            clear.apply();
        }
        ToastHelper.showToast(context, "清除成功", 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$3(Context it) {
        SharedPreferences.Editor putBoolean;
        SharedPreferences.Editor putBoolean2;
        Intrinsics.checkNotNullParameter(it, "it");
        boolean currentIsEnable = BiliGlobalPreferenceHelper.getBLKVSharedPreference(it).getBoolean("splash_is_sensor_debug_enable", true);
        if (currentIsEnable) {
            SharedPreferences.Editor edit = BiliGlobalPreferenceHelper.getBLKVSharedPreference(it).edit();
            if (edit != null && (putBoolean2 = edit.putBoolean("splash_is_sensor_debug_enable", false)) != null) {
                putBoolean2.commit();
            }
            ToastHelper.showToast(it, "开关已关闭", 0);
        } else {
            SharedPreferences.Editor edit2 = BiliGlobalPreferenceHelper.getBLKVSharedPreference(it).edit();
            if (edit2 != null && (putBoolean = edit2.putBoolean("splash_is_sensor_debug_enable", true)) != null) {
                putBoolean.commit();
            }
            ToastHelper.showToast(it, "开关已打开", 0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$4(Context it) {
        SharedPreferences.Editor putBoolean;
        SharedPreferences.Editor putBoolean2;
        Intrinsics.checkNotNullParameter(it, "it");
        boolean currentIsDisable = BiliGlobalPreferenceHelper.getBLKVSharedPreference(it).getBoolean("disable_splash_debug_sensor", false);
        if (currentIsDisable) {
            SharedPreferences.Editor edit = BiliGlobalPreferenceHelper.getBLKVSharedPreference(it).edit();
            if (edit != null && (putBoolean2 = edit.putBoolean("disable_splash_debug_sensor", false)) != null) {
                putBoolean2.commit();
            }
            ToastHelper.showToast(it, "开关已关闭，正常使用手机传感器", 1);
        } else {
            SharedPreferences.Editor edit2 = BiliGlobalPreferenceHelper.getBLKVSharedPreference(it).edit();
            if (edit2 != null && (putBoolean = edit2.putBoolean("disable_splash_debug_sensor", true)) != null) {
                putBoolean.commit();
            }
            ToastHelper.showToast(it, "开关已打开，已经禁用闪屏传感器", 1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$5(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ResManager.deleteWithWhitelist(DownloadBizType.Splash, CollectionsKt.emptyList());
        ResManager.deleteWithWhitelist(DownloadBizType.EffectSplash, CollectionsKt.emptyList());
        ToastHelper.showToast(context, "清除成功", 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$6(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FileUtils.deleteQuietly(new File(context.getFilesDir() + "/res_cache"));
        ToastHelper.showToast(context, "清除成功，请重启", 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$7(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final SplashData splashData = SplashHelper.readConfigFromDisk();
        if (splashData != null) {
            splashData.setSplashList(new ArrayList());
        }
        if (splashData != null) {
            RouteRequest request = new RouteRequest.Builder("bilibili://list_test/jsonViewer").extras(new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    Unit menuItems$lambda$7$0;
                    menuItems$lambda$7$0 = MenusItemsKt.menuItems$lambda$7$0(SplashData.this, (MutableBundleLike) obj);
                    return menuItems$lambda$7$0;
                }
            }).build();
            BLRouter.routeTo$default(request, (Context) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$7$0(SplashData $splashData, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        String jSONString = JSON.toJSONString($splashData);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        $this$extras.put("jsonStr", jSONString);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$8(Context context) {
        Iterable splashList;
        Intrinsics.checkNotNullParameter(context, "context");
        SplashData splashData = SplashHelper.readConfigFromDisk();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        final List liteList = new ArrayList();
        if (splashData != null && (splashList = splashData.getSplashList()) != null) {
            Iterable $this$forEach$iv = splashList;
            for (Object element$iv : $this$forEach$iv) {
                Splash it = (Splash) element$iv;
                SplashLite $this$menuItems_u24lambda_u248_u240_u240 = new SplashLite();
                $this$menuItems_u24lambda_u248_u240_u240.setId(it.id);
                $this$menuItems_u24lambda_u248_u240_u240.setCardType(it.cardType);
                $this$menuItems_u24lambda_u248_u240_u240.setType(it.type);
                $this$menuItems_u24lambda_u248_u240_u240.setImageHash(it.imageHash);
                $this$menuItems_u24lambda_u248_u240_u240.setVideoHash(it.videoHash);
                $this$menuItems_u24lambda_u248_u240_u240.setExposeCount(it.localExposeCount);
                $this$menuItems_u24lambda_u248_u240_u240.setLastExposeTime(sdf.format(Long.valueOf(it.lastExposeTime)));
                long j = it.beginTime;
                SplashData splashData2 = splashData;
                long j2 = (long) IjkMediaCodecInfo.RANK_MAX;
                $this$menuItems_u24lambda_u248_u240_u240.setBeginTime(sdf.format(Long.valueOf(j * j2)));
                $this$menuItems_u24lambda_u248_u240_u240.setEndTime(sdf.format(Long.valueOf(it.endTime * j2)));
                liteList.add($this$menuItems_u24lambda_u248_u240_u240);
                splashData = splashData2;
            }
        }
        RouteRequest request = new RouteRequest.Builder("bilibili://list_test/jsonViewer").extras(new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit menuItems$lambda$8$1;
                menuItems$lambda$8$1 = MenusItemsKt.menuItems$lambda$8$1(liteList, (MutableBundleLike) obj);
                return menuItems$lambda$8$1;
            }
        }).build();
        BLRouter.routeTo$default(request, (Context) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$8$1(List $liteList, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        String jSONString = JSON.toJSONString($liteList);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        $this$extras.put("jsonStr", jSONString);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$9(Context context) {
        List list;
        Intrinsics.checkNotNullParameter(context, "context");
        SplashData readConfigFromDisk = SplashHelper.readConfigFromDisk();
        String[] strArr = null;
        final List splashList = readConfigFromDisk != null ? readConfigFromDisk.getSplashList() : null;
        if (splashList == null) {
            list = null;
        } else {
            Iterable $this$map$iv = splashList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Splash it = (Splash) item$iv$iv;
                destination$iv$iv.add("闪屏id:" + it.id);
            }
            list = (List) destination$iv$iv;
        }
        final List idList = list;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (idList != null) {
            List $this$toTypedArray$iv = idList;
            strArr = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
        }
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MenusItemsKt.menuItems$lambda$9$1(idList, splashList, dialogInterface, i);
            }
        }).create().show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void menuItems$lambda$9$1(List $idList, List $splashList, DialogInterface dialogInterface, int position) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNull($idList);
        String id = (String) $idList.get(position);
        Iterator it = $splashList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Splash it2 = (Splash) obj;
            long j = it2.id;
            Long longOrNull = StringsKt.toLongOrNull(StringsKt.replace$default(id, "闪屏id:", "", false, 4, (Object) null));
            if (longOrNull != null && j == longOrNull.longValue()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        final Splash splash = (Splash) obj;
        if (splash != null) {
            RouteRequest request = new RouteRequest.Builder("bilibili://list_test/jsonViewer").extras(new Function1() { // from class: tv.danmaku.bili.ui.splash.MenusItemsKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit menuItems$lambda$9$1$1;
                    menuItems$lambda$9$1$1 = MenusItemsKt.menuItems$lambda$9$1$1(Splash.this, (MutableBundleLike) obj2);
                    return menuItems$lambda$9$1$1;
                }
            }).build();
            BLRouter.routeTo$default(request, (Context) null, 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuItems$lambda$9$1$1(Splash $splash, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        String jSONString = JSON.toJSONString($splash);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        $this$extras.put("jsonStr", jSONString);
        return Unit.INSTANCE;
    }
}