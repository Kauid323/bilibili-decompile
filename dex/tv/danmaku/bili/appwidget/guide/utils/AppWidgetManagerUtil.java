package tv.danmaku.bili.appwidget.guide.utils;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import com.bilibili.moduleservice.appwidget.GuideScene;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdaterKt;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: AppWidgetManagerUtil.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0015J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/utils/AppWidgetManagerUtil;", "", "<init>", "()V", "TAG", "", "KEY_ADD_TYPE", "VALUE_APP_WIDGET_DETAIL", "KEY_WIDGET_NAME", "KEY_WIDGET_EXTRA_DATA", "KEY_AUTO_PIN_APP_WIDGET", "requestPinAppWidget", "", "context", "Landroid/content/Context;", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "extras", "Landroid/os/Bundle;", "requestPinAppWidget$core_apinkDebug", "requestPinAppWidgetExtras", "requestPinAppWidgetExtras$core_apinkDebug", "isWidgetDetailPageSupported", "isWidgetDetailPageSupported$core_apinkDebug", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppWidgetManagerUtil {
    public static final int $stable = 0;
    public static final AppWidgetManagerUtil INSTANCE = new AppWidgetManagerUtil();
    private static final String KEY_ADD_TYPE = "addType";
    public static final String KEY_AUTO_PIN_APP_WIDGET = "auto_pin_app_widget";
    public static final String KEY_WIDGET_EXTRA_DATA = "widgetExtraData";
    private static final String KEY_WIDGET_NAME = "widgetName";
    private static final String TAG = "AppWidgetManagerUtils";
    private static final String VALUE_APP_WIDGET_DETAIL = "appWidgetDetail";

    private AppWidgetManagerUtil() {
    }

    public static /* synthetic */ boolean requestPinAppWidget$core_apinkDebug$default(AppWidgetManagerUtil appWidgetManagerUtil, Context context, GuideScene guideScene, Bundle bundle, int i, Object obj) {
        if ((i & 4) != 0) {
            bundle = null;
        }
        return appWidgetManagerUtil.requestPinAppWidget$core_apinkDebug(context, guideScene, bundle);
    }

    public final boolean requestPinAppWidget$core_apinkDebug(Context context, GuideScene scene, Bundle extras) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (Build.VERSION.SDK_INT < 26) {
            BLog.i(TAG, "OS Version is too low: " + Build.VERSION.SDK_INT);
            return false;
        }
        try {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            if (!appWidgetManager.isRequestPinAppWidgetSupported()) {
                BLog.i(TAG, "not support request pin app widget");
                return false;
            } else if (AutoAddWidgetSceneExtKt.widgetAdded(scene, context)) {
                BLog.i(TAG, "app widget has been added");
                return false;
            } else {
                ComponentName componentName = new ComponentName(context, AutoAddWidgetSceneExtKt.component(scene));
                Intent pinnedWidgetCallbackIntent = new Intent(context, AutoAddWidgetSceneExtKt.component(scene));
                pinnedWidgetCallbackIntent.setAction(AutoAddWidgetSceneExtKt.action(scene));
                pinnedWidgetCallbackIntent.putExtra(FavoritesConstsKt.SPMID, AutoAddWidgetSceneExtKt.spmid(scene));
                pinnedWidgetCallbackIntent.putExtra("content_id", AutoAddWidgetSceneExtKt.contentId(scene));
                PendingIntent successCallback = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(context, HotWordAppWidgetUpdaterKt.REQUEST_CODE_AUTO_ADD, pinnedWidgetCallbackIntent, 201326592);
                appWidgetManager.requestPinAppWidget(componentName, extras, successCallback);
                return true;
            }
        } catch (Exception e) {
            BLog.e(TAG, "requestPinAppWidget -> error = " + e);
            return false;
        }
    }

    public final Bundle requestPinAppWidgetExtras$core_apinkDebug(GuideScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (scene instanceof GuideScene.Function) {
            Bundle extras = new Bundle();
            extras.putString(KEY_ADD_TYPE, VALUE_APP_WIDGET_DETAIL);
            extras.putString(KEY_WIDGET_NAME, AutoAddWidgetSceneExtKt.contentId(scene));
            Bundle dataBundle = new Bundle();
            dataBundle.putString(KEY_AUTO_PIN_APP_WIDGET, ((GuideScene.Function) scene).getSpmid());
            extras.putBundle(KEY_WIDGET_EXTRA_DATA, dataBundle);
            return extras;
        }
        return null;
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

    public final Object isWidgetDetailPageSupported$core_apinkDebug(Context context, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AppWidgetManagerUtil$isWidgetDetailPageSupported$2(context, null), continuation);
    }
}