package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteSubArray.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lshark/internal/ByteSubArray;", "", "array", "", "rangeStart", "", "size", "longIdentifiers", "", "([BIIZ)V", "currentIndex", "endInclusive", "readByte", "", "readId", "", "readInt", "readLong", "readTruncatedLong", "byteCount", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class ByteSubArray {
    private final byte[] array;
    private int currentIndex;
    private final int endInclusive;
    private final boolean longIdentifiers;
    private final int rangeStart;

    public ByteSubArray(byte[] array, int rangeStart, int size, boolean longIdentifiers) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        this.array = array;
        this.rangeStart = rangeStart;
        this.longIdentifiers = longIdentifiers;
        this.endInclusive = size - 1;
    }

    public final byte readByte() {
        int index = this.currentIndex;
        boolean z = true;
        this.currentIndex++;
        if (!((index < 0 || this.endInclusive < index) ? false : false)) {
            throw new IllegalArgumentException(("Index " + index + " should be between 0 and " + this.endInclusive).toString());
        }
        return this.array[this.rangeStart + index];
    }

    public final long readId() {
        if (this.longIdentifiers) {
            return readLong();
        }
        return readInt();
    }

    public final int readInt() {
        int index = this.currentIndex;
        this.currentIndex += 4;
        if (!(index >= 0 && index <= this.endInclusive + (-3))) {
            throw new IllegalArgumentException(("Index " + index + " should be between 0 and " + (this.endInclusive - 3)).toString());
        }
        return ByteSubArrayKt.readInt(this.array, this.rangeStart + index);
    }

    public final long readTruncatedLong(int byteCount) {
        int index = this.currentIndex;
        this.currentIndex += byteCount;
        if (!(index >= 0 && index <= this.endInclusive - (byteCount + (-1)))) {
            throw new IllegalArgumentException(("Index " + index + " should be between 0 and " + (this.endInclusive - (byteCount - 1))).toString());
        }
        int pos = this.rangeStart + index;
        byte[] array = this.array;
        long value = 0;
        int shift = (byteCount - 1) * 8;
        while (shift >= 8) {
            int pos2 = pos + 1;
            byte $this$and$iv = array[pos];
            long other$iv = 255 & $this$and$iv;
            value |= other$iv << shift;
            shift -= 8;
            pos = pos2;
        }
        byte $this$and$iv2 = array[pos];
        return value | ($this$and$iv2 & 255);
    }

    public final long readLong() {
        int index = this.currentIndex;
        this.currentIndex += 8;
        if (!(index >= 0 && index <= this.endInclusive + (-7))) {
            throw new IllegalArgumentException(("Index " + index + " should be between 0 and " + (this.endInclusive - 7)).toString());
        }
        return ByteSubArrayKt.readLong(this.array, this.rangeStart + index);
    }
}