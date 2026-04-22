package io.grpc;

import io.grpc.Attributes;
import io.ktor.sse.ServerSentEventKt;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import javax.net.ssl.SSLSession;

public final class Grpc {
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_REMOTE_ADDR = Attributes.Key.create("remote-addr");
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_LOCAL_ADDR = Attributes.Key.create("local-addr");
    public static final Attributes.Key<SSLSession> TRANSPORT_ATTR_SSL_SESSION = Attributes.Key.create("ssl-session");

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public @interface TransportAttr {
    }

    private Grpc() {
    }

    public static ManagedChannelBuilder<?> newChannelBuilder(String target, ChannelCredentials creds) {
        return ManagedChannelRegistry.getDefaultRegistry().newChannelBuilder(target, creds);
    }

    public static ManagedChannelBuilder<?> newChannelBuilderForAddress(String host2, int port, ChannelCredentials creds) {
        return newChannelBuilder(authorityFromHostAndPort(host2, port), creds);
    }

    private static String authorityFromHostAndPort(String host2, int port) {
        try {
            return new URI(null, null, host2, port, null, null, null).getAuthority();
        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException("Invalid host or port: " + host2 + ServerSentEventKt.SPACE + port, ex);
        }
    }

    public static ServerBuilder<?> newServerBuilderForPort(int port, ServerCredentials creds) {
        return ServerRegistry.getDefaultRegistry().newServerBuilderForPort(port, creds);
    }
}