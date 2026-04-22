package im.base;

import com.bapis.bilibili.broadcast.message.im.KNotifyRsp;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IMBroadcastManager.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lim/base/IMBroadCastPlatformService;", "", "startFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bapis/bilibili/broadcast/message/im/KNotifyRsp;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMBroadCastPlatformService {
    Flow<KNotifyRsp> startFlow();
}