package kotlinx.io.bytestring;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteStringBuilder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0003J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkotlinx/io/bytestring/ByteStringBuilder;", "", "initialCapacity", "", "<init>", "(I)V", "buffer", "", "offset", "size", "getSize", "()I", "capacity", "getCapacity", "toByteString", "Lkotlinx/io/bytestring/ByteString;", "append", "", "byte", "", "array", "startIndex", "endIndex", "ensureCapacity", "requiredCapacity", "kotlinx-io-bytestring"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ByteStringBuilder {
    private byte[] buffer;
    private int offset;

    public ByteStringBuilder() {
        this(0, 1, null);
    }

    public ByteStringBuilder(int initialCapacity) {
        this.buffer = new byte[initialCapacity];
    }

    public /* synthetic */ ByteStringBuilder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getSize() {
        return this.offset;
    }

    public final int getCapacity() {
        return this.buffer.length;
    }

    public final ByteString toByteString() {
        if (getSize() == 0) {
            return ByteStringKt.ByteString();
        }
        if (this.buffer.length == getSize()) {
            return ByteString.Companion.wrap$kotlinx_io_bytestring(this.buffer);
        }
        return new ByteString(this.buffer, 0, getSize());
    }

    public final void append(byte b) {
        ensureCapacity(getSize() + 1);
        byte[] bArr = this.buffer;
        int i = this.offset;
        this.offset = i + 1;
        bArr[i] = b;
    }

    public static /* synthetic */ void append$default(ByteStringBuilder byteStringBuilder, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        byteStringBuilder.append(bArr, i, i2);
    }

    public final void append(byte[] array, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (!(startIndex <= endIndex)) {
            throw new IllegalArgumentException(("startIndex (" + startIndex + ") > endIndex (" + endIndex + ')').toString());
        }
        if (startIndex < 0 || endIndex > array.length) {
            throw new IndexOutOfBoundsException("startIndex (" + startIndex + ") and endIndex (" + endIndex + ") represents an interval out of array's bounds [0.." + array.length + ").");
        }
        ensureCapacity((this.offset + endIndex) - startIndex);
        ArraysKt.copyInto(array, this.buffer, this.offset, startIndex, endIndex);
        this.offset += endIndex - startIndex;
    }

    private final void ensureCapacity(int requiredCapacity) {
        if (this.buffer.length >= requiredCapacity) {
            return;
        }
        int desiredSize = this.buffer.length == 0 ? 16 : (int) (this.buffer.length * 1.5d);
        byte[] newBuffer = new byte[Math.max(desiredSize, requiredCapacity)];
        ArraysKt.copyInto$default(this.buffer, newBuffer, 0, 0, 0, 14, (Object) null);
        this.buffer = newBuffer;
    }
}