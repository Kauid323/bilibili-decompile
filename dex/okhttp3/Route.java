package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

public final class Route {
    final Address address;
    final InetSocketAddress inetSocketAddress;

    /* renamed from: proxy  reason: collision with root package name */
    final Proxy f16proxy;

    public Route(Address address, Proxy proxy2, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy2 == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.address = address;
        this.f16proxy = proxy2;
        this.inetSocketAddress = inetSocketAddress;
    }

    public Address address() {
        return this.address;
    }

    public Proxy proxy() {
        return this.f16proxy;
    }

    public InetSocketAddress socketAddress() {
        return this.inetSocketAddress;
    }

    public boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.f16proxy.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof Route) && ((Route) other).address.equals(this.address) && ((Route) other).f16proxy.equals(this.f16proxy) && ((Route) other).inetSocketAddress.equals(this.inetSocketAddress);
    }

    public int hashCode() {
        int result = (17 * 31) + this.address.hashCode();
        return (((result * 31) + this.f16proxy.hashCode()) * 31) + this.inetSocketAddress.hashCode();
    }

    public String toString() {
        return "Route{" + this.inetSocketAddress + "}";
    }
}