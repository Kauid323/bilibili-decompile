package video.base.utils;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Throttler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.base.utils.Throttler$remove$1", f = "Throttler.kt", i = {0, 0}, l = {57}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "I$0"}, v = 1)
public final class Throttler$remove$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $keys;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Throttler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Throttler$remove$1(Throttler throttler, List<String> list, Continuation<? super Throttler$remove$1> continuation) {
        super(2, continuation);
        this.this$0 = throttler;
        this.$keys = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Throttler$remove$1(this.this$0, this.$keys, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Mutex $this$withLock_u24default$iv;
        Iterable iterable;
        Throttler throttler;
        Object owner$iv;
        Map map;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$withLock_u24default$iv = this.this$0.mutex;
                iterable = this.$keys;
                throttler = this.this$0;
                owner$iv = null;
                this.L$0 = $this$withLock_u24default$iv;
                this.L$1 = iterable;
                this.L$2 = throttler;
                this.I$0 = 0;
                this.label = 1;
                if ($this$withLock_u24default$iv.lock((Object) null, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                int i = this.I$0;
                throttler = (Throttler) this.L$2;
                iterable = (List) this.L$1;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String) element$iv;
                map = throttler.timeMap;
                map.remove(it);
            }
            Unit unit = Unit.INSTANCE;
            $this$withLock_u24default$iv.unlock(owner$iv);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
    }
}