package im.base;

import com.bapis.bilibili.broadcast.message.im.KNotifyRsp;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: IMBroadcastManager.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lim/base/IMBroadcastPlatformServiceImpl;", "Lim/base/IMBroadCastPlatformService;", "<init>", "()V", "startFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bapis/bilibili/broadcast/message/im/KNotifyRsp;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMBroadcastPlatformServiceImpl implements IMBroadCastPlatformService {
    @Override // im.base.IMBroadCastPlatformService
    public Flow<KNotifyRsp> startFlow() {
        return FlowKt.callbackFlow(new IMBroadcastPlatformServiceImpl$startFlow$1(null));
    }
}