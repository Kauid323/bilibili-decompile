package tv.danmaku.biliplayer.preload.repository;

import com.bilibili.lib.coroutineextension.DispatchersKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerCacheCoroutine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"preloadDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getPreloadDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "player-preload_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerCacheCoroutineKt {
    public static final CoroutineDispatcher getPreloadDispatcher() {
        return DispatchersKt.getBiliIODispatcher();
    }
}