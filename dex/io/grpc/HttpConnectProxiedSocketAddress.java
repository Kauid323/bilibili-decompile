package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import javax.annotation.Nullable;

public final class HttpConnectProxiedSocketAddress extends ProxiedSocketAddress {
    private static final long serialVersionUID = 0;
    @Nullable
    private final String password;
    private final SocketAddress proxyAddress;
    private final InetSocketAddress targetAddress;
    @Nullable
    private final String username;

    private HttpConnectProxiedSocketAddress(SocketAddress proxyAddress, InetSocketAddress targetAddress, @Nullable String username, @Nullable String password) {
        Preconditions.checkNotNull(proxyAddress, "proxyAddress");
        Preconditions.checkNotNull(targetAddress, "targetAddress");
        if (proxyAddress instanceof InetSocketAddress) {
            Preconditions.checkState(!((InetSocketAddress) proxyAddress).isUnresolved(), "The proxy address %s is not resolved", proxyAddress);
        }
        this.proxyAddress = proxyAddress;
        this.targetAddress = targetAddress;
        this.username = username;
        this.password = password;
    }

    @Nullable
    public String getPassword() {
        return this.password;
    }

    @Nullable
    public String getUsername() {
        return this.username;
    }

    public SocketAddress getProxyAddress() {
        return this.proxyAddress;
    }

    public InetSocketAddress getTargetAddress() {
        return this.targetAddress;
    }

    public boolean equals(Object o) {
        if (o instanceof HttpConnectProxiedSocketAddress) {
            HttpConnectProxiedSocketAddress that = (HttpConnectProxiedSocketAddress) o;
            return Objects.equal(this.proxyAddress, that.proxyAddress) && Objects.equal(this.targetAddress, that.targetAddress) && Objects.equal(this.username, that.username) && Objects.equal(this.password, that.password);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.proxyAddress, this.targetAddress, this.username, this.password});
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("proxyAddr", this.proxyAddress).add("targetAddr", this.targetAddress).add("username", this.username).add("hasPassword", this.password != null).toString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Builder {
        @Nullable
        private String password;
        private SocketAddress proxyAddress;
        private InetSocketAddress targetAddress;
        @Nullable
        private String username;

        private Builder() {
        }

        public Builder setProxyAddress(SocketAddress proxyAddress) {
            this.proxyAddress = (SocketAddress) Preconditions.checkNotNull(proxyAddress, "proxyAddress");
            return this;
        }

        public Builder setTargetAddress(InetSocketAddress targetAddress) {
            this.targetAddress = (InetSocketAddress) Preconditions.checkNotNull(targetAddress, "targetAddress");
            return this;
        }

        public Builder setUsername(@Nullable String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(@Nullable String password) {
            this.password = password;
            return this;
        }

        public HttpConnectProxiedSocketAddress build() {
            return new HttpConnectProxiedSocketAddress(this.proxyAddress, this.targetAddress, this.username, this.password);
        }
    }
}