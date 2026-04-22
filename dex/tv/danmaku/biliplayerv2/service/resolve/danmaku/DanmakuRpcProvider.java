package tv.danmaku.biliplayerv2.service.resolve.danmaku;

import com.bapis.bilibili.community.service.dm.v1.DmViewReq;
import com.bilibili.lib.coldstart.api.ColdStartReqProvider;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuRpcProvider.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/danmaku/DanmakuRpcProvider;", "Lcom/bilibili/lib/coldstart/api/ColdStartReqProvider;", "Lcom/bapis/bilibili/community/service/dm/v1/DmViewReq;", "<init>", "()V", "getGrpcReq", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Named("dm_view")
public final class DanmakuRpcProvider implements ColdStartReqProvider<DmViewReq> {
    public /* synthetic */ Map toByteArrayMap() {
        return ColdStartReqProvider.-CC.$default$toByteArrayMap(this);
    }

    /* renamed from: getGrpcReq */
    public DmViewReq m2289getGrpcReq() {
        return DanmakuRpcWrapper.getDefaultDanmakuViewReq();
    }
}