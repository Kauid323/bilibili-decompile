package tv.danmaku.bili.utils.vip;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class VipRoutes {
    public static final String ROUTER_MAIN_VIP_WEB_ACTIVITY = "activity://main/vip-web/";
    @Deprecated
    public static final String URI_BILIBILI_VIP = "bilibili://vip";
    public static final String VIP_BUY_APP_ID = "appId";
    public static final String VIP_BUY_ORDER_REPORT_PARAMS = "order_report_params";
    public static final String VIP_BUY_SOURCE_FROM = "source_from";
    public static final String VIP_BUY_SUB_ID = "appSubId";
    public static final String VIP_INDEX_URL = "https://big.bilibili.com/mobile/index";

    public static void openH5(Context context, final String url) {
        RouteRequest vipRequest = new RouteRequest.Builder(Uri.parse(ROUTER_MAIN_VIP_WEB_ACTIVITY)).extras(new Function1() { // from class: tv.danmaku.bili.utils.vip.VipRoutes$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return VipRoutes.lambda$openH5$0(url, (MutableBundleLike) obj);
            }
        }).build();
        BLRouter.routeTo(vipRequest, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$openH5$0(String url, MutableBundleLike mutableBundleLike) {
        if (!TextUtils.isEmpty(url)) {
            mutableBundleLike.put("uri", url);
            return null;
        }
        return null;
    }
}