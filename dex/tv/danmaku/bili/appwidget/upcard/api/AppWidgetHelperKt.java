package tv.danmaku.bili.appwidget.upcard.api;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.data.UpCardWidgetData;

/* compiled from: AppWidgetHelper.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "getUpCardWidgetApiData", "Ltv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppWidgetHelperKt {
    private static final String TAG = "AppWidgetHelper";

    public static final Object getUpCardWidgetApiData(Context context, Continuation<? super UpCardWidgetData> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AppWidgetHelperKt$getUpCardWidgetApiData$2(context, null), continuation);
    }
}