package io.ktor.http;

import io.grpc.internal.GrpcUtil;
import io.ktor.http.ContentDisposition;
import io.ktor.util.CharsetKt;
import io.ktor.util.TextKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLProtocol.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0019"}, d2 = {"Lio/ktor/http/URLProtocol;", "", "", ContentDisposition.Parameters.Name, "", "defaultPort", "<init>", "(Ljava/lang/String;I)V", "component1", "()Ljava/lang/String;", "component2", "()I", "copy", "(Ljava/lang/String;I)Lio/ktor/http/URLProtocol;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getName", "I", "getDefaultPort", "Companion", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class URLProtocol {
    private static final Map<String, URLProtocol> byName;
    private final int defaultPort;
    private final String name;
    public static final Companion Companion = new Companion(null);
    private static final URLProtocol HTTP = new URLProtocol("http", 80);
    private static final URLProtocol HTTPS = new URLProtocol("https", GrpcUtil.DEFAULT_PORT_SSL);
    private static final URLProtocol WS = new URLProtocol("ws", 80);
    private static final URLProtocol WSS = new URLProtocol("wss", GrpcUtil.DEFAULT_PORT_SSL);
    private static final URLProtocol SOCKS = new URLProtocol("socks", 1080);

    public static /* synthetic */ URLProtocol copy$default(URLProtocol uRLProtocol, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = uRLProtocol.name;
        }
        if ((i3 & 2) != 0) {
            i2 = uRLProtocol.defaultPort;
        }
        return uRLProtocol.copy(str, i2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.defaultPort;
    }

    public final URLProtocol copy(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        return new URLProtocol(str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof URLProtocol) {
            URLProtocol uRLProtocol = (URLProtocol) obj;
            return Intrinsics.areEqual(this.name, uRLProtocol.name) && this.defaultPort == uRLProtocol.defaultPort;
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.defaultPort;
    }

    public String toString() {
        return "URLProtocol(name=" + this.name + ", defaultPort=" + this.defaultPort + ')';
    }

    public URLProtocol(String name, int defaultPort) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        this.name = name;
        this.defaultPort = defaultPort;
        CharSequence $this$all$iv = this.name;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < $this$all$iv.length()) {
                char element$iv = $this$all$iv.charAt(i2);
                if (!CharsetKt.isLowerCase(element$iv)) {
                    break;
                }
                i2++;
            } else {
                z = true;
                break;
            }
        }
        if (!z) {
            throw new IllegalArgumentException("All characters should be lower case".toString());
        }
    }

    public final int getDefaultPort() {
        return this.defaultPort;
    }

    public final String getName() {
        return this.name;
    }

    /* compiled from: URLProtocol.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/http/URLProtocol$Companion;", "", "<init>", "()V", "", ContentDisposition.Parameters.Name, "Lio/ktor/http/URLProtocol;", "createOrDefault", "(Ljava/lang/String;)Lio/ktor/http/URLProtocol;", "HTTP", "Lio/ktor/http/URLProtocol;", "getHTTP", "()Lio/ktor/http/URLProtocol;", "HTTPS", "getHTTPS", "WS", "getWS", "WSS", "getWSS", "SOCKS", "getSOCKS", "", "byName", "Ljava/util/Map;", "getByName", "()Ljava/util/Map;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final URLProtocol getHTTP() {
            return URLProtocol.HTTP;
        }

        public final URLProtocol getHTTPS() {
            return URLProtocol.HTTPS;
        }

        public final URLProtocol getWS() {
            return URLProtocol.WS;
        }

        public final URLProtocol getWSS() {
            return URLProtocol.WSS;
        }

        public final URLProtocol getSOCKS() {
            return URLProtocol.SOCKS;
        }

        public final Map<String, URLProtocol> getByName() {
            return URLProtocol.byName;
        }

        public final URLProtocol createOrDefault(String name) {
            Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
            String it = TextKt.toLowerCasePreservingASCIIRules(name);
            URLProtocol uRLProtocol = URLProtocol.Companion.getByName().get(it);
            return uRLProtocol == null ? new URLProtocol(it, 0) : uRLProtocol;
        }
    }

    static {
        Iterable $this$associateBy$iv = CollectionsKt.listOf(new URLProtocol[]{HTTP, HTTPS, WS, WSS, SOCKS});
        int capacity$iv = kotlin.ranges.RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            URLProtocol it = (URLProtocol) element$iv$iv;
            destination$iv$iv.put(it.name, element$iv$iv);
        }
        byName = destination$iv$iv;
    }
}