package video.base.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicLong;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Throttler.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lvideo/base/utils/Throttler;", "", "timeout", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(JLkotlinx/coroutines/CoroutineScope;)V", "timeMap", "", "", "Lkotlinx/atomicfu/AtomicLong;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "throttle", "", "key", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "remove", "keys", "", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Throttler {
    public static final int $stable = 8;
    private final Mutex mutex;
    private final CoroutineScope scope;
    private Map<String, AtomicLong> timeMap;
    private final long timeout;

    public Throttler(long timeout, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.timeout = timeout;
        this.scope = scope;
        this.timeMap = new LinkedHashMap();
        this.mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    public final void throttle(String key, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function1, "block");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new Throttler$throttle$1(this, function1, key, null), 3, (Object) null);
    }

    public final void remove(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "keys");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new Throttler$remove$1(this, list, null), 3, (Object) null);
    }
}