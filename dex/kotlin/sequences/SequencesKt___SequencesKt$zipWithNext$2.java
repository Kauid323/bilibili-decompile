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
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0, 0}, l = {2979}, m = "invokeSuspend", n = {"$this$result", "iterator", "current", "next"}, nl = {2980}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
public final class SequencesKt___SequencesKt$zipWithNext$2<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Sequence<T> $this_zipWithNext;
    final /* synthetic */ Function2<T, T, R> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$zipWithNext$2(Sequence<? extends T> sequence, Function2<? super T, ? super T, ? extends R> function2, Continuation<? super SequencesKt___SequencesKt$zipWithNext$2> continuation) {
        super(2, continuation);
        this.$this_zipWithNext = sequence;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.$this_zipWithNext, this.$transform, continuation);
        sequencesKt___SequencesKt$zipWithNext$2.L$0 = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SequenceScope) ((SequenceScope) obj), continuation);
    }

    public final Object invoke(SequenceScope<? super R> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0065 -> B:18:0x006a). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object current;
        Iterator iterator;
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2;
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$22;
        Object next;
        Iterator iterator2;
        SequenceScope $this$result = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterator iterator3 = this.$this_zipWithNext.iterator();
                if (iterator3.hasNext()) {
                    current = iterator3.next();
                    iterator = iterator3;
                    sequencesKt___SequencesKt$zipWithNext$2 = this;
                    break;
                } else {
                    return Unit.INSTANCE;
                }
            case 1:
                next = this.L$3;
                Object obj = this.L$2;
                ResultKt.throwOnFailure($result);
                iterator2 = (Iterator) this.L$1;
                sequencesKt___SequencesKt$zipWithNext$22 = this;
                iterator = iterator2;
                SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$23 = sequencesKt___SequencesKt$zipWithNext$22;
                current = next;
                sequencesKt___SequencesKt$zipWithNext$2 = sequencesKt___SequencesKt$zipWithNext$23;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!iterator.hasNext()) {
            Object next2 = iterator.next();
            sequencesKt___SequencesKt$zipWithNext$2.L$0 = $this$result;
            sequencesKt___SequencesKt$zipWithNext$2.L$1 = iterator;
            sequencesKt___SequencesKt$zipWithNext$2.L$2 = SpillingKt.nullOutSpilledVariable(current);
            sequencesKt___SequencesKt$zipWithNext$2.L$3 = next2;
            sequencesKt___SequencesKt$zipWithNext$2.label = 1;
            if ($this$result.yield(sequencesKt___SequencesKt$zipWithNext$2.$transform.invoke(current, next2), sequencesKt___SequencesKt$zipWithNext$2) == coroutine_suspended) {
                return coroutine_suspended;
            }
            sequencesKt___SequencesKt$zipWithNext$22 = sequencesKt___SequencesKt$zipWithNext$2;
            next = next2;
            iterator2 = iterator;
            iterator = iterator2;
            SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$232 = sequencesKt___SequencesKt$zipWithNext$22;
            current = next;
            sequencesKt___SequencesKt$zipWithNext$2 = sequencesKt___SequencesKt$zipWithNext$232;
            if (!iterator.hasNext()) {
                return Unit.INSTANCE;
            }
        }
    }
}