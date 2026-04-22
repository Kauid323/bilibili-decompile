package tv.danmaku.bili.videopage.common.helper;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.router.Router;
import tv.danmaku.bili.ui.rank.router.RankRouter;

@Deprecated
public class IntentHelper {
    public static final String ROUTE_URI_BILI_VIDEO_DETAIL = "bilibili://video/:avid/";

    public static void intentToLive(Context context, String routeUrl) {
        if (!TextUtils.isEmpty(routeUrl)) {
            Uri uri = Uri.parse(routeUrl).buildUpon().build();
            RouteRequest request = new RouteRequest.Builder(uri).build();
            BLRouter.routeTo(request, context);
        }
    }

    public static void goToAuthorSpaceForResult(Context context, long mid, String name, String from, String tab, String avid, int requestCode) {
        RouteRequest.Builder builder = new RouteRequest.Builder(Uri.parse("bilibili://space/:mid/"));
        builder.getExtras().put(RankRouter.BundleKey.AUTHOR_SPACE_MID, String.valueOf(mid));
        builder.getExtras().put("name", name);
        builder.getExtras().put("from", from);
        builder.getExtras().put("defaultTab", tab);
        builder.getExtras().put("avid", avid);
        builder.requestCode(requestCode);
        BLRouter.routeTo(builder.build(), context);
    }

    public static void intentTo(Context context, Uri uri) {
        intentTo(context, uri, true);
    }

    public static void intentTo(Context context, Uri uri, boolean onlyBili) {
        BLRouter.routeTo(new RouteRequest.Builder(uri).build(), context);
    }

    public static void intentTo(Context context, long aid, int from, String fromSpmid) {
        Router.global().with(context).with("avid", String.valueOf(aid)).with("jumpFrom", String.valueOf(from)).with("from_spmid", fromSpmid).open(ROUTE_URI_BILI_VIDEO_DETAIL);
    }
}