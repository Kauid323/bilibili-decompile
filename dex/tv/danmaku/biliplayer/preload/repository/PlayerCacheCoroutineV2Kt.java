package tv.danmaku.biliplayer.preload.repository;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerCacheCoroutineV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\u0007\u0010\u0003¨\u0006\t"}, d2 = {"cacheManagerDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCacheManagerDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "cacheManagerDispatcher$delegate", "Lkotlin/Lazy;", "cacheDispatcher", "getCacheDispatcher", "cacheDispatcher$delegate", "player-preload_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerCacheCoroutineV2Kt {
    private static final Lazy cacheManagerDispatcher$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayer.preload.repository.PlayerCacheCoroutineV2Kt$$ExternalSyntheticLambda0
        public final Object invoke() {
            MainCoroutineDispatcher cacheManagerDispatcher_delegate$lambda$0;
            cacheManagerDispatcher_delegate$lambda$0 = PlayerCacheCoroutineV2Kt.cacheManagerDispatcher_delegate$lambda$0();
            return cacheManagerDispatcher_delegate$lambda$0;
        }
    });
    private static final Lazy cacheDispatcher$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayer.preload.repository.PlayerCacheCoroutineV2Kt$$ExternalSyntheticLambda1
        public final Object invoke() {
            ExecutorCoroutineDispatcher cacheDispatcher_delegate$lambda$0;
            cacheDispatcher_delegate$lambda$0 = PlayerCacheCoroutineV2Kt.cacheDispatcher_delegate$lambda$0();
            return cacheDispatcher_delegate$lambda$0;
        }
    });

    public static final CoroutineDispatcher getCacheManagerDispatcher() {
        return (CoroutineDispatcher) cacheManagerDispatcher$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MainCoroutineDispatcher cacheManagerDispatcher_delegate$lambda$0() {
        return Dispatchers.getMain();
    }

    public static final CoroutineDispatcher getCacheDispatcher() {
        return (CoroutineDispatcher) cacheDispatcher$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExecutorCoroutineDispatcher cacheDispatcher_delegate$lambda$0() {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: tv.danmaku.biliplayer.preload.repository.PlayerCacheCoroutineV2Kt$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread cacheDispatcher_delegate$lambda$0$0;
                cacheDispatcher_delegate$lambda$0$0 = PlayerCacheCoroutineV2Kt.cacheDispatcher_delegate$lambda$0$0(runnable);
                return cacheDispatcher_delegate$lambda$0$0;
            }
        };
        ThreadPoolExecutor $this$cacheDispatcher_delegate_u24lambda_u240_u241 = new ThreadPoolExecutor(3, 5, 5L, TimeUnit.MINUTES, new LinkedBlockingQueue(), threadFactory);
        $this$cacheDispatcher_delegate_u24lambda_u240_u241.allowCoreThreadTimeOut(true);
        return ExecutorsKt.from($this$cacheDispatcher_delegate_u24lambda_u240_u241);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread cacheDispatcher_delegate$lambda$0$0(Runnable r) {
        Thread $this$cacheDispatcher_delegate_u24lambda_u240_u240_u240 = new Thread(r);
        $this$cacheDispatcher_delegate_u24lambda_u240_u240_u240.setName("player preload cache thread");
        return $this$cacheDispatcher_delegate_u24lambda_u240_u240_u240;
    }
}