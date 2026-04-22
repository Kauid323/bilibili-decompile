package io.ktor.client.engine;

import io.ktor.http.Url;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProxyConfigJvm.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/engine/ProxyBuilder;", "", "<init>", "()V", "Lio/ktor/http/Url;", "url", "Ljava/net/Proxy;", "Lio/ktor/client/engine/ProxyConfig;", "http", "(Lio/ktor/http/Url;)Ljava/net/Proxy;", "", "host", "", "port", "socks", "(Ljava/lang/String;I)Ljava/net/Proxy;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProxyBuilder {
    public static final ProxyBuilder INSTANCE = new ProxyBuilder();

    private ProxyBuilder() {
    }

    public final Proxy http(Url url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(url.getHost(), url.getPort()));
    }

    public final Proxy socks(String host2, int port) {
        Intrinsics.checkNotNullParameter(host2, "host");
        return new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(host2, port));
    }
}