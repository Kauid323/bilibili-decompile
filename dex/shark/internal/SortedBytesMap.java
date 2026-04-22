package shark.internal;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.internal.hppc.LongObjectPair;
import shark.internal.hppc.TuplesKt;

/* compiled from: SortedBytesMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0011\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013J\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0005R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lshark/internal/SortedBytesMap;", "", "longIdentifiers", "", "bytesPerValue", "", "sortedEntries", "", "(ZI[B)V", "bytesPerEntry", "bytesPerKey", "size", "getSize", "()I", "binarySearch", "key", "", "contains", "entrySequence", "Lkotlin/sequences/Sequence;", "Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/ByteSubArray;", "get", "getAtIndex", "keyIndex", "indexOf", "keyAt", "index", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class SortedBytesMap {
    private final int bytesPerEntry;
    private final int bytesPerKey;
    private final int bytesPerValue;
    private final boolean longIdentifiers;
    private final int size;
    private final byte[] sortedEntries;

    public SortedBytesMap(boolean longIdentifiers, int bytesPerValue, byte[] sortedEntries) {
        Intrinsics.checkParameterIsNotNull(sortedEntries, "sortedEntries");
        this.longIdentifiers = longIdentifiers;
        this.bytesPerValue = bytesPerValue;
        this.sortedEntries = sortedEntries;
        this.bytesPerKey = this.longIdentifiers ? 8 : 4;
        this.bytesPerEntry = this.bytesPerKey + this.bytesPerValue;
        this.size = this.sortedEntries.length / this.bytesPerEntry;
    }

    public final int getSize() {
        return this.size;
    }

    public final ByteSubArray get(long key) {
        int keyIndex = binarySearch(key);
        if (keyIndex < 0) {
            return null;
        }
        return getAtIndex(keyIndex);
    }

    public final int indexOf(long key) {
        return binarySearch(key);
    }

    public final ByteSubArray getAtIndex(int keyIndex) {
        int valueIndex = (this.bytesPerEntry * keyIndex) + this.bytesPerKey;
        return new ByteSubArray(this.sortedEntries, valueIndex, this.bytesPerValue, this.longIdentifiers);
    }

    public final boolean contains(long key) {
        int keyIndex = binarySearch(key);
        return keyIndex >= 0;
    }

    public final Sequence<LongObjectPair<ByteSubArray>> entrySequence() {
        return SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, this.size)), new Function1<Integer, LongObjectPair<? extends ByteSubArray>>() { // from class: shark.internal.SortedBytesMap$entrySequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final LongObjectPair<ByteSubArray> invoke(int keyIndex) {
                int i;
                int i2;
                byte[] bArr;
                int i3;
                boolean z;
                i = SortedBytesMap.this.bytesPerEntry;
                i2 = SortedBytesMap.this.bytesPerKey;
                int valueIndex = (i * keyIndex) + i2;
                long keyAt = SortedBytesMap.this.keyAt(keyIndex);
                bArr = SortedBytesMap.this.sortedEntries;
                i3 = SortedBytesMap.this.bytesPerValue;
                z = SortedBytesMap.this.longIdentifiers;
                return TuplesKt.to(keyAt, new ByteSubArray(bArr, valueIndex, i3, z));
            }
        });
    }

    private final int binarySearch(long key) {
        int endIndex = this.size;
        int lo = 0;
        int hi = endIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            long midVal = keyAt(mid);
            if (midVal < key) {
                lo = mid + 1;
            } else if (midVal <= key) {
                return mid;
            } else {
                hi = mid - 1;
            }
        }
        return ~lo;
    }

    public final long keyAt(int index) {
        int keyIndex = this.bytesPerEntry * index;
        if (this.longIdentifiers) {
            return ByteSubArrayKt.readLong(this.sortedEntries, keyIndex);
        }
        return ByteSubArrayKt.readInt(this.sortedEntries, keyIndex);
    }
}