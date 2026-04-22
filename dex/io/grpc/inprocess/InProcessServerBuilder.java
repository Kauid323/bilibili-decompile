package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import io.grpc.Deadline;
import io.grpc.ServerBuilder;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.AbstractServerImplBuilder;
import io.grpc.internal.FixedObjectPool;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InternalServer;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerImplBuilder;
import io.grpc.internal.SharedResourcePool;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class InProcessServerBuilder extends AbstractServerImplBuilder<InProcessServerBuilder> {
    final String name;
    int maxInboundMetadataSize = Integer.MAX_VALUE;
    ObjectPool<ScheduledExecutorService> schedulerPool = SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE);
    private final ServerImplBuilder serverImplBuilder = new ServerImplBuilder(new ServerImplBuilder.ClientTransportServersBuilder() { // from class: io.grpc.inprocess.InProcessServerBuilder.1InProcessClientTransportServersBuilder
        @Override // io.grpc.internal.ServerImplBuilder.ClientTransportServersBuilder
        public InternalServer buildClientTransportServers(List<? extends ServerStreamTracer.Factory> streamTracerFactories) {
            return InProcessServerBuilder.this.buildTransportServers(streamTracerFactories);
        }
    });

    public static InProcessServerBuilder forName(String name) {
        return new InProcessServerBuilder(name);
    }

    public static InProcessServerBuilder forPort(int port) {
        throw new UnsupportedOperationException("call forName() instead");
    }

    public static String generateName() {
        return UUID.randomUUID().toString();
    }

    private InProcessServerBuilder(String name) {
        this.name = (String) Preconditions.checkNotNull(name, ContentDisposition.Parameters.Name);
        this.serverImplBuilder.setStatsRecordStartedRpcs(false);
        this.serverImplBuilder.setStatsRecordFinishedRpcs(false);
        handshakeTimeout(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder
    protected ServerBuilder<?> delegate() {
        return this.serverImplBuilder;
    }

    public InProcessServerBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.schedulerPool = new FixedObjectPool(Preconditions.checkNotNull(scheduledExecutorService, "scheduledExecutorService"));
        return this;
    }

    public InProcessServerBuilder deadlineTicker(Deadline.Ticker ticker) {
        this.serverImplBuilder.setDeadlineTicker(ticker);
        return this;
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    public InProcessServerBuilder maxInboundMetadataSize(int bytes) {
        Preconditions.checkArgument(bytes > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = bytes;
        return this;
    }

    InProcessServer buildTransportServers(List<? extends ServerStreamTracer.Factory> streamTracerFactories) {
        return new InProcessServer(this, streamTracerFactories);
    }

    @Override // io.grpc.internal.AbstractServerImplBuilder, io.grpc.ServerBuilder
    public InProcessServerBuilder useTransportSecurity(File certChain, File privateKey) {
        throw new UnsupportedOperationException("TLS not supported in InProcessServer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatsEnabled(boolean value) {
        this.serverImplBuilder.setStatsEnabled(value);
    }
}