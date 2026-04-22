package tv.danmaku.bili.appwidget.hotword;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import bili.resource.homepage.R;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.bus.Violet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.AutoAddResult;
import tv.danmaku.bili.appwidget.guide.function.FunctionWidgetUtilsKt;
import tv.danmaku.bili.appwidget.guide.utils.AppWidgetManagerUtil;
import tv.danmaku.bili.appwidget.hotlist.utils.ReportUtilKt;
import tv.danmaku.bili.appwidget.hotword.work.BiliWidgetWorkManager;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: HotWordAppWidget.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J.\u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/appwidget/hotword/HotWordAppWidget;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "onUpdate", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "onEnabled", "onDisabled", "onReceive", "intent", "Landroid/content/Intent;", "onAppWidgetOptionsChanged", "appWidgetId", "", "newOptions", "Landroid/os/Bundle;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotWordAppWidget extends AppWidgetProvider {
    public static final int $stable = 8;

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        HotWordAppWidgetUpdater.INSTANCE.updateWidgetWithCacheData(context);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLog.i("HotWordAppWidget", "onEnabled");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLog.i("HotWordAppWidget", "onDisabled");
        if (DelayTaskController.shouldBlock()) {
            return;
        }
        BiliWidgetWorkManager.Companion.cancelWork(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        BLog.e("HotWordAppWidget", "onReceive " + intent);
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action.hashCode()) {
                case -2101930256:
                    if (action.equals("tv.danmaku.bili.action.appwidget.AUTO_ADD_WIDGET")) {
                        String spmid = intent.getStringExtra(FavoritesConstsKt.SPMID);
                        if (spmid == null) {
                            spmid = "";
                        }
                        BLog.i("HotWordAppWidget", "AUTO_ADD_WIDGET " + spmid);
                        if (FunctionWidgetUtilsKt.enableFunctionGuideWidget()) {
                            Violet.INSTANCE.sendMsg(new AutoAddResult(spmid, "function", null));
                            break;
                        } else {
                            ReportUtilKt.reportAutoAddSuccess(spmid);
                            PromoToast.showMidToast(context.getApplicationContext(), R.string.homepage_global_string_37);
                            break;
                        }
                    }
                    break;
                case 1027655412:
                    if (action.equals("miui.appwidget.action.APPWIDGET_UPDATE")) {
                        HotWordAppWidgetUpdater.INSTANCE.updateWidgetWithCacheData(context);
                        break;
                    }
                    break;
            }
        }
        super.onReceive(context, intent);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        Bundle dataBundle;
        String autoPinAppWidget;
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        if (newOptions != null && (dataBundle = newOptions.getBundle(AppWidgetManagerUtil.KEY_WIDGET_EXTRA_DATA)) != null && (autoPinAppWidget = dataBundle.getString(AppWidgetManagerUtil.KEY_AUTO_PIN_APP_WIDGET)) != null) {
            String it = !StringsKt.isBlank(autoPinAppWidget) ? autoPinAppWidget : null;
            if (it != null) {
                Violet.INSTANCE.sendMsg(new AutoAddResult(it, "function", null));
            }
        }
    }
}