package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Sequences.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0, 0, 0}, l = {383}, m = "invokeSuspend", n = {"$this$sequence", "element", "result", "index"}, nl = {385}, s = {"L$0", "L$2", "L$3", "I$0"}, v = 2)
public final class SequencesKt__SequencesKt$flatMapIndexed$1<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<C, Iterator<R>> $iterator;
    final /* synthetic */ Sequence<T> $source;
    final /* synthetic */ Function2<Integer, T, C> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt__SequencesKt$flatMapIndexed$1(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends C> function2, Function1<? super C, ? extends Iterator<? extends R>> function1, Continuation<? super SequencesKt__SequencesKt$flatMapIndexed$1> continuation) {
        super(2, continuation);
        this.$source = sequence;
        this.$transform = function2;
        this.$iterator = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, continuation);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SequenceScope) ((SequenceScope) obj), continuation);
    }

    public final Object invoke(SequenceScope<? super R> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0074 -> B:17:0x0079). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int index;
        Iterator it;
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1;
        Iterator it2;
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$12;
        SequenceScope $this$sequence = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                index = 0;
                it = this.$source.iterator();
                sequencesKt__SequencesKt$flatMapIndexed$1 = this;
                break;
            case 1:
                index = this.I$0;
                Object obj = this.L$3;
                Object obj2 = this.L$2;
                ResultKt.throwOnFailure($result);
                it2 = (Iterator) this.L$1;
                sequencesKt__SequencesKt$flatMapIndexed$12 = this;
                sequencesKt__SequencesKt$flatMapIndexed$1 = sequencesKt__SequencesKt$flatMapIndexed$12;
                it = it2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!it.hasNext()) {
            Object element = it.next();
            Function2<Integer, T, C> function2 = sequencesKt__SequencesKt$flatMapIndexed$1.$transform;
            int index2 = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object result = function2.invoke(Boxing.boxInt(index), element);
            sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = $this$sequence;
            sequencesKt__SequencesKt$flatMapIndexed$1.L$1 = it;
            sequencesKt__SequencesKt$flatMapIndexed$1.L$2 = SpillingKt.nullOutSpilledVariable(element);
            sequencesKt__SequencesKt$flatMapIndexed$1.L$3 = SpillingKt.nullOutSpilledVariable(result);
            sequencesKt__SequencesKt$flatMapIndexed$1.I$0 = index2;
            sequencesKt__SequencesKt$flatMapIndexed$1.label = 1;
            if ($this$sequence.yieldAll(sequencesKt__SequencesKt$flatMapIndexed$1.$iterator.invoke(result), sequencesKt__SequencesKt$flatMapIndexed$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            it2 = it;
            sequencesKt__SequencesKt$flatMapIndexed$12 = sequencesKt__SequencesKt$flatMapIndexed$1;
            index = index2;
            sequencesKt__SequencesKt$flatMapIndexed$1 = sequencesKt__SequencesKt$flatMapIndexed$12;
            it = it2;
            if (!it.hasNext()) {
                return Unit.INSTANCE;
            }
        }
    }
}