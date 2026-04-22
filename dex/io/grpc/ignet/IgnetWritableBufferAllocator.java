package io.grpc.ignet;

import io.grpc.internal.WritableBuffer;
import io.grpc.internal.WritableBufferAllocator;
import java.nio.ByteBuffer;

/* compiled from: IgnetWriteBuffer.java */
class IgnetWritableBufferAllocator implements WritableBufferAllocator {
    private static final int MAX_BUFFER = 1048576;

    IgnetWritableBufferAllocator() {
    }

    @Override // io.grpc.internal.WritableBufferAllocator
    public WritableBuffer allocate(int capacityHint) {
        return new IgnetWriteBuffer(ByteBuffer.allocateDirect(Math.min((int) MAX_BUFFER, capacityHint)));
    }
}