package tv.danmaku.bili.utils;

import android.content.Context;
import android.net.Uri;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;

public class PersonInfoHelper {
    public static void intentTo(Context context, Uri uri, boolean onlyBili) {
        BLRouter.routeTo(RouteRequestKt.toRouteRequest(uri), context);
    }
}