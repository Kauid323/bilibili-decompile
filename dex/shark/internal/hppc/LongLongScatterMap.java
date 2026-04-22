package shark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import tv.danmaku.android.log.BuildConfig;

/* compiled from: LongLongScatterMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001:\u00012B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J \u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$J\u0011\u0010%\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0086\u0002J\u000e\u0010&\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001aJ\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0003J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0002J\u0006\u0010,\u001a\u00020\u0015J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0019\u0010.\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001aH\u0086\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lshark/internal/hppc/LongLongScatterMap;", "", "expectedElements", "", "(I)V", "assigned", "hasEmptyKey", "", "isEmpty", "()Z", "keys", "", "loadFactor", "", "mask", "resizeAt", "size", "getSize", "()I", "values", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "", "pendingValue", "containsKey", "key", "ensureCapacity", "entrySequence", "Lkotlin/sequences/Sequence;", "Lshark/internal/hppc/LongLongPair;", "forEach", "forEachCallback", "Lshark/internal/hppc/LongLongScatterMap$ForEachCallback;", "get", "getSlot", "getSlotValue", "hashKey", "rehash", "fromKeys", "fromValues", BuildConfig.BUILD_TYPE, "remove", "set", "value", "shiftConflictingKeys", "gapSlotArg", "ForEachCallback", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class LongLongScatterMap {
    private int assigned;
    private boolean hasEmptyKey;
    private long[] keys;
    private double loadFactor;
    private int mask;
    private int resizeAt;
    private long[] values;

    /* compiled from: LongLongScatterMap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lshark/internal/hppc/LongLongScatterMap$ForEachCallback;", "", "onEntry", "", "key", "", "value", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface ForEachCallback {
        void onEntry(long j, long j2);
    }

    public LongLongScatterMap() {
        this(0, 1, null);
    }

    public LongLongScatterMap(int expectedElements) {
        this.keys = new long[0];
        this.values = new long[0];
        this.loadFactor = 0.75d;
        ensureCapacity(expectedElements);
    }

    public /* synthetic */ LongLongScatterMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 4 : i);
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final long set(long key, long value) {
        int mask = this.mask;
        if (key == 0) {
            this.hasEmptyKey = true;
            long previousValue = this.values[mask + 1];
            this.values[mask + 1] = value;
            return previousValue;
        }
        long[] keys = this.keys;
        int slot = hashKey(key) & mask;
        int slot2 = slot;
        long existing = keys[slot];
        while (existing != 0) {
            if (existing == key) {
                long previousValue2 = this.values[slot2];
                this.values[slot2] = value;
                return previousValue2;
            }
            slot2 = (slot2 + 1) & mask;
            existing = keys[slot2];
        }
        if (this.assigned == this.resizeAt) {
            allocateThenInsertThenRehash(slot2, key, value);
        } else {
            keys[slot2] = key;
            this.values[slot2] = value;
        }
        this.assigned++;
        return 0L;
    }

    public final long remove(long key) {
        int mask = this.mask;
        if (key == 0) {
            this.hasEmptyKey = false;
            long previousValue = this.values[mask + 1];
            this.values[mask + 1] = 0;
            return previousValue;
        }
        long[] keys = this.keys;
        int slot = hashKey(key) & mask;
        long existing = keys[slot];
        while (existing != 0) {
            if (existing == key) {
                long previousValue2 = this.values[slot];
                shiftConflictingKeys(slot);
                return previousValue2;
            }
            slot = (slot + 1) & mask;
            existing = keys[slot];
        }
        return 0L;
    }

    public final int getSlot(long key) {
        if (key == 0) {
            if (this.hasEmptyKey) {
                return this.mask + 1;
            }
            return -1;
        }
        long[] keys = this.keys;
        int mask = this.mask;
        int slot = hashKey(key) & mask;
        long existing = keys[slot];
        while (existing != 0) {
            if (existing == key) {
                return slot;
            }
            slot = (slot + 1) & mask;
            existing = keys[slot];
        }
        return -1;
    }

    public final long getSlotValue(int slot) {
        return this.values[slot];
    }

    public final long get(long key) {
        int slot = getSlot(key);
        if (!(slot != -1)) {
            throw new IllegalArgumentException(("Unknown key " + key).toString());
        }
        return getSlotValue(slot);
    }

    public final void forEach(ForEachCallback forEachCallback) {
        Intrinsics.checkParameterIsNotNull(forEachCallback, "forEachCallback");
        int max = this.mask + 1;
        int slot = -1;
        while (true) {
            if (slot < max) {
                slot++;
                while (slot < max) {
                    long existing = this.keys[slot];
                    if (existing != 0) {
                        forEachCallback.onEntry(existing, this.values[slot]);
                        break;
                    }
                    slot++;
                }
            }
            if (slot == max && this.hasEmptyKey) {
                slot++;
                forEachCallback.onEntry(0L, this.values[max]);
            } else {
                return;
            }
        }
    }

    public final Sequence<LongLongPair> entrySequence() {
        final int max = this.mask + 1;
        final Ref.IntRef slot = new Ref.IntRef();
        slot.element = -1;
        return SequencesKt.generateSequence(new Function0<LongLongPair>() { // from class: shark.internal.hppc.LongLongScatterMap$entrySequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final LongLongPair invoke() {
                boolean z;
                long[] jArr;
                long[] jArr2;
                long[] jArr3;
                if (slot.element < max) {
                    slot.element++;
                    while (slot.element < max) {
                        jArr2 = LongLongScatterMap.this.keys;
                        long existing = jArr2[slot.element];
                        if (existing != 0) {
                            jArr3 = LongLongScatterMap.this.values;
                            return TuplesKt.to(existing, jArr3[slot.element]);
                        }
                        slot.element++;
                    }
                }
                if (slot.element == max) {
                    z = LongLongScatterMap.this.hasEmptyKey;
                    if (z) {
                        slot.element++;
                        jArr = LongLongScatterMap.this.values;
                        return TuplesKt.to(0L, jArr[max]);
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
            long[] prevValues = this.values;
            allocateBuffers(HPPC.INSTANCE.minBufferSize(expectedElements, this.loadFactor));
            if (!isEmpty()) {
                rehash(prevKeys, prevValues);
            }
        }
    }

    private final int hashKey(long key) {
        return HPPC.INSTANCE.mixPhi(key);
    }

    private final void rehash(long[] fromKeys, long[] fromValues) {
        long[] keys = this.keys;
        long[] values = this.values;
        int mask = this.mask;
        int from = fromKeys.length - 1;
        keys[keys.length - 1] = fromKeys[from];
        values[values.length - 1] = fromValues[from];
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
                    values[slot] = fromValues[from];
                }
            } else {
                return;
            }
        }
    }

    private final void allocateBuffers(int arraySize) {
        long[] prevKeys = this.keys;
        long[] prevValues = this.values;
        try {
            this.keys = new long[arraySize + 1];
            this.values = new long[arraySize + 1];
            this.resizeAt = HPPC.INSTANCE.expandAtCount(arraySize, this.loadFactor);
            this.mask = arraySize - 1;
        } catch (OutOfMemoryError e) {
            this.keys = prevKeys;
            this.values = prevValues;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            String format = String.format(locale, "Not enough memory to allocate buffers for rehashing: %d -> %d", Arrays.copyOf(new Object[]{Integer.valueOf(this.mask + 1), Integer.valueOf(arraySize)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(format, e);
        }
    }

    private final void allocateThenInsertThenRehash(int slot, long pendingKey, long pendingValue) {
        long[] prevKeys = this.keys;
        long[] prevValues = this.values;
        allocateBuffers(HPPC.INSTANCE.nextBufferSize(this.mask + 1, getSize(), this.loadFactor));
        prevKeys[slot] = pendingKey;
        prevValues[slot] = pendingValue;
        rehash(prevKeys, prevValues);
    }

    private final void shiftConflictingKeys(int gapSlotArg) {
        int gapSlot = gapSlotArg;
        long[] keys = this.keys;
        long[] values = this.values;
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
                values[gapSlot] = 0;
                this.assigned--;
                return;
            }
        }
    }
}