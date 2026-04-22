package tv.danmaku.biliplayerv2;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.service.IActivityStateService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerContainerCoroutine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X \u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/PlayerContainerCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "activityService", "Ltv/danmaku/biliplayerv2/service/IActivityStateService;", "getActivityService$biliplayerv2_debug", "()Ltv/danmaku/biliplayerv2/service/IActivityStateService;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class PlayerContainerCoroutineScope implements CoroutineScope {
    public abstract IActivityStateService getActivityService$biliplayerv2_debug();
}