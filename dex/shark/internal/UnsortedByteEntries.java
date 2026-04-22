package shark.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.internal.aosp.ByteArrayComparator;
import shark.internal.aosp.ByteArrayTimSort;
import tv.danmaku.bili.BR;

/* compiled from: UnsortedByteEntries.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001!B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0012\u001a\u00060\u0010R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0015\u0010\u001e\u001a\u00020\u0003*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0082\fJ\u0015\u0010\u001e\u001a\u00020\u0014*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0082\fR\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lshark/internal/UnsortedByteEntries;", "", "bytesPerValue", "", "longIdentifiers", "", "initialCapacity", "growthFactor", "", "(IZID)V", "assigned", "bytesPerEntry", "currentCapacity", "entries", "", "subArray", "Lshark/internal/UnsortedByteEntries$MutableByteSubArray;", "subArrayIndex", "append", "key", "", "growEntries", "", "newCapacity", "moveToSortedMap", "Lshark/internal/SortedBytesMap;", "readInt", "array", "index", "readLong", "and", "", "other", "MutableByteSubArray", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class UnsortedByteEntries {
    private int assigned;
    private final int bytesPerEntry;
    private final int bytesPerValue;
    private int currentCapacity;
    private byte[] entries;
    private final double growthFactor;
    private final int initialCapacity;
    private final boolean longIdentifiers;
    private final MutableByteSubArray subArray;
    private int subArrayIndex;

    public UnsortedByteEntries(int bytesPerValue, boolean longIdentifiers, int initialCapacity, double growthFactor) {
        this.bytesPerValue = bytesPerValue;
        this.longIdentifiers = longIdentifiers;
        this.initialCapacity = initialCapacity;
        this.growthFactor = growthFactor;
        this.bytesPerEntry = this.bytesPerValue + (this.longIdentifiers ? 8 : 4);
        this.subArray = new MutableByteSubArray();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ UnsortedByteEntries(int i, boolean z, int i2, double d, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, r3, r4);
        double d2;
        int i4 = (i3 & 4) != 0 ? 4 : i2;
        if ((i3 & 8) == 0) {
            d2 = d;
        } else {
            d2 = 2.0d;
        }
    }

    public final MutableByteSubArray append(long key) {
        if (this.entries == null) {
            this.currentCapacity = this.initialCapacity;
            this.entries = new byte[this.currentCapacity * this.bytesPerEntry];
        } else if (this.currentCapacity == this.assigned) {
            int newCapacity = (int) (this.currentCapacity * this.growthFactor);
            growEntries(newCapacity);
            this.currentCapacity = newCapacity;
        }
        this.assigned++;
        this.subArrayIndex = 0;
        this.subArray.writeId(key);
        return this.subArray;
    }

    public final SortedBytesMap moveToSortedMap() {
        byte[] sortedEntries;
        if (this.assigned == 0) {
            return new SortedBytesMap(this.longIdentifiers, this.bytesPerValue, new byte[0]);
        }
        byte[] entries = this.entries;
        if (entries == null) {
            Intrinsics.throwNpe();
        }
        ByteArrayTimSort.Companion.sort(entries, 0, this.assigned, this.bytesPerEntry, new ByteArrayComparator() { // from class: shark.internal.UnsortedByteEntries$moveToSortedMap$1
            @Override // shark.internal.aosp.ByteArrayComparator
            public final int compare(int entrySize, byte[] o1Array, int o1Index, byte[] o2Array, int o2Index) {
                int readInt;
                int readInt2;
                long readLong;
                long readLong2;
                Intrinsics.checkParameterIsNotNull(o1Array, "o1Array");
                Intrinsics.checkParameterIsNotNull(o2Array, "o2Array");
                if (UnsortedByteEntries.this.longIdentifiers) {
                    readLong = UnsortedByteEntries.this.readLong(o1Array, o1Index * entrySize);
                    readLong2 = UnsortedByteEntries.this.readLong(o2Array, o2Index * entrySize);
                    return (readLong > readLong2 ? 1 : (readLong == readLong2 ? 0 : -1));
                }
                readInt = UnsortedByteEntries.this.readInt(o1Array, o1Index * entrySize);
                readInt2 = UnsortedByteEntries.this.readInt(o2Array, o2Index * entrySize);
                return Intrinsics.compare(readInt, readInt2);
            }
        });
        if (entries.length > this.assigned * this.bytesPerEntry) {
            sortedEntries = Arrays.copyOf(entries, this.assigned * this.bytesPerEntry);
            Intrinsics.checkExpressionValueIsNotNull(sortedEntries, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            sortedEntries = entries;
        }
        this.entries = null;
        this.assigned = 0;
        return new SortedBytesMap(this.longIdentifiers, this.bytesPerValue, sortedEntries);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int readInt(byte[] array, int index) {
        int pos = index + 1;
        byte $this$and$iv = array[index];
        int pos2 = pos + 1;
        byte $this$and$iv2 = array[pos];
        int i = (($this$and$iv & 255) << 24) | (($this$and$iv2 & 255) << 16);
        int pos3 = pos2 + 1;
        byte $this$and$iv3 = array[pos2];
        int i2 = i | (($this$and$iv3 & 255) << 8);
        byte $this$and$iv4 = array[pos3];
        return i2 | ($this$and$iv4 & 255);
    }

    private final long and(byte $this$and, long other) {
        return $this$and & other;
    }

    private final int and(byte $this$and, int other) {
        return $this$and & other;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long readLong(byte[] array, int index) {
        int pos = index + 1;
        byte $this$and$iv = array[index];
        long other$iv = 255 & $this$and$iv;
        int pos2 = pos + 1;
        byte $this$and$iv2 = array[pos];
        long other$iv2 = 255 & $this$and$iv2;
        long j = (other$iv << 56) | (other$iv2 << 48);
        int pos3 = pos2 + 1;
        byte $this$and$iv3 = array[pos2];
        long other$iv3 = 255 & $this$and$iv3;
        int pos4 = pos3 + 1;
        byte $this$and$iv4 = array[pos3];
        long j2 = j | (other$iv3 << 40) | (($this$and$iv4 & 255) << 32);
        int pos5 = pos4 + 1;
        byte $this$and$iv5 = array[pos4];
        long other$iv4 = 255 & $this$and$iv5;
        int pos6 = pos5 + 1;
        byte $this$and$iv6 = array[pos5];
        long j3 = j2 | (other$iv4 << 24) | (($this$and$iv6 & 255) << 16);
        int pos7 = pos6 + 1;
        byte $this$and$iv7 = array[pos6];
        long other$iv5 = 255 & $this$and$iv7;
        long j4 = j3 | (other$iv5 << 8);
        byte $this$and$iv8 = array[pos7];
        long other$iv6 = 255 & $this$and$iv8;
        return j4 | other$iv6;
    }

    private final void growEntries(int newCapacity) {
        byte[] newEntries = new byte[this.bytesPerEntry * newCapacity];
        System.arraycopy(this.entries, 0, newEntries, 0, this.assigned * this.bytesPerEntry);
        this.entries = newEntries;
    }

    /* compiled from: UnsortedByteEntries.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n¨\u0006\u000e"}, d2 = {"Lshark/internal/UnsortedByteEntries$MutableByteSubArray;", "", "(Lshark/internal/UnsortedByteEntries;)V", "writeByte", "", "value", "", "writeId", "", "writeInt", "", "writeLong", "writeTruncatedLong", "byteCount", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class MutableByteSubArray {
        public MutableByteSubArray() {
        }

        public final void writeByte(byte value) {
            int index = UnsortedByteEntries.this.subArrayIndex;
            UnsortedByteEntries.this.subArrayIndex++;
            if (index >= 0 && UnsortedByteEntries.this.bytesPerEntry >= index) {
                int valuesIndex = ((UnsortedByteEntries.this.assigned - 1) * UnsortedByteEntries.this.bytesPerEntry) + index;
                byte[] bArr = UnsortedByteEntries.this.entries;
                if (bArr == null) {
                    Intrinsics.throwNpe();
                }
                bArr[valuesIndex] = value;
                return;
            }
            throw new IllegalArgumentException(("Index " + index + " should be between 0 and " + UnsortedByteEntries.this.bytesPerEntry).toString());
        }

        public final void writeId(long value) {
            if (UnsortedByteEntries.this.longIdentifiers) {
                writeLong(value);
            } else {
                writeInt((int) value);
            }
        }

        public final void writeInt(int value) {
            int index = UnsortedByteEntries.this.subArrayIndex;
            UnsortedByteEntries.this.subArrayIndex += 4;
            if (index >= 0 && index <= UnsortedByteEntries.this.bytesPerEntry + (-4)) {
                int pos = ((UnsortedByteEntries.this.assigned - 1) * UnsortedByteEntries.this.bytesPerEntry) + index;
                byte[] values = UnsortedByteEntries.this.entries;
                if (values == null) {
                    Intrinsics.throwNpe();
                }
                int pos2 = pos + 1;
                values[pos] = (byte) ((value >>> 24) & BR.hallCover);
                int pos3 = pos2 + 1;
                values[pos2] = (byte) ((value >>> 16) & BR.hallCover);
                values[pos3] = (byte) ((value >>> 8) & BR.hallCover);
                values[pos3 + 1] = (byte) (value & BR.hallCover);
                return;
            }
            throw new IllegalArgumentException(("Index " + index + " should be between 0 and " + (UnsortedByteEntries.this.bytesPerEntry - 4)).toString());
        }

        public final void writeTruncatedLong(long value, int byteCount) {
            int index = UnsortedByteEntries.this.subArrayIndex;
            UnsortedByteEntries.this.subArrayIndex += byteCount;
            if (index >= 0 && index <= UnsortedByteEntries.this.bytesPerEntry - byteCount) {
                int pos = ((UnsortedByteEntries.this.assigned - 1) * UnsortedByteEntries.this.bytesPerEntry) + index;
                byte[] values = UnsortedByteEntries.this.entries;
                if (values == null) {
                    Intrinsics.throwNpe();
                }
                int shift = (byteCount - 1) * 8;
                while (shift >= 8) {
                    values[pos] = (byte) (255 & (value >>> shift));
                    shift -= 8;
                    pos++;
                }
                values[pos] = (byte) (value & 255);
                return;
            }
            throw new IllegalArgumentException(("Index " + index + " should be between 0 and " + (UnsortedByteEntries.this.bytesPerEntry - byteCount)).toString());
        }

        public final void writeLong(long value) {
            int index = UnsortedByteEntries.this.subArrayIndex;
            UnsortedByteEntries.this.subArrayIndex += 8;
            if (index >= 0 && index <= UnsortedByteEntries.this.bytesPerEntry - 8) {
                int pos = ((UnsortedByteEntries.this.assigned - 1) * UnsortedByteEntries.this.bytesPerEntry) + index;
                byte[] values = UnsortedByteEntries.this.entries;
                if (values == null) {
                    Intrinsics.throwNpe();
                }
                int pos2 = pos + 1;
                values[pos] = (byte) ((value >>> 56) & 255);
                int pos3 = pos2 + 1;
                values[pos2] = (byte) ((value >>> 48) & 255);
                int pos4 = pos3 + 1;
                values[pos3] = (byte) ((value >>> 40) & 255);
                int pos5 = pos4 + 1;
                values[pos4] = (byte) ((value >>> 32) & 255);
                int pos6 = pos5 + 1;
                values[pos5] = (byte) ((value >>> 24) & 255);
                int pos7 = pos6 + 1;
                values[pos6] = (byte) ((value >>> 16) & 255);
                values[pos7] = (byte) ((value >>> 8) & 255);
                values[pos7 + 1] = (byte) (value & 255);
                return;
            }
            throw new IllegalArgumentException(("Index " + index + " should be between 0 and " + (UnsortedByteEntries.this.bytesPerEntry - 8)).toString());
        }
    }
}