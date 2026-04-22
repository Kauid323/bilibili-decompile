package tv.danmaku.bili.appwidget.hotword;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.WidgetTransparentActivity;
import tv.danmaku.bili.appwidget.WidgetTransparentActivityKt;
import tv.danmaku.bili.appwidget.hotword.api.AppWidgetHelperKt;
import tv.danmaku.bili.appwidget.hotword.data.ButtonData;
import tv.danmaku.bili.appwidget.hotword.data.HotWordLocalWidgetData;
import tv.danmaku.bili.appwidget.hotword.data.HotWordWidgetData;
import tv.danmaku.bili.appwidget.hotword.router.HotWordAppWidgetRouter;
import tv.danmaku.bili.router.SearchRoutes;

/* compiled from: HotWordAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ \u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ2\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J(\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0019J6\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u0011H\u0002J2\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/bili/appwidget/hotword/HotWordAppWidgetUpdater;", "", "<init>", "()V", "TAG", "", "updateWidgetWithCacheData", "", "context", "Landroid/content/Context;", "updateAppWidget", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "updateAppWidgetInternal", "useCache", "", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidgetWithLocalData", "constructWidgetView", "Landroid/widget/RemoteViews;", "data", "Ltv/danmaku/bili/appwidget/hotword/data/HotWordWidgetData;", "withPic", "(Landroid/content/Context;Ltv/danmaku/bili/appwidget/hotword/data/HotWordWidgetData;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createIntent", "Landroid/app/PendingIntent;", "url", "reportTitle", "requestCode", "", "app", "downloadImage", "Landroid/graphics/Bitmap;", "width", "height", "(Landroid/content/Context;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildSearchUrl", "searchJumpLink", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotWordAppWidgetUpdater {
    public static final int $stable = 0;
    public static final HotWordAppWidgetUpdater INSTANCE = new HotWordAppWidgetUpdater();
    private static final String TAG = "HotWordAppWidgetUpdater";

    private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(Context context, int requestCode, Intent intent, int flags) {
        PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
            } catch (IllegalArgumentException e) {
                return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(33554432 | flags).intValue());
            }
        }
        return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
    }

    private HotWordAppWidgetUpdater() {
    }

    public final void updateWidgetWithCacheData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (DelayTaskController.shouldBlock()) {
                BLog.i(TAG, "update -> should block");
                updateWidgetWithLocalData(context);
                return;
            }
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            if (appWidgetManager == null) {
                return;
            }
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, HotWordAppWidget.class));
            if (appWidgetIds != null) {
                if (!(appWidgetIds.length == 0)) {
                    BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new HotWordAppWidgetUpdater$updateWidgetWithCacheData$1(context, appWidgetManager, appWidgetIds, null), 3, (Object) null);
                    return;
                }
            }
            BLog.i(TAG, "update -> non appwidget");
        } catch (Exception e) {
            BLog.e(TAG, "update error = " + e);
        }
    }

    public final void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        String arrays = Arrays.toString(appWidgetIds);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        BLog.i(TAG, "updateAppWidget " + arrays);
        if (appWidgetIds != null) {
            if (appWidgetIds.length == 0) {
                return;
            }
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new HotWordAppWidgetUpdater$updateAppWidget$1(context, appWidgetManager, appWidgetIds, null), 3, (Object) null);
        }
    }

    public static /* synthetic */ Object updateAppWidgetInternal$default(HotWordAppWidgetUpdater hotWordAppWidgetUpdater, Context context, AppWidgetManager appWidgetManager, int[] iArr, boolean z, Continuation continuation, int i, Object obj) {
        boolean z2;
        if ((i & 8) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return hotWordAppWidgetUpdater.updateAppWidgetInternal(context, appWidgetManager, iArr, z2, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|8))|46|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e7, code lost:
        tv.danmaku.android.log.BLog.e(tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdater.TAG, "updateAppWidgetInternal error ", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9 A[Catch: Exception -> 0x0058, TryCatch #0 {Exception -> 0x0058, blocks: (B:13:0x003e, B:42:0x00d0, B:16:0x0052, B:35:0x00b4, B:38:0x00b9, B:43:0x00d7, B:21:0x0068, B:23:0x008b, B:31:0x0097, B:32:0x009c, B:44:0x00e4), top: B:49:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d7 A[Catch: Exception -> 0x0058, TryCatch #0 {Exception -> 0x0058, blocks: (B:13:0x003e, B:42:0x00d0, B:16:0x0052, B:35:0x00b4, B:38:0x00b9, B:43:0x00d7, B:21:0x0068, B:23:0x008b, B:31:0x0097, B:32:0x009c, B:44:0x00e4), top: B:49:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateAppWidgetInternal(Context context, AppWidgetManager appWidgetManager, int[] iArr, boolean useCache, Continuation<? super Unit> continuation) {
        HotWordAppWidgetUpdater$updateAppWidgetInternal$1 hotWordAppWidgetUpdater$updateAppWidgetInternal$1;
        HotWordAppWidgetUpdater$updateAppWidgetInternal$1 hotWordAppWidgetUpdater$updateAppWidgetInternal$12;
        HotWordAppWidgetUpdater hotWordAppWidgetUpdater;
        AppWidgetManager appWidgetManager2;
        Context context2;
        int[] appWidgetIds;
        Object hotWordWidgetApiData;
        HotWordWidgetData data;
        Object constructWidgetView;
        AppWidgetManager appWidgetManager3;
        if (continuation instanceof HotWordAppWidgetUpdater$updateAppWidgetInternal$1) {
            hotWordAppWidgetUpdater$updateAppWidgetInternal$1 = (HotWordAppWidgetUpdater$updateAppWidgetInternal$1) continuation;
            if ((hotWordAppWidgetUpdater$updateAppWidgetInternal$1.label & Integer.MIN_VALUE) != 0) {
                hotWordAppWidgetUpdater$updateAppWidgetInternal$1.label -= Integer.MIN_VALUE;
                hotWordAppWidgetUpdater$updateAppWidgetInternal$12 = hotWordAppWidgetUpdater$updateAppWidgetInternal$1;
                Object $result = hotWordAppWidgetUpdater$updateAppWidgetInternal$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (hotWordAppWidgetUpdater$updateAppWidgetInternal$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        hotWordAppWidgetUpdater = this;
                        appWidgetManager2 = appWidgetManager;
                        context2 = context;
                        appWidgetIds = iArr;
                        String arrays = Arrays.toString(appWidgetIds);
                        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
                        BLog.i(TAG, "updateAppWidgetInternal " + arrays);
                        if (appWidgetIds != null) {
                            if (!(appWidgetIds.length == 0)) {
                                if (useCache) {
                                    data = AppWidgetHelperKt.getHorWordWidgetLocalData(context2);
                                    if (data == null) {
                                        HotWordAppWidgetUpdater hotWordAppWidgetUpdater2 = hotWordAppWidgetUpdater;
                                        BLog.w(TAG, "updateAppWidgetWithData: no data available");
                                        return Unit.INSTANCE;
                                    }
                                    HotWordAppWidgetUpdater hotWordAppWidgetUpdater3 = INSTANCE;
                                    hotWordAppWidgetUpdater$updateAppWidgetInternal$12.L$0 = appWidgetManager2;
                                    hotWordAppWidgetUpdater$updateAppWidgetInternal$12.L$1 = appWidgetIds;
                                    hotWordAppWidgetUpdater$updateAppWidgetInternal$12.L$2 = null;
                                    hotWordAppWidgetUpdater$updateAppWidgetInternal$12.label = 2;
                                    constructWidgetView = hotWordAppWidgetUpdater3.constructWidgetView(context2, data, true, hotWordAppWidgetUpdater$updateAppWidgetInternal$12);
                                    if (constructWidgetView == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    appWidgetManager3 = appWidgetManager2;
                                    RemoteViews views = (RemoteViews) constructWidgetView;
                                    appWidgetManager3.updateAppWidget(appWidgetIds, views);
                                    return Unit.INSTANCE;
                                }
                                Context applicationContext = context2.getApplicationContext();
                                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                                hotWordAppWidgetUpdater$updateAppWidgetInternal$12.L$0 = context2;
                                hotWordAppWidgetUpdater$updateAppWidgetInternal$12.L$1 = appWidgetManager2;
                                hotWordAppWidgetUpdater$updateAppWidgetInternal$12.L$2 = appWidgetIds;
                                hotWordAppWidgetUpdater$updateAppWidgetInternal$12.label = 1;
                                hotWordWidgetApiData = AppWidgetHelperKt.getHotWordWidgetApiData(applicationContext, hotWordAppWidgetUpdater$updateAppWidgetInternal$12);
                                if (hotWordWidgetApiData == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                data = (HotWordWidgetData) hotWordWidgetApiData;
                                if (data == null) {
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        hotWordAppWidgetUpdater = this;
                        int[] appWidgetIds2 = (int[]) hotWordAppWidgetUpdater$updateAppWidgetInternal$12.L$2;
                        appWidgetManager2 = (AppWidgetManager) hotWordAppWidgetUpdater$updateAppWidgetInternal$12.L$1;
                        context2 = (Context) hotWordAppWidgetUpdater$updateAppWidgetInternal$12.L$0;
                        ResultKt.throwOnFailure($result);
                        appWidgetIds = appWidgetIds2;
                        hotWordWidgetApiData = $result;
                        data = (HotWordWidgetData) hotWordWidgetApiData;
                        if (data == null) {
                        }
                        break;
                    case 2:
                        int[] appWidgetIds3 = (int[]) hotWordAppWidgetUpdater$updateAppWidgetInternal$12.L$1;
                        appWidgetManager3 = (AppWidgetManager) hotWordAppWidgetUpdater$updateAppWidgetInternal$12.L$0;
                        ResultKt.throwOnFailure($result);
                        appWidgetIds = appWidgetIds3;
                        constructWidgetView = $result;
                        RemoteViews views2 = (RemoteViews) constructWidgetView;
                        appWidgetManager3.updateAppWidget(appWidgetIds, views2);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        hotWordAppWidgetUpdater$updateAppWidgetInternal$1 = new HotWordAppWidgetUpdater$updateAppWidgetInternal$1(this, continuation);
        hotWordAppWidgetUpdater$updateAppWidgetInternal$12 = hotWordAppWidgetUpdater$updateAppWidgetInternal$1;
        Object $result2 = hotWordAppWidgetUpdater$updateAppWidgetInternal$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (hotWordAppWidgetUpdater$updateAppWidgetInternal$12.label) {
        }
    }

    private final void updateWidgetWithLocalData(Context context) {
        RemoteViews remoteView;
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (appWidgetManager == null) {
            return;
        }
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, HotWordAppWidget.class));
        if (appWidgetIds != null) {
            if (!(appWidgetIds.length == 0)) {
                HotWordLocalWidgetData data = AppWidgetHelperKt.getLocalDefaultHotWordWidgetData(context);
                try {
                    remoteView = new RemoteViews(context.getPackageName(), R.layout.bili_app_hot_word_widget);
                    remoteView.setOnClickPendingIntent(R.id.brand, createIntent(context, "", "bilibili", 3335, true));
                    remoteView.removeAllViews(R.id.container_entrances);
                    Iterable $this$forEachIndexed$iv = data.getButtons();
                    int index$iv = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ButtonData widgetButtonData = (ButtonData) item$iv;
                        int index = index$iv;
                        RemoteViews entranceView = new RemoteViews(context.getPackageName(), R.layout.bili_include_widget_entrance);
                        entranceView.setTextViewText(R.id.tv_entrance, widgetButtonData.getText());
                        entranceView.setImageViewResource(R.id.iv_entrance, widgetButtonData.getIcon());
                        String it = widgetButtonData.getUrl();
                        String position = "";
                        try {
                            Uri uri = Uri.parse(it);
                            String queryParameter = uri.getQueryParameter("position");
                            position = queryParameter != null ? queryParameter : "";
                        } catch (Exception e) {
                            BLog.e(TAG, e, new Function0() { // from class: tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdater$$ExternalSyntheticLambda0
                                public final Object invoke() {
                                    Object updateWidgetWithLocalData$lambda$0$0$0;
                                    updateWidgetWithLocalData$lambda$0$0$0 = HotWordAppWidgetUpdater.updateWidgetWithLocalData$lambda$0$0$0();
                                    return updateWidgetWithLocalData$lambda$0$0$0;
                                }
                            });
                        }
                        PendingIntent intent = createIntent$default(INSTANCE, context, widgetButtonData.getUrl(), position, index + 3340, false, 16, null);
                        entranceView.setOnClickPendingIntent(R.id.ll_entrance, intent);
                        remoteView.addView(R.id.container_entrances, entranceView);
                        index$iv = index$iv2;
                    }
                    int index$iv3 = R.id.tv_hot_word;
                    remoteView.setTextViewText(index$iv3, data.getHotWord());
                } catch (Exception e2) {
                    e = e2;
                    BLog.e(TAG, "updateLocalData error = " + e);
                    return;
                }
                try {
                    String search = buildSearchUrl(null);
                    remoteView.setOnClickPendingIntent(R.id.container_search, createIntent$default(this, context, search, "search", 3334, false, 16, null));
                    appWidgetManager.updateAppWidget(appWidgetIds, remoteView);
                    return;
                } catch (Exception e3) {
                    e = e3;
                    BLog.e(TAG, "updateLocalData error = " + e);
                    return;
                }
            }
        }
        BLog.i(TAG, "update -> non appwidget");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object updateWidgetWithLocalData$lambda$0$0$0() {
        return "parse Exception";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object constructWidgetView(Context context, HotWordWidgetData data, boolean withPic, Continuation<? super RemoteViews> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HotWordAppWidgetUpdater$constructWidgetView$2(context, data, withPic, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PendingIntent createIntent$default(HotWordAppWidgetUpdater hotWordAppWidgetUpdater, Context context, String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = false;
        }
        return hotWordAppWidgetUpdater.createIntent(context, str, str2, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent createIntent(Context context, String url, String reportTitle, int requestCode, boolean app) {
        int flag;
        if (Build.VERSION.SDK_INT >= 31) {
            flag = 201326592;
        } else {
            flag = 134217728;
        }
        BLog.i(TAG, "create pending intent " + url);
        Intent intent = new Intent(context, WidgetTransparentActivity.class);
        intent.setFlags(335544320);
        intent.putExtra(HotWordAppWidgetUpdaterKt.FROM_WIDGET, true);
        intent.putExtra(WidgetTransparentActivityKt.APP_WIDGET_ROUTER, url);
        intent.putExtra(HotWordAppWidgetUpdaterKt.WIDGET_MODULE_TITLE, reportTitle);
        intent.putExtra(WidgetTransparentActivityKt.APP_WIDGET_BUSINESS_CLASS_NAME, HotWordAppWidgetRouter.class.getName());
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(context, requestCode, intent, flag);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity, "let(...)");
        return __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadImage(Context context, String url, int width, int height, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HotWordAppWidgetUpdater$downloadImage$2(context, url, width, height, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildSearchUrl(String searchJumpLink) {
        String str = searchJumpLink;
        if (str == null || StringsKt.isBlank(str)) {
            return SearchRoutes.URI_BILIBILI_SEARCH;
        }
        return searchJumpLink;
    }
}