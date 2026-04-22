package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import kotlinx.serialization.SerializationException;
import nl.adaptivity.xmlutil.core.KtXmlReader;

/* compiled from: Streams.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/protobuf/internal/ByteArrayInput;", "", "array", "", "endIndex", "", "([BI)V", "availableBytes", "getAvailableBytes", "()I", "position", "ensureEnoughBytes", "", "bytesCount", "eof", "read", "readExactNBytes", "readString", "", "length", "readVarint32", "readVarint32SlowPath", "readVarint64", "", "eofAllowed", "", "readVarint64SlowPath", "slice", "size", "kotlinx-serialization-protobuf"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ByteArrayInput {
    private byte[] array;
    private final int endIndex;
    private int position;

    public ByteArrayInput(byte[] array, int endIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.array = array;
        this.endIndex = endIndex;
    }

    public /* synthetic */ ByteArrayInput(byte[] bArr, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i2 & 2) != 0 ? bArr.length : i);
    }

    public final int getAvailableBytes() {
        return this.endIndex - this.position;
    }

    public final ByteArrayInput slice(int size) {
        ensureEnoughBytes(size);
        ByteArrayInput result = new ByteArrayInput(this.array, this.position + size);
        result.position = this.position;
        this.position += size;
        return result;
    }

    public final int read() {
        if (this.position < this.endIndex) {
            byte[] bArr = this.array;
            int i = this.position;
            this.position = i + 1;
            return bArr[i] & 255;
        }
        return -1;
    }

    public final byte[] readExactNBytes(int bytesCount) {
        ensureEnoughBytes(bytesCount);
        byte[] b = new byte[bytesCount];
        int length = b.length;
        int copied = this.endIndex - this.position < length ? this.endIndex - this.position : length;
        ArraysKt.copyInto(this.array, b, 0, this.position, this.position + copied);
        this.position += copied;
        return b;
    }

    private final void ensureEnoughBytes(int bytesCount) {
        if (bytesCount > getAvailableBytes()) {
            throw new SerializationException("Unexpected EOF, available " + getAvailableBytes() + " bytes, requested: " + bytesCount);
        }
    }

    public final String readString(int length) {
        String result = StringsKt.decodeToString$default(this.array, this.position, this.position + length, false, 4, null);
        this.position += length;
        return result;
    }

    public final int readVarint32() {
        if (this.position == this.endIndex) {
            eof();
        }
        int currentPosition = this.position;
        int currentPosition2 = currentPosition + 1;
        int result = this.array[currentPosition];
        if (result >= 0) {
            this.position = currentPosition2;
            return result;
        }
        if (this.endIndex - this.position > 1) {
            int currentPosition3 = currentPosition2 + 1;
            int result2 = result ^ (this.array[currentPosition2] << 7);
            if (result2 < 0) {
                this.position = currentPosition3;
                return result2 ^ (-128);
            }
        }
        return readVarint32SlowPath();
    }

    public final long readVarint64(boolean eofAllowed) {
        if (this.position == this.endIndex) {
            if (eofAllowed) {
                return -1L;
            }
            eof();
        }
        int currentPosition = this.position;
        int currentPosition2 = currentPosition + 1;
        long result = this.array[currentPosition];
        if (result >= 0) {
            this.position = currentPosition2;
            return result;
        }
        if (this.endIndex - this.position > 1) {
            int currentPosition3 = currentPosition2 + 1;
            long result2 = result ^ (this.array[currentPosition2] << 7);
            if (result2 < 0) {
                this.position = currentPosition3;
                return (-128) ^ result2;
            }
        }
        return readVarint64SlowPath();
    }

    private final void eof() {
        throw new SerializationException(KtXmlReader.UNEXPECTED_EOF);
    }

    private final long readVarint64SlowPath() {
        long result = 0;
        for (int shift = 0; shift < 64; shift += 7) {
            int read = read();
            result |= (read & WorkQueueKt.MASK) << shift;
            if ((read & 128) == 0) {
                return result;
            }
        }
        throw new SerializationException("Input stream is malformed: Varint too long (exceeded 64 bits)");
    }

    private final int readVarint32SlowPath() {
        int result = 0;
        for (int shift = 0; shift < 32; shift += 7) {
            int read = read();
            result |= (read & WorkQueueKt.MASK) << shift;
            if ((read & 128) == 0) {
                return result;
            }
        }
        throw new SerializationException("Input stream is malformed: Varint too long (exceeded 32 bits)");
    }
}