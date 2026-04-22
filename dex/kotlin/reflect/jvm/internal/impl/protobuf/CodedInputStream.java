package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public final class CodedInputStream {
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface RefillCallback {
        void onRefill();
    }

    public static CodedInputStream newInstance(InputStream input) {
        return new CodedInputStream(input);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(LiteralByteString byteString) {
        CodedInputStream result = new CodedInputStream(byteString);
        try {
            result.pushLimit(byteString.size());
            return result;
        } catch (InvalidProtocolBufferException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = readRawVarint32();
        if (WireFormat.getTagFieldNumber(this.lastTag) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        return this.lastTag;
    }

    public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
        if (this.lastTag != value) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public boolean skipField(int tag, CodedOutputStream output) throws IOException {
        switch (WireFormat.getTagWireType(tag)) {
            case 0:
                long value = readInt64();
                output.writeRawVarint32(tag);
                output.writeUInt64NoTag(value);
                return true;
            case 1:
                long value2 = readRawLittleEndian64();
                output.writeRawVarint32(tag);
                output.writeFixed64NoTag(value2);
                return true;
            case 2:
                ByteString value3 = readBytes();
                output.writeRawVarint32(tag);
                output.writeBytesNoTag(value3);
                return true;
            case 3:
                output.writeRawVarint32(tag);
                skipMessage(output);
                int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                checkLastTagWas(endtag);
                output.writeRawVarint32(endtag);
                return true;
            case 4:
                return false;
            case 5:
                int value4 = readRawLittleEndian32();
                output.writeRawVarint32(tag);
                output.writeFixed32NoTag(value4);
                return true;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public void skipMessage(CodedOutputStream output) throws IOException {
        int tag;
        do {
            tag = readTag();
            if (tag == 0) {
                return;
            }
        } while (skipField(tag, output));
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public boolean readBool() throws IOException {
        return readRawVarint64() != 0;
    }

    public String readString() throws IOException {
        int size = readRawVarint32();
        if (size <= this.bufferSize - this.bufferPos && size > 0) {
            String result = new String(this.buffer, this.bufferPos, size, "UTF-8");
            this.bufferPos += size;
            return result;
        } else if (size == 0) {
            return "";
        } else {
            return new String(readRawBytesSlowPath(size), "UTF-8");
        }
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] bytes;
        int size = readRawVarint32();
        int pos = this.bufferPos;
        if (size <= this.bufferSize - pos && size > 0) {
            bytes = this.buffer;
            this.bufferPos = pos + size;
        } else if (size == 0) {
            return "";
        } else {
            bytes = readRawBytesSlowPath(size);
            pos = 0;
        }
        if (!Utf8.isValidUtf8(bytes, pos, pos + size)) {
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        return new String(bytes, pos, size, "UTF-8");
    }

    public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        this.recursionDepth++;
        builder.mergeFrom(this, extensionRegistry);
        checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
        this.recursionDepth--;
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
        int length = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int oldLimit = pushLimit(length);
        this.recursionDepth++;
        builder.mergeFrom(this, extensionRegistry);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(oldLimit);
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
        int length = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int oldLimit = pushLimit(length);
        this.recursionDepth++;
        T result = parser.parsePartialFrom(this, extensionRegistry);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(oldLimit);
        return result;
    }

    public ByteString readBytes() throws IOException {
        int size = readRawVarint32();
        if (size <= this.bufferSize - this.bufferPos && size > 0) {
            ByteString result = (this.bufferIsImmutable && this.enableAliasing) ? new BoundedByteString(this.buffer, this.bufferPos, size) : ByteString.copyFrom(this.buffer, this.bufferPos, size);
            this.bufferPos += size;
            return result;
        } else if (size == 0) {
            return ByteString.EMPTY;
        } else {
            return new LiteralByteString(readRawBytesSlowPath(size));
        }
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
        if (r1[r2] < 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int readRawVarint32() throws IOException {
        int pos;
        int pos2 = this.bufferPos;
        if (this.bufferSize != pos2) {
            byte[] buffer = this.buffer;
            int pos3 = pos2 + 1;
            int x = buffer[pos2];
            if (x >= 0) {
                this.bufferPos = pos3;
                return x;
            } else if (this.bufferSize - pos3 >= 9) {
                int pos4 = pos3 + 1;
                int x2 = (buffer[pos3] << 7) ^ x;
                if (x2 < 0) {
                    pos = (int) (x2 ^ (-128));
                } else {
                    int x3 = pos4 + 1;
                    int x4 = (buffer[pos4] << 14) ^ x2;
                    if (x4 >= 0) {
                        pos = (int) (x4 ^ 16256);
                        pos4 = x3;
                    } else {
                        pos4 = x3 + 1;
                        int x5 = (buffer[x3] << 21) ^ x4;
                        if (x5 < 0) {
                            pos = (int) (x5 ^ (-2080896));
                        } else {
                            int pos5 = pos4 + 1;
                            int y = buffer[pos4];
                            int x6 = (int) ((x5 ^ (y << 28)) ^ 266354560);
                            if (y < 0) {
                                int pos6 = pos5 + 1;
                                if (buffer[pos5] < 0) {
                                    pos5 = pos6 + 1;
                                    if (buffer[pos6] < 0) {
                                        pos6 = pos5 + 1;
                                        if (buffer[pos5] < 0) {
                                            pos5 = pos6 + 1;
                                            if (buffer[pos6] < 0) {
                                                pos6 = pos5 + 1;
                                            }
                                        }
                                    }
                                }
                                pos = x6;
                                pos4 = pos6;
                            }
                            pos4 = pos5;
                            pos = x6;
                        }
                    }
                }
                this.bufferPos = pos4;
                return pos;
            }
        }
        return (int) readRawVarint64SlowPath();
    }

    public static int readRawVarint32(int firstByte, InputStream input) throws IOException {
        if ((firstByte & 128) == 0) {
            return firstByte;
        }
        int result = firstByte & WorkQueueKt.MASK;
        int offset = 7;
        while (offset < 32) {
            int b = input.read();
            if (b == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            result |= (b & WorkQueueKt.MASK) << offset;
            if ((b & 128) != 0) {
                offset += 7;
            } else {
                return result;
            }
        }
        while (offset < 64) {
            int b2 = input.read();
            if (b2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((b2 & 128) != 0) {
                offset += 7;
            } else {
                return result;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c6, code lost:
        if (r1[r2] < 0) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readRawVarint64() throws IOException {
        long x;
        int pos = this.bufferPos;
        if (this.bufferSize != pos) {
            byte[] buffer = this.buffer;
            int pos2 = pos + 1;
            int y = buffer[pos];
            if (y >= 0) {
                this.bufferPos = pos2;
                return y;
            } else if (this.bufferSize - pos2 >= 9) {
                int pos3 = pos2 + 1;
                long x2 = (buffer[pos2] << 7) ^ y;
                if (x2 < 0) {
                    x = (-128) ^ x2;
                } else {
                    int pos4 = pos3 + 1;
                    long x3 = (buffer[pos3] << 14) ^ x2;
                    if (x3 >= 0) {
                        x = 16256 ^ x3;
                        pos3 = pos4;
                    } else {
                        pos3 = pos4 + 1;
                        long x4 = (buffer[pos4] << 21) ^ x3;
                        if (x4 < 0) {
                            x = (-2080896) ^ x4;
                        } else {
                            int pos5 = pos3 + 1;
                            long x5 = (buffer[pos3] << 28) ^ x4;
                            if (x5 >= 0) {
                                x = 266354560 ^ x5;
                                pos3 = pos5;
                            } else {
                                pos3 = pos5 + 1;
                                long x6 = (buffer[pos5] << 35) ^ x5;
                                if (x6 < 0) {
                                    x = (-34093383808L) ^ x6;
                                } else {
                                    int pos6 = pos3 + 1;
                                    long x7 = (buffer[pos3] << 42) ^ x6;
                                    if (x7 >= 0) {
                                        x = 4363953127296L ^ x7;
                                        pos3 = pos6;
                                    } else {
                                        pos3 = pos6 + 1;
                                        long x8 = (buffer[pos6] << 49) ^ x7;
                                        if (x8 < 0) {
                                            x = (-558586000294016L) ^ x8;
                                        } else {
                                            int pos7 = pos3 + 1;
                                            x = ((buffer[pos3] << 56) ^ x8) ^ 71499008037633920L;
                                            if (x >= 0) {
                                                pos3 = pos7;
                                            } else {
                                                pos3 = pos7 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.bufferPos = pos3;
                return x;
            }
        }
        return readRawVarint64SlowPath();
    }

    long readRawVarint64SlowPath() throws IOException {
        long result = 0;
        for (int shift = 0; shift < 64; shift += 7) {
            byte b = readRawByte();
            result |= (b & Byte.MAX_VALUE) << shift;
            if ((b & 128) == 0) {
                return result;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readRawLittleEndian32() throws IOException {
        int pos = this.bufferPos;
        if (this.bufferSize - pos < 4) {
            refillBuffer(4);
            pos = this.bufferPos;
        }
        byte[] buffer = this.buffer;
        this.bufferPos = pos + 4;
        return (buffer[pos] & 255) | ((buffer[pos + 1] & 255) << 8) | ((buffer[pos + 2] & 255) << 16) | ((buffer[pos + 3] & 255) << 24);
    }

    public long readRawLittleEndian64() throws IOException {
        int pos = this.bufferPos;
        if (this.bufferSize - pos < 8) {
            refillBuffer(8);
            pos = this.bufferPos;
        }
        byte[] buffer = this.buffer;
        this.bufferPos = pos + 8;
        return (buffer[pos] & 255) | ((buffer[pos + 1] & 255) << 8) | ((buffer[pos + 2] & 255) << 16) | ((buffer[pos + 3] & 255) << 24) | ((buffer[pos + 4] & 255) << 32) | ((buffer[pos + 5] & 255) << 40) | ((buffer[pos + 6] & 255) << 48) | ((buffer[pos + 7] & 255) << 56);
    }

    public static int decodeZigZag32(int n) {
        return (n >>> 1) ^ (-(n & 1));
    }

    public static long decodeZigZag64(long n) {
        return (n >>> 1) ^ (-(1 & n));
    }

    private CodedInputStream(InputStream input) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = input;
        this.bufferIsImmutable = false;
    }

    private CodedInputStream(LiteralByteString byteString) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = byteString.bytes;
        this.bufferPos = byteString.getOffsetIntoBytes();
        this.bufferSize = this.bufferPos + byteString.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
        if (byteLimit < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int byteLimit2 = byteLimit + this.totalBytesRetired + this.bufferPos;
        int oldLimit = this.currentLimit;
        if (byteLimit2 > oldLimit) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.currentLimit = byteLimit2;
        recomputeBufferSizeAfterLimit();
        return oldLimit;
    }

    private void recomputeBufferSizeAfterLimit() {
        this.bufferSize += this.bufferSizeAfterLimit;
        int bufferEnd = this.totalBytesRetired + this.bufferSize;
        if (bufferEnd > this.currentLimit) {
            this.bufferSizeAfterLimit = bufferEnd - this.currentLimit;
            this.bufferSize -= this.bufferSizeAfterLimit;
            return;
        }
        this.bufferSizeAfterLimit = 0;
    }

    public void popLimit(int oldLimit) {
        this.currentLimit = oldLimit;
        recomputeBufferSizeAfterLimit();
    }

    public int getBytesUntilLimit() {
        if (this.currentLimit == Integer.MAX_VALUE) {
            return -1;
        }
        int currentAbsolutePosition = this.totalBytesRetired + this.bufferPos;
        return this.currentLimit - currentAbsolutePosition;
    }

    public boolean isAtEnd() throws IOException {
        return this.bufferPos == this.bufferSize && !tryRefillBuffer(1);
    }

    private void ensureAvailable(int n) throws IOException {
        if (this.bufferSize - this.bufferPos < n) {
            refillBuffer(n);
        }
    }

    private void refillBuffer(int n) throws IOException {
        if (!tryRefillBuffer(n)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private boolean tryRefillBuffer(int n) throws IOException {
        if (this.bufferPos + n <= this.bufferSize) {
            throw new IllegalStateException(new StringBuilder(77).append("refillBuffer() called when ").append(n).append(" bytes were already available in buffer").toString());
        }
        if (this.totalBytesRetired + this.bufferPos + n > this.currentLimit) {
            return false;
        }
        if (this.refillCallback != null) {
            this.refillCallback.onRefill();
        }
        if (this.input != null) {
            int pos = this.bufferPos;
            if (pos > 0) {
                if (this.bufferSize > pos) {
                    System.arraycopy(this.buffer, pos, this.buffer, 0, this.bufferSize - pos);
                }
                this.totalBytesRetired += pos;
                this.bufferSize -= pos;
                this.bufferPos = 0;
            }
            int bytesRead = this.input.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize);
            if (bytesRead == 0 || bytesRead < -1 || bytesRead > this.buffer.length) {
                throw new IllegalStateException(new StringBuilder(102).append("InputStream#read(byte[]) returned invalid result: ").append(bytesRead).append("\nThe InputStream implementation is buggy.").toString());
            }
            if (bytesRead > 0) {
                this.bufferSize += bytesRead;
                if ((this.totalBytesRetired + n) - this.sizeLimit > 0) {
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
                recomputeBufferSizeAfterLimit();
                if (this.bufferSize >= n) {
                    return true;
                }
                return tryRefillBuffer(n);
            }
        }
        return false;
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(1);
        }
        byte[] bArr = this.buffer;
        int i = this.bufferPos;
        this.bufferPos = i + 1;
        return bArr[i];
    }

    private byte[] readRawBytesSlowPath(int size) throws IOException {
        if (size <= 0) {
            if (size == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        } else if (this.totalBytesRetired + this.bufferPos + size > this.currentLimit) {
            skipRawBytes((this.currentLimit - this.totalBytesRetired) - this.bufferPos);
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (size < 4096) {
            byte[] bytes = new byte[size];
            int pos = this.bufferSize - this.bufferPos;
            System.arraycopy(this.buffer, this.bufferPos, bytes, 0, pos);
            this.bufferPos = this.bufferSize;
            ensureAvailable(size - pos);
            System.arraycopy(this.buffer, 0, bytes, pos, size - pos);
            this.bufferPos = size - pos;
            return bytes;
        } else {
            int pos2 = this.bufferPos;
            int originalBufferSize = this.bufferSize;
            this.totalBytesRetired += this.bufferSize;
            this.bufferPos = 0;
            this.bufferSize = 0;
            int sizeLeft = size - (originalBufferSize - pos2);
            List<byte[]> chunks = new ArrayList<>();
            while (sizeLeft > 0) {
                byte[] chunk = new byte[Math.min(sizeLeft, 4096)];
                int pos3 = 0;
                while (pos3 < chunk.length) {
                    int n = this.input == null ? -1 : this.input.read(chunk, pos3, chunk.length - pos3);
                    if (n == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += n;
                    pos3 += n;
                }
                sizeLeft -= chunk.length;
                chunks.add(chunk);
            }
            byte[] bytes2 = new byte[size];
            int pos4 = originalBufferSize - pos2;
            System.arraycopy(this.buffer, pos2, bytes2, 0, pos4);
            for (byte[] chunk2 : chunks) {
                System.arraycopy(chunk2, 0, bytes2, pos4, chunk2.length);
                pos4 += chunk2.length;
            }
            return bytes2;
        }
    }

    public void skipRawBytes(int size) throws IOException {
        if (size <= this.bufferSize - this.bufferPos && size >= 0) {
            this.bufferPos += size;
        } else {
            skipRawBytesSlowPath(size);
        }
    }

    private void skipRawBytesSlowPath(int size) throws IOException {
        if (size < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (this.totalBytesRetired + this.bufferPos + size > this.currentLimit) {
            int pos = this.currentLimit;
            skipRawBytes((pos - this.totalBytesRetired) - this.bufferPos);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int pos2 = this.bufferSize - this.bufferPos;
        this.bufferPos = this.bufferSize;
        refillBuffer(1);
        while (size - pos2 > this.bufferSize) {
            pos2 += this.bufferSize;
            this.bufferPos = this.bufferSize;
            refillBuffer(1);
        }
        this.bufferPos = size - pos2;
    }
}