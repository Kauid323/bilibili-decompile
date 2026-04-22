package tv.danmaku.bili.quick.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import com.bilibili.lib.blrouter.RouteInterceptor;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.blrouter.RouteResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.PResult;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: BottomSheetStyleInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/quick/ui/BottomSheetStyleInterceptor;", "Lcom/bilibili/lib/blrouter/RouteInterceptor;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lcom/bilibili/lib/blrouter/RouteResponse;", "chain", "Lcom/bilibili/lib/blrouter/RouteInterceptor$Chain;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BottomSheetStyleInterceptor implements RouteInterceptor {
    public static final int $stable = 0;

    public RouteResponse intercept(RouteInterceptor.Chain chain) {
        Configuration configuration;
        Intrinsics.checkNotNullParameter(chain, "chain");
        PResult pResult = OnlineParamsHelper.appOnepassMode();
        Resources resources = chain.getContext().getResources();
        boolean isBottomStyle = true;
        int orientation = (resources == null || (configuration = resources.getConfiguration()) == null) ? 1 : configuration.orientation;
        isBottomStyle = (pResult.getExist() && Intrinsics.areEqual(pResult.getResult(), true) && orientation == 1) ? false : false;
        RouteRequest originRequest = chain.getRequest();
        if (isBottomStyle) {
            Uri uri = Uri.parse("bilibili://login/quick/bottomsheet");
            RouteRequest.Builder request = chain.getRequest().newBuilder();
            Intrinsics.checkNotNull(uri);
            request.setTargetUri(uri);
            return RouteRequestKt.redirectTo(originRequest, request.build());
        }
        return chain.next(chain.getRequest());
    }
}