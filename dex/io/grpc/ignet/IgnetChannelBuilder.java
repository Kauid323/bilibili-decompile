package io.grpc.ignet;

import com.google.common.base.Preconditions;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.ManagedChannelImplBuilder;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.TransportTracer;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import tv.danmaku.android.log.BLog;

public class IgnetChannelBuilder extends AbstractManagedChannelImplBuilder<IgnetChannelBuilder> {
    private static final String LOG_TAG = "IgnetChannelBuilder";
    private final ManagedChannelImplBuilder mManagedChannelImplBuilder;
    private String mProxy;
    @Nullable
    private ScheduledExecutorService mScheduledExecutorService;
    private TransportTracer.Factory mTransportTracerFactory = TransportTracer.getDefaultFactory();

    public static IgnetChannelBuilder forAddress(String name, int port, String proxy) {
        return new IgnetChannelBuilder(name, port, proxy);
    }

    private IgnetChannelBuilder(String host2, int port, String proxy) {
        this.mManagedChannelImplBuilder = new ManagedChannelImplBuilder(InetSocketAddress.createUnresolved(host2, port), GrpcUtil.authorityFromHostAndPort(host2, port), new IgnetChannelTransportFactoryBuilder(), null);
        this.mProxy = proxy;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder
    protected ManagedChannelBuilder<?> delegate() {
        return this.mManagedChannelImplBuilder;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    final class IgnetChannelTransportFactoryBuilder implements ManagedChannelImplBuilder.ClientTransportFactoryBuilder {
        IgnetChannelTransportFactoryBuilder() {
        }

        @Override // io.grpc.internal.ManagedChannelImplBuilder.ClientTransportFactoryBuilder
        public ClientTransportFactory buildClientTransportFactory() {
            return IgnetChannelBuilder.this.buildTransportFactory();
        }
    }

    ClientTransportFactory buildTransportFactory() {
        BLog.i(LOG_TAG, "buildTransportFactory");
        return new IgnetTransportFactory(this.mScheduledExecutorService, this.mTransportTracerFactory.create(), this.mProxy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class IgnetTransportFactory implements ClientTransportFactory {
        private String mProxy;
        private final ScheduledExecutorService timeoutService;
        private final TransportTracer transportTracer;
        private final boolean usingSharedScheduler;

        private IgnetTransportFactory(@Nullable ScheduledExecutorService timeoutService, TransportTracer transportTracer, String proxy) {
            this.usingSharedScheduler = timeoutService == null;
            this.timeoutService = this.usingSharedScheduler ? (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE) : timeoutService;
            this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer");
            this.mProxy = proxy;
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ConnectionClientTransport newClientTransport(SocketAddress addr, ClientTransportFactory.ClientTransportOptions options, ChannelLogger channelLogger) {
            InetSocketAddress inetSocketAddr = (InetSocketAddress) addr;
            BLog.i(IgnetChannelBuilder.LOG_TAG, "newClientTransport addr:" + addr.toString());
            return new IgnetClientTransport(inetSocketAddr, options.getUserAgent(), options.getEagAttributes(), this.transportTracer, this.mProxy);
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ScheduledExecutorService getScheduledExecutorService() {
            return this.timeoutService;
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ClientTransportFactory.SwapChannelCredentialsResult swapChannelCredentials(ChannelCredentials channelCreds) {
            return null;
        }

        @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.usingSharedScheduler) {
                SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timeoutService);
            }
        }
    }
}