package tv.danmaku.bili.appwidget.upcard.utils;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: WidgetSizeUtil.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004\u001a \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0004H\u0002\u001a \u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0004H\u0002\u001a \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"TAG", "", "getWidgetsSize", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "widgetId", "getWidgetWidth", "isPortrait", "", "getWidgetHeight", "getWidgetSizeInDp", "key", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class WidgetSizeUtilKt {
    private static final String TAG = "HotListWidgetSize";

    public static final Pair<Integer, Integer> getWidgetsSize(Context context, AppWidgetManager appWidgetManager, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        boolean isPortrait = context.getResources().getConfiguration().orientation == 1;
        Pair it = TuplesKt.to(Integer.valueOf(getWidgetWidth(appWidgetManager, isPortrait, widgetId)), Integer.valueOf(getWidgetHeight(appWidgetManager, isPortrait, widgetId)));
        BLog.d(TAG, "widget id:" + widgetId + " and width:" + it.getFirst() + " and height:" + it.getSecond());
        return it;
    }

    private static final int getWidgetWidth(AppWidgetManager appWidgetManager, boolean isPortrait, int widgetId) {
        if (isPortrait) {
            return getWidgetSizeInDp(appWidgetManager, widgetId, "appWidgetMinWidth");
        }
        return getWidgetSizeInDp(appWidgetManager, widgetId, "appWidgetMaxWidth");
    }

    private static final int getWidgetHeight(AppWidgetManager appWidgetManager, boolean isPortrait, int widgetId) {
        if (isPortrait) {
            return getWidgetSizeInDp(appWidgetManager, widgetId, "appWidgetMaxHeight");
        }
        return getWidgetSizeInDp(appWidgetManager, widgetId, "appWidgetMinHeight");
    }

    private static final int getWidgetSizeInDp(AppWidgetManager appWidgetManager, int widgetId, String key) {
        return appWidgetManager.getAppWidgetOptions(widgetId).getInt(key);
    }
}