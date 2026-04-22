package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SlidingWindow.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "e", "bufferInitialCapacity", "gap", "skip", "$this$iterator", "buffer", "bufferInitialCapacity", "gap", "skip", "$this$iterator", "buffer", "e", "bufferInitialCapacity", "gap", "$this$iterator", "buffer", "bufferInitialCapacity", "gap", "$this$iterator", "buffer", "bufferInitialCapacity", "gap"}, nl = {35, 43, 50, 56, LockFreeTaskQueueCore.CLOSED_SHIFT}, s = {"L$0", "L$1", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "L$3", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 2)
public final class SlidingWindowKt$windowedIterator$1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator<T> $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator<? extends T> it, boolean z, boolean z2, Continuation<? super SlidingWindowKt$windowedIterator$1> continuation) {
        super(2, continuation);
        this.$size = i;
        this.$step = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.L$0 = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SequenceScope) ((SequenceScope) obj), continuation);
    }

    public final Object invoke(SequenceScope<? super List<? extends T>> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SlidingWindowKt$windowedIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01fa  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ca -> B:25:0x00d0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x017f -> B:56:0x0182). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x01bf -> B:69:0x01c2). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int gap;
        Iterator<T> it;
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1;
        RingBuffer buffer;
        int bufferInitialCapacity;
        int gap2;
        Iterator<T> it2;
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$12;
        Object obj;
        int skip;
        ArrayList buffer2;
        int bufferInitialCapacity2;
        int gap3;
        int bufferInitialCapacity3;
        ArrayList buffer3;
        Object obj2;
        int gap4;
        int bufferInitialCapacity4;
        SequenceScope $this$iterator = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int bufferInitialCapacity5 = RangesKt.coerceAtMost(this.$size, 1024);
                gap = this.$step - this.$size;
                if (gap >= 0) {
                    ArrayList buffer4 = new ArrayList(bufferInitialCapacity5);
                    it2 = this.$iterator;
                    slidingWindowKt$windowedIterator$12 = this;
                    obj = coroutine_suspended;
                    skip = 0;
                    buffer2 = buffer4;
                    bufferInitialCapacity2 = bufferInitialCapacity5;
                    while (it2.hasNext()) {
                        T next = it2.next();
                        if (skip > 0) {
                            skip--;
                        } else {
                            buffer2.add(next);
                            if (buffer2.size() == slidingWindowKt$windowedIterator$12.$size) {
                                slidingWindowKt$windowedIterator$12.L$0 = $this$iterator;
                                slidingWindowKt$windowedIterator$12.L$1 = buffer2;
                                slidingWindowKt$windowedIterator$12.L$2 = it2;
                                slidingWindowKt$windowedIterator$12.L$3 = SpillingKt.nullOutSpilledVariable(next);
                                slidingWindowKt$windowedIterator$12.I$0 = bufferInitialCapacity2;
                                slidingWindowKt$windowedIterator$12.I$1 = gap;
                                slidingWindowKt$windowedIterator$12.I$2 = skip;
                                slidingWindowKt$windowedIterator$12.label = 1;
                                if ($this$iterator.yield(buffer2, slidingWindowKt$windowedIterator$12) == obj) {
                                    return obj;
                                }
                                coroutine_suspended = obj;
                                buffer3 = buffer2;
                                if (slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                                    buffer3 = new ArrayList(slidingWindowKt$windowedIterator$12.$size);
                                } else {
                                    buffer3.clear();
                                }
                                int skip2 = gap;
                                buffer2 = buffer3;
                                obj = coroutine_suspended;
                                skip = skip2;
                                while (it2.hasNext()) {
                                }
                            }
                        }
                    }
                    if (!buffer2.isEmpty() && (slidingWindowKt$windowedIterator$12.$partialWindows || buffer2.size() == slidingWindowKt$windowedIterator$12.$size)) {
                        slidingWindowKt$windowedIterator$12.L$0 = SpillingKt.nullOutSpilledVariable($this$iterator);
                        slidingWindowKt$windowedIterator$12.L$1 = SpillingKt.nullOutSpilledVariable(buffer2);
                        slidingWindowKt$windowedIterator$12.L$2 = null;
                        slidingWindowKt$windowedIterator$12.L$3 = null;
                        slidingWindowKt$windowedIterator$12.I$0 = bufferInitialCapacity2;
                        slidingWindowKt$windowedIterator$12.I$1 = gap;
                        slidingWindowKt$windowedIterator$12.I$2 = skip;
                        slidingWindowKt$windowedIterator$12.label = 2;
                        if ($this$iterator.yield(buffer2, slidingWindowKt$windowedIterator$12) != obj) {
                            return obj;
                        }
                        gap3 = gap;
                        bufferInitialCapacity3 = bufferInitialCapacity2;
                    }
                    return Unit.INSTANCE;
                }
                RingBuffer buffer5 = new RingBuffer(bufferInitialCapacity5);
                it = this.$iterator;
                slidingWindowKt$windowedIterator$1 = this;
                buffer = buffer5;
                bufferInitialCapacity = bufferInitialCapacity5;
                gap2 = gap;
                while (it.hasNext()) {
                    T next2 = it.next();
                    buffer.add((RingBuffer) next2);
                    if (buffer.isFull()) {
                        if (buffer.size() >= slidingWindowKt$windowedIterator$1.$size) {
                            List arrayList = slidingWindowKt$windowedIterator$1.$reuseBuffer ? buffer : new ArrayList(buffer);
                            slidingWindowKt$windowedIterator$1.L$0 = $this$iterator;
                            slidingWindowKt$windowedIterator$1.L$1 = buffer;
                            slidingWindowKt$windowedIterator$1.L$2 = it;
                            slidingWindowKt$windowedIterator$1.L$3 = SpillingKt.nullOutSpilledVariable(next2);
                            slidingWindowKt$windowedIterator$1.I$0 = bufferInitialCapacity;
                            slidingWindowKt$windowedIterator$1.I$1 = gap2;
                            slidingWindowKt$windowedIterator$1.label = 3;
                            if ($this$iterator.yield(arrayList, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            buffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                            while (it.hasNext()) {
                            }
                        } else {
                            buffer = buffer.expanded(slidingWindowKt$windowedIterator$1.$size);
                        }
                    }
                }
                if (slidingWindowKt$windowedIterator$1.$partialWindows) {
                    return Unit.INSTANCE;
                }
                int i = gap2;
                obj2 = coroutine_suspended;
                gap4 = i;
                if (buffer.size() <= slidingWindowKt$windowedIterator$1.$step) {
                    List arrayList2 = slidingWindowKt$windowedIterator$1.$reuseBuffer ? buffer : new ArrayList(buffer);
                    slidingWindowKt$windowedIterator$1.L$0 = $this$iterator;
                    slidingWindowKt$windowedIterator$1.L$1 = buffer;
                    slidingWindowKt$windowedIterator$1.L$2 = null;
                    slidingWindowKt$windowedIterator$1.L$3 = null;
                    slidingWindowKt$windowedIterator$1.I$0 = bufferInitialCapacity;
                    slidingWindowKt$windowedIterator$1.I$1 = gap4;
                    slidingWindowKt$windowedIterator$1.label = 4;
                    if ($this$iterator.yield(arrayList2, slidingWindowKt$windowedIterator$1) == obj2) {
                        return obj2;
                    }
                    buffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                    if (buffer.size() <= slidingWindowKt$windowedIterator$1.$step) {
                        if (buffer.isEmpty()) {
                            return Unit.INSTANCE;
                        }
                        slidingWindowKt$windowedIterator$1.L$0 = SpillingKt.nullOutSpilledVariable($this$iterator);
                        slidingWindowKt$windowedIterator$1.L$1 = SpillingKt.nullOutSpilledVariable(buffer);
                        slidingWindowKt$windowedIterator$1.L$2 = null;
                        slidingWindowKt$windowedIterator$1.L$3 = null;
                        slidingWindowKt$windowedIterator$1.I$0 = bufferInitialCapacity;
                        slidingWindowKt$windowedIterator$1.I$1 = gap4;
                        slidingWindowKt$windowedIterator$1.label = 5;
                        if ($this$iterator.yield(buffer, slidingWindowKt$windowedIterator$1) == obj2) {
                            return obj2;
                        }
                        bufferInitialCapacity4 = bufferInitialCapacity;
                        return Unit.INSTANCE;
                    }
                }
                break;
            case 1:
                int gap5 = this.I$2;
                gap = this.I$1;
                bufferInitialCapacity2 = this.I$0;
                Object obj3 = this.L$3;
                it2 = (Iterator) this.L$2;
                ArrayList buffer6 = (ArrayList) this.L$1;
                ResultKt.throwOnFailure($result);
                buffer3 = buffer6;
                slidingWindowKt$windowedIterator$12 = this;
                if (slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                }
                int skip22 = gap;
                buffer2 = buffer3;
                obj = coroutine_suspended;
                skip = skip22;
                while (it2.hasNext()) {
                }
                if (!buffer2.isEmpty()) {
                    slidingWindowKt$windowedIterator$12.L$0 = SpillingKt.nullOutSpilledVariable($this$iterator);
                    slidingWindowKt$windowedIterator$12.L$1 = SpillingKt.nullOutSpilledVariable(buffer2);
                    slidingWindowKt$windowedIterator$12.L$2 = null;
                    slidingWindowKt$windowedIterator$12.L$3 = null;
                    slidingWindowKt$windowedIterator$12.I$0 = bufferInitialCapacity2;
                    slidingWindowKt$windowedIterator$12.I$1 = gap;
                    slidingWindowKt$windowedIterator$12.I$2 = skip;
                    slidingWindowKt$windowedIterator$12.label = 2;
                    if ($this$iterator.yield(buffer2, slidingWindowKt$windowedIterator$12) != obj) {
                    }
                    break;
                }
                return Unit.INSTANCE;
            case 2:
                int i2 = this.I$2;
                gap3 = this.I$1;
                bufferInitialCapacity3 = this.I$0;
                ArrayList arrayList3 = (ArrayList) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                gap2 = this.I$1;
                bufferInitialCapacity = this.I$0;
                Object obj4 = this.L$3;
                it = (Iterator) this.L$2;
                buffer = (RingBuffer) this.L$1;
                ResultKt.throwOnFailure($result);
                slidingWindowKt$windowedIterator$1 = this;
                buffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                while (it.hasNext()) {
                }
                if (slidingWindowKt$windowedIterator$1.$partialWindows) {
                }
                break;
            case 4:
                int bufferInitialCapacity6 = this.I$1;
                bufferInitialCapacity = this.I$0;
                RingBuffer buffer7 = (RingBuffer) this.L$1;
                ResultKt.throwOnFailure($result);
                slidingWindowKt$windowedIterator$1 = this;
                buffer = buffer7;
                obj2 = coroutine_suspended;
                gap4 = bufferInitialCapacity6;
                buffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                if (buffer.size() <= slidingWindowKt$windowedIterator$1.$step) {
                }
                break;
            case 5:
                gap4 = this.I$1;
                bufferInitialCapacity4 = this.I$0;
                RingBuffer ringBuffer = (RingBuffer) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}