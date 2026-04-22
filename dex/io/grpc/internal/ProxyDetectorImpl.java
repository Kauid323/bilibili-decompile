package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

class ProxyDetectorImpl implements ProxyDetector {
    @Deprecated
    private static final String GRPC_PROXY_ENV_VAR = "GRPC_PROXY_EXP";
    static final String PROXY_SCHEME = "https";
    private final AuthenticationProvider authenticationProvider;
    private final InetSocketAddress overrideProxyAddress;
    private final Supplier<ProxySelector> proxySelector;
    private static final Logger log = Logger.getLogger(ProxyDetectorImpl.class.getName());
    private static final AuthenticationProvider DEFAULT_AUTHENTICATOR = new AuthenticationProvider() { // from class: io.grpc.internal.ProxyDetectorImpl.1
        @Override // io.grpc.internal.ProxyDetectorImpl.AuthenticationProvider
        public PasswordAuthentication requestPasswordAuthentication(String host2, InetAddress addr, int port, String protocol, String prompt, String scheme) {
            URL url;
            try {
                url = new URL(protocol, host2, port, "");
            } catch (MalformedURLException e2) {
                ProxyDetectorImpl.log.log(Level.WARNING, String.format("failed to create URL for Authenticator: %s %s", protocol, host2));
                url = null;
                return Authenticator.requestPasswordAuthentication(host2, addr, port, protocol, prompt, scheme, url, Authenticator.RequestorType.PROXY);
            }
            return Authenticator.requestPasswordAuthentication(host2, addr, port, protocol, prompt, scheme, url, Authenticator.RequestorType.PROXY);
        }
    };
    private static final Supplier<ProxySelector> DEFAULT_PROXY_SELECTOR = new Supplier<ProxySelector>() { // from class: io.grpc.internal.ProxyDetectorImpl.2
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface AuthenticationProvider {
        PasswordAuthentication requestPasswordAuthentication(String str, InetAddress inetAddress, int i2, String str2, String str3, String str4);
    }

    public ProxyDetectorImpl() {
        this(DEFAULT_PROXY_SELECTOR, DEFAULT_AUTHENTICATOR, System.getenv(GRPC_PROXY_ENV_VAR));
    }

    ProxyDetectorImpl(Supplier<ProxySelector> proxySelector, AuthenticationProvider authenticationProvider, @Nullable String proxyEnvString) {
        this.proxySelector = (Supplier) Preconditions.checkNotNull(proxySelector);
        this.authenticationProvider = (AuthenticationProvider) Preconditions.checkNotNull(authenticationProvider);
        if (proxyEnvString != null) {
            this.overrideProxyAddress = overrideProxy(proxyEnvString);
        } else {
            this.overrideProxyAddress = null;
        }
    }

    @Override // io.grpc.ProxyDetector
    @Nullable
    public ProxiedSocketAddress proxyFor(SocketAddress targetServerAddress) throws IOException {
        if (!(targetServerAddress instanceof InetSocketAddress)) {
            return null;
        }
        if (this.overrideProxyAddress != null) {
            return HttpConnectProxiedSocketAddress.newBuilder().setProxyAddress(this.overrideProxyAddress).setTargetAddress((InetSocketAddress) targetServerAddress).build();
        }
        return detectProxy((InetSocketAddress) targetServerAddress);
    }

    private ProxiedSocketAddress detectProxy(InetSocketAddress targetAddr) throws IOException {
        InetSocketAddress resolvedProxyAddr;
        try {
            String host2 = GrpcUtil.getHost(targetAddr);
            try {
                URI uri = new URI(PROXY_SCHEME, null, host2, targetAddr.getPort(), null, null, null);
                ProxySelector proxySelector = (ProxySelector) this.proxySelector.get();
                if (proxySelector == null) {
                    log.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> proxies = proxySelector.select(uri);
                if (proxies.size() > 1) {
                    log.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = proxies.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress proxyAddr = (InetSocketAddress) proxy.address();
                PasswordAuthentication auth = this.authenticationProvider.requestPasswordAuthentication(GrpcUtil.getHost(proxyAddr), proxyAddr.getAddress(), proxyAddr.getPort(), PROXY_SCHEME, "", null);
                if (proxyAddr.isUnresolved()) {
                    InetAddress resolvedAddress = InetAddress.getByName(proxyAddr.getHostName());
                    resolvedProxyAddr = new InetSocketAddress(resolvedAddress, proxyAddr.getPort());
                } else {
                    resolvedProxyAddr = proxyAddr;
                }
                HttpConnectProxiedSocketAddress.Builder builder = HttpConnectProxiedSocketAddress.newBuilder().setTargetAddress(targetAddr).setProxyAddress(resolvedProxyAddr);
                if (auth == null) {
                    return builder.build();
                }
                return builder.setUsername(auth.getUserName()).setPassword(auth.getPassword() != null ? new String(auth.getPassword()) : null).build();
            } catch (URISyntaxException e2) {
                log.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e2);
                return null;
            }
        } catch (Throwable t) {
            log.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", t);
            return null;
        }
    }

    private static InetSocketAddress overrideProxy(String proxyHostPort) {
        if (proxyHostPort == null) {
            return null;
        }
        String[] parts = proxyHostPort.split(":", 2);
        int port = 80;
        if (parts.length > 1) {
            port = Integer.parseInt(parts[1]);
        }
        log.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(parts[0], port);
    }
}