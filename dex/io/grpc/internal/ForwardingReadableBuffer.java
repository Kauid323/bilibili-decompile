package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public abstract class ForwardingReadableBuffer implements ReadableBuffer {
    private final ReadableBuffer buf;

    /* JADX INFO: Access modifiers changed from: protected */
    public ForwardingReadableBuffer(ReadableBuffer buf) {
        this.buf = (ReadableBuffer) Preconditions.checkNotNull(buf, "buf");
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return this.buf.readableBytes();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readInt() {
        return this.buf.readInt();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int length) {
        this.buf.skipBytes(length);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(byte[] dest, int destOffset, int length) {
        this.buf.readBytes(dest, destOffset, length);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(ByteBuffer dest) {
        this.buf.readBytes(dest);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(OutputStream dest, int length) throws IOException {
        this.buf.readBytes(dest, length);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public ReadableBuffer readBytes(int length) {
        return this.buf.readBytes(length);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public boolean hasArray() {
        return this.buf.hasArray();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public byte[] array() {
        return this.buf.array();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    @Override // io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.buf.close();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.buf).toString();
    }
}