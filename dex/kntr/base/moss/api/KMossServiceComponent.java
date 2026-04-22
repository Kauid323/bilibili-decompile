package kntr.base.moss.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KMossServiceComponent.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lkntr/base/moss/api/KMossServiceComponent;", "", "host", "", "port", "", "callOptions", "Lkntr/base/moss/api/KCallOptions;", "<init>", "(Ljava/lang/String;ILkntr/base/moss/api/KCallOptions;)V", "getHost", "()Ljava/lang/String;", "getPort", "()I", "getCallOptions", "()Lkntr/base/moss/api/KCallOptions;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KMossServiceComponent {
    private final KCallOptions callOptions;
    private final String host;
    private final int port;

    public static /* synthetic */ KMossServiceComponent copy$default(KMossServiceComponent kMossServiceComponent, String str, int i, KCallOptions kCallOptions, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kMossServiceComponent.host;
        }
        if ((i2 & 2) != 0) {
            i = kMossServiceComponent.port;
        }
        if ((i2 & 4) != 0) {
            kCallOptions = kMossServiceComponent.callOptions;
        }
        return kMossServiceComponent.copy(str, i, kCallOptions);
    }

    public final String component1() {
        return this.host;
    }

    public final int component2() {
        return this.port;
    }

    public final KCallOptions component3() {
        return this.callOptions;
    }

    public final KMossServiceComponent copy(String str, int i, KCallOptions kCallOptions) {
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(kCallOptions, "callOptions");
        return new KMossServiceComponent(str, i, kCallOptions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KMossServiceComponent) {
            KMossServiceComponent kMossServiceComponent = (KMossServiceComponent) obj;
            return Intrinsics.areEqual(this.host, kMossServiceComponent.host) && this.port == kMossServiceComponent.port && Intrinsics.areEqual(this.callOptions, kMossServiceComponent.callOptions);
        }
        return false;
    }

    public int hashCode() {
        return (((this.host.hashCode() * 31) + this.port) * 31) + this.callOptions.hashCode();
    }

    public String toString() {
        String str = this.host;
        int i = this.port;
        return "KMossServiceComponent(host=" + str + ", port=" + i + ", callOptions=" + this.callOptions + ")";
    }

    public KMossServiceComponent(String host, int port, KCallOptions callOptions) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(callOptions, "callOptions");
        this.host = host;
        this.port = port;
        this.callOptions = callOptions;
    }

    public final String getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }

    public final KCallOptions getCallOptions() {
        return this.callOptions;
    }
}