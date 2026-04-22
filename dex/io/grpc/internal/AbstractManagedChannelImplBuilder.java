package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.BinaryLog;
import io.grpc.ClientInterceptor;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.ProxyDetector;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract class AbstractManagedChannelImplBuilder<T extends ManagedChannelBuilder<T>> extends ManagedChannelBuilder<T> {
    protected abstract ManagedChannelBuilder<?> delegate();

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelBuilder defaultServiceConfig(@Nullable Map map) {
        return defaultServiceConfig((Map<String, ?>) map);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelBuilder intercept(List list) {
        return intercept((List<ClientInterceptor>) list);
    }

    public static ManagedChannelBuilder<?> forAddress(String name, int port) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    public static ManagedChannelBuilder<?> forTarget(String target) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T directExecutor() {
        delegate().directExecutor();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T executor(Executor executor) {
        delegate().executor(executor);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T offloadExecutor(Executor executor) {
        delegate().offloadExecutor(executor);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T intercept(List<ClientInterceptor> interceptors) {
        delegate().intercept(interceptors);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T intercept(ClientInterceptor... interceptors) {
        delegate().intercept(interceptors);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T userAgent(String userAgent) {
        delegate().userAgent(userAgent);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T overrideAuthority(String authority) {
        delegate().overrideAuthority(authority);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T usePlaintext() {
        delegate().usePlaintext();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T useTransportSecurity() {
        delegate().useTransportSecurity();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    @Deprecated
    public T nameResolverFactory(NameResolver.Factory resolverFactory) {
        delegate().nameResolverFactory(resolverFactory);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T defaultLoadBalancingPolicy(String policy) {
        delegate().defaultLoadBalancingPolicy(policy);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T enableFullStreamDecompression() {
        delegate().enableFullStreamDecompression();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T decompressorRegistry(DecompressorRegistry registry) {
        delegate().decompressorRegistry(registry);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T compressorRegistry(CompressorRegistry registry) {
        delegate().compressorRegistry(registry);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T idleTimeout(long value, TimeUnit unit) {
        delegate().idleTimeout(value, unit);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxInboundMessageSize(int max) {
        delegate().maxInboundMessageSize(max);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxInboundMetadataSize(int max) {
        delegate().maxInboundMetadataSize(max);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T keepAliveTime(long keepAliveTime, TimeUnit timeUnit) {
        delegate().keepAliveTime(keepAliveTime, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T keepAliveTimeout(long keepAliveTimeout, TimeUnit timeUnit) {
        delegate().keepAliveTimeout(keepAliveTimeout, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T keepAliveWithoutCalls(boolean enable) {
        delegate().keepAliveWithoutCalls(enable);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxRetryAttempts(int maxRetryAttempts) {
        delegate().maxRetryAttempts(maxRetryAttempts);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxHedgedAttempts(int maxHedgedAttempts) {
        delegate().maxHedgedAttempts(maxHedgedAttempts);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T retryBufferSize(long bytes) {
        delegate().retryBufferSize(bytes);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T perRpcBufferLimit(long bytes) {
        delegate().perRpcBufferLimit(bytes);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T disableRetry() {
        delegate().disableRetry();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T enableRetry() {
        delegate().enableRetry();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T setBinaryLog(BinaryLog binaryLog) {
        delegate().setBinaryLog(binaryLog);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T maxTraceEvents(int maxTraceEvents) {
        delegate().maxTraceEvents(maxTraceEvents);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T proxyDetector(ProxyDetector proxyDetector) {
        delegate().proxyDetector(proxyDetector);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T defaultServiceConfig(@Nullable Map<String, ?> serviceConfig) {
        delegate().defaultServiceConfig(serviceConfig);
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public T disableServiceConfigLookUp() {
        delegate().disableServiceConfigLookUp();
        return thisT();
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannel build() {
        return delegate().build();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }

    protected final T thisT() {
        return this;
    }
}