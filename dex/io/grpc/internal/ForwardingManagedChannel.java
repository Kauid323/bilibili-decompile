package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.util.concurrent.TimeUnit;

abstract class ForwardingManagedChannel extends ManagedChannel {
    private final ManagedChannel delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ForwardingManagedChannel(ManagedChannel delegate) {
        this.delegate = delegate;
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdown() {
        return this.delegate.shutdown();
    }

    @Override // io.grpc.ManagedChannel
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // io.grpc.ManagedChannel
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override // io.grpc.ManagedChannel
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.delegate.awaitTermination(timeout, unit);
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return this.delegate.newCall(methodDescriptor, callOptions);
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.delegate.authority();
    }

    @Override // io.grpc.ManagedChannel
    public ConnectivityState getState(boolean requestConnection) {
        return this.delegate.getState(requestConnection);
    }

    @Override // io.grpc.ManagedChannel
    public void notifyWhenStateChanged(ConnectivityState source, Runnable callback) {
        this.delegate.notifyWhenStateChanged(source, callback);
    }

    @Override // io.grpc.ManagedChannel
    public void resetConnectBackoff() {
        this.delegate.resetConnectBackoff();
    }

    @Override // io.grpc.ManagedChannel
    public void enterIdle() {
        this.delegate.enterIdle();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.delegate).toString();
    }
}