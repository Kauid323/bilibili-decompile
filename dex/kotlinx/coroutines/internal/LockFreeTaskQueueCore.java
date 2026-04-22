package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

/* compiled from: LockFreeTaskQueue.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ,*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002,-B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u0006J1\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0006J&\u0010!\u001a\b\u0012\u0004\u0012\u0002H#0\"\"\u0004\b\u0001\u0010#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H#0%J\b\u0010&\u001a\u00020\u001aH\u0002J\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010(\u001a\u0004\u0018\u00010\u0002J,\u0010)\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002R#\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n0\tX\u0082\u0004R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "E", "", "capacity", "", "singleConsumer", "", "(IZ)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_state", "Lkotlinx/atomicfu/AtomicLong;", "array", "Lkotlinx/atomicfu/AtomicArray;", "isEmpty", "()Z", "mask", "size", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)I", "allocateNextCopy", "state", "", "allocateOrGetNextCopy", "close", "fillPlaceholder", "index", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "markFrozen", "next", "removeFirstOrNull", "removeSlowPath", "oldHead", "newHead", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LockFreeTaskQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    private final /* synthetic */ AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;
    public static final Companion Companion = new Companion(null);
    private static final /* synthetic */ AtomicReferenceFieldUpdater _next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater _state$volatile$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state$volatile");
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");

    private final /* synthetic */ AtomicReferenceArray getArray() {
        return this.array;
    }

    private final /* synthetic */ Object get_next$volatile() {
        return this._next$volatile;
    }

    private final /* synthetic */ long get_state$volatile() {
        return this._state$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ void set_next$volatile(Object obj) {
        this._next$volatile = obj;
    }

    private final /* synthetic */ void set_state$volatile(long j) {
        this._state$volatile = j;
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        long j;
        do {
            j = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, function1.invoke(Long.valueOf(j)).longValue()));
    }

    private final /* synthetic */ long updateAndGet$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        long j;
        Long invoke;
        do {
            j = atomicLongFieldUpdater.get(obj);
            invoke = function1.invoke(Long.valueOf(j));
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, invoke.longValue()));
        return invoke.longValue();
    }

    public LockFreeTaskQueueCore(int capacity, boolean singleConsumer) {
        this.capacity = capacity;
        this.singleConsumer = singleConsumer;
        this.mask = this.capacity - 1;
        this.array = new AtomicReferenceArray(this.capacity);
        if (!(this.mask <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if ((this.capacity & this.mask) == 0) {
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final boolean isEmpty() {
        Companion companion = Companion;
        long $this$withState$iv = _state$volatile$FU.get(this);
        int head$iv = (int) ((HEAD_MASK & $this$withState$iv) >> 0);
        int tail$iv = (int) ((TAIL_MASK & $this$withState$iv) >> 30);
        return head$iv == tail$iv;
    }

    public final int getSize() {
        Companion companion = Companion;
        long $this$withState$iv = _state$volatile$FU.get(this);
        int head$iv = (int) ((HEAD_MASK & $this$withState$iv) >> 0);
        int tail$iv = (int) ((TAIL_MASK & $this$withState$iv) >> 30);
        int head = (tail$iv - head$iv) & MAX_CAPACITY_MASK;
        return head;
    }

    public final boolean close() {
        long state;
        AtomicLongFieldUpdater handler$atomicfu$iv = _state$volatile$FU;
        do {
            state = handler$atomicfu$iv.get(this);
            if ((state & CLOSED_MASK) != 0) {
                return true;
            }
            if ((1152921504606846976L & state) != 0) {
                return false;
            }
        } while (!handler$atomicfu$iv.compareAndSet(this, state, state | CLOSED_MASK));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int addLast(E e) {
        LockFreeTaskQueueCore fillPlaceholder;
        AtomicLongFieldUpdater handler$atomicfu$iv = _state$volatile$FU;
        while (true) {
            long state = handler$atomicfu$iv.get(this);
            if ((3458764513820540928L & state) != 0) {
                return Companion.addFailReason(state);
            }
            Companion companion = Companion;
            int head$iv = (int) ((state & HEAD_MASK) >> 0);
            int tail$iv = (int) ((state & TAIL_MASK) >> 30);
            int mask = this.mask;
            if (((tail$iv + 2) & mask) == (head$iv & mask)) {
                return 1;
            }
            if (!this.singleConsumer && getArray().get(tail$iv & mask) != null) {
                if (this.capacity < 1024 || ((tail$iv - head$iv) & MAX_CAPACITY_MASK) > (this.capacity >> 1)) {
                    break;
                }
            } else {
                int newTail = (tail$iv + 1) & MAX_CAPACITY_MASK;
                if (_state$volatile$FU.compareAndSet(this, state, Companion.updateTail(state, newTail))) {
                    getArray().set(tail$iv & mask, e);
                    LockFreeTaskQueueCore cur = this;
                    while ((_state$volatile$FU.get(cur) & 1152921504606846976L) != 0 && (fillPlaceholder = cur.next().fillPlaceholder(tail$iv, e)) != null) {
                        cur = fillPlaceholder;
                    }
                    return 0;
                }
            }
        }
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int index, E e) {
        Object old = getArray().get(this.mask & index);
        if ((old instanceof Placeholder) && ((Placeholder) old).index == index) {
            getArray().set(this.mask & index, e);
            return this;
        }
        return null;
    }

    public final Object removeFirstOrNull() {
        AtomicLongFieldUpdater handler$atomicfu$iv = _state$volatile$FU;
        LockFreeTaskQueueCore this_$iv = this;
        while (true) {
            long state = handler$atomicfu$iv.get(this);
            if ((1152921504606846976L & state) != 0) {
                return REMOVE_FROZEN;
            }
            Companion companion = Companion;
            int head$iv = (int) ((HEAD_MASK & state) >> 0);
            int tail$iv = (int) ((TAIL_MASK & state) >> 30);
            if ((tail$iv & this.mask) == (this.mask & head$iv)) {
                return null;
            }
            Object element = getArray().get(this.mask & head$iv);
            if (element == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else if (element instanceof Placeholder) {
                return null;
            } else {
                int newHead = (head$iv + 1) & MAX_CAPACITY_MASK;
                AtomicLongFieldUpdater handler$atomicfu$iv2 = handler$atomicfu$iv;
                LockFreeTaskQueueCore this_$iv2 = this_$iv;
                if (!_state$volatile$FU.compareAndSet(this, state, Companion.updateHead(state, newHead))) {
                    if (!this.singleConsumer) {
                        this_$iv = this_$iv2;
                        handler$atomicfu$iv = handler$atomicfu$iv2;
                    } else {
                        LockFreeTaskQueueCore cur = this;
                        while (true) {
                            LockFreeTaskQueueCore removeSlowPath = cur.removeSlowPath(head$iv, newHead);
                            if (removeSlowPath == null) {
                                return element;
                            }
                            cur = removeSlowPath;
                        }
                    }
                } else {
                    getArray().set(this.mask & head$iv, null);
                    return element;
                }
            }
        }
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int oldHead, int newHead) {
        AtomicLongFieldUpdater handler$atomicfu$iv = _state$volatile$FU;
        while (true) {
            long state = handler$atomicfu$iv.get(this);
            Companion companion = Companion;
            int head$iv = (int) ((HEAD_MASK & state) >> 0);
            int i = (int) ((TAIL_MASK & state) >> 30);
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(head$iv == oldHead)) {
                    throw new AssertionError();
                }
            }
            if ((state & 1152921504606846976L) != 0) {
                return next();
            }
            AtomicLongFieldUpdater handler$atomicfu$iv2 = handler$atomicfu$iv;
            if (!_state$volatile$FU.compareAndSet(this, state, Companion.updateHead(state, newHead))) {
                handler$atomicfu$iv = handler$atomicfu$iv2;
            } else {
                getArray().set(head$iv & this.mask, null);
                return null;
            }
        }
    }

    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    private final long markFrozen() {
        long state;
        long j;
        AtomicLongFieldUpdater handler$atomicfu$iv = _state$volatile$FU;
        do {
            state = handler$atomicfu$iv.get(this);
            if ((state & 1152921504606846976L) != 0) {
                return state;
            }
            j = 1152921504606846976L | state;
        } while (!handler$atomicfu$iv.compareAndSet(this, state, j));
        return j;
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long state) {
        AtomicReferenceFieldUpdater handler$atomicfu$iv = _next$volatile$FU;
        while (true) {
            LockFreeTaskQueueCore next = (LockFreeTaskQueueCore) handler$atomicfu$iv.get(this);
            if (next != null) {
                return next;
            }
            AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_next$volatile$FU, this, (Object) null, allocateNextCopy(state));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LockFreeTaskQueueCore<E> allocateNextCopy(long state) {
        LockFreeTaskQueueCore next = new LockFreeTaskQueueCore(this.capacity * 2, this.singleConsumer);
        Companion companion = Companion;
        int head$iv = (int) ((HEAD_MASK & state) >> 0);
        int tail$iv = (int) ((TAIL_MASK & state) >> 30);
        for (int index = head$iv; (this.mask & index) != (this.mask & tail$iv); index++) {
            Object value = getArray().get(this.mask & index);
            if (value == null) {
                value = new Placeholder(index);
            }
            next.getArray().set(next.mask & index, value);
        }
        _state$volatile$FU.set(next, Companion.wo(state, 1152921504606846976L));
        return next;
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> function1) {
        ArrayList res = new ArrayList(this.capacity);
        Companion companion = Companion;
        long $this$withState$iv = _state$volatile$FU.get(this);
        int head$iv = (int) ((HEAD_MASK & $this$withState$iv) >> 0);
        int tail$iv = (int) ((TAIL_MASK & $this$withState$iv) >> 30);
        for (int index = head$iv; (this.mask & index) != (this.mask & tail$iv); index++) {
            Object element = (Object) getArray().get(this.mask & index);
            if (element != null && !(element instanceof Placeholder)) {
                res.add(function1.invoke(element));
            }
        }
        return res;
    }

    public final boolean isClosed() {
        return (_state$volatile$FU.get(this) & CLOSED_MASK) != 0;
    }

    /* compiled from: LockFreeTaskQueue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Placeholder {
        public final int index;

        public Placeholder(int index) {
            this.index = index;
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long wo(long $this$wo, long other) {
            return (~other) & $this$wo;
        }

        public final long updateHead(long $this$updateHead, int newHead) {
            return wo($this$updateHead, LockFreeTaskQueueCore.HEAD_MASK) | (newHead << 0);
        }

        public final long updateTail(long $this$updateTail, int newTail) {
            return wo($this$updateTail, LockFreeTaskQueueCore.TAIL_MASK) | (newTail << 30);
        }

        public final <T> T withState(long $this$withState, Function2<? super Integer, ? super Integer, ? extends T> function2) {
            int head = (int) ((LockFreeTaskQueueCore.HEAD_MASK & $this$withState) >> 0);
            int tail = (int) ((LockFreeTaskQueueCore.TAIL_MASK & $this$withState) >> 30);
            return function2.invoke(Integer.valueOf(head), Integer.valueOf(tail));
        }

        public final int addFailReason(long $this$addFailReason) {
            return (LockFreeTaskQueueCore.CLOSED_MASK & $this$addFailReason) != 0 ? 2 : 1;
        }
    }
}