package tv.danmaku.bili.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.bilibili.app.history.di.AutoAddWidgetInterface;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.moduleservice.appwidget.GuideScene;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.utils.AutoAddWidgetSceneExtKt;
import tv.danmaku.bili.appwidget.hotlist.utils.ReportUtilKt;
import tv.danmaku.bili.appwidget.hotword.HotWordAppWidget;
import tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdaterKt;
import tv.danmaku.bili.appwidget.utils.WidgetUtilsKt;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: AutoAddWidget.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/appwidget/AutoAddWidget;", "Lcom/bilibili/app/history/di/AutoAddWidgetInterface;", "<init>", "()V", "tryToAddWidget", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "context", "Landroid/content/Context;", FavoritesConstsKt.SPMID, "", "tryToAddUpCardWidget", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "isHonorDevice", "getSP", "key", "defaultValue", "putSP", "", "value", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AutoAddWidget implements AutoAddWidgetInterface {
    public static final int $stable = 0;
    public static final String AUTO_ADD_WIDGET_HAS_SHOWED_KEY = "auto_add_widget_has_showed_key";
    public static final Companion Companion = new Companion(null);
    public static final String HONOR_DEVICE = "honor";
    public static final String TAG = "AutoAddWidget";

    /* compiled from: AutoAddWidget.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/appwidget/AutoAddWidget$Companion;", "", "<init>", "()V", "TAG", "", "HONOR_DEVICE", "AUTO_ADD_WIDGET_HAS_SHOWED_KEY", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean tryToAddWidget(Lifecycle lifecycle, Context context, String spmid) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (!isHonorDevice()) {
            BLog.i(TAG, "Not Honor Device");
            return false;
        } else if (!DeviceDecision.INSTANCE.getBoolean("dd.show_auto_add_widget_dialog", false)) {
            BLog.i(TAG, "Not Hit DD");
            return false;
        } else if (Build.VERSION.SDK_INT < 26) {
            BLog.i(TAG, "OS version is too low: " + Build.VERSION.SDK_INT);
            return false;
        } else if (!appWidgetManager.isRequestPinAppWidgetSupported()) {
            BLog.i(TAG, "!isRequestPinAppWidgetSupported");
            return false;
        } else if (WidgetUtilsKt.isWidgetAdded(context, HotWordAppWidget.class)) {
            BLog.i(TAG, "HotWordAppWidget has been added");
            return false;
        } else if (getSP(AUTO_ADD_WIDGET_HAS_SHOWED_KEY, false)) {
            BLog.i(TAG, "has show widget dialog");
            return false;
        } else {
            ComponentName myProvider = new ComponentName(context, HotWordAppWidget.class);
            Intent pinnedWidgetCallbackIntent = new Intent(context, HotWordAppWidget.class);
            pinnedWidgetCallbackIntent.setAction("tv.danmaku.bili.action.appwidget.AUTO_ADD_WIDGET");
            pinnedWidgetCallbackIntent.putExtra(FavoritesConstsKt.SPMID, spmid);
            PendingIntent successCallback = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(context, HotWordAppWidgetUpdaterKt.REQUEST_CODE_AUTO_ADD, pinnedWidgetCallbackIntent, 201326592);
            appWidgetManager.requestPinAppWidget(myProvider, null, successCallback);
            ReportUtilKt.reportStartAutoAdd(spmid);
            BuildersKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), Dispatchers.getIO(), (CoroutineStart) null, new AutoAddWidget$tryToAddWidget$1(this, null), 2, (Object) null);
            BLog.i(TAG, "requestPinAppWidget success");
            return true;
        }
    }

    private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(Context context, int requestCode, Intent intent, int flags) {
        PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
            } catch (IllegalArgumentException e) {
                return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(33554432 | flags).intValue());
            }
        }
        return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
    }

    public boolean tryToAddUpCardWidget(Context context, GuideScene scene) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scene, "scene");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (Build.VERSION.SDK_INT < 26) {
            BLog.i(TAG, "OS version is too low: " + Build.VERSION.SDK_INT);
            return false;
        } else if (!appWidgetManager.isRequestPinAppWidgetSupported()) {
            BLog.i(TAG, "!isRequestPinAppWidgetSupported");
            return false;
        } else if (AutoAddWidgetSceneExtKt.widgetAdded(scene, context)) {
            BLog.i(TAG, "UpCardAppWidget has been added");
            return false;
        } else {
            ComponentName myProvider = new ComponentName(context, AutoAddWidgetSceneExtKt.component(scene));
            Intent pinnedWidgetCallbackIntent = new Intent(context, AutoAddWidgetSceneExtKt.component(scene));
            pinnedWidgetCallbackIntent.setAction(AutoAddWidgetSceneExtKt.action(scene));
            pinnedWidgetCallbackIntent.putExtra(FavoritesConstsKt.SPMID, AutoAddWidgetSceneExtKt.spmid(scene));
            pinnedWidgetCallbackIntent.putExtra("content_id", AutoAddWidgetSceneExtKt.contentId(scene));
            PendingIntent successCallback = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(context, HotWordAppWidgetUpdaterKt.REQUEST_CODE_AUTO_ADD, pinnedWidgetCallbackIntent, 201326592);
            appWidgetManager.requestPinAppWidget(myProvider, null, successCallback);
            BLog.i(TAG, "requestPinAppWidget success");
            return true;
        }
    }

    private final boolean isHonorDevice() {
        String manufacturer = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(manufacturer, "MANUFACTURER");
        String brand = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(brand, "BRAND");
        String model = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(model, "MODEL");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String manufacturer2 = manufacturer.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(manufacturer2, "toLowerCase(...)");
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
        String brand2 = brand.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(brand2, "toLowerCase(...)");
        Locale locale3 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
        String model2 = model.toLowerCase(locale3);
        Intrinsics.checkNotNullExpressionValue(model2, "toLowerCase(...)");
        BLog.i(TAG, "manufacturer: " + manufacturer2 + ", brand: " + brand2 + ", model: " + model2);
        return StringsKt.contains$default(manufacturer2, HONOR_DEVICE, false, 2, (Object) null) || StringsKt.contains$default(brand2, HONOR_DEVICE, false, 2, (Object) null) || StringsKt.contains$default(model2, HONOR_DEVICE, false, 2, (Object) null);
    }

    static /* synthetic */ boolean getSP$default(AutoAddWidget autoAddWidget, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return autoAddWidget.getSP(str, z);
    }

    private final boolean getSP(String key, boolean defaultValue) {
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        if (bLKVSharedPreference != null) {
            return bLKVSharedPreference.getBoolean(key, defaultValue);
        }
        return defaultValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void putSP(String key, boolean value) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        if (bLKVSharedPreference != null && (edit = bLKVSharedPreference.edit()) != null && (putBoolean = edit.putBoolean(key, value)) != null) {
            putBoolean.apply();
        }
    }
}