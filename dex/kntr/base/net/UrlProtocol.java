package kntr.base.net;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/base/net/UrlProtocol;", "", "name", "", "defaultPort", "", "<init>", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getDefaultPort", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UrlProtocol {
    private static final Map<String, UrlProtocol> byName;
    private final int defaultPort;
    private final String name;
    public static final Companion Companion = new Companion(null);
    private static final UrlProtocol HTTP = new UrlProtocol("http", 80);
    private static final UrlProtocol HTTPS = new UrlProtocol("https", 443);
    private static final UrlProtocol WS = new UrlProtocol("ws", 80);
    private static final UrlProtocol WSS = new UrlProtocol("wss", 443);
    private static final UrlProtocol SOCKS = new UrlProtocol("socks", 1080);

    public static /* synthetic */ UrlProtocol copy$default(UrlProtocol urlProtocol, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = urlProtocol.name;
        }
        if ((i2 & 2) != 0) {
            i = urlProtocol.defaultPort;
        }
        return urlProtocol.copy(str, i);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.defaultPort;
    }

    public final UrlProtocol copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new UrlProtocol(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UrlProtocol) {
            UrlProtocol urlProtocol = (UrlProtocol) obj;
            return Intrinsics.areEqual(this.name, urlProtocol.name) && this.defaultPort == urlProtocol.defaultPort;
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.defaultPort;
    }

    public String toString() {
        String str = this.name;
        return "UrlProtocol(name=" + str + ", defaultPort=" + this.defaultPort + ")";
    }

    public UrlProtocol(String name, int defaultPort) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.defaultPort = defaultPort;
        CharSequence $this$all$iv = this.name;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < $this$all$iv.length()) {
                char element$iv = $this$all$iv.charAt(i);
                if (!(Character.toLowerCase(element$iv) == element$iv)) {
                    break;
                }
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (!z) {
            throw new IllegalArgumentException("All characters should be lower case".toString());
        }
    }

    public final String getName() {
        return this.name;
    }

    public final int getDefaultPort() {
        return this.defaultPort;
    }

    /* compiled from: Gnet.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/base/net/UrlProtocol$Companion;", "", "<init>", "()V", "HTTP", "Lkntr/base/net/UrlProtocol;", "getHTTP", "()Lkntr/base/net/UrlProtocol;", "HTTPS", "getHTTPS", "WS", "getWS", "WSS", "getWSS", "SOCKS", "getSOCKS", "byName", "", "", "createOrDefault", "name", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UrlProtocol getHTTP() {
            return UrlProtocol.HTTP;
        }

        public final UrlProtocol getHTTPS() {
            return UrlProtocol.HTTPS;
        }

        public final UrlProtocol getWS() {
            return UrlProtocol.WS;
        }

        public final UrlProtocol getWSS() {
            return UrlProtocol.WSS;
        }

        public final UrlProtocol getSOCKS() {
            return UrlProtocol.SOCKS;
        }

        public final UrlProtocol createOrDefault(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            UrlProtocol urlProtocol = (UrlProtocol) UrlProtocol.byName.get(name);
            return urlProtocol == null ? new UrlProtocol(name, 0) : urlProtocol;
        }
    }

    static {
        Iterable $this$associateBy$iv = CollectionsKt.listOf(new UrlProtocol[]{HTTP, HTTPS, WS, WSS, SOCKS});
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            UrlProtocol it = (UrlProtocol) element$iv$iv;
            destination$iv$iv.put(it.name, element$iv$iv);
        }
        byName = destination$iv$iv;
    }
}