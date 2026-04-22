package kntr.app.appwidget.guide.utils;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppWidgetManager.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"TAG", RoomRecommendViewModel.EMPTY_CURSOR, "checkAddAppWidgetRequest", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Landroidx/fragment/app/FragmentActivity;", "Lkntr/app/appwidget/guide/PlatformContext;", "component", "isWidgetAdded", "Landroid/content/Context;", "widgetClass", "guide_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppWidgetManager_androidKt {
    private static final String TAG = "AppWidgetManager";

    public static final boolean checkAddAppWidgetRequest(FragmentActivity context, String component) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(component, "component");
        if (Build.VERSION.SDK_INT < 26) {
            KLog_androidKt.getKLog().i(TAG, "checkAddAppWidgetRequest -> unsupported version");
            return false;
        }
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance((Context) context);
        if (!appWidgetManager.isRequestPinAppWidgetSupported()) {
            KLog_androidKt.getKLog().i(TAG, "checkAddAppWidgetRequest -> pin widget not supported");
            return false;
        } else if (isWidgetAdded((Context) context, component)) {
            KLog_androidKt.getKLog().i(TAG, "checkAddAppWidgetRequest -> widget added");
            return false;
        } else {
            return true;
        }
    }

    private static final boolean isWidgetAdded(Context context, String widgetClass) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName componentName = new ComponentName(context, widgetClass);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(componentName);
        Intrinsics.checkNotNull(appWidgetIds);
        return !(appWidgetIds.length == 0);
    }
}