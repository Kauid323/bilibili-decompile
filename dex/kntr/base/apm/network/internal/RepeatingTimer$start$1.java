package kntr.base.apm.network.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepeatingTimer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.apm.network.internal.RepeatingTimer$start$1", f = "RepeatingTimer.kt", i = {0}, l = {ConstantsKt.PLAYING_ICON_UNIT_COUNT}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
public final class RepeatingTimer$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $intervalMillis;
    final /* synthetic */ Function0<Unit> $onStop;
    final /* synthetic */ Function1<Integer, Unit> $onTick;
    final /* synthetic */ int $repeatCount;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RepeatingTimer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatingTimer$start$1(long j, int i, RepeatingTimer repeatingTimer, Function1<? super Integer, Unit> function1, Function0<Unit> function0, Continuation<? super RepeatingTimer$start$1> continuation) {
        super(2, continuation);
        this.$intervalMillis = j;
        this.$repeatCount = i;
        this.this$0 = repeatingTimer;
        this.$onTick = function1;
        this.$onStop = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> repeatingTimer$start$1 = new RepeatingTimer$start$1(this.$intervalMillis, this.$repeatCount, this.this$0, this.$onTick, this.$onStop, continuation);
        repeatingTimer$start$1.L$0 = obj;
        return repeatingTimer$start$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x007d -> B:15:0x0080). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        RepeatingTimer$start$1 repeatingTimer$start$1;
        AtomicInt atomicInt;
        AtomicInt atomicInt2;
        Function0<Unit> function0;
        AtomicInt atomicInt3;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String currentProcessName = Utils_androidKt.getCurrentProcessName();
                long j = this.$intervalMillis;
                UtilsKt.logI("timer", "started on process<" + currentProcessName + "> -> interval=" + j + "ms, count=" + this.$repeatCount + ".");
                repeatingTimer$start$1 = this;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                repeatingTimer$start$1 = this;
                atomicInt3 = repeatingTimer$start$1.this$0.count;
                int current = atomicInt3.incrementAndGet();
                repeatingTimer$start$1.$onTick.invoke(Boxing.boxInt(current));
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        atomicInt = repeatingTimer$start$1.this$0.count;
        if (atomicInt.getValue() < repeatingTimer$start$1.$repeatCount || !CoroutineScopeKt.isActive($this$launch)) {
            atomicInt2 = repeatingTimer$start$1.this$0.count;
            int value = atomicInt2.getValue();
            UtilsKt.logI("timer", "end -> " + value + "/" + repeatingTimer$start$1.$repeatCount + ".");
            function0 = repeatingTimer$start$1.$onStop;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
        repeatingTimer$start$1.L$0 = $this$launch;
        repeatingTimer$start$1.label = 1;
        if (DelayKt.delay(repeatingTimer$start$1.$intervalMillis, (Continuation) repeatingTimer$start$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        atomicInt3 = repeatingTimer$start$1.this$0.count;
        int current2 = atomicInt3.incrementAndGet();
        repeatingTimer$start$1.$onTick.invoke(Boxing.boxInt(current2));
        atomicInt = repeatingTimer$start$1.this$0.count;
        if (atomicInt.getValue() < repeatingTimer$start$1.$repeatCount) {
        }
        atomicInt2 = repeatingTimer$start$1.this$0.count;
        int value2 = atomicInt2.getValue();
        UtilsKt.logI("timer", "end -> " + value2 + "/" + repeatingTimer$start$1.$repeatCount + ".");
        function0 = repeatingTimer$start$1.$onStop;
        if (function0 != null) {
        }
        return Unit.INSTANCE;
    }
}