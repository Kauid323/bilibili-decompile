package tv.danmaku.bili.ui.rank;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bilibili.lib.blrouter.BundleLike;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteInterceptor;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.ui.rank.router.RankRouter;

public class RankTabs implements RouteInterceptor {
    public RouteResponse intercept(RouteInterceptor.Chain chain) {
        int order_type;
        RouteRequest request = chain.getRequest();
        final Context context = chain.getContext();
        Uri uri = request.getPureUri();
        BundleLike extra = request.getExtras();
        String iosCompatType = null;
        try {
            iosCompatType = uri.getQueryParameter("type");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ("all".equals(iosCompatType)) {
            order_type = 1;
        } else if (RankRouter.RankConst.TYPE_ORIGINAL.equals(iosCompatType)) {
            order_type = 2;
        } else {
            order_type = parseParam(extra.get("order_type"), 1);
        }
        RouteRequest.Builder reqBuilder = request.newBuilder();
        if (order_type == 1) {
            reqBuilder.props(new Function1() { // from class: tv.danmaku.bili.ui.rank.RankTabs$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return RankTabs.lambda$intercept$0(context, (MutableBundleLike) obj);
                }
            });
        } else {
            final String title = context.getString(bili.resource.homepage.R.string.homepage_global_string_178);
            reqBuilder.props(new Function1() { // from class: tv.danmaku.bili.ui.rank.RankTabs$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return RankTabs.lambda$intercept$1(title, (MutableBundleLike) obj);
                }
            });
        }
        return chain.next(reqBuilder.build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$intercept$0(Context context, MutableBundleLike props) {
        props.put("ct.nav.title", context.getString(bili.resource.homepage.R.string.homepage_global_string_99));
        Bundle tabs = new Bundle();
        props.put("ct.tab.pages", tabs);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$intercept$1(String title, MutableBundleLike props) {
        props.put("ct.nav.title", title);
        Bundle tabs = new Bundle();
        props.put("ct.tab.pages", tabs);
        return null;
    }

    private int parseParam(String param, int def) {
        if (TextUtils.isEmpty(param)) {
            return def;
        }
        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
            return def;
        }
    }
}