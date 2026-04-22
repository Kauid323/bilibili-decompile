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

/* compiled from: LongScatterSet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0011\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0011\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u0006\u0010#\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lshark/internal/hppc/LongScatterSet;", "", "expectedElements", "", "(I)V", "assigned", "hasEmptyKey", "", "keys", "", "loadFactor", "", "mask", "resizeAt", "add", "key", "", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "contains", "elementSequence", "Lkotlin/sequences/Sequence;", "ensureCapacity", "hashKey", "plusAssign", "rehash", "fromKeys", BuildConfig.BUILD_TYPE, "remove", "shiftConflictingKeys", "inputGapSlot", "size", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class LongScatterSet {
    private int assigned;
    private boolean hasEmptyKey;
    private long[] keys;
    private final double loadFactor;
    private int mask;
    private int resizeAt;

    public LongScatterSet() {
        this(0, 1, null);
    }

    public LongScatterSet(int expectedElements) {
        this.keys = new long[0];
        this.loadFactor = 0.75d;
        ensureCapacity(expectedElements);
    }

    public /* synthetic */ LongScatterSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 4 : i);
    }

    public final Sequence<Long> elementSequence() {
        final int max = this.mask + 1;
        final Ref.IntRef slot = new Ref.IntRef();
        slot.element = -1;
        return SequencesKt.generateSequence(new Function0<Long>() { // from class: shark.internal.hppc.LongScatterSet$elementSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Long m160invoke() {
                boolean z;
                long[] jArr;
                if (slot.element < max) {
                    slot.element++;
                    while (slot.element < max) {
                        jArr = LongScatterSet.this.keys;
                        long existing = jArr[slot.element];
                        if (existing != 0) {
                            return Long.valueOf(existing);
                        }
                        slot.element++;
                    }
                }
                if (slot.element == max) {
                    z = LongScatterSet.this.hasEmptyKey;
                    if (z) {
                        slot.element++;
                        return 0L;
                    }
                    return null;
                }
                return null;
            }
        });
    }

    private final int hashKey(long key) {
        return HPPC.INSTANCE.mixPhi(key);
    }

    public final void plusAssign(long key) {
        add(key);
    }

    public final boolean add(long key) {
        if (key == 0) {
            boolean added = !this.hasEmptyKey;
            this.hasEmptyKey = true;
            return added;
        }
        long[] keys = this.keys;
        int mask = this.mask;
        int slot = hashKey(key) & mask;
        long existing = keys[slot];
        while (existing != 0) {
            if (existing == key) {
                return false;
            }
            slot = (slot + 1) & mask;
            existing = keys[slot];
        }
        if (this.assigned == this.resizeAt) {
            allocateThenInsertThenRehash(slot, key);
        } else {
            keys[slot] = key;
        }
        this.assigned++;
        return true;
    }

    public final boolean contains(long key) {
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

    public final boolean remove(long key) {
        if (key == 0) {
            boolean hadEmptyKey = this.hasEmptyKey;
            this.hasEmptyKey = false;
            return hadEmptyKey;
        }
        long[] keys = this.keys;
        int mask = this.mask;
        int slot = hashKey(key) & mask;
        long existing = keys[slot];
        while (existing != 0) {
            if (existing == key) {
                shiftConflictingKeys(slot);
                return true;
            }
            slot = (slot + 1) & mask;
            existing = keys[slot];
        }
        return false;
    }

    private final void shiftConflictingKeys(int inputGapSlot) {
        int gapSlot = inputGapSlot;
        long[] keys = this.keys;
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
                    gapSlot = slot;
                    distance = 0;
                }
            } else {
                keys[gapSlot] = 0;
                this.assigned--;
                return;
            }
        }
    }

    public final void release() {
        this.assigned = 0;
        this.hasEmptyKey = false;
        allocateBuffers(HPPC.INSTANCE.minBufferSize(4, this.loadFactor));
    }

    public final void ensureCapacity(int expectedElements) {
        if (expectedElements > this.resizeAt) {
            long[] prevKeys = this.keys;
            allocateBuffers(HPPC.INSTANCE.minBufferSize(expectedElements, this.loadFactor));
            if (size() != 0) {
                rehash(prevKeys);
            }
        }
    }

    public final int size() {
        return this.assigned + (this.hasEmptyKey ? 1 : 0);
    }

    private final void rehash(long[] fromKeys) {
        long[] keys = this.keys;
        int mask = this.mask;
        int i = fromKeys.length - 1;
        while (true) {
            i--;
            if (i >= 0) {
                long existing = fromKeys[i];
                if (existing != 0) {
                    int slot = hashKey(existing) & mask;
                    while (keys[slot] != 0) {
                        slot = (slot + 1) & mask;
                    }
                    keys[slot] = existing;
                }
            } else {
                return;
            }
        }
    }

    private final void allocateBuffers(int arraySize) {
        long[] prevKeys = this.keys;
        try {
            this.keys = new long[arraySize + 1];
            this.resizeAt = HPPC.INSTANCE.expandAtCount(arraySize, this.loadFactor);
            this.mask = arraySize - 1;
        } catch (OutOfMemoryError e) {
            this.keys = prevKeys;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            String format = String.format(locale, "Not enough memory to allocate buffers for rehashing: %d -> %d", Arrays.copyOf(new Object[]{Integer.valueOf(size()), Integer.valueOf(arraySize)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(format, e);
        }
    }

    private final void allocateThenInsertThenRehash(int slot, long pendingKey) {
        long[] prevKeys = this.keys;
        allocateBuffers(HPPC.INSTANCE.nextBufferSize(this.mask + 1, size(), this.loadFactor));
        prevKeys[slot] = pendingKey;
        rehash(prevKeys);
    }
}