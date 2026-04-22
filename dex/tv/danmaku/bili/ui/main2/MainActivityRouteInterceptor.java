package tv.danmaku.bili.ui.main2;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.RouteInterceptor;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: MainActivityRouteInterceptor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/main2/MainActivityRouteInterceptor;", "Lcom/bilibili/lib/blrouter/RouteInterceptor;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lcom/bilibili/lib/blrouter/RouteResponse;", "chain", "Lcom/bilibili/lib/blrouter/RouteInterceptor$Chain;", "isAddFlagEnable", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MainActivityRouteInterceptor implements RouteInterceptor {
    public static final int $stable = 0;

    public RouteResponse intercept(RouteInterceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RouteRequest originReq = chain.getRequest();
        try {
            if (isAddFlagEnable() && originReq.getFlags() == 0) {
                RouteRequest.Builder reqBuilder = originReq.newBuilder();
                reqBuilder.flags(603979776);
                BLog.i("MainActivityRouteInterceptor", "add singleTask flag");
                return chain.next(reqBuilder.build());
            }
            return chain.next(originReq);
        } catch (Exception e) {
            BLog.e("MainActivityRouteInterceptor", "add flag error", e);
            return chain.next(originReq);
        }
    }

    private final boolean isAddFlagEnable() {
        return Intrinsics.areEqual("1", ConfigManager.Companion.config().get("main.add_main_page_flag", "1"));
    }
}