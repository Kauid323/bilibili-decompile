package tv.danmaku.bili.appwidget.hotlist;

import android.app.Activity;
import android.app.Application;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.HotListAppWidget;
import tv.danmaku.bili.appwidget.hotlist.utils.SpUtilKt;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.proc.ActivityCallBack;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.StartupFragmentV2;

/* compiled from: HotListAppWidget.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001c\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J.\u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u0018\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/HotListAppWidget;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onUpdate", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", ReportUtilKt.POS_UPDATE, "onDeleted", "onAppWidgetOptionsChanged", "appWidgetId", "", "newOptions", "Landroid/os/Bundle;", "onEnabled", "onDisabled", "onRestored", "oldWidgetIds", "newWidgetIds", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotListAppWidget extends AppWidgetProvider {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HotListAppWidget.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/HotListAppWidget$Companion;", "", "<init>", "()V", "hasHotListWidget", "", "context", "Landroid/content/Context;", "registerPackageChanged", "", "registerActivityCallBack", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter) {
            if (Build.VERSION.SDK_INT >= 34) {
                return ((Context) ctx).registerReceiver(receiver, filter, 4);
            }
            return ((Application) ctx).registerReceiver(receiver, filter);
        }

        private Companion() {
        }

        public final boolean hasHotListWidget(Context context) {
            int[] appWidgetIds;
            if (context == null) {
                return false;
            }
            try {
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                if (appWidgetManager == null || (appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, HotListAppWidget.class))) == null) {
                    return false;
                }
                return !(appWidgetIds.length == 0);
            } catch (Exception e) {
                BLog.e("HotListAppWidget", e);
                return false;
            }
        }

        public final void registerPackageChanged() {
            final Application context = BiliContext.application();
            if (context != null && hasHotListWidget(context)) {
                BLog.d("HotListAppWidget", "register PACKAGE_CHANGED");
                final HotListAppWidget hotListAppWidget = new HotListAppWidget();
                IntentFilter $this$registerPackageChanged_u24lambda_u240 = new IntentFilter("android.intent.action.PACKAGE_CHANGED");
                $this$registerPackageChanged_u24lambda_u240.addDataScheme("package");
                Unit unit = Unit.INSTANCE;
                __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(context, hotListAppWidget, $this$registerPackageChanged_u24lambda_u240);
                HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.appwidget.hotlist.HotListAppWidget$Companion$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        HotListAppWidget.Companion.registerPackageChanged$lambda$1(context, hotListAppWidget);
                    }
                }, (long) StartupFragmentV2.FORCE_UPDATE_CHECK_INTERVAL);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void registerPackageChanged$lambda$1(Application $context, HotListAppWidget $hotListAppWidget) {
            BLog.d("HotListAppWidget", "unregister PACKAGE_CHANGED");
            $context.unregisterReceiver($hotListAppWidget);
        }

        public final void registerActivityCallBack() {
            ActivityCallBack.addIPCActivityStateCallback(new ActivityCallBack.IPCActivityStateCallback() { // from class: tv.danmaku.bili.appwidget.hotlist.HotListAppWidget$Companion$registerActivityCallBack$1
                @Override // tv.danmaku.bili.proc.ActivityCallBack.IPCActivityStateCallback
                public void onVisibleCountChanged(Activity activity, int lastVisibleCount, int currentVisibleCount) {
                    Application it;
                    Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
                    if (lastVisibleCount != 0 && currentVisibleCount == 0 && (it = BiliContext.application()) != null && HotListAppWidget.Companion.hasHotListWidget(it)) {
                        Intent $this$onVisibleCountChanged_u24lambda_u240_u240 = new Intent("tv.danmaku.bili.action.appwidget.IN_BACKGROUND");
                        $this$onVisibleCountChanged_u24lambda_u240_u240.setComponent(new ComponentName(it, HotListAppWidget.class.getName()));
                        it.sendBroadcast($this$onVisibleCountChanged_u24lambda_u240_u240);
                    }
                }

                @Override // tv.danmaku.bili.proc.ActivityCallBack.IPCActivityStateCallback
                public void onForegroundActivitiesChanged(Activity activity, int lastForegroundCount, int currentForegroundCount) {
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
        if (r1.equals("tv.danmaku.bili.action.appwidget.IN_BACKGROUND") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0083, code lost:
        if (r1.equals("tv.danmaku.bili.action.appwidget.RESTRICTED_MODE") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
        update(r9, r10);
     */
    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        BLog.e("HotListAppWidget", "onReceive " + intent);
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action.hashCode()) {
                case 172491798:
                    if (action.equals("android.intent.action.PACKAGE_CHANGED")) {
                        Uri data = intent.getData();
                        if (Intrinsics.areEqual(data != null ? data.getSchemeSpecificPart() : null, context.getPackageName())) {
                            update(context, intent);
                            break;
                        }
                    }
                    break;
                case 306886053:
                    break;
                case 759217646:
                    if (action.equals("tv.danmaku.bili.action.appwidget.EXCHANGE_CLICK")) {
                        SpUtilKt.incrementHotListPageNo(context);
                        update(context, intent);
                        tv.danmaku.bili.appwidget.hotlist.utils.ReportUtilKt.reportExchangeClick();
                        tv.danmaku.bili.appwidget.hotlist.utils.ReportUtilKt.reportWidgetClick$default("widget-card", "change", null, null, null, 28, null);
                        break;
                    }
                    break;
                case 1027655412:
                    if (action.equals("miui.appwidget.action.APPWIDGET_UPDATE")) {
                        SpUtilKt.resetHotListPageNo(context);
                        update(context, intent);
                        break;
                    }
                    break;
                case 1153049254:
                    break;
                case 1619576947:
                    if (action.equals("android.appwidget.action.APPWIDGET_UPDATE")) {
                        SpUtilKt.resetHotListPageNo(context);
                        break;
                    }
                    break;
            }
        }
        super.onReceive(context, intent);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        HotListAppWidgetUpdaterKt.update(context, "android.appwidget.action.APPWIDGET_UPDATE");
    }

    private final void update(Context context, Intent intent) {
        String it = intent.getAction();
        if (it != null) {
            HotListAppWidgetUpdaterKt.update(context, it);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        BLog.d("HotListAppWidget", "onDeleted");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        BLog.d("HotListAppWidget", "onAppWidgetOptionsChanged");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
        BLog.d("HotListAppWidget", "onEnabled");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
        BLog.d("HotListAppWidget", "onDisabled");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);
        BLog.d("HotListAppWidget", "onRestored");
    }
}