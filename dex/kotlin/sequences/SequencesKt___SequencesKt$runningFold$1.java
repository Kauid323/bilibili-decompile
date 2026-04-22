package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: _Sequences.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2423, 2427}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "element"}, nl = {2424, 2429}, s = {"L$0", "L$0", "L$1", "L$3"}, v = 2)
public final class SequencesKt___SequencesKt$runningFold$1<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ R $initial;
    final /* synthetic */ Function2<R, T, R> $operation;
    final /* synthetic */ Sequence<T> $this_runningFold;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningFold$1(R r, Sequence<? extends T> sequence, Function2<? super R, ? super T, ? extends R> function2, Continuation<? super SequencesKt___SequencesKt$runningFold$1> continuation) {
        super(2, continuation);
        this.$initial = r;
        this.$this_runningFold = sequence;
        this.$operation = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1 = new SequencesKt___SequencesKt$runningFold$1(this.$initial, this.$this_runningFold, this.$operation, continuation);
        sequencesKt___SequencesKt$runningFold$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFold$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SequenceScope) ((SequenceScope) obj), continuation);
    }

    public final Object invoke(SequenceScope<? super R> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$runningFold$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x006c -> B:18:0x0070). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        R r;
        Iterator it;
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1;
        Object obj;
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$12;
        SequenceScope $this$sequence = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$sequence;
                this.label = 1;
                if ($this$sequence.yield(this.$initial, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                r = this.$initial;
                it = this.$this_runningFold.iterator();
                sequencesKt___SequencesKt$runningFold$1 = this;
                if (!it.hasNext()) {
                    Object element = it.next();
                    Object accumulator = sequencesKt___SequencesKt$runningFold$1.$operation.invoke(r, element);
                    sequencesKt___SequencesKt$runningFold$1.L$0 = $this$sequence;
                    sequencesKt___SequencesKt$runningFold$1.L$1 = accumulator;
                    sequencesKt___SequencesKt$runningFold$1.L$2 = it;
                    sequencesKt___SequencesKt$runningFold$1.L$3 = SpillingKt.nullOutSpilledVariable(element);
                    sequencesKt___SequencesKt$runningFold$1.label = 2;
                    if ($this$sequence.yield(accumulator, sequencesKt___SequencesKt$runningFold$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$13 = sequencesKt___SequencesKt$runningFold$1;
                    obj = accumulator;
                    sequencesKt___SequencesKt$runningFold$12 = sequencesKt___SequencesKt$runningFold$13;
                    r = obj;
                    sequencesKt___SequencesKt$runningFold$1 = sequencesKt___SequencesKt$runningFold$12;
                    if (!it.hasNext()) {
                        return Unit.INSTANCE;
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                r = this.$initial;
                it = this.$this_runningFold.iterator();
                sequencesKt___SequencesKt$runningFold$1 = this;
                if (!it.hasNext()) {
                }
                break;
            case 2:
                Object obj2 = this.L$3;
                it = (Iterator) this.L$2;
                obj = this.L$1;
                ResultKt.throwOnFailure($result);
                sequencesKt___SequencesKt$runningFold$12 = this;
                r = obj;
                sequencesKt___SequencesKt$runningFold$1 = sequencesKt___SequencesKt$runningFold$12;
                if (!it.hasNext()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}