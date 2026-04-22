package kntr.base.net.comm.flowcontrol.internal.model;

import java.util.HashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.flowcontrol.internal.protocol.RetryAfterKt;
import kntr.base.net.comm.flowcontrol.internal.tracker.EventListener;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Policies.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.net.comm.flowcontrol.internal.model.Policies$block$1", f = "Policies.kt", i = {0, 0}, l = {103}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "I$1"}, v = 1)
public final class Policies$block$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $host;
    final /* synthetic */ String $key;
    final /* synthetic */ String $path;
    final /* synthetic */ int $retryAfter;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ Policies this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Policies$block$1(Policies policies, String str, String str2, int i, String str3, Continuation<? super Policies$block$1> continuation) {
        super(2, continuation);
        this.this$0 = policies;
        this.$host = str;
        this.$path = str2;
        this.$retryAfter = i;
        this.$key = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Policies$block$1(this.this$0, this.$host, this.$path, this.$retryAfter, this.$key, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Mutex $this$withLock_u24default$iv;
        int i;
        Policies policies;
        String str;
        Object owner$iv;
        String str2;
        String str3;
        Map map;
        EventListener eventListener;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$withLock_u24default$iv = this.this$0.mutex;
                String str4 = this.$host;
                String str5 = this.$path;
                i = this.$retryAfter;
                policies = this.this$0;
                str = this.$key;
                owner$iv = null;
                this.L$0 = $this$withLock_u24default$iv;
                this.L$1 = str4;
                this.L$2 = str5;
                this.L$3 = policies;
                this.L$4 = str;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 1;
                if ($this$withLock_u24default$iv.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str2 = str5;
                str3 = str4;
                break;
            case 1:
                int i2 = this.I$1;
                i = this.I$0;
                str = (String) this.L$4;
                policies = (Policies) this.L$3;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) this.L$0;
                ResultKt.throwOnFailure($result);
                str2 = (String) this.L$2;
                str3 = (String) this.L$1;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            BlockPolicy policy = new BlockPolicy(str3, str2, RetryAfterKt.blockPolicy(str3, str2, i));
            policy.update();
            HashMap newValue = new HashMap();
            map = policies.map;
            newValue.putAll(map);
            newValue.put(str, policy);
            policies.map = newValue;
            ILogger kLog = KLog_androidKt.getKLog();
            long duration = policy.getDuration();
            kLog.w("net.flowcontrol.policy", "Block " + str3 + str2 + " for " + duration + " ms " + policy.getUpdate() + " time");
            eventListener = policies.tracker;
            eventListener.block(str3, str2, policy.getDuration(), policy.getUpdate());
            Unit unit = Unit.INSTANCE;
            $this$withLock_u24default$iv.unlock(owner$iv);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
    }
}