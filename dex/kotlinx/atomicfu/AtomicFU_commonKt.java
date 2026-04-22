package kotlinx.atomicfu;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AtomicFU.common.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a$\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0005\u001a\u00020\u0004*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0005\u001a\u00020\u000b*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\bø\u0001\u0000\u001a5\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a0\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\bø\u0001\u0000\u001a0\u0010\u0013\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u0004*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u000b*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\bø\u0001\u0000\u001a5\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"atomicArrayOfNulls", "Lkotlinx/atomicfu/AtomicArray;", "T", "size", "", "getAndUpdate", "", "Lkotlinx/atomicfu/AtomicBoolean;", "function", "Lkotlin/Function1;", "Lkotlinx/atomicfu/AtomicInt;", "", "Lkotlinx/atomicfu/AtomicLong;", "Lkotlinx/atomicfu/AtomicRef;", "(Lkotlinx/atomicfu/AtomicRef;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "loop", "", "action", "", "update", "updateAndGet", "atomicfu"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AtomicFU_commonKt {
    public static final <T> AtomicArray<T> atomicArrayOfNulls(int size) {
        return new AtomicArray<>(size);
    }

    public static final <T> Void loop(AtomicRef<T> atomicRef, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(atomicRef, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(atomicRef.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void update(AtomicRef<T> atomicRef, Function1<? super T, ? extends T> function) {
        Object obj;
        Intrinsics.checkNotNullParameter(atomicRef, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            obj = (Object) atomicRef.getValue();
        } while (!atomicRef.compareAndSet(obj, function.invoke(obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
    public static final <T> T getAndUpdate(AtomicRef<T> atomicRef, Function1<? super T, ? extends T> function) {
        ?? r1;
        Intrinsics.checkNotNullParameter(atomicRef, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            r1 = (Object) atomicRef.getValue();
        } while (!atomicRef.compareAndSet(r1, function.invoke(r1)));
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T updateAndGet(AtomicRef<T> atomicRef, Function1<? super T, ? extends T> function) {
        Object obj;
        T invoke;
        Intrinsics.checkNotNullParameter(atomicRef, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            obj = (Object) atomicRef.getValue();
            invoke = function.invoke(obj);
        } while (!atomicRef.compareAndSet(obj, invoke));
        return invoke;
    }

    public static final Void loop(AtomicBoolean $this$loop, Function1<? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter($this$loop, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Boolean.valueOf($this$loop.getValue()));
        }
    }

    public static final void update(AtomicBoolean $this$update, Function1<? super Boolean, Boolean> function) {
        boolean cur;
        boolean upd;
        Intrinsics.checkNotNullParameter($this$update, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            cur = $this$update.getValue();
            upd = function.invoke(Boolean.valueOf(cur)).booleanValue();
        } while (!$this$update.compareAndSet(cur, upd));
    }

    public static final boolean getAndUpdate(AtomicBoolean $this$getAndUpdate, Function1<? super Boolean, Boolean> function) {
        boolean cur;
        boolean upd;
        Intrinsics.checkNotNullParameter($this$getAndUpdate, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            cur = $this$getAndUpdate.getValue();
            upd = function.invoke(Boolean.valueOf(cur)).booleanValue();
        } while (!$this$getAndUpdate.compareAndSet(cur, upd));
        return cur;
    }

    public static final boolean updateAndGet(AtomicBoolean $this$updateAndGet, Function1<? super Boolean, Boolean> function) {
        boolean cur;
        boolean upd;
        Intrinsics.checkNotNullParameter($this$updateAndGet, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            cur = $this$updateAndGet.getValue();
            upd = function.invoke(Boolean.valueOf(cur)).booleanValue();
        } while (!$this$updateAndGet.compareAndSet(cur, upd));
        return upd;
    }

    public static final Void loop(AtomicInt $this$loop, Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter($this$loop, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Integer.valueOf($this$loop.getValue()));
        }
    }

    public static final void update(AtomicInt $this$update, Function1<? super Integer, Integer> function) {
        int cur;
        int upd;
        Intrinsics.checkNotNullParameter($this$update, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            cur = $this$update.getValue();
            upd = function.invoke(Integer.valueOf(cur)).intValue();
        } while (!$this$update.compareAndSet(cur, upd));
    }

    public static final int getAndUpdate(AtomicInt $this$getAndUpdate, Function1<? super Integer, Integer> function) {
        int cur;
        int upd;
        Intrinsics.checkNotNullParameter($this$getAndUpdate, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            cur = $this$getAndUpdate.getValue();
            upd = function.invoke(Integer.valueOf(cur)).intValue();
        } while (!$this$getAndUpdate.compareAndSet(cur, upd));
        return cur;
    }

    public static final int updateAndGet(AtomicInt $this$updateAndGet, Function1<? super Integer, Integer> function) {
        int cur;
        int upd;
        Intrinsics.checkNotNullParameter($this$updateAndGet, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            cur = $this$updateAndGet.getValue();
            upd = function.invoke(Integer.valueOf(cur)).intValue();
        } while (!$this$updateAndGet.compareAndSet(cur, upd));
        return upd;
    }

    public static final Void loop(AtomicLong $this$loop, Function1<? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter($this$loop, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Long.valueOf($this$loop.getValue()));
        }
    }

    public static final void update(AtomicLong $this$update, Function1<? super Long, Long> function) {
        long cur;
        long upd;
        Intrinsics.checkNotNullParameter($this$update, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            cur = $this$update.getValue();
            upd = function.invoke(Long.valueOf(cur)).longValue();
        } while (!$this$update.compareAndSet(cur, upd));
    }

    public static final long getAndUpdate(AtomicLong $this$getAndUpdate, Function1<? super Long, Long> function) {
        long cur;
        long upd;
        Intrinsics.checkNotNullParameter($this$getAndUpdate, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            cur = $this$getAndUpdate.getValue();
            upd = function.invoke(Long.valueOf(cur)).longValue();
        } while (!$this$getAndUpdate.compareAndSet(cur, upd));
        return cur;
    }

    public static final long updateAndGet(AtomicLong $this$updateAndGet, Function1<? super Long, Long> function) {
        long cur;
        long upd;
        Intrinsics.checkNotNullParameter($this$updateAndGet, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            cur = $this$updateAndGet.getValue();
            upd = function.invoke(Long.valueOf(cur)).longValue();
        } while (!$this$updateAndGet.compareAndSet(cur, upd));
        return upd;
    }
}