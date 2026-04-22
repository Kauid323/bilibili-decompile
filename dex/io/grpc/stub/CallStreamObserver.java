package io.grpc.stub;

public abstract class CallStreamObserver<V> implements StreamObserver<V> {
    public abstract void disableAutoInboundFlowControl();

    public abstract boolean isReady();

    public abstract void request(int i2);

    public abstract void setMessageCompression(boolean z);

    public abstract void setOnReadyHandler(Runnable runnable);
}