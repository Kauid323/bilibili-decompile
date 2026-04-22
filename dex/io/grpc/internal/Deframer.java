package io.grpc.internal;

import io.grpc.Decompressor;

public interface Deframer {
    void close();

    void closeWhenComplete();

    void deframe(ReadableBuffer readableBuffer);

    void request(int i2);

    void setDecompressor(Decompressor decompressor);

    void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer);

    void setMaxInboundMessageSize(int i2);
}