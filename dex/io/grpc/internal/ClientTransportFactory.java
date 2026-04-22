package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.HttpConnectProxiedSocketAddress;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public interface ClientTransportFactory extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ScheduledExecutorService getScheduledExecutorService();

    ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger);

    @CheckReturnValue
    @Nullable
    SwapChannelCredentialsResult swapChannelCredentials(ChannelCredentials channelCredentials);

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ClientTransportOptions {
        private ChannelLogger channelLogger;
        @Nullable
        private HttpConnectProxiedSocketAddress connectProxiedSocketAddr;
        @Nullable
        private String userAgent;
        private String authority = "unknown-authority";
        private Attributes eagAttributes = Attributes.EMPTY;

        public ChannelLogger getChannelLogger() {
            return this.channelLogger;
        }

        public ClientTransportOptions setChannelLogger(ChannelLogger channelLogger) {
            this.channelLogger = channelLogger;
            return this;
        }

        public String getAuthority() {
            return this.authority;
        }

        public ClientTransportOptions setAuthority(String authority) {
            this.authority = (String) Preconditions.checkNotNull(authority, "authority");
            return this;
        }

        public Attributes getEagAttributes() {
            return this.eagAttributes;
        }

        public ClientTransportOptions setEagAttributes(Attributes eagAttributes) {
            Preconditions.checkNotNull(eagAttributes, "eagAttributes");
            this.eagAttributes = eagAttributes;
            return this;
        }

        @Nullable
        public String getUserAgent() {
            return this.userAgent;
        }

        public ClientTransportOptions setUserAgent(@Nullable String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        @Nullable
        public HttpConnectProxiedSocketAddress getHttpConnectProxiedSocketAddress() {
            return this.connectProxiedSocketAddr;
        }

        public ClientTransportOptions setHttpConnectProxiedSocketAddress(@Nullable HttpConnectProxiedSocketAddress connectProxiedSocketAddr) {
            this.connectProxiedSocketAddr = connectProxiedSocketAddr;
            return this;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.authority, this.eagAttributes, this.userAgent, this.connectProxiedSocketAddr});
        }

        public boolean equals(Object o) {
            if (o instanceof ClientTransportOptions) {
                ClientTransportOptions that = (ClientTransportOptions) o;
                return this.authority.equals(that.authority) && this.eagAttributes.equals(that.eagAttributes) && Objects.equal(this.userAgent, that.userAgent) && Objects.equal(this.connectProxiedSocketAddr, that.connectProxiedSocketAddr);
            }
            return false;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class SwapChannelCredentialsResult {
        @Nullable
        final CallCredentials callCredentials;
        final ClientTransportFactory transportFactory;

        public SwapChannelCredentialsResult(ClientTransportFactory transportFactory, @Nullable CallCredentials callCredentials) {
            this.transportFactory = (ClientTransportFactory) Preconditions.checkNotNull(transportFactory, "transportFactory");
            this.callCredentials = callCredentials;
        }
    }
}