package tv.danmaku.biliplayer.preload.repository;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerItemCachePoolExt.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a,\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0080\bø\u0001\u0000\u001a,\u0010\t\u001a\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0080\bø\u0001\u0000\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"PRELOAD_POOL_TAG", "", "logI", "", "Lkotlinx/coroutines/CoroutineScope;", "throwable", "", "block", "Lkotlin/Function0;", "logW", "checkIndexOverflow", "", "index", "player-preload_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerItemCachePoolExtKt {
    public static final String PRELOAD_POOL_TAG = "PlayerItemCachePool";

    public static /* synthetic */ void logI$default(CoroutineScope $this$logI_u24default, Throwable throwable, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
        }
        Intrinsics.checkNotNullParameter($this$logI_u24default, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        CoroutineContext coroutineContext = $this$logI_u24default.getCoroutineContext();
        String name = Thread.currentThread().getName();
        BLog.i(PRELOAD_POOL_TAG, "log scope context: " + coroutineContext + ", thread:" + name + " \n " + block.invoke());
    }

    public static final void logI(CoroutineScope $this$logI, Throwable throwable, Function0<String> function0) {
        Intrinsics.checkNotNullParameter($this$logI, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        CoroutineContext coroutineContext = $this$logI.getCoroutineContext();
        String name = Thread.currentThread().getName();
        BLog.i(PRELOAD_POOL_TAG, "log scope context: " + coroutineContext + ", thread:" + name + " \n " + function0.invoke());
    }

    public static /* synthetic */ void logW$default(CoroutineScope $this$logW_u24default, Throwable throwable, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
        }
        Intrinsics.checkNotNullParameter($this$logW_u24default, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        CoroutineContext coroutineContext = $this$logW_u24default.getCoroutineContext();
        String name = Thread.currentThread().getName();
        BLog.w(PRELOAD_POOL_TAG, "log scope context: " + coroutineContext + ", thread:" + name + " \n " + block.invoke());
    }

    public static final void logW(CoroutineScope $this$logW, Throwable throwable, Function0<String> function0) {
        Intrinsics.checkNotNullParameter($this$logW, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        CoroutineContext coroutineContext = $this$logW.getCoroutineContext();
        String name = Thread.currentThread().getName();
        BLog.w(PRELOAD_POOL_TAG, "log scope context: " + coroutineContext + ", thread:" + name + " \n " + function0.invoke());
    }

    private static final int checkIndexOverflow(int index) {
        if (index < 0) {
            throw new ArithmeticException("Index overflow has happened.");
        }
        return index;
    }
}