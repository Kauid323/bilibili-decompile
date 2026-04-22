package tv.danmaku.bili.ui.personinfo.modifyNameV2;

import com.bilibili.lib.blrouter.RouteInterceptor;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.personinfo.PersonInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PersonInfoModifyNameRedirectInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/PersonInfoModifyNameRedirectInterceptor;", "Lcom/bilibili/lib/blrouter/RouteInterceptor;", "<init>", "()V", "intercept", "Lcom/bilibili/lib/blrouter/RouteResponse;", "chain", "Lcom/bilibili/lib/blrouter/RouteInterceptor$Chain;", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PersonInfoModifyNameRedirectInterceptor implements RouteInterceptor {
    public static final int $stable = 0;

    public RouteResponse intercept(RouteInterceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        boolean isEnableFreeCoinsChangeNickName = DeviceDecision.INSTANCE.getBoolean("free_coins_change_nick_name", false);
        if (!isEnableFreeCoinsChangeNickName) {
            return chain.next(chain.getRequest());
        }
        return RouteRequestKt.redirectTo(chain.getRequest(), RouteRequestKt.toRouteRequest(PersonInfo.URI_PERSONINFO_MODIFY_NAME_ACTIVITY2));
    }
}