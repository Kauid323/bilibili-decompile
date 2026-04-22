package tv.danmaku.biliplayer.preload.repository;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PreloadPool.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"playerCachePool", "Ltv/danmaku/biliplayer/preload/repository/PreloadPool;", "getPlayerCachePool", "()Ltv/danmaku/biliplayer/preload/repository/PreloadPool;", "playerCachePool$delegate", "Lkotlin/Lazy;", "player-preload_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PreloadPoolKt {
    private static final Lazy playerCachePool$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayer.preload.repository.PreloadPoolKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            PreloadPoolImpl playerCachePool_delegate$lambda$0;
            playerCachePool_delegate$lambda$0 = PreloadPoolKt.playerCachePool_delegate$lambda$0();
            return playerCachePool_delegate$lambda$0;
        }
    });

    public static final PreloadPool getPlayerCachePool() {
        return (PreloadPool) playerCachePool$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreloadPoolImpl playerCachePool_delegate$lambda$0() {
        return new PreloadPoolImpl();
    }
}