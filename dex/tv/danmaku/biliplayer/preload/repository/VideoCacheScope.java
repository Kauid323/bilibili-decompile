package tv.danmaku.biliplayer.preload.repository;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerCacheCoroutineV2.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/VideoCacheScope;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoCacheScope implements CoroutineScope {
    public static final VideoCacheScope INSTANCE = new VideoCacheScope();
    private static final CoroutineContext context = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(PlayerCacheCoroutineV2Kt.getCacheDispatcher());
    private static final CoroutineContext coroutineContext = context;

    private VideoCacheScope() {
    }

    public CoroutineContext getCoroutineContext() {
        return coroutineContext;
    }
}