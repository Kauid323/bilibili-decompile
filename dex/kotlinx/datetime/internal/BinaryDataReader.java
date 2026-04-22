package kotlinx.datetime.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BinaryDataReader.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u0013\u0010\u0011\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Lkotlinx/datetime/internal/BinaryDataReader;", "", "bytes", "", "position", "", "([BI)V", "readAsciiChar", "", "readByte", "", "readInt", "readLong", "", "readNullTerminatedUtf8String", "", "fieldSize", "readUnsignedByte", "Lkotlin/UByte;", "readUnsignedByte-w2LRezQ", "()B", "readUtf8String", "exactLength", "skip", "", "length", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BinaryDataReader {
    private final byte[] bytes;
    private int position;

    public BinaryDataReader(byte[] bytes, int position) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
        this.position = position;
    }

    public /* synthetic */ BinaryDataReader(byte[] bArr, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i2 & 2) != 0 ? 0 : i);
    }

    public final byte readByte() {
        byte[] bArr = this.bytes;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    /* renamed from: readUnsignedByte-w2LRezQ  reason: not valid java name */
    public final byte m1489readUnsignedBytew2LRezQ() {
        return UByte.constructor-impl(readByte());
    }

    public final int readInt() {
        this.position += 4;
        Unit unit = Unit.INSTANCE;
        return ((this.bytes[this.position] & 255) << 24) | ((this.bytes[this.position + 1] & 255) << 16) | ((this.bytes[this.position + 2] & 255) << 8) | (this.bytes[this.position + 3] & 255);
    }

    public final long readLong() {
        long j = ((this.bytes[this.position] & 255) << 56) | ((this.bytes[this.position + 1] & 255) << 48) | ((this.bytes[this.position + 2] & 255) << 40) | ((this.bytes[this.position + 3] & 255) << 32) | ((this.bytes[this.position + 4] & 255) << 24) | ((this.bytes[this.position + 5] & 255) << 16) | ((this.bytes[this.position + 6] & 255) << 8);
        long j2 = 255 & this.bytes[this.position + 7];
        this.position += 8;
        Unit unit = Unit.INSTANCE;
        return j | j2;
    }

    public final String readUtf8String(int exactLength) {
        String decodeToString$default = StringsKt.decodeToString$default(this.bytes, this.position, this.position + exactLength, false, 4, null);
        this.position += exactLength;
        return decodeToString$default;
    }

    public final String readNullTerminatedUtf8String(int fieldSize) {
        int exactLength = 0;
        while (this.position + exactLength < this.bytes.length && this.bytes[this.position + exactLength] != 0 && exactLength < fieldSize) {
            exactLength++;
        }
        String decodeToString$default = StringsKt.decodeToString$default(this.bytes, this.position, this.position + exactLength, false, 4, null);
        this.position += fieldSize;
        return decodeToString$default;
    }

    public final char readAsciiChar() {
        return (char) readByte();
    }

    public final void skip(int length) {
        this.position += length;
    }
}