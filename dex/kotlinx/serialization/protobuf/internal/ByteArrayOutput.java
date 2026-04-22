package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Streams.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0000J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ByteArrayOutput;", "", "()V", "array", "", "position", "", "encodeVarint", "", "value", "", "length", "encodeVarint32", "encodeVarint64", "ensureCapacity", "elementsToAppend", "size", "toByteArray", "varIntLength", "write", "buffer", "output", "writeInt", "intValue", "writeLong", "longValue", "Companion", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ByteArrayOutput {
    private static final Companion Companion = new Companion(null);
    private static final int[] VAR_INT_LENGTHS;
    private byte[] array = new byte[32];
    private int position;

    /* compiled from: Streams.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ByteArrayOutput$Companion;", "", "()V", "VAR_INT_LENGTHS", "", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        int[] iArr = new int[65];
        for (int i = 0; i < 65; i++) {
            iArr[i] = (63 - i) / 7;
        }
        VAR_INT_LENGTHS = iArr;
    }

    private final void ensureCapacity(int elementsToAppend) {
        if (this.position + elementsToAppend <= this.array.length) {
            return;
        }
        byte[] newArray = new byte[Integer.highestOneBit(this.position + elementsToAppend) << 1];
        ArraysKt.copyInto$default(this.array, newArray, 0, 0, 0, 14, (Object) null);
        this.array = newArray;
    }

    public final int size() {
        return this.position;
    }

    public final byte[] toByteArray() {
        byte[] newArray = new byte[this.position];
        ArraysKt.copyInto$default(this.array, newArray, 0, 0, this.position, 2, (Object) null);
        return newArray;
    }

    public final void write(byte[] buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int count = buffer.length;
        if (count == 0) {
            return;
        }
        ensureCapacity(count);
        ArraysKt.copyInto(buffer, this.array, this.position, 0, count);
        this.position += count;
    }

    public final void write(ByteArrayOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        int count = output.size();
        ensureCapacity(count);
        ArraysKt.copyInto(output.array, this.array, this.position, 0, count);
        this.position += count;
    }

    public final void writeInt(int intValue) {
        ensureCapacity(4);
        for (int i = 3; -1 < i; i--) {
            byte[] bArr = this.array;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) (intValue >> (i * 8));
        }
    }

    public final void writeLong(long longValue) {
        ensureCapacity(8);
        for (int i = 7; -1 < i; i--) {
            byte[] bArr = this.array;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) (longValue >> (i * 8));
        }
    }

    public final void encodeVarint32(int value) {
        ensureCapacity(5);
        if ((value & (-128)) == 0) {
            byte[] bArr = this.array;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) value;
            return;
        }
        int length = varIntLength(value);
        encodeVarint(value, length);
    }

    public final void encodeVarint64(long value) {
        int length = varIntLength(value);
        ensureCapacity(length + 1);
        encodeVarint(value, length);
    }

    private final void encodeVarint(long value, int length) {
        long current = value;
        for (int i = 0; i < length; i++) {
            this.array[this.position + i] = (byte) ((127 & current) | 128);
            current >>>= 7;
        }
        this.array[this.position + length] = (byte) current;
        this.position += length + 1;
    }

    private final int varIntLength(long value) {
        return VAR_INT_LENGTHS[Long.numberOfLeadingZeros(value)];
    }
}