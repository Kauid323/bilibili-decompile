package tv.danmaku.bili.ui.favorites.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RequestMode;
import com.bilibili.lib.blrouter.RouteRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FavRouterUtils.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"URL_PLAYSET_DETAIL", "", "URL_CREATE_FOLDER", "REQ_CODE_IN_FAVORITE_BOX", "", "REQ_CODE_CREATE_FOLDER", "routerToFavFolderList", "", "jumpLink", "fragment", "Landroidx/fragment/app/Fragment;", "routerToAddFolder", "context", "Landroid/content/Context;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavRouterUtilsKt {
    public static final int REQ_CODE_CREATE_FOLDER = 2333;
    public static final int REQ_CODE_IN_FAVORITE_BOX = 300;
    public static final String URL_CREATE_FOLDER = "activity://playset/box/create";
    public static final String URL_PLAYSET_DETAIL = "bilibili://user_center/favorites/folder/detail";

    public static final void routerToFavFolderList(String jumpLink, Fragment fragment) {
        Intrinsics.checkNotNullParameter(jumpLink, "jumpLink");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        BLRouter.routeTo(new RouteRequest.Builder(jumpLink).requestCode(300).build(), fragment);
    }

    public static final void routerToAddFolder(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activityResultLauncher, "launcher");
        Uri parse = Uri.parse(URL_CREATE_FOLDER);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        RouteRequest routeRequest = new RouteRequest.Builder(parse).requestCode((int) REQ_CODE_CREATE_FOLDER).build();
        Object obj = BLRouter.newCall(routeRequest, context, (Fragment) null, RequestMode.INTENT, false).execute().getObj();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.Intent");
        Intent intent = (Intent) obj;
        activityResultLauncher.launch(intent);
    }
}