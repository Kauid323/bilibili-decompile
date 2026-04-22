package p2p.io.grpc.ignet;

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

    public static IgnetChannelBuilder forAddress(String name, int port, String proxy2) {
        return new IgnetChannelBuilder(name, port, proxy2);
    }

    private IgnetChannelBuilder(String host, int port, String proxy2) {
        this.mManagedChannelImplBuilder = new ManagedChannelImplBuilder(InetSocketAddress.createUnresolved(host, port), GrpcUtil.authorityFromHostAndPort(host, port), new IgnetChannelTransportFactoryBuilder(), (ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider) null);
        this.mProxy = proxy2;
    }

    protected ManagedChannelBuilder<?> delegate() {
        return this.mManagedChannelImplBuilder;
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    final class IgnetChannelTransportFactoryBuilder implements ManagedChannelImplBuilder.ClientTransportFactoryBuilder {
        IgnetChannelTransportFactoryBuilder() {
        }

        public ClientTransportFactory buildClientTransportFactory() {
            return IgnetChannelBuilder.this.buildTransportFactory();
        }
    }

    ClientTransportFactory buildTransportFactory() {
        BLog.i(LOG_TAG, "buildTransportFactory");
        return new IgnetTransportFactory(this.mScheduledExecutorService, this.mTransportTracerFactory.create(), this.mProxy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class IgnetTransportFactory implements ClientTransportFactory {
        private String mProxy;
        private final ScheduledExecutorService timeoutService;
        private final TransportTracer transportTracer;
        private final boolean usingSharedScheduler;

        private IgnetTransportFactory(@Nullable ScheduledExecutorService timeoutService, TransportTracer transportTracer, String proxy2) {
            this.usingSharedScheduler = timeoutService == null;
            this.timeoutService = this.usingSharedScheduler ? (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE) : timeoutService;
            this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer");
            this.mProxy = proxy2;
        }

        public ConnectionClientTransport newClientTransport(SocketAddress addr, ClientTransportFactory.ClientTransportOptions options, ChannelLogger channelLogger) {
            InetSocketAddress inetSocketAddr = (InetSocketAddress) addr;
            BLog.i(IgnetChannelBuilder.LOG_TAG, "newClientTransport addr:" + addr.toString());
            return new IgnetClientTransport(inetSocketAddr, options.getUserAgent(), options.getEagAttributes(), this.transportTracer, this.mProxy);
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            return this.timeoutService;
        }

        public ClientTransportFactory.SwapChannelCredentialsResult swapChannelCredentials(ChannelCredentials channelCreds) {
            return null;
        }

        public void close() {
            if (this.usingSharedScheduler) {
                SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timeoutService);
            }
        }
    }
}