package kntr.base.primer;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GPrimer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J5\u0010\r\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lkntr/base/primer/PrimerCommonParams;", "", "headers", "", "", "params", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "getHeaders", "()Ljava/util/Map;", "getParams", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "primer_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PrimerCommonParams {
    private final Map<String, String> headers;
    private final Map<String, String> params;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrimerCommonParams copy$default(PrimerCommonParams primerCommonParams, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = primerCommonParams.headers;
        }
        if ((i & 2) != 0) {
            map2 = primerCommonParams.params;
        }
        return primerCommonParams.copy(map, map2);
    }

    public final Map<String, String> component1() {
        return this.headers;
    }

    public final Map<String, String> component2() {
        return this.params;
    }

    public final PrimerCommonParams copy(Map<String, String> map, Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "params");
        return new PrimerCommonParams(map, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PrimerCommonParams) {
            PrimerCommonParams primerCommonParams = (PrimerCommonParams) obj;
            return Intrinsics.areEqual(this.headers, primerCommonParams.headers) && Intrinsics.areEqual(this.params, primerCommonParams.params);
        }
        return false;
    }

    public int hashCode() {
        return (this.headers.hashCode() * 31) + this.params.hashCode();
    }

    public String toString() {
        Map<String, String> map = this.headers;
        return "PrimerCommonParams(headers=" + map + ", params=" + this.params + ")";
    }

    public PrimerCommonParams(Map<String, String> map, Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "params");
        this.headers = map;
        this.params = map2;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }
}