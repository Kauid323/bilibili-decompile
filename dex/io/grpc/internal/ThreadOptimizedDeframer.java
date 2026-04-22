package io.grpc.internal;

public interface ThreadOptimizedDeframer extends Deframer {
    @Override // io.grpc.internal.Deframer
    void request(int i2);
}