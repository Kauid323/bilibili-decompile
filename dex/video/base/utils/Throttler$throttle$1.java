package video.base.utils;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicLong;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Throttler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.base.utils.Throttler$throttle$1", f = "Throttler.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3}, l = {57, 67, 32, DynModuleType.module_onetime_notice_VALUE}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "now", "$i$f$withLock", "time", "atomic", "$this$withLock_u24default$iv", "now", "$i$f$withLock", "time", "atomic", "now", "time", "now"}, s = {"L$0", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "L$1", "J$0", "L$0", "J$0"}, v = 1)
public final class Throttler$throttle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ String $key;
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ Throttler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Throttler$throttle$1(Throttler throttler, Function1<? super Continuation<? super Unit>, ? extends Object> function1, String str, Continuation<? super Throttler$throttle$1> continuation) {
        super(2, continuation);
        this.this$0 = throttler;
        this.$block = function1;
        this.$key = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Throttler$throttle$1(this.this$0, this.$block, this.$key, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        long now;
        Mutex $this$withLock_u24default$iv;
        Throttler throttler;
        String str;
        Object owner$iv;
        Mutex $this$withLock_u24default$iv2;
        AtomicLong owner$iv2;
        Map map;
        AtomicLong time;
        long j;
        AtomicLong time2;
        long now2;
        AtomicLong atomic;
        Throttler throttler2;
        String str2;
        AtomicLong time3;
        Map map2;
        Function1<Continuation<? super Unit>, Object> function1;
        long now3;
        AtomicLong time4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                now = DateKt.getCurrentTimeMillis();
                $this$withLock_u24default$iv = this.this$0.mutex;
                throttler = this.this$0;
                str = this.$key;
                owner$iv = null;
                this.L$0 = $this$withLock_u24default$iv;
                this.L$1 = throttler;
                this.L$2 = str;
                this.J$0 = now;
                this.I$0 = 0;
                this.label = 1;
                if ($this$withLock_u24default$iv.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                try {
                    map = throttler.timeMap;
                    time = (AtomicLong) map.get(str);
                    if (time == null) {
                        j = this.this$0.timeout;
                        if (now - time.getValue() > j) {
                            time.lazySet(now);
                            Function1<Continuation<? super Unit>, Object> function12 = this.$block;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(time);
                            this.L$1 = null;
                            this.L$2 = null;
                            this.J$0 = now;
                            this.label = 4;
                            if (function12.invoke(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            time2 = time;
                            now2 = now;
                        }
                        return Unit.INSTANCE;
                    }
                    atomic = AtomicFU.atomic(now);
                    $this$withLock_u24default$iv2 = this.this$0.mutex;
                    throttler2 = this.this$0;
                    str2 = this.$key;
                    owner$iv2 = null;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(time);
                    this.L$1 = atomic;
                    this.L$2 = $this$withLock_u24default$iv2;
                    this.L$3 = throttler2;
                    this.L$4 = str2;
                    this.J$0 = now;
                    this.I$0 = 0;
                    this.label = 2;
                    if ($this$withLock_u24default$iv2.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    time3 = time;
                    try {
                        map2 = throttler2.timeMap;
                        map2.put(str2, atomic);
                        Unit unit = Unit.INSTANCE;
                        $this$withLock_u24default$iv2.unlock(owner$iv2);
                        function1 = this.$block;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(time3);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(atomic);
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.J$0 = now;
                        this.label = 3;
                        if (function1.invoke(this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        now3 = now;
                        time4 = time3;
                        return Unit.INSTANCE;
                    } finally {
                    }
                } finally {
                }
            case 1:
                int $i$f$withLock = this.I$0;
                now = this.J$0;
                str = (String) this.L$2;
                throttler = (Throttler) this.L$1;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) this.L$0;
                ResultKt.throwOnFailure($result);
                map = throttler.timeMap;
                time = (AtomicLong) map.get(str);
                if (time == null) {
                }
                break;
            case 2:
                long now4 = this.I$0;
                now = this.J$0;
                throttler2 = (Throttler) this.L$3;
                $this$withLock_u24default$iv2 = (Mutex) this.L$2;
                time3 = (AtomicLong) this.L$0;
                ResultKt.throwOnFailure($result);
                str2 = (String) this.L$4;
                atomic = (AtomicLong) this.L$1;
                owner$iv2 = null;
                map2 = throttler2.timeMap;
                map2.put(str2, atomic);
                Unit unit2 = Unit.INSTANCE;
                $this$withLock_u24default$iv2.unlock(owner$iv2);
                function1 = this.$block;
                this.L$0 = SpillingKt.nullOutSpilledVariable(time3);
                this.L$1 = SpillingKt.nullOutSpilledVariable(atomic);
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.J$0 = now;
                this.label = 3;
                if (function1.invoke(this) != coroutine_suspended) {
                }
                break;
            case 3:
                now3 = this.J$0;
                AtomicLong atomicLong = (AtomicLong) this.L$1;
                time4 = (AtomicLong) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 4:
                now2 = this.J$0;
                time2 = (AtomicLong) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}