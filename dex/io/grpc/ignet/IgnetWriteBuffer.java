package io.grpc.ignet;

import com.google.common.base.Preconditions;
import io.grpc.internal.WritableBuffer;
import java.nio.ByteBuffer;

public class IgnetWriteBuffer implements WritableBuffer {
    private final ByteBuffer buffer;

    public IgnetWriteBuffer(ByteBuffer buffer) {
        this.buffer = (ByteBuffer) Preconditions.checkNotNull(buffer, "buffer");
    }

    @Override // io.grpc.internal.WritableBuffer
    public void write(byte[] src, int srcIndex, int length) {
        this.buffer.put(src, srcIndex, length);
    }

    @Override // io.grpc.internal.WritableBuffer
    public void write(byte b) {
        this.buffer.put(b);
    }

    @Override // io.grpc.internal.WritableBuffer
    public int writableBytes() {
        return this.buffer.remaining();
    }

    @Override // io.grpc.internal.WritableBuffer
    public int readableBytes() {
        return this.buffer.position();
    }

    @Override // io.grpc.internal.WritableBuffer
    public void release() {
    }

    ByteBuffer buffer() {
        return this.buffer;
    }
}