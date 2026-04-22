package io.grpc.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

public class CompositeReadableBuffer extends AbstractReadableBuffer {
    private final Queue<ReadableBuffer> buffers;
    private int readableBytes;
    private static final NoThrowReadOperation<Void> UBYTE_OP = new NoThrowReadOperation<Void>() { // from class: io.grpc.internal.CompositeReadableBuffer.1
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer buffer, int length, Void unused, int value) {
            return buffer.readUnsignedByte();
        }
    };
    private static final NoThrowReadOperation<Void> SKIP_OP = new NoThrowReadOperation<Void>() { // from class: io.grpc.internal.CompositeReadableBuffer.2
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer buffer, int length, Void unused, int unused2) {
            buffer.skipBytes(length);
            return 0;
        }
    };
    private static final NoThrowReadOperation<byte[]> BYTE_ARRAY_OP = new NoThrowReadOperation<byte[]>() { // from class: io.grpc.internal.CompositeReadableBuffer.3
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer buffer, int length, byte[] dest, int offset) {
            buffer.readBytes(dest, offset, length);
            return offset + length;
        }
    };
    private static final NoThrowReadOperation<ByteBuffer> BYTE_BUF_OP = new NoThrowReadOperation<ByteBuffer>() { // from class: io.grpc.internal.CompositeReadableBuffer.4
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer buffer, int length, ByteBuffer dest, int unused) {
            int prevLimit = dest.limit();
            dest.limit(dest.position() + length);
            buffer.readBytes(dest);
            dest.limit(prevLimit);
            return 0;
        }
    };
    private static final ReadOperation<OutputStream> STREAM_OP = new ReadOperation<OutputStream>() { // from class: io.grpc.internal.CompositeReadableBuffer.5
        @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer buffer, int length, OutputStream dest, int unused) throws IOException {
            buffer.readBytes(dest, length);
            return 0;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface NoThrowReadOperation<T> extends ReadOperation<T> {
        @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
        int read(ReadableBuffer readableBuffer, int i2, T t, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface ReadOperation<T> {
        int read(ReadableBuffer readableBuffer, int i2, T t, int i3) throws IOException;
    }

    public CompositeReadableBuffer(int initialCapacity) {
        this.buffers = new ArrayDeque(initialCapacity);
    }

    public CompositeReadableBuffer() {
        this.buffers = new ArrayDeque();
    }

    public void addBuffer(ReadableBuffer buffer) {
        if (!(buffer instanceof CompositeReadableBuffer)) {
            this.buffers.add(buffer);
            this.readableBytes += buffer.readableBytes();
            return;
        }
        CompositeReadableBuffer compositeBuffer = (CompositeReadableBuffer) buffer;
        while (!compositeBuffer.buffers.isEmpty()) {
            ReadableBuffer subBuffer = compositeBuffer.buffers.remove();
            this.buffers.add(subBuffer);
        }
        this.readableBytes += compositeBuffer.readableBytes;
        compositeBuffer.readableBytes = 0;
        compositeBuffer.close();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return this.readableBytes;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        return executeNoThrow(UBYTE_OP, 1, null, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int length) {
        executeNoThrow(SKIP_OP, length, null, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(byte[] dest, int destOffset, int length) {
        executeNoThrow(BYTE_ARRAY_OP, length, dest, destOffset);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(ByteBuffer dest) {
        executeNoThrow(BYTE_BUF_OP, dest.remaining(), dest, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(OutputStream dest, int length) throws IOException {
        execute(STREAM_OP, length, dest, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public ReadableBuffer readBytes(int length) {
        ReadableBuffer readBuffer;
        if (length <= 0) {
            return ReadableBuffers.empty();
        }
        checkReadable(length);
        this.readableBytes -= length;
        ReadableBuffer newBuffer = null;
        CompositeReadableBuffer newComposite = null;
        do {
            ReadableBuffer buffer = this.buffers.peek();
            int readable = buffer.readableBytes();
            if (readable > length) {
                readBuffer = buffer.readBytes(length);
                length = 0;
            } else {
                readBuffer = this.buffers.poll();
                length -= readable;
            }
            if (newBuffer == null) {
                newBuffer = readBuffer;
                continue;
            } else {
                if (newComposite == null) {
                    newComposite = new CompositeReadableBuffer(length != 0 ? Math.min(this.buffers.size() + 2, 16) : 2);
                    newComposite.addBuffer(newBuffer);
                    newBuffer = newComposite;
                }
                newComposite.addBuffer(readBuffer);
                continue;
            }
        } while (length > 0);
        return newBuffer;
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.buffers.isEmpty()) {
            this.buffers.remove().close();
        }
    }

    private <T> int execute(ReadOperation<T> op, int length, T dest, int value) throws IOException {
        checkReadable(length);
        if (!this.buffers.isEmpty()) {
            advanceBufferIfNecessary();
        }
        while (length > 0 && !this.buffers.isEmpty()) {
            ReadableBuffer buffer = this.buffers.peek();
            int lengthToCopy = Math.min(length, buffer.readableBytes());
            value = op.read(buffer, lengthToCopy, dest, value);
            length -= lengthToCopy;
            this.readableBytes -= lengthToCopy;
            advanceBufferIfNecessary();
        }
        if (length > 0) {
            throw new AssertionError("Failed executing read operation");
        }
        return value;
    }

    private <T> int executeNoThrow(NoThrowReadOperation<T> op, int length, T dest, int value) {
        try {
            return execute(op, length, dest, value);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    private void advanceBufferIfNecessary() {
        ReadableBuffer buffer = this.buffers.peek();
        if (buffer.readableBytes() == 0) {
            this.buffers.remove().close();
        }
    }
}