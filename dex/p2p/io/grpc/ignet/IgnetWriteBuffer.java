package p2p.io.grpc.ignet;

import com.google.common.base.Preconditions;
import io.grpc.internal.WritableBuffer;
import java.nio.ByteBuffer;

public class IgnetWriteBuffer implements WritableBuffer {
    private final ByteBuffer buffer;

    public IgnetWriteBuffer(ByteBuffer buffer) {
        this.buffer = (ByteBuffer) Preconditions.checkNotNull(buffer, "buffer");
    }

    public void write(byte[] src, int srcIndex, int length) {
        this.buffer.put(src, srcIndex, length);
    }

    public void write(byte b) {
        this.buffer.put(b);
    }

    public int writableBytes() {
        return this.buffer.remaining();
    }

    public int readableBytes() {
        return this.buffer.position();
    }

    public void release() {
    }

    ByteBuffer buffer() {
        return this.buffer;
    }
}