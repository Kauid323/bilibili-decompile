package kntr.base.net.comm.flowcontrol.internal.model;

import java.util.HashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
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
@DebugMetadata(c = "kntr.base.net.comm.flowcontrol.internal.model.Policies$unblock$1", f = "Policies.kt", i = {0, 0}, l = {103}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "I$0"}, v = 1)
public final class Policies$unblock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $host;
    final /* synthetic */ String $key;
    final /* synthetic */ String $path;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ Policies this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Policies$unblock$1(Policies policies, String str, String str2, String str3, Continuation<? super Policies$unblock$1> continuation) {
        super(2, continuation);
        this.this$0 = policies;
        this.$key = str;
        this.$host = str2;
        this.$path = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Policies$unblock$1(this.this$0, this.$key, this.$host, this.$path, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Mutex $this$withLock_u24default$iv;
        Policies policies;
        String str;
        String str2;
        String str3;
        Object owner$iv;
        Map map;
        Map map2;
        EventListener eventListener;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$withLock_u24default$iv = this.this$0.mutex;
                policies = this.this$0;
                str = this.$key;
                str2 = this.$host;
                str3 = this.$path;
                owner$iv = null;
                this.L$0 = $this$withLock_u24default$iv;
                this.L$1 = policies;
                this.L$2 = str;
                this.L$3 = str2;
                this.L$4 = str3;
                this.I$0 = 0;
                this.label = 1;
                if ($this$withLock_u24default$iv.lock((Object) null, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                int i = this.I$0;
                str3 = (String) this.L$4;
                str2 = (String) this.L$3;
                str = (String) this.L$2;
                policies = (Policies) this.L$1;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            map = policies.map;
            if (map.containsKey(str)) {
                HashMap newValue = new HashMap();
                map2 = policies.map;
                newValue.putAll(map2);
                if (((BlockPolicy) newValue.remove(str)) != null) {
                    KLog_androidKt.getKLog().i("net.flowcontrol.policy", "Unblock " + str2 + str3);
                    eventListener = policies.tracker;
                    eventListener.unblock(str2, str3);
                }
                policies.map = newValue;
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