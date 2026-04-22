package shark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import tv.danmaku.android.log.BuildConfig;

/* compiled from: LongObjectScatterMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J%\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0005J\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&0%J\u0018\u0010'\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001dH\u0086\u0002¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001dH\u0002J%\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0002¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\u0018J\u0015\u0010/\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001d¢\u0006\u0002\u0010(J \u00100\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001d2\u0006\u00101\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014X\u0082\u000e¢\u0006\n\n\u0002\u0010\u0016\u0012\u0004\b\u0015\u0010\u0003¨\u00065"}, d2 = {"Lshark/internal/hppc/LongObjectScatterMap;", "T", "", "()V", "assigned", "", "hasEmptyKey", "", "isEmpty", "()Z", "keys", "", "loadFactor", "", "mask", "resizeAt", "size", "getSize", "()I", "values", "", "getValues$annotations", "[Ljava/lang/Object;", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "", "pendingValue", "(IJLjava/lang/Object;)V", "containsKey", "key", "ensureCapacity", "expectedElements", "entrySequence", "Lkotlin/sequences/Sequence;", "Lshark/internal/hppc/LongObjectPair;", "get", "(J)Ljava/lang/Object;", "hashKey", "rehash", "fromKeys", "fromValues", "([J[Ljava/lang/Object;)V", BuildConfig.BUILD_TYPE, "remove", "set", "value", "(JLjava/lang/Object;)Ljava/lang/Object;", "shiftConflictingKeys", "gapSlotArg", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class LongObjectScatterMap<T> {
    private int assigned;
    private boolean hasEmptyKey;
    private int mask;
    private int resizeAt;
    private long[] keys = new long[0];
    private T[] values = (T[]) new Object[0];
    private double loadFactor = 0.75d;

    private static /* synthetic */ void getValues$annotations() {
    }

    public LongObjectScatterMap() {
        ensureCapacity(4);
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final T set(long key, T t) {
        int mask = this.mask;
        if (key == 0) {
            this.hasEmptyKey = true;
            T t2 = this.values[mask + 1];
            this.values[mask + 1] = t;
            return t2;
        }
        long[] keys = this.keys;
        int slot = hashKey(key) & mask;
        long existing = keys[slot];
        while (existing != 0) {
            if (existing == key) {
                T t3 = this.values[slot];
                this.values[slot] = t;
                return t3;
            }
            slot = (slot + 1) & mask;
            existing = keys[slot];
        }
        if (this.assigned == this.resizeAt) {
            allocateThenInsertThenRehash(slot, key, t);
        } else {
            keys[slot] = key;
            this.values[slot] = t;
        }
        this.assigned++;
        return null;
    }

    public final T remove(long key) {
        int mask = this.mask;
        if (key == 0) {
            this.hasEmptyKey = false;
            T t = this.values[mask + 1];
            this.values[mask + 1] = null;
            return t;
        }
        long[] keys = this.keys;
        int slot = hashKey(key) & mask;
        long existing = keys[slot];
        while (existing != 0) {
            if (existing == key) {
                T t2 = this.values[slot];
                shiftConflictingKeys(slot);
                return t2;
            }
            slot = (slot + 1) & mask;
            existing = keys[slot];
        }
        return null;
    }

    public final T get(long key) {
        if (key == 0) {
            if (this.hasEmptyKey) {
                return this.values[this.mask + 1];
            }
            return null;
        }
        long[] keys = this.keys;
        int mask = this.mask;
        int slot = hashKey(key) & mask;
        long existing = keys[slot];
        while (existing != 0) {
            if (existing == key) {
                return this.values[slot];
            }
            slot = (slot + 1) & mask;
            existing = keys[slot];
        }
        return null;
    }

    public final Sequence<LongObjectPair<T>> entrySequence() {
        final int max = this.mask + 1;
        final Ref.IntRef slot = new Ref.IntRef();
        slot.element = -1;
        return SequencesKt.generateSequence(new Function0<LongObjectPair<? extends T>>() { // from class: shark.internal.hppc.LongObjectScatterMap$entrySequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final LongObjectPair<T> invoke() {
                boolean z;
                Object[] objArr;
                long[] jArr;
                Object[] objArr2;
                if (slot.element < max) {
                    slot.element++;
                    while (slot.element < max) {
                        jArr = LongObjectScatterMap.this.keys;
                        long existing = jArr[slot.element];
                        if (existing != 0) {
                            objArr2 = LongObjectScatterMap.this.values;
                            Object obj = objArr2[slot.element];
                            if (obj == null) {
                                Intrinsics.throwNpe();
                            }
                            return TuplesKt.to(existing, obj);
                        }
                        slot.element++;
                    }
                }
                if (slot.element == max) {
                    z = LongObjectScatterMap.this.hasEmptyKey;
                    if (z) {
                        slot.element++;
                        objArr = LongObjectScatterMap.this.values;
                        Object obj2 = objArr[max];
                        if (obj2 == null) {
                            Intrinsics.throwNpe();
                        }
                        return TuplesKt.to(0L, obj2);
                    }
                    return null;
                }
                return null;
            }
        });
    }

    public final boolean containsKey(long key) {
        if (key == 0) {
            return this.hasEmptyKey;
        }
        long[] keys = this.keys;
        int mask = this.mask;
        int slot = hashKey(key) & mask;
        long existing = keys[slot];
        while (existing != 0) {
            if (existing == key) {
                return true;
            }
            slot = (slot + 1) & mask;
            existing = keys[slot];
        }
        return false;
    }

    public final void release() {
        this.assigned = 0;
        this.hasEmptyKey = false;
        allocateBuffers(HPPC.INSTANCE.minBufferSize(4, this.loadFactor));
    }

    public final int getSize() {
        return this.assigned + (this.hasEmptyKey ? 1 : 0);
    }

    public final void ensureCapacity(int expectedElements) {
        if (expectedElements > this.resizeAt) {
            long[] prevKeys = this.keys;
            T[] tArr = this.values;
            allocateBuffers(HPPC.INSTANCE.minBufferSize(expectedElements, this.loadFactor));
            if (!isEmpty()) {
                rehash(prevKeys, tArr);
            }
        }
    }

    private final int hashKey(long key) {
        return HPPC.INSTANCE.mixPhi(key);
    }

    private final void rehash(long[] fromKeys, T[] tArr) {
        long[] keys = this.keys;
        Object[] values = this.values;
        int mask = this.mask;
        int from = fromKeys.length - 1;
        keys[keys.length - 1] = fromKeys[from];
        values[values.length - 1] = tArr[from];
        while (true) {
            from--;
            if (from >= 0) {
                long existing = fromKeys[from];
                if (existing != 0) {
                    int slot = hashKey(existing) & mask;
                    while (keys[slot] != 0) {
                        slot = (slot + 1) & mask;
                    }
                    keys[slot] = existing;
                    values[slot] = tArr[from];
                }
            } else {
                return;
            }
        }
    }

    private final void allocateBuffers(int arraySize) {
        long[] prevKeys = this.keys;
        T[] tArr = this.values;
        try {
            this.keys = new long[arraySize + 1];
            this.values = (T[]) new Object[arraySize + 1];
            this.resizeAt = HPPC.INSTANCE.expandAtCount(arraySize, this.loadFactor);
            this.mask = arraySize - 1;
        } catch (OutOfMemoryError e) {
            this.keys = prevKeys;
            this.values = tArr;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            String format = String.format(locale, "Not enough memory to allocate buffers for rehashing: %d -> %d", Arrays.copyOf(new Object[]{Integer.valueOf(this.mask + 1), Integer.valueOf(arraySize)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(format, e);
        }
    }

    private final void allocateThenInsertThenRehash(int slot, long pendingKey, T t) {
        long[] prevKeys = this.keys;
        T[] tArr = this.values;
        allocateBuffers(HPPC.INSTANCE.nextBufferSize(this.mask + 1, getSize(), this.loadFactor));
        prevKeys[slot] = pendingKey;
        tArr[slot] = t;
        rehash(prevKeys, tArr);
    }

    private final void shiftConflictingKeys(int gapSlotArg) {
        int gapSlot = gapSlotArg;
        long[] keys = this.keys;
        Object[] values = this.values;
        int mask = this.mask;
        int distance = 0;
        while (true) {
            distance++;
            int slot = (gapSlot + distance) & mask;
            long existing = keys[slot];
            if (existing != 0) {
                int idealSlot = hashKey(existing);
                int shift = (slot - idealSlot) & mask;
                if (shift >= distance) {
                    keys[gapSlot] = existing;
                    values[gapSlot] = values[slot];
                    gapSlot = slot;
                    distance = 0;
                }
            } else {
                keys[gapSlot] = 0;
                values[gapSlot] = null;
                this.assigned--;
                return;
            }
        }
    }
}