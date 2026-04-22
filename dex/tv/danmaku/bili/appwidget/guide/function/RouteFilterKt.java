package tv.danmaku.bili.appwidget.guide.function;

import android.app.Activity;
import android.net.Uri;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MatchedRoutes;
import com.bilibili.lib.blrouter.RouteInfo;
import com.bilibili.lib.blrouter.RouteRequest;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: RouteFilter.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\b\u0010\t\u001a\u00020\nH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"TAG", "", "whiteUrlList", "", "routeWhiteList", "validRouteFilter", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "updateRouteWhiteList", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RouteFilterKt {
    private static final String TAG = "RouteFilter";
    private static final Set<String> whiteUrlList = SetsKt.mutableSetOf(new String[]{"bilibili://main/favorite", "bilibili://united_video", "bilibili://user_center/favourite2", "bilibili://music/playlist/playpage/0"});
    private static final Set<String> routeWhiteList = SetsKt.mutableSetOf(new String[]{"GeneralActivity"});

    public static final boolean validRouteFilter(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Iterable $this$forEach$iv = routeWhiteList;
        for (Object element$iv : $this$forEach$iv) {
            String item = (String) element$iv;
            String className = activity.getComponentName().getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            if (StringsKt.contains(className, item, true)) {
                return true;
            }
        }
        return false;
    }

    public static final void updateRouteWhiteList() {
        Iterable $this$forEach$iv;
        Iterable $this$forEach$iv2 = whiteUrlList;
        for (Object element$iv : $this$forEach$iv2) {
            String url = (String) element$iv;
            RouteRequest routeRequest = new RouteRequest.Builder(Uri.parse(url)).build();
            MatchedRoutes matches = BLRouter.findRoutes(routeRequest);
            for (Object element$iv2 : matches.getInfo()) {
                RouteInfo routeInfo = (RouteInfo) element$iv2;
                try {
                    routeWhiteList.add(routeInfo.getClazz().getName());
                    $this$forEach$iv = $this$forEach$iv2;
                } catch (Exception e) {
                    $this$forEach$iv = $this$forEach$iv2;
                    BLog.e(TAG, "updateRouteWhiteList -> error: " + e);
                }
                $this$forEach$iv2 = $this$forEach$iv;
            }
        }
    }
}