package io.grpc.inprocess;

import io.grpc.Attributes;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerListener;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public final class InternalInProcess {
    private InternalInProcess() {
    }

    public static ConnectionClientTransport createInProcessTransport(String name, int maxInboundMetadataSize, String authority, String userAgent, Attributes eagAttrs, ObjectPool<ScheduledExecutorService> serverSchedulerPool, List<ServerStreamTracer.Factory> serverStreamTracerFactories, ServerListener serverListener) {
        return new InProcessTransport(name, maxInboundMetadataSize, authority, userAgent, eagAttrs, serverSchedulerPool, serverStreamTracerFactories, serverListener);
    }
}