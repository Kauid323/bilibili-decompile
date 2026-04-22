package io.grpc.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public interface ReadableBuffer extends Closeable {
    byte[] array();

    int arrayOffset();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean hasArray();

    ReadableBuffer readBytes(int i2);

    void readBytes(OutputStream outputStream, int i2) throws IOException;

    void readBytes(ByteBuffer byteBuffer);

    void readBytes(byte[] bArr, int i2, int i3);

    int readInt();

    int readUnsignedByte();

    int readableBytes();

    void skipBytes(int i2);
}