package io.grpc;

import com.google.common.base.MoreObjects;
import io.grpc.ServerBuilder;
import io.grpc.ServerStreamTracer;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract class ForwardingServerBuilder<T extends ServerBuilder<T>> extends ServerBuilder<T> {
    protected abstract ServerBuilder<?> delegate();

    protected ForwardingServerBuilder() {
    }

    public static ServerBuilder<?> forPort(int port) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    @Override // io.grpc.ServerBuilder
    public T directExecutor() {
        delegate().directExecutor();
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T executor(@Nullable Executor executor) {
        delegate().executor(executor);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T addService(ServerServiceDefinition service) {
        delegate().addService(service);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T addService(BindableService bindableService) {
        delegate().addService(bindableService);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T intercept(ServerInterceptor interceptor) {
        delegate().intercept(interceptor);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T addTransportFilter(ServerTransportFilter filter) {
        delegate().addTransportFilter(filter);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T addStreamTracerFactory(ServerStreamTracer.Factory factory) {
        delegate().addStreamTracerFactory(factory);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T fallbackHandlerRegistry(@Nullable HandlerRegistry fallbackRegistry) {
        delegate().fallbackHandlerRegistry(fallbackRegistry);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T useTransportSecurity(File certChain, File privateKey) {
        delegate().useTransportSecurity(certChain, privateKey);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T useTransportSecurity(InputStream certChain, InputStream privateKey) {
        delegate().useTransportSecurity(certChain, privateKey);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T decompressorRegistry(@Nullable DecompressorRegistry registry) {
        delegate().decompressorRegistry(registry);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T compressorRegistry(@Nullable CompressorRegistry registry) {
        delegate().compressorRegistry(registry);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T handshakeTimeout(long timeout, TimeUnit unit) {
        delegate().handshakeTimeout(timeout, unit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxInboundMessageSize(int bytes) {
        delegate().maxInboundMessageSize(bytes);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxInboundMetadataSize(int bytes) {
        delegate().maxInboundMetadataSize(bytes);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T setBinaryLog(BinaryLog binaryLog) {
        delegate().setBinaryLog(binaryLog);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public Server build() {
        return delegate().build();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }

    private T thisT() {
        return this;
    }
}